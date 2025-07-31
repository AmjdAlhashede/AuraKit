use std::io::Cursor;
use symphonia::core::audio::Signal;
use symphonia::core::probe::Hint;
use symphonia::core::io::MediaSourceStream;
use symphonia::core::formats::FormatOptions;
use symphonia::core::meta::MetadataOptions;
use symphonia::core::codecs::{DecoderOptions};
use symphonia::core::errors::Error;

pub fn decode_ogg_bytes(data: &[u8]) -> Result<Vec<u8>, Error> {
    let cursor = Cursor::new(data.to_vec());
    let mss = MediaSourceStream::new(Box::new(cursor), Default::default());

    let probed = symphonia::default::get_probe().format(
        &Hint::new(),
        mss,
        &FormatOptions::default(),
        &MetadataOptions::default(),
    )?;

    let mut format = probed.format;
    let track = format.default_track().ok_or(Error::Unsupported("No default track"))?;
    let mut decoder = symphonia::default::get_codecs().make(&track.codec_params, &DecoderOptions::default())?;
    let track_id = track.id;

    let mut pcm_data = Vec::new();

    while let Ok(packet) = format.next_packet() {
        if packet.track_id() != track_id {
            continue;
        }

        if let Ok(decoded) = decoder.decode(&packet) {
            let mut buf_i16 = decoded.make_equivalent::<i16>();
            decoded.convert(&mut buf_i16);

            for ch in 0..buf_i16.spec().channels.count() {
                for sample in buf_i16.chan(ch) {
                    pcm_data.extend_from_slice(&sample.to_le_bytes());
                }
            }
        }
    }

    Ok(pcm_data)
}

package io.github.aurakit.common.media

import android.media.MediaFormat

enum class AuraMimeTypes(val mime: String) {

    VIDEO_VP8(MediaFormat.MIMETYPE_VIDEO_VP8),
    VIDEO_VP9(MediaFormat.MIMETYPE_VIDEO_VP9),
    VIDEO_AV1("video/av01"),
    VIDEO_WEBM("video/webm"),
    VIDEO_MKV("video/x-matroska"),


    AUDIO_AAC(MediaFormat.MIMETYPE_AUDIO_AAC),
    AUDIO_MP3(MediaFormat.MIMETYPE_AUDIO_MPEG),
    AUDIO_OPUS(MediaFormat.MIMETYPE_AUDIO_OPUS),
    AUDIO_VORBIS(MediaFormat.MIMETYPE_AUDIO_VORBIS),
    AUDIO_FLAC(MediaFormat.MIMETYPE_AUDIO_FLAC),
    AUDIO_RAW(MediaFormat.MIMETYPE_AUDIO_RAW),

    AUDIO_PCM("audio/L16"),
    AUDIO_OGG("audio/ogg"),
    AUDIO_WEBM("audio/webm"),
    AUDIO_WAV("audio/wav"),
    AUDIO_ALAC("audio/x-alac"),
    AUDIO_M4A("audio/x-m4a"),

}


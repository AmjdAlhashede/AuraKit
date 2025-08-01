use jni::JNIEnv;
use jni::objects::{JObject, JByteArray};
use jni::sys::{jbyteArray};
use crate::common::conversion::{jbytearray_to_vec, vec_to_jbytearray};
use crate::decoder::decode_ogg_bytes; 
 
#[unsafe(no_mangle)]
pub extern "system" fn Java_io_github_internal_RustBridgeOgg_decodeOgg(
     env: JNIEnv,
    _class: JObject,
    input_jbyte_array: jbyteArray,  
    ) -> jbyteArray { 
         let java_array = unsafe { JByteArray::from_raw(input_jbyte_array) }; 

         let input = jbytearray_to_vec(&env, java_array); 

         let result = match decode_ogg_bytes(&input) {
            Ok(pcm_data) => pcm_data,
            Err(_) => return std::ptr::null_mut(),
        };
        
        vec_to_jbytearray(&env, &result)
}
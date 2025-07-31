
use jni::sys::jbyteArray;
use jni::JNIEnv;
use jni::objects::JByteArray;  

pub fn jbytearray_to_vec2(env: &JNIEnv, array: JByteArray) -> Vec<u8> {
    env.convert_byte_array(array).unwrap_or_default()
} 

 


pub fn jbytearray_to_vec(env: &JNIEnv, array: JByteArray) -> Vec<u8> {
    env.convert_byte_array(array).unwrap_or_default()
}

pub fn vec_to_jbytearray(env: &JNIEnv, buffer: &[u8]) -> jbyteArray {
    env.byte_array_from_slice(buffer)
        .expect("Failed to create jbyteArray")
        .into_raw()
}

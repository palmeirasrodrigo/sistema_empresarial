package com.sistemaempresarial.springboot.backend.apirest.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguma.chave.secreta.1234568";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEA2p90HdO/f4eilDiq8ixU85XUHXh/HEQHry/KHaTg0d1cg0Mi\r\n" + 
			"0KnLkrn5FdRzEkwGCRKsWtsgRi8yW712HZMtlH52wh6XfV+DmJPzBXvVBgt42D5I\r\n" + 
			"mAhiDfMGHt06Q5I+dNObcZ7/A0gdVHUwegW04N6MHVEW8KzB3Jp7EX3laeLmhMGq\r\n" + 
			"VtEo/JqiGmxtwHs2yfbC1ygCRB9o3ZkWuDowki6R/EeoDUHK1p0P5u7UCp+V+LqW\r\n" + 
			"+Atxp/BTxR5uty2tEPIJfRpLbYq5yGU58hnbInFMEkPJ5kNjVViYydziKrl9+Iv3\r\n" + 
			"9h+lskSLGdlmhUxoUYdlvawl3XGsCffyCiTTGQIDAQABAoIBACtfex/3xIQ+moih\r\n" + 
			"fXiyRuBUl1KJd15aONQOvSCId3nrWtFH3n5bUWH4t2wXTAUTRBdEtyEHXC3Qa0M8\r\n" + 
			"IVTYwDA3rsPwYcmjy23X3Fz4JlkeqYjtQmW3NAzkbBBvf4GsX+u5l5tBGgLCqd75\r\n" + 
			"qPZsb2g1fsLKNazl+UgU9dmQipUo6wDCIaBKtOI0SgiCgu0aVKUjqHCNnUuX8PE+\r\n" + 
			"bmPTaqf3wuUpbDNDuQCVbvrgckXlJRyaO/quk8YkwM+s+8FieawyQPXjLyYPcXmJ\r\n" + 
			"JpJd07xz4SmqtI0q+NR4yGPUqLsnjPy+FyiL0o+Ct8qp2qXGxiyUtJ62VHkcGXFX\r\n" + 
			"abCk/wkCgYEA8oC3ffaSs0qoG9w+JNYFiD58q4jdQfa331khHM2N1XdYxq7ssfXc\r\n" + 
			"IY7+nV7QGi1agGPNaHGsX+0qD1aHbBQrQNFHwcLtU7bVIb390sR3POo7qgOZHaxD\r\n" + 
			"0hch4l1NHkEKLg/2UGoAv/3iMMrk+EaERXLNSeDFIhhces4x0BDVkocCgYEA5sp8\r\n" + 
			"PtYO3gfE/4Nbswx1QOzkvIi6jMV8FQ0+IuebBRMl6ZsA6kOo/krCuT/fJXqtauuI\r\n" + 
			"ZorjkbIZz0/MxfJ4iaa4ZPF/6vhNaEtn1YbHyhTvEwEBQwyGhIjiEjQSc5+lx50T\r\n" + 
			"HdP3nXVGSiLRg/M5yKCH6rrcUd5aQF2pe/PmtV8CgYEA8XlgvgqI3AXMTinKq81+\r\n" + 
			"JsPqSrj3cZbmU34iLdc1k8nK2dUXlsG2WKhWO4hM+rQMuWooAQeoWMEFr84+/U08\r\n" + 
			"IMgEhxm+TyzxIC9bD8RY44xuqwX4Mwb1Zb9pG0pC34xuQZ3dbQeRBZ0e3e07gUpe\r\n" + 
			"rfT6HMW4JxJRDGxER+ZrdQMCgYAprIKG7iw9F3YRFW0nhaZelOgwyxe0d6ySOJPx\r\n" + 
			"xZSOdAiyiBTAOHt5f5Jt1QS8Rcyus90rdwTkuB5E+wnk7IWrhXlicOFCUpfXr1YO\r\n" + 
			"jonhCaqp6dKKguZ/ZCA+XTy/uCI9SzW6ex4JRrXsiSEADJlwitxAHIHQHrB5UvBZ\r\n" + 
			"u477TQKBgQDxc56AVBfU9qBMOKF9EOs+S+nX9ShI1hj7dK5yvPuPD4nqTBkPQrDK\r\n" + 
			"lUm9NJwkHAxd5Pw31wdOeDdcSYD2KB8RmqQArDwKh214fd7Yl7KuQNxhAK3GDf4W\r\n" + 
			"+nCBserdfuR6tu2TNVobnmmT/FVnSLiDtAgatd/R9XPE4C6GGDfJVA==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2p90HdO/f4eilDiq8ixU\r\n" + 
			"85XUHXh/HEQHry/KHaTg0d1cg0Mi0KnLkrn5FdRzEkwGCRKsWtsgRi8yW712HZMt\r\n" + 
			"lH52wh6XfV+DmJPzBXvVBgt42D5ImAhiDfMGHt06Q5I+dNObcZ7/A0gdVHUwegW0\r\n" + 
			"4N6MHVEW8KzB3Jp7EX3laeLmhMGqVtEo/JqiGmxtwHs2yfbC1ygCRB9o3ZkWuDow\r\n" + 
			"ki6R/EeoDUHK1p0P5u7UCp+V+LqW+Atxp/BTxR5uty2tEPIJfRpLbYq5yGU58hnb\r\n" + 
			"InFMEkPJ5kNjVViYydziKrl9+Iv39h+lskSLGdlmhUxoUYdlvawl3XGsCffyCiTT\r\n" + 
			"GQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}

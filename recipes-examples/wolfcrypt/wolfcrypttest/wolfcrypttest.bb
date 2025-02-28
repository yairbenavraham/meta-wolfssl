SUMMARY = "wolfCrypt Test Application"
DESCRIPTION = "wolfCrypt test application used to test crypto algorithm \
               functionality included in the wolfSSL embedded SSL/TLS library."
HOMEPAGE = "https://www.wolfssl.com"
BUGTRACKER = "https://github.com/wolfssl/wolfssl/issues"
SECTION = "x11/applications"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://test.c;beginline=1;endline=20;md5=61d63fb8b820bae4d85beb53e7acf340"

DEPENDS += "wolfssl"

WOLFCRYPT_V="5.6.6"
SRC_URI = "git://github.com/wolfssl/wolfssl.git;nobranch=1;protocol=https;tag=v${WOLFCRYPT_V}-stable;"
S = "${WORKDIR}/git/wolfcrypt/test"

do_compile() {
    ${CC} ${CFLAGS} -DUSE_CERT_BUFFERS_2048 -DUSE_CERT_BUFFERS_256 -DUSE_FLAT_TEST_H -Wall -include wolfssl/options.h -o wolfcrypttest ${S}/test.c -lwolfssl ${LDFLAGS}
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/wolfcrypttest ${D}${bindir}
}

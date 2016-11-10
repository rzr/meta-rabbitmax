DESCRIPTION = "Helper scripts to setup WiFi AP"
HOMEPAGE = "https://github.com/RabbitMax"
SECTION = "Network & Connectivity"
LICENSE = "Apache-2.0"
PR = "r1"

PRIORITY = "10"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "file://setupap"

DEPENDS_${PN} = " hostapd "
RDEPENDS_${PN} = " hostapd dnsmasq connman "

do_prep() {
 cd ${S}
 chmod -Rf a+rX,u+w,g-w,o-w ${S}
}

do_configure() {
}

do_compile() {
}

do_install() {
 # copy script setting up WiFi access point
 install -d ${D}/usr/sbin/
 install -m 0755 ${WORKDIR}/setupap ${D}/usr/sbin/setupap
}

FILES_${PN} = ""
FILES_${PN} += "/usr/sbin/"
FILES_${PN} += "/usr/sbin/setupap"

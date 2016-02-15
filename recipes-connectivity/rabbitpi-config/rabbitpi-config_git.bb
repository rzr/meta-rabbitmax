DESCRIPTION = "Configure WiFi, username, password, etc"
HOMEPAGE = "https://github.com/RabbitPi/rabbitpi-config"
SECTION = "Network & Connectivity"
LICENSE = "Apache-2.0"
PR = "r1"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/RabbitPi/rabbitpi-config.git;branch=master;tag=b00a48298b5854e3c0151ad46c89f1c5e546da52"

DEPENDS = "nodejs"

S = "${WORKDIR}/git"

do_configure() {
}

do_compile() {
}

do_install() {
 cd ${S}
 npm install
 rm -rf ${D}
 mkdir -p ${D}/opt/rabbitpi-config
 cp -R ${S}/* ${D}/opt/rabbitpi-config/
}

FILES_${PN} = ""
FILES_${PN} += "/opt/"
FILES_${PN} += "/opt/rabbitpi-config"
FILES_${PN} += "/opt/rabbitpi-config/*"

DESCRIPTION = "Configure WiFi, username, password, etc"
HOMEPAGE = "https://github.com/RabbitPi/rabbitpi-config"
SECTION = "Network & Connectivity"
LICENSE = "Apache-2.0"
PR = "r1"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/RabbitPi/rabbitpi-config.git;branch=master;tag=95af2fa40f7d19c1b1bb66de0af8b4970522c909"

inherit systemd

SYSTEMD_SERVICE_${PN} = "rabbitpi-config.service"

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

 if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
  install -p -D ${S}/systemd/rabbitpi-config.service ${D}${systemd_unitdir}/system/rabbitpi-config.service
 fi
}

FILES_${PN} = ""
FILES_${PN} += "/opt/"
FILES_${PN} += "/opt/rabbitpi-config"
FILES_${PN} += "/opt/rabbitpi-config/*"

DESCRIPTION = "Configure WiFi, username, password, etc"
HOMEPAGE = "https://github.com/RabbitPi/rabbitmax-config"
SECTION = "Network & Connectivity"
LICENSE = "Apache-2.0"
PR = "r1"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/RabbitPi/rabbitmax-config.git;branch=master;tag=435561d79a925f287b98e3251bcfac718e8c3541"

inherit systemd

SYSTEMD_SERVICE_${PN} = "rabbitmax-config.service"

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
 mkdir -p ${D}/opt/rabbitmax-config
 cp -R ${S}/* ${D}/opt/rabbitmax-config/

 if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
  install -p -D ${S}/systemd/rabbitmax-config.service ${D}${systemd_unitdir}/system/rabbitmax-config.service
 fi
}

FILES_${PN} = ""
FILES_${PN} += "/opt/"
FILES_${PN} += "/opt/rabbitmax-config"
FILES_${PN} += "/opt/rabbitmax-config/*"

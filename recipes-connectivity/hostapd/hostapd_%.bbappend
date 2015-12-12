FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://hostapd-conf.patch \
	file://hostapd \
	 "

do_install_append() {
 # replace hostapd with older version (0.8) due to the following issue:
 # "Driver does not support authentication/association or connect command"
 rm ${D}/usr/sbin/hostapd
 mkdir -p ${D}/usr/sbin/
 install -m 0755 ${WORKDIR}/hostapd ${D}/usr/sbin/hostapd
}

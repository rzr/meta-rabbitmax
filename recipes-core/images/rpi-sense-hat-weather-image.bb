require recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL_append = " connman connman-client hostapd \
                        nodejs nodejs-npm \
                        git \
                        kernel-modules \
                        autoconf automake binutils binutils-symlinks \
                        cpp cpp-symlinks gcc gcc-symlinks g++ g++-symlinks \
                        gettext make libstdc++ libstdc++-dev file coreutils \
                        dnsmasq \
                        python python-dev python-modules python-pip \
                        python-sense-hat \
                        i2c-tools \
                        rabbitmax-config \
                        "

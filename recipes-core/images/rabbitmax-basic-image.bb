require recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL_append = " connman connman-client \
                        glibc \
                        glibc-dev \
                        kernel-dev \
                        kernel-modules \
                        libgcc-dev \
                        linux-libc-headers-dev \
                        ncurses-terminfo \
                        nodejs \
                        git \
                        autoconf automake binutils \
                        cpp cpp-symlinks gcc gcc-symlinks g++ g++-symlinks \
                        gettext make libstdc++ libstdc++-dev file coreutils \
                        dnsmasq \
                        i2c-tools \
                        os-release \
                        rabbitmax-config \
                        screen \
                        sudo \
                        "

IMAGE_INSTALL_append_raspberrypi += " rpi-gpio "

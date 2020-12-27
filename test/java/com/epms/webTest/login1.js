/*
 * 加密工具已经升级了一个版本，目前为 jsjiami.com.v5 ，主要加强了算法，以及防破解【绝对不可逆】配置，耶稣也无法100%还原，我说的。;
 * 已经打算把这个工具基础功能一直免费下去。还希望支持我。
 * 另外 jsjiami.com.v5 已经强制加入校验，注释可以去掉，但是 jsjiami.com.v5 不能去掉（如果你开通了VIP，可以手动去掉），其他都没有任何绑定。
 * 誓死不会加入任何后门，jsjiami.com JS 加密的使命就是为了保护你们的Javascript 。
 * 警告：如果您恶意去掉 jsjiami.com.v5 那么我们将不会保护您的JavaScript代码。请遵守规则
 * 新版本: https://www.jsjiami.com/ 支持批量加密，支持大文件加密，拥有更多加密。 */

;var encode_version = 'jsjiami.com.v5', qxwvv = '__0xaac3c',
    __0xaac3c = ['wq3Dh8KpbBw=', 'F8KWBMOiwpI+FWbDlxl1JSMVRMKCCg==', 'f8OxwrbCmsKxEQ==', 'wrDDp8OGFnA9AQ==', 'woNFw7DDl8KB', 'w6bDqTbCrcKL', 'w77Dhh7Cmgs=', 'wp3ClcOYwqtZ', 'wpPDglUGbw==', 'w5zDqRbChsKF', 'HHBA', 'wq7CkGHCl8KU', 'wp7CpxBOwo4=', 'wqvCrcK4wps=', 'dcKnwpl2T1PCtsOVWsK0w5lVOcKRUsOlNcOvJCDDisKnS8OKL0VbHsKQw5IDwp0=', 'cjoR', 'eQYBwovDkw==', 'AkrDqcKEWQ==', 'bcOkwoc=', 'UMKlwrdMw6Q=', 'E8KgOw==', 'KMO8wqQ=', 'a0Zdwq00w53CucKgNg==', 'wp7CgTdTwr9Swp7Dp8OBw7p5UcK9w7Y=', 'OcKAZABA', 'RMK3ChRH', 'wqvDskAWfg==', 'w5QnwpXCvlk=', 'w5xDwoZTXw==', '5Ym16ZmX54mh5pyA5Y+G776CcnXkvaTlrrHmnJHlv4Tnqqo=', 'wrvDi8KZbl8cwojDtA==', 'dcOywpDCkQ==', 'w55WaMO8DMKnwonDgcOVflJDwrfCtw==', 'CcK+wo/Cjkg=', 'w6MpdsKlwok=', 'U8OBOxLCqh3DiHDCkDXDrlY6dg=='];
(function (_0x7bd3e5, _0x17fb1d) {
    var _0x4e492d = function (_0x3782c2) {
        while (--_0x3782c2) {
            _0x7bd3e5['push'](_0x7bd3e5['shift']());
        }
    };
    _0x4e492d(++_0x17fb1d);
}(__0xaac3c, 0x1aa));
var _0x240a = function (_0x231fd0, _0x4f680a) {
    _0x231fd0 = _0x231fd0 - 0x0;
    var _0x5b4826 = __0xaac3c[_0x231fd0];
    if (_0x240a['initialized'] === undefined) {
        (function () {
            var _0x550fbc = typeof window !== 'undefined' ? window : typeof process === 'object' && typeof require === 'function' && typeof global === 'object' ? global : this;
            var _0x18d5c9 = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=';
            _0x550fbc['atob'] || (_0x550fbc['atob'] = function (_0x4ce2f1) {
                var _0x333808 = String(_0x4ce2f1)['replace'](/=+$/, '');
                for (var _0x432180 = 0x0, _0x2ab90b, _0x991246, _0x981158 = 0x0, _0x57b080 = ''; _0x991246 = _0x333808['charAt'](_0x981158++); ~_0x991246 && (_0x2ab90b = _0x432180 % 0x4 ? _0x2ab90b * 0x40 + _0x991246 : _0x991246, _0x432180++ % 0x4) ? _0x57b080 += String['fromCharCode'](0xff & _0x2ab90b >> (-0x2 * _0x432180 & 0x6)) : 0x0) {
                    _0x991246 = _0x18d5c9['indexOf'](_0x991246);
                }
                return _0x57b080;
            });
        }());
        var _0x219af0 = function (_0x441e3a, _0x2cc193) {
            var _0x5f41ea = [], _0x503809 = 0x0, _0xe42b77, _0x56465b = '', _0x52cace = '';
            _0x441e3a = atob(_0x441e3a);
            for (var _0x39753a = 0x0, _0xf81284 = _0x441e3a['length']; _0x39753a < _0xf81284; _0x39753a++) {
                _0x52cace += '%' + ('00' + _0x441e3a['charCodeAt'](_0x39753a)['toString'](0x10))['slice'](-0x2);
            }
            _0x441e3a = decodeURIComponent(_0x52cace);
            for (var _0x307b3e = 0x0; _0x307b3e < 0x100; _0x307b3e++) {
                _0x5f41ea[_0x307b3e] = _0x307b3e;
            }
            for (_0x307b3e = 0x0; _0x307b3e < 0x100; _0x307b3e++) {
                _0x503809 = (_0x503809 + _0x5f41ea[_0x307b3e] + _0x2cc193['charCodeAt'](_0x307b3e % _0x2cc193['length'])) % 0x100;
                _0xe42b77 = _0x5f41ea[_0x307b3e];
                _0x5f41ea[_0x307b3e] = _0x5f41ea[_0x503809];
                _0x5f41ea[_0x503809] = _0xe42b77;
            }
            _0x307b3e = 0x0;
            _0x503809 = 0x0;
            for (var _0x3ab53f = 0x0; _0x3ab53f < _0x441e3a['length']; _0x3ab53f++) {
                _0x307b3e = (_0x307b3e + 0x1) % 0x100;
                _0x503809 = (_0x503809 + _0x5f41ea[_0x307b3e]) % 0x100;
                _0xe42b77 = _0x5f41ea[_0x307b3e];
                _0x5f41ea[_0x307b3e] = _0x5f41ea[_0x503809];
                _0x5f41ea[_0x503809] = _0xe42b77;
                _0x56465b += String['fromCharCode'](_0x441e3a['charCodeAt'](_0x3ab53f) ^ _0x5f41ea[(_0x5f41ea[_0x307b3e] + _0x5f41ea[_0x503809]) % 0x100]);
            }
            return _0x56465b;
        };
        _0x240a['rc4'] = _0x219af0;
        _0x240a['data'] = {};
        _0x240a['initialized'] = !![];
    }
    var _0xfeb75b = _0x240a['data'][_0x231fd0];
    if (_0xfeb75b === undefined) {
        if (_0x240a['once'] === undefined) {
            _0x240a['once'] = !![];
        }
        _0x5b4826 = _0x240a['rc4'](_0x5b4826, _0x4f680a);
        _0x240a['data'][_0x231fd0] = _0x5b4826;
    } else {
        _0x5b4826 = _0xfeb75b;
    }
    return _0x5b4826;
};

function getData() {
    var _0x583e1d = {
        'yirEm': _0x240a('0x0', 'hqIl'),
        'IaRPP': 'password',
        'iOqzR': _0x240a('0x1', 'Pgxx'),
        'letIG': function _0x214068(_0x1c5b6c, _0x5daaa0) {
            return _0x1c5b6c < _0x5daaa0;
        },
        'Qtugf': function _0x2be114(_0x5ef004, _0x36a31a) {
            return _0x5ef004 + _0x36a31a;
        }
    };
    var _0x39cd63 = document[_0x240a('0x2', '^2SE')](_0x583e1d[_0x240a('0x3', '7e#x')]);
    var _0x21cd57 = _0x39cd63[_0x240a('0x4', 'Z])L')];
    var _0x121680 = document[_0x240a('0x5', 'OwZ9')](_0x583e1d['IaRPP']);
    var _0x26f2f4 = _0x121680[_0x240a('0x6', 'REGG')];
    var _0x1f602f = document[_0x240a('0x7', 'wV!A')](_0x583e1d['iOqzR']);
    var _0x218df9;
    for (var _0x465786 = 0x0; _0x583e1d['letIG'](_0x465786, _0x1f602f[_0x240a('0x8', 'sY8b')]); _0x465786++) {
        if (_0x1f602f[_0x465786][_0x240a('0x9', '*lg6')]) {
            _0x218df9 = _0x1f602f[_0x465786][_0x240a('0xa', 'IrX^')];
            break;
        }
    }
    console['log'](_0x583e1d[_0x240a('0xb', 'hgdL')](_0x583e1d[_0x240a('0xc', 'RCh[')](_0x21cd57 + ':', _0x26f2f4), ':'), _0x218df9);
    var _0x387e7b = {'userName': _0x21cd57, 'password': _0x26f2f4, 'type': _0x218df9};
    return _0x387e7b;
}

function sendData() {
    var _0x406afc = {
        'FYPVx': '1|0|3|2|4', 'QqBDz': function _0x41d6d9(_0x32e70d, _0x1482fd) {
            return _0x32e70d(_0x1482fd);
        }, 'oLpfv': function _0x271579(_0x25b6d9, _0x293bd8) {
            return _0x25b6d9 + _0x293bd8;
        }, 'ktULh': 'epms', 'KlhjG': function _0x3e370d(_0x3c64c9, _0x26d12d) {
            return _0x3c64c9 + _0x26d12d;
        }, 'jUMtP': function _0x501c20(_0x1e75be) {
            return _0x1e75be();
        }
    };
    var _0x10e973 = _0x406afc[_0x240a('0xd', '%eQf')]['split']('|'), _0x4d9bd0 = 0x0;
    while (!![]) {
        switch (_0x10e973[_0x4d9bd0++]) {
            case'0':
                var _0x3204d1 = _0x406afc[_0x240a('0xe', 'pM9z')](md5, _0x406afc['oLpfv'](_0x406afc[_0x240a('0xf', 'hgdL')], _0x5ce90d));
                continue;
            case'1':
                var _0x5ce90d = new Date()['valueOf']();
                continue;
            case'2':
                console[_0x240a('0x10', 'Q5qg')](_0x406afc[_0x240a('0x11', 'HA(!')](_0x5ce90d, ':'), _0x406afc['KlhjG'](_0x3204d1, ':'), _0x4964e3);
                continue;
            case'3':
                var _0x4964e3 = _0x406afc[_0x240a('0x12', 'Rol4')](getData);
                continue;
            case'4':
                $[_0x240a('0x13', 'L&&p')]({
                    'url': _0x240a('0x14', '1!l]'),
                    'data': _0x4964e3,
                    'headers': {'token': _0x3204d1, 'timestamp': _0x5ce90d},
                    'success': function (_0xb0e7b1) {
                        var _0x2d1b6a = {
                            'fibfn': function _0x139b44(_0x450f74, _0x18bd85) {
                                return _0x450f74 !== _0x18bd85;
                            }, 'vtzkT': _0x240a('0x15', 'C349'), 'xfRip': 'mkI', 'XBcIO': 'res'
                        };
                        if (_0x2d1b6a[_0x240a('0x16', 'C349')](_0x2d1b6a[_0x240a('0x17', 'sgRU')], _0x2d1b6a['xfRip'])) {
                            console[_0x240a('0x18', 'Pgxx')](_0x2d1b6a[_0x240a('0x19', 'P4Xg')], _0xb0e7b1);
                        } else {
                            console[_0x240a('0x1a', 'cVLE')](err);
                        }
                    },
                    'error': function (_0x38d856) {
                        console['log'](_0x38d856);
                    }
                });
                continue;
        }
        break;
    }
};(function (_0x2273fa, _0x1e7a27, _0x55cc44) {
    var _0x25b2bf = {
        'mkJna': _0x240a('0x1b', 'F^S$'), 'oNeoL': function _0x1b5d04(_0x40980a, _0x3e0901) {
            return _0x40980a !== _0x3e0901;
        }, 'iAWTk': _0x240a('0x1c', 'Q*bH'), 'TGRFO': _0x240a('0x1d', 'Rol4'), 'hqxWC': '版本号，js会定期弹窗，还请支持我们的工作'
    };
    _0x55cc44 = 'al';
    try {
        _0x55cc44 += _0x25b2bf[_0x240a('0x1e', 'QkPm')];
        _0x1e7a27 = encode_version;
        if (!(_0x25b2bf[_0x240a('0x1f', '!*sT')](typeof _0x1e7a27, _0x25b2bf[_0x240a('0x20', 'pM9z')]) && _0x1e7a27 === _0x25b2bf[_0x240a('0x21', '%66d')])) {
            _0x2273fa[_0x55cc44]('删除' + _0x25b2bf[_0x240a('0x22', 'n@8)')]);
        }
    } catch (_0x5e9ab1) {
        _0x2273fa[_0x55cc44](_0x240a('0x23', '6TYu'));
    }
}(window));
;encode_version = 'jsjiami.com.v5';
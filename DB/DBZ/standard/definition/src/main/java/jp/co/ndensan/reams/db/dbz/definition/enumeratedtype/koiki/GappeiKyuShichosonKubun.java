/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.koiki;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域の構成市長村管理において、その市町村が過去に合併した「旧市町村」か、最新の構成市町村の一つかを、区部するための値です。
 *
 * @author N3327 三浦 凌
 */
public enum GappeiKyuShichosonKubun {

    /**
     * 合併して、今は存在しない市町村であることを表します。
     */
    合併旧市町村("1"),
    /**
     * 広域の構成市町村であることを表します。
     */
    構成市町村("0");
    private final RString theCode;

    private GappeiKyuShichosonKubun(String code) {
        this.theCode = new RString(code);

    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return this.theCode;
    }

    /**
     * 引数のコードに対応する GappeiKyuShichosonKubun を返します。
     *
     * @param code コード
     * @return コードに対応する GappeiKyuShichosonKubun
     * @throws IllegalArgumentException コードに対応する GappeiKyuShichosonKubun が無い時
     */
    public static GappeiKyuShichosonKubun toValue(RString code) throws IllegalArgumentException {
        GappeiKyuShichosonKubun value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException();
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, GappeiKyuShichosonKubun> DICTHIONARY;

        static {
            Map<RString, GappeiKyuShichosonKubun> map = new HashMap<>();
            for (GappeiKyuShichosonKubun value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static GappeiKyuShichosonKubun get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}

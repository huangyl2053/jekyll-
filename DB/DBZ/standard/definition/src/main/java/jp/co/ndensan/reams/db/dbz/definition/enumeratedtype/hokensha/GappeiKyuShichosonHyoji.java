/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併市町村を表示するか表示しないかの区分です。
 *
 * @author N3327 三浦 凌
 */
public enum GappeiKyuShichosonHyoji {

    /**
     * 表示する<br/>
     * コード:"1"
     */
    表示する("1"),
    /**
     * 表示しない<br/>
     * コード:"2"
     */
    表示しない("0"),
    /**
     * 設定なし<br/>
     * コード:"" (空文字)
     */
    設定なし("");

    private final RString theCode;

    private GappeiKyuShichosonHyoji(String code) {
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
     * 引数のコードに対応する GappeiKyuShichosonOutput を返します。
     *
     * @param code コード
     * @return コードに対応する GappeiKyuShichosonOutput
     * @throws IllegalArgumentException コードに対応する GappeiKyuShichosonOutput が無い時
     */
    public static GappeiKyuShichosonHyoji toValue(RString code) throws IllegalArgumentException {
        GappeiKyuShichosonHyoji value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(GappeiKyuShichosonHyoji.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, GappeiKyuShichosonHyoji> DICTHIONARY;

        static {
            Map<RString, GappeiKyuShichosonHyoji> map = new HashMap<>();
            for (GappeiKyuShichosonHyoji value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static GappeiKyuShichosonHyoji get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.shinsei;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給申請事由
 *
 * @author N8235 船山 洋介
 */
public enum JukyuShinseiJiyu {

    /**
     * 初回申請 <br />
     * コード : 1
     */
    初回申請("1"),
    /**
     * 再申請_有効期限内 <br />
     * コード : 2
     */
    再申請_有効期限内("2"),
    /**
     * 再申請_有効期限外 <br />
     * コード : 3
     */
    再申請_有効期限外("3"),
    /**
     * 要介護度変更申請 <br />
     * コード : 4
     */
    要介護度変更申請("4"),
    /**
     * 指定サービス種類変更申請 <br />
     * コード : 5
     */
    指定サービス種類変更申請("5"),
    /**
     * 申請_法施行前 <br />
     * コード : 6
     */
    申請_法施行前("6"),
    /**
     * 追加_申請なしの追加 <br />
     * コード : 7
     */
    追加_申請なしの追加("7");

    private final RString theCode;

    private JukyuShinseiJiyu(String code) {
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
     * {@link #name() name()}を{@link RString}へ変換して返します。
     *
     * @return {@link #name() name()}を{@link RString}へ変換した物
     */
    public RString toRString() {
        return new RString(name());
    }

    /**
     * 引数のコードに対応する{@link JukyuShinseiJiyu}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link JukyuShinseiJiyu}
     * @throws IllegalArgumentException
     * コードに対応する{@link JukyuShinseiJiyu}が無い時
     */
    public static JukyuShinseiJiyu toValue(RString code) throws IllegalArgumentException {
        JukyuShinseiJiyu value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(JukyuShinseiJiyu.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, JukyuShinseiJiyu> DICTHIONARY;

        static {
            Map<RString, JukyuShinseiJiyu> map = new HashMap<>();
            for (JukyuShinseiJiyu value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static JukyuShinseiJiyu get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}

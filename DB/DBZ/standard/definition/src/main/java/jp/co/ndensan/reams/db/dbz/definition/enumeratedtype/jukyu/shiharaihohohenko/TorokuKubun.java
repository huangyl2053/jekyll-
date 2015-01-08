/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更で使用する登録区分です。
 *
 * @author N3327 三浦 凌
 */
public enum TorokuKubun {

    /**
     * ２号予告登録者です。コード："01"
     */
    二号予告登録者("01", "２号予告登録者"),
    /**
     * ２号差止登録です。コード："02"
     */
    二号差止登録("02", "２号差止登録"),
    /**
     * １号予告者登録です。コード:"11"
     */
    一号予告者登録("11", "１号予告者登録"),
    /**
     * １号償還払い化登録です。コード："12"
     */
    一号償還払い化登録("12", "１号償還払い化登録"),
    /**
     * １号給付額減額登録です。コード："21"
     */
    一号給付額減額登録("21", "１号給付額減額登録");
    private final RString theCode;
    private final RString theName;

    private TorokuKubun(String code, String name) {
        this.theCode = new RString(code);
        this.theName = new RString(name);
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
     * 名称を返します。
     *
     * @return 名称
     */
    public RString getName() {
        return this.theName;
    }

    /**
     * 引数のコードに対応する{@link TorokuKubun}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link TorokuKubun}
     * @throws IllegalArgumentException コードに対応する{@link TorokuKubun}が無い時
     */
    public static TorokuKubun toValue(RString code) throws IllegalArgumentException {
        TorokuKubun value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(TorokuKubun.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, TorokuKubun> DICTHIONARY;

        static {
            Map<RString, TorokuKubun> map = new HashMap<>();
            for (TorokuKubun value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static TorokuKubun get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}

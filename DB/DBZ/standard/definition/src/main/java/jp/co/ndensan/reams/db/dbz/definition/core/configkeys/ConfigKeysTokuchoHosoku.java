/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 特別徴収捕捉を表す列挙体クラスです。
 *
 * @author n3317 塚田 萌
 */
public enum ConfigKeysTokuchoHosoku implements IRStringConvertable {

    /**
     * 4月捕捉。
     */
    特別徴収_特徴開始月_4月捕捉("04"),
    /**
     * 6月捕捉。
     */
    特別徴収_特徴開始月_6月捕捉("06"),
    /**
     * 8月捕捉。
     */
    特別徴収_特徴開始月_8月捕捉("08"),
    /**
     * 10月捕捉。
     */
    特別徴収_特徴開始月_10月捕捉("10"),
    /**
     * 12月捕捉。
     */
    特別徴収_特徴開始月_12月捕捉("12"),
    /**
     * 2月捕捉。
     */
    特別徴収_特徴開始月_2月捕捉("02");

    private final RString month;

    private ConfigKeysTokuchoHosoku(String month) {
        this.month = new RString(month);
    }

    /**
     * 列挙体に対応するコンフィグキーを返します。
     *
     * @return コンフィグキー
     */
    public RString getKey() {
        return new RString(this.toString());
    }

    /**
     * 捕捉月を返します。
     *
     * @return 捕捉月
     */
    public RString month() {
        return this.month;
    }

    /**
     * 指定の月に対応するConfigKeysTokuchoHosokuを返します。
     *
     * @param month 捕捉月
     * @return 指定のコードに対応するConfigKeysTokuchoHosoku
     * @throws IllegalArgumentException 指定のコードに対応するConfigKeysTokuchoHosokuがないとき
     */
    public static ConfigKeysTokuchoHosoku toValue(RString month) throws IllegalArgumentException {
        for (ConfigKeysTokuchoHosoku target : values()) {
            if (target.month().equals(month)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("捕捉月に対応するコンフィグキー").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
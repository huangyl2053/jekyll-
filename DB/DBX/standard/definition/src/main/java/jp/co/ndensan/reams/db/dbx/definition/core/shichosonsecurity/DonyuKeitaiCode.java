/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 導入形態コードを定義した列挙型です。
 */
public enum DonyuKeitaiCode implements IRStringConvertable {

    /**
     * 事務広域 <br />
     * コード : 111
     */
    事務広域("111", "事務広域", false, true),
    /**
     * 事務構成市町村 <br />
     * コード : 112
     */
    事務構成市町村("112", "事務構成市町村", true, false),
    /**
     * 事務単一 <br />
     * コード : 120
     */
    事務単一("120", "事務単一", true, false),
    /**
     * 認定広域 <br />
     * コード : 211
     */
    認定広域("211", "認定広域", false, true),
    /**
     * 認定単一 <br />
     * コード : 220
     */
    認定単一("220", "", true, false);
    private final RString code;
    private final RString name;
    private final boolean isTanitsu;
    private final boolean isKoiki;

    private DonyuKeitaiCode(String code, String name, boolean isTanitsu, boolean isKoiki) {
        this.code = new RString(code);
        this.name = new RString(name);
        this.isTanitsu = isTanitsu;
        this.isKoiki = isKoiki;
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.code;
    }

    /**
     * 単一かどうかを返却します。
     *
     * @return 単一の場合true, 単一以外の場合false
     */
    public boolean is単一() {
        return isTanitsu;
    }

    /**
     * 広域かどうかを返却します。
     *
     * @return 広域の場合true、広域以外の場合false
     */
    public boolean is広域() {
        return isKoiki;
    }

    /**
     * 指定のコードに対応するDonyuKeitaiを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するGaitoHigaitoKubun
     * @throws IllegalArgumentException 指定のコードに対応するDonyuKeitaiがないとき
     */
    public static DonyuKeitaiCode toValue(RString code) throws IllegalArgumentException {
        for (DonyuKeitaiCode target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する導入形態").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}

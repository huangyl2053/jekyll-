/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype;

import static jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode.values;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 導入形態コードを定義した列挙型です。
 */
public enum DonyukeitaiCode implements IRStringConvertable {

    /**
     * 事務広域 <br />
     * コード : 111
     */
    事務広域("111", "事務広域"),
    /**
     * 事務構成市町村 <br />
     * コード : 112
     */
    事務構成市町村("112", "事務構成市町村"),
    /**
     * 事務単一 <br />
     * コード : 120
     */
    事務単一("120", "事務単一"),
    /**
     * 認定広域 <br />
     * コード : 211
     */
    認定広域("211", "認定広域"),
    /**
     * 認定単一 <br />
     * コード : 220
     */
    認定単一("220", "");
    private final RString code;
    private final RString name;

    private DonyukeitaiCode(String code, String name) {
        this.code = new RString(code);
        this.name = new RString(name);
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
     * 指定のコードに対応するGaitoHigaitoKubunを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するGaitoHigaitoKubun
     * @throws IllegalArgumentException 指定のコードに対応するGaitoHigaitoKubunがないとき
     */
    public static DonyukeitaiCode toValue(RString code) throws IllegalArgumentException {
        for (DonyukeitaiCode target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する導入形態コード").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}

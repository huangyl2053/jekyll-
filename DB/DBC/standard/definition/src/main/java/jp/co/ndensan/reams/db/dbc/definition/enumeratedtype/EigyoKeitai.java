/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 営業形態を表す列挙型です。
 *
 * @author N3317 塚田 萌
 */
public enum EigyoKeitai {

    /**
     * 営業形態が「法人」であることを表します。 <br />
     * コード：１
     */
    法人("1"),
    /**
     * 営業形態「個人」であることを表します。 <br />
     * コード：２
     */
    個人("2");
    private final RString code;

    private EigyoKeitai(String code) {
        this.code = new RString(code);
    }

    /**
     * RString型の営業形態コードを返します。
     *
     * @return 営業形態
     */
    public RString getCode() {
        return code;
    }

    /**
     * RString型の営業形態コードをもらい、コードに対応するEigyoKeitai型のenumを返します。
     *
     * @param code 営業形態コード
     * @return 引数のコードに対応するEigyoKeitai型のenum
     */
    public static EigyoKeitai toValue(RString code) {
        for (EigyoKeitai data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する営業形態").evaluate());
    }
}

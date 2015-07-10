/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業者区分の列挙型です。
 *
 * @author n8223 朴義一
 */
public enum JigyoshaKubun implements IRStringConvertable {

    /**
     * なし <br/>
     * なし : 00
     */
    なし("00"),
    /**
     * 地域包括支援センター <br/>
     * 地域包括支援センター : 10
     */
    地域包括支援センター("10"),
    /**
     * 居宅介護支援事業者 <br/>
     * 居宅介護支援事業者 : 20
     */
    居宅介護支援事業者("20"),
    /**
     * 指定介護老人福祉施設 <br/>
     * 指定介護老人福祉施設 : 30
     */
    指定介護老人福祉施設("30"),
    /**
     * 介護老人保健施設 <br/>
     * 介護老人保健施設 : 40
     */
    介護老人保健施設("40"),
    /**
     * 指定介護療養型医療施設 <br/>
     * 指定介護療養型医療施設 : 50
     */
    指定介護療養型医療施設("50");

    private final RString code;

    private JigyoshaKubun(String code) {
        this.code = new RString(code);
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
     * 指定のコードに対応するJigyoshaKubunを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するJigyoshaKubun
     * @throws IllegalArgumentException 指定のコードに対応するJigyoshaKubunがないとき
     */
    public static JigyoshaKubun toValue(RString code) throws IllegalArgumentException {
        for (JigyoshaKubun target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する事業者区分").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}

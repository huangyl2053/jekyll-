/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 事業者区分の列挙型クラスです。
 * 
 * @author n8371
 */
public enum JigyoshaKubun implements IRStringConvertable {

    /**
     * 地域包括支援センター <br/>
     * 地域包括支援センター : 0。
     */
    地域包括支援センター("0", "地域包括支援センター"),
    /**
     * 医科 <br/>
     * 医科 : 1。
     */
    医科("1", "医科"),
    /**
     * 歯科 <br/>
     * 歯科 : 3。
     */
    歯科("3", "歯科"),
    /**
     * 薬局 <br/>
     * 薬局 : 4。
     */
    薬局("4", "薬局"),
    /**
     * 老人保健施設 <br/>
     * 老人保健施設 : 5。
     */
    老人保健施設("5", "老人保健施設"),
    /**
     * 訪問看護ステーション <br/>
     * 訪問看護ステーション : 6。
     */
    訪問看護ステーション("6", "訪問看護ステーション"),
    /**
     * 介護保険事業所 <br/>
     * 介護保険事業所 : 7。
     */
    介護保険事業所("7", "介護保険事業所"),
    /**
     * 基準該当事業所 <br/>
     * 基準該当事業所 : 8。
     */
    基準該当事業所("8", "基準該当事業所"),
    /**
     * 地域密着型事業者 <br/>
     * 地域密着型事業者 : 9。
     */
    地域密着型事業者("9", "地域密着型事業者");
    private final RString code;
    private final RString fullName;

    private JigyoshaKubun(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
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
     * 事業者区分コードの名称を返します。
     *
     * @return 事業者区分コードの名称
     */
    public RString get名称() {
        return fullName;
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

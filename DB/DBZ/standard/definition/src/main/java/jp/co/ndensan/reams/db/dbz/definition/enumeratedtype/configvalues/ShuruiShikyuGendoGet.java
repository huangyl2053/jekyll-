/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務コンフィグの種類支給限度額_取得方法の定義値を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ShuruiShikyuGendoGet {

    /**
     * 種類支給限度額検索時に要介護度を検索キーにしない（要介護度＋適用期間で検索する）ことを表します。<br />
     * コード : 0
     */
    要介護度を検索キーにしない("0"),
    /**
     * 種類支給限度額検索時に要介護度を検索キーにすることを表します。<br />
     * コード : 1
     */
    要介護度を検索キーにする("1");

    private final RString theCode;

    private ShuruiShikyuGendoGet(String code) {
        this.theCode = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return 取得方法
     */
    public RString code() {
        return theCode;
    }

    /**
     * 引数のコードに対応する{@link ShuruiShikyuGendoGet}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link ShuruiShikyuGendoGet}
     * @throws IllegalArgumentException コードに対応する{@link ShuruiShikyuGendoGet}が無い時
     */
    public static ShuruiShikyuGendoGet toValue(RString code) {
        for (ShuruiShikyuGendoGet data : values()) {
            if (data.code().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(ShuruiShikyuGendoGet.class.getSimpleName()));
    }

}

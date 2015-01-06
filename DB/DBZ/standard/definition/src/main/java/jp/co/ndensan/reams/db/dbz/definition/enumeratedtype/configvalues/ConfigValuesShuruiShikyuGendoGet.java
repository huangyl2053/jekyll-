/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務コンフィグの種類支給限度額_取得方法の定義値を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ConfigValuesShuruiShikyuGendoGet {

    /**
     * 種類支給限度額検索時に要介護度を検索キーにしない（要介護度＋適用期間で検索する）ことを表します。<br />
     * コード : 0
     */
    種類支給限度額検索時に要介護度を検索キーにしない("0"),
    /**
     * 種類支給限度額検索時に要介護度を検索キーにすることを表します。<br />
     * コード : 1
     */
    種類支給限度額検索時に要介護度を検索キーにする("1");

    private final RString code;

    private ConfigValuesShuruiShikyuGendoGet(String code) {
        this.code = new RString(code);
    }

    public RString getCode() {
        return code;
    }

    /**
     * コードに対応するenumを返します。
     *
     * @param code 定義値
     * @return 引数のコードに対応するenum
     */
    public static ConfigValuesShuruiShikyuGendoGet toValue(RString code) {
        for (ConfigValuesShuruiShikyuGendoGet data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(DbzErrorMessages.データが存在しない.getMessage().toString());
    }

}

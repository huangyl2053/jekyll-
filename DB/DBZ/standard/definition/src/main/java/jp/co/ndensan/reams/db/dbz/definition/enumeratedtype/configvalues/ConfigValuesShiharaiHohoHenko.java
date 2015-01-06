/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務コンフィグの支払方法変更の終了分記載区分の定義値を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ConfigValuesShiharaiHohoHenko {

    /**
     * 支払方法変更の終了分記載区分が「終了後は記載しない」であることを表します。<br />
     * コード : 0
     */
    支払方法変更_終了分記載区分_終了後は記載しない("0"),
    /**
     * 支払方法変更の終了分記載区分が「終了後も記載する」であることを表します。<br />
     * コード : 1
     */
    支払方法変更_終了分記載区分_終了後も記載する("1");

    private final RString code;

    private ConfigValuesShiharaiHohoHenko(String code) {
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
    public static ConfigValuesShiharaiHohoHenko toValue(RString code) {
        for (ConfigValuesShiharaiHohoHenko data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(DbzErrorMessages.データが存在しない.getMessage().toString());
    }

}

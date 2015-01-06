/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務コンフィグの資格者証期限_有効期限初期表示の定義値を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ConfigValuesShikakushashoKigen {

    /**
     * 資格者証期限_有効期限初期表示が「常にシステム日付+有効期限加算値」であることを表します。<br />
     * コード : 1
     */
    資格者証期限_有効期限初期表示_システム日付plus有効期限加算値("1"),
    /**
     * 資格者証期限_有効期限初期表示が「更新申請時、従前認定終値比較」であることを表します。<br />
     * コード : 2
     */
    資格者証期限_有効期限初期表示_更新申請時_従前認定終値比較("2"),
    /**
     * 資格者証期限_有効期限初期表示が「更新・区分申請時、従前認定終値比較」であることを表します。<br />
     * コード : 3
     */
    資格者証期限_有効期限初期表示_更新区分申請時_従前認定終値比較("3");

    private final RString code;

    private ConfigValuesShikakushashoKigen(String code) {
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
    public static ConfigValuesShikakushashoKigen toValue(RString code) {
        for (ConfigValuesShikakushashoKigen data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(DbzErrorMessages.データが存在しない.getMessage().toString());
    }

}

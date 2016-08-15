/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.shinseishotorokuchushutsutaisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請書登録_抽出条件を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 qinzhen
 */
public enum ShinseishoTorokuChushutsuTaisho {

    /**
     * コード:1 名称:基準収入額適用申請書の該当のみ抽出 略称:満たす時に出力
     */
    処理年度("0001", "基準収入額適用申請書の該当のみ抽出", "満たす時に出力"),
    /**
     * コード:0002 名称:無条件抽出 略称:満たさなくても出力
     */
    被保険者番号("0002", "無条件抽出", "満たさなくても出力");
    private final RString code;
    private final RString shortName;
    private final RString fullName;

    private ShinseishoTorokuChushutsuTaisho(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 基準収入額適用申請書登録_抽出対象のコードを返します。
     *
     * @return 基準収入額適用申請書登録_抽出対象のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 基準収入額適用申請書登録_抽出対象の名称を返します。
     *
     * @return 基準収入額適用申請書登録_抽出対象の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 基準収入額適用申請書登録_抽出対象の名称を返します。
     *
     * @return 基準収入額適用申請書登録_抽出対象の名称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 基準収入額適用申請書登録_抽出対象のコードと一致する内容を探します。
     *
     * @param code 基準収入額適用申請書登録_抽出対象のコード
     * @return {@code code} に対応する基準収入額適用申請書登録_抽出対象
     */
    public static ShinseishoTorokuChushutsuTaisho toValue(RString code) {

        for (ShinseishoTorokuChushutsuTaisho shiharaiHohoKubun : ShinseishoTorokuChushutsuTaisho.values()) {
            if (shiharaiHohoKubun.code.equals(code)) {
                return shiharaiHohoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請書登録_抽出対象"));
    }
}

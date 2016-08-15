/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.ShinseishoHakkoChushutsuJoken;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請書発行_抽出条件を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 qinzhen
 */
public enum ShinseishoHakkoChushutsuJoken {

    /**
     * コード:1 名称:異動分 略称:定義なし
     */
    異動分("0001", "異動分"),
    /**
     * コード:0002 名称:被保険者番号 略称:定義なし
     */
    被保険者番号("0002", "被保険者番号"),
    /**
     * コード:0003 名称:白紙印刷 略称:定義なし
     */
    白紙印刷("0003", "白紙印刷");
    private final RString code;
    private final RString fullName;

    private ShinseishoHakkoChushutsuJoken(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 申請書発行_抽出条件のコードを返します。
     *
     * @return 申請書発行_抽出条件のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 申請書発行_抽出条件の名称を返します。
     *
     * @return 申請書発行_抽出条件の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申請書発行_抽出条件のコードと一致する内容を探します。
     *
     * @param code 申請書発行_抽出条件のコード
     * @return {@code code} に対応する申請書発行_抽出条件
     */
    public static ShinseishoHakkoChushutsuJoken toValue(RString code) {

        for (ShinseishoHakkoChushutsuJoken shiharaiHohoKubun : ShinseishoHakkoChushutsuJoken.values()) {
            if (shiharaiHohoKubun.code.equals(code)) {
                return shiharaiHohoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請書発行_抽出条件"));
    }
}

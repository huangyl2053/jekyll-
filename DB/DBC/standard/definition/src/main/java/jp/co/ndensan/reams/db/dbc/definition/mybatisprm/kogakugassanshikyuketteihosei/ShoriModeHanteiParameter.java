/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteihosei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-030 quxiaodong
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriModeHanteiParameter {

    private final HihokenshaNo 被保険者番号;
    private final HokenshaNo 証記載保険者番号;
    private final RString 支給申請書整理番号;

    /**
     * コンストラクタです
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 証記載保険者番号 HokenshaNo
     * @param 支給申請書整理番号 RString
     */
    public ShoriModeHanteiParameter(
            HihokenshaNo 被保険者番号,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号) {
        this.被保険者番号 = 被保険者番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.支給申請書整理番号 = 支給申請書整理番号;
    }

}

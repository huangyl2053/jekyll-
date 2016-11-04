/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Value;

/**
 * 住宅改修理由書作成手数料請求決定の識別子です。
 *
 * @reamsid_L DBC-2870-010 zhangruitao
 */
@Value
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakuKaishuRiyushoTesuryoKetteiIdentifier implements Serializable {

    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final JigyoshaNo 介護住宅改修理由書作成事業者番号;
    private final RString 集計関連付け番号;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 介護住宅改修理由書作成事業者番号 介護住宅改修理由書作成事業者番号
     * @param 集計関連付け番号 集計関連付け番号
     * @param 履歴番号 履歴番号
     */
    public JutakuKaishuRiyushoTesuryoKetteiIdentifier(
            ShoKisaiHokenshaNo 証記載保険者番号,
            JigyoshaNo 介護住宅改修理由書作成事業者番号,
            RString 集計関連付け番号,
            Decimal 履歴番号) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.介護住宅改修理由書作成事業者番号 = 介護住宅改修理由書作成事業者番号;
        this.集計関連付け番号 = 集計関連付け番号;
        this.履歴番号 = 履歴番号;
    }
}

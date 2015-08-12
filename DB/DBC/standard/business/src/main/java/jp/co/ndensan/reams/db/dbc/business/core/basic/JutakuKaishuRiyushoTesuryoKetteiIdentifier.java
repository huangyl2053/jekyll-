/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 住宅改修理由書作成手数料請求決定の識別子です。
 */
@Value
public class JutakuKaishuRiyushoTesuryoKetteiIdentifier implements Serializable {

    private final JigyoshaNo 介護住宅改修理由書作成事業者番号;
    private final FlexibleDate 決定年月日;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 介護住宅改修理由書作成事業者番号 介護住宅改修理由書作成事業者番号
     * @param 決定年月日 決定年月日
     * @param 履歴番号 履歴番号
     */
    public JutakuKaishuRiyushoTesuryoKetteiIdentifier(JigyoshaNo 介護住宅改修理由書作成事業者番号,
            FlexibleDate 決定年月日,
            Decimal 履歴番号) {
        this.介護住宅改修理由書作成事業者番号 = 介護住宅改修理由書作成事業者番号;
        this.決定年月日 = 決定年月日;
        this.履歴番号 = 履歴番号;
    }
}

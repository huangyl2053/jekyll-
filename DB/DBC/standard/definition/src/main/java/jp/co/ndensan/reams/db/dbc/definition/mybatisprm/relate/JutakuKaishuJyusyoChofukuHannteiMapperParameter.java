/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 *
 * @author ycb
 */
@lombok.Getter
public class JutakuKaishuJyusyoChofukuHannteiMapperParameter {

    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth serviceTeikyoYM;

    private JutakuKaishuJyusyoChofukuHannteiMapperParameter(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月
    ) {
        this.hiHokenshaNo = 被保険者番号;
        this.serviceTeikyoYM = サービス提供年月;

    }

    public static JutakuKaishuJyusyoChofukuHannteiMapperParameter createSelectByKeyParam(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月
    ) {
        return new JutakuKaishuJyusyoChofukuHannteiMapperParameter(被保険者番号, サービス提供年月);
    }
}

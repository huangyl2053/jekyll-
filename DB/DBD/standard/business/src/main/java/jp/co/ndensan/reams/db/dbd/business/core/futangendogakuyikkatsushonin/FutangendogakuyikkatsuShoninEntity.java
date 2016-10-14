/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.futangendogakuyikkatsushonin;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 負担限度額一括認定情報entity
 *
 * @reamsid_L DBD-3710-080 xuejm
 */
@lombok.Getter
@lombok.Setter
public class FutangendogakuyikkatsuShoninEntity {

    private FlexibleYear 作成年度;
    private FlexibleDate 決定日;
    private Boolean 承認済みフラグ;
}

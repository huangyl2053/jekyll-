/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.sougoujigyoujyohou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 提供基本情報のEntityクラスです。
 *
 * @reamsid_L DBU-4880-080 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SougouJigyouJyohouRelateEntity {

    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleYear taishoNendo;
    private RString shikyuShinseishoSeiriNo;
    private FlexibleDate taishoKeisanKaishiYMD;
    private FlexibleDate taishoKeisanShuryoYMD;
    private FlexibleDate hihokenshaKaishiYMD;
    private FlexibleDate hihokenshaShuryoYMD;
    private RString sumi_Gokei_JikoFutanGaku;
    private RString sumi_Gokei_70_74JikoFutanGaku;
    private RDateTime lastUpdateTimestamp;
}

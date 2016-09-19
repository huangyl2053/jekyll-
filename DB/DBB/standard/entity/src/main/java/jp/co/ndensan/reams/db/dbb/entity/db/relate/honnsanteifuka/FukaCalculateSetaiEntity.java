/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 賦課計算中間Tempのクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaCalculateSetaiEntity {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private FlexibleDate kijunYMD;
    private FukaCalculateTempEntity 賦課計算中間Entity;
    private SetaiShotokuEntity 世帯員Entity;
}

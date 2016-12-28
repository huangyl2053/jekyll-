/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkakagami;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査判定結果（鑑）のEntityです。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanteikekkaKagamiEntity {

    private RDateTime printTimeStamp;
    private NinshoshaSource ninshoshaSource;
    private FlexibleDate shinsakaiKaisaiYMD;
    private int gogitaiNo;
    private RString tsuchibun1;
    private RString tsuchibun2;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;

}

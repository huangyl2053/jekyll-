/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiKetteiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険料額変更兼特別徴収中止通知書のItemです。
 *
 * @reamsid_L DBB-9080-020 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness {

    private RString 文書番号;
    private HonSanteiKetteiTsuchiShoJoho 本算定決定通知書情報;
    private List<RString> 調定事由リスト;
    private NinshoshaSource ninshoshaSource;
    private CompKaigoToiawasesakiSource compKaigoToiawasesakiSource;
}

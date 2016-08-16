/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 前回利用者負担割合判定Entityクラスです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MaeRiyoshaFutanWariaiHanteiEntity {

    private HihokenshaNo hihokenshaNo;
    private Code koseiJiyu;
    private FlexibleYear nendo;
    private RString futanWariaiKubun;
    private Decimal honninGoukeiShotokuGaku;
    private int setaiIchigouHihokenshaSu;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private Decimal nenkinShunyuGoukei;
    private Decimal sonotanoGoukeiShotokuKingakuGoukei;
}

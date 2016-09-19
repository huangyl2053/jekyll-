/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogakugassan;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業状況報告情報のRelateEntityクラスです。
 *
 * @reamsid_L DBU-5590-030 zhangzhiming
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
public class JigyoHokokuDataCsvRelateEntity {

    private RString dataKubun;
    private RString syukeKubun;
    private RString hyouNo;
    private RString shukeiNo;
    private RString syukeTani;
    private RString tateNo;
    private RString yokoNo;
    private HihokenshaNo hihokenshaNo;
    private RString taishoNendo;
    private HokenshaNo hokenshaNo;
    private RString shikyuSeiriNo;
    private int rirekiNo;
    private RString jikoFutanSeiriNo;
    private RString hokenSeidoCode;
    private RString kokuho_HihokenshaShoKigo;
    private FlexibleDate keisanKaishiYMD;
    private FlexibleDate keisanShuryoYMD;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private Decimal jikoFutanSogaku;
    private RString shikyuKubunCode;
    private Decimal shikyugaku;
    private RString kyufuShurui;
    private RString fushikyuRiyu;
    private RString biko;
    private RString shotokuKubun;
    private RString over70_ShotokuKubun;
    private RString keikoku;
    private LasdecCode shichosonCode;
    private LasdecCode kyuShichosonCode;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給決定通知書Entityクラスです。
 *
 * @reamsid_L DBC-5310-030 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoukanbaraiShikyuketteiTsuuchisho {

    private SofubutsuAtesakiSource 送付物宛先;
    private RString 文書番号;
    private FlexibleDate 発行日;
    private RString title;
    private RString title2;
    private RString title221;
    private RString title222;
    private RString title231;
    private RString title232;
    private RString title24;
    private RString 通知文1;
    private RString 被保険者氏名;
    private HihokenshaNo 被保険者番号1;
    private HihokenshaNo 被保険者番号2;
    private HihokenshaNo 被保険者番号3;
    private HihokenshaNo 被保険者番号4;
    private HihokenshaNo 被保険者番号5;
    private HihokenshaNo 被保険者番号6;
    private HihokenshaNo 被保険者番号7;
    private HihokenshaNo 被保険者番号8;
    private HihokenshaNo 被保険者番号9;
    private HihokenshaNo 被保険者番号10;

    private RString 給付の種類1;
    private RString 給付の種類2;
    private RString 給付の種類3;
    private RString 増減の理由1;
    private RString 増減の理由2;
    private RString 増減の理由3;

    private IKoza 口座情報;
    private FlexibleDate 支払予定日;
    private RString 通知文2;
    private RString 通知文3;
    private RString 通知文4;
    private RString 通知文5;
    private RString 通知文6;
    private RString 通知文7;
    private RString 通番;

}

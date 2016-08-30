/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護保険住所地特例施設変更通知書_帳票パラメータクラスです。
 *
 * @reamsid_L DBA-0380-070 duanzhanli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShisetsuHenkoTsuchishoItem {

    private RString hokenshaYubinNo;
    private RString bunshoNo;
    private RString hokenshaJusho;
    private RString hakkoYMD;
    private RString hokenshaName;
    private RString tantoBushoName;
    private RString barcode;
    private RString midashi1;
    private RString midashi2;
    private RString midashi3;
    private RString hihokenshaNo1;
    private RString hihokenshaNo2;
    private RString hihokenshaNo3;
    private RString hihokenshaNo4;
    private RString hihokenshaNo5;
    private RString hihokenshaNo6;
    private RString hihokenshaNo7;
    private RString hihokenshaNo8;
    private RString hihokenshaNo9;
    private RString hihokenshaNo10;
    private RString taishoshaNameKana;
    private RString taishoshaName;
    private RString birthYMD;
    private RString seibetsu;
    private RString henkoYMD;
    private RString henkomaeShisetsuName;
    private RString henkomaeShisetsuTelNo;
    private RString henkomaeShisetsuFaxNo;
    private RString henkomaeShisetsuYubinNo;
    private RString henkomaeShisetsuJusho;
    private RString henkogoShisetsuName;
    private RString henkogoShisetsuTelNo;
    private RString henkogoShisetsuFaxNo;
    private RString henkogoShisetsuYubinNo;
    private RString henkogoShisetsuJusho;
    private RString denshiKoin;
    private RString shomeiHakkoYMD;
    private RString ninshoshaYakushokuMei;
    private RString ninshoshaYakushokuMei2;
    private RString koinShoryaku;
    private RString koinMojiretsu;
    private RString ninshoshaShimeiKakenai;
    private RString ninshoshaShimeiKakeru;
    private RString ninshoshaYakushokuMei1;
}

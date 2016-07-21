/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.DBD2020001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更滞納者把握リスト（画面）バッチProcess用パラメータクラスです。
 *
 * @reamsid_L DBD-3650-030 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShiharaiHohoHenkoHaakuIchiranProcessParameter implements IBatchProcessParameter {

    private FlexibleDate kijunYMD;
    private Long hihokenshaAll;
    private Long tainoKikanHihokenshaAll;
    private Long jukyushaAll;
    private Long tainoKikanJukyushaAll;
    private Long ninteiShinseisha;
    private Long tainoKikanNinteiShinseisha;
    private Long ninteiYMD;
    private Long tainoKikanNinteiYMD;
    private FlexibleDate ninteiDateFrom;
    private FlexibleDate ninteiYMDTo;
    private Long shokanShinseisha;
    private Long tainoKikanShokanShinseisha;
    private Long shokanKetteiYMD;
    private Long tainoKikanShokanKettei;
    private FlexibleDate shokanKetteiYMDFrom;
    private FlexibleDate shokanKetteiYMDTo;
    private Long tab;
    private RString reportId;

    /**
     * パラメターを返却します．
     *
     * @param kijunYMD　基準日
     * @param hihokenshaAll　被保険者選択
     * @param tainoKikanHihokenshaAll　被保険者全員の滞納期間
     * @param jukyushaAll　受給者全員
     * @param tainoKikanJukyushaAll　受給者全員の滞納期間
     * @param ninteiShinseisha　受給認定申請中者
     * @param tainoKikanNinteiShinseisha　受給認定申請中者の滞納期間
     * @param ninteiYMD　受給認定日抽出
     * @param tainoKikanNinteiYMD　受給認定日抽出の滞納期間
     * @param ninteiDateFrom　受給認定日抽出の開始
     * @param ninteiYMDTo　受給認定日抽出の終了
     * @param shokanShinseisha　受給申請中者
     * @param tainoKikanShokanShinseisha　受給申請中者の滞納期間
     * @param shokanKetteiYMD　受給支給決定日抽出
     * @param tainoKikanShokanKettei　受給支給決定日抽出の滞納期間
     * @param shokanKetteiYMDFrom　受給支給決定日抽出の開始
     * @param shokanKetteiYMDTo　受給支給決定日抽出の終了
     * @param tab　改頁出力順ID
     * @param reportId　帳票ID
     */
    public ShiharaiHohoHenkoHaakuIchiranProcessParameter(FlexibleDate kijunYMD,
            Long hihokenshaAll,
            Long tainoKikanHihokenshaAll,
            Long jukyushaAll,
            Long tainoKikanJukyushaAll,
            Long ninteiShinseisha,
            Long tainoKikanNinteiShinseisha,
            Long ninteiYMD,
            Long tainoKikanNinteiYMD,
            FlexibleDate ninteiDateFrom,
            FlexibleDate ninteiYMDTo,
            Long shokanShinseisha,
            Long tainoKikanShokanShinseisha,
            Long shokanKetteiYMD,
            Long tainoKikanShokanKettei,
            FlexibleDate shokanKetteiYMDFrom,
            FlexibleDate shokanKetteiYMDTo,
            Long tab,
            RString reportId) {

        this.kijunYMD = kijunYMD;
        this.hihokenshaAll = hihokenshaAll;
        this.tainoKikanHihokenshaAll = tainoKikanHihokenshaAll;
        this.jukyushaAll = jukyushaAll;
        this.tainoKikanJukyushaAll = tainoKikanJukyushaAll;
        this.ninteiShinseisha = ninteiShinseisha;
        this.tainoKikanNinteiShinseisha = tainoKikanNinteiShinseisha;
        this.ninteiYMD = ninteiYMD;
        this.tainoKikanNinteiYMD = tainoKikanNinteiYMD;
        this.ninteiDateFrom = ninteiDateFrom;
        this.ninteiYMDTo = ninteiYMDTo;
        this.shokanShinseisha = shokanShinseisha;
        this.tainoKikanShokanShinseisha = tainoKikanShokanShinseisha;
        this.shokanKetteiYMD = shokanKetteiYMD;
        this.tainoKikanShokanKettei = tainoKikanShokanKettei;
        this.shokanKetteiYMDFrom = shokanKetteiYMDFrom;
        this.shokanKetteiYMDTo = shokanKetteiYMDTo;
        this.tab = tab;
        this.reportId = reportId;
    }
}

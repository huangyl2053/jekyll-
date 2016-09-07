/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd207010;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoHaakoFiveProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoHaakuOneProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoTainoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更滞納者把握リスト（画面）バッチパラメタークラスです．
 *
 * @reamsid_L DBD-3650-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakuIchiranBatchParameter extends BatchParameterBase {

    private static final String KIJUNYMD = "kijunYMD";
    private static final String HIHOKENSHAALL = "hihokenshaAll";
    private static final String TAINOKIKANHIHOKENSHAALL = "tainoKikanHihokenshaAll";
    private static final String JUKYUSHAALL = "jukyushaAll";
    private static final String TAINOKIKANJUKYUSHAALL = "tainoKikanJukyushaAll";
    private static final String NINTEISHINSEISHA = "ninteiShinseisha";
    private static final String TAINOKIKANNINTEISHINSEISHA = "tainoKikanNinteiShinseisha";
    private static final String NINTEIYMD = "ninteiYMD";
    private static final String TAINOKIKANNINTEIYMD = "tainoKikanNinteiYMD";
    private static final String NINTEIDATEFROM = "ninteiDateFrom";
    private static final String NINTEIYMDTO = "ninteiYMDTo";
    private static final String SHOKANSHINSEISHA = "shokanShinseisha";
    private static final String TAINOKIKANSHOKANSHINSEISHA = "tainoKikanShokanShinseisha";
    private static final String SHOKANKETTEIYMD = "shokanKetteiYMD";
    private static final String TAINOKIKANSHOKANKETTEI = "tainoKikanShokanKettei";
    private static final String SHOKANKETTEIYMDFROM = "shokanKetteiYMDFrom";
    private static final String SHOKANKETTEIYMDTO = "shokanKetteiYMDTo";
    private static final String TAB = "tab";
    private static final String REPORTID = "reportId";

    private static final String REPORTTYPEID = "reportTypeId";
    private static final String REPORTCREATEDATETIME = "reportCreateDateTime";

    @BatchParameter(key = KIJUNYMD, name = "基準日")
    private FlexibleDate kijunYMD;
    @BatchParameter(key = HIHOKENSHAALL, name = "被保険者選択")
    private RString hihokenshaAll;
    @BatchParameter(key = TAINOKIKANHIHOKENSHAALL, name = "被保険者全員の滞納期間")
    private int tainoKikanHihokenshaAll;
    @BatchParameter(key = JUKYUSHAALL, name = "受給者全員")
    private RString jukyushaAll;
    @BatchParameter(key = TAINOKIKANJUKYUSHAALL, name = "受給者全員の滞納期間")
    private int tainoKikanJukyushaAll;
    @BatchParameter(key = NINTEISHINSEISHA, name = "受給認定申請中者")
    private RString ninteiShinseisha;
    @BatchParameter(key = TAINOKIKANNINTEISHINSEISHA, name = "受給認定申請中者の滞納期間")
    private int tainoKikanNinteiShinseisha;
    @BatchParameter(key = NINTEIYMD, name = "受給認定日抽出")
    private RString ninteiYMD;
    @BatchParameter(key = TAINOKIKANNINTEIYMD, name = "受給認定日抽出の滞納期間")
    private int tainoKikanNinteiYMD;
    @BatchParameter(key = NINTEIDATEFROM, name = "受給認定日抽出の開始")
    private FlexibleDate ninteiDateFrom;
    @BatchParameter(key = NINTEIYMDTO, name = "受給認定日抽出の終了")
    private FlexibleDate ninteiYMDTo;
    @BatchParameter(key = SHOKANSHINSEISHA, name = "受給申請中者")
    private RString shokanShinseisha;
    @BatchParameter(key = TAINOKIKANSHOKANSHINSEISHA, name = "受給申請中者の滞納期間")
    private int tainoKikanShokanShinseisha;
    @BatchParameter(key = SHOKANKETTEIYMD, name = "受給支給決定日抽出")
    private RString shokanKetteiYMD;
    @BatchParameter(key = TAINOKIKANSHOKANKETTEI, name = "受給支給決定日抽出の滞納期間")
    private int tainoKikanShokanKettei;
    @BatchParameter(key = SHOKANKETTEIYMDFROM, name = "受給支給決定日抽出の開始")
    private FlexibleDate shokanKetteiYMDFrom;
    @BatchParameter(key = SHOKANKETTEIYMDTO, name = "受給支給決定日抽出の終了")
    private FlexibleDate shokanKetteiYMDTo;
    @BatchParameter(key = TAB, name = "改頁出力順ID")
    private Long tab;
    @BatchParameter(key = REPORTID, name = "帳票ID")
    private ReportId reportId;
    @BatchParameter(key = REPORTTYPEID, name = "帳票分類ID")
    private ReportId reportTypeId;
    @BatchParameter(key = REPORTCREATEDATETIME, name = "帳票作成日時")
    private RDateTime reportCreateDateTime;

    /**
     * 支払方法変更滞納者抽出_Processパラメターを取得します．
     *
     * @return 支払方法変更滞納者抽出_Processパラメター
     */
    public ShiharaiHohoHenkoTainoProcessParameter toShiharaiHohoHenkoTainoProcessParameter() {
        return new ShiharaiHohoHenkoTainoProcessParameter(kijunYMD,
                hihokenshaAll,
                tainoKikanHihokenshaAll,
                jukyushaAll,
                tainoKikanJukyushaAll,
                ninteiShinseisha,
                tainoKikanNinteiShinseisha,
                ninteiYMD,
                tainoKikanNinteiYMD,
                ninteiDateFrom,
                ninteiYMDTo,
                shokanShinseisha,
                tainoKikanShokanShinseisha,
                shokanKetteiYMD,
                tainoKikanShokanKettei,
                shokanKetteiYMDFrom,
                shokanKetteiYMDTo,
                tab,
                reportId,
                reportTypeId,
                reportCreateDateTime);
    }

    /**
     * バッチプロセス１パラメターを取得します．
     *
     * @return バッチプロセス１
     */
    public ShiharaiHohoHenkoHaakuOneProcessParameter toShiharaiHohoHenkoHaakuOneProcessParameter() {
        return new ShiharaiHohoHenkoHaakuOneProcessParameter(kijunYMD);
    }

    /**
     * バッチプロセス5パラメターを取得します．
     *
     * @return バッチプロセス5
     */
    public ShiharaiHohoHenkoHaakoFiveProcessParameter toShiharaiHohoHenkoHaakoFiveProcessParameter() {
        return new ShiharaiHohoHenkoHaakoFiveProcessParameter(kijunYMD,
                hihokenshaAll,
                tainoKikanHihokenshaAll,
                jukyushaAll,
                tainoKikanJukyushaAll,
                ninteiShinseisha,
                tainoKikanNinteiShinseisha,
                ninteiYMD,
                tainoKikanNinteiYMD,
                ninteiDateFrom,
                ninteiYMDTo,
                shokanShinseisha,
                tainoKikanShokanShinseisha,
                shokanKetteiYMD,
                tainoKikanShokanKettei,
                shokanKetteiYMDFrom,
                shokanKetteiYMDTo,
                tab,
                reportId,
                reportTypeId,
                reportCreateDateTime);
    }
}

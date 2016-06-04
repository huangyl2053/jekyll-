/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.kingaku.IKingakuFormatter;
import jp.co.ndensan.reams.ur.urz.business.core.kingaku.KingakuFormatter;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.core.kingaku.KingakuUnit;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表のReportです。
 *
 * @reamsid_L DBB-0820-060 xuyue
 */
public class TokuChoHeijunkaKariSanteigakuHakkoIchiranReport
        extends Report<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> {

    private final List<EditedKariSanteiTsuchiShoKyotsu> editedDataList;
    private final IOutputOrder outputOrder;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;

    private final RString 出力順１;
    private final RString 出力順２;
    private final RString 出力順３;
    private final RString 出力順４;
    private final RString 出力順５;
    private final RDateTime 帳票作成日時;

    /**
     * コンストラクタです。
     *
     * @param editedDataList 編集後仮算定通知書共通情報entityのリスト
     * @param outputOrder outputOrder
     * @param 出力順１ 出力順１
     * @param 出力順２ 出力順２
     * @param 出力順３ 出力順３
     * @param 出力順４ 出力順４
     * @param 出力順５ 出力順５
     * @param 帳票作成日時 帳票作成日時
     */
    public TokuChoHeijunkaKariSanteigakuHakkoIchiranReport(List<EditedKariSanteiTsuchiShoKyotsu> editedDataList,
            IOutputOrder outputOrder,
            RString 出力順１, RString 出力順２, RString 出力順３, RString 出力順４, RString 出力順５, RDateTime 帳票作成日時) {
        this.editedDataList = editedDataList != null ? editedDataList : new ArrayList<EditedKariSanteiTsuchiShoKyotsu>();
        this.outputOrder = outputOrder;
        this.出力順１ = 出力順１;
        this.出力順２ = 出力順２;
        this.出力順３ = 出力順３;
        this.出力順４ = 出力順４;
        this.出力順５ = 出力順５;
        this.帳票作成日時 = 帳票作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> reportSourceWriter) {
        int 連番 = 1;
        for (EditedKariSanteiTsuchiShoKyotsu editedData : editedDataList) {
            TokuChoHeijunkaKariSanteigakuHakkoIchiranItem item = new TokuChoHeijunkaKariSanteigakuHakkoIchiranItem();
            setHeader(editedData, item, outputOrder);
            setBody(editedData, item, 連番);
            ITokuChoHeijunkaKariSanteigakuHakkoIchiranEditor headerEditor = new TokuChoHeijunkaKariSanteigakuHakkoIchiranHeaderEditor(item);
            ITokuChoHeijunkaKariSanteigakuHakkoIchiranEditor hyojiBodyEditor = new TokuChoHeijunkaKariSanteigakuHakkoIchiranBodyEditor(item);
            ITokuChoHeijunkaKariSanteigakuHakkoIchiranBuilder builder
                    = new TokuChoHeijunkaKariSanteigakuHakkoIchiranBuilderImpl(headerEditor, hyojiBodyEditor);
            reportSourceWriter.writeLine(builder);
            連番++;
        }
    }

    private void setHeader(EditedKariSanteiTsuchiShoKyotsu editedData, TokuChoHeijunkaKariSanteigakuHakkoIchiranItem item, IOutputOrder outputOrder) {

        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;

        List<ISetSortItem> list = outputOrder.get設定項目リスト();
        if (list == null) {
            list = new ArrayList<>();
        }

        if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
            改頁１ = list.get(0).get項目名();
        }
        if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
            改頁２ = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
            改頁３ = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
            改頁４ = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
            改頁５ = list.get(INDEX_4).get項目名();
        }

        RTime time = 帳票作成日時.getTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");
        RString printTimeStamp = 帳票作成日時.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString().concat(RString.FULL_SPACE).concat(timeFormat)
                .concat(RString.FULL_SPACE).concat(new RString("作成"));

        item.setPrintTimeStamp(printTimeStamp);
        if (editedData.get調定年度() != null) {
            item.setNendo(editedData.get調定年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString());
        }
        item.setHokenshaNo(Association.getLasdecCode().getColumnValue());
        item.setHokenshaName(Association.getShichosonName());
        item.setShutsuryokujun1(出力順１);
        item.setShutsuryokujun2(出力順２);
        item.setShutsuryokujun3(出力順３);
        item.setShutsuryokujun4(出力順４);
        item.setShutsuryokujun5(出力順５);
        item.setKaipage1(改頁１);
        item.setKaipage1(改頁２);
        item.setKaipage1(改頁３);
        item.setKaipage1(改頁４);
        item.setKaipage1(改頁５);
    }

    private void setBody(EditedKariSanteiTsuchiShoKyotsu editedData, TokuChoHeijunkaKariSanteigakuHakkoIchiranItem item, int 連番) {

        item.setListUpper_1(new RString(String.valueOf(連番)));
        if (editedData.get編集後宛先() != null) {
            item.setListUpper_2(editedData.get編集後宛先().get郵便番号());
            item.setListUpper_3(editedData.get編集後宛先().get編集後住所());
            if (editedData.get編集後宛先().get行政区() != null) {
                item.setListUpper_4(editedData.get編集後宛先().get行政区().get名称());
            }
        }
        if (editedData.get編集後個人() != null) {
            item.setListUpper_5(editedData.get編集後個人().get性別());
            item.setListUpper_6(editedData.get編集後個人().get生年月日());
        }

        try {
            IKingakuFormatter 更正前特徴期別金額01formatter = KingakuFormatter.create(editedData.get更正前().get更正前特徴期別金額01());
            item.setListUpper_7(new RString(更正前特徴期別金額01formatter.format(KingakuUnit.円).setCommaSeparated().toString()));
        } catch (Exception e) {
            item.setListUpper_7(RString.EMPTY);
        }
        try {
            IKingakuFormatter 更正前特徴期別金額02formatter = KingakuFormatter.create(editedData.get更正前().get更正前特徴期別金額02());
            item.setListUpper_8(new RString(更正前特徴期別金額02formatter.format(KingakuUnit.円).setCommaSeparated().toString()));
        } catch (Exception e) {
            item.setListUpper_8(RString.EMPTY);
        }
        try {
            IKingakuFormatter 更正前特徴期別金額03formatter = KingakuFormatter.create(editedData.get更正前().get更正前特徴期別金額03());
            item.setListUpper_9(new RString(更正前特徴期別金額03formatter.format(KingakuUnit.円).setCommaSeparated().toString()));
        } catch (Exception e) {
            item.setListUpper_9(RString.EMPTY);
        }

        if (editedData.get通知書番号() != null) {
            item.setListLower_1(editedData.get通知書番号().getColumnValue());
        }

        if (editedData.get編集後個人() != null && editedData.get編集後個人().get世帯コード() != null) {
            item.setListLower_2(editedData.get編集後個人().get世帯コード().getColumnValue());
        }

        if (editedData.get編集後個人() != null && editedData.get編集後個人().get名称() != null && editedData.get編集後個人().get名称().getName() != null) {
            item.setListLower_3(editedData.get編集後個人().get名称().getName().getColumnValue());
        }

        if (editedData.get更正後() != null) {
            item.setListLower_4(editedData.get更正後().get更正後特別徴収義務者());
            item.setListLower_5(editedData.get更正後().get更正後特別徴収対象年金());
        }
        try {
            IKingakuFormatter 更正後特徴期別金額01formatter = KingakuFormatter.create(editedData.get更正後().get更正後特徴期別金額01());
            item.setListLower_6(new RString(更正後特徴期別金額01formatter.format(KingakuUnit.円).setCommaSeparated().toString()));
        } catch (Exception e) {
            item.setListLower_6(RString.EMPTY);
        }
        try {
            IKingakuFormatter 更正後特徴期別金額02formatter = KingakuFormatter.create(editedData.get更正後().get更正後特徴期別金額02());
            item.setListLower_7(new RString(更正後特徴期別金額02formatter.format(KingakuUnit.円).setCommaSeparated().toString()));
        } catch (Exception e) {
            item.setListLower_7(RString.EMPTY);
        }
        try {
            IKingakuFormatter 更正後特徴期別金額03formatter = KingakuFormatter.create(editedData.get更正後().get更正後特徴期別金額03());
            item.setListLower_8(new RString(更正後特徴期別金額03formatter.format(KingakuUnit.円).setCommaSeparated().toString()));
        } catch (Exception e) {
            item.setListLower_8(RString.EMPTY);
        }
    }

}

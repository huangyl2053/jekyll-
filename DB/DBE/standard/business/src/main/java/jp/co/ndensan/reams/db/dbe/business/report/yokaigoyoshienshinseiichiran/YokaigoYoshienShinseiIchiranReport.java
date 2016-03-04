/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import lombok.NonNull;

/**
 * 要介護認定・要支援認定等申請者一覧表のReportです。
 */
public class YokaigoYoshienShinseiIchiranReport extends Report<YokaigoYoshienShinseiIchiranReportSource> {

    private final List<YokaigoYoshienShinseiIchiranItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定・要支援認定等申請者一覧表のITEMリスト
     * @return 要介護認定・要支援認定等申請者一覧表のReport
     */
    public static YokaigoYoshienShinseiIchiranReport createFrom(
            @NonNull List<YokaigoYoshienShinseiIchiranItem> itemList) {

        return new YokaigoYoshienShinseiIchiranReport(
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定・要支援認定等申請者一覧表のITEMリスト
     */
    protected YokaigoYoshienShinseiIchiranReport(
            List<YokaigoYoshienShinseiIchiranItem> itemList) {
        this.itemList = itemList;
    }

    /**
     * 要介護認定・要支援認定等申請者一覧表出力処理です。
     *
     * @param reportSourceWriter 要介護認定・要支援認定等申請者一覧表Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<YokaigoYoshienShinseiIchiranReportSource> reportSourceWriter) {
        RString date = RDate.getNowDate().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        RString time = RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        RStringBuilder printTimeStamp = new RStringBuilder();
        printTimeStamp.append(date);
        printTimeStamp.append(time);
        int renban = 1;
        for (YokaigoYoshienShinseiIchiranItem item : itemList) {
            item.setTitle(ReportIdDBE.DBE011001.getReportName());
            item.setPrintTimeStamp(printTimeStamp.toRString());
            item.setRenban(new RString(String.valueOf(renban++)));
            IYokaigoYoshienShinseiIchiranEditor editor = new YokaigoYoshienShinseiIchiranEditorImpl(item);
            IYokaigoYoshienShinseiIchiranBuilder builder = new YokaigoYoshienShinseiIchiranBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}

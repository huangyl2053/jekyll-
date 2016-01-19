/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.KekkatsuchiTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 要介護認定結果通知書対象者一覧表ヘッダEditorです。
 */
class KaigoKekkaTaishouIchiranHeaderEditor implements KaigoKekkaTaishouIchiranEditor {

    private final KaigoKekkaTaishouIchiranHeadItem item;

    private static final RString KARA = new RString("～");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KaigoKekkaTaishouIchiranHeadItem}
     */
    protected KaigoKekkaTaishouIchiranHeaderEditor(KaigoKekkaTaishouIchiranHeadItem item) {
        this.item = item;
    }

    @Override
    public KekkatsuchiTaishoshaIchiranReportSource edit(KekkatsuchiTaishoshaIchiranReportSource source) {
        return editHeader(source);
    }

    private KekkatsuchiTaishoshaIchiranReportSource editHeader(KekkatsuchiTaishoshaIchiranReportSource source) {

        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%02d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%02d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%02d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        source.printTimeStamp = systemDateTime.toRString();

        source.title = new RString("DBE介護保険（認定） 要介護認定結果通知書対象者一覧表");
        RStringBuilder iryoKikanCodeBulider = new RStringBuilder();
        iryoKikanCodeBulider.append(new RDate(item.getChushutsuKikanFrom().toString()).wareki().toDateString());
        iryoKikanCodeBulider.append(KARA);
        iryoKikanCodeBulider.append(new RDate(item.getChushutsuKikanTo().toString()).wareki().toDateString());
        source.chushutsuKikan = iryoKikanCodeBulider.toRString();
        if (item.getGokei() != null) {
            RStringBuilder rsbGokeiLabel = new RStringBuilder();
            rsbGokeiLabel.append(new RString("合計："));
            source.gokeiLabel = new RString(rsbGokeiLabel.toString());

            RStringBuilder rsbGokei = new RStringBuilder();
            rsbGokei.append(item.getGokei().toString());
            source.gokei = new RString(rsbGokei.toString());

            RStringBuilder rsbkenLabel = new RStringBuilder();
            rsbkenLabel.append(new RString("件"));
            source.kenLabel = new RString(rsbkenLabel.toString());
        }
        source.shichosonName = item.getShichosonName();

        return source;
    }
}

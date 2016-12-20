/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.KekkatsuchiTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 要介護認定結果通知書対象者一覧表ボディEditorです。
 *
 * @reamsid_L DBE-0190-020 lizhuoxuan
 */
class KaigoKekkaTaishouIchiranBodyEditor implements IKaigoKekkaTaishouIchiranEditor {

    private final KaigoKekkaTaishouIchiranBodyItem item;
    private final RString index;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KaigoKekkaTaishouIchiranBodyItem}
     */
    protected KaigoKekkaTaishouIchiranBodyEditor(KaigoKekkaTaishouIchiranBodyItem item, RString index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public KekkatsuchiTaishoshaIchiranReportSource edit(KekkatsuchiTaishoshaIchiranReportSource source) {
        return editBody(source);
    }

    private KekkatsuchiTaishoshaIchiranReportSource editBody(KekkatsuchiTaishoshaIchiranReportSource source) {

        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.listKekkatsuchi_1 = index;
        source.listKekkatsuchi_2 = item.getListKekkatsuchi_2();
        RStringBuilder listKekkatsuchi_3 = new RStringBuilder();
        listKekkatsuchi_3.append((new RDate(item.getListKekkatsuchi_3().toString()).wareki()).eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).
                fillType(FillType.ZERO).toDateString());
        source.listKekkatsuchi_3 = listKekkatsuchi_3.toRString();
        if (!RString.isNullOrEmpty(item.getListKekkatsuchi_4())) {
            source.listKekkatsuchi_4 = new RDate(item.getListKekkatsuchi_4().toString()).wareki().toDateString();
        }
        source.listKekkatsuchi_5 = item.getListKekkatsuchi_5();
        source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), item.getListKekkatsuchi_5());
        source.listKekkatsuchi_6 = item.getListKekkatsuchi_6();
        source.listKekkatsuchi_7 = item.getListKekkatsuchi_7();
        RStringBuilder listKekkatsuchi_8 = new RStringBuilder();
        listKekkatsuchi_8.append((new RDate(item.getListKekkatsuchi_8().toString()).wareki()).eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).
                fillType(FillType.ZERO).toDateString());
        source.listKekkatsuchi_8 = listKekkatsuchi_8.toRString();
        source.listKekkatsuchi_9 = item.getListKekkatsuchi_9();
        source.listKekkatsuchi_10 = item.getListKekkatsuchi_10();
        return source;
    }
}

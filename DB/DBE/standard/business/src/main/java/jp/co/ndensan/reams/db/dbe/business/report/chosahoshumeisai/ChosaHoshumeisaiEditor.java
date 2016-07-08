/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshumeisai;

import jp.co.ndensan.reams.db.dbe.business.core.chosahoshumeisai.ChosaHoshumeisai;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshumeisai.ChosaHoshumeisaiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 認定調査報酬支払明細書のEditorです。
 *
 * @reamsid_L DBE-1980-045 suguangjun
 */
public class ChosaHoshumeisaiEditor implements IChosaHoshumeisaiEditor {

    private final ChosaHoshumeisai item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaHoshumeisai}
     */
    protected ChosaHoshumeisaiEditor(ChosaHoshumeisai item) {
        this.item = item;
    }

    @Override
    public ChosaHoshumeisaiReportSource edit(ChosaHoshumeisaiReportSource source) {
        return editSource(source);
    }

    private ChosaHoshumeisaiReportSource editSource(ChosaHoshumeisaiReportSource source) {
        FlexibleDate printdate = item.get帳票印刷日時();
        RString printTimeStampSb = printdate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
        source.title = item.getタイトル();
        source.taishoKikan = item.get対象期間();
        source.hokenshaName = item.get保険者名();
        source.chosaItakusakiName = item.get調査機関名();
        source.chosainName = item.get調査員名();
        source.printTimeStamp = printTimeStampSb;
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (item.get被保険者番号() != null) {
            source.hihokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), item.get被保険者番号());
        }
        return source;
    }
}

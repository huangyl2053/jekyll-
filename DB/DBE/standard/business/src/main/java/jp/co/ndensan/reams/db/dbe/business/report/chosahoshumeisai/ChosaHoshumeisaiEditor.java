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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

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
        source.title = item.getタイトル();
        source.taishoKikan = item.get対象期間();
        source.hokenshaName = item.get保険者名();
        source.chosaItakusakiName = item.get調査機関名();
        source.chosainName = item.get調査員名();
        source.printTimeStamp = item.get帳票印刷日時();
        source.listChosaSakusei_1 = item.get明細番号();
        source.listChosaSakusei_2 = item.get被保険者番号();
        source.listChosaSakusei_3 = item.get被保険者氏名();
        source.listChosaSakusei_4 = item.get生年月日();
        source.listChosaSakusei_5 = item.get調査票提出日();
        source.listChosaSakusei_6 = item.get新規申請在宅();
        source.listChosaSakusei_7 = item.get新規申請施設();
        source.listChosaSakusei_8 = item.get継続申請在宅();
        source.listChosaSakusei_9 = item.get継続申請施設();
        source.listChosaSakusei_10 = item.get調査票作成料();
        source.listGokeikensu_1 = kinngakuFormat(item.get合計件数新規在宅());
        source.listGokeikensu_2 = kinngakuFormat(item.get合計件数新規施設());
        source.listGokeikensu_3 = kinngakuFormat(item.get合計件数継続在宅());
        source.listGokeikensu_4 = kinngakuFormat(item.get合計件数継続施設());
        source.gokeiKingaku = kinngakuFormat(item.get合計金額());
        source.shouhiZei = kinngakuFormat(item.get消費税());
        source.gokeiSeikyuKingaku = kinngakuFormat(item.get合計請求額());
        source.ninteichosainCode = item.get調査員コード();
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (item.get被保険者番号() != null) {
            source.hihokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), item.get被保険者番号());
        }
        return source;
    }

    private RString kinngakuFormat(RString date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(new Decimal(date.toString()), 0);
    }
}

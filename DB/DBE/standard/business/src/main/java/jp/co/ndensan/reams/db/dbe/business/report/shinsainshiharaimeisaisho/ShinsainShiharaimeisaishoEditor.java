/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsainshiharaimeisaisho;

import jp.co.ndensan.reams.db.dbe.business.core.shinsainshiharaimeisaisho.ShinsainShiharaimeisaisho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsainshiharaimeisaisho.ShinsainShiharaimeisaishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護認定審査会委員報酬支払明細書のEditorです。
 *
 * @reamsid_L DBE-1980-046 suguangjun
 */
public class ShinsainShiharaimeisaishoEditor implements IShinsainShiharaimeisaishoEditor {

    private final ShinsainShiharaimeisaisho item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsainShiharaimeisaisho}
     */
    protected ShinsainShiharaimeisaishoEditor(ShinsainShiharaimeisaisho item) {
        this.item = item;
    }

    @Override
    public ShinsainShiharaimeisaishoReportSource edit(ShinsainShiharaimeisaishoReportSource source) {
        return editSource(source);
    }

    private ShinsainShiharaimeisaishoReportSource editSource(ShinsainShiharaimeisaishoReportSource source) {
        source.title = item.getタイトル();
        source.taishoKikan = item.get対象期間();
        source.hokenshaName = item.get保険者名();
        source.shinsainName = item.get審査委員名();
        source.printTimeStamp = item.get帳票印刷日時();
        source.listChosaSakusei_1 = item.get明細番号();
        source.listChosaSakusei_2 = item.get被保険者番号();
        source.listChosaSakusei_3 = item.get被保険者氏名();
        source.listChosaSakusei_4 = item.get生年月日();
        source.listChosaSakusei_5 = item.get査会開催年月日();
        source.listChosaSakusei_6 = kinngakuFormat(item.get報酬総額());
        source.listChosaSakusei_7 = kinngakuFormat(item.get費用弁償());
        source.listChosaSakusei_8 = kinngakuFormat(item.get税額控除());
        source.listChosaSakusei_9 = kinngakuFormat(item.get報酬合計());
        source.gokeiKingaku = kinngakuFormat(item.get合計金額());
        source.shouhiZei = kinngakuFormat(item.get消費税());
        source.gokeiSeikyuKingaku = kinngakuFormat(item.get合計請求額());
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (item.get被保険者番号() != null) {
            source.hihokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), item.get被保険者番号());
        }
        return source;
    }

    private RString kinngakuFormat(RString data) {
        if (data == null || data.isEmpty()) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(new Decimal(data.toString()), 0);
    }
}

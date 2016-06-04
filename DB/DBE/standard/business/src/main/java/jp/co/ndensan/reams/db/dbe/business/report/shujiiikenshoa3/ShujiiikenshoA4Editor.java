/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.ShujiiikenshoA4ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.ShujiiikenshoItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 委員用主治医意見書A4のEditorです。
 *
 * @reamsid_L DBE-0150-140 lishengli
 */
public class ShujiiikenshoA4Editor implements IShujiiikenshoA4Editor {

    private static final int INT_4 = 4;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_10 = 10;
    private final ShujiiikenshoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShujiiikenshoItem}
     */
    protected ShujiiikenshoA4Editor(ShujiiikenshoItem item) {
        this.item = item;
    }

    @Override
    public ShujiiikenshoA4ReportSource edit(ShujiiikenshoA4ReportSource source) {
        return editSource(source);
    }

    private ShujiiikenshoA4ReportSource editSource(ShujiiikenshoA4ReportSource source) {
        source.hokenshaNo = item.get保険者番号();
        source.hihokenshaNo = item.get被保険者番号();
        source.hihokenshaName = item.get名前();
        source.shinseiGengo = get元号(item.get今回認定申請年月日());
        source.shinseiYY = get年(item.get今回認定申請年月日());
        source.shinseiMM = get月(item.get今回認定申請年月日());
        source.shinseiDD = get日(item.get今回認定申請年月日());
        source.sakuseiGengo = get元号(item.get審査会資料作成年月日());
        source.sakuseiYY = get年(item.get審査会資料作成年月日());
        source.sakuseiMM = get月(item.get審査会資料作成年月日());
        source.sakuseiDD = get日(item.get審査会資料作成年月日());
        source.chosaGengo = get元号(item.get今回認定調査実施年月日());
        source.chosaYY = get年(item.get今回認定調査実施年月日());
        source.chosaMM = get月(item.get今回認定調査実施年月日());
        source.chosaDD = get日(item.get今回認定調査実施年月日());
        source.shinsaGengo = get元号(item.get今回認定審査年月日());
        source.shinsaYY = get年(item.get今回認定審査年月日());
        source.shinsaMM = get月(item.get今回認定審査年月日());
        source.shinsaDD = get日(item.get今回認定審査年月日());
        //TODO 主治医意見書イメージset
        source.imgIkensho1 = item.get主治医意見書イメージ();
        source.two_hokenshaNo = item.get保険者番号();
        source.two_hihokenshaNo = item.get被保険者番号();
        source.two_hihokenshaName = item.get名前();
        source.two_shinseiGengo = get元号(item.get今回認定申請年月日());
        source.two_shinseiYY = get年(item.get今回認定申請年月日());
        source.two_shinseiMM = get月(item.get今回認定申請年月日());
        source.two_shinseiDD = get日(item.get今回認定申請年月日());
        source.two_sakuseiGengo = get元号(item.get審査会資料作成年月日());
        source.two_sakuseiYY = get年(item.get審査会資料作成年月日());
        source.two_sakuseiMM = get月(item.get審査会資料作成年月日());
        source.two_sakuseiDD = get日(item.get審査会資料作成年月日());
        source.two_chosaGengo = get元号(item.get今回認定調査実施年月日());
        source.two_chosaYY = get年(item.get今回認定調査実施年月日());
        source.two_chosaMM = get月(item.get今回認定調査実施年月日());
        source.two_chosaDD = get日(item.get今回認定調査実施年月日());
        source.two_shinsaGengo = get元号(item.get今回認定審査年月日());
        source.two_shinsaYY = get年(item.get今回認定審査年月日());
        source.two_shinsaMM = get月(item.get今回認定審査年月日());
        source.two_shinsaDD = get日(item.get今回認定審査年月日());
        source.two_imgIkensho2 = item.get主治医意見書イメージ();
        return source;
    }

    private RString get元号(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(0, 2);
        }
        return RString.EMPTY;
    }

    private RString get年(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(2, INT_4);
        }
        return RString.EMPTY;
    }

    private RString get月(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(INT_6, INT_7);
        }
        return RString.EMPTY;
    }

    private RString get日(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(INT_8, INT_10);
        }
        return RString.EMPTY;
    }

    private RString パターン12(FlexibleDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
}

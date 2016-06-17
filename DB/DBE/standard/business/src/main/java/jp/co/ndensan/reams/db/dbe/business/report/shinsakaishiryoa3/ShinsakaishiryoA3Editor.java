/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3.ShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3.ShinsakaishiryoItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 事務局用介護認定審査対象者一覧表A3のEditorクラスです。
 *
 * @reamsid_L DBE-0150-020 lishengli
 */
public class ShinsakaishiryoA3Editor implements IShinsakaishiryoA3Editor {

    private final ShinsakaishiryoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsakaishiryoItem}
     */
    protected ShinsakaishiryoA3Editor(ShinsakaishiryoItem item) {
        this.item = item;
    }

    /**
     *
     * @param source 事務局用介護認定審査対象者一覧表のReportSourceクラス
     * @return ShinsakaishiryoA3ReportSource 事務局用介護認定審査対象者一覧表のReportSourceクラス
     */
    @Override
    public ShinsakaishiryoA3ReportSource edit(ShinsakaishiryoA3ReportSource source) {
        return editItem(source);
    }

    private ShinsakaishiryoA3ReportSource editItem(ShinsakaishiryoA3ReportSource source) {
        source.shinsakaiNo = item.get審査会番号();
        source.shinsakaiKaisaiYMD = item.get審査会開催年月日();
        source.gogitaiNo = RStringUtil.convert半角to全角(item.get合議体番号());
        source.listShinsainName_1 = item.get審査員一覧();
        source.shinsaTaishoshaCount = RStringUtil.convert半角to全角(item.get審査対象者数());
        int no = item.getNo();
        if (no % 2 == 0) {
            source.listShinsei2_1 = item.get審査会審査順();
            source.listShinsei2_2 = item.get保険者();
            source.listShinsei2_3 = item.get被保険者();
            source.listShinsei2_4 = item.get氏名();
            source.listShinsei2_5 = item.get性別();
            source.listShinsei2_6 = item.get年齢();
            source.listShinsei2_7 = item.get前回二次();
            source.listShinsei2_8 = item.get前回期間();
            source.listShinsei2_9 = item.get一次判定();
            source.listShinsei2_10 = item.get二次判定();
            source.listShinsei2_11 = RString.EMPTY;
            source.listZenkaiｙukokikan2_1 = get二時判定認定有効年月日();
            source.listYukokikan2_1 = RString.EMPTY;
        } else {
            source.listShinsei1_1 = item.get審査会審査順();
            source.listShinsei1_2 = item.get保険者();
            source.listShinsei1_3 = item.get被保険者();
            source.listShinsei1_4 = item.get氏名();
            source.listShinsei1_5 = item.get性別();
            source.listShinsei1_6 = item.get年齢();
            source.listShinsei1_7 = item.get前回二次();
            source.listShinsei1_8 = item.get前回期間();
            source.listShinsei1_9 = item.get一次判定();
            source.listShinsei1_10 = item.get二次判定();
            source.listShinsei1_11 = RString.EMPTY;
            source.listZenkaiｙukokikan1_1 = get二時判定認定有効年月日();
            source.listYukokikan1_1 = RString.EMPTY;
        }
        return source;
    }

    private RString get二時判定認定有効年月日() {
        RStringBuilder 効開始年月日 = new RStringBuilder();
        効開始年月日.append(getパターン13(item.get二時判定認定有効開始年月日()));
        if (item.get二時判定認定有効開始年月日() != null && !item.get二時判定認定有効開始年月日().isEmpty()) {
            効開始年月日.append(new RString("～"));
        }
        効開始年月日.append(item.get二時判定認定有効開始年月日());
        return 効開始年月日.toRString();
    }

    private RString getパターン13(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

}

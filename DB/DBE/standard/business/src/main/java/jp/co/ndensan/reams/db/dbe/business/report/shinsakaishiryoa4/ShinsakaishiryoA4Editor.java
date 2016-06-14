/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3.ShinsakaishiryoItem;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4.ShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 * 事務局用介護認定審査対象者一覧表A4のEditorクラスです。
 *
 * @reamsid_L DBE-0150-020 lishengli
 */
public class ShinsakaishiryoA4Editor implements IShinsakaishiryoA4Editor {

    private final ShinsakaishiryoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsakaishiryoItem}
     */
    protected ShinsakaishiryoA4Editor(ShinsakaishiryoItem item) {
        this.item = item;
    }

    /**
     *
     * @param source 事務局用介護認定審査対象者一覧表のReportSourceクラス
     * @return ShinsakaishiryoA4ReportSource 事務局用介護認定審査対象者一覧表のReportSourceクラス
     */
    @Override
    public ShinsakaishiryoA4ReportSource edit(ShinsakaishiryoA4ReportSource source) {
        return editItem(source);
    }

    private ShinsakaishiryoA4ReportSource editItem(ShinsakaishiryoA4ReportSource source) {
        source.shinsakaiNo = item.get審査会番号();
        source.year = item.get審査会開催年月日();
        source.listshinsainName_1 = item.get審査員一覧();
        source.gogitaiNo = RStringUtil.convert半角to全角(item.get合議体番号());
        source.shinsaTaishoshaCount = RStringUtil.convert半角to全角(item.get審査対象者数());
        source.list1_1 = new RString(item.getNo());
        source.list1_2 = item.get保険者();
        source.list1_3 = item.get被保険者();
        source.list1_4 = item.get氏名();
        source.list1_5 = item.get性別();
        source.list1_6 = item.get年齢();
        source.list1_7 = item.get前回二次();
        source.list1_8 = item.get前回期間();
        source.list1_9 = item.get一次判定();
        source.list1_10 = item.get警告();
        source.list1_11 = item.get基準時間();
        source.list1_12 = RString.EMPTY;
        source.list1_13 = RString.EMPTY;
        return source;
    }

}

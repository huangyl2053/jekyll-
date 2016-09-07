/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3.ShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査対象者一覧表A3のEditorクラスです。
 *
 * @reamsid_L DBE-0150-230 lishengli
 */
public class ShinsakaishiryoA3EditorRight implements IShinsakaishiryoA3Editor {

    private static final int INT_2 = 2;
    private static final int INT_25 = 25;
    private final JimuShinsakaishiryoBusiness business;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link JimuShinsakaishiryoBusiness}
     * @param index index
     */
    protected ShinsakaishiryoA3EditorRight(JimuShinsakaishiryoBusiness business, int index) {
        this.business = business;
        this.index = index;
    }

    /**
     * 介護認定審査対象者一覧表のEditです。
     *
     * @param source 介護認定審査対象者一覧表のReportSourceクラス
     * @return ShinsakaishiryoA3ReportSource 介護認定審査対象者一覧表のReportSourceクラス
     */
    @Override
    public ShinsakaishiryoA3ReportSource edit(ShinsakaishiryoA3ReportSource source) {
        return editItem(source);
    }

    private ShinsakaishiryoA3ReportSource editItem(ShinsakaishiryoA3ReportSource source) {
        if (INT_25 <= index) {
            source.listShinsei2_1 = business.get審査会審査順().padZeroToLeft(INT_2);
            source.listShinsei2_2 = business.get保険者();
            source.listShinsei2_3 = business.get被保険者();
            source.listShinsei2_4 = business.get氏名();
            source.listShinsei2_5 = business.get性別();
            source.listShinsei2_6 = business.get年齢();
            source.listShinsei2_7 = business.get前回二次();
            source.listShinsei2_8 = business.get前回期間();
            source.listShinsei2_9 = business.get一次判定();
            source.listShinsei2_10 = RString.EMPTY;
            source.listShinsei2_11 = RString.EMPTY;
            source.listZenkaiｙukokikan2_1 = business.get前回期間_下();
            source.listYukokikan2_1 = RString.EMPTY;
        }
        return source;
    }
}

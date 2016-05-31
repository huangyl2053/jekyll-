/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.a4tate;

import jp.co.ndensan.reams.db.dbb.entity.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource;

/**
 *
 * 介護保険料額決定通知書のA4縦タイプのEditorです。
 *
 * @reamsid_L DBB-9080-010 sunhaidi
 */
public class KibetsuEditor implements IKaigoHokenHokenryogakuKetteiTsuchishoA4TateEditor {

    private final KibetsuBusiness item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KaigoHokenHokenryogakuKetteiTsuchishoB5YokoBusiness}
     */
    protected KibetsuEditor(KibetsuBusiness item) {
        this.item = item;
    }

    @Override
    public KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource edit(KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource reportSource) {
        reportSource.listKibetsu_1 = item.getListKibetsu_1();
        reportSource.listKibetsu_2 = item.getListKibetsu_2();
        reportSource.listKibetsu_3 = item.getListKibetsu_3();
        reportSource.listKibetsu_4 = item.getListKibetsu_4();
        reportSource.listKibetsu_5 = item.getListKibetsu_5();
        reportSource.listKibetsu_6 = item.getListKibetsu_6();
        reportSource.listKibetsu_7 = item.getListKibetsu_7();
        reportSource.listKibetsu_8 = item.getListKibetsu_8();
        reportSource.listKibetsu_9 = item.getListKibetsu_9();
        return reportSource;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.b5yoko;

import jp.co.ndensan.reams.db.dbb.entity.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource;

/**
 *
 * 介護保険料額決定通知書のB5横タイプのEditorです。
 *
 * @reamsid_L DBB-9080-010 sunhaidi
 */
public class KibetsuEditor implements IKaigoHokenHokenryogakuKetteiTsuchishoB5YokoEditor {

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
    public KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource edit(KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource reportSource) {
        reportSource.listKibetsu_1 = item.getListKibetsu_1();
        reportSource.listKibetsu_2 = item.getListKibetsu_2();
        reportSource.listKibetsu_3 = item.getListKibetsu_3();
        reportSource.listKibetsu_4 = item.getListKibetsu_4();
        reportSource.listKibetsu_5 = item.getListKibetsu_5();
        reportSource.listKibetsu_6 = item.getListKibetsu_6();
        reportSource.listKibetsu_7 = item.getListKibetsu_7();
        reportSource.listKibetsu_8 = item.getListKibetsu_8();
        return reportSource;
    }
}

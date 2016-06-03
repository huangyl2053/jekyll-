/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.b5yoko;

import jp.co.ndensan.reams.db.dbb.entity.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource;

/**
 *
 * 介護保険料額変更兼特別徴収中止通知書のB5横タイプのEditorです。
 *
 * @reamsid_L DBB-9080-020 sunhaidi
 */
public class KibetsuEditor implements IKaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoEditor {

    private final KibetsuBusiness item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoBusiness}
     */
    protected KibetsuEditor(KibetsuBusiness item) {
        this.item = item;
    }

    @Override
    public KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource edit(KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource reportSource) {
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

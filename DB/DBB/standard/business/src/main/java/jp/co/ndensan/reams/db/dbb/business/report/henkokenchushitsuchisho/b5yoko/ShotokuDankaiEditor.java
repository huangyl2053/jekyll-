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
public class ShotokuDankaiEditor implements IKaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoEditor {

    private final ShotokuDankaiBusiness item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoBusiness}
     */
    protected ShotokuDankaiEditor(ShotokuDankaiBusiness item) {
        this.item = item;
    }

    @Override
    public KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource edit(KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource reportSource) {
        reportSource.listShotokuDankai_1 = item.getListShotokuDankai_1();
        reportSource.listShotokuDankai_2 = item.getListShotokuDankai_2();
        reportSource.listShotokuDankai_3 = item.getListShotokuDankai_3();
        reportSource.listShotokuDankai_4 = item.getListShotokuDankai_4();
        reportSource.listShotokuDankai_5 = item.getListShotokuDankai_5();
        reportSource.listShotokuDankai_6 = item.getListShotokuDankai_6();
        reportSource.listShotokuDankai_7 = item.getListShotokuDankai_7();
        reportSource.listShotokuDankai_8 = item.getListShotokuDankai_8();
        reportSource.listShotokuDankai_9 = item.getListShotokuDankai_9();
        reportSource.listShotokuDankai_10 = item.getListShotokuDankai_10();
        reportSource.listShotokuDankai_11 = item.getListShotokuDankai_11();
        reportSource.listShotokuDankai_12 = item.getListShotokuDankai_12();
        return reportSource;
    }
}

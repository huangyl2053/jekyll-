/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoA3ReportSource;

/**
 * 委員用一次判定結果票A3のEditorです。
 *
 * @reamsid_L DBE-0150-130 lishengli
 */
public class IchijihanteikekkahyoA3BodyEditor implements IIchijihanteikekkahyoA3Editor {

    private final IchijihanteikekkahyoA3Body item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IchijihanteikekkahyoA3Body}
     */
    protected IchijihanteikekkahyoA3BodyEditor(IchijihanteikekkahyoA3Body item) {
        this.item = item;
    }

    @Override
    public IchijihanteikekkahyoA3ReportSource edit(IchijihanteikekkahyoA3ReportSource source) {
        return editSource(source);
    }

    private IchijihanteikekkahyoA3ReportSource editSource(IchijihanteikekkahyoA3ReportSource source) {
        source.kaigo_listKaigokyufu_1 = item.getKaigo_listKaigokyufu_1();
        source.kaigo_listKaigokyufu1_1 = item.getKaigo_listKaigokyufu1_1();
        source.yobo_listYobokyufu_1 = item.getYobo_listYobokyufu_1();
        source.yobo_listYobokyufu1_1 = item.getYobo_listYobokyufu1_1();
        source.listChukanhyoka_1 = item.getListChukanhyoka_1();
        source.listChukanhyoka_2 = item.getListChukanhyoka_2();
        source.listChukanhyoka_3 = item.getListChukanhyoka_3();
        source.listChukanhyoka_4 = item.getListChukanhyoka_4();
        source.listChukanhyoka_5 = item.getListChukanhyoka_5();
        source.listIchigun_1 = item.getListIchigun_1();
        source.listIchigun_2 = item.getListIchigun_2();
        source.listIchigun_3 = item.getListIchigun_3();
        source.listIchigun_4 = item.getListIchigun_4();
        source.listNigun_1 = item.getListNigun_1();
        source.listNigun_2 = item.getListNigun_2();
        source.listNigun_3 = item.getListNigun_3();
        source.listNigun_4 = item.getListNigun_4();
        source.listSangun_1 = item.getListSangun_1();
        source.listSangun_2 = item.getListSangun_2();
        source.listSangun_3 = item.getListSangun_3();
        source.listSangun_4 = item.getListSangun_4();
        source.listYongun_1 = item.getListYongun_1();
        source.listYongun_2 = item.getListYongun_2();
        source.listYongun_3 = item.getListYongun_3();
        source.listYongun_4 = item.getListYongun_4();
        source.listGogun_1 = item.getListGogun_1();
        source.listGogun_2 = item.getListGogun_2();
        source.listGogun_3 = item.getListGogun_3();
        source.listGogun_4 = item.getListGogun_4();
        source.listFuseigo1_1 = item.getListFuseigo1_1();
        source.listFuseigo1_2 = item.getListFuseigo1_2();
        source.listFuseigo2_1 = item.getListFuseigo2_1();
        source.listFuseigo2_2 = item.getListFuseigo2_2();
        source.listFuseigo3_1 = item.getListFuseigo3_1();
        source.listFuseigo3_2 = item.getListFuseigo3_2();
        source.listFuseigo4_1 = item.getListFuseigo4_1();
        source.listFuseigo4_2 = item.getListFuseigo4_2();
        source.listFuseigo5_1 = item.getListFuseigo5_1();
        source.listFuseigo5_2 = item.getListFuseigo5_2();
        source.listtokubetsunaIryo1_1 = item.getListtokubetsunaIryo1_1();
        source.listtokubetsunaIryo1_2 = item.getListtokubetsunaIryo1_2();
        source.listtokubetsunaIryo1_3 = item.getListtokubetsunaIryo1_3();
        source.listtokubetsunaIryo1_4 = item.getListtokubetsunaIryo1_4();
        source.listtokubetsunaIryo2_1 = item.getListtokubetsunaIryo2_1();
        source.listtokubetsunaIryo2_2 = item.getListtokubetsunaIryo2_2();
        source.listtokubetsunaIryo2_3 = item.getListtokubetsunaIryo2_3();
        source.listtokubetsunaIryo2_4 = item.getListtokubetsunaIryo2_4();
        return source;
    }
}

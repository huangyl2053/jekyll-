/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyouichijihanteikekkahyoa4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyouichijihanteikekkahyo.IchijihanteikekkahyoA4ReportSource;

/**
 * 事務局用一次判定結果票A4のEditorです。
 *
 * @reamsid_L DBE-0150-040 lishengli
 */
public class IchijihanteikekkahyoA4BodyEditor implements IIchijihanteikekkahyoA4Editor {

    private final IchijihanteikekkahyoA4Body item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IchijihanteikekkahyoA4Body}
     */
    protected IchijihanteikekkahyoA4BodyEditor(IchijihanteikekkahyoA4Body item) {
        this.item = item;
    }

    @Override
    public IchijihanteikekkahyoA4ReportSource edit(IchijihanteikekkahyoA4ReportSource source) {
        return editSource(source);
    }

    private IchijihanteikekkahyoA4ReportSource editSource(IchijihanteikekkahyoA4ReportSource source) {
        source.listshujiiikensho_1 = item.getListshujiiikensho_1();
        source.listshujiiikensho_2 = item.getListshujiiikensho_2();
        source.listshujiiikensho_3 = item.getListshujiiikensho_3();
        source.listshujiiikensho_4 = item.getListshujiiikensho_4();
        source.ｌistNichijoseikatsujiritsudo_1 = item.getListNichijoseikatsujiritsudo_1();
        source.listtokki1_1 = item.getListtokki1_1();
        source.listtokki2_1 = item.getListtokki2_1();
        source.listtokki3_1 = item.getListtokki3_1();
        source.listtokki4_1 = item.getListtokki4_1();
        source.listtokki5_1 = item.getListtokki5_1();
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
        source.listtokki6_1 = item.getListtokki6_1();
        source.listtokki8_1 = item.getListtokki8_1();
        source.listtokubetsunaIryo1_1 = item.getListtokubetsunaIryo1_1();
        source.listtokubetsunaIryo1_2 = item.getListtokubetsunaIryo1_2();
        source.listtokubetsunaIryo2_1 = item.getListtokubetsunaIryo2_1();
        source.listtokubetsunaIryo2_2 = item.getListtokubetsunaIryo2_2();
        return source;
    }
}

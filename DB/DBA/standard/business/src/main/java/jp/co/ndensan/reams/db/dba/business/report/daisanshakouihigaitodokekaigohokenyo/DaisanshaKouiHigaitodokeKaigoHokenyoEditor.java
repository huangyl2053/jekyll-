/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.daisanshakouihigaitodokekaigohokenyo;

import jp.co.ndensan.reams.db.dba.entity.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoReportSource;

/**
 *
 * 第三者行為による被害届（介護保険用）のEditorです。
 */
public class DaisanshaKouiHigaitodokeKaigoHokenyoEditor implements IDaisanshaKouiHigaitodokeKaigoHokenyoEditor {

    private final DaisanshaKouiHigaitodokeKaigoHokenyoItem joho;

    /**
     * コンストラクタです。
     *
     * @param joho 第三者行為による被害届（介護保険用）Entityリストです
     */
    public DaisanshaKouiHigaitodokeKaigoHokenyoEditor(DaisanshaKouiHigaitodokeKaigoHokenyoItem joho) {
        this.joho = joho;
    }

    /**
     * 第三者行為による被害届（介護保険用）editです。
     *
     * @param source 第三者行為による被害届（介護保険用）Source
     * @return 第三者行為による被害届（介護保険用）
     */
    @Override
    public DaisanshaKouiHigaitodokeKaigoHokenyoReportSource edit(DaisanshaKouiHigaitodokeKaigoHokenyoReportSource source) {
        return editBody(source);
    }

    private DaisanshaKouiHigaitodokeKaigoHokenyoReportSource editBody(DaisanshaKouiHigaitodokeKaigoHokenyoReportSource source) {
        source.ninshoshaYakushokuMei = joho.getNinshoshaYakushokuMei();
        source.birthYMD = joho.getBirthYMD();
        source.hihokenshaName = joho.getHihokenshaName();
        source.hihokenshaNameKana = joho.getHihokenshaNameKana();
        source.hihokenshaNo = joho.getHihokenshaNo();
        source.hokenshaNo = joho.getHokenshaNo();
        source.ninteiYukoKikanKaishiYMD = joho.getNinteiYukoKikanKaishiYMD();
        source.ninteiYukoKikanShuryoYMD = joho.getNinteiYukoKikanShuryoYMD();
        source.remban = joho.getRemban();
        source.yokaigoJotaiKubun = joho.getYokaigoJotaiKubun();
        return source;
    }
}

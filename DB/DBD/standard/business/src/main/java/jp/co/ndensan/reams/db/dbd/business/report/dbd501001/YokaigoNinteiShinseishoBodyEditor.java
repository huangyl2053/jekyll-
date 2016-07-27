/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd501001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteishinseishohakko.ShinseiShoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd501001.YokaigoNinteiShinseishoReportSource;

/**
 * 要介護認定申請書ボディEditorです。
 *
 * @reamsid_L DBD-1400-020 b_zhengs
 */
public class YokaigoNinteiShinseishoBodyEditor implements IYokaigoNinteiShinseishoEditor {

    private final ShinseiShoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定申請書の一覧Entity
     */
    public YokaigoNinteiShinseishoBodyEditor(ShinseiShoEntity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定申請書ボディEditorです。
     *
     * @param source 要介護認定申請書Source
     * @return 要介護認定申請書Source
     */
    @Override
    public YokaigoNinteiShinseishoReportSource edit(YokaigoNinteiShinseishoReportSource source) {
        return bodyEdit(source);
    }

    private YokaigoNinteiShinseishoReportSource bodyEdit(YokaigoNinteiShinseishoReportSource source) {
//        source.cityName = entity.getCityName();
        // TODO:
        source.hihokenshaNo1 = entity.getHihokenshaNo1();
        source.hihokenshaNo2 = entity.getHihokenshaNo2();
        source.hihokenshaNo3 = entity.getHihokenshaNo3();
        source.hihokenshaNo4 = entity.getHihokenshaNo4();
        source.hihokenshaNo5 = entity.getHihokenshaNo5();
        source.hihokenshaNo6 = entity.getHihokenshaNo6();
        source.hihokenshaNo7 = entity.getHihokenshaNo7();
        source.hihokenshaNo8 = entity.getHihokenshaNo8();
        source.hihokenshaNo9 = entity.getHihokenshaNo9();
        source.hihokenshaNo10 = entity.getHihokenshaNo10();
        source.birthGengoMeiji = entity.getBirthGengoMeiji();
        source.birthGengoTaisho = entity.getBirthGengoTaisho();
        source.birthGengoShowa = entity.getBirthGengoShowa();
        source.hihokenshaNameKana = entity.getHihokenshaNameKana();
        source.birthYYYY = entity.getBirthYYYY();
        source.umareYy = entity.getUmareYy();
        source.birthMM = entity.getBirthMM();
        source.birthDD = entity.getBirthDD();
        source.hihokenshaName = entity.getHihokenshaName();
        source.seibetsuMan = entity.getSeibetsuMan();
        source.seibetsuWoman = entity.getSeibetsuWoman();
        source.telNo = entity.getTelNo();
        source.yubinNo = entity.getYubinNo();
        source.jusho = entity.getJusho();
        source.yokaigoJotaiKubun1 = entity.getYokaigoJotaiKubun1();
        source.yokaigoJotaiKubun2 = entity.getYokaigoJotaiKubun2();
        source.yokaigoJotaiKubun3 = entity.getYokaigoJotaiKubun3();
        source.yokaigoJotaiKubun4 = entity.getYokaigoJotaiKubun4();
        source.yokaigoJotaiKubun5 = entity.getYokaigoJotaiKubun5();
        source.yoshienJotaiKubun1 = entity.getYoshienJotaiKubun1();
        source.yoshienJotaiKubun2 = entity.getYoshienJotaiKubun2();
        source.yukoKaishiYYYY = entity.getYukoKaishiYYYY();
        source.yukoKaishiMM = entity.getYukoKaishiMM();
        source.yukoKaishiDD = entity.getYukoKaishiDD();
        source.yukoShuryoYYYY = entity.getYukoShuryoYYYY();
        source.yukoShuryoMM = entity.getYukoShuryoMM();
        source.yukoShuryoDD = entity.getYukoShuryoDD();

        return source;

    }

}

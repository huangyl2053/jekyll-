/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshokinyuyoshi.IkenshokinyuyoshiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ikenshokinyuyoshi.IkenshokinyuyoshiReportSource;

/**
 * 要介護認定主治医意見書記入用紙のEditorです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiEditorImpl implements IIkenshokinyuyoshiEditor {

    private final IkenshokinyuyoshiEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link IkenshokinyuyoshiEntity}
     */
    protected IkenshokinyuyoshiEditorImpl(IkenshokinyuyoshiEntity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定主治医意見書記入用紙を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public IkenshokinyuyoshiReportSource edit(IkenshokinyuyoshiReportSource source) {
        return editSource(source);
    }

    private IkenshokinyuyoshiReportSource editSource(IkenshokinyuyoshiReportSource source) {
        source.hihokenshaKana = entity.getHihokenshaNameKana();
        source.yubinNo = entity.getYubinNo();
        source.seibetsuMan = entity.getSeibetsuMan();
        source.jusho = entity.getJusho();
        source.hihokenshaName = entity.getHihokenshaName();
        source.seibetsuWoman = entity.getSeibetsuWoman();
        source.hihokenshaTel = entity.getHihokenshaTel();
        source.birthGengoMeiji = entity.getBirthGengoMeiji();
        source.birthGengoTaisho = entity.getBirthGengoTaisho();
        source.birthGengoShowa = entity.getBirthGengoShowa();
        source.age = entity.getAge();
        source.birthYY = entity.getBirthYY();
        source.birthMM = entity.getBirthMM();
        source.birthDD = entity.getBirthDD();
        source.shujiiName = entity.getShujiiName();
        source.iryokikanName = entity.getIryokikanName();
        source.iryokikanNameTel = entity.getIryokikanNameTel();
        source.iryokikanFax = entity.getIryokikanFax();
        source.iryokikanAdress = entity.getIryokikanAdress();
        source.hokenshaNo1 = entity.getHokenshaNo1();
        source.hokenshaNo2 = entity.getHokenshaNo2();
        source.hokenshaNo3 = entity.getHokenshaNo3();
        source.hokenshaNo4 = entity.getHokenshaNo4();
        source.hokenshaNo5 = entity.getHokenshaNo5();
        source.hokenshaNo6 = entity.getHokenshaNo6();
        source.shinseiYMDNo1 = entity.getShinseiYY1();
        source.shinseiYMDNo2 = entity.getShinseiYY2();
        source.shinseiYMDNo3 = entity.getShinseiMM1();
        source.shinseiYMDNo4 = entity.getShinseiMM2();
        source.shinseiYMDNo5 = entity.getShinseiDD1();
        source.shinseiYMDNo6 = entity.getShinseiDD2();
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
        source.oCR2_shinseiYY1 = entity.getShinseiYY1();
        source.oCR2_shinseiYY2 = entity.getShinseiYY2();
        source.oCR2_shinseiMM1 = entity.getShinseiMM1();
        source.oCR2_shinseiMM2 = entity.getShinseiMM2();
        source.oCR2_shinseiD1 = entity.getShinseiDD1();
        source.oCR2_shinseiDD2 = entity.getShinseiDD2();
        source.oCR2_hokenshaNo1 = entity.getHokenshaNo1();
        source.oCR2_hokenshaNo2 = entity.getHokenshaNo2();
        source.oCR2_hokenshaNo3 = entity.getHokenshaNo3();
        source.oCR2_hokenshaNo4 = entity.getHokenshaNo4();
        source.oCR2_hokenshaNo5 = entity.getHokenshaNo5();
        source.oCR2_hokenshaNo6 = entity.getHokenshaNo6();
        source.oCR2_hihokenshaNo1 = entity.getHihokenshaNo1();
        source.oCR2_hihokenshaNo2 = entity.getHihokenshaNo2();
        source.oCR2_hihokenshaNo3 = entity.getHihokenshaNo3();
        source.oCR2_hihokenshaNo4 = entity.getHihokenshaNo4();
        source.oCR2_hihokenshaNo5 = entity.getHihokenshaNo5();
        source.oCR2_hihokenshaNo6 = entity.getHihokenshaNo6();
        source.oCR2_hihokenshaNo7 = entity.getHihokenshaNo7();
        source.oCR2_hihokenshaNo8 = entity.getHihokenshaNo8();
        source.oCR2_hihokenshaNo9 = entity.getHihokenshaNo9();
        source.oCR2_hihokenshaNo10 = entity.getHihokenshaNo10();
        source.oCR2_shinseishaNameKana = entity.getHihokenshaNameKana();
        source.oCR2_shinseishaYubinNo = entity.getYubinNo();
        source.oCR2_shinseishaTelNo = entity.getHihokenshaTel();
        source.oCR2_seibetsuMan = entity.getSeibetsuMan();
        source.oCR2_shinseishaName = entity.getHihokenshaName();
        source.oCR2_shinseishaJusho = entity.getJusho();
        source.oCR2_seibetsuWoman = entity.getSeibetsuWoman();
        source.oCR2_meiji = entity.getBirthGengoMeiji();
        source.oCR2_taisho = entity.getBirthGengoTaisho();
        source.oCR2_showa = entity.getBirthGengoShowa();
        source.oCR2_birthDD = entity.getBirthDD();
        source.oCR2_birthMM = entity.getBirthMM();
        source.oCR2_birthYY = entity.getBirthYY();
        source.oCR2_age = entity.getAge();
        source.oCR2_shujiiName = entity.getShujiiName();
        source.oCR2_iryokikanName = entity.getIryokikanName();
        source.oCR2_iryokikanTelNo = entity.getIryokikanNameTel();
        source.oCR2_iryokikanJusho = entity.getIryokikanAdress();
        source.oCR2_iryokikanFaxNo = entity.getIryokikanFax();
        source.oCR4_shinseiYY1 = entity.getShinseiYY1();
        source.oCR4_shinseiYY2 = entity.getShinseiYY2();
        source.oCR4_shinseiMM1 = entity.getShinseiMM1();
        source.oCR4_shinseiMM2 = entity.getShinseiMM2();
        source.oCR4_shinseiDD1 = entity.getShinseiDD1();
        source.oCR4_shinseiDD2 = entity.getShinseiDD2();
        source.oCR4_hokenshaNo1 = entity.getHokenshaNo1();
        source.oCR4_hokenshaNo2 = entity.getHokenshaNo1();
        source.oCR4_hokenshaNo3 = entity.getHokenshaNo1();
        source.oCR4_hokenshaNo4 = entity.getHokenshaNo4();
        source.oCR4_hokenshaNo5 = entity.getHokenshaNo5();
        source.oCR4_hokenshaNo6 = entity.getHokenshaNo6();
        source.oCR4_hihokenshaNo1 = entity.getHihokenshaNo1();
        source.oCR4_hihokenshaNo2 = entity.getHihokenshaNo2();
        source.oCR4_hihokenshaNo3 = entity.getHihokenshaNo3();
        source.oCR4_hihokenshaNo4 = entity.getHihokenshaNo4();
        source.oCR4_hihokenshaNo5 = entity.getHihokenshaNo5();
        source.oCR4_hihokenshaNo6 = entity.getHihokenshaNo6();
        source.oCR4_hihokenshaNo7 = entity.getHihokenshaNo7();
        source.oCR4_hihokenshaNo8 = entity.getHihokenshaNo8();
        source.oCR4_hihokenshaNo9 = entity.getHihokenshaNo9();
        source.oCR4_hihokenshaNo10 = entity.getHihokenshaNo10();
        return source;
    }

}

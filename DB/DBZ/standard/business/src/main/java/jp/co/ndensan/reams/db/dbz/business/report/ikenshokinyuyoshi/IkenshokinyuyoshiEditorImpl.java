/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ikenshokinyuyoshi;

import jp.co.ndensan.reams.db.dbz.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshokinyuyoshi.IkenshokinyuyoshiReportSource;

/**
 * 要介護認定主治医意見書記入用紙のEditorです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiEditorImpl implements IIkenshokinyuyoshiEditor {

    private final IkenshokinyuyoshiBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link IkenshokinyuyoshiBusiness}
     */
    protected IkenshokinyuyoshiEditorImpl(IkenshokinyuyoshiBusiness business) {
        this.business = business;
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
        source.hihokenshaKana = business.getHihokenshaNameKana();
        source.yubinNo = business.getYubinNo();
        source.seibetsuMan = business.getSeibetsuMan();
        source.jusho = business.getJusho();
        source.hihokenshaName = business.getHihokenshaName();
        source.seibetsuWoman = business.getSeibetsuWoman();
        source.hihokenshaTel = business.getHihokenshaTel();
        source.birthGengoMeiji = business.getBirthGengoMeiji();
        source.birthGengoTaisho = business.getBirthGengoTaisho();
        source.birthGengoShowa = business.getBirthGengoShowa();
        source.age = business.getAge();
        source.birthYY = business.getBirthYY();
        source.birthMM = business.getBirthMM();
        source.birthDD = business.getBirthDD();
        source.shujiiName = business.getShujiiName();
        source.iryokikanName = business.getIryokikanName();
        source.iryokikanNameTel = business.getIryokikanNameTel();
        source.iryokikanFax = business.getIryokikanFax();
        source.iryokikanAdress = business.getIryokikanAdress();
        source.hokenshaNo1 = business.getHokenshaNo1();
        source.hokenshaNo2 = business.getHokenshaNo2();
        source.hokenshaNo3 = business.getHokenshaNo3();
        source.hokenshaNo4 = business.getHokenshaNo4();
        source.hokenshaNo5 = business.getHokenshaNo5();
        source.hokenshaNo6 = business.getHokenshaNo6();
        source.shinseiYMDNo1 = business.getShinseiYY1();
        source.shinseiYMDNo2 = business.getShinseiYY2();
        source.shinseiYMDNo3 = business.getShinseiMM1();
        source.shinseiYMDNo4 = business.getShinseiMM2();
        source.shinseiYMDNo5 = business.getShinseiDD1();
        source.shinseiYMDNo6 = business.getShinseiDD2();
        source.hihokenshaNo1 = business.getHihokenshaNo1();
        source.hihokenshaNo2 = business.getHihokenshaNo2();
        source.hihokenshaNo3 = business.getHihokenshaNo3();
        source.hihokenshaNo4 = business.getHihokenshaNo4();
        source.hihokenshaNo5 = business.getHihokenshaNo5();
        source.hihokenshaNo6 = business.getHihokenshaNo6();
        source.hihokenshaNo7 = business.getHihokenshaNo7();
        source.hihokenshaNo8 = business.getHihokenshaNo8();
        source.hihokenshaNo9 = business.getHihokenshaNo9();
        source.hihokenshaNo10 = business.getHihokenshaNo10();
        source.oCR2_shinseiYY1 = business.getShinseiYY1();
        source.oCR2_shinseiYY2 = business.getShinseiYY2();
        source.oCR2_shinseiMM1 = business.getShinseiMM1();
        source.oCR2_shinseiMM2 = business.getShinseiMM2();
        source.oCR2_shinseiD1 = business.getShinseiDD1();
        source.oCR2_shinseiDD2 = business.getShinseiDD2();
        source.oCR2_hokenshaNo1 = business.getHokenshaNo1();
        source.oCR2_hokenshaNo2 = business.getHokenshaNo2();
        source.oCR2_hokenshaNo3 = business.getHokenshaNo3();
        source.oCR2_hokenshaNo4 = business.getHokenshaNo4();
        source.oCR2_hokenshaNo5 = business.getHokenshaNo5();
        source.oCR2_hokenshaNo6 = business.getHokenshaNo6();
        source.oCR2_hihokenshaNo1 = business.getHihokenshaNo1();
        source.oCR2_hihokenshaNo2 = business.getHihokenshaNo2();
        source.oCR2_hihokenshaNo3 = business.getHihokenshaNo3();
        source.oCR2_hihokenshaNo4 = business.getHihokenshaNo4();
        source.oCR2_hihokenshaNo5 = business.getHihokenshaNo5();
        source.oCR2_hihokenshaNo6 = business.getHihokenshaNo6();
        source.oCR2_hihokenshaNo7 = business.getHihokenshaNo7();
        source.oCR2_hihokenshaNo8 = business.getHihokenshaNo8();
        source.oCR2_hihokenshaNo9 = business.getHihokenshaNo9();
        source.oCR2_hihokenshaNo10 = business.getHihokenshaNo10();
        source.oCR2_shinseishaNameKana = business.getHihokenshaNameKana();
        source.oCR2_shinseishaYubinNo = business.getYubinNo();
        source.oCR2_shinseishaTelNo = business.getHihokenshaTel();
        source.oCR2_seibetsuMan = business.getSeibetsuMan();
        source.oCR2_shinseishaName = business.getHihokenshaName();
        source.oCR2_shinseishaJusho = business.getJusho();
        source.oCR2_seibetsuWoman = business.getSeibetsuWoman();
        source.oCR2_meiji = business.getBirthGengoMeiji();
        source.oCR2_taisho = business.getBirthGengoTaisho();
        source.oCR2_showa = business.getBirthGengoShowa();
        source.oCR2_birthDD = business.getBirthDD();
        source.oCR2_birthMM = business.getBirthMM();
        source.oCR2_birthYY = business.getBirthYY();
        source.oCR2_age = business.getAge();
        source.oCR2_shujiiName = business.getShujiiName();
        source.oCR2_iryokikanName = business.getIryokikanName();
        source.oCR2_iryokikanTelNo = business.getIryokikanNameTel();
        source.oCR2_iryokikanJusho = business.getIryokikanAdress();
        source.oCR2_iryokikanFaxNo = business.getIryokikanFax();
        source.oCR4_shinseiYY1 = business.getShinseiYY1();
        source.oCR4_shinseiYY2 = business.getShinseiYY2();
        source.oCR4_shinseiMM1 = business.getShinseiMM1();
        source.oCR4_shinseiMM2 = business.getShinseiMM2();
        source.oCR4_shinseiDD1 = business.getShinseiDD1();
        source.oCR4_shinseiDD2 = business.getShinseiDD2();
        source.oCR4_hokenshaNo1 = business.getHokenshaNo1();
        source.oCR4_hokenshaNo2 = business.getHokenshaNo2();
        source.oCR4_hokenshaNo3 = business.getHokenshaNo3();
        source.oCR4_hokenshaNo4 = business.getHokenshaNo4();
        source.oCR4_hokenshaNo5 = business.getHokenshaNo5();
        source.oCR4_hokenshaNo6 = business.getHokenshaNo6();
        source.oCR4_hihokenshaNo1 = business.getHihokenshaNo1();
        source.oCR4_hihokenshaNo2 = business.getHihokenshaNo2();
        source.oCR4_hihokenshaNo3 = business.getHihokenshaNo3();
        source.oCR4_hihokenshaNo4 = business.getHihokenshaNo4();
        source.oCR4_hihokenshaNo5 = business.getHihokenshaNo5();
        source.oCR4_hihokenshaNo6 = business.getHihokenshaNo6();
        source.oCR4_hihokenshaNo7 = business.getHihokenshaNo7();
        source.oCR4_hihokenshaNo8 = business.getHihokenshaNo8();
        source.oCR4_hihokenshaNo9 = business.getHihokenshaNo9();
        source.oCR4_hihokenshaNo10 = business.getHihokenshaNo10();
        return source;
    }
}

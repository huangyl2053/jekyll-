/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ikenshokinyuyoshi;

import jp.co.ndensan.reams.db.dbz.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshokinyuyoshi.IkenshokinyuyoshiReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;

/**
 * 要介護認定主治医意見書記入用紙OCRー表のEditorです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiOCRomoteEditorImpl implements IIkenshokinyuyoshiOCREditor {

    private final IkenshokinyuyoshiBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link IkenshokinyuyoshiBusiness}
     */
    protected IkenshokinyuyoshiOCRomoteEditorImpl(IkenshokinyuyoshiBusiness business) {
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
        source.layout = Layouts.鑑;
        return source;
    }
}

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
 * 要介護認定主治医意見書記入用紙OCRー裏のEditorです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiOCRuraEditorImpl implements IIkenshokinyuyoshiOCREditor {

    private final IkenshokinyuyoshiBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link IkenshokinyuyoshiBusiness}
     */
    protected IkenshokinyuyoshiOCRuraEditorImpl(IkenshokinyuyoshiBusiness business) {
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
        source.layout = Layouts.必須;
        return source;
    }
}

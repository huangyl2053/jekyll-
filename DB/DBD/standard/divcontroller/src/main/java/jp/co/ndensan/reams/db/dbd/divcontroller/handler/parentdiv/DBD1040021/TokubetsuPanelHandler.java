/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1040021;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021.TokubetsuPanelDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別地域加算軽減実績管理リスト画面のHandlerです。
 *
 * @reamsid_L DBD-3880-010 xuejm
 */
public class TokubetsuPanelHandler {

    private final TokubetsuPanelDiv div;
    private static final RString 住所 = new RString("1");
    private static final RString 行政区 = new RString("2");
    private static final RString 地区 = new RString("3");

    /**
     * 特別地域加算軽減実績管理リスト
     *
     * @param div TokubetsuPanelDiv
     */
    public TokubetsuPanelHandler(TokubetsuPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * onLoad
     */
    public void onLoad() {
        ShichosonSecurityJoho shichosonsecurityjoho
                = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonsecurityjoho != null && shichosonsecurityjoho.get導入形態コード() != null) {
            if (shichosonsecurityjoho.get導入形態コード().is広域()) {
                div.getChushutsuJoken4().setEraseBorder(false);
                div.getChushutsuJoken().setDisplayNone(true);
                div.getShichosonPanel().setDisplayNone(false);
            } else {
                div.getChushutsuJoken4().setEraseBorder(false);
                div.getShichosonPanel().setDisplayNone(true);
                div.getChushutsuJoken().setDisplayNone(false);
                set地区DDL非表示();
            }
        } else {
            throw new ApplicationException("市町村セキュリティ情報の取得に失敗しました。");
        }
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200012.getReportId());
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護事務);
    }

    /**
     * 画面のHandlerの地区DDLを操作
     *
     * onChange_ddlChiku
     */
    public void onChange_ddlChiku() {
        if (div.getChushutsuJoken().getDdlChiku().getSelectedKey().equals(住所)) {
            div.getChushutsuJoken().getCcdJyuusyoStart().setDisplayNone(false);
            div.getChushutsuJoken().getCcdJyuusyoEnd().setDisplayNone(false);
            div.getChushutsuJoken().getCcdChikuStart().setDisplayNone(true);
            div.getChushutsuJoken().getCcdChikuEnd().setDisplayNone(true);
            div.getChushutsuJoken().getCcdGyouseiStart().setDisplayNone(true);
            div.getChushutsuJoken().getCcdGyouseiEnd().setDisplayNone(true);
            div.getChushutsuJoken().getLblJushoKara().setDisplayNone(false);
            div.getChushutsuJoken().getLblChiku2Kara().setDisplayNone(true);
            div.getChushutsuJoken().getLblGyoseikuKara().setDisplayNone(true);
        } else if (div.getChushutsuJoken().getDdlChiku().getSelectedKey().equals(行政区)) {
            div.getChushutsuJoken().getCcdGyouseiStart().setDisplayNone(false);
            div.getChushutsuJoken().getCcdGyouseiEnd().setDisplayNone(false);
            div.getChushutsuJoken().getCcdJyuusyoStart().setDisplayNone(true);
            div.getChushutsuJoken().getCcdJyuusyoEnd().setDisplayNone(true);
            div.getChushutsuJoken().getCcdChikuStart().setDisplayNone(true);
            div.getChushutsuJoken().getCcdChikuEnd().setDisplayNone(true);
            div.getChushutsuJoken().getLblGyoseikuKara().setDisplayNone(false);
            div.getChushutsuJoken().getLblChiku2Kara().setDisplayNone(true);
            div.getChushutsuJoken().getLblJushoKara().setDisplayNone(true);
        } else if (div.getChushutsuJoken().getDdlChiku().getSelectedKey().equals(地区)) {
            div.getChushutsuJoken().getCcdChikuStart().setDisplayNone(false);
            div.getChushutsuJoken().getCcdChikuEnd().setDisplayNone(false);
            div.getChushutsuJoken().getCcdGyouseiStart().setDisplayNone(true);
            div.getChushutsuJoken().getCcdGyouseiEnd().setDisplayNone(true);
            div.getChushutsuJoken().getCcdJyuusyoStart().setDisplayNone(true);
            div.getChushutsuJoken().getCcdJyuusyoEnd().setDisplayNone(true);
            div.getChushutsuJoken().getLblChiku2Kara().setDisplayNone(false);
            div.getChushutsuJoken().getLblGyoseikuKara().setDisplayNone(true);
            div.getChushutsuJoken().getLblJushoKara().setDisplayNone(true);
        } else {
            set地区DDL非表示();
        }
    }

    /**
     * 画面のHandlerのset活性
     *
     */
    public void set地区DDL非表示() {
        div.getChushutsuJoken().getCcdChikuStart().setDisplayNone(true);
        div.getChushutsuJoken().getCcdChikuEnd().setDisplayNone(true);
        div.getChushutsuJoken().getCcdGyouseiStart().setDisplayNone(true);
        div.getChushutsuJoken().getCcdGyouseiEnd().setDisplayNone(true);
        div.getChushutsuJoken().getCcdJyuusyoStart().setDisplayNone(true);
        div.getChushutsuJoken().getCcdJyuusyoEnd().setDisplayNone(true);
        div.getChushutsuJoken().getLblChiku2Kara().setDisplayNone(true);
        div.getChushutsuJoken().getLblGyoseikuKara().setDisplayNone(true);
        div.getChushutsuJoken().getLblJushoKara().setDisplayNone(true);
    }
}

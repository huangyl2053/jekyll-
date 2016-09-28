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
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChikuNyuryokuGuide.ChikuNyuryokuGuideDiv;
import jp.co.ndensan.reams.ur.urz.definition.core.chiku.ChikuShubetsu;
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
                div.getChushutsuJoken4().setEraseBorder(true);
                div.getChushutsuJoken().setVisible(false);
            } else {
                div.getChushutsuJoken4().setEraseBorder(true);
                div.getShichosonPanel().setVisible(false);
                div.getBtnChikuGyoseikuCodeFrom().setDisplayNone(true);
                div.getBtnChikuGyoseikuCodeTo().setDisplayNone(true);
                div.getBtnChikuJushoCodeFrom().setDisabled(true);
                div.getBtnChikuJushoCodeTo().setDisabled(true);
            }
        } else {
            throw new ApplicationException("市町村セキュリティ情報の取得に失敗しました。");
        }
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200012.getReportId());
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護事務);
        clearvalue();
    }

    /**
     * 画面のHandlerの地区DDLを操作
     *
     * onChange_ddlChiku
     */
    public void onChange_ddlChiku() {
        if (div.getChushutsuJoken().getDdlChiku().getSelectedKey().equals(住所)) {
            div.getBtnChikuJushoCodeFrom().setDisplayNone(false);
            div.getBtnChikuJushoCodeTo().setDisplayNone(false);
            div.getTxtChikuCodeFrom().setDisabled(false);
            div.getTxtChikuCodeTo().setDisabled(false);
            div.getBtnChikuGyoseikuCodeFrom().setDisplayNone(true);
            div.getBtnChikuGyoseikuCodeTo().setDisplayNone(true);
            div.getBtnChikuJushoCodeFrom().setDisabled(false);
            div.getBtnChikuJushoCodeTo().setDisabled(false);
            clearvalue();
        } else if (div.getChushutsuJoken().getDdlChiku().getSelectedKey().equals(行政区)) {
            div.getBtnChikuJushoCodeFrom().setDisplayNone(true);
            div.getBtnChikuJushoCodeTo().setDisplayNone(true);
            div.getBtnChikuGyoseikuCodeFrom().setDisplayNone(false);
            div.getBtnChikuGyoseikuCodeTo().setDisplayNone(false);
            div.getBtnChikuGyoseikuCodeFrom().setDisabled(false);
            div.getBtnChikuGyoseikuCodeTo().setDisabled(false);
            div.getTxtChikuCodeFrom().setDisabled(false);
            div.getTxtChikuCodeTo().setDisabled(false);
            clearvalue();
            div.setHdnChikuShubetsuName(ChikuShubetsu.行政区.getShubetsu());
            div.setHdnIsMultiSelected(new RString(ChikuNyuryokuGuideDiv.SelectableType.Single.toString()));
        } else if (div.getChushutsuJoken().getDdlChiku().getSelectedKey().equals(地区)) {
            div.getTxtChikuCodeFrom().setDisabled(false);
            div.getTxtChikuCodeTo().setDisabled(false);
            set活性();
            clearvalue();
        } else {
            set活性();
            clearvalue();
        }
    }

    /**
     * 画面のHandlerのclearvalue
     *
     * cleartext
     */
    public void clearvalue() {
        div.getTxtChikuCodeFrom().clearValue();
        div.getTxtChikuCodeTo().clearValue();
        div.getTxtChikuNameFrom().clearValue();
        div.getTxtChikuNameTo().clearValue();
    }

    /**
     * 画面のHandlerのset活性
     *
     * set活性
     */
    public void set活性() {
        div.getBtnChikuGyoseikuCodeFrom().setDisabled(true);
        div.getBtnChikuGyoseikuCodeTo().setDisabled(true);
        div.getBtnChikuJushoCodeFrom().setDisabled(true);
        div.getBtnChikuJushoCodeTo().setDisabled(true);
    }
}

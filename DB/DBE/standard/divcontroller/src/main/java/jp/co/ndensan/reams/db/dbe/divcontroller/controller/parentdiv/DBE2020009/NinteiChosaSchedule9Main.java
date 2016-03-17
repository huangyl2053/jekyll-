/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2020009;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho.ChikuShichosonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho.JiKanKanRiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho.JiMuSyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho.NinteichosaScheduleBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo.ChosaSchedulehyoReportJoho;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriReportJoho;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinReportJoho;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosaitakusakijoho.JiKanKanRiParameter;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosaitakusakijoho.JiMuSyoParameter;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosaitakusakijoho.NinteichosaScheduleParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020009.DBE2020009StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020009.NinteiChosaSchedule9MainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020009.NinteiChosaSchedule9MainHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ninteichosaitakusakijoho.NinteichosaItakusakiJohoFinder;
import jp.co.ndensan.reams.db.dbe.service.report.chosaschedulehyo.ChosaSchedulehyoPrintService;
import jp.co.ndensan.reams.db.dbe.service.report.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriPrintService;
import jp.co.ndensan.reams.db.dbe.service.report.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinPrintService;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 認定調査スケジュール登録9のコントローラです。
 */
public class NinteiChosaSchedule9Main {

    private final NinteichosaItakusakiJohoFinder ninteichosaItakusakiJohoFinder;
    private final RString 調査員 = new RString("0");
    private final RString 事務所 = new RString("1");

    /**
     * コンストラクタです。
     */
    public NinteiChosaSchedule9Main() {
        ninteichosaItakusakiJohoFinder = NinteichosaItakusakiJohoFinder.createInstance();
    }

    /**
     * 画面初期化処理です。
     *
     * @param div NinteiChosaSchedule9MainDiv
     * @return ResponseData<NinteiChosaSchedule9MainDiv>
     */
    public ResponseData<NinteiChosaSchedule9MainDiv> onLoad(NinteiChosaSchedule9MainDiv div) {
        RString 地区コード = new RString("00003");
        List<ChikuShichosonBusiness> chikuShichosonList = 市町村リスト(地区コード);
        getHandler(div).load(地区コード, chikuShichosonList);
        return ResponseData.of(div).setState(DBE2020009StateName.初期化);
    }

    /**
     * 対象地区DDL。
     *
     * @param div NinteiChosaSchedule9MainDiv
     * @return ResponseData<NinteiChosaSchedule9MainDiv>
     */
    public ResponseData<NinteiChosaSchedule9MainDiv> onChange_ddlTaishoChiku(NinteiChosaSchedule9MainDiv div) {

        List<ChikuShichosonBusiness> chikuShichosonList = 市町村リスト(div.
                getPrintConditionPanel().getDdlTaishoChiku().getSelectedKey());
        getHandler(div).市町村リストの設定(chikuShichosonList);
        return ResponseData.of(div).respond();
    }

    /**
     * 対象市町村DDL。
     *
     * @param div NinteiChosaSchedule9MainDiv
     * @return ResponseData<NinteiChosaSchedule9MainDiv>
     */
    public ResponseData<NinteiChosaSchedule9MainDiv> onChange_ddlTaishoShichoson(NinteiChosaSchedule9MainDiv div) {

        List<NinteichosaItakusakiJoho> 対象認定調査員所属機関 = 対象認定調査員所属機関(new LasdecCode(div.getPrintConditionPanel().getDdlTaishoShichoson().getSelectedKey()));
        getHandler(div).対象認定調査員所属機関の設定(対象認定調査員所属機関);
        return ResponseData.of(div).respond();
    }

    /**
     * 対象認定調査員所属機関DDL。
     *
     * @param div NinteiChosaSchedule9MainDiv
     * @return ResponseData<NinteiChosaSchedule9MainDiv>
     */
    public ResponseData<NinteiChosaSchedule9MainDiv> onChange_ddlTaishoNinteiChosainShozokuKikan(NinteiChosaSchedule9MainDiv div) {

        List<ChosainJoho> 対象認定調査員 = 対象認定調査員(new LasdecCode(div.getPrintConditionPanel().getDdlTaishoShichoson().getSelectedKey()),
                new ChosaItakusakiCode(div.getPrintConditionPanel().getDdlTaishoNinteiChosainShozokuKikan().getSelectedKey()));
        getHandler(div).対象認定調査員の設定(対象認定調査員);
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件をクリアする」ボタン。
     *
     * @param div NinteiChosaSchedule9MainDiv
     * @return ResponseData<NinteiChosaSchedule9MainDiv>
     */
    public ResponseData<NinteiChosaSchedule9MainDiv> onClick_clear(NinteiChosaSchedule9MainDiv div) {

        getHandler(div).条件をクリア();
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタン押下の場合、帳票を印刷します。
     *
     * @param div 画面情報
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> btnPrint(NinteiChosaSchedule9MainDiv div) {
        div.getCcdKanryoMessage().setSuccessMessage(
                new RString(UrInformationMessages.正常終了.getMessage().
                        replace("発行").evaluate()), RString.EMPTY, RString.EMPTY);
        div.getBtnClear().setDisplayNone(true);
        if (調査員.equals(div.getPrintConditionPanel().getRadPrintselect().getSelectedKey())) {
            return ResponseData.of(new ChosaSchedulehyoTyousayinPrintService().
                    print(ceratePrint_調査員(div, get調査員(div)))).setState(DBE2020009StateName.印刷);
        }
        if (事務所.equals(div.getPrintConditionPanel().getRadPrintselect().getSelectedKey())) {
            return ResponseData.of(new ChosaSchedulehyoPrintService().
                    print(ceratePrint_事務所(div, get事務所(div)))).setState(DBE2020009StateName.印刷);
        }
        return ResponseData.of(new ChosaSchedulehyoJikankanriPrintService().
                print(ceratePrint_時間管理(div, get時間管理(div)))).setState(DBE2020009StateName.印刷);
    }

    private ChosaSchedulehyoTyousayinReportJoho ceratePrint_調査員(NinteiChosaSchedule9MainDiv div,
            List<NinteichosaScheduleBusiness> businessList) {
        return new ChosaSchedulehyoTyousayinReportJoho(getHandler(div).
                createHeadItemItem_調査員(businessList), getHandler(div).createBodyItem_調査員(businessList));
    }

    private ChosaSchedulehyoReportJoho ceratePrint_事務所(NinteiChosaSchedule9MainDiv div, List<JiMuSyoBusiness> businessList) {
        return new ChosaSchedulehyoReportJoho(getHandler(div).createHeadItemItem_事務所(businessList),
                getHandler(div).createBodyItem_事務所(businessList));
    }

    private ChosaSchedulehyoJikankanriReportJoho ceratePrint_時間管理(NinteiChosaSchedule9MainDiv div,
            List<JiKanKanRiBusiness> businessList) {
        return new ChosaSchedulehyoJikankanriReportJoho(getHandler(div).
                createHeadItemItem_時間管理(businessList), getHandler(div).createBodyItem_時間管理(businessList));
    }

    private NinteiChosaSchedule9MainHandler getHandler(NinteiChosaSchedule9MainDiv div) {
        return new NinteiChosaSchedule9MainHandler(div);
    }

    private List<ChikuShichosonBusiness> 市町村リスト(RString 地区コード) {

        return ninteichosaItakusakiJohoFinder.get市町村リスト(地区コード).records();
    }

    private List<NinteichosaScheduleBusiness> get調査員(NinteiChosaSchedule9MainDiv div) {

        return ninteichosaItakusakiJohoFinder.get調査員(NinteichosaScheduleParameter.
                createParam_common(
                        div.getPrintConditionPanel().getDdlTaishoChiku().getSelectedKey(),
                        div.getPrintConditionPanel().getDdlTaishoShichoson().getSelectedKey(),
                        div.getPrintConditionPanel().getDdlTaishoNinteiChosainShozokuKikan().getSelectedKey(),
                        div.getPrintConditionPanel().getDdlTaishoNinteiChosain().getSelectedKey(),
                        div.getPrintConditionPanel().getRadJokyo().getSelectedKey(),
                        div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDFrom() == null ? RString.EMPTY
                        : new RString(div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDFrom().getValue().toString()),
                        div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDTo() == null ? RString.EMPTY
                        : new RString(div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDTo().getValue().toString()),
                        false,
                        false,
                        false,
                        false)).records();
    }

    private List<JiMuSyoBusiness> get事務所(NinteiChosaSchedule9MainDiv div) {

        return ninteichosaItakusakiJohoFinder.get事務所(JiMuSyoParameter.
                createParam_common(
                        // TODO 画面で入力した設定年月の月初日付 QA内部番号846
                        div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDFrom() == null ? RString.EMPTY
                        : new RString(div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDFrom().getValue().toString()),
                        // TODO 画面で入力した設定年月の月末日付 QA内部番号846
                        div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDTo() == null ? RString.EMPTY
                        : new RString(div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDTo().getValue().toString()),
                        div.getPrintConditionPanel().getDdlTaishoChiku().getSelectedKey(),
                        div.getPrintConditionPanel().getDdlTaishoNinteiChosainShozokuKikan().getSelectedKey(),
                        div.getPrintConditionPanel().getDdlTaishoNinteiChosain().getSelectedKey(),
                        false,
                        false)).records();
    }

    private List<JiKanKanRiBusiness> get時間管理(NinteiChosaSchedule9MainDiv div) {

        return ninteichosaItakusakiJohoFinder.get時間管理(JiKanKanRiParameter.
                createParam_common(
                        // TODO 画面で入力した設定年月の月初日付 QA内部番号846
                        div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDFrom() == null ? RString.EMPTY
                        : new RString(div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDFrom().getValue().toString()),
                        // TODO 画面で入力した設定年月の月末日付 QA内部番号846
                        div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDTo() == null ? RString.EMPTY
                        : new RString(div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDTo().getValue().toString()),
                        div.getPrintConditionPanel().getDdlTaishoChiku().getSelectedKey(),
                        div.getPrintConditionPanel().getDdlTaishoNinteiChosainShozokuKikan().getSelectedKey(),
                        div.getPrintConditionPanel().getDdlTaishoNinteiChosain().getSelectedKey(),
                        div.getPrintConditionPanel().getDdlTaishoShichoson().getSelectedKey(),
                        false,
                        false,
                        false,
                        false)).records();
    }

    private List<NinteichosaItakusakiJoho> 対象認定調査員所属機関(LasdecCode 市町村コード) {

        return ninteichosaItakusakiJohoFinder.get対象認定調査員所属機関(市町村コード).records();
    }

    private List<ChosainJoho> 対象認定調査員(LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード) {

        return ninteichosaItakusakiJohoFinder.get対象認定調査員(市町村コード, 認定調査委託先コード).records();
    }
}

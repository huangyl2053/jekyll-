/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0330001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChi;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE090001.DBE090001_ShujiiKekkaTsuchiParameter;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0330001.DBE0330001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0330001.YouKaiGoNinTeiKekTesuChiMainPanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0330001.dgResultList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0330001.MainPanelHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.service.core.shishosecurityjoho.ShishoSecurityJoho;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定結果通知（主治医）Divを制御クラスです。
 *
 * @reamsid_L DBE-0220-010 wangkun
 */
public class YouKaiGoNinTeiKekTesuChiMainPanel {

    private static final RString 未出力のみ = new RString("key0");
    private static final RString 未出力のみフラグ = new RString("1");
    private static final RString 未出力のみ以外 = new RString("2");
    private static final RString 希望のみ = new RString("key0");

    /**
     * 要介護認定結果通知（主治医）の初期処理を表示します。
     *
     * @param div YouKaiGoNinTeiKekTesuChiMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<YouKaiGoNinTeiKekTesuChiMainPanelDiv> onLoad(YouKaiGoNinTeiKekTesuChiMainPanelDiv div) {
        div.getCcdShujiiIryokikanAndShujiiInput().initialize(LasdecCode.EMPTY, ShinseishoKanriNo.EMPTY, SubGyomuCode.DBE認定支援);
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);

        div.getSearchConditionPanel().getTxtDispMax().setValue(new Decimal(最大表示件数.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setDisabled(false);
        div.getDgResultList().setDisabled(false);
        div.getDoctorSelectionPanel().getDgDoctorSelection().setDisabled(false);
        return ResponseData.of(div).setState(DBE0330001StateName.照会);
    }

    /**
     * 要介護認定結果通知（主治医）のクリアを処理します。
     *
     * @param div YouKaiGoNinTeiKekTesuChiMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<YouKaiGoNinTeiKekTesuChiMainPanelDiv> onClick_btnClear(YouKaiGoNinTeiKekTesuChiMainPanelDiv div) {
        div.getSearchConditionPanel().getTxtNijiHanteiKikan().clearFromValue();
        div.getSearchConditionPanel().getTxtNijiHanteiKikan().clearToValue();
        div.getCcdShujiiIryokikanAndShujiiInput().initialize(LasdecCode.EMPTY, ShinseishoKanriNo.EMPTY, SubGyomuCode.DBE認定支援);
        div.getRadKekkaTsuchiOutputTaisho().setSelectedKey(希望のみ);
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getSearchConditionPanel().getTxtDispMax().setValue(new Decimal(最大表示件数.toString()));
        return ResponseData.of(div).respond();
    }

    /**
     * 要介護認定結果通知（主治医）の「検索」ボタンが押下します。
     *
     * @param div YouKaiGoNinTeiKekTesuChiMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<YouKaiGoNinTeiKekTesuChiMainPanelDiv> onClick_btnSearch(YouKaiGoNinTeiKekTesuChiMainPanelDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs validPairs = getHandler(div).二次判定期間の前後順チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        boolean 希望のみFlag = false;
        RString dateFrom = RString.EMPTY;
        RString dateTo = RString.EMPTY;
        if (希望のみ.equals(div.getRadKekkaTsuchiOutputTaisho().getSelectedKey())) {
            希望のみFlag = true;
        }
        if (div.getTxtNijiHanteiKikan().getFromValue() != null) {
            dateFrom = div.getTxtNijiHanteiKikan().getFromValue().toDateString();
        }
        if (div.getTxtNijiHanteiKikan().getToValue() != null) {
            dateTo = div.getTxtNijiHanteiKikan().getToValue().toDateString();
        }
        List<YouKaiGoNinTeiKekTesuChi> youKaiGoNinTeiKekTesuChi = YouKaiGoNinTeiKekTesuChiFinder.createInstance()
                .get主治医選択一覧(YouKaiGoNinTeiKekTesuChiMapperParameter
                        .createSelectListParam(dateFrom,
                                dateTo,
                                div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode(),
                                div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode(), false, 希望のみFlag)).records();
        if (youKaiGoNinTeiKekTesuChi.isEmpty()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        getHandler(div).edit主治医選択一覧情報(youKaiGoNinTeiKekTesuChi);
        return ResponseData.of(div).setState(DBE0330001StateName.主治医選択一覧);
    }

    /**
     * 主治医選択一覧の「選択」ボタンが押下します。
     *
     * @param div YouKaiGoNinTeiKekTesuChiMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<YouKaiGoNinTeiKekTesuChiMainPanelDiv> onClick_SelectByButton(YouKaiGoNinTeiKekTesuChiMainPanelDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        boolean 希望のみFlag = false;
        if (希望のみ.equals(div.getRadKekkaTsuchiOutputTaisho().getSelectedKey())) {
            希望のみFlag = true;
        }
        RString dateFrom = RString.EMPTY;
        RString dateTo = RString.EMPTY;
        if (div.getTxtNijiHanteiKikan().getFromValue() != null) {
            dateFrom = div.getTxtNijiHanteiKikan().getFromValue().toDateString();
        }
        if (div.getTxtNijiHanteiKikan().getToValue() != null) {
            dateTo = div.getTxtNijiHanteiKikan().getToValue().toDateString();
        }
        RString 主治医医療機関コード = div.getDoctorSelectionPanel().getDgDoctorSelection().getActiveRow().getShujiiIryokikanCode();
        RString 主治医コード = div.getDoctorSelectionPanel().getDgDoctorSelection().getActiveRow().getDoctorCode();
        List<YouKaiGoNinTeiKekTesuChi> youKaiGoNinTeiKekTesuChi = YouKaiGoNinTeiKekTesuChiFinder.createInstance()
                .get結果通知出力対象申請者一覧(YouKaiGoNinTeiKekTesuChiMapperParameter
                        .createSelectListParam(dateFrom,
                                dateTo,
                                主治医医療機関コード, 主治医コード, false, 希望のみFlag)).records();
        if (youKaiGoNinTeiKekTesuChi.isEmpty()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        getHandler(div).edit結果通知出力対象申請者一覧情報(youKaiGoNinTeiKekTesuChi);
        return ResponseData.of(div).setState(DBE0330001StateName.一覧);
    }

    /**
     * 「再検索」ボタンが押下します。
     *
     * @param div YouKaiGoNinTeiKekTesuChiMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<YouKaiGoNinTeiKekTesuChiMainPanelDiv> onClick_btnSaiKenSaku(YouKaiGoNinTeiKekTesuChiMainPanelDiv div) {
        if (!ResponseHolder.isReRequest() && !hasChange(div)) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getPrintPanel().getTxtNinteiJokyoTeikyoYMD().clearValue();
            div.getPrintPanel().getRadPrintCondition().setSelectedIndex(0);
            return ResponseData.of(div).setState(DBE0330001StateName.照会);
        }
        if (ResponseHolder.getState().equals(DBE0330001StateName.主治医選択一覧.getName())) {
            return ResponseData.of(div).setState(DBE0330001StateName.照会);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「結果通知を実行する」ボタンが押下場合、チェックを実行します。
     *
     * @param div YouKaiGoNinTeiKekTesuChiMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<YouKaiGoNinTeiKekTesuChiMainPanelDiv> onClick_btnBatchRegisterCheck(YouKaiGoNinTeiKekTesuChiMainPanelDiv div) {
        if (div.getPrintPanel().getTxtNinteiJokyoTeikyoYMD().getValue() == null) {
            ValidationMessageControlPairs validPairs = getHandler(div).getメッセジー_入力データなし();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        if (div.getDgResultList().getDataSource().isEmpty()) {
            ValidationMessageControlPairs validPairs = getHandler(div).getメッセジー_対象データなし();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        if (div.getDgResultList().getSelectedItems().isEmpty()) {
            ValidationMessageControlPairs validPairs = getHandler(div).getメッセジー_選択されていない();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbeWarningMessages.既に印刷済.getMessage()).respond();
        }
        if (new RString(DbeWarningMessages.既に印刷済.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            onClick_btnBatchRegister(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「結果通知を実行する」ボタンが押下します。
     *
     * @param div YouKaiGoNinTeiKekTesuChiMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<DBE090001_ShujiiKekkaTsuchiParameter> onClick_btnBatchRegister(YouKaiGoNinTeiKekTesuChiMainPanelDiv div) {
        ResponseData<DBE090001_ShujiiKekkaTsuchiParameter> response = new ResponseData<>();
        DBE090001_ShujiiKekkaTsuchiParameter param = new DBE090001_ShujiiKekkaTsuchiParameter();

        param.setNijiHanteiYMDFrom(div.getTxtNijiHanteiKikan().getFromValue() == null
                ? RString.EMPTY : div.getTxtNijiHanteiKikan().getFromValue().toDateString());
        param.setNijiHanteiYMDTo(div.getTxtNijiHanteiKikan().getToValue() == null
                ? RString.EMPTY : div.getTxtNijiHanteiKikan().getToValue().toDateString());
        param.setMaDaNyuRyoKu(未出力のみ以外);
        if (未出力のみ.equals(div.getRadPrintCondition().getSelectedKey())) {
            param.setMaDaNyuRyoKu(未出力のみフラグ);
        }
        RStringBuilder builder = new RStringBuilder(div.getDoctorSelectionPanel().getDgDoctorSelection().getActiveRow().getShujiiIryokikanCode());
        builder.append(div.getDoctorSelectionPanel().getDgDoctorSelection().getActiveRow().getDoctorCode());
        param.setShuJiiJyouHou(builder.toRString());
        param.setNinteiJohoTeikyoYMD(div.getTxtNinteiJokyoTeikyoYMD().getValue().toDateString());
        param.setShinseishoKanriNo(div.getDoctorSelectionPanel().getDgDoctorSelection().getActiveRow().getShinseishoKanriNo());
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        RString 支所コード = RString.EMPTY;
        if (市町村セキュリティ情報.get支所管理有無フラグ()) {
            支所コード = ShishoSecurityJoho.createInstance().getShishoCode(UrControlDataFactory.
                    createInstance().getLoginInfo().getUserId());
        }
        System.out.println(市町村セキュリティ情報.get市町村情報().get市町村識別ID());
        param.setUseShoKisaiHokenshaNo(!市町村セキュリティ情報.get市町村情報().get市町村識別ID().equals(new RString("00")));
        param.setShichosonCode(div.getDoctorSelectionPanel().getDgDoctorSelection().getActiveRow().getShichosonCode());
        param.setShishoCode(支所コード);
        param.setShoKisaiHokenshaNo(市町村セキュリティ情報.get市町村情報().get証記載保険者番号().value());
        response.data = param;
        return response;
    }

    private boolean hasChange(YouKaiGoNinTeiKekTesuChiMainPanelDiv div) {
        List<dgResultList_Row> rowList = div.getDgResultList().getDataSource();
        RStringBuilder rsb = new RStringBuilder();
        for (dgResultList_Row row : rowList) {
            rsb.append(String.valueOf(row.getSelected()));
        }
        return div.getPrintPanel().getHiddenitem().equals(rsb.toRString());
    }

    private MainPanelHandler getHandler(YouKaiGoNinTeiKekTesuChiMainPanelDiv div) {
        return new MainPanelHandler(div);
    }
}

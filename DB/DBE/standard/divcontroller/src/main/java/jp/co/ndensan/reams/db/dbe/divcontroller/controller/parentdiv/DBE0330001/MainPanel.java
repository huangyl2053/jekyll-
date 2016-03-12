/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0330001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChi;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe090001.YouKaiGoNinTeiKekTesuChiFlowParameter;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0330001.MainPanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0330001.MainPanelHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定結果通知（主治医）Divを制御クラスです。
 *
 */
public class MainPanel {
    
    private static final RString 未出力のみ = new RString("key0");
    private static final RString 未出力のみフラグ = new RString("1");
    private static final RString 未出力のみ以外 = new RString("2");
    private static final RString 希望のみ = new RString("key0");

    /**
     * 要介護認定結果通知（主治医）の初期処理を表示します。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {
        div.getCcdShujiiIryokikanAndShujiiInput().setDisabled(false);
        div.getDgResultList().setDisabled(false);
        div.getDoctorSelectionPanel().getDgDoctorSelection().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 要介護認定結果通知（主治医）の「検索」ボタンが押下します。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnSearch(MainPanelDiv div) {
        ValidationMessageControlPairs validPairs = getHandler(div).二次判定期間の前後順チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        boolean 未出力のみFlag = false;
        boolean 希望のみFlag = false;
        RString dateFrom = RString.EMPTY;
        RString dateTo = RString.EMPTY;
        if (未出力のみ.equals(div.getRadPrintCondition().getSelectedKey())) {
            未出力のみFlag = true;
        }
        if (希望のみ.equals(div.getRadPrintCondition().getSelectedKey())) {
            希望のみFlag = true;
        }
        if (div.getTxtNijiHanteiKikan().getFromValue() != null) {
            dateFrom = div.getTxtNijiHanteiKikan().getFromValue().toDateString();
        }
        if (div.getTxtNijiHanteiKikan().getToValue() != null) {
            dateTo = div.getTxtNijiHanteiKikan().getToValue().toDateString();
        }
        // TODO 主治医医療機関コードと主治医コード　QA421を待ち
        List<YouKaiGoNinTeiKekTesuChi> youKaiGoNinTeiKekTesuChi = YouKaiGoNinTeiKekTesuChiFinder.createInstance()
                .get主治医選択一覧(YouKaiGoNinTeiKekTesuChiMapperParameter
                        .createSelectListParam(dateFrom,
                                dateTo,
                                RString.EMPTY, RString.EMPTY, 未出力のみFlag, 希望のみFlag)).records();
        if (youKaiGoNinTeiKekTesuChi.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        
        getHandler(div).edit主治医選択一覧情報(youKaiGoNinTeiKekTesuChi);
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医選択一覧の「選択」ボタンが押下します。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_SelectByButton(MainPanelDiv div) {
        boolean 未出力のみFlag = false;
        boolean 希望のみFlag = false;
        if (未出力のみ.equals(div.getRadPrintCondition().getSelectedKey())) {
            未出力のみFlag = true;
        }
        if (希望のみ.equals(div.getRadPrintCondition().getSelectedKey())) {
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
                                主治医医療機関コード, 主治医コード, 未出力のみFlag, 希望のみFlag)).records();
        if (youKaiGoNinTeiKekTesuChi.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).edit結果通知出力対象申請者一覧情報(youKaiGoNinTeiKekTesuChi);
        return ResponseData.of(div).respond();
    }

    /**
     * 結果通知を実行する」ボタンが押下場合、チェックを実行します。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnBatchRegisterCheck(MainPanelDiv div) {
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
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<YouKaiGoNinTeiKekTesuChiFlowParameter> onClick_btnBatchRegister(MainPanelDiv div) {
        ResponseData<YouKaiGoNinTeiKekTesuChiFlowParameter> response = new ResponseData<>();
        YouKaiGoNinTeiKekTesuChiFlowParameter param = new YouKaiGoNinTeiKekTesuChiFlowParameter();

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
        // QA 326 支所コード  市町村セキュリティより取得した「証記載保険者番号」
        param.setShishoCode(RString.EMPTY);
        param.setShoKisaiHokenshaNo(new RString("209006"));
        response.data = param;
        return response;
    }

    private MainPanelHandler getHandler(MainPanelDiv div) {
        return new MainPanelHandler(div);
    }
}

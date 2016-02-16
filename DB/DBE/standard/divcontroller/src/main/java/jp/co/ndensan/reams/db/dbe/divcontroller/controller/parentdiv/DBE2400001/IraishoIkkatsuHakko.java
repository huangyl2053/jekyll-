/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2400001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.iraisho.IraishoIkkatsuHakkoResult;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.IraishoIkkatsuHakkoBatchParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.iraisho.IraishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.DBE2400001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.IraishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.dgNinteiChosaIraiTaishoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2400001.IraishoIkkatsuHakkoHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2400001.IraishoIkkatsuHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.iraisho.IraishoIkkatsuHakkoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 依頼書一括発行のコントローラです。
 */
public class IraishoIkkatsuHakko {

    private static final RString SELECTED_KEY0 = new RString("key0");
    private static final RString SELECTED_KEY1 = new RString("key1");
    private static final RString SELECTED_KEY2 = new RString("key2");
    private static final RString STATE_NINTEIO = new RString("1");
    private static final RString STATE_SHUJII = new RString("2");
    private static final RString NO_PRINT = new RString("1");
    private static final RString PRINT = new RString("2");
    private static final RString PRINT_AND_NOPRINT = new RString("3");
    private static final RString SHINSEISHA = new RString("0");
    private static final RString BLANK = new RString("1");
    private static final RString COMMON_DATE = new RString("2");
    private static final RString COMMON_PRINT = new RString("1");
    private static final RString COMMON_NO_PRINT = new RString("0");
    private final IraishoIkkatsuHakkoFinder service;

    /**
     * コンストラクタです。
     *
     */
    public IraishoIkkatsuHakko() {
        service = IraishoIkkatsuHakkoFinder.createInstance();
    }

    /**
     * 依頼書一括発行初期化の設定します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onLoad(IraishoIkkatsuHakkoDiv div) {
        getHandler(div).load(BusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, SubGyomuCode.DBE認定支援));
        return ResponseData.of(div).setState(DBE2400001StateName.認定調査依頼);
    }

    /**
     * 対象選択ラジオボタン選択を設定します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onChange_radTaishoSentaku(IraishoIkkatsuHakkoDiv div) {
        if (SELECTED_KEY0.equals(div.getRadTaishoSentaku().getSelectedKey())) {
            getHandler(div).load(BusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, SubGyomuCode.DBE認定支援));
            return ResponseData.of(div).setState(DBE2400001StateName.認定調査依頼);
        }
        if (SELECTED_KEY1.equals(div.getRadTaishoSentaku().getSelectedKey())) {
            getHandler(div).shuziiiKenshoLoad(BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, SubGyomuCode.DBE認定支援));
            return ResponseData.of(div).setState(DBE2400001StateName.主治医意見書作成依頼);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するボタン押下の場合、一覧を設定します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onClick_btnKensanku(IraishoIkkatsuHakkoDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).iraibiZengoJunCheck());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        List<IraishoIkkatsuHakkoResult> resultList = new ArrayList<>();
        if (STATE_NINTEIO.equals(div.getState())) {
            IraishoIkkatsuHakkoParameter param
                    = IraishoIkkatsuHakkoParameter.createIraishoIkkatsuHakkoParameter(
                            div.getTxtIraibiFrom().getValue(),
                            div.getTxtIraibiTo().getValue(),
                            div.getChkNinteioChosaIraisho().getSelectedKeys(),
                            div.getCommonChildDiv1().getSelectedItem().get証記載保険者番号(),
                            div.getChkNinteiChosahyo().getSelectedKeys(),
                            Collections.<RString>emptyList(),
                            Collections.<RString>emptyList());
            resultList = service.getNinteiChousaIrai(param).records();
        }
        if (STATE_SHUJII.equals(div.getState())) {
            IraishoIkkatsuHakkoParameter param
                    = IraishoIkkatsuHakkoParameter.createIraishoIkkatsuHakkoParameter(
                            div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue(),
                            div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue(),
                            Collections.<RString>emptyList(),
                            div.getCommonChildDiv2().getSelectedItem().get証記載保険者番号(),
                            Collections.<RString>emptyList(),
                            div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys(),
                            div.getChkShujiiIkensho().getSelectedKeys());
            resultList = service.getShuziiIkenshoIrai(param).records();
        }
        getHandler(div).setDataGrid(resultList);
        return ResponseData.of(div).respond();
    }

    /**
     * 申請単位チェックボックス選択の場合、同Div内のチェックボックスの使用可不可を設定します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onChange_chkShinseiTani(IraishoIkkatsuHakkoDiv div) {
        getHandler(div).setChkShinseiTani();
        return ResponseData.of(div).respond();
    }

    /**
     * 提出期限ラジオボタン選択の場合、共通日付txtの使用可否などを設定します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onChange_radTeishutsuKigen(IraishoIkkatsuHakkoDiv div) {
        if (SELECTED_KEY2.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            div.getTxtKyotsuHizuke().setReadOnly(false);
        } else {
            div.getTxtKyotsuHizuke().setReadOnly(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択された帳票を発行するボタン」を押下場合、入力チェックを実行します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onClick_btnCheck(IraishoIkkatsuHakkoDiv div) {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).iraibiZengoJunCheck());
        validationMessages.add(getValidationHandler(div).iraiItiranCheck());
        validationMessages.add(getValidationHandler(div).printChouhyouSentakuCheck());
        validationMessages.add(getValidationHandler(div).commonDateCheck());

        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査依頼発行一覧表バッチを起動します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoBatchParamter> onClick_btnBatchNintei(IraishoIkkatsuHakkoDiv div) {

        IraishoIkkatsuHakkoBatchParamter param = new IraishoIkkatsuHakkoBatchParamter();
        param.setIraiFromYMD(div.getTxtIraibiFrom().getValue() == null
                ? RString.EMPTY : div.getTxtIraibiFrom().getValue().toDateString());
        param.setIraiToYMD(div.getTxtIraibiTo().getValue() == null
                ? RString.EMPTY : div.getTxtIraibiTo().getValue().toDateString());
        param.setHihokenshaNo(div.getCommonChildDiv1().getSelectedItem().get証記載保険者番号().value());
        if (div.getChkNinteioChosaIraisho().getSelectedKeys().size() == 2) {
            param.setNinteioChosaIraisho(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkNinteioChosaIraisho().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setNinteioChosaIraisho(NO_PRINT);
            }
            if (div.getChkNinteioChosaIraisho().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setNinteioChosaIraisho(PRINT);
            }
        }
        if (div.getChkNinteiChosahyo().getSelectedKeys().size() == 2) {
            param.setNinteiChosahyo(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkNinteiChosahyo().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setNinteiChosahyo(NO_PRINT);
            }
            if (div.getChkNinteiChosahyo().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setNinteiChosahyo(PRINT);
            }
        }
        List<RString> ninteiChosaItakusakiCodeList = new ArrayList<>();
        List<RString> ninteiChosainNoList = new ArrayList<>();
        for (dgNinteiChosaIraiTaishoIchiran_Row row : div.getDgNinteiChosaIraiTaishoIchiran().getSelectedItems()) {
            ninteiChosaItakusakiCodeList.add(row.getNinteiChosaitakusaki());
            ninteiChosainNoList.add(row.getNinteiChosainNo());
        }
        param.setNinteiChosaItakusakiCodeList(ninteiChosaItakusakiCodeList);
        param.setNinteiChosainNoList(ninteiChosainNoList);
        setOutputJokenhyoForNinteiChosa(param);
        return ResponseData.of(param).respond();
    }

    /**
     * 主治医意見書作成依頼発行一覧表バッチを起動します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoBatchParamter> onClick_btnBatchSakusei(IraishoIkkatsuHakkoDiv div) {

        IraishoIkkatsuHakkoBatchParamter param = new IraishoIkkatsuHakkoBatchParamter();
        param.setIraiFromYMD(div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue() == null
                ? RString.EMPTY : div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue().toDateString());
        param.setIraiToYMD(div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue() == null
                ? RString.EMPTY : div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue().toDateString());
        param.setHihokenshaNo(div.getCommonChildDiv2().getSelectedItem().get証記載保険者番号().value());
        if (div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys().size() == 2) {
            param.setShujiiikenshoSakuseiIrai(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setShujiiikenshoSakuseiIrai(NO_PRINT);
            }
            if (div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setShujiiikenshoSakuseiIrai(PRINT);
            }
        }
        if (div.getChkShujiiIkensho().getSelectedKeys().size() == 2) {
            param.setShujiiIkensho(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setShujiiIkensho(NO_PRINT);
            }
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setShujiiIkensho(PRINT);
            }
        }
        List<RString> shujiiIryoKikanCodeList = new ArrayList<>();
        List<RString> shujiiCodeList = new ArrayList<>();
        for (dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row row : div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().getSelectedItems()) {
            shujiiIryoKikanCodeList.add(row.getShujiiIryoKikanCode());
            shujiiCodeList.add(row.getIshiNo());
        }
        param.setShujiiIryokikanCodeList(shujiiIryoKikanCodeList);
        param.setShujiiCodeList(shujiiCodeList);
        setOutputJokenhyoForShujii(param);
        return ResponseData.of(param).respond();
    }

    /**
     * 主治医意見書提出依頼書発行バッチを起動します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoBatchParamter> onClick_btnBatchTeishutu(IraishoIkkatsuHakkoDiv div) {

        IraishoIkkatsuHakkoBatchParamter param = new IraishoIkkatsuHakkoBatchParamter();
        setParam(param, div);
        if (SELECTED_KEY0.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(SHINSEISHA);
        }
        if (SELECTED_KEY1.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(BLANK);
        }
        if (SELECTED_KEY2.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(COMMON_DATE);
        }
        param.setKyotsuHizuke(div.getTxtKyotsuHizuke().getValue() == null
                ? RString.EMPTY : div.getTxtKyotsuHizuke().getValue().toDateString());
        param.setIkenshoSakuseiirai(
                div.getChkShujiiIkenshoShutsuryoku().getSelectedKeys().contains(SELECTED_KEY0)
                ? COMMON_PRINT : COMMON_NO_PRINT);
        param.setShujiiIkenshoSakuseiIraisho(
                div.getChkShujiiIkenshoSakuseiIraisho().getSelectedKeys().contains(SELECTED_KEY0)
                ? COMMON_PRINT : COMMON_NO_PRINT);

        param.setIkenshoKinyuu(
                div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().getSelectedKeys().contains(SELECTED_KEY0)
                ? COMMON_PRINT : COMMON_NO_PRINT);
        param.setIkenshoKinyuuOCR(
                div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().getSelectedKeys().contains(SELECTED_KEY1)
                ? COMMON_PRINT : COMMON_NO_PRINT);
        param.setIkenshoSakuseiSeikyuusho(
                div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().getSelectedKeys().contains(SELECTED_KEY2)
                ? COMMON_PRINT : COMMON_NO_PRINT);
        // TODO  内部QA：663 Redmine：#75721(パラメータの整合性を確認、設定しない)
        param.setIkenshoTeishutu(
                !div.getChkShindanMeireishoAndTeishutsuIraisho().getSelectedKeys().isEmpty()
                ? COMMON_PRINT : COMMON_NO_PRINT);

        return ResponseData.of(param).respond();
    }

    private void setParam(IraishoIkkatsuHakkoBatchParamter param, IraishoIkkatsuHakkoDiv div) {
        param.setIraiFromYMD(div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue() == null
                ? RString.EMPTY : div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue().toDateString());
        param.setIraiToYMD(div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue() == null
                ? RString.EMPTY : div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue().toDateString());
        param.setHihokenshaNo(div.getCommonChildDiv2().getSelectedItem().get証記載保険者番号().value());
        if (div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys().size() == 2) {
            param.setShujiiikenshoSakuseiIrai(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setShujiiikenshoSakuseiIrai(NO_PRINT);
            }
            if (div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setShujiiikenshoSakuseiIrai(PRINT);
            }
        }
        if (div.getChkShujiiIkensho().getSelectedKeys().size() == 2) {
            param.setShujiiIkensho(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setShujiiIkensho(NO_PRINT);
            }
            if (div.getChkShujiiIkensho().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setShujiiIkensho(PRINT);
            }
        }
        List<RString> shujiiIryoKikanCodeList = new ArrayList<>();
        List<RString> shujiiCodeList = new ArrayList<>();
        for (dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row row : div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().getSelectedItems()) {
            shujiiIryoKikanCodeList.add(row.getShujiiIryoKikanCode());
            shujiiCodeList.add(row.getIshiNo());
        }
        param.setShujiiIryokikanCodeList(shujiiIryoKikanCodeList);
        param.setShujiiCodeList(shujiiCodeList);
        param.setHakkobi(div.getTxtHakkobi().getValue() == null
                ? RString.EMPTY : div.getTxtHakkobi().getValue().toDateString());
    }

    /**
     * 訪問調査依頼書発行バッチを起動します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoBatchParamter> onClick_btnBatchHoumon(IraishoIkkatsuHakkoDiv div) {

        IraishoIkkatsuHakkoBatchParamter param = new IraishoIkkatsuHakkoBatchParamter();
        param.setIraiFromYMD(div.getTxtIraibiFrom().getValue() == null
                ? RString.EMPTY : div.getTxtIraibiFrom().getValue().toDateString());
        param.setIraiToYMD(div.getTxtIraibiTo().getValue() == null
                ? RString.EMPTY : div.getTxtIraibiTo().getValue().toDateString());
        param.setHihokenshaNo(div.getCommonChildDiv1().getSelectedItem().get証記載保険者番号().value());
        if (div.getChkNinteioChosaIraisho().getSelectedKeys().size() == 2) {
            param.setNinteioChosaIraisho(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkNinteioChosaIraisho().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setNinteioChosaIraisho(NO_PRINT);
            }
            if (div.getChkNinteioChosaIraisho().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setNinteioChosaIraisho(PRINT);
            }
        }
        if (div.getChkNinteiChosahyo().getSelectedKeys().size() == 2) {
            param.setNinteiChosahyo(PRINT_AND_NOPRINT);
        } else {
            if (div.getChkNinteiChosahyo().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setNinteiChosahyo(NO_PRINT);
            }
            if (div.getChkNinteiChosahyo().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setNinteiChosahyo(PRINT);
            }
        }
        List<RString> ninteiChosaItakusakiCodeList = new ArrayList<>();
        List<RString> ninteiChosainNoList = new ArrayList<>();
        for (dgNinteiChosaIraiTaishoIchiran_Row row : div.getDgNinteiChosaIraiTaishoIchiran().getSelectedItems()) {
            ninteiChosaItakusakiCodeList.add(row.getNinteiChosaitakusaki());
            ninteiChosainNoList.add(row.getNinteiChosainNo());
        }
        param.setNinteiChosaItakusakiCodeList(ninteiChosaItakusakiCodeList);
        param.setNinteiChosainNoList(ninteiChosainNoList);

        param.setHakkobi(div.getTxtHakkobi().getValue() == null
                ? RString.EMPTY : div.getTxtHakkobi().getValue().toDateString());
        if (SELECTED_KEY0.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(SHINSEISHA);
        }
        if (SELECTED_KEY1.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(BLANK);
        }
        if (SELECTED_KEY2.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(COMMON_DATE);
        }
        param.setKyotsuHizuke(div.getTxtKyotsuHizuke().getValue() == null
                ? RString.EMPTY : div.getTxtKyotsuHizuke().getValue().toDateString());
        if (div.getChkNinteiChosaIraisho().getSelectedKeys().contains(SELECTED_KEY0)) {
            param.setNinteiChosaIraisyo(COMMON_PRINT);
        } else {
            param.setNinteiChosaIraisyo(COMMON_NO_PRINT);
        }
        if (div.getChkNinteiChosaIraiChohyo().getSelectedKeys().contains(SELECTED_KEY0)) {
            param.setNinteiChosaIraiChohyo(COMMON_PRINT);
        } else {
            param.setNinteiChosaIraiChohyo(COMMON_NO_PRINT);
        }

        return ResponseData.of(param).respond();
    }

    private IraishoIkkatsuHakkoHandler getHandler(IraishoIkkatsuHakkoDiv div) {
        return new IraishoIkkatsuHakkoHandler(div);
    }

    private IraishoIkkatsuHakkoValidationHandler getValidationHandler(IraishoIkkatsuHakkoDiv div) {
        return new IraishoIkkatsuHakkoValidationHandler(div);
    }

    private void setOutputJokenhyoForNinteiChosa(IraishoIkkatsuHakkoBatchParamter param) {
        List<RString> 出力条件 = new ArrayList();

        RString 帳票ID = new RString("DBE220003_ChosaIraiHakkoIchiranhyo");
        RString csv出力有無 = new RString("なし");
        RString csvファイル名 = RString.EMPTY;
        出力条件.add(param.getIraiFromYMD());
        出力条件.add(param.getIraiToYMD());
        出力条件.add(param.getHihokenshaNo());
        出力条件.add(param.getNinteioChosaIraisho());
        出力条件.add(param.getNinteiChosahyo());
        出力条件.add(param.getHakkobi());
        出力条件.add(param.getTeishutsuKigen());
        出力条件.add(param.getKyotsuHizuke());
        for (RString itakusakiCode : param.getNinteiChosaItakusakiCodeList()) {
            出力条件.add(itakusakiCode);
        }
        for (RString chosainNo : param.getNinteiChosainNoList()) {
            出力条件.add(chosainNo);
        }
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        帳票ID,
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString("jodID"),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, 帳票ID),
                        new RString(String.valueOf(0)),
                        csv出力有無,
                        csvファイル名,
                        出力条件
                );
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }

    private void setOutputJokenhyoForShujii(IraishoIkkatsuHakkoBatchParamter param) {
        List<RString> 出力条件 = new ArrayList();

        RString 帳票ID = new RString("DBE230003_IkenshoSakuseiIraiHakkoIchiranhyo");
        RString csv出力有無 = new RString("なし");
        RString csvファイル名 = RString.EMPTY;
        出力条件.add(param.getIraiFromYMD());
        出力条件.add(param.getIraiToYMD());
        出力条件.add(param.getHihokenshaNo());
        出力条件.add(param.getNinteioChosaIraisho());
        出力条件.add(param.getNinteiChosahyo());
        出力条件.add(param.getHakkobi());
        出力条件.add(param.getTeishutsuKigen());
        出力条件.add(param.getKyotsuHizuke());
        for (RString iryoKikanCode : param.getShujiiIryokikanCodeList()) {
            出力条件.add(iryoKikanCode);
        }
        for (RString shujiiCode : param.getShujiiCodeList()) {
            出力条件.add(shujiiCode);
        }
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        帳票ID,
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString("jodID"),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, 帳票ID),
                        new RString(String.valueOf(0)),
                        csv出力有無,
                        csvファイル名,
                        出力条件
                );
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }
}

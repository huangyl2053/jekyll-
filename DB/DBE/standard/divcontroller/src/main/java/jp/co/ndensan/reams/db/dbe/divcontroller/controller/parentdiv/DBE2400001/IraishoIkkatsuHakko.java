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
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.IraishoIkkatsuHakkoBatchParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.iraisho.IraishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.DBE2400001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.IraishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.dgNinteiChosaIraiTaishoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001.dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2400001.IraishoIkkatsuHakkoHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2400001.IraishoIkkatsuHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.iraisho.IraishoIkkatsuHakkoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 依頼書一括発行のコントローラです。
 *
 * @reamsid_L DBE-0080-010 duanzhanli
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
        getHandler(div).load(DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
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
            getHandler(div).load(DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
            return ResponseData.of(div).setState(DBE2400001StateName.認定調査依頼);
        }
        if (SELECTED_KEY1.equals(div.getRadTaishoSentaku().getSelectedKey())) {
            getHandler(div).shuziiiKenshoLoad(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法,
                    RDate.getNowDate(),
                    SubGyomuCode.DBE認定支援));
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
                            div.getCcdNinteiChosaHokensha().getSelectedItem().get証記載保険者番号(),
                            div.getChkNinteiChosahyo().getSelectedKeys(),
                            Collections.<RString>emptyList(),
                            Collections.<RString>emptyList(),
                            div.getTxtChosaDispMax().getValue());
            resultList = service.getNinteiChousaIrai(param).records();
        }
        if (STATE_SHUJII.equals(div.getState())) {
            IraishoIkkatsuHakkoParameter param
                    = IraishoIkkatsuHakkoParameter.createIraishoIkkatsuHakkoParameter(
                            div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue(),
                            div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue(),
                            Collections.<RString>emptyList(),
                            div.getCcdShujiiIkenshoHokensha().getSelectedItem().get証記載保険者番号(),
                            Collections.<RString>emptyList(),
                            div.getChkShujiiikenshoSakuseiIrai().getSelectedKeys(),
                            div.getChkShujiiIkensho().getSelectedKeys(),
                            div.getTxtIkenshoDispMax().getValue());
            resultList = service.getShuziiIkenshoIrai(param).records();
        }
        getHandler(div).setDataGrid(resultList);
        return ResponseData.of(div).respond();
    }

    /**
     * 条件をクリアするボタン押下します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoDiv> onClick_btnJokenClear(IraishoIkkatsuHakkoDiv div) {
        getHandler(div).clearJoken();
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
        getHandler(div).setTxtKyotsuHizuke();
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
     * 依頼書一括発行バッチを起動します。
     *
     * @param div 依頼書一括発行Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<IraishoIkkatsuHakkoBatchParamter> onClick_btnBatchRegister(IraishoIkkatsuHakkoDiv div) {
        IraishoIkkatsuHakkoBatchParamter param = new IraishoIkkatsuHakkoBatchParamter();
        if (STATE_NINTEIO.equals(div.getState())) {
            param.setIraiFromYMD(div.getTxtIraibiFrom().getValue() == null
                    ? RString.EMPTY : div.getTxtIraibiFrom().getValue().toDateString());
            param.setIraiToYMD(div.getTxtIraibiTo().getValue() == null
                    ? RString.EMPTY : div.getTxtIraibiTo().getValue().toDateString());
            setNinteParam(param, div);
        }
        if (STATE_SHUJII.equals(div.getState())) {
            param.setIraiFromYMD(div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue() == null
                    ? RString.EMPTY : div.getTxtShujiiIkenshoSakuseiIraibiFrom().getValue().toDateString());
            param.setIraiToYMD(div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue() == null
                    ? RString.EMPTY : div.getTxtShujiiIkenshoSakuseiIraibiTo().getValue().toDateString());
            setShujiiParam(param, div);
        }
        param.setHakkobi(div.getTxtHakkobi().getValue() == null
                ? RString.EMPTY : div.getTxtHakkobi().getValue().toDateString());
        if (SELECTED_KEY0.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(COMMON_NO_PRINT);
        } else if (SELECTED_KEY1.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(COMMON_PRINT);
        } else if (SELECTED_KEY2.equals(div.getRadTeishutsuKigen().getSelectedKey())) {
            param.setTeishutsuKigen(COMMON_DATE);
        } else {
            param.setTeishutsuKigen(RString.EMPTY);
        }
        if (SELECTED_KEY2.equals(div.getRadTeishutsuKigen().getSelectedKey()) && div.getTxtKyotsuHizuke().getValue() != null) {
            param.setKyotsuHizuke(div.getTxtKyotsuHizuke().getValue().toDateString());
        } else {
            param.setKyotsuHizuke(RString.EMPTY);
        }
        return ResponseData.of(param).respond();
    }

    private void setNinteParam(IraishoIkkatsuHakkoBatchParamter param, IraishoIkkatsuHakkoDiv div) {
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
        List<GridParameter> ninteiChosaIraiList = new ArrayList<>();
        for (dgNinteiChosaIraiTaishoIchiran_Row row : div.getDgNinteiChosaIraiTaishoIchiran().getSelectedItems()) {
            GridParameter gridParameter = new GridParameter();
            gridParameter.setNinteichosaItakusakiCode(row.getNinteiChosaitakusaki());
            gridParameter.setNinteiChosainCode(row.getNinteiChosainNo());
            gridParameter.setShoKisaiHokenshaNo(row.getShoKisaiHokenshaNo());
            ninteiChosaIraiList.add(gridParameter);
        }
        param.setNinteiChosaIraiList(ninteiChosaIraiList);
        if (div.getChkNinteiChosaIraiChohyo().getSelectedKeys().contains(SELECTED_KEY0)) {
            param.setNinteiChosaIraiChohyo(true);
        }
        if (div.getChkNinteiChosaIraiChohyo().getSelectedKeys().contains(SELECTED_KEY1)) {
            if (div.getChkNinteiChosaIraisho().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setNinteiChosaIraisyo(true);
            }
            if (div.getChkNinteiChosahyoShurui().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setNinteiChosahyoKihon(true);
            }
            if (div.getChkNinteiChosahyoShurui().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setNinteiChosahyoTokki(true);
            }
            if (div.getChkNinteiChosahyoShurui().getSelectedKeys().contains(SELECTED_KEY2)) {
                param.setNinteiChosahyoGaikyou(true);
            }
            if (div.getChkNinteiChosahyoOcrShurui().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setNinteiChosahyoOCRKihon(true);
            }
            if (div.getChkNinteiChosahyoOcrShurui().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setNinteiChosahyoOCRTokki(true);
            }
            if (div.getChkNinteiChosahyoOcrShurui().getSelectedKeys().contains(SELECTED_KEY2)) {
                param.setNinteiChosahyoOCRGaikyou(true);
            }
            if (div.getChkNinteiChosahyoSonota().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setNinteiChosaCheckHyo(true);
            }
            if (div.getChkNinteiChosahyoSonota().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setZenkoNinteiChosahyo(true);
            }
        }
        param.setNinteiChosairaiHakkou(div.getChkchosairaihakko().getSelectedKeys().contains(SELECTED_KEY0));
    }

    private void setShujiiParam(IraishoIkkatsuHakkoBatchParamter param, IraishoIkkatsuHakkoDiv div) {
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
        List<GridParameter> shujiiIkenshoSakuseiIraiList = new ArrayList<>();
        for (dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row row : div.getDgShujiiIkenshoSakuseiIraiTaishoIchiran().getSelectedItems()) {
            GridParameter gridParameter = new GridParameter();
            gridParameter.setShujiiIryoKikanCode(row.getShujiiIryoKikanCode());
            gridParameter.setIshiNo(row.getIshiNo());
            gridParameter.setShoKisaiHokenshaNo(row.getShoKisaiHokenshaNo());
            shujiiIkenshoSakuseiIraiList.add(gridParameter);
        }
        param.setShujiiIkenshoSakuseiIraiList(shujiiIkenshoSakuseiIraiList);
        if (div.getChkShujiiIkenshoShutsuryoku().getSelectedKeys().contains(SELECTED_KEY0)) {
            param.setIkenshoSakuseiirai(true);
        }
        if (div.getChkShujiiIkenshoShutsuryoku().getSelectedKeys().contains(SELECTED_KEY1)) {
            param.setIkenshoSakuseiSeikyuu(true);
        }
        if (div.getChkShujiiIkenshoShutsuryoku().getSelectedKeys().contains(SELECTED_KEY2)) {
            if (div.getChkShujiiIkenshoSakuseiIraisho().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setShujiiIkenshoSakuseiIraisho(true);
            }
            if (div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setIkenshoKinyuu(true);
            }
            if (div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().getSelectedKeys().contains(SELECTED_KEY1)) {
                param.setIkenshoKinyuuOCR(true);
            }
            if (div.getChkShujiIkenshoKinyuAndSakuseiryoSeikyu().getSelectedKeys().contains(SELECTED_KEY2)) {
                param.setIkenshoSakuseiSeikyuusho(true);
            }
            if (div.getChkShindanMeireishoAndTeishutsuIraisho().getSelectedKeys().contains(SELECTED_KEY0)) {
                param.setIkenshoTeishutu(true);
            }
        }
        if (div.getChkikenshiiraihakko().getSelectedKeys().contains(SELECTED_KEY0)) {
            param.setIkenshoSakuseiIraiHakkou(true);
        }
    }

    private IraishoIkkatsuHakkoHandler getHandler(IraishoIkkatsuHakkoDiv div) {
        return new IraishoIkkatsuHakkoHandler(div);
    }

    private IraishoIkkatsuHakkoValidationHandler getValidationHandler(IraishoIkkatsuHakkoDiv div) {
        return new IraishoIkkatsuHakkoValidationHandler(div);
    }

}

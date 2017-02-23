/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2300001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.DBE2300001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.dgMiwaritsukeShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.dgWaritsukeZumiShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IshiKubunCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShujiiIkenshoIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.shishosecurityjoho.ShishoSecurityJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 主治医意見書作成依頼のクラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class ShujiiIkenshoSakuseiIrai {

    private static final RString 未割付 = new RString("未割付");
    private static final RString 割付解除 = new RString("割付解除");
    private static final RString 意見書作成依頼日より加算する = new RString("1");
    private static final RString 主治医選択タイトル = new RString("主治医選択");
    private static final RString 意見書対象者選択に進むボタン名 = new RString("btnNextTaishoshaSentaku");

    /**
     * 主治医意見書作成依頼の初期化です。
     *
     * @param div ShujiiIkenshoSakuseiIraiDiv
     * @return ResponseData<ShujiiIkenshoSakuseiIraiDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onLoad(ShujiiIkenshoSakuseiIraiDiv div) {
        createHandler(div).load();
        ShoKisaiHokenshaNo 保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        RString 支所コード = ShishoSecurityJoho.createInstance().getShishoCode(ControlDataHolder.getUserId());
        ViewStateHolder.put(ViewStateKeys.支所コード, 支所コード);
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, 保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者リスト変更
     *
     * @param div ShujiiIkenshoSakuseiIraiDiv
     * @return ResponseData<ShujiiIkenshoSakuseiIraiDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onChange_ddlHokenshaList(ShujiiIkenshoSakuseiIraiDiv div) {
        div.getCcdShujiiIryoKikanAndShujiiInput().clear();
        ShoKisaiHokenshaNo 保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, 保険者番号);
        div.getCcdShujiiIryoKikanAndShujiiInput().initialize(
                div.getCcdHokenshaList().getSelectedItem().get市町村コード(),
                ShinseishoKanriNo.EMPTY, SubGyomuCode.DBE認定支援);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件クリア処理です。
     *
     * @param div ShujiiIkenshoSakuseiIraiDiv
     * @return ResponseData<ShujiiIkenshoSakuseiIraiDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnClear(ShujiiIkenshoSakuseiIraiDiv div) {
        createHandler(div).load();
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者選択ボタン押下 。
     *
     * @param div ShujiiIkenshoSakuseiIraiDiv
     * @return ResponseData<ShujiiIkenshoSakuseiIraiDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnNextToTaishoshaSentaku(ShujiiIkenshoSakuseiIraiDiv div) {
        set意見書作成対象者情報(div);
        setPnlShujiiSentaku(div, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(意見書対象者選択に進むボタン名, true);
        return ResponseData.of(div).setState(DBE2300001StateName.対象者選択);
    }

    /**
     * 「↑申請者を割付ける」ボタンのclick処理です。
     *
     * @param div ShujiiIkenshoSakuseiIraiDiv
     * @return ResponseData<ShujiiIkenshoSakuseiIraiDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnWaritsuke(ShujiiIkenshoSakuseiIraiDiv div) {
        List<dgMiwaritsukeShinseishaIchiran_Row> selectedItems = div.getDgMiwaritsukeShinseishaIchiran().getSelectedItems();
        if (selectedItems.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.選択されていない.getMessage().replace("未割付申請者"));
        }
        if (div.getTxtIkenshoSakuseiIraiDay().getValue() == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("意見書作成依頼日"));
        }
        for (dgMiwaritsukeShinseishaIchiran_Row row : selectedItems) {
            createHandler(div).set割付済み申請者一覧(row);
            div.getDgMiwaritsukeShinseishaIchiran().getDataSource().remove(row);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「↓割付けを解除する」ボタンのclick処理です。
     *
     * @param div ShujiiIkenshoSakuseiIraiDiv
     * @return ResponseData<ShujiiIkenshoSakuseiIraiDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnKaijo(ShujiiIkenshoSakuseiIraiDiv div) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        if (selectedItems.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.選択されていない.getMessage().replace("割付済み申請者"));
        }

        boolean exist調査完了申請者 = false;
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            if (row.getJotai().isEmpty()
                    && (row.getShujiiIkenshoTorokuKanryoYMD().getValue() != null && !row.getShujiiIkenshoTorokuKanryoYMD().getValue().isEmpty())) {
                exist調査完了申請者 = true;
                break;
            }
        }
        if (exist調査完了申請者) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.主治医意見書登録完了申請者ですが割付解除.getMessage().getCode(),
                        DbeQuestionMessages.主治医意見書登録完了申請者ですが割付解除.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.主治医意見書登録完了申請者ですが割付解除.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            createHandler(div).set未割付申請者一覧(row);
            div.getDgWaritsukeZumiShinseishaIchiran().getDataSource().remove(row);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「依頼書等を印刷する」ボタンを押下した時の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onBeforeOpen_printDialog(ShujiiIkenshoSakuseiIraiDiv div) {
        ShujiiIkenshoSakuseiIraiValidationHandler validationHandler = createValidationHandler(div);
        ValidationMessageControlPairs validationMessages = validationHandler.validate依頼書等を印刷するボタンクリック();
        if (validationMessages.existsError()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        IkenshoPrintParameterModel model = new IkenshoPrintParameterModel();
        List<ShinseishoKanriNo> list = new ArrayList<>();
        List<dgWaritsukeZumiShinseishaIchiran_Row> rowList = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        for (dgWaritsukeZumiShinseishaIchiran_Row row : rowList) {
            if (!RString.isNullOrEmpty(row.getShinseishoKanriNo())) {
                list.add(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            }
        }
        model.set申請書管理番号リスト(list);
        model.set市町村コード(div.getCcdHokenshaList().getSelectedItem().get市町村コード());
        model.set遷移元画面区分(GamenSeniKbn.主治医意見書依頼);
        div.setHiddenIuputModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 保存処理を行います。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnHozon(ShujiiIkenshoSakuseiIraiDiv div) {
        if (!ResponseHolder.isReRequest() && !createHandler(div).exist変更()) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            insert主治医意見書作成依頼情報(div);
            update主治医意見書作成依頼情報(div);
            set割付済み申請者一覧(div);
            div.getKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBE2300001StateName.保存完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医選択画面へ戻ります。(対象者選択画面から)
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnBackToShujiiSentakuFromTaishoshaSentaku(ShujiiIkenshoSakuseiIraiDiv div) {
        if (createHandler(div).exist変更()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        createHandler(div).load();
        setPnlShujiiSentaku(div, false);
        return ResponseData.of(div).setState(DBE2300001StateName.初期表示);
    }

    /**
     * 主治医選択画面へ戻ります。(完了画面から)
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnBackToShujiiSentakuFromKanryo(ShujiiIkenshoSakuseiIraiDiv div) {
        createHandler(div).load();
        setPnlShujiiSentaku(div, false);
        ShoKisaiHokenshaNo 保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        RString 支所コード = ShishoSecurityJoho.createInstance().getShishoCode(ControlDataHolder.getUserId());
        ViewStateHolder.put(ViewStateKeys.支所コード, 支所コード);
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, 保険者番号);
        return ResponseData.of(div).setState(DBE2300001StateName.初期表示);
    }
    
    /**
     * 主治医入力ダイアログがOkCloseで操作時
     * 
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onOKClose_btnShujiiGuide(ShujiiIkenshoSakuseiIraiDiv div) {
        if (!RString.isNullOrEmpty(div.getSearch().getCcdShujiiIryoKikanAndShujiiInput().getTxtShujiiCode().getValue())) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(意見書対象者選択に進むボタン名, false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 保険者名称 保険者名称
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     */
    private void set意見書作成対象者情報(ShujiiIkenshoSakuseiIraiDiv div) {
        set割付済み申請者一覧(div);
        set未割付申請者一覧(div);
    }

    private void set割付済み申請者一覧(ShujiiIkenshoSakuseiIraiDiv div) {
        ShoKisaiHokenshaNo 証記載保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        RString 保険者名称 = div.getCcdHokenshaList().getSelectedItem().get市町村名称();
        ShujiiIryokikanCode 主治医医療機関コード = new ShujiiIryokikanCode(div.getCcdShujiiIryoKikanAndShujiiInput().getIryoKikanCode());
        ShujiiCode 主治医コード = new ShujiiCode(div.getCcdShujiiIryoKikanAndShujiiInput().getShujiiCode());
        RString 支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);

        ShujiiIkenshoSakuseiIraiParameter parameter
                = ShujiiIkenshoSakuseiIraiParameter.createParamfor割付済み申請者一覧(証記載保険者番号, 支所コード, 主治医医療機関コード, 主治医コード);
        List<WaritsukeBusiness> 割付済み申請者一覧 = ShujiiIkenshoSakuseiIraiManager.createInstance().get割付済み申請者情報(parameter);
        createHandler(div).set割付済み申請者一覧(割付済み申請者一覧, 保険者名称);

        List<NinteiKanryoJoho> ninteiKanryoJohoList = new ArrayList<>();
        List<ShujiiIkenshoIraiJoho> shujiiIkenshoIraiJohoList = new ArrayList<>();
        for (WaritsukeBusiness 割付済み申請者 : 割付済み申請者一覧) {
            ninteiKanryoJohoList.add(割付済み申請者.getNinteiKanryoJohoEntity());
            if (割付済み申請者.getShujiiIkenshoIraiJoho() != null) {
                shujiiIkenshoIraiJohoList.add(割付済み申請者.getShujiiIkenshoIraiJoho());
            }
        }
        ViewStateHolder.put(ViewStateKeys.要介護認定完了情報, Models.create(ninteiKanryoJohoList));
        ViewStateHolder.put(ViewStateKeys.主治医意見書作成依頼情報, Models.create(shujiiIkenshoIraiJohoList));
    }

    private void set未割付申請者一覧(ShujiiIkenshoSakuseiIraiDiv div) {
        ShoKisaiHokenshaNo 証記載保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        RString 保険者名称 = div.getCcdHokenshaList().getSelectedItem().get市町村名称();
        RString 支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);

        ShujiiIkenshoSakuseiIraiParameter parameter = ShujiiIkenshoSakuseiIraiParameter.createParam主治医医療機関Or未割付申請者(証記載保険者番号, 支所コード);
        List<WaritsukeBusiness> 未割付申請者一覧 = ShujiiIkenshoSakuseiIraiManager.createInstance().get未割付申請者情報(parameter);
        createHandler(div).set未割付申請者一覧(未割付申請者一覧, 保険者名称);
    }

    private void insert主治医意見書作成依頼情報(ShujiiIkenshoSakuseiIraiDiv div) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> 割付済み申請者List = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        ShujiiIkenshoIraiJohoManager shujiiIkenshoIraiJohoManager = ShujiiIkenshoIraiJohoManager.createInstance();
        RDate nowDate = RDate.getNowDate();
        RString 主治医意見書作成期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, nowDate, SubGyomuCode.DBE認定支援);
        RString 主治医意見書作成期限日数 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, nowDate, SubGyomuCode.DBE認定支援);
        FlexibleDate 主治医意見書作成依頼年月日 = new FlexibleDate(div.getTxtIkenshoSakuseiIraiDay().getValue().toDateString());
        for (dgWaritsukeZumiShinseishaIchiran_Row row : 割付済み申請者List) {
            if (未割付.equals(row.getJotai())) {
                ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
                int 主治医意見書作成依頼履歴番号 = Integer.parseInt(row.getIkenshoIraiRirekiNo().toString()) + 1;
                RString 主治医医療機関コード = div.getCcdShujiiIryoKikanAndShujiiInput().getIryoKikanCode();
                RString 主治医コード = div.getCcdShujiiIryoKikanAndShujiiInput().getShujiiCode();
                FlexibleDate 認定申請日 = new FlexibleDate(row.getNinteiShinseiDay().getValue().toDateString());
                FlexibleDate 主治医意見書作成期限年月日;
                if (意見書作成依頼日より加算する.equals(主治医意見書作成期限設定方法)) {
                    主治医意見書作成期限年月日 = 主治医意見書作成依頼年月日.plusDay(Integer.parseInt(主治医意見書作成期限日数.toString()));
                } else {
                    主治医意見書作成期限年月日 = 認定申請日.plusDay(Integer.parseInt(主治医意見書作成期限日数.toString()));
                }
                Code 医師区分コード;
                if (div.getCcdShujiiIryoKikanAndShujiiInput().hasShiteii()) {
                    医師区分コード = new Code(IshiKubunCode.指定医.getコード());
                } else {
                    医師区分コード = new Code(IshiKubunCode.主治医.getコード());
                }
                Code 作成料請求区分Code = new Code();
                if (!RString.isNullOrEmpty(row.getSakuseiryoSeikyuKubunCode())) {
                    作成料請求区分Code = new Code(row.getSakuseiryoSeikyuKubunCode());
                }
                if (IkenshoIraiKubun.初回依頼.get名称().equals(row.getIkenshoIraiKubun())) {
                    ShujiiIkenshoIraiJoho shujiiIkenshoIraiJoho = new ShujiiIkenshoIraiJoho(申請書管理番号, 主治医意見書作成依頼履歴番号);
                    shujiiIkenshoIraiJoho = shujiiIkenshoIraiJoho.createBuilderForEdit()
                            .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                            .set主治医医療機関コード(主治医医療機関コード)
                            .set主治医コード(主治医コード)
                            .set主治医意見書依頼区分(IkenshoIraiKubun.初回依頼.getコード())
                            .set主治医意見書作成回数(1)
                            .set医師区分コード(医師区分コード)
                            .set主治医意見書作成依頼年月日(主治医意見書作成依頼年月日)
                            .set主治医意見書作成期限年月日(主治医意見書作成期限年月日)
                            .set作成料請求区分(作成料請求区分Code)
                            .set論理削除フラグ(false)
                            .build();
                    shujiiIkenshoIraiJohoManager.save主治医意見書作成依頼情報(shujiiIkenshoIraiJoho);
                    update要介護認定申請情報(申請書管理番号, 主治医コード, 主治医医療機関コード, row, div.getCcdShujiiIryoKikanAndShujiiInput().hasShiteii());
                } else {
                    ShujiiIkenshoIraiJoho shujiiIkenshoIraiJoho = new ShujiiIkenshoIraiJoho(申請書管理番号, 主治医意見書作成依頼履歴番号);
                    shujiiIkenshoIraiJoho = shujiiIkenshoIraiJoho.createBuilderForEdit()
                            .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                            .set主治医医療機関コード(主治医医療機関コード)
                            .set主治医コード(主治医コード)
                            .set主治医意見書依頼区分(IkenshoIraiKubun.再依頼.getコード())
                            .set主治医意見書作成回数(1)
                            .set医師区分コード(医師区分コード)
                            .set主治医意見書作成依頼年月日(主治医意見書作成依頼年月日)
                            .set主治医意見書作成期限年月日(主治医意見書作成期限年月日)
                            .set作成料請求区分(作成料請求区分Code)
                            .set論理削除フラグ(false)
                            .build();
                    shujiiIkenshoIraiJohoManager.save主治医意見書作成依頼情報(shujiiIkenshoIraiJoho);
                    update要介護認定申請情報(申請書管理番号, 主治医コード, 主治医医療機関コード, row, div.getCcdShujiiIryoKikanAndShujiiInput().hasShiteii());
                }
            }
        }
        div.getDgWaritsukeZumiShinseishaIchiran().setDataSource(割付済み申請者List);
    }

    private void update要介護認定申請情報(ShinseishoKanriNo 申請書管理番号, RString 主治医コード,
            RString 主治医医療機関コード, dgWaritsukeZumiShinseishaIchiran_Row row, boolean 指定医フラグ) {
        NinteiShinseiJohoManager manager = NinteiShinseiJohoManager.createInstance();
        NinteiShinseiJoho ninteiShinseiJoho = manager.get要介護認定申請情報(申請書管理番号);
        ninteiShinseiJoho = ninteiShinseiJoho.createBuilderForEdit()
                .set主治医医療機関コード(主治医医療機関コード)
                .set主治医コード(主治医コード)
                .set指定医フラグ(指定医フラグ)
                .build();
        manager.save要介護認定申請情報(ninteiShinseiJoho.modifiedModel());
    }

    private void update主治医意見書作成依頼情報(ShujiiIkenshoSakuseiIraiDiv div) {
        List<dgMiwaritsukeShinseishaIchiran_Row> miwaritsukeShinseishaIchiran = div.getDgMiwaritsukeShinseishaIchiran().getDataSource();
        Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJohoList = ViewStateHolder.get(ViewStateKeys.要介護認定完了情報, Models.class);
        Models<ShujiiIkenshoIraiJohoIdentifier, ShujiiIkenshoIraiJoho> shujiiIkenshoIraiJohoList = ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼情報, Models.class);
        NinteiKanryoJohoManager ninteiKanryoJohoManager = NinteiKanryoJohoManager.createInstance();
        ShujiiIkenshoIraiJohoManager shujiiIkenshoIraiJohoManager = ShujiiIkenshoIraiJohoManager.createInstance();
        for (dgMiwaritsukeShinseishaIchiran_Row row : miwaritsukeShinseishaIchiran) {
            if (割付解除.equals(row.getJotai())) {
                ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
                int 意見書依頼履歴番号 = Integer.parseInt(row.getIkenshoIraiRirekiNo().toString());
                ShujiiIkenshoIraiJohoIdentifier shujiiIkenshoIraiJohoIdentifier = new ShujiiIkenshoIraiJohoIdentifier(申請書管理番号, 意見書依頼履歴番号);
                ShujiiIkenshoIraiJoho shujiiIkenshoIraiJoho = shujiiIkenshoIraiJohoList.get(shujiiIkenshoIraiJohoIdentifier);
                if (shujiiIkenshoIraiJoho != null) {
                    shujiiIkenshoIraiJohoManager.saveOrDeletePhysical(shujiiIkenshoIraiJoho.deleted());
                }

                NinteiKanryoJohoIdentifier ninteiKanryoJohoIdentifier = new NinteiKanryoJohoIdentifier(申請書管理番号);
                NinteiKanryoJoho ninteiKanryoJoho = ninteiKanryoJohoList.get(ninteiKanryoJohoIdentifier)
                        .createBuilderForEdit()
                        .set主治医意見書作成依頼完了年月日(null)
                        .set主治医意見書登録完了年月日(null)
                        .build();
                ninteiKanryoJohoManager.save要介護認定完了情報(ninteiKanryoJoho.modifiedModel());
            }
        }
    }

    private ShujiiIkenshoSakuseiIraiHandler createHandler(ShujiiIkenshoSakuseiIraiDiv div) {
        return new ShujiiIkenshoSakuseiIraiHandler(div);
    }

    private ShujiiIkenshoSakuseiIraiValidationHandler createValidationHandler(ShujiiIkenshoSakuseiIraiDiv div) {
        return new ShujiiIkenshoSakuseiIraiValidationHandler(div);
    }

    private void setPnlShujiiSentaku(ShujiiIkenshoSakuseiIraiDiv div, boolean readOnly) {
        if (readOnly) {
            div.getSearch().setTitle(RString.EMPTY);
            div.getSearch().setReadOnly(true);
        } else {
            div.getSearch().setTitle(主治医選択タイトル);
            div.getSearch().setReadOnly(false);
        }
    }
}

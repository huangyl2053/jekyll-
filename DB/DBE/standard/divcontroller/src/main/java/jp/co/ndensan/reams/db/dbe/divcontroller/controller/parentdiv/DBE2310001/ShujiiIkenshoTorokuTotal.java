/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2310001;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshotoroku.ShujiiIkenshoTorokuResult;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeInformationMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikensho.ninteishinseijoho.NinteiShinseiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshotoroku.ShujiiIkenshoTorokuMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiijoho.ShujiiMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001.DBE2310001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001.DBE2310001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001.ShujiiIkenshoTorokuTotalDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2310001.ShujiiIkenshoTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2310001.ShujiiIkenshoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.shujiijoho.ShujiiMasterFinder;
import jp.co.ndensan.reams.db.dbe.service.core.ikensho.ninteishinseijoho.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshotoroku.ShujiiIkenshoTorokuManager;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagekanri.YokaigoninteiimagekanriFinder;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagesakujo.YokaigoninteiimagesakujoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujii;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv.TaishoMode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.db.dbz.service.core.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideFinder;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.service.core.util.KekkaTorokuUtil;
import jp.co.ndensan.reams.db.dbe.service.core.util.KekkaTorokuUtil.CheckEditableResult;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書登録のコントローラです。
 *
 * @reamsid_L DBE-0070-010 chengsanyuan
 */
public class ShujiiIkenshoTorokuTotal {

    private static final RString JYOTAI_CODE_ADD = new RString("1");
    private static final RString JYOTAI_CODE_UPD = new RString("2");
    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final RString SELECT_KEY2 = new RString("key2");
    private static final RString SELECT_KEY3 = new RString("key3");
    private static final RString SELECT_KEY4 = new RString("key4");
    private static final RString SELECT_KEY5 = new RString("key5");
    private static final RString SELECT_KEY6 = new RString("key6");
    private static final RString SELECT_KEY7 = new RString("key7");
    private static final RString SELECT_KEY8 = new RString("key8");
    private static final RString SELECT_KEY9 = new RString("key9");
    private static final RString SELECT_KEY10 = new RString("key10");
    private static final RString SELECT_KEY11 = new RString("key11");
    private final ShujiiIkenshoTorokuManager service;
    private final ImageManager imageManager;
    private final NinteiShinseiJohoManager ninteiManager;
    private static final RString COMMON_BUTTON_UPDATE = new RString("btnIkenshoSave");
    private static final RString UIContainerID_主治医意見書入手 = new RString("DBEUC20701");
    private static final int 該当データなし = 0;
    private static final RString 登録_修正 = new RString("key0");
    private static final RString 削除 = new RString("key1");
    private static final RString 連絡必要 = new RString("key1");
    private RString 確認メッセージ出力区分;
    private static final RString 確認メッセージ出力要 = new RString("1");
    private static final RString イメージファイルが存在区分_存在しない = new RString("1");
    private static final RString イメージファイルが存在区分_マスキング有 = new RString("2");
    private static final RString 厚労省IF識別番号_09B = new RString("09B");
    private final ShujiiIryokikanAndShujiiGuideFinder finder;

    /**
     * コンストラクタです。
     *
     */
    public ShujiiIkenshoTorokuTotal() {
        this.service = ShujiiIkenshoTorokuManager.createInstance();
        this.imageManager = new ImageManager();
        this.ninteiManager = NinteiShinseiJohoManager.createInstance();
        this.finder = ShujiiIryokikanAndShujiiGuideFinder.createInstance();
    }

    /**
     * 主治医意見書登録初期化の設定します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onLoad(ShujiiIkenshoTorokuTotalDiv div) {
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        SearchResult<ShujiiIkenshoTorokuResult> resultList = service.getDataForLoad(ShujiiIkenshoTorokuMapperParameter.findBy(管理番号));

        if (resultList.records().isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                div.setDisabled(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_UPDATE, true);
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage().replace("主治医依頼情報未登録のため、")).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        }
        ShujiiIkenshoTorokuResult result = resultList.records().get(0);

        if (!Objects.equals(result.get厚労省IF識別コード(), 厚労省IF識別番号_09B)
                && !(new RString(DbeErrorMessages.認定ソフトバージョンエラー.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))) {
            return ResponseData.of(div).addMessage(DbeErrorMessages.認定ソフトバージョンエラー.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && new RString(DbeErrorMessages.認定ソフトバージョンエラー.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            setReadOnly(div);
            div.getRadJotaiKubun().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_UPDATE, true);
            if (UIContainerID_主治医意見書入手.equals(ResponseHolder.getUIContainerId())) {
                return ResponseData.of(div).setState(DBE2310001StateName.初期表示_一覧);
            } else {
                return ResponseData.of(div).setState(DBE2310001StateName.初期表示);
            }
        }

        LasdecCode 市町村コード = result.get市町村コード();
        ViewStateHolder.put(ViewStateKeys.市町村コード, 市町村コード);
        int 履歴番号 = result.get主治医意見書作成依頼履歴番号();
        ViewStateHolder.put(ViewStateKeys.主治医意見書作成依頼履歴番号, new RString(履歴番号));
        Image image = imageManager.getイメージ情報(管理番号);
        NinteiShinseiJoho ninteiShinseiJoho = ninteiManager.get意見書情報(NinteiShinseiJohoMapperParameter.create主治医意見書登録Param(管理番号, 履歴番号));
        if (result.get主治医意見書記入年月日() == null) {
            div.setHdnHasChanged(RString.EMPTY);
            div.getRadTakaShinryo().setSelectedKey(SELECT_KEY1);
            ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_ADD);
            getHandler(div).setChosaTishoJohoDisable(true);
            getHandler(div).setSonotaDisable(true);
        } else {
            ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_UPD);
        }
        getHandler(div).load(result);
        div.setHdnHasChanged(getHandler(div).getDataRString());
        div.getCcdNinteiShinseishaKihonInfo().initialize(管理番号);

        RString 被保険者番号 = div.getCcdNinteiShinseishaKihonInfo().get被保険者番号();
        RString 証記載保険者番号 = div.getCcdNinteiShinseishaKihonInfo().get証記載保険者番号();
        DbAccessLogger accessLog = new DbAccessLogger();
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"),
                new RString("申請書管理番号"), 管理番号.value());
        accessLog.store(new ShoKisaiHokenshaNo(証記載保険者番号), 被保険者番号, expandedInfo);
        accessLog.flushBy(AccessLogType.照会);

        getHandler(div).setChkTakaJushin(result);
        ViewStateHolder.put(ViewStateKeys.意見書情報, ninteiShinseiJoho);
        ViewStateHolder.put(ViewStateKeys.イメージ情報, image);

        boolean 照会のみ = false;
        if (!ResponseHolder.isReRequest()) {
            CheckEditableResult result2 = KekkaTorokuUtil.checkEditable(管理番号);
            if (!result2.is編集可能()) {
                return ResponseData.of(div).addMessage(result2.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && Arrays.asList(
                        CheckEditableResult.審査会結果登録完了済み.getMessageCode(),
                        CheckEditableResult.一次判定完了済み.getMessageCode()
                ).contains(ResponseHolder.getMessageCode())) {
            照会のみ = true;
        }
        if (照会のみ) {
            setReadOnly(div);
            div.getRadJotaiKubun().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_UPDATE, true);
            return ResponseData.of(div).setState(DBE2310001StateName.初期表示);
        }
        RStringBuilder 前排他制御開催番号 = new RStringBuilder();
        前排他制御開催番号.append("DBEShinseishoKanriNo");
        前排他制御開催番号.append(管理番号);
        前排他ロックキー(前排他制御開催番号.toRString());
        div.getRadJotaiKubun().setSelectedKey(登録_修正);

        return ResponseData.of(div).respond();
    }

    /**
     * チェック変更した際の選択項目により、画面項目の入力可否を設定します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onChange_jotaiKubun(ShujiiIkenshoTorokuTotalDiv div) {
        if (div.getRadJotaiKubun().getSelectedKey().equals(登録_修正)) {
            div.getTxtKinyuYMD().setReadOnly(false);
            div.getTxtSaishuShinryoYMD().setReadOnly(false);
            div.getRadIkenshoSakuseiKaisu().setReadOnly(false);
            div.getRadTakaShinryo().setReadOnly(false);
            div.getTxtShujiiMemo().setReadOnly(false);
            div.getBtnShobyoGuide().setDisabled(false);
            div.getBtnTokubetsuIryoGuide().setDisabled(false);
            div.getBtnShinshinJotaiGuide().setDisabled(false);
            div.getBtnSeikatsuKinoServiceGuide().setDisabled(false);
            div.getBtnTokkiJikoGuide().setDisabled(false);
            div.getRadDoi().setReadOnly(false);
            div.getBtnMemoTeikeibunGuide().setDisabled(false);
            div.getRadShujiiRenraku().setReadOnly(false);
            div.getIkenshoKihonJoho().getTxtShujiiCode().setReadOnly(false);
            div.getIkenshoKihonJoho().getTxtShujiiIryoKikanCode().setReadOnly(false);
            div.getIkenshoKihonJoho().getBtnShujiiGuide().setDisabled(false);
            div.getIkenshoKihonJoho().getBtnToSearchIryoKikan().setDisabled(false);
        } else {
            setReadOnly(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 各項目を編集不可にする
     *
     * @param div 主治医意見書登録Div
     */
    private void setReadOnly(ShujiiIkenshoTorokuTotalDiv div) {
        div.getTxtKinyuYMD().setReadOnly(true);
        div.getTxtSaishuShinryoYMD().setReadOnly(true);
        div.getRadIkenshoSakuseiKaisu().setReadOnly(true);
        div.getRadTakaShinryo().setReadOnly(true);
        div.getTxtShujiiMemo().setReadOnly(true);
        div.getBtnShobyoGuide().setDisabled(true);
        div.getBtnTokubetsuIryoGuide().setDisabled(true);
        div.getBtnShinshinJotaiGuide().setDisabled(true);
        div.getBtnSeikatsuKinoServiceGuide().setDisabled(true);
        div.getBtnTokkiJikoGuide().setDisabled(true);
        div.getRadDoi().setReadOnly(true);
        div.getBtnMemoTeikeibunGuide().setDisabled(true);
        div.getRadShujiiRenraku().setReadOnly(true);
        div.getIkenshoKihonJoho().getTxtShujiiCode().setReadOnly(true);
        div.getIkenshoKihonJoho().getTxtShujiiIryoKikanCode().setReadOnly(true);
        div.getIkenshoKihonJoho().getBtnShujiiGuide().setDisabled(true);
        div.getIkenshoKihonJoho().getBtnToSearchIryoKikan().setDisabled(true);
    }

    /**
     * チェック変更した際の選択項目により、他科診療チェックボックスを変更可能にします。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onChange_radTakaShinryo(ShujiiIkenshoTorokuTotalDiv div) {
        if (SELECT_KEY0.equals(div.getRadTakaShinryo().getSelectedKey())) {
            getHandler(div).setChosaTishoJohoDisable(false);
        } else {
            getHandler(div).setChosaTishoJohoDisable(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * チェック変更した際の選択項目により、テキストボックスその他を変更可能にします。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onChange_chkSonota(ShujiiIkenshoTorokuTotalDiv div) {
        if (div.getChkSonota().getSelectedKeys().contains(SELECT_KEY0)) {
            getHandler(div).setSonotaDisable(false);
        } else {
            getHandler(div).setSonotaDisable(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関検索ボタンを押下します。
     *
     * @param div ShujiiIkenshoTorokuTotalDiv
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onClick_IryoKikanOpen(ShujiiIkenshoTorokuTotalDiv div) {
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = new ShujiiIryokikanandshujiiDataPassModel();
        LasdecCode 市町村コード = (ViewStateHolder.get(ViewStateKeys.市町村コード, LasdecCode.class));
        dataPassModel.setサブ業務コード(SubGyomuCode.DBE認定支援.value());
        dataPassModel.set市町村コード(市町村コード.value());
        dataPassModel.set対象モード(new RString(TaishoMode.IryoKikanMode.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(dataPassModel));
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関検索ボタンを押下します。
     *
     * @param div ShujiiIkenshoTorokuTotalDiv
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onClick_btnToSearchIryoKikan(ShujiiIkenshoTorokuTotalDiv div) {
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        div.getIkenshoKihonJoho().getTxtShujiiIryoKikanCode().setValue(dataPassModel.get主治医医療機関コード());
        div.getIkenshoKihonJoho().getTxtShujiiIryoKikanMei().setValue(dataPassModel.get主治医医療機関名称());
        if (dataPassModel.get電話番号() != null) {
            div.getIkenshoKihonJoho().getTxtShujiiIryoKikanTelNumber().setDomain(new TelNo(dataPassModel.get電話番号()));
        }
        if (dataPassModel.getFAX番号() != null) {
            div.getIkenshoKihonJoho().getTxtShujiiIryoKikanFaxNumber().setDomain(new TelNo(dataPassModel.getFAX番号()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関名を取得します。
     *
     * @param div ShujiiIkenshoTorokuTotalDiv
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onBlur_txtSearchShujiiIryokikanMeisho(ShujiiIkenshoTorokuTotalDiv div) {
        RString txtShujiiIryoKikanCode = div.getIkenshoKihonJoho().getTxtShujiiIryoKikanCode().getValue();
        LasdecCode 市町村コード = (ViewStateHolder.get(ViewStateKeys.市町村コード, LasdecCode.class));
        if (!RString.isNullOrEmpty(txtShujiiIryoKikanCode)) {
            RString shujiiIryoKikanMei = ShujiiMasterFinder.createInstance().getShujiiIryoKikanJoho(
                    ShujiiMasterSearchParameter.createParamForSelectShujiiJoho(
                            市町村コード,
                            div.getIkenshoKihonJoho().getTxtShujiiIryoKikanCode().getValue(),
                            div.getIkenshoKihonJoho().getTxtShujiiCode().getValue()));

            if (!RString.isNullOrEmpty(shujiiIryoKikanMei)) {
                div.getIkenshoKihonJoho().getTxtShujiiIryoKikanMei().setValue(shujiiIryoKikanMei);
            } else {
                div.getIkenshoKihonJoho().getTxtShujiiIryoKikanMei().setValue(RString.EMPTY);
            }
        } else {
            div.getIkenshoKihonJoho().getTxtShujiiIryoKikanMei().setValue(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関ガイドのデータを設定します。
     *
     * @param div ShujiiIkenshoTorokuTotalDiv
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onOKClose_btnShujiiGuide(ShujiiIkenshoTorokuTotalDiv div) {
        ShujiiIryokikanandshujiiDataPassModel model = DataPassingConverter.deserialize(div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        div.getTxtShujiiCode().setValue(model.get主治医コード());
        div.getTxtSujiiName().setValue(model.get主治医氏名());
        div.getTxtShujiiIryoKikanCode().setValue(model.get主治医医療機関コード());
        div.getTxtShujiiIryoKikanMei().setValue(model.get主治医医療機関名称());
        div.getTxtShujiiIryoKikanShozaichi().setDomain(model.get住所AsAtenaJusho());
        div.getTxtShujiiIryoKikanTelNumber().setDomain(model.get電話番号AsTelNo());
        div.getTxtShujiiIryoKikanFaxNumber().setDomain(model.getFAX番号AsTelNo());
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関ガイドのデータを設定します。
     *
     * @param div ShujiiIkenshoTorokuTotalDiv
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onClick_btnShujiiGuide(ShujiiIkenshoTorokuTotalDiv div) {
        ShujiiIryokikanandshujiiDataPassModel modle = new ShujiiIryokikanandshujiiDataPassModel();
        LasdecCode 市町村コード = (ViewStateHolder.get(ViewStateKeys.市町村コード, LasdecCode.class));
        modle.set市町村コード(new RString(市町村コード.toString()));
        modle.setサブ業務コード(SubGyomuCode.DBE認定支援.value());
        modle.set主治医医療機関コード(div.getIkenshoKihonJoho().getTxtShujiiIryoKikanCode().getValue());
        modle.set主治医医療機関名称(div.getIkenshoKihonJoho().getTxtShujiiIryoKikanMei().getValue());
        modle.set対象モード(new RString(TaishoMode.ShujiiMode.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(modle));
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医コードロストフォーカスの時、画面を設定します。
     *
     * @param div ShujiiIkenshoTorokuTotalDiv
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onBlur_txtShujii(ShujiiIkenshoTorokuTotalDiv div) {

        div.getIkenshoKihonJoho().getTxtSujiiName().setValue(RString.EMPTY);
        LasdecCode 市町村コード = (ViewStateHolder.get(ViewStateKeys.市町村コード, LasdecCode.class));
        if (RString.isNullOrEmpty(div.getIkenshoKihonJoho().getTxtShujiiCode().getValue())
                || RString.isNullOrEmpty(div.getIkenshoKihonJoho().getTxtShujiiCode().getValue())) {
            return ResponseData.of(div).respond();
        }

        List<ShujiiIryokikanAndShujii> list = finder.search主治医医療機関_主治医情報(
                ShujiiIryokikanAndShujiiGuideParameter.createKensakuJokenParameter(
                        new RString(市町村コード.toString()),
                        true,
                        div.getIkenshoKihonJoho().getTxtShujiiIryoKikanCode().getValue(),
                        div.getIkenshoKihonJoho().getTxtShujiiIryoKikanCode().getValue(),
                        true,
                        RString.EMPTY,
                        RString.EMPTY,
                        div.getIkenshoKihonJoho().getTxtShujiiCode().getValue(),
                        div.getIkenshoKihonJoho().getTxtShujiiCode().getValue(),
                        true,
                        RString.EMPTY,
                        RString.EMPTY,
                        1)).records();

        if (!list.isEmpty()) {
            div.getIkenshoKihonJoho().getTxtSujiiName().setValue(list.get(0).get主治医氏名());
        } else {
            div.getIkenshoKihonJoho().getTxtSujiiName().setValue(RString.EMPTY);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 傷病に関する意見ダイアログ表示前、データを設定します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onBefore_btnShobyoGuide(ShujiiIkenshoTorokuTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 傷病に関する意見ダイアログ閉じの時、データを取得します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onOkClose_btnShobyoGuide(ShujiiIkenshoTorokuTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 特別な医療に関する意見ダイアログ表示前、データを設定します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onBefore_btnTokubetsuIryoGuide(ShujiiIkenshoTorokuTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 特別な医療に関する意見ダイアログ閉じの時、データを取得します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onOkClose_btnTokubetsuIryoGuide(ShujiiIkenshoTorokuTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 心身の状態に関する意見ダイアログ表示前、データを設定します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onBefore_btnShinshinJotaiGuide(ShujiiIkenshoTorokuTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 心身の状態に関する意見ダイアログ閉じの時、データを取得します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onOkClose_btnShinshinJotaiGuide(ShujiiIkenshoTorokuTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 生活機能とサービスダイアログ表示前、データを設定します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onBefore_btnSeikatsuKinoServiceGuide(ShujiiIkenshoTorokuTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 生活機能とサービスダイアログ閉じの時、データを取得します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onOkClose_btnSeikatsuKinoServiceGuide(ShujiiIkenshoTorokuTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 特記すべき事項ダイアログ表示前、データを設定します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onBefore_btnTokkiJikoGuide(ShujiiIkenshoTorokuTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 特記すべき事項ダイアログ閉じの時、データを取得します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onOkClose_btnTokkiJikoGuide(ShujiiIkenshoTorokuTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ダイアログ表示前、データを設定します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onBefore_btnMemoTeikeibunGuide(ShujiiIkenshoTorokuTotalDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(new RString("5101"));
        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ダイアログ閉じの時、データを取得します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onOkClose_btnMemoTeikeibunGuide(ShujiiIkenshoTorokuTotalDiv div) {
        div.getTxtShujiiMemo().setValue(div.getHdnSampleText());
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧に戻るボタンを押下の場合、主治医意見書入手へ遷移します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onClick_btnBackToIchiran(ShujiiIkenshoTorokuTotalDiv div) {
        if (!ResponseHolder.isReRequest()) {
            RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
            RString beforeChange = getHandler(div).getDataRString();
            if ((JYOTAI_CODE_ADD.equals(state) && !beforeChange.equals(div.getHdnHasChanged()))
                    || (JYOTAI_CODE_UPD.equals(state) && !beforeChange.equals(div.getHdnHasChanged()))) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        RStringBuilder 前排他制御開催番号 = new RStringBuilder();
        前排他制御開催番号.append("DBEShinseishoKanriNo");
        前排他制御開催番号.append(管理番号);
        前排他キーの解除(前排他制御開催番号.toRString());
        return ResponseData.of(div).forwardWithEventName(DBE2310001TransitionEventName.申請者検索結果一覧に戻る).respond();
    }

    /**
     * 検索に戻るボタンを押下の場合、要介護認定申請検索へ遷移します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onClick_btnResearch(ShujiiIkenshoTorokuTotalDiv div) {
        ViewStateHolder.put(ViewStateKeys.機能詳細画面から再検索, Boolean.TRUE);
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        RStringBuilder 前排他制御開催番号 = new RStringBuilder();
        前排他制御開催番号.append("DBEShinseishoKanriNo");
        前排他制御開催番号.append(管理番号);
        前排他キーの解除(前排他制御開催番号.toRString());
        return onClick_ButtonsToReturnTaishoshaKensaku(div, DBE2310001TransitionEventName.申請者検索に戻る);
    }

    private ResponseData<ShujiiIkenshoTorokuTotalDiv> onClick_ButtonsToReturnTaishoshaKensaku(ShujiiIkenshoTorokuTotalDiv div, DBE2310001TransitionEventName eventName) {
        if (!ResponseHolder.isReRequest()) {
            RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
            RString beforeChange = getHandler(div).getDataRString();
            if ((JYOTAI_CODE_ADD.equals(state) && !beforeChange.equals(div.getHdnHasChanged()))
                    || (JYOTAI_CODE_UPD.equals(state) && !beforeChange.equals(div.getHdnHasChanged()))) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        RStringBuilder 前排他制御開催番号 = new RStringBuilder();
        前排他制御開催番号.append("DBEShinseishoKanriNo");
        前排他制御開催番号.append(管理番号);
        前排他キーの解除(前排他制御開催番号.toRString());
        return ResponseData.of(div).forwardWithEventName(eventName).respond();
    }

    /**
     * @param div 主治医意見書登録Div
     * @return ResponseData
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onClick_btnSearchResult(ShujiiIkenshoTorokuTotalDiv div) {
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        RStringBuilder 前排他制御開催番号 = new RStringBuilder();
        前排他制御開催番号.append("DBEShinseishoKanriNo");
        前排他制御開催番号.append(管理番号);
        前排他キーの解除(前排他制御開催番号.toRString());
        return onClick_ButtonsToReturnTaishoshaKensaku(div, DBE2310001TransitionEventName.申請者検索結果一覧に戻る);
    }

    /**
     * 完了ボタン押下時のイベントです。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onClick_btnKanryo(ShujiiIkenshoTorokuTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定のし直しが必要か否かを返します。
     *
     * @param div 主治医意見書登録Div
     * @return 一次判定し直しが必要か否か
     */
    private boolean isRequiredRejudgeOfIchiji(ShinseishoKanriNo 管理番号, int 履歴番号) {
        LasdecCode 市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        ShujiiIkenshoTorokuMapperParameter param
                = ShujiiIkenshoTorokuMapperParameter.createShujiiIkenshoTorokuMapperParameter(管理番号, 履歴番号, 市町村コード);
        int 一次判定データ = service.getIchijiHantei(param);
        int 一値判定未完了 = service.getIchijiHanteiMikanryo(param);
        if (!ResponseHolder.isReRequest()) {
            if (!(一次判定データ == 該当データなし && 一値判定未完了 == 該当データなし)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 保存するボタンを押下の場合、主治医意見書入手へ遷移します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onClick_btnIkenshoSave(ShujiiIkenshoTorokuTotalDiv div) {
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        int 履歴番号 = Integer.parseInt(ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼履歴番号, RString.class).toString());
        if (!ResponseHolder.isReRequest()) {
            if (div.getRadJotaiKubun().getSelectedKey().equals(登録_修正)) {
                ValidationMessageControlPairs canSave = getValidationHandler(div).validateCanSave();
                if (canSave.iterator().hasNext()) {
                    return ResponseData.of(div).addValidationMessages(canSave).respond();
                }
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            } else if (div.getRadJotaiKubun().getSelectedKey().equals(削除)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
            setShujiiIkenshoJoho(state, 管理番号, 履歴番号, div);
        }

        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            setShujiiIkenshoJoho(state, 管理番号, 履歴番号, div);
            if (UrControlDataFactory.createInstance().getUIContainerId().equals(UIContainerID_主治医意見書入手)) {
                RStringBuilder 前排他制御開催番号 = new RStringBuilder();
                前排他制御開催番号.append("DBEShinseishoKanriNo");
                前排他制御開催番号.append(管理番号);
                前排他キーの解除(前排他制御開催番号.toRString());
                return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
            }
            IchijiHanteiKekkaJohoManager ichijiHanteiKekkaJohoManager = InstanceProvider.create(IchijiHanteiKekkaJohoManager.class);
            IchijiHanteiKekkaJoho 一次判定結果情報 = ichijiHanteiKekkaJohoManager.get要介護認定一次判定結果情報(管理番号);
            if (!ResponseHolder.isReRequest() && 一次判定結果情報 != null && !一次判定結果情報.get仮一次判定区分()) {
                return ResponseData.of(div).addMessage(DbeInformationMessages.一次判定再処理.getMessage()).respond();
            }
            getEndMessage(div);
            return ResponseData.of(div).setState(DBE2310001StateName.完了状態);
        }

        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            setShujiiIkenshoJoho(state, 管理番号, 履歴番号, div);
            div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.削除終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY, true);
            RStringBuilder 前排他制御開催番号 = new RStringBuilder();
            前排他制御開催番号.append("DBEShinseishoKanriNo");
            前排他制御開催番号.append(管理番号);
            前排他キーの解除(前排他制御開催番号.toRString());
            return ResponseData.of(div).setState(DBE2310001StateName.完了状態);
        }

        if (new RString(DbeInformationMessages.一次判定再処理.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            if (!(ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
                return ResponseData.of(div).setState(DBE2310001StateName.初期表示);
            } else {
                return ResponseData.of(div).setState(DBE2310001StateName.完了状態);
            }
        }

        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }

        if (new RString(UrInformationMessages.保存終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && UrControlDataFactory.createInstance().getUIContainerId().equals(UIContainerID_主治医意見書入手)) {
            return ResponseData.of(div).forwardWithEventName(DBE2310001TransitionEventName.申請者検索結果一覧に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void setShujiiIkenshoJoho(
            RString flag,
            ShinseishoKanriNo 管理番号,
            int 履歴番号,
            ShujiiIkenshoTorokuTotalDiv div) {

        NinteiShinseiJoho ninteiShinseiJoho = ViewStateHolder.get(ViewStateKeys.意見書情報, NinteiShinseiJoho.class);
        ShujiiIkenshoIraiJoho shujiiIkenshoIraiJoho = ninteiShinseiJoho.getShujiiIkenshoIraiJoho(
                new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号));
        if (shujiiIkenshoIraiJoho.getShujiiIkenshoJohoList().isEmpty()) {
            shujiiIkenshoIraiJoho.createBuilderForEdit().setShujiiIkenshoJoho(new ShujiiIkenshoJoho(管理番号, 履歴番号));
        }
        ShujiiIkenshoJoho shujiiIkenshoJoho = shujiiIkenshoIraiJoho.
                getSeishinTechoNini(new ShujiiIkenshoJohoIdentifier(管理番号, 履歴番号));
        ShujiiIkenshoJohoBuilder shujiiIkenshoBuilder = shujiiIkenshoJoho.createBuilderForEdit();
        if (JYOTAI_CODE_ADD.equals(flag)) {
            shujiiIkenshoBuilder.set厚労省IF識別コード(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード());
            shujiiIkenshoBuilder.set主治医意見書依頼区分(shujiiIkenshoIraiJoho.get主治医意見書依頼区分());
            shujiiIkenshoBuilder.set主治医コード(div.getIkenshoKihonJoho().getTxtShujiiCode().getValue());
            shujiiIkenshoBuilder.set主治医医療機関コード(div.getIkenshoKihonJoho().getTxtShujiiIryoKikanCode().getValue());
            shujiiIkenshoBuilder.set主治医意見書受領年月日(FlexibleDate.getNowDate());
            shujiiIkenshoBuilder.set在宅_施設区分(new Code(ZaitakuShisetsuKubun.在宅.getコード()));
            if (ninteiShinseiJoho.is施設入所の有無()) {
                shujiiIkenshoBuilder.set在宅_施設区分(new Code(ZaitakuShisetsuKubun.施設.getコード()));
            }
            shujiiIkenshoBuilder.set主治医意見書記入年月日(rdateToFlex(div.getTxtKinyuYMD().getValue()));
            setShujiiIkenshoJohoCommon(shujiiIkenshoBuilder, div);
            shujiiIkenshoJoho = shujiiIkenshoBuilder.build();
        }
        if (JYOTAI_CODE_UPD.equals(flag)) {
            shujiiIkenshoBuilder.set主治医コード(div.getIkenshoKihonJoho().getTxtShujiiCode().getValue());
            shujiiIkenshoBuilder.set主治医医療機関コード(div.getIkenshoKihonJoho().getTxtShujiiIryoKikanCode().getValue());
            shujiiIkenshoBuilder.set主治医意見書記入年月日(rdateToFlex(div.getTxtKinyuYMD().getValue()));
            setShujiiIkenshoJohoCommon(shujiiIkenshoBuilder, div);
            shujiiIkenshoJoho = shujiiIkenshoBuilder.build();
            shujiiIkenshoJoho = shujiiIkenshoJoho.modifiedModel();
        }
        shujiiIkenshoIraiJoho = shujiiIkenshoIraiJoho.createBuilderForEdit().setShujiiIkenshoJoho(shujiiIkenshoJoho).build();

        if (div.getRadJotaiKubun().getSelectedKey().equals(登録_修正)) {
            ninteiShinseiJoho = ninteiShinseiJoho.createBuilderForEdit().setShujiiIkenshoIraiJoho(shujiiIkenshoIraiJoho).build();
        } else if (div.getRadJotaiKubun().getSelectedKey().equals(削除)) {
            ImagekanriJoho イメージ管理情報 = YokaigoninteiimagekanriFinder.createInstance().getImageJoho(管理番号.value());
            if (イメージ管理情報.get証記載保険者番号() == null
                    || イメージ管理情報.get被保険者番号() == null
                    || イメージ管理情報.getイメージ共有ファイルID() == null) {
                throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
            }
            ReadOnlySharedFileEntryDescriptor descriptor = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(
                    イメージ管理情報.get証記載保険者番号().concat(イメージ管理情報.get被保険者番号())),
                    イメージ管理情報.getイメージ共有ファイルID());
            List<RString> 存在したイメージファイル名 = YokaigoninteiimagesakujoManager.createInstance().get存在したイメージファイル名(descriptor);
            ValidationMessageControlPairs イメージ削除チェック = イメージ削除チェック(div, 存在したイメージファイル名, イメージ管理情報);
            if (イメージ削除チェック.iterator().hasNext()) {
                getValidationMessages(div, イメージ削除チェック);
            }
            RString localCopyPath = DBEImageUtil.copySharedFiles(descriptor.getSharedFileId(), descriptor.getSharedFileName().toRString());
            deleteImageFile(localCopyPath, 存在したイメージファイル名, div, descriptor);
            service.updateOrDelete(イメージ管理情報);

            ninteiShinseiJoho = ninteiShinseiJoho.createBuilderForEdit().setShujiiIkenshoIraiJoho(shujiiIkenshoIraiJoho).build().deleted();
            NinteiKanryoJoho ninteiKanryoJoho = NinteiKanryoJohoManager.createInstance().get要介護認定完了情報(管理番号);
            getHandler(div).要介護認定完了情報更新(ninteiKanryoJoho);
        }
        ninteiManager.save(ninteiShinseiJoho);
    }

    private void setShujiiIkenshoJohoCommon(ShujiiIkenshoJohoBuilder shujiiIkenshoBuilder, ShujiiIkenshoTorokuTotalDiv div) {
        shujiiIkenshoBuilder.set意見書作成回数区分(SELECT_KEY0.equals(div.getRadIkenshoSakuseiKaisu().getSelectedKey())
                ? new Code(IkenshoSakuseiKaisuKubun.初回.getコード())
                : new Code(IkenshoSakuseiKaisuKubun._2回目以降.getコード()));

        RString zaitakuShisetsuKubun = div.getRadZaitakuShisetsuKubun().getSelectedKey();
        if (!RString.isNullOrEmpty(zaitakuShisetsuKubun)) {
            shujiiIkenshoBuilder.set在宅_施設区分(new Code(zaitakuShisetsuKubun));
        }
        shujiiIkenshoBuilder.set意見書同意フラグ(SELECT_KEY0.equals(div.getRadDoi().getSelectedKey()));
        shujiiIkenshoBuilder.set最終診療日(rdateToFlex(div.getTxtSaishuShinryoYMD().getValue()));
        shujiiIkenshoBuilder.set他科受診の有無(SELECT_KEY0.equals(div.getRadTakaShinryo().getSelectedKey()));
        shujiiIkenshoBuilder.set内科受診の有無(div.getChkTakaJushinSelect().getSelectedKeys().contains(SELECT_KEY0));
        shujiiIkenshoBuilder.set精神科受診の有無(div.getChkTakaJushinSelect().getSelectedKeys().contains(SELECT_KEY1));
        shujiiIkenshoBuilder.set外科受診の有無(div.getChkTakaJushinSelect().getSelectedKeys().contains(SELECT_KEY2));
        shujiiIkenshoBuilder.set整形外科受診の有無(div.getChkTakaJushinSelect().getSelectedKeys().contains(SELECT_KEY3));
        shujiiIkenshoBuilder.set脳神経外科の有無(div.getChkTakaJushinSelect().getSelectedKeys().contains(SELECT_KEY4));
        shujiiIkenshoBuilder.set皮膚科受診の有無(div.getChkTakaJushinSelect().getSelectedKeys().contains(SELECT_KEY5));
        shujiiIkenshoBuilder.set泌尿器科受診の有無(div.getChkTakaJushinSelect().getSelectedKeys().contains(SELECT_KEY6));
        shujiiIkenshoBuilder.set婦人科受診の有無(div.getChkTakaJushinSelect().getSelectedKeys().contains(SELECT_KEY7));
        shujiiIkenshoBuilder.set眼科の有無(div.getChkTakaJushinSelect().getSelectedKeys().contains(SELECT_KEY8));
        shujiiIkenshoBuilder.set耳鼻咽喉科受診の有無(div.getChkTakaJushinSelect().getSelectedKeys().contains(SELECT_KEY9));
        shujiiIkenshoBuilder.setリハビリテーション科受診の有無(div.getChkTakaJushinSelect().getSelectedKeys().contains(SELECT_KEY10));
        shujiiIkenshoBuilder.set歯科受診の有無(div.getChkTakaJushinSelect().getSelectedKeys().contains(SELECT_KEY11));
        shujiiIkenshoBuilder.setその他受診科の有無(div.getChkSonota().getSelectedKeys().contains(SELECT_KEY0));
        shujiiIkenshoBuilder.setその他受診科名(div.getTxtSonotaNyuryoku().getValue());
        shujiiIkenshoBuilder.set認定審査会後の二次判定結果の連絡確認フラグ(div.getRadShujiiRenraku().getSelectedKey().equals(連絡必要));
        shujiiIkenshoBuilder.set意見書メモ(div.getTxtShujiiMemo().getValue());
    }

    private ValidationMessageControlPairs イメージ削除チェック(ShujiiIkenshoTorokuTotalDiv div, List<RString> 存在したイメージファイル名, ImagekanriJoho イメージ管理情報) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs イメージファイル存在チェック = getValidationHandler(div).
                イメージファイル存在チェック(存在したイメージファイル名);
        if (イメージファイル存在チェック.iterator().hasNext()) {
            return イメージファイル存在チェック;
        }
        ValidationMessageControlPairs controlPairs = 主治医意見書チェック(div, 存在したイメージファイル名,
                イメージ管理情報.get主治医医療機関コード(), イメージ管理情報.get主治医コード(),
                イメージ管理情報.get申請書管理番号().value(), イメージ管理情報.get主治医意見書作成依頼履歴番号());
        if (controlPairs.iterator().hasNext()) {
            return controlPairs;
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs 主治医意見書チェック(ShujiiIkenshoTorokuTotalDiv div, List<RString> 存在したイメージファイル名,
            RString 主治医医療機関コード, RString 主治医コード, RString 申請書管理番号, Integer 主治医意見書作成依頼履歴番号) {
        RString イメージファイルが存在区分 = getHandler(div).get主治医意見書のイメージファイルが存在区分(存在したイメージファイル名, 確認メッセージ出力区分);
        if (イメージファイルが存在区分_存在しない.equals(イメージファイルが存在区分)) {
            確認メッセージ出力区分 = RString.EMPTY;
            return getValidationHandler(div).主治医意見書イメージファイル存在チェック();
        } else {
            if (イメージファイルが存在区分_マスキング有.equals(イメージファイルが存在区分)) {
                確認メッセージ出力区分 = 確認メッセージ出力要;
            }
            FlexibleDate 主治医意見書報酬支払年月日 = YokaigoninteiimagesakujoManager.createInstance().getHoshuShiharaiYMD(
                    主治医医療機関コード, 主治医コード, new ShinseishoKanriNo(申請書管理番号), 主治医意見書作成依頼履歴番号);
            if (主治医意見書報酬支払年月日 != null && !主治医意見書報酬支払年月日.isEmpty()) {
                return getValidationHandler(div).主治医意見書報酬支払年月日チェック();
            }
        }
        return new ValidationMessageControlPairs();
    }

    private void deleteImageFile(RString localCopyPath, List<RString> imageFileList, ShujiiIkenshoTorokuTotalDiv div, ReadOnlySharedFileEntryDescriptor descriptor) {
        boolean isMaskOnly = false;
        getHandler(div).deleteOpinionImageFile(descriptor, localCopyPath, imageFileList, isMaskOnly);
    }

    private ResponseData<ShujiiIkenshoTorokuTotalDiv> getValidationMessages(ShujiiIkenshoTorokuTotalDiv div, ValidationMessageControlPairs イメージ削除チェック) {
        return ResponseData.of(div).addValidationMessages(イメージ削除チェック).respond();
    }

    private ShujiiIkenshoTorokuValidationHandler getValidationHandler(ShujiiIkenshoTorokuTotalDiv div) {
        return new ShujiiIkenshoTorokuValidationHandler(div);
    }

    private FlexibleDate rdateToFlex(RDate fromDate) {
        if (fromDate == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(fromDate.getYearValue(), fromDate.getMonthValue(), fromDate.getDayValue());
    }

    private void getEndMessage(ShujiiIkenshoTorokuTotalDiv div) {
        div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage().
                replace("主治医意見書登録").evaluate()), RString.EMPTY, RString.EMPTY, true);
    }

    private ShujiiIkenshoTorokuHandler getHandler(ShujiiIkenshoTorokuTotalDiv div) {
        return new ShujiiIkenshoTorokuHandler(div);
    }

    private void 前排他ロックキー(RString 排他ロックキー) {
        LockingKey 前排他ロックキー = new LockingKey(排他ロックキー);
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            throw new PessimisticLockingException();
        }
    }

    private void 前排他キーの解除(RString 排他) {
        LockingKey 排他キー = new LockingKey(排他);
        RealInitialLocker.release(排他キー);
    }

}

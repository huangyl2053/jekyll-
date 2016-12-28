/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2310001;

import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshotoroku.ShujiiIkenshoTorokuResult;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikensho.ninteishinseijoho.NinteiShinseiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshotoroku.ShujiiIkenshoTorokuMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001.DBE2310001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001.DBE2310001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001.ShujiiIkenshoTorokuTotalDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2310001.ShujiiIkenshoTorokuHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikensho.ninteishinseijoho.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshotoroku.ShujiiIkenshoTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

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

    /**
     * コンストラクタです。
     *
     */
    public ShujiiIkenshoTorokuTotal() {
        this.service = ShujiiIkenshoTorokuManager.createInstance();
        this.imageManager = new ImageManager();
        this.ninteiManager = NinteiShinseiJohoManager.createInstance();
    }

    /**
     * 主治医意見書登録初期化の設定します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onLoad(ShujiiIkenshoTorokuTotalDiv div) {
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        int 履歴番号 = Integer.parseInt(ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼履歴番号, RString.class).toString());
        LasdecCode 市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        ShujiiIkenshoTorokuMapperParameter param
                = ShujiiIkenshoTorokuMapperParameter.createShujiiIkenshoTorokuMapperParameter(管理番号, 履歴番号, 市町村コード);
        SearchResult<ShujiiIkenshoTorokuResult> resultList = service.getDataForLoad(param);

        if (resultList.records().isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                div.setDisabled(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_UPDATE, true);
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage().replace("主治医依頼情報未登録のため、")).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        }

        履歴番号 = resultList.records().get(0).get主治医意見書作成依頼履歴番号();
        ViewStateHolder.put(ViewStateKeys.主治医意見書作成依頼履歴番号, new RString(履歴番号));
        Image image = imageManager.getイメージ情報(管理番号);
        NinteiShinseiJoho ninteiShinseiJoho = ninteiManager.get意見書情報(NinteiShinseiJohoMapperParameter.create主治医意見書登録Param(管理番号, 履歴番号));

        if (resultList.records().get(0).get主治医意見書記入年月日() == null) {
            div.setHdnHasChanged(RString.EMPTY);
            div.getRadTakaShinryo().setSelectedKey(SELECT_KEY1);
            ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_ADD);
            getHandler(div).setChosaTishoJohoDisable(true);
            getHandler(div).setSonotaDisable(true);
            div.getTxtKinyuYMD().setDisabled(false);
        } else {
            getHandler(div).load(resultList.records().get(0));
            div.getTxtKinyuYMD().setDisabled(true);
            ViewStateHolder.put(ViewStateKeys.状態, JYOTAI_CODE_UPD);
        }
        div.setHdnHasChanged(getHandler(div).getDataRString());
        div.getCcdNinteiShinseishaKihonInfo().initialize(管理番号);
        getHandler(div).setChkTakaJushin(resultList.records().get(0));
        ViewStateHolder.put(ViewStateKeys.意見書情報, ninteiShinseiJoho);
        ViewStateHolder.put(ViewStateKeys.イメージ情報, image);
        return ResponseData.of(div).respond();
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
        return ResponseData.of(div).forwardWithEventName(DBE2310001TransitionEventName.申請者検索結果一覧に戻る).respond();
    }

    /**
     * 検索に戻るボタンを押下の場合、要介護認定申請検索へ遷移します。
     *
     * @param div 主治医意見書登録Div
     * @return ResponseData<ShujiiIkenshoTorokuTotalDiv>
     */
    public ResponseData<ShujiiIkenshoTorokuTotalDiv> onClick_btnResearch(ShujiiIkenshoTorokuTotalDiv div) {
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
        return ResponseData.of(div).forwardWithEventName(DBE2310001TransitionEventName.申請者検索に戻る).respond();
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
            RString beforeChange = getHandler(div).getDataRString();
            if ((JYOTAI_CODE_ADD.equals(state) && !beforeChange.equals(div.getHdnHasChanged()))
                    || (JYOTAI_CODE_UPD.equals(state) && !beforeChange.equals(div.getHdnHasChanged()))) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            setShujiiIkenshoJoho(state, 管理番号, 履歴番号, div);
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            setShujiiIkenshoJoho(state, 管理番号, 履歴番号, div);
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        div.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage().
                replace("主治医意見書登録").evaluate()), RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBE2310001StateName.完了状態);
    }

    private ShujiiIkenshoTorokuHandler getHandler(ShujiiIkenshoTorokuTotalDiv div) {
        return new ShujiiIkenshoTorokuHandler(div);
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
        Image image = ViewStateHolder.get(ViewStateKeys.イメージ情報, Image.class);
        if (JYOTAI_CODE_ADD.equals(flag)) {
            shujiiIkenshoBuilder.set厚労省IF識別コード(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード());
            shujiiIkenshoBuilder.set主治医意見書依頼区分(shujiiIkenshoIraiJoho.get主治医意見書依頼区分());
            shujiiIkenshoBuilder.set主治医コード(shujiiIkenshoIraiJoho.get主治医コード());
            shujiiIkenshoBuilder.set主治医医療機関コード(shujiiIkenshoIraiJoho.get主治医医療機関コード());
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
            setShujiiIkenshoJohoCommon(shujiiIkenshoBuilder, div);
            shujiiIkenshoJoho = shujiiIkenshoBuilder.build();
            shujiiIkenshoJoho = shujiiIkenshoJoho.modifiedModel();
        }
        shujiiIkenshoIraiJoho = shujiiIkenshoIraiJoho.createBuilderForEdit().setShujiiIkenshoJoho(shujiiIkenshoJoho).build();
        ninteiShinseiJoho = ninteiShinseiJoho.createBuilderForEdit().setShujiiIkenshoIraiJoho(shujiiIkenshoIraiJoho).build();
        ninteiManager.save(ninteiShinseiJoho);
        if (image != null) {
            imageManager.saveイメージ情報(image);
        }
    }

    private void setShujiiIkenshoJohoCommon(ShujiiIkenshoJohoBuilder shujiiIkenshoBuilder, ShujiiIkenshoTorokuTotalDiv div) {
        shujiiIkenshoBuilder.set意見書作成回数区分(SELECT_KEY0.equals(div.getRadIkenshoSakuseiKaisu().getSelectedKey())
                ? new Code(IkenshoSakuseiKaisuKubun.初回.getコード())
                : new Code(IkenshoSakuseiKaisuKubun._2回目以降.getコード()));
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
        shujiiIkenshoBuilder.set意見書メモ(div.getTxtShujiiMemo().getValue());
    }

    private FlexibleDate rdateToFlex(RDate fromDate) {
        if (fromDate == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(fromDate.getYearValue(), fromDate.getMonthValue(), fromDate.getDayValue());
    }
}

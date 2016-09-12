/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.DBZA010001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo.FuseigoCheckResult;
import jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo.FuseigoCheckResultOfTatokurei;
import jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo.FuseigoCheckResultOfTekiyoJogai;
import jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo.ShikakuFuseigoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo.ShikakuFuseigoShusei;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.fuseigoriyu.FuseigoRiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakufuseigo.DaichoFuseigoJotai;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001.DBZA010001StateName;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001.ShikakuFuseigoShuseiMainDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZA010001.ShikakuFuseigoShuseiMainHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZA010001.ShikakuFuseigoShuseiMainValidationHandler;
import jp.co.ndensan.reams.db.dbz.service.core.shikakufuseigo.ShikakuFuseigoShuseiService;
import jp.co.ndensan.reams.db.dbz.service.core.shikakufuseigo.ShikakuSeigoseiCheckJohoManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 資格不整合修正のコントローラです。
 *
 * @reamsid_L DBB-0630-010 chengsanyuan
 */
public class ShikakuFuseigoShuseiMain {

    private final ShikakuSeigoseiCheckJohoManager manager;
    private final ShikakuFuseigoShuseiService serivce;

    /**
     * コンストラクタです。
     *
     */
    public ShikakuFuseigoShuseiMain() {
        this.manager = ShikakuSeigoseiCheckJohoManager.createInstance();
        this.serivce = ShikakuFuseigoShuseiService.createInstance();
    }

    /**
     * 資格不整合修正初期化の設定します。
     *
     * @param div 資格不整合修正Div
     * @return ResponseData<ShikakuFuseigoShuseiMainDiv>
     */
    public ResponseData<ShikakuFuseigoShuseiMainDiv> onLoad(ShikakuFuseigoShuseiMainDiv div) {
        SearchResult<ShikakuFuseigoBusiness> resultList = manager.get被保険者資格不整合一覧();
        ShikakuFuseigoShusei business = new ShikakuFuseigoShusei();
        business.setBusinessList(resultList.records());
        ViewStateHolder.put(ViewStateKeys.整合性チェックの情報_宛名, business);
        getHandler(div).load(resultList.records());
        return ResponseData.of(div).setState(DBZA010001StateName.不整合一覧);
    }

    /**
     * DDLの選択項目に合わせてグリッドの表示を変更します。
     *
     * @param div 資格不整合修正Div
     * @return ResponseData<ShikakuFuseigoShuseiMainDiv>
     */
    public ResponseData<ShikakuFuseigoShuseiMainDiv> onChange_ddlDaichoShubetsu(ShikakuFuseigoShuseiMainDiv div) {
        ShikakuFuseigoShusei business = ViewStateHolder.get(
                ViewStateKeys.整合性チェックの情報_宛名, ShikakuFuseigoShusei.class);
        getHandler(div).setDataGridByDaichoType(business.getBusinessList(), div.getDdlDaichoShubetsu().getSelectedKey(),
                !div.getChkTaishoGaiHyoji().getSelectedKeys().isEmpty());
        return ResponseData.of(div).respond();
    }

    /**
     * 資格不整合一覧表示結果の連動を変更します。
     *
     * @param div 資格不整合修正Div
     * @return ResponseData<ShikakuFuseigoShuseiMainDiv>
     */
    public ResponseData<ShikakuFuseigoShuseiMainDiv> onChange_chkTaishoGaiHyoji(ShikakuFuseigoShuseiMainDiv div) {
        ShikakuFuseigoShusei business = ViewStateHolder.get(
                ViewStateKeys.整合性チェックの情報_宛名, ShikakuFuseigoShusei.class);
        getHandler(div).setDataGridByDaichoType(business.getBusinessList(), div.getDdlDaichoShubetsu().getSelectedKey(),
                !div.getChkTaishoGaiHyoji().getSelectedKeys().isEmpty());
        return ResponseData.of(div).respond();
    }

    /**
     * 「資格不整合一覧の修正」アイコンをクリックの場合、資格修正エリアのデータを設定します。
     *
     * @param div 資格不整合修正Div
     * @return ResponseData<ShikakuFuseigoShuseiMainDiv>
     */
    public ResponseData<ShikakuFuseigoShuseiMainDiv> onSelectByModifyButton_dgShikakuFuseigoIchiran(ShikakuFuseigoShuseiMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ShikakuFuseigoShusei business = ViewStateHolder.get(
                    ViewStateKeys.整合性チェックの情報_宛名, ShikakuFuseigoShusei.class);
            RString 被保番号 = div.getDgShikakuFuseigoIchiran().getClickedItem().getHihoNo();
            RString 識別コード = div.getDgShikakuFuseigoIchiran().getClickedItem().getShikibetsuCode();
            if (整合性チェックの処理(business, 被保番号, 識別コード)) {
                return ResponseData.of(div).addMessage(DbzInformationMessages.不整合解消済み.getMessage()).respond();
            }
            RString 不整合理由コード = ViewStateHolder.get(ViewStateKeys.不整合修正中,
                    ShikakuFuseigoBusiness.class).get不整合理由コード();
            if (!不整合理由コード.equals(
                    ViewStateHolder.get(ViewStateKeys.不整合理由, FuseigoRiyu.class).getコード())) {
                ViewStateHolder.put(ViewStateKeys.台帳状態, RString.EMPTY);
                return ResponseData.of(div).addMessage(
                        DbzInformationMessages.不整合内容相違.getMessage().replace(
                                FuseigoRiyu.toValue(不整合理由コード).get名称().toString(),
                                ViewStateHolder.get(ViewStateKeys.不整合理由,
                                        FuseigoRiyu.class).get名称().toString())).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return onLoad(div);
        }
        DaichoFuseigoJotai 台帳状態 = ViewStateHolder.get(ViewStateKeys.台帳状態, DaichoFuseigoJotai.class);
        ViewStateHolder.put(ViewStateKeys.台帳状態, null);
        if (台帳状態 == DaichoFuseigoJotai.不整合あり) {
            RString 台帳種別 = ViewStateHolder.get(ViewStateKeys.不整合修正中, ShikakuFuseigoBusiness.class).get台帳種別();
            IKojin 個人情報 = ViewStateHolder.get(ViewStateKeys.個人情報, IKojin.class);
            FuseigoRiyu 不整合理由 = ViewStateHolder.get(ViewStateKeys.不整合理由, FuseigoRiyu.class);
            div.getShikakuFuseigoIchiran().setDisabled(true);
            if (台帳種別.equals(DaichoType.被保険者.getコード())) {
                HihokenshaDaicho 現在の資格の情報 = ViewStateHolder.get(ViewStateKeys.現在の資格の情報, HihokenshaDaicho.class);
                HihokenshaDaicho 修正後の資格の情報 = ViewStateHolder.get(ViewStateKeys.修正後の資格の情報, HihokenshaDaicho.class);
                ShikakuShutokuJogaisha 資格取得除外の情報 = ViewStateHolder.get(ViewStateKeys.取得除外の情報, ShikakuShutokuJogaisha.class);
                getHandler(div).setHihokenshaMeisai(不整合理由, 個人情報, 現在の資格の情報, 修正後の資格の情報, 資格取得除外の情報);
                return ResponseData.of(div).setState(DBZA010001StateName.資格修正);
            }
            if (台帳種別.equals(DaichoType.適用除外者.getコード())) {
                TekiyoJogaisha 現在の他特の情報 = ViewStateHolder.get(ViewStateKeys.現在の除外の情報, TekiyoJogaisha.class);
                TekiyoJogaisha 修正後の他特の情報 = ViewStateHolder.get(ViewStateKeys.修正後の除外の情報, TekiyoJogaisha.class);
                getHandler(div).setTekiyoMeisai(不整合理由, 個人情報, 現在の他特の情報, 修正後の他特の情報);
                return ResponseData.of(div).setState(DBZA010001StateName.除外者修正);
            }
            if (台帳種別.equals(DaichoType.他市町村住所地特例者.getコード())) {
                TashichosonJushochiTokurei 現在の他特の情報 = ViewStateHolder.get(ViewStateKeys.現在の他特の情報,
                        TashichosonJushochiTokurei.class);
                TashichosonJushochiTokurei 修正後の他特の情報 = ViewStateHolder.get(ViewStateKeys.修正後の他特の情報,
                        TashichosonJushochiTokurei.class);
                getHandler(div).setTashichosonMeisai(不整合理由, 個人情報, 現在の他特の情報, 修正後の他特の情報);
                return ResponseData.of(div).setState(DBZA010001StateName.他特修正);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 資格修正明細エリア表示の連動
     *
     * @param div 資格不整合修正Div
     * @return ResponseData<ShikakuFuseigoShuseiMainDiv>
     */
    public ResponseData<ShikakuFuseigoShuseiMainDiv> onChange_chkToTaishoGai(ShikakuFuseigoShuseiMainDiv div) {
        if (div.getChkToTaishoGai().isAllSelected()) {
            div.getShikakuShutokuJogaiSettei().setDisabled(true);
            div.getTekiyoJogaiKaijo().setDisabled(true);
            div.getTekiyoJogaiTekiyo().setDisabled(true);
            div.getTatokuKaijo().setDisabled(true);
            div.getTatokuTekiyo().setDisabled(true);
            div.getShikakuSoshitsu().setDisabled(true);
            div.getJushochiTokureiTekiyo().setDisabled(true);
            div.getShikakuHenko().setDisabled(true);
            div.getSikakuShutoku().setDisabled(true);
        } else {
            div.getShikakuShutokuJogaiSettei().setDisabled(false);
            div.getTekiyoJogaiKaijo().setDisabled(false);
            div.getTekiyoJogaiTekiyo().setDisabled(false);
            div.getTatokuKaijo().setDisabled(false);
            div.getTatokuTekiyo().setDisabled(false);
            div.getShikakuSoshitsu().setDisabled(false);
            div.getJushochiTokureiTekiyo().setDisabled(false);
            div.getShikakuHenko().setDisabled(false);
            div.getSikakuShutoku().setDisabled(false);
            IKojin 個人情報 = ViewStateHolder.get(ViewStateKeys.個人情報, IKojin.class);
            FuseigoRiyu 不整合理由 = ViewStateHolder.get(ViewStateKeys.不整合理由, FuseigoRiyu.class);
            HihokenshaDaicho 現在の資格の情報 = ViewStateHolder.get(ViewStateKeys.現在の資格の情報, HihokenshaDaicho.class);
            HihokenshaDaicho 修正後の資格の情報 = ViewStateHolder.get(ViewStateKeys.修正後の資格の情報, HihokenshaDaicho.class);
            ShikakuShutokuJogaisha 資格取得除外の情報 = ViewStateHolder.get(ViewStateKeys.取得除外の情報, ShikakuShutokuJogaisha.class);
            getHandler(div).setHihokenshaMeisai(不整合理由, 個人情報, 現在の資格の情報, 修正後の資格の情報, 資格取得除外の情報);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 住所地特例適用エリア、資格喪失エリアの表示切替
     *
     * @param div 資格不整合修正Div
     * @return ResponseData<ShikakuFuseigoShuseiMainDiv>
     */
    public ResponseData<ShikakuFuseigoShuseiMainDiv> onChange_chkJutoku(ShikakuFuseigoShuseiMainDiv div) {
        FuseigoRiyu 不整合理由 = ViewStateHolder.get(ViewStateKeys.不整合理由, FuseigoRiyu.class);
        getHandler(div).setShikakuSoushitu(不整合理由);
        return ResponseData.of(div).respond();
    }

    /**
     * 資格取得エリア、取得除外エリアの表示切替
     *
     * @param div 資格不整合修正Div
     * @return ResponseData<ShikakuFuseigoShuseiMainDiv>
     */
    public ResponseData<ShikakuFuseigoShuseiMainDiv> onChange_chkShutokuJogai(ShikakuFuseigoShuseiMainDiv div) {
        FuseigoRiyu 不整合理由 = ViewStateHolder.get(ViewStateKeys.不整合理由, FuseigoRiyu.class);
        getHandler(div).setSyutokuJogai(不整合理由);
        return ResponseData.of(div).respond();
    }

    /**
     * 資格情報の更新処理
     *
     * @param div 資格不整合修正Div
     * @return ResponseData<ShikakuFuseigoShuseiMainDiv>
     */
    public ResponseData<ShikakuFuseigoShuseiMainDiv> onClick_btnCommitDialog(ShikakuFuseigoShuseiMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        ShikakuFuseigoBusiness shikakuFusei = ViewStateHolder.get(ViewStateKeys.不整合修正中, ShikakuFuseigoBusiness.class);
        RString 台帳種別 = shikakuFusei.get台帳種別();
        HihokenshaDaicho 修正後の資格の情報 = ViewStateHolder.get(ViewStateKeys.修正後の資格の情報, HihokenshaDaicho.class);
        TekiyoJogaisha 修正後の除外の情報 = ViewStateHolder.get(ViewStateKeys.修正後の除外の情報, TekiyoJogaisha.class);
        TashichosonJushochiTokurei 修正後の他特の情報 = ViewStateHolder.get(ViewStateKeys.修正後の他特の情報, TashichosonJushochiTokurei.class);
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes && div.getChkToTaishoGai().isAllSelected()) {
            manager.saveAs対象外(shikakuFusei.get整合性チェック情報());
            div.getShikakuFuseigoIchiran().setDisabled(false);
            setアクセスログ(shikakuFusei.get整合性チェック情報().get識別コード());
            return onLoad(div);
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        FuseigoRiyu 不整合理由 = ViewStateHolder.get(ViewStateKeys.不整合理由, FuseigoRiyu.class);
        if (台帳種別.equals(DaichoType.被保険者.getコード())) {
            修正後の資格の情報 = getHandler(div).set資格の情報(不整合理由, 修正後の資格の情報);
            int 履歴番号 = manager.getMax履歴番号(修正後の資格の情報.get識別コード());
            ShikakuShutokuJogaisha 取得除外の情報 = getHandler(div).set取得除外の情報(不整合理由, 履歴番号, 修正後の資格の情報);
            validationMessages.add(getValidationHandler(div).beforeUpdCheck(台帳種別, shikakuFusei,
                    修正後の資格の情報, 修正後の除外の情報, 修正後の他特の情報));
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            save修正後の情報By被保険者(shikakuFusei, div, 修正後の資格の情報, 取得除外の情報);
            setアクセスログ(修正後の資格の情報.get識別コード());
        }
        if (台帳種別.equals(DaichoType.適用除外者.getコード())) {
            修正後の除外の情報 = getHandler(div).set除外の情報(不整合理由, 修正後の除外の情報);
            validationMessages.add(getValidationHandler(div).beforeUpdCheck(台帳種別, shikakuFusei,
                    修正後の資格の情報, 修正後の除外の情報, 修正後の他特の情報));
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            manager.save除外情報(
                    ViewStateHolder.get(ViewStateKeys.現在の除外の情報, TekiyoJogaisha.class),
                    修正後の除外の情報,
                    shikakuFusei.get整合性チェック情報());
            setアクセスログ(修正後の除外の情報.get識別コード());
        }
        if (台帳種別.equals(DaichoType.他市町村住所地特例者.getコード())) {
            修正後の他特の情報 = getHandler(div).set他特の情報(不整合理由, 修正後の他特の情報);
            validationMessages.add(getValidationHandler(div).beforeUpdCheck(台帳種別, shikakuFusei,
                    修正後の資格の情報, 修正後の除外の情報, 修正後の他特の情報));
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            manager.save他特情報(
                    ViewStateHolder.get(ViewStateKeys.現在の他特の情報, TashichosonJushochiTokurei.class),
                    修正後の他特の情報,
                    shikakuFusei.get整合性チェック情報());
            setアクセスログ(修正後の他特の情報.get識別コード());
        }
        div.getShikakuFuseigoIchiran().setDisabled(false);
        return onLoad(div);
    }

    private void save修正後の情報By被保険者(ShikakuFuseigoBusiness shikakuFusei,
            ShikakuFuseigoShuseiMainDiv div, HihokenshaDaicho 修正後の資格の情報, ShikakuShutokuJogaisha 取得除外の情報) {
        if (div.getChkShutokuJogai().isAllSelected()) {
            manager.save取得除外情報(取得除外の情報,
                    shikakuFusei.get整合性チェック情報());
        } else {
            manager.save資格情報(
                    ViewStateHolder.get(ViewStateKeys.現在の資格の情報, HihokenshaDaicho.class),
                    修正後の資格の情報,
                    shikakuFusei.get整合性チェック情報());
        }
    }

    /**
     * 画面初期化検索を実施して、画面再表示する。
     *
     * @param div 資格不整合修正Div
     * @return ResponseData<ShikakuFuseigoShuseiMainDiv>
     */
    public ResponseData<ShikakuFuseigoShuseiMainDiv> onClick_btnCancel(ShikakuFuseigoShuseiMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getShikakuFuseigoIchiran().setDisabled(false);
            return onLoad(div);
        }
        return ResponseData.of(div).respond();
    }

    private ShikakuFuseigoShuseiMainHandler getHandler(ShikakuFuseigoShuseiMainDiv div) {
        return new ShikakuFuseigoShuseiMainHandler(div);
    }

    private ShikakuFuseigoShuseiMainValidationHandler getValidationHandler(ShikakuFuseigoShuseiMainDiv div) {
        return new ShikakuFuseigoShuseiMainValidationHandler(div);
    }

    private boolean 整合性チェックの処理(ShikakuFuseigoShusei business, RString 被保番号, RString 識別コード) {
        for (ShikakuFuseigoBusiness shikakuFusei : business.getBusinessList()) {
            if (識別コード.equals(shikakuFusei.get識別コード().value())) {
                ViewStateHolder.put(ViewStateKeys.不整合修正中, shikakuFusei);
                switch (DaichoType.toValue(shikakuFusei.get台帳種別())) {
                    case 被保険者:
                        FuseigoCheckResult result = serivce.checkAndCorrect被保険者資格不整合(shikakuFusei.get個人情報(),
                                new HihokenshaNo(被保番号));
                        ViewStateHolder.put(ViewStateKeys.現在の資格の情報, result.get現在の資格の情報());
                        ViewStateHolder.put(ViewStateKeys.修正後の資格の情報, result.get修正後の資格の情報());
                        ViewStateHolder.put(ViewStateKeys.不整合理由, result.get不整合理由());
                        ViewStateHolder.put(ViewStateKeys.個人情報, result.get個人());
                        ViewStateHolder.put(ViewStateKeys.台帳状態, result.get被保険者台帳状態());
                        break;
                    case 適用除外者:
                        FuseigoCheckResultOfTekiyoJogai resultTekiyoJogai = serivce.checkAndCorrect適用除外者不整合(shikakuFusei.get個人情報(),
                                new ShikibetsuCode(識別コード));
                        ViewStateHolder.put(ViewStateKeys.現在の除外の情報, resultTekiyoJogai.get現在の除外の情報());
                        ViewStateHolder.put(ViewStateKeys.修正後の除外の情報, resultTekiyoJogai.get修正後の除外の情報());
                        ViewStateHolder.put(ViewStateKeys.不整合理由, resultTekiyoJogai.get不整合理由());
                        ViewStateHolder.put(ViewStateKeys.個人情報, resultTekiyoJogai.get個人());
                        ViewStateHolder.put(ViewStateKeys.台帳状態, resultTekiyoJogai.get適用除外者台帳状態());
                        break;
                    case 他市町村住所地特例者:
                        FuseigoCheckResultOfTatokurei resultTatokurei = serivce.checkAndCorrect他特例不整合(shikakuFusei.get個人情報(),
                                new ShikibetsuCode(識別コード));
                        ViewStateHolder.put(ViewStateKeys.現在の他特の情報, resultTatokurei.get現在の他特の情報());
                        ViewStateHolder.put(ViewStateKeys.修正後の他特の情報, resultTatokurei.get修正後の他特の情報());
                        ViewStateHolder.put(ViewStateKeys.不整合理由, resultTatokurei.get不整合理由());
                        ViewStateHolder.put(ViewStateKeys.個人情報, resultTatokurei.get個人());
                        ViewStateHolder.put(ViewStateKeys.台帳状態, resultTatokurei.get他市町村住所地特例台帳状態());
                        break;
                    default:
                        break;
                }
            }
            DaichoFuseigoJotai 台帳状態 = ViewStateHolder.get(ViewStateKeys.台帳状態, DaichoFuseigoJotai.class);
            if (台帳状態 != null) {
                if (台帳状態 == DaichoFuseigoJotai.不整合なし) {
                    business.getBusinessList().remove(shikakuFusei);
                    ViewStateHolder.put(ViewStateKeys.整合性チェックの情報_宛名, business);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private void setアクセスログ(ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("識別コード"), 識別コード.value());
        AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード, expandedInfo));
    }
}

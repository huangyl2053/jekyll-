/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1600011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SaishinsaMoshitate;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SaishinsaMoshitateBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.KyufuJissekiGaitoshaBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.SaishinsaMoshitateJohoBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.SaishinsaMoshitateTourokuBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.SaishinsaMoshitateTourokuCollect;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.ServiceCodeBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.ServiceShuruiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.TokuteiSinryoShikibetsuBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsamoshitatetouroku.SaishinsaMoshitateTourokuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1600011.DBC1600011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1600011.DBC1600011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1600011.SaishinsaMoshitateTourokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1600011.SaishinsaMoshitateTourokuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1600011.SaishinsaMoshitateTourokuPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.saishinsamoshitatetouroku.HihokenshaDaichoAliveManager;
import jp.co.ndensan.reams.db.dbc.service.core.saishinsamoshitatetouroku.SaishinsaMoshitateManager;
import jp.co.ndensan.reams.db.dbc.service.core.saishinsamoshitatetouroku.SaishinsaMoshitateTouroku;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護給付費再審査申立書作成のコントローラクラスです。
 *
 * @reamsid_L DBC-2230-010 chenxiangyu
 */
public class SaishinsaMoshitateTourokuPanel {

    private static final RString TRUE = new RString(Boolean.TRUE.toString());
    private static final RString FALSE = new RString(Boolean.FALSE.toString());
    private static final RString 登録モード = new RString("登録モード");
    private static final RString 修正モード = new RString("修正モード");
    private static final RString 削除モード = new RString("削除モード");
    private static final RString 初期化状態 = new RString("初期化状態");
    private static final RString 対象者検索戻る状態 = new RString("対象者検索戻る状態");
    private static final RString 再審査申立情報一覧モード = new RString("再審査申立情報一覧");
    private static final RString 給付実績該当者一覧モード = new RString("給付実績該当者一覧");
    private static final RString サービス種類 = new RString("サービス種類");
    private static final RString サービスコード = new RString("サービスコード");
    private static final RString MESSAGE = new RString("再審査申立テーブルを更新しました。");
    private static final RString 排他キー = new RString("DBCHihokenshaNo");
    private static final int ONE = 1;

    /**
     * 画面初期化します。
     *
     * @param div 画面情報
     * @return ResponseData<SaishinsaMoshitateTourokuPanelDiv>
     */
    public ResponseData<SaishinsaMoshitateTourokuPanelDiv> onLoad(SaishinsaMoshitateTourokuPanelDiv div) {
        SaishinsaMoshitateTourokuCollect collect = DataPassingConverter.deserialize(
                div.getHdn一覧検索条件(),
                SaishinsaMoshitateTourokuCollect.class);
        if (collect == null) {
            collect = ViewStateHolder.get(ViewStateKeys.一覧検索キー, SaishinsaMoshitateTourokuCollect.class);
        }
        if (collect == null || 初期化状態.equals(collect.get画面状態())) {
            if (collect != null && TRUE.equals(div.getHdn再検索フラグ())) {
                SaishinsaMoshitateTourokuMybatisParameter parameter = SaishinsaMoshitateTourokuMybatisParameter.createMybatisParameter(
                        collect.get被保険者番号(),
                        collect.get事業所番号(),
                        getHandler(div).get保険者番号の選択値(collect.get保険者番号()),
                        collect.get提供年月開始(),
                        collect.get提供年月終了());
                List<SaishinsaMoshitateJohoBusiness> 再審査申立情報一覧 = SaishinsaMoshitateTouroku.createInstance()
                        .selectSaishinsaMoshitateJohoList(parameter);
                getHandler(div).set再審査申立情報一覧(再審査申立情報一覧);
            }
        } else if (対象者検索戻る状態.equals(collect.get画面状態())) {
            TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            if (資格対象者.get被保険者番号() != null && !資格対象者.get被保険者番号().isEmpty()) {
                div.getSearchToKyufujissekiPanel().getTxtHihoNo().setValue(資格対象者.get被保険者番号().value());
                div.getSearchToKyufujissekiPanel().getTxtHihoName().setValue(get被保名称(資格対象者.get識別コード()));
            } else {
                div.getSearchToKyufujissekiPanel().getTxtHihoNo().setValue(collect.get被保険者番号());
                div.getSearchToKyufujissekiPanel().getTxtHihoName().setValue(collect.get被保険者名称());
            }
            div.getSearchToKyufujissekiPanel().getTextBox1().setValue(collect.get事業所番号());
            div.getSearchToKyufujissekiPanel().getTxtJigyoshaName().setValue(collect.get事業者名称());
            if (collect.get提供年月開始() != null) {
                div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().setFromValue(
                        new RDate(collect.get提供年月開始().toString()));
            }
            if (collect.get提供年月終了() != null) {
                div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().setToValue(
                        new RDate(collect.get提供年月終了().toString()));
            }
            if (collect.get市町村コード() != null) {
                div.getSearchToKyufujissekiPanel().getHokenshaList().setSelectedShichosonIfExist(
                        new LasdecCode(collect.get市町村コード()));
            }
            if (再審査申立情報一覧モード.equals(collect.get一覧モード())) {
                getHandler(div).setState再審査申立情報一覧画面();
                getHandler(div).set再審査申立情報一覧(collect.get再審査申立情報List());
            } else if (給付実績該当者一覧モード.equals(collect.get一覧モード())) {
                getHandler(div).setState給付実績該当者一覧画面();
                getHandler(div).set給付実績一覧(collect.get給付実績情報List());
            }
            div.setHdn一覧検索条件(DataPassingConverter.serialize(collect));
        }
        getHandler(div).set保険者リスト();
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBC1600011StateName.search);
    }

    /**
     * 「被保番号検索」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SaishinsaMoshitateTourokuPanelDiv>
     */
    public ResponseData<SaishinsaMoshitateTourokuPanelDiv> onClick_btnSearchHihokensha(SaishinsaMoshitateTourokuPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.資格対象者, null);
        SaishinsaMoshitateTourokuCollect collect = DataPassingConverter.deserialize(
                div.getHdn一覧検索条件(),
                SaishinsaMoshitateTourokuCollect.class);
        if (collect == null) {
            collect = new SaishinsaMoshitateTourokuCollect();
        }
        getHandler(div).set一時検索条件(collect.get再審査申立情報List(), collect.get給付実績情報List());
        SaishinsaMoshitateTourokuCollect 一覧検索キー = DataPassingConverter.deserialize(
                div.getHdn一覧検索条件(), SaishinsaMoshitateTourokuCollect.class);
        一覧検索キー.set画面状態(対象者検索戻る状態);
        ViewStateHolder.put(ViewStateKeys.一覧検索キー, 一覧検索キー);
        return ResponseData.of(div).forwardWithEventName(DBC1600011TransitionEventName.対象者検索).respond();
    }

    /**
     * 「被保番号」をブラーします。
     *
     * @param div 画面情報
     * @return ResponseData<SaishinsaMoshitateTourokuPanelDiv>
     */
    public ResponseData<SaishinsaMoshitateTourokuPanelDiv> onBlur_txtHihoNo(SaishinsaMoshitateTourokuPanelDiv div) {
        if (RString.isNullOrEmpty(div.getSearchToKyufujissekiPanel().getTxtHihoNo().getValue())) {
            div.getSearchToKyufujissekiPanel().getTxtHihoName().clearValue();
        } else {
            HihokenshaDaichoAliveManager manager = new HihokenshaDaichoAliveManager();
            HihokenshaDaichoAlive date = manager.get最新の被保険者台帳情報(
                    div.getSearchToKyufujissekiPanel().getTxtHihoNo().getValue());
            if (date == null) {
                div.getSearchToKyufujissekiPanel().getTxtHihoName().clearValue();
                return ResponseData.of(div).addValidationMessages(getValidationHandler(div)
                        .get存在しないエラーメッセージ()).respond();
            }
            div.getSearchToKyufujissekiPanel().getTxtHihoName().setValue(get被保名称(date.get識別コード()));
        }
        return ResponseData.of(div).setState(DBC1600011StateName.search);
    }

    /**
     * 「再審査申立情報を検索する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SaishinsaMoshitateTourokuPanelDiv>
     */
    public ResponseData<SaishinsaMoshitateTourokuPanelDiv> onClick_btnSaishinsaMoshitateSearch(
            SaishinsaMoshitateTourokuPanelDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).check被保番号と支援事業者番号の入力関連();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        ValidationMessageControlPairs validPairs1 = getValidationHandler(div).check提供年月開始と提供年月終了の必須入力();
        if (validPairs1.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs1).respond();
        }
        ValidationMessageControlPairs validPairs2 = getValidationHandler(div).check提供年月開始と提供年月終了の比較();
        if (validPairs2.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs2).respond();
        }
        SaishinsaMoshitateTourokuMybatisParameter parameter = SaishinsaMoshitateTourokuMybatisParameter.createMybatisParameter(
                div.getSearchToKyufujissekiPanel().getTxtHihoNo().getValue(),
                div.getSearchToKyufujissekiPanel().getTextBox1().getValue(),
                getHandler(div).get保険者番号の選択値(
                        getHandler(div).get保険者リストの値()),
                div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().getFromValue().getYearMonth().toDateString(),
                div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().getToValue().getYearMonth().toDateString());
        List<SaishinsaMoshitateJohoBusiness> 再審査申立情報一覧 = SaishinsaMoshitateTouroku.createInstance()
                .selectSaishinsaMoshitateJohoList(parameter);
        getHandler(div).set再審査申立情報一覧(再審査申立情報一覧);
        getHandler(div).set一時検索条件(再審査申立情報一覧, null);
        return ResponseData.of(div).setState(DBC1600011StateName.search);
    }

    /**
     * 「給付実績を検索する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SaishinsaMoshitateTourokuPanelDiv>
     */
    public ResponseData<SaishinsaMoshitateTourokuPanelDiv> onClick_btnKyufuJissekiSearch(
            SaishinsaMoshitateTourokuPanelDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).check提供年月開始と提供年月終了の必須入力();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        SaishinsaMoshitateTourokuMybatisParameter parameter = SaishinsaMoshitateTourokuMybatisParameter.createMybatisParameter(
                div.getSearchToKyufujissekiPanel().getTxtHihoNo().getValue(),
                div.getSearchToKyufujissekiPanel().getTextBox1().getValue(),
                getHandler(div).get保険者番号の選択値(
                        getHandler(div).get保険者リストの値()),
                div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().getFromValue().getYearMonth().toDateString(),
                div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().getToValue().getYearMonth().toDateString());
        List<KyufuJissekiGaitoshaBusiness> 給付実績該当者一覧 = SaishinsaMoshitateTouroku.createInstance()
                .selectKyufuJissekiList(parameter);
        getHandler(div).set給付実績一覧(給付実績該当者一覧);
        getHandler(div).set一時検索条件(null, 給付実績該当者一覧);
        return ResponseData.of(div).setState(DBC1600011StateName.search);
    }

    /**
     * 「選択」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SaishinsaMoshitateTourokuPanelDiv>
     */
    public ResponseData<SaishinsaMoshitateTourokuPanelDiv> onClick_btnSelect(SaishinsaMoshitateTourokuPanelDiv div) {
        RString 被保険者番号 = div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtHiHoekNo();
        SaishinsaMoshitateTourokuMybatisParameter parameter = SaishinsaMoshitateTourokuMybatisParameter.createMybatisParameter(
                被保険者番号,
                div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtTeikyoYM(),
                div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtJigyoshaNo());
        List<ServiceShuruiBusiness> サービス種類リスト = SaishinsaMoshitateTouroku.createInstance()
                .selectSabisuShuruiList(parameter);
        List<ServiceCodeBusiness> サービスコードリスト = SaishinsaMoshitateTouroku.createInstance()
                .selectSabisuKodoList(parameter);
        List<TokuteiSinryoShikibetsuBusiness> 特定診療識別リスト = SaishinsaMoshitateTouroku.createInstance()
                .selectTokuteiShinryoShikibetsuList(parameter);
        if (サービス種類リスト == null && サービスコードリスト == null && 特定診療識別リスト == null) {
            return ResponseData.of(div).addValidationMessages(getValidationHandler(div).get再審査対象なしエラーメッセージ()).respond();
        }
        getHandler(div).再審査申立書登録表示初期化(登録モード, サービス種類リスト, サービスコードリスト, 特定診療識別リスト);
        ResponseData<SaishinsaMoshitateTourokuPanelDiv> responseData;
        RString 前排他キー = 排他キー.concat(
                div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtHiHoekNo());
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            responseData = ResponseData.of(div).setState(DBC1600011StateName.detail_notUpdate);
            responseData.addValidationMessages(getValidationHandler(div).get他のユーザが使用中エラーメッセージ());
            div.getKagoMoshitatePanel().setHdn排他状態フラグ(FALSE);
        } else {
            responseData = ResponseData.of(div).setState(DBC1600011StateName.detail);
            div.getKagoMoshitatePanel().setHdn排他状態フラグ(TRUE);
        }
        return responseData;
    }

    /**
     * 「修正」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SaishinsaMoshitateTourokuPanelDiv>
     */
    public ResponseData<SaishinsaMoshitateTourokuPanelDiv> onClick_btnModify(SaishinsaMoshitateTourokuPanelDiv div) {
        RString 被保険者番号 = div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtHiHoekNo();
        SaishinsaMoshitateTourokuMybatisParameter parameter = SaishinsaMoshitateTourokuMybatisParameter.createMybatisParameter(
                被保険者番号,
                div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtTeikyoYM(),
                div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtJigyoshaNo());
        List<ServiceShuruiBusiness> サービス種類リスト = SaishinsaMoshitateTouroku.createInstance()
                .selectSabisuShuruiList(parameter);
        List<ServiceCodeBusiness> サービスコードリスト = SaishinsaMoshitateTouroku.createInstance()
                .selectSabisuKodoList(parameter);
        List<TokuteiSinryoShikibetsuBusiness> 特定診療識別リスト = SaishinsaMoshitateTouroku.createInstance()
                .selectTokuteiShinryoShikibetsuList(parameter);
        getHandler(div).再審査申立書登録表示初期化(修正モード, サービス種類リスト, サービスコードリスト, 特定診療識別リスト);
        ResponseData<SaishinsaMoshitateTourokuPanelDiv> responseData;
        RString 前排他キー = 排他キー.concat(
                div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtHiHoekNo());
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            responseData = ResponseData.of(div).setState(DBC1600011StateName.detail_notUpdate);
            responseData.addValidationMessages(getValidationHandler(div).get他のユーザが使用中エラーメッセージ());
            div.getKagoMoshitatePanel().setHdn排他状態フラグ(FALSE);
        } else {
            responseData = ResponseData.of(div).setState(DBC1600011StateName.detail);
            div.getKagoMoshitatePanel().setHdn排他状態フラグ(TRUE);
        }
        return responseData;
    }

    /**
     * 「削除」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SaishinsaMoshitateTourokuPanelDiv>
     */
    public ResponseData<SaishinsaMoshitateTourokuPanelDiv> onClick_btnDelete(SaishinsaMoshitateTourokuPanelDiv div) {
        RString 被保険者番号 = div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtHiHoekNo();
        SaishinsaMoshitateTourokuMybatisParameter parameter = SaishinsaMoshitateTourokuMybatisParameter.createMybatisParameter(
                被保険者番号,
                div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtTeikyoYM(),
                div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtJigyoshaNo());
        List<ServiceShuruiBusiness> サービス種類リスト = SaishinsaMoshitateTouroku.createInstance()
                .selectSabisuShuruiList(parameter);
        List<ServiceCodeBusiness> サービスコードリスト = SaishinsaMoshitateTouroku.createInstance()
                .selectSabisuKodoList(parameter);
        List<TokuteiSinryoShikibetsuBusiness> 特定診療識別リスト = SaishinsaMoshitateTouroku.createInstance()
                .selectTokuteiShinryoShikibetsuList(parameter);
        getHandler(div).再審査申立書登録表示初期化(削除モード, サービス種類リスト, サービスコードリスト, 特定診療識別リスト);
        ResponseData<SaishinsaMoshitateTourokuPanelDiv> responseData;
        RString 前排他キー = 排他キー.concat(
                div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtHiHoekNo());
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            responseData = ResponseData.of(div).setState(DBC1600011StateName.detail_notUpdate);
            responseData.addValidationMessages(getValidationHandler(div).get他のユーザが使用中エラーメッセージ());
            div.getKagoMoshitatePanel().setHdn排他状態フラグ(FALSE);
        } else {
            responseData = ResponseData.of(div).setState(DBC1600011StateName.detail);
            div.getKagoMoshitatePanel().setHdn排他状態フラグ(TRUE);
        }
        return responseData;
    }

    /**
     * 再審査申立書登録画面の「検索結果一覧へ」ボタンをを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SaishinsaMoshitateTourokuPanelDiv>
     */
    public ResponseData<SaishinsaMoshitateTourokuPanelDiv> onClick_btnMoshitateSearchResult(
            SaishinsaMoshitateTourokuPanelDiv div) {
        if (TRUE.equals(div.getKagoMoshitatePanel().getHdn排他状態フラグ())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                RString 前排他キー = 排他キー.concat(div.getHdn被保険者番号());
                RealInitialLocker.release(new LockingKey(前排他キー));
                return ResponseData.of(div).setState(DBC1600011StateName.search);
            } else {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).setState(DBC1600011StateName.search);
    }

    /**
     * 更新結果状況画面の「検索結果一覧へ」ボタンをを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SaishinsaMoshitateTourokuPanelDiv>
     */
    public ResponseData<SaishinsaMoshitateTourokuPanelDiv> onClick_btnKanryoSearchResult(
            SaishinsaMoshitateTourokuPanelDiv div) {
        AccessLogger.log(AccessLogType.更新, toPersonalData(
                new ShikibetsuCode(div.getHdn識別コード()),
                new HihokenshaNo(div.getHdn被保険者番号())));
        RString 前排他キー = 排他キー.concat(div.getHdn被保険者番号());
        RealInitialLocker.release(new LockingKey(前排他キー));
        div.setHdn再検索フラグ(TRUE);
        SaishinsaMoshitateTourokuCollect collect = DataPassingConverter.deserialize(
                div.getHdn一覧検索条件(),
                SaishinsaMoshitateTourokuCollect.class);
        collect.set画面状態(初期化状態);
        div.setHdn一覧検索条件(DataPassingConverter.serialize(collect));
        return onLoad(div);
    }

    /**
     * 「保存する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SaishinsaMoshitateTourokuPanelDiv>
     */
    public ResponseData<SaishinsaMoshitateTourokuPanelDiv> onClick_btnUpdate(SaishinsaMoshitateTourokuPanelDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).check申立日エラー();
        validPairs.add(getValidationHandler(div).check再審査特定診療識別1());
        validPairs.add(getValidationHandler(div).check再審査特定診療識別2());
        validPairs.add(getValidationHandler(div).check再審査サービス選択());
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (削除モード.equals(div.getHdn画面モード())) {
            ValidationMessageControlPairs validPairs1 = getValidationHandler(div).check送付済み();
            if (validPairs1.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs1).respond();
            }
        }
        if (save(div)) {
            div.getCommonKiagoKanryoMessageChildDiv1().setSuccessMessage(MESSAGE);
            return ResponseData.of(div).setState(DBC1600011StateName.KanryoMessage);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private RString get被保名称(ShikibetsuCode 識別コード) {
        RString 被保名称 = RString.EMPTY;
        if (識別コード != null && !識別コード.isEmpty()) {
            IShikibetsuTaishoFinder 識別対象Finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
            IShikibetsuTaisho 宛名情報 = 識別対象Finder.get識別対象(GyomuCode.DB介護保険, 識別コード, KensakuYusenKubun.住登外優先);
            被保名称 = 宛名情報.get名称().getName().value();
        }
        return 被保名称;
    }

    private boolean save(SaishinsaMoshitateTourokuPanelDiv div) {
        boolean flag;
        SaishinsaMoshitateManager manager = new SaishinsaMoshitateManager();
        RString サービス種類コード = RString.EMPTY;
        RString サービス項目コード = RString.EMPTY;
        if (サービス種類.equals(div.getKagoMoshitatePanel().getRadioButton1().getSelectedValue())) {
            if (!div.getKagoMoshitatePanel().getDropDownList3().getDataSource().isEmpty()) {
                サービス種類コード = div.getKagoMoshitatePanel().getDropDownList3().getSelectedKey().substring(0, 2);
                サービス項目コード = div.getKagoMoshitatePanel().getDropDownList3().getSelectedKey().substring(2);
            }
        } else if (サービスコード.equals(div.getKagoMoshitatePanel().getRadioButton1().getSelectedValue())) {
            if (!div.getKagoMoshitatePanel().getDropDownList6().getDataSource().isEmpty()) {
                サービス種類コード = div.getKagoMoshitatePanel().getDropDownList6().getSelectedKey().substring(0, 2);
                サービス項目コード = div.getKagoMoshitatePanel().getDropDownList6().getSelectedKey().substring(2);
            }
        } else {
            if (!div.getKagoMoshitatePanel().getDropDownList7().getDataSource().isEmpty()) {
                サービス種類コード = div.getKagoMoshitatePanel().getDropDownList7().getSelectedKey().substring(0, 2);
                サービス項目コード = div.getKagoMoshitatePanel().getDropDownList7().getSelectedKey().substring(2);
            }
        }
        SaishinsaMoshitate data = new SaishinsaMoshitate(
                new JigyoshaNo(div.getKagoMoshitatePanel().getTextBox2().getValue()),
                new HihokenshaNo(div.getCommonKaigoshikakuKihonChildDiv2().get被保険者番号()),
                new FlexibleYearMonth(new RYearMonth(div.getKagoMoshitatePanel().getTextBox5().getValue()).toDateString()),
                new ServiceShuruiCode(サービス種類コード),
                new ServiceKomokuCode(サービス項目コード),
                Integer.parseInt(div.getHdn履歴番号().toString()));
        SaishinsaMoshitateBuilder builder = data.createBuilderForEdit();
        SaishinsaMoshitateTourokuBusiness business;
        if (登録モード.equals(div.getHdn画面モード())) {
            SaishinsaMoshitateTourokuMybatisParameter parameter = SaishinsaMoshitateTourokuMybatisParameter.createMybatisParameter(
                    div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtHiHoekNo(),
                    div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtTeikyoYM(),
                    div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().getActiveRow().getTxtJigyoshaNo());
            RString 最大履歴番号 = SaishinsaMoshitateTouroku.createInstance().selectSaishinsaMoshitateJohoSidaiRenBan(parameter);
            int 履歴番号 = ONE;
            if (最大履歴番号 != null) {
                履歴番号 = Integer.parseInt(最大履歴番号.toString()) + ONE;
            }
            builder.set履歴番号(履歴番号);
            builder.set申立年月日(new FlexibleDate(div.getKagoMoshitatePanel().getTextBoxDate1().getValue().toDateString()));
            builder.set申立者区分コード(div.getKagoMoshitatePanel().getDropDownList2().getSelectedKey());
            builder.set証記載保険者番号(new ShoKisaiHokenshaNo(div.getKagoMoshitatePanel().getTextBox7().getValue()));
            builder.set申立単位数(Integer.parseInt(div.getKagoMoshitatePanel().getTextBox12().getValue().toString()));
            builder.set申立事由コード(div.getKagoMoshitatePanel().getDropDownList4().getSelectedKey().concat(
                    div.getKagoMoshitatePanel().getDropDownList5().getSelectedKey()));
            if (!RString.isNullOrEmpty(div.getKagoMoshitatePanel().getTextBox6().getValue())) {
                builder.set国保連送付年月(new FlexibleYearMonth(
                        new RYearMonth(div.getKagoMoshitatePanel().getTextBox6().getValue()).toDateString()));
            }
            boolean 国保連再送付有フラグ = true;
            if (div.getKagoMoshitatePanel().getCheckBoxList1().getSelectedKeys().isEmpty()) {
                国保連再送付有フラグ = false;
            }
            builder.set国保連再送付有フラグ(国保連再送付有フラグ);
            builder.set備考(RString.EMPTY);
            business = new SaishinsaMoshitateTourokuBusiness(builder.build().toEntity());
            business.setState(EntityDataState.Added);
            flag = manager.addOrDelete再審査申立(new SaishinsaMoshitate(business.getEntity()));
        } else if (修正モード.equals(div.getHdn画面モード())) {
            SaishinsaMoshitateJohoBusiness 再審査申立情報 = DataPassingConverter.deserialize(
                    div.getHdn一覧検索条件(),
                    SaishinsaMoshitateTourokuCollect.class).get再審査申立情報List().get(
                            Integer.parseInt(div.getHdnActiveRowId().toString()));
            builder.set申立年月日(new FlexibleDate(div.getKagoMoshitatePanel().getTextBoxDate1().getValue().toDateString()));
            builder.set申立者区分コード(div.getKagoMoshitatePanel().getDropDownList2().getSelectedKey());
            builder.set申立単位数(Integer.parseInt(div.getKagoMoshitatePanel().getTextBox12().getValue().toString()));
            builder.set申立事由コード(div.getKagoMoshitatePanel().getDropDownList4().getSelectedKey().concat(
                    div.getKagoMoshitatePanel().getDropDownList5().getSelectedKey()));
            boolean 国保連再送付有フラグ = true;
            if (div.getKagoMoshitatePanel().getCheckBoxList1().getSelectedKeys().isEmpty()) {
                国保連再送付有フラグ = false;
            }
            builder.set国保連再送付有フラグ(国保連再送付有フラグ);
            builder.setサービス種類コード(new ServiceShuruiCode(再審査申立情報.getサービス種類コード()));
            builder.setサービス項目コード(new ServiceKomokuCode(再審査申立情報.getサービス項目コード()));
            builder.set証記載保険者番号(new ShoKisaiHokenshaNo(再審査申立情報.get証記載保険者番号()));
            builder.set国保連送付年月(new FlexibleYearMonth(再審査申立情報.get国保連送付年月()));
            if (!RString.isNullOrEmpty(再審査申立情報.get備考())) {
                builder.set備考(再審査申立情報.get備考());
            }
            business = new SaishinsaMoshitateTourokuBusiness(builder.build().toEntity());
            flag = manager.update再審査申立(
                    new SaishinsaMoshitate(business.getEntity()),
                    new ServiceShuruiCode(サービス種類コード),
                    new ServiceKomokuCode(サービス項目コード));
        } else {
            SaishinsaMoshitateJohoBusiness 再審査申立情報 = DataPassingConverter.deserialize(
                    div.getHdn一覧検索条件(),
                    SaishinsaMoshitateTourokuCollect.class).get再審査申立情報List()
                    .get(Integer.parseInt(div.getHdnActiveRowId().toString()));
            builder.setサービス種類コード(new ServiceShuruiCode(再審査申立情報.getサービス種類コード()));
            builder.setサービス項目コード(new ServiceKomokuCode(再審査申立情報.getサービス項目コード()));
            business = new SaishinsaMoshitateTourokuBusiness(builder.build().toEntity());
            business.setState(EntityDataState.Deleted);
            flag = manager.addOrDelete再審査申立(new SaishinsaMoshitate(business.getEntity()));
        }
        return flag;
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        return PersonalData.of(識別コード, expandedInfo);
    }

    private SaishinsaMoshitateTourokuPanelHandler getHandler(SaishinsaMoshitateTourokuPanelDiv div) {
        return new SaishinsaMoshitateTourokuPanelHandler(div);
    }

    private SaishinsaMoshitateTourokuPanelValidationHandler getValidationHandler(SaishinsaMoshitateTourokuPanelDiv div) {
        return new SaishinsaMoshitateTourokuPanelValidationHandler(div);
    }
}

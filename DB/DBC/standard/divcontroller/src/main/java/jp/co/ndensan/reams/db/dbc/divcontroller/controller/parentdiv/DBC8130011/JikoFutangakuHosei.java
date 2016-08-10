/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC8130011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGakuHolder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGakuIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGakuMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.JigyoKogakuGassanJikofutangakuHosei;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011.DBC8130011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011.DBC8130011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011.JikoFutangakuHoseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011.dgJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8130011.JikoFutangakuHoseiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8130011.JikoFutangakuHoseiValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuGassanJikoFutanGakuManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.SogoJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.jikofutangakuhosei.JikoFutangakuHoseiFinder;
import jp.co.ndensan.reams.db.dbc.service.core.jikofutangakuhosei.JikoFutangakuHoseiManager;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.JukyushaDaichoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 事業分自己負担額情報補正（単）_情報一覧のクラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class JikoFutangakuHosei {

    private static final RString 排他キー = new RString("DBCHihokenshaNo");
    private static final RString CODE_003 = new RString("003");
    private static final RString 名称_被保険者番号 = new RString("被保険者番号");
    private static final RString CODE_ZERO = new RString("0");
    private static final RString CODE_ONE = new RString("1");
    private static final RString 登録 = new RString("登録");
    private static final RString KEY_ZERO = new RString("key0");

    /**
     * 画面初期化のonLoadメソッドです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuHoseiDiv> onLoad(JikoFutangakuHoseiDiv div) {
        if (ResponseHolder.isReRequest()
                && new RString(DbcInformationMessages.被保険者でないデータ
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
        JikoFutangakuHoseiHandler handler = getHandler(div);
        if ((被保険者番号 == null || RString.EMPTY.equals(
                被保険者番号.getColumnValue())) && !ResponseHolder.isReRequest()) {
            ResponseData.of(div).addMessage(DbcInformationMessages.被保険者でないデータ.getMessage());
        }
        RString 前排他キー = 排他キー.concat(対象者.get被保険者番号().getColumnValue());
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        if (DBC8130011StateName.自己負担額管理情報入力.getName().equals(ResponseHolder.getState())) {
            KogakuGassanJikoFutanGaku result = ViewStateHolder.get(
                    ViewStateKeys.高額合算自己負担額, KogakuGassanJikoFutanGaku.class);
            JigyoKogakuGassanJikofutangakuHosei 自己負担額保持 = ViewStateHolder.get(
                    ViewStateKeys.事業高額合算自己負担額補正保持Entity,
                    JigyoKogakuGassanJikofutangakuHosei.class);
            result = handler.編集処理対象から保持Entity(result, 自己負担額保持);
            handler.onSelect_dgRireki(result);
            return ResponseData.of(div).respond();
        }
        JukyushaDaichoManager 受給者台帳manager = new JukyushaDaichoManager();
        List<JukyushaDaicho> 受給者台帳List = 受給者台帳manager.get受給者台帳被保険者番号(被保険者番号);
        SogoJigyoTaishoshaManager 総合事業対象者manager = new SogoJigyoTaishoshaManager();
        List<SogoJigyoTaishosha> 総合事業対象者List
                = 総合事業対象者manager.get総合事業対象者情報(被保険者番号);
        KogakuGassanJikoFutanGakuManager 高額合算manager = new KogakuGassanJikoFutanGakuManager();
        List<KogakuGassanJikoFutanGaku> 高額合算List = 高額合算manager.getBy被保険者番号(被保険者番号);

        if (受給者台帳List.isEmpty() && 総合事業対象者List.isEmpty() && !ResponseHolder.isReRequest()) {
            throw new ApplicationException(
                    DbdErrorMessages.受給共通_受給者_事業対象者登録なし.getMessage());
        }
        if (高額合算List.isEmpty() && (!ResponseHolder.isReRequest()
                || new RString(DbdErrorMessages.受給共通_受給者_事業対象者登録なし
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode()))) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        handler.initializeDisplay(対象者);
        onClick_chkRirekiHyouji(div);
        return ResponseData.of(div).setState(DBC8130011StateName.自己負担額一覧);
    }

    /**
     * 履歴を表示するのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuHoseiDiv> onClick_chkRirekiHyouji(JikoFutangakuHoseiDiv div) {
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
        List<KogakuGassanJikoFutanGaku> resultList;
        List<RString> selectedKeys = div.getJikoFutangakuHoseiList()
                .getChkRirekiHyouji().getSelectedKeys();
        if (Collections.EMPTY_LIST.equals(selectedKeys)) {
            ViewStateHolder.put(ViewStateKeys.一覧データ, CODE_ZERO);
            JikoFutangakuHoseiFinder finder = JikoFutangakuHoseiFinder.createInstance();
            resultList = finder.selectJyutakukaisyuList(被保険者番号).records();
        } else {
            ViewStateHolder.put(ViewStateKeys.一覧データ, CODE_ONE);
            KogakuGassanJikoFutanGakuManager manager = new KogakuGassanJikoFutanGakuManager();
            resultList = manager.getBy被保険者番号(被保険者番号);
        }
        ViewStateHolder.put(ViewStateKeys.高額合算自己負担額情報,
                new KogakuGassanJikoFutanGakuHolder(resultList));
        JikoFutangakuHoseiHandler handler = getHandler(div);
        if (resultList != null) {
            handler.onClick_chkRirekiHyouji(resultList, 被保険者番号, 対象者.get識別コード());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 履歴Dgdの選択ボタンの処理です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuHoseiDiv> onSelect_dgRireki(JikoFutangakuHoseiDiv div) {
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        JikoFutangakuHoseiHandler handler = getHandler(div);
        boolean flg = handler.isCheckPass(対象者.get被保険者番号());
        if (!flg && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    DbcWarningMessages.高額合算補正関連１.getMessage()).respond();
        }
        KogakuGassanJikoFutanGakuHolder 高額合算情報 = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額情報, KogakuGassanJikoFutanGakuHolder.class);
        dgJohoIchiran_Row row = div.getDgJohoIchiran().getClickedItem();
        int 履歴番号 = Integer.parseInt(row.getTxtRirekiNo().toString());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo());
        HokenshaNo 保険者番号 = new HokenshaNo(row.getTxtHokenshaNo());
        RString 支給申請書整理番号 = row.getTxtShikyuShinseishoSeiriNo();
        KogakuGassanJikoFutanGakuIdentifier identifier = new KogakuGassanJikoFutanGakuIdentifier(
                対象者.get被保険者番号(), 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号);
        KogakuGassanJikoFutanGaku result = 高額合算情報.getKogakuGassanJikoFutanGaku(identifier);
        ViewStateHolder.put(ViewStateKeys.高額合算自己負担額, result);
        ViewStateHolder.put(ViewStateKeys.事業高額合算自己負担額補正保持Entity, null);
        handler.onSelect_dgRireki(result);
        return ResponseData.of(div).setState(DBC8130011StateName.自己負担額管理情報入力);
    }

    /**
     * 窓口払情報開始日の制御事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuHoseiDiv> onChange_txtMadoguchiKaishiYMD(
            JikoFutangakuHoseiDiv div) {
        JikoFutangakuHoseiHandler handler = getHandler(div);
        handler.onChange_txtMadoguchiKaishiYMD();
        return ResponseData.of(div).respond();
    }

    /**
     * 窓口払情報終了日の制御事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuHoseiDiv> onChange_txtMadoguchiShuryoYMD(
            JikoFutangakuHoseiDiv div) {
        JikoFutangakuHoseiHandler handler = getHandler(div);
        handler.onChange_txtMadoguchiShuryoYMD();
        return ResponseData.of(div).respond();
    }

    /**
     * 自己負担額一覧に戻るボタンクリック時の事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuHoseiDiv> onClick_btnJikofutangakuJohoNiModoru(
            JikoFutangakuHoseiDiv div) {
        JikoFutangakuHoseiHandler handler = getHandler(div);
        KogakuGassanJikoFutanGaku result = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額, KogakuGassanJikoFutanGaku.class);
        boolean 内容が編集フラグ = handler.onClick_btnJikofutangakuJohoNiModoru(result);
        if (内容が編集フラグ && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())
                || !new RString(UrQuestionMessages.検索画面遷移の確認
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            handler.initializeDisplay(対象者);
            RString 一覧flg = ViewStateHolder.get(ViewStateKeys.一覧データ, RString.class);
            if (CODE_ZERO.equals(一覧flg)) {
                List<RString> keyList = new ArrayList();
                keyList.add(KEY_ZERO);
                div.getJikoFutangakuHoseiList().getChkRirekiHyouji().setSelectedItemsByKey(keyList);
            } else {
                div.getJikoFutangakuHoseiList().getChkRirekiHyouji().setSelectedItemsByKey(Collections.EMPTY_LIST);
            }
            onClick_chkRirekiHyouji(div);
            return ResponseData.of(div).setState(DBC8130011StateName.自己負担額一覧);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 自己負担額情報を入力するボタンクリック時の事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuHoseiDiv> onClick_btnJikofutangakuJohoNyuryoku(
            JikoFutangakuHoseiDiv div) {
        JikoFutangakuHoseiHandler handler = getHandler(div);
        KogakuGassanJikoFutanGaku result = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額, KogakuGassanJikoFutanGaku.class);
        result = handler.編集処理対象から画面(result);
        ViewStateHolder.put(ViewStateKeys.高額合算自己負担額, result);
        JigyoKogakuGassanJikofutangakuHosei 自己負担額保持 = ViewStateHolder.get(
                ViewStateKeys.事業高額合算自己負担額補正保持Entity,
                JigyoKogakuGassanJikofutangakuHosei.class);
        if (自己負担額保持 == null) {
            自己負担額保持 = new JigyoKogakuGassanJikofutangakuHosei();
            自己負担額保持 = set自己負担額保持回目１(自己負担額保持, result);
        } else {
            if (CODE_ZERO.equals(自己負担額保持.get変更フラグ())) {
                div.getBtnJikofutangakuJohoNyuryoku().setIconNameEnum(IconName.NONE);
            }
            if (CODE_ONE.equals(自己負担額保持.get変更フラグ())) {
                div.getBtnJikofutangakuJohoNyuryoku().setIconNameEnum(IconName.Check);
            }
            自己負担額保持.set呼び出しフラグ(CODE_ONE);
        }
        ViewStateHolder.put(ViewStateKeys.事業高額合算自己負担額補正保持Entity, 自己負担額保持);
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索する」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuHoseiDiv> onClick_btnReSearch(JikoFutangakuHoseiDiv div) {
        JikoFutangakuHoseiHandler handler = getHandler(div);
        KogakuGassanJikoFutanGaku result = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額, KogakuGassanJikoFutanGaku.class);
        boolean 内容が編集フラグ = handler.onClick_btnJikofutangakuJohoNiModoru(result);
        if (内容が編集フラグ && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())
                || !new RString(UrQuestionMessages.検索画面遷移の確認
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            handler.initializeDisplay(対象者);
            onClick_chkRirekiHyouji(div);
            return ResponseData.of(div).forwardWithEventName(
                    DBC8130011TransitionEventName.再検索).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuHoseiDiv> onClick_btnTaishoshaModoru(
            JikoFutangakuHoseiDiv div) {
        JikoFutangakuHoseiHandler handler = getHandler(div);
        KogakuGassanJikoFutanGaku result = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額, KogakuGassanJikoFutanGaku.class);
        boolean 内容が編集フラグ = handler.onClick_btnJikofutangakuJohoNiModoru(result);
        if (内容が編集フラグ && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())
                || !new RString(UrQuestionMessages.検索画面遷移の確認
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).forwardWithEventName(
                    DBC8130011TransitionEventName.検索結果一覧).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「補正情報を保存する」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuHoseiDiv> onClick_btnSave(JikoFutangakuHoseiDiv div) {
        boolean 登録flg = false;
        JikoFutangakuHoseiValidationHandler validationhandler = getValidatioHandler(div);
        ValidationMessageControlPairs 保存Pairs = validationhandler.validate保存する();
        if (保存Pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(保存Pairs).respond();
        }
        ValidationMessageControlPairs 明細月Pairs = validationhandler.validate負担額情報入力の明細月();
        if (明細月Pairs.iterator().hasNext() && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addValidationMessages(明細月Pairs).respond();
        }
        if (!ResponseHolder.isWarningIgnoredRequest() && new RString(
                DbcWarningMessages.自己負担被保険者期間外
                .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs 終了年度が同年Pairs = validationhandler.validate終了年度が同年();
        if (終了年度が同年Pairs.iterator().hasNext() && (!ResponseHolder.isReRequest()
                || new RString(DbcWarningMessages.自己負担被保険者期間外
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode()))) {
            return ResponseData.of(div).addValidationMessages(終了年度が同年Pairs).respond();
        }
        if (!ResponseHolder.isWarningIgnoredRequest() && new RString(
                DbcWarningMessages.対象年対象計算期間終了不整合
                .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        JigyoKogakuGassanJikofutangakuHosei 自己負担額保持 = ViewStateHolder.get(
                ViewStateKeys.事業高額合算自己負担額補正保持Entity,
                JigyoKogakuGassanJikofutangakuHosei.class);
        if (自己負担未確定メッセージ判定(自己負担額保持)) {
            return ResponseData.of(div).addMessage(
                    DbcWarningMessages.自己負担未確定.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.No.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).respond();
        }
        JikoFutangakuHoseiHandler handler = getHandler(div);
        KogakuGassanJikoFutanGaku 負担額 = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額, KogakuGassanJikoFutanGaku.class);
        負担額 = handler.編集処理対象から画面(負担額);
        負担額.createBuilderForEdit()
                .setリアル補正実施年月日(FlexibleDate.getNowDate())
                .build();
        List<KogakuGassanJikoFutanGakuMeisai> 負担額明細一覧 = null;
        if (自己負担額保持 != null) {
            負担額 = handler.編集処理対象から保持Entity(負担額, 自己負担額保持);
            負担額明細一覧 = handler.setFutanGakuMeisai(自己負担額保持);
        }
        JikoFutangakuHoseiManager manager = JikoFutangakuHoseiManager.createInstance();
        if (!new RString(UrInformationMessages.正常終了
                .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            manager.保存(負担額, 負担額明細一覧);
            登録flg = true;
        }
        if (登録メッセージ判定(登録flg)) {
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了
                    .getMessage().replace(登録.toString())).respond();
        }
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE_003),
                名称_被保険者番号, 対象者.get被保険者番号().getColumnValue());
        PersonalData personalData = PersonalData.of(対象者.get識別コード(), expandedInfo);
        AccessLogger.log(AccessLogType.照会, personalData);
        handler.initializeDisplay(対象者);
        onClick_chkRirekiHyouji(div);
        return ResponseData.of(div).setState(DBC8130011StateName.自己負担額一覧);
    }

    private boolean 自己負担未確定メッセージ判定(JigyoKogakuGassanJikofutangakuHosei 自己負担額保持) {
        return 自己負担額保持 != null && CODE_ZERO.equals(自己負担額保持.get変更フラグ())
                && (!ResponseHolder.isReRequest()
                || new RString(DbcWarningMessages.自己負担被保険者期間外
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                || new RString(DbcWarningMessages.対象年対象計算期間終了不整合
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode()));
    }

    private boolean 登録メッセージ判定(boolean 登録flg) {
        return 登録flg && (!ResponseHolder.isReRequest()
                || new RString(DbcWarningMessages.自己負担被保険者期間外
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                || new RString(DbcWarningMessages.対象年対象計算期間終了不整合
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                || new RString(DbcWarningMessages.自己負担未確定
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode()));
    }

    private JigyoKogakuGassanJikofutangakuHosei set自己負担額保持回目１(
            JigyoKogakuGassanJikofutangakuHosei 自己負担額保持,
            KogakuGassanJikoFutanGaku result) {
        自己負担額保持.set被保険者番号(result.get被保険者番号());
        自己負担額保持.set対象年度(result.get対象年度());
        自己負担額保持.set保険者番号(result.get保険者番号());
        自己負担額保持.set支給申請書整理番号(result.get支給申請書整理番号());
        自己負担額保持.set履歴番号(new RString(result.get履歴番号()));
        自己負担額保持.set呼び出しフラグ(CODE_ZERO);
        自己負担額保持.set変更フラグ(CODE_ZERO);
        return 自己負担額保持;
    }

    private JikoFutangakuHoseiHandler getHandler(JikoFutangakuHoseiDiv div) {
        return JikoFutangakuHoseiHandler.of(div);
    }

    private JikoFutangakuHoseiValidationHandler getValidatioHandler(JikoFutangakuHoseiDiv div) {
        return new JikoFutangakuHoseiValidationHandler(div);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1140011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGakuHolder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGakuIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGakuMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanJikofutangakuHosei;
import jp.co.ndensan.reams.db.dbc.definition.core.jigyougassan.JigyouGassan_ShoumeishoyouDataKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011.DBC1140011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011.DBC1140011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011.JikoFutangakuJohoHoseiJohoDgDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011.dgJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140011.JikoFutangakuJohoHoseiJohoDgHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140011.JikoFutangakuJohoHoseiJohoDgValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuGassanJikoFutanGakuManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.SogoJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.jikofutangakuhosei.JikoFutangakuHoseiFinder;
import jp.co.ndensan.reams.db.dbc.service.core.jikofutangakuhosei.JikoFutangakuHoseiManager;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
 * 高額合算自己負担額情報補正(単)_情報一覧のクラスです。
 *
 * @reamsid_L DBC-2080-010 jiangzongyue
 */
public class JikoFutangakuJohoHoseiJohoDg {

    private static final RString 排他キー = new RString("DBCHihokenshaNo");
    private static final RString 被保険者番号なし = new RString("被保険者番号なし");
    private static final RString CODE_003 = new RString("003");
    private static final RString 名称_被保険者番号 = new RString("被保険者番号");
    private static final RString CODE_ZERO = new RString("0");
    private static final RString CODE_ONE = new RString("1");
    private static final RString KEY_ZERO = new RString("key0");
    private static final RString 平成２０年度 = new RString("平成２０年度");
    private static final RString 平成２０年度以外 = new RString("平成２０年度以外");
    private static final int NENDO2008 = 2008;
    private static final RString 登録 = new RString("登録");
    private static final RString 完了メッセージ = new RString("自己負担額情報の更新が完了しました。");

    /**
     * 画面初期化のonLoadメソッドです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiJohoDgDiv> onLoad(JikoFutangakuJohoHoseiJohoDgDiv div) {
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (対象者 != null) {
            HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
            JikoFutangakuJohoHoseiJohoDgHandler handler = getHandler(div);
            if (被保険者番号 == null || 被保険者番号.isEmpty()) {
                throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace(被保険者番号なし.toString()));
            }
            handler.initializeDisplay(対象者);
            RString 前排他キー = 排他キー.concat(被保険者番号.getColumnValue());
            LockingKey key = new LockingKey(前排他キー);
            if (!RealInitialLocker.tryGetLock(key)) {
                throw new PessimisticLockingException();
            }
            JukyushaDaichoManager 受給者台帳manager = new JukyushaDaichoManager();
            List<JukyushaDaicho> 受給者台帳List = 受給者台帳manager.get受給者台帳被保険者番号(被保険者番号);
            SogoJigyoTaishoshaManager 総合事業対象者manager = new SogoJigyoTaishoshaManager();
            List<SogoJigyoTaishosha> 総合事業対象者List
                    = 総合事業対象者manager.get総合事業対象者情報(被保険者番号);
            KogakuGassanJikoFutanGakuManager 高額合算manager = new KogakuGassanJikoFutanGakuManager();
            List<KogakuGassanJikoFutanGaku> 高額合算List = 高額合算manager.getBy被保険者番号(被保険者番号);
            if (受給者台帳List.isEmpty() && 総合事業対象者List.isEmpty()) {
                throw new ApplicationException(
                        DbdErrorMessages.受給共通_受給者_事業対象者登録なし.getMessage());
            }
            if (高額合算List.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            ViewStateHolder.put(ViewStateKeys.一覧データ, CODE_ZERO);
            JikoFutangakuHoseiFinder finder = JikoFutangakuHoseiFinder.createInstance();
            List<KogakuGassanJikoFutanGaku> resultList = finder.selectJyutakukaisyuList(被保険者番号).records();
            ViewStateHolder.put(ViewStateKeys.高額合算自己負担額情報,
                    new KogakuGassanJikoFutanGakuHolder(resultList));
            if (resultList != null) {
                handler.履歴を表示printLog(resultList, 対象者.get識別コード(), 被保険者番号);
            } else {
                div.getChkRirekiHyouji().setDisabled(true);
            }
        }
        return ResponseData.of(div).setState(DBC1140011StateName.自己負担額一覧);
    }

    /**
     * 履歴を表示するのイベントです。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiJohoDgDiv> onClick_chkRirekiHyouji(JikoFutangakuJohoHoseiJohoDgDiv div) {
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 対象者.get被保険者番号();
        JikoFutangakuJohoHoseiJohoDgHandler handler = getHandler(div);
        List<KogakuGassanJikoFutanGaku> resultList;
        List<RString> selectedKeys = div.getChkRirekiHyouji().getSelectedKeys();
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
        if (resultList != null) {
            handler.onClick_chkRirekiHyouji(resultList, 被保険者番号, 対象者.get識別コード());
        } else {
            div.getChkRirekiHyouji().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 履歴Dgdの選択ボタンの処理です。
     *
     * @param div JikoFutangakuJohoHoseiJohoDgDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiJohoDgDiv> onSelect_dgRireki(JikoFutangakuJohoHoseiJohoDgDiv div) {
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        JikoFutangakuJohoHoseiJohoDgHandler handler = getHandler(div);
        dgJohoIchiran_Row row = div.getDgJohoIchiran().getClickedItem();
        boolean flg = handler.isCheckPass(対象者.get被保険者番号(), row);
        if (!flg && !JigyouGassan_ShoumeishoyouDataKubun.証明書用.getCode().equals(row.getTxtDataKBN())
                && !ResponseHolder.isReRequest()
                && !(new RString(DbcWarningMessages.高額合算補正関連２
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode()))) {
            return ResponseData.of(div).addMessage(
                    DbcWarningMessages.高額合算補正関連１.getMessage()).respond();
        } else if (!flg && JigyouGassan_ShoumeishoyouDataKubun.証明書用.getCode().equals(row.getTxtDataKBN())
                && !ResponseHolder.isReRequest()
                && !(new RString(DbcWarningMessages.高額合算補正関連１
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode()))) {
            return ResponseData.of(div).addMessage(
                    DbcWarningMessages.高額合算補正関連２.getMessage()).respond();
        }
        if (!RString.isNullOrEmpty(row.getTxtSofuNengetsu())
                && !ResponseHolder.isReRequest()
                && !(new RString(DbcWarningMessages.高額合算補正関連１
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                || new RString(
                        DbcWarningMessages.高額合算補正関連２
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode()))) {
            return ResponseData.of(div).addMessage(
                    DbcWarningMessages.高額合算補正関連３.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.No.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).respond();
        }
        KogakuGassanJikoFutanGakuHolder 高額合算情報 = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額情報, KogakuGassanJikoFutanGakuHolder.class);
        int 履歴番号 = Integer.parseInt(row.getTxtRirekiNo().toString());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtHdnTaishoNendo());
        HokenshaNo 保険者番号 = new HokenshaNo(row.getTxtHokenshaNo());
        RString 支給申請書整理番号 = row.getTxtShikyuShinseishoSeiriNo();
        KogakuGassanJikoFutanGakuIdentifier identifier = new KogakuGassanJikoFutanGakuIdentifier(
                対象者.get被保険者番号(), 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号);
        KogakuGassanJikoFutanGaku result = 高額合算情報.getKogakuGassanJikoFutanGaku(identifier);
        handler.再送区分送付対象外制御(flg, result);
        ViewStateHolder.put(ViewStateKeys.高額合算自己負担額, result);
        ViewStateHolder.put(ViewStateKeys.高額合算自己負担額補正保持Entity, null);
        div.getBtnJikofutangakuJohoNyuryoku().setIconNameEnum(IconName.NONE);
        handler.onSelect_dgRireki(result);
        return ResponseData.of(div).setState(DBC1140011StateName.自己負担額管理情報入力);
    }

    /**
     * 窓口払情報開始日の制御事件です。
     *
     * @param div JikoFutangakuJohoHoseiJohoDgDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiJohoDgDiv> onChange_txtMadoguchiKaishiYMD(
            JikoFutangakuJohoHoseiJohoDgDiv div) {
        JikoFutangakuJohoHoseiJohoDgHandler handler = getHandler(div);
        handler.onChange_txtMadoguchiKaishiYMD();
        return ResponseData.of(div).respond();
    }

    /**
     * 窓口払情報終了日の制御事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiJohoDgDiv> onChange_txtMadoguchiShuryoYMD(
            JikoFutangakuJohoHoseiJohoDgDiv div) {
        JikoFutangakuJohoHoseiJohoDgHandler handler = getHandler(div);
        handler.onChange_txtMadoguchiShuryoYMD();
        return ResponseData.of(div).respond();
    }

    /**
     * 自己負担額一覧に戻るボタンクリック時の事件です。
     *
     * @param div JikoFutangakuHoseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiJohoDgDiv> onClick_btnJikofutangakuJohoNiModoru(
            JikoFutangakuJohoHoseiJohoDgDiv div) {
        JikoFutangakuJohoHoseiJohoDgHandler handler = getHandler(div);
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
                div.getChkRirekiHyouji().setSelectedItemsByKey(Collections.EMPTY_LIST);
            } else {
                List<RString> keyList = new ArrayList();
                keyList.add(KEY_ZERO);
                div.getChkRirekiHyouji().setSelectedItemsByKey(keyList);
            }
            onClick_chkRirekiHyouji(div);
            return ResponseData.of(div).setState(DBC1140011StateName.自己負担額一覧);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 自己負担額情報を入力するボタンクリック時の事件です。
     *
     * @param div JikoFutangakuJohoHoseiJohoDgDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiJohoDgDiv> onClick_btnJikofutangakuJohoNyuryoku(
            JikoFutangakuJohoHoseiJohoDgDiv div) {
        JikoFutangakuJohoHoseiJohoDgHandler handler = getHandler(div);
        KogakuGassanJikoFutanGaku result = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額, KogakuGassanJikoFutanGaku.class);
        result = handler.編集処理対象から画面(result);
        RString 平成年度;
        RDate 対象年度 = div.getJikoFutangakuHoseiDetail().getTxtTaishouNendo().getValue();
        if (対象年度.getYear().getYearValue() == NENDO2008) {
            平成年度 = 平成２０年度;
        } else {
            平成年度 = 平成２０年度以外;
        }
        ViewStateHolder.put(ViewStateKeys.高額合算自己負担額, result);
        KogakuGassanJikofutangakuHosei 自己負担額保持 = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額補正保持Entity,
                KogakuGassanJikofutangakuHosei.class);
        if (自己負担額保持 == null) {
            自己負担額保持 = new KogakuGassanJikofutangakuHosei();
            自己負担額保持 = set自己負担額保持回目１(自己負担額保持, result);
        }
        ViewStateHolder.put(ViewStateKeys.高額合算自己負担額補正保持Entity, 自己負担額保持);
        return ResponseData.of(div).forwardWithEventName(DBC1140011TransitionEventName.自己負担額入力).parameter(平成年度);
    }

    private KogakuGassanJikofutangakuHosei set自己負担額保持回目１(
            KogakuGassanJikofutangakuHosei 自己負担額保持,
            KogakuGassanJikoFutanGaku result) {
        自己負担額保持.set被保険者番号(result.get被保険者番号());
        自己負担額保持.set対象年度(result.get対象年度());
        自己負担額保持.set保険者番号(result.get保険者番号());
        自己負担額保持.set支給申請書整理番号(result.get支給申請書整理番号());
        自己負担額保持.set履歴番号(new RString(result.get履歴番号()));
        自己負担額保持.set生年月日(result.get生年月日());
        自己負担額保持.set呼び出しフラグ(CODE_ZERO);
        return 自己負担額保持;
    }

    /**
     * 「再検索する」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuJohoHoseiJohoDgDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiJohoDgDiv> onClick_btnReSearch(JikoFutangakuJohoHoseiJohoDgDiv div) {
        JikoFutangakuJohoHoseiJohoDgHandler handler = getHandler(div);
        KogakuGassanJikoFutanGaku result = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額, KogakuGassanJikoFutanGaku.class);
        boolean 内容が編集フラグ = handler.onClick_btnJikofutangakuJohoNiModoru(result);
        if (内容が編集フラグ && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.No.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).respond();
        }
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        handler.initializeDisplay(対象者);
        onClick_chkRirekiHyouji(div);
        RString 前排他キー = 排他キー.concat(対象者.get被保険者番号().getColumnValue());
        LockingKey key = new LockingKey(前排他キー);
        RealInitialLocker.release(key);
        return ResponseData.of(div).forwardWithEventName(
                DBC1140011TransitionEventName.再検索).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuJohoHoseiJohoDgDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiJohoDgDiv> onClick_btnTaishoshaModoru(
            JikoFutangakuJohoHoseiJohoDgDiv div) {
        JikoFutangakuJohoHoseiJohoDgHandler handler = getHandler(div);
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
            RString 前排他キー = 排他キー.concat(対象者.get被保険者番号().getColumnValue());
            LockingKey key = new LockingKey(前排他キー);
            RealInitialLocker.release(key);
            return ResponseData.of(div).forwardWithEventName(
                    DBC1140011TransitionEventName.検索結果一覧).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「補正情報を保存する」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuJohoHoseiJohoDgDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiJohoDgDiv> onClick_btnSave(JikoFutangakuJohoHoseiJohoDgDiv div) {
        boolean 登録flg = false;
        JikoFutangakuJohoHoseiJohoDgHandler handler = getHandler(div);
        JikoFutangakuJohoHoseiJohoDgValidationHandler validationhandler = getValidatioHandler(div);
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
        KogakuGassanJikofutangakuHosei 自己負担額保持 = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額補正保持Entity,
                KogakuGassanJikofutangakuHosei.class);
        if (自己負担未確定メッセージ判定(自己負担額保持)) {
            return ResponseData.of(div).addMessage(
                    DbcWarningMessages.自己負担未確定.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.No.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.No.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).respond();
        }

        KogakuGassanJikoFutanGaku 負担額 = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額, KogakuGassanJikoFutanGaku.class);
        負担額 = handler.編集処理対象から画面(負担額);
        負担額 = 負担額.createBuilderForEdit()
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
        TaishoshaKey 対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);

        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE_003),
                名称_被保険者番号, 対象者.get被保険者番号().getColumnValue());
        PersonalData personalData = PersonalData.of(対象者.get識別コード(), expandedInfo);
        AccessLogger.log(AccessLogType.更新, personalData);
        if (登録メッセージ判定(登録flg)) {

            handler.initializeDisplay(対象者);
            onClick_chkRirekiHyouji(div);
            RString 前排他キー = 排他キー.concat(対象者.get被保険者番号().getColumnValue());
            LockingKey key = new LockingKey(前排他キー);
            RealInitialLocker.release(key);

            div.getCcdKanryoMessage().setSuccessMessage(完了メッセージ, 対象者.get被保険者番号().getColumnValue(),
                    div.getKogakuGassanShikyuShinseiTorokuKihon().get氏名漢字());
            return ResponseData.of(div).setState(DBC1140011StateName.処理完了);
        } else {
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
    }

    /**
     * 画面初期化のonActiveメソッドです。
     *
     * @param div JikoFutangakuJohoHoseiJohoDgDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiJohoDgDiv> onActive(JikoFutangakuJohoHoseiJohoDgDiv div) {
        KogakuGassanJikofutangakuHosei 自己負担額保持 = ViewStateHolder.get(
                ViewStateKeys.高額合算自己負担額補正保持Entity,
                KogakuGassanJikofutangakuHosei.class);
        if (CODE_ZERO.equals(自己負担額保持.get変更フラグ())) {
            div.getBtnJikofutangakuJohoNyuryoku().setIconNameEnum(IconName.NONE);
        }
        if (CODE_ONE.equals(自己負担額保持.get変更フラグ())) {
            div.getBtnJikofutangakuJohoNyuryoku().setIconNameEnum(IconName.Check);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタンクリック時の事件です。
     *
     * @param div JikoFutangakuJohoHoseiJohoDgDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuJohoHoseiJohoDgDiv> onClick_btnEnd(
            JikoFutangakuJohoHoseiJohoDgDiv div) {
        return ResponseData.of(div).forwardWithEventName(
                DBC1140011TransitionEventName.完了).respond();
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

    private boolean 自己負担未確定メッセージ判定(KogakuGassanJikofutangakuHosei 自己負担額保持) {
        return 自己負担額保持 != null && CODE_ZERO.equals(自己負担額保持.get変更フラグ())
                && (!ResponseHolder.isReRequest()
                || new RString(DbcWarningMessages.自己負担被保険者期間外
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                || new RString(DbcWarningMessages.対象年対象計算期間終了不整合
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode()));
    }

    private JikoFutangakuJohoHoseiJohoDgHandler getHandler(JikoFutangakuJohoHoseiJohoDgDiv div) {
        return JikoFutangakuJohoHoseiJohoDgHandler.of(div);
    }

    private JikoFutangakuJohoHoseiJohoDgValidationHandler getValidatioHandler(JikoFutangakuJohoHoseiJohoDgDiv div) {
        return new JikoFutangakuJohoHoseiJohoDgValidationHandler(div);
    }
}

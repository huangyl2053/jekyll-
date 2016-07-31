/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB2710002;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchomidoteijoho.TokuchoMidoteiJoho;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchomidoteijoho.TokuchoMidoteiJohoIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoDouteiKouhoshaShousaiJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoDouteiListJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoMiDouteiListJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakuseiResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbInformationMessages;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbWarningMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.DBB2710002StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.DBB2710002TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.TokuchoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.dgTokubetChoshuMidoteiIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.dgTokuchoDoteiKohoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710002.TokuchoTaishoshaIchiranHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710002.TokuchoTaishoshaIchiranValidationHandler;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakusei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ue.uex.definition.core.DoteiFuitchiRiyu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-010 yangchenbing
 */
public class TokuchoTaishoshaIchiran {

    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
    private static final RString 同定済み_CODE = new RString("1");
    private static final RString 対象外_CODE = new RString("2");
    private static final RString 月_RS = new RString("月");
    private static final RString 状態なし = new RString("0");
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final RString STATE特別徴収対象者一覧確認 = new RString("1");
    private TokuchoTaishoshaIchiranSakusei service;

    /**
     * 画面のonLoadイベント
     *
     * @param div ShotokuJohoTorokuTotalTotalDiv
     * @return ResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> onLoad(TokuchoTaishoshaIchiranDiv div) {
        if (DBB2710002StateName.同定非同定表示.getName().equals(ResponseHolder.getState())) {
            return 同定非同定表示initialize(div);
        } else if (DBB2710002StateName.特別徴収同定一覧.getName().equals(ResponseHolder.getState())) {
            return 特別徴収同定一覧initialize(div);
        } else if (DBB2710002StateName.特別徴収同定候補者一覧.getName().equals(ResponseHolder.getState())) {
            特別徴収同定候補者一覧initialize(div);
            return ResponseData.of(div).setState(DBB2710002StateName.特別徴収同定候補者一覧);
        } else if (DBB2710002StateName.特別徴収対象者一覧作成.getName().equals(ResponseHolder.getState())) {
            TokuchoTaishoshaIchiranSakuseiResult result = getHandler(div).特別徴収対象者一覧作成initialize();
            if (result != null) {
                ViewStateHolder.put(ViewStateKeys.特別徴収開始月, result.get特別徴収開始月());
                ViewStateHolder.put(ViewStateKeys.捕捉月リスト, (Serializable) result.get捕捉月リスト());
            }
            return ResponseData.of(div).setState(DBB2710002StateName.特別徴収対象者一覧作成);
        } else if (DBB2710002StateName.特別徴収未同定一覧.getName().equals(ResponseHolder.getState())) {
            return 特別徴収未同定一覧initialize(div);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<TokuchoTaishoshaIchiranDiv> 特別徴収同定一覧initialize(TokuchoTaishoshaIchiranDiv div) {
        RString 特別徴収開始月 = ViewStateHolder.get(ViewStateKeys.特別徴収開始月, RString.class);
        RString 最大表示件数 = ViewStateHolder.get(ViewStateKeys.最大表示件数, RString.class);
        List<RString> 捕捉月リスト = ViewStateHolder.get(ViewStateKeys.捕捉月リスト, List.class);
        List<TokuchoDouteiListJoho> result同定
                = getHandler(div).特別徴収同定一覧initialize1(特別徴収開始月, 捕捉月リスト);
        if (result同定 == null || result同定.isEmpty()) {
            return ResponseData.of(div).setState(DBB2710002StateName.特別徴収同定一覧);
        }
        if (result同定.size() <= Integer.parseInt(最大表示件数.toString())) {
            getHandler(div).特別徴収同定一覧initialize2(result同定, result同定.size());
            return ResponseData.of(div).setState(DBB2710002StateName.特別徴収同定一覧);
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.最大表示件数超過.getMessage()).respond();
        }
        if (new RString(DbzInformationMessages.最大表示件数超過.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).特別徴収同定一覧initialize2(result同定, Integer.parseInt(最大表示件数.toString()));
        }
        return ResponseData.of(div).setState(DBB2710002StateName.特別徴収同定一覧);
    }

    private ResponseData<TokuchoTaishoshaIchiranDiv> 特別徴収未同定一覧initialize(TokuchoTaishoshaIchiranDiv div) {
        RString 特別徴収開始月 = ViewStateHolder.get(ViewStateKeys.特別徴収開始月, RString.class);
        RString 最大表示件数 = ViewStateHolder.get(ViewStateKeys.最大表示件数, RString.class);
        boolean 確認済を含む = ViewStateHolder.get(ViewStateKeys.確認済を含む, boolean.class);
        List<RString> 捕捉月リスト = ViewStateHolder.get(ViewStateKeys.捕捉月リスト, List.class);
        List<TokuchoMiDouteiListJoho> 未同定一覧情報List = getHandler(div).特別徴収未同定一覧initialize1(
                特別徴収開始月, 確認済を含む, 捕捉月リスト);
        if (未同定一覧情報List == null || 未同定一覧情報List.isEmpty()) {
            return ResponseData.of(div).setState(DBB2710002StateName.特別徴収未同定一覧);
        }
        if (未同定一覧情報List.size() <= Integer.parseInt(最大表示件数.toString())) {
            getHandler(div).特別徴収未同定一覧initialize2(未同定一覧情報List, 未同定一覧情報List.size());
            return ResponseData.of(div).setState(DBB2710002StateName.特別徴収未同定一覧);
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.最大表示件数超過.getMessage()).respond();
        }
        if (new RString(DbzInformationMessages.最大表示件数超過.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).特別徴収未同定一覧initialize2(未同定一覧情報List, Integer.parseInt(最大表示件数.toString()));
        }
        return ResponseData.of(div).setState(DBB2710002StateName.特別徴収未同定一覧);
    }

    private ResponseData<TokuchoTaishoshaIchiranDiv> 同定非同定表示initialize(TokuchoTaishoshaIchiranDiv div) {
        div.setHiddenPageState(STATE特別徴収対象者一覧確認);
        TokuchoTaishoshaIchiranSakuseiResult result = getHandler(div).同定非同定表示initialize();
        if (result != null) {
            ViewStateHolder.put(ViewStateKeys.特別徴収開始月, result.get特別徴収開始月());
            ViewStateHolder.put(ViewStateKeys.捕捉月リスト, (Serializable) result.get捕捉月リスト());
        }
        return ResponseData.of(div).setState(DBB2710002StateName.同定非同定表示);
    }

    private void 特別徴収同定候補者一覧initialize(TokuchoTaishoshaIchiranDiv div) {
        RString 処理年度 = ViewStateHolder.get(ViewStateKeys.処理年度, RString.class);
        RString 捕捉月 = ViewStateHolder.get(ViewStateKeys.捕捉月, RString.class);
        RString 基礎年金番号 = ViewStateHolder.get(ViewStateKeys.基礎年金番号, RString.class);
        RString 年金コード = ViewStateHolder.get(ViewStateKeys.年金コード, RString.class);
        RString 特徴開始月 = ViewStateHolder.get(ViewStateKeys.特別徴収開始月, RString.class);
        List<TokuchoMidoteiJoho> models
                = getHandler(div).特別徴収同定候補者一覧initialize(処理年度, 捕捉月, 基礎年金番号, 年金コード, 特徴開始月);
        ViewStateHolder.put(ViewStateKeys.特別徴収同定候補者リスト, (ArrayList<TokuchoMidoteiJoho>) models);
        if (models.size() == 1) {
            ViewStateHolder.put(ViewStateKeys.特別徴収同定候補者, models.get(NUM0));
            ViewStateHolder.put(ViewStateKeys.特別徴収同定候補者対象外リスト,
                    (ArrayList<TokuchoMidoteiJoho>) get対象外(models.get(NUM0)));
        }
        Map<TokuchoMidoteiJohoIdentifier, List<TokuchoMidoteiJoho>> 対象外Map
                = get対象外Map(models);
        ViewStateHolder.put(ViewStateKeys.特別徴収同定候補者対象外Map,
                (HashMap<TokuchoMidoteiJohoIdentifier, List<TokuchoMidoteiJoho>>) 対象外Map);
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (taishoshaKey == null || taishoshaKey.get被保険者番号() == null) {
            return;
        }
        getHandler(div).対象者検索戻る値の処理(taishoshaKey, ViewStateHolder.get(ViewStateKeys.特別徴収開始月, RString.class));
        ViewStateHolder.put(ViewStateKeys.資格対象者, null);
    }

    private Map<TokuchoMidoteiJohoIdentifier, List<TokuchoMidoteiJoho>> get対象外Map(
            List<TokuchoMidoteiJoho> tokuchoMidoteiJohos) {
        if (tokuchoMidoteiJohos == null || tokuchoMidoteiJohos.isEmpty()) {
            return null;
        }
        Map<TokuchoMidoteiJohoIdentifier, List<TokuchoMidoteiJoho>> 対象外Map = new HashMap<>();
        for (TokuchoMidoteiJoho model : tokuchoMidoteiJohos) {
            if (model == null) {
                continue;
            }
            TokuchoMidoteiJohoIdentifier id = model.identifier();
            service = TokuchoTaishoshaIchiranSakusei.createInstance();
            List<TokuchoMidoteiJoho> models = service.get特徴未同定情報List(id);
            if (models != null && !models.isEmpty()) {
                対象外Map.put(id, (ArrayList<TokuchoMidoteiJoho>) models);
            }
        }
        return 対象外Map;
    }

    private List<TokuchoMidoteiJoho> get対象外(TokuchoMidoteiJoho model) {
        if (model == null) {
            return null;
        }
        TokuchoMidoteiJohoIdentifier id = model.identifier();
        Map<TokuchoMidoteiJohoIdentifier, List<TokuchoMidoteiJoho>> 対象外Map
                = ViewStateHolder.get(ViewStateKeys.特別徴収同定候補者対象外Map, HashMap.class);
        if (対象外Map == null) {
            return null;
        }
        return 対象外Map.get(id);
    }

    /**
     * 「実行」ボタンを押下する。<br/>
     * 特別徴収対象者一覧作成
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv}
     * @return TokuchoTeishiTaisyosyaDouteiBatchParameterを持つResponseData
     */
    public ResponseData<TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter>
            onClick_btnBatchRegister(TokuchoTaishoshaIchiranDiv div) {
        RString 特別徴収開始月 = ViewStateHolder.get(ViewStateKeys.特別徴収開始月, RString.class);
        List<RString> 捕捉月リスト = ViewStateHolder.get(ViewStateKeys.捕捉月リスト, List.class);
        TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter parameter
                = getHandler(div).getBatchParameter(特別徴収開始月, 捕捉月リスト);
        TokuchoTaishoshaIchiranSakuseiResult result = getHandler(div).同定非同定表示initialize();
        if (result != null) {
            ViewStateHolder.put(ViewStateKeys.特別徴収開始月, result.get特別徴収開始月());
            ViewStateHolder.put(ViewStateKeys.捕捉月リスト, (Serializable) result.get捕捉月リスト());
        }
        ResponseData<TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter> responseData = new ResponseData<>();
        responseData.data = parameter;
        return responseData;
    }

    /**
     * before「実行」ボタンを押下する。<br/>
     * 特別徴収対象者一覧作成
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv}
     * @return ResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> before_btnBatchRegister(TokuchoTaishoshaIchiranDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate出力対象();
        pairs.add(getValidationHandler(div).validate特別徴収開始月未指定());
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「back」ボタンを押下する。<br/>
     * 特別徴収同定一覧 特別徴収未同定一覧
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv }
     * @return ResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> onClick_btnBack(TokuchoTaishoshaIchiranDiv div) {
        getHandler(div).同定非同定表示に戻るinitialize(ViewStateHolder.get(ViewStateKeys.表示対象, RString.class),
                ViewStateHolder.get(ViewStateKeys.確認済を含む, boolean.class),
                ViewStateHolder.get(ViewStateKeys.最大表示件数, RString.class));
        return ResponseData.of(div)
                .setState(DBB2710002StateName.同定非同定表示);
    }

    /**
     * 出力対象変化後の処理。<br/>
     * 特別徴収対象者一覧作成
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv }
     * @return を持つResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> onChange_ChkOutPro(TokuchoTaishoshaIchiranDiv div) {
        getHandler(div).onChange_Chk出力対象(div);
        return ResponseData.of(div).respond();
    }

    /**
     * test使用，作为画面临时跳转使用，用完删除。<br/>
     * 特別徴収対象者一覧作成
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv }
     * @return を持つResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> onClick_TempStateChange(TokuchoTaishoshaIchiranDiv div) {
        //test用，用完删除
        return 同定非同定表示initialize(div);
    }

    /**
     * 出力対象変化後の処理<br/>
     * 同定非同定表示
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv }
     * @return を持つResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> onChange_RadShowPro(TokuchoTaishoshaIchiranDiv div) {
        getHandler(div).onChange_Rad表示対象(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「表示する」ボタンを押下する。<br/>
     * 同定非同定表示
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv }
     * @return を持つResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> onClick_btnShow(TokuchoTaishoshaIchiranDiv div) {
        RString 最大表示件数_画面 = div.getTxtMaxHyojiKensu().getValue();
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate最大表示件数();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        RString selected表示対象 = div.getRadhyojiTaisho().getSelectedKey();
        RString 特別徴収開始月 = div.getTxtKaishiYM().getValue();
        ViewStateHolder.put(ViewStateKeys.特別徴収開始月, 特別徴収開始月);
        ViewStateHolder.put(ViewStateKeys.最大表示件数, 最大表示件数_画面);
        if (KEY0.compareTo(selected表示対象) == NUM0) {
            ViewStateHolder.put(ViewStateKeys.表示対象, KEY0);
            ViewStateHolder.put(ViewStateKeys.確認済を含む, false);
            return 特別徴収同定一覧initialize(div);
        } else if (KEY1.compareTo(selected表示対象) == NUM0) {
            ViewStateHolder.put(ViewStateKeys.表示対象, KEY1);
            List<RString> selectedKeys = div.getChkKakuninZumiFukumu().getSelectedKeys();
            if (selectedKeys.contains(KEY0)) {
                ViewStateHolder.put(ViewStateKeys.確認済を含む, true);
            } else {
                ViewStateHolder.put(ViewStateKeys.確認済を含む, false);
            }
            return 特別徴収未同定一覧initialize(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * dataGrid(dgTokubetChoshuMidoteiIchiran)のSelectButtonを押下する。<br/>
     * 非同定表示
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv }
     * @return を持つResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv>
            onClick_dgTokubetChoshuMidoteiIchiranSelect(TokuchoTaishoshaIchiranDiv div) {
        RDate nowDate = RDate.getNowDate();
        RString 処理年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, nowDate, SubGyomuCode.DBB介護賦課);
        dgTokubetChoshuMidoteiIchiran_Row selectedRow = div.getDgTokubetChoshuMidoteiIchiran().getClickedItem();
        RString 捕捉月 = selectedRow.getTxtHosokuM().getValue();
        if (!RString.isNullOrEmpty(捕捉月)) {
            捕捉月 = 捕捉月.replace(月_RS, RString.EMPTY).padZeroToLeft(NUM2);
        }
        RString 基礎年金番号 = selectedRow.getTxtKisoNenkinNo().getValue();
        RString 年金コード = selectedRow.getTxtNenkinCode().getValue();
        RString 確認状況 = selectedRow.getTxtKakuninJokyo();
        RString fuichiRiyu = selectedRow.getTxtFuichiRiyu();
        div.setHiddenReasonCode(getDoteiFuitchiRiyuCode(fuichiRiyu));
        div.setHiddenConfirmState(確認状況);
        ViewStateHolder.put(ViewStateKeys.処理年度, 処理年度);
        ViewStateHolder.put(ViewStateKeys.捕捉月, 捕捉月);
        ViewStateHolder.put(ViewStateKeys.基礎年金番号, 基礎年金番号);
        ViewStateHolder.put(ViewStateKeys.年金コード, 年金コード);
        ViewStateHolder.put(ViewStateKeys.確認状況, 確認状況);
        特別徴収同定候補者一覧initialize(div);
        return ResponseData.of(div).setState(DBB2710002StateName.特別徴収同定候補者一覧);
    }

    private RString getDoteiFuitchiRiyuCode(RString doteiFuitchiRiyu) {
        for (DoteiFuitchiRiyu dfr : DoteiFuitchiRiyu.values()) {
            if (dfr.get不一致理由名().equals(doteiFuitchiRiyu)) {
                return dfr.getコード();
            }
        }
        return null;
    }

    /**
     * 「未同定一覧に」ボタンを押下する。<br/>
     * 特別徴収同定候補者一覧
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv }
     * @return を持つResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> onClick_btnBackToMiDoteiIchiran(TokuchoTaishoshaIchiranDiv div) {
        return 特別徴収未同定一覧initialize(div);
    }

    /**
     * dataGrid(dgTokuchoDoteiKohoshaIchiran)のSelectButtonを押下する。<br/>
     * 特別徴収同定候補者一覧
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv }
     * @return を持つResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> onClick_btnGridSelect(TokuchoTaishoshaIchiranDiv div) {
        dgTokubetChoshuMidoteiIchiran_Row selectedRow = div.getDgTokubetChoshuMidoteiIchiran().getClickedItem();
        RString fuichiRiyu = selectedRow.getTxtFuichiRiyu();
        div.setHiddenReasonCode(getDoteiFuitchiRiyuCode(fuichiRiyu));
        getHandler(div).一行同定候補者一覧initialize表示制御();
        RString 特別徴収開始月 = ViewStateHolder.get(ViewStateKeys.特別徴収開始月, RString.class);
        RString 捕捉月 = ViewStateHolder.get(ViewStateKeys.捕捉月, RString.class);
        RString 処理年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 基礎年金番号 = div.getDgTokuchoDoteiKohoshaIchiran().getClickedItem().
                getTxtNenkinKaifukuInfoKisoNenkinNo().getValue();
        RString 年金コード = div.getDgTokuchoDoteiKohoshaIchiran().getClickedItem().
                getTxtNenkinKaifukuInfoNenkinCode().getValue();
        RString 識別コードTemp = div.getDgTokuchoDoteiKohoshaIchiran().
                getClickedItem().getTxtShikibetsuCode();
        ShikibetsuCode 識別コード = 識別コードTemp == null ? null
                : new ShikibetsuCode(識別コードTemp);
        TokuchoMidoteiJoho model
                = getClickedModel(new FlexibleYear(処理年度), 基礎年金番号, 年金コード, 捕捉月, 識別コード);
        ViewStateHolder.put(ViewStateKeys.特別徴収同定候補者, model);
        ViewStateHolder.put(ViewStateKeys.特別徴収同定候補者対象外リスト,
                (ArrayList<TokuchoMidoteiJoho>) get対象外(model));
        TokuchoDouteiKouhoshaShousaiJoho result
                = getHandler(div).show特別徴収同定候補者詳細情報(特別徴収開始月, 捕捉月);

        ViewStateHolder.put(ViewStateKeys.被保険者番号, result.get被保険者台帳_被保険者番号());
        ViewStateHolder.put(ViewStateKeys.氏名, result.get住基情報_漢字氏名());
        return ResponseData.of(div).respond();
    }

    private TokuchoMidoteiJoho getClickedModel(FlexibleYear 処理年度, RString 基礎年金番号, RString 年金コード,
            RString 捕捉月, ShikibetsuCode 識別コード) {
        List<TokuchoMidoteiJoho> models = ViewStateHolder.get(ViewStateKeys.特別徴収同定候補者リスト, ArrayList.class);
        if (models == null || models.isEmpty()) {
            return null;
        }
        if (models.size() == 1) {
            return models.get(NUM0);
        }
        for (TokuchoMidoteiJoho model : models) {
            if (model.get処理年度().equals(処理年度) && model.get基礎年金番号().equals(基礎年金番号)
                    && model.get年金コード().equals(年金コード) && model.get捕捉月().equals(捕捉月)
                    && model.get識別コード().equals(識別コード)) {
                return model;
            }
        }
        return null;
    }

    /**
     * 「被保険者検索」ボタンを押下する。<br/>
     * 特別徴収同定候補者一覧 {被保険者検索」ボタン押下処理
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv }
     * @return を持つResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> onClick_btnHihokensha(TokuchoTaishoshaIchiranDiv div) {
        RString fukaNendo = div.getHiddenFukaNendo();
        if (fukaNendo == null) {
            div.getTorokuZumiNenkinInfo().setDisplayNone(true);
        } else {
            div.getTorokuZumiNenkinInfo().setDisplayNone(false);
        }
        div.setHiddenPageState(KEY2);
        return ResponseData.of(div).forwardWithEventName(DBB2710002TransitionEventName.被保険者検索).respond();
    }

    /**
     * 「同定する」ボタン押下処理<br/>
     * 特別徴収同定候補者一覧·
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv }
     * @return を持つResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> onClick_btnDoutei(TokuchoTaishoshaIchiranDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate被保険者();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest() && (!RString.isNullOrEmpty(
                div.getTxtTorokuZumiKisoNenkinNo().getValue()) || !RString.isNullOrEmpty(
                        div.getTxtTorokuZumiNenkinCode().getValue())
                || !RString.isNullOrEmpty(div.getTxtTorokuZumiTokuchoGimusha().getValue()))) {
            return ResponseData.of(div).addMessage(
                    DbbWarningMessages.別情報での特徴対象者同定.getMessage()).respond();
        }
        if (new RString(DbbWarningMessages.別情報での特徴対象者同定.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<dgTokuchoDoteiKohoshaIchiran_Row> 特別徴収同定候補者一覧List
                    = div.getDgTokuchoDoteiKohoshaIchiran().getDataSource();
            if (特別徴収同定候補者一覧List != null && NUM1 < 特別徴収同定候補者一覧List.size()) {
                return ResponseData.of(div).addMessage(
                        DbbWarningMessages.他の候補者を対象外更新.getMessage()).respond();
            } else {
                return ResponseData.of(div).addMessage(
                        new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                                UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
            }
        }
        List<dgTokuchoDoteiKohoshaIchiran_Row> 特別徴収同定候補者一覧List
                = div.getDgTokuchoDoteiKohoshaIchiran().getDataSource();
        if (!ResponseHolder.isReRequest() && 特別徴収同定候補者一覧List
                != null && !特別徴収同定候補者一覧List.isEmpty()
                && NUM1 < 特別徴収同定候補者一覧List.size()) {
            return ResponseData.of(div).addMessage(DbbWarningMessages.他の候補者を対象外更新.getMessage()).respond();
        }
        if (new RString(DbbWarningMessages.他の候補者を対象外更新.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).addMessage(
                    new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();

        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RString 特別徴収開始月 = ViewStateHolder.get(ViewStateKeys.特別徴収開始月, RString.class);
            RString 捕捉月 = ViewStateHolder.get(ViewStateKeys.捕捉月, RString.class);
            Message 同定Message = DbbInformationMessages.同定処理完了.getMessage();
            TokuchoMidoteiJoho model
                    = ViewStateHolder.get(ViewStateKeys.特別徴収同定候補者, TokuchoMidoteiJoho.class);
            List<TokuchoMidoteiJoho> taishogaiModels
                    = ViewStateHolder.get(ViewStateKeys.特別徴収同定候補者対象外リスト, ArrayList.class);

            getHandler(div)
                    .execute確認状態更新(特別徴収開始月, 捕捉月, 同定済み_CODE, 同定Message, model, taishogaiModels);
            return ResponseData.of(div)
                    .setState(DBB2710002StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「同定対象外確認済」ボタン押下処理<br/>
     * 特別徴収同定候補者一覧·
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv }
     * @return を持つResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> onClick_btnTaishoGai(TokuchoTaishoshaIchiranDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RString 特別徴収開始月 = ViewStateHolder.get(ViewStateKeys.特別徴収開始月, RString.class
            );
            RString 捕捉月 = ViewStateHolder.get(ViewStateKeys.捕捉月, RString.class);
            Message 同定対象外Message = DbbInformationMessages.同定対象外確認済処理完了.getMessage();
            TokuchoMidoteiJoho model
                    = ViewStateHolder.get(ViewStateKeys.特別徴収同定候補者, TokuchoMidoteiJoho.class);
            List<TokuchoMidoteiJoho> taishogaiModels
                    = ViewStateHolder.get(ViewStateKeys.特別徴収同定候補者対象外リスト, ArrayList.class);

            getHandler(div)
                    .execute確認状態更新(特別徴収開始月, 捕捉月, 対象外_CODE, 同定対象外Message, model, taishogaiModels);
            return ResponseData.of(div)
                    .setState(DBB2710002StateName.完了);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * onStateTransition表示制御<br/>
     * 特別徴収同定候補者一覧 表示制御
     *
     * @param div {@link TokuchoTaishoshaIchiranDiv }
     * @return を持つResponseData
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> onStateTransition_CommonBtn(TokuchoTaishoshaIchiranDiv div) {
        if (!RString.isNullOrEmpty(div.getHiddenState()) && 状態なし.compareTo(div.getHiddenState()) != NUM0) {
            getHandler(div).stateTransition_CommonBtn();
        }
        if (KEY2.equals(div.getHiddenPageState())) {
            特別徴収同定候補者一覧initialize(div);
            div.setHiddenPageState(KEY1);
            return ResponseData.of(div).setState(DBB2710002StateName.特別徴収同定候補者一覧);
        }
        return getHandler(div).stateTransition_RootTitle();
    }

    private TokuchoTaishoshaIchiranHandler getHandler(TokuchoTaishoshaIchiranDiv div) {
        return new TokuchoTaishoshaIchiranHandler(div);
    }

    private TokuchoTaishoshaIchiranValidationHandler getValidationHandler(TokuchoTaishoshaIchiranDiv div) {
        return new TokuchoTaishoshaIchiranValidationHandler(div);
    }
}

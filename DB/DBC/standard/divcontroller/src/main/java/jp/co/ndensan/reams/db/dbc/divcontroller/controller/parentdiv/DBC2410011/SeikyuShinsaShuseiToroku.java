/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2410011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.seikyushinsashuseitoroku.SeikyuShinsaShuseiTorokuBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.seikyushinsashuseitoroku.SeikyuShinsaShuseiTorokuCollect;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.seikyushinsashuseitoroku.SeikyuShinsaShuseiTorokuMapperParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011.DBC2410011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011.DBC2410011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011.SeikyuShinsaShuseiTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2410011.SeikyuShinsaShuseiTorokuHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JutakuKaishuRiyushoTesuryoKetteiManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JutakuKaishuRiyushoTesuryoMeisaiManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JutakuKaishuRiyushoTesuryoShukeiManager;
import jp.co.ndensan.reams.db.dbc.service.core.seikyushinsashuseitoroku.SeikyuShinsaShuseiTorokuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 住宅改修理由書作成手数料請求情報修正登録(審査結果登録)のクラスです。
 *
 * @reamsid_L DBC-2870-010 zhangruitao
 */
public class SeikyuShinsaShuseiToroku {

    private static final RString 照会 = new RString("照会");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 前排他キー = new RString("JutakuKaishuRiyushoSakuseiTesuryo");
    private static final RString 処理完了メッセージ = new RString("住宅改修理由書作成手数料請求審査情報の登録が完了しました。");
    private static final RString 事業者番号 = new RString("事業者番号：");
    private static final RString DBCMNE_1005 = new RString("DBCMNE1005");
    private static final RString DBCMNE_1004 = new RString("DBCMNE1004");

    /**
     * 画面初期化処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onLoad(SeikyuShinsaShuseiTorokuDiv div) {

        RString menuID = ResponseHolder.getMenuID();
        this.get前排他(前排他キー);
        getHandler(div).onLoad(menuID);
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_Kensaku(SeikyuShinsaShuseiTorokuDiv div) {
        RString 事業者番号 = div.getCcdJigyosha().getNyuryokuShisetsuKodo();
        RString 請求情報作成年月 = RString.EMPTY;
        if (div.getSearchJutakuTesuryoSeikyuJohoPanel().getTxtSearchSakuseiYM().getValue() != null) {
            請求情報作成年月 = new RString(div.getSearchJutakuTesuryoSeikyuJohoPanel().getTxtSearchSakuseiYM().getValue().getYearMonth().toString());
        }
        SeikyuShinsaShuseiTorokuMapperParameter parameter = SeikyuShinsaShuseiTorokuMapperParameter.
                createSelectByKeyParam(事業者番号, 請求情報作成年月, div.getChkSerchKetteiZumi().isAllSelected());
        SeikyuShinsaShuseiTorokuFinder seikyushinsashuseitorokufinder = SeikyuShinsaShuseiTorokuFinder.createInstance();
        List<SeikyuShinsaShuseiTorokuBusiness> 一覧情報 = seikyushinsashuseitorokufinder.getKoikinaiTenkyoList(parameter).records();
        if (一覧情報.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        SeikyuShinsaShuseiTorokuCollect collectList = new SeikyuShinsaShuseiTorokuCollect();
        collectList.set事業者情報List(一覧情報);
        ViewStateHolder.put(ViewStateKeys.住宅改修理由書事業者情報, collectList);
        getHandler(div).get検索一覧(一覧情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択する」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_Showukai(SeikyuShinsaShuseiTorokuDiv div) {
        div.getSearchJutakuTesuryoSeikyuJohoPanel().setExecutionStatus(照会);
        getHandler(div).get情報一覧();
        return 画面の遷移_照会(div);
    }

    /**
     * 「修正する」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_Shuwusei(SeikyuShinsaShuseiTorokuDiv div) {
        div.getSearchJutakuTesuryoSeikyuJohoPanel().setExecutionStatus(修正);
        getHandler(div).get情報一覧();
        return 画面の遷移(div);
    }

    /**
     * 「削除する」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData　<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_Sakujo(SeikyuShinsaShuseiTorokuDiv div) {
        div.getSearchJutakuTesuryoSeikyuJohoPanel().setExecutionStatus(削除);
        getHandler(div).get情報一覧();
        return 画面の遷移(div);
    }

    /**
     * 「明細一覧照会する」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_MeisaiShowukai(SeikyuShinsaShuseiTorokuDiv div) {
        getHandler(div).get明細照会一覧();
        return 画面の遷移(div);
    }

    /**
     * 「再検索する」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_btnSaiKensaku(SeikyuShinsaShuseiTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            getHandler(div).get情報一覧();
            getHandler(div).クリアデータ();
            if (DBCMNE_1004.equals(ResponseHolder.getMenuID())) {
                div.getChkSerchKetteiZumi().setVisible(false);
            } else {
                div.getChkSerchKetteiZumi().setVisible(true);
            }
            return 画面の戻る(div);
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && MessageDialogSelectedResult.No.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「請求情報集計パネルの請求合計」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onBlur_hasChanged(SeikyuShinsaShuseiTorokuDiv div) {
        getHandler(div).get請求合計();
        return ResponseData.of(div).respond();
    }

    /**
     * 「請求情報明細一覧GRD対象外CHK」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onBlur_hasChangedCheck(SeikyuShinsaShuseiTorokuDiv div) {
        int rowSize = getHandler(div).対象外CHK();
        if (rowSize == 0) {
            div.getTxtRiyushoSakuseiKensu().setValue(Decimal.ZERO);
        } else {
            div.getTxtRiyushoSakuseiKensu().setValue(new Decimal(rowSize));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「「保存する」ボタン」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_btnHozon(SeikyuShinsaShuseiTorokuDiv div) {
        int index = div.getDgSeikyuMeisai().getClickedRowId();
        if (index == -1) {
            index = index + 1;
        }
        SeikyuShinsaShuseiTorokuBusiness 住宅改修理由書事業者明細情報 = ViewStateHolder
                .get(ViewStateKeys.住宅改修理由書事業者情報明細, SeikyuShinsaShuseiTorokuCollect.class).get事業者情報List().get(index);
        JutakuKaishuRiyushoTesuryoMeisaiManager 出力明細MANAGER = new JutakuKaishuRiyushoTesuryoMeisaiManager();
        JutakuKaishuRiyushoTesuryoKetteiManager 出力決定MANAGER = new JutakuKaishuRiyushoTesuryoKetteiManager();
        JutakuKaishuRiyushoTesuryoShukeiManager 出力集計MANAGER = new JutakuKaishuRiyushoTesuryoShukeiManager();
        入力チェック(div);
        if (修正.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                SeikyuShinsaShuseiTorokuBusiness businessResult = getHandler(div).修正更新(住宅改修理由書事業者明細情報);
                保存の確認(出力明細MANAGER, 出力決定MANAGER, 出力集計MANAGER, businessResult);
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && MessageDialogSelectedResult.No.equals(ResponseHolder.getButtonType())) {
                return ResponseData.of(div).respond();
            }
        }
        if (削除.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                SeikyuShinsaShuseiTorokuBusiness businessResult = getHandler(div).削除更新(住宅改修理由書事業者明細情報);
                出力明細MANAGER.save住宅改修理由書作成手数料請求明細(businessResult.getDbT3095().deleted());
                出力集計MANAGER.save住宅改修理由書作成手数料請求集計(businessResult.getDbT3096().deleted());
                出力決定削除(出力決定MANAGER, businessResult);
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && MessageDialogSelectedResult.No.equals(ResponseHolder.getButtonType())) {
                return ResponseData.of(div).respond();
            }
        }
        div.getCcdKanryoMessage().setSuccessMessage(処理完了メッセージ, 事業者番号.concat(div.getTxtJigyoshaNo().getValue()), RString.EMPTY);
        return ResponseData.of(div).setState(DBC2410011StateName.処理完了);
    }

    private void 保存の確認(JutakuKaishuRiyushoTesuryoMeisaiManager 出力明細MANAGER,
            JutakuKaishuRiyushoTesuryoKetteiManager 出力決定MANAGER,
            JutakuKaishuRiyushoTesuryoShukeiManager 出力集計MANAGER,
            SeikyuShinsaShuseiTorokuBusiness businessResult) {
        if (businessResult.getDbT3094() != null) {
            出力決定MANAGER.save住宅改修理由書作成手数料請求決定(businessResult.getDbT3094());
        }
        出力明細MANAGER.save住宅改修理由書作成手数料請求明細(businessResult.getDbT3095());
        出力集計MANAGER.save住宅改修理由書作成手数料請求集計(businessResult.getDbT3096());

    }

    private void 出力決定削除(JutakuKaishuRiyushoTesuryoKetteiManager 出力決定MANAGER, SeikyuShinsaShuseiTorokuBusiness businessResult) {
        if (DBCMNE_1005.equals(ResponseHolder.getMenuID())
                && businessResult.getDbT3094() != null) {
            出力決定MANAGER.save住宅改修理由書作成手数料請求決定(businessResult.getDbT3094().deleted());
        }
    }

    /**
     * 「「完了する」ボタン」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_btnComplete(SeikyuShinsaShuseiTorokuDiv div) {
        前排他キーの解除(前排他キー);
        return ResponseData.of(div).forwardWithEventName(DBC2410011TransitionEventName.完了).respond();
    }

    /**
     * 「「処理を続ける」ボタン」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_btnContinue(SeikyuShinsaShuseiTorokuDiv div) {
        return 画面リロード(div);
    }

    private SeikyuShinsaShuseiTorokuHandler getHandler(SeikyuShinsaShuseiTorokuDiv div) {
        return new SeikyuShinsaShuseiTorokuHandler(div);
    }

    /**
     * 前排他を取得します
     *
     * @param 前排他キー 前排他キー
     */
    public void get前排他(RString 前排他キー) {
        LockingKey 排他キー = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(排他キー)) {
            throw new PessimisticLockingException();
        }
    }

    /**
     * 前排他キーを解除します
     *
     * @param 前排他キー 前排他キー
     */
    public void 前排他キーの解除(RString 前排他キー) {
        LockingKey 排他キー = new LockingKey();
        RealInitialLocker.release(排他キー);
    }

    private ResponseData<SeikyuShinsaShuseiTorokuDiv> 画面の遷移(SeikyuShinsaShuseiTorokuDiv div) {
        if (DBC2410011StateName.情報修正登録検索.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.情報修正登録);
        }
        if (DBC2410011StateName.審査結果登録検索.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.審査結果登録);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<SeikyuShinsaShuseiTorokuDiv> 画面の遷移_照会(SeikyuShinsaShuseiTorokuDiv div) {
        if (DBC2410011StateName.情報修正登録検索.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.情報修正登録照会);
        }
        if (DBC2410011StateName.審査結果登録検索.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.審査結果登録照会);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<SeikyuShinsaShuseiTorokuDiv> 画面の戻る(SeikyuShinsaShuseiTorokuDiv div) {
        if (DBC2410011StateName.情報修正登録照会.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.情報修正登録検索戻る);
        }
        if (DBC2410011StateName.審査結果登録照会.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.審査結果登録検索戻る);
        }
        if (DBC2410011StateName.情報修正登録.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.情報修正登録検索戻る);
        }
        if (DBC2410011StateName.審査結果登録.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.審査結果登録検索戻る);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<SeikyuShinsaShuseiTorokuDiv> 画面リロード(SeikyuShinsaShuseiTorokuDiv div) {

        getHandler(div).クリアデータ();
        List<SeikyuShinsaShuseiTorokuBusiness> 住宅改修理由書事業者情報リスト = ViewStateHolder
                .get(ViewStateKeys.住宅改修理由書事業者情報, SeikyuShinsaShuseiTorokuCollect.class).get事業者情報List();
        getHandler(div).get検索一覧(住宅改修理由書事業者情報リスト);
        if (DBCMNE_1004.equals(ResponseHolder.getMenuID()) && DBC2410011StateName.処理完了.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.情報修正登録検索戻る);
        }
        if (DBCMNE_1005.equals(ResponseHolder.getMenuID()) && DBC2410011StateName.処理完了.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.審査結果登録検索戻る);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<SeikyuShinsaShuseiTorokuDiv> 入力チェック(SeikyuShinsaShuseiTorokuDiv div) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(getHandler(div).請求単価チェック());
        validPairs.add(getHandler(div).決定区分チェック());
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }
}

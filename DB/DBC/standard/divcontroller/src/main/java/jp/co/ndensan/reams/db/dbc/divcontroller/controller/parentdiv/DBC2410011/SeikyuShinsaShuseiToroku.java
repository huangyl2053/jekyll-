
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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011.SeikyuShinsaShuseiTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2410011.SeikyuShinsaShuseiTorokuHandler;
import jp.co.ndensan.reams.db.dbc.service.core.seikyushinsashuseitoroku.SeikyuShinsaShuseiTorokuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 住宅改修理由書作成手数料請求情報修正登録(審査結果登録)のクラスです。
 *
 * @reamsid_L DBC-2870-010 zhangruitao
 */
public class SeikyuShinsaShuseiToroku {

    private static final RString 照会 = new RString("照会");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 保存 = new RString("保存は正常に終了しました。");
    private static final RString 前排他キー = new RString("JutakuKaishuRiyushoSakuseiTesuryo");

    /**
     * 画面初期化処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onLoad(SeikyuShinsaShuseiTorokuDiv div) {

        RString menuID = ResponseHolder.getMenuID();
        get前排他(前排他キー);
        if (!get前排他(前排他キー)) {
            throw new PessimisticLockingException();
        }
        div.setDisabled(false);
        getHandler(div).onLoad(menuID);
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者番号を選択する」ダイアログボタンの処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData <SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_onBeforeOpenDialog(SeikyuShinsaShuseiTorokuDiv div) {
        JigyoshaMode model = new JigyoshaMode();
        RString txt_SerchJigyosyaNo = div.getSearchJutakuTesuryoSeikyuJohoPanel().getTxtSerchJigyosyaNo().getValue();
        model.setJigyoshaNo(new KaigoJigyoshaNo(txt_SerchJigyosyaNo));
        model.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
        div.setJigyoshaMode(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者番号を選択する」ダイアログボタンの処理です。
     *
     * @param div 様式別連携情報Div
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_onOkClose(SeikyuShinsaShuseiTorokuDiv div) {
        JigyoshaMode model = DataPassingConverter.deserialize(div.getJigyoshaMode(), JigyoshaMode.class);
        div.getSearchJutakuTesuryoSeikyuJohoPanel().getTxtSerchJigyosyaNo().setValue(model.getJigyoshaNo().value());
        div.getSearchJutakuTesuryoSeikyuJohoPanel().getTxtSerchJigyosyaName().setValue(model.getJigyoshaName().value());
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_Kensaku(SeikyuShinsaShuseiTorokuDiv div) {
        RString 事業者番号 = div.getSearchJutakuTesuryoSeikyuJohoPanel().getTxtSerchJigyosyaNo().getValue();
        RDate 理由書作成年月 = div.getSearchJutakuTesuryoSeikyuJohoPanel().getTxtSearchSakuseiYM().getValue();
        SeikyuShinsaShuseiTorokuMapperParameter parameter = SeikyuShinsaShuseiTorokuMapperParameter.
                createSelectByKeyParam(事業者番号, 理由書作成年月, div.getChkSerchKetteiZumi().isAllSelected());
        SeikyuShinsaShuseiTorokuFinder seikyushinsashuseitorokufinder = SeikyuShinsaShuseiTorokuFinder.createInstance();
        List<SeikyuShinsaShuseiTorokuBusiness> 一覧情報 = seikyushinsashuseitorokufinder.getKoikinaiTenkyoList(parameter).records();
        SeikyuShinsaShuseiTorokuCollect collectList = new SeikyuShinsaShuseiTorokuCollect();
        collectList.set事業者情報List(一覧情報);
        ViewStateHolder.put(ViewStateKeys.住宅改修理由書事業者情報, collectList);
        getHandler(div).get検索一覧(一覧情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 「照会する」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_Showukai(SeikyuShinsaShuseiTorokuDiv div) {
        div.getSearchJutakuTesuryoSeikyuJohoPanel().setExecutionStatus(照会);
        getHandler(div).get情報一覧();
        return 画面の遷移(div);
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
     * 「検索結果一覧へ」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_btnKekkaIchiranHe(SeikyuShinsaShuseiTorokuDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            getHandler(div).get操作確認();
            return 画面リロード(div);
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
     * 「請求情報集計パネルの請求合計」の処理です。
     *
     * @param div SeikyuShinsaShuseiTorokuDiv
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public ResponseData<SeikyuShinsaShuseiTorokuDiv> onClick_btnHozon(SeikyuShinsaShuseiTorokuDiv div) {
        SeikyuShinsaShuseiTorokuBusiness business = ViewStateHolder
                .get(ViewStateKeys.住宅改修理由書事業者情報, SeikyuShinsaShuseiTorokuCollect.class).get事業者情報List().get(div.getDgSeikyu().getClickedRowId());
        if (div.getDgSeikyuMeisai().getActiveRow() == null && !ResponseHolder.isReRequest()) {
            InformationMessage message = new InformationMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode(),
                    DbzInformationMessages.内容変更なしで保存不可.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (getHandler(div).is内容変更状態(business) && 修正.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                getHandler(div).修正更新(business);
            }
        } else if (修正.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus()) && !ResponseHolder.isReRequest()) {
            InformationMessage message = new InformationMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode(),
                    DbzInformationMessages.内容変更なしで保存不可.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (削除.equals(div.getSearchJutakuTesuryoSeikyuJohoPanel().getExecutionStatus())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }

            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                getHandler(div).削除更新(business);
            }
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    UrInformationMessages.正常終了.getMessage().replace(保存.toString())).respond();
        }
        this.前排他キーの解除(ResponseHolder.getMenuID());
        this.onClick_Kensaku(div);
        return 画面リロード(div);
    }

    private SeikyuShinsaShuseiTorokuHandler getHandler(SeikyuShinsaShuseiTorokuDiv div) {
        return new SeikyuShinsaShuseiTorokuHandler(div);
    }

    /**
     * 前排他を取得します
     *
     *
     * @param 前排他キー 前排他キー
     * @return boolean
     */
    public boolean get前排他(RString 前排他キー) {
        LockingKey 排他キー = new LockingKey(前排他キー);
        return RealInitialLocker.tryGetLock(排他キー);
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

    /**
     * 自画面の画面状態遷移する
     */
    private ResponseData<SeikyuShinsaShuseiTorokuDiv> 画面の遷移(SeikyuShinsaShuseiTorokuDiv div) {
        if (DBC2410011StateName.情報修正登録検索.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.情報修正登録);
        }
        if (DBC2410011StateName.審査結果登録検索.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.審査結果登録);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 自画面の画面状態を逆遷移する
     */
    private ResponseData<SeikyuShinsaShuseiTorokuDiv> 画面リロード(SeikyuShinsaShuseiTorokuDiv div) {

        getHandler(div).クリアデータ();
        if (DBC2410011StateName.情報修正登録.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.情報修正登録検索);
        }
        if (DBC2410011StateName.審査結果登録.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBC2410011StateName.審査結果登録検索);
        }
        return ResponseData.of(div).respond();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0330011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuJuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuJuryoininKeiyakuJigyoshaHolder;
import jp.co.ndensan.reams.db.dbc.business.core.kogakujuryoininkeiyakujigyosha.KogakuJuryoininKeiyakuJigyoshaResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakuservicehijuryoininkeiyakukakuninsho.KogakuServiceHiJuryoininKeiyakuKakuninshoResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakujuryoininkeiyakujigyosha.KogakuJuryoininKeiyakuJigyoshaParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011.DBC0330011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011.DBC0330011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011.DvKogakuServiceJuryoIninDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0330011.DvKogakuServiceJuryoIninHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0330011.DvKogakuServiceJuryoIninValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0030011.KogakuServiceData;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuJuryoininKeiyakuJigyoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.kogakujuryoininkeiyakujigyosha.KogakuJuryoininKeiyakuJigyoshaFinder;
import jp.co.ndensan.reams.db.dbc.service.report.dbc100031.KogakuServiceJyuryoKakuninShoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 高額サービス費等受領委任払情報管理のDivControllerです。
 *
 * @reamsid_L DBC-1980-010 yuqingzhang
 */
public class DvKogakuServiceJuryoInin {

    private static final RString 事業者入力モード = new RString("事業者入力モード");
    private static final RString 台帳種別表示無し = new RString("台帳種別表示無し");
    private static final RString メニューID_追加 = new RString("DBCMN31005");
    private static final RString メニューID_修正 = new RString("DBCMN31006");
    private static final RString BUTTONID_該当者一覧へ_一覧 = new RString("btnShuseiIchiranBack");
    private static final RString BUTTONID_該当者一覧へ_追加 = new RString("btnTsukaIchiranBack");
    private static final RString BUTTONID_発行する = new RString("btnHakko");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    private DvKogakuServiceJuryoIninHandler getHandler(DvKogakuServiceJuryoIninDiv div) {
        return new DvKogakuServiceJuryoIninHandler(div);
    }

    private DvKogakuServiceJuryoIninValidationHandler getValidationHandler(DvKogakuServiceJuryoIninDiv div) {
        return new DvKogakuServiceJuryoIninValidationHandler(div);
    }

    /**
     * 介護支援専門員登録画面 初期化を処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onLoad(DvKogakuServiceJuryoIninDiv div) {
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 台帳種別表示無し);
        ViewStateHolder.put(ViewStateKeys.事業者入力モード, 事業者入力モード);

        DBC0330011StateName 画面タイトル = get画面タイトル();

        TaishoshaKey 引き継ぎデータ = ViewStateHolder.get(
                jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (null == 引き継ぎデータ || null == 引き継ぎデータ.get被保険者番号()
                || HihokenshaNo.EMPTY.equals(引き継ぎデータ.get被保険者番号())) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace("被保険者番号なし"));
        }

        LockingKey 前排他ロックキー = new LockingKey(引き継ぎデータ.get被保険者番号().value());
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            throw new PessimisticLockingException();
        }

        KogakuJuryoininKeiyakuJigyoshaParameter param = new KogakuJuryoininKeiyakuJigyoshaParameter();
        param.set被保険者番号(引き継ぎデータ.get被保険者番号().value());
        KogakuJuryoininKeiyakuJigyoshaFinder finder = KogakuJuryoininKeiyakuJigyoshaFinder.createInstance();
        List<KogakuJuryoininKeiyakuJigyoshaResult> resultList = finder.get高額受領委任契約事業者情報(param);
        if (null != resultList && (!resultList.isEmpty())) {
            List<KogakuJuryoininKeiyakuJigyosha> businessList = new ArrayList<>();
            for (KogakuJuryoininKeiyakuJigyoshaResult result : resultList) {
                businessList.add(result.getKogakuJuryoininKeiyakuJigyosha());
            }
            if (!businessList.isEmpty()) {
                ViewStateHolder.put(ViewStateHolderName.高額受領委任契約事業者, new KogakuJuryoininKeiyakuJigyoshaHolder(businessList));
            }
        }
        getHandler(div).onLoad(引き継ぎデータ, 画面タイトル, resultList);
        return ResponseData.of(div).setState(画面タイトル);
    }

    private DBC0330011StateName get画面タイトル() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (メニューID_追加.equals(menuID)) {
            return DBC0330011StateName.追加;
        }
        if (メニューID_修正.equals(menuID)) {
            return DBC0330011StateName.修正;
        }
        return DBC0330011StateName.NoChange;
    }

    /**
     * 「保存する」ボタンと「発行する」ボタンの制御を処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onState(DvKogakuServiceJuryoIninDiv div) {
        if (DBC0330011StateName.追加.getName().equals(ResponseHolder.getState()) || DBC0330011StateName.修正.getName().equals(ResponseHolder.getState())) {
            boolean is経由該当者一覧画面 = null == ViewStateHolder.get(ViewStateKeys.is経由該当者一覧画面, Boolean.class)
                    ? false : ViewStateHolder.get(ViewStateKeys.is経由該当者一覧画面, Boolean.class);
            if (追加.equals(div.getOperateState())) {
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(BUTTONID_該当者一覧へ_追加, !is経由該当者一覧画面);
            } else {
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(BUTTONID_該当者一覧へ_一覧, !is経由該当者一覧画面);
            }
        }

        if (DBC0330011StateName.発行.getName().equals(ResponseHolder.getState())) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(BUTTONID_発行する, 削除.equals(div.getOperateState()));
        }
        return ResponseData.of(div).rootTitle(div.getRootTitle()).respond();
    }

    /**
     * 高額サービス費等受領委任払管理一覧グリッド 「修正」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onClick_dgModify(DvKogakuServiceJuryoIninDiv div) {
        getHandler(div).onClick_dgModify();
        return ResponseData.of(div).respond();
    }

    /**
     * 高額サービス費等受領委任払管理一覧グリッド 「削除」ボタンの変更を処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onClick_dgDelete(DvKogakuServiceJuryoIninDiv div) {
        getHandler(div).onClick_dgDelete();
        return ResponseData.of(div).respond();
    }

    /**
     * ｢世帯一覧を表示する｣ボタンの変更を処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onClick_btnSeitaiIchiran(DvKogakuServiceJuryoIninDiv div) {
        TaishoshaKey 引き継ぎデータ = ViewStateHolder.get(
                jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class);
        KogakuServiceData 引き継ぎ情報 = getHandler(div).onClick_btnSeitaiIchiran(引き継ぎデータ);
        ViewStateHolder.put(ViewStateKeys.該当者一覧キー, 引き継ぎ情報);
        return ResponseData.of(div).forwardWithEventName(DBC0330011TransitionEventName.世帯情報表示).respond();
    }

    /**
     * 決定区分の変更を処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onChange_radKetteiKubun(DvKogakuServiceJuryoIninDiv div) {
        getHandler(div).onChange_radKetteiKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * 「決定一覧へ戻る」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onClick_btnKetteiIchiranBack(DvKogakuServiceJuryoIninDiv div) {
        if ((!ResponseHolder.isReRequest()) && getHandler(div).onClick_btnKetteiIchiranBack()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().getCode(),
                    UrQuestionMessages.確認_汎用.getMessage().replace("編集されています。入力画面を終了して").evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).setState(DBC0330011StateName.修正);
    }

    /**
     * 「該当者一覧へ戻る」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onClick_btnShuseiIchiranBack(DvKogakuServiceJuryoIninDiv div) {
        RString state = ResponseHolder.getState();
        if (追加.equals(state)) {
            if ((!ResponseHolder.isReRequest()) && getHandler(div).onClick_btnShuseiBack(state)) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        LockingKey 前排他ロックキー = new LockingKey(div.getDvKyotsuJoho().getCddShikakuKihon().get被保険者番号());
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).forwardWithEventName(DBC0330011TransitionEventName.対象一覧へ戻る).respond();
    }

    /**
     * 「該当者検索へ戻る」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onClick_btnShuseiKensakuBack(DvKogakuServiceJuryoIninDiv div) {
        RString state1 = ResponseHolder.getState();
        if (追加.equals(state1)) {
            if ((!ResponseHolder.isReRequest()) && getHandler(div).onClick_btnShuseiBack(state1)) {
                return ResponseData.of(div).addMessage(new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate())).respond();
            }
            if (MessageDialogSelectedResult.No == ResponseHolder.getButtonType()) {
                return ResponseData.of(div).respond();
            }
        }
        RealInitialLocker.release(new LockingKey(div.getDvKyotsuJoho().getCddShikakuKihon().get被保険者番号()));
        return ResponseData.of(div).forwardWithEventName(DBC0330011TransitionEventName.対象検索へ戻る).respond();
    }

    /**
     * 「保存する」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onClick_btnSave(DvKogakuServiceJuryoIninDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate修正追加();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        KogakuJuryoininKeiyakuJigyoshaHolder holder = ViewStateHolder.get(
                ViewStateHolderName.高額受領委任契約事業者, KogakuJuryoininKeiyakuJigyoshaHolder.class);
        getHandler(div).onClick_btnSave(holder);
        LockingKey 前排他ロックキー = new LockingKey(div.getDvKyotsuJoho().getCddShikakuKihon().get被保険者番号());
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).setState(DBC0330011StateName.発行);
    }

    /**
     * 「保存する」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onClick_btnShuseiSave(DvKogakuServiceJuryoIninDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate修正追加();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (修正.equals(div.getOperateState()) && (!ResponseHolder.isReRequest()) && getHandler(div).onClick_btnSaveBefore()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }

        KogakuJuryoininKeiyakuJigyoshaHolder holder = ViewStateHolder.get(
                ViewStateHolderName.高額受領委任契約事業者, KogakuJuryoininKeiyakuJigyoshaHolder.class);
        getHandler(div).onClick_btnSave(holder);
        LockingKey 前排他ロックキー = new LockingKey(div.getDvKyotsuJoho().getCddShikakuKihon().get被保険者番号());
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).setState(DBC0330011StateName.発行);
    }

    /**
     * 「発行する」ボタン入力のチェックを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onClick_btnHakkoBefore(DvKogakuServiceJuryoIninDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate発行();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnHakko(DvKogakuServiceJuryoIninDiv div) {
        KogakuJuryoininKeiyakuJigyoshaManager manager = new KogakuJuryoininKeiyakuJigyoshaManager();
        KogakuJuryoininKeiyakuJigyosha business
                = manager.get高額受領委任契約事業者(new HihokenshaNo(div.getCddShikakuKihon().get被保険者番号().toString()),
                        Integer.parseInt(div.getDvHaraiKetteiShusei().getTxtRirekiNo().getValue().toString()));
        List<KogakuJuryoininKeiyakuJigyosha> businessList = new ArrayList<>();
        businessList.add(business);
        if (!businessList.isEmpty()) {
            ViewStateHolder.put(ViewStateHolderName.高額受領委任契約事業者, new KogakuJuryoininKeiyakuJigyoshaHolder(businessList));
        }
        KogakuJuryoininKeiyakuJigyoshaHolder holder = ViewStateHolder.get(
                ViewStateHolderName.高額受領委任契約事業者, KogakuJuryoininKeiyakuJigyoshaHolder.class);
        KogakuServiceHiJuryoininKeiyakuKakuninshoResult result = getHandler(div).onClick_btnHakko(holder);
        KogakuServiceJyuryoKakuninShoPrintService printService = new KogakuServiceJyuryoKakuninShoPrintService();
        return ResponseData.of(printService.print(result)).respond();
    }

    /**
     * 「発行する」ボタンを押下後に画面を処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<DvKogakuServiceJuryoIninDiv> onClick_btnHakkoAfter(DvKogakuServiceJuryoIninDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0330011TransitionEventName.完了).respond();
    }
}

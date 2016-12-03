/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeInformationMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJohoHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div　一次判定結果情報　のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBE-3000-220 huangh
 */
public class IchijiHanteiKekkaJoho {

    private static final int RESULT_NUM = 8;
    private static final int DIVISION_NUM = 10;

    /**
     * 共通子DIVを初期化します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDiv> onLoad(IchijiHanteiKekkaJohoDiv div) {

        IchijiHanteiKekkaJohoHandler handler = getHandler(div);
        ShinseishoKanriNo shinseishoKanriNo = handler.get申請書管理番号();
        ModeType modeType = handler.getモード();

        if (shinseishoKanriNo == null || shinseishoKanriNo.isEmpty()) {
            handler.setStateOfIchijiHanteiKekka(ModeType.SHOKAI_MODE);
            throw new ApplicationException(UrErrorMessages.設定不可.getMessage().replace("申請書管理番号が受け取れなかった"));
        }

        if (!RString.isNullOrEmpty(div.getIchijiHanteiKekka())) {
            jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho hanteiKekka
                    = DataPassingConverter.deserialize(div.getIchijiHanteiKekka(),
                            jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho.class);
            handler.initialize(hanteiKekka, modeType);
        } else {
            handler.initialize(shinseishoKanriNo, modeType);
        }

        if (ModeType.ADD_MODE.equals(modeType)) {
            handler.create一次判定引数(shinseishoKanriNo);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 戻る　ボタン押下します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDiv> onClick_btnBack(IchijiHanteiKekkaJohoDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 確定　ボタン押下します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDiv> onClick_btnKakutei(IchijiHanteiKekkaJohoDiv div) {

        if (!ResponseHolder.isReRequest()) {
            if (!RString.isNullOrEmpty(div.getIchijiHanteiKekka())) {
            } else {
                return ResponseData.of(div).addMessage(DbeErrorMessages.一次判定未処理.getMessage()).respond();
            }

            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確定の確認.getMessage().getCode(),
                    UrQuestionMessages.確定の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho hanteiKekka
                    = DataPassingConverter.deserialize(div.getIchijiHanteiKekka(),
                            jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho.class);

            ShinseishoKanriNo shinseishoKanriNo = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class
            );
            ModeType modeType = ViewStateHolder.get(ViewStateKeys.モード, ModeType.class);

            if (ModeType.SHOKAI_MODE.equals(modeType)) {
                RString 一次判定結果 = div.getTxtIchijiHanteiKekka().getValue();
                ViewStateHolder.put(ViewStateKeys.一次判定結果, 一次判定結果);
            } else if (ModeType.ADD_MODE.equals(modeType)) {
                set一次判定結果情報(hanteiKekka, div);
            }

            return ResponseData.of(div)
                    .dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    private void set一次判定結果情報(jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho hanteiKekka,
            IchijiHanteiKekkaJohoDiv div) {
        jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho result
                = getHandler(div).呼び出し元画面への戻り値(hanteiKekka);
        if (result != null) {
            div.setIchijiHanteiKekka(DataPassingConverter.serialize(result));
            ViewStateHolder.put(ViewStateKeys.一次判定結果情報, result);
        }

    }

    private IchijiHanteiKekkaJohoHandler getHandler(IchijiHanteiKekkaJohoDiv div) {
        return new IchijiHanteiKekkaJohoHandler(div);
    }

    /**
     * 一次判定ボタンをクリックした場合の処理を実行します。
     *
     * @param div IchijiHanteiKekkaJohoDiv
     * @return ResponseData<IchijiHanteiKekkaJohoDiv>
     */
    public ResponseData<IchijiHanteiKekkaJohoDiv> btnAfterIchijiHantei(IchijiHanteiKekkaJohoDiv div) {

        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }

        RString result = div.getHanteiResult();
        if (RString.isNullOrEmpty(result)) {
            return ResponseData.of(div).addMessage(DbeErrorMessages.一次判定失敗.getMessage()).respond();
        }

        List<RString> resultList = result.split(",");
        if (resultList.size() != RESULT_NUM) {
            return ResponseData.of(div).addMessage(DbeErrorMessages.一次判定失敗.getMessage()).respond();
        }

        IchijiHanteiKekkaJohoHandler handler = getHandler(div);
        ShinseishoKanriNo shinseishoKanriNo = handler.get申請書管理番号();

        //TODO 戻り値を元に一次判定結果クラスを作る
        jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho hanteiKekka
                = new jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho(shinseishoKanriNo);
        IchijiHanteiKekkaJohoBuilder builder = hanteiKekka.createBuilderForEdit();

        RString ichijiHanteiKekkaCode = resultList.get(0);
        RString tumitashiKekkaCode = resultList.get(1);

        builder.set要介護認定一次判定年月日(FlexibleDate.getNowDate());
        builder.set要介護認定一次判定結果コード(new Code(ichijiHanteiKekkaCode));
        builder.set要介護認定一次判定結果コード_認知症加算(new Code(tumitashiKekkaCode));

        RString kijunJikan = resultList.get(2);
        List<RString> kijunJikanSplit = kijunJikan.split("-");
        builder.set要介護認定等基準時間(rStringToIntAndDivide10(kijunJikanSplit.get(0)));
        builder.set要介護認定等基準時間_食事(rStringToIntAndDivide10(kijunJikanSplit.get(1)));
        builder.set要介護認定等基準時間_排泄(rStringToIntAndDivide10(kijunJikanSplit.get(2)));
        builder.set要介護認定等基準時間_移動(rStringToIntAndDivide10(kijunJikanSplit.get(3)));
        builder.set要介護認定等基準時間_清潔保持(rStringToIntAndDivide10(kijunJikanSplit.get(4)));
        builder.set要介護認定等基準時間_間接ケア(rStringToIntAndDivide10(kijunJikanSplit.get(5)));
        builder.set要介護認定等基準時間_BPSD関連(rStringToIntAndDivide10(kijunJikanSplit.get(6)));
        builder.set要介護認定等基準時間_機能訓練(rStringToIntAndDivide10(kijunJikanSplit.get(7)));
        builder.set要介護認定等基準時間_医療関連(rStringToIntAndDivide10(kijunJikanSplit.get(8)));
        builder.set要介護認定等基準時間_認知症加算(rStringToIntAndDivide10(kijunJikanSplit.get(9)));

        RString hyokaJikan = resultList.get(3);
        List<RString> hyokaJikanSplit = hyokaJikan.split("-");
        builder.set中間評価項目得点第1群(rStringToIntAndDivide10(hyokaJikanSplit.get(0)));
        builder.set中間評価項目得点第2群(rStringToIntAndDivide10(hyokaJikanSplit.get(1)));
        builder.set中間評価項目得点第3群(rStringToIntAndDivide10(hyokaJikanSplit.get(2)));
        builder.set中間評価項目得点第4群(rStringToIntAndDivide10(hyokaJikanSplit.get(3)));
        builder.set中間評価項目得点第5群(rStringToIntAndDivide10(hyokaJikanSplit.get(4)));
        builder.set中間評価項目得点第6群(0);
        builder.set中間評価項目得点第7群(0);

        RString keikokuCode = resultList.get(4);
        builder.set要介護認定一次判定警告コード(keikokuCode);

        RString gaizenseiP = resultList.get(5);
        builder.set認知症自立度Ⅱ以上の蓋然性(rStringToDecimalAndDivide10(gaizenseiP));

        RString anteisei = resultList.get(6);
        builder.set要介護認定状態の安定性コード(new Code(anteisei));

        RString kyufuKubun = resultList.get(7);
        builder.set認知機能及び状態安定性から推定される給付区分コード(new Code(kyufuKubun));

        div.setIchijiHanteiKekka(DataPassingConverter.serialize(builder.build()));
        handler.setIchijiHanteiKekka(builder.build());
        return ResponseData.of(div).addMessage(DbeInformationMessages.一次判定処理完了.getMessage()).respond();
    }

    private int rStringToIntAndDivide10(RString str) {
        int i = Integer.parseInt(str.toString());
        return i / DIVISION_NUM;
    }

    private Decimal rStringToDecimalAndDivide10(RString str) {
        Decimal d = new Decimal(str.toString());
        if (d.equals(new Decimal(-1))) {
            return d;
        }
        return d.divide(DIVISION_NUM);
    }

}

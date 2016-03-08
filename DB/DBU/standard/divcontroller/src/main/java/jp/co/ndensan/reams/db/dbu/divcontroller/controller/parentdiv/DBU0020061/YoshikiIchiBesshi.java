/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020061;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.JigyoHokokuTokeiData;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoDetalSearchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061.DBU0020061TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061.YoshikiIchiBesshiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0020061.YoshikiIchiBesshiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.service.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 事業報告（月報）補正発行_様式１(別紙)のクラス
 */
public class YoshikiIchiBesshi {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * 画面ロードメソッド
     *
     * @param div YoshikiIchiBesshiDiv
     * @return ResponseData<YoshikiIchiBesshiDiv>
     */
    public ResponseData<YoshikiIchiBesshiDiv> onLoad(YoshikiIchiBesshiDiv div) {
        YoshikiIchiBesshiHandler handler = getHandler(div);
        // TODO 引き継ぎデータの取得
        JigyoHokokuGeppoParameter par = new JigyoHokokuGeppoParameter();
        par.set報告年月(new RString("201503"));
        par.set集計年月(new RString("201504"));
        par.set保険者コード(new RString("0010"));
        par.set市町村名称(new RString("張三"));
        ViewStateHolder.put(ViewStateKeys.被保険者, par);
        JigyoHokokuGeppoParameter 引き継ぎデータ = ViewStateHolder.get(ViewStateKeys.被保険者,
                JigyoHokokuGeppoParameter.class);
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        handler.setViewState(引き継ぎデータ, 状態);
        List<JigyoHokokuTokeiData> 更新前データリスト = handler.get更新前データリスト();
        handler.更新前データリスト初期化(更新前データリスト);

        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタンークをリックして時実行するメソッド
     *
     * @param div YoshikiIchiBesshiDiv
     * @return ResponseData<YoshikiIchiBesshiDiv>
     */
    public ResponseData<YoshikiIchiBesshiDiv> onClick_btnSave(YoshikiIchiBesshiDiv div) {
        YoshikiIchiBesshiHandler handler = getHandler(div);
        JigyoHokokuGeppoDetalSearchParameter par = JigyoHokokuGeppoDetalSearchParameter
                .createParameterForJigyoHokokuGeppoDetal(
                        new FlexibleYear("2015"),
                        new RString("06"),
                        new FlexibleYear("2015"),
                        new RString("06"),
                        new RString("3"),
                        new LasdecCode("209008"),
                        new Code("03"),
                        new Code("0100"));
        List<JigyoHokokuTokeiData> 修正データリスト = handler.get修正データリスト();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            JigyoHokokuGeppoHoseiHako.createInstance().deleteJigyoHokokuGeppoData(par);
            InformationMessage message = new InformationMessage(
                    UrInformationMessages.正常終了.getMessage().getCode(),
                    UrInformationMessages.正常終了.getMessage().replace("削除").evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (修正データリスト.isEmpty() && !ResponseHolder.isReRequest()) {
                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            }
            if (handler.is世帯数整合性チェックNG()) {
                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrWarningMessages.相違.getMessage().getCode(),
                            UrWarningMessages.相違.getMessage().replace(
                                    "当月末現在の世帯数", "前月末世帯数から増減した世帯数の計算結果").evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrWarningMessages.相違.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
            } else if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                        UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                JigyoHokokuGeppoHoseiHako.createInstance().updateJigyoHokokuGeppoData(
                        修正データリスト);
                InformationMessage message = new InformationMessage(
                        UrInformationMessages.正常終了.getMessage().getCode(),
                        UrInformationMessages.正常終了.getMessage().replace("更新").evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(UrInformationMessages.正常終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBU0020061TransitionEventName.処理完了).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタンークをリックして時実行するメソッド
     *
     * @param div YoshikiIchiBesshiDiv
     * @return ResponseData<YoshikiIchiBesshiDiv>
     */
    public ResponseData<YoshikiIchiBesshiDiv> onClick_btnBack(YoshikiIchiBesshiDiv div) {
        YoshikiIchiBesshiHandler handler = getHandler(div);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(
                    DBU0020061TransitionEventName.補正発行検索に戻る).respond();
        }
        List<JigyoHokokuTokeiData> 修正データリスト = handler.get修正データリスト();
        if (修正データリスト.isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(
                    DBU0020061TransitionEventName.補正発行検索に戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(
                    DBU0020061TransitionEventName.補正発行検索に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private YoshikiIchiBesshiHandler getHandler(YoshikiIchiBesshiDiv div) {
        return YoshikiIchiBesshiHandler.of(div);
    }

}

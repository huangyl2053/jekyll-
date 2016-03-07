/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiChosaIkkatsuInput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosaikkatsuinput.ChkJikanwakuModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosaikkatsuinput.NinteiChosaIkkatsuInputModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteichosaikkatsuinput.NinteiChosaIkkatsuInputHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteichosaikkatsuinput.NinteiChosaIkkatsuInputValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div 「NinteiChosaIkkatsuInput」のイベントを定義したDivControllerです。
 */
public class NinteiChosaIkkatsuInput {

    private static final Code 時間枠_1 = new Code("1");
    private static final Code 時間枠_2 = new Code("2");
    private static final Code 時間枠_3 = new Code("3");
    private static final Code 時間枠_4 = new Code("4");
    private static final Code 時間枠_5 = new Code("5");
    private static final Code 時間枠_6 = new Code("6");
    private static final Code 時間枠_7 = new Code("7");
    private static final Code 時間枠_8 = new Code("8");
    private static final Code 時間枠_9 = new Code("9");
    private static final Code 時間枠_10 = new Code("10");
    private static final RString 日付_0 = new RString("0");
    private static final RString COLON = new RString(":");
    private static final int 認定調査予定年月日_10 = 10;
    private RString 認定調査予定開始時間;
    private RString 認定調査予定終了時間;
    private Code 認定調査時間枠;

    /**
     * 共通子DIVを初期化します。
     *
     * @param div NinteiChosaIkkatsuInputDiv
     * @return ResponseData<NinteiChosaIkkatsuInputDiv>
     */
    public ResponseData<NinteiChosaIkkatsuInputDiv> onLoad(NinteiChosaIkkatsuInputDiv div) {
        div.setChkJikanwakuModel(DataPassingConverter.serialize(getHandler(div).initialize()));
        return ResponseData.of(div).respond();
    }

    /**
     * 「確認」ボタン押下の処理です。
     *
     * @param div NinteiChosaIkkatsuInputDiv
     * @return ResponseData<NinteiChosaIkkatsuInputDiv>
     */
    public ResponseData<NinteiChosaIkkatsuInputDiv> onClick_btnKaKuNin(NinteiChosaIkkatsuInputDiv div) {
        ValidationMessageControlPairs validationMessage = getValidationHandler(div).validateForAction();
        if (validationMessage.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessage).respond();
        }
        if (編集質問(div)) {
            hozon(div);
        } else {
            確定の確認(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタン押下の処理です。
     *
     * @param div NinteiChosaIkkatsuInputDiv
     * @return ResponseData<NinteiChosaIkkatsuInputDiv>
     */
    public ResponseData<NinteiChosaIkkatsuInputDiv> onClick_btnMoDoRu(NinteiChosaIkkatsuInputDiv div) {
        if (編集質問(div)) {
            画面遷移の確認(div);
        }
        return ResponseData.of(div).respond();
    }

    private boolean 編集質問(NinteiChosaIkkatsuInputDiv div) {
        ChkJikanwakuModel model = DataPassingConverter.deserialize(div.getChkJikanwakuModel(), ChkJikanwakuModel.class);
        if (model.is時間枠1() && div.getTblJikanwaku1().getChkJikanwaku1().getSelectedKeys().isEmpty()) {
            return true;
        }
        if (model.is時間枠2() && div.getTblJikanwaku1().getChkJikanwaku2().getSelectedKeys().isEmpty()) {
            return true;
        }
        if (model.is時間枠3() && div.getTblJikanwaku1().getChkJikanwaku3().getSelectedKeys().isEmpty()) {
            return true;
        }
        if (model.is時間枠4() && div.getTblJikanwaku1().getChkJikanwaku4().getSelectedKeys().isEmpty()) {
            return true;
        }
        if (model.is時間枠5() && div.getTblJikanwaku1().getChkJikanwaku5().getSelectedKeys().isEmpty()) {
            return true;
        }
        編集質問2(div, model);
        return false;
    }

    private boolean 編集質問2(NinteiChosaIkkatsuInputDiv div, ChkJikanwakuModel model) {
        if (model.is時間枠6() && div.getTblJikanwaku2().getChkJikanwaku6().getSelectedKeys().isEmpty()) {
            return true;
        }
        if (model.is時間枠7() && div.getTblJikanwaku2().getChkJikanwaku7().getSelectedKeys().isEmpty()) {
            return true;
        }
        if (model.is時間枠8() && div.getTblJikanwaku2().getChkJikanwaku8().getSelectedKeys().isEmpty()) {
            return true;
        }
        if (model.is時間枠9() && div.getTblJikanwaku2().getChkJikanwaku9().getSelectedKeys().isEmpty()) {
            return true;
        }
        return model.is時間枠10() && div.getTblJikanwaku2().getChkJikanwaku10().getSelectedKeys().isEmpty();
    }

    private ResponseData<NinteiChosaIkkatsuInputDiv> 確定の確認(NinteiChosaIkkatsuInputDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確定の確認.getMessage().getCode(),
                    UrQuestionMessages.確定の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<NinteiChosaIkkatsuInputDiv> 画面遷移の確認(NinteiChosaIkkatsuInputDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void hozon(NinteiChosaIkkatsuInputDiv div) {
        List<NinteichosaSchedule> list = get情報list(div);
        div.setNinteiChosaIkkatsuInputModel(DataPassingConverter.serialize(getModel(div, list)));

    }

    private List<NinteichosaSchedule> get情報list(NinteiChosaIkkatsuInputDiv div) {
        List<NinteichosaSchedule> list = new ArrayList<>();
        list = get時間枠1(div, list);
        list = get時間枠2(div, list);
        list = get時間枠3(div, list);
        list = get時間枠4(div, list);
        list = get時間枠5(div, list);
        list = get時間枠6(div, list);
        list = get時間枠7(div, list);
        list = get時間枠8(div, list);
        list = get時間枠9(div, list);
        list = get時間枠10(div, list);
        return list;
    }

    private List<NinteichosaSchedule> get時間枠1(NinteiChosaIkkatsuInputDiv div, List<NinteichosaSchedule> list) {
        if (!div.getTblJikanwaku1().getChkJikanwaku1().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_1;
            認定調査予定開始時間 = div.getTblJikanwaku1().getTxtStartTime1().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm);
            認定調査予定終了時間 = div.getTblJikanwaku1().getTxtEndTime1().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm);
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠1 = get認定調査スケジュール情報(div, 開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠1);
        }
        return list;
    }

    private List<NinteichosaSchedule> get時間枠2(NinteiChosaIkkatsuInputDiv div, List<NinteichosaSchedule> list) {
        if (!div.getTblJikanwaku1().getChkJikanwaku2().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_2;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku1().getTxtStartTime2().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku1().getTxtEndTime2().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠2 = get認定調査スケジュール情報(div, 開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠2);
        }
        return list;
    }

    private List<NinteichosaSchedule> get時間枠3(NinteiChosaIkkatsuInputDiv div, List<NinteichosaSchedule> list) {
        if (!div.getTblJikanwaku1().getChkJikanwaku3().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_3;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku1().getTxtStartTime3().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku1().getTxtEndTime3().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠3 = get認定調査スケジュール情報(div, 開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠3);
        }
        return list;
    }

    private List<NinteichosaSchedule> get時間枠4(NinteiChosaIkkatsuInputDiv div, List<NinteichosaSchedule> list) {
        if (!div.getTblJikanwaku1().getChkJikanwaku4().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_4;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku1().getTxtStartTime4().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku1().getTxtEndTime4().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠4 = get認定調査スケジュール情報(div, 開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠4);
        }
        return list;
    }

    private List<NinteichosaSchedule> get時間枠5(NinteiChosaIkkatsuInputDiv div, List<NinteichosaSchedule> list) {
        if (!div.getTblJikanwaku1().getChkJikanwaku5().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_5;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku1().getTxtStartTime5().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku1().getTxtEndTime5().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠5 = get認定調査スケジュール情報(div, 開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠5);
        }
        return list;
    }

    private List<NinteichosaSchedule> get時間枠6(NinteiChosaIkkatsuInputDiv div, List<NinteichosaSchedule> list) {
        if (!div.getTblJikanwaku2().getChkJikanwaku6().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_6;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime6().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime6().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠6 = get認定調査スケジュール情報(div, 開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠6);
        }
        return list;
    }

    private List<NinteichosaSchedule> get時間枠7(NinteiChosaIkkatsuInputDiv div, List<NinteichosaSchedule> list) {
        if (!div.getTblJikanwaku2().getChkJikanwaku7().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_7;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime7().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime7().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠7 = get認定調査スケジュール情報(div, 開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠7);
        }
        return list;
    }

    private List<NinteichosaSchedule> get時間枠8(NinteiChosaIkkatsuInputDiv div, List<NinteichosaSchedule> list) {
        if (!div.getTblJikanwaku2().getChkJikanwaku8().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_8;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime8().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime8().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠8 = get認定調査スケジュール情報(div, 開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠8);
        }
        return list;
    }

    private List<NinteichosaSchedule> get時間枠9(NinteiChosaIkkatsuInputDiv div, List<NinteichosaSchedule> list) {
        if (!div.getTblJikanwaku2().getChkJikanwaku9().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_9;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime9().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime9().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠9 = get認定調査スケジュール情報(div, 開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠9);
        }
        return list;
    }

    private List<NinteichosaSchedule> get時間枠10(NinteiChosaIkkatsuInputDiv div, List<NinteichosaSchedule> list) {
        if (!div.getTblJikanwaku2().getChkJikanwaku10().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_10;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime10().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime10().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠10 = get認定調査スケジュール情報(div, 開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠10);
        }
        return list;
    }

    private RString get開始時間(RString 認定調査予定開始時間) {
        RString 開始時 = 認定調査予定開始時間.split(COLON.toString()).get(0);
        RString 開始分 = 認定調査予定開始時間.split(COLON.toString()).get(1);
        StringBuilder 開始時間 = new StringBuilder("");
        開始時間.append(開始時);
        開始時間.append(開始分);
        return new RString(開始時間.toString());
    }

    private RString get終了時間(RString 認定調査予定終了時間) {
        RString 終了時 = 認定調査予定終了時間.split(COLON.toString()).get(0);
        RString 終了分 = 認定調査予定終了時間.split(COLON.toString()).get(1);
        StringBuilder 終了時間 = new StringBuilder("");
        終了時間.append(終了時);
        終了時間.append(終了分);
        return new RString(終了時間.toString());
    }

    private NinteiChosaIkkatsuInputModel getModel(NinteiChosaIkkatsuInputDiv div, List<NinteichosaSchedule> list) {
        NinteiChosaIkkatsuInputModel model = new NinteiChosaIkkatsuInputModel();
        List<NinteiChosaIkkatsuInputModel> modellist = new ArrayList<>();
        FlexibleDate 認定調査予定年月日 = new FlexibleDate("");
        for (int i = 1; i <= list.get(0).get認定調査予定年月日().getYearMonth().getLastDay(); i++) {
            if (i < 認定調査予定年月日_10) {
                StringBuilder a = new StringBuilder("");
                a.append(認定調査予定年月日.toString());
                a.append(日付_0.toString());
                a.append(String.valueOf(i));
                認定調査予定年月日 = new FlexibleDate(new RString(a.toString()));
            } else {
                StringBuilder b = new StringBuilder("");
                b.append(認定調査予定年月日.toString());
                b.append(String.valueOf(i));
                認定調査予定年月日 = new FlexibleDate(new RString(b.toString()));
            }
            for (RString 曜日 : div.getChkDay().getSelectedValues()) {
                if (new RString(認定調査予定年月日.getDayOfWeek().getShortTerm()).equals(曜日)) {
                    for (NinteichosaSchedule nintei : list) {
                        model.set認定調査予定年月日(認定調査予定年月日);
                        model.set曜日(曜日);
                        model.set認定調査予定開始時間(nintei.get認定調査予定開始時間());
                        model.set認定調査予定終了時間(nintei.get認定調査予定終了時間());
                        if (div.getChkDay().getDataSource().isEmpty()) {
                            model.set既に設定済みの場合上書きするフラグ(false);
                        }
                        model.set既に設定済みの場合上書きするフラグ(true);
                        modellist.add(model);
                    }
                }
            }
        }
        model.setModelList(modellist);
        return model;
    }

    private NinteichosaSchedule get認定調査スケジュール情報(NinteiChosaIkkatsuInputDiv div, RString 認定調査予定開始時間, RString 認定調査予定終了時間, Code 認定調査時間枠) {
        NinteiChosaIkkatsuInputModel model = DataPassingConverter.deserialize(div.getNinteiChosaIkkatsuInputModel(), NinteiChosaIkkatsuInputModel.class);
        NinteichosaSchedule 時間枠 = new NinteichosaSchedule(model.get設定年月(),
                認定調査予定開始時間,
                認定調査予定終了時間,
                認定調査時間枠,
                Code.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                LasdecCode.EMPTY);
        return 時間枠;
    }

    private NinteiChosaIkkatsuInputHandler getHandler(NinteiChosaIkkatsuInputDiv div) {
        return new NinteiChosaIkkatsuInputHandler(div);
    }

    private NinteiChosaIkkatsuInputValidationHandler getValidationHandler(NinteiChosaIkkatsuInputDiv div) {
        return new NinteiChosaIkkatsuInputValidationHandler(div);
    }
}

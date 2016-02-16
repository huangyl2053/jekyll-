/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiChosaIkkatsuInput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaScheduleBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInputHandler;
import jp.co.ndensan.reams.db.dbz.service.core.ninteiChosaIkkatsu.NinteiChosaIkkatsuInputManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
    private static final Code 予約状況 = new Code("0");

    /**
     * 共通子DIVを初期化します。
     *
     * @param div NinteiChosaIkkatsuInputDiv
     * @return ResponseData<NinteiChosaIkkatsuInputDiv>
     */
    public ResponseData<NinteiChosaIkkatsuInputDiv> onLoad(NinteiChosaIkkatsuInputDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「確認」ボタン押下の処理です。
     *
     * @param div
     * @return ResponseData<NinteiChosaIkkatsuInputDiv>
     */
    public ResponseData<NinteiChosaIkkatsuInputDiv> onClick_btnKaKuNin(NinteiChosaIkkatsuInputDiv div) {
        ValidationMessageControlPairs validationMessage = getHandler(div).validateForAction();
        if (validationMessage.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessage).respond();
        }
        hozon(div);
        return ResponseData.of(div).respond();
    }

    private void hozon(NinteiChosaIkkatsuInputDiv div) {
        List<NinteichosaSchedule> 認定調査スケジュール情報 = get情報list(div);
        NinteiChosaIkkatsuInputManager.createInstance().get認定調査スケジュール情報(div.getChkUpdate().getSelectedItems().isEmpty(), div.getChkDay().getSelectedValues(), 認定調査スケジュール情報);
    }

    private List<NinteichosaSchedule> get情報list(NinteiChosaIkkatsuInputDiv div) {
        RString 認定調査予定開始時間;
        RString 認定調査予定終了時間;
        Code 認定調査時間枠;
        List<NinteichosaSchedule> list = new ArrayList<>();
        if (!div.getTblJikanwaku1().getChkJikanwaku1().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_1;
            認定調査予定開始時間 = div.getTblJikanwaku1().getTxtStartTime1().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm);
            認定調査予定終了時間 = div.getTblJikanwaku1().getTxtEndTime1().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm);
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠1 = get認定調査スケジュール情報(開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠1);
        }
        if (!div.getTblJikanwaku1().getChkJikanwaku2().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_2;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku1().getTxtStartTime2().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku1().getTxtEndTime2().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠2 = get認定調査スケジュール情報(開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠2);
        }
        if (!div.getTblJikanwaku1().getChkJikanwaku3().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_3;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku1().getTxtStartTime3().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku1().getTxtEndTime3().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠3 = get認定調査スケジュール情報(開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠3);
        }
        if (!div.getTblJikanwaku1().getChkJikanwaku4().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_4;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku1().getTxtStartTime4().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku1().getTxtEndTime4().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠4 = get認定調査スケジュール情報(開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠4);
        }
        if (!div.getTblJikanwaku1().getChkJikanwaku5().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_5;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku1().getTxtStartTime5().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku1().getTxtEndTime5().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠5 = get認定調査スケジュール情報(開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠5);
        }
        if (!div.getTblJikanwaku2().getChkJikanwaku6().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_6;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime6().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime6().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠6 = get認定調査スケジュール情報(開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠6);
        }
        if (!div.getTblJikanwaku2().getChkJikanwaku7().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_7;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime7().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime7().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠7 = get認定調査スケジュール情報(開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠7);
        }
        if (!div.getTblJikanwaku2().getChkJikanwaku8().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_8;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime8().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime8().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠8 = get認定調査スケジュール情報(開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠8);
        }
        if (!div.getTblJikanwaku2().getChkJikanwaku9().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_9;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime9().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime9().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠9 = get認定調査スケジュール情報(開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠9);
        }
        if (!div.getTblJikanwaku2().getChkJikanwaku10().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_10;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime10().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime10().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時間 = get開始時間(認定調査予定開始時間);
            RString 終了時間 = get終了時間(認定調査予定終了時間);
            NinteichosaSchedule 時間枠10 = get認定調査スケジュール情報(開始時間, 終了時間, 認定調査時間枠);
            list.add(時間枠10);
        }
        return list;
    }

    private RString get開始時間(RString 認定調査予定開始時間) {
        RString 開始時 = 認定調査予定開始時間.split(":").get(0);
        RString 開始分 = 認定調査予定開始時間.split(":").get(1);
        StringBuilder 開始時間 = new StringBuilder("");
        開始時間.append(開始時);
        開始時間.append(開始分);
        return new RString(開始時間.toString());
    }

    private RString get終了時間(RString 認定調査予定終了時間) {
        RString 終了時 = 認定調査予定終了時間.split(":").get(0);
        RString 終了分 = 認定調査予定終了時間.split(":").get(1);
        StringBuilder 終了時間 = new StringBuilder("");
        終了時間.append(終了時);
        終了時間.append(終了分);
        return new RString(終了時間.toString());
    }

    private NinteichosaSchedule get認定調査スケジュール情報(RString 認定調査予定開始時間, RString 認定調査予定終了時間, Code 認定調査時間枠) {
        FlexibleDate 設定年月 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録11_設定年月, FlexibleDate.class);
        Code 調査地区コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録11_調査地区コード, Code.class);
        RString 認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録11_認定調査委託先コード, RString.class);
        RString 認定調査員コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録11_認定調査員コード, RString.class);
        LasdecCode 市町村コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録11_市町村コード, LasdecCode.class);
        NinteichosaSchedule 時間枠 = new NinteichosaSchedule(設定年月,
                認定調査予定開始時間,
                認定調査予定終了時間,
                認定調査時間枠,
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード);
        NinteichosaScheduleBuilder builder = 時間枠.createBuilderForEdit();
        builder.set予約状況(予約状況);
        builder.set予約可能フラグ(true);
        時間枠 = builder.build();
        return 時間枠;
    }

    private NinteiChosaIkkatsuInputHandler getHandler(NinteiChosaIkkatsuInputDiv div) {
        return new NinteiChosaIkkatsuInputHandler(div);
    }
}

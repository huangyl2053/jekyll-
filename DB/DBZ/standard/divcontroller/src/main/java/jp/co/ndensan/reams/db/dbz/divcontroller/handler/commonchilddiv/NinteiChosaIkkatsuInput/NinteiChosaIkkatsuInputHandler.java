/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.NinteiChosaIkkatsuInput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaScheduleBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInputDiv;
import jp.co.ndensan.reams.db.dbz.service.core.ninteiChosaIkkatsu.NinteiChosaIkkatsuInputManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 共有子Div 「NinteiChosaIkkatsuInput」のhandlerクラスです。
 */
public class NinteiChosaIkkatsuInputHandler {

    private static final RString key0 = new RString("key0");
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
    private final NinteiChosaIkkatsuInputDiv div;

    public NinteiChosaIkkatsuInputHandler(NinteiChosaIkkatsuInputDiv div) {
        this.div = div;
    }

    /**
     * 共通子DIVを初期化します。
     *
     */
    public void initialize() {
        set非活性();
        set時間();
    }

    private void set非活性() {
        div.getTblJikanwaku1().getTxtStartTime1().setDisabled(true);
        div.getTblJikanwaku1().getTxtEndTime1().setDisabled(true);
        div.getTblJikanwaku1().getTxtStartTime2().setDisabled(true);
        div.getTblJikanwaku1().getTxtEndTime2().setDisabled(true);
        div.getTblJikanwaku1().getTxtStartTime3().setDisabled(true);
        div.getTblJikanwaku1().getTxtEndTime3().setDisabled(true);
        div.getTblJikanwaku1().getTxtStartTime4().setDisabled(true);
        div.getTblJikanwaku1().getTxtEndTime4().setDisabled(true);
        div.getTblJikanwaku1().getTxtStartTime5().setDisabled(true);
        div.getTblJikanwaku1().getTxtEndTime5().setDisabled(true);
        div.getTblJikanwaku2().getTxtStartTime6().setDisabled(true);
        div.getTblJikanwaku2().getTxtEndTime6().setDisabled(true);
        div.getTblJikanwaku2().getTxtStartTime7().setDisabled(true);
        div.getTblJikanwaku2().getTxtEndTime7().setDisabled(true);
        div.getTblJikanwaku2().getTxtStartTime8().setDisabled(true);
        div.getTblJikanwaku2().getTxtEndTime8().setDisabled(true);
        div.getTblJikanwaku2().getTxtStartTime9().setDisabled(true);
        div.getTblJikanwaku2().getTxtEndTime9().setDisabled(true);
        div.getTblJikanwaku2().getTxtStartTime10().setDisabled(true);
        div.getTblJikanwaku2().getTxtEndTime10().setDisabled(true);
    }

    private void set時間() {
        List<RString> keylist = new ArrayList<>();
        keylist.add(key0);
        RString 時間枠1 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠1, SubGyomuCode.DBE認定支援);
        if (!時間枠1.isEmpty()) {
            List<RString> start = 時間枠1.split("-").get(0).split(":");
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠1.split("-").get(1).split(":");
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku1().getChkJikanwaku1().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku1().getTxtStartTime1().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku1().getTxtEndTime1().setValue(RTime.of(endhour, endminute));
        }
        RString 時間枠2 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠2, SubGyomuCode.DBE認定支援);
        if (!時間枠2.isEmpty()) {
            List<RString> start = 時間枠2.split("-").get(0).split(":");
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠2.split("-").get(1).split(":");
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku1().getChkJikanwaku2().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku1().getTxtStartTime2().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku1().getTxtEndTime2().setValue(RTime.of(endhour, endminute));
        }
        RString 時間枠3 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠3, SubGyomuCode.DBE認定支援);
        if (!時間枠3.isEmpty()) {
            List<RString> start = 時間枠3.split("-").get(0).split(":");
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠3.split("-").get(1).split(":");
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku1().getChkJikanwaku3().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku1().getTxtStartTime3().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku1().getTxtEndTime3().setValue(RTime.of(endhour, endminute));
        }
        RString 時間枠4 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠4, SubGyomuCode.DBE認定支援);
        if (!時間枠4.isEmpty()) {
            List<RString> start = 時間枠4.split("-").get(0).split(":");
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠4.split("-").get(1).split(":");
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku1().getChkJikanwaku4().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku1().getTxtStartTime4().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku1().getTxtEndTime4().setValue(RTime.of(endhour, endminute));
        }
        RString 時間枠5 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠5, SubGyomuCode.DBE認定支援);
        if (!時間枠5.isEmpty()) {
            List<RString> start = 時間枠5.split("-").get(0).split(":");
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠5.split("-").get(1).split(":");
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku1().getChkJikanwaku5().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku1().getTxtStartTime5().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku1().getTxtEndTime5().setValue(RTime.of(endhour, endminute));
        }
        RString 時間枠6 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠6, SubGyomuCode.DBE認定支援);
        if (!時間枠6.isEmpty()) {
            List<RString> start = 時間枠6.split("-").get(0).split(":");
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠6.split("-").get(1).split(":");
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku2().getChkJikanwaku6().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku2().getTxtStartTime6().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku2().getTxtEndTime6().setValue(RTime.of(endhour, endminute));
        }
        RString 時間枠7 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠7, SubGyomuCode.DBE認定支援);
        if (!時間枠7.isEmpty()) {
            List<RString> start = 時間枠7.split("-").get(0).split(":");
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠7.split("-").get(1).split(":");
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku2().getChkJikanwaku7().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku2().getTxtStartTime7().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku2().getTxtEndTime7().setValue(RTime.of(endhour, endminute));
        }
        RString 時間枠8 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠8, SubGyomuCode.DBE認定支援);
        if (!時間枠8.isEmpty()) {
            List<RString> start = 時間枠8.split("-").get(0).split(":");
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠8.split("-").get(1).split(":");
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku2().getChkJikanwaku8().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku2().getTxtStartTime8().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku2().getTxtEndTime8().setValue(RTime.of(endhour, endminute));
        }
        RString 時間枠9 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠9, SubGyomuCode.DBE認定支援);
        if (!時間枠9.isEmpty()) {
            List<RString> start = 時間枠9.split("-").get(0).split(":");
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠9.split("-").get(1).split(":");
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku2().getChkJikanwaku9().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku2().getTxtStartTime9().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku2().getTxtEndTime9().setValue(RTime.of(endhour, endminute));
        }
        RString 時間枠10 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠10, SubGyomuCode.DBE認定支援);
        if (!時間枠10.isEmpty()) {
            List<RString> start = 時間枠10.split("-").get(0).split(":");
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠10.split("-").get(1).split(":");
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku2().getChkJikanwaku10().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku2().getTxtStartTime10().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku2().getTxtEndTime10().setValue(RTime.of(endhour, endminute));
        }
    }

    /**
     * 「保存」ボタンを処理する。
     *
     * @param chkUpdate chkUpdate
     */
    public void hozon(boolean chkUpdate) {
        List<NinteichosaSchedule> 認定調査スケジュール情報 = get情報list();
        List<RString> 曜日list = new ArrayList<>();
        for (RString 曜日 : div.getChkDay().getSelectedValues()) {
            曜日list.add(曜日);
        }
        NinteiChosaIkkatsuInputManager.createInstance().get認定調査スケジュール情報(chkUpdate, 曜日list, 認定調査スケジュール情報);
    }

    private List<NinteichosaSchedule> get情報list() {
        RString 認定調査予定開始時間;
        RString 認定調査予定終了時間;
        Code 認定調査時間枠;
        List<NinteichosaSchedule> list = new ArrayList<>();
        if (!div.getTblJikanwaku1().getChkJikanwaku1().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_1;
            認定調査予定開始時間 = div.getTblJikanwaku1().getTxtStartTime1().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm);
            認定調査予定終了時間 = div.getTblJikanwaku1().getTxtEndTime1().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm);
            RString 開始時 = 認定調査予定開始時間.split(":").get(0);
            RString 開始分 = 認定調査予定開始時間.split(":").get(1);
            StringBuilder 開始時間 = new StringBuilder("");
            開始時間.append(開始時);
            開始時間.append(開始分);
            RString 終了時 = 認定調査予定終了時間.split(":").get(0);
            RString 終了分 = 認定調査予定終了時間.split(":").get(1);
            StringBuilder 終了時間 = new StringBuilder("");
            終了時間.append(終了時);
            終了時間.append(終了分);
            NinteichosaSchedule 時間枠1 = get認定調査スケジュール情報(new RString(開始時間.toString()), new RString(終了時間.toString()),
                    認定調査時間枠);
            list.add(時間枠1);
        }
        if (!div.getTblJikanwaku1().getChkJikanwaku2().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_2;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku1().getTxtStartTime2().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku1().getTxtEndTime2().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時 = 認定調査予定開始時間.split(":").get(0);
            RString 開始分 = 認定調査予定開始時間.split(":").get(1);
            StringBuilder 開始時間 = new StringBuilder("");
            開始時間.append(開始時);
            開始時間.append(開始分);
            RString 終了時 = 認定調査予定終了時間.split(":").get(0);
            RString 終了分 = 認定調査予定終了時間.split(":").get(1);
            StringBuilder 終了時間 = new StringBuilder("");
            終了時間.append(終了時);
            終了時間.append(終了分);
            NinteichosaSchedule 時間枠2 = get認定調査スケジュール情報(new RString(開始時間.toString()), new RString(終了時間.toString()),
                    認定調査時間枠);
            list.add(時間枠2);
        }
        if (!div.getTblJikanwaku1().getChkJikanwaku3().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_3;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku1().getTxtStartTime3().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku1().getTxtEndTime3().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時 = 認定調査予定開始時間.split(":").get(0);
            RString 開始分 = 認定調査予定開始時間.split(":").get(1);
            StringBuilder 開始時間 = new StringBuilder("");
            開始時間.append(開始時);
            開始時間.append(開始分);
            RString 終了時 = 認定調査予定終了時間.split(":").get(0);
            RString 終了分 = 認定調査予定終了時間.split(":").get(1);
            StringBuilder 終了時間 = new StringBuilder("");
            終了時間.append(終了時);
            終了時間.append(終了分);
            NinteichosaSchedule 時間枠3 = get認定調査スケジュール情報(new RString(開始時間.toString()), new RString(終了時間.toString()),
                    認定調査時間枠);
            list.add(時間枠3);
        }
        if (!div.getTblJikanwaku1().getChkJikanwaku4().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_4;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku1().getTxtStartTime4().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku1().getTxtEndTime4().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時 = 認定調査予定開始時間.split(":").get(0);
            RString 開始分 = 認定調査予定開始時間.split(":").get(1);
            StringBuilder 開始時間 = new StringBuilder("");
            開始時間.append(開始時);
            開始時間.append(開始分);
            RString 終了時 = 認定調査予定終了時間.split(":").get(0);
            RString 終了分 = 認定調査予定終了時間.split(":").get(1);
            StringBuilder 終了時間 = new StringBuilder("");
            終了時間.append(終了時);
            終了時間.append(終了分);
            NinteichosaSchedule 時間枠4 = get認定調査スケジュール情報(new RString(開始時間.toString()), new RString(終了時間.toString()),
                    認定調査時間枠);
            list.add(時間枠4);
        }
        if (!div.getTblJikanwaku1().getChkJikanwaku5().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_5;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku1().getTxtStartTime5().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku1().getTxtEndTime5().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時 = 認定調査予定開始時間.split(":").get(0);
            RString 開始分 = 認定調査予定開始時間.split(":").get(1);
            StringBuilder 開始時間 = new StringBuilder("");
            開始時間.append(開始時);
            開始時間.append(開始分);
            RString 終了時 = 認定調査予定終了時間.split(":").get(0);
            RString 終了分 = 認定調査予定終了時間.split(":").get(1);
            StringBuilder 終了時間 = new StringBuilder("");
            終了時間.append(終了時);
            終了時間.append(終了分);
            NinteichosaSchedule 時間枠5 = get認定調査スケジュール情報(new RString(開始時間.toString()), new RString(終了時間.toString()),
                    認定調査時間枠);
            list.add(時間枠5);
        }
        if (!div.getTblJikanwaku2().getChkJikanwaku6().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_6;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime6().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime6().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時 = 認定調査予定開始時間.split(":").get(0);
            RString 開始分 = 認定調査予定開始時間.split(":").get(1);
            StringBuilder 開始時間 = new StringBuilder("");
            開始時間.append(開始時);
            開始時間.append(開始分);
            RString 終了時 = 認定調査予定終了時間.split(":").get(0);
            RString 終了分 = 認定調査予定終了時間.split(":").get(1);
            StringBuilder 終了時間 = new StringBuilder("");
            終了時間.append(終了時);
            終了時間.append(終了分);
            NinteichosaSchedule 時間枠6 = get認定調査スケジュール情報(new RString(開始時間.toString()), new RString(終了時間.toString()),
                    認定調査時間枠);
            list.add(時間枠6);
        }
        if (!div.getTblJikanwaku2().getChkJikanwaku7().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_7;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime7().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime7().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時 = 認定調査予定開始時間.split(":").get(0);
            RString 開始分 = 認定調査予定開始時間.split(":").get(1);
            StringBuilder 開始時間 = new StringBuilder("");
            開始時間.append(開始時);
            開始時間.append(開始分);
            RString 終了時 = 認定調査予定終了時間.split(":").get(0);
            RString 終了分 = 認定調査予定終了時間.split(":").get(1);
            StringBuilder 終了時間 = new StringBuilder("");
            終了時間.append(終了時);
            終了時間.append(終了分);
            NinteichosaSchedule 時間枠7 = get認定調査スケジュール情報(new RString(開始時間.toString()), new RString(終了時間.toString()),
                    認定調査時間枠);
            list.add(時間枠7);
        }
        if (!div.getTblJikanwaku2().getChkJikanwaku8().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_8;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime8().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime8().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時 = 認定調査予定開始時間.split(":").get(0);
            RString 開始分 = 認定調査予定開始時間.split(":").get(1);
            StringBuilder 開始時間 = new StringBuilder("");
            開始時間.append(開始時);
            開始時間.append(開始分);
            RString 終了時 = 認定調査予定終了時間.split(":").get(0);
            RString 終了分 = 認定調査予定終了時間.split(":").get(1);
            StringBuilder 終了時間 = new StringBuilder("");
            終了時間.append(終了時);
            終了時間.append(終了分);
            NinteichosaSchedule 時間枠8 = get認定調査スケジュール情報(new RString(開始時間.toString()), new RString(終了時間.toString()),
                    認定調査時間枠);
            list.add(時間枠8);
        }
        if (!div.getTblJikanwaku2().getChkJikanwaku9().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_9;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime9().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime9().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時 = 認定調査予定開始時間.split(":").get(0);
            RString 開始分 = 認定調査予定開始時間.split(":").get(1);
            StringBuilder 開始時間 = new StringBuilder("");
            開始時間.append(開始時);
            開始時間.append(開始分);
            RString 終了時 = 認定調査予定終了時間.split(":").get(0);
            RString 終了分 = 認定調査予定終了時間.split(":").get(1);
            StringBuilder 終了時間 = new StringBuilder("");
            終了時間.append(終了時);
            終了時間.append(終了分);
            NinteichosaSchedule 時間枠9 = get認定調査スケジュール情報(new RString(開始時間.toString()), new RString(終了時間.toString()),
                    認定調査時間枠);
            list.add(時間枠9);
        }
        if (!div.getTblJikanwaku2().getChkJikanwaku10().getSelectedKeys().isEmpty()) {
            認定調査時間枠 = 時間枠_10;
            認定調査予定開始時間 = new RString(div.getTblJikanwaku2().getTxtStartTime10().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            認定調査予定終了時間 = new RString(div.getTblJikanwaku2().getTxtEndTime10().getValue().
                    toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
            RString 開始時 = 認定調査予定開始時間.split(":").get(0);
            RString 開始分 = 認定調査予定開始時間.split(":").get(1);
            StringBuilder 開始時間 = new StringBuilder("");
            開始時間.append(開始時);
            開始時間.append(開始分);
            RString 終了時 = 認定調査予定終了時間.split(":").get(0);
            RString 終了分 = 認定調査予定終了時間.split(":").get(1);
            StringBuilder 終了時間 = new StringBuilder("");
            終了時間.append(終了時);
            終了時間.append(終了分);
            NinteichosaSchedule 時間枠10 = get認定調査スケジュール情報(new RString(開始時間.toString()), new RString(終了時間.toString()),
                    認定調査時間枠);
            list.add(時間枠10);
        }
        return list;
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
        builder.set予約状況(new Code("0"));
        builder.set予約可能フラグ(true);
        時間枠 = builder.build();
        return 時間枠;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.NinteiChosaIkkatsuInput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 共有子Div 「NinteiChosaIkkatsuInput」のhandlerクラスです。
 */
public class NinteiChosaIkkatsuInputHandler {

    private static final RString key0 = new RString("key0");
    private static final RString LINE = new RString("-");
    private static final RString COLON = new RString(":");
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
        div.getTblJikanwaku1().getChkJikanwaku1().setDisabled(true);
        div.getTblJikanwaku1().getTxtStartTime1().setDisabled(true);
        div.getTblJikanwaku1().getTxtEndTime1().setDisabled(true);
        div.getTblJikanwaku1().getChkJikanwaku2().setDisabled(true);
        div.getTblJikanwaku1().getTxtStartTime2().setDisabled(true);
        div.getTblJikanwaku1().getTxtEndTime2().setDisabled(true);
        div.getTblJikanwaku1().getChkJikanwaku3().setDisabled(true);
        div.getTblJikanwaku1().getTxtStartTime3().setDisabled(true);
        div.getTblJikanwaku1().getTxtEndTime3().setDisabled(true);
        div.getTblJikanwaku1().getChkJikanwaku4().setDisabled(true);
        div.getTblJikanwaku1().getTxtStartTime4().setDisabled(true);
        div.getTblJikanwaku1().getTxtEndTime4().setDisabled(true);
        div.getTblJikanwaku1().getChkJikanwaku5().setDisabled(true);
        div.getTblJikanwaku1().getTxtStartTime5().setDisabled(true);
        div.getTblJikanwaku1().getTxtEndTime5().setDisabled(true);
        div.getTblJikanwaku2().getChkJikanwaku6().setDisabled(true);
        div.getTblJikanwaku2().getTxtStartTime6().setDisabled(true);
        div.getTblJikanwaku2().getTxtEndTime6().setDisabled(true);
        div.getTblJikanwaku2().getChkJikanwaku7().setDisabled(true);
        div.getTblJikanwaku2().getTxtStartTime7().setDisabled(true);
        div.getTblJikanwaku2().getTxtEndTime7().setDisabled(true);
        div.getTblJikanwaku2().getChkJikanwaku8().setDisabled(true);
        div.getTblJikanwaku2().getTxtStartTime8().setDisabled(true);
        div.getTblJikanwaku2().getTxtEndTime8().setDisabled(true);
        div.getTblJikanwaku2().getChkJikanwaku9().setDisabled(true);
        div.getTblJikanwaku2().getTxtStartTime9().setDisabled(true);
        div.getTblJikanwaku2().getTxtEndTime9().setDisabled(true);
        div.getTblJikanwaku2().getChkJikanwaku10().setDisabled(true);
        div.getTblJikanwaku2().getTxtStartTime10().setDisabled(true);
        div.getTblJikanwaku2().getTxtEndTime10().setDisabled(true);
    }

    private void set時間() {
        List<RString> keylist = new ArrayList<>();
        keylist.add(key0);
        set時間枠1(keylist);
        set時間枠2(keylist);
        set時間枠3(keylist);
        set時間枠4(keylist);
        set時間枠5(keylist);
        set時間枠6(keylist);
        set時間枠7(keylist);
        set時間枠8(keylist);
        set時間枠9(keylist);
        set時間枠10(keylist);
    }

    private void set時間枠1(List<RString> keylist) {
        RString 時間枠1 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠1, SubGyomuCode.DBE認定支援);
        if (時間枠1 != null && !時間枠1.isEmpty()) {
            List<RString> start = 時間枠1.split(LINE.toString()).get(0).split(COLON.toString());
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠1.split(LINE.toString()).get(1).split(COLON.toString());
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku1().getChkJikanwaku1().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku1().getTxtStartTime1().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku1().getTxtEndTime1().setValue(RTime.of(endhour, endminute));
        }
    }

    private void set時間枠2(List<RString> keylist) {
        RString 時間枠2 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠2, SubGyomuCode.DBE認定支援);
        if (時間枠2 != null && !時間枠2.isEmpty()) {
            List<RString> start = 時間枠2.split(LINE.toString()).get(0).split(COLON.toString());
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠2.split(LINE.toString()).get(1).split(COLON.toString());
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku1().getChkJikanwaku2().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku1().getTxtStartTime2().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku1().getTxtEndTime2().setValue(RTime.of(endhour, endminute));
        }
    }

    private void set時間枠3(List<RString> keylist) {
        RString 時間枠3 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠3, SubGyomuCode.DBE認定支援);
        if (時間枠3 != null && !時間枠3.isEmpty()) {
            List<RString> start = 時間枠3.split(LINE.toString()).get(0).split(COLON.toString());
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠3.split(LINE.toString()).get(1).split(COLON.toString());
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku1().getChkJikanwaku3().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku1().getTxtStartTime3().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku1().getTxtEndTime3().setValue(RTime.of(endhour, endminute));
        }
    }

    private void set時間枠4(List<RString> keylist) {
        RString 時間枠4 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠4, SubGyomuCode.DBE認定支援);
        if (時間枠4 != null && !時間枠4.isEmpty()) {
            List<RString> start = 時間枠4.split(LINE.toString()).get(0).split(COLON.toString());
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠4.split(LINE.toString()).get(1).split(COLON.toString());
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku1().getChkJikanwaku4().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku1().getTxtStartTime4().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku1().getTxtEndTime4().setValue(RTime.of(endhour, endminute));
        }
    }

    private void set時間枠5(List<RString> keylist) {
        RString 時間枠5 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠5, SubGyomuCode.DBE認定支援);
        if (時間枠5 != null && !時間枠5.isEmpty()) {
            List<RString> start = 時間枠5.split(LINE.toString()).get(0).split(COLON.toString());
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠5.split(LINE.toString()).get(1).split(COLON.toString());
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku1().getChkJikanwaku5().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku1().getTxtStartTime5().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku1().getTxtEndTime5().setValue(RTime.of(endhour, endminute));
        }
    }

    private void set時間枠6(List<RString> keylist) {
        RString 時間枠6 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠6, SubGyomuCode.DBE認定支援);
        if (時間枠6 != null && !時間枠6.isEmpty()) {
            List<RString> start = 時間枠6.split(LINE.toString()).get(0).split(COLON.toString());
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠6.split(LINE.toString()).get(1).split(COLON.toString());
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku2().getChkJikanwaku6().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku2().getTxtStartTime6().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku2().getTxtEndTime6().setValue(RTime.of(endhour, endminute));
        }
    }

    private void set時間枠7(List<RString> keylist) {
        RString 時間枠7 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠7, SubGyomuCode.DBE認定支援);
        if (時間枠7 != null && !時間枠7.isEmpty()) {
            List<RString> start = 時間枠7.split(LINE.toString()).get(0).split(COLON.toString());
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠7.split(LINE.toString()).get(1).split(COLON.toString());
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku2().getChkJikanwaku7().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku2().getTxtStartTime7().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku2().getTxtEndTime7().setValue(RTime.of(endhour, endminute));
        }
    }

    private void set時間枠8(List<RString> keylist) {
        RString 時間枠8 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠8, SubGyomuCode.DBE認定支援);
        if (時間枠8 != null && !時間枠8.isEmpty()) {
            List<RString> start = 時間枠8.split(LINE.toString()).get(0).split(COLON.toString());
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠8.split(LINE.toString()).get(1).split(COLON.toString());
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku2().getChkJikanwaku8().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku2().getTxtStartTime8().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku2().getTxtEndTime8().setValue(RTime.of(endhour, endminute));
        }
    }

    private void set時間枠9(List<RString> keylist) {
        RString 時間枠9 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠9, SubGyomuCode.DBE認定支援);
        if (時間枠9 != null && !時間枠9.isEmpty()) {
            List<RString> start = 時間枠9.split(LINE.toString()).get(0).split(COLON.toString());
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠9.split(LINE.toString()).get(1).split(COLON.toString());
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku2().getChkJikanwaku9().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku2().getTxtStartTime9().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku2().getTxtEndTime9().setValue(RTime.of(endhour, endminute));
        }
    }

    private void set時間枠10(List<RString> keylist) {
        RString 時間枠10 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠10, SubGyomuCode.DBE認定支援);
        if (時間枠10 != null && !時間枠10.isEmpty()) {
            List<RString> start = 時間枠10.split(LINE.toString()).get(0).split(COLON.toString());
            int starthour = Integer.valueOf(start.get(0).toString());
            int startminute = Integer.valueOf(start.get(1).toString());
            List<RString> end = 時間枠10.split(LINE.toString()).get(1).split(COLON.toString());
            int endhour = Integer.valueOf(end.get(0).toString());
            int endminute = Integer.valueOf(end.get(1).toString());
            div.getTblJikanwaku2().getChkJikanwaku10().setSelectedItemsByKey(keylist);
            div.getTblJikanwaku2().getTxtStartTime10().setValue(RTime.of(starthour, startminute));
            div.getTblJikanwaku2().getTxtEndTime10().setValue(RTime.of(endhour, endminute));
        }
    }
}

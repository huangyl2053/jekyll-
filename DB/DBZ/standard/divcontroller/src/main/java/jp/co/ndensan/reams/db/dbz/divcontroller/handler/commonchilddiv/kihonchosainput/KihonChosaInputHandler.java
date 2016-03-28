/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.kihonchosainput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput.KihonChosaInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.IconType;
import jp.co.ndensan.reams.uz.uza.ui.binding.ListControlTextIcon;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div「認定基本調査入力」の状態を変更するクラスです。
 */
public class KihonChosaInputHandler {

    private final KihonChosaInputDiv div;
    private final RString 認定調査前回結果表示 = new RString("1");
    private final RString 調査項目ある = new RString("1");
    private final RString 調査項目ない = new RString("2");
    private final RString 調査項目1 = new RString("1");
    private final RString 調査項目2 = new RString("2");
    private final RString 調査項目3 = new RString("3");
    private final RString 調査項目4 = new RString("4");
    private final RString 調査項目5 = new RString("5");
    private static final RString モードDAIGUN = new RString("Dai1gun");
    private static final RString モードDA2GUN = new RString("Dai2gun");
    private static final RString モードDA3GUN = new RString("Dai3gun");
    private static final RString モードDA4GUN = new RString("Dai4gun");
    private static final RString モードDA5GUN = new RString("Dai5gun");
    private static final RString モードDA6GUN = new RString("Dai6gun");
    private static final RString モードDA7GUN = new RString("Dai7gun");
    private static final int 整数3 = 3;
    private static final int 整数4 = 4;
    private static final int 整数5 = 5;
    private static final int 整数9 = 9;
    private static final int 整数10 = 10;
    private static final int 整数11 = 11;
    private static final int 整数12 = 12;
    private static final int 整数13 = 13;
    private static final int 整数14 = 14;
    private static final int 整数15 = 15;
    private static final int 整数16 = 16;
    private static final int 整数17 = 17;
    private static final int 整数18 = 18;
    private static final int 整数19 = 19;
    private static final int 整数20 = 20;
    private static final int 整数21 = 21;
    private static final int 整数22 = 22;
    private static final int 整数23 = 23;
    private static final int 整数24 = 24;
    private static final int 整数25 = 25;
    private static final int 整数26 = 26;
    private static final int 整数27 = 27;
    private static final int 整数28 = 28;
    private static final int 整数29 = 29;
    private static final int 整数30 = 30;
    private static final int 整数31 = 31;
    private static final int 整数32 = 32;
    private static final int 整数33 = 33;
    private static final int 整数34 = 34;
    private static final int 整数35 = 35;
    private static final int 整数36 = 36;
    private static final int 整数37 = 37;
    private static final int 整数38 = 38;
    private static final int 整数39 = 39;
    private static final int 整数40 = 40;
    private static final int 整数41 = 41;
    private static final int 整数42 = 42;
    private static final int 整数43 = 43;
    private static final int 整数44 = 44;
    private static final int 整数45 = 45;
    private static final int 整数46 = 46;
    private static final int 整数47 = 47;
    private static final int 整数48 = 48;
    private static final int 整数49 = 49;
    private static final int 整数50 = 50;
    private static final int 整数51 = 51;
    private static final int 整数52 = 52;
    private static final int 整数53 = 53;
    private static final int 整数54 = 54;
    private static final int 整数55 = 55;
    private static final int 整数56 = 56;
    private static final int 整数57 = 57;
    private static final int 整数58 = 58;
    private static final int 整数59 = 59;
    private static final int 整数60 = 60;
    private static final int 整数61 = 61;
    private static final int 整数62 = 62;
    private static final int 整数63 = 63;
    private static final int 整数64 = 64;
    private static final int 整数65 = 65;
    private static final int 整数66 = 66;
    private static final int 整数67 = 67;
    private static final int 整数68 = 68;
    private static final int 整数69 = 69;
    private static final int 整数70 = 70;
    private static final int 整数71 = 71;
    private static final int 整数72 = 72;
    private static final int 整数73 = 73;
    private static final int 整数74 = 74;
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY2 = new RString("key2");
    private static final RString KEY3 = new RString("key3");
    private static final RString KEY4 = new RString("key4");
    private static final RString KEY5 = new RString("key5");
    private static final RString KEY6 = new RString("key6");
    private static final RString KEY7 = new RString("key7");
    private static final RString KEY8 = new RString("key8");

    /**
     * コンストラクタです。
     *
     * @param div KihonChosaInputDiv
     */
    public KihonChosaInputHandler(KihonChosaInputDiv div) {
        this.div = div;
    }

    /**
     * 共有子Divの麻痺等の有無ないCHKします。
     *
     */
    public void 麻痺等の有無ないChange() {
        List<RString> selectedKeys = div.getChkMahi().getSelectedKeys();
        RString paraSelected = div.getMahi().getIsMahiSelected();
        RString selected;
        List<RString> selectedItems = new ArrayList<>();
        if (selectedKeys.contains(KEY0)) {
            selectedItems.add(KEY0);
            selected = new RString("1");
        } else {
            selected = new RString("0");
        }
        List<RString> disabledItems = new ArrayList<>();
        if (!selected.equals(paraSelected)) {
            div.getMahi().setIsMahiSelected(selected);
            if (new RString("1").equals(selected)) {
                disabledItems.add(KEY1);
                disabledItems.add(KEY2);
                disabledItems.add(KEY3);
                disabledItems.add(KEY4);
                disabledItems.add(KEY5);
                div.getChkMahi().setSelectedItemsByKey(selectedItems);
                div.getChkMahi().setDisabledItemsByKey(disabledItems);
            } else {
                div.getChkMahi().setDisabledItemsByKey(disabledItems);
            }
        }
    }

    /**
     * 共有子Divの拘縮の有無ないCHKします。
     *
     */
    public void 拘縮の有無ないChange() {
        List<RString> selectedKeys = div.getChkKoshuku().getSelectedKeys();
        RString paraSelected = div.getKoshuku().getIsKoshukuSelected();
        RString selected;
        List<RString> selectedItems = new ArrayList<>();
        if (selectedKeys.contains(KEY0)) {
            selectedItems.add(KEY0);
            selected = new RString("1");
        } else {
            selected = new RString("0");
        }
        List<RString> disabledItems = new ArrayList<>();
        if (!selected.equals(paraSelected)) {
            div.getKoshuku().setIsKoshukuSelected(selected);
            if (new RString("1").equals(selected)) {
                disabledItems.add(KEY1);
                disabledItems.add(KEY2);
                disabledItems.add(KEY3);
                disabledItems.add(KEY4);
                div.getChkKoshuku().setSelectedItemsByKey(selectedItems);
                div.getChkKoshuku().setDisabledItemsByKey(disabledItems);
            } else {
                div.getChkKoshuku().setDisabledItemsByKey(disabledItems);
            }
        }
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     */
    public void onClick_btnConfirm() {
        RString 初期状態モード = div.getモード();
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = new ArrayList<>();
        if (モードDAIGUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第一群認定調査基本情報リスト, ArrayList.class);
        } else if (モードDA2GUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第二群認定調査基本情報リスト, ArrayList.class);
        } else if (モードDA3GUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第三群認定調査基本情報リスト, ArrayList.class);
        } else if (モードDA4GUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第四群認定調査基本情報リスト, ArrayList.class);
        } else if (モードDA5GUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第五群認定調査基本情報リスト, ArrayList.class);
        } else if (モードDA6GUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第六群認定調査基本情報リスト, ArrayList.class);
        } else if (モードDA7GUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第七群認定調査基本情報リスト, ArrayList.class);
        }
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        if (モードDAIGUN.equals(初期状態モード)) {
            第一群身体機能Confirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKey.第一群認定調査基本情報リスト, 認定調査基本情報リスト);
        } else if (モードDA2GUN.equals(初期状態モード)) {
            第二群生活機能Confirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKey.第二群認定調査基本情報リスト, 認定調査基本情報リスト);
        } else if (モードDA3GUN.equals(初期状態モード)) {
            第三群認知機能Confirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKey.第三群認定調査基本情報リスト, 認定調査基本情報リスト);
        } else if (モードDA4GUN.equals(初期状態モード)) {
            第四群精神_行動障害Confirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKey.第四群認定調査基本情報リスト, 認定調査基本情報リスト);
        } else if (モードDA5GUN.equals(初期状態モード)) {
            第五群社会生活への適用Confirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKey.第五群認定調査基本情報リスト, 認定調査基本情報リスト);
        } else if (モードDA6GUN.equals(初期状態モード)) {
            第六群特別な医療Confirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKey.第六群認定調査基本情報リスト, 認定調査基本情報リスト);
        } else if (モードDA7GUN.equals(初期状態モード)) {
            第七群自立度Confirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKey.第七群認定調査基本情報リスト, 認定調査基本情報リスト);
        }
    }

    /**
     * 共有子Divの状態を初期化します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 初期状態モード 初期状態モード
     */
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, RString 初期状態モード) {
        if (申請書管理番号 != null) {
            div.getDaiichigunShintaiKino().setShinseishoKanriNo(申請書管理番号.getColumnValue());
        }
        div.getDaiichigunShintaiKino().setRecordNumber(認定調査依頼履歴番号);
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = new ArrayList<>();
        if (モードDAIGUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第一群認定調査基本情報リスト, ArrayList.class);
        } else if (モードDA2GUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第二群認定調査基本情報リスト, ArrayList.class);
        } else if (モードDA3GUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第三群認定調査基本情報リスト, ArrayList.class);
        } else if (モードDA4GUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第四群認定調査基本情報リスト, ArrayList.class);
        } else if (モードDA5GUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第五群認定調査基本情報リスト, ArrayList.class);
        } else if (モードDA6GUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第六群認定調査基本情報リスト, ArrayList.class);
        } else if (モードDA7GUN.equals(初期状態モード)) {
            認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第七群認定調査基本情報リスト, ArrayList.class);
        }
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        RString 認定調査前回結果表示 = BusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (!this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            div.getZenkaiHyojiTeiji().setDisplayNone(true);
        }
        if (モードDAIGUN.equals(初期状態モード)) {
            getHandler1(div).onLoad第一群身体機能(認定調査基本情報リスト, 認定調査前回結果表示);
            div.getSeikatsuKinou().setDisplayNone(true);
            div.getNinchiKinou().setDisplayNone(true);
            div.getKoudoShogai().setDisplayNone(true);
            div.getShakaiSekatsu().setDisplayNone(true);
            div.getTokubetsuIryo().setDisplayNone(true);
            div.getJiritsudo().setDisplayNone(true);
        } else if (モードDA2GUN.equals(初期状態モード)) {
            getHandler1(div).onLoad第二群生活機能(認定調査基本情報リスト, 認定調査前回結果表示);
            div.getDaiichigunShintaiKino().setDisplayNone(true);
            div.getNinchiKinou().setDisplayNone(true);
            div.getKoudoShogai().setDisplayNone(true);
            div.getShakaiSekatsu().setDisplayNone(true);
            div.getTokubetsuIryo().setDisplayNone(true);
            div.getJiritsudo().setDisplayNone(true);
        } else if (モードDA3GUN.equals(初期状態モード)) {
            getHandler1(div).onLoad第三群認知機能(認定調査基本情報リスト, 認定調査前回結果表示);
            div.getDaiichigunShintaiKino().setDisplayNone(true);
            div.getSeikatsuKinou().setDisplayNone(true);
            div.getKoudoShogai().setDisplayNone(true);
            div.getShakaiSekatsu().setDisplayNone(true);
            div.getTokubetsuIryo().setDisplayNone(true);
            div.getJiritsudo().setDisplayNone(true);
        } else if (モードDA4GUN.equals(初期状態モード)) {
            onLoad第四群精神_行動障害(認定調査基本情報リスト, 認定調査前回結果表示);
            div.getDaiichigunShintaiKino().setDisplayNone(true);
            div.getSeikatsuKinou().setDisplayNone(true);
            div.getNinchiKinou().setDisplayNone(true);
            div.getShakaiSekatsu().setDisplayNone(true);
            div.getTokubetsuIryo().setDisplayNone(true);
            div.getJiritsudo().setDisplayNone(true);
        } else if (モードDA5GUN.equals(初期状態モード)) {
            onLoad第五群社会生活への適用(認定調査基本情報リスト, 認定調査前回結果表示);
            div.getDaiichigunShintaiKino().setDisplayNone(true);
            div.getSeikatsuKinou().setDisplayNone(true);
            div.getNinchiKinou().setDisplayNone(true);
            div.getKoudoShogai().setDisplayNone(true);
            div.getTokubetsuIryo().setDisplayNone(true);
            div.getJiritsudo().setDisplayNone(true);
        } else if (モードDA6GUN.equals(初期状態モード)) {
            onLoad第六群特別な医療(認定調査基本情報リスト, 認定調査前回結果表示);
            div.getDaiichigunShintaiKino().setDisplayNone(true);
            div.getSeikatsuKinou().setDisplayNone(true);
            div.getNinchiKinou().setDisplayNone(true);
            div.getKoudoShogai().setDisplayNone(true);
            div.getShakaiSekatsu().setDisplayNone(true);
            div.getJiritsudo().setDisplayNone(true);
        } else if (モードDA7GUN.equals(初期状態モード)) {
            onLoad第七群自立度(認定調査基本情報リスト, 認定調査前回結果表示);
            div.getDaiichigunShintaiKino().setDisplayNone(true);
            div.getSeikatsuKinou().setDisplayNone(true);
            div.getNinchiKinou().setDisplayNone(true);
            div.getKoudoShogai().setDisplayNone(true);
            div.getShakaiSekatsu().setDisplayNone(true);
            div.getTokubetsuIryo().setDisplayNone(true);
        }
    }

    private void onLoad第四群精神_行動障害(ArrayList<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
        List<RString> 被虐的Keys = new ArrayList<>();
        List<RString> 前回被虐的Keys = new ArrayList<>();
        List<RString> 作話Keys = new ArrayList<>();
        List<RString> 前回作話Keys = new ArrayList<>();
        List<RString> 感情が不安定Keys = new ArrayList<>();
        List<RString> 前回感情が不安定Keys = new ArrayList<>();
        List<RString> 昼夜逆転Keys = new ArrayList<>();
        List<RString> 前回昼夜逆転Keys = new ArrayList<>();
        List<RString> 同じ話をするKeys = new ArrayList<>();
        List<RString> 前回同じ話をするKeys = new ArrayList<>();
        List<RString> 大声をだすKeys = new ArrayList<>();
        List<RString> 前回大声をだすKeys = new ArrayList<>();
        List<RString> 介護に抵抗Keys = new ArrayList<>();
        List<RString> 前回介護に抵抗Keys = new ArrayList<>();
        List<RString> 落ち着きなしKeys = new ArrayList<>();
        List<RString> 前回落ち着きなしKeys = new ArrayList<>();
        List<RString> 一人で出たがるKeys = new ArrayList<>();
        List<RString> 前回一人で出たがるKeys = new ArrayList<>();
        List<RString> 収集癖Keys = new ArrayList<>();
        List<RString> 前回収集癖Keys = new ArrayList<>();
        List<RString> 物や衣類を壊すKeys = new ArrayList<>();
        List<RString> 前回物や衣類を壊すKeys = new ArrayList<>();
        List<RString> ひどい物忘れKeys = new ArrayList<>();
        List<RString> 前回ひどい物忘れKeys = new ArrayList<>();
        List<RString> 独り言_独り笑いKeys = new ArrayList<>();
        List<RString> 前回独り言_独り笑いKeys = new ArrayList<>();
        List<RString> 自分勝手に行動するKeys = new ArrayList<>();
        List<RString> 前回自分勝手に行動するKeys = new ArrayList<>();
        List<RString> 話がまとまらないKeys = new ArrayList<>();
        List<RString> 前回話がまとまらないKeys = new ArrayList<>();
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            set被虐的(被虐的Keys, 前回被虐的Keys, 認定調査基本情報);
            set作話(作話Keys, 前回作話Keys, 認定調査基本情報);
            set感情が不安定(感情が不安定Keys, 前回感情が不安定Keys, 認定調査基本情報);
            set昼夜逆転(昼夜逆転Keys, 前回昼夜逆転Keys, 認定調査基本情報);
            set同じ話をする(同じ話をするKeys, 前回同じ話をするKeys, 認定調査基本情報);
            set大声をだす(大声をだすKeys, 前回大声をだすKeys, 認定調査基本情報);
            set介護に抵抗(介護に抵抗Keys, 前回介護に抵抗Keys, 認定調査基本情報);
            set落ち着きなし(落ち着きなしKeys, 前回落ち着きなしKeys, 認定調査基本情報);
            set一人で出たがる(一人で出たがるKeys, 前回一人で出たがるKeys, 認定調査基本情報);
            set収集癖(収集癖Keys, 前回収集癖Keys, 認定調査基本情報);
            set物や衣類を壊す(物や衣類を壊すKeys, 前回物や衣類を壊すKeys, 認定調査基本情報);
            setひどい物忘れ(ひどい物忘れKeys, 前回ひどい物忘れKeys, 認定調査基本情報);
            set独り言_独り笑い(独り言_独り笑いKeys, 前回独り言_独り笑いKeys, 認定調査基本情報);
            set自分勝手に行動する(自分勝手に行動するKeys, 前回自分勝手に行動するKeys, 認定調査基本情報);
            set話がまとまらない(話がまとまらないKeys, 前回話がまとまらないKeys, 認定調査基本情報);
        }
        被虐的画面表示(被虐的Keys, 前回被虐的Keys, 認定調査前回結果表示);
        作話画面表示(作話Keys, 前回作話Keys, 認定調査前回結果表示);
        感情が不安定画面表示(感情が不安定Keys, 前回感情が不安定Keys, 認定調査前回結果表示);
        昼夜逆転画面表示(昼夜逆転Keys, 前回昼夜逆転Keys, 認定調査前回結果表示);
        同じ話をする画面表示(同じ話をするKeys, 前回同じ話をするKeys, 認定調査前回結果表示);
        大声をだす画面表示(大声をだすKeys, 前回大声をだすKeys, 認定調査前回結果表示);
        介護に抵抗画面表示(介護に抵抗Keys, 前回介護に抵抗Keys, 認定調査前回結果表示);
        落ち着きなし画面表示(落ち着きなしKeys, 前回落ち着きなしKeys, 認定調査前回結果表示);
        一人で出たがる画面表示(一人で出たがるKeys, 前回一人で出たがるKeys, 認定調査前回結果表示);
        収集癖画面表示(収集癖Keys, 前回収集癖Keys, 認定調査前回結果表示);
        物や衣類を壊す画面表示(物や衣類を壊すKeys, 前回物や衣類を壊すKeys, 認定調査前回結果表示);
        ひどい物忘れ画面表示(ひどい物忘れKeys, 前回ひどい物忘れKeys, 認定調査前回結果表示);
        独り言_独り笑い画面表示(独り言_独り笑いKeys, 前回独り言_独り笑いKeys, 認定調査前回結果表示);
        自分勝手に行動する画面表示(自分勝手に行動するKeys, 前回自分勝手に行動するKeys, 認定調査前回結果表示);
        話がまとまらない画面表示(話がまとまらないKeys, 前回話がまとまらないKeys, 認定調査前回結果表示);
    }

    private void onLoad第五群社会生活への適用(ArrayList<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
        List<RString> 薬の内服Keys = new ArrayList<>();
        List<RString> 前回薬の内服Keys = new ArrayList<>();
        List<RString> 金銭の管理Keys = new ArrayList<>();
        List<RString> 前回金銭の管理Keys = new ArrayList<>();
        List<RString> 日常の意思決定Keys = new ArrayList<>();
        List<RString> 前回日常の意思決定Keys = new ArrayList<>();
        List<RString> 集団への不適用Keys = new ArrayList<>();
        List<RString> 前回集団への不適用Keys = new ArrayList<>();
        List<RString> 買い物Keys = new ArrayList<>();
        List<RString> 前回買い物Keys = new ArrayList<>();
        List<RString> 簡単な調理Keys = new ArrayList<>();
        List<RString> 前回簡単な調理Keys = new ArrayList<>();
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            set薬の内服(薬の内服Keys, 前回薬の内服Keys, 認定調査基本情報);
            set金銭の管理(金銭の管理Keys, 前回金銭の管理Keys, 認定調査基本情報);
            set日常の意思決定(日常の意思決定Keys, 前回日常の意思決定Keys, 認定調査基本情報);
            set集団への不適用(集団への不適用Keys, 前回集団への不適用Keys, 認定調査基本情報);
            set買い物(買い物Keys, 前回買い物Keys, 認定調査基本情報);
            set簡単な調理(簡単な調理Keys, 前回簡単な調理Keys, 認定調査基本情報);
        }
        薬の内服画面表示(薬の内服Keys, 前回薬の内服Keys, 認定調査前回結果表示);
        金銭の管理画面表示(金銭の管理Keys, 前回金銭の管理Keys, 認定調査前回結果表示);
        日常の意思決定画面表示(日常の意思決定Keys, 前回日常の意思決定Keys, 認定調査前回結果表示);
        集団への不適用画面表示(集団への不適用Keys, 前回集団への不適用Keys, 認定調査前回結果表示);
        買い物画面表示(買い物Keys, 前回買い物Keys, 認定調査前回結果表示);
        簡単な調理画面表示(簡単な調理Keys, 前回簡単な調理Keys, 認定調査前回結果表示);
    }

    private void onLoad第六群特別な医療(ArrayList<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
        List<RString> 処置内容Keys = new ArrayList<>();
        List<RString> 前回処置内容Keys = new ArrayList<>();
        List<RString> 処置内容特記事項番号 = new ArrayList<>();
        List<RString> 特別な対応Keys = new ArrayList<>();
        List<RString> 前回特別な対応Keys = new ArrayList<>();
        List<RString> 特別な対応特記事項番号 = new ArrayList<>();
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            set特別な対応Keys(特別な対応Keys, 前回特別な対応Keys, 特別な対応特記事項番号, 認定調査基本情報);
            set処置内容Keys(処置内容Keys, 前回処置内容Keys, 処置内容特記事項番号, 認定調査基本情報);
        }
        特別な対応画面表示(特別な対応Keys, 前回特別な対応Keys, 特別な対応特記事項番号, 認定調査前回結果表示);
        処置内容画面表示(処置内容Keys, 前回処置内容Keys, 処置内容特記事項番号, 認定調査前回結果表示);
    }

    private void onLoad第七群自立度(ArrayList<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
        List<RString> 障害高齢者の日常生活自立度_寝たきり度Keys = new ArrayList<>();
        List<RString> 前回障害高齢者の日常生活自立度_寝たきり度Keys = new ArrayList<>();
        List<RString> 認知症高齢者の日常生活自立度Keys = new ArrayList<>();
        List<RString> 前回認知症高齢者の日常生活自立度Keys = new ArrayList<>();
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            set障害高齢者の日常生活自立度_寝たきり度Keys(障害高齢者の日常生活自立度_寝たきり度Keys,
                    前回障害高齢者の日常生活自立度_寝たきり度Keys, 認定調査基本情報);
            set認知症高齢者の日常生活自立度Keys(認知症高齢者の日常生活自立度Keys, 前回認知症高齢者の日常生活自立度Keys, 認定調査基本情報);
        }
        障害高齢者の日常生活自立度_寝たきり度画面表示(障害高齢者の日常生活自立度_寝たきり度Keys,
                前回障害高齢者の日常生活自立度_寝たきり度Keys, 認定調査前回結果表示);
        認知症高齢者の日常生活自立度画面表示(認知症高齢者の日常生活自立度Keys, 前回認知症高齢者の日常生活自立度Keys, 認定調査前回結果表示);
    }

    private void set認知症高齢者の日常生活自立度Keys(List<RString> 認知症高齢者の日常生活自立度Keys,
            List<RString> 前回認知症高齢者の日常生活自立度Keys, KihonChosaInput 認定調査基本情報) {
        RString 認知症高齢者自立度RString = 認定調査基本情報.get認知症高齢者自立度().getColumnValue();
        RString 前回認知症高齢者自立度RString = 認定調査基本情報.get前回認知症高齢者自立度().getColumnValue();
        if (NinchishoNichijoSeikatsuJiritsudoCode.自立.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY0);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅰ.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY1);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅱa.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY2);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅱb.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY3);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅲa.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY4);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅲb.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY5);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅳ.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY6);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.M.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY7);
        }
        if (NinchishoNichijoSeikatsuJiritsudoCode.自立.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY0);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅰ.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY1);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅱa.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY2);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅱb.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY3);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅲa.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY4);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅲb.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY5);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅳ.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY6);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.M.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY7);
        }
    }

    private void 認知症高齢者の日常生活自立度画面表示(List<RString> 認知症高齢者の日常生活自立度Keys,
            List<RString> 前回認知症高齢者の日常生活自立度Keys, RString 認定調査前回結果表示) {
        if (認知症高齢者の日常生活自立度Keys.isEmpty()) {
            div.getBtnNinchishaJiritsudo().setDisabled(true);
        } else {
            div.getRadNinchishaJiritsudo().setSelectedKey(認知症高齢者の日常生活自立度Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            認知症高齢者の日常生活自立度アンダーライン(前回認知症高齢者の日常生活自立度Keys);
        }
    }

    private void 認知症高齢者の日常生活自立度アンダーライン(List<RString> 前回認知症高齢者の日常生活自立度) {
        if (!前回認知症高齢者の日常生活自立度.isEmpty()) {
            div.getRadNinchishaJiritsudo().setIcon(getListControlTextIcon(前回認知症高齢者の日常生活自立度));
        }
    }

    private void set障害高齢者の日常生活自立度_寝たきり度Keys(List<RString> 障害高齢者の日常生活自立度_寝たきり度Keys,
            List<RString> 前回障害高齢者の日常生活自立度_寝たきり度Keys, KihonChosaInput 認定調査基本情報) {
        RString 障害高齢者自立度RString = 認定調査基本情報.get障害高齢者自立度().getColumnValue();
        RString 前回障害高齢者自立度RString = 認定調査基本情報.get前回障害高齢者自立度().getColumnValue();
        if (ShogaiNichijoSeikatsuJiritsudoCode.自立.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY0);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.J1.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY1);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.J2.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY2);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.A1.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY3);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.A2.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY4);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.B1.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY5);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.B2.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY6);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.C1.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY7);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.C2.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY8);
        }
        if (ShogaiNichijoSeikatsuJiritsudoCode.自立.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY0);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.J1.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY1);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.J2.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY2);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.A1.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY3);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.A2.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY4);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.B1.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY5);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.B2.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY6);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.C1.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY7);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.C2.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY8);
        }
    }

    private void 障害高齢者の日常生活自立度_寝たきり度画面表示(List<RString> 障害高齢者の日常生活自立度_寝たきり度Keys,
            List<RString> 前回障害高齢者の日常生活自立度_寝たきり度Keys, RString 認定調査前回結果表示) {
        if (障害高齢者の日常生活自立度_寝たきり度Keys.isEmpty()) {
            div.getBtnShogaiKoreisha().setDisabled(true);
        } else {
            div.getRadShogaiKoreisha().setSelectedKey(障害高齢者の日常生活自立度_寝たきり度Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            障害高齢者の日常生活自立度_寝たきり度アンダーライン(前回障害高齢者の日常生活自立度_寝たきり度Keys);
        }
    }

    private void 障害高齢者の日常生活自立度_寝たきり度アンダーライン(List<RString> 前回障害高齢者の日常生活自立度_寝たきり度) {
        if (!前回障害高齢者の日常生活自立度_寝たきり度.isEmpty()) {
            div.getRadShogaiKoreisha().setIcon(getListControlTextIcon(前回障害高齢者の日常生活自立度_寝たきり度));
        }
    }

    private void set特別な対応Keys(List<RString> 特別な対応Keys, List<RString> 前回特別な対応Keys,
            List<RString> 特別な対応特記事項番号, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        RString 特記事項番号 = 認定調査基本情報.get認定調査特記事項番号();
        if (調査項目ある.equals(調査項目)) {
            if (連番 == 整数72) {
                特別な対応Keys.add(KEY0);
                特別な対応特記事項番号.add(特記事項番号);
            } else if (連番 == 整数73) {
                特別な対応Keys.add(KEY1);
                特別な対応特記事項番号.add(特記事項番号);
            } else if (連番 == 整数74) {
                特別な対応Keys.add(KEY2);
                特別な対応特記事項番号.add(特記事項番号);
            }
        }
        if (調査項目ある.equals(前回調査項目)) {
            if (前回連番 == 整数72) {
                前回特別な対応Keys.add(KEY0);
            } else if (前回連番 == 整数73) {
                前回特別な対応Keys.add(KEY1);
            } else if (前回連番 == 整数74) {
                前回特別な対応Keys.add(KEY2);
            }
        }
    }

    private void 特別な対応画面表示(List<RString> 特別な対応Keys, List<RString> 前回特別な対応Keys,
            List<RString> 特別な対応特記事項番号, RString 認定調査前回結果表示) {
        if (特別な対応Keys.isEmpty()) {
            div.getBtnTokiTaiou().setDisabled(true);
        } else {
            div.getChkTokiTaiou().setSelectedItemsByKey(特別な対応Keys);
            div.getTokiTaiou().setTokiTaiouShinseishoKanriNo(DataPassingConverter.serialize(
                    new ArrayList<>(特別な対応特記事項番号)));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            特別な対応アンダーライン(前回特別な対応Keys);
        }
    }

    private void 特別な対応アンダーライン(List<RString> 前回特別な対応) {
        if (!前回特別な対応.isEmpty()) {
            div.getChkTokiTaiou().setIcon(getListControlTextIcon(前回特別な対応));
        }
    }

    private void set処置内容Keys(List<RString> 処置内容Keys, List<RString> 前回処置内容Keys,
            List<RString> 処置内容特記事項番号, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 特記事項番号 = 認定調査基本情報.get認定調査特記事項番号();
        if (調査項目ある.equals(調査項目)) {
            if (連番 == 整数63) {
                処置内容Keys.add(KEY0);
                処置内容特記事項番号.add(特記事項番号);
            } else if (連番 == 整数64) {
                処置内容Keys.add(KEY1);
                処置内容特記事項番号.add(特記事項番号);
            } else if (連番 == 整数65) {
                処置内容Keys.add(KEY2);
                処置内容特記事項番号.add(特記事項番号);
            } else if (連番 == 整数66) {
                処置内容Keys.add(KEY3);
                処置内容特記事項番号.add(特記事項番号);
            } else if (連番 == 整数67) {
                処置内容Keys.add(KEY4);
                処置内容特記事項番号.add(特記事項番号);
            } else if (連番 == 整数68) {
                処置内容Keys.add(KEY5);
                処置内容特記事項番号.add(特記事項番号);
            } else if (連番 == 整数69) {
                処置内容Keys.add(KEY6);
                処置内容特記事項番号.add(特記事項番号);
            } else if (連番 == 整数70) {
                処置内容Keys.add(KEY7);
                処置内容特記事項番号.add(特記事項番号);
            } else if (連番 == 整数71) {
                処置内容Keys.add(KEY8);
                処置内容特記事項番号.add(特記事項番号);
            }
        }
    }

    private void set前回処置内容Keys(List<RString> 前回処置内容Keys, KihonChosaInput 認定調査基本情報) {
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (調査項目ある.equals(前回調査項目)) {
            if (前回連番 == 整数63) {
                前回処置内容Keys.add(KEY0);
            } else if (前回連番 == 整数64) {
                前回処置内容Keys.add(KEY1);
            } else if (前回連番 == 整数65) {
                前回処置内容Keys.add(KEY2);
            } else if (前回連番 == 整数66) {
                前回処置内容Keys.add(KEY3);
            } else if (前回連番 == 整数67) {
                前回処置内容Keys.add(KEY4);
            } else if (前回連番 == 整数68) {
                前回処置内容Keys.add(KEY5);
            } else if (前回連番 == 整数69) {
                前回処置内容Keys.add(KEY6);
            } else if (前回連番 == 整数70) {
                前回処置内容Keys.add(KEY7);
            } else if (前回連番 == 整数71) {
                前回処置内容Keys.add(KEY8);
            }
        }
    }

    private void 処置内容画面表示(List<RString> 処置内容Keys, List<RString> 前回処置内容Keys,
            List<RString> 処置内容特記事項番号, RString 認定調査前回結果表示) {
        if (処置内容Keys.isEmpty()) {
            div.getBtnShochiNaiyo().setDisabled(true);
        } else {
            div.getChkShochiNaiyo().setSelectedItemsByKey(処置内容Keys);
            div.getShochiNaiyo().setShochiNaiyoShinseishoKanriNo(DataPassingConverter.serialize(
                    new ArrayList<>(処置内容特記事項番号)));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            処置内容アンダーライン(前回処置内容Keys);
        }
    }

    private void 処置内容アンダーライン(List<RString> 前回処置内容) {
        if (!前回処置内容.isEmpty()) {
            div.getChkShochiNaiyo().setIcon(getListControlTextIcon(前回処置内容));
        }
    }

    private void set簡単な調理(List<RString> 簡単な調理Keys, List<RString> 前回簡単な調理Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        if (連番 == 整数62) {
            setKeyBy調査項目(簡単な調理Keys, 調査項目, true, false);
            div.getKantanChori().setKantanChoriShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数62) {
            setKeyBy調査項目(前回簡単な調理Keys, 調査項目, true, false);
        }
    }

    private void 簡単な調理画面表示(List<RString> 簡単な調理Keys, List<RString> 前回簡単な調理Keys, RString 認定調査前回結果表示) {
        if (簡単な調理Keys.isEmpty()) {
            div.getBtnKantanChori().setDisabled(true);
        } else {
            div.getRadKantanChori().setSelectedKey(簡単な調理Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            簡単な調理アンダーライン(前回簡単な調理Keys);
        }
    }

    private void 簡単な調理アンダーライン(List<RString> 前回簡単な調理Keys) {
        if (!前回簡単な調理Keys.isEmpty()) {
            div.getRadKantanChori().setIcon(getListControlTextIcon(前回簡単な調理Keys));
        }
    }

    private void set買い物(List<RString> 買い物Keys, List<RString> 前回買い物Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数61) {
            setKeyBy調査項目(買い物Keys, 調査項目, true, false);
            div.getKaiMono().setKaiMonoShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数61) {
            setKeyBy調査項目(前回買い物Keys, 前回調査項目, true, false);
        }
    }

    private void 買い物画面表示(List<RString> 買い物Keys, List<RString> 前回買い物Keys, RString 認定調査前回結果表示) {
        if (買い物Keys.isEmpty()) {
            div.getBtnKaiMono().setDisabled(true);
        } else {
            div.getRadKaiMono().setSelectedKey(買い物Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            買い物アンダーライン(前回買い物Keys);
        }
    }

    private void 買い物アンダーライン(List<RString> 前回買い物Keys) {
        if (!前回買い物Keys.isEmpty()) {
            div.getRadKaiMono().setIcon(getListControlTextIcon(前回買い物Keys));
        }
    }

    private void set集団への不適用(List<RString> 集団への不適用Keys, List<RString> 前回集団への不適用Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数60) {
            setKeyBy調査項目(集団への不適用Keys, 調査項目, true, false);
            div.getShudan().setShudanShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数60) {
            setKeyBy調査項目(前回集団への不適用Keys, 前回調査項目, true, false);
        }
    }

    private void 集団への不適用画面表示(List<RString> 集団への不適用Keys, List<RString> 前回集団への不適用Keys, RString 認定調査前回結果表示) {
        if (集団への不適用Keys.isEmpty()) {
            div.getBtnShudan().setDisabled(true);
        } else {
            div.getRadShudan().setSelectedKey(集団への不適用Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            集団への不適用アンダーライン(前回集団への不適用Keys);
        }
    }

    private void 集団への不適用アンダーライン(List<RString> 前回集団への不適用Keys) {
        if (!前回集団への不適用Keys.isEmpty()) {
            div.getRadShudan().setIcon(getListControlTextIcon(前回集団への不適用Keys));
        }
    }

    private void set日常の意思決定(List<RString> 日常の意思決定Keys, List<RString> 前回日常の意思決定Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数59) {
            setKeyBy調査項目(日常の意思決定Keys, 調査項目, true, false);
            div.getIshiKetei().setIshiKeteiShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数59) {
            setKeyBy調査項目(前回日常の意思決定Keys, 前回調査項目, true, false);
        }
    }

    private void 日常の意思決定画面表示(List<RString> 日常の意思決定Keys, List<RString> 前回日常の意思決定Keys, RString 認定調査前回結果表示) {
        if (日常の意思決定Keys.isEmpty()) {
            div.getBtnIshiKetei().setDisabled(true);
        } else {
            div.getRadIshiKetei().setSelectedKey(日常の意思決定Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            日常の意思決定アンダーライン(前回日常の意思決定Keys);
        }
    }

    private void 日常の意思決定アンダーライン(List<RString> 前回日常の意思決定Keys) {
        if (!前回日常の意思決定Keys.isEmpty()) {
            div.getRadIshiKetei().setIcon(getListControlTextIcon(前回日常の意思決定Keys));
        }
    }

    private void set金銭の管理(List<RString> 金銭の管理Keys, List<RString> 前回金銭の管理Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数58) {
            setKeyBy調査項目(金銭の管理Keys, 調査項目, false, false);
            div.getKingakuKanri().setKingakuKanriShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数58) {
            setKeyBy調査項目(前回金銭の管理Keys, 前回調査項目, false, false);
        }
    }

    private void 金銭の管理画面表示(List<RString> 金銭の管理Keys, List<RString> 前回金銭の管理Keys, RString 認定調査前回結果表示) {
        if (金銭の管理Keys.isEmpty()) {
            div.getBtnKingakuKanri().setDisabled(true);
        } else {
            div.getRadKingakuKanri().setSelectedKey(金銭の管理Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            金銭の管理アンダーライン(前回金銭の管理Keys);
        }
    }

    private void 金銭の管理アンダーライン(List<RString> 前回金銭の管理Keys) {
        if (!前回金銭の管理Keys.isEmpty()) {
            div.getRadKingakuKanri().setIcon(getListControlTextIcon(前回金銭の管理Keys));
        }
    }

    private void set薬の内服(List<RString> 薬の内服Keys, List<RString> 前回薬の内服Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数57) {
            setKeyBy調査項目(薬の内服Keys, 調査項目, false, false);
            div.getKusuri().setKusuriShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数57) {
            setKeyBy調査項目(前回薬の内服Keys, 前回調査項目, false, false);
        }
    }

    private void 薬の内服画面表示(List<RString> 薬の内服Keys, List<RString> 前回薬の内服Keys, RString 認定調査前回結果表示) {
        if (薬の内服Keys.isEmpty()) {
            div.getBtnKusuri().setDisabled(true);
        } else {
            div.getRadKusuri().setSelectedKey(薬の内服Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            薬の内服アンダーライン(前回薬の内服Keys);
        }
    }

    private void 薬の内服アンダーライン(List<RString> 前回薬の内服Keys) {
        if (!前回薬の内服Keys.isEmpty()) {
            div.getRadKusuri().setIcon(getListControlTextIcon(前回薬の内服Keys));
        }
    }

    private void set話がまとまらない(List<RString> 話がまとまらないKeys, List<RString> 前回話がまとまらないKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数56) {
            setKeyBy調査項目(話がまとまらないKeys, 調査項目, false, false);
            div.getMatomeNai().setMatomeNaiShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数56) {
            setKeyBy調査項目(前回話がまとまらないKeys, 前回調査項目, false, false);
        }
    }

    private void 話がまとまらない画面表示(List<RString> 話がまとまらないKeys, List<RString> 前回話がまとまらないKeys, RString 認定調査前回結果表示) {
        if (話がまとまらないKeys.isEmpty()) {
            div.getBtnMatomeNai().setDisabled(true);
        } else {
            div.getRadMatomeNai().setSelectedKey(話がまとまらないKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            話がまとまらないアンダーライン(前回話がまとまらないKeys);
        }
    }

    private void 話がまとまらないアンダーライン(List<RString> 前回話がまとまらないKeys) {
        if (!前回話がまとまらないKeys.isEmpty()) {
            div.getRadMatomeNai().setIcon(getListControlTextIcon(前回話がまとまらないKeys));
        }
    }

    private void set自分勝手に行動する(List<RString> 自分勝手に行動するKeys,
            List<RString> 前回自分勝手に行動するKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数55) {
            setKeyBy調査項目(自分勝手に行動するKeys, 調査項目, false, false);
            div.getKateKodo().setKateKodoShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数55) {
            setKeyBy調査項目(前回自分勝手に行動するKeys, 前回調査項目, false, false);
        }
    }

    private void 自分勝手に行動する画面表示(List<RString> 自分勝手に行動するKeys, List<RString> 前回自分勝手に行動するKeys, RString 認定調査前回結果表示) {
        if (自分勝手に行動するKeys.isEmpty()) {
            div.getBtnKateKodo().setDisabled(true);
        } else {
            div.getRadKateKodo().setSelectedKey(自分勝手に行動するKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            自分勝手に行動するアンダーライン(前回自分勝手に行動するKeys);
        }
    }

    private void 自分勝手に行動するアンダーライン(List<RString> 前回自分勝手に行動するKeys) {
        if (!前回自分勝手に行動するKeys.isEmpty()) {
            div.getRadKateKodo().setIcon(getListControlTextIcon(前回自分勝手に行動するKeys));
        }
    }

    private void set独り言_独り笑い(List<RString> 独り言_独り笑いKeys, List<RString> 前回独り言_独り笑いKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数54) {
            setKeyBy調査項目(独り言_独り笑いKeys, 調査項目, false, false);
            div.getHitoriWarai().setHitoriWaraiShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数54) {
            setKeyBy調査項目(前回独り言_独り笑いKeys, 前回調査項目, false, false);
        }
    }

    private void 独り言_独り笑い画面表示(List<RString> 独り言_独り笑いKeys, List<RString> 前回独り言_独り笑いKeys, RString 認定調査前回結果表示) {
        if (独り言_独り笑いKeys.isEmpty()) {
            div.getBtnHitoriWarai().setDisabled(true);
        } else {
            div.getRadHitoriWarai().setSelectedKey(独り言_独り笑いKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            独り言_独り笑いアンダーライン(前回独り言_独り笑いKeys);
        }
    }

    private void 独り言_独り笑いアンダーライン(List<RString> 前回独り言_独り笑いKeys) {
        if (!前回独り言_独り笑いKeys.isEmpty()) {
            div.getRadHitoriWarai().setIcon(getListControlTextIcon(前回独り言_独り笑いKeys));
        }
    }

    private void setひどい物忘れ(List<RString> ひどい物忘れKeys, List<RString> 前回ひどい物忘れKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数53) {
            setKeyBy調査項目(ひどい物忘れKeys, 調査項目, false, false);
            div.getMonoWasure().setMonoWasureShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数53) {
            setKeyBy調査項目(前回ひどい物忘れKeys, 前回調査項目, false, false);
        }
    }

    private void ひどい物忘れ画面表示(List<RString> ひどい物忘れKeys, List<RString> 前回ひどい物忘れKeys, RString 認定調査前回結果表示) {
        if (ひどい物忘れKeys.isEmpty()) {
            div.getBtnMonoWasure().setDisabled(true);
        } else {
            div.getRadMonoWasure().setSelectedKey(ひどい物忘れKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            ひどい物忘れアンダーライン(前回ひどい物忘れKeys);
        }
    }

    private void ひどい物忘れアンダーライン(List<RString> 前回ひどい物忘れKeys) {
        if (!前回ひどい物忘れKeys.isEmpty()) {
            div.getRadMonoWasure().setIcon(getListControlTextIcon(前回ひどい物忘れKeys));
        }
    }

    private void set物や衣類を壊す(List<RString> 物や衣類を壊すKeys, List<RString> 前回物や衣類を壊すKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数52) {
            setKeyBy調査項目(物や衣類を壊すKeys, 調査項目, false, false);
            div.getKowasu().setKowasuShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数52) {
            setKeyBy調査項目(前回物や衣類を壊すKeys, 前回調査項目, false, false);
        }
    }

    private void 物や衣類を壊す画面表示(List<RString> 物や衣類を壊すKeys, List<RString> 前回物や衣類を壊すKeys, RString 認定調査前回結果表示) {
        if (物や衣類を壊すKeys.isEmpty()) {
            div.getBtnKowasu().setDisabled(true);
        } else {
            div.getRadKowasu().setSelectedKey(物や衣類を壊すKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            物や衣類を壊すアンダーライン(前回物や衣類を壊すKeys);
        }
    }

    private void 物や衣類を壊すアンダーライン(List<RString> 前回物や衣類を壊すKeys) {
        if (!前回物や衣類を壊すKeys.isEmpty()) {
            div.getRadKowasu().setIcon(getListControlTextIcon(前回物や衣類を壊すKeys));
        }
    }

    private void set収集癖(List<RString> 収集癖Keys, List<RString> 前回収集癖Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数51) {
            setKeyBy調査項目(収集癖Keys, 調査項目, false, false);
            div.getShushu().setShushuShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数51) {
            setKeyBy調査項目(前回収集癖Keys, 前回調査項目, false, false);
        }
    }

    private void 収集癖画面表示(List<RString> 収集癖Keys, List<RString> 前回収集癖Keys, RString 認定調査前回結果表示) {
        if (収集癖Keys.isEmpty()) {
            div.getBtnShushu().setDisabled(true);
        } else {
            div.getRadShushu().setSelectedKey(収集癖Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            収集癖アンダーライン(前回収集癖Keys);
        }
    }

    private void 収集癖アンダーライン(List<RString> 前回収集癖Keys) {
        if (!前回収集癖Keys.isEmpty()) {
            div.getRadShushu().setIcon(getListControlTextIcon(前回収集癖Keys));
        }
    }

    private void set一人で出たがる(List<RString> 一人で出たがるKeys, List<RString> 前回一人で出たがるKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数50) {
            setKeyBy調査項目(一人で出たがるKeys, 調査項目, false, false);
            div.getOutLonly().setOutLonlyShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数50) {
            setKeyBy調査項目(前回一人で出たがるKeys, 前回調査項目, false, false);
        }
    }

    private void 一人で出たがる画面表示(List<RString> 一人で出たがるKeys, List<RString> 前回一人で出たがるKeys, RString 認定調査前回結果表示) {
        if (一人で出たがるKeys.isEmpty()) {
            div.getBtnOutLonly().setDisabled(true);
        } else {
            div.getRadOutLonly().setSelectedKey(一人で出たがるKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            一人で出たがるアンダーライン(前回一人で出たがるKeys);
        }
    }

    private void 一人で出たがるアンダーライン(List<RString> 前回一人で出たがるKeys) {
        if (!前回一人で出たがるKeys.isEmpty()) {
            div.getRadOutLonly().setIcon(getListControlTextIcon(前回一人で出たがるKeys));
        }
    }

    private void set落ち着きなし(List<RString> 落ち着きなしKeys, List<RString> 前回落ち着きなしKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数49) {
            setKeyBy調査項目(落ち着きなしKeys, 調査項目, false, false);
            div.getOchituki().setOchitukiShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数49) {
            setKeyBy調査項目(前回落ち着きなしKeys, 前回調査項目, false, false);
        }
    }

    private void 落ち着きなし画面表示(List<RString> 落ち着きなしKeys, List<RString> 前回落ち着きなしKeys, RString 認定調査前回結果表示) {
        if (落ち着きなしKeys.isEmpty()) {
            div.getBtnOchituki().setDisabled(true);
        } else {
            div.getRadOchituki().setSelectedKey(落ち着きなしKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            落ち着きなしアンダーライン(前回落ち着きなしKeys);
        }
    }

    private void 落ち着きなしアンダーライン(List<RString> 前回落ち着きなしKeys) {
        if (!前回落ち着きなしKeys.isEmpty()) {
            div.getRadOchituki().setIcon(getListControlTextIcon(前回落ち着きなしKeys));
        }
    }

    private void set介護に抵抗(List<RString> 介護に抵抗Keys, List<RString> 前回介護に抵抗Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数48) {
            setKeyBy調査項目(介護に抵抗Keys, 調査項目, false, false);
            div.getTeikou().setTeikouShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数48) {
            setKeyBy調査項目(前回介護に抵抗Keys, 前回調査項目, false, false);
        }
    }

    private void 介護に抵抗画面表示(List<RString> 介護に抵抗Keys, List<RString> 前回介護に抵抗Keys, RString 認定調査前回結果表示) {
        if (介護に抵抗Keys.isEmpty()) {
            div.getBtnTeikou().setDisabled(true);
        } else {
            div.getRadTeikou().setSelectedKey(介護に抵抗Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            介護に抵抗アンダーライン(前回介護に抵抗Keys);
        }
    }

    private void 介護に抵抗アンダーライン(List<RString> 前回介護に抵抗Keys) {
        if (!前回介護に抵抗Keys.isEmpty()) {
            div.getRadTeikou().setIcon(getListControlTextIcon(前回介護に抵抗Keys));
        }
    }

    private void set大声をだす(List<RString> 大声をだすKeys, List<RString> 前回大声をだすKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数47) {
            setKeyBy調査項目(大声をだすKeys, 調査項目, false, false);
            div.getBigVoice().setBigVoiceShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数47) {
            setKeyBy調査項目(前回大声をだすKeys, 前回調査項目, false, false);
        }
    }

    private void 大声をだす画面表示(List<RString> 大声をだすKeys, List<RString> 前回大声をだすKeys, RString 認定調査前回結果表示) {
        if (大声をだすKeys.isEmpty()) {
            div.getBtnBigVoice().setDisabled(true);
        } else {
            div.getRadBigVoice().setSelectedKey(大声をだすKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            大声をだすアンダーライン(前回大声をだすKeys);
        }
    }

    private void 大声をだすアンダーライン(List<RString> 前回大声をだすKeys) {
        if (!前回大声をだすKeys.isEmpty()) {
            div.getRadBigVoice().setIcon(getListControlTextIcon(前回大声をだすKeys));
        }
    }

    private void set同じ話をする(List<RString> 同じ話をするKeys, List<RString> 前回同じ話をするKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数46) {
            setKeyBy調査項目(同じ話をするKeys, 調査項目, false, false);
            div.getOnajiHanashi().setOnajiHanashiShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数46) {
            setKeyBy調査項目(前回同じ話をするKeys, 前回調査項目, false, false);
        }
    }

    private void 同じ話をする画面表示(List<RString> 同じ話をするKeys, List<RString> 前回同じ話をするKeys, RString 認定調査前回結果表示) {
        if (同じ話をするKeys.isEmpty()) {
            div.getBtnOnajiHanashi().setDisabled(true);
        } else {
            div.getRadOnajiHanashi().setSelectedKey(同じ話をするKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            同じ話をするアンダーライン(前回同じ話をするKeys);
        }
    }

    private void 同じ話をするアンダーライン(List<RString> 前回同じ話をするKeys) {
        if (!前回同じ話をするKeys.isEmpty()) {
            div.getRadOnajiHanashi().setIcon(getListControlTextIcon(前回同じ話をするKeys));
        }
    }

    private void set昼夜逆転(List<RString> 昼夜逆転Keys, List<RString> 前回昼夜逆転Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数45) {
            setKeyBy調査項目(昼夜逆転Keys, 調査項目, false, false);
            div.getChuyaku().setChuyakuShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数45) {
            setKeyBy調査項目(前回昼夜逆転Keys, 前回調査項目, false, false);
        }
    }

    private void 昼夜逆転画面表示(List<RString> 昼夜逆転Keys, List<RString> 前回昼夜逆転Keys, RString 認定調査前回結果表示) {
        if (昼夜逆転Keys.isEmpty()) {
            div.getBtnChuyaku().setDisabled(true);
        } else {
            div.getRadChuyaku().setSelectedKey(昼夜逆転Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            昼夜逆転アンダーライン(前回昼夜逆転Keys);
        }
    }

    private void 昼夜逆転アンダーライン(List<RString> 前回昼夜逆転Keys) {
        if (!前回昼夜逆転Keys.isEmpty()) {
            div.getRadChuyaku().setIcon(getListControlTextIcon(前回昼夜逆転Keys));
        }
    }

    private void set感情が不安定(List<RString> 感情が不安定Keys, List<RString> 前回感情が不安定Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数44) {
            setKeyBy調査項目(感情が不安定Keys, 調査項目, false, false);
            div.getKanjyo().setKanjyoShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数44) {
            setKeyBy調査項目(前回感情が不安定Keys, 前回調査項目, false, false);
        }
    }

    private void 感情が不安定画面表示(List<RString> 感情が不安定Keys, List<RString> 前回感情が不安定Keys, RString 認定調査前回結果表示) {
        if (感情が不安定Keys.isEmpty()) {
            div.getBtnKanjyo().setDisabled(true);
        } else {
            div.getRadKanjyo().setSelectedKey(感情が不安定Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            感情が不安定アンダーライン(前回感情が不安定Keys);
        }
    }

    private void 感情が不安定アンダーライン(List<RString> 前回感情が不安定Keys) {
        if (!前回感情が不安定Keys.isEmpty()) {
            div.getRadKanjyo().setIcon(getListControlTextIcon(前回感情が不安定Keys));
        }
    }

    private void set作話(List<RString> 作話Keys, List<RString> 前回作話Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数43) {
            setKeyBy調査項目(作話Keys, 調査項目, false, false);
            div.getTukuriHanashi().setTukuriHanashiShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数43) {
            setKeyBy調査項目(前回作話Keys, 前回調査項目, false, false);
        }
    }

    private void 作話画面表示(List<RString> 作話Keys, List<RString> 前回作話Keys, RString 認定調査前回結果表示) {
        if (作話Keys.isEmpty()) {
            div.getBtnTukuriHanashi().setDisabled(true);
        } else {
            div.getRadTukuriHanashi().setSelectedKey(作話Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            作話アンダーライン(前回作話Keys);
        }
    }

    private void 作話アンダーライン(List<RString> 前回作話Keys) {
        if (!前回作話Keys.isEmpty()) {
            div.getRadTukuriHanashi().setIcon(getListControlTextIcon(前回作話Keys));
        }
    }

    private void set被虐的(List<RString> 被虐的Keys, List<RString> 前回被虐的Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数42) {
            setKeyBy調査項目(被虐的Keys, 調査項目, false, false);
            div.getHiryaku().setHiryakuShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数42) {
            setKeyBy調査項目(前回被虐的Keys, 前回調査項目, false, false);
        }
    }

    private void 被虐的画面表示(List<RString> 被虐的Keys, List<RString> 前回被虐的Keys, RString 認定調査前回結果表示) {
        if (被虐的Keys.isEmpty()) {
            div.getBtnHiryaku().setDisabled(true);
        } else {
            div.getRadbtnHiryaku().setSelectedKey(被虐的Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            被虐的アンダーライン(前回被虐的Keys);
        }
    }

    private void 被虐的アンダーライン(List<RString> 前回被虐的Keys) {
        if (!前回被虐的Keys.isEmpty()) {
            div.getRadbtnHiryaku().setIcon(getListControlTextIcon(前回被虐的Keys));
        }
    }

    private void setKeyBy調査項目(List<RString> keys, RString 調査項目, boolean is調査項目4がある, boolean is調査項目5がある) {
        if (調査項目1.equals(調査項目)) {
            keys.add(KEY0);
        } else if (調査項目2.equals(調査項目)) {
            keys.add(KEY1);
        } else if (調査項目3.equals(調査項目)) {
            keys.add(KEY2);
        }
        if (調査項目4.equals(調査項目) && is調査項目4がある) {
            keys.add(KEY3);
        }
        if (調査項目5.equals(調査項目) && is調査項目5がある) {
            keys.add(KEY4);
        }
    }

    private ArrayList<RString> get認定調査特記事項番号List(KihonChosaInput 認定調査基本情報) {
        ArrayList<RString> list = new ArrayList<>();
        if (認定調査基本情報 != null) {
            list.add(認定調査基本情報.get認定調査特記事項番号());
        }
        return list;
    }

    private List<ListControlTextIcon> getListControlTextIcon(List<RString> 前回Keys) {
        List<ListControlTextIcon> iconList = new ArrayList<>();
        for (RString 前回Key : 前回Keys) {
            if (KEY0.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY0, IconType.File_Ari));
            } else if (KEY1.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY1, IconType.File_Ari));
            } else if (KEY2.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY2, IconType.File_Ari));
            } else if (KEY3.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY3, IconType.File_Ari));
            } else if (KEY4.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY4, IconType.File_Ari));
            } else if (KEY5.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY5, IconType.File_Ari));
            } else if (KEY6.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY6, IconType.File_Ari));
            } else if (KEY7.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY7, IconType.File_Ari));
            } else if (KEY8.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY8, IconType.File_Ari));
            }
        }
        return iconList;
    }

    private void 第七群自立度Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        RString 障害高齢者の日常生活自立度_寝たきり度Key = div.getRadShogaiKoreisha().getSelectedKey();
        RString 認知症高齢者の日常生活自立度Key = div.getRadNinchishaJiritsudo().getSelectedKey();
        KihonChosaInput 認定調査基本情報;
        if (!認定調査基本情報リスト.isEmpty()) {
            認定調査基本情報 = 認定調査基本情報リスト.get(0);
        } else {
            認定調査基本情報 = new KihonChosaInput(Code.EMPTY, Code.EMPTY, 0, RString.EMPTY,
                    Code.EMPTY, Code.EMPTY, 0, RString.EMPTY, RString.EMPTY, 0, Code.EMPTY, RString.EMPTY);
        }
        KihonChosaInput new認定調査基本情報 = new KihonChosaInput(get日常生活自立度(認知症高齢者の日常生活自立度Key),
                get日常生活自立度(障害高齢者の日常生活自立度_寝たきり度Key), 認定調査基本情報.get調査連番(), 認定調査基本情報.get調査項目(),
                認定調査基本情報.get前回認知症高齢者自立度(), 認定調査基本情報.get前回障害高齢者自立度(), 認定調査基本情報.get前回調査連番(),
                認定調査基本情報.get前回調査項目(), 認定調査基本情報.get認定調査特記事項番号(), 認定調査基本情報.get認定調査特記事項連番(),
                認定調査基本情報.get原本マスク区分(), 認定調査基本情報.get特記事項());
        認定調査基本情報リスト.clear();
        認定調査基本情報リスト.add(new認定調査基本情報);
    }

    private Code get日常生活自立度(RString key) {
        if (key.isNullOrEmpty()) {
            return Code.EMPTY;
        } else if (KEY0.equals(key)) {
            return new Code(ShogaiNichijoSeikatsuJiritsudoCode.自立.getコード());
        } else if (KEY1.equals(key)) {
            return new Code(ShogaiNichijoSeikatsuJiritsudoCode.J1.getコード());
        } else if (KEY2.equals(key)) {
            return new Code(ShogaiNichijoSeikatsuJiritsudoCode.J2.getコード());
        } else if (KEY3.equals(key)) {
            return new Code(ShogaiNichijoSeikatsuJiritsudoCode.A1.getコード());
        } else if (KEY4.equals(key)) {
            return new Code(ShogaiNichijoSeikatsuJiritsudoCode.A2.getコード());
        } else if (KEY5.equals(key)) {
            return new Code(ShogaiNichijoSeikatsuJiritsudoCode.B1.getコード());
        } else if (KEY6.equals(key)) {
            return new Code(ShogaiNichijoSeikatsuJiritsudoCode.B2.getコード());
        } else if (KEY7.equals(key)) {
            return new Code(ShogaiNichijoSeikatsuJiritsudoCode.C1.getコード());
        } else if (KEY8.equals(key)) {
            return new Code(ShogaiNichijoSeikatsuJiritsudoCode.C2.getコード());
        }
        return Code.EMPTY;
    }

    private void 第六群特別な医療Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        List<RString> 処置内容Keys = div.getChkShochiNaiyo().getSelectedKeys();
        List<RString> 特別な対応Keys = div.getChkTokiTaiou().getSelectedKeys();
        List<Integer> 処置内容と特別な対応連番List = new ArrayList<>();
        add連番ListBy処置内容Keys(処置内容と特別な対応連番List, 処置内容Keys);
        add連番ListBy特別な対応Keys(処置内容と特別な対応連番List, 特別な対応Keys);
        checkListBoxConfirm(認定調査基本情報リスト, 処置内容と特別な対応連番List);
    }

    private void add連番ListBy処置内容Keys(List<Integer> 連番List, List<RString> 処置内容Keys) {
        if (処置内容Keys.isEmpty()) {
            return;
        }
        for (RString key : 処置内容Keys) {
            if (KEY0.equals(key)) {
                連番List.add(整数63);
            } else if (KEY1.equals(key)) {
                連番List.add(整数64);
            } else if (KEY2.equals(key)) {
                連番List.add(整数65);
            } else if (KEY3.equals(key)) {
                連番List.add(整数66);
            } else if (KEY4.equals(key)) {
                連番List.add(整数67);
            } else if (KEY5.equals(key)) {
                連番List.add(整数68);
            } else if (KEY6.equals(key)) {
                連番List.add(整数68);
            } else if (KEY7.equals(key)) {
                連番List.add(整数70);
            } else if (KEY8.equals(key)) {
                連番List.add(整数71);
            }
        }
    }

    private void add連番ListBy特別な対応Keys(List<Integer> 連番List, List<RString> 特別な対応Keys) {
        if (特別な対応Keys.isEmpty()) {
            return;
        }
        for (RString key : 特別な対応Keys) {
            if (KEY0.equals(key)) {
                連番List.add(整数72);
            } else if (KEY1.equals(key)) {
                連番List.add(整数73);
            } else if (KEY2.equals(key)) {
                連番List.add(整数74);
            }
        }
    }

    private void 第五群社会生活への適用Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        RString 薬の内服Keys = div.getRadKusuri().getSelectedKey();
        RString 金銭の管理Keys = div.getRadKingakuKanri().getSelectedKey();
        RString 日常の意思決定Keys = div.getRadIshiKetei().getSelectedKey();
        RString 集団への不適用Keys = div.getRadShudan().getSelectedKey();
        RString 買い物Keys = div.getRadKaiMono().getSelectedKey();
        RString 簡単な調理Keys = div.getRadKantanChori().getSelectedKey();
        単項Confirm(認定調査基本情報リスト, 整数57, 薬の内服Keys);
        単項Confirm(認定調査基本情報リスト, 整数58, 金銭の管理Keys);
        単項Confirm(認定調査基本情報リスト, 整数59, 日常の意思決定Keys);
        単項Confirm(認定調査基本情報リスト, 整数60, 集団への不適用Keys);
        単項Confirm(認定調査基本情報リスト, 整数61, 買い物Keys);
        単項Confirm(認定調査基本情報リスト, 整数62, 簡単な調理Keys);
    }

    private void 第四群精神_行動障害Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        RString 被虐的Keys = div.getRadbtnHiryaku().getSelectedKey();
        RString 作話Keys = div.getRadTukuriHanashi().getSelectedKey();
        RString 感情が不安定Keys = div.getRadKanjyo().getSelectedKey();
        RString 昼夜逆転Keys = div.getRadChuyaku().getSelectedKey();
        RString 同じ話をするKeys = div.getRadOnajiHanashi().getSelectedKey();
        RString 大声をだすKeys = div.getRadBigVoice().getSelectedKey();
        RString 介護に抵抗Keys = div.getRadTeikou().getSelectedKey();
        RString 落ち着きなしKeys = div.getRadOchituki().getSelectedKey();
        RString 一人で出たがるKeys = div.getRadOutLonly().getSelectedKey();
        RString 収集癖Keys = div.getRadShushu().getSelectedKey();
        RString 物や衣類を壊すKeys = div.getRadKowasu().getSelectedKey();
        RString ひどい物忘れKeys = div.getRadMonoWasure().getSelectedKey();
        RString 独り言_独り笑いKeys = div.getRadHitoriWarai().getSelectedKey();
        RString 自分勝手に行動するKeys = div.getRadKateKodo().getSelectedKey();
        RString 話がまとまらないKeys = div.getRadMatomeNai().getSelectedKey();
        単項Confirm(認定調査基本情報リスト, 整数42, 被虐的Keys);
        単項Confirm(認定調査基本情報リスト, 整数43, 作話Keys);
        単項Confirm(認定調査基本情報リスト, 整数44, 感情が不安定Keys);
        単項Confirm(認定調査基本情報リスト, 整数45, 昼夜逆転Keys);
        単項Confirm(認定調査基本情報リスト, 整数46, 同じ話をするKeys);
        単項Confirm(認定調査基本情報リスト, 整数47, 大声をだすKeys);
        単項Confirm(認定調査基本情報リスト, 整数48, 介護に抵抗Keys);
        単項Confirm(認定調査基本情報リスト, 整数49, 落ち着きなしKeys);
        単項Confirm(認定調査基本情報リスト, 整数50, 一人で出たがるKeys);
        単項Confirm(認定調査基本情報リスト, 整数51, 収集癖Keys);
        単項Confirm(認定調査基本情報リスト, 整数52, 物や衣類を壊すKeys);
        単項Confirm(認定調査基本情報リスト, 整数53, ひどい物忘れKeys);
        単項Confirm(認定調査基本情報リスト, 整数54, 独り言_独り笑いKeys);
        単項Confirm(認定調査基本情報リスト, 整数55, 自分勝手に行動するKeys);
        単項Confirm(認定調査基本情報リスト, 整数56, 話がまとまらないKeys);
    }

    private void 第三群認知機能Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        RString 意思の伝達Keys = div.getRadIshiDentatsu().getSelectedKey();
        RString 毎日の日課を理解Keys = div.getRadNikka().getSelectedKey();
        RString 生年月日や年齢を言うKeys = div.getRadInfo().getSelectedKey();
        RString 短期記憶Keys = div.getRadDankiKioku().getSelectedKey();
        RString 自分の名前を言うKeys = div.getRadNameInfo().getSelectedKey();
        RString 今の季節を理解するKeys = div.getRadKisetsu().getSelectedKey();
        RString 場所の理解Keys = div.getRadBasho().getSelectedKey();
        RString 徘徊Keys = div.getRadHaikai().getSelectedKey();
        RString 外出すると戻れないKeys = div.getRadModoru().getSelectedKey();
        単項Confirm(認定調査基本情報リスト, 整数33, 意思の伝達Keys);
        単項Confirm(認定調査基本情報リスト, 整数34, 毎日の日課を理解Keys);
        単項Confirm(認定調査基本情報リスト, 整数35, 生年月日や年齢を言うKeys);
        単項Confirm(認定調査基本情報リスト, 整数36, 短期記憶Keys);
        単項Confirm(認定調査基本情報リスト, 整数37, 自分の名前を言うKeys);
        単項Confirm(認定調査基本情報リスト, 整数38, 今の季節を理解するKeys);
        単項Confirm(認定調査基本情報リスト, 整数39, 場所の理解Keys);
        単項Confirm(認定調査基本情報リスト, 整数40, 徘徊Keys);
        単項Confirm(認定調査基本情報リスト, 整数41, 外出すると戻れないKeys);
    }

    private void 第二群生活機能Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        RString 移乗Keys = div.getRadIjyo().getSelectedKey();
        RString 移動Keys = div.getRadIdou().getSelectedKey();
        RString えん下Keys = div.getRadEnka().getSelectedKey();
        RString 食事摂取Keys = div.getRadShokuji().getSelectedKey();
        RString 排尿Keys = div.getRadHainyo().getSelectedKey();
        RString 排便Keys = div.getRadHaiben().getSelectedKey();
        RString 口腔清潔Keys = div.getRadKokou().getSelectedKey();
        RString 洗顔Keys = div.getRadSengan().getSelectedKey();
        RString 整髪Keys = div.getRadSeihatsu().getSelectedKey();
        RString 上衣の着脱Keys = div.getRadUwagi().getSelectedKey();
        RString ズボン等の着脱Keys = div.getRadZubon().getSelectedKey();
        RString 外出頻度Keys = div.getRadHindo().getSelectedKey();
        単項Confirm(認定調査基本情報リスト, 整数21, 移乗Keys);
        単項Confirm(認定調査基本情報リスト, 整数22, 移動Keys);
        単項Confirm(認定調査基本情報リスト, 整数23, えん下Keys);
        単項Confirm(認定調査基本情報リスト, 整数24, 食事摂取Keys);
        単項Confirm(認定調査基本情報リスト, 整数25, 排尿Keys);
        単項Confirm(認定調査基本情報リスト, 整数26, 排便Keys);
        単項Confirm(認定調査基本情報リスト, 整数27, 口腔清潔Keys);
        単項Confirm(認定調査基本情報リスト, 整数28, 洗顔Keys);
        単項Confirm(認定調査基本情報リスト, 整数29, 整髪Keys);
        単項Confirm(認定調査基本情報リスト, 整数30, 上衣の着脱Keys);
        単項Confirm(認定調査基本情報リスト, 整数31, ズボン等の着脱Keys);
        単項Confirm(認定調査基本情報リスト, 整数32, 外出頻度Keys);
    }

    private void 第一群身体機能Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        List<RString> 麻痺等の有無Keys = div.getChkMahi().getSelectedKeys();
        List<RString> 拘縮の有無Keys = div.getChkKoshuku().getSelectedKeys();
        RString 寝返りKey = div.getRadNeKaeri().getSelectedKey();
        RString 起き上がりKey = div.getRadOkiAgari().getSelectedKey();
        RString 座位保持Key = div.getRadZai().getSelectedKey();
        RString 両足での立位保持Key = div.getRadRyoAshi().getSelectedKey();
        RString 歩行Key = div.getRadBuko().getSelectedKey();
        RString 立ち上がりKey = div.getRadTachiAgari().getSelectedKey();
        RString 片足での立位Key = div.getRadKataAshi().getSelectedKey();
        RString 洗身Key = div.getRadSenshin().getSelectedKey();
        RString つめ切りKey = div.getRadTumeKiri().getSelectedKey();
        RString 視力Key = div.getRadShiryoku().getSelectedKey();
        RString 聴力Key = div.getRadChoryoku().getSelectedKey();
        単項Confirm(認定調査基本情報リスト, 整数10, 寝返りKey);
        単項Confirm(認定調査基本情報リスト, 整数11, 起き上がりKey);
        単項Confirm(認定調査基本情報リスト, 整数12, 座位保持Key);
        単項Confirm(認定調査基本情報リスト, 整数13, 両足での立位保持Key);
        単項Confirm(認定調査基本情報リスト, 整数14, 歩行Key);
        単項Confirm(認定調査基本情報リスト, 整数15, 立ち上がりKey);
        単項Confirm(認定調査基本情報リスト, 整数16, 片足での立位Key);
        単項Confirm(認定調査基本情報リスト, 整数17, 洗身Key);
        単項Confirm(認定調査基本情報リスト, 整数18, つめ切りKey);
        単項Confirm(認定調査基本情報リスト, 整数19, 視力Key);
        単項Confirm(認定調査基本情報リスト, 整数20, 聴力Key);
        List<Integer> 麻痺拘縮連番List = new ArrayList<>();
        add連番ListBy麻痺等の有無Keys(麻痺拘縮連番List, 麻痺等の有無Keys);
        add連番ListBy拘縮の有無Keys(麻痺拘縮連番List, 拘縮の有無Keys);
        checkListBoxConfirm(認定調査基本情報リスト, 麻痺拘縮連番List);
    }

    private void add連番ListBy麻痺等の有無Keys(List<Integer> 連番List, List<RString> 麻痺等の有無keys) {
        if (麻痺等の有無keys.isEmpty()) {
            return;
        }
        if (KEY0.equals(麻痺等の有無keys.get(0))) {
            return;
        }
        for (RString key : 麻痺等の有無keys) {
            if (KEY1.equals(key)) {
                連番List.add(1);
            } else if (KEY2.equals(key)) {
                連番List.add(2);
            } else if (KEY3.equals(key)) {
                連番List.add(整数3);
            } else if (KEY4.equals(key)) {
                連番List.add(整数4);
            } else if (KEY5.equals(key)) {
                連番List.add(整数5);
            }
        }
    }

    private void add連番ListBy拘縮の有無Keys(List<Integer> 連番List, List<RString> 拘縮の有無keys) {
        if (拘縮の有無keys.isEmpty()) {
            return;
        }
        if (KEY0.equals(拘縮の有無keys.get(0))) {
            return;
        }
        for (RString key : 拘縮の有無keys) {
            if (KEY1.equals(key)) {
                連番List.add(1);
            } else if (KEY2.equals(key)) {
                連番List.add(2);
            } else if (KEY3.equals(key)) {
                連番List.add(整数3);
            } else if (KEY4.equals(key)) {
                連番List.add(整数4);
            }
        }
    }

    private void checkListBoxConfirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト, List<Integer> 連番List) {
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            int 認定調査基本情報_連番 = 認定調査基本情報.get調査連番();
            if (((認定調査基本情報_連番 <= 整数9 && 認定調査基本情報_連番 > 1) || (認定調査基本情報_連番 >= 整数63 && 認定調査基本情報_連番 <= 整数74))) {
                if (!is認定調査基本情報_連番が連番Listに存在(連番List, 認定調査基本情報_連番)
                        && 調査項目ある.equals(認定調査基本情報.get調査項目())) {
                    KihonChosaInput new認定調査基本情報 = new KihonChosaInput(認定調査基本情報.get認知症高齢者自立度(), 認定調査基本情報.get障害高齢者自立度(),
                            認定調査基本情報.get調査連番(), 調査項目ない, 認定調査基本情報.get前回認知症高齢者自立度(),
                            認定調査基本情報.get前回障害高齢者自立度(), 認定調査基本情報.get前回調査連番(), 認定調査基本情報.get前回調査項目(),
                            認定調査基本情報.get認定調査特記事項番号(), 認定調査基本情報.get認定調査特記事項連番(), 認定調査基本情報.get原本マスク区分(),
                            認定調査基本情報.get特記事項());
                    認定調査基本情報 = new認定調査基本情報;
                } else if (is認定調査基本情報_連番が連番Listに存在(連番List, 認定調査基本情報_連番)
                        && 調査項目ない.equals(認定調査基本情報.get調査項目())) {
                    KihonChosaInput new認定調査基本情報 = new KihonChosaInput(認定調査基本情報.get認知症高齢者自立度(), 認定調査基本情報.get障害高齢者自立度(),
                            認定調査基本情報.get調査連番(), 調査項目ある, 認定調査基本情報.get前回認知症高齢者自立度(),
                            認定調査基本情報.get前回障害高齢者自立度(), 認定調査基本情報.get前回調査連番(), 認定調査基本情報.get前回調査項目(),
                            認定調査基本情報.get認定調査特記事項番号(), 認定調査基本情報.get認定調査特記事項連番(), 認定調査基本情報.get原本マスク区分(),
                            認定調査基本情報.get特記事項());
                    認定調査基本情報 = new認定調査基本情報;
                }
            }
        }
    }

    private boolean is認定調査基本情報_連番が連番Listに存在(List<Integer> 連番List, int 認定調査基本情報_連番) {
        for (int 連番 : 連番List) {
            if (連番 == 認定調査基本情報_連番) {
                return true;
            }
        }
        return false;
    }

    private void 単項Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト, int 連番, RString 単項Key) {
        if (単項Key.isNullOrEmpty()) {
            return;
        }
        boolean is連番対応認定調査基本情報なし = true;
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            if (連番 == 認定調査基本情報.get調査連番()) {
                if (!get調査項目By単項Key(単項Key).equals(認定調査基本情報.get調査項目())) {
                    KihonChosaInput new認定調査基本情報 = new KihonChosaInput(認定調査基本情報.get認知症高齢者自立度(), 認定調査基本情報.get障害高齢者自立度(),
                            認定調査基本情報.get調査連番(), get調査項目By単項Key(単項Key), 認定調査基本情報.get前回認知症高齢者自立度(),
                            認定調査基本情報.get前回障害高齢者自立度(), 認定調査基本情報.get前回調査連番(), 認定調査基本情報.get前回調査項目(),
                            認定調査基本情報.get認定調査特記事項番号(), 認定調査基本情報.get認定調査特記事項連番(), 認定調査基本情報.get原本マスク区分(),
                            認定調査基本情報.get特記事項());
                    認定調査基本情報 = new認定調査基本情報;
                }
                is連番対応認定調査基本情報なし = false;
            }
        }
        if (is連番対応認定調査基本情報なし) {
            認定調査基本情報リスト.add(new KihonChosaInput(Code.EMPTY, Code.EMPTY, 連番, get調査項目By単項Key(単項Key), Code.EMPTY, Code.EMPTY,
                    0, RString.EMPTY, RString.EMPTY, 0, Code.EMPTY, RString.EMPTY));
        }
    }

    private RString get調査項目By単項Key(RString 単項Key) {
        if (KEY0.equals(単項Key)) {
            return 調査項目1;
        } else if (KEY1.equals(単項Key)) {
            return 調査項目2;
        } else if (KEY2.equals(単項Key)) {
            return 調査項目3;
        } else if (KEY3.equals(単項Key)) {
            return 調査項目4;
        } else if (KEY4.equals(単項Key)) {
            return 調査項目5;
        }
        return RString.EMPTY;
    }

    private KihonChosaInputHandler1 getHandler1(KihonChosaInputDiv div) {
        return new KihonChosaInputHandler1(div);
    }

    /**
     * 引数定義<br/>
     *
     */
    public enum ViewStateKey {

        /**
         * 認定調査基本情報リストです。
         */
        第五群認定調査基本情報リスト,
        /**
         * 認定調査基本情報リストです。
         */
        第一群認定調査基本情報リスト,
        /**
         * 認定調査基本情報リストです。
         */
        第二群認定調査基本情報リスト,
        /**
         * 認定調査基本情報リストです。
         */
        第三群認定調査基本情報リスト,
        /**
         * 認定調査基本情報リストです。
         */
        第四群認定調査基本情報リスト,
        /**
         * 認定調査基本情報リストです。
         */
        第六群認定調査基本情報リスト,
        /**
         * 認定調査基本情報リストです。
         */
        第七群認定調査基本情報リスト;
    }

}

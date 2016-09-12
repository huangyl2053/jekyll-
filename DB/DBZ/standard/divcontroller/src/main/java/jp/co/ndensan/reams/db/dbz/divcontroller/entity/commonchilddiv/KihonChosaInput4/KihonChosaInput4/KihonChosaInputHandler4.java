/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaSpecial;
import jp.co.ndensan.reams.db.dbz.service.core.kihonchosainput.KihonChosaInputFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.IconType;
import jp.co.ndensan.reams.uz.uza.ui.binding.ListControlTextIcon;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div「認定基本調査入力」の第四群精神・行動障害の状態を変更するクラスです。
 *
 * @reamsid_L DBE-3000-093 wangjie2
 */
public class KihonChosaInputHandler4 {

    private final KihonChosaInput4Div div;
    private final RString 認定調査前回結果表示 = new RString("1");
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
    private final RString 調査項目1 = new RString("1");
    private final RString 調査項目2 = new RString("2");
    private final RString 調査項目3 = new RString("3");
    private final RString 調査項目4 = new RString("4");
    private final RString 調査項目5 = new RString("5");
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
     * @param div KihonChosaInput4Div
     */
    public KihonChosaInputHandler4(KihonChosaInput4Div div) {
        this.div = div;
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param 認定調査基本情報リスト 認定調査基本情報リスト
     * @return 認定調査基本情報リスト
     *
     */
    public ArrayList<KihonChosaInput> onClick_btnConfirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        第四群精神_行動障害Confirm(認定調査基本情報リスト);
        return 認定調査基本情報リスト;
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

    private void 単項Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト, int 連番, RString 単項Key) {
        ArrayList<KihonChosaInput> remove認定調査基本情報リスト = new ArrayList<>();
        ArrayList<KihonChosaInput> add認定調査基本情報リスト = new ArrayList<>();
        if (単項Key.isNullOrEmpty()) {
            return;
        }
        boolean is連番対応認定調査基本情報なし = true;
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            if (連番 == 認定調査基本情報.get調査連番()) {
                if (!get調査項目By単項Key(単項Key).equals(認定調査基本情報.get調査項目())) {
                    KihonChosaInput new認定調査基本情報 = new KihonChosaInput(認定調査基本情報.get申請書管理番号(),
                            認定調査基本情報.get認定調査依頼履歴番号(), 認定調査基本情報.get認知症高齢者自立度(),
                            認定調査基本情報.get障害高齢者自立度(), 認定調査基本情報.get調査連番(), get調査項目By単項Key(単項Key),
                            認定調査基本情報.get前回認知症高齢者自立度(), 認定調査基本情報.get前回障害高齢者自立度(), 認定調査基本情報.get前回調査連番(),
                            認定調査基本情報.get前回調査項目(), 認定調査基本情報.is特記事項有無());
                    remove認定調査基本情報リスト.add(認定調査基本情報);
                    add認定調査基本情報リスト.add(new認定調査基本情報);
                }
                is連番対応認定調査基本情報なし = false;
            }
        }
        if (!remove認定調査基本情報リスト.isEmpty()) {
            認定調査基本情報リスト.removeAll(remove認定調査基本情報リスト);
            認定調査基本情報リスト.addAll(add認定調査基本情報リスト);
        }
        if (is連番対応認定調査基本情報なし) {
            認定調査基本情報リスト.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, Code.EMPTY, Code.EMPTY,
                    連番, get調査項目By単項Key(単項Key), Code.EMPTY, Code.EMPTY, 0, RString.EMPTY, false));
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

    /**
     * 共有子Divの状態を初期化します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査基本情報リスト 認定調査基本情報リスト
     */
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, List<KihonChosaInput> 認定調査基本情報リスト) {
        if (申請書管理番号 != null) {
            div.getKoudoShogai().setShinseishoKanriNo(申請書管理番号.getColumnValue());
        }
        div.getKoudoShogai().setRecordNumber(認定調査依頼履歴番号);
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        RString 認定調査前回結果表示 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (!this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            div.getZenkaiHyojiTeiji().setDisplayNone(true);
        }
        List<RString> 認定調査特記情報List = get特記事項番号List(申請書管理番号);
        ArrayList<RString> 認定調査特記情報ArrayList = new ArrayList<>(認定調査特記情報List);
        div.getKoudoShogai().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(認定調査特記情報ArrayList));
        onLoad第四群精神_行動障害(認定調査基本情報リスト, 認定調査前回結果表示);
    }

    private List<RString> get特記事項番号List(ShinseishoKanriNo 申請書管理番号) {
        KihonChosaInputFinder finder = KihonChosaInputFinder.createInstance();
        List<KihonChosaSpecial> 認定調査特記情報List = finder.get認定調査特記情報(申請書管理番号);
        List<RString> 特記事項番号List = new ArrayList<>();
        for (KihonChosaSpecial 認定調査特記情報 : 認定調査特記情報List) {
            特記事項番号List.add(認定調査特記情報.get認定調査特記事項番号());
        }
        return 特記事項番号List;
    }

    private void onLoad第四群精神_行動障害(List<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
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

    private void set話がまとまらない(List<RString> 話がまとまらないKeys, List<RString> 前回話がまとまらないKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数56) {
            div.getBtnMatomeNai().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(話がまとまらないKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数56) {
            setKeyBy調査項目(前回話がまとまらないKeys, 前回調査項目, false, false);
        }
    }

    private void 話がまとまらない画面表示(List<RString> 話がまとまらないKeys, List<RString> 前回話がまとまらないKeys, RString 認定調査前回結果表示) {
        if (!話がまとまらないKeys.isEmpty()) {
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
            div.getBtnKateKodo().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(自分勝手に行動するKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数55) {
            setKeyBy調査項目(前回自分勝手に行動するKeys, 前回調査項目, false, false);
        }
    }

    private void 自分勝手に行動する画面表示(List<RString> 自分勝手に行動するKeys,
            List<RString> 前回自分勝手に行動するKeys, RString 認定調査前回結果表示) {
        if (!自分勝手に行動するKeys.isEmpty()) {
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
            div.getBtnHitoriWarai().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(独り言_独り笑いKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数54) {
            setKeyBy調査項目(前回独り言_独り笑いKeys, 前回調査項目, false, false);
        }
    }

    private void 独り言_独り笑い画面表示(List<RString> 独り言_独り笑いKeys, List<RString> 前回独り言_独り笑いKeys, RString 認定調査前回結果表示) {
        if (!独り言_独り笑いKeys.isEmpty()) {
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
            div.getBtnMonoWasure().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(ひどい物忘れKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数53) {
            setKeyBy調査項目(前回ひどい物忘れKeys, 前回調査項目, false, false);
        }
    }

    private void ひどい物忘れ画面表示(List<RString> ひどい物忘れKeys, List<RString> 前回ひどい物忘れKeys, RString 認定調査前回結果表示) {
        if (!ひどい物忘れKeys.isEmpty()) {
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
            div.getBtnKowasu().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(物や衣類を壊すKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数52) {
            setKeyBy調査項目(前回物や衣類を壊すKeys, 前回調査項目, false, false);
        }
    }

    private void 物や衣類を壊す画面表示(List<RString> 物や衣類を壊すKeys, List<RString> 前回物や衣類を壊すKeys, RString 認定調査前回結果表示) {
        if (!物や衣類を壊すKeys.isEmpty()) {
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
            div.getBtnShushu().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(収集癖Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数51) {
            setKeyBy調査項目(前回収集癖Keys, 前回調査項目, false, false);
        }
    }

    private void 収集癖画面表示(List<RString> 収集癖Keys, List<RString> 前回収集癖Keys, RString 認定調査前回結果表示) {
        if (!収集癖Keys.isEmpty()) {
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
            div.getBtnOutLonly().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(一人で出たがるKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数50) {
            setKeyBy調査項目(前回一人で出たがるKeys, 前回調査項目, false, false);
        }
    }

    private void 一人で出たがる画面表示(List<RString> 一人で出たがるKeys, List<RString> 前回一人で出たがるKeys, RString 認定調査前回結果表示) {
        if (!一人で出たがるKeys.isEmpty()) {
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
            div.getBtnOchituki().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(落ち着きなしKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数49) {
            setKeyBy調査項目(前回落ち着きなしKeys, 前回調査項目, false, false);
        }
    }

    private void 落ち着きなし画面表示(List<RString> 落ち着きなしKeys, List<RString> 前回落ち着きなしKeys, RString 認定調査前回結果表示) {
        if (!落ち着きなしKeys.isEmpty()) {
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
            div.getBtnTeikou().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(介護に抵抗Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数48) {
            setKeyBy調査項目(前回介護に抵抗Keys, 前回調査項目, false, false);
        }
    }

    private void 介護に抵抗画面表示(List<RString> 介護に抵抗Keys, List<RString> 前回介護に抵抗Keys, RString 認定調査前回結果表示) {
        if (!介護に抵抗Keys.isEmpty()) {
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
            div.getBtnBigVoice().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(大声をだすKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数47) {
            setKeyBy調査項目(前回大声をだすKeys, 前回調査項目, false, false);
        }
    }

    private void 大声をだす画面表示(List<RString> 大声をだすKeys, List<RString> 前回大声をだすKeys, RString 認定調査前回結果表示) {
        if (!大声をだすKeys.isEmpty()) {
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
            div.getBtnOnajiHanashi().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(同じ話をするKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数46) {
            setKeyBy調査項目(前回同じ話をするKeys, 前回調査項目, false, false);
        }
    }

    private void 同じ話をする画面表示(List<RString> 同じ話をするKeys, List<RString> 前回同じ話をするKeys, RString 認定調査前回結果表示) {
        if (!同じ話をするKeys.isEmpty()) {
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
            div.getBtnChuyaku().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(昼夜逆転Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数45) {
            setKeyBy調査項目(前回昼夜逆転Keys, 前回調査項目, false, false);
        }
    }

    private void 昼夜逆転画面表示(List<RString> 昼夜逆転Keys, List<RString> 前回昼夜逆転Keys, RString 認定調査前回結果表示) {
        if (!昼夜逆転Keys.isEmpty()) {
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
            div.getBtnKanjyo().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(感情が不安定Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数44) {
            setKeyBy調査項目(前回感情が不安定Keys, 前回調査項目, false, false);
        }
    }

    private void 感情が不安定画面表示(List<RString> 感情が不安定Keys, List<RString> 前回感情が不安定Keys, RString 認定調査前回結果表示) {
        if (!感情が不安定Keys.isEmpty()) {
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
            div.getBtnTukuriHanashi().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(作話Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数43) {
            setKeyBy調査項目(前回作話Keys, 前回調査項目, false, false);
        }
    }

    private void 作話画面表示(List<RString> 作話Keys, List<RString> 前回作話Keys, RString 認定調査前回結果表示) {
        if (!作話Keys.isEmpty()) {
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
            div.getBtnHiryaku().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(被虐的Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数42) {
            setKeyBy調査項目(前回被虐的Keys, 前回調査項目, false, false);
        }
    }

    private void 被虐的画面表示(List<RString> 被虐的Keys, List<RString> 前回被虐的Keys, RString 認定調査前回結果表示) {
        if (!被虐的Keys.isEmpty()) {
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

}

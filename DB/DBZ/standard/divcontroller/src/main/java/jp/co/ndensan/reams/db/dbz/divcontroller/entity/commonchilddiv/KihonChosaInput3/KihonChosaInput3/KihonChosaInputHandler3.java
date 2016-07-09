/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput3.KihonChosaInput3;

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
 * 共有子Div「認定基本調査入力」の第三群認知機能の状態を変更するクラスです。
 *
 * @reamsid_L DBE-3000-092 wangjie2
 */
public class KihonChosaInputHandler3 {

    private final KihonChosaInput3Div div;
    private final RString 認定調査前回結果表示 = new RString("1");
    private final RString 調査項目1 = new RString("1");
    private final RString 調査項目2 = new RString("2");
    private final RString 調査項目3 = new RString("3");
    private final RString 調査項目4 = new RString("4");
    private final RString 調査項目5 = new RString("5");
    private static final int 整数33 = 33;
    private static final int 整数34 = 34;
    private static final int 整数35 = 35;
    private static final int 整数36 = 36;
    private static final int 整数37 = 37;
    private static final int 整数38 = 38;
    private static final int 整数39 = 39;
    private static final int 整数40 = 40;
    private static final int 整数41 = 41;
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
     * @param div KihonChosaInput3Div
     */
    public KihonChosaInputHandler3(KihonChosaInput3Div div) {
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
        第三群認知機能Confirm(認定調査基本情報リスト);
        return 認定調査基本情報リスト;
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
            div.getNinchiKinou().setShinseishoKanriNo(申請書管理番号.getColumnValue());
        }
        div.getNinchiKinou().setRecordNumber(認定調査依頼履歴番号);
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        RString 認定調査前回結果表示 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (!this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            div.getZenkaiHyojiTeiji().setDisplayNone(true);
        }
        List<RString> 認定調査特記情報List = get特記事項番号List(申請書管理番号);
        ArrayList<RString> 認定調査特記情報ArrayList = new ArrayList<>(認定調査特記情報List);
        div.getNinchiKinou().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(認定調査特記情報ArrayList));
        onLoad第三群認知機能(認定調査基本情報リスト, 認定調査前回結果表示);
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

    private void onLoad第三群認知機能(List<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
        List<RString> 意思の伝達Keys = new ArrayList<>();
        List<RString> 前回意思の伝達Keys = new ArrayList<>();
        List<RString> 毎日の日課を理解Keys = new ArrayList<>();
        List<RString> 前回毎日の日課を理解Keys = new ArrayList<>();
        List<RString> 生年月日や年齢を言うKeys = new ArrayList<>();
        List<RString> 前回生年月日や年齢を言うKeys = new ArrayList<>();
        List<RString> 短期記憶Keys = new ArrayList<>();
        List<RString> 前回短期記憶Keys = new ArrayList<>();
        List<RString> 自分の名前を言うKeys = new ArrayList<>();
        List<RString> 前回自分の名前を言うKeys = new ArrayList<>();
        List<RString> 今の季節を理解するKeys = new ArrayList<>();
        List<RString> 前回今の季節を理解するKeys = new ArrayList<>();
        List<RString> 場所の理解Keys = new ArrayList<>();
        List<RString> 前回場所の理解Keys = new ArrayList<>();
        List<RString> 徘徊Keys = new ArrayList<>();
        List<RString> 前回徘徊Keys = new ArrayList<>();
        List<RString> 外出すると戻れないKeys = new ArrayList<>();
        List<RString> 前回外出すると戻れないKeys = new ArrayList<>();
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            set意思の伝達(意思の伝達Keys, 前回意思の伝達Keys, 認定調査基本情報);
            set毎日の日課を理解(毎日の日課を理解Keys, 前回毎日の日課を理解Keys, 認定調査基本情報);
            set生年月日や年齢を言う(生年月日や年齢を言うKeys, 前回生年月日や年齢を言うKeys, 認定調査基本情報);
            set短期記憶(短期記憶Keys, 前回短期記憶Keys, 認定調査基本情報);
            set自分の名前を言う(自分の名前を言うKeys, 前回自分の名前を言うKeys, 認定調査基本情報);
            set今の季節を理解する(今の季節を理解するKeys, 前回今の季節を理解するKeys, 認定調査基本情報);
            set場所の理解(場所の理解Keys, 前回場所の理解Keys, 認定調査基本情報);
            set徘徊(徘徊Keys, 前回徘徊Keys, 認定調査基本情報);
            set外出すると戻れない(外出すると戻れないKeys, 前回外出すると戻れないKeys, 認定調査基本情報);
        }
        意思の伝達画面表示(意思の伝達Keys, 前回意思の伝達Keys, 認定調査前回結果表示);
        毎日の日課を理解画面表示(毎日の日課を理解Keys, 前回毎日の日課を理解Keys, 認定調査前回結果表示);
        生年月日や年齢を言う画面表示(生年月日や年齢を言うKeys, 前回生年月日や年齢を言うKeys, 認定調査前回結果表示);
        短期記憶画面表示(短期記憶Keys, 前回短期記憶Keys, 認定調査前回結果表示);
        自分の名前を言う画面表示(自分の名前を言うKeys, 前回自分の名前を言うKeys, 認定調査前回結果表示);
        今の季節を理解する画面表示(今の季節を理解するKeys, 前回今の季節を理解するKeys, 認定調査前回結果表示);
        場所の理解画面表示(場所の理解Keys, 前回場所の理解Keys, 認定調査前回結果表示);
        徘徊画面表示(徘徊Keys, 前回徘徊Keys, 認定調査前回結果表示);
        外出すると戻れない画面表示(外出すると戻れないKeys, 前回外出すると戻れないKeys, 認定調査前回結果表示);
    }

    private void set外出すると戻れない(List<RString> 外出すると戻れないKeys,
            List<RString> 前回外出すると戻れないKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数41) {
            div.getBtnModoru().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(外出すると戻れないKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数41) {
            setKeyBy調査項目(前回外出すると戻れないKeys, 前回調査項目, false, false);
        }
    }

    private void 外出すると戻れない画面表示(List<RString> 外出すると戻れないKeys, List<RString> 前回外出すると戻れないKeys, RString 認定調査前回結果表示) {
        if (!外出すると戻れないKeys.isEmpty()) {
            div.getRadModoru().setSelectedKey(外出すると戻れないKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            外出すると戻れないアンダーライン(前回外出すると戻れないKeys);
        }
    }

    private void 外出すると戻れないアンダーライン(List<RString> 前回外出すると戻れないKeys) {
        if (!前回外出すると戻れないKeys.isEmpty()) {
            div.getRadModoru().setIcon(getListControlTextIcon(前回外出すると戻れないKeys));
        }
    }

    private void set徘徊(List<RString> 徘徊Keys, List<RString> 前回徘徊Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数40) {
            div.getBtnHaikai().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(徘徊Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数40) {
            setKeyBy調査項目(前回徘徊Keys, 前回調査項目, false, false);
        }
    }

    private void 徘徊画面表示(List<RString> 徘徊Keys, List<RString> 前回徘徊Keys, RString 認定調査前回結果表示) {
        if (!徘徊Keys.isEmpty()) {
            div.getRadHaikai().setSelectedKey(徘徊Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            徘徊アンダーライン(前回徘徊Keys);
        }
    }

    private void 徘徊アンダーライン(List<RString> 前回徘徊Keys) {
        if (!前回徘徊Keys.isEmpty()) {
            div.getRadHaikai().setIcon(getListControlTextIcon(前回徘徊Keys));
        }
    }

    private void set場所の理解(List<RString> 場所の理解Keys, List<RString> 前回場所の理解Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数39) {
            div.getBtnBasho().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目が2(場所の理解Keys, 調査項目);
        }
        if (前回連番 == 整数39) {
            setKeyBy調査項目が2(前回場所の理解Keys, 前回調査項目);
        }
    }

    private void 場所の理解画面表示(List<RString> 場所の理解Keys,
            List<RString> 前回場所の理解Keys, RString 認定調査前回結果表示) {
        if (!場所の理解Keys.isEmpty()) {
            div.getRadBasho().setSelectedKey(場所の理解Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            場所の理解アンダーライン(前回場所の理解Keys);
        }
    }

    private void 場所の理解アンダーライン(List<RString> 前回場所の理解Keys) {
        if (!前回場所の理解Keys.isEmpty()) {
            div.getRadBasho().setIcon(getListControlTextIcon(前回場所の理解Keys));
        }
    }

    private void set今の季節を理解する(List<RString> 今の季節を理解するKeys,
            List<RString> 前回今の季節を理解するKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数38) {
            div.getBtnKisetsu().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目が2(今の季節を理解するKeys, 調査項目);
        }
        if (前回連番 == 整数38) {
            setKeyBy調査項目が2(前回今の季節を理解するKeys, 前回調査項目);
        }
    }

    private void 今の季節を理解する画面表示(List<RString> 今の季節を理解するKeys,
            List<RString> 前回今の季節を理解するKeys, RString 認定調査前回結果表示) {
        if (!今の季節を理解するKeys.isEmpty()) {
            div.getRadKisetsu().setSelectedKey(今の季節を理解するKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            今の季節を理解するアンダーライン(前回今の季節を理解するKeys);
        }
    }

    private void 今の季節を理解するアンダーライン(List<RString> 前回今の季節を理解するKeys) {
        if (!前回今の季節を理解するKeys.isEmpty()) {
            div.getRadKisetsu().setIcon(getListControlTextIcon(前回今の季節を理解するKeys));
        }
    }

    private void set自分の名前を言う(List<RString> 自分の名前を言うKeys, List<RString> 前回自分の名前を言うKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数37) {
            div.getBtnNameInfo().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目が2(自分の名前を言うKeys, 調査項目);
        }
        if (前回連番 == 整数37) {
            setKeyBy調査項目が2(前回自分の名前を言うKeys, 前回調査項目);
        }
    }

    private void 自分の名前を言う画面表示(List<RString> 自分の名前を言うKeys, List<RString> 前回自分の名前を言うKeys, RString 認定調査前回結果表示) {
        if (!自分の名前を言うKeys.isEmpty()) {
            div.getRadNameInfo().setSelectedKey(自分の名前を言うKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            自分の名前を言うアンダーライン(前回自分の名前を言うKeys);
        }
    }

    private void 自分の名前を言うアンダーライン(List<RString> 前回自分の名前を言うKeys) {
        if (!前回自分の名前を言うKeys.isEmpty()) {
            div.getRadNameInfo().setIcon(getListControlTextIcon(前回自分の名前を言うKeys));
        }
    }

    private void set短期記憶(List<RString> 短期記憶Keys, List<RString> 前回短期記憶Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数36) {
            div.getBtnDankiKioku().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目が2(短期記憶Keys, 調査項目);
        }
        if (前回連番 == 整数36) {
            setKeyBy調査項目が2(前回短期記憶Keys, 前回調査項目);
        }
    }

    private void 短期記憶画面表示(List<RString> 短期記憶Keys, List<RString> 前回短期記憶Keys, RString 認定調査前回結果表示) {
        if (!短期記憶Keys.isEmpty()) {
            div.getRadDankiKioku().setSelectedKey(短期記憶Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            短期記憶アンダーライン(前回短期記憶Keys);
        }
    }

    private void 短期記憶アンダーライン(List<RString> 前回短期記憶Keys) {
        if (!前回短期記憶Keys.isEmpty()) {
            div.getRadDankiKioku().setIcon(getListControlTextIcon(前回短期記憶Keys));
        }
    }

    private void set生年月日や年齢を言う(List<RString> 生年月日や年齢を言うKeys,
            List<RString> 前回生年月日や年齢を言うKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数35) {
            div.getBtnInfo().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目が2(生年月日や年齢を言うKeys, 調査項目);
        }
        if (前回連番 == 整数35) {
            setKeyBy調査項目が2(前回生年月日や年齢を言うKeys, 前回調査項目);
        }
    }

    private void 生年月日や年齢を言う画面表示(List<RString> 生年月日や年齢を言うKeys,
            List<RString> 前回生年月日や年齢を言うKeys, RString 認定調査前回結果表示) {
        if (!生年月日や年齢を言うKeys.isEmpty()) {
            div.getRadInfo().setSelectedKey(生年月日や年齢を言うKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            生年月日や年齢を言うアンダーライン(前回生年月日や年齢を言うKeys);
        }
    }

    private void 生年月日や年齢を言うアンダーライン(List<RString> 前回生年月日や年齢を言うKeys) {
        if (!前回生年月日や年齢を言うKeys.isEmpty()) {
            div.getRadInfo().setIcon(getListControlTextIcon(前回生年月日や年齢を言うKeys));
        }
    }

    private void set毎日の日課を理解(List<RString> 毎日の日課を理解Keys, List<RString> 前回毎日の日課を理解Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数34) {
            div.getBtnNikka().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目が2(毎日の日課を理解Keys, 調査項目);
        }
        if (前回連番 == 整数34) {
            setKeyBy調査項目が2(前回毎日の日課を理解Keys, 前回調査項目);
        }
    }

    private void 毎日の日課を理解画面表示(List<RString> 毎日の日課を理解Keys, List<RString> 前回毎日の日課を理解Keys, RString 認定調査前回結果表示) {
        if (!毎日の日課を理解Keys.isEmpty()) {
            div.getRadNikka().setSelectedKey(毎日の日課を理解Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            毎日の日課を理解アンダーライン(前回毎日の日課を理解Keys);
        }
    }

    private void 毎日の日課を理解アンダーライン(List<RString> 前回毎日の日課を理解Keys) {
        if (!前回毎日の日課を理解Keys.isEmpty()) {
            div.getRadNikka().setIcon(getListControlTextIcon(前回毎日の日課を理解Keys));
        }
    }

    private void set意思の伝達(List<RString> 意思の伝達Keys, List<RString> 前回意思の伝達Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数33) {
            div.getBtnIshiDentatsu().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(意思の伝達Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数33) {
            setKeyBy調査項目(前回意思の伝達Keys, 前回調査項目, true, false);
        }
    }

    private void 意思の伝達画面表示(List<RString> 意思の伝達Keys, List<RString> 前回意思の伝達Keys, RString 認定調査前回結果表示) {
        if (!意思の伝達Keys.isEmpty()) {
            div.getRadIshiDentatsu().setSelectedKey(意思の伝達Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            意思の伝達アンダーライン(前回意思の伝達Keys);
        }
    }

    private void 意思の伝達アンダーライン(List<RString> 前回意思の伝達Keys) {
        if (!前回意思の伝達Keys.isEmpty()) {
            div.getRadIshiDentatsu().setIcon(getListControlTextIcon(前回意思の伝達Keys));
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

    private void setKeyBy調査項目が2(List<RString> keys, RString 調査項目) {
        if (調査項目1.equals(調査項目)) {
            keys.add(KEY0);
        } else if (調査項目2.equals(調査項目)) {
            keys.add(KEY1);
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

}

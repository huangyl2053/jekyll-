/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput5.KihonChosaInput5;

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
 * 共有子Div「認定基本調査入力」の第五群社会生活への適用の状態を変更するクラスです。
 *
 * @reamsid_L DBE-3000-094 wangjie2
 */
public class KihonChosaInputHandler5 {

    private final KihonChosaInput5Div div;
    private final RString 認定調査前回結果表示 = new RString("1");
    private static final int 整数57 = 57;
    private static final int 整数58 = 58;
    private static final int 整数59 = 59;
    private static final int 整数60 = 60;
    private static final int 整数61 = 61;
    private static final int 整数62 = 62;
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
     * @param div KihonChosaInput5Div
     */
    public KihonChosaInputHandler5(KihonChosaInput5Div div) {
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
        第五群社会生活への適用Confirm(認定調査基本情報リスト);
        return 認定調査基本情報リスト;
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
            div.getShakaiSekatsu().setShinseishoKanriNo(申請書管理番号.getColumnValue());
        }
        div.getShakaiSekatsu().setRecordNumber(認定調査依頼履歴番号);
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        RString 認定調査前回結果表示 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (!this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            div.getZenkaiHyojiTeiji().setDisplayNone(true);
        }
        List<RString> 認定調査特記情報List = get特記事項番号List(申請書管理番号);
        ArrayList<RString> 認定調査特記情報ArrayList = new ArrayList<>(認定調査特記情報List);
        div.getShakaiSekatsu().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(認定調査特記情報ArrayList));
        onLoad第五群社会生活への適用(認定調査基本情報リスト, 認定調査前回結果表示);
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

    private void onLoad第五群社会生活への適用(List<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
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

    private void set簡単な調理(List<RString> 簡単な調理Keys, List<RString> 前回簡単な調理Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        if (連番 == 整数62) {
            div.getBtnKantanChori().setDisabled(true);
            setKeyBy調査項目(簡単な調理Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数62) {
            setKeyBy調査項目(前回簡単な調理Keys, 調査項目, true, false);
        }
    }

    private void 簡単な調理画面表示(List<RString> 簡単な調理Keys, List<RString> 前回簡単な調理Keys, RString 認定調査前回結果表示) {
        if (!簡単な調理Keys.isEmpty()) {
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
            div.getBtnKaiMono().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(買い物Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数61) {
            setKeyBy調査項目(前回買い物Keys, 前回調査項目, true, false);
        }
    }

    private void 買い物画面表示(List<RString> 買い物Keys, List<RString> 前回買い物Keys, RString 認定調査前回結果表示) {
        if (!買い物Keys.isEmpty()) {
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
            div.getBtnShudan().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(集団への不適用Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数60) {
            setKeyBy調査項目(前回集団への不適用Keys, 前回調査項目, true, false);
        }
    }

    private void 集団への不適用画面表示(List<RString> 集団への不適用Keys, List<RString> 前回集団への不適用Keys, RString 認定調査前回結果表示) {
        if (!集団への不適用Keys.isEmpty()) {
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
            div.getBtnIshiKetei().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(日常の意思決定Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数59) {
            setKeyBy調査項目(前回日常の意思決定Keys, 前回調査項目, true, false);
        }
    }

    private void 日常の意思決定画面表示(List<RString> 日常の意思決定Keys, List<RString> 前回日常の意思決定Keys, RString 認定調査前回結果表示) {
        if (!日常の意思決定Keys.isEmpty()) {
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
            div.getBtnKingakuKanri().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(金銭の管理Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数58) {
            setKeyBy調査項目(前回金銭の管理Keys, 前回調査項目, false, false);
        }
    }

    private void 金銭の管理画面表示(List<RString> 金銭の管理Keys, List<RString> 前回金銭の管理Keys, RString 認定調査前回結果表示) {
        if (!金銭の管理Keys.isEmpty()) {
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
            div.getBtnKusuri().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(薬の内服Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数57) {
            setKeyBy調査項目(前回薬の内服Keys, 前回調査項目, false, false);
        }
    }

    private void 薬の内服画面表示(List<RString> 薬の内服Keys, List<RString> 前回薬の内服Keys, RString 認定調査前回結果表示) {
        if (!薬の内服Keys.isEmpty()) {
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

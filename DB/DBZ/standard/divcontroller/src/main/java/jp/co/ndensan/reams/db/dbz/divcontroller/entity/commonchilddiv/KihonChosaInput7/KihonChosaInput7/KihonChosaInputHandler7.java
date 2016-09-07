/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput7.KihonChosaInput7;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaSpecial;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
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
 * 共有子Div「認定基本調査入力」の自立度の状態を変更するクラスです。
 *
 * @reamsid_L DBE-3000-096 wangjie2
 */
public class KihonChosaInputHandler7 {

    private final KihonChosaInput7Div div;
    private final RString 認定調査前回結果表示 = new RString("1");
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
     * @param div KihonChosaInput7Div
     */
    public KihonChosaInputHandler7(KihonChosaInput7Div div) {
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
        第七群自立度Confirm(認定調査基本情報リスト);
        return 認定調査基本情報リスト;
    }

    private void 第七群自立度Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        RString 障害高齢者の日常生活自立度_寝たきり度Key = div.getRadShogaiKoreisha().getSelectedKey();
        RString 認知症高齢者の日常生活自立度Key = div.getRadNinchishaJiritsudo().getSelectedKey();
        KihonChosaInput 障害高齢者認定調査基本情報 = 認定調査基本情報リスト.get(0);
        KihonChosaInput 認知症高齢者認定調査基本情報 = 認定調査基本情報リスト.get(1);
        KihonChosaInput new障害高齢者認定調査基本情報 = new KihonChosaInput(
                障害高齢者認定調査基本情報.get申請書管理番号(),
                障害高齢者認定調査基本情報.get認定調査依頼履歴番号(),
                障害高齢者認定調査基本情報.get認知症高齢者自立度(),
                get日常生活自立度(障害高齢者の日常生活自立度_寝たきり度Key),
                障害高齢者認定調査基本情報.get調査連番(),
                障害高齢者認定調査基本情報.get調査項目(),
                障害高齢者認定調査基本情報.get前回認知症高齢者自立度(),
                障害高齢者認定調査基本情報.get前回障害高齢者自立度(),
                障害高齢者認定調査基本情報.get前回調査連番(),
                障害高齢者認定調査基本情報.get前回調査項目(),
                障害高齢者認定調査基本情報.is特記事項有無());
        KihonChosaInput new認知症高齢者認定調査基本情報 = new KihonChosaInput(
                認知症高齢者認定調査基本情報.get申請書管理番号(),
                認知症高齢者認定調査基本情報.get認定調査依頼履歴番号(),
                get日常生活自立度(認知症高齢者の日常生活自立度Key),
                認知症高齢者認定調査基本情報.get障害高齢者自立度(),
                認知症高齢者認定調査基本情報.get調査連番(),
                認知症高齢者認定調査基本情報.get調査項目(),
                認知症高齢者認定調査基本情報.get前回認知症高齢者自立度(),
                認知症高齢者認定調査基本情報.get前回障害高齢者自立度(),
                認知症高齢者認定調査基本情報.get前回調査連番(),
                認知症高齢者認定調査基本情報.get前回調査項目(),
                認知症高齢者認定調査基本情報.is特記事項有無());
        認定調査基本情報リスト.clear();
        認定調査基本情報リスト.add(new障害高齢者認定調査基本情報);
        認定調査基本情報リスト.add(new認知症高齢者認定調査基本情報);
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

    /**
     * 共有子Divの状態を初期化します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査基本情報リスト 認定調査基本情報リスト
     */
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, List<KihonChosaInput> 認定調査基本情報リスト) {
        if (申請書管理番号 != null) {
            div.getJiritsudo().setShinseishoKanriNo(申請書管理番号.getColumnValue());
        }
        div.getJiritsudo().setRecordNumber(認定調査依頼履歴番号);
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        RString 認定調査前回結果表示 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (!this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            div.getZenkaiHyojiTeiji().setDisplayNone(true);
        }
        List<RString> 認定調査特記情報List = get特記事項番号List(申請書管理番号);
        ArrayList<RString> 認定調査特記情報ArrayList = new ArrayList<>(認定調査特記情報List);
        div.getJiritsudo().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(認定調査特記情報ArrayList));
        onLoad第七群自立度(認定調査基本情報リスト, 認定調査前回結果表示);
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

    private void onLoad第七群自立度(List<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
        List<RString> 障害高齢者の日常生活自立度_寝たきり度Keys = new ArrayList<>();
        List<RString> 前回障害高齢者の日常生活自立度_寝たきり度Keys = new ArrayList<>();
        List<RString> 認知症高齢者の日常生活自立度Keys = new ArrayList<>();
        List<RString> 前回認知症高齢者の日常生活自立度Keys = new ArrayList<>();
        KihonChosaInput 障害高齢者認定調査基本情報 = 認定調査基本情報リスト.get(0);
        KihonChosaInput 認知症高齢者認定調査基本情報 = 認定調査基本情報リスト.get(1);
        div.getBtnShogaiKoreisha().setDisabled(!障害高齢者認定調査基本情報.is特記事項有無());
        div.getBtnNinchishaJiritsudo().setDisabled(!認知症高齢者認定調査基本情報.is特記事項有無());
        set障害高齢者の日常生活自立度_寝たきり度Keys(障害高齢者の日常生活自立度_寝たきり度Keys,
                前回障害高齢者の日常生活自立度_寝たきり度Keys, 障害高齢者認定調査基本情報);
        set認知症高齢者の日常生活自立度Keys(認知症高齢者の日常生活自立度Keys,
                前回認知症高齢者の日常生活自立度Keys, 認知症高齢者認定調査基本情報);
        障害高齢者の日常生活自立度_寝たきり度画面表示(障害高齢者の日常生活自立度_寝たきり度Keys,
                前回障害高齢者の日常生活自立度_寝たきり度Keys, 認定調査前回結果表示);
        認知症高齢者の日常生活自立度画面表示(認知症高齢者の日常生活自立度Keys,
                前回認知症高齢者の日常生活自立度Keys, 認定調査前回結果表示);
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
        if (!認知症高齢者の日常生活自立度Keys.isEmpty()) {
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
        if (!障害高齢者の日常生活自立度_寝たきり度Keys.isEmpty()) {
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

}

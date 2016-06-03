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
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.IconType;
import jp.co.ndensan.reams.uz.uza.ui.binding.ListControlTextIcon;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
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
     */
    public void onClick_btnConfirm() {
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第七群認定調査基本情報リスト, ArrayList.class);
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        第七群自立度Confirm(認定調査基本情報リスト);
        ViewStateHolder.put(ViewStateKey.第七群認定調査基本情報リスト, 認定調査基本情報リスト);
    }

    private void 第七群自立度Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        RString 障害高齢者の日常生活自立度_寝たきり度Key = div.getRadShogaiKoreisha().getSelectedKey();
        RString 認知症高齢者の日常生活自立度Key = div.getRadNinchishaJiritsudo().getSelectedKey();
        KihonChosaInput 障害高齢者認定調査基本情報 = 認定調査基本情報リスト.get(0);
        KihonChosaInput 認知症高齢者認定調査基本情報 = 認定調査基本情報リスト.get(1);
        KihonChosaInput new障害高齢者認定調査基本情報 = new KihonChosaInput(
                障害高齢者認定調査基本情報.get認知症高齢者自立度(),
                get日常生活自立度(障害高齢者の日常生活自立度_寝たきり度Key),
                障害高齢者認定調査基本情報.get調査連番(),
                障害高齢者認定調査基本情報.get調査項目(),
                障害高齢者認定調査基本情報.get前回認知症高齢者自立度(),
                障害高齢者認定調査基本情報.get前回障害高齢者自立度(),
                障害高齢者認定調査基本情報.get前回調査連番(),
                障害高齢者認定調査基本情報.get前回調査項目(),
                障害高齢者認定調査基本情報.get認定調査特記事項番号(),
                障害高齢者認定調査基本情報.get認定調査特記事項連番(),
                障害高齢者認定調査基本情報.get原本マスク区分(),
                障害高齢者認定調査基本情報.get特記事項(),
                障害高齢者認定調査基本情報.is特記事項有無());
        KihonChosaInput new認知症高齢者認定調査基本情報 = new KihonChosaInput(
                get日常生活自立度(認知症高齢者の日常生活自立度Key),
                認知症高齢者認定調査基本情報.get障害高齢者自立度(),
                認知症高齢者認定調査基本情報.get調査連番(),
                認知症高齢者認定調査基本情報.get調査項目(),
                認知症高齢者認定調査基本情報.get前回認知症高齢者自立度(),
                認知症高齢者認定調査基本情報.get前回障害高齢者自立度(),
                認知症高齢者認定調査基本情報.get前回調査連番(),
                認知症高齢者認定調査基本情報.get前回調査項目(),
                認知症高齢者認定調査基本情報.get認定調査特記事項番号(),
                認知症高齢者認定調査基本情報.get認定調査特記事項連番(),
                認知症高齢者認定調査基本情報.get原本マスク区分(),
                認知症高齢者認定調査基本情報.get特記事項(),
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
     */
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号) {
        if (申請書管理番号 != null) {
            div.getJiritsudo().setShinseishoKanriNo(申請書管理番号.getColumnValue());
        }
        div.getJiritsudo().setRecordNumber(認定調査依頼履歴番号);
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKey.第七群認定調査基本情報リスト, ArrayList.class);
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        RString 認定調査前回結果表示 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (!this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            div.getZenkaiHyojiTeiji().setDisplayNone(true);
        }
        onLoad第七群自立度(認定調査基本情報リスト, 認定調査前回結果表示);
    }

    private void onLoad第七群自立度(ArrayList<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
        List<RString> 障害高齢者の日常生活自立度_寝たきり度Keys = new ArrayList<>();
        List<RString> 前回障害高齢者の日常生活自立度_寝たきり度Keys = new ArrayList<>();
        List<RString> 障害高齢者特記事項番号 = new ArrayList<>();
        List<RString> 認知症高齢者の日常生活自立度Keys = new ArrayList<>();
        List<RString> 前回認知症高齢者の日常生活自立度Keys = new ArrayList<>();
        List<RString> 認知症高齢者特記事項番号 = new ArrayList<>();
        KihonChosaInput 障害高齢者認定調査基本情報 = 認定調査基本情報リスト.get(0);
        KihonChosaInput 認知症高齢者認定調査基本情報 = 認定調査基本情報リスト.get(1);
        div.getBtnShogaiKoreisha().setDisabled(!障害高齢者認定調査基本情報.is特記事項有無());
        div.getBtnNinchishaJiritsudo().setDisabled(!認知症高齢者認定調査基本情報.is特記事項有無());
        set障害高齢者の日常生活自立度_寝たきり度Keys(障害高齢者の日常生活自立度_寝たきり度Keys,
                前回障害高齢者の日常生活自立度_寝たきり度Keys, 障害高齢者認定調査基本情報, 障害高齢者特記事項番号);
        set認知症高齢者の日常生活自立度Keys(認知症高齢者の日常生活自立度Keys,
                前回認知症高齢者の日常生活自立度Keys, 認知症高齢者認定調査基本情報, 認知症高齢者特記事項番号);
        障害高齢者の日常生活自立度_寝たきり度画面表示(障害高齢者の日常生活自立度_寝たきり度Keys,
                前回障害高齢者の日常生活自立度_寝たきり度Keys, 認定調査前回結果表示, 障害高齢者特記事項番号);
        認知症高齢者の日常生活自立度画面表示(認知症高齢者の日常生活自立度Keys,
                前回認知症高齢者の日常生活自立度Keys, 認定調査前回結果表示, 認知症高齢者特記事項番号);
    }

    private void set認知症高齢者の日常生活自立度Keys(List<RString> 認知症高齢者の日常生活自立度Keys,
            List<RString> 前回認知症高齢者の日常生活自立度Keys, KihonChosaInput 認定調査基本情報, List<RString> 認知症高齢者特記事項番号) {
        RString 認知症高齢者自立度RString = 認定調査基本情報.get認知症高齢者自立度().getColumnValue();
        RString 前回認知症高齢者自立度RString = 認定調査基本情報.get前回認知症高齢者自立度().getColumnValue();
        RString 特記事項番号 = 認定調査基本情報.get認定調査特記事項番号();
        if (NinchishoNichijoSeikatsuJiritsudoCode.自立.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY0);
            認知症高齢者特記事項番号.add(特記事項番号);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅰ.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY1);
            認知症高齢者特記事項番号.add(特記事項番号);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅱa.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY2);
            認知症高齢者特記事項番号.add(特記事項番号);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅱb.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY3);
            認知症高齢者特記事項番号.add(特記事項番号);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅲa.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY4);
            認知症高齢者特記事項番号.add(特記事項番号);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅲb.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY5);
            認知症高齢者特記事項番号.add(特記事項番号);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅳ.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY6);
            認知症高齢者特記事項番号.add(特記事項番号);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.M.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY7);
            認知症高齢者特記事項番号.add(特記事項番号);
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
            List<RString> 前回認知症高齢者の日常生活自立度Keys, RString 認定調査前回結果表示, List<RString> 認知症高齢者特記事項番号) {
        if (!認知症高齢者の日常生活自立度Keys.isEmpty()) {
            div.getNinchishaJiritsudo().setNinchishaJiritsudoShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<>(認知症高齢者特記事項番号)));
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
            List<RString> 前回障害高齢者の日常生活自立度_寝たきり度Keys, KihonChosaInput 認定調査基本情報, List<RString> 障害高齢者特記事項番号) {
        RString 障害高齢者自立度RString = 認定調査基本情報.get障害高齢者自立度().getColumnValue();
        RString 前回障害高齢者自立度RString = 認定調査基本情報.get前回障害高齢者自立度().getColumnValue();
        RString 特記事項番号 = 認定調査基本情報.get認定調査特記事項番号();
        if (ShogaiNichijoSeikatsuJiritsudoCode.自立.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY0);
            障害高齢者特記事項番号.add(特記事項番号);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.J1.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY1);
            障害高齢者特記事項番号.add(特記事項番号);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.J2.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY2);
            障害高齢者特記事項番号.add(特記事項番号);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.A1.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY3);
            障害高齢者特記事項番号.add(特記事項番号);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.A2.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY4);
            障害高齢者特記事項番号.add(特記事項番号);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.B1.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY5);
            障害高齢者特記事項番号.add(特記事項番号);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.B2.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY6);
            障害高齢者特記事項番号.add(特記事項番号);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.C1.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY7);
            障害高齢者特記事項番号.add(特記事項番号);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.C2.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY8);
            障害高齢者特記事項番号.add(特記事項番号);
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
            List<RString> 前回障害高齢者の日常生活自立度_寝たきり度Keys, RString 認定調査前回結果表示, List<RString> 障害高齢者特記事項番号) {
        if (!障害高齢者の日常生活自立度_寝たきり度Keys.isEmpty()) {
            div.getShogaiKoreisha().setShogaiKoreishaShinseishoKanriNo(DataPassingConverter.serialize(new ArrayList<>(障害高齢者特記事項番号)));
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

    /**
     * 引数定義<br/>
     *
     */
    public enum ViewStateKey {

        /**
         * 認定調査基本情報リストです。
         */
        第七群認定調査基本情報リスト;
    }

}

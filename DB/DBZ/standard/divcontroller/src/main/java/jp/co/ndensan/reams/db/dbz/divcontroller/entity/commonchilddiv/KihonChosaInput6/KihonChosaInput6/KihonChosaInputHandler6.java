/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput6.KihonChosaInput6;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaSpecial;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.db.dbz.service.core.kihonchosainput.KihonChosaInputFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.IconType;
import jp.co.ndensan.reams.uz.uza.ui.binding.ListControlTextIcon;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div「認定基本調査入力」の特別な医療の状態を変更するクラスです。
 *
 * @reamsid_L DBE-3000-095 wangjie2
 */
public class KihonChosaInputHandler6 {

    private final KihonChosaInput6Div div;
    private final RString 認定調査前回結果表示 = new RString("1");
    private final RString 調査項目ある = new RString("2");
    private final RString 調査項目ない = new RString("1");
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
     * @param div KihonChosaInput6Div
     */
    public KihonChosaInputHandler6(KihonChosaInput6Div div) {
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
        第六群特別な医療Confirm(認定調査基本情報リスト);
        return 認定調査基本情報リスト;
    }

    private void 第六群特別な医療Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        List<RString> 処置内容Keys = new ArrayList();
        処置内容Keys.addAll(div.getChkTenteki().getSelectedKeys());
        処置内容Keys.addAll(div.getChkSeimyaku().getSelectedKeys());
        処置内容Keys.addAll(div.getChkTouseki().getSelectedKeys());
        処置内容Keys.addAll(div.getChkSutoma().getSelectedKeys());
        処置内容Keys.addAll(div.getChkSansou().getSelectedKeys());
        処置内容Keys.addAll(div.getChkResupireta().getSelectedKeys());
        処置内容Keys.addAll(div.getChkKikan().getSelectedKeys());
        処置内容Keys.addAll(div.getChkToutsu().getSelectedKeys());
        処置内容Keys.addAll(div.getChkKeikan().getSelectedKeys());
        List<RString> 特別な対応Keys = new ArrayList();
        特別な対応Keys.addAll(div.getChkMonita().getSelectedKeys());
        特別な対応Keys.addAll(div.getChkJyokuso().getSelectedKeys());
        特別な対応Keys.addAll(div.getChkKateru().getSelectedKeys());
        List<Integer> 処置内容と特別な対応連番List = new ArrayList<>();
        add連番ListBy処置内容Keys(処置内容と特別な対応連番List, 処置内容Keys);
        add連番ListBy特別な対応Keys(処置内容と特別な対応連番List, 特別な対応Keys);
        checkListBoxConfirm(認定調査基本情報リスト, 処置内容と特別な対応連番List);
    }

    private void checkListBoxConfirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト, List<Integer> 連番List) {
        ArrayList<KihonChosaInput> remove認定調査基本情報リスト = new ArrayList<>();
        ArrayList<KihonChosaInput> add認定調査基本情報リスト = new ArrayList<>();
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            int 認定調査基本情報_連番 = 認定調査基本情報.get調査連番();
            if ((認定調査基本情報_連番 >= 整数63 && 認定調査基本情報_連番 <= 整数74)) {
                if (!is認定調査基本情報_連番が連番Listに存在(連番List, 認定調査基本情報_連番)
                        && 調査項目ある.equals(認定調査基本情報.get調査項目())) {
                    KihonChosaInput new認定調査基本情報 = new KihonChosaInput(認定調査基本情報.get申請書管理番号(),
                            認定調査基本情報.get認定調査依頼履歴番号(), 認定調査基本情報.get認知症高齢者自立度(),
                            認定調査基本情報.get障害高齢者自立度(), 認定調査基本情報.get調査連番(), 調査項目ない,
                            認定調査基本情報.get前回認知症高齢者自立度(), 認定調査基本情報.get前回障害高齢者自立度(), 認定調査基本情報.get前回調査連番(),
                            認定調査基本情報.get前回調査項目(), 認定調査基本情報.is特記事項有無());
                    remove認定調査基本情報リスト.add(認定調査基本情報);
                    add認定調査基本情報リスト.add(new認定調査基本情報);
                } else if (is認定調査基本情報_連番が連番Listに存在(連番List, 認定調査基本情報_連番)
                        && !調査項目ある.equals(認定調査基本情報.get調査項目())) {
                    KihonChosaInput new認定調査基本情報 = new KihonChosaInput(認定調査基本情報.get申請書管理番号(),
                            認定調査基本情報.get認定調査依頼履歴番号(), 認定調査基本情報.get認知症高齢者自立度(),
                            認定調査基本情報.get障害高齢者自立度(), 認定調査基本情報.get調査連番(), 調査項目ある,
                            認定調査基本情報.get前回認知症高齢者自立度(), 認定調査基本情報.get前回障害高齢者自立度(), 認定調査基本情報.get前回調査連番(),
                            認定調査基本情報.get前回調査項目(), 認定調査基本情報.is特記事項有無());
                    remove認定調査基本情報リスト.add(認定調査基本情報);
                    add認定調査基本情報リスト.add(new認定調査基本情報);
                }
            }
        }
        if (!remove認定調査基本情報リスト.isEmpty()) {
            認定調査基本情報リスト.removeAll(remove認定調査基本情報リスト);
            認定調査基本情報リスト.addAll(add認定調査基本情報リスト);
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
                連番List.add(整数69);
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

    /**
     * 共有子Divの状態を初期化します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査基本情報リスト 認定調査基本情報リスト
     */
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, List<KihonChosaInput> 認定調査基本情報リスト) {
        if (申請書管理番号 != null) {
            div.getTokubetsuIryo().setShinseishoKanriNo(申請書管理番号.getColumnValue());
        }
        div.getTokubetsuIryo().setRecordNumber(認定調査依頼履歴番号);
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        RString 認定調査前回結果表示 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (!this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            div.getZenkaiHyojiTeiji().setDisplayNone(true);
        }
        List<RString> 認定調査特記情報List = get特記事項番号List(申請書管理番号);
        ArrayList<RString> 認定調査特記情報ArrayList = new ArrayList<>(認定調査特記情報List);
        div.getTokubetsuIryo().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(認定調査特記情報ArrayList));
        onLoad第六群特別な医療(認定調査基本情報リスト, 認定調査前回結果表示);
        setTokkiJikouDisabled(申請書管理番号, 認定調査依頼履歴番号);
    }
    
    private void setTokkiJikouDisabled(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号) {
        ArrayList<RString> tokkiJikouNoList = setTokkiJikouNoList();
        NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);
        ArrayList<RString> gaitouTokkiJikouNoList = new ArrayList<>();
        for (RString tokkiJikouNo : tokkiJikouNoList) {
            gaitouTokkiJikouNoList.add(tokkiJikouNo);
            ArrayList<NinteichosahyoTokkijiko> list = manager.get調査特記事項(申請書管理番号, Integer.parseInt(認定調査依頼履歴番号.toString()), gaitouTokkiJikouNoList);
            if (list.isEmpty()
                    || RString.isNullOrEmpty(tokkiJikouNo)) {
                setDisabled(tokkiJikouNo);
            }
            gaitouTokkiJikouNoList.clear();
        }
    }
    
    private ArrayList<RString> setTokkiJikouNoList() {
        ArrayList<RString> tokkiJikouNoList = new ArrayList<>();
        tokkiJikouNoList.add(NinteiChosaTokkiJikou.点滴の管理.get認定調査票_特記情報_認定調査特記事項番号());
        tokkiJikouNoList.add(NinteiChosaTokkiJikou.中心静脈栄養.get認定調査票_特記情報_認定調査特記事項番号());
        tokkiJikouNoList.add(NinteiChosaTokkiJikou.透析.get認定調査票_特記情報_認定調査特記事項番号());
        tokkiJikouNoList.add(NinteiChosaTokkiJikou.ストーマの処置.get認定調査票_特記情報_認定調査特記事項番号());
        tokkiJikouNoList.add(NinteiChosaTokkiJikou.酸素療法.get認定調査票_特記情報_認定調査特記事項番号());
        tokkiJikouNoList.add(NinteiChosaTokkiJikou.レスピレーター.get認定調査票_特記情報_認定調査特記事項番号());
        tokkiJikouNoList.add(NinteiChosaTokkiJikou.気管切開.get認定調査票_特記情報_認定調査特記事項番号());
        tokkiJikouNoList.add(NinteiChosaTokkiJikou.疼痛の看護.get認定調査票_特記情報_認定調査特記事項番号());
        tokkiJikouNoList.add(NinteiChosaTokkiJikou.経管栄養.get認定調査票_特記情報_認定調査特記事項番号());
        tokkiJikouNoList.add(NinteiChosaTokkiJikou.モニター測定.get認定調査票_特記情報_認定調査特記事項番号());
        tokkiJikouNoList.add(NinteiChosaTokkiJikou.じょくそうの処置.get認定調査票_特記情報_認定調査特記事項番号());
        tokkiJikouNoList.add(NinteiChosaTokkiJikou.カテーテル.get認定調査票_特記情報_認定調査特記事項番号());
        return tokkiJikouNoList;
    }
    
    private void setDisabled(RString tokkiJikouNo) {
        if(NinteiChosaTokkiJikou.点滴の管理.get認定調査票_特記情報_認定調査特記事項番号().equals(tokkiJikouNo)) {
            div.getBtnTenteki().setDisabled(true);
        } else if (NinteiChosaTokkiJikou.中心静脈栄養.get認定調査票_特記情報_認定調査特記事項番号().equals(tokkiJikouNo)) {
            div.getBtnSeimyaku().setDisabled(true);
        } else if (NinteiChosaTokkiJikou.透析.get認定調査票_特記情報_認定調査特記事項番号().equals(tokkiJikouNo)) {
            div.getBtnTouseki().setDisabled(true);
        } else if (NinteiChosaTokkiJikou.ストーマの処置.get認定調査票_特記情報_認定調査特記事項番号().equals(tokkiJikouNo)) {
            div.getBtnSutoma().setDisabled(true);
        } else if (NinteiChosaTokkiJikou.酸素療法.get認定調査票_特記情報_認定調査特記事項番号().equals(tokkiJikouNo)) {
            div.getBtnSansou().setDisabled(true);
        } else if (NinteiChosaTokkiJikou.レスピレーター.get認定調査票_特記情報_認定調査特記事項番号().equals(tokkiJikouNo)) {
            div.getBtnResupireta().setDisabled(true);
        } else if (NinteiChosaTokkiJikou.気管切開.get認定調査票_特記情報_認定調査特記事項番号().equals(tokkiJikouNo)) {
            div.getBtnKikan().setDisabled(true);
        } else if (NinteiChosaTokkiJikou.疼痛の看護.get認定調査票_特記情報_認定調査特記事項番号().equals(tokkiJikouNo)) {
            div.getBtnToutsu().setDisabled(true);
        } else if (NinteiChosaTokkiJikou.経管栄養.get認定調査票_特記情報_認定調査特記事項番号().equals(tokkiJikouNo)) {
            div.getBtnKeikan().setDisabled(true);
        } else if (NinteiChosaTokkiJikou.モニター測定.get認定調査票_特記情報_認定調査特記事項番号().equals(tokkiJikouNo)) {
            div.getBtnMonita().setDisabled(true);
        } else if (NinteiChosaTokkiJikou.じょくそうの処置.get認定調査票_特記情報_認定調査特記事項番号().equals(tokkiJikouNo)) {
            div.getBtnJyokuso().setDisabled(true);
        } else if (NinteiChosaTokkiJikou.カテーテル.get認定調査票_特記情報_認定調査特記事項番号().equals(tokkiJikouNo)) {
            div.getBtnbtnKateru().setDisabled(true);
        }
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

    private void onLoad第六群特別な医療(List<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
        List<RString> 処置内容Keys = new ArrayList<>();
        List<RString> 前回処置内容Keys = new ArrayList<>();
        List<RString> 特別な対応Keys = new ArrayList<>();
        List<RString> 前回特別な対応Keys = new ArrayList<>();
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            set特別な対応Keys(特別な対応Keys, 前回特別な対応Keys, 認定調査基本情報);
            set処置内容Keys(処置内容Keys, 前回処置内容Keys, 認定調査基本情報);
        }
        特別な対応画面表示(特別な対応Keys, 前回特別な対応Keys, 認定調査前回結果表示);
        処置内容画面表示(処置内容Keys, 前回処置内容Keys, 認定調査前回結果表示);
    }

    private void set特別な対応Keys(List<RString> 特別な対応Keys, List<RString> 前回特別な対応Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (調査項目ある.equals(調査項目)) {
            if (連番 == 整数72) {
                特別な対応Keys.add(KEY0);
            } else if (連番 == 整数73) {
                特別な対応Keys.add(KEY1);
            } else if (連番 == 整数74) {
                特別な対応Keys.add(KEY2);
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

    private void 特別な対応画面表示(List<RString> 特別な対応Keys, List<RString> 前回特別な対応Keys, RString 認定調査前回結果表示) {
        if (!特別な対応Keys.isEmpty()) {
            for (RString key : 特別な対応Keys) {
                if (KEY0.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkMonita().setSelectedItemsByKey(keys);
                } else if (KEY1.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkJyokuso().setSelectedItemsByKey(keys);
                } else if (KEY2.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkKateru().setSelectedItemsByKey(keys);
                }
            }
            if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
                特別な対応アンダーライン(前回特別な対応Keys);
            }
        }
    }

    private void 特別な対応アンダーライン(List<RString> 前回特別な対応) {
        if (!前回特別な対応.isEmpty()) {
            for (RString key : 前回特別な対応) {
                if (KEY0.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkMonita().setIcon(getListControlTextIcon(keys));
                } else if (KEY1.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkJyokuso().setIcon(getListControlTextIcon(keys));
                } else if (KEY2.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkKateru().setIcon(getListControlTextIcon(keys));
                }
            }
        }
    }

    private void set処置内容Keys(List<RString> 処置内容Keys, List<RString> 前回処置内容Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        if (調査項目ある.equals(調査項目)) {
            if (連番 == 整数63) {
                処置内容Keys.add(KEY0);
            } else if (連番 == 整数64) {
                処置内容Keys.add(KEY1);
            } else if (連番 == 整数65) {
                処置内容Keys.add(KEY2);
            } else if (連番 == 整数66) {
                処置内容Keys.add(KEY3);
            } else if (連番 == 整数67) {
                処置内容Keys.add(KEY4);
            } else if (連番 == 整数68) {
                処置内容Keys.add(KEY5);
            } else if (連番 == 整数69) {
                処置内容Keys.add(KEY6);
            } else if (連番 == 整数70) {
                処置内容Keys.add(KEY7);
            } else if (連番 == 整数71) {
                処置内容Keys.add(KEY8);
            }
        }
        set前回処置内容Keys(前回処置内容Keys, 認定調査基本情報);
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

    private void 処置内容画面表示(List<RString> 処置内容Keys, List<RString> 前回処置内容Keys, RString 認定調査前回結果表示) {
        if (!処置内容Keys.isEmpty()) {
            for (RString key : 処置内容Keys) {
                if (KEY0.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkTenteki().setSelectedItemsByKey(keys);
                } else if (KEY1.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkSeimyaku().setSelectedItemsByKey(keys);
                } else if (KEY2.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkTouseki().setSelectedItemsByKey(keys);
                } else if (KEY3.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkSutoma().setSelectedItemsByKey(keys);
                } else if (KEY4.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkSansou().setSelectedItemsByKey(keys);
                } else if (KEY5.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkResupireta().setSelectedItemsByKey(keys);
                } else if (KEY6.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkKikan().setSelectedItemsByKey(keys);
                } else if (KEY7.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkToutsu().setSelectedItemsByKey(keys);
                } else if (KEY8.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkKeikan().setSelectedItemsByKey(keys);
                }
            }
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            処置内容アンダーライン(前回処置内容Keys);
        }
    }

    private void 処置内容アンダーライン(List<RString> 前回処置内容) {
        if (!前回処置内容.isEmpty()) {
            for (RString key : 前回処置内容) {
                if (KEY0.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkTenteki().setIcon(getListControlTextIcon(keys));
                } else if (KEY1.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkSeimyaku().setIcon(getListControlTextIcon(keys));
                } else if (KEY2.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkTouseki().setIcon(getListControlTextIcon(keys));
                } else if (KEY3.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkSutoma().setIcon(getListControlTextIcon(keys));
                } else if (KEY4.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkSansou().setIcon(getListControlTextIcon(keys));
                } else if (KEY5.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkResupireta().setIcon(getListControlTextIcon(keys));
                } else if (KEY6.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkKikan().setIcon(getListControlTextIcon(keys));
                } else if (KEY7.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkToutsu().setIcon(getListControlTextIcon(keys));
                } else if (KEY8.equals(key)) {
                    ArrayList<RString> keys = new ArrayList();
                    keys.add(key);
                    div.getChkKeikan().setIcon(getListControlTextIcon(keys));
                }
            }
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

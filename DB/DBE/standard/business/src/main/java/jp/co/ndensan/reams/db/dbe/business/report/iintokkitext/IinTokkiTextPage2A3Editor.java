/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iintokkitext;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.jimutokkitext.JimuTokkiTextA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iintokkitext.IinTokkiTextA3ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用特記事項（2枚目以降）A3版のEditorです。
 *
 * @reamsid_L DBE-0150-290 lishengli
 */
public class IinTokkiTextPage2A3Editor implements IIinTokkiTextA3Editor {

    private static final RString 全面 = new RString("1");
    private static final RString 短冊 = new RString("2");
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
    private static final int INT_15 = 15;
    private static final int INT_16 = 16;
    private static final int INT_17 = 17;
    private static final int INT_18 = 18;
    private static final int INT_19 = 19;
    private static final int INT_20 = 20;
    private static final int INT_21 = 21;
    private static final int INT_22 = 22;
    private static final int INT_23 = 23;
    private static final int INT_24 = 24;
    private static final int INT_25 = 25;
    private static final int INT_26 = 26;
    private static final int INT_27 = 27;
    private static final int INT_28 = 28;
    private static final int INT_29 = 29;
    private static final int INT_30 = 30;
    private static final int INT_31 = 31;
    private static final int INT_32 = 32;
    private static final int INT_33 = 33;
    private static final int PAGE1COUNT = 15;
    private static final int PAGE2COUNT = 34;
    private static final int PAGE1連番名称COUNT = 30;
    private static final int PAGE2連番名称COUNT = 34;
    private final JimuTokkiTextA3Entity item;
    private final int index;
    private final int page;
    private final List<RString> 特記事項List;

    /**
     * インスタンスを生成します。
     *
     * @param item JimuTokkiTextA3Entity
     * @param 特記事項List List<RString>
     * @param index int
     * @param page int
     */
    protected IinTokkiTextPage2A3Editor(JimuTokkiTextA3Entity item, List<RString> 特記事項List, int index, int page) {
        this.item = item;
        this.特記事項List = 特記事項List;
        this.index = index;
        this.page = page;
    }

    @Override
    public IinTokkiTextA3ReportSource edit(IinTokkiTextA3ReportSource source) {
        return editSource(source);
    }

    private IinTokkiTextA3ReportSource editSource(IinTokkiTextA3ReportSource source) {
        source.two_hokenshaNo = item.get保険者番号();
        source.two_hihokenshaNo = item.get被保険者番号();
        source.two_hihokenshaName = item.get名前();
        source.two_sakuseiGengo = item.get審査会資料作成年号();
        source.two_sakuseiYY = item.get審査会資料作成年();
        source.two_sakuseiMM = item.get審査会資料作成月();
        source.two_sakuseiDD = item.get審査会資料作成日();
        source.two_shinseiGengo = item.get今回認定申請年号();
        source.two_shinseiYY = item.get今回認定申請年();
        source.two_shinseiMM = item.get今回認定申請月();
        source.two_shinseiDD = item.get今回認定申請日();
        source.two_chosaGengo = item.get今回認定調査実施年号();
        source.two_chosaYY = item.get今回認定調査実施年();
        source.two_chosaMM = item.get今回認定調査実施月();
        source.two_chosaDD = item.get今回認定調査実施日();
        source.two_shinsaGengo = item.get今回認定審査年号();
        source.two_shinsaYY = item.get今回認定審査年();
        source.two_shinsaMM = item.get今回認定審査月();
        source.two_shinsaDD = item.get今回認定審査日();
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.two_tokkiText1 = get特記事項_tokkiText((page - 1) * 2 - 1);
                source.two_tokkiText2 = get特記事項_tokkiText((page - 1) * 2);
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項テキスト連番_名称(source);
                source = set特記事項テキスト(source);
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.two_tokkiImg1 = get特記事項_tokkiImg((page - 1) * 2 - 1);
                source.two_tokkiImg2 = get特記事項_tokkiImg((page - 1) * 2);
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項イメージ連番_名称(source);
                source = set特記事項イメージ(source);
            }
        }
        source.layout = Layouts.必須;
        return source;
    }

    private RString get特記事項_tokkiText(int index) {
        if (index < item.get特記事項_tokkiText().size()) {
            return item.get特記事項_tokkiText().get(index);
        }
        return RString.EMPTY;
    }

    private RString get特記事項_tokkiImg(int index) {
        if (index < item.get特記事項_tokkiImg().size()) {
            return item.get特記事項_tokkiImg().get(index);
        }
        return RString.EMPTY;
    }

    private RString get特記事項テキスト_イメージ(int index) {
        if ((PAGE2COUNT * (page - 2) + PAGE1COUNT + index) < item.get特記事項_listChosa1().size()) {
            return item.get特記事項_listChosa1().get(PAGE2COUNT * (page - 2) + PAGE1COUNT + index).getテキストとイメージ();
        }
        return RString.EMPTY;
    }

    private IinTokkiTextA3ReportSource set特記事項テキスト(IinTokkiTextA3ReportSource source) {
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == 0) {
                source.two_tokkiText3 = get特記事項テキスト_イメージ(i);
            }
            if (i == 1) {
                source.two_tokkiText4 = get特記事項テキスト_イメージ(i);
            }
            if (i == 2) {
                source.two_tokkiText5 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_3) {
                source.two_tokkiText6 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_4) {
                source.two_tokkiText7 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_5) {
                source.two_tokkiText8 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_6) {
                source.two_tokkiText9 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_7) {
                source.two_tokkiText10 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_8) {
                source.two_tokkiText11 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_9) {
                source.two_tokkiText12 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_10) {
                source.two_tokkiText13 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_11) {
                source.two_tokkiText14 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_12) {
                source.two_tokkiText15 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_13) {
                source.two_tokkiText16 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_14) {
                source.two_tokkiText17 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_15) {
                source.two_tokkiText18 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_16) {
                source.two_tokkiText19 = get特記事項テキスト_イメージ(i);
            }
        }
        source = set特記事項テキスト2(source);
        return source;
    }

    private IinTokkiTextA3ReportSource set特記事項テキスト2(IinTokkiTextA3ReportSource source) {
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == INT_17) {
                source.two_tokkiText20 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_18) {
                source.two_tokkiText21 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_19) {
                source.two_tokkiText22 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_20) {
                source.two_tokkiText23 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_21) {
                source.two_tokkiText24 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_22) {
                source.two_tokkiText25 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_23) {
                source.two_tokkiText26 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_24) {
                source.two_tokkiText27 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_25) {
                source.two_tokkiText28 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_26) {
                source.two_tokkiText29 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_27) {
                source.two_tokkiText30 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_28) {
                source.two_tokkiText31 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_29) {
                source.two_tokkiText32 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_30) {
                source.two_tokkiText33 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_31) {
                source.two_tokkiText34 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_32) {
                source.two_tokkiText35 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_33) {
                source.two_tokkiText36 = get特記事項テキスト_イメージ(i);
            }
        }
        return source;
    }

    private IinTokkiTextA3ReportSource set特記事項イメージ(IinTokkiTextA3ReportSource source) {
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == 0) {
                source.two_tokkiImg3 = get特記事項テキスト_イメージ(i);
            }
            if (i == 1) {
                source.two_tokkiImg4 = get特記事項テキスト_イメージ(i);
            }
            if (i == 2) {
                source.two_tokkiImg5 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_3) {
                source.two_tokkiImg6 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_4) {
                source.two_tokkiImg7 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_5) {
                source.two_tokkiImg8 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_6) {
                source.two_tokkiImg9 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_7) {
                source.two_tokkiImg10 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_8) {
                source.two_tokkiImg11 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_9) {
                source.two_tokkiImg12 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_10) {
                source.two_tokkiImg13 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_11) {
                source.two_tokkiImg14 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_12) {
                source.two_tokkiImg15 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_13) {
                source.two_tokkiImg16 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_14) {
                source.two_tokkiImg17 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_15) {
                source.two_tokkiImg18 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_16) {
                source.two_tokkiImg19 = get特記事項テキスト_イメージ(i);
            }
        }
        source = set特記事項イメージ2(source);
        return source;
    }

    private IinTokkiTextA3ReportSource set特記事項イメージ2(IinTokkiTextA3ReportSource source) {
        for (int i = 0; i < item.get特記事項_listChosa1().size(); i++) {
            if (i == INT_17) {
                source.two_tokkiImg20 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_18) {
                source.two_tokkiImg21 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_19) {
                source.two_tokkiImg22 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_20) {
                source.two_tokkiImg23 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_21) {
                source.two_tokkiImg24 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_22) {
                source.two_tokkiImg25 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_23) {
                source.two_tokkiImg26 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_24) {
                source.two_tokkiImg27 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_25) {
                source.two_tokkiImg28 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_26) {
                source.two_tokkiImg29 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_27) {
                source.two_tokkiImg30 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_28) {
                source.two_tokkiImg31 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_29) {
                source.two_tokkiImg32 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_30) {
                source.two_tokkiImg33 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_31) {
                source.two_tokkiImg34 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_32) {
                source.two_tokkiImg35 = get特記事項テキスト_イメージ(i);
            }
            if (i == INT_33) {
                source.two_tokkiImg36 = get特記事項テキスト_イメージ(i);
            }
        }
        return source;
    }

    private IinTokkiTextA3ReportSource set特記事項テキスト連番_名称(IinTokkiTextA3ReportSource source) {
        if ((PAGE2連番名称COUNT * (page - 2) + PAGE1連番名称COUNT + index) < 特記事項List.size()) {
            source.two_listChosa2_1 = 特記事項List.get(PAGE2連番名称COUNT * (page - 2) + PAGE1連番名称COUNT + index);
        }
        if ((PAGE2連番名称COUNT * (page - 2) + PAGE2連番名称COUNT + PAGE1連番名称COUNT + index) < 特記事項List.size()) {
            source.two_listChosa3_1 = 特記事項List.get(PAGE2連番名称COUNT * (page - 2) + PAGE2連番名称COUNT + PAGE1連番名称COUNT + index);
        }
        return source;
    }

    private IinTokkiTextA3ReportSource set特記事項イメージ連番_名称(IinTokkiTextA3ReportSource source) {
        if ((PAGE2連番名称COUNT * (page - 2) + PAGE1連番名称COUNT + index) < 特記事項List.size()) {
            source.two_listChosa_1 = 特記事項List.get(PAGE2連番名称COUNT * (page - 2) + PAGE1COUNT + index);
        }
        if ((PAGE2連番名称COUNT * (page - 2) + PAGE2連番名称COUNT + PAGE1連番名称COUNT + index) < 特記事項List.size()) {
            source.two_listChosa1_1 = 特記事項List.get(PAGE2連番名称COUNT * (page - 2) + PAGE2連番名称COUNT + PAGE1COUNT + index);
        }
        return source;
    }

}

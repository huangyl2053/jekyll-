/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext2a3;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext2a3.TokkiText2A3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.tokkitext2a3.TokkiText2A3ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 特記事項（2枚目以降）A3版のEditorです。
 *
 * @reamsid_L DBE-0150-290 lishengli
 */
public class TokkiText2A3Editor implements ITokkiText2A3Editor {

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
    private final TokkiText2A3Entity item;
    private final int index;
    private final List<RString> 特記事項List1;
    private final List<RString> 特記事項List2;

    /**
     * インスタンスを生成します。
     *
     * @param item TokkiText2A3Entity
     * @param 特記事項List1 List<RString>
     * @param 特記事項List2 List<RString>
     * @param index int
     */
    protected TokkiText2A3Editor(TokkiText2A3Entity item, List<RString> 特記事項List1, List<RString> 特記事項List2, int index) {
        this.item = item;
        this.特記事項List1 = 特記事項List1;
        this.特記事項List2 = 特記事項List2;
        this.index = index;
    }

    @Override
    public TokkiText2A3ReportSource edit(TokkiText2A3ReportSource source) {
        return editSource(source);
    }

    private TokkiText2A3ReportSource editSource(TokkiText2A3ReportSource source) {
        source.hokenshaNo = item.get保険者番号();
        source.hihokenshaNo = item.get被保険者番号();
        source.hihokenshaName = item.get名前();
        source.sakuseiGengo = item.get審査会資料作成年号();
        source.sakuseiYY = item.get審査会資料作成年();
        source.sakuseiMM = item.get審査会資料作成月();
        source.sakuseiDD = item.get審査会資料作成日();
        source.shinseiGengo = item.get今回認定申請年号();
        source.shinseiYY = item.get今回認定申請年();
        source.shinseiMM = item.get今回認定申請月();
        source.shinseiDD = item.get今回認定申請日();
        source.chosaGengo = item.get今回認定調査実施年号();
        source.chosaYY = item.get今回認定調査実施年();
        source.chosaMM = item.get今回認定調査実施月();
        source.chosaDD = item.get今回認定調査実施日();
        source.shinsaGengo = item.get今回認定審査年号();
        source.shinsaYY = item.get今回認定審査年();
        source.shinsaMM = item.get今回認定審査月();
        source.shinsaDD = item.get今回認定審査日();
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.tokkiText1 = item.getTokkiText1();
                source.tokkiText2 = item.getTokkiText2();
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項テキスト連番_名称(source);
                source = set特記事項テキスト(source);
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.tokkiImg1 = item.getTokkiImg1();
                source.tokkiImg2 = item.getTokkiImg2();
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項イメージ連番_名称(source);
                source = set特記事項イメージ(source);
            }
        }
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(item.get申請書管理番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    item.get申請書管理番号());
        }
        return source;
    }

    private TokkiText2A3ReportSource set特記事項テキスト(TokkiText2A3ReportSource source) {
        for (int i = 0; i < item.getListChosa2().size(); i++) {
            if (i == 0) {
                source.tokkiText3 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == 1) {
                source.tokkiText4 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == 2) {
                source.tokkiText5 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_3) {
                source.tokkiText6 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_4) {
                source.tokkiText7 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_5) {
                source.tokkiText8 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_6) {
                source.tokkiText9 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_7) {
                source.tokkiText10 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_8) {
                source.tokkiText11 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_9) {
                source.tokkiText12 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_10) {
                source.tokkiText13 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_11) {
                source.tokkiText14 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_12) {
                source.tokkiText15 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_13) {
                source.tokkiText16 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_14) {
                source.tokkiText17 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_15) {
                source.tokkiText18 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_16) {
                source.tokkiText19 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            source = set特記事項テキスト2(source, i);
        }
        return source;
    }

    private TokkiText2A3ReportSource set特記事項テキスト2(TokkiText2A3ReportSource source, int i) {
        if (i == INT_17) {
            source.tokkiText20 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_18) {
            source.tokkiText21 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_19) {
            source.tokkiText22 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_20) {
            source.tokkiText23 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_21) {
            source.tokkiText24 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_22) {
            source.tokkiText25 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_23) {
            source.tokkiText26 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_24) {
            source.tokkiText27 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_25) {
            source.tokkiText28 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_26) {
            source.tokkiText29 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_27) {
            source.tokkiText30 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_28) {
            source.tokkiText31 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_29) {
            source.tokkiText32 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_30) {
            source.tokkiText33 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_31) {
            source.tokkiText34 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_32) {
            source.tokkiText35 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_33) {
            source.tokkiText36 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        return source;
    }

    private TokkiText2A3ReportSource set特記事項イメージ(TokkiText2A3ReportSource source) {
        for (int i = 0; i < item.getListChosa2().size(); i++) {
            if (i == 0) {
                source.tokkiImg3 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == 1) {
                source.tokkiImg4 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == 2) {
                source.tokkiImg5 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_3) {
                source.tokkiImg6 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_4) {
                source.tokkiImg7 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_5) {
                source.tokkiImg8 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_6) {
                source.tokkiImg9 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_7) {
                source.tokkiImg10 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_8) {
                source.tokkiImg11 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_9) {
                source.tokkiImg12 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_10) {
                source.tokkiImg13 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_11) {
                source.tokkiImg14 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_12) {
                source.tokkiImg15 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_13) {
                source.tokkiImg16 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_14) {
                source.tokkiImg17 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_15) {
                source.tokkiImg18 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            if (i == INT_16) {
                source.tokkiImg19 = item.getListChosa1().get(i).getテキストとイメージ();
            }
            source = set特記事項イメージ2(source, i);
        }
        return source;
    }

    private TokkiText2A3ReportSource set特記事項イメージ2(TokkiText2A3ReportSource source, int i) {
        if (i == INT_17) {
            source.tokkiImg20 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_18) {
            source.tokkiImg21 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_19) {
            source.tokkiImg22 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_20) {
            source.tokkiImg23 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_21) {
            source.tokkiImg24 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_22) {
            source.tokkiImg25 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_23) {
            source.tokkiImg26 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_24) {
            source.tokkiImg27 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_25) {
            source.tokkiImg28 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_26) {
            source.tokkiImg29 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_27) {
            source.tokkiImg30 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_28) {
            source.tokkiImg31 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_29) {
            source.tokkiImg32 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_30) {
            source.tokkiImg33 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_31) {
            source.tokkiImg34 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_32) {
            source.tokkiImg35 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        if (i == INT_33) {
            source.tokkiImg36 = item.getListChosa2().get(i).getテキストとイメージ();
        }
        return source;
    }

    private TokkiText2A3ReportSource set特記事項テキスト連番_名称(TokkiText2A3ReportSource source) {
        if (index < 特記事項List1.size()) {
            source.listChosa2_1 = 特記事項List1.get(index);
        }
        if (index < 特記事項List2.size()) {
            source.listChosa3_1 = 特記事項List2.get(index);
        }
        return source;
    }

    private TokkiText2A3ReportSource set特記事項イメージ連番_名称(TokkiText2A3ReportSource source) {
        if (index < 特記事項List1.size()) {
            source.listChosa_1 = 特記事項List1.get(index);
        }
        if (index < 特記事項List2.size()) {
            source.listChosa1_1 = 特記事項List2.get(index);
        }
        return source;
    }
}

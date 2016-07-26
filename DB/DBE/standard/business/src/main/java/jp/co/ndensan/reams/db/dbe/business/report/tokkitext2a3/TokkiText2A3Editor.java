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
                source.tokkiText3 = item.getTokkiText3();
                source.tokkiText4 = item.getTokkiText4();
                source.tokkiText5 = item.getTokkiText5();
                source.tokkiText6 = item.getTokkiText6();
                source.tokkiText7 = item.getTokkiText7();
                source.tokkiText8 = item.getTokkiText8();
                source.tokkiText9 = item.getTokkiText9();
                source.tokkiText10 = item.getTokkiText10();
                source.tokkiText11 = item.getTokkiText11();
                source.tokkiText12 = item.getTokkiText12();
                source.tokkiText13 = item.getTokkiText13();
                source.tokkiText14 = item.getTokkiText14();
                source.tokkiText15 = item.getTokkiText15();
                source.tokkiText16 = item.getTokkiText16();
                source.tokkiText17 = item.getTokkiText17();
                source.tokkiText18 = item.getTokkiText18();
                source.tokkiText19 = item.getTokkiText19();
                source.tokkiText20 = item.getTokkiText20();
                source.tokkiText21 = item.getTokkiText21();
                source.tokkiText22 = item.getTokkiText22();
                source.tokkiText23 = item.getTokkiText23();
                source.tokkiText24 = item.getTokkiText24();
                source.tokkiText25 = item.getTokkiText25();
                source.tokkiText26 = item.getTokkiText26();
                source.tokkiText27 = item.getTokkiText27();
                source.tokkiText28 = item.getTokkiText28();
                source.tokkiText29 = item.getTokkiText29();
                source.tokkiText30 = item.getTokkiText30();
                source.tokkiText31 = item.getTokkiText31();
                source.tokkiText32 = item.getTokkiText32();
                source.tokkiText33 = item.getTokkiText33();
                source.tokkiText34 = item.getTokkiText34();
                source.tokkiText35 = item.getTokkiText35();
                source.tokkiText36 = item.getTokkiText36();
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get特記事項テキスト_イメージ区分())) {
            if (全面.equals(item.get特記パターン())) {
                source.tokkiImg1 = item.getTokkiImg1();
                source.tokkiImg2 = item.getTokkiImg2();
            } else if (短冊.equals(item.get特記パターン())) {
                source = set特記事項イメージ連番_名称(source);
                source.tokkiImg3 = item.getTokkiImg3();
                source.tokkiImg4 = item.getTokkiImg4();
                source.tokkiImg5 = item.getTokkiImg5();
                source.tokkiImg6 = item.getTokkiImg6();
                source.tokkiImg7 = item.getTokkiImg7();
                source.tokkiImg8 = item.getTokkiImg8();
                source.tokkiImg9 = item.getTokkiImg9();
                source.tokkiImg10 = item.getTokkiImg10();
                source.tokkiImg11 = item.getTokkiImg11();
                source.tokkiImg12 = item.getTokkiImg12();
                source.tokkiImg13 = item.getTokkiImg13();
                source.tokkiImg14 = item.getTokkiImg14();
                source.tokkiImg15 = item.getTokkiImg15();
                source.tokkiImg16 = item.getTokkiImg16();
                source.tokkiImg17 = item.getTokkiImg17();
                source.tokkiImg18 = item.getTokkiImg18();
                source.tokkiImg19 = item.getTokkiImg19();
                source.tokkiImg20 = item.getTokkiImg20();
                source.tokkiImg21 = item.getTokkiImg21();
                source.tokkiImg22 = item.getTokkiImg22();
                source.tokkiImg23 = item.getTokkiImg23();
                source.tokkiImg24 = item.getTokkiImg24();
                source.tokkiImg25 = item.getTokkiImg25();
                source.tokkiImg26 = item.getTokkiImg26();
                source.tokkiImg27 = item.getTokkiImg27();
                source.tokkiImg28 = item.getTokkiImg28();
                source.tokkiImg29 = item.getTokkiImg29();
                source.tokkiImg30 = item.getTokkiImg30();
                source.tokkiImg31 = item.getTokkiImg31();
                source.tokkiImg32 = item.getTokkiImg32();
                source.tokkiImg33 = item.getTokkiImg33();
                source.tokkiImg34 = item.getTokkiImg34();
                source.tokkiImg35 = item.getTokkiImg35();
                source.tokkiImg36 = item.getTokkiImg36();
            }
        }
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(item.get申請書管理番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    item.get申請書管理番号());
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

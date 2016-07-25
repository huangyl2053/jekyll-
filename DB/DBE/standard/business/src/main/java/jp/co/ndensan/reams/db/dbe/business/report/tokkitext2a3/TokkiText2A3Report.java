/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext2a3;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext2a3.TokkiText2A3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.TokkiJikou;
import jp.co.ndensan.reams.db.dbe.entity.report.tokkitext2a3.TokkiText2A3ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特記事項（2枚目以降）A3版のReportです。
 *
 * @reamsid_L DBE-0150-290 lishengli
 */
public class TokkiText2A3Report extends Report<TokkiText2A3ReportSource> {

    private static final RString テキスト = new RString("1");
    private static final RString イメージ = new RString("2");
    private static final int LENGTH_34 = 34;
    private final TokkiText2A3Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 特記事項（2枚目以降）Entity
     */
    public TokkiText2A3Report(TokkiText2A3Entity entity) {
        this.entity = entity;
    }

    /**
     * 事務局用特記事項を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<TokkiText2A3ReportSource> reportSourceWriter) {
        List<RString> 特記事項List1 = new ArrayList<>();
        List<RString> 特記事項List2 = new ArrayList<>();
        if (テキスト.equals(entity.get特記事項テキスト_イメージ区分())) {
            特記事項List1 = getlistChosa2();
            特記事項List2 = getlistChosa3();
        } else if (イメージ.equals(entity.get特記事項テキスト_イメージ区分())) {
            特記事項List1 = getlistChosa();
            特記事項List2 = getlistChosa1();
        }
        for (int i = 0; i < LENGTH_34; i++) {
            ITokkiText2A3Editor editor = new TokkiText2A3Editor(entity, 特記事項List1, 特記事項List2, i);
            ITokkiText2A3Builder buildera = new TokkiText2A3Builder(editor);
            reportSourceWriter.writeLine(buildera);
        }
    }

    private List<RString> getlistChosa() {
        List<RString> listChosa1 = new ArrayList<>();
        List<TokkiJikou> 特記事項List = entity.getListChosa();
        for (int i = 0; i < 特記事項List.size(); i++) {
            listChosa1.add(特記事項List.get(i).get事項番号());
            listChosa1.add(特記事項List.get(i).get項目名称());
        }
        return listChosa1;
    }

    private List<RString> getlistChosa1() {
        List<RString> listChosa1 = new ArrayList<>();
        List<TokkiJikou> 特記事項List = entity.getListChosa1();
        for (int i = 0; i < 特記事項List.size(); i++) {
            listChosa1.add(特記事項List.get(i).get事項番号());
            listChosa1.add(特記事項List.get(i).get項目名称());
        }
        return listChosa1;
    }

    private List<RString> getlistChosa2() {
        List<RString> listChosa1 = new ArrayList<>();
        List<TokkiJikou> 特記事項List = entity.getListChosa2();
        for (int i = 0; i < 特記事項List.size(); i++) {
            listChosa1.add(特記事項List.get(i).get事項番号());
            listChosa1.add(特記事項List.get(i).get項目名称());
        }
        return listChosa1;
    }

    private List<RString> getlistChosa3() {
        List<RString> listChosa1 = new ArrayList<>();
        List<TokkiJikou> 特記事項List = entity.getListChosa3();
        for (int i = 0; i < 特記事項List.size(); i++) {
            listChosa1.add(特記事項List.get(i).get事項番号());
            listChosa1.add(特記事項List.get(i).get項目名称());
        }
        return listChosa1;
    }

}

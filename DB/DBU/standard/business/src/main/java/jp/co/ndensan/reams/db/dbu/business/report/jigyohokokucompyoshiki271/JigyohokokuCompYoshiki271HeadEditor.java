/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki271;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki271.JigyohokokuCompYoshiki271Data;
import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki271.JigyohokokuCompYoshiki271ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7-1）のHeadEditorクラスです。
 *
 * @reamsid_L DBU-5580-040　wanghuafeng
 */
public class JigyohokokuCompYoshiki271HeadEditor implements IJigyohokokuCompYoshiki271Editor {

    private final JigyohokokuCompYoshiki271Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki271Data
     */
    protected JigyohokokuCompYoshiki271HeadEditor(JigyohokokuCompYoshiki271Data data) {
        this.data = data;
    }

    @Override
    public JigyohokokuCompYoshiki271ReportSource edit(JigyohokokuCompYoshiki271ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki271ReportSource editSource(JigyohokokuCompYoshiki271ReportSource source) {
        source.printTimeStamp = data.get作成日時();
        source.shukeiKubun = data.get年報月報区分();
        source.shuukeiHani = set範囲(data.get集計年月());
        source.hokenshaNo = data.get保険者番号();
        source.hokenshaName = data.get保険者名();
        return source;
    }

    private RString set範囲(RString 集計年月) {
        RStringBuilder 範囲_SB = new RStringBuilder();
        範囲_SB.append("（");
        範囲_SB.append(集計年月);
        範囲_SB.append("分）");
        return 範囲_SB.toRString();
    }

}

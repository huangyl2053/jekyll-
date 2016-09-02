/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki1;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護事業状況報告月報・一般状況（様式1） のEditorです。
 *
 * @reamsid_L DBU-5530-040 dangjingjing
 */
public class JigyohokokuGeppoYoshiki1Editor implements IJigyohokokuGeppoYoshiki1Editor {

    private final JigyohokokuGeppoYoshiki1Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuGeppoYoshiki1Data
     */
    protected JigyohokokuGeppoYoshiki1Editor(JigyohokokuGeppoYoshiki1Data data) {
        this.data = data;
    }

    @Override
    public JigyohokokuGeppoYoshiki1ReportSource edit(JigyohokokuGeppoYoshiki1ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuGeppoYoshiki1ReportSource editSource(JigyohokokuGeppoYoshiki1ReportSource source) {
        source.shukeiKubun = data.get集計区分();
        source.printTimeStamp = data.get作成日時();
        source.shuukeiHani = set集計範囲(data);
        source.hokenshaNo = data.get保険者番号();
        source.hokenshaName = data.get保険者名();
        source.komokuHyodaiRetsu1 = data.get第1号被保険者数_項目標題列1();
        source.komokuHyodaiRetsu2 = data.get第1号被保険者数_項目標題列2();
        source.komokuHyodaiRetsu3 = data.get第1号被保険者数_項目標題列3();
        source.komokuHyodaiRetsu4 = data.get第1号被保険者数_項目標題列4();
        source.komokuHyodaiGyo1 = data.get第1号被保険者増減内訳_項目標題行1();
        source.komokuHyodaiGyo2 = data.get第1号被保険者増減内訳_項目標題行2();
        return source;
    }

    private RString set集計範囲(JigyohokokuGeppoYoshiki1Data data) {
        RStringBuilder 集計範囲 = new RStringBuilder();
        if (new RString("1").equals(data.get年報月報区分())) {
            集計範囲.append("（");
            集計範囲.append(data.get集計年月());
            集計範囲.append("分）");
        }
        if (new RString("2").equals(data.get年報月報区分())) {
            集計範囲.append("（");
            集計範囲.append(data.get集計年度());
            集計範囲.append("年度分）");
            集計範囲.append(data.get集計期間FROM());
            集計範囲.append("～");
            集計範囲.append(data.get集計期間TO());
        }
        return 集計範囲.toRString();
    }
}

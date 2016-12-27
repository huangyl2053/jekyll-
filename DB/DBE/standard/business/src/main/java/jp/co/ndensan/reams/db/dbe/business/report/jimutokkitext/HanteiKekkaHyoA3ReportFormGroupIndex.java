/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimutokkitext;

import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.ChoiceResultItem;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 判定結果票A3のFormGroupIndexを決定します。
 */
public class HanteiKekkaHyoA3ReportFormGroupIndex {

    private static final RString 全面 = new RString("1");
    private static final RString 短冊 = new RString("2");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
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

    /**
     * 判定結果票A3のFormGroupIndexを返します。
     *
     * @param サービス区分コード サービス区分コード
     * @param 特記事項テキストイメージ区分 特記事項テキストイメージ区分
     * @param 特記パターン 特記パターン
     * @return 対応するFormGroupIndex
     */
    public static int getFormGroupIndex(Code サービス区分コード, RString 特記事項テキストイメージ区分, RString 特記パターン) {
        if (isサービス区分コード_予防及び介護以外(サービス区分コード)
                && TokkijikoTextImageKubun.テキスト.getコード().equals(特記事項テキストイメージ区分)
                && 特記パターン.equals(全面)) {
            return INT_1;
        } else if (isサービス区分コード_予防及び介護以外(サービス区分コード)
                && TokkijikoTextImageKubun.テキスト.getコード().equals(特記事項テキストイメージ区分)
                && 特記パターン.equals(短冊)) {
            return INT_2;
        } else if (isサービス区分コード_予防及び介護以外(サービス区分コード)
                && TokkijikoTextImageKubun.イメージ.getコード().equals(特記事項テキストイメージ区分)
                && 特記パターン.equals(全面)) {
            return INT_3;
        } else if (isサービス区分コード_予防及び介護以外(サービス区分コード)
                && TokkijikoTextImageKubun.イメージ.getコード().equals(特記事項テキストイメージ区分)
                && 特記パターン.equals(短冊)) {
            return INT_4;
        } else if (ChoiceResultItem.ServiceKubun.予防.getCode().equals(サービス区分コード.value())
                && TokkijikoTextImageKubun.テキスト.getコード().equals(特記事項テキストイメージ区分)
                && 特記パターン.equals(全面)) {
            return INT_5;
        } else if (ChoiceResultItem.ServiceKubun.予防.getCode().equals(サービス区分コード.value())
                && TokkijikoTextImageKubun.テキスト.getコード().equals(特記事項テキストイメージ区分)
                && 特記パターン.equals(短冊)) {
            return INT_6;
        } else if (ChoiceResultItem.ServiceKubun.予防.getCode().equals(サービス区分コード.value())
                && TokkijikoTextImageKubun.イメージ.getコード().equals(特記事項テキストイメージ区分)
                && 特記パターン.equals(全面)) {
            return INT_7;
        } else if (ChoiceResultItem.ServiceKubun.予防.getCode().equals(サービス区分コード.value())
                && TokkijikoTextImageKubun.イメージ.getコード().equals(特記事項テキストイメージ区分)
                && 特記パターン.equals(短冊)) {
            return INT_8;
        } else if (ChoiceResultItem.ServiceKubun.介護.getCode().equals(サービス区分コード.value())
                && TokkijikoTextImageKubun.テキスト.getコード().equals(特記事項テキストイメージ区分)
                && 特記パターン.equals(全面)) {
            return INT_9;
        } else if (ChoiceResultItem.ServiceKubun.介護.getCode().equals(サービス区分コード.value())
                && TokkijikoTextImageKubun.テキスト.getコード().equals(特記事項テキストイメージ区分)
                && 特記パターン.equals(短冊)) {
            return INT_10;
        } else if (ChoiceResultItem.ServiceKubun.介護.getCode().equals(サービス区分コード.value())
                && TokkijikoTextImageKubun.イメージ.getコード().equals(特記事項テキストイメージ区分)
                && 特記パターン.equals(全面)) {
            return INT_11;
        } else if (ChoiceResultItem.ServiceKubun.介護.getCode().equals(サービス区分コード.value())
                && TokkijikoTextImageKubun.イメージ.getコード().equals(特記事項テキストイメージ区分)
                && 特記パターン.equals(短冊)) {
            return INT_12;
        } else {
            return INT_1;
        }
    }

    private static boolean isサービス区分コード_予防及び介護以外(Code サービス区分コード) {
        return !ChoiceResultItem.ServiceKubun.予防.getCode().equals(サービス区分コード.value())
                && !ChoiceResultItem.ServiceKubun.介護.getCode().equals(サービス区分コード.value());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払不支給決定者一覧表 償還払不支給決定者一覧表Entity
 *
 * @reamsid_L DBC-2590-040 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanFushikyuKetteiInItem {

    private final RString 印刷日時;
    private final RString ページ数;
    private final RString 国保連合会名;
    private final RString 証記載保険者番号;
    private final RString 証記載保険者名;
    private final RString 並び順１;
    private final RString 並び順２;
    private final RString 並び順３;
    private final RString 並び順４;
    private final RString 並び順５;
    private final RString 改頁１;
    private final RString 改頁２;
    private final RString 改頁３;
    private final RString 改頁４;
    private final RString 改頁５;
    private final RString 通知書番号;
    private final RString 被保険者番号;
    private final RString 被保険者氏名;
    private final RString 事業者番号;
    private final RString 事業者名;
    private final RString サービス提供年月;
    private final RString 単位数;
    private final RString 喪失事由;
    private final RString 備考１;
    private final RString 整理番号;
    private final RString 町域コード;
    private final RString 住所;
    private final RString 行政区コード;
    private final RString 行政区;
    private final RString サービス種類;
    private final RString 喪失年月日;
    private final RString 備考２;
    private final RString 更新DB無;

    /**
     * コンストラクタです。
     *
     * @param 印刷日時 印刷日時
     * @param ページ数 ページ数
     * @param 国保連合会名 国保連合会名
     * @param 証記載保険者番号 証記載保険者番号
     * @param 証記載保険者名 証記載保険者名
     * @param 並び順１ 並び順１
     * @param 並び順２ 並び順２
     * @param 並び順３ 並び順３
     * @param 並び順４ 並び順４
     * @param 並び順５ 並び順５
     * @param 改頁１ 改頁１
     * @param 改頁２ 改頁２
     * @param 改頁３ 改頁３
     * @param 改頁４ 改頁４
     * @param 改頁５ 改頁５
     * @param 通知書番号 通知書番号
     * @param 被保険者番号 被保険者番号
     * @param 被保険者氏名 被保険者氏名
     * @param 事業者番号 事業者番号
     * @param 事業者名 事業者名
     * @param サービス提供年月 サービス提供年月
     * @param 単位数 単位数
     * @param 喪失事由 喪失事由
     * @param 備考１ 備考１
     * @param 整理番号 整理番号
     * @param 町域コード 町域コード
     * @param 住所 住所
     * @param 行政区コード 行政区コード
     * @param 行政区 行政区
     * @param サービス種類 サービス種類
     * @param 喪失年月日 喪失年月日
     * @param 備考２ 備考２
     * @param 更新DB無 更新DB無
     */
    public ShokanFushikyuKetteiInItem(
            RString 印刷日時,
            RString ページ数,
            RString 国保連合会名,
            RString 証記載保険者番号,
            RString 証記載保険者名,
            RString 並び順１,
            RString 並び順２,
            RString 並び順３,
            RString 並び順４,
            RString 並び順５,
            RString 改頁１,
            RString 改頁２,
            RString 改頁３,
            RString 改頁４,
            RString 改頁５,
            RString 通知書番号,
            RString 被保険者番号,
            RString 被保険者氏名,
            RString 事業者番号,
            RString 事業者名,
            RString サービス提供年月,
            RString 単位数,
            RString 喪失事由,
            RString 備考１,
            RString 整理番号,
            RString 町域コード,
            RString 住所,
            RString 行政区コード,
            RString 行政区,
            RString サービス種類,
            RString 喪失年月日,
            RString 備考２,
            RString 更新DB無) {
        this.印刷日時 = 印刷日時;
        this.ページ数 = ページ数;
        this.国保連合会名 = 国保連合会名;
        this.証記載保険者番号 = 証記載保険者番号;
        this.証記載保険者名 = 証記載保険者名;
        this.並び順１ = 並び順１;
        this.並び順２ = 並び順２;
        this.並び順３ = 並び順３;
        this.並び順４ = 並び順４;
        this.並び順５ = 並び順５;
        this.改頁１ = 改頁１;
        this.改頁２ = 改頁２;
        this.改頁３ = 改頁３;
        this.改頁４ = 改頁４;
        this.改頁５ = 改頁５;
        this.通知書番号 = 通知書番号;
        this.被保険者番号 = 被保険者番号;
        this.被保険者氏名 = 被保険者氏名;
        this.事業者番号 = 事業者番号;
        this.事業者名 = 事業者名;
        this.サービス提供年月 = サービス提供年月;
        this.単位数 = 単位数;
        this.喪失事由 = 喪失事由;
        this.備考１ = 備考１;
        this.整理番号 = 整理番号;
        this.町域コード = 町域コード;
        this.住所 = 住所;
        this.行政区コード = 行政区コード;
        this.行政区 = 行政区;
        this.サービス種類 = サービス種類;
        this.喪失年月日 = 喪失年月日;
        this.備考２ = 備考２;
        this.更新DB無 = 更新DB無;
    }

}

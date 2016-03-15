/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤決定通知書情報取込一覧表（公費負担者分）帳票出力用Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiKohifutanshaInItem {

    private final RString 印刷日時;
    private final RString ページ数;
    private final RString 処理年月;
    private final RString 公費負担者番号;
    private final RString 公費負担者名;
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
    private final RString No;
    private final RString 取り扱い年月;
    private final RString 事業者番号;
    private final RString 事業者名;
    private final RString 公費受給者番号;
    private final RString 被保険者番号;
    private final RString 公費受給者名;
    private final RString サービ提供年月;
    private final RString サービス種類コード;
    private final RString サービス種類名;
    private final RString 申立事由コード;
    private final RString 申立事由;
    private final RString 単位数;
    private final RString 公費負担額;
    private final RString 件数タイトル;
    private final RString 単位数タイトル;
    private final RString 負担額タイトル;
    private final RString 給付費タイトル;
    private final RString サービス費タイトル;
    private final RString 食事費タイトル;
    private final RString 介護給付費の件数;
    private final RString 介護給付費の単位数;
    private final RString 介護給付費の公費負担額;
    private final RString 高額介護サービス費の件数;
    private final RString 高額介護サービス費の単位数;
    private final RString 高額介護サービス費の公費負担額;
    private final RString 特定入所者介護サービス費等の件数;
    private final RString 特定入所者介護サービス費等の単位数;
    private final RString 特定入所者介護サービス費等の公費負担額;

    /**
     * コンストラクタです。
     *
     * @param 印刷日時 印刷日時
     * @param ページ数 ページ数
     * @param 処理年月 処理年月
     * @param 公費負担者番号 公費負担者番号
     * @param 公費負担者名 公費負担者名
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
     * @param No No
     * @param 取り扱い年月 取り扱い年月
     * @param 事業者番号 事業者番号
     * @param 事業者名 事業者名
     * @param 公費受給者番号 公費受給者番号
     * @param 被保険者番号 被保険者番号
     * @param 公費受給者名 公費受給者名
     * @param サービ提供年月 サービ提供年月
     * @param サービス種類コード サービス種類コード
     * @param サービス種類名 サービス種類名
     * @param 申立事由コード 申立事由コード
     * @param 申立事由 申立事由
     * @param 単位数 単位数
     * @param 公費負担額 公費負担額
     * @param 件数タイトル 件数タイトル
     * @param 単位数タイトル 単位数タイトル
     * @param 負担額タイトル 負担額タイトル
     * @param 給付費タイトル 給付費タイトル
     * @param サービス費タイトル サービス費タイトル
     * @param 食事費タイトル 食事費タイトル
     * @param 介護給付費の件数 介護給付費の件数
     * @param 介護給付費の単位数 介護給付費の単位数
     * @param 介護給付費の公費負担額 介護給付費の公費負担額
     * @param 高額介護サービス費の件数 高額介護サービス費の件数
     * @param 高額介護サービス費の単位数 高額介護サービス費の単位数
     * @param 高額介護サービス費の公費負担額 高額介護サービス費の公費負担額
     * @param 特定入所者介護サービス費等の件数 特定入所者介護サービス費等の件数
     * @param 特定入所者介護サービス費等の単位数 特定入所者介護サービス費等の単位数
     * @param 特定入所者介護サービス費等の公費負担額 特定入所者介護サービス費等の公費負担額
     */
    public KagoKetteiKohifutanshaInItem(
            RString 印刷日時,
            RString ページ数,
            RString 処理年月,
            RString 公費負担者番号,
            RString 公費負担者名,
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
            RString No,
            RString 取り扱い年月,
            RString 事業者番号,
            RString 事業者名,
            RString 公費受給者番号,
            RString 被保険者番号,
            RString 公費受給者名,
            RString サービ提供年月,
            RString サービス種類コード,
            RString サービス種類名,
            RString 申立事由コード,
            RString 申立事由,
            RString 単位数,
            RString 公費負担額,
            RString 件数タイトル,
            RString 単位数タイトル,
            RString 負担額タイトル,
            RString 給付費タイトル,
            RString サービス費タイトル,
            RString 食事費タイトル,
            RString 介護給付費の件数,
            RString 介護給付費の単位数,
            RString 介護給付費の公費負担額,
            RString 高額介護サービス費の件数,
            RString 高額介護サービス費の単位数,
            RString 高額介護サービス費の公費負担額,
            RString 特定入所者介護サービス費等の件数,
            RString 特定入所者介護サービス費等の単位数,
            RString 特定入所者介護サービス費等の公費負担額) {
        this.印刷日時 = 印刷日時;
        this.ページ数 = ページ数;
        this.処理年月 = 処理年月;
        this.公費負担者番号 = 公費負担者番号;
        this.公費負担者名 = 公費負担者名;
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
        this.No = No;
        this.取り扱い年月 = 取り扱い年月;
        this.事業者番号 = 事業者番号;
        this.事業者名 = 事業者名;
        this.公費受給者番号 = 公費受給者番号;
        this.被保険者番号 = 被保険者番号;
        this.公費受給者名 = 公費受給者名;
        this.サービ提供年月 = サービ提供年月;
        this.サービス種類コード = サービス種類コード;
        this.サービス種類名 = サービス種類名;
        this.申立事由コード = 申立事由コード;
        this.申立事由 = 申立事由;
        this.単位数 = 単位数;
        this.公費負担額 = 公費負担額;
        this.件数タイトル = 件数タイトル;
        this.単位数タイトル = 単位数タイトル;
        this.負担額タイトル = 負担額タイトル;
        this.給付費タイトル = 給付費タイトル;
        this.サービス費タイトル = サービス費タイトル;
        this.食事費タイトル = 食事費タイトル;
        this.介護給付費の件数 = 介護給付費の件数;
        this.介護給付費の単位数 = 介護給付費の単位数;
        this.介護給付費の公費負担額 = 介護給付費の公費負担額;
        this.高額介護サービス費の件数 = 高額介護サービス費の件数;
        this.高額介護サービス費の単位数 = 高額介護サービス費の単位数;
        this.高額介護サービス費の公費負担額 = 高額介護サービス費の公費負担額;
        this.特定入所者介護サービス費等の件数 = 特定入所者介護サービス費等の件数;
        this.特定入所者介護サービス費等の単位数 = 特定入所者介護サービス費等の単位数;
        this.特定入所者介護サービス費等の公費負担額 = 特定入所者介護サービス費等の公費負担額;
    }
}

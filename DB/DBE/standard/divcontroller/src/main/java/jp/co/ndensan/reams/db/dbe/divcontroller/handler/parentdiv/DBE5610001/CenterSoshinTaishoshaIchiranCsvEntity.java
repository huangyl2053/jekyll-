/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5610001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信準備対象者一覧ファイルのCSVEntityクラスです。
 *
 * @reamsid_L DBE-1520-011 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CenterSoshinTaishoshaIchiranCsvEntity {

    @CsvField(order = 1, name = "保険者")
    private final RString 保険者;
    @CsvField(order = 2, name = "被保番号")
    private final RString 被保番号;
    @CsvField(order = 3, name = "氏名")
    private final RString 氏名;
    @CsvField(order = 4, name = "氏名カナ")
    private final RString 氏名カナ;
    @CsvField(order = 5, name = "性別")
    private final RString 性別;
    @CsvField(order = 6, name = "生年月日")
    private final RString 生年月日;
    @CsvField(order = 7, name = "認定申請日")
    private final RString 認定申請日;
    @CsvField(order = 8, name = "申請区分(申)")
    private final RString 申請区分_申;
    @CsvField(order = 9, name = "申請区分(法)")
    private final RString 申請区分_法;
    @CsvField(order = 10, name = "二次判定結果")
    private final RString 二次判定結果;
    @CsvField(order = 11, name = "認定有効期間")
    private final RString 認定有効期間;
    @CsvField(order = 12, name = "有効期間（開始）")
    private final RString 有効期間_開始;
    @CsvField(order = 13, name = "有効期間（終了）")
    private final RString 有効期間_終了;
    @CsvField(order = 14, name = "送信データ作成日")
    private final RString 送信データ作成日;

    /**
     * コンストラクタです。
     *
     * @param 保険者 保険者
     * @param 被保番号 被保番号
     * @param 氏名 氏名
     * @param 氏名カナ 氏名カナ
     * @param 性別 性別
     * @param 生年月日 生年月日
     * @param 認定申請日 認定申請日
     * @param 申請区分_申 申請区分_申
     * @param 申請区分_法 申請区分_法
     * @param 二次判定結果 二次判定結果
     * @param 認定有効期間 認定有効期間
     * @param 有効期間_開始 有効期間_開始
     * @param 有効期間_終了 有効期間_終了
     * @param 送信データ作成日 送信データ作成日
     */
    public CenterSoshinTaishoshaIchiranCsvEntity(
            RString 保険者,
            RString 被保番号,
            RString 氏名,
            RString 氏名カナ,
            RString 性別,
            RString 生年月日,
            RString 認定申請日,
            RString 申請区分_申,
            RString 申請区分_法,
            RString 二次判定結果,
            RString 認定有効期間,
            RString 有効期間_開始,
            RString 有効期間_終了,
            RString 送信データ作成日) {
        this.保険者 = 保険者;
        this.被保番号 = 被保番号;
        this.氏名 = 氏名;
        this.氏名カナ = 氏名カナ;
        this.性別 = 性別;
        this.生年月日 = 生年月日;
        this.認定申請日 = 認定申請日;
        this.申請区分_申 = 申請区分_申;
        this.申請区分_法 = 申請区分_法;
        this.二次判定結果 = 二次判定結果;
        this.認定有効期間 = 認定有効期間;
        this.有効期間_開始 = 有効期間_開始;
        this.有効期間_終了 = 有効期間_終了;
        this.送信データ作成日 = 送信データ作成日;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanrenrakuhyosofuichiran;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBC-2570-030 jianglaisheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShokanRenrakuhyoSofuIchiranCsvEntity {

    @CsvField(order = 1, name = "送付年月")
    private final RString 送付年月;
    @CsvField(order = 2, name = "作成日時")
    private final RString 作成日時;
    @CsvField(order = 3, name = "保険者番号")
    private final RString 保険者番号;
    @CsvField(order = 4, name = "保険者名")
    private final RString 保険者名;
    @CsvField(order = 5, name = "№")
    private final RString renban;
    @CsvField(order = 6, name = "整理番号")
    private final RString 整理番号;
    @CsvField(order = 7, name = "サービス提供年月")
    private final RString サービス提供年月;
    @CsvField(order = 8, name = "証記載保険者番号")
    private final RString 証記載保険者番号;
    @CsvField(order = 9, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 10, name = "被保険者氏名")
    private final RString 被保険者氏名;
    @CsvField(order = 11, name = "旧措置")
    private final RString 旧措置;
    @CsvField(order = 12, name = "要介護状態区分コード")
    private final RString 要介護状態区分コード;
    @CsvField(order = 13, name = "要介護状態区分")
    private final RString 要介護状態区分;
    @CsvField(order = 14, name = "認定有効開始年月日")
    private final RString 認定有効開始年月日;
    @CsvField(order = 15, name = "認定有効終了年月日")
    private final RString 認定有効終了年月日;
    @CsvField(order = 16, name = "保険請求額")
    private final RString 保険請求額;
    @CsvField(order = 17, name = "自己負担額")
    private final RString 自己負担額;
    @CsvField(order = 18, name = "支払合計金額")
    private final RString 支払合計金額;
    @CsvField(order = 19, name = "様式番号")
    private final RString 様式番号;
    @CsvField(order = 20, name = "備考")
    private final RString 備考;

    /**
     * コンストラクタです。
     *
     * @param 送付年月 RString
     * @param 作成日時 RString
     * @param 保険者番号 RString
     * @param 保険者名 RString
     * @param renban RString
     * @param 整理番号 RString
     * @param サービス提供年月 RString
     * @param 証記載保険者番号 RString
     * @param 被保険者番号 RString
     * @param 被保険者氏名 RString
     * @param 旧措置 RString
     * @param 要介護状態区分コード RString
     * @param 要介護状態区分 RString
     * @param 認定有効開始年月日 RString
     * @param 認定有効終了年月日 RString
     * @param 保険請求額 RString
     * @param 自己負担額 RString
     * @param 支払合計金額 RString
     * @param 様式番号 RString
     * @param 備考 RString
     */
    public ShokanRenrakuhyoSofuIchiranCsvEntity(RString 送付年月, RString 作成日時,
            RString 保険者番号, RString 保険者名,
            RString renban, RString 整理番号,
            RString サービス提供年月, RString 証記載保険者番号,
            RString 被保険者番号, RString 被保険者氏名,
            RString 旧措置, RString 要介護状態区分コード,
            RString 要介護状態区分, RString 認定有効開始年月日,
            RString 認定有効終了年月日, RString 保険請求額,
            RString 自己負担額, RString 支払合計金額,
            RString 様式番号, RString 備考) {
        this.送付年月 = 送付年月;
        this.作成日時 = 作成日時;
        this.保険者番号 = 保険者番号;
        this.保険者名 = 保険者名;
        this.renban = renban;
        this.整理番号 = 整理番号;
        this.サービス提供年月 = サービス提供年月;
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.被保険者氏名 = 被保険者氏名;
        this.旧措置 = 旧措置;
        this.要介護状態区分コード = 要介護状態区分コード;
        this.要介護状態区分 = 要介護状態区分;
        this.認定有効開始年月日 = 認定有効開始年月日;
        this.認定有効終了年月日 = 認定有効終了年月日;
        this.保険請求額 = 保険請求額;
        this.自己負担額 = 自己負担額;
        this.支払合計金額 = 支払合計金額;
        this.様式番号 = 様式番号;
        this.備考 = 備考;
    }
}

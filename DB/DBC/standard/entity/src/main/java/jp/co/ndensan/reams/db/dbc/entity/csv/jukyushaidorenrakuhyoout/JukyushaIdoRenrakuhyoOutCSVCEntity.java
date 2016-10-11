/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 共同処理用受給者異動連絡票（CSV）を定義したEntityクラスです。
 *
 * @reamsid_L DBC-2770-080 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JukyushaIdoRenrakuhyoOutCSVCEntity {

    @CsvField(order = 1, name = "レコード種別")
    private final RString レコード種別;

    @CsvField(order = 2, name = "レコード番号連")
    private final RString レコード番号連;

    @CsvField(order = 3, name = "交換情報識別番号")
    private final RString 交換情報識別番号;

    @CsvField(order = 4, name = "異動年月日")
    private final RString 異動年月日;

    @CsvField(order = 5, name = "異動区分コード")
    private final RString 異動区分コード;

    @CsvField(order = 6, name = "異動事由")
    private final RString 異動事由;

    @CsvField(order = 7, name = "証記載保険者番号")
    private final RString 証記載保険者番号;

    @CsvField(order = 8, name = "被保険者番号")
    private final RString 被保険者番号;

    @CsvField(order = 9, name = "開始年月日")
    private final RString 開始年月日;

    @CsvField(order = 10, name = "終了年月日")
    private final RString 終了年月日;

    @CsvField(order = 11, name = "一時差止区分コード")
    private final RString 一時差止区分コード;

    @CsvField(order = 12, name = "一時差止金額")
    private final Decimal 一時差止金額;

    @CsvField(order = 13, name = "ブランク")
    private final RString ブランク;

    /**
     * コンストラクタです。
     *
     * @param レコード種別 レコード種別
     * @param レコード番号連 レコード番号連
     * @param 交換情報識別番号 交換情報識別番号
     * @param 異動年月日 異動年月日
     * @param 異動区分コード 異動区分コード
     * @param 異動事由 異動事由
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 開始年月日 開始年月日
     * @param 終了年月日 終了年月日
     * @param 一時差止区分コード 一時差止区分コード
     * @param 一時差止金額 一時差止金額
     * @param ブランク ブランク
     */
    public JukyushaIdoRenrakuhyoOutCSVCEntity(
            RString レコード種別,
            RString レコード番号連,
            RString 交換情報識別番号,
            RString 異動年月日,
            RString 異動区分コード,
            RString 異動事由,
            RString 証記載保険者番号,
            RString 被保険者番号,
            RString 開始年月日,
            RString 終了年月日,
            RString 一時差止区分コード,
            Decimal 一時差止金額,
            RString ブランク
    ) {
        this.交換情報識別番号 = 交換情報識別番号;
        this.ブランク = ブランク;
        this.一時差止金額 = 一時差止金額;
        this.レコード番号連 = レコード番号連;
        this.レコード種別 = レコード種別;
        this.異動事由 = 異動事由;
        this.異動区分コード = 異動区分コード;
        this.一時差止区分コード = 一時差止区分コード;
        this.被保険者番号 = 被保険者番号;
        this.開始年月日 = 開始年月日;
        this.終了年月日 = 終了年月日;
        this.異動年月日 = 異動年月日;
        this.証記載保険者番号 = 証記載保険者番号;
    }
}

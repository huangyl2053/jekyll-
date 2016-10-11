/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
public class JukyushaIdoRenrakuhyoOutCSVBEntity {

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

    @CsvField(order = 9, name = "被保険者氏名漢字")
    private final RString 被保険者氏名漢字;

    @CsvField(order = 10, name = "郵便番号")
    private final RString 郵便番号;

    @CsvField(order = 11, name = "住所カナ")
    private final RString 住所カナ;

    @CsvField(order = 12, name = "住所漢字")
    private final RString 住所漢字;

    @CsvField(order = 13, name = "電話番号")
    private final RString 電話番号;

    @CsvField(order = 14, name = "帳票出力順序コード")
    private final RString 帳票出力順序コード;

    @CsvField(order = 15, name = "ブランク")
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
     * @param 被保険者氏名漢字 被保険者氏名漢字
     * @param 郵便番号 郵便番号
     * @param 住所カナ 住所カナ
     * @param 住所漢字 住所漢字
     * @param 電話番号 電話番号
     * @param 帳票出力順序コード 帳票出力順序コード
     * @param ブランク ブランク
     */
    public JukyushaIdoRenrakuhyoOutCSVBEntity(
            RString レコード種別,
            RString レコード番号連,
            RString 交換情報識別番号,
            RString 異動年月日,
            RString 異動区分コード,
            RString 異動事由,
            RString 証記載保険者番号,
            RString 被保険者番号,
            RString 被保険者氏名漢字,
            RString 郵便番号,
            RString 住所カナ,
            RString 住所漢字,
            RString 電話番号,
            RString 帳票出力順序コード,
            RString ブランク
    ) {
        this.交換情報識別番号 = 交換情報識別番号;
        this.住所カナ = 住所カナ;
        this.ブランク = ブランク;
        this.住所漢字 = 住所漢字;
        this.レコード番号連 = レコード番号連;
        this.レコード種別 = レコード種別;
        this.帳票出力順序コード = 帳票出力順序コード;
        this.異動事由 = 異動事由;
        this.異動区分コード = 異動区分コード;
        this.被保険者氏名漢字 = 被保険者氏名漢字;
        this.被保険者番号 = 被保険者番号;
        this.郵便番号 = 郵便番号;
        this.電話番号 = 電話番号;
        this.異動年月日 = 異動年月日;
        this.証記載保険者番号 = 証記載保険者番号;
    }
}

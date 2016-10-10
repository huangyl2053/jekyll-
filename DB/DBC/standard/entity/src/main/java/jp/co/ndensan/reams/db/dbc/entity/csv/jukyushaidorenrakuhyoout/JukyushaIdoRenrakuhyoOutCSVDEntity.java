/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
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
public class JukyushaIdoRenrakuhyoOutCSVDEntity {

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
    private final ShoKisaiHokenshaNo 証記載保険者番号;

    @CsvField(order = 8, name = "被保険者番号")
    private final HihokenshaNo 被保険者番号;

    @CsvField(order = 9, name = "世帯主被保険者番号")
    private final HihokenshaNo 世帯主被保険者番号;

    @CsvField(order = 10, name = "世帯所得区分コード")
    private final RString 世帯所得区分コード;

    @CsvField(order = 11, name = "所得区分コード")
    private final RString 所得区分コード;

    @CsvField(order = 12, name = "老齢福祉年金受給の有無")
    private final boolean 老齢福祉年金受給の有無;

    @CsvField(order = 13, name = "利用者負担第２段階")
    private final boolean 利用者負担第２段階;

    @CsvField(order = 14, name = "支給申請書出力の有無")
    private final boolean 支給申請書出力の有無;

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
     * @param 世帯主被保険者番号 世帯主被保険者番号
     * @param 世帯所得区分コード 世帯所得区分コード
     * @param 所得区分コード 所得区分コード
     * @param 老齢福祉年金受給の有無 老齢福祉年金受給の有無
     * @param 利用者負担第２段階 利用者負担第２段階
     * @param 支給申請書出力の有無 支給申請書出力の有無
     * @param ブランク ブランク
     */
    public JukyushaIdoRenrakuhyoOutCSVDEntity(
            RString レコード種別,
            RString レコード番号連,
            RString 交換情報識別番号,
            RString 異動年月日,
            RString 異動区分コード,
            RString 異動事由,
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            HihokenshaNo 世帯主被保険者番号,
            RString 世帯所得区分コード,
            RString 所得区分コード,
            boolean 老齢福祉年金受給の有無,
            boolean 利用者負担第２段階,
            boolean 支給申請書出力の有無,
            RString ブランク
    ) {
        this.交換情報識別番号 = 交換情報識別番号;
        this.支給申請書出力の有無 = 支給申請書出力の有無;
        this.ブランク = ブランク;
        this.利用者負担第２段階 = 利用者負担第２段階;
        this.レコード番号連 = レコード番号連;
        this.レコード種別 = レコード種別;
        this.老齢福祉年金受給の有無 = 老齢福祉年金受給の有無;
        this.異動事由 = 異動事由;
        this.異動区分コード = 異動区分コード;
        this.世帯所得区分コード = 世帯所得区分コード;
        this.被保険者番号 = 被保険者番号;
        this.所得区分コード = 所得区分コード;
        this.世帯主被保険者番号 = 世帯主被保険者番号;
        this.異動年月日 = 異動年月日;
        this.証記載保険者番号 = 証記載保険者番号;
    }
}

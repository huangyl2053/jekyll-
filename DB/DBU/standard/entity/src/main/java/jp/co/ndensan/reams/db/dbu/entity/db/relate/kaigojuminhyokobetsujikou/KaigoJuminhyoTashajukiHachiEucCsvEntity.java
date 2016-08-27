/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsujikou;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBU-0350-020 lijia
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class KaigoJuminhyoTashajukiHachiEucCsvEntity implements IKaigoJuminhyoEucCsvEntity {

    @CsvField(order = 10, name = "市町村コード")
    private final RString 市町村コード;
    @CsvField(order = 20, name = "識別ＩＤ")
    private final RString 識別ＩＤ;
    @CsvField(order = 30, name = "タイムスタンプ")
    private final RString タイムスタンプ;
    @CsvField(order = 40, name = "最終レコード区分")
    private final RString 最終レコード区分;
    @CsvField(order = 50, name = "連番")
    private final RString 連番;
    @CsvField(order = 60, name = "ＦＩＬＬＥＲ1")
    private final RString ＦＩＬＬＥＲ1;
    @CsvField(order = 70, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 80, name = "識別コード")
    private final RString 識別コード;
    @CsvField(order = 90, name = "資格取得日")
    private final FlexibleDate 資格取得日;
    @CsvField(order = 100, name = "資格喪失日")
    private final FlexibleDate 資格喪失日;
    @CsvField(order = 110, name = "受給認定年月日")
    private final FlexibleDate 受給認定年月日;
    @CsvField(order = 120, name = "受給認定取消年月日")
    private final FlexibleDate 受給認定取消年月日;
    @CsvField(order = 130, name = "資格区分")
    private final RString 資格区分;
    @CsvField(order = 140, name = "受給者区分")
    private final RString 受給者区分;
    @CsvField(order = 150, name = "更新日時")
    private final RString 更新日時;
    @CsvField(order = 160, name = "ＦＩＬＬＥＲ2")
    private final RString ＦＩＬＬＥＲ2;

    /**
     * コンストラクタ
     *
     * @param 市町村コード RString
     * @param 識別ＩＤ RString
     * @param タイムスタンプ RString
     * @param 最終レコード区分 RString
     * @param 連番 RString
     * @param ＦＩＬＬＥＲ1 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード RString
     * @param 資格取得日 FlexibleDate
     * @param 資格喪失日 FlexibleDate
     * @param 受給認定年月日 FlexibleDate
     * @param 受給認定取消年月日 FlexibleDate
     * @param 資格区分 RString
     * @param 受給者区分 RString
     * @param 更新日時 RString
     * @param ＦＩＬＬＥＲ2 RString
     */
    public KaigoJuminhyoTashajukiHachiEucCsvEntity(
            RString 市町村コード,
            RString 識別ＩＤ,
            RString タイムスタンプ,
            RString 最終レコード区分,
            RString 連番,
            RString ＦＩＬＬＥＲ1,
            RString 被保険者番号,
            RString 識別コード,
            FlexibleDate 資格取得日,
            FlexibleDate 資格喪失日,
            FlexibleDate 受給認定年月日,
            FlexibleDate 受給認定取消年月日,
            RString 資格区分,
            RString 受給者区分,
            RString 更新日時,
            RString ＦＩＬＬＥＲ2
    ) {
        this.市町村コード = 市町村コード;
        this.識別ＩＤ = 識別ＩＤ;
        this.タイムスタンプ = タイムスタンプ;
        this.最終レコード区分 = 最終レコード区分;
        this.連番 = 連番;
        this.ＦＩＬＬＥＲ1 = ＦＩＬＬＥＲ1;
        this.被保険者番号 = 被保険者番号;
        this.識別コード = 識別コード;
        this.資格取得日 = 資格取得日;
        this.資格喪失日 = 資格喪失日;
        this.受給認定年月日 = 受給認定年月日;
        this.受給認定取消年月日 = 受給認定取消年月日;
        this.資格区分 = 資格区分;
        this.受給者区分 = 受給者区分;
        this.更新日時 = 更新日時;
        this.ＦＩＬＬＥＲ2 = ＦＩＬＬＥＲ2;
    }
}

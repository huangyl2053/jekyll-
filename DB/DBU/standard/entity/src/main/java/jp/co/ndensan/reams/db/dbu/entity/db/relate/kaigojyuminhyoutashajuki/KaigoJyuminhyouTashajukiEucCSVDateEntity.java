/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojyuminhyoutashajuki;

import jp.co.ndensan.reams.db.dbu.entity.db.kaigojuminhyo.IKaigoJuminhyoEucCsvEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護住民票個別事項連携情報作成【広域運用】CSV用データEntity
 *
 * @reamsid_L DBU-0550-030 wanghui
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class KaigoJyuminhyouTashajukiEucCSVDateEntity implements IKaigoJuminhyoEucCsvEntity {

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
    @CsvField(order = 60, name = "識別コード")
    private final RString 識別コード;
    @CsvField(order = 70, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 80, name = "資格取得日")
    private final FlexibleDate 資格取得日;
    @CsvField(order = 90, name = "資格喪失日")
    private final FlexibleDate 資格喪失日;
    @CsvField(order = 100, name = "資格被保険者区分")
    private final RString 資格被保険者区分;
    @CsvField(order = 110, name = "住所地特例者区分")
    private final RString 住所地特例者区分;
    @CsvField(order = 120, name = "受給者区分")
    private final RString 受給者区分;
    @CsvField(order = 130, name = "要介護状態区分コード")
    private final Code 要介護状態区分コード;
    @CsvField(order = 140, name = "認定有効開始日")
    private final FlexibleDate 認定有効開始日;
    @CsvField(order = 150, name = "認定有効終了日")
    private final FlexibleDate 認定有効終了日;
    @CsvField(order = 160, name = "受給認定年月日")
    private final FlexibleDate 受給認定年月日;
    @CsvField(order = 170, name = "受給認定取消年月日")
    private final FlexibleDate 受給認定取消年月日;
    @CsvField(order = 180, name = "削除フラグ")
    private final RString 削除フラグ;
    @CsvField(order = 190, name = "作成日時")
    private final RString 作成日時;
    @CsvField(order = 200, name = "更新日時")
    private final RString 更新日時;

    /**
     * コンストラクタ
     *
     * @param 市町村コード RString
     * @param 識別ＩＤ RString
     * @param タイムスタンプ RString
     * @param 最終レコード区分 RString
     * @param 連番 RString
     * @param 識別コード RString
     * @param 被保険者番号 HihokenshaNo
     * @param 資格取得日 FlexibleDate
     * @param 資格喪失日 FlexibleDate
     * @param 資格被保険者区分 RString
     * @param 住所地特例者区分 RString
     * @param 受給者区分 RString
     * @param 要介護状態区分コード Code
     * @param 認定有効開始日 FlexibleDate
     * @param 認定有効終了日 FlexibleDate
     * @param 受給認定年月日 FlexibleDate
     * @param 受給認定取消年月日 FlexibleDate
     * @param 削除フラグ RString
     * @param 作成日時 RString
     * @param 更新日時 RString
     */
    public KaigoJyuminhyouTashajukiEucCSVDateEntity(
            RString 市町村コード,
            RString 識別ＩＤ,
            RString タイムスタンプ,
            RString 最終レコード区分,
            RString 連番,
            RString 識別コード,
            RString 被保険者番号,
            FlexibleDate 資格取得日,
            FlexibleDate 資格喪失日,
            RString 資格被保険者区分,
            RString 住所地特例者区分,
            RString 受給者区分,
            Code 要介護状態区分コード,
            FlexibleDate 認定有効開始日,
            FlexibleDate 認定有効終了日,
            FlexibleDate 受給認定年月日,
            FlexibleDate 受給認定取消年月日,
            RString 削除フラグ,
            RString 作成日時,
            RString 更新日時
    ) {
        this.市町村コード = 市町村コード;
        this.識別ＩＤ = 識別ＩＤ;
        this.タイムスタンプ = タイムスタンプ;
        this.最終レコード区分 = 最終レコード区分;
        this.連番 = 連番;
        this.識別コード = 識別コード;
        this.被保険者番号 = 被保険者番号;
        this.資格取得日 = 資格取得日;
        this.資格喪失日 = 資格喪失日;
        this.資格被保険者区分 = 資格被保険者区分;
        this.住所地特例者区分 = 住所地特例者区分;
        this.受給者区分 = 受給者区分;
        this.要介護状態区分コード = 要介護状態区分コード;
        this.認定有効開始日 = 認定有効開始日;
        this.認定有効終了日 = 認定有効終了日;
        this.受給認定年月日 = 受給認定年月日;
        this.受給認定取消年月日 = 受給認定取消年月日;
        this.削除フラグ = 削除フラグ;
        this.作成日時 = 作成日時;
        this.更新日時 = 更新日時;
    }
}

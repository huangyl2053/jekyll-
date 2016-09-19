/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110810;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者突合依頼情報作成のＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBC-2750-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class ControlRecordCsvEntity implements IJukyushaTotsugoIraiOutCsvEntity {

    @CsvField(order = 1, name = "種別")
    private final RString 種別;
    @CsvField(order = 2, name = "番号連番")
    private final RString 番号連番;
    @CsvField(order = 3, name = "通番")
    private final RString 通番;
    @CsvField(order = 4, name = "件数")
    private final RString 件数;
    @CsvField(order = 5, name = "データ種別")
    private final RString データ種別;
    @CsvField(order = 6, name = "福祉事務所特定番号")
    private final RString 福祉事務所特定番号;
    @CsvField(order = 7, name = "保険者番号")
    private final RString 保険者番号;
    @CsvField(order = 8, name = "事業所番号")
    private final RString 事業所番号;
    @CsvField(order = 9, name = "都道府県番号")
    private final RString 都道府県番号;
    @CsvField(order = 10, name = "媒体区分")
    private final RString 媒体区分;
    @CsvField(order = 11, name = "処理対象年月")
    private final RString 処理対象年月;
    @CsvField(order = 12, name = "ファイル管理番号")
    private final RString ファイル管理番号;

    /**
     * コンストラクタ
     *
     * @param 種別 種別
     * @param 番号連番 番号連番
     * @param 通番 通番
     * @param 件数 件数
     * @param データ種別 データ種別
     * @param 福祉事務所特定番号 福祉事務所特定番号
     * @param 保険者番号 保険者番号
     * @param 事業所番号 事業所番号
     * @param 都道府県番号 都道府県番号
     * @param 媒体区分 媒体区分
     * @param 処理対象年月 処理対象年月
     * @param ファイル管理番号 ファイル管理番号
     */
    public ControlRecordCsvEntity(RString 種別,
            RString 番号連番,
            RString 通番,
            RString 件数,
            RString データ種別,
            RString 福祉事務所特定番号,
            RString 保険者番号,
            RString 事業所番号,
            RString 都道府県番号,
            RString 媒体区分,
            RString 処理対象年月,
            RString ファイル管理番号) {
        this.種別 = 種別;
        this.番号連番 = 番号連番;
        this.通番 = 通番;
        this.件数 = 件数;
        this.データ種別 = データ種別;
        this.福祉事務所特定番号 = 福祉事務所特定番号;
        this.保険者番号 = 保険者番号;
        this.事業所番号 = 事業所番号;
        this.都道府県番号 = 都道府県番号;
        this.媒体区分 = 媒体区分;
        this.処理対象年月 = 処理対象年月;
        this.ファイル管理番号 = ファイル管理番号;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
public class JukyushaIdoRenrakuhyoOutCSVAEntity {

    @CsvField(order = 1, name = "レコード種別")
    private final RString レコード種別;

    @CsvField(order = 2, name = "レコード番号連")
    private final RString レコード番号連;

    @CsvField(order = 3, name = "ボリュム通番")
    private final RString ボリュム通番;

    @CsvField(order = 4, name = "レコード件数")
    private final int レコード件数;

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

    @CsvField(order = 13, name = "ブランク")
    private final RString ブランク;

    /**
     * コンストラクタです。
     *
     * @param レコード種別 レコード種別
     * @param レコード番号連 レコード番号連
     * @param ボリュム通番 ボリュム通番
     * @param レコード件数 レコード件数
     * @param データ種別 データ種別
     * @param 福祉事務所特定番号 福祉事務所特定番号
     * @param 保険者番号 保険者番号
     * @param 事業所番号 事業所番号
     * @param 都道府県番号 都道府県番号
     * @param 媒体区分 媒体区分
     * @param 処理対象年月 処理対象年月
     * @param ファイル管理番号 ファイル管理番号
     * @param ブランク ブランク
     */
    public JukyushaIdoRenrakuhyoOutCSVAEntity(
            RString レコード種別,
            RString レコード番号連,
            RString ボリュム通番,
            int レコード件数,
            RString データ種別,
            RString 福祉事務所特定番号,
            RString 保険者番号,
            RString 事業所番号,
            RString 都道府県番号,
            RString 媒体区分,
            RString 処理対象年月,
            RString ファイル管理番号,
            RString ブランク
    ) {
        this.データ種別 = データ種別;
        this.ファイル管理番号 = ファイル管理番号;
        this.ブランク = ブランク;
        this.ボリュム通番 = ボリュム通番;
        this.レコード番号連 = レコード番号連;
        this.レコード種別 = レコード種別;
        this.事業所番号 = 事業所番号;
        this.保険者番号 = 保険者番号;
        this.媒体区分 = 媒体区分;
        this.福祉事務所特定番号 = 福祉事務所特定番号;
        this.都道府県番号 = 都道府県番号;
        this.レコード件数 = レコード件数;
        this.処理対象年月 = 処理対象年月;
    }
}

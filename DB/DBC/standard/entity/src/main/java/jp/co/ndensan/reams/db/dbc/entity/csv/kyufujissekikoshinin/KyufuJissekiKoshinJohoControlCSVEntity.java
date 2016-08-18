/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績更新結果情報取込のControlEntity
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKoshinJohoControlCSVEntity {
    
    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "ボリューム通番")
    private RString ボリューム通番;
    @CsvField(order = 40, name = "レコード件数")
    private RString レコード件数;
    @CsvField(order = 50, name = "データ種別")
    private RString データ種別;
    @CsvField(order = 60, name = "福祉事務所特定番号")
    private RString 福祉事務所特定番号;
    @CsvField(order = 70, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 80, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 90, name = "都道府県番号")
    private RString 都道府県番号;
    @CsvField(order = 100, name = "媒体区分")
    private RString 媒体区分;
    @CsvField(order = 110, name = "処理対象年月")
    private RString 処理対象年月;
    @CsvField(order = 120, name = "ファイル管理番号")
    private RString ファイル管理番号;
    @CsvField(order = 130, name = "ブランク")
    private RString ブランク;
    
}

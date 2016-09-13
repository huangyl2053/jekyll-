/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * CSVファイル作成のヘッダエンティティです。
 *
 * @reamsid_L DBC-2700-010 wangxingpeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanKyufuJissekiInCsvEntity {

    @CsvField(order = 10, name = "取込年月")
    private RString 取込年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "№")
    private RString 番号;
    @CsvField(order = 60, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 70, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 80, name = "支給申請書整理番号")
    private RString 支給申請書整理番号;
    @CsvField(order = 90, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 100, name = "作成区分コード")
    private RString 作成区分コード;
    @CsvField(order = 110, name = "作成区分名称")
    private RString 作成区分名称;
    @CsvField(order = 120, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 130, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 140, name = "決定年月日")
    private RString 決定年月日;
    @CsvField(order = 150, name = "自己負担額")
    private RString 自己負担額;
    @CsvField(order = 160, name = "支給額")
    private RString 支給額;

}

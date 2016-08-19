/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100203;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者情報_生年月日～CSVEntityクラスです．
 *
 * @reamsid_L DBD-4910-050 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokyuuSeinenngappiCsvEntity {

    @CsvField(order = 1, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 2, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 3, name = "年金保険者コード")
    private RString 年金保険者コード;
    @CsvField(order = 4, name = "年金保険者")
    private RString 年金保険者;
    @CsvField(order = 5, name = "基礎年金番号")
    private RString 基礎年金番号;
    @CsvField(order = 6, name = "年金コード")
    private RString 年金コード;
    @CsvField(order = 7, name = "年金名称")
    private RString 年金名称;
    @CsvField(order = 8, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 9, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 10, name = "対象年")
    private RString 対象年;
    @CsvField(order = 11, name = "生年月日市町村データ")
    private RString 生年月日市町村データ;
    @CsvField(order = 12, name = "生年月日年金保険者データ")
    private RString 生年月日年金保険者データ;
    @CsvField(order = 13, name = "性別コード市町村データ")
    private RString 性別コード市町村データ;
    @CsvField(order = 14, name = "性別市町村データ")
    private RString 性別市町村データ;
    @CsvField(order = 15, name = "性別コード年金保険者データ")
    private RString 性別コード年金保険者データ;
    @CsvField(order = 16, name = "性別年金保険者データ")
    private RString 性別年金保険者データ;
    @CsvField(order = 17, name = "カナ氏名市町村データ")
    private RString カナ氏名市町村データ;
    @CsvField(order = 18, name = "カナ氏名年金保険者データ")
    private RString カナ氏名年金保険者データ;
    @CsvField(order = 19, name = "不一致項目")
    private RString 不一致項目;
}

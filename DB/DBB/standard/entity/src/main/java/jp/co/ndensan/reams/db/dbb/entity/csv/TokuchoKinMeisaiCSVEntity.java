/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収依頼金額明細一覧表CSV
 *
 * @reamsid_L DBB-0850-020 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class TokuchoKinMeisaiCSVEntity {

    @CsvField (order = 10, name = "作成年月日")
    private RString 作成年月日;
    @CsvField (order = 20, name = "作成時刻")
    private RString 作成時刻;
    @CsvField (order = 30, name = "賦課年度")
    private RString 賦課年度;
    @CsvField (order = 40, name = "保険者コード")
    private RString 保険者コード;
    @CsvField (order = 50, name = "保険者名")
    private RString 保険者名;
    @CsvField (order = 60, name = "通知書番号")
    private RString 通知書番号;
    @CsvField (order = 70, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField (order = 80, name = "識別コード")
    private RString 識別コード;
    @CsvField (order = 90, name = "世帯コード")
    private RString 世帯コード;
    @CsvField (order = 100, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField (order = 110, name = "住所コード")
    private RString 住所コード;
    @CsvField (order = 120, name = "行政区コード")
    private RString 行政区コード;
    @CsvField (order = 130, name = "住所")
    private RString 住所;
    @CsvField (order = 140, name = "町域（管内）・管外住所")
    private RString 町域管内_管外住所;
    @CsvField (order = 150, name = "番地")
    private RString 番地;
    @CsvField (order = 160, name = "基礎年金番号")
    private RString 基礎年金番号;
    @CsvField (order = 170, name = "年金コード")
    private RString 年金コード;
    @CsvField (order = 180, name = "特別徴収対象年金")
    private RString 特別徴収対象年金;
    @CsvField (order = 190, name = "特別徴収業務者コード")
    private RString 特別徴収業務者コード;
    @CsvField (order = 200, name = "特別徴収業務者")
    private RString 特別徴収業務者;
    @CsvField (order = 210, name = "保険料段階")
    private RString 保険料段階;
    @CsvField (order = 220, name = "基準年度保険料率")
    private RString 基準年度保険料率;
    @CsvField (order = 230, name = "特徴開始月")
    private RString 特徴開始月;
    @CsvField (order = 240, name = "依頼金額")
    private RString 依頼金額;
    @CsvField (order = 250, name = "備考")
    private RString 備考;
}

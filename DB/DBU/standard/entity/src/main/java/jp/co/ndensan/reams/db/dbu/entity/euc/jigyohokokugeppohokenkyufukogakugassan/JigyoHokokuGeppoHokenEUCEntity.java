/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokugeppohokenkyufukogakugassan;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 根拠CSV作成情報のCSV用データEntityです。
 *
 * @reamsid_L DBU-5590-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class JigyoHokokuGeppoHokenEUCEntity implements IJigyoHokokuGeppoHokenEUCEntity {

    @CsvField(order = 1, name = "データ区分")
    private RString データ区分;
    @CsvField(order = 2, name = "集計区分")
    private RString 集計区分;
    @CsvField(order = 3, name = "表番号")
    private RString 表番号;
    @CsvField(order = 4, name = "集計番号")
    private RString 集計番号;
    @CsvField(order = 5, name = "集計単位")
    private RString 集計単位;
    @CsvField(order = 6, name = "縦番号")
    private RString 縦番号;
    @CsvField(order = 7, name = "横番号")
    private RString 横番号;
    @CsvField(order = 8, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 9, name = "対象年度")
    private RString 対象年度;
    @CsvField(order = 10, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 11, name = "連絡票整理番号")
    private RString 連絡票整理番号;
    @CsvField(order = 12, name = "履歴番号")
    private int 履歴番号;
    @CsvField(order = 13, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 14, name = "保険制度コード")
    private RString 保険制度コード;
    @CsvField(order = 15, name = "国保被保険者証記号")
    private RString 国保被保険者証記号;
    @CsvField(order = 16, name = "対象計算期間_開始")
    private RString 対象計算期間_開始;
    @CsvField(order = 17, name = "対象計算期間_終了")
    private RString 対象計算期間_終了;
    @CsvField(order = 18, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 19, name = "決定年月日")
    private RString 決定年月日;
    @CsvField(order = 20, name = "不支給の理由")
    private RString 不支給の理由;
    @CsvField(order = 21, name = "備考")
    private RString 備考;
    @CsvField(order = 22, name = "所得区分")
    private RString 所得区分;
    @CsvField(order = 23, name = "係る所得区分")
    private RString 係る所得区分;
    @CsvField(order = 24, name = "警告")
    private RString 警告;
    @CsvField(order = 25, name = "市町村コード")
    private LasdecCode 市町村コード;
    @CsvField(order = 26, name = "旧市町村コード")
    private LasdecCode 旧市町村コード;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費対象者一覧表CSVEntity
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
@SuppressWarnings ("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KogakuServicehiTaishoshaIchiranCSVEntity {

    @CsvField (order = 10, name = "総ページ数")
    private RString 総ページ数;
    @CsvField (order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField (order = 30, name = "審査年月")
    private RString 審査年月;
    @CsvField (order = 40, name = "市町村コード")
    private RString 市町村コード;
    @CsvField (order = 50, name = "市町村名称")
    private RString 市町村名称;
    @CsvField (order = 60, name = "出力順1")
    private RString 出力順1;
    @CsvField (order = 70, name = "出力順2")
    private RString 出力順2;
    @CsvField (order = 80, name = "出力順3")
    private RString 出力順3;
    @CsvField (order = 90, name = "出力順4")
    private RString 出力順4;
    @CsvField (order = 100, name = "出力順5")
    private RString 出力順5;
    @CsvField (order = 110, name = "改ページ1")
    private RString 改ページ1;
    @CsvField (order = 120, name = "改ページ2")
    private RString 改ページ2;
    @CsvField (order = 130, name = "改ページ3")
    private RString 改ページ3;
    @CsvField (order = 140, name = "改ページ4")
    private RString 改ページ4;
    @CsvField (order = 150, name = "改ページ5")
    private RString 改ページ5;
    @CsvField (order = 160, name = "NO")
    private RString no;
    @CsvField (order = 170, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField (order = 180, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField (order = 190, name = "被保険者名")
    private RString 被保険者名;
    @CsvField (order = 200, name = "旧措置")
    private RString 旧措置;
    @CsvField (order = 210, name = "要介護度")
    private RString 要介護度;
    @CsvField (order = 220, name = "認定有効開始年月日")
    private RString 認定有効開始年月日;
    @CsvField (order = 230, name = "認定有効終了年月日")
    private RString 認定有効終了年月日;
    @CsvField (order = 240, name = "世帯番号")
    private RString 世帯番号;
    @CsvField (order = 250, name = "単独合算")
    private RString 単独合算;
    @CsvField (order = 260, name = "自己負担額")
    private RString 自己負担額;
    @CsvField (order = 270, name = "支給（予定）金額")
    private RString 支給予定金額;
    @CsvField (order = 280, name = "備考")
    private RString 備考;

}

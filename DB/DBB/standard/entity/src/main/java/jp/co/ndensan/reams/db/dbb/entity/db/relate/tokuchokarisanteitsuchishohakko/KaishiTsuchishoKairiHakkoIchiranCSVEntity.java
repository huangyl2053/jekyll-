/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表ＣＳＶクラスです。
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class KaishiTsuchishoKairiHakkoIchiranCSVEntity {

    @CsvField (order = 10, name = "作成年月日")
    private RString 作成年月日;
    @CsvField (order = 20, name = "作成時刻")
    private RString 作成時刻;
    @CsvField (order = 30, name = "賦課年度")
    private RString 賦課年度;
    @CsvField (order = 40, name = "郵便番号")
    private RString 郵便番号;
    @CsvField (order = 50, name = "住所")
    private RString 住所;
    @CsvField (order = 60, name = "町域（管内）・管外住所")
    private RString 町域管内管外住所;
    @CsvField (order = 70, name = "番地")
    private RString 番地;
    @CsvField (order = 80, name = "行政区コード")
    private RString 行政区コード;
    @CsvField (order = 90, name = "行政区")
    private RString 行政区;
    @CsvField (order = 100, name = "生年月日")
    private RString 生年月日;
    @CsvField (order = 110, name = "性別")
    private RString 性別;
    @CsvField (order = 120, name = "世帯主名")
    private RString 世帯主名;
    @CsvField (order = 130, name = "通知書番号")
    private RString 通知書番号;
    @CsvField (order = 140, name = "世帯コード")
    private RString 世帯コード;
    @CsvField (order = 150, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField (order = 160, name = "特別徴収業務者コード")
    private RString 特別徴収業務者コード;
    @CsvField (order = 170, name = "特別徴収業務者")
    private RString 特別徴収業務者;
    @CsvField (order = 180, name = "特別徴収対象年金コード")
    private RString 特別徴収対象年金コード;
    @CsvField (order = 190, name = "特別徴収対象年金")
    private RString 特別徴収対象年金;
    @CsvField (order = 200, name = "仮徴収額（4月）")
    private RString 仮徴収額_4月;
    @CsvField (order = 210, name = "仮徴収額（6月）　")
    private RString 仮徴収額_6月;
    @CsvField (order = 220, name = "仮徴収額（8月）")
    private RString 仮徴収額_8月;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohotorokueuccsventity;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報登録エラーリストのEntity
 *
 * @reamsid_L DBB-1690-070 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuJohoTorokuEucCsvEntity {

    @CsvField(order = 10, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "賦課年度")
    private RString 賦課年度;
    @CsvField(order = 40, name = "住民コード")
    private RString 住民コード;
    @CsvField(order = 50, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 60, name = "非課税区分")
    private RString 非課税区分;
    @CsvField(order = 70, name = "エラー内容")
    private RString エラー内容;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 請求額通知書情報取込共通処理（CSVファイル取込）のmeisaiEntity
 *
 * @reamsid_L DBC-2480-013 sunqingzhu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyugakuTsuchishoCsvFileMeisaiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "目コード")
    private RString 目コード;
    @CsvField(order = 60, name = "目名")
    private RString 目名;
    @CsvField(order = 70, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 80, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 90, name = "通常分・件数")
    private RString 通常分_件数;
    @CsvField(order = 100, name = "通常分・実日数")
    private RString 通常分_実日数;
    @CsvField(order = 110, name = "通常分・単位数")
    private RString 通常分_単位数;
    @CsvField(order = 120, name = "通常分・金額")
    private RString 通常分_金額;
    @CsvField(order = 130, name = "再審査・過誤・件数")
    private RString 再審査_過誤_件数;
    @CsvField(order = 140, name = "再審査・過誤・単位数")
    private RString 再審査_過誤_単位数;
    @CsvField(order = 150, name = "再審査・過誤・調整額")
    private RString 再審査_過誤_調整額;
    @CsvField(order = 160, name = "介護給付費／総合事業費")
    private RString 介護給付費_総合事業費;
    @CsvField(order = 170, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 180, name = "公費負担額")
    private RString 公費負担額;
    @CsvField(order = 190, name = "ブランク")
    private RString ブランク;
}

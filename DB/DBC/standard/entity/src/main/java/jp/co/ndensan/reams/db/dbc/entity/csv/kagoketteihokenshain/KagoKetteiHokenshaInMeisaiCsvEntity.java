/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 過誤決定通知書情報取込共通処理（保険者分・ファイル読込）のmeisaiEntity
 *
 * @reamsid_L DBC-0980-302 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaInMeisaiCsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString codeShubetsu;
    @CsvField(order = 20, name = "レコード番号")
    private RString codeNo;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString kokanShikibetsuNo;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString chouhyouCodeShubetsu;
    @CsvField(order = 50, name = "事業所番号")
    private RString jigyoshoNo;
    @CsvField(order = 60, name = "事業所名")
    private RString jigyoshaName;
    @CsvField(order = 70, name = "被保険者番号")
    private RString orgHihokenshaNo;
    @CsvField(order = 80, name = "被保険者氏名")
    private RString orgHihokenshaShimei;
    @CsvField(order = 90, name = "サービス提供年月")
    private RString serviceTeikyoYM;
    @CsvField(order = 100, name = "サービス種類コード")
    private RString serviceShuruiCode;
    @CsvField(order = 110, name = "サービス種類名")
    private RString serviceShuruiName;
    @CsvField(order = 120, name = "過誤申立事由コード")
    private RString kagomoushitateJiyuCode;
    @CsvField(order = 130, name = "過誤申立事由")
    private RString kagomoushitateJiyu;
    @CsvField(order = 140, name = "単位数")
    private RString tanisu;
    @CsvField(order = 150, name = "保険者負担額")
    private RString hokenshaFutangaku;
    @CsvField(order = 160, name = "ブランク")
    private RString flag;
}

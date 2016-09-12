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
 * 過誤決定通知書情報取込共通処理（保険者分・ファイル読込）のheadEntity
 *
 * @reamsid_L DBC-0980-302 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaInHeadCsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString codeShubetsu;
    @CsvField(order = 20, name = "レコード番号")
    private RString codeNo;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString kokanShikibetsuNo;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString chouhyouCodeShubetsu;
    @CsvField(order = 50, name = "取扱年月")
    private RString hdrToriatsukaiYm;
    @CsvField(order = 60, name = "証記載保険者番号")
    private RString shoKisaiHokenshaNo;
    @CsvField(order = 70, name = "証記載保険者名")
    private RString hihokenshaName;
    @CsvField(order = 80, name = "作成年月日")
    private RString sakuseiYMD;
    @CsvField(order = 90, name = "頁")
    private RString page;
    @CsvField(order = 100, name = "国保連合会名")
    private RString kokukoRengoukaiNa;
    @CsvField(order = 110, name = "ブランク")
    private RString flag;

}

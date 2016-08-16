/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenkyotsu;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 国保連共通のコントロールレコードのCsvEntityです。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenkyoutsuControlCsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString codeShubetsu;
    @CsvField(order = 20, name = "レコード番号")
    private RString codeNo;
    @CsvField(order = 30, name = "ボリューム通番")
    private RString volumeRenban;
    @CsvField(order = 40, name = "レコード件数")
    private RString codeNum;
    @CsvField(order = 50, name = "データ種別")
    private RString dataShubetsu;
    @CsvField(order = 60, name = "福祉事務所特定番号")
    private RString fukushijimushoTokuteiNo;
    @CsvField(order = 70, name = "保険者番号")
    private RString hokenshaNo;
    @CsvField(order = 80, name = "事業所番号")
    private RString jigyoshoNo;
    @CsvField(order = 90, name = "都道府県番号")
    private RString todofukenNo;
    @CsvField(order = 100, name = "媒体区分")
    private RString baitaiKubun;
    @CsvField(order = 110, name = "処理対象年月")
    private RString shoriYM;
    @CsvField(order = 120, name = "ファイル管理番号")
    private RString fileKanriNo;
    @CsvField(order = 130, name = "ブランク")
    private RString flag;

}

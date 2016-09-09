/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120140;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 支給不支給決定者一覧情報ファイルのヘッダです。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikyuFushikyuKetteishaIchiranCsvHeadEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "レコード種別_HDT")
    private RString レコード種別_HDT;
    @CsvField(order = 50, name = "保険制度コード")
    private RString 保険制度コード;
    @CsvField(order = 60, name = "申請対象年度")
    private RString 申請対象年度;
    @CsvField(order = 70, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 80, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 90, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 100, name = "国保連合会")
    private RString 国保連合会;
    @CsvField(order = 110, name = "ブランク")
    private RString ブランク;
}

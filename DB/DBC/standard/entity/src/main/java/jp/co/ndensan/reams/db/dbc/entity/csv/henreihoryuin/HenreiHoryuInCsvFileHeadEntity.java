/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.henreihoryuin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護予防・日常生活支援総合事業費公費受給者別一覧表情報取込のヘッダーEntity
 *
 * @reamsid_L DBC-4710-030 chenjie
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HenreiHoryuInCsvFileHeadEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "事業所（保険者）番号")
    private RString 事業所保険者番号;
    @CsvField(order = 60, name = "事業所（保険者）名")
    private RString 事業所保険者名;
    @CsvField(order = 70, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 80, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 90, name = "頁")
    private RString 頁;
    @CsvField(order = 100, name = "国保連合会名")
    private RString 国保連合会名;
}

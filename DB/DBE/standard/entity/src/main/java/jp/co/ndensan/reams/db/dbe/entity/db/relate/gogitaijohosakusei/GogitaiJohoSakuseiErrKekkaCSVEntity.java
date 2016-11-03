/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *合議体情報作成時エラー結果クラスです。
 * 
 * @author n8344
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GogitaiJohoSakuseiErrKekkaCSVEntity {
    @CsvField(order = 1)
    private RString gogitaiNo;
    @CsvField(order = 2)
    private RString gogitaiMei;
    @CsvField(order = 3)
    private RString gogitaiYukoKikanKaishiYMD;
    @CsvField(order = 4)
    private RString gogitaiYukoKikanShuryoYMD;
    @CsvField(order = 5)
    private RString gogitaiKaishiYoteiTime;
    @CsvField(order = 6)
    private RString gogitaiShuryoYoteiTime;
    @CsvField(order = 10)
    private RString shinsakaiKaisaiBashoCode;
    @CsvField(order = 7)
    private RString shinsakaiYoteiTeiin;
    @CsvField(order = 8)
    private RString shinsakaiJidoWariateTeiin;
    @CsvField(order = 9)
    private RString shinsakaiIinTeiin;
    @CsvField(order = 11)
    private RString gogitaiSeishinkaSonzaiFlag;
    @CsvField(order = 12)
    private RString gogitaiDummyFlag;
    @CsvField(order = 13)
    private RString shinsakaiIinCode;
    @CsvField(order = 15)
    private RString gogitaichoKubunCode;
    @CsvField(order = 14)
    private RString substituteFlag; 
    @CsvField(order = 16)
    private RString ErrJoho; 
}

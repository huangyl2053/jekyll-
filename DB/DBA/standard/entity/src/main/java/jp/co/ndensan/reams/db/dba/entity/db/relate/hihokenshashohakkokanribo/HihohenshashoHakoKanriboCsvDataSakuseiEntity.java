/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 証発行管理リストCSV用データリストです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihohenshashoHakoKanriboCsvDataSakuseiEntity {

    @CsvField(order = 10, name = "連番")
    private int renban;
    @CsvField(order = 20, name = "被保険者番号")
    private RString hihokenshaNo;
    @CsvField(order = 30, name = "識別コード")
    private ShikibetsuCode shikibetsuCode;
    @CsvField(order = 40, name = "市町村コード")
    private LasdecCode shichosonCode;
    @CsvField(order = 50, name = "郵便番号")
    private RString yubinNo;
    @CsvField(order = 60, name = "住所")
    private RString jusho;
    @CsvField(order = 70, name = "氏名")
    private RString meisho;
    @CsvField(order = 80, name = "交付年月日")
    private RString kofuYMD;
    @CsvField(order = 90, name = "交付事由コード")
    private RString kofuJiyuCode;
    @CsvField(order = 100, name = "交付事由_略称")
    private RString kofuJiyuRyakusho;
    @CsvField(order = 110, name = "交付事由")
    private RString kofuJiyu;
    @CsvField(order = 120, name = "回収年月日")
    private RString kaishuYMD;
    @CsvField(order = 130, name = "回収事由コード")
    private RString kaishuJiyuCode;
    @CsvField(order = 140, name = "回収事由")
    private RString kaishuJiyu;
    @CsvField(order = 150, name = "有効期限")
    private RString yukoKigenYMD;
    @CsvField(order = 160, name = "様式")
    private RString shoYoshikiKubunCode;

}

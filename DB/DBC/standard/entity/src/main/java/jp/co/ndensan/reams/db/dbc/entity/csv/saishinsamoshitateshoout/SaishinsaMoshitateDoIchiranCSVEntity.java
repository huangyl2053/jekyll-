/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.saishinsamoshitateshoout;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護給付費再審査申立書情報作成の帳票CSVEntity
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaMoshitateDoIchiranCSVEntity {

    @CsvField(order = 10, name = "送付年月")
    private RString 送付年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 40, name = "証記載保険者名")
    private RString 証記載保険者名;
    @CsvField(order = 50, name = "No.")
    private RString no;
    @CsvField(order = 60, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 70, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 80, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 90, name = "被保険者カナ氏名")
    private RString 被保険者カナ氏名;
    @CsvField(order = 100, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 110, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 120, name = "サービスコード")
    private RString サービスコード;
    @CsvField(order = 130, name = "サービス名称")
    private RString サービス名称;
    @CsvField(order = 140, name = "申立年月日")
    private RString 申立年月日;
    @CsvField(order = 150, name = "申立点数")
    private RString 申立点数;
    @CsvField(order = 160, name = "申立事由コード")
    private RString 申立事由コード;
    @CsvField(order = 170, name = "申立事由1")
    private RString 申立事由1;
    @CsvField(order = 180, name = "申立事由2")
    private RString 申立事由2;
    @CsvField(order = 190, name = "合計件数")
    private RString 合計件数;

}

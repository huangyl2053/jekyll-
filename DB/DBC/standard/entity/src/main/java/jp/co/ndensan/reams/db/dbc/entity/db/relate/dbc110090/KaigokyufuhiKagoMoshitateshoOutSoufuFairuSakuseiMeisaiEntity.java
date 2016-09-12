/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護給付費過誤申立書作成のデータレコードです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigokyufuhiKagoMoshitateshoOutSoufuFairuSakuseiMeisaiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号_連番;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "申立年月日")
    private RString 申立年月日;
    @CsvField(order = 50, name = "申立者区分コード")
    private RString 申立者区分コード;
    @CsvField(order = 60, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 70, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 80, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 90, name = "サービス提供年月日")
    private RString サービス提供年月日;
    @CsvField(order = 100, name = "申立事由コード）")
    private RString 申立事由コード;
}

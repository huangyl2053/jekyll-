/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.henreihoryuin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護予防・日常生活支援総合事業費公費受給者別一覧表情報取込の明細Entity
 *
 * @reamsid_L DBC-2830-010 yaodongsheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HenreiHoryuInCsvFileMeisaEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "保険者（事業所）番号")
    private RString 保険者事業所番号;
    @CsvField(order = 60, name = "保険者（事業所）名")
    private RString 保険者事業所名;
    @CsvField(order = 70, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 80, name = "被保険者カナ氏名")
    private RString 被保険者カナ氏名;
    @CsvField(order = 90, name = "種別")
    private RString 種別;
    @CsvField(order = 100, name = "サービス提供年月")
    private FlexibleYearMonth サービス提供年月;
    @CsvField(order = 110, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 120, name = "単位数")
    private Decimal 単位数;
    @CsvField(order = 130, name = "事由")
    private RString 事由;
    @CsvField(order = 140, name = "内容")
    private RString 内容;
    @CsvField(order = 150, name = "備考")
    private RString 備考;
    @CsvField(order = 160, name = "サービス項目コード等")
    private RString サービス項目コード等;
}

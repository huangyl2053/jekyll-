/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護予防・日常生活支援総合事業費公費受給者別一覧表情報取込の明細Entity
 *
 * @reamsid_L DBC-4710-030 chenjie
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiKohiJukyushaCsvFileMeisaEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "公費受給者番号")
    private RString 公費受給者番号;
    @CsvField(order = 60, name = "サービス提供年月")
    private FlexibleYearMonth サービス提供年月;
    @CsvField(order = 70, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 80, name = "事業所名")
    private RString 事業所名;
    @CsvField(order = 90, name = "サービスコード")
    private RString サービスコード;
    @CsvField(order = 100, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 110, name = "サービス項目名")
    private RString サービス項目名;
    @CsvField(order = 120, name = "日数回数")
    private RString 日数回数;
    @CsvField(order = 130, name = "公費対象単位数")
    private RString 公費対象単位数;
    @CsvField(order = 140, name = "公費負担金額")
    private RString 公費負担金額;
    @CsvField(order = 150, name = "公費分本人負担額")
    private RString 公費分本人負担額;
    @CsvField(order = 160, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 170, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 180, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 190, name = "ブランク")
    private RString ブランク;
}

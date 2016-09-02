/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishikakushogohyokeikasochiin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票のCSVファイル作成のヘッダエンティティです。
 *
 * @reamsid_L DBC-2890-011 wangxingpeng
 *
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity {

    @CsvField(order = 10, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "連番")
    private RString 連番;
    @CsvField(order = 40, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 50, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 60, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 70, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 80, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 90, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 100, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 110, name = "警告種別")
    private RString 警告種別;
    @CsvField(order = 120, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 130, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 140, name = "要介護区分コード")
    private RString 要介護区分コード;
    @CsvField(order = 150, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 160, name = "認定有効期間（開始)")
    private RString 認定有効期間_開始;
    @CsvField(order = 170, name = "認定有効期間（終了）")
    private RString 認定有効期間_終了;
    @CsvField(order = 180, name = "サービス日数・回数")
    private RString サービス日数_回数;
    @CsvField(order = 190, name = "サービス単位数")
    private RString サービス単位数;
    @CsvField(order = 200, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 210, name = "証記載保険者番号")
    private RString 証記載保険者番号;

    /**
     *
     * 証記載保険者番号列を出力しない
     *
     * @return SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity
     */
    public SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity to単一() {
        SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity 単一 = new SogojigyohiShikakuShogohyoKeikaSochiInCsvEntity();
        単一.setサービス単位数(サービス単位数);
        単一.setサービス提供年月(サービス提供年月);
        単一.setサービス日数_回数(サービス日数_回数);
        単一.setサービス種類コード(サービス種類コード);
        単一.setサービス種類名(サービス種類名);
        単一.set事業者名(事業者名);
        単一.set事業者番号(事業者番号);
        単一.set作成日時(作成日時);
        単一.set保険者名(保険者名);
        単一.set保険者番号(保険者番号);
        単一.set利用者負担額(利用者負担額);
        単一.set審査年月(審査年月);
        単一.set被保険者氏名(被保険者氏名);
        単一.set被保険者番号(被保険者番号);
        単一.set要介護区分コード(要介護区分コード);
        単一.set要介護度(要介護度);
        単一.set認定有効期間_終了(認定有効期間_終了);
        単一.set認定有効期間_開始(認定有効期間_開始);
        単一.set警告種別(警告種別);
        単一.set連番(連番);
        return 単一;
    }
}

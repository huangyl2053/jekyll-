/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績更新結果情報取込の帳票CSVEntity
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKoshinJohoIchiranCsvEntity {

    @CsvField(order = 10, name = "処理年月")
    private RString 処理年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "No.")
    private int no;
    @CsvField(order = 60, name = "入力識別番号")
    private RString 入力識別番号;
    @CsvField(order = 70, name = "入力識別名称")
    private RString 入力識別名称;
    @CsvField(order = 80, name = "作成区分")
    private RString 作成区分;
    @CsvField(order = 90, name = "作成区分名")
    private RString 作成区分名;
    @CsvField(order = 100, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 110, name = "被保険者カナ氏名")
    private RString 被保険者カナ氏名;
    @CsvField(order = 120, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 130, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 140, name = "給付実績区分")
    private RString 給付実績区分;
    @CsvField(order = 150, name = "給付実績区分名")
    private RString 給付実績区分名;
    @CsvField(order = 160, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 170, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 180, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 190, name = "作成レコード種別・01基本")
    private RString 作成レコード種別_01基本;
    @CsvField(order = 200, name = "作成レコード種別・02明細")
    private RString 作成レコード種別_02明細;
    @CsvField(order = 210, name = "作成レコード種別・03施設")
    private RString 作成レコード種別_03施設;
    @CsvField(order = 220, name = "作成レコード種別・04特診")
    private RString 作成レコード種別_04特診;
    @CsvField(order = 230, name = "作成レコード種別・05食事")
    private RString 作成レコード種別_05食事;
    @CsvField(order = 240, name = "作成レコード種別・06計画")
    private RString 作成レコード種別_06計画;
    @CsvField(order = 250, name = "作成レコード種別・07用具")
    private RString 作成レコード種別_07用具;
    @CsvField(order = 260, name = "作成レコード種別・08住宅")
    private RString 作成レコード種別_08住宅;
    @CsvField(order = 270, name = "作成レコード種別・09高額")
    private RString 作成レコード種別_09高額;
    @CsvField(order = 280, name = "作成レコード種別・10集計")
    private RString 作成レコード種別_10集計;
    @CsvField(order = 290, name = "作成レコード種別・11特定")
    private RString 作成レコード種別_11特定;
    @CsvField(order = 300, name = "作成レコード種別・12社福")
    private RString 作成レコード種別_12社福;
    @CsvField(order = 310, name = "作成レコード種別・13所定")
    private RString 作成レコード種別_13所定;
    @CsvField(order = 320, name = "備考")
    private RString 備考;
    @CsvField(order = 330, name = "合計件数")
    private RString 合計件数;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票作成csvのEntity
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KyufuKanrihyoSofuIchirancsvEntity {

    @CsvField(order = 10, name = "提出年月")
    private RString 提出年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "対象年月")
    private RString 対象年月;
    @CsvField(order = 60, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 70, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 80, name = "更新区分")
    private RString 更新区分;
    @CsvField(order = 90, name = "帳票通番")
    private RString 帳票通番;
    @CsvField(order = 100, name = "居宅サービス区分")
    private RString 居宅サービス区分;
    @CsvField(order = 110, name = "要介護状態区分")
    private RString 要介護状態区分;
    @CsvField(order = 120, name = "区分支給限度基準額")
    private RString 区分支給限度基準額;
    @CsvField(order = 130, name = "限度額管理開始年月")
    private RString 限度額管理開始年月;
    @CsvField(order = 140, name = "限度額管理終了年月")
    private RString 限度額管理終了年月;
    @CsvField(order = 150, name = "指定サービス単位／日数")
    private RString 指定サービス単位_日数;
    @CsvField(order = 160, name = "基準該当サービス単位／日数")
    private RString 基準該当サービス単位_日数;
    @CsvField(order = 170, name = "合計単位")
    private RString 合計単位;
    @CsvField(order = 180, name = "備考")
    private RString 備考;
    @CsvField(order = 190, name = "備考（証記載保険者番号）")
    private RString 備考証記載保険者番号;
    @CsvField(order = 200, name = "集計項目")
    private RString 集計項目;
    @CsvField(order = 210, name = "合計件数・新規")
    private RString 合計件数_新規;
    @CsvField(order = 220, name = "合計件数・修正")
    private RString 合計件数_修正;
    @CsvField(order = 230, name = "合計件数・取消")
    private RString 合計件数_取消;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishokohiin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMNF2002-631_介護給付費等請求額通知書情報（公費）取込のCsvEntityです。
 *
 * @reamsid_L DBC-2790-010 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyugakuTsuchishoKohiInCsvEntity {

    @CsvField(order = 10, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "国保連合会名")
    private RString 国保連合会名;
    @CsvField(order = 40, name = "公費負担者番号")
    private RString 公費負担者番号;
    @CsvField(order = 50, name = "公費負担者名")
    private RString 公費負担者名;
    @CsvField(order = 60, name = "款コード")
    private RString 款コード;
    @CsvField(order = 70, name = "款名")
    private RString 款名;
    @CsvField(order = 80, name = "項コード")
    private RString 項コード;
    @CsvField(order = 90, name = "項名")
    private RString 項名;
    @CsvField(order = 100, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 110, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 120, name = "通常分・件数")
    private RString 通常分件数;
    @CsvField(order = 130, name = "通常分・実日数")
    private RString 通常分実日数;
    @CsvField(order = 140, name = "通常分・公費対象単位数")
    private RString 通常分公費対象単位数;
    @CsvField(order = 150, name = "通常分・公費対象金額")
    private RString 通常分公費対象金額;
    @CsvField(order = 160, name = "再審査・過誤・件数")
    private RString 再審査過誤件数;
    @CsvField(order = 170, name = "再審査・過誤・公費対象単位数")
    private RString 再審査過誤公費対象単位数;
    @CsvField(order = 180, name = "再審査・過誤・公費対象調整額")
    private RString 再審査過誤公費対象調整額;
    @CsvField(order = 190, name = "負担額")
    private RString 負担額;
    @CsvField(order = 200, name = "公費分本人負担額")
    private RString 公費分本人負担額;
    @CsvField(order = 210, name = "合計・通常分・件数")
    private RString 合計通常分件数;
    @CsvField(order = 220, name = "合計・通常分・公費対象単位数")
    private RString 合計通常分公費対象単位数;
    @CsvField(order = 230, name = "合計・通常分・公費対象金額")
    private RString 合計通常分公費対象金額;
    @CsvField(order = 240, name = "合計・再審査・過誤・件数")
    private RString 合計再審査過誤件数;
    @CsvField(order = 250, name = "合計・再審査・過誤・公費対象単位数")
    private RString 合計再審査過誤公費対象単位数;
    @CsvField(order = 260, name = "合計・再審査・過誤・公費対象調整額")
    private RString 合計再審査過誤公費対象調整額;
    @CsvField(order = 270, name = "合計・負担額")
    private RString 合計負担額;
    @CsvField(order = 280, name = "合計・公費分本人負担額")
    private RString 合計公費分本人負担額;
    @CsvField(order = 290, name = "累計・通常分・件数")
    private RString 累計通常分件数;
    @CsvField(order = 300, name = "累計・通常分・公費対象単位数")
    private RString 累計通常分公費対象単位数;
    @CsvField(order = 310, name = "累計・通常分・公費対象金額")
    private RString 累計通常分公費対象金額;
    @CsvField(order = 320, name = "累計・再審査・過誤・件数")
    private RString 累計再審査過誤件数;
    @CsvField(order = 330, name = "累計・再審査・過誤・公費対象単位数")
    private RString 累計再審査過誤公費対象単位数;
    @CsvField(order = 340, name = "累計・再審査・過誤・公費対象調整額")
    private RString 累計再審査過誤公費対象調整額;
    @CsvField(order = 350, name = "累計・負担額")
    private RString 累計負担額;
    @CsvField(order = 360, name = "累計・公費分本人負担額")
    private RString 累計公費分本人負担額;
    @CsvField(order = 370, name = "手数料・請求額")
    private RString 手数料請求額;
    @CsvField(order = 380, name = "手数料・累計請求額")
    private RString 手数料累計請求額;

}

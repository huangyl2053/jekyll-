/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定データ出力Entityです。
 *
 * @reamsid_L DBE-1610-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class IchijihanteiSumidataIferaEucEntity implements IchijihanteiSumidataEucEntity {

    @CsvField(order = 1, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 2, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 3, name = "エラー項目")
    private RString エラー項目;
}

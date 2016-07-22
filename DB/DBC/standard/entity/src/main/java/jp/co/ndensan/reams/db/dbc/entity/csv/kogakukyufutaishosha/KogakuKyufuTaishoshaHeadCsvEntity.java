/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費給付対象者のCsvEntity
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuTaishoshaHeadCsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 60, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 70, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 80, name = "国保連合会名")
    private RString 国保連合会名;
    @CsvField(order = 90, name = "ブランク")
    private RString ブランク;

}

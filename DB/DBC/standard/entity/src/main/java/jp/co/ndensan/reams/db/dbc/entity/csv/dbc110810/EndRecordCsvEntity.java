/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110810;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者突合依頼情報作成のＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBC-2750-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class EndRecordCsvEntity implements IJukyushaTotsugoIraiOutCsvEntity {

    @CsvField(order = 1, name = "種別")
    private final RString 種別;
    @CsvField(order = 2, name = "番号連番")
    private final RString 番号連番;

    /**
     * コンストラクタ
     *
     * @param 種別 種別
     * @param 番号連番 番号連番
     */
    public EndRecordCsvEntity(RString 種別,
            RString 番号連番) {
        this.種別 = 種別;
        this.番号連番 = 番号連番;
    }

}

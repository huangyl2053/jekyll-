/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc180020;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class RiyoshaFutanWariaiHanteiCsvEntity {

    @CsvField(order = 1, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 2, name = "確認内容")
    private RString 確認内容;

    /**
     * RiyoshaFutanWariaiHanteiCsvEntityのコンストラクタです。
     *
     */
    public RiyoshaFutanWariaiHanteiCsvEntity() {
    }

    /**
     * RiyoshaFutanWariaiHanteiCsvEntityのコンストラクタです。
     *
     * @param 被保険者番号 RString
     * @param 確認内容 RString
     */
    public RiyoshaFutanWariaiHanteiCsvEntity(RString 被保険者番号, RString 確認内容) {
        this.被保険者番号 = 被保険者番号;
        this.確認内容 = 確認内容;
    }

}

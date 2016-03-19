/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain;

import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbT3054CSVDataMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbT3055CSVDataGokeiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 高額介護サービス費給付対象者一覧表明細集計
 *
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuMeisaiGokeiEntity {

    private final DbT3054CSVDataMeisaiEntity 明細Entity;
    private final DbT3055CSVDataGokeiEntity 集計Entity;
    private final FlexibleDate 資格喪失日;

    /**
     * コンストラクタです。
     *
     * @param 明細Entity DbT3054CSVDataMeisaiEntity
     * @param 集計Entity DbT3055CSVDataGokeiEntity
     * @param 資格喪失日 FlexibleDate
     */
    public KogakuKyufuMeisaiGokeiEntity(
            @NonNull DbT3054CSVDataMeisaiEntity 明細Entity,
            @NonNull DbT3055CSVDataGokeiEntity 集計Entity,
            @NonNull FlexibleDate 資格喪失日) {
        this.明細Entity = 明細Entity;
        this.集計Entity = 集計Entity;
        this.資格喪失日 = 資格喪失日;
    }
}

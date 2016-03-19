/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbTKogakuKyufuCSVDataHeadEntity;

/**
 * 高額介護サービス費給付対象者一覧表のEntity
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuTaishoshaInEntity {

    private DbTKogakuKyufuCSVDataHeadEntity headEntity;
    private List<KogakuKyufuMeisaiGokeiEntity> 明細集計List;

    public KogakuKyufuTaishoshaInEntity(DbTKogakuKyufuCSVDataHeadEntity headEntity,
            List<KogakuKyufuMeisaiGokeiEntity> 明細集計List) {
        this.headEntity = headEntity;
        this.明細集計List = 明細集計List;
    }

}

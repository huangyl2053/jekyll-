/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha.DbWT3054KogakuKyufuTaishoshaTempEntity;

/**
 * 被保険者一時TBLと高額介護サービス費給付対象者一時TBL結びついたエンティティ。
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyuufuTaishoshaHihokenshaEntity {

    private DbWT0001HihokenshaTempEntity 被保険者一時;
    private DbWT3054KogakuKyufuTaishoshaTempEntity 対象者;

}

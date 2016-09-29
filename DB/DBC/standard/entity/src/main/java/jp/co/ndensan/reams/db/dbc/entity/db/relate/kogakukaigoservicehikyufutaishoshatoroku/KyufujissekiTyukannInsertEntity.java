/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;

/**
 * 給付実績中間高額一時１Insert用Entityです。
 *
 * @reamsid_L DBC-2010-070 tianshuai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiTyukannInsertEntity implements Serializable {

    private DbT3017KyufujissekiKihonEntity 給付実績基本情報高額一時;
    private TempSetaiinShotokuHanteiEntity 世帯員所得判定明細高額一時;
}

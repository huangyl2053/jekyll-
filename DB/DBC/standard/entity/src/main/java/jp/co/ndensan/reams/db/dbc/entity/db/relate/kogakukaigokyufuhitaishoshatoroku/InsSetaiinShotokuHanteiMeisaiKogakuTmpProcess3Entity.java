/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 世帯員所得判定明細高額一時の作成３のプロセス用エンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 zhouchuanlin
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess3Entity {

    private TempSetaiinShotokuHanteiEntity 世帯員所得判定明細高額一時Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
}

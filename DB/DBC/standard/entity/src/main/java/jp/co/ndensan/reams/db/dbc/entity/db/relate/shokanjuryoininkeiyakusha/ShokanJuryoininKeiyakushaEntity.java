/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanjuryoininkeiyakusha;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;

/**
 * 契約者一覧Entityクラスです。
 *
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanJuryoininKeiyakushaEntity implements Cloneable, Serializable {

    private DbT3078ShokanJuryoininKeiyakushaEntity dbt3078entity;
    private DbT3077JuryoininKeiyakuJigyoshaEntity dbt3077entity;
    private IName 氏名;
}

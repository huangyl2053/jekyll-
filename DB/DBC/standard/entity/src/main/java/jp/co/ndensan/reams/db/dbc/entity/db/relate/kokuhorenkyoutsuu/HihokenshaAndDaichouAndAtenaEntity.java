/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyoutsuu;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者・宛名情報エンティティです。
 *
 * @reamsid_L DBC-0980-560 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaAndDaichouAndAtenaEntity {

    private int id;
    private DbWT0001HihokenshaTempEntity hihokensha;
    private DbT1001HihokenshaDaichoEntity daicho;
    private UaFt200FindShikibetsuTaishoEntity atena;

}

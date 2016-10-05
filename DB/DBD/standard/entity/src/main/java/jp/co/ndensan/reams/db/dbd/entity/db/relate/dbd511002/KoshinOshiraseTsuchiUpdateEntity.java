/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定更新お知らせ通知書発行のSQL結果クラスです。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KoshinOshiraseTsuchiUpdateEntity {

    private DbT4101NinteiShinseiJohoEntity dbt4101Entity;
    private DbT7051KoseiShichosonMasterEntity dbT7051KoseiShichosonMaster;
    private DbV4001JukyushaDaichoEntity dbV4001JukyushaDaicho;
    private DbT4910NinteichosaItakusakiJohoEntity dbT4910NinteichosaItakusakiJoho;
    private DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyosha;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
}

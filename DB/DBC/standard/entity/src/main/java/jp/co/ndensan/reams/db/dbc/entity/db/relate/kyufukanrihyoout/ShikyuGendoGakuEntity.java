/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;

/**
 * 支給限度額のentity
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")

@lombok.Getter
@lombok.Setter
public class ShikyuGendoGakuEntity implements Serializable {

    private KyotakuKeikakuJikosakuseiKanriTempEntity 居宅給付計画自己作成管理一時Entity;
    private DbT4001JukyushaDaichoEntity 受給者台帳Entity;
    private DbT7109KubunShikyuGendoGakuEntity 居宅サービス区分支給限度額Entity;
    private DbT7063KaigoJigyoshaShiteiServiceEntity 介護事業者指定サービスEntity;
    private DbT7060KaigoJigyoshaEntity 介護事業者Entity;
}

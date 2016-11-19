/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jikofutangakushomeisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 高額合算情報のentity.
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanJohoEntity {

    private DbT3068KogakuGassanShinseishoEntity 高額合算申請書entity;
    private DbT3070KogakuGassanJikoFutanGakuEntity 高額合算自己負担額entity;
    private List<DbT3071KogakuGassanJikoFutanGakuMeisaiEntity> 高額合算自己負担額明細entity;
    private DbT3170JigyoKogakuGassanJikoFutanGakuEntity 事業高額合算自己負担額entity;
    private List<DbT3171JigyoKogakuGassanJikoFutanGakuMeisaiEntity> 事業高額合算自己負担額明細entity;
    private UaFt200FindShikibetsuTaishoEntity uaFt200Entity;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳entity;
}

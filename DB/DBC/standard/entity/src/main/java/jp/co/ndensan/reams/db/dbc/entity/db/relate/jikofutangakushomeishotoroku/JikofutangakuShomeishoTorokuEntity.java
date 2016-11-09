/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jikofutangakushomeishotoroku;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity;

/**
 * 事業分自己負担額証明書登録（単）のEntityクラスです。
 *
 * @reamsid_L DBC-4820-010 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JikofutangakuShomeishoTorokuEntity implements Serializable {
    private static final long serialVersionUID = -8392006020041704271L;
    private DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity dbT3180Entity;
    private List<DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity> dbT3181EntityList;
}

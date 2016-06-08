/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;

/**
 *
 * 適用除外者管理のRelateEntityクラスです。
 *
 * @reamsid_L DBA-0210-020 dingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TekiyoJogaishaKanriRelateEntity {

    private DbT1002TekiyoJogaishaEntity 適用除外者Entity;
    private DbT1004ShisetsuNyutaishoEntity 施設入退所Entity;
}

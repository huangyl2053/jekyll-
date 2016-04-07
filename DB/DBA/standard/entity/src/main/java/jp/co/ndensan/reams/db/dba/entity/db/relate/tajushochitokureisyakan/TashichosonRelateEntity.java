/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tajushochitokureisyakan;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;

/**
 *
 * 他住所地特例者管理のRelateEntityクラスです。
 *
 * @reamsid_L DBA-0200-020 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TashichosonRelateEntity {

    private List<DbT1003TashichosonJushochiTokureiEntity> 住所地特例EntityList;
    private List<DbT1004ShisetsuNyutaishoEntity> 施設入退所EntityLsit;
}

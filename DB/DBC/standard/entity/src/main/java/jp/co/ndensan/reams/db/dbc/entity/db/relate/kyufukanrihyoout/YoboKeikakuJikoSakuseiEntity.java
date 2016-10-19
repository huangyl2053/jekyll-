/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3120YoboKeikakuJikoSakuseiKanriEntity;

/**
 * 予防給付計画自己作成情報のEntity
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class YoboKeikakuJikoSakuseiEntity implements Serializable {

    private DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity 予防給付計画自己作成短期利用日数entity;
    private List<DbT3120YoboKeikakuJikoSakuseiKanriEntity> 予防給付計画自己作成管理entity;

}

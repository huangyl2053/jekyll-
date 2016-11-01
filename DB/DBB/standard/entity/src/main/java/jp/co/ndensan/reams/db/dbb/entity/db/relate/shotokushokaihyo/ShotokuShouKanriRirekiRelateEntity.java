/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2020ShotokuShokaihyoHakkoRirekiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;

/**
 * 所得照会票発行履歴と介護所得管理マスタと所得照会票発行履歴のクラスです。
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuShouKanriRirekiRelateEntity {

    private DbT2020ShotokuShokaihyoHakkoRirekiEntity 所得照会票発行履歴Entity;
    private DbT2008ShotokuKanriEntity 介護所得管理マスタEntity;
    private ShotokuShoukaiDataTempEntity 所得照会票Entity;
}

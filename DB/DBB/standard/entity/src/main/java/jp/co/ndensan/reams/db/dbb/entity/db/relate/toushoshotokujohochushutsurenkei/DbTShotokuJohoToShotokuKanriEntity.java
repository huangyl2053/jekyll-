/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.toushoshotokujohochushutsurenkei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohotemp.DbTShotokuJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;

/**
 * 所得情報抽出・連携バッチの所得情報介護所得管理と介護所得管理Entityです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbTShotokuJohoToShotokuKanriEntity implements Serializable {

    private DbTShotokuJohoTempTableEntity 所得情報tempEntity;
    private DbT2008ShotokuKanriEntity 介護所得管理entity;
}

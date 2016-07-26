/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;

/**
 * 介護所得管理クラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuKanri implements Serializable {

    private final DbT2008ShotokuKanriEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2008ShotokuKanriEntity}より{@link ShotokuKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT2008ShotokuKanriEntity}
     */
    public ShotokuKanri(DbT2008ShotokuKanriEntity entity) {
        this.entity = entity;
    }
}

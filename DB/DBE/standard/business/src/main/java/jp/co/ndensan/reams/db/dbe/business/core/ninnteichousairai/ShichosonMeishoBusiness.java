/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村名称を管理するクラスです。
 */
public class ShichosonMeishoBusiness {

    private final DbT7051KoseiShichosonMasterEntity entity;

    /**
     * 市町村情報を返します。
     *
     * @param entity DbT7051KoseiShichosonMasterEntity
     */
    public ShichosonMeishoBusiness(DbT7051KoseiShichosonMasterEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString getShichosonMeisho() {
        return entity.getShichosonMeisho();
    }
}

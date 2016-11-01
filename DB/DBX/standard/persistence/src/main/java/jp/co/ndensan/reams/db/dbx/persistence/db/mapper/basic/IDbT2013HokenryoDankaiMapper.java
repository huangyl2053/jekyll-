/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;

/**
 * {@link jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic.IDbT2013HokenryoDankaiMapper}のマッパーIFです。
 *
 * @reamsid_L DBB-9999-022 xuxin
 */
public interface IDbT2013HokenryoDankaiMapper {

    /**
     * {@link DbT2013HokenryoDankaiEntity}を取得します。
     *
     * @return List<DbT2013HokenryoDankaiEntity>
     */
    List<DbT2013HokenryoDankaiEntity> getHokenryoDankai();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic.IDbT2013HokenryoDankaiMapper}のマッパーIFです。
 *
 * @reamsid_L DBB-9020-130 sunhaidi
 */
public interface IDbT2013HokenryoDankaiMapper {

    /**
     * {@link DbT2013HokenryoDankaiEntity}を取得します。
     *
     * @return {@link DbT2013HokenryoDankaiEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT2013HokenryoDankaiEntity getEntity();

    /**
     * {@link DbT2013HokenryoDankaiEntity}を取得します。
     *
     * @return List<DbT2013HokenryoDankaiEntity>
     */
    List<DbT2013HokenryoDankaiEntity> getHokenryoDankai();
    
    /**
     * {@link DbT2013HokenryoDankaiEntity}を取得します。
     * 
     * @param fukaNendo 賦課年度
     * @return List<DbT2013HokenryoDankaiEntity>
     */
    List<DbT2013HokenryoDankaiEntity> getHokenryoDankaiKubun(RString fukaNendo);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.dbb021051;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb021051.DBB021051MyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.AtenaSealJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.DBB021051ShoriKekkaListTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.DBB021051TableJohoTempEntity;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）のMapperのインターフェースクラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
public interface IDBB021051Mapper {

    /**
     * get一時表情報のメソッドです。
     *
     * @param parameter DBB021051MyBatisParameter
     * @return KaigoChoshuHohoJohoEntity
     */
    List<AtenaSealJohoEntity> get一時表情報(DBB021051MyBatisParameter parameter);

    /**
     * get宛名シール情報一時のメソッドです。
     *
     * @param parameter DBB021051MyBatisParameter
     * @return List<DBB021051TableJohoTempEntity>
     */
    List<DBB021051TableJohoTempEntity> get宛名シール情報一時(DBB021051MyBatisParameter parameter);

    /**
     * get処理結果リスト一時のメソッドです。
     *
     * @return List<DBB021051TableJohoTempEntity>
     */
    List<DBB021051ShoriKekkaListTempEntity> get処理結果リスト一時();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.gemmen;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gemmen.GemmenMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gemmen.GemmenEntity;

/**
 * バッチ設計_DBBMN61002_介護保険料減免登録(一括)のIMapper
 *
 * @reamsid_L DBB-1670-030 surun
 */
public interface IGemmenMapper {

    /**
     * getData
     *
     * @param parameter GemmenMybatisParameter
     * @return List<GemmenEntity>
     */
    List<GemmenEntity> getData(GemmenMybatisParameter parameter);

}

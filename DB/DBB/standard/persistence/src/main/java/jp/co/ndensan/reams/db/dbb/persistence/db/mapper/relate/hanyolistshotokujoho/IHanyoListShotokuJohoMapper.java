/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.hanyolistshotokujoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.hanyolistshotokujoho.HanyoListShotokuJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistshotokujoho.HanyoListShotokuJohoEntity;

/**
 * バッチ設計_DBBBT22002_汎用リスト 所得情報IHanyoListShotokuJohoMapperのクラス
 *
 * @reamsid_L DBB-1901-030 surun
 */
public interface IHanyoListShotokuJohoMapper {

    /**
     * selectbyKey
     *
     * @param parameter HanyoListShotokuJohoMybatisParameter
     * @return List<HanyoListShotokuJohoEntity>
     */
    List<HanyoListShotokuJohoEntity> getCSVData(HanyoListShotokuJohoMybatisParameter parameter);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshoiraishokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshoiraishokai.ShujiiIkenshoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoirai.ShujiiIkenshoIraiEntity;

/**
 * 認定調査情報のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0200-030 zhangzhiming
 */
public interface IShujiiIkenshoIraiMapper {

    /**
     * 認定調査情報取得します。
     *
     * @param param ShujiiIkenshoMapperParameter
     * @return KoseiShichosonMasterEntity
     */
    List<ShujiiIkenshoIraiEntity> selectNinnteiChousa(ShujiiIkenshoMapperParameter param);
}

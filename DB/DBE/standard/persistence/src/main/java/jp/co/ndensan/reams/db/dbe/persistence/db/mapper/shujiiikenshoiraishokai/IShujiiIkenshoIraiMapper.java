/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.shujiiikenshoiraishokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoirai.ShujiiIkenshoIraiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 認定調査情報のマッパーインタフェースです。
 */
public interface IShujiiIkenshoIraiMapper {

    /**
     * 認定調査情報取得します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return KoseiShichosonMasterEntity
     */
    List<ShujiiIkenshoIraiEntity> selectNinnteiChousa(HihokenshaNo hihokenshaNo);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.iraisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.iraisho.IraishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iraisho.IraishoIkkatsuHakkoRelateEntity;

/**
 * 依頼書一括発行のマッパーインタフェースです。
 */
public interface IIraishoIkkatsuHakkoMapper {

    /**
     * 認定調査一覧を検索します。
     *
     * @param param 依頼書一括発行のパラメータ
     * @return List<IraishoIkkatsuHakkoRelateEntity>
     */
    List<IraishoIkkatsuHakkoRelateEntity> getNinteiChousaIrai(IraishoIkkatsuHakkoParameter param);

    /**
     * 主治医意見書一覧を検索します。
     *
     * @param param 依頼書一括発行のパラメータ
     * @return List<IraishoIkkatsuHakkoRelateEntity>
     */
    List<IraishoIkkatsuHakkoRelateEntity> getShuziiIkenshoIrai(IraishoIkkatsuHakkoParameter param);

}

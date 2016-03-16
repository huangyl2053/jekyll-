/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;

/**
 * 主治医意見書提出依頼書発行のマッパーインタフェースです。
 */
public interface IShujiiIkenshoTeishutsuIraishoHakkoMapper {

    /**
     * 主治医意見書提出依頼書発行を取得します。
     *
     * @param param 主治医意見書提出依頼書発行のパラメータ
     * @return List<ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity>
     */
    List<ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity> get主治医意見書提出依頼書発行(ShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter param);

    /**
     * 主治医意見書作成依頼情報を更新します。
     *
     * @param entity DbT5301ShujiiIkenshoIraiJohoEntity
     * @return 更新件数
     */
    int update主治医意見書作成依頼情報(DbT5301ShujiiIkenshoIraiJohoEntity entity);
}

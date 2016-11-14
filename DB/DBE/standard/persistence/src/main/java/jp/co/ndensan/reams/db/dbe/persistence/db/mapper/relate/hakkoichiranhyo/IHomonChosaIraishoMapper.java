/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.HomonChosaIraishoMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;

/**
 * 訪問調査依頼書発行のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public interface IHomonChosaIraishoMapper {

    /**
     * 認定調査依頼発行一覧表を取得します。
     *
     * @param param 訪問調査依頼書発行のパラメータ
     * @return List<HomonChosaIraishoRelateEntity>
     */
    List<HomonChosaIraishoRelateEntity> get訪問調査依頼書(HomonChosaIraishoMybitisParamter param);

    /**
     * 認定調査依頼情報を検索します。
     *
     * @param entity HomonChosaIraishoRelateEntity
     * @return DbT5201NinteichosaIraiJohoEntity
     */
    DbT5201NinteichosaIraiJohoEntity get認定調査依頼情報(HomonChosaIraishoRelateEntity entity);

    /**
     * 認定調査依頼履歴一覧を取得します。
     *
     * @return List<HomonChosaIraishoRelateEntity>
     */
    List<HomonChosaIraishoRelateEntity> get認定調査依頼履歴一覧();
}

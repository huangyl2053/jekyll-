/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hoshushiharaijunbipanel;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hoshushiharaijunbipanel.HoshushiharaiJumbiPanelBatchMybitisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbipanel.HoshushiharaiJumbiPanelBatchRelateEntity;

/**
 * バッチ設計_DBE622001_支払いデータ作成マッパーインタフェースです
 *
 * @reamsid_L DBE-1990-020 lizhuoxuan
 */
public interface IHoshuShiharaiJunbiPanelMapper {

    /**
     * 検索条件より、適当な条件を連結して、認定調査対象を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshushiharaiJumbiPanelBatchRelateEntity 検索結果の{@link HoshushiharaiJumbiPanelBatchRelateEntity}
     */
    List<HoshushiharaiJumbiPanelBatchRelateEntity> get認定調査対象(HoshushiharaiJumbiPanelBatchMybitisParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、主治医意見書作成報酬を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshushiharaiJumbiPanelBatchRelateEntity 検索結果の{@link HoshushiharaiJumbiPanelBatchRelateEntity}
     */
    List<HoshushiharaiJumbiPanelBatchRelateEntity> get主治医意見書作成報酬(HoshushiharaiJumbiPanelBatchMybitisParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、審査会委員報酬を検索する。
     *
     * @param 検索条件 検索条件
     * @return HoshushiharaiJumbiPanelBatchRelateEntity 検索結果の{@link HoshushiharaiJumbiPanelBatchRelateEntity}
     */
    List<HoshushiharaiJumbiPanelBatchRelateEntity> get審査会委員報酬(HoshushiharaiJumbiPanelBatchMybitisParameter 検索条件);
}

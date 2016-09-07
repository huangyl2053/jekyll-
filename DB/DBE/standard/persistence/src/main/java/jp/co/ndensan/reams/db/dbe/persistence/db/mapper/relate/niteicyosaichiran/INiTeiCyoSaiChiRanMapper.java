/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.niteicyosaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.niteicyosaichiran.NiTeiCyoSaiChiRanParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niteicyosaichiran.NiTeiCyoSaiChiRanRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niteicyosaichiran.NinteichosahyoGaikyoChosaRelateEntity;

/**
 *
 * 認定調査データ取込（モバイル）Mapperクラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
public interface INiTeiCyoSaiChiRanMapper {

    /**
     * 認定調査一覧の検索。
     *
     * @param parameter NiTeiCyoSaiChiRanParameter
     * @return NiTeiCyoSaiChiRanRelateEntity 認定調査データ取込
     */
    List<NiTeiCyoSaiChiRanRelateEntity> get認定調査一覧(NiTeiCyoSaiChiRanParameter parameter);

    /**
     * 認定調査一覧の検索。
     *
     * @param parameter NiTeiCyoSaiChiRanParameter
     * @return NinteichosahyoGaikyoChosaRelateEntity 認定調査一覧
     */
    List<NinteichosahyoGaikyoChosaRelateEntity> getNinteichosahyoGaikyoChosa(NiTeiCyoSaiChiRanParameter parameter);
}

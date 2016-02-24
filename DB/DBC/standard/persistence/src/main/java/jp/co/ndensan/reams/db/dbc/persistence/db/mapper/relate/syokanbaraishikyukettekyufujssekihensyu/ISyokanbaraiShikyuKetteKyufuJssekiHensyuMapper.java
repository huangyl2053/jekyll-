/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraishikyukettekyufujssekihensyu;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraishikyukettekyufujssekihensyu.SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraishikyukettekyufujssekihensyu.DealKyufujissekiEntity;

/**
 * 宛名取得PSM取得するマッパーインタフェースです。
 */
public interface ISyokanbaraiShikyuKetteKyufuJssekiHensyuMapper {

    /**
     * 宛名取得PSM取得
     *
     * @param parameter parameter
     * @return DealKyufujissekiEntity
     */
    DealKyufujissekiEntity get宛名(SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter parameter);
}

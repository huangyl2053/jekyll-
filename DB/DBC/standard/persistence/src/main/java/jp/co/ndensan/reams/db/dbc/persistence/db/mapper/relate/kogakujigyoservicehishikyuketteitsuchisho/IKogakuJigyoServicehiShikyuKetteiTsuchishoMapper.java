/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakujigyoservicehishikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraishikyukettekyufujssekihensyu.SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraishikyukettekyufujssekihensyu.DealKyufujissekiEntity;

/**
 * 高額総合事業サービス費支給（不支給）決定通知書作成する用マッパーインタフェースです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
public interface IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper {

    /**
     * 宛名取得PSM取得
     *
     * @param parameter parameter
     * @return DealKyufujissekiEntity
     */
    DealKyufujissekiEntity get宛名(SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter parameter);
}

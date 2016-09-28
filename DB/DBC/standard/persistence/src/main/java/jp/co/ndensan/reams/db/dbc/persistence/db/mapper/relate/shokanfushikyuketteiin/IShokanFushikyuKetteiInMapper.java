/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanfushikyuketteiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;

/**
 * 償還払不支給決定情報取込出力対象データ取得
 *
 * @reamsid_L DBC-2590-010 liuxiaoyu
 */
public interface IShokanFushikyuKetteiInMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter Map<String, Object>
     * @return List<ShokanFushikyuKetteiInEntity>
     */
    List<ShokanFushikyuKetteiInEntity> select一時テーブル(KokuhorenIchiranhyoMybatisParameter parameter);
}

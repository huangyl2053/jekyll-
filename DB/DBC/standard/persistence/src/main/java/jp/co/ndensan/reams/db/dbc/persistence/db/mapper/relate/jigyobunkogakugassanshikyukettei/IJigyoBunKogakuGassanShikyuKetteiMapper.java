/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jigyobunkogakugassanshikyukettei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigyobunkogakugassanshikyukettei.JigyoBunKogakuGassanShikyuKetteiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jigyobunkogakugassanshikyukettei.JigyoBunKogakuGassanShikyuKetteiRelateEntity;

/**
 * 汎用リスト_事業分高額合算支給決定情報のマッパーインタフェースです。
 *
 * @reamsid_L DBC-5060-030 duanzhanli
 */
public interface IJigyoBunKogakuGassanShikyuKetteiMapper {

    /**
     * 事業分高額合算支給決定情報データを取得します。
     *
     * @param parameter JigyoBunKogakuGassanShikyuKetteiMybatisParameter
     * @return List<JigyoBunKogakuGassanShikyuKetteiRelateEntity>
     */
    List<JigyoBunKogakuGassanShikyuKetteiRelateEntity> get事業分高額合算支給決定情報(JigyoBunKogakuGassanShikyuKetteiMybatisParameter parameter);

}

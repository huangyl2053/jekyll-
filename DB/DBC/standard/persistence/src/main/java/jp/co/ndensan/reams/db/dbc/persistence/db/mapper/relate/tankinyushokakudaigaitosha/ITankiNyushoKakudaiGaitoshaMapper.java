/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.tankinyushokakudaigaitosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.tankinyushokakudaigaitosha.TankiNyushoKakudaiGaitoshaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.tankinyushokakudaigaitosha.TankiNyushoKakudaiGaitoshaRelateEntity;

/**
 * 汎用リスト_短期入所拡大該当者情報のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3111-020 duanzhanli
 */
public interface ITankiNyushoKakudaiGaitoshaMapper {

    /**
     * 汎用リスト_短期入所拡大該当者情報データを取得します。
     *
     * @param parameter TankiNyushoKakudaiGaitoshaMybatisParameter
     * @return List<JigyoBunKogakuGassanShikyuKetteiRelateEntity>
     */
    List<TankiNyushoKakudaiGaitoshaRelateEntity> get短期入所拡大該当者情報(TankiNyushoKakudaiGaitoshaMybatisParameter parameter);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hanyolistkokuhorenjukyusha;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkokuhorenjukyusha.HanyoListKokuhorenJukyushaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkokuhorenjukyusha.HanyoListKokuhorenJukyushaRelateEntity;

/**
 * 汎用リスト 国保連受給者情報ビジネスのマッパーインタフェースです。
 *
 * @reamsid_L DBC-3104-020 yaodongsheng
 */
public interface IHanyoListKokuhorenJukyushaMapper {

    /**
     * 汎用リスト 国保連受給者情報データを取得します。
     *
     * @param parameter HanyoListKokuhorenJukyushaMybatisParameter
     * @return List<HanyoListKokuhorenJukyushaRelateEntity>
     */
    List<HanyoListKokuhorenJukyushaRelateEntity> get国保連受給者情報(HanyoListKokuhorenJukyushaMybatisParameter parameter);
}

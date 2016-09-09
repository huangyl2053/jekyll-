/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc710050;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710050.HanyoListKyodoJukyushaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710050.KyodoJukyushaKihonEntity;

/**
 * 汎用リスト_共同処理用受給者情報（基本）CSVデータのバッチのDB操作です。
 *
 *
 * @reamsid_L DBC-3097-020 qinzhen
 */
public interface IHanyoListKyodoJukyushaMapper {

    /**
     * 共同処理用受給者情報データを取得する。
     *
     * @param param param
     * @return {@link List<KyodoJukyushaKihonEntity>}
     */
    List<KyodoJukyushaKihonEntity> select共同処理用受給者情報(HanyoListKyodoJukyushaMybatisParameter param);
}

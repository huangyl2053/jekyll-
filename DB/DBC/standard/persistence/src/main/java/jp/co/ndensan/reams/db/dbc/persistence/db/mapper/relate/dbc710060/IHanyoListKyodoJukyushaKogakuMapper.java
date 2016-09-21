/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc710060;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710060.HanyoListKyodoJukyushaKogakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710060.HanyoListKyodoJukyushaKogakuEntity;

/**
 * 汎用リスト 共同処理用受給者情報（高額）CSVデータのバッチのDB操作です。
 *
 * @reamsid_L DBC-3098-020 xushouyue
 */
public interface IHanyoListKyodoJukyushaKogakuMapper {

    /**
     * 共同処理用受給者情報（高額）データを取得する。
     *
     * @param param param
     * @return {@link List<HanyoListKyodoJukyushaKogakuEntity>}
     */
    List<HanyoListKyodoJukyushaKogakuEntity> select共同受給者高額情報(HanyoListKyodoJukyushaKogakuMybatisParameter param);
}

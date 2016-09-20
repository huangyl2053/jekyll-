/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc710070;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710070.HanyoListKyodoJukyushaShokanMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710070.KyodoJukyushaShokanEntity;

/**
 * 汎用リスト_共同処理用受給者情報（償還）CSVデータのバッチのDB操作です。
 *
 *
 * @reamsid_L DBC-3099-020 zhouchuanlin
 */
public interface IHanyoListKyodoJukyushaShokanMapper {

    /**
     * 共同処理用受給者異動償還情報データを取得する。
     *
     * @param param HanyoListKyodoJukyushaShokanMybatisParameter
     * @return {@link List<KyodoJukyushaShokanEntity>}
     */
    List<KyodoJukyushaShokanEntity> select共同処理用受給者異動償還情報(HanyoListKyodoJukyushaShokanMybatisParameter param);
}

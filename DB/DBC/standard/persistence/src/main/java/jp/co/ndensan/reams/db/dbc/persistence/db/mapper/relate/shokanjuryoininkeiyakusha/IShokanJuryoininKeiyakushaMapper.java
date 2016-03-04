/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanjuryoininkeiyakusha;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaListParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakushaEntity;

/**
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会のマッパーインタフェースです。
 */
public interface IShokanJuryoininKeiyakushaMapper {

    /**
     * 契約事業者一覧リスト取得
     *
     * @param parameter parameter
     * @return List<DbT3078ShokanJuryoininKeiyakushaEntity>
     */
    List<DbT3078ShokanJuryoininKeiyakushaEntity> get契約事業者一覧(ShokanJuryoininKeiyakushaListParameter parameter);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDataEntity;

/**
 * 振込データ作成
 *
 * @reamsid_L DBC-2830-030 donghj
 */
public interface IFurikomiDataMapper {

    /**
     * 振込対象データ取得です。
     *
     * @return {@link List<FurikomiDataEntity>}
     */
    List<FurikomiDataEntity> get振込対象データ();

}

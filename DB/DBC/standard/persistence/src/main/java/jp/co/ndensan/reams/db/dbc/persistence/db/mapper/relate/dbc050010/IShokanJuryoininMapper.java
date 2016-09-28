/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShokanJuryoininEntity;

/**
 * 償還受領委任払の口座情報取得
 *
 * @reamsid_L DBC-2180-030 donghj
 */
public interface IShokanJuryoininMapper {

    /**
     * 償還受領委任払の口座情報取得
     *
     * @return List<ShokanJuryoininEntity>
     */
    List<ShokanJuryoininEntity> get償還受領委任払の口座情報();

}

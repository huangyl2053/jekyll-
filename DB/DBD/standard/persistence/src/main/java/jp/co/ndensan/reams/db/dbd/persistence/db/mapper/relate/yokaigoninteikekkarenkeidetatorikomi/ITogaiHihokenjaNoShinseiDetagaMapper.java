/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteikekkarenkeidetatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.TogaiHihokenjaNoShinseiDetagaEntity;

/**
 * 当該被保険者の申請データが存在するかどうかチェックのマッパーインタフェースです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public interface ITogaiHihokenjaNoShinseiDetagaMapper {

    /**
     * 当該被保険者の申請データが存在
     *
     * @return 当該被保険者の申請データが存在
     */
    List<TogaiHihokenjaNoShinseiDetagaEntity> get当該被保険者の申請データが存在();
}

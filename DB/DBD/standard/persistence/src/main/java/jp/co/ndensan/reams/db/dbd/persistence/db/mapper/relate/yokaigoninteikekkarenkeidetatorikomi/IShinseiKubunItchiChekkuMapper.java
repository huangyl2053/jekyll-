/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteikekkarenkeidetatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.ShinseiKubunItchiChekkuEntity;

/**
 * 申請区分一致チェックのマッパーインタフェースです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public interface IShinseiKubunItchiChekkuMapper {

    /**
     * 申請区分一致
     *
     * @return 申請区分一致
     */
    List<ShinseiKubunItchiChekkuEntity> get申請区分一致();

}

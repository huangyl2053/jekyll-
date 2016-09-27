/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteikekkarenkeidetatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.HokenShaKodochekkuEntity;

/**
 * 保険者コードチェックデータ検索のマッパーインタフェースです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public interface IHokenShaKodochekkuMapper {

    /**
     * 保険者コードチェックデータ検索
     *
     * @return 保険者コードチェックデータ検索
     */
    List<HokenShaKodochekkuEntity> get保険者コードチェックデータ検索();

}

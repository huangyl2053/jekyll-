/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.riyoshatemptables;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;

/**
 * 判定対象者Tempのインターフェースクラスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public interface IHanteiTaishoshaTempMapper {

    /**
     * selectTempAllのメソドです。
     *
     * @return List<HanteiTaishoshaTempEntity>
     */
    List<HanteiTaishoshaTempEntity> selectHanteiTaishoshaTempAll();
}

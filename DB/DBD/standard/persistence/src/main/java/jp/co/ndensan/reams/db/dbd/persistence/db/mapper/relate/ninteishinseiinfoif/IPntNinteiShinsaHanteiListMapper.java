/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseiinfoif;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519001.PntNinteiShinsaHanteiListMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.PntNinteiShinsaHanteiListEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査判定データを取得します。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
public interface IPntNinteiShinsaHanteiListMapper {

    /**
     * 介護認定審査判定データを取得します。
     *
     * @return List<PntNinteiShinsaHanteiListEntity>
     */
    List<PntNinteiShinsaHanteiListEntity> select介護認定審査判定データ();

    /**
     * 市町村名を取得します。
     *
     * @param parameter PntNinteiShinsaHanteiListMybatisParameter
     * @return List<DbT7051KoseiShichosonMasterEntity>
     */
    List<RString> select市町村名(PntNinteiShinsaHanteiListMybatisParameter parameter);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;

/**
 * 計算後情報作成のマッパーインタフェースです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 *
 */
public interface IKeisanTyukanTempMapper {

    /**
     * 計算中間Temp情報を取得します。
     *
     * @return List<DbTKeisangoJohoTempTableEntity>
     */
    List<DbTKeisangoJohoTempTableEntity> getgetEntity();

}

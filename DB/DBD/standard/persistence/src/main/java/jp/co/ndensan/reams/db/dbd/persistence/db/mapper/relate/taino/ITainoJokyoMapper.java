/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.taino;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.taino.TainoJokyoMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.taino.TainoJohoRelateEntity;

/**
 * 滞納状況取得のマッパーインタフェースです。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public interface ITainoJokyoMapper {

    /**
     * 滞納情報を取得する
     *
     * @param param 滞納状況取得のパラメータ
     * @return 滞納情報
     */
    List<TainoJohoRelateEntity> selectTainoJoho(TainoJokyoMapperParameter param);
}

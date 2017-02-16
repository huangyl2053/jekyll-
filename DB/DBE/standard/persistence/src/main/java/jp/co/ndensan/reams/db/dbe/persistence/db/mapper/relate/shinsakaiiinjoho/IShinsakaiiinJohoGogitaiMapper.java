/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinjoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinjoho.ShinsakaiIinJohoKaisaiMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjohogogitai.ShinsakaiIinJohoGoitaiEntity;

/**
 *
 * 介護認定審査会委員情報のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0130-060 yaodongsheng
 */
public interface IShinsakaiiinJohoGogitaiMapper {

    /**
     * 介護認定審査会委員情報リストの取得処理です。
     *
     * @param mapper IShinsakaiiinJohoGogitaiMapper
     * @return List<ShinsakaiIinJohoGoitaiEntity>
     */
    List<ShinsakaiIinJohoGoitaiEntity> search審査会委員情報(ShinsakaiIinJohoKaisaiMapperParameter mapper);
}

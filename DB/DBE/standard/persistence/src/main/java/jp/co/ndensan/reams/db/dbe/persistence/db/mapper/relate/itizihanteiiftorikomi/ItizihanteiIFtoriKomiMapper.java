/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.itizihanteiiftorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.itizihanteiiftorikomi.ItizihanteiIFtoriKomiRelateEntity;

/**
 * バッチ設計_DBE309002_一次判定IF取込のMapperクラスです。
 *
 * @reamsid_L DBE-1470-022 wanghui
 */
public interface ItizihanteiIFtoriKomiMapper {

    /**
     * 当該被保険者の申請状況チェック。
     *
     * @return ItizihanteiIFtoriKomiRelateEntity
     */
    List<ItizihanteiIFtoriKomiRelateEntity> gethihokenshaNo();

}

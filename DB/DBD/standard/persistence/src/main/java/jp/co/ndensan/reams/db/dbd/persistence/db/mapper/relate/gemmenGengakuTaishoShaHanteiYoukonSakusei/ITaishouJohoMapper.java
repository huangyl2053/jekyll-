/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenGengakuTaishoShaHanteiYoukonSakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenGengakuTaishoShaHanteiYoukonSakusei.GemmenGengakuTaishoShaHanteiYoukonSakuseiMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenGengakuTaishoShaHanteiYoukonSakusei.TaishouJohoEntity;

/**
 * 対象情報を取得のMapperクラスです。
 *
 * @reamsid_L DBD-3710-090 liuwei2
 */
public interface ITaishouJohoMapper {

    List<TaishouJohoEntity> get対象情報(GemmenGengakuTaishoShaHanteiYoukonSakuseiMyBatisParameter Parameter);

}

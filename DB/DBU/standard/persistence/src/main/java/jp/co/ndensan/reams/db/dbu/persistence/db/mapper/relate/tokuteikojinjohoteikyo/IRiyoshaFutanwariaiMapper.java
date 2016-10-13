/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.RiyoshaFutanwariaiMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.RiyoshaFutanwariaiRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;

/**
 * 負担割合のmapperクラスです。
 *
 * @reamsid_L DBU-4880-060 zhaoyao
 */
public interface IRiyoshaFutanwariaiMapper {

    /**
     * 提供情報(候補)の取得処理です。
     *
     * @param parameter RiyoshaFutanwariaiMybatisParameter
     * @return List<RiyoshaFutanwariaiRelateEntity>
     */
    List<RiyoshaFutanwariaiRelateEntity> get提供情報_候補(RiyoshaFutanwariaiMybatisParameter parameter);

    /**
     * 提供対象者の取得処理です。
     *
     * @return List<TeikyoKihonJohoEntity>
     */
    List<TeikyoKihonJohoNNTempEntity> get提供対象者();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.HihokenshaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.HihokenshaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.JukyushaTeikyoKihonJohoNNTempEntity;

/**
 * 被保険者情報のバッチ処理です。
 *
 * @reamsid_L DBU-4880-030 zhaoyao
 */
public interface IHihokenshaJohoMapper {

    /**
     * 提供情報(候補)の取得処理です。
     *
     * @param parameter HihokenshaJohoMybatisParameter
     * @return List<RiyoshaFutanwariaiRelateEntity>
     */
    List<HihokenshaJohoRelateEntity> get提供情報_候補(HihokenshaJohoMybatisParameter parameter);

    /**
     * 提供対象者の取得処理です。
     *
     * @param parameter HihokenshaJohoMybatisParameter
     * @return List<TeikyoKihonJohoEntity>
     */
    List<JukyushaTeikyoKihonJohoNNTempEntity> get提供対象者(HihokenshaJohoMybatisParameter parameter);
}

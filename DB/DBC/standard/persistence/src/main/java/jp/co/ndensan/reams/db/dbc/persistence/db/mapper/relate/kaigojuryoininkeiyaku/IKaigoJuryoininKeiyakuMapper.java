/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigojuryoininkeiyaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigojuryoininkeiyaku.KaigoJuryoininKeiyakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigojuryoininkeiyakujigyoshaichirahyo.KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity;

/**
 * ビジネス設計_DBCMN32001_受領委任契約事業者一覧表取得です.
 *
 * @reamsid_L DBC-2110-050 liuxiaoyu
 */
public interface IKaigoJuryoininKeiyakuMapper {

    /**
     * 受領委任契約事業者一覧表-取得する。
     *
     * @param parameter KaigoJuryoininKeiyakuMybatisParameter
     * @return List<KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity>
     */
    List<KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity> select受領委任契約事業者(KaigoJuryoininKeiyakuMybatisParameter parameter);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc010020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc010020.KogakuServicehiJuryoininKeiyakuShoninKakuninshoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010020.KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書作成のマッパインタフェースクラスです。
 *
 * @reamsid_L DBC-1970-030 zhouchuanlin
 */
public interface IKogakuServicehiJuryoininKeiyakuShoninKakuninshoMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter KogakuServicehiJuryoininKeiyakuShoninKakuninshoMybatisParameter
     * @return List<KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity>
     */
    List<KogakuServicehiJuryoininKeiyakuShoninKakuninshoEntity> get高額受領委任契約事業者情報データ(
            KogakuServicehiJuryoininKeiyakuShoninKakuninshoMybatisParameter parameter);
}

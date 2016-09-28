package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc010010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc010010.JuryoininKeiyakuShoninKakuninshoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010010.JuryoininKeiyakuShoninKakuninshoEntity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 介護保険受領委任契約承認（不承認）確認書対象データ取得
 *
 * @reamsid_L DBC-1910-030 yuanzhenxia
 */
public interface IJuryoininKeiyakuShoninKakuninshoMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter JuryoininKeiyakuShoninKakuninshoMybatisParameter
     * @return List<JuryoininKeiyakuShoninKakuninshoEntity>
     */
    List<JuryoininKeiyakuShoninKakuninshoEntity> get受領委任データ(JuryoininKeiyakuShoninKakuninshoMybatisParameter parameter);

}

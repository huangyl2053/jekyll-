/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.idoriyoshafutanwariaihentei;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.idoriyoshafutanwariaihentei.IdoRiyoshaFutanwariaiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 高額サービス費給付お知らせ通知書作成マッパーインタフェースです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public interface IIdoRiyoshaFutanwariaiHanteiMapper {

    /**
     * 処理日付管理情報を取得します。
     *
     * @param parameter parameter
     * @return Entity
     */
    DbT7022ShoriDateKanriEntity selectMaxRenban(IdoRiyoshaFutanwariaiHanteiMybatisParameter parameter);
}

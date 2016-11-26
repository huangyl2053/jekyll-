/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kanendoriyoshafutanwariaihantei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kanendoriyoshafutanwariaihantei.KanendoRiyoshaFutanwariaiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 処理日付管理情報を取得クラス.
 *
 * @reamsid_L DBC-4940-030 wangrenze
 */
public interface IKanendoRiyoshaFutanwariaiHanteiMapper {

    /**
     * 更新対象（処理名）のデータを取得します。
     *
     * @param parameter parameter
     * @return date List<DbT7022ShoriDateKanriEntity>
     */
    List<DbT7022ShoriDateKanriEntity> selectDate(KanendoRiyoshaFutanwariaiHanteiMybatisParameter parameter);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.KanendoUpdateFutanwariaiHanteMybatisParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 処理日付管理マスタ更新のmapperです
 *
 * @reamsid_L DBC-2180-030 x_miaocl
 */
public interface IKanendoUpdateFutanwariaiHanteiMapper {

    /**
     * 処理日付管理マスタ更新
     *
     * @param parameter 処理日付管理マスタ更新SQL用パラメター
     * @return 処理日付管理マスタ情報
     */
    List<DbT7022ShoriDateKanriEntity> get処理日付管理マスタ更新(KanendoUpdateFutanwariaiHanteMybatisParameter parameter);

    /**
     * 処理日付管理マスタデータなし
     *
     * @return 処理日付管理マスタデータなし情報
     */
    List<DbT7022ShoriDateKanriEntity> get処理日付管理マスタデータなし();
}

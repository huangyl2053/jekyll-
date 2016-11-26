/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.idoufunriyoushyafutankanendo;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.idoufunriyoushyafutankanendo.IdoufunRiyoushyafutanKanendoMybatisParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動分利用者負担割合判定（過年度）のMapperクラスです。
 *
 * @reamsid_L DBC-4940-010 wangrenze
 */
public interface IIdoufunRiyoushyafutanKanendoMapper {

    /**
     * 直近の年次負担割合判定処理のデータを取得です.
     *
     * @param 処理名 処理名
     * @return 直近の年次負担割合判定処理のデータ DbT7022ShoriDateKanriEntity
     */
    DbT7022ShoriDateKanriEntity get直近の年次負担割合判定処理(RString 処理名);

    /**
     * 処理年度の異動分利用者負担割合判定_過年度のデータを取得です.
     *
     * @param 処理名 処理名
     * @return 処理年度の異動分利用者負担割合判定_過年度のデータ ShoriDateKanri
     */
    DbT7022ShoriDateKanriEntity get処理年度の異動分利用者負担割合判定_過年度のデータ(RString 処理名);

    /**
     * 異動分利用者負担割合判定のデータを取得です.
     *
     * @param parameter IdoufunRiyoushyafutanKanendoMybatisParameter
     * @return 異動分利用者負担割合判定のデータ ShoriDateKanri
     */
    DbT7022ShoriDateKanriEntity get異動分利用者負担割合判定のデータ(IdoufunRiyoushyafutanKanendoMybatisParameter parameter);
}

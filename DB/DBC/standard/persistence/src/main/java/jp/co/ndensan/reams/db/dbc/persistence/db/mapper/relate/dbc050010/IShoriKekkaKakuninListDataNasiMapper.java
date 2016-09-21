/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;

/**
 * 処理結果確認リスト一時_振込データなしのmapperです
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
public interface IShoriKekkaKakuninListDataNasiMapper {

    /**
     * 処理結果確認リスト一時の情報取得します．
     *
     * @return 処理結果確認リスト一時の情報
     */
    List<ShoriKekkaKakuninListTempTableEntity> select処理結果確認リスト一時情報();
}

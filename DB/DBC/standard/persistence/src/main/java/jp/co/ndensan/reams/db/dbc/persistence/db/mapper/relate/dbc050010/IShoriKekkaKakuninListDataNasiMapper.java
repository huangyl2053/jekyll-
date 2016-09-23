/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;

/**
 * 処理結果確認リスト一時_振込データなしのmapperです
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
public interface IShoriKekkaKakuninListDataNasiMapper {

    /**
     * 振込明細一時一時の情報取得します．
     *
     * @return 振込明細一時一時の情報
     */
    List<FurikomiDetailTempTableEntity> select振込明細一時情報();
}

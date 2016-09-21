/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;

/**
 * 振込明細一覧表作成_受申請データ有無確認のMapperクラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
public interface IShinseiDataKakuninMapper {

    /**
     * 振込明細一時情報を取得します．
     *
     * @return 振込明細一時情報
     */
    List<FurikomiDetailTempTableEntity> select申請データ有無確認情報();
}

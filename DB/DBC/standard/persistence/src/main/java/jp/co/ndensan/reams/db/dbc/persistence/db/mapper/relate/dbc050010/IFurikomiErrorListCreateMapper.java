/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;

/**
 * 振込エラーリスト作成と処理結果確認リスト情報_データ取得のMapperクラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
public interface IFurikomiErrorListCreateMapper {

    /**
     * 振込明細一時情報を取得します．
     *
     * @return 振込明細一時情報
     */
    List<FurikomiDetailTempTableEntity> select振込エラーリスト情報();

    /**
     * 処理結果確認リスト情報を取得します．
     *
     * @return 処理結果確認リスト情報
     */
    List<ShoriKekkaKakuninListTempTableEntity> select処理結果確認リスト情報();

}

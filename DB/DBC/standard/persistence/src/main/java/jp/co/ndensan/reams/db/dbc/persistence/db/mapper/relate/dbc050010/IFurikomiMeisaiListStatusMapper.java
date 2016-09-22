/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiMeisaiListStatusEntity;

/**
 * 振込明細一覧表作成_受給取得状況データ取得のMapperクラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
public interface IFurikomiMeisaiListStatusMapper {

    /**
     * 受給取得状況情報を取得します．
     *
     * @return 受給取得状況情報
     */
    List<FurikomiMeisaiListStatusEntity> select受給取得状況情報();
}

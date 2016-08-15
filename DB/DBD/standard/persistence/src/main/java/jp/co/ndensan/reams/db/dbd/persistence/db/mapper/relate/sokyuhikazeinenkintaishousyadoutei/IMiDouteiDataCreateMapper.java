/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.sokyuhikazeinenkintaishousyadoutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity;

/**
 * 未同定データ作成のマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-050 x_lilh
 */
public interface IMiDouteiDataCreateMapper {

    /**
     * 未同定データ作成情報を取得します．
     *
     * @return 未同定データ作成情報
     */
    List<DbT4037HikazeNenkinTaishoshaEntity> get未同定データ作成情報();
}

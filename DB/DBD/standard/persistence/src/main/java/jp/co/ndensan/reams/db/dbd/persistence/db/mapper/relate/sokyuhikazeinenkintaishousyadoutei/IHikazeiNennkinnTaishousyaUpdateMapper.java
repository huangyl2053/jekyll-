/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.sokyuhikazeinenkintaishousyadoutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity;

/**
 * 非課税年金対象者更新のマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-050 x_lilh
 */
public interface IHikazeiNennkinnTaishousyaUpdateMapper {

    /**
     * 非課税年金対象者情報を取得します．
     *
     * @return 非課税年金対象者情報
     */
    List<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> get非課税年金対象者情報();
}

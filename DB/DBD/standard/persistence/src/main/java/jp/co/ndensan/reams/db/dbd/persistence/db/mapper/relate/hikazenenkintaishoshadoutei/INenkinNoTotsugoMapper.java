/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.temptable.TorikomiTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.HikazeNenkinTaishoFirJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.NenkinNoCheckListJohoEntity;

/**
 * 年金番号突合のマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public interface INenkinNoTotsugoMapper {

    /**
     * 年金番号突合_非課税年金対象者情報を取得します．
     *
     * @return 年金番号突合_非課税年金対象者情報
     */
    List<HikazeNenkinTaishoFirJohoEntity> get年金番号突合_非課税年金対象者情報();

    /**
     * 該当情報なし情報を取得します．
     *
     * @return 該当情報なし
     */
    List<TorikomiTempTableEntity> get年金番号突合_該当情報なし();

    /**
     * 年金番号チェックリスト情報を取得します．
     *
     * @return 年金番号チェックリスト情報
     */
    List<NenkinNoCheckListJohoEntity> get年金番号突合_年金番号チェックリスト情報();
}

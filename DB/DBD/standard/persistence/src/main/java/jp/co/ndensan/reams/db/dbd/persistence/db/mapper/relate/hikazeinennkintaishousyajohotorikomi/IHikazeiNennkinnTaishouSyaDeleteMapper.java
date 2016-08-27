/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazeinennkintaishousyajohotorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity;

/**
 * 非課税年金対象者登録のマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-030 x_xuliang
 */
public interface IHikazeiNennkinnTaishouSyaDeleteMapper {

    /**
     * 非課税年金対象者同定結果情報一時のデータ情報を取得します．
     *
     * @return 非課税年金対象者同定結果情報一時のデータ情報
     */
    List<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> get非課税年金対象者同定結果情報一時のデータ情報();

    /**
     * BP_処理状態削除するを取得します．
     *
     * @return BP_処理状態削除する
     */
    List<DbT4037HikazeNenkinTaishoshaEntity> getBP_処理状態削除する();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazenenkintaishoshadoutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ShimeiKanaTotsugoGaitousyaNasiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ShimeiKanaTotsugoKensuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ShimeiKanaTotsugoResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ShimeiKanaTotsugoSedJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ShimeiKanaTotsugoTouItuninJohoEntity;

/**
 * 氏名カナ突合のマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public interface IShimeiKanaTotsugoMapper {

    /**
     * 該当年金情報なし一時情報を取得します．
     *
     * @return 該当年金情報なし一時情報
     */
    List<ShimeiKanaTotsugoResultEntity> get氏名カナ突合結果一時();

    /**
     * 氏名カナ突合結果件数一時情報を取得します．
     *
     * @return 氏名カナ突合結果件数一時情報
     */
    List<ShimeiKanaTotsugoKensuJohoEntity> get氏名カナ突合結果件数一時();

    /**
     * 非課税年金対象者情報を取得する
     *
     * @return HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity
     */
    List<ShimeiKanaTotsugoSedJohoEntity> get非課税年金対象者情報();

    /**
     * 該当者なし情報を取得する
     *
     * @return ShimeiKanaTotsugoGaitousyaNasiJohoEntity
     */
    List<ShimeiKanaTotsugoGaitousyaNasiJohoEntity> get該当者なし情報();

    /**
     * 同一人情報を取得する
     *
     * @return ShimeiKanaTotsugoTouItuninJohoEntity
     */
    List<ShimeiKanaTotsugoTouItuninJohoEntity> get同一人情報();
}

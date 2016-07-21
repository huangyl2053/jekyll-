/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenkolist;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.HenkouJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShiharaiHohoHenkoTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShunoJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 支払方法変更管理リスト作成_バッチ処理クラスです。
 *
 * @reamsid_L DBD-3630-040 liangbc
 */
public class PublishReportProcessSerivice {

    private static final RString RS申請中 = new RString("申請中");

    /**
     * コンストラクタです。
     */
    PublishReportProcessSerivice() {
    }

    /**
     * 【共有子Div】社会福祉法人軽減FinderのIntanceを作成します。
     *
     * @return ShakaiFukushiHojinKeigenFinder
     */
    public static PublishReportProcessSerivice createIntance() {
        return InstanceProvider.create(PublishReportProcessSerivice.class);
    }

//    /**
//     * 支払方法変更情報一時テーブルのentityを作成
//     *
//     * @param entity 支払方法変更管理リストのEntity
//     * @return 支払方法変更情報一時テーブルのentity
//     */
//    public ShiharaiHohoHenkoTempTableEntity createShiharaiHohoHenkoTempTableEntity(HenkouJohoEntity entity) {
//        RString 生保 = RString.EMPTY;
//        RString 申請中 = RString.EMPTY;
//        if (entity.getShikakuJohoEntitys().getgetShikibetsuCode() != null) {
//            生保 = RS申請中;
//        }
//        FlexibleDate 認定年月日 = entity.getDbt4001Entity().getNinteiYMD();
//        if (認定年月日 != null && !認定年月日.isEmpty()) {
//            申請中 = RS申請中;
//        }
//        return new ShiharaiHohoHenkoTempTableEntity(entity, 生保, 申請中);
//    }
    /**
     * 収納状況一時テーブルEntityを作成
     *
     * @param entity 支払方法変更管理リストのEntity
     * @return 支払方法変更情報一時テーブルのentity
     */
    public ShunoJohoTempTableEntity createShunoJohoTempTableEntity(HenkouJohoEntity entity) {
        ShunoJohoTempTableEntity tempTableEntity = new ShunoJohoTempTableEntity();
//        tempTableEntity.setChoteiNendo(entity.getChoteiNendo());
//        tempTableEntity.setFukaNendo(entity.getFukaNendo());
//        tempTableEntity.setTsuchishoNo(entity.getTsuchishoNo());
//        tempTableEntity.setKi(entity.getKi());
//        tempTableEntity.setHihokenshaNo(entity.getHihokenshaNo());
//        tempTableEntity.setShikibetsuCode(entity.getShikibetsuCode());
//        tempTableEntity.setNokigenYMD(entity.getNokigenYMD());
//        tempTableEntity.setChoteigaku(entity.getChoteigaku());
//        tempTableEntity.setShunyuYMD(entity.getShunyuYMD());
//        tempTableEntity.setShunyugaku(entity.getShunyugaku());
//        tempTableEntity.setTokusokujoHakkoYMD(entity.getTokusokujoHakkoYMD());
//        時効起算日と時効起算事由の設定(entity, tempTableEntity);
        return tempTableEntity;
    }

    private void 時効起算日と時効起算事由の設定(ShiharaiHohoHenkoTempTableEntity entity, ShunoJohoTempTableEntity tempTableEntity) {
        RDate 仮の時効起算日 = RDate.MIN;
        if (entity.getJikoKisanYMD() != null && !entity.getJikoKisanYMD().isEmpty()) {
            仮の時効起算日 = new RDate(entity.getJikoKisanYMD().toString());
        }
        if (entity.getTokusokujoHakkoYMD() != null && 仮の時効起算日.isBefore(entity.getTokusokujoHakkoYMD())) {
            仮の時効起算日 = entity.getTokusokujoHakkoYMD();
        }
        if (entity.getNokigenYMD() != null && 仮の時効起算日.isBefore(entity.getNokigenYMD().plusDay(1))) {
            仮の時効起算日 = entity.getNokigenYMD().plusDay(1);
        }

    }
}

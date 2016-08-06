/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.servicehishikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 高額サービス費支給決定通知書作成（バッチ）のクラスです。
 *
 * @reamsid_L DBC-2000-130 xicongwang
 */
public class ServicehiShikyuKetteiTsuchisho {

    /**
     * {@link InstanceProvider#create}にて生成した{@link ServicehiShikyuKetteiTsuchisho}のインスタンスを返します。
     *
     * @return ServicehiShikyuKetteiTsuchisho
     */
    public static ServicehiShikyuKetteiTsuchisho createInstance() {
        return InstanceProvider.create(ServicehiShikyuKetteiTsuchisho.class);
    }

    /**
     * 決定通知書情報取得するメソッドです。
     *
     * @param entity KetteiTsuchishoInfoTempResultEntity
     * @return KetteiTsuchishoInfoTempEntity 決定通知書情報
     */
    public KetteiTsuchishoInfoTempEntity to決定通知書情報(KetteiTsuchishoInfoTempResultEntity entity) {

        KetteiTsuchishoInfoTempEntity tmpEntity = new KetteiTsuchishoInfoTempEntity();
        tmpEntity.setHihokenshaNo(entity.get被保険者番号());
        tmpEntity.setServiceTeikyoYM(entity.getサービス提供年月());
        tmpEntity.setRirekiNo(entity.get履歴番号());
        tmpEntity.setShoKisaiHokenshaNo(entity.get証記載保険者番号());
        tmpEntity.setUketsukeYMD(entity.get受付年月日());
        tmpEntity.setShiharaiHohoKubunCode(entity.get支払方法区分コード());
        tmpEntity.setShiharaiBasho(entity.get支払場所());
        tmpEntity.setShiharaiKaishiYMD(entity.get支払期間開始年月日());
        tmpEntity.setShiharaiShuryoYMD(entity.get支払期間終了年月日());
        tmpEntity.setShiharaiKaishiTime(entity.get支払窓口開始時間());
        tmpEntity.setShiharaiShuryoTime(entity.get支払窓口終了期間());
        tmpEntity.setKetteiYMD(entity.get決定年月日());
        tmpEntity.setTsuchishoNo(entity.get決定通知No());
        tmpEntity.setFushikyuRiyu(entity.get不支給理由());
        return tmpEntity;
    }
}

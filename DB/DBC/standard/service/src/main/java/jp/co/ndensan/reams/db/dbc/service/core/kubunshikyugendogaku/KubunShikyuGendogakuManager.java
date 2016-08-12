/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kubunshikyugendogaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigoserviceshurui.KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * サービス種類登録Mangerです。
 *
 * @reamsid_L DBC-3350-010 jiangzongyue
 */
public class KubunShikyuGendogakuManager {

    private final DbT7130KaigoServiceShuruiDac kaigoServiceDac;

    /**
     * サービス種類登録クラスのコンストラクタです。
     */
    public KubunShikyuGendogakuManager() {

        kaigoServiceDac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);

    }

    /**
     * 利サービス種類登録クラスのコンストラクタです(テスト用)。
     *
     * @param kaigoServiceDac kaigoServiceDac
     */
    KubunShikyuGendogakuManager(DbT7130KaigoServiceShuruiDac kaigoServiceDac) {

        this.kaigoServiceDac = kaigoServiceDac;

    }

    /**
     * サービス種類登録を取得します。
     *
     * @return List<NinkaModel>
     */
    public List<KaigoServiceShurui> getサービス種類登録() {

        List<KaigoServiceShurui> lists = new ArrayList();
        for (DbT7130KaigoServiceShuruiEntity entity : kaigoServiceDac.selectサービス種類登録()) {
            KaigoServiceShuruiEntity kaigoServiceShuruiEntity = new KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.set介護サービス種類Entity(entity);
            lists.add(new KaigoServiceShurui(kaigoServiceShuruiEntity));
        }
        return lists;
    }

    /**
     * サービス種類登録を取得します。
     *
     * @param entity DbT7130KaigoServiceShuruiEntity
     */
    public void save(KaigoServiceShurui entity) {
        kaigoServiceDac.save(entity.toEntity());
    }

}

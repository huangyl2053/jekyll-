/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic.IDbT2013HokenryoDankaiMapper;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 保険料段階取得の共通クラスです。
 *
 * @reamsid_L DBB-9999-022 xuxin
 */
public class HokenryoDankaiSettings {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     *
     */
    public HokenryoDankaiSettings() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     */
    HokenryoDankaiSettings(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HokenryoDankaiSettings}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HokenryoDankaiSettings}のインスタンス
     */
    public static HokenryoDankaiSettings createInstance() {
        return InstanceProvider.create(HokenryoDankaiSettings.class);
    }

    /**
     * 現在の保険料段階をすべて返します。
     *
     * @return 保険料段階リスト(検索できない場合、nullを返す)
     */
    @Transaction
    public HokenryoDankaiList getCurrent保険料段階List() {

        List<HokenryoDankai> serviceShuruiList = new ArrayList<>();
        IDbT2013HokenryoDankaiMapper dbT2013HokenryoDankaiMapper = mapperProvider.create(IDbT2013HokenryoDankaiMapper.class);
        List<DbT2013HokenryoDankaiEntity> 保険料段階 = dbT2013HokenryoDankaiMapper.getHokenryoDankai();
        if (保険料段階 == null || 保険料段階.isEmpty()) {
            return new HokenryoDankaiList(serviceShuruiList);
        }
        for (DbT2013HokenryoDankaiEntity entity : 保険料段階) {
            serviceShuruiList.add(new HokenryoDankai(entity));
        }
        return new HokenryoDankaiList(serviceShuruiList);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2013HokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic.IDbT2013HokenryoDankaiMapper;
import jp.co.ndensan.reams.ur.urz.persistence.db.mapper.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 保険料段階取得のクラスです。
 */
public class HokenryoDankaiSettings {

    private final MapperProvider mapperProvider;
    private final DbT2013HokenryoDankaiDac 賦課年度dac;

    /**
     * コンストラクタです。
     *
     */
    public HokenryoDankaiSettings() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.賦課年度dac = InstanceProvider.create(DbT2013HokenryoDankaiDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param DbT2013HokenryoDankaiDac 保険料段階dac
     */
    HokenryoDankaiSettings(MapperProvider mapperProvider, DbT2013HokenryoDankaiDac 賦課年度dac) {
        this.mapperProvider = mapperProvider;
        this.賦課年度dac = 賦課年度dac;
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
     *
     * @return 保険料段階リスト(検索できない場合、nullを返す)
     */
    @Transaction
    public HokenryoDankaiList getCurrent保険料段階List() {

        IDbT2013HokenryoDankaiMapper IDbT2013HokenryoDankaiMapper = mapperProvider.create(IDbT2013HokenryoDankaiMapper.class);
        List<DbT2013HokenryoDankaiEntity> 保険料段階 = IDbT2013HokenryoDankaiMapper.getHokenryoDankai();
        if (保険料段階 == null || 保険料段階.isEmpty()) {
            return null;
        }
        List<HokenryoDankai> serviceShuruiList = new ArrayList<>();
        for (DbT2013HokenryoDankaiEntity entity : 保険料段階) {
            serviceShuruiList.add(new HokenryoDankai(entity));
        }
        return new HokenryoDankaiList(serviceShuruiList);
    }

    /**
     * 指定の年度の保険料段階をすべて返します。
     *
     *
     * @param 賦課年度 FlexibleYear
     * @return 保険料段階リスト(検索できない場合、nullを返す)
     */
    @Transaction
    public HokenryoDankaiList get保険料段階ListIn(FlexibleYear 賦課年度) {
        List<HokenryoDankai> serviceShuruiList = new ArrayList<>();
        List<DbT2013HokenryoDankaiEntity> 賦課年度リスタ = 賦課年度dac.selectDankaiByFukaNendo(賦課年度);
        if (賦課年度リスタ == null || 賦課年度リスタ.isEmpty()) {
            return null;
        }
        for (DbT2013HokenryoDankaiEntity entity : 賦課年度リスタ) {
            serviceShuruiList.add(new HokenryoDankai(entity));

        }
        return new HokenryoDankaiList(serviceShuruiList);
    }
}

package jp.co.ndensan.reams.db.dba.service;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.persistence.mapper.basic.ShichosonSentakuMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 市町村選択には、旧市町村選択情報を取得する、構成市町村選択情報を取得する機能を提供します。
 *
 */
public class ShichosonSentakuFinder {

    private final DbT7056GappeiShichosonDac dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ShichosonSentakuFinder() {
        this.dac = InstanceProvider.create(DbT7056GappeiShichosonDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @return
     */
    public static ShichosonSentakuFinder createInstance() {
        return InstanceProvider.create(ShichosonSentakuFinder.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7056GappeiShichosonDac}
     * @param dac {@link ShichosonSentakuMapper}
     */
    ShichosonSentakuFinder(DbT7056GappeiShichosonDac dac, MapperProvider mapperProvider) {
        this.dac = dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * 合併市町村選択情報を取得する。
     *
     * @param 基準日
     * @return 旧市町村選択情報取得
     */
    public List<DbT7056GappeiShichosonEntity> getGapeiShichosonSentaku(FlexibleDate 基準日) {
        List<DbT7056GappeiShichosonEntity> entityList = dac.selectfor合併市町村選択情報の取得処理(
                基準日);
        if (entityList.isEmpty()) {
            return new ArrayList();
        }
        return entityList;
    }

    /**
     * 構成市町村選択情報を取得する。
     *
     * @param 基準日
     * @return 構成市町村選択情報取得
     */
    public List<DbT7051KoseiShichosonMasterEntity> getKouseiShichosonSentaku(FlexibleDate 基準日) {
        ShichosonSentakuMapper mapper = mapperProvider.create(ShichosonSentakuMapper.class);
        List<DbT7051KoseiShichosonMasterEntity> mapperList = mapper.getEntity(基準日);
        if (mapperList.isEmpty()) {
            return new ArrayList();
        }
        return mapperList;
    }
}

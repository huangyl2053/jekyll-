/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.yokaigoninteijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiJoho;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho.YokaigoNinteiJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4003YokaigoNinteiInterfaceDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteijoho.IYokaigoNinteiJohoMapper;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.sikakuidocheck.SikakuIdoCheckManager;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定処理情報の処理します。
 *
 * @reamsid_L DBU-1530-010 lit
 */
public class YokaigoNinteiJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT4101NinteiShinseiJohoDac 要介護認定申請情報Dac;
    private final DbV4001JukyushaDaichoAliveDac 受給者台帳AliveDac;
    private final DbT4102NinteiKekkaJohoDac 要介護認定結果情報Dac;
    private final DbT4003YokaigoNinteiInterfaceDac 要介護認定インターフェース情報Dac;

    /**
     * コンストラクタです。
     */
    YokaigoNinteiJohoManager() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        要介護認定申請情報Dac = InstanceProvider.create(DbT4101NinteiShinseiJohoDac.class);
        受給者台帳AliveDac = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);
        要介護認定結果情報Dac = InstanceProvider.create(DbT4102NinteiKekkaJohoDac.class);
        要介護認定インターフェース情報Dac = InstanceProvider.create(DbT4003YokaigoNinteiInterfaceDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @@param mapperProvider MapperProvider
     */
    YokaigoNinteiJohoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
        要介護認定申請情報Dac = InstanceProvider.create(DbT4101NinteiShinseiJohoDac.class);
        受給者台帳AliveDac = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);
        要介護認定結果情報Dac = InstanceProvider.create(DbT4102NinteiKekkaJohoDac.class);
        要介護認定インターフェース情報Dac = InstanceProvider.create(DbT4003YokaigoNinteiInterfaceDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SikakuIdoCheckManager}のインスタンスを返します。
     *
     * @return SikakuIdoCheckManager
     *
     */
    public static YokaigoNinteiJohoManager createInstance() {
        return InstanceProvider.create(YokaigoNinteiJohoManager.class);

    }

    /**
     * 今回認定情報の取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定広域フラグ 認定広域フラグ
     * @return 今回認定情報 YokaigoNinteiJoho
     */
    public YokaigoNinteiJoho get今回認定情報(RString 申請書管理番号, boolean 認定広域フラグ) {
        IYokaigoNinteiJohoMapper mapper = mapperProvider.create(IYokaigoNinteiJohoMapper.class);
        List<YokaigoNinteiJohoEntity> entities = mapper.get今回認定情報(申請書管理番号, 認定広域フラグ);
        if (null != entities && !entities.isEmpty()) {
            YokaigoNinteiJohoEntity entity = entities.get(0);
            entity.initializeMd5ToEntities();
            return new YokaigoNinteiJoho(entity);
        }
        return null;
    }

    /**
     * 前回認定情報の取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 前回認定情報 YokaigoNinteiJoho
     */
    public YokaigoNinteiJoho get前回認定情報(RString 申請書管理番号) {
        IYokaigoNinteiJohoMapper mapper = mapperProvider.create(IYokaigoNinteiJohoMapper.class);
        List<YokaigoNinteiJohoEntity> entities = mapper.get前回認定情報(申請書管理番号);
        if (null != entities && !entities.isEmpty()) {
            YokaigoNinteiJohoEntity entity = entities.get(0);
            entity.initializeMd5ToEntities();
            return new YokaigoNinteiJoho(entity);
        }
        return null;
    }

    /**
     * 前回認定情報の取得します。
     *
     * @param 前回情報 YokaigoNinteiJoho
     * @param 今回情報 YokaigoNinteiJoho
     */
    @Transaction
    public void save(YokaigoNinteiJoho 前回情報, YokaigoNinteiJoho 今回情報) {

        if (null != 前回情報 && 前回情報.hasChanged()) {
            受給者台帳AliveDac.save(前回情報.get受給者台帳Entity());
        }
        if (null != 今回情報 && 今回情報.hasChanged()) {
            要介護認定申請情報Dac.save(今回情報.get要介護認定申請情報Entity());
            受給者台帳AliveDac.save(今回情報.get受給者台帳Entity());
            要介護認定結果情報Dac.save(今回情報.get要介護認定結果情報Entity());
            if (null != 今回情報.get要介護認定インターフェース情報Entity()) {
                要介護認定インターフェース情報Dac.save(今回情報.get要介護認定インターフェース情報Entity());
            }
        }
    }

    /**
     * Max履歴番号の取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return Max履歴番号 RString
     */
    public RString getMax履歴番号(RString 申請書管理番号) {
        IYokaigoNinteiJohoMapper mapper = mapperProvider.create(IYokaigoNinteiJohoMapper.class);
        return mapper.getMax履歴番号(申請書管理番号);
    }

}

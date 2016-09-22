/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.sabisunaiyoutouruku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sabisunaiyoutouruku.SabisuNaiyouTourukuInfo;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sabisunaiyoutouruku.SabisuNaiyouTourukuMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sabisunaiyoutouruku.SabisuNaiyouTourukuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sabisunaiyoutouruku.ISabisuNaiyouTourukuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * サービス内容登録Mangerです。
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
public class SabisuNaiyouTourukuManager {

    private final MapperProvider mapperProvider;
    private final DbT7131KaigoServiceNaiyouDac dbt7131Dac;

    /**
     * コンストラクタです。
     */
    public SabisuNaiyouTourukuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt7131Dac = InstanceProvider.create(DbT7131KaigoServiceNaiyouDac.class);

    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    SabisuNaiyouTourukuManager(MapperProvider mapperProvider, DbT7131KaigoServiceNaiyouDac dbt7131Dac) {
        this.mapperProvider = mapperProvider;
        this.dbt7131Dac = dbt7131Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SabisuNaiyouTourukuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link SabisuNaiyouTourukuManager}のインスタンス
     */
    public static SabisuNaiyouTourukuManager createInstance() {
        return InstanceProvider.create(SabisuNaiyouTourukuManager.class);
    }

    /**
     * サービス内容データ取得
     *
     * @param サービス種類コード RString
     * @param サービス項目コード RString
     *
     * @return List<SabisuNaiyouTourukuInfo>
     */
    @Transaction
    public List<SabisuNaiyouTourukuInfo> getサービス内容データ(RString サービス種類コード, RString サービス項目コード) {
        ISabisuNaiyouTourukuMapper mapper = mapperProvider.create(ISabisuNaiyouTourukuMapper.class);
        SabisuNaiyouTourukuMyBatisParameter param
                = new SabisuNaiyouTourukuMyBatisParameter(サービス種類コード, サービス項目コード);
        List<SabisuNaiyouTourukuEntity> entityList = mapper.getサービス内容(param);
        List<SabisuNaiyouTourukuInfo> サービス内容 = new ArrayList<>();
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        for (SabisuNaiyouTourukuEntity entity : entityList) {
            entity.initializeMd5ToEntity();
            SabisuNaiyouTourukuInfo info = new SabisuNaiyouTourukuInfo();
            info.setサービス分類コード(entity.getサービス分類コード());
            info.setサービス小分類(entity.getサービス小分類());
            info.setサービス内容(new KaigoServiceNaiyou(entity.get介護サービス内容()));
            サービス内容.add(info);
        }
        return サービス内容;
    }

    /**
     * サービス種類登録を取得します。
     *
     * @param entity DbT7130SabisuNaiyouTourukuEntity
     */
    public void save(KaigoServiceNaiyou entity) {
        if (!entity.hasChanged()) {
            return;
        }
        this.dbt7131Dac.save(entity.toEntity());
    }

    /**
     * サービス種類登録を削除します。
     *
     * @param entity DbT7130SabisuNaiyouTourukuEntity
     */
    public void delete(KaigoServiceNaiyou entity) {
        this.dbt7131Dac.delete(entity.toEntity());
    }

}

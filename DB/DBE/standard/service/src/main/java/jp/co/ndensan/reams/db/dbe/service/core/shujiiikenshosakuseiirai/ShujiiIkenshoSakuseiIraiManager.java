/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.ShujiiIraiAtenaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIraiAtenaJohoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai.ShujiiIraiAtenaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai.WaritsukeEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshosakuseiirai.IShujiiIkenshoSakuseiIraiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成依頼情報を管理するクラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class ShujiiIkenshoSakuseiIraiManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShujiiIkenshoSakuseiIraiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoSakuseiIraiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoSakuseiIraiManager}のインスタンス
     */
    public static ShujiiIkenshoSakuseiIraiManager createInstance() {
        return InstanceProvider.create(ShujiiIkenshoSakuseiIraiManager.class);
    }

    /**
     * 割付済み申請者一覧を取得します。
     * 
     * @param param 主治医意見書作成依頼情報を特定するためのMyBatis用パラメータクラスです。
     * @return 割付済み申請者一覧
     */
    @Transaction
    public List<WaritsukeBusiness> get割付済み申請者情報(ShujiiIkenshoSakuseiIraiParameter param) {
        IShujiiIkenshoSakuseiIraiMapper mapper = mapperProvider.create(IShujiiIkenshoSakuseiIraiMapper.class);
        List<WaritsukeEntity> entityList = mapper.get割付済み申請者情報(param);
        List<WaritsukeBusiness> 割付済み申請者List = new ArrayList<>();
        for (WaritsukeEntity entity : entityList) {
            entity.initializeMd5();
            割付済み申請者List.add(new WaritsukeBusiness(entity));
        }
        return 割付済み申請者List;
    }

    /**
     * 未割付申請者一覧を取得します。
     * 
     * @param param 主治医意見書作成依頼情報を特定するためのMyBatis用パラメータクラスです。
     * @return 割付済み申請者一覧
     */
    @Transaction
    public List<WaritsukeBusiness> get未割付申請者情報(ShujiiIkenshoSakuseiIraiParameter param) {
        IShujiiIkenshoSakuseiIraiMapper mapper = mapperProvider.create(IShujiiIkenshoSakuseiIraiMapper.class);
        List<WaritsukeEntity> entityList = mapper.get未割付申請者情報(param);
        List<WaritsukeBusiness> 未割付申請者List = new ArrayList<>();
        for (WaritsukeEntity entity : entityList) {
            entity.initializeMd5();
            未割付申請者List.add(new WaritsukeBusiness(entity));
        }
        return 未割付申請者List;
    }

    /**
     * 宛先情報を取得します。
     *
     * @param atenaJohoParameter 宛先情報取得のパラメータ
     * @return 宛先情報
     */
    @Transaction
    public ShujiiIraiAtenaJoho get宛先情報(ShujiiIraiAtenaJohoParameter atenaJohoParameter) {
        IShujiiIkenshoSakuseiIraiMapper mapper = mapperProvider.create(IShujiiIkenshoSakuseiIraiMapper.class);
        ShujiiIraiAtenaJohoRelateEntity entity = mapper.get宛名情報(atenaJohoParameter);
        if (entity == null) {
            return null;
        }
        return new ShujiiIraiAtenaJoho(entity);
    }
}

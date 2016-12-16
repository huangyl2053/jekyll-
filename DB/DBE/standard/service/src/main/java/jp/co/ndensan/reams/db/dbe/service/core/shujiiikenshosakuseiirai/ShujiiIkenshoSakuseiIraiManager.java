/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.ShujiiIraiAtenaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.Shujiiikenshosakuseiirai;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIraiAtenaJohoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai.ShujiiIraiAtenaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai.ShujiiikenshosakuseiiraiRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshosakuseiirai.IShujiiIkenshoSakuseiIraiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5301ShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成依頼情報を管理するクラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class ShujiiIkenshoSakuseiIraiManager {

    private final MapperProvider mapperProvider;
    private final DbT5301ShujiiIkenshoIraiJohoDac 主治医意見書作成依頼情報dac;
    private final DbT5101NinteiShinseiJohoDac 要介護認定申請情報dac;

    /**
     * コンストラクタです。
     */
    ShujiiIkenshoSakuseiIraiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.主治医意見書作成依頼情報dac = InstanceProvider.create(DbT5301ShujiiIkenshoIraiJohoDac.class);
        this.要介護認定申請情報dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
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
     * 申請者情報を取得します。
     *
     * @param param 主治医意見書一覧のMyBatis用パラメータ
     * @return 申請者情報
     */
    @Transaction
    public SearchResult<Shujiiikenshosakuseiirai> get申請者情報(ShujiiIkenshoSakuseiIraiParameter param) {
        IShujiiIkenshoSakuseiIraiMapper mapper = mapperProvider.create(IShujiiIkenshoSakuseiIraiMapper.class);
        List<ShujiiikenshosakuseiiraiRelateEntity> entityList = mapper.get申請者情報(param);
        List<Shujiiikenshosakuseiirai> businessList = new ArrayList<>();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<Shujiiikenshosakuseiirai>emptyList(), 0, false);
        }
        for (ShujiiikenshosakuseiiraiRelateEntity entity : entityList) {
            businessList.add(new Shujiiikenshosakuseiirai(entity));
        }
        
        int totalcount = mapper.countShinSeiShaJoho(param);
        return SearchResult.of(businessList, totalcount, param.getLimitCount() < totalcount);
    }

    /**
     * 主治医意見書作成依頼情報を取得します。
     *
     * @param param 主治医意見書一覧のMyBatis用パラメータ
     * @return 主治医意見書作成依頼情報
     */
    @Transaction
    public ShujiiIkenshoIraiJoho get主治医意見書作成依頼情報(ShujiiIkenshoSakuseiIraiParameter param) {
        IShujiiIkenshoSakuseiIraiMapper mapper = mapperProvider.create(IShujiiIkenshoSakuseiIraiMapper.class);
        DbT5301ShujiiIkenshoIraiJohoEntity entity = mapper.get主治医意見書作成依頼情報(param);
        if (entity == null) {
            return null;
        }
        return new ShujiiIkenshoIraiJoho(entity);
    }

    /**
     * 要介護認定申請情報を取得します。
     *
     * @param param 主治医意見書一覧のMyBatis用パラメータ
     * @return 要介護認定申請情報
     */
    @Transaction
    public NinteiShinseiJoho2 get要介護認定申請情報(ShujiiIkenshoSakuseiIraiParameter param) {
        IShujiiIkenshoSakuseiIraiMapper mapper = mapperProvider.create(IShujiiIkenshoSakuseiIraiMapper.class);
        DbT5101NinteiShinseiJohoEntity entity = mapper.get要介護認定申請情報(param);
        if (entity == null) {
            return null;
        }
        return new NinteiShinseiJoho2(entity);
    }

    /**
     * 主治医意見書作成依頼情報を更新します。
     *
     * @param 主治医意見書作成依頼情報 主治医意見書作成依頼情報
     * @param state 更新状態
     */
    @Transaction
    public void save主治医意見書作成依頼情報(ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報, EntityDataState state) {
        DbT5301ShujiiIkenshoIraiJohoEntity entity = 主治医意見書作成依頼情報.toEntity();
        entity.setState(state);
        主治医意見書作成依頼情報dac.save(entity);
    }

    /**
     * 主治医意見書作成依頼情報を更新作成します。
     *
     * @param 要介護認定申請情報 要介護認定申請情報
     * @param state 更新状態
     */
    @Transaction
    public void save要介護認定申請情報(NinteiShinseiJoho2 要介護認定申請情報, EntityDataState state) {
        DbT5101NinteiShinseiJohoEntity entity = 要介護認定申請情報.toEntity();
        entity.setState(state);
        要介護認定申請情報dac.save(entity);
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

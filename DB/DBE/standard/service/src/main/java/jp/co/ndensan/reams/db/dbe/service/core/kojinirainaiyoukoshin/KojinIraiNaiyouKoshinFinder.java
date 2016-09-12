/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.kojinirainaiyoukoshin;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.kojinirainaiyoukoshin.KojinIraiNaiyouBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kojinirainaiyoukoshin.KojinIraiNaiyouRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kojinirainaiyoukoshin.IKojinIraiNaiyouKoshinMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 個人依頼内容更新(認定調査票・主治医意見書編集)クラスです。
 *
 * @reamsid_L DBE-1590-020 zhangzhiming
 */
public class KojinIraiNaiyouKoshinFinder {

    private final MapperProvider mapperProvider;
    private final DbT5121ShinseiRirekiJohoDac dac;

    /**
     * コンストラクタです。
     */
    KojinIraiNaiyouKoshinFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     * @param dac {@link DbT5121ShinseiRirekiJohoDac}
     */
    KojinIraiNaiyouKoshinFinder(MapperProvider mapperProvider, DbT5121ShinseiRirekiJohoDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KojinIraiNaiyouKoshinFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KojinIraiNaiyouKoshinFinder}のインスタンス
     */
    public static KojinIraiNaiyouKoshinFinder createInstance() {
        return InstanceProvider.create(KojinIraiNaiyouKoshinFinder.class);
    }

    /**
     * 検索条件に従い、前回訪問調査依頼情報を検索します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 前回訪問調査依頼情報
     */
    @Transaction
    public KojinIraiNaiyouBusiness getZennkaiChousa(ShinseishoKanriNo 申請書管理番号) {
        DbT5121ShinseiRirekiJohoEntity dbt5121Entity = dac.selectByKey(申請書管理番号);
        if (dbt5121Entity != null) {
            IKojinIraiNaiyouKoshinMapper mapper = mapperProvider.create(IKojinIraiNaiyouKoshinMapper.class);
            List<KojinIraiNaiyouRelateEntity> entity = mapper.getChousaIraiJouhou(dbt5121Entity.getZenkaiShinseishoKanriNo());
            if (entity != null && !entity.isEmpty()) {
                return new KojinIraiNaiyouBusiness(entity.get(0));
            }
        }
        return null;
    }

    /**
     * 検索条件に従い、今回訪問調査依頼情報を検索します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 今回訪問調査依頼情報
     */
    @Transaction
    public KojinIraiNaiyouBusiness getKonnkaiChousa(ShinseishoKanriNo 申請書管理番号) {
        IKojinIraiNaiyouKoshinMapper mapper = mapperProvider.create(IKojinIraiNaiyouKoshinMapper.class);
        List<KojinIraiNaiyouRelateEntity> entity = mapper.getChousaIraiJouhou(申請書管理番号);
        if (entity != null && !entity.isEmpty()) {
            return new KojinIraiNaiyouBusiness(entity.get(0));
        }
        return null;
    }

    /**
     * 検索条件に従い、前回主治医依頼情報を検索します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 前回主治医依頼情報
     */
    @Transaction
    public KojinIraiNaiyouBusiness getZennkaiSyuji(ShinseishoKanriNo 申請書管理番号) {
        DbT5121ShinseiRirekiJohoEntity dbt5121Entity = dac.selectByKey(申請書管理番号);
        if (dbt5121Entity != null) {
            IKojinIraiNaiyouKoshinMapper mapper = mapperProvider.create(IKojinIraiNaiyouKoshinMapper.class);
            List<KojinIraiNaiyouRelateEntity> entity = mapper.getSyujiIraiJouhou(dbt5121Entity.getZenkaiShinseishoKanriNo());
            if (entity != null && !entity.isEmpty()) {
                return new KojinIraiNaiyouBusiness(entity.get(0));
            }
        }
        return null;
    }

    /**
     * 検索条件に従い、今回主治医依頼情報を検索します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 今回主治医依頼情報
     */
    @Transaction
    public KojinIraiNaiyouBusiness getKonnkaiSyuji(ShinseishoKanriNo 申請書管理番号) {
        IKojinIraiNaiyouKoshinMapper mapper = mapperProvider.create(IKojinIraiNaiyouKoshinMapper.class);
        List<KojinIraiNaiyouRelateEntity> entity = mapper.getSyujiIraiJouhou(申請書管理番号);
        if (entity != null && !entity.isEmpty()) {
            return new KojinIraiNaiyouBusiness(entity.get(0));
        }
        return null;
    }
}

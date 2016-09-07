/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.seikatsuhogotoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku.SeikatsuhogoTorokuResult;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.seikatsuhogotoroku.SeikatsuhogoTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.seikatsuhogotoroku.ISeikatsuhogoTorokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * みなし2号登録のサービスクラスです。
 *
 * @reamsid_L DBE-1310-020 chengsanyuan
 */
public class SeikatsuhogoTorokuFinder {

    private final MapperProvider mapperProvider;
    private final DbT5121ShinseiRirekiJohoDac dbt5121Dac;

    /**
     * コンストラクタです。
     */
    SeikatsuhogoTorokuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt5121Dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    SeikatsuhogoTorokuFinder(MapperProvider mapperProvider, DbT5121ShinseiRirekiJohoDac dbt5121Dac) {
        this.mapperProvider = mapperProvider;
        this.dbt5121Dac = dbt5121Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SeikatsuhogoTorokuFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SeikatsuhogoTorokuFinder}のインスタンス
     */
    public static SeikatsuhogoTorokuFinder createInstance() {
        return InstanceProvider.create(SeikatsuhogoTorokuFinder.class);
    }

    /**
     * 識別コードにようり、個人番号と行政区を取得します。
     *
     * @param 識別コード 識別コード
     * @return 宛名PSM情報
     */
    public IKojin getPsmData(ShikibetsuCode 識別コード) {
        IShikibetsuTaishoGyomuHanteiKey 業務判定キー = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoSearchKey 宛名検索キー
                = new ShikibetsuTaishoSearchKeyBuilder(業務判定キー, true)
                .set識別コード(識別コード)
                .build();
        IPsmCriteria 宛名psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(宛名検索キー);
        List<UaFt200FindShikibetsuTaishoEntity> 宛名PSM = InstanceProvider.create(UaFt200FindShikibetsuTaishoFunctionDac.class).select(宛名psm);
        if (宛名PSM != null && !宛名PSM.isEmpty()) {
            return ShikibetsuTaishoFactory.createKojin(宛名PSM.get(0));
        }
        return null;
    }

    /**
     * 申請情報の取得
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 申請情報
     */
    public SeikatsuhogoTorokuResult get申請情報(RString 申請書管理番号) {
        SeikatsuhogoTorokuRelateEntity entity = mapperProvider.create(ISeikatsuhogoTorokuMapper.class).getShinseiJoho(申請書管理番号);
        if (entity == null) {
            return null;
        }
        return new SeikatsuhogoTorokuResult(entity);
    }

    /**
     * 申請書管理番号にて、前回申請書管理番号を取得します
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 前回申請書管理番号
     */
    public ShinseishoKanriNo get前回申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        DbT5121ShinseiRirekiJohoEntity entity = dbt5121Dac.selectByKey(申請書管理番号);
        if (entity == null) {
            return null;
        }
        return entity.getZenkaiShinseishoKanriNo();
    }
}

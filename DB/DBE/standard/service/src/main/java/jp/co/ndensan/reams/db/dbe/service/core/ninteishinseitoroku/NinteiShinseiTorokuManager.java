/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseitoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinJogaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseitoroku.NinteiShinseiTorokuResult;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseitoroku.RirekiJohoResult;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5590ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseitoroku.NinteiShinseiTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseitoroku.RirekiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5590ShinsakaiIinJogaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishinseitoroku.INinteiShinseiTorokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1008IryohokenKanyuJokyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5120ShinseitodokedeJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5150RenrakusakiJohoDac;
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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 審査依頼受付／みなし２号審査受付のサービスクラスです。
 *
 * @reamsid_L DBE-1310-010 chengsanyuan
 */
public class NinteiShinseiTorokuManager {

    private final MapperProvider mapperProvider;
    private final DbT5150RenrakusakiJohoDac dbt5150Dac;
    private final DbT5590ShinsakaiIinJogaiJohoDac dbt5590Dac;
    private final DbT5101NinteiShinseiJohoDac dbt5101Dac;
    private final DbT5121ShinseiRirekiJohoDac dbt5121Dac;
    private final DbT1008IryohokenKanyuJokyoDac dbt1008Dac;
    private final DbT5120ShinseitodokedeJohoDac dbt5120Dac;

    /**
     * コンストラクタです。
     */
    NinteiShinseiTorokuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt5150Dac = InstanceProvider.create(DbT5150RenrakusakiJohoDac.class);
        this.dbt5590Dac = InstanceProvider.create(DbT5590ShinsakaiIinJogaiJohoDac.class);
        this.dbt5101Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.dbt5121Dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
        this.dbt1008Dac = InstanceProvider.create(DbT1008IryohokenKanyuJokyoDac.class);
        this.dbt5120Dac = InstanceProvider.create(DbT5120ShinseitodokedeJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    NinteiShinseiTorokuManager(MapperProvider mapperProvider, DbT5150RenrakusakiJohoDac dbt5150Dac,
            DbT5590ShinsakaiIinJogaiJohoDac dbt5590Dac, DbT5101NinteiShinseiJohoDac dbt5101Dac,
            DbT5121ShinseiRirekiJohoDac dbt5121Dac, DbT1008IryohokenKanyuJokyoDac dbt1008Dac,
            DbT5120ShinseitodokedeJohoDac dbt5120Dac) {
        this.mapperProvider = mapperProvider;
        this.dbt5150Dac = dbt5150Dac;
        this.dbt5590Dac = dbt5590Dac;
        this.dbt5101Dac = dbt5101Dac;
        this.dbt5121Dac = dbt5121Dac;
        this.dbt1008Dac = dbt1008Dac;
        this.dbt5120Dac = dbt5120Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiShinseiTorokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiShinseiTorokuManager}のインスタンス
     */
    public static NinteiShinseiTorokuManager createInstance() {
        return InstanceProvider.create(NinteiShinseiTorokuManager.class);
    }

    /**
     * 審査依頼受付／みなし２号審査受付画面初期検索
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 画面初期データ
     */
    public NinteiShinseiTorokuResult getDataForLoad(ShinseishoKanriNo 申請書管理番号) {
        NinteiShinseiTorokuRelateEntity entity
                = mapperProvider.create(INinteiShinseiTorokuMapper.class).getShuseiJohoForLoad(申請書管理番号.value());
        if (entity == null) {
            return null;
        }
        return new NinteiShinseiTorokuResult(entity);
    }

    /**
     * 各共有子Divのデータを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 各共有子Divのデータ
     */
    public RirekiJohoResult get共有子データ(RString 被保険者番号) {
        List<RirekiJohoRelateEntity> entityList
                = mapperProvider.create(INinteiShinseiTorokuMapper.class).getDataForCom(被保険者番号);
        if (entityList == null) {
            return null;
        }
        return new RirekiJohoResult(entityList);
    }

    /**
     * 申請書管理番号により、被保険者番号の取得
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 被保険者番号
     */
    public RString get被保険者番号(ShinseishoKanriNo 申請書管理番号) {
        DbT5101NinteiShinseiJohoEntity entity = dbt5101Dac.selectByKey(申請書管理番号);
        if (entity != null) {
            return entity.getHihokenshaNo();
        }
        return RString.EMPTY;
    }

    /**
     * 申請書管理番号により、介護連絡先情報の取得
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 介護連絡先情報
     */
    public SearchResult<RenrakusakiJoho> get介護連絡先情報(ShinseishoKanriNo 申請書管理番号) {
        List<RenrakusakiJoho> resultList = new ArrayList<>();
        List<DbT5150RenrakusakiJohoEntity> entityList = dbt5150Dac.getRenrakusakiJohoBy申請書管理番号(申請書管理番号);
        if (entityList == null) {
            return SearchResult.of(Collections.<RenrakusakiJoho>emptyList(), 0, false);
        }
        for (DbT5150RenrakusakiJohoEntity entity : entityList) {
            resultList.add(new RenrakusakiJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 申請書管理番号、審査会委員コードにより、除外審査会委員情報を削除
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 審査会委員コード 審査会委員コード
     */
    public void del除外審査会委員情報(ShinseishoKanriNo 申請書管理番号, RString 審査会委員コード) {
        List<DbT5590ShinsakaiIinJogaiJohoEntity> entityList
                = dbt5590Dac.selectJohoBy申請書管理番号And委員コード(申請書管理番号, 審査会委員コード);
        if (entityList == null) {
            return;
        }
        for (DbT5590ShinsakaiIinJogaiJohoEntity entity : entityList) {
            dbt5590Dac.deletePhysical(entity);
        }
    }

    /**
     * 申請書管理番号により、除外審査会委員情報の取得
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 除外審査会委員情報
     */
    public SearchResult<ShinsakaiIinJogaiJoho> get除外審査会委員情報(ShinseishoKanriNo 申請書管理番号) {
        List<ShinsakaiIinJogaiJoho> resultList = new ArrayList<>();
        List<DbT5590ShinsakaiIinJogaiJohoEntity> entityList
                = dbt5590Dac.selectShinsakaiIinJogaiJohoBy申請書管理番号(申請書管理番号);
        if (entityList == null) {
            return SearchResult.of(Collections.<ShinsakaiIinJogaiJoho>emptyList(), 0, false);
        }
        for (DbT5590ShinsakaiIinJogaiJohoEntity entity : entityList) {
            resultList.add(new ShinsakaiIinJogaiJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 申請書管理番号により、前回申請管理番号の取得
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 前回申請管理番号
     */
    public ShinseishoKanriNo get前回申請管理番号(ShinseishoKanriNo 申請書管理番号) {
        DbT5121ShinseiRirekiJohoEntity entity = dbt5121Dac.selectByKey(申請書管理番号);
        if (entity != null) {
            return entity.getZenkaiShinseishoKanriNo();
        }
        return null;
    }

    /**
     * 識別コードにより、医療保険履歴の取得の取得
     *
     * @param 識別コード 識別コード
     * @return 医療保険履歴
     */
    public IryohokenKanyuJokyo get医療保険履歴(ShikibetsuCode 識別コード) {
        DbT1008IryohokenKanyuJokyoEntity entity = dbt1008Dac.select医療保険加入状況ByShikibetsuCode(識別コード);
        if (entity != null) {
            return new IryohokenKanyuJokyo(entity);
        }
        return null;
    }

    /**
     * 申請書管理番号により、要介護認定申請情報の取得の取得
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 要介護認定申請情報
     */
    public NinteiShinseiJoho get要介護認定申請情報(ShinseishoKanriNo 申請書管理番号) {
        DbT5101NinteiShinseiJohoEntity entity = dbt5101Dac.selectByKey(申請書管理番号);
        if (entity != null) {
            return new NinteiShinseiJoho(entity);
        }
        return null;
    }

    /**
     * 申請書管理番号により、認定申請届出情報の取得
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定申請届出情報
     */
    public ShinseitodokedeJoho get認定申請届出情報(ShinseishoKanriNo 申請書管理番号) {
        DbT5120ShinseitodokedeJohoEntity entity = dbt5120Dac.selectByKey(申請書管理番号);
        if (entity != null) {
            return new ShinseitodokedeJoho(entity);
        }
        return null;
    }

    /**
     * 識別コードにより、宛名情報の取得
     *
     * @param 識別コード 識別コード
     * @return 宛名情報
     */
    public IKojin get宛名情報(ShikibetsuCode 識別コード) {
        IShikibetsuTaishoGyomuHanteiKey 業務判定キー = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
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
     * 要介護認定申請情報{@link NinteiShinseiJoho}を保存します。
     *
     * @param 要介護認定申請情報 {@link NinteiShinseiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定申請情報(NinteiShinseiJoho 要介護認定申請情報) {
        if (!要介護認定申請情報.hasChanged()) {
            return false;
        }
        return 1 == dbt5101Dac.save(要介護認定申請情報.toEntity());
    }

    /**
     * 申請届出情報{@link ShinseitodokedeJoho}を保存します。
     *
     * @param 申請届出情報 {@link ShinseitodokedeJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save申請届出情報(ShinseitodokedeJoho 申請届出情報) {
        if (!申請届出情報.hasChanged()) {
            return false;
        }
        return 1 == dbt5120Dac.save(申請届出情報.toEntity());
    }

    /**
     * 申請履歴情報{@link ShinseiRirekiJoho}を保存します。
     *
     * @param 申請履歴情報 {@link ShinseiRirekiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save申請履歴情報(ShinseiRirekiJoho 申請履歴情報) {
        if (!申請履歴情報.hasChanged()) {
            return false;
        }
        return 1 == dbt5121Dac.save(申請履歴情報.toEntity());
    }

    /**
     * 介護連絡先情報{@link RenrakusakiJoho}を保存します。
     *
     * @param 介護連絡先情報 {@link RenrakusakiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護連絡先情報(RenrakusakiJoho 介護連絡先情報) {
        if (!介護連絡先情報.hasChanged()) {
            return false;
        }
        return 1 == dbt5150Dac.save(介護連絡先情報.toEntity());
    }

    /**
     * 介護連絡先情報{@link RenrakusakiJoho}を保存します。
     *
     * @param 介護連絡先情報 {@link RenrakusakiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean del介護連絡先情報(RenrakusakiJoho 介護連絡先情報) {
        return 1 == dbt5150Dac.deletePhysical(介護連絡先情報.toEntity());
    }

    /**
     * 審査会委員除外情報{@link ShinsakaiIinJogaiJoho}を保存します。
     *
     * @param 審査会委員除外情報 {@link ShinsakaiIinJogaiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save審査会委員除外情報(ShinsakaiIinJogaiJoho 審査会委員除外情報) {
        if (!審査会委員除外情報.hasChanged()) {
            return false;
        }
        return 1 == dbt5590Dac.save(審査会委員除外情報.toEntity());
    }

    /**
     * データ重複チェック
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 認定申請年月日 認定申請年月日
     * @param 認定申請区分_申請時_コード 認定申請区分_申請時_コード
     * @return TRUE:有り FALSE:なし
     */
    public boolean has要介護認定申請情報(RString 証記載保険者番号, RString 被保険者番号,
            FlexibleDate 認定申請年月日, Code 認定申請区分_申請時_コード) {
        List<DbT5101NinteiShinseiJohoEntity> retList = dbt5101Dac.get要介護認定申請情報ForCheck(
                証記載保険者番号, 被保険者番号, 認定申請年月日, 認定申請区分_申請時_コード);
        return null != retList && !retList.isEmpty();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shikakufuseigo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokureiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaishaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SeigoseiCheck;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SeigoseiCheckBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo.ShikakuFuseigoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shikakufuseigo.ShikakuFuseigoMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakufuseigo.ShikakuFuseigoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1009ShikakuShutokuJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shikakufuseigo.IShikakuFuseigoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.SeigoseiCheckManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShikakuShutokuJogaishaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.TashichosonJushochiTokureiManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.TekiyoJogaishaManager;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 資格不整合を管理するクラスです。
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
public class ShikakuSeigoseiCheckJohoManager {

    private final MapperProvider mapperProvider;
    private final SeigoseiCheckManager dbt1014manager;
    private final HihokenshaDaichoManager dbt1001manager;
    private final TekiyoJogaishaManager dbt1002manager;
    private final TashichosonJushochiTokureiManager dbt1003manager;
    private final ShikakuShutokuJogaishaManager dbt1009manager;
    private final DbT1009ShikakuShutokuJogaishaDac dbt1009dac;
    private static final int NUMBER_4 = 4;

    /**
     * コンストラクタです。
     */
    ShikakuSeigoseiCheckJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt1014manager = SeigoseiCheckManager.createInstance();
        this.dbt1001manager = HihokenshaDaichoManager.createInstance();
        this.dbt1002manager = TekiyoJogaishaManager.createInstance();
        this.dbt1003manager = TashichosonJushochiTokureiManager.createInstance();
        this.dbt1009manager = new ShikakuShutokuJogaishaManager();
        this.dbt1009dac = InstanceProvider.create(DbT1009ShikakuShutokuJogaishaDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShikakuSeigoseiCheckJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShikakuSeigoseiCheckJohoManager}のインスタンス
     */
    public static ShikakuSeigoseiCheckJohoManager createInstance() {
        return InstanceProvider.create(ShikakuSeigoseiCheckJohoManager.class);
    }

    /**
     * 資格不整合一覧情報の取得する。
     *
     * @return SearchResult<SeigoseiCheckBusiness> 資格不整合一覧情報を取得する。
     */
    public SearchResult<ShikakuFuseigoBusiness> get被保険者資格不整合一覧() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        ShikakuFuseigoMybatisParameter param
                = new ShikakuFuseigoMybatisParameter(new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        List<ShikakuFuseigoEntity> entityList = mapperProvider.create(IShikakuFuseigoMapper.class).get被保険者資格不整合一覧(param);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuFuseigoBusiness>emptyList(), 0, false);
        }
        List<ShikakuFuseigoBusiness> business = new ArrayList<>();
        for (ShikakuFuseigoEntity entity : entityList) {
            business.add(new ShikakuFuseigoBusiness(entity));
        }
        return SearchResult.of(business, 0, false);
    }

    /**
     * パラメータの識別コードによって、整合性チェック情報を更新する。
     *
     * @param 整合性情報 整合性情報
     */
    public void saveAs対象外(SeigoseiCheck 整合性情報) {
        SeigoseiCheckBuilder builder = 整合性情報.createBuilderForEdit();
        builder.set対象外フラグ(true);
        整合性情報 = builder.build();
        dbt1014manager.save整合性チェック(整合性情報.modifiedModel());
    }

    /**
     * 入力の資格の情報を更新します。また、入力の不整合チェック情報を削除します。
     *
     * @param 現在の資格の情報 HihokenshaDaicho
     * @param 修正後の資格の情報 HihokenshaDaicho
     * @param 整合性情報 SeigoseiCheck
     */
    public void save資格情報(HihokenshaDaicho 現在の資格の情報, HihokenshaDaicho 修正後の資格の情報, SeigoseiCheck 整合性情報) {
        if (現在の資格の情報.get異動日().compareTo(修正後の資格の情報.get異動日()) != 0) {
            HihokenshaDaicho 資格の情報 = new HihokenshaDaicho(現在の資格の情報.get被保険者番号(),
                    現在の資格の情報.get異動日(), add枝番(現在の資格の情報.get枝番()));
            dbt1001manager.save被保険者台帳管理(set資格の情報(現在の資格の情報, 資格の情報));
        } else {
            dbt1001manager.save被保険者台帳管理(修正後の資格の情報);
        }
        dbt1014manager.save整合性チェック(整合性情報.deleted());
    }

    /**
     * 入力の資格取得除外の情報を更新します。また、入力の不整合チェック情報を削除します。
     *
     * @param 資格取得除外の情報 ShikakuShutokuJogaisha
     * @param 整合性情報 SeigoseiCheck
     */
    public void save取得除外情報(ShikakuShutokuJogaisha 資格取得除外の情報, SeigoseiCheck 整合性情報) {
        dbt1009manager.save資格取得除外者(資格取得除外の情報);
        dbt1014manager.save整合性チェック(整合性情報.deleted());
    }

    /**
     * 入力の他市町村住所地特例の情報を更新します。また、入力の不整合チェック情報を削除します。
     *
     * @param 現在の他特の情報 TashichosonJushochiTokurei
     * @param 修正後の他特の情報 TashichosonJushochiTokurei
     * @param 整合性情報 SeigoseiCheck
     */
    public void save他特情報(TashichosonJushochiTokurei 現在の他特の情報,
            TashichosonJushochiTokurei 修正後の他特の情報, SeigoseiCheck 整合性情報) {
        if (現在の他特の情報.get異動日().compareTo(修正後の他特の情報.get異動日()) != 0) {
            TashichosonJushochiTokurei 他特の情報 = new TashichosonJushochiTokurei(現在の他特の情報.get識別コード(),
                    現在の他特の情報.get異動日(), add枝番(現在の他特の情報.get枝番()));
            dbt1003manager.save他市町村住所地特例(set他特の情報(現在の他特の情報, 他特の情報));
        }
        dbt1003manager.save他市町村住所地特例(修正後の他特の情報);
        dbt1014manager.save整合性チェック(整合性情報.deleted());
    }

    /**
     * 入力の適用除外者の情報を更新します。また、入力の不整合チェック情報を削除します。
     *
     * @param 現在の除外の情報 TekiyoJogaisha
     * @param 修正後の除外の情報 TekiyoJogaisha
     * @param 整合性情報 SeigoseiCheck
     */
    public void save除外情報(TekiyoJogaisha 現在の除外の情報, TekiyoJogaisha 修正後の除外の情報, SeigoseiCheck 整合性情報) {
        if (現在の除外の情報.get異動日().compareTo(修正後の除外の情報.get異動日()) != 0) {
            TekiyoJogaisha 除外の情報 = new TekiyoJogaisha(現在の除外の情報.get識別コード(),
                    現在の除外の情報.get異動日(), add枝番(現在の除外の情報.get枝番()));
            dbt1002manager.save適用除外者(set除外の情報(現在の除外の情報, 除外の情報));
        }
        dbt1002manager.save適用除外者(修正後の除外の情報);
        dbt1014manager.save整合性チェック(整合性情報.deleted());
    }

    /**
     * 同じ識別コードを持つ中で、最大の履歴番号を取得する。
     *
     * @param 識別コード ShikibetsuCode
     * @return int
     */
    public int getMax履歴番号(ShikibetsuCode 識別コード) {
        DbT1009ShikakuShutokuJogaishaEntity entity = dbt1009dac.select履歴番号(識別コード);
        if (entity == null) {
            return 1;
        }
        return entity.getRirekiNo();
    }

    private HihokenshaDaicho set資格の情報(HihokenshaDaicho 資格の情報修正前, HihokenshaDaicho 資格の情報修正後) {
        HihokenshaDaichoBuilder 資格の情報修正後Builder = 資格の情報修正後.createBuilderForEdit();
        資格の情報修正後Builder.set異動事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get異動事由コード(), RString.EMPTY));
        資格の情報修正後Builder.set市町村コード(ObjectUtil.defaultIfNull(資格の情報修正前.get市町村コード(), LasdecCode.EMPTY));
        資格の情報修正後Builder.set識別コード(ObjectUtil.defaultIfNull(資格の情報修正前.get識別コード(), ShikibetsuCode.EMPTY));
        資格の情報修正後Builder.set被保険者区分コード(ObjectUtil.defaultIfNull(資格の情報修正前.get被保険者区分コード(), RString.EMPTY));
        資格の情報修正後Builder.set資格喪失事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get資格喪失事由コード(), RString.EMPTY));
        資格の情報修正後Builder.set資格喪失年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格喪失年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set資格喪失届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格喪失届出年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set資格変更事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get資格変更事由コード(), RString.EMPTY));
        資格の情報修正後Builder.set資格変更年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格変更年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set資格変更届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格変更届出年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set資格取得事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get資格取得事由コード(), RString.EMPTY));
        資格の情報修正後Builder.set資格取得年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格取得年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set資格取得届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get資格取得届出年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set第1号資格取得年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get第1号資格取得年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set住所地特例適用事由コード(ObjectUtil.defaultIfNull(資格の情報修正前.get住所地特例適用事由コード(), RString.EMPTY));
        資格の情報修正後Builder.set適用年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get適用年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set適用届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get適用届出年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set住所地特例解除事由コード(
                ObjectUtil.defaultIfNull(資格の情報修正前.get住所地特例解除事由コード(), RString.EMPTY));
        資格の情報修正後Builder.set解除年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get解除年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set解除届出年月日(ObjectUtil.defaultIfNull(資格の情報修正前.get解除届出年月日(), FlexibleDate.EMPTY));
        資格の情報修正後Builder.set住所地特例フラグ(ObjectUtil.defaultIfNull(資格の情報修正前.get住所地特例フラグ(), RString.EMPTY));
        資格の情報修正後Builder.set広域内住所地特例フラグ(ObjectUtil.defaultIfNull(資格の情報修正前.get広域内住所地特例フラグ(), RString.EMPTY));
        資格の情報修正後Builder.set広住特措置元市町村コード(
                ObjectUtil.defaultIfNull(資格の情報修正前.get広住特措置元市町村コード(), LasdecCode.EMPTY));
        資格の情報修正後Builder.set旧市町村コード(ObjectUtil.defaultIfNull(資格の情報修正前.get旧市町村コード(), LasdecCode.EMPTY));
        資格の情報修正後Builder.set論理削除フラグ(true);
        return 資格の情報修正後Builder.build();
    }

    private TashichosonJushochiTokurei set他特の情報(TashichosonJushochiTokurei 他特の情報修正前,
            TashichosonJushochiTokurei 他特の情報修正後) {
        TashichosonJushochiTokureiBuilder 他特の情報修正後Builder = 他特の情報修正後.createBuilderForEdit();
        他特の情報修正後Builder.set異動事由コード(ObjectUtil.defaultIfNull(他特の情報修正前.get異動事由コード(), RString.EMPTY));
        他特の情報修正後Builder.set市町村コード(ObjectUtil.defaultIfNull(他特の情報修正前.get市町村コード(), LasdecCode.EMPTY));
        他特の情報修正後Builder.set他市町村住所地特例適用事由コード(
                ObjectUtil.defaultIfNull(他特の情報修正前.get他市町村住所地特例適用事由コード(), RString.EMPTY));
        他特の情報修正後Builder.set適用年月日(ObjectUtil.defaultIfNull(他特の情報修正前.get適用年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set適用届出年月日(ObjectUtil.defaultIfNull(他特の情報修正前.get適用届出年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set適用受付年月日(ObjectUtil.defaultIfNull(他特の情報修正前.get適用受付年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set他市町村住所地特例解除事由コード(
                ObjectUtil.defaultIfNull(他特の情報修正前.get他市町村住所地特例解除事由コード(), RString.EMPTY));
        他特の情報修正後Builder.set解除年月日(ObjectUtil.defaultIfNull(他特の情報修正前.get解除年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set解除届出年月日(ObjectUtil.defaultIfNull(他特の情報修正前.get解除届出年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set解除受付年月日(ObjectUtil.defaultIfNull(他特の情報修正前.get解除受付年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set措置保険者番号(ObjectUtil.defaultIfNull(他特の情報修正前.get措置保険者番号(), ShoKisaiHokenshaNo.EMPTY));
        他特の情報修正後Builder.set措置被保険者番号(ObjectUtil.defaultIfNull(他特の情報修正前.get措置被保険者番号(), HihokenshaNo.EMPTY));
        他特の情報修正後Builder.set他特例連絡票発行年月日(
                ObjectUtil.defaultIfNull(他特の情報修正前.get他特例連絡票発行年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set施設退所通知発行年月日(
                ObjectUtil.defaultIfNull(他特の情報修正前.get施設退所通知発行年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set施設変更通知発行年月日(
                ObjectUtil.defaultIfNull(他特の情報修正前.get施設変更通知発行年月日(), FlexibleDate.EMPTY));
        他特の情報修正後Builder.set論理削除フラグ(true);
        return 他特の情報修正後Builder.build();
    }

    private TekiyoJogaisha set除外の情報(TekiyoJogaisha 除外の情報修正前, TekiyoJogaisha 除外の情報修正後) {
        TekiyoJogaishaBuilder 除外の情報修正後Builder = 除外の情報修正後.createBuilderForEdit();
        除外の情報修正後Builder.set異動事由コード(ObjectUtil.defaultIfNull(除外の情報修正前.get異動事由コード(), RString.EMPTY));
        除外の情報修正後Builder.set市町村コード(ObjectUtil.defaultIfNull(除外の情報修正前.get市町村コード(), LasdecCode.EMPTY));
        除外の情報修正後Builder.set適用除外解除事由コード(
                ObjectUtil.defaultIfNull(除外の情報修正前.get適用除外解除事由コード(), RString.EMPTY));
        除外の情報修正後Builder.set解除年月日(ObjectUtil.defaultIfNull(除外の情報修正前.get解除年月日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set解除届出年月日(ObjectUtil.defaultIfNull(除外の情報修正前.get解除届出年月日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set適用除外適用事由コード(
                ObjectUtil.defaultIfNull(除外の情報修正前.get適用除外適用事由コード(), RString.EMPTY));
        除外の情報修正後Builder.set適用年月日(ObjectUtil.defaultIfNull(除外の情報修正前.get適用年月日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set適用届出年月日(ObjectUtil.defaultIfNull(除外の情報修正前.get適用届出年月日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set適用受付年月日(ObjectUtil.defaultIfNull(除外の情報修正前.get適用受付年月日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set解除受付年月日(ObjectUtil.defaultIfNull(除外の情報修正前.get解除受付年月日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set入所通知発行日(ObjectUtil.defaultIfNull(除外の情報修正前.get入所通知発行日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set退所通知発行日(ObjectUtil.defaultIfNull(除外の情報修正前.get退所通知発行日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set変更通知発行日(ObjectUtil.defaultIfNull(除外の情報修正前.get変更通知発行日(), FlexibleDate.EMPTY));
        除外の情報修正後Builder.set論理削除フラグ(true);
        return 除外の情報修正後Builder.build();
    }

    private RString add枝番(RString 枝番) {
        return new RString(Integer.parseInt(枝番.trim().toString()) + 1).padZeroToLeft(NUMBER_4);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shikakufuseigo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SeigoseiCheck;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SeigoseiCheckBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo.ShikakuFuseigoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shikakufuseigo.ShikakuFuseigoMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakufuseigo.ShikakuFuseigoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1009ShikakuShutokuJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shikakufuseigo.IShikakuFuseigoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.SeigoseiCheckManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShikakuShutokuJogaishaManager;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshashikakusoshitsu.HihokenshashikakusoshitsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshashikakuteisei.HihokenshaShikakuTeiseiManager;
import jp.co.ndensan.reams.db.dbz.service.core.shikakuhenkouidou.HihokenshaShikakuHenkoManager;
import jp.co.ndensan.reams.db.dbz.service.core.tashichosonjushochitokureisyaidoteisei.TaShichosonJushochiTokureisyaIdoTeisei;
import jp.co.ndensan.reams.db.dbz.service.core.tekiyojogaishaidoteisei.TekiyoJogaishaIdoTeiseiFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
    private final ShikakuShutokuJogaishaManager dbt1009manager;
    private final DbT1009ShikakuShutokuJogaishaDac dbt1009dac;
    private final HihokenshaShikakuHenkoManager henkoManager;
    private final HihokenshaShikakuTeiseiManager tsiseiManager;
    private final HihokenshaShikakuShutokuManager shutokuManager;
    private final HihokenshashikakusoshitsuManager soshitsuManager;
    private final TaShichosonJushochiTokureisyaIdoTeisei tashiManager;
    private final TekiyoJogaishaIdoTeiseiFinder tekiyoManager;

    /**
     * コンストラクタです。
     */
    ShikakuSeigoseiCheckJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt1014manager = SeigoseiCheckManager.createInstance();
        this.dbt1009manager = new ShikakuShutokuJogaishaManager();
        this.dbt1009dac = InstanceProvider.create(DbT1009ShikakuShutokuJogaishaDac.class);
        this.henkoManager = HihokenshaShikakuHenkoManager.createInstance();
        this.tsiseiManager = HihokenshaShikakuTeiseiManager.createInstance();
        this.shutokuManager = HihokenshaShikakuShutokuManager.createInstance();
        this.soshitsuManager = HihokenshashikakusoshitsuManager.createInstance();
        this.tashiManager = TaShichosonJushochiTokureisyaIdoTeisei.createInstance();
        this.tekiyoManager = InstanceProvider.create(TekiyoJogaishaIdoTeiseiFinder.class);
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
     * @param 生年月日 生年月日
     */
    public void save資格情報(HihokenshaDaicho 現在の資格の情報, HihokenshaDaicho 修正後の資格の情報, SeigoseiCheck 整合性情報, IDateOfBirth 生年月日) {
        if (現在の資格の情報 == null && 修正後の資格の情報 != null) {
            shutokuManager.saveHihokenshaShutoku(修正後の資格の情報, 生年月日);
        }
        if (現在の資格の情報 != null && 修正後の資格の情報 != null
                && !(現在の資格の情報.get資格喪失年月日() != null && 現在の資格の情報.get資格喪失年月日().isEmpty())
                && 修正後の資格の情報.get資格喪失年月日() != null && !修正後の資格の情報.get資格喪失年月日().isEmpty()) {
            soshitsuManager.saveHihokenshaShikakuSoshitsu(修正後の資格の情報.get識別コード(),
                    修正後の資格の情報.get被保険者番号(), 修正後の資格の情報.get資格喪失年月日(),
                    修正後の資格の情報.get資格喪失事由コード(), 修正後の資格の情報.get資格喪失届出年月日());
        }
        if (現在の資格の情報 != null && 修正後の資格の情報 != null
                && !(現在の資格の情報.get資格変更年月日() != null && 現在の資格の情報.get資格変更年月日().isEmpty())
                && 修正後の資格の情報.get資格変更年月日() != null && !修正後の資格の情報.get資格変更年月日().isEmpty()) {
            henkoManager.saveHihokenshaHenko(修正後の資格の情報);
        }
        if (現在の資格の情報 != null && 修正後の資格の情報 != null
                && hanChanged資格の情報(現在の資格の情報, 修正後の資格の情報)) {
            List<HihokenshaDaicho> list = new ArrayList<>();
            list.add(修正後の資格の情報);
            tsiseiManager.saveHihokenshaShikakuTeisei(現在の資格の情報.get被保険者番号(), 現在の資格の情報.get資格取得年月日(), null, list);
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
        tashiManager.save異動訂正(現在の他特の情報, 修正後の他特の情報);
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
        tekiyoManager.save異動訂正(現在の除外の情報, 修正後の除外の情報);
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

    private boolean hanChanged資格の情報(HihokenshaDaicho 資格の情報修正前, HihokenshaDaicho 資格の情報修正後) {
        RString ret = RString.EMPTY;
        if (資格の情報修正後.get異動事由コード() != null && !資格の情報修正後.get異動事由コード().equals(資格の情報修正前.get異動事由コード())) {
            ret = null;
        }
        if (資格の情報修正後.get市町村コード() != null && !資格の情報修正後.get市町村コード().equals(資格の情報修正前.get市町村コード())) {
            ret = null;
        }
        if (資格の情報修正後.get識別コード() != null && !資格の情報修正後.get識別コード().equals(資格の情報修正前.get識別コード())) {
            ret = null;
        }
        if (資格の情報修正後.get被保険者区分コード() != null
                && !資格の情報修正後.get被保険者区分コード().equals(資格の情報修正前.get被保険者区分コード())) {
            ret = null;
        }
        if (資格の情報修正後.get資格喪失事由コード() != null
                && !資格の情報修正後.get資格喪失事由コード().equals(資格の情報修正前.get資格喪失事由コード())) {
            ret = null;
        }
        if (資格の情報修正後.get資格喪失年月日() != null
                && !資格の情報修正後.get資格喪失年月日().equals(資格の情報修正前.get資格喪失年月日())) {
            ret = null;
        }
        if (資格の情報修正後.get資格喪失届出年月日() != null
                && !資格の情報修正後.get資格喪失届出年月日().equals(資格の情報修正前.get資格喪失届出年月日())) {
            ret = null;
        }
        if (資格の情報修正後.get資格変更事由コード() != null
                && !資格の情報修正後.get資格変更事由コード().equals(資格の情報修正前.get資格変更事由コード())) {
            ret = null;
        }
        return ret == null || hanChanged資格の情報2(資格の情報修正前, 資格の情報修正後) == null
                || hanChanged資格の情報3(資格の情報修正前, 資格の情報修正後) == null;
    }

    private RString hanChanged資格の情報2(HihokenshaDaicho 資格の情報修正前, HihokenshaDaicho 資格の情報修正後) {
        if (資格の情報修正後.get資格変更年月日() != null
                && !資格の情報修正後.get資格変更年月日().equals(資格の情報修正前.get資格変更年月日())) {
            return null;
        }
        if (資格の情報修正後.get資格変更届出年月日() != null
                && !資格の情報修正後.get資格変更届出年月日().equals(資格の情報修正前.get資格変更届出年月日())) {
            return null;
        }
        if (資格の情報修正後.get資格取得事由コード() != null
                && !資格の情報修正後.get資格取得事由コード().equals(資格の情報修正前.get資格取得事由コード())) {
            return null;
        }
        if (資格の情報修正後.get資格取得年月日() != null
                && !資格の情報修正後.get資格取得年月日().equals(資格の情報修正前.get資格取得年月日())) {
            return null;
        }
        if (資格の情報修正後.get資格取得届出年月日() != null
                && !資格の情報修正後.get資格取得届出年月日().equals(資格の情報修正前.get資格取得届出年月日())) {
            return null;
        }
        if (資格の情報修正後.get第1号資格取得年月日() != null
                && !資格の情報修正後.get第1号資格取得年月日().equals(資格の情報修正前.get第1号資格取得年月日())) {
            return null;
        }
        if (資格の情報修正後.get住所地特例適用事由コード() != null
                && !資格の情報修正後.get住所地特例適用事由コード().equals(資格の情報修正前.get住所地特例適用事由コード())) {
            return null;
        }
        if (資格の情報修正後.get適用年月日() != null && !資格の情報修正後.get適用年月日().equals(資格の情報修正前.get適用年月日())) {
            return null;
        }
        if (資格の情報修正後.get適用届出年月日() != null
                && !資格の情報修正後.get適用届出年月日().equals(資格の情報修正前.get適用届出年月日())) {
            return null;
        }
        return RString.EMPTY;
    }

    private RString hanChanged資格の情報3(HihokenshaDaicho 資格の情報修正前, HihokenshaDaicho 資格の情報修正後) {
        if (資格の情報修正後.get住所地特例解除事由コード() != null
                && !資格の情報修正後.get住所地特例解除事由コード().equals(資格の情報修正前.get住所地特例解除事由コード())) {
            return null;
        }
        if (資格の情報修正後.get解除年月日() != null && !資格の情報修正後.get解除年月日().equals(資格の情報修正前.get解除年月日())) {
            return null;
        }
        if (資格の情報修正後.get解除届出年月日() != null
                && !資格の情報修正後.get解除届出年月日().equals(資格の情報修正前.get解除届出年月日())) {
            return null;
        }
        if (資格の情報修正後.get住所地特例フラグ() != null
                && !資格の情報修正後.get住所地特例フラグ().equals(資格の情報修正前.get住所地特例フラグ())) {
            return null;
        }
        if (資格の情報修正後.get広域内住所地特例フラグ() != null
                && !資格の情報修正後.get広域内住所地特例フラグ().equals(資格の情報修正前.get広域内住所地特例フラグ())) {
            return null;
        }
        if (資格の情報修正後.get広住特措置元市町村コード() != null
                && !資格の情報修正後.get広住特措置元市町村コード().equals(資格の情報修正前.get広住特措置元市町村コード())) {
            return null;
        }
        if (資格の情報修正後.get旧市町村コード() != null
                && !資格の情報修正後.get旧市町村コード().equals(資格の情報修正前.get旧市町村コード())) {
            return null;
        }
        if (!(資格の情報修正後.is論理削除フラグ() && 資格の情報修正前.is論理削除フラグ())) {
            return null;
        }
        return RString.EMPTY;
    }
}

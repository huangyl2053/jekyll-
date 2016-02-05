/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.definition.core.tokuteifutangendogakushinseisho.PsmTokuteifutanGendogakudoMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseishoMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tokuteifutangendogakushinseisho.HihokenshaKihonEntity;
import jp.co.ndensan.reams.db.dba.persistence.mapper.tokuteifutangendogakushinseisho.ITokuteifutanGendogakuShinseishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 申請書_共通クラス部分クラスです。
 */
public class TokuteifutanGendogakuShinseisho {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    TokuteifutanGendogakuShinseisho(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * コンストラクタです。
     */
    public TokuteifutanGendogakuShinseisho() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuteifutanGendogakuShinseisho}のインスタンスを返します。
     *
     * @return TokuteifutanGendogakuShinseisho
     */
    public static TokuteifutanGendogakuShinseisho createInstance() {
        return InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
    }

    /**
     * 被保険者基本情報の取得処理です。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コード
     * @return HihokenshaKihonBusiness
     */
    public HihokenshaKihonBusiness getHihokenshaKihonJoho(HihokenshaNo hihokenshaNo, ShikibetsuCode shikibetsuCode) {
        ITokuteifutanGendogakuShinseishoMapper mapper = mapperProvider.create(ITokuteifutanGendogakuShinseishoMapper.class);
        DbT1001HihokenshaDaichoEntity dbt1001Entity = get最新異動日データ(hihokenshaNo, shikibetsuCode, mapper);
        UaFt200FindShikibetsuTaishoEntity uaft200Entity = getPsm(dbt1001Entity, mapper);
        // TODO  内部QA：644  Redmine： (スケジュールに「ビジネス設計_DBUMN00000_市町村情報セキュリティ取得」がありません。)
        RString 導入形態コード = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード().value();
        HokenshaNo 証記載保険者番号 = get証記載保険者番号(導入形態コード, dbt1001Entity);
        // TODO 内部QA：644  Redmine： (「保険者」テーブルがありません。)
        RString 保険者名称 = new RString("名称");
        return ge被保険者基本情報(uaft200Entity, 証記載保険者番号, 保険者名称, dbt1001Entity);
    }

    private DbT1001HihokenshaDaichoEntity get最新異動日データ(HihokenshaNo hihokenshaNo, ShikibetsuCode shikibetsuCode,
            ITokuteifutanGendogakuShinseishoMapper mapper) {
        boolean isHihokenshaNo_flg = true;
        boolean isShikibetsuCode_flg = true;
        if (hihokenshaNo == null || hihokenshaNo.isEmpty()) {
            isHihokenshaNo_flg = false;
        }
        if (shikibetsuCode == null || shikibetsuCode.isEmpty()) {
            isShikibetsuCode_flg = false;
        }
        TokuteifutanGendogakuShinseishoMybatisParameter parameter = TokuteifutanGendogakuShinseishoMybatisParameter.createParam(
                hihokenshaNo, shikibetsuCode, isHihokenshaNo_flg, isShikibetsuCode_flg);
        DbT1001HihokenshaDaichoEntity dbt1001Entity = mapper.get最新異動日データ(parameter);
        if (dbt1001Entity == null) {
            dbt1001Entity = new DbT1001HihokenshaDaichoEntity();
        }
        return dbt1001Entity;
    }

    private UaFt200FindShikibetsuTaishoEntity getPsm(DbT1001HihokenshaDaichoEntity dbt1001Entity, ITokuteifutanGendogakuShinseishoMapper mapper) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(dbt1001Entity.getShikibetsuCode());
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        PsmTokuteifutanGendogakudoMybatisParameter psmParameter = new PsmTokuteifutanGendogakudoMybatisParameter(
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        UaFt200FindShikibetsuTaishoEntity uaft200Entity = mapper.getPsm(psmParameter);
        if (uaft200Entity == null) {
            uaft200Entity = new UaFt200FindShikibetsuTaishoEntity();
        }
        return uaft200Entity;
    }

    private HihokenshaKihonBusiness ge被保険者基本情報(UaFt200FindShikibetsuTaishoEntity uaft200Entity,
            HokenshaNo 証記載保険者番号, RString 保険者名称, DbT1001HihokenshaDaichoEntity dbt1001Entity) {
        HihokenshaKihonEntity hihokenshaKihonEntity = new HihokenshaKihonEntity();
        if (uaft200Entity.getKanaMeisho() != null) {
            hihokenshaKihonEntity.setフリガナ(uaft200Entity.getKanaMeisho().value());
        }
        if (uaft200Entity.getMeisho() != null) {
            hihokenshaKihonEntity.set被保険者氏名(uaft200Entity.getMeisho().value());
        }

        hihokenshaKihonEntity.set保険者番号(証記載保険者番号);
        hihokenshaKihonEntity.set保険者名称(保険者名称);
        hihokenshaKihonEntity.set被保険者番号(dbt1001Entity.getHihokenshaNo());
        hihokenshaKihonEntity.set生年月日(uaft200Entity.getSeinengappiYMD());
        hihokenshaKihonEntity.set性別(uaft200Entity.getSeibetsuCode());
        hihokenshaKihonEntity.set続柄(uaft200Entity.getTsuzukigara());
        if (uaft200Entity.getYubinNo() != null) {
            hihokenshaKihonEntity.set郵便番号(uaft200Entity.getYubinNo().value());
        }
        // TODO 内部QA：644  Redmine： (宛名情報に「連絡先」がありません。)
        if (uaft200Entity.getRenrakusaki1() != null) {
            hihokenshaKihonEntity.set電話番号(uaft200Entity.getRenrakusaki1().value());
        }
        if (uaft200Entity.getJusho() != null) {
            hihokenshaKihonEntity.set住所(uaft200Entity.getJusho().value());
        }
        if (uaft200Entity.getSetainushiMei() != null) {
            hihokenshaKihonEntity.set世帯主氏名(uaft200Entity.getSetainushiMei().value());
        }
        hihokenshaKihonEntity.set生年月日不詳区分(uaft200Entity.getSeinengappiFushoKubun());
        return new HihokenshaKihonBusiness(hihokenshaKihonEntity);
    }

    private HokenshaNo get証記載保険者番号(RString 導入形態コード, DbT1001HihokenshaDaichoEntity dbt1001Entity) {
        HokenshaNo 証記載保険者番号;
        if (DonyukeitaiCode.事務広域.getCode().equals(導入形態コード) || DonyukeitaiCode.認定広域.getCode().equals(導入形態コード)) {
            KoikiShichosonJohoFinder koikiShichosonJohoFinder = InstanceProvider.create(KoikiShichosonJohoFinder.class);
            LasdecCode koikiShichosonJohoParameter;
            LasdecCode koikinaiTokureiSochimotoShichosonCode = dbt1001Entity.getKoikinaiTokureiSochimotoShichosonCode();
            if (koikinaiTokureiSochimotoShichosonCode == null || koikinaiTokureiSochimotoShichosonCode.isEmpty()) {
                koikiShichosonJohoParameter = dbt1001Entity.getShichosonCode();
            } else {
                koikiShichosonJohoParameter = koikinaiTokureiSochimotoShichosonCode;
            }
            SearchResult<ShichosonCodeYoriShichoson> shichoson = koikiShichosonJohoFinder.shichosonCodeYoriShichosonJoho(
                    koikiShichosonJohoParameter);
            // TODO  内部QA：644  Redmine： (検索結果は復数件の可能性があります。)
            証記載保険者番号 = new HokenshaNo(shichoson.records().get(0).get運用保険者番号().value());
            // TODO  内部QA：644  Redmine： (スケジュールに「ビジネス設計_DBUMN00000_市町村情報取得_単一」がありません。)
        } else {
            証記載保険者番号 = new HokenshaNo("111");
        }
        return 証記載保険者番号;
    }
}

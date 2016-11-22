/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteifutangendogakushinseisho.PsmTokuteifutanGendogakudoMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseishoMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.tokuteifutangendogakushinseisho.HihokenshaKihonEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.tokuteifutangendogakushinseisho.ITokuteifutanGendogakuShinseishoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 申請書_共通クラス部分クラスです。
 *
 * @reamsid_L DBA-0540-714 yaodongsheng
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
        if ((hihokenshaNo == null || hihokenshaNo.isEmpty()) && (shikibetsuCode == null || shikibetsuCode.isEmpty())) {
            return null;
        }
        DbT1001HihokenshaDaichoEntity dbt1001Entity = get最新異動日データ(hihokenshaNo, shikibetsuCode, mapper);
        UaFt200FindShikibetsuTaishoEntity uaft200Entity = getPsm(dbt1001Entity, mapper);
        RString 導入形態コード = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード().value();
        HokenshaNo 証記載保険者番号 = get証記載保険者番号(導入形態コード, dbt1001Entity);
        RString 保険者名称 = mapper.get保険者名称(証記載保険者番号);
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
        AtenaKanaMeisho atenaKanaMeisho = uaft200Entity.getKanaMeisho();
        if (atenaKanaMeisho != null) {
            hihokenshaKihonEntity.setフリガナ(atenaKanaMeisho.value());
        }
        AtenaMeisho atenaMeisho = uaft200Entity.getMeisho();
        if (atenaMeisho != null) {
            hihokenshaKihonEntity.set被保険者氏名(atenaMeisho.value());
        }
        hihokenshaKihonEntity.set保険者番号(証記載保険者番号);
        hihokenshaKihonEntity.set保険者名称(保険者名称);
        hihokenshaKihonEntity.set被保険者番号(dbt1001Entity.getHihokenshaNo());
        FlexibleDate 生年月日 = uaft200Entity.getSeinengappiYMD();
        if (生年月日 != null) {
            hihokenshaKihonEntity.set生年月日(生年月日);
        }
        hihokenshaKihonEntity.set性別(uaft200Entity.getSeibetsuCode());
        hihokenshaKihonEntity.set続柄(uaft200Entity.getTsuzukigara());
        YubinNo yubinNo = uaft200Entity.getYubinNo();
        if (yubinNo != null) {
            hihokenshaKihonEntity.set郵便番号(yubinNo.value());
        }
        TelNo renrakusaki1 = uaft200Entity.getRenrakusaki1();
        if (renrakusaki1 != null) {
            hihokenshaKihonEntity.set電話番号(renrakusaki1.value());
        }
        RStringBuilder jusho = new RStringBuilder();
        AtenaJusho atenaJusho = uaft200Entity.getJusho();
        if (atenaJusho != null) {
            jusho = jusho.append(atenaJusho.value());
        }
        AtenaBanchi atenaBanchi = uaft200Entity.getBanchi();
        if (atenaBanchi != null) {
            jusho = jusho.append(atenaBanchi.value());
        }
        Katagaki katagakinew = uaft200Entity.getKatagaki();
        if (katagakinew != null) {
            jusho = jusho.append(katagakinew.value());
        }
        hihokenshaKihonEntity.set住所(jusho.toRString());
        hihokenshaKihonEntity.set住民種別コード(uaft200Entity.getJuminShubetsuCode());
        AtenaMeisho setainushiMei = uaft200Entity.getSetainushiMei();
        if (setainushiMei != null) {
            hihokenshaKihonEntity.set世帯主氏名(setainushiMei.value());
        }
        hihokenshaKihonEntity.set生年月日不詳区分(uaft200Entity.getSeinengappiFushoKubun());
        Katagaki katagaki = uaft200Entity.getKatagaki();
        if (katagaki != null) {
            hihokenshaKihonEntity.set方書(katagaki.value());
        }
        return new HihokenshaKihonBusiness(hihokenshaKihonEntity);
    }

    private HokenshaNo get証記載保険者番号(RString 導入形態コード, DbT1001HihokenshaDaichoEntity dbt1001Entity) {
        HokenshaNo 証記載保険者番号;
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード) || DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード)) {
            KoikiShichosonJohoFinder koikiShichosonJohoFinder = InstanceProvider.create(KoikiShichosonJohoFinder.class);
            LasdecCode koikiShichosonJohoParameter;
            LasdecCode shichosonCode = dbt1001Entity.getKoikinaiTokureiSochimotoShichosonCode();
            if (shichosonCode == null || shichosonCode.isEmpty()) {
                koikiShichosonJohoParameter = dbt1001Entity.getShichosonCode();
            } else {
                koikiShichosonJohoParameter = shichosonCode;
            }
            SearchResult<ShichosonCodeYoriShichoson> shichoson = koikiShichosonJohoFinder.shichosonCodeYoriShichosonJoho(
                    koikiShichosonJohoParameter);
            証記載保険者番号 = new HokenshaNo(shichoson.records().get(0).get証記載保険者番号().value());
        } else {
            KoikiShichosonJohoFinder koikiShichosonJohoFinder = InstanceProvider.create(KoikiShichosonJohoFinder.class);
            証記載保険者番号 = new HokenshaNo(koikiShichosonJohoFinder.koseiShichosonJoho().records().get(0).get証記載保険者番号().value());
        }
        return 証記載保険者番号;
    }
}

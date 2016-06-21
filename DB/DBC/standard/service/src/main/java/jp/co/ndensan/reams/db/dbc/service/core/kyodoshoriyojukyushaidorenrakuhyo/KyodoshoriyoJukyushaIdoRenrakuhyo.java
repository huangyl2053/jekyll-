/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyodoshoriyojukyushaidorenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyoutuuEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuDac;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.mapper.IUaFt200FindShikibetsuTaishoFunctionMapper;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 共同処理用受給者異動連絡票のビジネス
 *
 * @reamsid_L DBC-4390-020 xupeng
 */
public class KyodoshoriyoJukyushaIdoRenrakuhyo {

    private final DbV1001HihokenshaDaichoAliveDac 被保険者台帳管理Dac;
    private final DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac dbT3002dac;
    private final DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac dbT3003dac;
    private final DbT3004KyodoShoriyoJukyushaIdoKogakuSofuDac dbT3004dac;
    private final MapperProvider mapperProvider;
    private static final RString 新規 = new RString("新規モード");
    private static final LasdecCode 市町村 = new LasdecCode("209007");

    /**
     * コンストラクタです。
     */
    public KyodoshoriyoJukyushaIdoRenrakuhyo() {
        this.被保険者台帳管理Dac = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
        this.dbT3002dac = InstanceProvider.create(DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac.class);
        this.dbT3003dac = InstanceProvider.create(DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac.class);
        this.dbT3004dac = InstanceProvider.create(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbV1001dac dbV1001dac
     */
    KyodoshoriyoJukyushaIdoRenrakuhyo(
            DbV1001HihokenshaDaichoAliveDac dbV1001dac,
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac dbT3002,
            DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac dbT3003,
            DbT3004KyodoShoriyoJukyushaIdoKogakuSofuDac dbT3004,
            MapperProvider mapperProvider
    ) {
        this.mapperProvider = mapperProvider;
        this.被保険者台帳管理Dac = dbV1001dac;
        this.dbT3002dac = dbT3002;
        this.dbT3003dac = dbT3003;
        this.dbT3004dac = dbT3004;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyodoshoriyoJukyushaIdoRenrakuhyo}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KyodoshoriyoJukyushaIdoRenrakuhyo}のインスタンス
     */
    public static KyodoshoriyoJukyushaIdoRenrakuhyo createInstance() {
        return InstanceProvider.create(KyodoshoriyoJukyushaIdoRenrakuhyo.class);
    }

    /**
     * 共同処理用受給者異動情報を取得する。
     *
     * @param 処理モード RString
     * @param 論理削除 boolean
     * @param 異動日 FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @return KyodoshoriyoJukyushaIdoRenrakuhyoParam
     */
    public KyodoshoriyoJukyushaIdoRenrakuhyoParam getJukyushaIdoJoho(RString 処理モード, boolean 論理削除,
            FlexibleDate 異動日, HihokenshaNo 被保険者番号, FlexibleYearMonth 対象年月) {
        if (新規.equals(処理モード)) {
            DbV1001HihokenshaDaichoEntity entity = 被保険者台帳管理Dac.get最新の被保険者台帳情報(被保険者番号);
            if (entity == null) {
                return null;
            }
            IUaFt200FindShikibetsuTaishoFunctionMapper mapper = mapperProvider.create(
                    IUaFt200FindShikibetsuTaishoFunctionMapper.class);
            ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(
                    GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
            IShikibetsuTaishoPSMSearchKey searchKey = builder.
                    setデータ取得区分(DataShutokuKubun.直近レコード).
                    set識別コード(entity.getShikibetsuCode()).build();
            UaFt200FindShikibetsuTaishoParam para = new UaFt200FindShikibetsuTaishoParam(searchKey);
            List<UaFt200FindShikibetsuTaishoEntity> result = mapper.selectByParameterClass(para);
            IKojin 宛名 = null;
            if (result != null && !result.isEmpty()) {
                宛名 = ShikibetsuTaishoFactory.createKojin(result.get(0));
            }
            return get証記載保険者番号と保険者番号(被保険者番号, 宛名);
        } else {
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity dbT3002Entity = dbT3002dac.get基本送付(被保険者番号, 異動日, 対象年月, 論理削除);
            DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity dbT3003Entity = dbT3003dac.get償還送付(被保険者番号, 異動日, 対象年月, 論理削除);
            DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity dbT3004Entity = dbT3004dac.get高額送付(被保険者番号, 異動日, 対象年月, 論理削除);
            if (dbT3002Entity == null && dbT3003Entity == null && dbT3004Entity == null) {
                return null;
            }
            return set共同処理用受給者異動情報_新規以外(dbT3002Entity, dbT3003Entity, dbT3004Entity);
        }
    }

    private KyodoshoriyoJukyushaIdoRenrakuhyoParam get証記載保険者番号と保険者番号(
            HihokenshaNo 被保険者番号, IKojin 宛名) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
        KyoutuuEntity 共通項目Entity = new KyoutuuEntity();
        if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {
            SearchResult<KoikiZenShichosonJoho> result = finder.koseiShichosonJoho();
            if (result.records() == null || result.records().isEmpty()) {
                return null;
            }
            共通項目Entity.set証記載保険者番号(result.records().get(0).get証記載保険者番号());
        } else {
            //TODO 「ビジネス設計_DBCKD00007_(共有子Div)受給者異動連絡票.xlsx」の
            //「市町村コードと広住例措置元市町村コード取得」機能未開発
            LasdecCode 市町村コード = 市町村;
            LasdecCode 広住特措置元市町村コード = get();
            SearchResult<ShichosonCodeYoriShichoson> result;
            if (広住特措置元市町村コード != null && !広住特措置元市町村コード.isEmpty()) {
                result = finder.shichosonCodeYoriShichosonJoho(広住特措置元市町村コード);
            } else {
                result = finder.shichosonCodeYoriShichosonJoho(市町村コード);
            }
            if (result.records() == null || result.records().isEmpty()) {
                return null;
            }
            共通項目Entity.set証記載保険者番号(result.records().get(0).get証記載保険者番号());
        }
        return set共同処理用受給者異動情報_新規(被保険者番号, 共通項目Entity, 宛名);
    }

    private LasdecCode get() {
        return null;
    }

    private KyodoshoriyoJukyushaIdoRenrakuhyoParam set共同処理用受給者異動情報_新規(
            HihokenshaNo 被保険者番号, KyoutuuEntity 共通項目Entity, IKojin 宛名) {
        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = new KyodoshoriyoJukyushaIdoRenrakuhyoParam();
        共通項目Entity.set被保険者番号(被保険者番号);
        共通項目Entity.set異動区分(JukyushaIF_IdoKubunCode.新規.getコード());
        共通項目Entity.set異動事由(null);
        entity.set共通項目Entity(共通項目Entity);

        DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity 基本情報Entity = new DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
        if (宛名 != null) {
            if (宛名.get名称().getName() != null && !宛名.get名称().getName().isEmpty()) {
                基本情報Entity.setHiHokenshaName(宛名.get名称().getName().value());
            }
            基本情報Entity.setTelNo(宛名.get連絡先１());
            基本情報Entity.setYubinNo(宛名.get住所().get郵便番号());
            基本情報Entity.setAddress(set住所(宛名));
        }
        entity.set基本情報Entity(基本情報Entity);

        DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity 償還情報Entity = new DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
        entity.set償還情報Entity(償還情報Entity);

        DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity 高額情報Entity = new DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity();
        高額情報Entity.setRiyoshaFutan2DankaiAriFlag(false);
        高額情報Entity.setRoureiFukushiNenkinJukyuAriFlag(false);
        高額情報Entity.setShikyuShinseishoOutputAriFlag(true);
        entity.set高額情報Entity(高額情報Entity);

        return entity;
    }

    private RString set住所(IKojin 宛名) {
        RStringBuilder 住所 = new RStringBuilder(宛名.get住所().get住所());
        住所 = 住所.append(宛名.get住所().get番地().getBanchi().value());
        if (宛名.get住所().get方書() != null && !宛名.get住所().get方書().isEmpty()) {
            住所 = 住所.append(RString.FULL_SPACE).append(宛名.get住所().get方書().value());
        }
        return 住所.toRString();
    }

    private KyodoshoriyoJukyushaIdoRenrakuhyoParam set共同処理用受給者異動情報_新規以外(
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity dbT3002Entity,
            DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity dbT3003Entity,
            DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity dbT3004Entity) {
        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = new KyodoshoriyoJukyushaIdoRenrakuhyoParam();

        KyoutuuEntity 共通項目Entity = new KyoutuuEntity();
        if (dbT3002Entity != null) {
            共通項目Entity.set証記載保険者番号(dbT3002Entity.getShoKisaiHokenshaNo());
            共通項目Entity.set被保険者番号(dbT3002Entity.getHiHokenshaNo());
            共通項目Entity.set異動区分(dbT3002Entity.getIdoKubunCode());
            共通項目Entity.set異動事由(dbT3002Entity.getJukyushaIdoJiyu());
        } else if (dbT3003Entity != null) {
            共通項目Entity.set証記載保険者番号(dbT3003Entity.getShoKisaiHokenshaNo());
            共通項目Entity.set被保険者番号(dbT3003Entity.getHiHokenshaNo());
            共通項目Entity.set異動区分(dbT3003Entity.getIdoKubunCode());
            共通項目Entity.set異動事由(dbT3003Entity.getJukyushaIdoJiyu());
        } else {
            共通項目Entity.set証記載保険者番号(dbT3004Entity.getShoKisaiHokenshaNo());
            共通項目Entity.set被保険者番号(dbT3004Entity.getHiHokenshaNo());
            共通項目Entity.set異動区分(dbT3004Entity.getIdoKubunCode());
            共通項目Entity.set異動事由(dbT3004Entity.getJukyushaIdoJiyu());
        }
        entity.set共通項目Entity(共通項目Entity);

        DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity 基本情報Entity = new DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
        if (dbT3002Entity != null) {
            基本情報Entity.setIdoYMD(dbT3002Entity.getIdoYMD());
            基本情報Entity.setRirekiNo(dbT3002Entity.getRirekiNo());
            基本情報Entity.setHiHokenshaName(dbT3002Entity.getHiHokenshaName());
            基本情報Entity.setTelNo(dbT3002Entity.getTelNo());
            基本情報Entity.setYubinNo(dbT3002Entity.getYubinNo());
            基本情報Entity.setAddress(dbT3002Entity.getAddress());
            基本情報Entity.setDdressKana(dbT3002Entity.getDdressKana());
            基本情報Entity.setChohyoOutputJunjyoCode(dbT3002Entity.getChohyoOutputJunjyoCode());
            基本情報Entity.setTeiseiKubunCode(dbT3002Entity.getTeiseiKubunCode());
            基本情報Entity.setTeiseiYMD(dbT3002Entity.getTeiseiYMD());
        }
        entity.set基本情報Entity(基本情報Entity);

        DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity 償還情報Entity = new DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
        if (dbT3003Entity != null) {
            償還情報Entity.setIdoYMD(dbT3003Entity.getIdoYMD());
            償還情報Entity.setRirekiNo(dbT3003Entity.getRirekiNo());
            償還情報Entity.setHokenKyufuIchijiSashitomeKaishiYMD(dbT3003Entity.getHokenKyufuIchijiSashitomeKaishiYMD());
            償還情報Entity.setHokenKyufuIchijiSashitomeShuryoYMD(dbT3003Entity.getHokenKyufuIchijiSashitomeShuryoYMD());
            償還情報Entity.setHokenkyufuIchijiSashitomeKubunCode(dbT3003Entity.getHokenkyufuIchijiSashitomeKubunCode());
            償還情報Entity.setHokenkyufuIchijiSashitomeKingaku(dbT3003Entity.getHokenkyufuIchijiSashitomeKingaku());
        }
        entity.set償還情報Entity(償還情報Entity);

        DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity 高額情報Entity = new DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity();
        if (dbT3004Entity != null) {
            高額情報Entity.setIdoYMD(dbT3004Entity.getIdoYMD());
            高額情報Entity.setRirekiNo(dbT3004Entity.getRirekiNo());
            高額情報Entity.setSetaiShuyakuNo(dbT3004Entity.getSetaiShuyakuNo());
            高額情報Entity.setSetaiShotokuKubunCode(dbT3004Entity.getSetaiShotokuKubunCode());
            高額情報Entity.setShotokuKubunCode(dbT3004Entity.getShotokuKubunCode());
            高額情報Entity.setRiyoshaFutan2DankaiAriFlag(dbT3004Entity.getRiyoshaFutan2DankaiAriFlag());
            高額情報Entity.setRoureiFukushiNenkinJukyuAriFlag(dbT3004Entity.getRoureiFukushiNenkinJukyuAriFlag());
            高額情報Entity.setShikyuShinseishoOutputAriFlag(dbT3004Entity.getShikyuShinseishoOutputAriFlag());
        }
        entity.set高額情報Entity(高額情報Entity);

        return entity;
    }
}

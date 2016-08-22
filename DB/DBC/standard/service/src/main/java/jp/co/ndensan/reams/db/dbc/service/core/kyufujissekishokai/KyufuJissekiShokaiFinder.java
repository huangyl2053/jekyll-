/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho1;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufujissekishokai.KyufuJissekiHeaderJohoMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiJyohoRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekishokai.IKyufuJissekiShokaiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 給付実績照会情報の取得クラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
public class KyufuJissekiShokaiFinder {

    private final MapperProvider mapperProvider;
    private final DbV1001HihokenshaDaichoAliveDac dbV1001;
    private final DbV4001JukyushaDaichoAliveDac dbV4001;
    private static final RString 準拠する = new RString("1");
    private static final RString 準拠しない = new RString("0");

    /**
     * コンストラクタです。
     */
    KyufuJissekiShokaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbV1001 = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
        this.dbV4001 = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);

    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param dbV1001 dbV1001
     * @param dbV4001 dbV4001
     */
    KyufuJissekiShokaiFinder(MapperProvider mapperProvider, DbV1001HihokenshaDaichoAliveDac dbV1001,
            DbV4001JukyushaDaichoAliveDac dbV4001) {
        this.mapperProvider = mapperProvider;
        this.dbV1001 = dbV1001;
        this.dbV4001 = dbV4001;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyufuJissekiShokaiFinder}のインスタンスを返します。
     *
     * @return KyufuJissekiShokaiFinder
     */
    public static KyufuJissekiShokaiFinder createInstance() {
        return InstanceProvider.create(KyufuJissekiShokaiFinder.class);
    }

    /**
     * 給付実績ヘッダ情報１の取得処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @return SearchResult<KyufuJissekiHedajyoho1> 給付実績ヘッダ情報1
     */
    public SearchResult<KyufuJissekiHedajyoho1> getKyufuJissekiHeaderJoho1(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        List<KyufuJissekiHedajyoho1> 給付実績ヘッダ情報1 = new ArrayList<>();
        DbV1001HihokenshaDaichoEntity 最新の被保険者台帳情報 = dbV1001.get最新の被保険者台帳情報(被保険者番号);
        if (最新の被保険者台帳情報 == null) {
            return SearchResult.of(給付実績ヘッダ情報1, 0, false);
        }
        KyufuJissekiHedajyoho1 給付実績ヘッダ情報 = new KyufuJissekiHedajyoho1();
        給付実績ヘッダ情報.set被保険者番号(被保険者番号);
        給付実績ヘッダ情報.set資格取得事由コード(最新の被保険者台帳情報.getShikakuShutokuJiyuCode());
        DbV4001JukyushaDaichoEntity 受給者情報 = dbV4001.selectBy被保険者番号And識別コード(
                最新の被保険者台帳情報.getHihokenshaNo(), 最新の被保険者台帳情報.getShikibetsuCode());
        if (受給者情報 != null) {
            給付実績ヘッダ情報.set要介護認定状態区分コード(受給者情報.getYokaigoJotaiKubunCode().value());
            給付実績ヘッダ情報.set認定有効期間開始年月日(受給者情報.getNinteiYukoKikanKaishiYMD());
            給付実績ヘッダ情報.set認定有効期間終了年月日(受給者情報.getNinteiYukoKikanShuryoYMD());
            給付実績ヘッダ情報.set認定年月日(受給者情報.getNinteiYMD());
            ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                    ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
            key.setデータ取得区分(DataShutokuKubun.直近レコード);
            key.set識別コード(最新の被保険者台帳情報.getShikibetsuCode());
            UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
            IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
            UaFt200FindShikibetsuTaishoEntity 宛名情報 = mapper.get宛名情報(
                    KyufuJissekiHeaderJohoMapperParameter.createParameter_宛名情報(
                            new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString())));
            if (宛名情報 != null) {
                IKojin 個人情報 = ShikibetsuTaishoFactory.createKojin(宛名情報);
                給付実績ヘッダ情報.set名称(個人情報.get名称().getName().value());
                給付実績ヘッダ情報.set性別コード(個人情報.get性別().getCode());
                給付実績ヘッダ情報.set生年月日(個人情報.get生年月日().toFlexibleDate());
            }
        }
        給付実績ヘッダ情報1.add(給付実績ヘッダ情報);
        return SearchResult.of(給付実績ヘッダ情報1, 0, false);
    }

    /**
     * 給付実績ヘッダ情報２の取得処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 識別番号 識別番号
     * @return SearchResult<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報２
     */
    public SearchResult<KyufuJissekiHedajyoho2> getKyufuJissekiHeaderJoho2(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, NyuryokuShikibetsuNo 識別番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号"));
        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2リスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufuJissekiJyohoRelateEntity> 給付実績情報リスト = mapper.get給付実績情報(
                KyufuJissekiHeaderJohoMapperParameter.createParameter_給付実績情報(
                        被保険者番号, サービス提供年月, 整理番号, 識別番号.value()));
        for (KyufuJissekiJyohoRelateEntity 給付実績情報 : 給付実績情報リスト) {
            KyufuJissekiHedajyoho2 給付実績ヘッダ情報2 = new KyufuJissekiHedajyoho2();
            給付実績ヘッダ情報2.setサービス提供年月(給付実績情報.getServiceTeikyoYM());
            給付実績ヘッダ情報2.set整理番号(給付実績情報.getSeiriNo());
            給付実績ヘッダ情報2.set給付実績区分コード(給付実績情報.getKyufuSakuseiKubunCode());
            給付実績ヘッダ情報2.set識別番号名称(給付実績情報.getShikibetsuMeisho());
            給付実績ヘッダ情報2.set事業者名称(getJikyoshaName(給付実績情報.getJigyoshoNo(), サービス提供年月));
        }
        return SearchResult.of(給付実績ヘッダ情報2リスト, 0, false);
    }

    /**
     * 事業者名称の取得処理です。
     *
     * @param 事業所番号 事業所番号
     * @param 基準年月 基準年月
     * @return 事業者名称
     */
    public RString getJikyoshaName(JigyoshaNo 事業所番号, FlexibleYearMonth 基準年月) {
        if (事業所番号 == null || 事業所番号.isEmpty()) {
            return RString.EMPTY;
        }
        RString 事業者名称_介護事業者 = RString.EMPTY;
        RString 事業者名称_介護事業者指定サービス = RString.EMPTY;
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        DbT7060KaigoJigyoshaEntity 介護事業者情報 = mapper.get介護事業者情報(
                KyufuJissekiHeaderJohoMapperParameter.createParameter_事業者名称(事業所番号, 基準年月));
        if (介護事業者情報 == null) {
            return RString.EMPTY;
        } else if (介護事業者情報.getJigyoshaName() != null
                && !介護事業者情報.getJigyoshaName().isEmpty()) {
            事業者名称_介護事業者 = 介護事業者情報.getJigyoshaName().value();
        }
        DbT7063KaigoJigyoshaShiteiServiceEntity 介護事業者指定サービス情報 = mapper.get介護事業者指定サービス情報(
                KyufuJissekiHeaderJohoMapperParameter.createParameter_事業者名称(事業所番号, 基準年月));
        if (介護事業者指定サービス情報 == null) {
            return RString.EMPTY;
        } else if (介護事業者指定サービス情報.getJigyoshaName() != null
                && !介護事業者指定サービス情報.getJigyoshaName().isEmpty()) {
            事業者名称_介護事業者指定サービス = 介護事業者指定サービス情報.getJigyoshaName().value();
        }
        if (準拠する.equals(介護事業者指定サービス情報.getKihonJohoJunkyoKubun())) {
            return 事業者名称_介護事業者;
        } else if (準拠しない.equals(介護事業者指定サービス情報.getKihonJohoJunkyoKubun())) {
            return 事業者名称_介護事業者指定サービス;
        }
        return RString.EMPTY;
    }

    /**
     * 識別番号管理データの取得処理です。
     *
     * @param サービス提供年月 サービス提供年月
     * @param 識別番号 識別番号
     * @return 識別番号管理データ
     */
    public SearchResult<ShikibetsuNoKanri> getShikibetsuBangoKanri(FlexibleYearMonth サービス提供年月, NyuryokuShikibetsuNo 識別番号) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号"));
        List<ShikibetsuNoKanri> 識別番号管理データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3118ShikibetsuNoKanriEntity> 識別番号管理データ = mapper.get識別番号管理データ(
                KyufuJissekiHeaderJohoMapperParameter.createParameter_識別番号管理データ(サービス提供年月, 識別番号.value()));
        if (識別番号管理データ != null && !識別番号管理データ.isEmpty()) {
            ShikibetsuNoKanri 識別番号管理データ1件目 = new ShikibetsuNoKanri(識別番号管理データ.get(0));
            識別番号管理データリスト.add(識別番号管理データ1件目);
        }
        return SearchResult.of(識別番号管理データリスト, 0, false);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.renrakuhyodatacreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2013HokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3017KyufujissekiKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3055KogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4014RiyoshaFutangakuGengakuDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiDac;
import jp.co.ndensan.reams.db.dbu.business.core.renrakuhyodatacreator.FutangakuGengakuBusiness;
import jp.co.ndensan.reams.db.dbu.business.core.renrakuhyodatacreator.KyufuJissekiKihonBuseiness;
import jp.co.ndensan.reams.db.dbu.business.core.renrakuhyodatacreator.RiyoshaFutangakuBusiness;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.renrakuhyodatacreator.FutangakuGengakuMybatisParameter;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.renrakuhyodatacreator.IRenrakuhyoDataCreatorMapper;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbz.business.core.view.JukyushaDaichoAlive;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険連絡票作成のサービスクラスです。
 *
 * @reamsid_L DBA-1290-020 linghuhang
 */
public class RenrakuhyoDataCreatorFinder {

    private final MapperProvider mapperProvider;
    private final DbV1001HihokenshaDaichoAliveDac dbv1001Dac;
    private final DbT4021ShiharaiHohoHenkoDac dbt4021Dac;
    private final DbT3017KyufujissekiKihonDac dbt3017Dac;
    private final DbT2013HokenryoDankaiDac dbt2013Dac;
    private final DbT3055KogakuKyufuTaishoshaGokeiDac dbt3055Dac;
    private final DbT2002FukaDac dbt2002Dac;
    private final DbV4001JukyushaDaichoAliveDac dbv4001Dac;
    private final DbT4014RiyoshaFutangakuGengakuDac dbt4014Dac;
    private final DbT4018KaigoHokenFutanGendogakuNinteiDac dbt4018Dac;
    private static final RString 被保険者番号メッセージ = new RString("被保険者番号");
    private static final RString 基準日メッセージ = new RString("基準日");

    /**
     * コンストラクタです。
     *
     */
    RenrakuhyoDataCreatorFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbv1001Dac = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
        this.dbt4021Dac = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
        this.dbt3017Dac = InstanceProvider.create(DbT3017KyufujissekiKihonDac.class);
        this.dbt2013Dac = InstanceProvider.create(DbT2013HokenryoDankaiDac.class);
        this.dbt3055Dac = InstanceProvider.create(DbT3055KogakuKyufuTaishoshaGokeiDac.class);
        this.dbt2002Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.dbv4001Dac = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);
        this.dbt4014Dac = InstanceProvider.create(DbT4014RiyoshaFutangakuGengakuDac.class);
        this.dbt4018Dac = InstanceProvider.create(DbT4018KaigoHokenFutanGendogakuNinteiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac DbV1001HihokenshaDaichoAliveDac
     * @param mapperProvider mapperProvider
     */
    RenrakuhyoDataCreatorFinder(MapperProvider mapperProvider,
            DbV1001HihokenshaDaichoAliveDac dbc1001Dac,
            DbT4021ShiharaiHohoHenkoDac dbt4021Dac,
            DbT3017KyufujissekiKihonDac dbt3017Dac,
            DbT2013HokenryoDankaiDac dbt2013Dac,
            DbT3055KogakuKyufuTaishoshaGokeiDac dbt3055Dac,
            DbT2002FukaDac dbt2002Dac,
            DbV4001JukyushaDaichoAliveDac dbv4001Dac,
            DbT4014RiyoshaFutangakuGengakuDac dbt4014Dac,
            DbT4018KaigoHokenFutanGendogakuNinteiDac dbt4018Dac) {
        this.mapperProvider = mapperProvider;
        this.dbv1001Dac = dbc1001Dac;
        this.dbt4021Dac = dbt4021Dac;
        this.dbt3017Dac = dbt3017Dac;
        this.dbt2013Dac = dbt2013Dac;
        this.dbt3055Dac = dbt3055Dac;
        this.dbt2002Dac = dbt2002Dac;
        this.dbv4001Dac = dbv4001Dac;
        this.dbt4014Dac = dbt4014Dac;
        this.dbt4018Dac = dbt4018Dac;
    }

    /**
     * {@link RenrakuhyoDataCreatorFinder#create}にて生成した{@link RenrakuhyoDataCreatorFinder}のインスタンスを返します。
     *
     * @return RenrakuhyoDataCreatorFinder
     */
    public static RenrakuhyoDataCreatorFinder createInstance() {
        return InstanceProvider.create(RenrakuhyoDataCreatorFinder.class);
    }

    /**
     * 旧措置情報と給付率を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準日 基準日
     * @return RiyoshaFutangakuBusiness
     */
    @Transaction
    public RiyoshaFutangakuBusiness get旧措置情報(HihokenshaNo 被保険者番号, FlexibleDate 基準日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(基準日メッセージ.toString()));
        DbT4014RiyoshaFutangakuGengakuEntity entity = dbt4014Dac.get利用者負担額減額(被保険者番号,
                基準日,
                ShiharaiHenkoKanriKubun._２号差止.getコード());
        if (entity == null) {
            return null;
        }
        return new RiyoshaFutangakuBusiness(entity);

    }

    /**
     * 被保険者番号により、負担限度額情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準日 基準日
     * @return FutangakuGengakuBusiness
     */
    @Transaction
    public FutangakuGengakuBusiness get負担限度額(HihokenshaNo 被保険者番号, FlexibleDate 基準日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(基準日メッセージ.toString()));
        DbT4018KaigoHokenFutanGendogakuNinteiEntity entity = dbt4018Dac.get利用者負担額減額(被保険者番号,
                基準日,
                ShiharaiHenkoKanriKubun._２号差止.getコード());
        if (entity == null) {
            return null;
        }
        return new FutangakuGengakuBusiness(entity);
    }

    /**
     * 支払方法変更情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 基準日 FlexibleDate
     * @return ShiharaiHohoHenko
     */
    @Transaction
    public ShiharaiHohoHenko get支払方法変更(HihokenshaNo 被保険者番号, FlexibleDate 基準日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(基準日メッセージ.toString()));
        DbT4021ShiharaiHohoHenkoEntity entity = dbt4021Dac.get支払方法変更(被保険者番号, 基準日, ShiharaiHenkoKanriKubun._１号給付額減額.getコード());
        if (entity == null) {
            return null;
        }
        return new ShiharaiHohoHenko(entity);
    }

    /**
     * 被保険者番号、サービス提供年月により、給付実績基本情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 基準日 FlexibleDate
     * @return KyufuJissekiKihonBuseiness
     */
    @Transaction
    public KyufuJissekiKihonBuseiness get給付実績基本(HihokenshaNo 被保険者番号,
            FlexibleDate 基準日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(基準日メッセージ.toString()));
        DbT3017KyufujissekiKihonEntity entity = dbt3017Dac.get給付実績基本(被保険者番号, 基準日.getYearMonth());
        if (entity == null) {
            return null;
        }
        return new KyufuJissekiKihonBuseiness(entity);
    }

    /**
     * 被保険者番号、サービス提供年月により、給付実績基本情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return Decimal
     */
    @Transaction
    public Decimal get利用者負担額(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        FutangakuGengakuMybatisParameter parameter = FutangakuGengakuMybatisParameter.createParam_Futangaku(被保険者番号, サービス提供年月);
        IRenrakuhyoDataCreatorMapper mapper = mapperProvider.create(IRenrakuhyoDataCreatorMapper.class);
        Decimal 利用者負担額 = new Decimal(0);
        for (int i = 0; i < mapper.get利用者負担額(parameter).size(); i++) {
            if (mapper.get利用者負担額(parameter).get(i) != null) {
                利用者負担額 = 利用者負担額.add(mapper.get利用者負担額(parameter).get(i));
            } else {
                利用者負担額 = 利用者負担額.add(new Decimal(0));
            }
        }
        return 利用者負担額;
    }

    /**
     * 高額介護サービス費給付対象者合計データを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準日 基準日
     * @return KogakuKyufuTaishoshaGokei
     */
    @Transaction
    public KogakuKyufuTaishoshaGokei get高額介護サービス費給付対象者合計(HihokenshaNo 被保険者番号, FlexibleDate 基準日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(基準日メッセージ.toString()));
        DbT3055KogakuKyufuTaishoshaGokeiEntity entity = dbt3055Dac.get高額介護サービス費給付対象者合計(被保険者番号, 基準日.getYearMonth());
        if (entity == null) {
            return null;
        }
        return new KogakuKyufuTaishoshaGokei(entity);
    }

    /**
     * 高額介護サービス費給付対象者合計データを取得します。
     *
     * @param 世帯集約番号 世帯集約番号
     * @param サービス提供年月 サービス提供年月
     * @return KogakuKyufuTaishoshaGokei
     */
    @Transaction
    public KogakuKyufuTaishoshaGokei get高額介護サービス費給付対象者合計(FlexibleYearMonth サービス提供年月, RString 世帯集約番号) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(世帯集約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯集約番号"));
        DbT3055KogakuKyufuTaishoshaGokeiEntity entity = dbt3055Dac.get高額介護サービス費給付対象者合計(サービス提供年月, 世帯集約番号);
        if (entity == null) {
            return null;
        }
        return new KogakuKyufuTaishoshaGokei(entity);
    }

    /**
     * 保険料段階情報を取得します。
     *
     * @param 基準日 FlexibleDate
     * @return SearchResult<HokenryoDankai>
     */
    @Transaction
    public SearchResult<HokenryoDankai> get保険料段階(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(基準日メッセージ.toString()));
        List<DbT2013HokenryoDankaiEntity> 保険料段階情報 = dbt2013Dac.selectDankaiByFukaNendo(基準日.getYear());
        List<HokenryoDankai> hokenryoDankai = new ArrayList<>();
        if (保険料段階情報 == null || 保険料段階情報.isEmpty()) {
            return SearchResult.of(Collections.<HokenryoDankai>emptyList(), 0, false);
        }
        for (DbT2013HokenryoDankaiEntity entity : 保険料段階情報) {
            hokenryoDankai.add(new HokenryoDankai(entity));
        }
        return SearchResult.of(hokenryoDankai, 0, false);
    }

    /**
     * 介護賦課を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 基準日 FlexibleDate
     * @return Fuka
     */
    @Transaction
    public Fuka get介護賦課(HihokenshaNo 被保険者番号, FlexibleDate 基準日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(基準日メッセージ.toString()));
        DbT2002FukaEntity entity = dbt2002Dac.get介護賦課(被保険者番号, 基準日.getYear());
        if (entity == null) {
            return null;
        }
        return new Fuka(entity);
    }

    /**
     * 受給者台帳を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return SearchResult<JukyushaDaicho>
     */
    @Transaction
    public JukyushaDaichoAlive get受給者台帳(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        DbV4001JukyushaDaichoEntity entity = dbv4001Dac.select受給者台帳情報(被保険者番号);
        if (entity == null) {
            return null;
        }
        return new JukyushaDaichoAlive(entity);
    }

    /**
     * 被保険者番号により、被保険者台帳管理Aliveを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return SearchResult<HihokenshaDaichoAlive>
     */
    @Transaction
    public HihokenshaDaichoAlive get被保険者台帳(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        DbV1001HihokenshaDaichoEntity 被保険者台帳 = dbv1001Dac.get被保険者台帳(被保険者番号);
        if (被保険者台帳 == null) {
            return null;
        }
        return new HihokenshaDaichoAlive(被保険者台帳);
    }

    /**
     * 被保険者番号により、被保険者台帳管理Aliveを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return HihokenshaDaichoAlive
     */
    @Transaction
    public HihokenshaDaichoAlive get被保険者台帳情報(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        DbV1001HihokenshaDaichoEntity 被保険者台帳 = dbv1001Dac.get被保険者台帳情報(被保険者番号);
        if (被保険者台帳 == null) {
            return null;
        }
        return new HihokenshaDaichoAlive(被保険者台帳);
    }
}

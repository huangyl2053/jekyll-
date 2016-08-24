/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.jyukyusyajoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3100NijiYoboJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbd.business.core.basic.KaigoHokenFutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShakaiFukushiHojinRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.hyojunfutangakugemmen.HyojunFutangakuGemmen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4012HyojunFutangakuGemmenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3105SogoJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4012HyojunFutangakuGemmenDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4014RiyoshaFutangakuGengakuDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4016HomonKaigoRiyoshaFutangakuGengakuDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4020TokubetsuchiikiKasanGemmenDac;
import jp.co.ndensan.reams.db.dbu.business.core.jyukyusyajoho.JukyuNinteiJohoBusiness;
import jp.co.ndensan.reams.db.dbu.business.core.jyukyusyajoho.JukyuShinseiJohoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jyukyusyajoho.SogoSyokaiMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jyukyusyajoho.JukyuNinteiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jyukyusyajoho.JukyuShinseiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jyukyusyajoho.ISogoSyokaiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 総合照会_受給者情報のクラスです。
 *
 * @reamsid_L DBU-4100-030 xuyannan
 */
public class SogoSyokaiJyukyusyaJohoFinder {

    private static final RString 被保険者番号メッセージ = new RString("被保険者番号");
    private final MapperProvider mapperProvider;
    private final DbT4018KaigoHokenFutanGendogakuNinteiDac 介護保険負担限度額認定dac;
    private final DbT4014RiyoshaFutangakuGengakuDac 利用者負担額減額dac;
    private final DbT4016HomonKaigoRiyoshaFutangakuGengakuDac 訪問介護利用者負担額減額dac;
    private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac 社会福祉法人等利用者負担軽減dac;
    private final DbT4020TokubetsuchiikiKasanGemmenDac 特別地域加算減免dac;
    private final DbT4012HyojunFutangakuGemmenDac 標準負担減免dac;
    private final DbT4021ShiharaiHohoHenkoDac 支払方法変更dac;
    private final DbT3100NijiYoboJigyoTaishoshaDac 二次予防事業対象者dac;
    private final DbT3105SogoJigyoTaishoshaDac 総合事業対象者dac;

    /**
     * コンストラクタです。
     */
    public SogoSyokaiJyukyusyaJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護保険負担限度額認定dac = InstanceProvider.create(DbT4018KaigoHokenFutanGendogakuNinteiDac.class);
        this.利用者負担額減額dac = InstanceProvider.create(DbT4014RiyoshaFutangakuGengakuDac.class);
        this.訪問介護利用者負担額減額dac = InstanceProvider.create(DbT4016HomonKaigoRiyoshaFutangakuGengakuDac.class);
        this.社会福祉法人等利用者負担軽減dac = InstanceProvider.create(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac.class);
        this.特別地域加算減免dac = InstanceProvider.create(DbT4020TokubetsuchiikiKasanGemmenDac.class);
        this.標準負担減免dac = InstanceProvider.create(DbT4012HyojunFutangakuGemmenDac.class);
        this.支払方法変更dac = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
        this.二次予防事業対象者dac = InstanceProvider.create(DbT3100NijiYoboJigyoTaishoshaDac.class);
        this.総合事業対象者dac = InstanceProvider.create(DbT3105SogoJigyoTaishoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4018KaigoHokenFutanGendogakuNinteiDac}
     */
    SogoSyokaiJyukyusyaJohoFinder(MapperProvider mapperProvider,
            DbT4018KaigoHokenFutanGendogakuNinteiDac 介護保険負担限度額認定dac,
            DbT4014RiyoshaFutangakuGengakuDac 利用者負担額減額dac,
            DbT4016HomonKaigoRiyoshaFutangakuGengakuDac 訪問介護利用者負担額減額dac,
            DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac 社会福祉法人等利用者負担軽減dac,
            DbT4020TokubetsuchiikiKasanGemmenDac 特別地域加算減免dac,
            DbT4012HyojunFutangakuGemmenDac 標準負担減免dac,
            DbT4021ShiharaiHohoHenkoDac 支払方法変更dac,
            DbT3100NijiYoboJigyoTaishoshaDac 二次予防事業対象者dac,
            DbT3105SogoJigyoTaishoshaDac 総合事業対象者dac) {
        this.mapperProvider = mapperProvider;
        this.介護保険負担限度額認定dac = 介護保険負担限度額認定dac;
        this.利用者負担額減額dac = 利用者負担額減額dac;
        this.訪問介護利用者負担額減額dac = 訪問介護利用者負担額減額dac;
        this.社会福祉法人等利用者負担軽減dac = 社会福祉法人等利用者負担軽減dac;
        this.特別地域加算減免dac = 特別地域加算減免dac;
        this.標準負担減免dac = 標準負担減免dac;
        this.支払方法変更dac = 支払方法変更dac;
        this.二次予防事業対象者dac = 二次予防事業対象者dac;
        this.総合事業対象者dac = 総合事業対象者dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SogoSyokaiJyukyusyaJohoFinder}のインスタンスを返します。
     *
     *
     * @return SogoSyokaiJyukyusyaJohoFinder
     */
    public static SogoSyokaiJyukyusyaJohoFinder createInstance() {
        return InstanceProvider.create(SogoSyokaiJyukyusyaJohoFinder.class);
    }

    /**
     * 被保険者番号、受給認定情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return JukyuNinteiJohoBusiness
     */
    public JukyuNinteiJohoBusiness get受給認定情報(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        SogoSyokaiMybatisParameter parameter = SogoSyokaiMybatisParameter.createParam(被保険者番号.value(), ShinseiJokyoKubun.認定完了.getコード());
        ISogoSyokaiMapper mapper = mapperProvider.create(ISogoSyokaiMapper.class);
        JukyuNinteiJohoRelateEntity entity = mapper.getJukyuNinteiJoho(parameter);
        if (entity == null) {
            return null;
        }
        return new JukyuNinteiJohoBusiness(entity);
    }

    /**
     * 被保険者番号、受給申請情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return JukyuShinseiJohoBusiness
     */
    public JukyuShinseiJohoBusiness get受給申請情報(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        SogoSyokaiMybatisParameter parameter = SogoSyokaiMybatisParameter.createParam(被保険者番号.value(), ShinseiJokyoKubun.申請中.getコード());
        ISogoSyokaiMapper mapper = mapperProvider.create(ISogoSyokaiMapper.class);
        JukyuShinseiJohoRelateEntity entity = mapper.getJukyuShinseiJoho(parameter);
        if (entity == null) {
            return null;
        }
        return new JukyuShinseiJohoBusiness(entity);
    }

    /**
     * 特定負担限度額認定を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return KaigoHokenFutanGendogakuNintei
     */
    public KaigoHokenFutanGendogakuNintei get負担限度額認定(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        DbT4018KaigoHokenFutanGendogakuNinteiEntity entity = 介護保険負担限度額認定dac.get負担限度額認定情報(被保険者番号);
        if (entity == null) {
            return null;
        }
        return new KaigoHokenFutanGendogakuNintei(entity);
    }

    /**
     * 利用者負担額減額を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return RiyoshaFutangakuGengaku
     */
    public RiyoshaFutangakuGengaku get利用者負担額減額(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        DbT4014RiyoshaFutangakuGengakuEntity entity = 利用者負担額減額dac.get利用者負担額減額情報(被保険者番号);
        if (entity == null) {
            return null;
        }
        RiyoshaFutangakuGengakuEntity gengakuEntity = new RiyoshaFutangakuGengakuEntity();
        gengakuEntity.set利用者負担額減額Entity(entity);
        return new RiyoshaFutangakuGengaku(gengakuEntity);
    }

    /**
     * 訪問介護利用者負担額減額を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return HomonKaigoRiyoshaFutangakuGengaku
     */
    public HomonKaigoRiyoshaFutangakuGengaku get訪問介護利用者負担額減額(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity entity = 訪問介護利用者負担額減額dac.get訪問介護利用者負担額減額情報(被保険者番号);
        if (entity == null) {
            return null;
        }
        HomonKaigoRiyoshaFutangakuGengakuEntity gengakuEntity = new HomonKaigoRiyoshaFutangakuGengakuEntity();
        gengakuEntity.set訪問介護利用者負担額減額Entity(entity);
        return new HomonKaigoRiyoshaFutangakuGengaku(gengakuEntity);
    }

    /**
     * 社会福祉法人等利用者負担軽減を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return ShakaiFukushiHojinRiyoshaFutanKeigen
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigen get社会福祉法人等利用者負担軽減(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity = 社会福祉法人等利用者負担軽減dac.get社会福祉法人等利用者負担軽減情報(被保険者番号);
        if (entity == null) {
            return null;
        }
        return new ShakaiFukushiHojinRiyoshaFutanKeigen(entity);
    }

    /**
     * 特別地域加算減免を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return TokubetsuchiikiKasanGemmen
     */
    public TokubetsuchiikiKasanGemmen get特別地域加算減免(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        DbT4020TokubetsuchiikiKasanGemmenEntity entity = 特別地域加算減免dac.get特別地域加算減免情報(被保険者番号);
        if (entity == null) {
            return null;
        }
        TokubetsuchiikiKasanGemmenEntity gemmenEntity = new TokubetsuchiikiKasanGemmenEntity();
        gemmenEntity.set特別地域加算減免Entity(entity);
        return new TokubetsuchiikiKasanGemmen(gemmenEntity);
    }

    /**
     * 標準負担減免を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return HyojunFutangakuGemmen
     */
    public HyojunFutangakuGemmen get標準負担減免(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        DbT4012HyojunFutangakuGemmenEntity entity = 標準負担減免dac.get標準負担額減免情報(被保険者番号);
        if (entity == null) {
            return null;
        }
        return new HyojunFutangakuGemmen(entity);
    }

    /**
     * 支払方法変更を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 管理区分List 管理区分List
     * @return ShiharaiHohoHenko
     */
    public ShiharaiHohoHenko get支払方法変更(HihokenshaNo 被保険者番号, List<RString> 管理区分List) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        requireNonNull(管理区分List, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分List"));
        DbT4021ShiharaiHohoHenkoEntity entity = 支払方法変更dac.get支払方法変更情報(被保険者番号, 管理区分List);
        if (entity == null) {
            return null;
        }
        return new ShiharaiHohoHenko(entity);
    }

    /**
     * 給付額減額情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @return ShiharaiHohoHenko
     */
    public ShiharaiHohoHenko get給付額減額情報(HihokenshaNo 被保険者番号, RString 管理区分) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));
        DbT4021ShiharaiHohoHenkoEntity entity = 支払方法変更dac.get給付額減額情報(被保険者番号, 管理区分);
        if (entity == null) {
            return null;
        }
        return new ShiharaiHohoHenko(entity);
    }

    /**
     * 総合事業_経過措置_対象者情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return NijiYoboJigyoTaishosha
     */
    public NijiYoboJigyoTaishosha get総合事業_経過措置_対象者情報(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        DbT3100NijiYoboJigyoTaishoshaEntity entity = 二次予防事業対象者dac.get総合事業_経過措置_対象者情報(被保険者番号);
        if (entity == null) {
            return null;
        }
        return new NijiYoboJigyoTaishosha(entity);
    }

    /**
     * 総合事業対象者を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return SogoJigyoTaishosha
     */
    public SogoJigyoTaishosha get総合事業対象者(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号メッセージ.toString()));
        DbT3105SogoJigyoTaishoshaEntity entity = 総合事業対象者dac.get総合事業対象者情報(被保険者番号);
        if (entity == null) {
            return null;
        }
        return new SogoJigyoTaishosha(entity);
    }
}

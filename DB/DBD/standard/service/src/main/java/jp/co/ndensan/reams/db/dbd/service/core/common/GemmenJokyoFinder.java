/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.common;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbd.business.core.common.NursingCareInformationBusiness;
import jp.co.ndensan.reams.db.dbd.business.core.common.VariousReductionInformation;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenkoSummary;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenjokyo.GemmenJokyoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.common.NursingCareInformationCodeEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.common.NursingCareInformationEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenjokyo.IGemmenJokyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 減免照会（画面）です。
 *
 * @reamsid_L DBD-4342-020 wangjie2
 */
public class GemmenJokyoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    GemmenJokyoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 減免照会（画面）のIntanceを作成します。
     *
     * @return GemmenJokyoFinder
     */
    public static GemmenJokyoFinder createIntance() {
        return InstanceProvider.create(GemmenJokyoFinder.class);
    }

    /**
     * 要介護認定情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<要介護認定情報>
     */
    @Transaction
    public List<NursingCareInformationBusiness> find要介護認定情報(HihokenshaNo 被保険者番号) {
        IGemmenJokyoMapper mapper = mapperProvider.create(IGemmenJokyoMapper.class);
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set被保険者番号(被保険者番号);
        List<NursingCareInformationCodeEntity> codeEntityList = mapper.get要介護認定情報(parameter);
        List<NursingCareInformationBusiness> 要介護認定情報List = new ArrayList<>();
        for (NursingCareInformationCodeEntity codeEntity : codeEntityList) {
            NursingCareInformationEntity entity = new NursingCareInformationEntity();
            entity.set申請状況区分(ShinseiJokyoKubun.toValue(codeEntity.get申請状況区分()));
            entity.set受給申請年月日(codeEntity.get受給申請年月日());
            entity.set認定有効期間終了年月日(codeEntity.get認定有効期間終了年月日());
            entity.set認定有効期間開始年月日(codeEntity.get認定有効期間開始年月日());
            entity.set認定年月日(codeEntity.get認定年月日());
            entity.set旧措置者フラグ(codeEntity.is旧措置者フラグ());
            entity.set受給申請事由(JukyuShinseiJiyu.toValue(codeEntity.get受給申請事由().getColumnValue()));
            entity.set要介護度(YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode.toValue(
                    codeEntity.get厚労省IF識別コード().getColumnValue()), codeEntity.get要介護認定状態区分コード().getColumnValue()));
            要介護認定情報List.add(new NursingCareInformationBusiness(entity));
        }
        return 要介護認定情報List;
    }

    /**
     * 申請中情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<受給者台帳>
     */
    @Transaction
    public List<JukyushaDaicho> find申請中情報(HihokenshaNo 被保険者番号) {
        DbT4001JukyushaDaichoDac dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        DbT4001JukyushaDaichoEntity entity = dac.select申請中情報By被保険者番号(被保険者番号);
        List<JukyushaDaicho> 申請中情報List = new ArrayList<>();
        if (entity != null) {
            JukyushaDaicho 申請中情報 = new JukyushaDaicho(entity);
            申請中情報List.add(申請中情報);
        }
        return 申請中情報List;
    }

    /**
     * 各種減免情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 各種減免情報
     */
    @Transaction
    public VariousReductionInformation find減免情報(HihokenshaNo 被保険者番号) {
        List<FutanGendogakuNintei> 介護保険負担限度額認定の情報List = get介護保険負担限度額認定の情報(被保険者番号);
        List<RiyoshaFutangakuGengaku> 利用者負担額減額の情報List = get利用者負担額減額の情報(被保険者番号);
        List<HomonKaigoRiyoshaFutangakuGengaku> 訪問介護利用者負担額減額の情報List = get訪問介護利用者負担額減額の情報(被保険者番号);
        List<ShakaifukuRiyoshaFutanKeigen> 社会福祉法人等利用者負担軽減の情報List = get社会福祉法人等利用者負担軽減の情報(被保険者番号);
        List<TokubetsuchiikiKasanGemmen> 特別地域加算減免の情報List = get特別地域加算減免の情報(被保険者番号);
        return new VariousReductionInformation(介護保険負担限度額認定の情報List, 利用者負担額減額の情報List,
                訪問介護利用者負担額減額の情報List, 社会福祉法人等利用者負担軽減の情報List, 特別地域加算減免の情報List);
    }

    private List<TokubetsuchiikiKasanGemmen> get特別地域加算減免の情報(HihokenshaNo 被保険者番号) {
        IGemmenJokyoMapper mapper = mapperProvider.create(IGemmenJokyoMapper.class);
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set減免減額種類コード(GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード());
        parameter.set被保険者番号(被保険者番号);
        List<TokubetsuchiikiKasanGemmen> 特別地域加算減免の情報List = new ArrayList<>();
        TokubetsuchiikiKasanGemmenEntity entity = mapper.get特別地域加算減免の情報(parameter);
        if (entity != null) {
            特別地域加算減免の情報List.add(new TokubetsuchiikiKasanGemmen(entity));
        }
        return 特別地域加算減免の情報List;
    }

    private List<HomonKaigoRiyoshaFutangakuGengaku> get訪問介護利用者負担額減額の情報(HihokenshaNo 被保険者番号) {
        IGemmenJokyoMapper mapper = mapperProvider.create(IGemmenJokyoMapper.class);
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set減免減額種類コード(GemmenGengakuShurui.訪問介護利用者負担額減額.getコード());
        parameter.set被保険者番号(被保険者番号);
        List<HomonKaigoRiyoshaFutangakuGengaku> 訪問介護利用者負担額減額の情報List = new ArrayList<>();
        HomonKaigoRiyoshaFutangakuGengakuEntity entity = mapper.get訪問介護利用者負担額減額の情報(parameter);
        if (entity != null) {
            訪問介護利用者負担額減額の情報List.add(new HomonKaigoRiyoshaFutangakuGengaku(entity));
        }
        return 訪問介護利用者負担額減額の情報List;
    }

    private List<ShakaifukuRiyoshaFutanKeigen> get社会福祉法人等利用者負担軽減の情報(HihokenshaNo 被保険者番号) {
        IGemmenJokyoMapper mapper = mapperProvider.create(IGemmenJokyoMapper.class);
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set減免減額種類コード(GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード());
        parameter.set被保険者番号(被保険者番号);
        ShafukuRiyoshaFutanKeigenEntity entity = mapper.get社会福祉法人等利用者負担軽減の情報(parameter);
        List<ShakaifukuRiyoshaFutanKeigen> 社会福祉法人等利用者負担軽減の情報List = new ArrayList<>();
        if (entity != null) {
            社会福祉法人等利用者負担軽減の情報List.add(new ShakaifukuRiyoshaFutanKeigen(entity));
        }
        return 社会福祉法人等利用者負担軽減の情報List;
    }

    private List<FutanGendogakuNintei> get介護保険負担限度額認定の情報(HihokenshaNo 被保険者番号) {
        IGemmenJokyoMapper mapper = mapperProvider.create(IGemmenJokyoMapper.class);
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set減免減額種類コード(GemmenGengakuShurui.負担限度額認定.getコード());
        parameter.set被保険者番号(被保険者番号);
        FutanGendogakuNinteiEntity entity = mapper.get介護保険負担限度額認定の情報(parameter);
        List<FutanGendogakuNintei> 介護保険負担限度額認定の情報List = new ArrayList<>();
        if (entity != null) {
            介護保険負担限度額認定の情報List.add(new FutanGendogakuNintei(entity));
        }
        return 介護保険負担限度額認定の情報List;
    }

    private List<RiyoshaFutangakuGengaku> get利用者負担額減額の情報(HihokenshaNo 被保険者番号) {
        IGemmenJokyoMapper mapper = mapperProvider.create(IGemmenJokyoMapper.class);
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set減免減額種類コード(GemmenGengakuShurui.利用者負担額減額.getコード());
        parameter.set被保険者番号(被保険者番号);
        RiyoshaFutangakuGengakuEntity entity = mapper.get利用者負担額減額の情報(parameter);
        List<RiyoshaFutangakuGengaku> 利用者負担額減額の情報List = new ArrayList<>();
        if (entity != null) {
            利用者負担額減額の情報List.add(new RiyoshaFutangakuGengaku(entity));
        }
        return 利用者負担額減額の情報List;
    }

    /**
     * 老齢年金受給情報を取得します。
     *
     * @param 識別コード 識別コード
     * @return 老齢年金情報
     */
    @Transaction
    public List<RoreiFukushiNenkinJukyusha> find老齢年金情報(ShikibetsuCode 識別コード) {
        IGemmenJokyoMapper mapper = mapperProvider.create(IGemmenJokyoMapper.class);
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set識別コード(識別コード);
        parameter.setシステム日付(RDate.getNowDate().toDateString());
        DbT7006RoreiFukushiNenkinJukyushaEntity entity = mapper.get老齢年金情報(parameter);
        List<RoreiFukushiNenkinJukyusha> 老齢年金情報List = new ArrayList<>();
        if (entity != null) {
            老齢年金情報List.add(new RoreiFukushiNenkinJukyusha(entity));
        }
        return 老齢年金情報List;
    }

    /**
     * 給付制限情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 給付制限情報
     */
    @Transaction
    public ShiharaiHohoHenkoSummary find支払方法変更情報(HihokenshaNo 被保険者番号) {
        IGemmenJokyoMapper mapper = mapperProvider.create(IGemmenJokyoMapper.class);
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set被保険者番号(被保険者番号);
        List<DbT4021ShiharaiHohoHenkoEntity> dbt4021EntityList = mapper.get支払方法変更情報(parameter);
        ShiharaiHohoHenkoSummary 支払方法変更概況 = new ShiharaiHohoHenkoSummary();
        if (null == dbt4021EntityList || dbt4021EntityList.isEmpty()) {
            支払方法変更概況.set支払方法変更_登録区分(ShiharaiHenkoTorokuKubun._空);
            支払方法変更概況.set支払方法変更_開始日(FlexibleDate.EMPTY);
            支払方法変更概況.set支払方法変更_終了日(FlexibleDate.EMPTY);
            支払方法変更概況.set給付額減額_登録区分(ShiharaiHenkoTorokuKubun._空);
            支払方法変更概況.set給付額減額_開始日(FlexibleDate.EMPTY);
            支払方法変更概況.set給付額減額_終了日(FlexibleDate.EMPTY);
        } else {
            DbT4021ShiharaiHohoHenkoEntity 支払方法変更取得結果_１号償還払い化 = get取得結果(ShiharaiHenkoKanriKubun._１号償還払い化, dbt4021EntityList);
            DbT4021ShiharaiHohoHenkoEntity 支払方法変更取得結果_２号差止 = get取得結果(ShiharaiHenkoKanriKubun._２号差止, dbt4021EntityList);
            if (支払方法変更取得結果_１号償還払い化 != null) {
                支払方法変更概況.set支払方法変更_登録区分(ShiharaiHenkoTorokuKubun.toValue(支払方法変更取得結果_１号償還払い化.getTorokuKubun()));
                支払方法変更概況.set支払方法変更_開始日(支払方法変更取得結果_１号償還払い化.getTekiyoKaishiYMD());
                支払方法変更概況.set支払方法変更_終了日(支払方法変更取得結果_１号償還払い化.getTekiyoShuryoYMD());
            } else if (支払方法変更取得結果_２号差止 != null) {
                支払方法変更概況.set支払方法変更_登録区分(ShiharaiHenkoTorokuKubun.toValue(支払方法変更取得結果_２号差止.getTorokuKubun()));
                支払方法変更概況.set支払方法変更_開始日(支払方法変更取得結果_２号差止.getTekiyoKaishiYMD());
                支払方法変更概況.set支払方法変更_終了日(支払方法変更取得結果_２号差止.getTekiyoShuryoYMD());
            } else {
                支払方法変更概況.set支払方法変更_登録区分(ShiharaiHenkoTorokuKubun._空);
                支払方法変更概況.set支払方法変更_開始日(FlexibleDate.EMPTY);
                支払方法変更概況.set支払方法変更_終了日(FlexibleDate.EMPTY);
            }
            DbT4021ShiharaiHohoHenkoEntity 支払方法変更取得結果_１号給付額減額 = get取得結果(ShiharaiHenkoKanriKubun._１号給付額減額, dbt4021EntityList);
            if (支払方法変更取得結果_１号給付額減額 != null) {
                支払方法変更概況.set給付額減額_登録区分(ShiharaiHenkoTorokuKubun.toValue(支払方法変更取得結果_１号給付額減額.getTorokuKubun()));
                支払方法変更概況.set給付額減額_開始日(支払方法変更取得結果_１号給付額減額.getTekiyoKaishiYMD());
                支払方法変更概況.set給付額減額_終了日(支払方法変更取得結果_１号給付額減額.getTekiyoShuryoYMD());
            } else {
                支払方法変更概況.set給付額減額_登録区分(ShiharaiHenkoTorokuKubun._空);
                支払方法変更概況.set給付額減額_開始日(FlexibleDate.EMPTY);
                支払方法変更概況.set給付額減額_終了日(FlexibleDate.EMPTY);
            }
        }
        return 支払方法変更概況;
    }

    private DbT4021ShiharaiHohoHenkoEntity get取得結果(ShiharaiHenkoKanriKubun 管理区分,
            List<DbT4021ShiharaiHohoHenkoEntity> dbt4021EntityList) {
        for (DbT4021ShiharaiHohoHenkoEntity dbT4021Entity : dbt4021EntityList) {
            if (管理区分.getコード().equals(dbT4021Entity.getKanriKubun())) {
                return dbT4021Entity;
            }
        }
        return null;
    }

    /**
     * 指定の被保険者番号を持つ被保険者の識別コードを取得して返却します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 識別コード
     */
    @Transaction
    public ShikibetsuCode get識別コード(HihokenshaNo 被保険者番号) {
        DbV1001HihokenshaDaichoAliveDac dac = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
        DbV1001HihokenshaDaichoEntity dbV1001Entity = dac.get最新の被保険者台帳情報(被保険者番号);
        if (null == dbV1001Entity) {
            return ShikibetsuCode.EMPTY;
        }
        return dbV1001Entity.getShikibetsuCode();
    }

    /**
     * 指定の被保険者番号の利用者負担割合（明細）情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 利用者負担割合明細
     */
    @Transaction
    public List<RiyoshaFutanWariaiMeisai> find利用者負担割合明細(HihokenshaNo 被保険者番号) {
        IGemmenJokyoMapper mapper = mapperProvider.create(IGemmenJokyoMapper.class);
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set被保険者番号(被保険者番号);
        parameter.setシステム日付(RDate.getNowDate().toDateString());
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> dbT3114EntityList = mapper.get利用者負担割合明細(parameter);
        List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細List = new ArrayList<>();
        for (DbT3114RiyoshaFutanWariaiMeisaiEntity dbT3114Entity : dbT3114EntityList) {
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = new RiyoshaFutanWariaiMeisai(dbT3114Entity);
            利用者負担割合明細List.add(利用者負担割合明細);
        }
        return 利用者負担割合明細List;
    }

}

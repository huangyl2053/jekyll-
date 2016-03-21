/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.common;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.shiharaihohohenko.ShiharaiHohoHenkoSummary;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.business.common.NursingCareInformationBusiness;
import jp.co.ndensan.reams.db.dbd.business.common.ShiharaiHohoHenkoSummaryBusiness;
import jp.co.ndensan.reams.db.dbd.business.common.VariousReductionInformation;
import jp.co.ndensan.reams.db.dbd.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbd.definition.common.GemmenJokyoParameter;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbd.entity.common.NursingCareInformationCodeEntity;
import jp.co.ndensan.reams.db.dbd.entity.common.NursingCareInformationEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.common.IGemmenJokyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 減免照会（画面）です。
 */
public class GemmenJokyoFinder {

    private final MapperProvider mapperProvider;
    private final IGemmenJokyoMapper mapper;
    private ShiharaiHenkoTorokuKubun ShiharaiHenkoTorokuKubun;

    /**
     * コンストラクタです。
     */
    GemmenJokyoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(IGemmenJokyoMapper.class);
    }

    /**
     * 減免照会（画面）のIntanceを作成します。
     *
     * @return GemmenJokyoFinder
     */
    public static GemmenJokyoFinder createIntance() {
        return new GemmenJokyoFinder();
    }

    /**
     * 要介護認定情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<要介護認定情報>
     */
    @Transaction
    public List<NursingCareInformationBusiness> find要介護認定情報(HihokenshaNo 被保険者番号) {
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
            //TODO 受給者台帳Newest.厚労省IF識別コード
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
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set被保険者番号(被保険者番号);
        DbT4001JukyushaDaichoEntity entity = mapper.get申請中情報(parameter);
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
    public VariousReductionInformation find減免情報(HihokenshaNo 被保険者番号) {
        return null;
    }

    /**
     * 老齢年金受給情報を取得します。
     *
     * @param 識別コード 識別コード
     * @return 老齢年金情報
     */
    @Transaction
    public List<RoreiFukushiNenkinJukyusha> find老齢年金情報(ShikibetsuCode 識別コード) {
        //TODO 老齢福祉年金受給者は　DbT7005RojinHokenJukyushaJohoEntity を保持するクラス
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set識別コード(識別コード);
        parameter.setシステム日付(RDate.getNowDate());
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
    public ShiharaiHohoHenkoSummaryBusiness find支払方法変更情報(HihokenshaNo 被保険者番号) {
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set被保険者番号(被保険者番号);
        List<DbT4021ShiharaiHohoHenkoEntity> dbT4021EntityList = mapper.get支払方法変更情報(parameter);
        ShiharaiHohoHenkoSummary 支払方法変更概況 = new ShiharaiHohoHenkoSummary();
        ShiharaiHohoHenkoSummaryBusiness 給付制限情報;
        if (null == dbT4021EntityList || dbT4021EntityList.isEmpty()) {
            支払方法変更概況.set支払方法変更_登録区分(ShiharaiHenkoTorokuKubun._空);
            支払方法変更概況.set支払方法変更_開始日(FlexibleDate.EMPTY);
            支払方法変更概況.set支払方法変更_終了日(FlexibleDate.EMPTY);
            支払方法変更概況.set給付額減額_登録区分(ShiharaiHenkoTorokuKubun._空);
            支払方法変更概況.set給付額減額_開始日(FlexibleDate.EMPTY);
            支払方法変更概況.set給付額減額_終了日(FlexibleDate.EMPTY);
            給付制限情報 = new ShiharaiHohoHenkoSummaryBusiness(支払方法変更概況);
        } else {
            DbT4021ShiharaiHohoHenkoEntity 支払方法変更取得結果_１号償還払い化 = get取得結果(ShiharaiHenkoKanriKubun._１号償還払い化, dbT4021EntityList);
            if (支払方法変更取得結果_１号償還払い化 != null) {
                支払方法変更概況.set支払方法変更_登録区分(ShiharaiHenkoTorokuKubun.toValue(支払方法変更取得結果_１号償還払い化.getKanriKubun()));
                支払方法変更概況.set支払方法変更_開始日(支払方法変更取得結果_１号償還払い化.getTekiyoKaishiYMD());
                支払方法変更概況.set支払方法変更_終了日(支払方法変更取得結果_１号償還払い化.getTekiyoShuryoYMD());
            } else {
                DbT4021ShiharaiHohoHenkoEntity 支払方法変更取得結果_２号差止 = get取得結果(ShiharaiHenkoKanriKubun._２号差止, dbT4021EntityList);
                if (支払方法変更取得結果_２号差止 != null) {
                    支払方法変更概況.set支払方法変更_登録区分(ShiharaiHenkoTorokuKubun.toValue(支払方法変更取得結果_２号差止.getKanriKubun()));
                    支払方法変更概況.set支払方法変更_開始日(支払方法変更取得結果_２号差止.getTekiyoKaishiYMD());
                    支払方法変更概況.set支払方法変更_終了日(支払方法変更取得結果_２号差止.getTekiyoShuryoYMD());
                } else {
                    //TODO DBD_Enum.支払方法変更登録区分．空
                    支払方法変更概況.set支払方法変更_登録区分(ShiharaiHenkoTorokuKubun._空);
                    支払方法変更概況.set支払方法変更_開始日(FlexibleDate.EMPTY);
                    支払方法変更概況.set支払方法変更_終了日(FlexibleDate.EMPTY);
                }
            }
            DbT4021ShiharaiHohoHenkoEntity 支払方法変更取得結果_１号給付額減額 = get取得結果(ShiharaiHenkoKanriKubun._１号給付額減額, dbT4021EntityList);
            if (支払方法変更取得結果_１号給付額減額 != null) {
                支払方法変更概況.set給付額減額_登録区分(ShiharaiHenkoTorokuKubun.toValue(支払方法変更取得結果_１号給付額減額.getKanriKubun()));
                支払方法変更概況.set給付額減額_開始日(支払方法変更取得結果_１号給付額減額.getTekiyoKaishiYMD());
                支払方法変更概況.set給付額減額_終了日(支払方法変更取得結果_１号給付額減額.getTekiyoShuryoYMD());
            } else {
                支払方法変更概況.set給付額減額_登録区分(ShiharaiHenkoTorokuKubun._空);
                支払方法変更概況.set給付額減額_開始日(FlexibleDate.EMPTY);
                支払方法変更概況.set給付額減額_終了日(FlexibleDate.EMPTY);
            }
            給付制限情報 = new ShiharaiHohoHenkoSummaryBusiness(支払方法変更概況);
        }
        return 給付制限情報;
    }

    private DbT4021ShiharaiHohoHenkoEntity get取得結果(ShiharaiHenkoKanriKubun 管理区分,
            List<DbT4021ShiharaiHohoHenkoEntity> dbT4021EntityList) {
        for (DbT4021ShiharaiHohoHenkoEntity dbT4021Entity : dbT4021EntityList) {
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
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set被保険者番号(被保険者番号);
        List<DbV1001HihokenshaDaichoEntity> dbV1001EntityList = mapper.get識別コード(parameter);
        if (null == dbV1001EntityList || dbV1001EntityList.isEmpty()) {
            return ShikibetsuCode.EMPTY;
        }
        return dbV1001EntityList.get(0).getShikibetsuCode();
    }

    /**
     * 指定の被保険者番号の利用者負担割合（明細）情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 利用者負担割合明細
     */
    @Transaction
    public List<RiyoshaFutanWariaiMeisai> find利用者負担割合明細(HihokenshaNo 被保険者番号) {
        GemmenJokyoParameter parameter = new GemmenJokyoParameter();
        parameter.set被保険者番号(被保険者番号);
        parameter.setシステム日付(RDate.getNowDate());
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> dbT3114EntityList = mapper.get利用者負担割合明細(parameter);
        List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細List = new ArrayList<>();
        for (DbT3114RiyoshaFutanWariaiMeisaiEntity dbT3114Entity : dbT3114EntityList) {
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = new RiyoshaFutanWariaiMeisai(dbT3114Entity);
            利用者負担割合明細List.add(利用者負担割合明細);
        }
        return 利用者負担割合明細List;
    }

}

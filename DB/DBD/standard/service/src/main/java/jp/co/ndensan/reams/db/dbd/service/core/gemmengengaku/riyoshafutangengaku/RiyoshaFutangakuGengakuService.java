/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.riyoshafutangengaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuServiceMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.basic.IDbT3114RiyoshaFutanWariaiMeisaiMapper;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.riyoshafutangengaku.IRiyoshaFutangakuGengakuMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担額減額申請（画面）のビジネスです。
 *
 * @reamsid_L DBD-3600-030 xuyue
 */
public class RiyoshaFutangakuGengakuService {

    private final MapperProvider mapperProvider;
    private final DbT4001JukyushaDaichoDac dac;

    /**
     * コンストラクタです。
     */
    public RiyoshaFutangakuGengakuService() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * 利用者負担額減額申請（画面）のビジネスを生成します。
     *
     * @return 利用者負担額減額申請（画面）のビジネス
     */
    public static RiyoshaFutangakuGengakuService createInstance() {
        return InstanceProvider.create(RiyoshaFutangakuGengakuService.class);
    }

    /**
     * 被保険者番号を使用して減免減額申請テーブルと利用者負担額減額テーブルより利用者負担額減額の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<利用者負担額減額の情報>
     */
    @Transaction
    public List<RiyoshaFutangakuGengaku> load利用者負担額減額申請All(HihokenshaNo 被保険者番号) {
        IRiyoshaFutangakuGengakuMapper riyoshaFutangakuGengakuMapper = mapperProvider.create(IRiyoshaFutangakuGengakuMapper.class);
        List<RiyoshaFutangakuGengakuEntity> 利用者負担額減額の情報 = riyoshaFutangakuGengakuMapper.
                select利用者負担額減額情報By被保険者番号(
                        RiyoshaFutangakuGengakuServiceMapperParameter.createParameter(GemmenGengakuShurui.利用者負担額減額.getコード(), 被保険者番号));

        List<RiyoshaFutangakuGengaku> list = new ArrayList<>();
        if (利用者負担額減額の情報 == null) {
            return list;
        }
        for (RiyoshaFutangakuGengakuEntity entity : 利用者負担額減額の情報) {
            list.add(new RiyoshaFutangakuGengaku(entity));
        }
        return list;
    }

    /**
     * 指定の適用日に対して、有効期限を判定し、返却します。
     *
     * @param 適用日 適用日
     * @return 有効期限
     */
    @Transaction
    public FlexibleDate estimate有効期限(FlexibleDate 適用日) {
        if (適用日 == null || 適用日.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        FlexibleDate 有効期限候補;
        RString 減免期限_利用減免;
        try {
            減免期限_利用減免 = DbBusinessConifg.get(ConfigNameDBD.減免期限_利用減免, RDate.getNowDate());
        } catch (Exception e) {
            return FlexibleDate.EMPTY;
        }
        RString 年 = 適用日.getYear().toDateString();
        RString 月 = new RString(new FlexibleDate(減免期限_利用減免).getMonthValue());
        RString 日 = new RString(new FlexibleDate(減免期限_利用減免).getDayValue());
        有効期限候補 = new FlexibleDate(年.concat(月).concat(日));

        if (適用日.isBeforeOrEquals(有効期限候補)) {
            return 有効期限候補;
        }
        return 有効期限候補.plusYear(1);
    }

    /**
     * 指定した被保険者番号を持つ被保険者の指定日時点の負担割合を返却します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準日 基準日
     * @return 負担割合区分
     */
    @Transaction
    public FutanwariaiKubun get利用者負担割合(HihokenshaNo 被保険者番号, FlexibleDate 基準日) {
        if (被保険者番号 == null || 基準日 == null) {
            throw new NullPointerException();
        }
        if (!基準日.getYear().isValid()) {
            throw new IllegalArgumentException();
        }
        IDbT3114RiyoshaFutanWariaiMeisaiMapper riyoshaFutanWariaiMeisaiMapper = mapperProvider.create(IDbT3114RiyoshaFutanWariaiMeisaiMapper.class);
        DbT3114RiyoshaFutanWariaiMeisaiEntity entity = riyoshaFutanWariaiMeisaiMapper
                .notExists_maxRirekiNo(被保険者番号.getColumnValue(), new RString(基準日.toString()));
        if (entity != null) {
            RString 負担割合区分 = entity.getFutanWariaiKubun();
            if (負担割合区分 != null && !負担割合区分.isEmpty()) {
                return FutanwariaiKubun.toValue(負担割合区分);
            }
        }
        return FutanwariaiKubun._１割;
    }

    /**
     * 指定の被保険者番号を持つ被保険者が、指定日時点でこの減免の利用者となれるかどうかを判定して返却します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 適用日 適用日
     * @return 判断結果(検索結果は存在する場合、true を返却する。検索結果は存在しない場合、falseを返却する。)
     */
    @Transaction
    public boolean canBe利用者(HihokenshaNo 被保険者番号, FlexibleDate 適用日) {

        List<DbT4001JukyushaDaichoEntity> list = dac.select受給者台帳情報By適用日(被保険者番号, 適用日);
        return !list.isEmpty();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.riyoshafutangengaku;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuViewState;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuServiceMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.basic.IDbT3114RiyoshaFutanWariaiMeisaiMapper;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.riyoshafutangengaku.IRiyoshaFutangakuGengakuMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
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
    private final RiyoshaFutangakuGengakuManager manager;
    private static final int INDEX_2 = 2;
    private static final int INDEX_4 = 4;

    /**
     * コンストラクタです。
     */
    RiyoshaFutangakuGengakuService() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        manager = RiyoshaFutangakuGengakuManager.createInstance();
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
                        RiyoshaFutangakuGengakuServiceMapperParameter.createParameter(GemmenGengakuShurui.利用者負担額減額.getコード(),
                                被保険者番号, RString.EMPTY));

        List<RiyoshaFutangakuGengaku> list = new ArrayList<>();
        for (RiyoshaFutangakuGengakuEntity entity : 利用者負担額減額の情報) {
            entity.initializeMd5ToEntities();
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
        RString 減免期限_利用減免 = BusinessConfig.get(ConfigNameDBD.減免期限_利用減免, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        if (減免期限_利用減免 == null) {
            return FlexibleDate.EMPTY;
        }
        RString 年 = 適用日.getYear().toDateString();
        RString 月 = 減免期限_利用減免.substring(0, INDEX_2);
        RString 日 = 減免期限_利用減免.substring(2, INDEX_4);
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
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));
        if (!基準日.getYear().isValid()) {
            throw new IllegalArgumentException();
        }
        IDbT3114RiyoshaFutanWariaiMeisaiMapper riyoshaFutanWariaiMeisaiMapper = mapperProvider.create(IDbT3114RiyoshaFutanWariaiMeisaiMapper.class);
        DbT3114RiyoshaFutanWariaiMeisaiEntity entity = riyoshaFutanWariaiMeisaiMapper
                .notExists_maxRirekiNo(
                        RiyoshaFutangakuGengakuServiceMapperParameter.createParameter(
                                null, 被保険者番号, new RString(基準日.toString())));
        if (entity != null) {
            RString 負担割合区分 = entity.getFutanWariaiKubun();
            try {
                return FutanwariaiKubun.toValue(負担割合区分);
            } catch (Exception e) {
                return FutanwariaiKubun._１割;
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

    /**
     * 画面の保存処理です。
     *
     * @param 削除List 削除List
     * @param 追加List 追加List
     * @param 修正List 修正List
     * @param 履歴修正ありList 履歴修正ありList
     */
    @Transaction
    public void 保存処理(List<RiyoshaFutangakuGengakuViewState> 削除List, List<RiyoshaFutangakuGengakuViewState> 追加List,
            List<RiyoshaFutangakuGengakuViewState> 修正List, List<RiyoshaFutangakuGengakuViewState> 履歴修正ありList) {

        if (!削除List.isEmpty()) {
            delete(削除List);
        }
        if (!修正List.isEmpty()) {
            更新or登録(修正List);
        }
        if (!履歴修正ありList.isEmpty()) {
            delete(履歴修正ありList);
            更新or登録(履歴修正ありList);
        }
        if (!追加List.isEmpty()) {
            更新or登録(追加List);
        }

    }

    private void 更新or登録(List<RiyoshaFutangakuGengakuViewState> 保存List) {

        RiyoshaFutangakuGengaku joho;
        for (RiyoshaFutangakuGengakuViewState viewState : 保存List) {

            int 処理後履歴番号 = viewState.getShorigoRirekiNo();
            joho = viewState.getRiyoshaFutangakuGengaku();

            if (処理後履歴番号 == joho.get履歴番号()) {
                manager.save利用者負担額減額(joho);
            } else {
                insert(joho, 処理後履歴番号);
            }
        }
    }

    private void insert(RiyoshaFutangakuGengaku joho, int 処理後履歴番号) {

        joho = joho.createBuilderForEdit().set履歴番号(処理後履歴番号).setState(EntityDataState.Added).build();
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = joho.getGemmenGengakuShinseiList();
        for (GemmenGengakuShinsei 減免減額申請 : gemmenGengakuShinseiList) {
            if (GemmenGengakuShurui.利用者負担額減額.getコード().equals(減免減額申請.get減免減額種類())) {
                減免減額申請 = 減免減額申請.createBuilderForEdit().set履歴番号(処理後履歴番号).setState(EntityDataState.Added).build();
                joho = joho.createBuilderForEdit().setGemmenGengakuShinsei(減免減額申請).build();
            }
        }
        manager.save利用者負担額減額(joho);
    }

    private void delete(List<RiyoshaFutangakuGengakuViewState> 削除List) {

        RiyoshaFutangakuGengaku joho;
        for (RiyoshaFutangakuGengakuViewState viewState : 削除List) {
            joho = viewState.getRiyoshaFutangakuGengaku();
            manager.delete利用者負担額減額(joho);
        }
    }

}

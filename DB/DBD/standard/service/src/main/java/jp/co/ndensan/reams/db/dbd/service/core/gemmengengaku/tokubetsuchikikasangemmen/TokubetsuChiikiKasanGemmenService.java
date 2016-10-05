/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.tokubetsuchikikasangemmen;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuChiikiKasanGemmenViewState;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuServiceMapperParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuChiikiKasanGemmenParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3105SogoJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4020TokubetsuchiikiKasanGemmenDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.basic.IDbT3114RiyoshaFutanWariaiMeisaiMapper;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.tokubetsuchikikasangemmen.ITokubetsuchiikiKasanGemmenMapper;
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
 *
 * 特別地域加算減免申請（画面）です。
 *
 * @reamsid_L DBD-3680-030 miaojin
 */
public class TokubetsuChiikiKasanGemmenService {

    private final MapperProvider mapperProvider;
    private static final int INDEX_2 = 2;
    private static final int INDEX_4 = 4;
    private final DbT4001JukyushaDaichoDac dac;
    private final DbT3105SogoJigyoTaishoshaDac dbT3105Dac;
    private final TokubetsuchiikiKasanGemmenManager manager;

    /**
     * コンストラクタです。
     */
    TokubetsuChiikiKasanGemmenService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        dbT3105Dac = InstanceProvider.create(DbT3105SogoJigyoTaishoshaDac.class);
        manager = TokubetsuchiikiKasanGemmenManager.createInstance();
    }

    /**
     * 特別地域加算減免申請（画面）のIntanceを作成します。
     *
     * @return TokubetsuChiikiKasanGemmenService
     */
    public static TokubetsuChiikiKasanGemmenService createIntance() {
        return InstanceProvider.create(TokubetsuChiikiKasanGemmenService.class);
    }

    /**
     * 特別地域加算減免申請情報の取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<TokubetsuchiikiKasanGemmen>
     */
    @Transaction
    public List<TokubetsuchiikiKasanGemmen> get特別地域加算減免申請の情報(HihokenshaNo 被保険者番号) {
        List<TokubetsuchiikiKasanGemmen> 特別地域加算減免申請の情報List = new ArrayList<>();
        TokubetsuChiikiKasanGemmenParameter 検索条件 = new TokubetsuChiikiKasanGemmenParameter(
                被保険者番号, GemmenGengakuShurui.特別地域加算減免.getコード());
        ITokubetsuchiikiKasanGemmenMapper mapper = mapperProvider.create(ITokubetsuchiikiKasanGemmenMapper.class);
        List<TokubetsuchiikiKasanGemmenEntity> entityList = mapper.select特別地域加算減免申請情報の取得(検索条件);
        if (entityList != null && !entityList.isEmpty()) {
            for (TokubetsuchiikiKasanGemmenEntity entity : entityList) {
                特別地域加算減免申請の情報List.add(new TokubetsuchiikiKasanGemmen(entity));
            }
        }
        return 特別地域加算減免申請の情報List;
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
        RString 減免期限_特地減免 = BusinessConfig.get(ConfigNameDBD.減免期限_特地減免, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        if (減免期限_特地減免 == null) {
            return FlexibleDate.EMPTY;
        }
        RString 年 = 適用日.getYear().toDateString();
        RString 月 = 減免期限_特地減免.substring(0, INDEX_2);
        RString 日 = 減免期限_特地減免.substring(2, INDEX_4);
        有効期限候補 = new FlexibleDate(年.concat(月).concat(日));

        if (適用日.isBeforeOrEquals(有効期限候補)) {
            return 有効期限候補;
        }
        return 有効期限候補.plusYear(1);
    }

    /**
     * 確認番号重複判定
     *
     * @param 適用日 適用日
     * @param 確認番号 確認番号
     * @return 確認番号に重複あり判断した場合true、それ以外の場合false
     */
    @Transaction
    public boolean exists確認番号In同一年度(FlexibleDate 適用日, RString 確認番号) {
        requireNonNull(確認番号, UrSystemErrorMessages.値がnull.getReplacedMessage("確認番号"));
        requireNonNull(適用日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用日"));
        FlexibleDate 年度終了日 = estimate有効期限(適用日);
        FlexibleDate 年度終了日の前年;
        if (年度終了日.isEmpty()) {
            年度終了日の前年 = FlexibleDate.EMPTY;
        } else {
            年度終了日の前年 = new FlexibleDate(年度終了日.getYearValue() - 1, 1, 1);
        }
        FlexibleDate 年度開始日;
        if (年度終了日の前年.isEmpty()) {
            年度開始日 = FlexibleDate.EMPTY;
        } else {
            年度開始日 = estimate有効期限(年度終了日の前年).plusDay(1);
        }
        DbT4020TokubetsuchiikiKasanGemmenDac dac
                = InstanceProvider.create(DbT4020TokubetsuchiikiKasanGemmenDac.class);
        List<DbT4020TokubetsuchiikiKasanGemmenEntity> entityList
                = dac.selectFor確認番号の重複判定(年度開始日, 年度終了日, 確認番号);
        return entityList != null && !entityList.isEmpty();
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
     * @return 判断結果(指定日時点でこの減免の利用者となれるかどうかを判定して返却します true:利用者)
     */
    @Transaction
    public boolean canBe利用者(HihokenshaNo 被保険者番号, FlexibleDate 適用日) {

        List<DbT4001JukyushaDaichoEntity> dbT4001EntityList = dac.select受給者台帳情報By適用日(被保険者番号, 適用日);
        if (!dbT4001EntityList.isEmpty()) {
            return true;
        }
        return !dbT3105Dac.selectFor総合事業対象者の判定(被保険者番号, 適用日).isEmpty();
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
    public void 保存処理(List<TokubetsuChiikiKasanGemmenViewState> 削除List, List<TokubetsuChiikiKasanGemmenViewState> 追加List,
            List<TokubetsuChiikiKasanGemmenViewState> 修正List, List<TokubetsuChiikiKasanGemmenViewState> 履歴修正ありList) {

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

    private void 更新or登録(List<TokubetsuChiikiKasanGemmenViewState> 保存List) {

        TokubetsuchiikiKasanGemmen joho;
        for (TokubetsuChiikiKasanGemmenViewState viewState : 保存List) {

            int 処理後履歴番号 = viewState.getShorigoRirekiNo();
            joho = viewState.getTokubetsuchiikiKasanGemmen();

            if (処理後履歴番号 == joho.get履歴番号()) {
                manager.save(joho);
            } else {
                insert(joho, 処理後履歴番号);
            }
        }
    }

    private void insert(TokubetsuchiikiKasanGemmen joho, int 処理後履歴番号) {

        joho = joho.createBuilderForEdit().set履歴番号(処理後履歴番号).setState(EntityDataState.Added).build();
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = joho.getGemmenGengakuShinseiList();
        for (GemmenGengakuShinsei 減免減額申請 : gemmenGengakuShinseiList) {
            if (GemmenGengakuShurui.特別地域加算減免.getコード().equals(減免減額申請.get減免減額種類())) {
                減免減額申請 = 減免減額申請.createBuilderForEdit().set履歴番号(処理後履歴番号).setState(EntityDataState.Added).build();
                joho = joho.createBuilderForEdit().setGemmenGengakuShinsei(減免減額申請).build();
            }
        }
        manager.save(joho);
    }

    private void delete(List<TokubetsuChiikiKasanGemmenViewState> 削除List) {

        TokubetsuchiikiKasanGemmen joho;
        for (TokubetsuChiikiKasanGemmenViewState viewState : 削除List) {
            joho = viewState.getTokubetsuchiikiKasanGemmen();
            manager.delete特別地域加算減免(joho);
        }
    }
}

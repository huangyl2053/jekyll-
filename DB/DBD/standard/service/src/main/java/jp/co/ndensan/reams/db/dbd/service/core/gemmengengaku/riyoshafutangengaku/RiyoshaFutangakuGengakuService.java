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
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuViewState;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuMapperParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuServiceMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.basic.IDbT3114RiyoshaFutanWariaiMeisaiMapper;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.riyoshafutangengaku.IRiyoshaFutangakuGengakuMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
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
    private RiyoshaFutangakuGengakuManager manager;
    private static final int INDEX_2 = 2;
    private static final int INDEX_4 = 4;
    private static final RString 空白KEY = new RString("-1");

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
        RiyoshaFutangakuGengaku dbObject;
        for (RiyoshaFutangakuGengakuViewState viewState : 保存List) {

            int 処理後履歴番号 = viewState.getShorigoRirekiNo();
            joho = viewState.getRiyoshaFutangakuGengaku();

            if (処理後履歴番号 == joho.get履歴番号()) {
                dbObject = manager.get利用者負担額減額(RiyoshaFutangakuGengakuMapperParameter
                        .createSelectByKeyParam(joho.get証記載保険者番号(), joho.get被保険者番号(), joho.get履歴番号()));
                update(joho, dbObject);
            } else {
                joho = joho.createBuilderForEdit().set履歴番号(処理後履歴番号).build();
                insert(joho);
            }
        }
    }

    private void update(RiyoshaFutangakuGengaku joho, RiyoshaFutangakuGengaku dbObject) {

        RiyoshaFutangakuGengakuBuilder builder = dbObject.createBuilderForEdit();
        builder.set旧措置者有無(joho.is旧措置者有無());
        if (joho.get申請事由() != null) {
            builder.set申請事由(joho.get申請事由());
        }
        builder.set申請年月日(joho.get申請年月日());
        if (joho.get決定区分() != null && KetteiKubun.承認する.getコード().equals(joho.get決定区分())) {
            builder.set決定区分(joho.get決定区分());
            builder.set決定年月日(joho.get決定年月日());
            builder.set適用開始年月日(joho.get適用開始年月日());
            builder.set適用終了年月日(joho.get適用終了年月日());
            builder.set給付率(joho.get給付率());
            builder.set非承認理由(RString.EMPTY);

        } else if (joho.get決定区分() != null && KetteiKubun.承認しない.getコード().equals(joho.get決定区分())) {
            builder.set決定区分(joho.get決定区分());
            builder.set決定年月日(joho.get決定年月日());
            builder.set非承認理由(joho.get非承認理由());
            builder.set給付率(HokenKyufuRitsu.ZERO);
            builder.set適用開始年月日(FlexibleDate.EMPTY);
            builder.set適用終了年月日(FlexibleDate.EMPTY);
        }

        GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder = new GemmenGengakuShinsei(joho.get証記載保険者番号(), joho.get被保険者番号(),
                GemmenGengakuShurui.利用者負担額減額.getコード(), joho.get履歴番号()).createBuilderForEdit();

        if (dbObject.getGemmenGengakuShinseiList() != null && dbObject.getGemmenGengakuShinseiList().size() > 0) {
            for (GemmenGengakuShinsei gemmenGengakuShinsei : dbObject.getGemmenGengakuShinseiList()) {
                if (GemmenGengakuShurui.利用者負担額減額.getコード().equals(gemmenGengakuShinsei.get減免減額種類())) {
                    gemmenGengakuShinseiBuilder = gemmenGengakuShinsei.createBuilderForEdit();
                    break;
                }
            }
        }
        GemmenGengakuShinsei pageGemmenGengakuShinsei = joho.getGemmenGengakuShinseiList().get(0);
        setGemmenGengakuShinseiBuilder(gemmenGengakuShinseiBuilder, pageGemmenGengakuShinsei);
        builder.setGemmenGengakuShinsei(gemmenGengakuShinseiBuilder.build());

        dbObject = builder.build();
        manager.save利用者負担額減額(dbObject);
    }

    private void insert(RiyoshaFutangakuGengaku joho) {

        RiyoshaFutangakuGengaku object = new RiyoshaFutangakuGengaku(joho.get証記載保険者番号(), joho.get被保険者番号(), joho.get履歴番号());

        RiyoshaFutangakuGengakuBuilder builder = object.createBuilderForEdit();
        builder.set旧措置者有無(joho.is旧措置者有無());
        if (joho.get申請事由() != null) {
            builder.set申請事由(joho.get申請事由());
        }
        builder.set申請年月日(joho.get申請年月日());
        if (joho.get決定区分() != null && KetteiKubun.承認する.getコード().equals(joho.get決定区分())) {
            builder.set決定区分(joho.get決定区分());
            builder.set決定年月日(joho.get決定年月日());
            builder.set適用開始年月日(joho.get適用開始年月日());
            builder.set適用終了年月日(joho.get適用終了年月日());
            builder.set給付率(joho.get給付率());
        } else if (joho.get決定区分() != null && KetteiKubun.承認しない.getコード().equals(joho.get決定区分())) {
            builder.set決定区分(joho.get決定区分());
            builder.set決定年月日(joho.get決定年月日());
            builder.set非承認理由(joho.get非承認理由());
        }

        GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder = new GemmenGengakuShinsei(joho.get証記載保険者番号(),
                joho.get被保険者番号(), GemmenGengakuShurui.利用者負担額減額.getコード(), joho.get履歴番号()).createBuilderForEdit();
        GemmenGengakuShinsei pageGemmenGengakuShinsei = joho.getGemmenGengakuShinseiList().get(0);
        setGemmenGengakuShinseiBuilder(gemmenGengakuShinseiBuilder, pageGemmenGengakuShinsei);
        builder.setGemmenGengakuShinsei(gemmenGengakuShinseiBuilder.build());

        object = builder.build();
        manager.save利用者負担額減額(object);
    }

    private void delete(List<RiyoshaFutangakuGengakuViewState> 削除List) {

        RiyoshaFutangakuGengaku joho;
        RiyoshaFutangakuGengaku object;
        for (RiyoshaFutangakuGengakuViewState viewState : 削除List) {
            joho = viewState.getRiyoshaFutangakuGengaku();
            object = manager.get利用者負担額減額(RiyoshaFutangakuGengakuMapperParameter
                    .createSelectByKeyParam(joho.get証記載保険者番号(), joho.get被保険者番号(), joho.get履歴番号()));
            if (object != null) {
                manager.delete利用者負担額減額(object);
            }
        }
    }

    private void setGemmenGengakuShinseiBuilder(GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder,
            GemmenGengakuShinsei pageGemmenGengakuShinsei) {
        if (pageGemmenGengakuShinsei.get事業者区分() != null && !空白KEY.equals(pageGemmenGengakuShinsei.get事業者区分())) {
            gemmenGengakuShinseiBuilder.set事業者区分(pageGemmenGengakuShinsei.get事業者区分());
        }
        if (pageGemmenGengakuShinsei.get申請届出代行事業者番号() != null && !pageGemmenGengakuShinsei.get申請届出代行事業者番号().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出代行事業者番号(pageGemmenGengakuShinsei.get申請届出代行事業者番号());
        }
        if (pageGemmenGengakuShinsei.get申請届出代行区分() != null && !空白KEY.equals(pageGemmenGengakuShinsei.get申請届出代行区分())) {
            gemmenGengakuShinseiBuilder.set申請届出代行区分(pageGemmenGengakuShinsei.get申請届出代行区分());
        }
        if (pageGemmenGengakuShinsei.get申請届出者住所() != null && !pageGemmenGengakuShinsei.get申請届出者住所().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者住所(pageGemmenGengakuShinsei.get申請届出者住所());
        }
        if (pageGemmenGengakuShinsei.get申請届出者氏名() != null && !pageGemmenGengakuShinsei.get申請届出者氏名().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者氏名(pageGemmenGengakuShinsei.get申請届出者氏名());
        }
        if (pageGemmenGengakuShinsei.get申請届出者氏名カナ() != null && !pageGemmenGengakuShinsei.get申請届出者氏名カナ().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者氏名カナ(pageGemmenGengakuShinsei.get申請届出者氏名カナ());
        }
        if (pageGemmenGengakuShinsei.get申請届出者続柄() != null && !pageGemmenGengakuShinsei.get申請届出者続柄().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者続柄(pageGemmenGengakuShinsei.get申請届出者続柄());
        }
        if (pageGemmenGengakuShinsei.get申請届出者郵便番号() != null && !pageGemmenGengakuShinsei.get申請届出者郵便番号().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者郵便番号(pageGemmenGengakuShinsei.get申請届出者郵便番号());
        }
        if (pageGemmenGengakuShinsei.get申請届出者電話番号() != null && !pageGemmenGengakuShinsei.get申請届出者電話番号().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者電話番号(pageGemmenGengakuShinsei.get申請届出者電話番号());
        }
    }
}

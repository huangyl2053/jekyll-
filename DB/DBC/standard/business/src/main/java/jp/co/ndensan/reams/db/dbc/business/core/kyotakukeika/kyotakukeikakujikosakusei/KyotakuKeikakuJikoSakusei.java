/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakusei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseimeisai.YoboKeikakuJikoSakuseiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseimeisai.YoboKeikakuJikoSakuseiMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.yobokeikakujikosakuseimeisai.YoboKeikakuJikoSakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画自己作成を管理するクラスです。
 */
public class KyotakuKeikakuJikoSakusei extends ParentModelBase<KyotakuKeikakuJikoSakuseiIdentifier, DbT3007KyotakuKeikakuJikoSakuseiEntity, KyotakuKeikakuJikoSakusei> implements Serializable {

    private final DbT3007KyotakuKeikakuJikoSakuseiEntity entity;
    private final KyotakuKeikakuJikoSakuseiIdentifier id;
    private final Models<KyotakuKeikakuJikosakuseiMeisaiIdentifier, KyotakuKeikakuJikosakuseiMeisai> kyotakuKeikakuJikosakuseiMeisai;
    private final Models<YoboKeikakuJikoSakuseiMeisaiIdentifier, YoboKeikakuJikoSakuseiMeisai> yoboKeikakuJikoSakuseiMeisai;

    /**
     * コンストラクタです。<br/>
     * 居宅給付計画自己作成の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     */
    public KyotakuKeikakuJikoSakusei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3007KyotakuKeikakuJikoSakuseiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoYM(対象年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyotakuKeikakuJikoSakuseiIdentifier(
                被保険者番号,
                対象年月,
                履歴番号
        );
        this.kyotakuKeikakuJikosakuseiMeisai = Models.create(new ArrayList<KyotakuKeikakuJikosakuseiMeisai>());
        this.yoboKeikakuJikoSakuseiMeisai = Models.create(new ArrayList<YoboKeikakuJikoSakuseiMeisai>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3007KyotakuKeikakuJikoSakuseiEntity}より{@link KyotakuKeikakuJikoSakusei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3007KyotakuKeikakuJikoSakuseiEntity}
     */
    public KyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiEntity entity) {
        this.entity = requireNonNull(entity.get居宅給付計画自己作成Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成"));
        this.id = new KyotakuKeikakuJikoSakuseiIdentifier(
                entity.get居宅給付計画自己作成Entity().getHihokenshaNo(),
                entity.get居宅給付計画自己作成Entity().getTaishoYM(),
                entity.get居宅給付計画自己作成Entity().getRirekiNo());
        List<KyotakuKeikakuJikosakuseiMeisai> kyotakuKeikakuJikosakuseiMeisaiList = new ArrayList<>();
        for (KyotakuKeikakuJikosakuseiMeisaiEntity kyotakuEntity : entity.get居宅給付計画自己作成明細Entity()) {
            kyotakuKeikakuJikosakuseiMeisaiList.add(new KyotakuKeikakuJikosakuseiMeisai(kyotakuEntity));
        }
        this.kyotakuKeikakuJikosakuseiMeisai = Models.create(kyotakuKeikakuJikosakuseiMeisaiList);
        List<YoboKeikakuJikoSakuseiMeisai> yoboKeikakuJikoSakuseiMeisaiList = new ArrayList<>();
        for (YoboKeikakuJikoSakuseiMeisaiEntity yoboKeikakuJikoSakuseiMeisaiEntity : entity.get予防給付計画自己作成明細Entity()) {
            yoboKeikakuJikoSakuseiMeisaiList.add(new YoboKeikakuJikoSakuseiMeisai(yoboKeikakuJikoSakuseiMeisaiEntity));
        }
        this.yoboKeikakuJikoSakuseiMeisai = Models.create(yoboKeikakuJikoSakuseiMeisaiList);
    }


    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3007KyotakuKeikakuJikoSakuseiEntity}
     * @param id {@link KyotakuKeikakuJikoSakuseiIdentifier}
     */
    KyotakuKeikakuJikoSakusei(
            DbT3007KyotakuKeikakuJikoSakuseiEntity entity,
            KyotakuKeikakuJikoSakuseiIdentifier id
    ,Models<KyotakuKeikakuJikosakuseiMeisaiIdentifier, KyotakuKeikakuJikosakuseiMeisai> kyotakuKeikakuJikosakuseiMeisai,
    Models<YoboKeikakuJikoSakuseiMeisaiIdentifier, YoboKeikakuJikoSakuseiMeisai> yoboKeikakuJikoSakuseiMeisai
    ) {
        this.entity = entity;
        this.id = id;
        this.kyotakuKeikakuJikosakuseiMeisai = kyotakuKeikakuJikosakuseiMeisai;
        this.yoboKeikakuJikoSakuseiMeisai = yoboKeikakuJikoSakuseiMeisai;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 対象年月を返します。
     *
     * @return 対象年月
     */
    public FlexibleYearMonth get対象年月() {
        return entity.getTaishoYM();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 居宅・総合事業区分を返します。
     *
     * @return 居宅・総合事業区分
     */
    public RString get居宅_総合事業区分() {
        return entity.getKyotaku_SogoJigyoKubun();
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
    }

    /**
     * 作成区分コードを返します。
     *
     * @return 作成区分コード
     */
    public RString get作成区分コード() {
        return entity.getSakuseiKubunCode();
    }

    /**
     * 計画作成年月日を返します。
     *
     * @return 計画作成年月日
     */
    public FlexibleDate get計画作成年月日() {
        return entity.getKeikakuSakuseiYMD();
    }

    /**
     * 計画変更年月日を返します。
     *
     * @return 計画変更年月日
     */
    public FlexibleDate get計画変更年月日() {
        return entity.getKeikakuHenkoYMD();
    }

    /**
     * 計画変更事由を返します。
     *
     * @return 計画変更事由
     */
    public RString get計画変更事由() {
        return entity.getKeikakuHenkoJiyu();
    }

    /**
     * {@link DbT3007KyotakuKeikakuJikoSakuseiEntity}のクローンを返します。
     *
     * @return {@link DbT3007KyotakuKeikakuJikoSakuseiEntity}のクローン
     */
    @Override
    public DbT3007KyotakuKeikakuJikoSakuseiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 居宅給付計画自己作成の識別子{@link KyotakuKeikakuJikoSakuseiIdentifier}を返します。
     *
     * @return 居宅給付計画自己作成の識別子{@link KyotakuKeikakuJikoSakuseiIdentifier}
     */
    @Override
    public KyotakuKeikakuJikoSakuseiIdentifier identifier() {
        return this.id;
    }

    /**
     * 居宅給付計画自己作成配下の要素を削除対象とします。<br/>
     * {@link DbT3007KyotakuKeikakuJikoSakuseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 居宅給付計画自己作成配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link KyotakuKeikakuJikoSakusei}を返します。
     *
     * @return 削除対象処理実施後の{@link KyotakuKeikakuJikoSakusei}
     * @throws IllegalStateException DbT3007KyotakuKeikakuJikoSakuseiEntityのデータ状態が変更の場合
     */
    @Override
    public KyotakuKeikakuJikoSakusei deleted() {
        DbT3007KyotakuKeikakuJikoSakuseiEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyotakuKeikakuJikoSakusei(
                deletedEntity, id, kyotakuKeikakuJikosakuseiMeisai.deleted(), yoboKeikakuJikoSakuseiMeisai.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || kyotakuKeikakuJikosakuseiMeisai.hasAnyChanged() || yoboKeikakuJikoSakuseiMeisai.hasAnyChanged();
    }

    /**
     * 居宅給付計画自己作成のみを変更対象とします。<br/>
     * {@link DbT3007KyotakuKeikakuJikoSakuseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyotakuKeikakuJikoSakusei}
     */
    @Override
    public KyotakuKeikakuJikoSakusei modifiedModel() {
        DbT3007KyotakuKeikakuJikoSakuseiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyotakuKeikakuJikoSakusei(
                modifiedEntity, id, kyotakuKeikakuJikosakuseiMeisai, yoboKeikakuJikoSakuseiMeisai);
    }

    /**
     * 居宅給付計画自己作成が保持する精神手帳任意項目情報に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id 精神手帳任意項目情報の識別子
     * @return 精神手帳任意項目情報
     * @throws IllegalStateException 指定の識別子に該当する精神手帳任意項目情報がない場合
     */
    public KyotakuKeikakuJikosakuseiMeisai getKyotakuKeikakuJikosakuseiMeisai(KyotakuKeikakuJikosakuseiMeisaiIdentifier id) {
        if (kyotakuKeikakuJikosakuseiMeisai.contains(id)) {
            return kyotakuKeikakuJikosakuseiMeisai.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 居宅給付計画自己作成が保持する精神手帳任意項目情報をリストで返します。
     *
     * @return 精神手帳任意項目情報リスト
     */
    public List<KyotakuKeikakuJikosakuseiMeisai> getKyotakuKeikakuJikosakuseiMeisaiList() {
        return new ArrayList<>(kyotakuKeikakuJikosakuseiMeisai.values());

    }

    /**
     * 居宅給付計画自己作成が保持する届出者情報に対して、指定の識別子に該当する届出者情報を返します。
     *
     * @param id 届出者情報の識別子
     * @return 届出者情報
     * @throws IllegalStateException 指定の識別子に該当する届出者情報がない場合
     */
    public YoboKeikakuJikoSakuseiMeisai getYoboKeikakuJikoSakuseiMeisai(YoboKeikakuJikoSakuseiMeisaiIdentifier id) {
        if (yoboKeikakuJikoSakuseiMeisai.contains(id)) {
            return yoboKeikakuJikoSakuseiMeisai.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 居宅給付計画自己作成が保持する届出者情報をリストで返します。
     *
     * @return 届出者情報リスト
     */
    public List<YoboKeikakuJikoSakuseiMeisai> getYoboKeikakuJikoSakuseiMeisaiList() {
        return new ArrayList<>(yoboKeikakuJikoSakuseiMeisai.values());
    }

    /**
     * {@link KyotakuKeikakuJikoSakusei}のシリアライズ形式を提供します。
     *
     * @return {@link KyotakuKeikakuJikoSakusei}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, kyotakuKeikakuJikosakuseiMeisai, yoboKeikakuJikoSakuseiMeisai);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT3007KyotakuKeikakuJikoSakuseiEntity entity;
        private final KyotakuKeikakuJikoSakuseiIdentifier id;
        private final Models<KyotakuKeikakuJikosakuseiMeisaiIdentifier, KyotakuKeikakuJikosakuseiMeisai> kyotakuKeikakuJikosakuseiMeisai;
        private final Models<YoboKeikakuJikoSakuseiMeisaiIdentifier, YoboKeikakuJikoSakuseiMeisai> yoboKeikakuJikoSakuseiMeisai;

        private _SerializationProxy(
                DbT3007KyotakuKeikakuJikoSakuseiEntity entity,
                KyotakuKeikakuJikoSakuseiIdentifier id,
                Models<KyotakuKeikakuJikosakuseiMeisaiIdentifier, KyotakuKeikakuJikosakuseiMeisai> kyotakuKeikakuJikosakuseiMeisai,
                Models<YoboKeikakuJikoSakuseiMeisaiIdentifier, YoboKeikakuJikoSakuseiMeisai> yoboKeikakuJikoSakuseiMeisai
        ) {
            this.entity = entity;
            this.id = id;
            this.kyotakuKeikakuJikosakuseiMeisai = kyotakuKeikakuJikosakuseiMeisai;
            this.yoboKeikakuJikoSakuseiMeisai = yoboKeikakuJikoSakuseiMeisai;
        }

        private Object readResolve() {
            return new KyotakuKeikakuJikoSakusei(this.entity, this.id, this.kyotakuKeikakuJikosakuseiMeisai, this.yoboKeikakuJikoSakuseiMeisai);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link KyotakuKeikakuJikoSakuseiBuilder#build()}を使用してください。
     *
     * @return {@link KyotakuKeikakuJikoSakuseiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiBuilder createBuilderForEdit() {
        return new KyotakuKeikakuJikoSakuseiBuilder(entity, id, kyotakuKeikakuJikosakuseiMeisai, yoboKeikakuJikoSakuseiMeisai);
    }
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KyotakuKeikakuJikoSakusei other = (KyotakuKeikakuJikoSakusei) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

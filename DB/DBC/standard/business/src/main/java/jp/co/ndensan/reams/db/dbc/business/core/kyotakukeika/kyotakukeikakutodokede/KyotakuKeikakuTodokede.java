/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakutodokede;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujigyoshasakusei.KyotakuKeikakuJigyoshaSakusei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujigyoshasakusei.KyotakuKeikakuJigyoshaSakuseiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakuseiIdentifier;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画届出を管理するクラスです。
 */
public class KyotakuKeikakuTodokede extends ParentModelBase<KyotakuKeikakuTodokedeIdentifier, DbT3005KyotakuKeikakuTodokedeEntity, KyotakuKeikakuTodokede> implements Serializable {

    private final DbT3005KyotakuKeikakuTodokedeEntity entity;
    private final KyotakuKeikakuTodokedeIdentifier id;
    private final Models<KyotakuKeikakuJikoSakuseiIdentifier, KyotakuKeikakuJikoSakusei> kyotakuKeikakuJikoSakusei;
    private final Models<KyotakuKeikakuJigyoshaSakuseiIdentifier, KyotakuKeikakuJigyoshaSakusei> kyotakuKeikakuJigyoshaSakusei;

    /**
     * コンストラクタです。<br/>
     * 居宅給付計画届出の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     */
    public KyotakuKeikakuTodokede(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3005KyotakuKeikakuTodokedeEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoYM(対象年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyotakuKeikakuTodokedeIdentifier(
                被保険者番号,
                対象年月,
                履歴番号
        );
        this.kyotakuKeikakuJikoSakusei = Models.create(new ArrayList<KyotakuKeikakuJikoSakusei>());
        this.kyotakuKeikakuJigyoshaSakusei = Models.create(new ArrayList<KyotakuKeikakuJigyoshaSakusei>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3005KyotakuKeikakuTodokedeEntity}より{@link KyotakuKeikakuTodokede}を生成します。
     *
     * @param entity DBより取得した{@link DbT3005KyotakuKeikakuTodokedeEntity}
     */
    public KyotakuKeikakuTodokede(KyotakuKeikakuTodokedeEntity entity) {
        this.entity = requireNonNull(entity.get居宅給付計画届出Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画届出"));
        this.id = new KyotakuKeikakuTodokedeIdentifier(
                entity.get居宅給付計画届出Entity().getHihokenshaNo(),
                entity.get居宅給付計画届出Entity().getTaishoYM(),
                entity.get居宅給付計画届出Entity().getRirekiNo());
        List<KyotakuKeikakuJikoSakusei> kyotakuKeikakuJikoSakuseiList = new ArrayList<>();
        for (KyotakuKeikakuJikoSakuseiEntity niniEntity : entity.get居宅給付計画自己作成Entity()) {
            kyotakuKeikakuJikoSakuseiList.add(new KyotakuKeikakuJikoSakusei(niniEntity));
        }
        this.kyotakuKeikakuJikoSakusei = Models.create(kyotakuKeikakuJikoSakuseiList);

        List<KyotakuKeikakuJigyoshaSakusei> kyotakuKeikakuJigyoshaSakuseiList = new ArrayList<>();
        for (DbT3006KyotakuKeikakuJigyoshaSakuseiEntity kyotakuKeikakuJigyoshaSakuseiEntity : entity.get居宅給付計画事業者作成Entity()) {
            kyotakuKeikakuJigyoshaSakuseiList.add(new KyotakuKeikakuJigyoshaSakusei(kyotakuKeikakuJigyoshaSakuseiEntity));
        }
        this.kyotakuKeikakuJigyoshaSakusei = Models.create(kyotakuKeikakuJigyoshaSakuseiList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3005KyotakuKeikakuTodokedeEntity}
     * @param id {@link KyotakuKeikakuTodokedeIdentifier}
     */
    KyotakuKeikakuTodokede(
            DbT3005KyotakuKeikakuTodokedeEntity entity,
            KyotakuKeikakuTodokedeIdentifier id, Models<KyotakuKeikakuJikoSakuseiIdentifier, KyotakuKeikakuJikoSakusei> kyotakuKeikakuJikoSakusei,
            Models<KyotakuKeikakuJigyoshaSakuseiIdentifier, KyotakuKeikakuJigyoshaSakusei> kyotakuKeikakuJigyoshaSakusei
    ) {
        this.entity = entity;
        this.id = id;
        this.kyotakuKeikakuJikoSakusei = kyotakuKeikakuJikoSakusei;
        this.kyotakuKeikakuJigyoshaSakusei = kyotakuKeikakuJigyoshaSakusei;
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
     * 届出区分を返します。
     *
     * @return 届出区分
     */
    public RString get届出区分() {
        return entity.getTodokedeKubun();
    }

    /**
     * 届出年月日を返します。
     *
     * @return 届出年月日
     */
    public FlexibleDate get届出年月日() {
        return entity.getTodokedeYMD();
    }

    /**
     * 届出者氏名を返します。
     *
     * @return 届出者氏名
     */
    public AtenaMeisho get届出者氏名() {
        return entity.getTodokedeshaShimei();
    }

    /**
     * 届出者氏名カナを返します。
     *
     * @return 届出者氏名カナ
     */
    public AtenaKanaMeisho get届出者氏名カナ() {
        return entity.getTodokedeshaShimeiKana();
    }

    /**
     * 届出者郵便番号を返します。
     *
     * @return 届出者郵便番号
     */
    public YubinNo get届出者郵便番号() {
        return entity.getTodokedeshaYubinNo();
    }

    /**
     * 届出者住所を返します。
     *
     * @return 届出者住所
     */
    public RString get届出者住所() {
        return entity.getTodokedeshaJusho();
    }

    /**
     * 届出者電話番号を返します。
     *
     * @return 届出者電話番号
     */
    public TelNo get届出者電話番号() {
        return entity.getTodokedeshaTelNo();
    }

    /**
     * 届出者関係区分を返します。
     *
     * @return 届出者関係区分
     */
    public RString get届出者関係区分() {
        return entity.getTodokedeshaKankeiKubun();
    }

    /**
     * 暫定区分を返します。
     *
     * @return 暫定区分
     */
    public RString get暫定区分() {
        return entity.getZanteiKubun();
    }

    /**
     * {@link DbT3005KyotakuKeikakuTodokedeEntity}のクローンを返します。
     *
     * @return {@link DbT3005KyotakuKeikakuTodokedeEntity}のクローン
     */
    @Override
    public DbT3005KyotakuKeikakuTodokedeEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 居宅給付計画届出の識別子{@link KyotakuKeikakuTodokedeIdentifier}を返します。
     *
     * @return 居宅給付計画届出の識別子{@link KyotakuKeikakuTodokedeIdentifier}
     */
    @Override
    public KyotakuKeikakuTodokedeIdentifier identifier() {
        return this.id;
    }

    /**
     * 居宅給付計画届出配下の要素を削除対象とします。<br/>
     * {@link DbT3005KyotakuKeikakuTodokedeEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 居宅給付計画届出配下の要素である居宅給付計画自己作成の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link KyotakuKeikakuTodokede}を返します。
     *
     * @return 削除対象処理実施後の{@link KyotakuKeikakuTodokede}
     * @throws IllegalStateException DbT3005KyotakuKeikakuTodokedeEntityのデータ状態が変更の場合
     */
    @Override
    public KyotakuKeikakuTodokede deleted() {
        DbT3005KyotakuKeikakuTodokedeEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyotakuKeikakuTodokede(
                deletedEntity, id, kyotakuKeikakuJikoSakusei.deleted(), kyotakuKeikakuJigyoshaSakusei.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || kyotakuKeikakuJikoSakusei.hasAnyChanged() || kyotakuKeikakuJigyoshaSakusei.hasAnyChanged();
    }

    /**
     * 居宅給付計画届出のみを変更対象とします。<br/>
     * {@link DbT3005KyotakuKeikakuTodokedeEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyotakuKeikakuTodokede}
     */
    @Override
    public KyotakuKeikakuTodokede modifiedModel() {
        DbT3005KyotakuKeikakuTodokedeEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyotakuKeikakuTodokede(
                modifiedEntity, id, kyotakuKeikakuJikoSakusei, kyotakuKeikakuJigyoshaSakusei);
    }

    /**
     * 居宅給付計画届出が保持する居宅給付計画自己作成に対して、指定の識別子に該当する居宅給付計画自己作成を返します。
     *
     * @param id 居宅給付計画自己作成の識別子
     * @return 居宅給付計画自己作成
     * @throws IllegalStateException 指定の識別子に該当する居宅給付計画自己作成がない場合
     */
    public KyotakuKeikakuJikoSakusei getKyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiIdentifier id) {
        if (kyotakuKeikakuJikoSakusei.contains(id)) {
            return kyotakuKeikakuJikoSakusei.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 居宅給付計画届出が保持する居宅給付計画自己作成をリストで返します。
     *
     * @return 居宅給付計画自己作成情報リスト
     */
    public List<KyotakuKeikakuJikoSakusei> getKyotakuKeikakuJikoSakuseiList() {
        return new ArrayList<>(kyotakuKeikakuJikoSakusei.values());

    }

    /**
     * 居宅給付計画届出が保持する居宅給付計画事業者作成に対して、指定の識別子に該当する居宅給付計画事業者作成を返します。
     *
     * @param id 居宅給付計画事業者作成の識別子
     * @return 居宅給付計画事業者作成
     * @throws IllegalStateException 指定の識別子に該当する居宅給付計画事業者作成がない場合
     */
    public KyotakuKeikakuJigyoshaSakusei getKyotakuKeikakuJigyoshaSakusei(KyotakuKeikakuJigyoshaSakuseiIdentifier id) {
        if (kyotakuKeikakuJigyoshaSakusei.contains(id)) {
            return kyotakuKeikakuJigyoshaSakusei.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 居宅給付計画届出が保持する居宅給付計画事業者作成をリストで返します。
     *
     * @return 居宅給付計画事業者作成情報リスト
     */
    public List<KyotakuKeikakuJigyoshaSakusei> getKyotakuKeikakuJigyoshaSakuseiList() {
        return new ArrayList<>(kyotakuKeikakuJigyoshaSakusei.values());
    }

    /**
     * {@link KyotakuKeikakuTodokede}のシリアライズ形式を提供します。
     *
     * @return {@link KyotakuKeikakuTodokede}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, kyotakuKeikakuJikoSakusei, kyotakuKeikakuJigyoshaSakusei);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT3005KyotakuKeikakuTodokedeEntity entity;
        private final KyotakuKeikakuTodokedeIdentifier id;
        private final Models<KyotakuKeikakuJikoSakuseiIdentifier, KyotakuKeikakuJikoSakusei> kyotakuKeikakuJikoSakusei;
        private final Models<KyotakuKeikakuJigyoshaSakuseiIdentifier, KyotakuKeikakuJigyoshaSakusei> kyotakuKeikakuJigyoshaSakusei;

        private _SerializationProxy(
                DbT3005KyotakuKeikakuTodokedeEntity entity,
                KyotakuKeikakuTodokedeIdentifier id,
                Models<KyotakuKeikakuJikoSakuseiIdentifier, KyotakuKeikakuJikoSakusei> kyotakuKeikakuJikoSakusei,
                Models<KyotakuKeikakuJigyoshaSakuseiIdentifier, KyotakuKeikakuJigyoshaSakusei> kyotakuKeikakuJigyoshaSakusei
        ) {
            this.entity = entity;
            this.id = id;
            this.kyotakuKeikakuJikoSakusei = kyotakuKeikakuJikoSakusei;
            this.kyotakuKeikakuJigyoshaSakusei = kyotakuKeikakuJigyoshaSakusei;
        }

        private Object readResolve() {
            return new KyotakuKeikakuTodokede(this.entity, this.id, this.kyotakuKeikakuJikoSakusei, this.kyotakuKeikakuJigyoshaSakusei);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link KyotakuKeikakuTodokedeBuilder#build()}を使用してください。
     *
     * @return {@link KyotakuKeikakuTodokedeBuilder}
     */
    public KyotakuKeikakuTodokedeBuilder createBuilderForEdit() {
        return new KyotakuKeikakuTodokedeBuilder(entity, id, kyotakuKeikakuJikoSakusei, kyotakuKeikakuJigyoshaSakusei);
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
        final KyotakuKeikakuTodokede other = (KyotakuKeikakuTodokede) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

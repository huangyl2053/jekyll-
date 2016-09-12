/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5034ShinsakaiIinBetsuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会委員別単価を管理するクラスです。
 *
 * @reamsid_L DBE-9999-021 dingyi
 */
public class ShinsakaiIinBetsuTanka extends ModelBase<ShinsakaiIinBetsuTankaIdentifier, DbT5034ShinsakaiIinBetsuTankaEntity, ShinsakaiIinBetsuTanka>
        implements Serializable {

    private static final long serialVersionUID = -8277962158005872532L;
    private final DbT5034ShinsakaiIinBetsuTankaEntity entity;
    private final ShinsakaiIinBetsuTankaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会委員別単価の新規作成時に使用します。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     */
    public ShinsakaiIinBetsuTanka(RString 介護認定審査会委員コード,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月) {
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));
        this.entity = new DbT5034ShinsakaiIinBetsuTankaEntity();
        this.entity.setShinsakaiIinCode(介護認定審査会委員コード);
        this.entity.setKaishiYM(開始年月);
        this.entity.setShuryoYM(終了年月);
        this.id = new ShinsakaiIinBetsuTankaIdentifier(
                介護認定審査会委員コード,
                開始年月,
                終了年月
        );
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5034ShinsakaiIinBetsuTankaEntity}
     */
    public ShinsakaiIinBetsuTanka(DbT5034ShinsakaiIinBetsuTankaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員別単価"));
        this.id = new ShinsakaiIinBetsuTankaIdentifier(
                entity.getShinsakaiIinCode(),
                entity.getKaishiYM(),
                entity.getShuryoYM());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5034ShinsakaiIinBetsuTankaEntity}
     * @param id {@link ShinsakaiIinBetsuTankaIdentifier}
     */
    ShinsakaiIinBetsuTanka(
            DbT5034ShinsakaiIinBetsuTankaEntity entity,
            ShinsakaiIinBetsuTankaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 介護認定審査会委員コードを返します。
     *
     * @return 介護認定審査会委員コード
     */
    public RString get介護認定審査会委員コード() {
        return entity.getShinsakaiIinCode();
    }

    /**
     * 開始年月を返します。
     *
     * @return 開始年月
     */
    public FlexibleYearMonth get開始年月() {
        return entity.getKaishiYM();
    }

    /**
     * 終了年月を返します。
     *
     * @return 終了年月
     */
    public FlexibleYearMonth get終了年月() {
        return entity.getShuryoYM();
    }

    /**
     * 単価を返します。
     *
     * @return 単価
     */
    public Decimal get単価() {
        return entity.getTanka();
    }

    /**
     * その他単価を返します。
     *
     * @return その他単価
     */
    public Decimal getその他単価() {
        return entity.getSonotatanka();
    }

    /**
     * {@link DbT5034ShinsakaiIinBetsuTankaEntity}のクローンを返します。
     *
     * @return {@link DbT5034ShinsakaiIinBetsuTankaEntity}のクローン
     */
    @Override
    public DbT5034ShinsakaiIinBetsuTankaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護認定審査会委員別単価の識別子{@link ShinsakaiIinBetsuTankaIdentifier}を返します。
     *
     * @return 介護認定審査会委員別単価の識別子{@link ShinsakaiIinBetsuTankaIdentifier}
     */
    @Override
    public ShinsakaiIinBetsuTankaIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査会委員別単価配下の要素を削除対象とします。<br/>
     * {@link DbT5034ShinsakaiIinBetsuTankaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiIinBetsuTanka}
     */
    @Override
    public ShinsakaiIinBetsuTanka deleted() {
        DbT5034ShinsakaiIinBetsuTankaEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiIinBetsuTanka(
                deletedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 介護認定審査会委員別単価のみを変更対象とします。<br/>
     * {@link DbT5034ShinsakaiIinBetsuTankaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiIinBetsuTanka}
     */
    public ShinsakaiIinBetsuTanka modifiedModel() {
        DbT5034ShinsakaiIinBetsuTankaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiIinBetsuTanka(
                modifiedEntity, id);
    }

    /**
     * {@link ShinsakaiIinBetsuTanka}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiIinBetsuTanka}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -5699627682795659469L;
        private final DbT5034ShinsakaiIinBetsuTankaEntity entity;
        private final ShinsakaiIinBetsuTankaIdentifier id;

        private _SerializationProxy(DbT5034ShinsakaiIinBetsuTankaEntity entity, ShinsakaiIinBetsuTankaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiIinBetsuTanka(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiIinBetsuTankaBuilder createBuilderForEdit() {
        return new ShinsakaiIinBetsuTankaBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.entity);
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final ShinsakaiIinBetsuTanka other = (ShinsakaiIinBetsuTanka) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

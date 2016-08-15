/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5033ShinsakaiIinHoshuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査委員報酬単価を管理するクラスです。
 *
 * @reamsid_L DBE-9999-021 dingyi
 */
public class ShinsakaiIinHoshuTanka extends ModelBase<ShinsakaiIinHoshuTankaIdentifier, DbT5033ShinsakaiIinHoshuTankaEntity, ShinsakaiIinHoshuTanka>
        implements Serializable {

    private static final long serialVersionUID = -4967239637100679538L;
    private final DbT5033ShinsakaiIinHoshuTankaEntity entity;
    private final ShinsakaiIinHoshuTankaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査委員報酬単価の新規作成時に使用します。
     *
     * @param 介護認定審査委員種別 介護認定審査委員種別
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     * @param 単価 単価
     */
    public ShinsakaiIinHoshuTanka(CodeShubetsu 介護認定審査委員種別,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月,
            Decimal 単価) {
        requireNonNull(介護認定審査委員種別, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査委員種別"));
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));
        this.entity = new DbT5033ShinsakaiIinHoshuTankaEntity();
        this.entity.setKaigoNinteiShinsaIinShubetsu(介護認定審査委員種別);
        this.entity.setKaishiYM(開始年月);
        this.entity.setShuryoYM(終了年月);
        this.entity.setTanka(単価);
        this.id = new ShinsakaiIinHoshuTankaIdentifier(
                介護認定審査委員種別,
                開始年月,
                終了年月
        );
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5033ShinsakaiIinHoshuTankaEntity}
     */
    public ShinsakaiIinHoshuTanka(DbT5033ShinsakaiIinHoshuTankaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査委員報酬単価"));
        this.id = new ShinsakaiIinHoshuTankaIdentifier(
                entity.getKaigoNinteiShinsaIinShubetsu(),
                entity.getKaishiYM(),
                entity.getShuryoYM());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5033ShinsakaiIinHoshuTankaEntity}
     * @param id {@link ShinsakaiIinHoshuTankaIdentifier}
     */
    ShinsakaiIinHoshuTanka(
            DbT5033ShinsakaiIinHoshuTankaEntity entity,
            ShinsakaiIinHoshuTankaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 介護認定審査委員種別を返します。
     *
     * @return 介護認定審査委員種別
     */
    public CodeShubetsu get介護認定審査委員種別() {
        return entity.getKaigoNinteiShinsaIinShubetsu();
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
     * {@link DbT5033ShinsakaiIinHoshuTankaEntity}のクローンを返します。
     *
     * @return {@link DbT5033ShinsakaiIinHoshuTankaEntity}のクローン
     */
    @Override
    public DbT5033ShinsakaiIinHoshuTankaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護認定審査委員報酬単価の識別子{@link ShinsakaiIinHoshuTankaIdentifier}を返します。
     *
     * @return 介護認定審査委員報酬単価の識別子{@link ShinsakaiIinHoshuTankaIdentifier}
     */
    @Override
    public ShinsakaiIinHoshuTankaIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査委員報酬単価配下の要素を削除対象とします。<br/>
     * {@link DbT5033ShinsakaiIinHoshuTankaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiIinHoshuTanka}
     */
    @Override
    public ShinsakaiIinHoshuTanka deleted() {
        DbT5033ShinsakaiIinHoshuTankaEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiIinHoshuTanka(
                deletedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 介護認定審査委員報酬単価のみを変更対象とします。<br/>
     * {@link DbT5033ShinsakaiIinHoshuTankaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiIinHoshuTanka}
     */
    public ShinsakaiIinHoshuTanka modifiedModel() {
        DbT5033ShinsakaiIinHoshuTankaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiIinHoshuTanka(
                modifiedEntity, id);
    }

    /**
     * {@link ShinsakaiIinHoshuTanka}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiIinHoshuTanka}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 6424064845818939898L;
        private final DbT5033ShinsakaiIinHoshuTankaEntity entity;
        private final ShinsakaiIinHoshuTankaIdentifier id;

        private _SerializationProxy(DbT5033ShinsakaiIinHoshuTankaEntity entity, ShinsakaiIinHoshuTankaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiIinHoshuTanka(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiIinHoshuTankaBuilder createBuilderForEdit() {
        return new ShinsakaiIinHoshuTankaBuilder(entity, id);
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
        final ShinsakaiIinHoshuTanka other = (ShinsakaiIinHoshuTanka) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

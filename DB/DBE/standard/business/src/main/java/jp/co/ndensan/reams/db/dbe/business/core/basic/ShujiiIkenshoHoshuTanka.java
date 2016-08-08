/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 意見書作成報酬単価を管理するクラスです。
 *
 * @reamsid_L DBE-9999-021 dingyi
 */
public class ShujiiIkenshoHoshuTanka
        extends ModelBase<ShujiiIkenshoHoshuTankaIdentifier, DbT5032ShujiiIkenshoHoshuTankaEntity, ShujiiIkenshoHoshuTanka>
        implements Serializable {

    private static final long serialVersionUID = -5059272010711467817L;
    private final DbT5032ShujiiIkenshoHoshuTankaEntity entity;
    private final ShujiiIkenshoHoshuTankaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 意見書作成報酬単価の新規作成時に使用します。
     *
     * @param 在宅施設区分 在宅施設区分
     * @param 意見書作成回数区分 意見書作成回数区分
     * @param 開始年月 開始年月
     */
    public ShujiiIkenshoHoshuTanka(Code 在宅施設区分,
            Code 意見書作成回数区分,
            FlexibleYearMonth 開始年月) {
        requireNonNull(在宅施設区分, UrSystemErrorMessages.値がnull.getReplacedMessage("在宅施設区分"));
        requireNonNull(意見書作成回数区分, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成回数区分"));
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        this.entity = new DbT5032ShujiiIkenshoHoshuTankaEntity();
        this.entity.setZaitakuShisetsuKubun(在宅施設区分);
        this.entity.setIkenshoSakuseiKaisuKubun(意見書作成回数区分);
        this.entity.setKaishiYM(開始年月);
        this.id = new ShujiiIkenshoHoshuTankaIdentifier(
                在宅施設区分,
                意見書作成回数区分,
                開始年月
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5032ShujiiIkenshoHoshuTankaEntity}より{@link ShujiiIkenshoHoshuTanka}を生成します。
     *
     * @param entity DBより取得した{@link DbT5032ShujiiIkenshoHoshuTankaEntity}
     */
    public ShujiiIkenshoHoshuTanka(DbT5032ShujiiIkenshoHoshuTankaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成報酬単価"));
        this.id = new ShujiiIkenshoHoshuTankaIdentifier(
                entity.getZaitakuShisetsuKubun(),
                entity.getIkenshoSakuseiKaisuKubun(),
                entity.getKaishiYM());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5032ShujiiIkenshoHoshuTankaEntity}
     * @param id {@link ShujiiIkenshoHoshuTankaIdentifier}
     */
    ShujiiIkenshoHoshuTanka(
            DbT5032ShujiiIkenshoHoshuTankaEntity entity,
            ShujiiIkenshoHoshuTankaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 在宅施設区分を返します。
     *
     * @return 在宅施設区分
     */
    public Code get在宅施設区分() {
        return entity.getZaitakuShisetsuKubun();
    }

    /**
     * 意見書作成回数区分を返します。
     *
     * @return 意見書作成回数区分
     */
    public Code get意見書作成回数区分() {
        return entity.getIkenshoSakuseiKaisuKubun();
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
     * {@link DbT5032ShujiiIkenshoHoshuTankaEntity}のクローンを返します。
     *
     * @return {@link DbT5032ShujiiIkenshoHoshuTankaEntity}のクローン
     */
    @Override
    public DbT5032ShujiiIkenshoHoshuTankaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 意見書作成報酬単価の識別子{@link ShujiiIkenshoHoshuTankaIdentifier}を返します。
     *
     * @return 意見書作成報酬単価の識別子{@link ShujiiIkenshoHoshuTankaIdentifier}
     */
    @Override
    public ShujiiIkenshoHoshuTankaIdentifier identifier() {
        return this.id;
    }

    /**
     * 意見書作成報酬単価のみを変更対象とします。<br/>
     * {@link DbT5032ShujiiIkenshoHoshuTankaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShujiiIkenshoHoshuTanka}
     */
    public ShujiiIkenshoHoshuTanka modifiedModel() {
        DbT5032ShujiiIkenshoHoshuTankaEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShujiiIkenshoHoshuTanka(
                modifiedEntity, id);
    }

    /**
     * 保持する意見書作成報酬単価を削除対象とします。<br/>
     * {@link DbT5032ShujiiIkenshoHoshuTankaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShujiiIkenshoHoshuTanka}
     */
    @Override
    public ShujiiIkenshoHoshuTanka deleted() {
        DbT5032ShujiiIkenshoHoshuTankaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShujiiIkenshoHoshuTanka(deletedEntity, id);
    }

    /**
     * {@link ShujiiIkenshoHoshuTanka}のシリアライズ形式を提供します。
     *
     * @return {@link ShujiiIkenshoHoshuTanka}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L; // TODO serialVersionUIDを生成してください
        private final DbT5032ShujiiIkenshoHoshuTankaEntity entity;
        private final ShujiiIkenshoHoshuTankaIdentifier id;

        private _SerializationProxy(DbT5032ShujiiIkenshoHoshuTankaEntity entity, ShujiiIkenshoHoshuTankaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShujiiIkenshoHoshuTanka(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShujiiIkenshoHoshuTankaBuilder createBuilderForEdit() {
        return new ShujiiIkenshoHoshuTankaBuilder(entity, id);
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
        final ShujiiIkenshoHoshuTanka other = (ShujiiIkenshoHoshuTanka) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

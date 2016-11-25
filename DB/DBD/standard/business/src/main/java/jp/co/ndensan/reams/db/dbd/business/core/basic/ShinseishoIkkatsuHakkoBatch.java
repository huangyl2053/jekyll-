/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4032ShinseishoIkkatsuHakkoBatchEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 申請書一括発行を管理するクラスです。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
public class ShinseishoIkkatsuHakkoBatch extends
        ModelBase<
        ShinseishoIkkatsuHakkoBatchIdentifier, DbT4032ShinseishoIkkatsuHakkoBatchEntity, ShinseishoIkkatsuHakkoBatch>
        implements
        Serializable {

    private final DbT4032ShinseishoIkkatsuHakkoBatchEntity entity;
    private final ShinseishoIkkatsuHakkoBatchIdentifier id;

    /**
     * コンストラクタです。
     *
     * @param 発行処理ID UUID
     */
    public ShinseishoIkkatsuHakkoBatch(UUID 発行処理ID) {
        requireNonNull(発行処理ID, UrSystemErrorMessages.値がnull.getReplacedMessage("発行処理ID"));
        this.entity = new DbT4032ShinseishoIkkatsuHakkoBatchEntity();
        this.entity.setHakkoShoriID(発行処理ID);
        this.id = new ShinseishoIkkatsuHakkoBatchIdentifier(発行処理ID);
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT4032ShinseishoIkkatsuHakkoBatchEntity
     */
    public ShinseishoIkkatsuHakkoBatch(DbT4032ShinseishoIkkatsuHakkoBatchEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書一括発行"));
        this.id = new ShinseishoIkkatsuHakkoBatchIdentifier(entity.getHakkoShoriID());
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT4032ShinseishoIkkatsuHakkoBatchEntity
     * @param id ShinseishoIkkatsuHakkoBatchIdentifier
     */
    ShinseishoIkkatsuHakkoBatch(
            DbT4032ShinseishoIkkatsuHakkoBatchEntity entity,
            ShinseishoIkkatsuHakkoBatchIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * {@link DbT4032ShinseishoIkkatsuHakkoBatchEntity}のクローンを返します。
     *
     * @return {@link DbT4032ShinseishoIkkatsuHakkoBatchEntity}のクローン
     */
    @Override
    public DbT4032ShinseishoIkkatsuHakkoBatchEntity toEntity() {
        return this.entity.clone();
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 申請書一括発行の識別子{@link ShinseishoIkkatsuHakkoBatchIdentifier}を返します。
     *
     * @return 申請書一括発行の識別子{@link ShinseishoIkkatsuHakkoBatchIdentifier}
     */
    @Override
    public ShinseishoIkkatsuHakkoBatchIdentifier identifier() {
        return this.id;
    }

    /**
     * 申請書一括発行を削除対象とします。
     *
     * @return 削除対象処理実施後の{@link ShinseishoIkkatsuHakkoBatch}
     */
    @Override
    public ShinseishoIkkatsuHakkoBatch deleted() {
        DbT4032ShinseishoIkkatsuHakkoBatchEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinseishoIkkatsuHakkoBatch(deletedEntity, id);
    }

    /**
     * {@link ShinseishoIkkatsuHakkoBatch}のシリアライズ形式を提供します。
     *
     * @return {@link ShinseishoIkkatsuHakkoBatch}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new ShinseishoIkkatsuHakkoBatch._SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT4032ShinseishoIkkatsuHakkoBatchEntity entity;
        private final ShinseishoIkkatsuHakkoBatchIdentifier id;

        private _SerializationProxy(DbT4032ShinseishoIkkatsuHakkoBatchEntity entity, ShinseishoIkkatsuHakkoBatchIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinseishoIkkatsuHakkoBatch(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。
     *
     * @return ShinseishoIkkatsuHakkoBatchBuilder
     */
    public ShinseishoIkkatsuHakkoBatchBuilder createBuidler() {
        return new ShinseishoIkkatsuHakkoBatchBuilder(entity, id);
    }
}

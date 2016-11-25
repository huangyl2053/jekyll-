/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4033ShinseishoHakkoTaishoshasEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 申請書発行対象を管理するクラスです。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
public class ShinseishoHakkoTaishoshas extends
        ModelBase<ShinseishoHakkoTaishoshasIdentifier, DbT4033ShinseishoHakkoTaishoshasEntity, ShinseishoHakkoTaishoshas>
        implements
        Serializable {

    private final DbT4033ShinseishoHakkoTaishoshasEntity entity;
    private final ShinseishoHakkoTaishoshasIdentifier id;

    /**
     * コンストラクタです。
     *
     * @param 発行処理ID UUID
     * @param 被保険者番号 HihokenshaNo
     */
    public ShinseishoHakkoTaishoshas(UUID 発行処理ID, HihokenshaNo 被保険者番号) {
        requireNonNull(発行処理ID, UrSystemErrorMessages.値がnull.getReplacedMessage("発行処理ID"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        this.entity = new DbT4033ShinseishoHakkoTaishoshasEntity();
        this.entity.setHakkoShoriID(発行処理ID);
        this.entity.setHihokenshaNo(被保険者番号);
        this.id = new ShinseishoHakkoTaishoshasIdentifier(発行処理ID, 被保険者番号);
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT4033ShinseishoHakkoTaishoshasEntity
     */
    public ShinseishoHakkoTaishoshas(DbT4033ShinseishoHakkoTaishoshasEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書発行対象"));
        this.id = new ShinseishoHakkoTaishoshasIdentifier(entity.getHakkoShoriID(), entity.getHihokenshaNo());
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT4033ShinseishoHakkoTaishoshasEntity
     * @param id ShinseishoHakkoTaishoshasIdentifier
     */
    ShinseishoHakkoTaishoshas(DbT4033ShinseishoHakkoTaishoshasEntity entity, ShinseishoHakkoTaishoshasIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * {@link DbT4033ShinseishoHakkoTaishoshasEntity}のクローンを返します。
     *
     * @return {@link DbT4033ShinseishoHakkoTaishoshasEntity}のクローン
     */
    @Override
    public DbT4033ShinseishoHakkoTaishoshasEntity toEntity() {
        return this.entity.clone();
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 申請書発行対象の識別子{@link ShinseishoHakkoTaishoshasIdentifier}を返します。
     *
     * @return 申請書発行対象の識別子{@link ShinseishoHakkoTaishoshasIdentifier}
     */
    @Override
    public ShinseishoHakkoTaishoshasIdentifier identifier() {
        return this.id;
    }

    /**
     * 申請書発行対象を削除対象とします。
     *
     * @return 削除対象処理実施後の{@link ShinseishoHakkoTaishoshas}
     */
    @Override
    public ShinseishoHakkoTaishoshas deleted() {
        DbT4033ShinseishoHakkoTaishoshasEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinseishoHakkoTaishoshas(deletedEntity, id);
    }

    /**
     * {@link ShinseishoHakkoTaishoshas}のシリアライズ形式を提供します。
     *
     * @return {@link ShinseishoHakkoTaishoshas}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new ShinseishoHakkoTaishoshas._SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT4033ShinseishoHakkoTaishoshasEntity entity;
        private final ShinseishoHakkoTaishoshasIdentifier id;

        private _SerializationProxy(DbT4033ShinseishoHakkoTaishoshasEntity entity, ShinseishoHakkoTaishoshasIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinseishoHakkoTaishoshas(this.entity, this.id);
        }
    }
}

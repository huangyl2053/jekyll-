/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護導入形態を管理するクラスです。
 */
public class KaigoDonyuKeitai extends ModelBase<KaigoDonyuKeitaiIdentifier, DbT7908KaigoDonyuKeitaiEntity, KaigoDonyuKeitai> implements Serializable {

    private final DbT7908KaigoDonyuKeitaiEntity entity;
    private final KaigoDonyuKeitaiIdentifier id;

    /**
     * {@link DbT7908KaigoDonyuKeitaiEntity}より{@link KaigoDonyuKeitai}を生成します。
     *
     * @param entity {@link DbT7908KaigoDonyuKeitaiEntity}
     */
    public KaigoDonyuKeitai(DbT7908KaigoDonyuKeitaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護導入形態"));
        this.id = new KaigoDonyuKeitaiIdentifier(
                entity.getGyomuBunrui(),
                entity.getDonyuKeitaiCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7908KaigoDonyuKeitaiEntity}
     * @param id {@link KaigoDonyuKeitaiIdentifier}
     */
    KaigoDonyuKeitai(
            DbT7908KaigoDonyuKeitaiEntity entity,
            KaigoDonyuKeitaiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 業務分類を返します。
     *
     * @return 業務分類
     */
    public GyomuBunrui get業務分類() {
        return GyomuBunrui.toValue(entity.getGyomuBunrui());
    }

    /**
     * 導入形態コードを返します。
     *
     * @return 導入形態コード
     */
    public DonyuKeitaiCode get導入形態コード() {
        return DonyuKeitaiCode.toValue(entity.getDonyuKeitaiCode().value());
    }

    /**
     * 支所管理有無を返します。
     *
     * @return 支所管理有無
     */
    public boolean exists支所管理() {
        return entity.getShishoKanriUmuFlag();
    }

    /**
     * {@link DbT7908KaigoDonyuKeitaiEntity}のクローンを返します。
     *
     * @return {@link DbT7908KaigoDonyuKeitaiEntity}のクローン
     */
    @Override
    public DbT7908KaigoDonyuKeitaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護導入形態の識別子{@link KaigoDonyuKeitaiIdentifier}を返します。
     *
     * @return 介護導入形態の識別子{@link KaigoDonyuKeitaiIdentifier}
     */
    @Override
    public KaigoDonyuKeitaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護導入形態を削除対象とします。<br/>
     * {@link DbT7908KaigoDonyuKeitaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoDonyuKeitai}
     */
    @Override
    public KaigoDonyuKeitai deleted() {
        DbT7908KaigoDonyuKeitaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoDonyuKeitai(deletedEntity, id);
    }

    /**
     * {@link KaigoDonyuKeitai}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoDonyuKeitai}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return this.entity.getState() != EntityDataState.Modified;
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT7908KaigoDonyuKeitaiEntity entity;
        private final KaigoDonyuKeitaiIdentifier id;

        private _SerializationProxy(DbT7908KaigoDonyuKeitaiEntity entity, KaigoDonyuKeitaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoDonyuKeitai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoDonyuKeitaiBuilder createBuilderForEdit() {
        return new KaigoDonyuKeitaiBuilder(entity, id);
    }
    private static final long serialVersionUID = 6866826642745028740L;
}

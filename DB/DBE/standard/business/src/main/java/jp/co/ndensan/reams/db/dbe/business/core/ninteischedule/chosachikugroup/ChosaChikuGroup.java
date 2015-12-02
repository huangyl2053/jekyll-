/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chosachikugroup;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 調査地区グループマスタを管理するクラスです。
 */
public class ChosaChikuGroup extends ModelBase<ChosaChikuGroupIdentifier, DbT5225ChosaChikuGroupEntity, ChosaChikuGroup> implements Serializable {
    private static final long serialVersionUID = -8442376890865711774L;

    private final DbT5225ChosaChikuGroupEntity entity;
    private final ChosaChikuGroupIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 調査地区グループマスタの新規作成時に使用します。
     *
     * @param 調査地区グループコード 調査地区グループコード
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     */
    public ChosaChikuGroup(Code 調査地区グループコード,
            Code 調査地区コード,
            LasdecCode 市町村コード) {
        requireNonNull(調査地区グループコード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区グループコード"));
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        this.entity = new DbT5225ChosaChikuGroupEntity();
        this.entity.setChosaChikuGroupCode(調査地区グループコード);
        this.entity.setChosachikucode(調査地区コード);
        this.entity.setShichosonCode(市町村コード);
        this.id = new ChosaChikuGroupIdentifier(
                調査地区グループコード,
                調査地区コード,
                市町村コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5225ChosaChikuGroupEntity}より{@link ChosaChikuGroup}を生成します。
     *
     * @param entity DBより取得した{@link DbT5225ChosaChikuGroupEntity}
     */
    public ChosaChikuGroup(DbT5225ChosaChikuGroupEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区グループマスタ"));
        this.id = new ChosaChikuGroupIdentifier(
                entity.getChosaChikuGroupCode(),
                entity.getChosachikucode(),
                entity.getShichosonCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5225ChosaChikuGroupEntity}
     * @param id {@link ChosaChikuGroupIdentifier}
     */
    ChosaChikuGroup(
            DbT5225ChosaChikuGroupEntity entity,
            ChosaChikuGroupIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 調査地区グループコードを返します。
     *
     * @return 調査地区グループコード
     */
    public Code get調査地区グループコード() {
        return entity.getChosaChikuGroupCode();
    }

    /**
     * 調査地区コードを返します。
     *
     * @return 調査地区コード
     */
    public Code get調査地区コード() {
        return entity.getChosachikucode();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 調査地区グループ名称を返します。
     *
     * @return 調査地区グループ名称
     */
    public RString get調査地区グループ名称() {
        return entity.getChosachikugroupname();
    }

    /**
     * 優先番号を返します。
     *
     * @return 優先番号
     */
    public int get優先番号() {
        return entity.getYusenNo();
    }

    /**
     * {@link DbT5225ChosaChikuGroupEntity}のクローンを返します。
     *
     * @return {@link DbT5225ChosaChikuGroupEntity}のクローン
     */
    @Override
    public DbT5225ChosaChikuGroupEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 調査地区グループマスタの識別子{@link ChosaChikuGroupIdentifier}を返します。
     *
     * @return 調査地区グループマスタの識別子{@link ChosaChikuGroupIdentifier}
     */
    @Override
    public ChosaChikuGroupIdentifier identifier() {
        return this.id;
    }

    /**
     * 調査地区グループマスタのみを変更対象とします。<br/>
     * {@link DbT5225ChosaChikuGroupEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ChosaChikuGroup}
     */
    public ChosaChikuGroup modifiedModel() {
        DbT5225ChosaChikuGroupEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ChosaChikuGroup(modifiedEntity, id);
    }

    /**
     * 保持する調査地区グループマスタを削除対象とします。<br/>
     * {@link DbT5225ChosaChikuGroupEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChosaChikuGroup}
     */
    @Override
    public ChosaChikuGroup deleted() {
        DbT5225ChosaChikuGroupEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChosaChikuGroup(deletedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * {@link ChosaChikuGroup}のシリアライズ形式を提供します。
     *
     * @return {@link ChosaChikuGroup}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {
        private static final long serialVersionUID = -2108246538332524703L;

        private final DbT5225ChosaChikuGroupEntity entity;
        private final ChosaChikuGroupIdentifier id;

        private _SerializationProxy(DbT5225ChosaChikuGroupEntity entity, ChosaChikuGroupIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ChosaChikuGroup(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ChosaChikuGroupBuilder createBuilderForEdit() {
        return new ChosaChikuGroupBuilder(entity, id);
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
        final ChosaChikuGroup other = (ChosaChikuGroup) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

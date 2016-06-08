/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryorank;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 保険料ランクを管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class HokenryoRank extends ModelBase<HokenryoRankIdentifier, DbT2012HokenryoRankEntity, HokenryoRank> implements Serializable {

    private final DbT2012HokenryoRankEntity entity;
    private final HokenryoRankIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 保険料ランクの新規作成時に使用します。
     *
     * @param 賦課年度 賦課年度
     * @param 市町村コード 市町村コード
     */
    public HokenryoRank(FlexibleYear 賦課年度,
            LasdecCode 市町村コード) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        this.entity = new DbT2012HokenryoRankEntity();
        this.entity.setFukaNendo(賦課年度);
        this.entity.setShichosonCode(市町村コード);
        this.id = new HokenryoRankIdentifier(
                賦課年度,
                市町村コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2012HokenryoRankEntity}より{@link HokenryoRank}を生成します。
     *
     * @param entity DBより取得した{@link DbT2012HokenryoRankEntity}
     */
    public HokenryoRank(DbT2012HokenryoRankEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料ランク"));
        this.id = new HokenryoRankIdentifier(
                entity.getFukaNendo(),
                entity.getShichosonCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2012HokenryoRankEntity}
     * @param id {@link HokenryoRankIdentifier}
     */
    HokenryoRank(
            DbT2012HokenryoRankEntity entity,
            HokenryoRankIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
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
     * ランク区分を返します。
     *
     * @return ランク区分
     */
    public RString getランク区分() {
        return entity.getRankKubun();
    }

    /**
     * 遡及年度を返します。
     *
     * @return 遡及年度
     */
    public FlexibleYear get遡及年度() {
        return entity.getSokyuNendo();
    }

    /**
     * {@link DbT2012HokenryoRankEntity}のクローンを返します。
     *
     * @return {@link DbT2012HokenryoRankEntity}のクローン
     */
    @Override
    public DbT2012HokenryoRankEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 保険料ランクの識別子{@link HokenryoRankIdentifier}を返します。
     *
     * @return 保険料ランクの識別子{@link HokenryoRankIdentifier}
     */
    @Override
    public HokenryoRankIdentifier identifier() {
        return this.id;
    }

    /**
     * 保険料ランクのみを変更対象とします。<br/> {@link DbT2012HokenryoRankEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link HokenryoRank}
     */
    public HokenryoRank modifiedModel() {
        DbT2012HokenryoRankEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new HokenryoRank(
                modifiedEntity, id);
    }

    /**
     * 保持する保険料ランクを削除対象とします。<br/> {@link DbT2012HokenryoRankEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link HokenryoRank}
     */
    @Override
    public HokenryoRank deleted() {
        DbT2012HokenryoRankEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new HokenryoRank(deletedEntity, id);
    }

    /**
     * {@link HokenryoRank}のシリアライズ形式を提供します。
     *
     * @return {@link HokenryoRank}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 5806192593610686503L;
        private final DbT2012HokenryoRankEntity entity;
        private final HokenryoRankIdentifier id;

        private _SerializationProxy(DbT2012HokenryoRankEntity entity, HokenryoRankIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new HokenryoRank(this.entity, this.id);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.entity);
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final HokenryoRank other = (HokenryoRank) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link HokenryoRank.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public HokenryoRankBuilder createBuilderForEdit() {
        return new HokenryoRankBuilder(entity, id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikushichoson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chosachikugroup.ChosaChikuGroup;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chosachikugroup.ChosaChikuGroupIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.chikushichoson.ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 地区市町村を管理するクラスです。
 */
public class ChikuShichoson extends ModelBase<ChikuShichosonIdentifier, DbT5224ChikuShichosonEntity, ChikuShichoson> implements Serializable {
    private static final long serialVersionUID = -6149283089424054020L;

    private final DbT5224ChikuShichosonEntity entity;
    private final ChikuShichosonIdentifier id;
    private final Models<ChosaChikuGroupIdentifier, ChosaChikuGroup> chosaChikuGroup;
    /**
     * コンストラクタです。<br/>
     * 地区市町村の新規作成時に使用します。
     *
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     */
    public ChikuShichoson(Code 調査地区コード,LasdecCode 市町村コード) {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        this.entity = new DbT5224ChikuShichosonEntity();
        this.entity.setChosaChikuCode(調査地区コード);
        this.entity.setShichosonCode(市町村コード);
        this.id = new ChikuShichosonIdentifier(
        調査地区コード,
        市町村コード
                );
        this.chosaChikuGroup = Models.create(new ArrayList<ChosaChikuGroup>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5224ChikuShichosonEntity}より{@link ChikuShichoson}を生成します。
     *
     * @param entity DBより取得した{@link DbT5224ChikuShichosonEntity}
     */
    public ChikuShichoson(ChikuShichosonEntity entity) {
        this.entity = requireNonNull(entity.get地区市町村Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("地区市町村"));
        this.id = new ChikuShichosonIdentifier(
                entity.get地区市町村Entity().getChosaChikuCode(),
                entity.get地区市町村Entity().getShichosonCode());
        List<ChosaChikuGroup> chosaChikuGroupList = new ArrayList<>();
        for (DbT5225ChosaChikuGroupEntity dbT5225ChosaChikuGroupEntity : entity.get調査地区グループマスタEntity()) {
            chosaChikuGroupList.add(new ChosaChikuGroup(dbT5225ChosaChikuGroupEntity));
        }
        this.chosaChikuGroup = Models.create(chosaChikuGroupList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5224ChikuShichosonEntity}
     * @param id {@link ChikuShichosonIdentifier}
     */
    ChikuShichoson(
            DbT5224ChikuShichosonEntity entity,
            ChikuShichosonIdentifier id,
            Models<ChosaChikuGroupIdentifier, ChosaChikuGroup> chosaChikuGroup) {
        this.entity = entity;
        this.id = id;
        this.chosaChikuGroup = chosaChikuGroup;
    }

    /**
     * 調査地区コードを返します。
     *
     * @return 調査地区コード
     */
    public Code get調査地区コード() {
        return entity.getChosaChikuCode();
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
     * 優先番号を返します。
     *
     * @return 優先番号
     */
    public int get優先番号() {
        return entity.getYusenNo();
    }

    /**
     * 自地区フラグを返します。
     *
     * @return 自地区フラグ
     */
    public boolean get自地区フラグ() {
        return entity.getJiChikuFlag();
    }

    /**
     * {@link DbT5224ChikuShichosonEntity}のクローンを返します。
     *
     * @return {@link DbT5224ChikuShichosonEntity}のクローン
     */
    @Override
    public DbT5224ChikuShichosonEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 地区市町村の識別子{@link ChikuShichosonIdentifier}を返します。
     *
     * @return 地区市町村の識別子{@link ChikuShichosonIdentifier}
     */
    @Override
    public ChikuShichosonIdentifier identifier() {
        return this.id;
    }

    /**
     * 地区市町村配下の要素を削除対象とします。<br/>
     * {@link DbT5224ChikuShichosonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 地区市町村配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link ChikuShichoson}を返します。
     *
     * @return 削除対象処理実施後の{@link ChikuShichoson}
     * @throws IllegalStateException DbT5224ChikuShichosonEntityのデータ状態が変更の場合
     */
    @Override
    public ChikuShichoson deleted() {
        DbT5224ChikuShichosonEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChikuShichoson(
                deletedEntity, id,chosaChikuGroup.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || chosaChikuGroup.hasAnyChanged();
    }

    /**
     * 地区市町村のみを変更対象とします。<br/>
     * {@link DbT5224ChikuShichosonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ChikuShichoson}
     */
    public ChikuShichoson modifiedModel() {
        DbT5224ChikuShichosonEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ChikuShichoson(
                modifiedEntity, id, chosaChikuGroup);
    }

    /**
     * 地区市町村が保持する精神手帳任意項目情報に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id 精神手帳任意項目情報の識別子
     * @return 精神手帳任意項目情報
     * @throws IllegalStateException 指定の識別子に該当する精神手帳任意項目情報がない場合
     */
    public ChosaChikuGroup getChosaChikuGroup(ChosaChikuGroupIdentifier id) {
        if (chosaChikuGroup.contains(id)) {
            return chosaChikuGroup.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 地区市町村が保持する精神手帳任意項目情報をリストで返します。
     *
     * @return 精神手帳任意項目情報リスト
     */
    public List<ChosaChikuGroup> getChosaChikuGroupList() {
        return new ArrayList<>(chosaChikuGroup.values());

    }
    /**
     * {@link ChikuShichoson}のシリアライズ形式を提供します。
     *
     * @return {@link ChikuShichoson}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, chosaChikuGroup);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT5224ChikuShichosonEntity entity;
        private final ChikuShichosonIdentifier id;
       private final Models<ChosaChikuGroupIdentifier, ChosaChikuGroup> chosaChikuGroup;

        private _SerializationProxy(
                DbT5224ChikuShichosonEntity entity,
                ChikuShichosonIdentifier id,
               Models<ChosaChikuGroupIdentifier, ChosaChikuGroup> chosachikugroup) {
            this.entity = entity;
            this.id = id;
            this.chosaChikuGroup = chosachikugroup;
        }

        private Object readResolve() {
            return new ChikuShichoson(this.entity, this.id, chosaChikuGroup);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link ChikuShichosonBuilder#build()}を使用してください。
     *
     * @return {@link ChikuShichosonBuilder}
     */
    public ChikuShichosonBuilder createBuilderForEdit() {
        return new ChikuShichosonBuilder(entity, id, chosaChikuGroup);
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
        final ChikuShichoson other = (ChikuShichoson) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

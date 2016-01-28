/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikuninteichosain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikushichoson.ChikuShichoson;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikushichoson.ChikuShichosonIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.chikuninteichosain.ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.chikushichoson.ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 地区認定調査員を管理するクラスです。
 */
public class ChikuNinteiChosain extends ModelBase<ChikuNinteiChosainIdentifier, DbT5223ChikuNinteiChosainEntity, ChikuNinteiChosain> implements Serializable {

    private static final long serialVersionUID = -921565083586101661L;

    private final DbT5223ChikuNinteiChosainEntity entity;
    private final ChikuNinteiChosainIdentifier id;
    private final Models<ChikuShichosonIdentifier, ChikuShichoson> chikuShichoson;

    /**
     * コンストラクタです。<br/>
     * 地区認定調査員の新規作成時に使用します。
     *
     * @param 調査地区コード 調査地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 市町村コード 市町村コード
     */
    public ChikuNinteiChosain(Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード) {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        this.entity = new DbT5223ChikuNinteiChosainEntity();
        this.entity.setChosaChikuCode(調査地区コード);
        this.entity.setNinteiChosaItakusakiCode(認定調査委託先コード);
        this.entity.setNinteiChosainCode(認定調査員コード);
        this.entity.setShichosonCode(市町村コード);
        this.id = new ChikuNinteiChosainIdentifier(
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード);
        this.chikuShichoson = Models.create(new ArrayList<ChikuShichoson>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5223ChikuNinteiChosainEntity}より{@link ChikuNinteiChosain}を生成します。
     *
     * @param entity DBより取得した{@link DbT5223ChikuNinteiChosainEntity}
     */
    public ChikuNinteiChosain(ChikuNinteiChosainEntity entity) {
        this.entity = requireNonNull(entity.get地区認定調査員Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("地区認定調査員"));
        this.id = new ChikuNinteiChosainIdentifier(
                entity.get地区認定調査員Entity().getChosaChikuCode(),
                entity.get地区認定調査員Entity().getNinteiChosaItakusakiCode(),
                entity.get地区認定調査員Entity().getNinteiChosainCode(),
                entity.get地区認定調査員Entity().getShichosonCode());
        List<ChikuShichoson> chikushichosonList = new ArrayList<>();
        for (ChikuShichosonEntity chikuEntity : entity.get地区市町村Entity()) {
            chikushichosonList.add(new ChikuShichoson(chikuEntity));
        }
        this.chikuShichoson = Models.create(chikushichosonList);
    }
    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5223ChikuNinteiChosainEntity}
     * @param id {@link ChikuNinteiChosainIdentifier}
     */
    ChikuNinteiChosain(
            DbT5223ChikuNinteiChosainEntity entity,
            ChikuNinteiChosainIdentifier id,
            Models<ChikuShichosonIdentifier, ChikuShichoson> chikushichoson) {
        this.entity = entity;
        this.id = id;
        this.chikuShichoson = chikushichoson;
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
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
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
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * {@link DbT5223ChikuNinteiChosainEntity}のクローンを返します。
     *
     * @return {@link DbT5223ChikuNinteiChosainEntity}のクローン
     */
    @Override
    public DbT5223ChikuNinteiChosainEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 地区認定調査員の識別子{@link ChikuNinteiChosainIdentifier}を返します。
     *
     * @return 地区認定調査員の識別子{@link ChikuNinteiChosainIdentifier}
     */
    @Override
    public ChikuNinteiChosainIdentifier identifier() {
        return this.id;
    }

    /**
     * 地区認定調査員配下の要素を削除対象とします。<br/>
     * {@link DbT5223ChikuNinteiChosainEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 地区認定調査員配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link ChikuNinteiChosain}を返します。
     *
     * @return 削除対象処理実施後の{@link ChikuNinteiChosain}
     * @throws IllegalStateException DbT5223ChikuNinteiChosainEntityのデータ状態が変更の場合
     */
    @Override
    public ChikuNinteiChosain deleted() {
        DbT5223ChikuNinteiChosainEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChikuNinteiChosain(
                deletedEntity, id, chikuShichoson.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || chikuShichoson.hasAnyChanged();
    }

    /**
     * 地区認定調査員のみを変更対象とします。<br/>
     * {@link DbT5223ChikuNinteiChosainEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ChikuNinteiChosain}
     */
    public ChikuNinteiChosain modifiedModel() {
        DbT5223ChikuNinteiChosainEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ChikuNinteiChosain(
                modifiedEntity, id, chikuShichoson);
    }

    /**
     * 地区認定調査員が保持する精神手帳任意項目情報に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id 精神手帳任意項目情報の識別子
     * @return 精神手帳任意項目情報
     * @throws IllegalStateException 指定の識別子に該当する精神手帳任意項目情報がない場合
     */
    public ChikuShichoson getChikuShichoson(ChikuShichosonIdentifier id) {
        if (chikuShichoson.contains(id)) {
            return chikuShichoson.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 地区認定調査員が保持する精神手帳任意項目情報をリストで返します。
     *
     * @return 精神手帳任意項目情報リスト
     */
    public List<ChikuShichoson> getChikuShichosonList() {
        return new ArrayList<>(chikuShichoson.values());

    }

    /**
     * {@link ChikuNinteiChosain}のシリアライズ形式を提供します。
     *
     * @return {@link ChikuNinteiChosain}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, chikuShichoson);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT5223ChikuNinteiChosainEntity entity;
        private final ChikuNinteiChosainIdentifier id;
        private final Models<ChikuShichosonIdentifier, ChikuShichoson> chikuShichoson;
        private _SerializationProxy(
                DbT5223ChikuNinteiChosainEntity entity,
                ChikuNinteiChosainIdentifier id,
                Models<ChikuShichosonIdentifier, ChikuShichoson> chikushichoson
        ) {
            this.entity = entity;
            this.id = id;
            this.chikuShichoson = chikushichoson;
        }

        private Object readResolve() {
            return new ChikuNinteiChosain(this.entity, this.id, this.chikuShichoson);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link ChikuNinteiChosainBuilder#build()}を使用してください。
     *
     * @return {@link ChikuNinteiChosainBuilder}
     */
    public ChikuNinteiChosainBuilder createBuilderForEdit() {
        return new ChikuNinteiChosainBuilder(entity, id, chikuShichoson);
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
        final ChikuNinteiChosain other = (ChikuNinteiChosain) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

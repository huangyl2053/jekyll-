/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 地区認定調査員を管理するクラスです。
 */
public class ChikuNinteiChosain extends ParentModelBase<ChikuNinteiChosainIdentifier, DbT5223ChikuNinteiChosainEntity, ChikuNinteiChosain> implements Serializable {

    private final DbT5223ChikuNinteiChosainEntity entity;
    private final ChikuNinteiChosainIdentifier id;

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
                市町村コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5223ChikuNinteiChosainEntity}より{@link ChikuNinteiChosain}を生成します。
     *
     * @param entity DBより取得した{@link DbT5223ChikuNinteiChosainEntity}
     */
    public ChikuNinteiChosain(DbT5223ChikuNinteiChosainEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("地区認定調査員"));
        this.id = new ChikuNinteiChosainIdentifier(
                entity.getChosaChikuCode(),
                entity.getNinteiChosaItakusakiCode(),
                entity.getNinteiChosainCode(),
                entity.getShichosonCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5223ChikuNinteiChosainEntity}
     * @param id {@link ChikuNinteiChosainIdentifier}
     */
    ChikuNinteiChosain(
            DbT5223ChikuNinteiChosainEntity entity,
            ChikuNinteiChosainIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
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
     * 地区認定調査員のみを変更対象とします。<br/>
     * {@link DbT5223ChikuNinteiChosainEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ChikuNinteiChosain}
     */
    @Override
    public ChikuNinteiChosain modifiedModel() {
        DbT5223ChikuNinteiChosainEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ChikuNinteiChosain(
                modifiedEntity, id);
    }

    /**
     * 保持する地区認定調査員を削除対象とします。<br/>
     * {@link DbT5223ChikuNinteiChosainEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChikuNinteiChosain}
     */
    @Override
    public ChikuNinteiChosain deleted() {
        DbT5223ChikuNinteiChosainEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChikuNinteiChosain(deletedEntity, id);
    }

    /**
     * {@link ChikuNinteiChosain}のシリアライズ形式を提供します。
     *
     * @return {@link ChikuNinteiChosain}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L; // TODO serialVersionUIDを生成してください
        private final DbT5223ChikuNinteiChosainEntity entity;
        private final ChikuNinteiChosainIdentifier id;

        private _SerializationProxy(DbT5223ChikuNinteiChosainEntity entity, ChikuNinteiChosainIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ChikuNinteiChosain(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ChikuNinteiChosainBuilder createBuilderForEdit() {
        return new ChikuNinteiChosainBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

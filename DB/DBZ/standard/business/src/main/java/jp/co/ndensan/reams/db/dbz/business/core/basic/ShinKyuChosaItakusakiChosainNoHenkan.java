/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 新旧調査委託先調査員番号変換テーブルを管理するクラスです。
 */
public class ShinKyuChosaItakusakiChosainNoHenkan extends ParentModelBase<ShinKyuChosaItakusakiChosainNoHenkanIdentifier, DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity, ShinKyuChosaItakusakiChosainNoHenkan> implements Serializable {

    private final DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity;
    private final ShinKyuChosaItakusakiChosainNoHenkanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 新旧調査委託先調査員番号変換テーブルの新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param 旧調査委託先番号 旧調査委託先番号
     * @param 旧調査員番号 旧調査員番号
     */
    public ShinKyuChosaItakusakiChosainNoHenkan(LasdecCode 市町村コード,
            RString 旧調査委託先番号,
            RString 旧調査員番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧調査委託先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査委託先番号"));
        requireNonNull(旧調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査員番号"));
        this.entity = new DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setKyuChosaItakusakiNo(旧調査委託先番号);
        this.entity.setKyuChosainNo(旧調査員番号);
        this.id = new ShinKyuChosaItakusakiChosainNoHenkanIdentifier(
                市町村コード,
                旧調査委託先番号,
                旧調査員番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}より{@link ShinKyuChosaItakusakiChosainNoHenkan}を生成します。
     *
     * @param entity DBより取得した{@link DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}
     */
    public ShinKyuChosaItakusakiChosainNoHenkan(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧調査委託先調査員番号変換テーブル"));
        this.id = new ShinKyuChosaItakusakiChosainNoHenkanIdentifier(
                entity.getShichosonCode(),
                entity.getKyuChosaItakusakiNo(),
                entity.getKyuChosainNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}
     * @param id {@link ShinKyuChosaItakusakiChosainNoHenkanIdentifier}
     */
    ShinKyuChosaItakusakiChosainNoHenkan(
            DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity,
            ShinKyuChosaItakusakiChosainNoHenkanIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 新調査委託先番号を返します。
     *
     * @return 新調査委託先番号
     */
    public RString get新調査委託先番号() {
        return entity.getShinChosaItakusakiNo();
    }

    /**
     * 新調査員番号を返します。
     *
     * @return 新調査員番号
     */
    public RString get新調査員番号() {
        return entity.getShinChosainNo();
    }

    /**
     * 旧調査委託先番号を返します。
     *
     * @return 旧調査委託先番号
     */
    public RString get旧調査委託先番号() {
        return entity.getKyuChosaItakusakiNo();
    }

    /**
     * 旧調査員番号を返します。
     *
     * @return 旧調査員番号
     */
    public RString get旧調査員番号() {
        return entity.getKyuChosainNo();
    }

    /**
     * 市町村コード２を返します。
     *
     * @return 市町村コード２
     */
    public LasdecCode get市町村コード２() {
        return entity.getShichosonCode2();
    }

    /**
     * 旧調査委託先番号２を返します。
     *
     * @return 旧調査委託先番号２
     */
    public RString get旧調査委託先番号２() {
        return entity.getKyuChosaItakusakiNo2();
    }

    /**
     * 旧調査員番号２を返します。
     *
     * @return 旧調査員番号２
     */
    public RString get旧調査員番号２() {
        return entity.getKyuChosainNo2();
    }

    /**
     * {@link DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}のクローンを返します。
     *
     * @return {@link DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}のクローン
     */
    @Override
    public DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 新旧調査委託先調査員番号変換テーブルの識別子{@link ShinKyuChosaItakusakiChosainNoHenkanIdentifier}を返します。
     *
     * @return 新旧調査委託先調査員番号変換テーブルの識別子{@link ShinKyuChosaItakusakiChosainNoHenkanIdentifier}
     */
    @Override
    public ShinKyuChosaItakusakiChosainNoHenkanIdentifier identifier() {
        return this.id;
    }

    /**
     * 新旧調査委託先調査員番号変換テーブルのみを変更対象とします。<br/>
     * {@link DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinKyuChosaItakusakiChosainNoHenkan}
     */
    @Override
    public ShinKyuChosaItakusakiChosainNoHenkan modifiedModel() {
        DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinKyuChosaItakusakiChosainNoHenkan(
                modifiedEntity, id);
    }

    /**
     * 保持する新旧調査委託先調査員番号変換テーブルを削除対象とします。<br/>
     * {@link DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinKyuChosaItakusakiChosainNoHenkan}
     */
    @Override
    public ShinKyuChosaItakusakiChosainNoHenkan deleted() {
        DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinKyuChosaItakusakiChosainNoHenkan(deletedEntity, id);
    }

    /**
     * {@link ShinKyuChosaItakusakiChosainNoHenkan}のシリアライズ形式を提供します。
     *
     * @return {@link ShinKyuChosaItakusakiChosainNoHenkan}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity;
        private final ShinKyuChosaItakusakiChosainNoHenkanIdentifier id;

        private _SerializationProxy(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity, ShinKyuChosaItakusakiChosainNoHenkanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinKyuChosaItakusakiChosainNoHenkan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinKyuChosaItakusakiChosainNoHenkanBuilder createBuilderForEdit() {
        return new ShinKyuChosaItakusakiChosainNoHenkanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

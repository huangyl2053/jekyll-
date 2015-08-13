/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 合併内住特者新旧番号変換テーブルを管理するクラスです。
 */
public class GappeiNaiJutokushaShinKyuNoHenkan extends ParentModelBase<GappeiNaiJutokushaShinKyuNoHenkanIdentifier, DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity, GappeiNaiJutokushaShinKyuNoHenkan> implements Serializable {

    private final DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity;
    private final GappeiNaiJutokushaShinKyuNoHenkanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 合併内住特者新旧番号変換テーブルの新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public GappeiNaiJutokushaShinKyuNoHenkan(ShikibetsuCode 識別コード,
            RString 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new GappeiNaiJutokushaShinKyuNoHenkanIdentifier(
                識別コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity}より{@link GappeiNaiJutokushaShinKyuNoHenkan}を生成します。
     *
     * @param entity DBより取得した{@link DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity}
     */
    public GappeiNaiJutokushaShinKyuNoHenkan(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合併内住特者新旧番号変換テーブル"));
        this.id = new GappeiNaiJutokushaShinKyuNoHenkanIdentifier(
                entity.getShikibetsuCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity}
     * @param id {@link GappeiNaiJutokushaShinKyuNoHenkanIdentifier}
     */
    GappeiNaiJutokushaShinKyuNoHenkan(
            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity,
            GappeiNaiJutokushaShinKyuNoHenkanIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public RString get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 識別コード（措置元）を返します。
     *
     * @return 識別コード（措置元）
     */
    public ShikibetsuCode get識別コード_措置元() {
        return entity.getShikibetsuCodeSochiMoto();
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
     * 市町村コード（措置元）を返します。
     *
     * @return 市町村コード（措置元）
     */
    public LasdecCode get市町村コード_措置元() {
        return entity.getShichosonCodeSochiMoto();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者番号（措置元）を返します。
     *
     * @return 被保険者番号（措置元）
     */
    public HihokenshaNo get被保険者番号_措置元() {
        return entity.getHihokenshaNoSochiMoto();
    }

    /**
     * 開始年月日を返します。
     *
     * @return 開始年月日
     */
    public FlexibleDate get開始年月日() {
        return entity.getKaishiYMD();
    }

    /**
     * 終了年月日を返します。
     *
     * @return 終了年月日
     */
    public FlexibleDate get終了年月日() {
        return entity.getShuryoYMD();
    }

    /**
     * {@link DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity}のクローンを返します。
     *
     * @return {@link DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity}のクローン
     */
    @Override
    public DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 合併内住特者新旧番号変換テーブルの識別子{@link GappeiNaiJutokushaShinKyuNoHenkanIdentifier}を返します。
     *
     * @return 合併内住特者新旧番号変換テーブルの識別子{@link GappeiNaiJutokushaShinKyuNoHenkanIdentifier}
     */
    @Override
    public GappeiNaiJutokushaShinKyuNoHenkanIdentifier identifier() {
        return this.id;
    }

    /**
     * 合併内住特者新旧番号変換テーブルのみを変更対象とします。<br/>
     * {@link DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GappeiNaiJutokushaShinKyuNoHenkan}
     */
    @Override
    public GappeiNaiJutokushaShinKyuNoHenkan modifiedModel() {
        DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new GappeiNaiJutokushaShinKyuNoHenkan(
                modifiedEntity, id);
    }

    /**
     * 保持する合併内住特者新旧番号変換テーブルを削除対象とします。<br/>
     * {@link DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link GappeiNaiJutokushaShinKyuNoHenkan}
     */
    @Override
    public GappeiNaiJutokushaShinKyuNoHenkan deleted() {
        DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new GappeiNaiJutokushaShinKyuNoHenkan(deletedEntity, id);
    }

    /**
     * {@link GappeiNaiJutokushaShinKyuNoHenkan}のシリアライズ形式を提供します。
     *
     * @return {@link GappeiNaiJutokushaShinKyuNoHenkan}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;// TODO serialVersionUIDを生成してください
        private final DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity;
        private final GappeiNaiJutokushaShinKyuNoHenkanIdentifier id;

        private _SerializationProxy(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity, GappeiNaiJutokushaShinKyuNoHenkanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new GappeiNaiJutokushaShinKyuNoHenkan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public GappeiNaiJutokushaShinKyuNoHenkanBuilder createBuilderForEdit() {
        return new GappeiNaiJutokushaShinKyuNoHenkanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

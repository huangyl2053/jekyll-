/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7028KakushuShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 各種新旧番号変換テーブルを管理するクラスです。
 */
public class KakushuShinKyuNoHenkan extends 
        ParentModelBase<KakushuShinKyuNoHenkanIdentifier, 
        DbT7028KakushuShinKyuNoHenkanEntity, KakushuShinKyuNoHenkan> implements Serializable {

    private final DbT7028KakushuShinKyuNoHenkanEntity entity;
    private final KakushuShinKyuNoHenkanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 各種新旧番号変換テーブルの新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 番号区分 番号区分
     * @param 旧番号 旧番号
     */
    public KakushuShinKyuNoHenkan(HihokenshaNo 被保険者番号,
            RString 番号区分,
            RString 旧番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(番号区分, UrSystemErrorMessages.値がnull.getReplacedMessage("番号区分"));
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));
        this.entity = new DbT7028KakushuShinKyuNoHenkanEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setNoKubun(番号区分);
        this.entity.setKyuNo(旧番号);
        this.id = new KakushuShinKyuNoHenkanIdentifier(
                被保険者番号,
                番号区分,
                旧番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7028KakushuShinKyuNoHenkanEntity}より{@link KakushuShinKyuNoHenkan}を生成します。
     *
     * @param entity DBより取得した{@link DbT7028KakushuShinKyuNoHenkanEntity}
     */
    public KakushuShinKyuNoHenkan(DbT7028KakushuShinKyuNoHenkanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("各種新旧番号変換テーブル"));
        this.id = new KakushuShinKyuNoHenkanIdentifier(
                entity.getHihokenshaNo(),
                entity.getNoKubun(),
                entity.getKyuNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7028KakushuShinKyuNoHenkanEntity}
     * @param id {@link KakushuShinKyuNoHenkanIdentifier}
     */
    KakushuShinKyuNoHenkan(
            DbT7028KakushuShinKyuNoHenkanEntity entity,
            KakushuShinKyuNoHenkanIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 番号区分を返します。
     *
     * @return 番号区分
     */
    public RString get番号区分() {
        return entity.getNoKubun();
    }

    /**
     * 新番号を返します。
     *
     * @return 新番号
     */
    public RString get新番号() {
        return entity.getShinNo();
    }

    /**
     * 旧番号を返します。
     *
     * @return 旧番号
     */
    public RString get旧番号() {
        return entity.getKyuNo();
    }

    /**
     * {@link DbT7028KakushuShinKyuNoHenkanEntity}のクローンを返します。
     *
     * @return {@link DbT7028KakushuShinKyuNoHenkanEntity}のクローン
     */
    @Override
    public DbT7028KakushuShinKyuNoHenkanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 各種新旧番号変換テーブルの識別子{@link KakushuShinKyuNoHenkanIdentifier}を返します。
     *
     * @return 各種新旧番号変換テーブルの識別子{@link KakushuShinKyuNoHenkanIdentifier}
     */
    @Override
    public KakushuShinKyuNoHenkanIdentifier identifier() {
        return this.id;
    }

    /**
     * 各種新旧番号変換テーブルのみを変更対象とします。<br/>
     * {@link DbT7028KakushuShinKyuNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KakushuShinKyuNoHenkan}
     */
    @Override
    public KakushuShinKyuNoHenkan modifiedModel() {
        DbT7028KakushuShinKyuNoHenkanEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KakushuShinKyuNoHenkan(
                modifiedEntity, id);
    }

    /**
     * 保持する各種新旧番号変換テーブルを削除対象とします。<br/>
     * {@link DbT7028KakushuShinKyuNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KakushuShinKyuNoHenkan}
     */
    @Override
    public KakushuShinKyuNoHenkan deleted() {
        DbT7028KakushuShinKyuNoHenkanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KakushuShinKyuNoHenkan(deletedEntity, id);
    }

    /**
     * {@link KakushuShinKyuNoHenkan}のシリアライズ形式を提供します。
     *
     * @return {@link KakushuShinKyuNoHenkan}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT7028KakushuShinKyuNoHenkanEntity entity;
        private final KakushuShinKyuNoHenkanIdentifier id;

        private _SerializationProxy(DbT7028KakushuShinKyuNoHenkanEntity entity, KakushuShinKyuNoHenkanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KakushuShinKyuNoHenkan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KakushuShinKyuNoHenkanBuilder createBuilderForEdit() {
        return new KakushuShinKyuNoHenkanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogoteishikikan;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0528SeikatsuHogoTeishikikanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 生活保護停止期間を管理するクラスです。
 */
public class SeikatsuHogoTeishikikan extends ModelBase<SeikatsuHogoTeishikikanIdentifier, UrT0528SeikatsuHogoTeishikikanEntity, SeikatsuHogoTeishikikan> implements Serializable {

    private final UrT0528SeikatsuHogoTeishikikanEntity entity;
    private final SeikatsuHogoTeishikikanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 生活保護停止期間の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 業務コード 業務コード
     * @param 受給開始日 受給開始日
     * @param 受給停止開始日 受給停止開始日
     */
    public SeikatsuHogoTeishikikan(ShikibetsuCode 識別コード,
            GyomuCode 業務コード,
            FlexibleDate 受給開始日,
            FlexibleDate 受給停止開始日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("業務コード"));
        requireNonNull(受給開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給開始日"));
        requireNonNull(受給停止開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給停止開始日"));
        this.entity = new UrT0528SeikatsuHogoTeishikikanEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setGyomuCode(業務コード);
        this.entity.setJukyuTeishiKaishiYMD(受給開始日);
        this.entity.setJukyuTeishiShuryoYMD(受給停止開始日);
        this.id = new SeikatsuHogoTeishikikanIdentifier(
                識別コード,
                業務コード,
                受給開始日,
                受給停止開始日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link UrT0528SeikatsuHogoTeishikikanEntity}より{@link SeikatsuHogoTeishikikan}を生成します。
     *
     * @param entity DBより取得した{@link UrT0528SeikatsuHogoTeishikikanEntity}
     */
    public SeikatsuHogoTeishikikan(UrT0528SeikatsuHogoTeishikikanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護停止期間"));
        this.id = new SeikatsuHogoTeishikikanIdentifier(
                entity.getShikibetsuCode(),
                entity.getGyomuCode(),
                entity.getJukyuTeishiKaishiYMD(),
                entity.getJukyuTeishiShuryoYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link UrT0528SeikatsuHogoTeishikikanEntity}
     * @param id {@link SeikatsuHogoTeishikikanIdentifier}
     */
    SeikatsuHogoTeishikikan(
            UrT0528SeikatsuHogoTeishikikanEntity entity,
            SeikatsuHogoTeishikikanIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 業務コードを返します。
     *
     * @return 業務コード
     */
    public GyomuCode get業務コード() {
        return entity.getGyomuCode();
    }

    /**
     * 受給開始日を返します。
     *
     * @return 受給開始日
     */
    public FlexibleDate get受給開始日() {
        return entity.getJukyuKaishiYMD();
    }

    /**
     * 受給停止開始日を返します。
     *
     * @return 受給停止開始日
     */
    public FlexibleDate get受給停止開始日() {
        return entity.getJukyuTeishiKaishiYMD();
    }

    /**
     * 受給停止終了日を返します。
     *
     * @return 受給停止終了日
     */
    public FlexibleDate get受給停止終了日() {
        return entity.getJukyuTeishiShuryoYMD();
    }

    /**
     * {@link UrT0528SeikatsuHogoTeishikikanEntity}のクローンを返します。
     *
     * @return {@link UrT0528SeikatsuHogoTeishikikanEntity}のクローン
     */
    @Override
    public UrT0528SeikatsuHogoTeishikikanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 生活保護停止期間の識別子{@link SeikatsuHogoTeishikikanIdentifier}を返します。
     *
     * @return 生活保護停止期間の識別子{@link SeikatsuHogoTeishikikanIdentifier}
     */
    @Override
    public SeikatsuHogoTeishikikanIdentifier identifier() {
        return this.id;
    }

    /**
     * 生活保護停止期間のみを変更対象とします。<br/>
     * {@link UrT0528SeikatsuHogoTeishikikanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link SeikatsuHogoTeishikikan}
     */
    public SeikatsuHogoTeishikikan modifiedModel() {
        UrT0528SeikatsuHogoTeishikikanEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new SeikatsuHogoTeishikikan(
                modifiedEntity, id);
    }

    /**
     * 保持する生活保護停止期間を削除対象とします。<br/>
     * {@link UrT0528SeikatsuHogoTeishikikanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SeikatsuHogoTeishikikan}
     */
    @Override
    public SeikatsuHogoTeishikikan deleted() {
        UrT0528SeikatsuHogoTeishikikanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SeikatsuHogoTeishikikan(deletedEntity, id);
    }

    /**
     * {@link SeikatsuHogoTeishikikan}のシリアライズ形式を提供します。
     *
     * @return {@link SeikatsuHogoTeishikikan}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 7002179809954282370L;
        private final UrT0528SeikatsuHogoTeishikikanEntity entity;
        private final SeikatsuHogoTeishikikanIdentifier id;

        private _SerializationProxy(UrT0528SeikatsuHogoTeishikikanEntity entity, SeikatsuHogoTeishikikanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new SeikatsuHogoTeishikikan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SeikatsuHogoTeishikikanBuilder createBuilderForEdit() {
        return new SeikatsuHogoTeishikikanBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final SeikatsuHogoTeishikikan other = (SeikatsuHogoTeishikikan) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

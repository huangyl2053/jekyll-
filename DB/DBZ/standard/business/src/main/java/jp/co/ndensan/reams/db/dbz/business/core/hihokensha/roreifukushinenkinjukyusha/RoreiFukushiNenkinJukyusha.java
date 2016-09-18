/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 老齢福祉年金受給者を管理するクラスです。
 *
 * @reamsid_L DBA-0220-020 dongyabin
 */
public class RoreiFukushiNenkinJukyusha
        extends ModelBase<RoreiFukushiNenkinJukyushaIdentifier, DbT7006RoreiFukushiNenkinJukyushaEntity, RoreiFukushiNenkinJukyusha>
        implements Serializable {

    private final DbT7006RoreiFukushiNenkinJukyushaEntity entity;
    private final RoreiFukushiNenkinJukyushaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 老齢福祉年金受給者の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 受給開始年月日 受給開始年月日
     */
    public RoreiFukushiNenkinJukyusha(ShikibetsuCode 識別コード,
            FlexibleDate 受給開始年月日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(受給開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給開始年月日"));
        this.entity = new DbT7006RoreiFukushiNenkinJukyushaEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setJukyuKaishiYMD(受給開始年月日);
        this.id = new RoreiFukushiNenkinJukyushaIdentifier(
                識別コード,
                受給開始年月日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7006RoreiFukushiNenkinJukyushaEntity}より{@link RoreiFukushiNenkinJukyusha}を生成します。
     *
     * @param entity DBより取得した{@link DbT7006RoreiFukushiNenkinJukyushaEntity}
     */
    public RoreiFukushiNenkinJukyusha(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("老齢福祉年金受給者"));
        this.id = new RoreiFukushiNenkinJukyushaIdentifier(
                entity.getShikibetsuCode(),
                entity.getJukyuKaishiYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7006RoreiFukushiNenkinJukyushaEntity}
     * @param id {@link RoreiFukushiNenkinJukyushaIdentifier}
     */
    RoreiFukushiNenkinJukyusha(
            DbT7006RoreiFukushiNenkinJukyushaEntity entity,
            RoreiFukushiNenkinJukyushaIdentifier id
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
     * 受給開始年月日を返します。
     *
     * @return 受給開始年月日
     */
    public FlexibleDate get受給開始年月日() {
        return entity.getJukyuKaishiYMD();
    }

    /**
     * 受給終了年月日を返します。
     *
     * @return 受給終了年月日
     */
    public FlexibleDate get受給終了年月日() {
        return entity.getJukyuHaishiYMD();
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
     * {@link DbT7006RoreiFukushiNenkinJukyushaEntity}のクローンを返します。
     *
     * @return {@link DbT7006RoreiFukushiNenkinJukyushaEntity}のクローン
     */
    @Override
    public DbT7006RoreiFukushiNenkinJukyushaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 老齢福祉年金受給者の識別子{@link RoreiFukushiNenkinJukyushaIdentifier}を返します。
     *
     * @return 老齢福祉年金受給者の識別子{@link RoreiFukushiNenkinJukyushaIdentifier}
     */
    @Override
    public RoreiFukushiNenkinJukyushaIdentifier identifier() {
        return this.id;
    }

    /**
     * 老齢福祉年金受給者のみを変更対象とします。<br/> {@link DbT7006RoreiFukushiNenkinJukyushaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link RoreiFukushiNenkinJukyusha}
     */
    public RoreiFukushiNenkinJukyusha modifiedModel() {
        DbT7006RoreiFukushiNenkinJukyushaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new RoreiFukushiNenkinJukyusha(
                modifiedEntity, id);
    }

    /**
     * 保持する老齢福祉年金受給者を削除対象とします。<br/> {@link DbT7006RoreiFukushiNenkinJukyushaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RoreiFukushiNenkinJukyusha}
     */
    @Override
    public RoreiFukushiNenkinJukyusha deleted() {
        DbT7006RoreiFukushiNenkinJukyushaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RoreiFukushiNenkinJukyusha(deletedEntity, id);
    }

    /**
     * {@link RoreiFukushiNenkinJukyusha}のシリアライズ形式を提供します。
     *
     * @return {@link RoreiFukushiNenkinJukyusha}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -2579431925880796506L;
        private final DbT7006RoreiFukushiNenkinJukyushaEntity entity;
        private final RoreiFukushiNenkinJukyushaIdentifier id;

        private _SerializationProxy(DbT7006RoreiFukushiNenkinJukyushaEntity entity, RoreiFukushiNenkinJukyushaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new RoreiFukushiNenkinJukyusha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RoreiFukushiNenkinJukyushaBuilder createBuilderForEdit() {
        return new RoreiFukushiNenkinJukyushaBuilder(entity, id);
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
        final RoreiFukushiNenkinJukyusha other = (RoreiFukushiNenkinJukyusha) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

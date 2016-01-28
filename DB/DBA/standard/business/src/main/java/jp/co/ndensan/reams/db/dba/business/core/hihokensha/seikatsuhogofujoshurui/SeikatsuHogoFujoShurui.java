/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogofujoshurui;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.code.FujoShuruiCodeValue;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 生活保護扶助種類を管理するクラスです。
 */
public class SeikatsuHogoFujoShurui extends ModelBase<SeikatsuHogoFujoShuruiIdentifier, UrT0526SeikatsuHogoFujoShuruiEntity, SeikatsuHogoFujoShurui> implements Serializable {

    private final UrT0526SeikatsuHogoFujoShuruiEntity entity;
    private final SeikatsuHogoFujoShuruiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 生活保護扶助種類の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 業務コード 業務コード
     * @param 受給開始日 受給開始日
     * @param 扶助種類コード 扶助種類コード
     */
    public SeikatsuHogoFujoShurui(ShikibetsuCode 識別コード,
            GyomuCode 業務コード,
            FlexibleDate 受給開始日,
            FujoShuruiCodeValue 扶助種類コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("業務コード"));
        requireNonNull(受給開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給開始日"));
        requireNonNull(扶助種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("扶助種類コード"));
        this.entity = new UrT0526SeikatsuHogoFujoShuruiEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setGyomuCode(業務コード);
        this.entity.setJukyuKaishiYMD(受給開始日);
        this.entity.setFujoShuruiCode(扶助種類コード);
        this.id = new SeikatsuHogoFujoShuruiIdentifier(
                識別コード,
                業務コード,
                受給開始日,
                扶助種類コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link UrT0526SeikatsuHogoFujoShuruiEntity}より{@link SeikatsuHogoFujoShurui}を生成します。
     *
     * @param entity DBより取得した{@link UrT0526SeikatsuHogoFujoShuruiEntity}
     */
    public SeikatsuHogoFujoShurui(UrT0526SeikatsuHogoFujoShuruiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護扶助種類"));
        this.id = new SeikatsuHogoFujoShuruiIdentifier(
                entity.getShikibetsuCode(),
                entity.getGyomuCode(),
                entity.getJukyuKaishiYMD(),
                entity.getFujoShuruiCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link UrT0526SeikatsuHogoFujoShuruiEntity}
     * @param id {@link SeikatsuHogoFujoShuruiIdentifier}
     */
    SeikatsuHogoFujoShurui(
            UrT0526SeikatsuHogoFujoShuruiEntity entity,
            SeikatsuHogoFujoShuruiIdentifier id
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
     * 扶助種類コードを返します。
     *
     * @return 扶助種類コード
     */
    public FujoShuruiCodeValue get扶助種類コード() {
        return entity.getFujoShuruiCode();
    }

    /**
     * {@link UrT0526SeikatsuHogoFujoShuruiEntity}のクローンを返します。
     *
     * @return {@link UrT0526SeikatsuHogoFujoShuruiEntity}のクローン
     */
    @Override
    public UrT0526SeikatsuHogoFujoShuruiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 生活保護扶助種類の識別子{@link SeikatsuHogoFujoShuruiIdentifier}を返します。
     *
     * @return 生活保護扶助種類の識別子{@link SeikatsuHogoFujoShuruiIdentifier}
     */
    @Override
    public SeikatsuHogoFujoShuruiIdentifier identifier() {
        return this.id;
    }

    /**
     * 生活保護扶助種類のみを変更対象とします。<br/>
     * {@link UrT0526SeikatsuHogoFujoShuruiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link SeikatsuHogoFujoShurui}
     */
    public SeikatsuHogoFujoShurui modifiedModel() {
        UrT0526SeikatsuHogoFujoShuruiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new SeikatsuHogoFujoShurui(
                modifiedEntity, id);
    }

    /**
     * 保持する生活保護扶助種類を削除対象とします。<br/>
     * {@link UrT0526SeikatsuHogoFujoShuruiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SeikatsuHogoFujoShurui}
     */
    @Override
    public SeikatsuHogoFujoShurui deleted() {
        UrT0526SeikatsuHogoFujoShuruiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SeikatsuHogoFujoShurui(deletedEntity, id);
    }

    /**
     * {@link SeikatsuHogoFujoShurui}のシリアライズ形式を提供します。
     *
     * @return {@link SeikatsuHogoFujoShurui}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 2704682210207429048L;
        private final UrT0526SeikatsuHogoFujoShuruiEntity entity;
        private final SeikatsuHogoFujoShuruiIdentifier id;

        private _SerializationProxy(UrT0526SeikatsuHogoFujoShuruiEntity entity, SeikatsuHogoFujoShuruiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new SeikatsuHogoFujoShurui(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SeikatsuHogoFujoShuruiBuilder createBuilderForEdit() {
        return new SeikatsuHogoFujoShuruiBuilder(entity, id);
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
        final SeikatsuHogoFujoShurui other = (SeikatsuHogoFujoShurui) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

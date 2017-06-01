/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.seikatsuhogojoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.code.FujoShuruiCodeValue;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 生活保護扶助種別情報です。
 *
 */
public class SeikatsuFujyoShubetsuJoho implements Serializable {

    private UrT0526SeikatsuHogoFujoShuruiEntity fujyoJoho;

    private SeikatsuFujyoShubetsuJoho() {
        fujyoJoho = new UrT0526SeikatsuHogoFujoShuruiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity 生活保護扶助種別情報
     */
    public SeikatsuFujyoShubetsuJoho(UrT0526SeikatsuHogoFujoShuruiEntity entity) {
        this.fujyoJoho = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護扶助種別情報"));
    }

    /**
     * `識別コードを返します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return fujyoJoho.getShikibetsuCode().value();
    }

    /**
     * `業務コードを返します。
     *
     * @return 業務コード
     */
    public RString get業務コード() {
        return fujyoJoho.getGyomuCode().value();
    }

    /**
     * `受給開始日を返します。
     *
     * @return 受給開始日
     */
    public FlexibleDate get受給開始日() {
        return fujyoJoho.getJukyuKaishiYMD();
    }

    /**
     * `扶助種別コードを返します。
     *
     * @return 扶助種別コード
     */
    public FujoShuruiCodeValue get扶助種別コード() {
        return fujyoJoho.getFujoShuruiCode();
    }

    /**
     * `扶助種別コードを設置します。
     *
     * @param fujyoCode 扶助種別コード
     */
    public void set扶助種別コード(RString fujyoCode) {
        fujyoJoho.setFujoShuruiCode(new FujoShuruiCodeValue(fujyoCode));
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。
     *
     * @return UrT0526SeikatsuHogoFujoShuruiEntity
     */
    public UrT0526SeikatsuHogoFujoShuruiEntity toEntity() {
        return fujyoJoho.clone();
    }

    /**
     * 編集用のビルダーを返します。
     *
     * @return ビルダー
     */
    public Builder createBuilderForEdit() {
        return new Builder(this);
    }

    /**
     * 新しい{@link SeikatsuFujyoShubetsuJoho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link SeikatsuFujyoShubetsuJoho}を生成するためのビルダーです。
     */
    public static final class Builder {

        private UrT0526SeikatsuHogoFujoShuruiEntity entity;

        Builder() {
            this.entity = new UrT0526SeikatsuHogoFujoShuruiEntity();
        }

        Builder(SeikatsuFujyoShubetsuJoho joho) {
            this.entity = joho.fujyoJoho.clone();
        }

        /**
         * 扶助種別コードを設定します。
         *
         * @param fujyoCode 扶助種別コード
         * @return builder
         */
        public Builder setFujyoShubetsu(FujoShuruiCodeValue fujyoCode) {
            Objects.requireNonNull(fujyoCode);
            this.entity.setFujoShuruiCode(fujyoCode);
            return this;
        }

        /**
         * 識別コードを設定します。
         *
         * @param shikibetsuCode 識別コード
         * @return builder
         */
        public Builder setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
            Objects.requireNonNull(shikibetsuCode);
            this.entity.setShikibetsuCode(shikibetsuCode);
            return this;
        }

        /**
         * 業務コードを設定します。
         *
         * @param gyomuCode 業務コード
         * @return builder
         */
        public Builder setGyomuCode(GyomuCode gyomuCode) {
            Objects.requireNonNull(gyomuCode);
            this.entity.setGyomuCode(gyomuCode);
            return this;
        }

        /**
         * 受給開始日を設定します。
         *
         * @param jukyuKaishiBi 受給開始日
         * @return builder
         */
        public Builder setJukyuKaishiBi(FlexibleDate jukyuKaishiBi) {
            Objects.requireNonNull(jukyuKaishiBi);
            this.entity.setJukyuKaishiYMD(jukyuKaishiBi);
            return this;
        }

        /**
         * 状態に空白を設定します。
         *
         * @param unchangFlag unchangFlag
         *
         * @return builder
         */
        public Builder setUnchangedState(boolean unchangFlag) {
            if (unchangFlag) {
                entity.setState(EntityDataState.Unchanged);
            } else {
                entity.unsetState();
            }
            return this;
        }

        /**
         * 状態に削除を設定します。
         *
         * @param deleteFlag deleteFlag
         * @return builder
         */
        public Builder setDeletedState(boolean deleteFlag) {
            if (deleteFlag) {
                entity.setState(EntityDataState.Deleted);
            } else {
                entity.unsetState();
            }
            return this;
        }

        /**
         * 状態に修正を設定します。
         *
         * @param modifiedFlag modifiedFlag
         * @return builder
         */
        public Builder setModifiedState(boolean modifiedFlag) {
            if (modifiedFlag) {
                entity.setState(EntityDataState.Modified);
            } else {
                entity.unsetState();
            }
            return this;
        }

        /**
         * 状態に追加を設定します。
         *
         * @param addFlag addFlag
         */
        public void setaddedState(boolean addFlag) {
            if (addFlag) {
                entity.setState(EntityDataState.Added);
            } else {
                entity.unsetState();
            }
        }

        /**
         * stateを返します。
         *
         * @return EntityDataState
         */
        public EntityDataState getState() {
            return entity.getState();
        }

        /**
         * {@link SeikatsuFujyoShubetsuJoho}を生成します。
         *
         * @return {@link SeikatsuFujyoShubetsuJoho}
         */
        public SeikatsuFujyoShubetsuJoho build() {
            return new SeikatsuFujyoShubetsuJoho(this);
        }
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new _SerializationProxy(this);
    }

    private SeikatsuFujyoShubetsuJoho(Builder builder) {
        this.fujyoJoho = builder.entity;
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -5410154699939468062L;
        private final UrT0526SeikatsuHogoFujoShuruiEntity entity;

        private _SerializationProxy(SeikatsuFujyoShubetsuJoho joho) {
            this.entity = joho.fujyoJoho;
        }

        private Object readResolve() {
            return new SeikatsuFujyoShubetsuJoho(entity);
        }
    }
}

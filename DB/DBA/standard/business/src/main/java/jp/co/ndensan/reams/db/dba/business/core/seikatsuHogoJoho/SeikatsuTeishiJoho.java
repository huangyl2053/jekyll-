/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.seikatsuHogoJoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0528SeikatsuHogoTeishikikanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 生活保護停止期間情報です。
 *
 */
public class SeikatsuTeishiJoho implements Serializable {

    private UrT0528SeikatsuHogoTeishikikanEntity teishiJoho;

    private SeikatsuTeishiJoho() {
        teishiJoho = new UrT0528SeikatsuHogoTeishikikanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity 生活保護扶助種別情報
     */
    public SeikatsuTeishiJoho(UrT0528SeikatsuHogoTeishikikanEntity entity) {
        this.teishiJoho = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護停止期間情報"));
    }

    /**
     * `識別コードを返します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return teishiJoho.getShikibetsuCode().value();
    }

    /**
     * `業務コードを返します。
     *
     * @return 業務コード
     */
    public RString get業務コード() {
        return teishiJoho.getGyomuCode().value();
    }

    /**
     * `受給開始日を返します。
     *
     * @return 受給開始日
     */
    public FlexibleDate get受給開始日() {
        return teishiJoho.getJukyuKaishiYMD();
    }

    /**
     * `受給停止開始日を返します。
     *
     * @return 受給停止開始日
     */
    public FlexibleDate get受給停止開始日() {
        return teishiJoho.getJukyuTeishiKaishiYMD();
    }

    /**
     * `受給停止開始日を設置します。
     *
     * @param kaishiBi 受給停止開始日
     *
     */
    public void set受給停止開始日(RString kaishiBi) {
        if (!kaishiBi.isEmpty()) {
            teishiJoho.setJukyuTeishiKaishiYMD(new FlexibleDate(kaishiBi));
        } else {
            teishiJoho.setJukyuTeishiKaishiYMD(FlexibleDate.EMPTY);
        }
    }

    /**
     * `受給停止終了日を返します。
     *
     * @return 受給停止終了日
     */
    public FlexibleDate get受給停止終了日() {
        return teishiJoho.getJukyuTeishiShuryoYMD();
    }

    /**
     * `受給停止終了日を設置します。
     *
     * @param shoryoBi 受給停止終了日
     *
     */
    public void set受給停止終了日(RString shoryoBi) {
        if (!shoryoBi.isEmpty()) {
            teishiJoho.setJukyuTeishiShuryoYMD(new FlexibleDate(shoryoBi));
        } else {
            teishiJoho.setJukyuTeishiShuryoYMD(FlexibleDate.EMPTY);
        }
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。
     *
     * @return UrT0528SeikatsuHogoTeishikikanEntity
     */
    public UrT0528SeikatsuHogoTeishikikanEntity toEntity() {
        return teishiJoho.clone();
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
     * 新しい{@link SeikatsuTeishiJoho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link SeikatsuTeishiJoho}を生成するためのビルダーです。
     */
    public static final class Builder {

        private UrT0528SeikatsuHogoTeishikikanEntity entity;

        Builder() {
            this.entity = new UrT0528SeikatsuHogoTeishikikanEntity();
        }

        Builder(SeikatsuTeishiJoho joho) {
            this.entity = joho.teishiJoho.clone();
        }

        /**
         * 受給停止開始日を設定します。
         *
         * @param jukyuteishiKaishiBi 受給停止開始日
         * @return builder
         */
        public Builder setJukyushaTeishiKaishiBi(FlexibleDate jukyuteishiKaishiBi) {
            Objects.requireNonNull(jukyuteishiKaishiBi);
            this.entity.setJukyuTeishiKaishiYMD(jukyuteishiKaishiBi);
            return this;
        }

        /**
         * 受給停止終了日を設定します。
         *
         * @param jukyuteishiShoryoBi 受給停止終了日
         * @return builder
         */
        public Builder setJukyushaTeishiShoryoBi(FlexibleDate jukyuteishiShoryoBi) {
            Objects.requireNonNull(jukyuteishiShoryoBi);
            this.entity.setJukyuTeishiShuryoYMD(jukyuteishiShoryoBi);
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
         * {@link SeikatsuTeishiJoho}を生成します。
         *
         * @return {@link SeikatsuTeishiJoho}
         */
        public SeikatsuTeishiJoho build() {
            return new SeikatsuTeishiJoho(this);
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

    private SeikatsuTeishiJoho(Builder builder) {
        this.teishiJoho = builder.entity;
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -5410154699939468062L;
        private final UrT0528SeikatsuHogoTeishikikanEntity entity;

        private _SerializationProxy(SeikatsuTeishiJoho joho) {
            this.entity = joho.teishiJoho;
        }

        private Object readResolve() {
            return new SeikatsuTeishiJoho(entity);
        }
    }
}

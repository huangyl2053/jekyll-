/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.seikatsuhogojoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.KaigoRyoDairiNofuKubun;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.KyugoShisetsuNyuTaishoKubun;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 生活保護受給者情報です。
 *
 */
public class SeikatsuJukyuShaJoho implements Serializable {

    private UrT0508SeikatsuHogoJukyushaEntity seikatsuJoho;

    private SeikatsuJukyuShaJoho() {
        seikatsuJoho = new UrT0508SeikatsuHogoJukyushaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity 生活保護受給者情報
     */
    public SeikatsuJukyuShaJoho(UrT0508SeikatsuHogoJukyushaEntity entity) {
        this.seikatsuJoho = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護受給者情報"));
    }

    /**
     * `識別コードを返します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return seikatsuJoho.getShikibetsuCode().value();
    }

    /**
     * `識別コードを設置します。
     *
     * @param shikibetsu 識別コード
     *
     */
    public void set識別コード(RString shikibetsu) {
        seikatsuJoho.setShikibetsuCode(new ShikibetsuCode(shikibetsu));
    }

    /**
     * `業務コードを返します。
     *
     * @return 業務コード
     */
    public RString get業務コード() {
        return seikatsuJoho.getGyomuCode().value();
    }

    /**
     * `業務コードを設置します。
     *
     * @param gyomuCode 業務コード
     *
     */
    public void set業務コード(RString gyomuCode) {
        seikatsuJoho.setGyomuCode(new GyomuCode(gyomuCode));
    }

    /**
     * `受給開始日を返します。
     *
     * @return 受給開始日
     */
    public FlexibleDate get受給開始日() {
        return seikatsuJoho.getJukyuKaishiYMD();
    }

    /**
     * `受給開始日を設置します。
     *
     * @param jukyukaishiBi 受給開始日
     *
     */
    public void set受給開始日(RString jukyukaishiBi) {
        seikatsuJoho.setJukyuKaishiYMD(new FlexibleDate(jukyukaishiBi));
    }

    /**
     * `受給廃止日を返します。
     *
     * @return 受給廃止日
     */
    public FlexibleDate get受給廃止日() {
        return seikatsuJoho.getJukyuHaishiYMD();
    }

    /**
     * `受給廃止日を設置します。
     *
     * @param jukyushoryoBi 受給廃止日
     *
     */
    public void set受給廃止日(RString jukyushoryoBi) {
        if (!jukyushoryoBi.isEmpty()) {
            seikatsuJoho.setJukyuHaishiYMD(new FlexibleDate(jukyushoryoBi));
        } else {
            seikatsuJoho.setJukyuHaishiYMD(FlexibleDate.EMPTY);
        }
    }

    /**
     * `受給者番号を返します。
     *
     * @return 受給者番号
     */
    public RString get受給者番号() {
        return seikatsuJoho.getJukyushaNo();
    }

    /**
     * `受給者番号を設置します。
     *
     * @param jukyushaNo 受給者番号
     *
     */
    public void set受給者番号(RString jukyushaNo) {
        seikatsuJoho.setJukyushaNo(jukyushaNo);
    }

    /**
     * `介護保険料代理納付区分を返します。
     *
     * @return 介護保険料代理納付区分
     */
    public RString get介護保険料代理納付区分() {
        if (seikatsuJoho.getKaigoRyoDairiNofuKubun() != null) {
            return seikatsuJoho.getKaigoRyoDairiNofuKubun().value().code();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * `介護保険料代理納付区分を設置します。
     *
     * @param kaigoKubun 介護保険料代理納付区分
     *
     */
    public void set介護保険料代理納付区分(KaigoRyoDairiNofuKubun kaigoKubun) {
        seikatsuJoho.setKaigoRyoDairiNofuKubun(kaigoKubun);
    }

    /**
     * `介護保険料代理納付年月を返します。
     *
     * @return 介護保険料代理納付年月
     */
    public FlexibleYearMonth get介護保険料代理納付年月() {
        return seikatsuJoho.getKaigoRyoDairiNofuYM();
    }

    /**
     * `介護保険料代理納付年月を設置します。
     *
     * @param kaigoYM 介護保険料代理納付年月
     *
     */
    public void set介護保険料代理納付年月(RString kaigoYM) {
        if (!kaigoYM.isEmpty()) {
            seikatsuJoho.setKaigoRyoDairiNofuYM(new FlexibleYearMonth(kaigoYM));
        } else {
            seikatsuJoho.setKaigoRyoDairiNofuYM(FlexibleYearMonth.EMPTY);
        }
    }

    /**
     * `救護施設入退所区分を返します。
     *
     * @return 救護施設入退所区分
     */
    public RString get救護施設入退所区分() {
        if (seikatsuJoho.getKyugoShisetsuNyuTaishoKubun() != null) {
            return seikatsuJoho.getKyugoShisetsuNyuTaishoKubun().value().code();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * `救護施設入退所区分を設置します。
     *
     * @param kyugoKubun 救護施設入退所区分
     *
     */
    public void set救護施設入退所区分(KyugoShisetsuNyuTaishoKubun kyugoKubun) {
        seikatsuJoho.setKyugoShisetsuNyuTaishoKubun(kyugoKubun);
    }

    /**
     * `救護施設入退所日を返します。
     *
     * @return 救護施設入退所日
     */
    public FlexibleDate get救護施設入退所日() {
        return seikatsuJoho.getKyugoShisetsuNyutaishoYMD();
    }

    /**
     * `救護施設入退所日を設置します。
     *
     * @param kyugoYMD 救護施設入退所日
     *
     */
    public void set救護施設入退所日(RString kyugoYMD) {
        if (!kyugoYMD.isEmpty()) {
            seikatsuJoho.setKyugoShisetsuNyutaishoYMD(new FlexibleDate(kyugoYMD));
        } else {
            seikatsuJoho.setKyugoShisetsuNyutaishoYMD(FlexibleDate.EMPTY);
        }
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。
     *
     * @return UrT0508SeikatsuHogoJukyushaEntity
     */
    public UrT0508SeikatsuHogoJukyushaEntity toEntity() {
        return seikatsuJoho.clone();
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
     * 新しい{@link SeikatsuJukyuShaJoho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link SeikatsuJukyuShaJoho}を生成するためのビルダーです。
     */
    public static final class Builder {

        private UrT0508SeikatsuHogoJukyushaEntity entity;

        Builder() {
            this.entity = new UrT0508SeikatsuHogoJukyushaEntity();
        }

        Builder(SeikatsuJukyuShaJoho joho) {
            this.entity = joho.seikatsuJoho.clone();
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
         * 受給者番号を設定します。
         *
         * @param jukyushaBangou 受給者番号
         * @return builder
         */
        public Builder setJukyushaBangou(RString jukyushaBangou) {
            Objects.requireNonNull(jukyushaBangou);
            this.entity.setJukyushaNo(jukyushaBangou);
            return this;
        }

        /**
         * 開始年月日を設定します。
         *
         * @param kaishiNengapi 開始年月日
         * @return builder
         */
        public Builder setKaishiNengapi(FlexibleDate kaishiNengapi) {
            Objects.requireNonNull(kaishiNengapi);
            this.entity.setJukyuKaishiYMD(kaishiNengapi);
            return this;
        }

        /**
         * 廃止年月日を設定します。
         *
         * @param haishiNengapi 廃止年月日
         * @return builder
         */
        public Builder setHaishiNengapi(FlexibleDate haishiNengapi) {
            Objects.requireNonNull(haishiNengapi);
            this.entity.setJukyuHaishiYMD(haishiNengapi);
            return this;
        }

        /**
         * 介護保険料代理納付区分を設定します。
         *
         * @param kaigonofuKubun 介護保険料代理納付区分
         * @return builder
         */
        public Builder setKaigonofuKubun(KaigoRyoDairiNofuKubun kaigonofuKubun) {
            Objects.requireNonNull(kaigonofuKubun);
            this.entity.setKaigoRyoDairiNofuKubun(kaigonofuKubun);
            return this;
        }

        /**
         * 介護保険料代理納付区分年月を設定します。
         *
         * @param kaigonofuKubunToshituki 介護保険料代理納付区分年月
         * @return builder
         */
        public Builder setKaigonofuKubunToshituki(FlexibleYearMonth kaigonofuKubunToshituki) {
            Objects.requireNonNull(kaigonofuKubunToshituki);
            this.entity.setKaigoRyoDairiNofuYM(kaigonofuKubunToshituki);
            return this;
        }

        /**
         * 救護施設入退所区分を設定します。
         *
         * @param kyugoshisetuKubun 救護施設入退所区分
         * @return builder
         */
        public Builder setKyugoshisetuKubun(KyugoShisetsuNyuTaishoKubun kyugoshisetuKubun) {
            Objects.requireNonNull(kyugoshisetuKubun);
            this.entity.setKyugoShisetsuNyuTaishoKubun(kyugoshisetuKubun);
            return this;
        }

        /**
         * 救護施設入退所年月日を設定します。
         *
         * @param kyugoshisetuKubunNengapi 救護施設入退所年月日
         * @return builder
         */
        public Builder setKyugoshisetuKubunNengapi(FlexibleDate kyugoshisetuKubunNengapi) {
            Objects.requireNonNull(kyugoshisetuKubunNengapi);
            this.entity.setKyugoShisetsuNyutaishoYMD(kyugoshisetuKubunNengapi);
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
         * {@link SeikatsuJukyuShaJoho}を生成します。
         *
         * @return {@link SeikatsuJukyuShaJoho}
         */
        public SeikatsuJukyuShaJoho build() {
            return new SeikatsuJukyuShaJoho(this);
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

    private SeikatsuJukyuShaJoho(Builder builder) {
        this.seikatsuJoho = builder.entity;
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -5410154699939468062L;
        private final UrT0508SeikatsuHogoJukyushaEntity entity;

        private _SerializationProxy(SeikatsuJukyuShaJoho joho) {
            this.entity = joho.seikatsuJoho;
        }

        private Object readResolve() {
            return new SeikatsuJukyuShaJoho(entity);
        }
    }
}

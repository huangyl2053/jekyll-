/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5031NinteiChosaHoshuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査報酬単価を管理するクラスです。
 *
 * @reamsid_L DBE-9999-021 dingyi
 */
public class NinteiChosaHoshuTanka
        extends ModelBase<NinteiChosaHoshuTankaIdentifier, DbT5031NinteiChosaHoshuTankaEntity, NinteiChosaHoshuTanka>
        implements Serializable {

    private static final long serialVersionUID = 7056535191774959535L;
    private final DbT5031NinteiChosaHoshuTankaEntity entity;
    private final NinteiChosaHoshuTankaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査報酬単価の新規作成時に使用します。
     *
     * @param 調査区分 調査区分
     * @param 訪問種別 訪問種別
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     */
    public NinteiChosaHoshuTanka(Code 調査区分,
            Code 訪問種別,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月) {
        requireNonNull(調査区分, UrSystemErrorMessages.値がnull.getReplacedMessage("調査区分"));
        requireNonNull(訪問種別, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問種別"));
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));
        this.entity = new DbT5031NinteiChosaHoshuTankaEntity();
        this.entity.setChosaKubun(調査区分);
        this.entity.setHomonShubetsu(訪問種別);
        this.entity.setKaishiYM(開始年月);
        this.entity.setShuryoYM(終了年月);
        this.id = new NinteiChosaHoshuTankaIdentifier(
                調査区分,
                訪問種別,
                開始年月,
                終了年月
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5031NinteiChosaHoshuTankaEntity}より{@link NinteiChosaHoshuTanka}を生成します。
     *
     * @param entity DBより取得した{@link DbT5031NinteiChosaHoshuTankaEntity}
     */
    public NinteiChosaHoshuTanka(DbT5031NinteiChosaHoshuTankaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査報酬単価"));
        this.id = new NinteiChosaHoshuTankaIdentifier(
                entity.getChosaKubun(),
                entity.getHomonShubetsu(),
                entity.getKaishiYM(),
                entity.getShuryoYM());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5031NinteiChosaHoshuTankaEntity}
     * @param id {@link NinteiChosaHoshuTankaIdentifier}
     */
    NinteiChosaHoshuTanka(
            DbT5031NinteiChosaHoshuTankaEntity entity,
            NinteiChosaHoshuTankaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 調査区分を返します。
     *
     * @return 調査区分
     */
    public Code get調査区分() {
        return entity.getChosaKubun();
    }

    /**
     * 訪問種別を返します。
     *
     * @return 訪問種別
     */
    public Code get訪問種別() {
        return entity.getHomonShubetsu();
    }

    /**
     * 開始年月を返します。
     *
     * @return 開始年月
     */
    public FlexibleYearMonth get開始年月() {
        return entity.getKaishiYM();
    }

    /**
     * 終了年月を返します。
     *
     * @return 終了年月
     */
    public FlexibleYearMonth get終了年月() {
        return entity.getShuryoYM();
    }

    /**
     * 単価を返します。
     *
     * @return 単価
     */
    public Decimal get単価() {
        return entity.getTanka();
    }

    /**
     * {@link DbT5031NinteiChosaHoshuTankaEntity}のクローンを返します。
     *
     * @return {@link DbT5031NinteiChosaHoshuTankaEntity}のクローン
     */
    @Override
    public DbT5031NinteiChosaHoshuTankaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査報酬単価の識別子{@link NinteiChosaHoshuTankaIdentifier}を返します。
     *
     * @return 認定調査報酬単価の識別子{@link NinteiChosaHoshuTankaIdentifier}
     */
    @Override
    public NinteiChosaHoshuTankaIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査報酬単価のみを変更対象とします。<br/>
     * {@link DbT5031NinteiChosaHoshuTankaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteiChosaHoshuTanka}
     */
    public NinteiChosaHoshuTanka modifiedModel() {
        DbT5031NinteiChosaHoshuTankaEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteiChosaHoshuTanka(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査報酬単価を削除対象とします。<br/>
     * {@link DbT5031NinteiChosaHoshuTankaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteiChosaHoshuTanka}
     */
    @Override
    public NinteiChosaHoshuTanka deleted() {
        DbT5031NinteiChosaHoshuTankaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteiChosaHoshuTanka(deletedEntity, id);
    }

    /**
     * {@link NinteiChosaHoshuTanka}のシリアライズ形式を提供します。
     *
     * @return {@link NinteiChosaHoshuTanka}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -3662129417481937802L;
        private final DbT5031NinteiChosaHoshuTankaEntity entity;
        private final NinteiChosaHoshuTankaIdentifier id;

        private _SerializationProxy(DbT5031NinteiChosaHoshuTankaEntity entity, NinteiChosaHoshuTankaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteiChosaHoshuTanka(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteiChosaHoshuTankaBuilder createBuilderForEdit() {
        return new NinteiChosaHoshuTankaBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.entity);
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
        final NinteiChosaHoshuTanka other = (NinteiChosaHoshuTanka) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

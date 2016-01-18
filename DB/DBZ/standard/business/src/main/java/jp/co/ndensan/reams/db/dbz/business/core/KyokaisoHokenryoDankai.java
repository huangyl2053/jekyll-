/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 境界層保険料段階を管理するクラスです。
 */
public class KyokaisoHokenryoDankai extends
        ModelBase<KyokaisoHokenryoDankaiIdentifier, DbT1007KyokaisoHokenryoDankaiEntity, KyokaisoHokenryoDankai>
        implements Serializable {

    private final DbT1007KyokaisoHokenryoDankaiEntity entity;
    private final KyokaisoHokenryoDankaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 境界層保険料段階の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 適用開始年月 適用開始年月
     */
    public KyokaisoHokenryoDankai(HihokenshaNo 被保険者番号,
            Decimal 履歴番号,
            FlexibleYearMonth 適用開始年月) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        this.entity = new DbT1007KyokaisoHokenryoDankaiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setTekiyoKaishiYM(適用開始年月);
        this.id = new KyokaisoHokenryoDankaiIdentifier(
                被保険者番号,
                履歴番号,
                適用開始年月
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1007KyokaisoHokenryoDankaiEntity}より{@link KyokaisoHokenryoDankai}を生成します。
     *
     * @param entity DBより取得した{@link DbT1007KyokaisoHokenryoDankaiEntity}
     */
    public KyokaisoHokenryoDankai(DbT1007KyokaisoHokenryoDankaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層保険料段階"));
        this.id = new KyokaisoHokenryoDankaiIdentifier(
                entity.getHihokenshaNo(),
                entity.getRirekiNo(),
                entity.getTekiyoKaishiYM()
        );
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1007KyokaisoHokenryoDankaiEntity}
     * @param id {@link KyokaisoHokenryoDankaiIdentifier}
     */
    KyokaisoHokenryoDankai(
            DbT1007KyokaisoHokenryoDankaiEntity entity,
            KyokaisoHokenryoDankaiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 適用開始年月を返します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.getTekiyoKaishiYM();
    }

    /**
     * 適用終了年月を返します。
     *
     * @return 適用終了年月
     */
    public FlexibleYearMonth get適用終了年月() {
        return entity.getTekiyoShuryoYM();
    }

    /**
     * 保険料納付減額後保険料段階を返します。
     *
     * @return 保険料納付減額後保険料段階
     */
    public RString get保険料納付減額後保険料段階() {
        return entity.getGengakuGoHokenryoDankai();
    }

    /**
     * {@link DbT1007KyokaisoHokenryoDankaiEntity}のクローンを返します。
     *
     * @return {@link DbT1007KyokaisoHokenryoDankaiEntity}のクローン
     */
    @Override
    public DbT1007KyokaisoHokenryoDankaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 境界層保険料段階の識別子{@link KyokaisoHokenryoDankaiIdentifier}を返します。
     *
     * @return 境界層保険料段階の識別子{@link KyokaisoHokenryoDankaiIdentifier}
     */
    @Override
    public KyokaisoHokenryoDankaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する境界層保険料段階を削除対象とします。<br/>
     * {@link DbT1007KyokaisoHokenryoDankaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyokaisoHokenryoDankai}
     */
    @Override
    public KyokaisoHokenryoDankai deleted() {
        DbT1007KyokaisoHokenryoDankaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyokaisoHokenryoDankai(deletedEntity, id);
    }

    /**
     * {@link KyokaisoHokenryoDankai}のシリアライズ形式を提供します。
     *
     * @return {@link KyokaisoHokenryoDankai}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    /**
     * 境界層保険料段階のみを変更対象とします。<br/>
     * {@link DbT1007KyokaisoHokenryoDankaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyokaisoHokenryoDankai}
     */
    public KyokaisoHokenryoDankai modifiedModel() {
        DbT1007KyokaisoHokenryoDankaiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyokaisoHokenryoDankai(
                modifiedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1696408535895799895L;
        private final DbT1007KyokaisoHokenryoDankaiEntity entity;
        private final KyokaisoHokenryoDankaiIdentifier id;

        private _SerializationProxy(DbT1007KyokaisoHokenryoDankaiEntity entity, KyokaisoHokenryoDankaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyokaisoHokenryoDankai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyokaisoHokenryoDankaiBuilder createBuilderForEdit() {
        return new KyokaisoHokenryoDankaiBuilder(entity, id);
    }
}

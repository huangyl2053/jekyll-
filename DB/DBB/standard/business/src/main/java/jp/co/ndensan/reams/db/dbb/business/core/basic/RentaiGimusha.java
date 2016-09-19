/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 連帯納付義務者を管理するクラスです。
 */
public class RentaiGimusha extends ModelBase<RentaiGimushaIdentifier, DbT2009RentaiGimushaEntity, RentaiGimusha> implements Serializable {

    private final DbT2009RentaiGimushaEntity entity;
    private final RentaiGimushaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 連帯納付義務者の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public RentaiGimusha(HihokenshaNo 被保険者番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT2009RentaiGimushaEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new RentaiGimushaIdentifier(
                被保険者番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2009RentaiGimushaEntity}より{@link RentaiGimusha}を生成します。
     *
     * @param entity DBより取得した{@link DbT2009RentaiGimushaEntity}
     */
    public RentaiGimusha(DbT2009RentaiGimushaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("連帯納付義務者"));
        this.id = new RentaiGimushaIdentifier(
                entity.getHihokenshaNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2009RentaiGimushaEntity}
     * @param id {@link RentaiGimushaIdentifier}
     */
    RentaiGimusha(
            DbT2009RentaiGimushaEntity entity,
            RentaiGimushaIdentifier id
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetuCode();
    }

    /**
     * 開始年月日を返します。
     *
     * @return 開始年月日
     */
    public FlexibleDate get開始年月日() {
        return entity.getStartYMD();
    }

    /**
     * 終了年月日を返します。
     *
     * @return 終了年月日
     */
    public FlexibleDate get終了年月日() {
        return entity.getEndYMD();
    }

    /**
     * {@link DbT2009RentaiGimushaEntity}のクローンを返します。
     *
     * @return {@link DbT2009RentaiGimushaEntity}のクローン
     */
    @Override
    public DbT2009RentaiGimushaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 連帯納付義務者の識別子{@link RentaiGimushaIdentifier}を返します。
     *
     * @return 連帯納付義務者の識別子{@link RentaiGimushaIdentifier}
     */
    @Override
    public RentaiGimushaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する連帯納付義務者を削除対象とします。<br/>
     * {@link DbT2009RentaiGimushaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RentaiGimusha}
     */
    @Override
    public RentaiGimusha deleted() {
        DbT2009RentaiGimushaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RentaiGimusha(deletedEntity, id);
    }

    /**
     * 保持する利用者負担割合を追加対象とします。
     * <br/> {@link DbT2009RentaiGimushaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば追加状態にします。
     *
     * @return 追加対象処理実施後の{@link RiyoshaFutanWariai}
     */
    public RentaiGimusha added() {
        DbT2009RentaiGimushaEntity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        return new RentaiGimusha(addedEntity, id);
    }

    /**
     * 保持する利用者負担割合を追加対象とします。
     * <br/> {@link DbT2009RentaiGimushaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば修正状態にします。
     *
     * @return 修正対象処理実施後の{@link RiyoshaFutanWariai}
     */
    public RentaiGimusha modified() {
        DbT2009RentaiGimushaEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        return new RentaiGimusha(modifiedEntity, id);
    }

    /**
     * {@link RentaiGimusha}のシリアライズ形式を提供します。
     *
     * @return {@link RentaiGimusha}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT2009RentaiGimushaEntity entity;
        private final RentaiGimushaIdentifier id;

        private _SerializationProxy(DbT2009RentaiGimushaEntity entity, RentaiGimushaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new RentaiGimusha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RentaiGimushaBuilder createBuilderForEdit() {
        return new RentaiGimushaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

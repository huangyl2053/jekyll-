/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.basic.SogoJigyoTaishoshaIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 総合事業対象者を管理するクラスです。
 */
public class SogoJigyoTaishosha
        extends ModelBase<SogoJigyoTaishoshaIdentifier, DbT3105SogoJigyoTaishoshaEntity, SogoJigyoTaishosha> implements Serializable {

    private final DbT3105SogoJigyoTaishoshaEntity entity;
    private final SogoJigyoTaishoshaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 総合事業対象者の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public SogoJigyoTaishosha(
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3105SogoJigyoTaishoshaEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new SogoJigyoTaishoshaIdentifier(
                被保険者番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3105SogoJigyoTaishoshaEntity}より{@link SogoJigyoTaishosha}を生成します。
     *
     * @param entity DBより取得した{@link DbT3105SogoJigyoTaishoshaEntity}
     */
    public SogoJigyoTaishosha(DbT3105SogoJigyoTaishoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("総合事業対象者"));
        this.id = new SogoJigyoTaishoshaIdentifier(
                entity.getHihokenshaNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3105SogoJigyoTaishoshaEntity}
     * @param id {@link SogoJigyoTaishoshaIdentifier}
     */
    SogoJigyoTaishosha(
            DbT3105SogoJigyoTaishoshaEntity entity,
            SogoJigyoTaishoshaIdentifier id
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
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
    }

    /**
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
    }

    /**
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * {@link DbT3105SogoJigyoTaishoshaEntity}のクローンを返します。
     *
     * @return {@link DbT3105SogoJigyoTaishoshaEntity}のクローン
     */
    @Override
    public DbT3105SogoJigyoTaishoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 総合事業対象者の識別子{@link SogoJigyoTaishoshaIdentifier}を返します。
     *
     * @return 総合事業対象者の識別子{@link SogoJigyoTaishoshaIdentifier}
     */
    @Override
    public SogoJigyoTaishoshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する総合事業対象者を削除対象とします。<br/>
     * {@link DbT3105SogoJigyoTaishoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SogoJigyoTaishosha}
     */
    @Override
    public SogoJigyoTaishosha deleted() {
        DbT3105SogoJigyoTaishoshaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SogoJigyoTaishosha(deletedEntity, id);
    }

    /**
     * {@link SogoJigyoTaishosha}のシリアライズ形式を提供します。
     *
     * @return {@link SogoJigyoTaishosha}のシリアライズ形式
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

        private final DbT3105SogoJigyoTaishoshaEntity entity;
        private final SogoJigyoTaishoshaIdentifier id;

        private _SerializationProxy(DbT3105SogoJigyoTaishoshaEntity entity, SogoJigyoTaishoshaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new SogoJigyoTaishosha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SogoJigyoTaishoshaBuilder createBuilderForEdit() {
        return new SogoJigyoTaishoshaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

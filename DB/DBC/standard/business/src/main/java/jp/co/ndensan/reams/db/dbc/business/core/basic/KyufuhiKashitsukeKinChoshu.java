/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3092KyufuhiKashitsukeKinChoshuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金徴収を管理するクラスです。
 */
public class KyufuhiKashitsukeKinChoshu extends ModelBase<KyufuhiKashitsukeKinChoshuIdentifier, DbT3092KyufuhiKashitsukeKinChoshuEntity, KyufuhiKashitsukeKinChoshu> implements Serializable {

    private final DbT3092KyufuhiKashitsukeKinChoshuEntity entity;
    private final KyufuhiKashitsukeKinChoshuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付費貸付金徴収の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 貸付管理番号 貸付管理番号
     * @param 履歴番号 履歴番号
     */
    public KyufuhiKashitsukeKinChoshu(HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3092KyufuhiKashitsukeKinChoshuEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKashitsukeKanriNo(貸付管理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyufuhiKashitsukeKinChoshuIdentifier(
                被保険者番号,
                貸付管理番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3092KyufuhiKashitsukeKinChoshuEntity}より{@link KyufuhiKashitsukeKinChoshu}を生成します。
     *
     * @param entity DBより取得した{@link DbT3092KyufuhiKashitsukeKinChoshuEntity}
     */
    public KyufuhiKashitsukeKinChoshu(DbT3092KyufuhiKashitsukeKinChoshuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金徴収"));
        this.id = new KyufuhiKashitsukeKinChoshuIdentifier(
                entity.getHihokenshaNo(),
                entity.getKashitsukeKanriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3092KyufuhiKashitsukeKinChoshuEntity}
     * @param id {@link KyufuhiKashitsukeKinChoshuIdentifier}
     */
    KyufuhiKashitsukeKinChoshu(
            DbT3092KyufuhiKashitsukeKinChoshuEntity entity,
            KyufuhiKashitsukeKinChoshuIdentifier id
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
     * 貸付管理番号を返します。
     *
     * @return 貸付管理番号
     */
    public RString get貸付管理番号() {
        return entity.getKashitsukeKanriNo();
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
     * 貸付金返還徴収方法を返します。
     *
     * @return 貸付金返還徴収方法
     */
    public RString get貸付金返還徴収方法() {
        return entity.getHenkanChoshuHoho();
    }

    /**
     * 貸付金返還徴収年月日を返します。
     *
     * @return 貸付金返還徴収年月日
     */
    public FlexibleDate get貸付金返還徴収年月日() {
        return entity.getHenkanChoshuYMD();
    }

    /**
     * 貸付金返還徴収金額を返します。
     *
     * @return 貸付金返還徴収金額
     */
    public Decimal get貸付金返還徴収金額() {
        return entity.getHenkanChoshuKingaku();
    }

    /**
     * 過不足判定結果区分を返します。
     *
     * @return 過不足判定結果区分
     */
    public RString get過不足判定結果区分() {
        return entity.getKabusokuHanteiKekkaKubun();
    }

    /**
     * {@link DbT3092KyufuhiKashitsukeKinChoshuEntity}のクローンを返します。
     *
     * @return {@link DbT3092KyufuhiKashitsukeKinChoshuEntity}のクローン
     */
    @Override
    public DbT3092KyufuhiKashitsukeKinChoshuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付費貸付金徴収の識別子{@link KyufuhiKashitsukeKinChoshuIdentifier}を返します。
     *
     * @return 給付費貸付金徴収の識別子{@link KyufuhiKashitsukeKinChoshuIdentifier}
     */
    @Override
    public KyufuhiKashitsukeKinChoshuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付費貸付金徴収を削除対象とします。<br/>
     * {@link DbT3092KyufuhiKashitsukeKinChoshuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufuhiKashitsukeKinChoshu}
     */
    @Override
    public KyufuhiKashitsukeKinChoshu deleted() {
        DbT3092KyufuhiKashitsukeKinChoshuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufuhiKashitsukeKinChoshu(deletedEntity, id);
    }

    /**
     * {@link KyufuhiKashitsukeKinChoshu}のシリアライズ形式を提供します。
     *
     * @return {@link KyufuhiKashitsukeKinChoshu}のシリアライズ形式
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

        private final DbT3092KyufuhiKashitsukeKinChoshuEntity entity;
        private final KyufuhiKashitsukeKinChoshuIdentifier id;

        private _SerializationProxy(DbT3092KyufuhiKashitsukeKinChoshuEntity entity, KyufuhiKashitsukeKinChoshuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufuhiKashitsukeKinChoshu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufuhiKashitsukeKinChoshuBuilder createBuilderForEdit() {
        return new KyufuhiKashitsukeKinChoshuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

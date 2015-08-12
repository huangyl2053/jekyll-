/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金延滞利息計算を管理するクラスです。
 */
public class KyufuhiKashitsukekinEntaiRisokuKeisan extends ModelBase<KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier, DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity, KyufuhiKashitsukekinEntaiRisokuKeisan> implements Serializable {

    private final DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity;
    private final KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付費貸付金延滞利息計算の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 貸付管理番号 貸付管理番号
     * @param 履歴番号 履歴番号
     */
    public KyufuhiKashitsukekinEntaiRisokuKeisan(HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKashitsukeKanriNo(貸付管理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier(
                被保険者番号,
                貸付管理番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity}より{@link KyufuhiKashitsukekinEntaiRisokuKeisan}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity}
     */
    public KyufuhiKashitsukekinEntaiRisokuKeisan(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金延滞利息計算"));
        this.id = new KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier(
                entity.getHihokenshaNo(),
                entity.getKashitsukeKanriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity}
     * @param id {@link KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier}
     */
    KyufuhiKashitsukekinEntaiRisokuKeisan(
            DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity,
            KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier id
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
     * 貸付金延滞日数を返します。
     *
     * @return 貸付金延滞日数
     */
    public RString get貸付金延滞日数() {
        return entity.getEntaiNissu();
    }

    /**
     * 貸付金延滞利息金額を返します。
     *
     * @return 貸付金延滞利息金額
     */
    public Decimal get貸付金延滞利息金額() {
        return entity.getEntaiRisokuKingaku();
    }

    /**
     * {@link DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity}のクローンを返します。
     *
     * @return {@link DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity}のクローン
     */
    @Override
    public DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付費貸付金延滞利息計算の識別子{@link KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier}を返します。
     *
     * @return
     * 給付費貸付金延滞利息計算の識別子{@link KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier}
     */
    @Override
    public KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付費貸付金延滞利息計算を削除対象とします。<br/>
     * {@link DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufuhiKashitsukekinEntaiRisokuKeisan}
     */
    @Override
    public KyufuhiKashitsukekinEntaiRisokuKeisan deleted() {
        DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufuhiKashitsukekinEntaiRisokuKeisan(deletedEntity, id);
    }

    /**
     * {@link KyufuhiKashitsukekinEntaiRisokuKeisan}のシリアライズ形式を提供します。
     *
     * @return {@link KyufuhiKashitsukekinEntaiRisokuKeisan}のシリアライズ形式
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

        private final DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity;
        private final KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier id;

        private _SerializationProxy(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity, KyufuhiKashitsukekinEntaiRisokuKeisanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufuhiKashitsukekinEntaiRisokuKeisan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufuhiKashitsukekinEntaiRisokuKeisanBuilder createBuilderForEdit() {
        return new KyufuhiKashitsukekinEntaiRisokuKeisanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

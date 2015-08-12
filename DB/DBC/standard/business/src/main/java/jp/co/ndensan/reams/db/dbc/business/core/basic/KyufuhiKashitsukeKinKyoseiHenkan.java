/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.IModel;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.Models;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.dbc.DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金強制返還を管理するクラスです。
 */
public class KyufuhiKashitsukeKinKyoseiHenkan extends ParentModelBase<KyufuhiKashitsukeKinKyoseiHenkanIdentifier, DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity, KyufuhiKashitsukeKinKyoseiHenkan> implements Serializable {

    private final DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity;
    private final KyufuhiKashitsukeKinKyoseiHenkanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付費貸付金強制返還の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 貸付管理番号 貸付管理番号
     * @param 履歴番号 履歴番号
     */
    public KyufuhiKashitsukeKinKyoseiHenkan(HihokenshaNo 被保険者番号,
RString 貸付管理番号,
Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKashitsukeKanriNo(貸付管理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyufuhiKashitsukeKinKyoseiHenkanIdentifier(
        被保険者番号,
        貸付管理番号,
        履歴番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}より{@link KyufuhiKashitsukeKinKyoseiHenkan}を生成します。
     *
     * @param entity DBより取得した{@link DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}
     */
    public KyufuhiKashitsukeKinKyoseiHenkan(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金強制返還"));
        this.id = new KyufuhiKashitsukeKinKyoseiHenkanIdentifier(
                entity.getHihokenshaNo(),
                entity.getKashitsukeKanriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}
     * @param id {@link KyufuhiKashitsukeKinKyoseiHenkanIdentifier}
     */
    KyufuhiKashitsukeKinKyoseiHenkan(
            DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity,
            KyufuhiKashitsukeKinKyoseiHenkanIdentifier id
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
     * 返還金区分を返します。
     *
     * @return 返還金区分
     */
    public RString get返還金区分() {
        return entity.getHenkanKinKubun();
    }

    /**
     * 返還金額を返します。
     *
     * @return 返還金額
     */
    public Decimal get返還金額() {
        return entity.getHenkanKingaku();
    }

    /**
     * 返還期限を返します。
     *
     * @return 返還期限
     */
    public FlexibleDate get返還期限() {
        return entity.getHenkanKigenYMD();
    }

    /**
     * 返還理由を返します。
     *
     * @return 返還理由
     */
    public RString get返還理由() {
        return entity.getHenkanRiyu();
    }

    /**
     * {@link DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}のクローンを返します。
     *
     * @return {@link DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}のクローン
     */
    @Override
    public DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付費貸付金強制返還の識別子{@link KyufuhiKashitsukeKinKyoseiHenkanIdentifier}を返します。
     *
     * @return 給付費貸付金強制返還の識別子{@link KyufuhiKashitsukeKinKyoseiHenkanIdentifier}
     */
    @Override
    public KyufuhiKashitsukeKinKyoseiHenkanIdentifier identifier() {
        return this.id;
    }

    /**
     * 給付費貸付金強制返還のみを変更対象とします。<br/>
     * {@link DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyufuhiKashitsukeKinKyoseiHenkan}
     */
    @Override
    public KyufuhiKashitsukeKinKyoseiHenkan modifiedModel() {
        DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyufuhiKashitsukeKinKyoseiHenkan(
                modifiedEntity, id);
    }

    /**
     * 保持する給付費貸付金強制返還を削除対象とします。<br/>
     * {@link DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufuhiKashitsukeKinKyoseiHenkan}
     */
    @Override
    public KyufuhiKashitsukeKinKyoseiHenkan deleted() {
        DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufuhiKashitsukeKinKyoseiHenkan(deletedEntity, id);
    }
    /**
     * {@link KyufuhiKashitsukeKinKyoseiHenkan}のシリアライズ形式を提供します。
     *
     * @return {@link KyufuhiKashitsukeKinKyoseiHenkan}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity;
        private final KyufuhiKashitsukeKinKyoseiHenkanIdentifier id;

        private _SerializationProxy(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity,KyufuhiKashitsukeKinKyoseiHenkanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufuhiKashitsukeKinKyoseiHenkan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufuhiKashitsukeKinKyoseiHenkanBuilder createBuilderForEdit() {
        return new KyufuhiKashitsukeKinKyoseiHenkanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

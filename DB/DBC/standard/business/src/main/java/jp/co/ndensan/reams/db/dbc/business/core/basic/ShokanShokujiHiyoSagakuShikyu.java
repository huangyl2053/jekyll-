/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3044ShokanShokujiHiyoSagakuShikyuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求食事費用差額支給を管理するクラスです。
 */
public class ShokanShokujiHiyoSagakuShikyu 
extends ModelBase<ShokanShokujiHiyoSagakuShikyuIdentifier, 
        DbT3044ShokanShokujiHiyoSagakuShikyuEntity, 
        ShokanShokujiHiyoSagakuShikyu> implements Serializable {

    private final DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity;
    private final ShokanShokujiHiyoSagakuShikyuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求食事費用差額支給の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 履歴番号 履歴番号
     */
    public ShokanShokujiHiyoSagakuShikyu(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3044ShokanShokujiHiyoSagakuShikyuEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNp(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShokanShokujiHiyoSagakuShikyuIdentifier(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3044ShokanShokujiHiyoSagakuShikyuEntity}より{@link ShokanShokujiHiyoSagakuShikyu}を生成します。
     *
     * @param entity DBより取得した{@link DbT3044ShokanShokujiHiyoSagakuShikyuEntity}
     */
    public ShokanShokujiHiyoSagakuShikyu(DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求食事費用差額支給"));
        this.id = new ShokanShokujiHiyoSagakuShikyuIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNp(),
                entity.getJigyoshaNo(),
                entity.getYoshikiNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3044ShokanShokujiHiyoSagakuShikyuEntity}
     * @param id {@link ShokanShokujiHiyoSagakuShikyuIdentifier}
     */
    ShokanShokujiHiyoSagakuShikyu(
            DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity,
            ShokanShokujiHiyoSagakuShikyuIdentifier id
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
        return entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNp();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 様式番号を返します。
     *
     * @return 様式番号
     */
    public RString get様式番号() {
        return entity.getYoshikiNo();
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
     * 差額金額を返します。
     *
     * @return 差額金額
     */
    public int get差額金額() {
        return entity.getSagakuKingaku();
    }

    /**
     * 支給区分コードを返します。
     *
     * @return 支給区分コード
     */
    public RString get支給区分コード() {
        return entity.getShikyuKubunCode();
    }

    /**
     * 点数_金額を返します。
     *
     * @return 点数_金額
     */
    public int get点数_金額() {
        return entity.getTensuKingaku();
    }

    /**
     * 支給金額を返します。
     *
     * @return 支給金額
     */
    public int get支給金額() {
        return entity.getShikyuKingaku();
    }

    /**
     * 支給_不支給理由を返します。
     *
     * @return 支給_不支給理由
     */
    public RString get支給_不支給理由() {
        return entity.getShikyuFushikyuRiyu();
    }

    /**
     * {@link DbT3044ShokanShokujiHiyoSagakuShikyuEntity}のクローンを返します。
     *
     * @return {@link DbT3044ShokanShokujiHiyoSagakuShikyuEntity}のクローン
     */
    @Override
    public DbT3044ShokanShokujiHiyoSagakuShikyuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求食事費用差額支給の識別子{@link ShokanShokujiHiyoSagakuShikyuIdentifier}を返します。
     *
     * @return 償還払請求食事費用差額支給の識別子{@link ShokanShokujiHiyoSagakuShikyuIdentifier}
     */
    @Override
    public ShokanShokujiHiyoSagakuShikyuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払請求食事費用差額支給を削除対象とします。<br/>
     * {@link DbT3044ShokanShokujiHiyoSagakuShikyuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanShokujiHiyoSagakuShikyu}
     */
    @Override
    public ShokanShokujiHiyoSagakuShikyu deleted() {
        DbT3044ShokanShokujiHiyoSagakuShikyuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanShokujiHiyoSagakuShikyu(deletedEntity, id);
    }

    /**
     * {@link ShokanShokujiHiyoSagakuShikyu}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanShokujiHiyoSagakuShikyu}のシリアライズ形式
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

        private final DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity;
        private final ShokanShokujiHiyoSagakuShikyuIdentifier id;

        private _SerializationProxy(DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity, ShokanShokujiHiyoSagakuShikyuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanShokujiHiyoSagakuShikyu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanShokujiHiyoSagakuShikyuBuilder createBuilderForEdit() {
        return new ShokanShokujiHiyoSagakuShikyuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

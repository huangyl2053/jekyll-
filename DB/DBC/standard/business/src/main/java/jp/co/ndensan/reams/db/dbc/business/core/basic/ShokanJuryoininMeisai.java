/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3037ShokanJuryoininMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給受領委任払明細を管理するクラスです。
 */
public class ShokanJuryoininMeisai extends ModelBase<ShokanJuryoininMeisaiIdentifier, DbT3037ShokanJuryoininMeisaiEntity, ShokanJuryoininMeisai> implements Serializable {

    private final DbT3037ShokanJuryoininMeisaiEntity entity;
    private final ShokanJuryoininMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払支給受領委任払明細の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 履歴番号 履歴番号
     */
    public ShokanJuryoininMeisai(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3037ShokanJuryoininMeisaiEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShokanJuryoininMeisaiIdentifier(
                被保険者番号,
                サービス提供年月,
                整理番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3037ShokanJuryoininMeisaiEntity}より{@link ShokanJuryoininMeisai}を生成します。
     *
     * @param entity DBより取得した{@link DbT3037ShokanJuryoininMeisaiEntity}
     */
    public ShokanJuryoininMeisai(DbT3037ShokanJuryoininMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給受領委任払明細"));
        this.id = new ShokanJuryoininMeisaiIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3037ShokanJuryoininMeisaiEntity}
     * @param id {@link ShokanJuryoininMeisaiIdentifier}
     */
    ShokanJuryoininMeisai(
            DbT3037ShokanJuryoininMeisaiEntity entity,
            ShokanJuryoininMeisaiIdentifier id
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
        return entity.getSeiriNo();
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
     * 契約番号を返します。
     *
     * @return 契約番号
     */
    public RString get契約番号() {
        return entity.getKeiyakuNo();
    }

    /**
     * 支払金額を返します。
     *
     * @return 支払金額
     */
    public Decimal get支払金額() {
        return entity.getShiharaiKingaku();
    }

    /**
     * {@link DbT3037ShokanJuryoininMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3037ShokanJuryoininMeisaiEntity}のクローン
     */
    @Override
    public DbT3037ShokanJuryoininMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払支給受領委任払明細の識別子{@link ShokanJuryoininMeisaiIdentifier}を返します。
     *
     * @return 償還払支給受領委任払明細の識別子{@link ShokanJuryoininMeisaiIdentifier}
     */
    @Override
    public ShokanJuryoininMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払支給受領委任払明細を削除対象とします。<br/>
     * {@link DbT3037ShokanJuryoininMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanJuryoininMeisai}
     */
    @Override
    public ShokanJuryoininMeisai deleted() {
        DbT3037ShokanJuryoininMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanJuryoininMeisai(deletedEntity, id);
    }

    /**
     * {@link ShokanJuryoininMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanJuryoininMeisai}のシリアライズ形式
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

        private final DbT3037ShokanJuryoininMeisaiEntity entity;
        private final ShokanJuryoininMeisaiIdentifier id;

        private _SerializationProxy(DbT3037ShokanJuryoininMeisaiEntity entity, ShokanJuryoininMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanJuryoininMeisai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanJuryoininMeisaiBuilder createBuilderForEdit() {
        return new ShokanJuryoininMeisaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

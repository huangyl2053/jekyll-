/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 事業高額介護サービス費給付対象者合計を管理するクラスです。
 */
public class JigyoKogakuKyufuTaishoshaGokei extends ModelBase<JigyoKogakuKyufuTaishoshaGokeiIdentifier, DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity, JigyoKogakuKyufuTaishoshaGokei> implements Serializable {

    private final DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity entity;
    private final JigyoKogakuKyufuTaishoshaGokeiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 事業高額介護サービス費給付対象者合計の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 履歴番号 履歴番号
     */
    public JigyoKogakuKyufuTaishoshaGokei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new JigyoKogakuKyufuTaishoshaGokeiIdentifier(
                被保険者番号,
                サービス提供年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity}より{@link JigyoKogakuKyufuTaishoshaGokei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity}
     */
    public JigyoKogakuKyufuTaishoshaGokei(DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費給付対象者合計"));
        this.id = new JigyoKogakuKyufuTaishoshaGokeiIdentifier(
                entity.getHihokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity}
     * @param id {@link JigyoKogakuKyufuTaishoshaGokeiIdentifier}
     */
    JigyoKogakuKyufuTaishoshaGokei(
            DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity entity,
            JigyoKogakuKyufuTaishoshaGokeiIdentifier id
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
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
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
     * サービス費用合計額合計を返します。
     *
     * @return サービス費用合計額合計
     */
    public Decimal getサービス費用合計額合計() {
        return entity.getServiceHiyoGokeiGakuGokei();
    }

    /**
     * 利用者負担額合計を返します。
     *
     * @return 利用者負担額合計
     */
    public Decimal get利用者負担額合計() {
        return entity.getRiyoshaFutanGakuGokei();
    }

    /**
     * 算定基準額を返します。
     *
     * @return 算定基準額
     */
    public Decimal get算定基準額() {
        return entity.getSanteiKijunGaku();
    }

    /**
     * 支払済金額合計を返します。
     *
     * @return 支払済金額合計
     */
    public Decimal get支払済金額合計() {
        return entity.getShiharaiSumiKingakuGokei();
    }

    /**
     * 事業高額支給額を返します。
     *
     * @return 事業高額支給額
     */
    public Decimal get事業高額支給額() {
        return entity.getJigyoKogakuShikyuGaku();
    }

    /**
     * 対象者受取年月を返します。
     *
     * @return 対象者受取年月
     */
    public FlexibleYearMonth get対象者受取年月() {
        return entity.getTashoshaUketoriYM();
    }

    /**
     * 対象者判定審査年月を返します。
     *
     * @return 対象者判定審査年月
     */
    public FlexibleYearMonth get対象者判定審査年月() {
        return entity.getTaishoshaHanteiShinsaYM();
    }

    /**
     * 世帯集約番号を返します。
     *
     * @return 世帯集約番号
     */
    public RString get世帯集約番号() {
        return entity.getSetaiShuyakuNo();
    }

    /**
     * 境界層対象者フラグを返します。
     *
     * @return 境界層対象者フラグ
     */
    public boolean get境界層対象者フラグ() {
        return entity.getKyokaisoTaishoshaFlag();
    }

    /**
     * 社会福祉法人軽減対象フラグを返します。
     *
     * @return 社会福祉法人軽減対象フラグ
     */
    public boolean get社会福祉法人軽減対象フラグ() {
        return entity.getHojinKeigenTaishoFlag();
    }

    /**
     * 高額対象外フラグを返します。
     *
     * @return 高額対象外フラグ
     */
    public boolean get高額対象外フラグ() {
        return entity.getKogakuTaishoGaiFlag();
    }

    /**
     * 自動償還対象フラグを返します。
     *
     * @return 自動償還対象フラグ
     */
    public boolean get自動償還対象フラグ() {
        return entity.getJidoShokanTaishoFlag();
    }

    /**
     * {@link DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity}のクローンを返します。
     *
     * @return {@link DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity}のクローン
     */
    @Override
    public DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 事業高額介護サービス費給付対象者合計の識別子{@link JigyoKogakuKyufuTaishoshaGokeiIdentifier}を返します。
     *
     * @return
     * 事業高額介護サービス費給付対象者合計の識別子{@link JigyoKogakuKyufuTaishoshaGokeiIdentifier}
     */
    @Override
    public JigyoKogakuKyufuTaishoshaGokeiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する事業高額介護サービス費給付対象者合計を削除対象とします。<br/>
     * {@link DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JigyoKogakuKyufuTaishoshaGokei}
     */
    @Override
    public JigyoKogakuKyufuTaishoshaGokei deleted() {
        DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JigyoKogakuKyufuTaishoshaGokei(deletedEntity, id);
    }

    /**
     * {@link JigyoKogakuKyufuTaishoshaGokei}のシリアライズ形式を提供します。
     *
     * @return {@link JigyoKogakuKyufuTaishoshaGokei}のシリアライズ形式
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

        private final DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity entity;
        private final JigyoKogakuKyufuTaishoshaGokeiIdentifier id;

        private _SerializationProxy(DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity entity, JigyoKogakuKyufuTaishoshaGokeiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JigyoKogakuKyufuTaishoshaGokei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JigyoKogakuKyufuTaishoshaGokeiBuilder createBuilderForEdit() {
        return new JigyoKogakuKyufuTaishoshaGokeiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

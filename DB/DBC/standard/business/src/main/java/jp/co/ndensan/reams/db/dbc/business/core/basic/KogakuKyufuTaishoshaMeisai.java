/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額介護サービス費給付対象者明細を管理するクラスです。
 *
 * @reamsid_L DBC-9999-040 quxiaodong
 */
public class KogakuKyufuTaishoshaMeisai
        extends ModelBase<KogakuKyufuTaishoshaMeisaiIdentifier, DbT3054KogakuKyufuTaishoshaMeisaiEntity, KogakuKyufuTaishoshaMeisai>
        implements Serializable {

    private final DbT3054KogakuKyufuTaishoshaMeisaiEntity entity;
    private final KogakuKyufuTaishoshaMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 高額介護サービス費給付対象者明細の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業者番号 事業者番号
     * @param サービス種類コード サービス種類コード
     * @param 履歴番号 履歴番号
     */
    public KogakuKyufuTaishoshaMeisai(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業者番号,
            ServiceShuruiCode サービス種類コード,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3054KogakuKyufuTaishoshaMeisaiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KogakuKyufuTaishoshaMeisaiIdentifier(
                被保険者番号,
                サービス提供年月,
                事業者番号,
                サービス種類コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3054KogakuKyufuTaishoshaMeisaiEntity}より{@link KogakuKyufuTaishoshaMeisai}を生成します。
     *
     * @param entity DBより取得した{@link DbT3054KogakuKyufuTaishoshaMeisaiEntity}
     */
    public KogakuKyufuTaishoshaMeisai(DbT3054KogakuKyufuTaishoshaMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費給付対象者明細"));
        this.id = new KogakuKyufuTaishoshaMeisaiIdentifier(
                entity.getHihokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshaNo(),
                entity.getServiceShuruiCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3054KogakuKyufuTaishoshaMeisaiEntity}
     * @param id {@link KogakuKyufuTaishoshaMeisaiIdentifier}
     */
    KogakuKyufuTaishoshaMeisai(
            DbT3054KogakuKyufuTaishoshaMeisaiEntity entity,
            KogakuKyufuTaishoshaMeisaiIdentifier id
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
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
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
     * サービス費用合計額を返します。
     *
     * @return サービス費用合計額
     */
    public Decimal getサービス費用合計額() {
        return entity.getServiceHiyoGokeiGaku();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public Decimal get利用者負担額() {
        return entity.getRiyoshaFutanGaku();
    }

    /**
     * 高額給付根拠を返します。
     *
     * @return 高額給付根拠
     */
    public RString get高額給付根拠() {
        return entity.getKogakuKyufuKonkyo();
    }

    /**
     * {@link DbT3054KogakuKyufuTaishoshaMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3054KogakuKyufuTaishoshaMeisaiEntity}のクローン
     */
    @Override
    public DbT3054KogakuKyufuTaishoshaMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 高額介護サービス費給付対象者明細の識別子{@link KogakuKyufuTaishoshaMeisaiIdentifier}を返します。
     *
     * @return 高額介護サービス費給付対象者明細の識別子{@link KogakuKyufuTaishoshaMeisaiIdentifier}
     */
    @Override
    public KogakuKyufuTaishoshaMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する高額介護サービス費給付対象者明細を削除対象とします。<br/>
     * {@link DbT3054KogakuKyufuTaishoshaMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KogakuKyufuTaishoshaMeisai}
     */
    @Override
    public KogakuKyufuTaishoshaMeisai deleted() {
        DbT3054KogakuKyufuTaishoshaMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KogakuKyufuTaishoshaMeisai(deletedEntity, id);
    }

    /**
     * add KogakuKyufuTaishoshaMeisai
     *
     * @return ShokanMeisaiJushochiTokurei {@link ShokanMeisai}のクローン
     */
    public KogakuKyufuTaishoshaMeisai added() {
        DbT3054KogakuKyufuTaishoshaMeisaiEntity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        //TODO メッセージの検討
        return new KogakuKyufuTaishoshaMeisai(addedEntity, id);
    }

    /**
     * 修正KogakuKyufuTaishoshaMeisai
     *
     * @return ShokanMeisaiJushochiTokurei {@link ShokanMeisai}のクローン
     */
    public KogakuKyufuTaishoshaMeisai modified() {
        DbT3054KogakuKyufuTaishoshaMeisaiEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        //TODO メッセージの検討
        return new KogakuKyufuTaishoshaMeisai(modifiedEntity, id);
    }

    /**
     * {@link KogakuKyufuTaishoshaMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link KogakuKyufuTaishoshaMeisai}のシリアライズ形式
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

        private final DbT3054KogakuKyufuTaishoshaMeisaiEntity entity;
        private final KogakuKyufuTaishoshaMeisaiIdentifier id;

        private _SerializationProxy(DbT3054KogakuKyufuTaishoshaMeisaiEntity entity, KogakuKyufuTaishoshaMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KogakuKyufuTaishoshaMeisai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KogakuKyufuTaishoshaMeisaiBuilder createBuilderForEdit() {
        return new KogakuKyufuTaishoshaMeisaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

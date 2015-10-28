/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
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
 * 事業高額介護サービス費給付対象者明細を管理するクラスです。
 */
public class JigyoKogakuKyufuTaishoshaMeisai
        extends ModelBase<JigyoKogakuKyufuTaishoshaMeisaiIdentifier, DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity, JigyoKogakuKyufuTaishoshaMeisai>
        implements Serializable {

    private final DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity;
    private final JigyoKogakuKyufuTaishoshaMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 事業高額介護サービス費給付対象者明細の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業者番号 事業者番号
     * @param サービス種類コード サービス種類コード
     * @param 履歴番号 履歴番号
     */
    public JigyoKogakuKyufuTaishoshaMeisai(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業者番号,
            ServiceShuruiCode サービス種類コード,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new JigyoKogakuKyufuTaishoshaMeisaiIdentifier(
                被保険者番号,
                サービス提供年月,
                事業者番号,
                サービス種類コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity}より{@link JigyoKogakuKyufuTaishoshaMeisai}を生成します。
     *
     * @param entity DBより取得した{@link DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity}
     */
    public JigyoKogakuKyufuTaishoshaMeisai(DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費給付対象者明細"));
        this.id = new JigyoKogakuKyufuTaishoshaMeisaiIdentifier(
                entity.getHihokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshaNo(),
                entity.getServiceShuruiCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity}
     * @param id {@link JigyoKogakuKyufuTaishoshaMeisaiIdentifier}
     */
    JigyoKogakuKyufuTaishoshaMeisai(
            DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity,
            JigyoKogakuKyufuTaishoshaMeisaiIdentifier id
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
    public Decimal get履歴番号() {
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
     * 事業高額給付根拠を返します。
     *
     * @return 事業高額給付根拠
     */
    public RString get事業高額給付根拠() {
        return entity.getJigyoKogakuKyufuKonkyo();
    }

    /**
     * {@link DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity}のクローン
     */
    @Override
    public DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 事業高額介護サービス費給付対象者明細の識別子{@link JigyoKogakuKyufuTaishoshaMeisaiIdentifier}を返します。
     *
     * @return 事業高額介護サービス費給付対象者明細の識別子{@link JigyoKogakuKyufuTaishoshaMeisaiIdentifier}
     */
    @Override
    public JigyoKogakuKyufuTaishoshaMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する事業高額介護サービス費給付対象者明細を削除対象とします。<br/>
     * {@link DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JigyoKogakuKyufuTaishoshaMeisai}
     */
    @Override
    public JigyoKogakuKyufuTaishoshaMeisai deleted() {
        DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JigyoKogakuKyufuTaishoshaMeisai(deletedEntity, id);
    }

    /**
     * {@link JigyoKogakuKyufuTaishoshaMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link JigyoKogakuKyufuTaishoshaMeisai}のシリアライズ形式
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

        private final DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity;
        private final JigyoKogakuKyufuTaishoshaMeisaiIdentifier id;

        private _SerializationProxy(DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity, JigyoKogakuKyufuTaishoshaMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JigyoKogakuKyufuTaishoshaMeisai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JigyoKogakuKyufuTaishoshaMeisaiBuilder createBuilderForEdit() {
        return new JigyoKogakuKyufuTaishoshaMeisaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

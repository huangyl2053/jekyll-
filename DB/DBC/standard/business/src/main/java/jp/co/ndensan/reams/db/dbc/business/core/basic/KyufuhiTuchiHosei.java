/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3067KyufuhiTuchiHoseiEntity;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費通知補正を管理するクラスです。
 *
 * @reamsid_L DBC-9999-011 xuyongchao
 */
public class KyufuhiTuchiHosei
        extends ModelBase<KyufuhiTuchiHoseiIdentifier, DbT3067KyufuhiTuchiHoseiEntity, KyufuhiTuchiHosei> implements Serializable {

    private final DbT3067KyufuhiTuchiHoseiEntity entity;
    private final KyufuhiTuchiHoseiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付費通知補正の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param サービス種類コード サービス種類コード
     * @param 履歴番号 履歴番号
     */
    public KyufuhiTuchiHosei(HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            ServiceShuruiCode サービス種類コード,
            Decimal 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3067KyufuhiTuchiHoseiEntity();
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyufuhiTuchiHoseiIdentifier(
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                サービス種類コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3067KyufuhiTuchiHoseiEntity}より{@link KyufuhiTuchiHosei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3067KyufuhiTuchiHoseiEntity}
     */
    public KyufuhiTuchiHosei(DbT3067KyufuhiTuchiHoseiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費通知補正"));
        this.id = new KyufuhiTuchiHoseiIdentifier(
                entity.getShokisaiHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshoNo(),
                entity.getServiceShuruiCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3067KyufuhiTuchiHoseiEntity}
     * @param id {@link KyufuhiTuchiHoseiIdentifier}
     */
    KyufuhiTuchiHosei(
            DbT3067KyufuhiTuchiHoseiEntity entity,
            KyufuhiTuchiHoseiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
    }

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
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
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
        return entity.getServiceHiyoTotal();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public Decimal get利用者負担額() {
        return entity.getRiyoshaFutangaku();
    }

    /**
     * {@link DbT3067KyufuhiTuchiHoseiEntity}のクローンを返します。
     *
     * @return {@link DbT3067KyufuhiTuchiHoseiEntity}のクローン
     */
    @Override
    public DbT3067KyufuhiTuchiHoseiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付費通知補正の識別子{@link KyufuhiTuchiHoseiIdentifier}を返します。
     *
     * @return 給付費通知補正の識別子{@link KyufuhiTuchiHoseiIdentifier}
     */
    @Override
    public KyufuhiTuchiHoseiIdentifier identifier() {
        return this.id;
    }

    /**
     * modifiedModelの処理です。
     *
     * @return KyufuhiTuchiHosei
     */
    public KyufuhiTuchiHosei modifiedModel() {
        DbT3067KyufuhiTuchiHoseiEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyufuhiTuchiHosei(
                modifiedEntity, id);
    }

    /**
     * 保持する給付費通知補正を削除対象とします。<br/> {@link DbT3067KyufuhiTuchiHoseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufuhiTuchiHosei}
     */
    @Override
    public KyufuhiTuchiHosei deleted() {
        DbT3067KyufuhiTuchiHoseiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufuhiTuchiHosei(deletedEntity, id);
    }

    /**
     * {@link KyufuhiTuchiHosei}のシリアライズ形式を提供します。
     *
     * @return {@link KyufuhiTuchiHosei}のシリアライズ形式
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

        private final DbT3067KyufuhiTuchiHoseiEntity entity;
        private final KyufuhiTuchiHoseiIdentifier id;

        private _SerializationProxy(DbT3067KyufuhiTuchiHoseiEntity entity, KyufuhiTuchiHoseiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufuhiTuchiHosei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufuhiTuchiHoseiBuilder createBuilderForEdit() {
        return new KyufuhiTuchiHoseiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

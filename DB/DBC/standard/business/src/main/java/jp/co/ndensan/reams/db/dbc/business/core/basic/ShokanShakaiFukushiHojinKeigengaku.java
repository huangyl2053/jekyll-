/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求社会福祉法人軽減額を管理するクラスです。
 */
public class ShokanShakaiFukushiHojinKeigengaku extends ParentModelBase<
        ShokanShakaiFukushiHojinKeigengakuIdentifier, DbT3051ShokanShakaiFukushiHojinKeigengakuEntity, ShokanShakaiFukushiHojinKeigengaku>
        implements Serializable {

    private final DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity;
    private final ShokanShakaiFukushiHojinKeigengakuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求社会福祉法人軽減額の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @param 連番 連番
     */
    public ShokanShakaiFukushiHojinKeigengaku(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setMeisaiNo(明細番号);
        this.entity.setRenban(連番);
        this.id = new ShokanShakaiFukushiHojinKeigengakuIdentifier(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3051ShokanShakaiFukushiHojinKeigengakuEntity}より{@link ShokanShakaiFukushiHojinKeigengaku}を生成します。
     *
     * @param entity DBより取得した{@link DbT3051ShokanShakaiFukushiHojinKeigengakuEntity}
     */
    public ShokanShakaiFukushiHojinKeigengaku(DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求社会福祉法人軽減額"));
        this.id = new ShokanShakaiFukushiHojinKeigengakuIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNo(),
                entity.getJigyoshaNo(),
                entity.getYoshikiNo(),
                entity.getMeisaiNo(),
                entity.getRenban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3051ShokanShakaiFukushiHojinKeigengakuEntity}
     * @param id {@link ShokanShakaiFukushiHojinKeigengakuIdentifier}
     */
    ShokanShakaiFukushiHojinKeigengaku(
            DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity,
            ShokanShakaiFukushiHojinKeigengakuIdentifier id
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
     * 明細番号を返します。
     *
     * @return 明細番号
     */
    public RString get明細番号() {
        return entity.getMeisaiNo();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public RString get連番() {
        return entity.getRenban();
    }

    /**
     * 軽減率を返します。
     *
     * @return 軽減率
     */
    public Decimal get軽減率() {
        return entity.getKeigenritsu();
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
     * 受領すべき利用者負担の総額を返します。
     *
     * @return 受領すべき利用者負担の総額
     */
    public int get受領すべき利用者負担の総額() {
        return entity.getRiyoshaFutangakuTotal();
    }

    /**
     * 軽減額を返します。
     *
     * @return 軽減額
     */
    public int get軽減額() {
        return entity.getKeigengaku();
    }

    /**
     * 軽減後利用者負担額を返します。
     *
     * @return 軽減後利用者負担額
     */
    public int get軽減後利用者負担額() {
        return entity.getKeigengoRiyoshaFutangaku();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * {@link DbT3051ShokanShakaiFukushiHojinKeigengakuEntity}のクローンを返します。
     *
     * @return {@link DbT3051ShokanShakaiFukushiHojinKeigengakuEntity}のクローン
     */
    @Override
    public DbT3051ShokanShakaiFukushiHojinKeigengakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求社会福祉法人軽減額の識別子{@link ShokanShakaiFukushiHojinKeigengakuIdentifier}を返します。
     *
     * @return 償還払請求社会福祉法人軽減額の識別子{@link ShokanShakaiFukushiHojinKeigengakuIdentifier}
     */
    @Override
    public ShokanShakaiFukushiHojinKeigengakuIdentifier identifier() {
        return this.id;
    }

    /**
     * 償還払請求社会福祉法人軽減額のみを登録対象とします。<br/> {@link DbT3051ShokanShakaiFukushiHojinKeigengakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば登録状態にします。
     *
     * @return 登録対象処理実施後の{@link ShokanShakaiFukushiHojinKeigengaku}
     */
    public ShokanShakaiFukushiHojinKeigengaku added() {
        DbT3051ShokanShakaiFukushiHojinKeigengakuEntity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        return new ShokanShakaiFukushiHojinKeigengaku(addedEntity, id);
    }

    /**
     * 償還払請求社会福祉法人軽減額のみを変更対象とします。<br/> {@link DbT3051ShokanShakaiFukushiHojinKeigengakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShokanShakaiFukushiHojinKeigengaku}
     */
    @Override
    public ShokanShakaiFukushiHojinKeigengaku modifiedModel() {
        DbT3051ShokanShakaiFukushiHojinKeigengakuEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShokanShakaiFukushiHojinKeigengaku(
                modifiedEntity, id);
    }

    /**
     * 保持する償還払請求社会福祉法人軽減額を削除対象とします。<br/> {@link DbT3051ShokanShakaiFukushiHojinKeigengakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanShakaiFukushiHojinKeigengaku}
     */
    @Override
    public ShokanShakaiFukushiHojinKeigengaku deleted() {
        DbT3051ShokanShakaiFukushiHojinKeigengakuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanShakaiFukushiHojinKeigengaku(deletedEntity, id);
    }

    /**
     * {@link ShokanShakaiFukushiHojinKeigengaku}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanShakaiFukushiHojinKeigengaku}のシリアライズ形式
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

        private final DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity;
        private final ShokanShakaiFukushiHojinKeigengakuIdentifier id;

        private _SerializationProxy(DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity, ShokanShakaiFukushiHojinKeigengakuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanShakaiFukushiHojinKeigengaku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder createBuilderForEdit() {
        return new ShokanShakaiFukushiHojinKeigengakuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

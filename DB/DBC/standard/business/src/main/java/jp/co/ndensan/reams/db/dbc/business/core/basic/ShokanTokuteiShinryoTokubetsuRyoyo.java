/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求特定診療費・特別療養費を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 panhe
 */
public class ShokanTokuteiShinryoTokubetsuRyoyo
        extends ModelBase<ShokanTokuteiShinryoTokubetsuRyoyoIdentifier,
        DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity, 
        ShokanTokuteiShinryoTokubetsuRyoyo> implements Serializable {

    private final DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity;
    private final ShokanTokuteiShinryoTokubetsuRyoyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求特定診療費・特別療養費の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @param 連番 連番
     */
    public ShokanTokuteiShinryoTokubetsuRyoyo(HihokenshaNo 被保険者番号,
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
        this.entity = new DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setMeisaiNo(明細番号);
        this.entity.setRenban(連番);
        this.id = new ShokanTokuteiShinryoTokubetsuRyoyoIdentifier(
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
     * DBより取得した{@link DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity}より{@link ShokanTokuteiShinryoTokubetsuRyoyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyo(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求特定診療費・特別療養費"));
        this.id = new ShokanTokuteiShinryoTokubetsuRyoyoIdentifier(
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
     * @param entity {@link DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity}
     * @param id {@link ShokanTokuteiShinryoTokubetsuRyoyoIdentifier}
     */
    ShokanTokuteiShinryoTokubetsuRyoyo(
            DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity,
            ShokanTokuteiShinryoTokubetsuRyoyoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * EntityDataStateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
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
     * 傷病名を返します。
     *
     * @return 傷病名
     */
    public RString get傷病名() {
        return entity.getShobyoName();
    }

    /**
     * 識別番号を返します。
     *
     * @return 識別番号
     */
    public RString get識別番号() {
        return entity.getShikibetsuNo();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public int get単位数() {
        return entity.getTanisu();
    }

    /**
     * 回数を返します。
     *
     * @return 回数
     */
    public int get回数() {
        return entity.getKaisu();
    }

    /**
     * サービス単位数を返します。
     *
     * @return サービス単位数
     */
    public int getサービス単位数() {
        return entity.getServiceTanisu();
    }

    /**
     * 合計単位数を返します。
     *
     * @return 合計単位数
     */
    public int get合計単位数() {
        return entity.getTotalTanisu();
    }

    /**
     * 摘要を返します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return entity.getTekiyo();
    }

    /**
     * {@link DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity}のクローンを返します。
     *
     * @return {@link DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity}のクローン
     */
    @Override
    public DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求特定診療費・特別療養費の識別子{@link ShokanTokuteiShinryoTokubetsuRyoyoIdentifier}を返します。
     *
     * @return 償還払請求特定診療費・特別療養費の識別子{@link ShokanTokuteiShinryoTokubetsuRyoyoIdentifier}
     */
    @Override
    public ShokanTokuteiShinryoTokubetsuRyoyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払請求特定診療費・特別療養費を削除対象とします。<br/>
     * {@link DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanTokuteiShinryoTokubetsuRyoyo}
     */
    @Override
    public ShokanTokuteiShinryoTokubetsuRyoyo deleted() {
        DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanTokuteiShinryoTokubetsuRyoyo(deletedEntity, id);
    }

    /**
     * {@link ShokanTokuteiShinryoTokubetsuRyoyo}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyo}のシリアライズ形式
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

        private final DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity;
        private final ShokanTokuteiShinryoTokubetsuRyoyoIdentifier id;

        private _SerializationProxy(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity, ShokanTokuteiShinryoTokubetsuRyoyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanTokuteiShinryoTokubetsuRyoyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder createBuilderForEdit() {
        return new ShokanTokuteiShinryoTokubetsuRyoyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求明細を管理するクラスです。
 */
public class ShokanMeisai extends ModelBase<ShokanMeisaiIdentifier, DbT3039ShokanMeisaiEntity, ShokanMeisai> implements Serializable {

    private final DbT3039ShokanMeisaiEntity entity;
    private final ShokanMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求明細の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @param 連番 連番
     */
    public ShokanMeisai(HihokenshaNo 被保険者番号,
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
        this.entity = new DbT3039ShokanMeisaiEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setMeisaiNo(明細番号);
        this.entity.setRenban(連番);
        this.id = new ShokanMeisaiIdentifier(
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
     * DBより取得した{@link DbT3039ShokanMeisaiEntity}より{@link ShokanMeisai}を生成します。
     *
     * @param entity DBより取得した{@link DbT3039ShokanMeisaiEntity}
     */
    public ShokanMeisai(DbT3039ShokanMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求明細"));
        this.id = new ShokanMeisaiIdentifier(
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
     * @param entity {@link DbT3039ShokanMeisaiEntity}
     * @param id {@link ShokanMeisaiIdentifier}
     */
    ShokanMeisai(
            DbT3039ShokanMeisaiEntity entity,
            ShokanMeisaiIdentifier id
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
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getサービス項目コード() {
        return entity.getServiceKomokuCode();
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
     * 日数・回数を返します。
     *
     * @return 日数・回数
     */
    public int get日数_回数() {
        return entity.getNissuKaisu();
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
     * 摘要を返します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return entity.getTekiyo();
    }

    /**
     * {@link DbT3039ShokanMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3039ShokanMeisaiEntity}のクローン
     */
    @Override
    public DbT3039ShokanMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求明細の識別子{@link ShokanMeisaiIdentifier}を返します。
     *
     * @return 償還払請求明細の識別子{@link ShokanMeisaiIdentifier}
     */
    @Override
    public ShokanMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払請求明細を削除対象とします。<br/> {@link DbT3039ShokanMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanMeisai}
     */
    @Override
    public ShokanMeisai deleted() {
        DbT3039ShokanMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanMeisai(deletedEntity, id);
    }

    /**
     * 修正ShokanMeisai
     *
     * @return ShokanMeisai {@link ShokanMeisai}のクローン
     */
    public ShokanMeisai modified() {
        DbT3039ShokanMeisaiEntity modifiedEntity = this.toEntity();

        modifiedEntity.setState(EntityDataState.Modified);

        //TODO メッセージの検討
        return new ShokanMeisai(modifiedEntity, id);
    }

    /**
     * add ShokanMeisai
     *
     * @return ShokanMeisai {@link ShokanMeisai}のクローン
     */
    public ShokanMeisai added() {
        DbT3039ShokanMeisaiEntity addedEntity = this.toEntity();

        addedEntity.setState(EntityDataState.Added);

        //TODO メッセージの検討
        return new ShokanMeisai(addedEntity, id);
    }

    /**
     * {@link ShokanMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanMeisai}のシリアライズ形式
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

        private final DbT3039ShokanMeisaiEntity entity;
        private final ShokanMeisaiIdentifier id;

        private _SerializationProxy(DbT3039ShokanMeisaiEntity entity, ShokanMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanMeisai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanMeisaiBuilder createBuilderForEdit() {
        return new ShokanMeisaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

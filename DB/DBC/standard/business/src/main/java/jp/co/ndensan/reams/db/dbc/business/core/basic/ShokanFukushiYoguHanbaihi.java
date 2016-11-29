/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求福祉用具販売費を管理するクラスです。
 *
 * @reamsid_L DBC-1020-050 chenaoqi
 */
public class ShokanFukushiYoguHanbaihi
        extends ModelBase<ShokanFukushiYoguHanbaihiIdentifier, DbT3048ShokanFukushiYoguHanbaihiEntity, ShokanFukushiYoguHanbaihi>
        implements Serializable {

    private final DbT3048ShokanFukushiYoguHanbaihiEntity entity;
    private final ShokanFukushiYoguHanbaihiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求福祉用具販売費の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @param 連番 連番
     */
    public ShokanFukushiYoguHanbaihi(HihokenshaNo 被保険者番号,
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
        this.entity = new DbT3048ShokanFukushiYoguHanbaihiEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setMeisaiNo(明細番号);
        this.entity.setRenban(連番);
        this.id = new ShokanFukushiYoguHanbaihiIdentifier(
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
     * DBより取得した{@link DbT3048ShokanFukushiYoguHanbaihiEntity}より{@link ShokanFukushiYoguHanbaihi}を生成します。
     *
     * @param entity DBより取得した{@link DbT3048ShokanFukushiYoguHanbaihiEntity}
     */
    public ShokanFukushiYoguHanbaihi(DbT3048ShokanFukushiYoguHanbaihiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求福祉用具販売費"));
        this.id = new ShokanFukushiYoguHanbaihiIdentifier(
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
     * @param entity {@link DbT3048ShokanFukushiYoguHanbaihiEntity}
     * @param id {@link ShokanFukushiYoguHanbaihiIdentifier}
     */
    ShokanFukushiYoguHanbaihi(
            DbT3048ShokanFukushiYoguHanbaihiEntity entity,
            ShokanFukushiYoguHanbaihiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
     * サービスコードを返します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード() {
        return entity.getServiceCode();
    }

    /**
     * 福祉用具販売年月日を返します。
     *
     * @return 福祉用具販売年月日
     */
    public FlexibleDate get福祉用具販売年月日() {
        return entity.getFukushiYoguHanbaiYMD();
    }

    /**
     * 福祉用具商品名を返します。
     *
     * @return 福祉用具商品名
     */
    public RString get福祉用具商品名() {
        return entity.getFukushiYoguShohinName();
    }

    /**
     * 福祉用具種目コードを返します。
     *
     * @return 福祉用具種目コード
     */
    public RString get福祉用具種目コード() {
        return entity.getFukushiYoguShumokuCode();
    }

    /**
     * 福祉用具製造事業者名を返します。
     *
     * @return 福祉用具製造事業者名
     */
    public RString get福祉用具製造事業者名() {
        return entity.getFukushiYoguSeizoJigyoshaName();
    }

    /**
     * 福祉用具販売事業者名を返します。
     *
     * @return 福祉用具販売事業者名
     */
    public RString get福祉用具販売事業者名() {
        return entity.getFukushiYoguHanbaiJigyoshaName();
    }

    /**
     * 購入金額を返します。
     *
     * @return 購入金額
     */
    public int get購入金額() {
        return entity.getKounyuKingaku();
    }

    /**
     * 品目コードを返します。
     *
     * @return 品目コード
     */
    public RString get品目コード() {
        return entity.getHinmokuCode();
    }

    /**
     * 審査方法区分コードを返します。
     *
     * @return 審査方法区分コード
     */
    public RString get審査方法区分コード() {
        return entity.getShinsaHohoKubunCode();
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
     * {@link DbT3048ShokanFukushiYoguHanbaihiEntity}のクローンを返します。
     *
     * @return {@link DbT3048ShokanFukushiYoguHanbaihiEntity}のクローン
     */
    @Override
    public DbT3048ShokanFukushiYoguHanbaihiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求福祉用具販売費の識別子{@link ShokanFukushiYoguHanbaihiIdentifier}を返します。
     *
     * @return 償還払請求福祉用具販売費の識別子{@link ShokanFukushiYoguHanbaihiIdentifier}
     */
    @Override
    public ShokanFukushiYoguHanbaihiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払請求福祉用具販売費を削除対象とします。<br/>
     * {@link DbT3048ShokanFukushiYoguHanbaihiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanFukushiYoguHanbaihi}
     */
    @Override
    public ShokanFukushiYoguHanbaihi deleted() {
        DbT3048ShokanFukushiYoguHanbaihiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanFukushiYoguHanbaihi(deletedEntity, id);
    }

    /**
     * 保持する償還払請求福祉用具販売費を削除対象とします。<br/>
     * {@link DbT3048ShokanFukushiYoguHanbaihiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return modified対象処理実施後の{@link ShokanFukushiYoguHanbaihi}
     */
    public ShokanFukushiYoguHanbaihi modified() {
        DbT3048ShokanFukushiYoguHanbaihiEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        return new ShokanFukushiYoguHanbaihi(modifiedEntity, id);
    }

    /**
     * 保持する償還払請求福祉用具販売費を削除対象とします。<br/>
     * {@link DbT3048ShokanFukushiYoguHanbaihiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return added対象処理実施後の{@link ShokanFukushiYoguHanbaihi}
     */
    public ShokanFukushiYoguHanbaihi added() {
        DbT3048ShokanFukushiYoguHanbaihiEntity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        return new ShokanFukushiYoguHanbaihi(addedEntity, id);
    }

    /**
     * {@link ShokanFukushiYoguHanbaihi}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanFukushiYoguHanbaihi}のシリアライズ形式
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

        private final DbT3048ShokanFukushiYoguHanbaihiEntity entity;
        private final ShokanFukushiYoguHanbaihiIdentifier id;

        private _SerializationProxy(DbT3048ShokanFukushiYoguHanbaihiEntity entity, ShokanFukushiYoguHanbaihiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanFukushiYoguHanbaihi(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanFukushiYoguHanbaihiBuilder createBuilderForEdit() {
        return new ShokanFukushiYoguHanbaihiBuilder(entity, id);
    }

}

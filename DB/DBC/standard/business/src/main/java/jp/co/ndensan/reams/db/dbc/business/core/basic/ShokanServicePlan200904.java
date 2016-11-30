/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求サービス計画200904を管理するクラスです。
 */
public class ShokanServicePlan200904
        extends ModelBase<ShokanServicePlan200904Identifier, DbT3047ShokanServicePlan200904Entity, ShokanServicePlan200904> implements Serializable {

    private final DbT3047ShokanServicePlan200904Entity entity;
    private final ShokanServicePlan200904Identifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求サービス計画200904の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @param 連番 連番
     */
    public ShokanServicePlan200904(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番
    ) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT3047ShokanServicePlan200904Entity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setMeisaiNo(明細番号);
        this.entity.setRenban(連番);
        this.id = new ShokanServicePlan200904Identifier(
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
     * DBより取得した{@link DbT3047ShokanServicePlan200904Entity}より{@link ShokanServicePlan200904}を生成します。
     *
     * @param entity DBより取得した{@link DbT3047ShokanServicePlan200904Entity}
     */
    public ShokanServicePlan200904(DbT3047ShokanServicePlan200904Entity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求サービス計画200904"));
        this.id = new ShokanServicePlan200904Identifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNo(),
                entity.getJigyoshaNo(),
                entity.getYoshikiNo(),
                entity.getMeisaiNo(),
                entity.getRenban()
        );
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3047ShokanServicePlan200904Entity}
     * @param id {@link ShokanServicePlan200904Identifier}
     */
    ShokanServicePlan200904(
            DbT3047ShokanServicePlan200904Entity entity,
            ShokanServicePlan200904Identifier id
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
     * 指定_基準該当事業者区分コードを返します。
     *
     * @return 指定_基準該当事業者区分コード
     */
    public RString get指定_基準該当事業者区分コード() {
        return entity.getShiteiKijunGaitoJigyoshaKubunCode();
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
     * 居宅サービス計画作成依頼届出年月日を返します。
     *
     * @return 居宅サービス計画作成依頼届出年月日
     */
    public FlexibleDate get居宅サービス計画作成依頼届出年月日() {
        return entity.getKyotakuServiceSakuseiIraiYMD();
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
     * 単位数単価を返します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価() {
        return entity.getTanisuTanka();
    }

    /**
     * サービス単位数合計を返します。
     *
     * @return サービス単位数合計
     */
    public int getサービス単位数合計() {
        return entity.getServiceTanisuTotal();
    }

    /**
     * 請求金額を返します。
     *
     * @return 請求金額
     */
    public int get請求金額() {
        return entity.getSeikyuKingaku();
    }

    /**
     * 担当介護支援専門員番号を返します。
     *
     * @return 担当介護支援専門員番号
     */
    public RString get担当介護支援専門員番号() {
        return entity.getTantokangoshienSemmoninNo();
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
     * 審査方法区分コードを返します。
     *
     * @return 審査方法区分コード
     */
    public RString get審査方法区分コード() {
        return entity.getShinsaHohoKubunCode();
    }

    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return entity.getShinsaYM();
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
     * 増減点を返します。
     *
     * @return 増減点
     */
    public int get増減点() {
        return entity.getZougenTen();
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
     * 増減理由等を返します。
     *
     * @return 増減理由等
     */
    public RString get増減理由等() {
        return entity.getZougenRiyu();
    }

    /**
     * 不支給理由等を返します。
     *
     * @return 不支給理由等
     */
    public RString get不支給理由等() {
        return entity.getFushikyuRiyu();
    }

    /**
     * 購入_改修履歴等を返します。
     *
     * @return 購入_改修履歴等
     */
    public RString get購入_改修履歴等() {
        return entity.getKounyuKaishuRireki();
    }

    /**
     * {@link DbT3047ShokanServicePlan200904Entity}のクローンを返します。
     *
     * @return {@link DbT3047ShokanServicePlan200904Entity}のクローン
     */
    @Override
    public DbT3047ShokanServicePlan200904Entity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求サービス計画200904の識別子{@link ShokanServicePlan200904Identifier}を返します。
     *
     * @return 償還払請求サービス計画200904の識別子{@link ShokanServicePlan200904Identifier}
     */
    @Override
    public ShokanServicePlan200904Identifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払請求サービス計画200904を削除対象とします。<br/>
     * {@link DbT3047ShokanServicePlan200904Entity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanServicePlan200904}
     */
    @Override
    public ShokanServicePlan200904 deleted() {
        DbT3047ShokanServicePlan200904Entity deletedEntity = this.toEntity();
        deletedEntity.setState(EntityDataState.Deleted);
        return new ShokanServicePlan200904(deletedEntity, id);
    }

    /**
     * 保持する償還払請求サービス計画200904を修正対象とします。<br/>
     * {@link DbT3047ShokanServicePlan200904Entity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば修正状態にします。
     *
     * @return 修正対象処理実施後の{@link ShokanServicePlan200904}
     */
    public ShokanServicePlan200904 modified() {
        DbT3047ShokanServicePlan200904Entity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        return new ShokanServicePlan200904(modifiedEntity, id);
    }

    /**
     * 保持する償還払請求サービス計画200904をUnchanged対象とします。<br/>
     * {@link DbT3047ShokanServicePlan200904Entity}の{@link EntityDataState}がすでにDBへ永続化されている物であればUnchanged状態にします。
     *
     * @return 対象処理実施後の{@link ShokanServicePlan200904}
     */
    public ShokanServicePlan200904 noChanged() {
        DbT3047ShokanServicePlan200904Entity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Unchanged);
        return new ShokanServicePlan200904(modifiedEntity, id);
    }

    /**
     * 保持する償還払請求サービス計画200904を登録対象とします。<br/>
     * {@link DbT3047ShokanServicePlan200904Entity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば登録状態にします。
     *
     * @return 登録対象処理実施後の{@link ShokanServicePlan200904}
     */
    public ShokanServicePlan200904 added() {
        DbT3047ShokanServicePlan200904Entity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        return new ShokanServicePlan200904(addedEntity, id);
    }

    /**
     * {@link ShokanServicePlan200904}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanServicePlan200904}のシリアライズ形式
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

        private final DbT3047ShokanServicePlan200904Entity entity;
        private final ShokanServicePlan200904Identifier id;

        private _SerializationProxy(DbT3047ShokanServicePlan200904Entity entity, ShokanServicePlan200904Identifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanServicePlan200904(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanServicePlan200904Builder createBuilderForEdit() {
        return new ShokanServicePlan200904Builder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

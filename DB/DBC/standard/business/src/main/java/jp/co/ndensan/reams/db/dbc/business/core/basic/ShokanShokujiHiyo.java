/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求食事費用を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 panhe
 */
public class ShokanShokujiHiyo
        extends ModelBase<ShokanShokujiHiyoIdentifier, DbT3043ShokanShokujiHiyoEntity, ShokanShokujiHiyo> implements Serializable {

    private final DbT3043ShokanShokujiHiyoEntity entity;
    private final ShokanShokujiHiyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求食事費用の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @param 連番 連番
     */
    public ShokanShokujiHiyo(HihokenshaNo 被保険者番号,
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
        this.entity = new DbT3043ShokanShokujiHiyoEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setMeisaiNo(明細番号);
        this.entity.setRenban(連番);
        this.id = new ShokanShokujiHiyoIdentifier(
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
     * DBより取得した{@link DbT3043ShokanShokujiHiyoEntity}より{@link ShokanShokujiHiyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT3043ShokanShokujiHiyoEntity}
     */
    public ShokanShokujiHiyo(DbT3043ShokanShokujiHiyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求食事費用"));
        this.id = new ShokanShokujiHiyoIdentifier(
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
     * @param entity {@link DbT3043ShokanShokujiHiyoEntity}
     * @param id {@link ShokanShokujiHiyoIdentifier}
     */
    ShokanShokujiHiyo(
            DbT3043ShokanShokujiHiyoEntity entity,
            ShokanShokujiHiyoIdentifier id
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
     * 基本提供日数を返します。
     *
     * @return 基本提供日数
     */
    public int get基本提供日数() {
        return entity.getKihonTeikyoNissu();
    }

    /**
     * 基本提供単価を返します。
     *
     * @return 基本提供単価
     */
    public int get基本提供単価() {
        return entity.getKihonTeikyoTanka();
    }

    /**
     * 基本提供金額を返します。
     *
     * @return 基本提供金額
     */
    public int get基本提供金額() {
        return entity.getKihonTeikyoKingaku();
    }

    /**
     * 特別提供日数を返します。
     *
     * @return 特別提供日数
     */
    public int get特別提供日数() {
        return entity.getTokubetsuTeikyoNissu();
    }

    /**
     * 特別提供単価を返します。
     *
     * @return 特別提供単価
     */
    public int get特別提供単価() {
        return entity.getTokubetsuTeikyoTanka();
    }

    /**
     * 特別提供金額を返します。
     *
     * @return 特別提供金額
     */
    public int get特別提供金額() {
        return entity.getTokubetsuTeikyoKingaku();
    }

    /**
     * 食事提供延べ日数を返します。
     *
     * @return 食事提供延べ日数
     */
    public int get食事提供延べ日数() {
        return entity.getShokujiTeikyoTotalNissu();
    }

    /**
     * 食事提供費合計を返します。
     *
     * @return 食事提供費合計
     */
    public int get食事提供費合計() {
        return entity.getShokujiTeikyohiTotal();
    }

    /**
     * 標準負担額_月額を返します。
     *
     * @return 標準負担額_月額
     */
    public int get標準負担額_月額() {
        return entity.getGetsugakuHyojunFutangaku();
    }

    /**
     * 食事提供費請求額を返します。
     *
     * @return 食事提供費請求額
     */
    public int get食事提供費請求額() {
        return entity.getShokujiTeikyohiSeikyugaku();
    }

    /**
     * 標準負担額_日額を返します。
     *
     * @return 標準負担額_日額
     */
    public int get標準負担額_日額() {
        return entity.getNichigakuHyojunFutangaku();
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
     * {@link DbT3043ShokanShokujiHiyoEntity}のクローンを返します。
     *
     * @return {@link DbT3043ShokanShokujiHiyoEntity}のクローン
     */
    @Override
    public DbT3043ShokanShokujiHiyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求食事費用の識別子{@link ShokanShokujiHiyoIdentifier}を返します。
     *
     * @return 償還払請求食事費用の識別子{@link ShokanShokujiHiyoIdentifier}
     */
    @Override
    public ShokanShokujiHiyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払請求食事費用を削除対象とします。<br/> {@link DbT3043ShokanShokujiHiyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanShokujiHiyo}
     */
    @Override
    public ShokanShokujiHiyo deleted() {
        DbT3043ShokanShokujiHiyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanShokujiHiyo(deletedEntity, id);
    }

    /**
     * 保持する償還払請求食事費用を削除対象とします。<br/> {@link DbT3043ShokanShokujiHiyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return modified対象処理実施後の{@link ShokanShukei}
     */
    public ShokanShokujiHiyo modified() {
        DbT3043ShokanShokujiHiyoEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        return new ShokanShokujiHiyo(modifiedEntity, id);
    }

    /**
     * 保持する償還払請求食事費用をinsert対象とします。<br/> {@link DbT3043ShokanShokujiHiyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であればinsert状態にします。
     *
     * @return 修正対象処理実施後の{@link ShokanShokujiHiyo}
     */
    public ShokanShokujiHiyo added() {
        DbT3043ShokanShokujiHiyoEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Added);
        return new ShokanShokujiHiyo(modifiedEntity, id);
    }

    /**
     * {@link ShokanShokujiHiyo}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanShokujiHiyo}のシリアライズ形式
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

        private final DbT3043ShokanShokujiHiyoEntity entity;
        private final ShokanShokujiHiyoIdentifier id;

        private _SerializationProxy(DbT3043ShokanShokujiHiyoEntity entity, ShokanShokujiHiyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanShokujiHiyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanShokujiHiyoBuilder createBuilderForEdit() {
        return new ShokanShokujiHiyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

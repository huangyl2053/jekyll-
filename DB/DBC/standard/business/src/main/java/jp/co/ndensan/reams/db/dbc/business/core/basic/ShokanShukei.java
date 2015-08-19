/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求集計を管理するクラスです。
 */
public class ShokanShukei extends ModelBase<ShokanShukeiIdentifier, DbT3053ShokanShukeiEntity, ShokanShukei> implements Serializable {

    private final DbT3053ShokanShukeiEntity entity;
    private final ShokanShukeiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求集計の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 順次番号 順次番号
     * @param 履歴番号 履歴番号
     */
    public ShokanShukei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 順次番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3053ShokanShukeiEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setJunjiNo(順次番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShokanShukeiIdentifier(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                順次番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3053ShokanShukeiEntity}より{@link ShokanShukei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3053ShokanShukeiEntity}
     */
    public ShokanShukei(DbT3053ShokanShukeiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求集計"));
        this.id = new ShokanShukeiIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNo(),
                entity.getJigyoshaNo(),
                entity.getYoshikiNo(),
                entity.getJunjiNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3053ShokanShukeiEntity}
     * @param id {@link ShokanShukeiIdentifier}
     */
    ShokanShukei(
            DbT3053ShokanShukeiEntity entity,
            ShokanShukeiIdentifier id
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
     * 順次番号を返します。
     *
     * @return 順次番号
     */
    public RString get順次番号() {
        return entity.getJunjiNo();
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
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * サービス実日数を返します。
     *
     * @return サービス実日数
     */
    public Decimal getサービス実日数() {
        return entity.getServiceJitsunissu();
    }

    /**
     * 計画単位数を返します。
     *
     * @return 計画単位数
     */
    public int get計画単位数() {
        return entity.getPlanTanisu();
    }

    /**
     * 限度額管理対象単位数を返します。
     *
     * @return 限度額管理対象単位数
     */
    public int get限度額管理対象単位数() {
        return entity.getGendogakuKanriTaishoTanisu();
    }

    /**
     * 限度額管理対象外単位数を返します。
     *
     * @return 限度額管理対象外単位数
     */
    public int get限度額管理対象外単位数() {
        return entity.getGendogakuKanriTaishogaiTanisu();
    }

    /**
     * 短期入所計画日数を返します。
     *
     * @return 短期入所計画日数
     */
    public Decimal get短期入所計画日数() {
        return entity.getTankiNyushoPlanNissu();
    }

    /**
     * 短期入所実日数を返します。
     *
     * @return 短期入所実日数
     */
    public Decimal get短期入所実日数() {
        return entity.getTankiNyushoJitsunissu();
    }

    /**
     * 単位数合計を返します。
     *
     * @return 単位数合計
     */
    public int get単位数合計() {
        return entity.getTanisuTotal();
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
     * 請求額を返します。
     *
     * @return 請求額
     */
    public Decimal get請求額() {
        return entity.getSeikyugaku();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public int get利用者負担額() {
        return entity.getRiyoshaFutangaku();
    }

    /**
     * 出来高医療費単位数合計を返します。
     *
     * @return 出来高医療費単位数合計
     */
    public int get出来高医療費単位数合計() {
        return entity.getDekidakaIryohiTanisuTotal();
    }

    /**
     * 出来高医療費請求額を返します。
     *
     * @return 出来高医療費請求額
     */
    public Decimal get出来高医療費請求額() {
        return entity.getDekidakaIryohiSeikyugaku();
    }

    /**
     * 出来高医療費利用者負担額を返します。
     *
     * @return 出来高医療費利用者負担額
     */
    public Decimal get出来高医療費利用者負担額() {
        return entity.getDekidakaIryohiRiyoshaFutangaku();
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
     * 支払金額を返します。
     *
     * @return 支払金額
     */
    public int get支払金額() {
        return entity.getShikyuKingaku();
    }

    /**
     * 増減点を返します。
     *
     * @return 増減点
     */
    public int get増減点() {
        return entity.getZougenten();
    }

    /**
     * 請求額差額金額を返します。
     *
     * @return 請求額差額金額
     */
    public int get請求額差額金額() {
        return entity.getSeikyugakuSagakuKingaku();
    }

    /**
     * 出来高請求額差額金額を返します。
     *
     * @return 出来高請求額差額金額
     */
    public int get出来高請求額差額金額() {
        return entity.getDekidakaSeikyugakuSagaku();
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
        return entity.getHushikyuRiyu();
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
     * {@link DbT3053ShokanShukeiEntity}のクローンを返します。
     *
     * @return {@link DbT3053ShokanShukeiEntity}のクローン
     */
    @Override
    public DbT3053ShokanShukeiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求集計の識別子{@link ShokanShukeiIdentifier}を返します。
     *
     * @return 償還払請求集計の識別子{@link ShokanShukeiIdentifier}
     */
    @Override
    public ShokanShukeiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払請求集計を削除対象とします。<br/>
     * {@link DbT3053ShokanShukeiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanShukei}
     */
    @Override
    public ShokanShukei deleted() {
        DbT3053ShokanShukeiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanShukei(deletedEntity, id);
    }

    /**
     * {@link ShokanShukei}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanShukei}のシリアライズ形式
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

        private final DbT3053ShokanShukeiEntity entity;
        private final ShokanShukeiIdentifier id;

        private _SerializationProxy(DbT3053ShokanShukeiEntity entity, ShokanShukeiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanShukei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanShukeiBuilder createBuilderForEdit() {
        return new ShokanShukeiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

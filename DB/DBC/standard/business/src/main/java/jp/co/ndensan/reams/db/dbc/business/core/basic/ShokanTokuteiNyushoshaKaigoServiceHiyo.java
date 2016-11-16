/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
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
 * 償還払請求特定入所者介護サービス費用を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 panhe
 */
public class ShokanTokuteiNyushoshaKaigoServiceHiyo extends ModelBase<ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier, DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity, ShokanTokuteiNyushoshaKaigoServiceHiyo>
        implements Serializable {

    private final DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity;
    private final ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求特定入所者介護サービス費用の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @param 連番 連番
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyo(HihokenshaNo 被保険者番号,
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
        this.entity = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setMeisaiNo(明細番号);
        this.entity.setRenban(連番);
        this.id = new ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier(
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
     * DBより取得した{@link DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}より{@link ShokanTokuteiNyushoshaKaigoServiceHiyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyo(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求特定入所者介護サービス費用"));
        this.id = new ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier(
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
     * @param entity {@link DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}
     * @param id {@link ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier}
     */
    ShokanTokuteiNyushoshaKaigoServiceHiyo(
            DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity,
            ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier id
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
     * 費用単価を返します。
     *
     * @return 費用単価
     */
    public int get費用単価() {
        return entity.getHiyoTanka();
    }

    /**
     * 負担限度額を返します。
     *
     * @return 負担限度額
     */
    public int get負担限度額() {
        return entity.getFutanGendogaku();
    }

    /**
     * 日数を返します。
     *
     * @return 日数
     */
    public int get日数() {
        return entity.getNissu();
    }

    /**
     * 費用額を返します。
     *
     * @return 費用額
     */
    public int get費用額() {
        return entity.getHiyogaku();
    }

    /**
     * 保険分請求額を返します。
     *
     * @return 保険分請求額
     */
    public int get保険分請求額() {
        return entity.getHokenbunSeikyugaku();
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
     * 費用額合計を返します。
     *
     * @return 費用額合計
     */
    public int get費用額合計() {
        return entity.getHiyogakuTotal();
    }

    /**
     * 保険分請求額合計を返します。
     *
     * @return 保険分請求額合計
     */
    public int get保険分請求額合計() {
        return entity.getHokenbunSeikyugakuTotal();
    }

    /**
     * 利用者負担額合計を返します。
     *
     * @return 利用者負担額合計
     */
    public int get利用者負担額合計() {
        return entity.getRiyoshaFutangakuTotal();
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
     * 点数／金額を返します。
     *
     * @return 点数／金額
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
        return entity.getZougenten();
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
     * {@link DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}のクローンを返します。
     *
     * @return {@link DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}のクローン
     */
    @Override
    public DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * {@link DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShokanTokuteiNyushoshaKaigoServiceHiyo}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyo modifiedModel() {
        DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShokanTokuteiNyushoshaKaigoServiceHiyo(
                modifiedEntity, id);
    }

    /**
     * 償還払請求特定入所者介護サービス費用の識別子{@link ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier}を返します。
     *
     * @return 償還払請求特定入所者介護サービス費用の識別子{@link ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier}
     */
    @Override
    public ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払請求特定入所者介護サービス費用を削除対象とします。<br/>
     * {@link DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanTokuteiNyushoshaKaigoServiceHiyo}
     */
    @Override
    public ShokanTokuteiNyushoshaKaigoServiceHiyo deleted() {
        DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanTokuteiNyushoshaKaigoServiceHiyo(deletedEntity, id);
    }

    /**
     * {@link ShokanTokuteiNyushoshaKaigoServiceHiyo}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyo}のシリアライズ形式
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

        private final DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity;
        private final ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier id;

        private _SerializationProxy(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity, ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanTokuteiNyushoshaKaigoServiceHiyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder createBuilderForEdit() {
        return new ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求基本を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 panhe
 */
public class ShokanKihon extends ModelBase<ShokanKihonIdentifier, DbT3038ShokanKihonEntity, ShokanKihon> implements Serializable {

    private final DbT3038ShokanKihonEntity entity;
    private final ShokanKihonIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求基本の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     */
    public ShokanKihon(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        this.entity = new DbT3038ShokanKihonEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setMeisaiNo(明細番号);
        this.id = new ShokanKihonIdentifier(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3038ShokanKihonEntity}より{@link ShokanKihon}を生成します。
     *
     * @param entity DBより取得した{@link DbT3038ShokanKihonEntity}
     */
    public ShokanKihon(DbT3038ShokanKihonEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求基本"));
        this.id = new ShokanKihonIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNo(),
                entity.getJigyoshaNo(),
                entity.getYoshikiNo(),
                entity.getMeisaiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3038ShokanKihonEntity}
     * @param id {@link ShokanKihonIdentifier}
     */
    ShokanKihon(
            DbT3038ShokanKihonEntity entity,
            ShokanKihonIdentifier id
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
     * 旧措置入所者特例コードを返します。
     *
     * @return 旧措置入所者特例コード
     */
    public RString get旧措置入所者特例コード() {
        return entity.getKyuSochiNyushoshaTokureiCode();
    }

    /**
     * 居宅サービス計画作成区分コードを返します。
     *
     * @return 居宅サービス計画作成区分コード
     */
    public RString get居宅サービス計画作成区分コード() {
        return entity.getKyotakuServiceSakuseiKubunCode();
    }

    /**
     * 居宅サービス計画事業者番号を返します。
     *
     * @return 居宅サービス計画事業者番号
     */
    public JigyoshaNo get居宅サービス計画事業者番号() {
        return entity.getKyotakuserviceJigyoshaNo();
    }

    /**
     * 開始年月日を返します。
     *
     * @return 開始年月日
     */
    public FlexibleDate get開始年月日() {
        return entity.getKaishiYMD();
    }

    /**
     * 中止年月日を返します。
     *
     * @return 中止年月日
     */
    public FlexibleDate get中止年月日() {
        return entity.getChushiYMD();
    }

    /**
     * 中止理由_入所_院前の状況コードを返します。
     *
     * @return 中止理由_入所_院前の状況コード
     */
    public RString get中止理由_入所_院前の状況コード() {
        return entity.getChushiRiyuNyushomaeJyokyoCode();
    }

    /**
     * 入所_院年月日を返します。
     *
     * @return 入所_院年月日
     */
    public FlexibleDate get入所_院年月日() {
        return entity.getNyushoYMD();
    }

    /**
     * 退所_院年月日を返します。
     *
     * @return 退所_院年月日
     */
    public FlexibleDate get退所_院年月日() {
        return entity.getTaishoYMD();
    }

    /**
     * 入所_院実日数を返します。
     *
     * @return 入所_院実日数
     */
    public int get入所_院実日数() {
        return entity.getNyushoJitsuNissu();
    }

    /**
     * 外泊日数を返します。
     *
     * @return 外泊日数
     */
    public int get外泊日数() {
        return entity.getGaihakuNissu();
    }

    /**
     * 退所_院後の状態コードを返します。
     *
     * @return 退所_院後の状態コード
     */
    public RString get退所_院後の状態コード() {
        return entity.getTaishogoJotaiCode();
    }

    /**
     * 保険給付率を返します。
     *
     * @return 保険給付率
     */
    public HokenKyufuRitsu get保険給付率() {
        return entity.getHokenKyufuritsu();
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
     * 保険請求額を返します。
     *
     * @return 保険請求額
     */
    public Decimal get保険請求額() {
        return entity.getHokenSeikyugaku();
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
     * 緊急時施設療養費請求額を返します。
     *
     * @return 緊急時施設療養費請求額
     */
    public Decimal get緊急時施設療養費請求額() {
        return entity.getKinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 特定診療費請求額を返します。
     *
     * @return 特定診療費請求額
     */
    public Decimal get特定診療費請求額() {
        return entity.getTokuteiShinryoSeikyugaku();
    }

    /**
     * 特定入所者介護サービス費等請求額を返します。
     *
     * @return 特定入所者介護サービス費等請求額
     */
    public int get特定入所者介護サービス費等請求額() {
        return entity.getTokuteiNyushoshaKaigoServiceSeikyugaku();
    }

    /**
     * {@link DbT3038ShokanKihonEntity}のクローンを返します。
     *
     * @return {@link DbT3038ShokanKihonEntity}のクローン
     */
    @Override
    public DbT3038ShokanKihonEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求基本の識別子{@link ShokanKihonIdentifier}を返します。
     *
     * @return 償還払請求基本の識別子{@link ShokanKihonIdentifier}
     */
    @Override
    public ShokanKihonIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払請求基本を削除対象とします。<br/> {@link DbT3038ShokanKihonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanKihon}
     */
    @Override
    public ShokanKihon deleted() {
        DbT3038ShokanKihonEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanKihon(deletedEntity, id);
    }

    /**
     * 保持する償還払請求基本を更新対象とします。<br/> {@link DbT3038ShokanKihonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば更新状態にします。
     *
     * @return 更新対象処理実施後の{@link ShokanKihon}
     */
    public ShokanKihon modified() {
        DbT3038ShokanKihonEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        return new ShokanKihon(modifiedEntity, id);
    }

    /**
     * {@link ShokanKihon}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanKihon}のシリアライズ形式
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

        private final DbT3038ShokanKihonEntity entity;
        private final ShokanKihonIdentifier id;

        private _SerializationProxy(DbT3038ShokanKihonEntity entity, ShokanKihonIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanKihon(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanKihonBuilder createBuilderForEdit() {
        return new ShokanKihonBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

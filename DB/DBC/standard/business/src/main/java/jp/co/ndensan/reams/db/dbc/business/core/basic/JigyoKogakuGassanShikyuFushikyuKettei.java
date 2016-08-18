/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 事業高額合算支給不支給決定を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 chenyadong
 */
public class JigyoKogakuGassanShikyuFushikyuKettei
        extends
        ModelBase<JigyoKogakuKetteiIdentifier, DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity, JigyoKogakuGassanShikyuFushikyuKettei>
        implements Serializable {

//TODO NetBeansの機能を使って必ずequalsとhashCodeを追加してください。
    private final DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity;
    private final JigyoKogakuKetteiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 事業高額合算支給不支給決定の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 保険者番号 保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 履歴番号 履歴番号
     */
    public JigyoKogakuGassanShikyuFushikyuKettei(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoNendo(対象年度);
        this.entity.setHokenshaNo(保険者番号);
        this.entity.setShikyuSeiriNo(支給申請書整理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new JigyoKogakuKetteiIdentifier(
                被保険者番号,
                対象年度,
                保険者番号,
                支給申請書整理番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity}より{@link JigyoKogakuGassanShikyuFushikyuKettei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity}
     */
    public JigyoKogakuGassanShikyuFushikyuKettei(DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額合算支給不支給決定"));
        this.id = new JigyoKogakuKetteiIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoNendo(),
                entity.getHokenshaNo(),
                entity.getShikyuSeiriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity}
     * @param id {@link JigyoKogakuKetteiIdentifier}
     */
    JigyoKogakuGassanShikyuFushikyuKettei(
            DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity,
            JigyoKogakuKetteiIdentifier id
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
        return entity.getHihokenshaNo();
    }

    /**
     * 対象年度を返します。
     *
     * @return 対象年度
     */
    public FlexibleYear get対象年度() {
        return entity.getTaishoNendo();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return entity.getHokenshaNo();
    }

    /**
     * 支給申請書整理番号を返します。
     *
     * @return 支給申請書整理番号
     */
    public RString get支給申請書整理番号() {
        return entity.getShikyuSeiriNo();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 自己負担額証明書整理番号を返します。
     *
     * @return 自己負担額証明書整理番号
     */
    public RString get自己負担額証明書整理番号() {
        return entity.getJikoFutanSeiriNo();
    }

    /**
     * 保険制度コードを返します。
     *
     * @return 保険制度コード
     */
    public RString get保険制度コード() {
        return entity.getHokenSeidoCode();
    }

    /**
     * 国保 被保険者証記号を返します。
     *
     * @return 国保 被保険者証記号
     */
    public RString get国保_被保険者証記号() {
        return entity.getKokuho_HihokenshaShoKigo();
    }

    /**
     * 対象計算期間開始年月日を返します。
     *
     * @return 対象計算期間開始年月日
     */
    public FlexibleDate get対象計算期間開始年月日() {
        return entity.getKeisanKaishiYMD();
    }

    /**
     * 対象計算期間終了年月日を返します。
     *
     * @return 対象計算期間終了年月日
     */
    public FlexibleDate get対象計算期間終了年月日() {
        return entity.getKeisanShuryoYMD();
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 自己負担総額を返します。
     *
     * @return 自己負担総額
     */
    public Decimal get自己負担総額() {
        return entity.getJikoFutanSogaku();
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
     * 支給額を返します。
     *
     * @return 支給額
     */
    public Decimal get支給額() {
        return entity.getShikyugaku();
    }

    /**
     * 給付の種類を返します。
     *
     * @return 給付の種類
     */
    public RString get給付の種類() {
        return entity.getKyufuShurui();
    }

    /**
     * 不支給理由を返します。
     *
     * @return 不支給理由
     */
    public RString get不支給理由() {
        return entity.getFushikyuRiyu();
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
     * 支払方法区分を返します。
     *
     * @return 支払方法区分
     */
    public RString get支払方法区分() {
        return entity.getShiharaiHohoKubun();
    }

    /**
     * 支払場所を返します。
     *
     * @return 支払場所
     */
    public RString get支払場所() {
        return entity.getShiharaiBasho();
    }

    /**
     * 支払期間開始年月日を返します。
     *
     * @return 支払期間開始年月日
     */
    public FlexibleDate get支払期間開始年月日() {
        return entity.getShiharaiKaishiYMD();
    }

    /**
     * 支払期間終了年月日を返します。
     *
     * @return 支払期間終了年月日
     */
    public FlexibleDate get支払期間終了年月日() {
        return entity.getShiharaiShuryoYMD();
    }

    /**
     * 閉庁内容を返します。
     *
     * @return 閉庁内容
     */
    public RString get閉庁内容() {
        return entity.getHeichoNaiyo();
    }

    /**
     * 支払期間開始時間を返します。
     *
     * @return 支払期間開始時間
     */
    public RString get支払期間開始時間() {
        return entity.getShiharaiKaishiTime();
    }

    /**
     * 支払期間終了時間を返します。
     *
     * @return 支払期間終了時間
     */
    public RString get支払期間終了時間() {
        return entity.getShiharaiShuryoTime();
    }

    /**
     * 決定通知書作成年月日を返します。
     *
     * @return 決定通知書作成年月日
     */
    public FlexibleDate get決定通知書作成年月日() {
        return entity.getKetteiTsuchiSakuseiYMD();
    }

    /**
     * 振込通知書作成年月日を返します。
     *
     * @return 振込通知書作成年月日
     */
    public FlexibleDate get振込通知書作成年月日() {
        return entity.getFurikomiTsuchiSakuseiYMD();
    }

    /**
     * 受取年月を返します。
     *
     * @return 受取年月
     */
    public FlexibleYearMonth get受取年月() {
        return entity.getUketoriYM();
    }

    /**
     * 口座IDを返します。
     *
     * @return 口座ID
     */
    public long get口座ID() {
        return entity.getKozaid();
    }

    /**
     * データ作成区分を返します。
     *
     * @return データ作成区分
     */
    public RString getデータ作成区分() {
        return entity.getDataSakuseiKubun();
    }

    /**
     * {@link DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity}のクローンを返します。
     *
     * @return {@link DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity}のクローン
     */
    @Override
    public DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 事業高額合算支給不支給決定の識別子{@link JigyoKogakuKetteiIdentifier}を返します。
     *
     * @return 事業高額合算支給不支給決定の識別子{@link JigyoKogakuKetteiIdentifier}
     */
    @Override
    public JigyoKogakuKetteiIdentifier identifier() {
        return this.id;
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 保持する事業高額合算支給不支給決定を削除対象とします。<br/>
     * {@link DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JigyoKogakuGassanShikyuFushikyuKettei}
     */
    @Override
    public JigyoKogakuGassanShikyuFushikyuKettei deleted() {
        DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JigyoKogakuGassanShikyuFushikyuKettei(deletedEntity, id);
    }

    /**
     * {@link JigyoKogakuGassanShikyuFushikyuKettei}のシリアライズ形式を提供します。
     *
     * @return {@link JigyoKogakuGassanShikyuFushikyuKettei}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity;
        private final JigyoKogakuKetteiIdentifier id;

        private _SerializationProxy(DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity, JigyoKogakuKetteiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JigyoKogakuGassanShikyuFushikyuKettei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder createBuilderForEdit() {
        return new JigyoKogakuGassanShikyuFushikyuKetteiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

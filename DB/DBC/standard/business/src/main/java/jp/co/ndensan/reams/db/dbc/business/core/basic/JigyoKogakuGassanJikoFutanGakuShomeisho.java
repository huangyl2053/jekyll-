/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 事業高額合算自己負担額証明書を管理するクラスです。
 *
 * @reamsid_L DBC-4820-010 sunhaidi
 */
public class JigyoKogakuGassanJikoFutanGakuShomeisho
        extends ModelBase<JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier,
        DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity,
        JigyoKogakuGassanJikoFutanGakuShomeisho>
        implements Serializable {

    private final DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity entity;
    private final JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 事業高額合算自己負担額証明書の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 転入前保険者番号 転入前保険者番号
     * @param 履歴番号 履歴番号
     */
    public JigyoKogakuGassanJikoFutanGakuShomeisho(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            HokenshaNo 転入前保険者番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(転入前保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("転入前保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoNendo(対象年度);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        this.entity.setTennyumaeHokenshaNo(転入前保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                転入前保険者番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity}より{@link JigyoKogakuGassanJikoFutanGakuShomeisho}を生成します。
     *
     * @param entity DBより取得した{@link DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeisho(DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額合算自己負担額証明書"));
        this.id = new JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoNendo(),
                entity.getShokisaiHokenshaNo(),
                entity.getShikyuShinseishoSeiriNo(),
                entity.getTennyumaeHokenshaNo(),
                entity.getRirekiNo()
        );
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity}
     * @param id {@link JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier}
     */
    JigyoKogakuGassanJikoFutanGakuShomeisho(
            DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity entity,
            JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier id
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
    }

    /**
     * 支給申請書整理番号を返します。
     *
     * @return 支給申請書整理番号
     */
    public RString get支給申請書整理番号() {
        return entity.getShikyuShinseishoSeiriNo();
    }

    /**
     * 転入前保険者番号を返します。
     *
     * @return 転入前保険者番号
     */
    public HokenshaNo get転入前保険者番号() {
        return entity.getTennyumaeHokenshaNo();
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
     * 転入前保険者名を返します。
     *
     * @return 転入前保険者名
     */
    public RString get転入前保険者名() {
        return entity.getTennyumaeHokenshaMei();
    }

    /**
     * 対象計算期間開始年月日を返します。
     *
     * @return 対象計算期間開始年月日
     */
    public FlexibleDate get対象計算期間開始年月日() {
        return entity.getTaishoKeisanKaishiYMD();
    }

    /**
     * 対象計算期間終了年月日を返します。
     *
     * @return 対象計算期間終了年月日
     */
    public FlexibleDate get対象計算期間終了年月日() {
        return entity.getTaishoKeisanShuryoYMD();
    }

    /**
     * 被保険者期間開始年月日を返します。
     *
     * @return 被保険者期間開始年月日
     */
    public FlexibleDate get被保険者期間開始年月日() {
        return entity.getHihokenshaKaishiYMD();
    }

    /**
     * 被保険者期間終了年月日を返します。
     *
     * @return 被保険者期間終了年月日
     */
    public FlexibleDate get被保険者期間終了年月日() {
        return entity.getHihokenshaShuryoYMD();
    }

    /**
     * 発行年月日を返します。
     *
     * @return 発行年月日
     */
    public FlexibleDate get発行年月日() {
        return entity.getHakkoDate();
    }

    /**
     * 合計・自己負担額を返します。
     *
     * @return 合計・自己負担額
     */
    public Decimal get合計_自己負担額() {
        return entity.getGokei_JikoFutanGaku();
    }

    /**
     * 合計・70-74自己負担額（内訳）を返します。
     *
     * @return 合計・70-74自己負担額（内訳）
     */
    public Decimal get合計_70_74自己負担額_内訳() {
        return entity.getGokei_70_74JikoFutanGaku();
    }

    /**
     * 合計・70未満高額支給額を返します。
     *
     * @return 合計・70未満高額支給額
     */
    public Decimal get合計_70未満高額支給額() {
        return entity.getGokei_Under70KogakuShikyuGaku();
    }

    /**
     * 合計・70-74高額支給額を返します。
     *
     * @return 合計・70-74高額支給額
     */
    public Decimal get合計_70_74高額支給額() {
        return entity.getGokei_70_74KogakuShikyuGaku();
    }

    /**
     * 支給額計算結果連絡先郵便番号を返します。
     *
     * @return 支給額計算結果連絡先郵便番号
     */
    public YubinNo get支給額計算結果連絡先郵便番号() {
        return entity.getAtesakiYubinNo();
    }

    /**
     * 支給額計算結果連絡先住所を返します。
     *
     * @return 支給額計算結果連絡先住所
     */
    public RString get支給額計算結果連絡先住所() {
        return entity.getAtesakiShimei();
    }

    /**
     * 支給額計算結果連絡先名称1を返します。
     *
     * @return 支給額計算結果連絡先名称1
     */
    public RString get支給額計算結果連絡先名称1() {
        return entity.getAtesakiJusho();
    }

    /**
     * 支給額計算結果連絡先名称2を返します。
     *
     * @return 支給額計算結果連絡先名称2
     */
    public RString get支給額計算結果連絡先名称2() {
        return entity.getMadoguchi_TaishoshaHanteiCode();
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
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeDate();
    }

    /**
     * 支給額計算年月日を返します。
     *
     * @return 支給額計算年月日
     */
    public FlexibleDate get支給額計算年月日() {
        return entity.getShikyugakuKeisanDate();
    }

    /**
     * {@link DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity}のクローンを返します。
     *
     * @return {@link DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity}のクローン
     */
    @Override
    public DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 事業高額合算自己負担額証明書の識別子{@link JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier}を返します。
     *
     * @return 事業高額合算自己負担額証明書の識別子{@link JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier}
     */
    @Override
    public JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier identifier() {
        return this.id;
    }

    /**
     * 事業高額合算自己負担額証明書のみを変更対象とします。<br/>
     * {@link DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link JigyoKogakuGassanJikoFutanGakuShomeisho}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeisho modifiedModel() {
        DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new JigyoKogakuGassanJikoFutanGakuShomeisho(
                modifiedEntity, id);
    }

    /**
     * 保持する事業高額合算自己負担額証明書を削除対象とします。<br/>
     * {@link DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JigyoKogakuGassanJikoFutanGakuShomeisho}
     */
    @Override
    public JigyoKogakuGassanJikoFutanGakuShomeisho deleted() {
        DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JigyoKogakuGassanJikoFutanGakuShomeisho(deletedEntity, id);
    }

    /**
     * {@link JigyoKogakuGassanJikoFutanGakuShomeisho}のシリアライズ形式を提供します。
     *
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeisho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 3343053434990726321L;

        private final DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity entity;
        private final JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier id;

        private _SerializationProxy(DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity entity,
                JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JigyoKogakuGassanJikoFutanGakuShomeisho(this.entity, this.id);
        }

    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder createBuilderForEdit() {
        return new JigyoKogakuGassanJikoFutanGakuShomeishoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JigyoKogakuGassanJikoFutanGakuShomeisho other = (JigyoKogakuGassanJikoFutanGakuShomeisho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

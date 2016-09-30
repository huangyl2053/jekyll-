/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算支給額計算結果を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 huzongcheng
 */
public class KogakuGassanShikyuGakuKeisanKekka extends ModelBase<
        KogakuGassanShikyuGakuKeisanKekkaIdentifier, DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity, KogakuGassanShikyuGakuKeisanKekka>
        implements Serializable {

    private final DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity;
    private final KogakuGassanShikyuGakuKeisanKekkaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 高額合算支給額計算結果の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 履歴番号 履歴番号
     */
    public KogakuGassanShikyuGakuKeisanKekka(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoNendo(対象年度);
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KogakuGassanShikyuGakuKeisanKekkaIdentifier(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity}より{@link KogakuGassanShikyuGakuKeisanKekka}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity}
     */
    public KogakuGassanShikyuGakuKeisanKekka(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算支給額計算結果"));
        this.id = new KogakuGassanShikyuGakuKeisanKekkaIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoNendo(),
                entity.getShoKisaiHokenshaNo(),
                entity.getShikyuShinseishoSeiriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity}
     * @param id {@link KogakuGassanShikyuGakuKeisanKekkaIdentifier}
     */
    KogakuGassanShikyuGakuKeisanKekka(
            DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity,
            KogakuGassanShikyuGakuKeisanKekkaIdentifier id
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
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
     * 自己負担額証明書整理番号を返します。
     *
     * @return 自己負担額証明書整理番号
     */
    public RString get自己負担額証明書整理番号() {
        return entity.getJikoFutanSeiriNo();
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
     * 世帯負担総額を返します。
     *
     * @return 世帯負担総額
     */
    public Decimal get世帯負担総額() {
        return entity.getSetaiFutanSogaku();
    }

    /**
     * 介護等合算一部負担金等世帯合算額を返します。
     *
     * @return 介護等合算一部負担金等世帯合算額
     */
    public Decimal get介護等合算一部負担金等世帯合算額() {
        return entity.getSetaiGassanGaku();
    }

    /**
     * 70歳以上介護等合算一部負担金等世帯合算額を返します。
     *
     * @return 70歳以上介護等合算一部負担金等世帯合算額
     */
    public Decimal get70歳以上介護等合算一部負担金等世帯合算額() {
        return entity.getOver70_SetaiGassanGaku();
    }

    /**
     * 所得区分を返します。
     *
     * @return 所得区分
     */
    public RString get所得区分() {
        return entity.getShotokuKubun();
    }

    /**
     * 70歳以上の者に係る所得区分を返します。
     *
     * @return 70歳以上の者に係る所得区分
     */
    public RString get70歳以上の者に係る所得区分() {
        return entity.getOver70_ShotokuKubun();
    }

    /**
     * 介護等合算算定基準額を返します。
     *
     * @return 介護等合算算定基準額
     */
    public Decimal get介護等合算算定基準額() {
        return entity.getSanteiKijunGaku();
    }

    /**
     * 70歳以上介護等合算算定基準額を返します。
     *
     * @return 70歳以上介護等合算算定基準額
     */
    public Decimal get70歳以上介護等合算算定基準額() {
        return entity.getOver70_SanteiKijyunGaku();
    }

    /**
     * 世帯支給総額を返します。
     *
     * @return 世帯支給総額
     */
    public Decimal get世帯支給総額() {
        return entity.getSetaiShikyuSogaku();
    }

    /**
     * うち70歳以上分世帯支給総額を返します。
     *
     * @return うち70歳以上分世帯支給総額
     */
    public Decimal getうち70歳以上分世帯支給総額() {
        return entity.getOver70_SetaiShikyuSogaku();
    }

    /**
     * 按分後支給額を返します。
     *
     * @return 按分後支給額
     */
    public Decimal get按分後支給額() {
        return entity.getHonninShikyugaku();
    }

    /**
     * うち70歳以上分按分後支給額を返します。
     *
     * @return うち70歳以上分按分後支給額
     */
    public Decimal getうち70歳以上分按分後支給額() {
        return entity.getOver70_honninShikyugaku();
    }

    /**
     * 介護低所得者Ⅰ再計算実施の有無を返します。
     *
     * @return 介護低所得者Ⅰ再計算実施の有無
     */
    public RString get介護低所得者Ⅰ再計算実施の有無() {
        return entity.getTeiShotoku_1_SaiKeisanUmu();
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
     * 支給額計算結果連絡先郵便番号を返します。
     *
     * @return 支給額計算結果連絡先郵便番号
     */
    public YubinNo get支給額計算結果連絡先郵便番号() {
        return entity.getKekkaRenrakusakiYubinNo();
    }

    /**
     * 支給額計算結果連絡先住所を返します。
     *
     * @return 支給額計算結果連絡先住所
     */
    public RString get支給額計算結果連絡先住所() {
        return entity.getKekkaRenrakusakiJusho();
    }

    /**
     * 支給額計算結果連絡先名称1を返します。
     *
     * @return 支給額計算結果連絡先名称1
     */
    public RString get支給額計算結果連絡先名称1() {
        return entity.getKetteRenrakusakiMeisho1();
    }

    /**
     * 支給額計算結果連絡先名称2を返します。
     *
     * @return 支給額計算結果連絡先名称2
     */
    public RString get支給額計算結果連絡先名称2() {
        return entity.getKekkaRenrakusakiMeisho2();
    }

    /**
     * 通知年月日を返します。
     *
     * @return 通知年月日
     */
    public FlexibleDate get通知年月日() {
        return entity.getTsuchiYMD();
    }

    /**
     * 連絡票発行者名を返します。
     *
     * @return 連絡票発行者名
     */
    public AtenaMeisho get連絡票発行者名() {
        return entity.getRenrakuhyoHakkoshaMei();
    }

    /**
     * 連絡票発行者郵便番号を返します。
     *
     * @return 連絡票発行者郵便番号
     */
    public YubinNo get連絡票発行者郵便番号() {
        return entity.getRenrakuhyoHakkoshaYubinNo();
    }

    /**
     * 連絡票発行者住所を返します。
     *
     * @return 連絡票発行者住所
     */
    public RString get連絡票発行者住所() {
        return entity.getRenrakuhyoHakkoshaJusho();
    }

    /**
     * 問い合わせ先郵便番号を返します。
     *
     * @return 問い合わせ先郵便番号
     */
    public YubinNo get問い合わせ先郵便番号() {
        return entity.getToiawasesakiYobinNo();
    }

    /**
     * 問い合わせ先住所を返します。
     *
     * @return 問い合わせ先住所
     */
    public RString get問い合わせ先住所() {
        return entity.getToiawasesakiJusho();
    }

    /**
     * 問い合わせ先名称1を返します。
     *
     * @return 問い合わせ先名称1
     */
    public RString get問い合わせ先名称1() {
        return entity.getToiawasesakiMeisho1();
    }

    /**
     * 問い合わせ先名称2を返します。
     *
     * @return 問い合わせ先名称2
     */
    public RString get問い合わせ先名称2() {
        return entity.getToiawasesakiMeisho2();
    }

    /**
     * 問い合わせ先電話番号を返します。
     *
     * @return 問い合わせ先電話番号
     */
    public TelNo get問い合わせ先電話番号() {
        return entity.getToiawasesakiTelNo();
    }

    /**
     * 70歳以上負担額合計を返します。
     *
     * @return 70歳以上負担額合計
     */
    public Decimal get70歳以上負担額合計() {
        return entity.getOver70_FutangakuGokei();
    }

    /**
     * 70歳以上支給額合計を返します。
     *
     * @return 70歳以上支給額合計
     */
    public Decimal get70歳以上支給額合計() {
        return entity.getOver70_ShikyugakuGokei();
    }

    /**
     * 70歳未満負担額合計を返します。
     *
     * @return 70歳未満負担額合計
     */
    public Decimal get70歳未満負担額合計() {
        return entity.getUnder70_FutangakuGokei();
    }

    /**
     * 負担額の合計額を返します。
     *
     * @return 負担額の合計額
     */
    public Decimal get負担額の合計額() {
        return entity.getFutangakuGokei();
    }

    /**
     * 70歳未満支給額合計を返します。
     *
     * @return 70歳未満支給額合計
     */
    public Decimal get70歳未満支給額合計() {
        return entity.getUnder70_ShikyugakuGokei();
    }

    /**
     * 支給額合計額を返します。
     *
     * @return 支給額合計額
     */
    public Decimal get支給額合計額() {
        return entity.getShikyugakuGokei();
    }

    /**
     * データ区分を返します。
     *
     * @return データ区分
     */
    public RString getデータ区分() {
        return entity.getDataKubun();
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
     * 送付年月を返します。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get送付年月() {
        return entity.getSofuYM();
    }

    /**
     * 再送フラグを返します。
     *
     * @return 送付年月
     */
    public RString get再送フラグ() {
        return entity.getSaisoFG();
    }

    /**
     * 支給額計算結果連絡票作成年月日を返します。
     *
     * @return 送付年月
     */
    public FlexibleDate get支給額計算結果連絡票作成年月日() {
        return entity.getSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD();
    }

    /**
     * {@link DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity}のクローンを返します。
     *
     * @return {@link DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity}のクローン
     */
    @Override
    public DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 高額合算支給額計算結果の識別子{@link KogakuGassanShikyuGakuKeisanKekkaIdentifier}を返します。
     *
     * @return
     * 高額合算支給額計算結果の識別子{@link KogakuGassanShikyuGakuKeisanKekkaIdentifier}
     */
    @Override
    public KogakuGassanShikyuGakuKeisanKekkaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する高額合算支給額計算結果を削除対象とします。<br/>
     * {@link DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KogakuGassanShikyuGakuKeisanKekka}
     */
    @Override
    public KogakuGassanShikyuGakuKeisanKekka deleted() {
        DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KogakuGassanShikyuGakuKeisanKekka(deletedEntity, id);
    }

    /**
     * {@link KogakuGassanShikyuGakuKeisanKekka}のシリアライズ形式を提供します。
     *
     * @return {@link KogakuGassanShikyuGakuKeisanKekka}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity;
        private final KogakuGassanShikyuGakuKeisanKekkaIdentifier id;

        private _SerializationProxy(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity, KogakuGassanShikyuGakuKeisanKekkaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KogakuGassanShikyuGakuKeisanKekka(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KogakuGassanShikyuGakuKeisanKekkaBuilder createBuilderForEdit() {
        return new KogakuGassanShikyuGakuKeisanKekkaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

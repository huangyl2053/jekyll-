/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算自己負担額を管理するクラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class KogakuGassanJikoFutanGaku
        extends ModelBase<KogakuGassanJikoFutanGakuIdentifier, DbT3070KogakuGassanJikoFutanGakuEntity, KogakuGassanJikoFutanGaku>
        implements Serializable {

    private final DbT3070KogakuGassanJikoFutanGakuEntity entity;
    private final KogakuGassanJikoFutanGakuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 高額合算自己負担額の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 保険者番号 保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 履歴番号 履歴番号
     */
    public KogakuGassanJikoFutanGaku(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3070KogakuGassanJikoFutanGakuEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoNendo(対象年度);
        this.entity.setHokenshaNo(保険者番号);
        this.entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KogakuGassanJikoFutanGakuIdentifier(
                被保険者番号,
                対象年度,
                保険者番号,
                支給申請書整理番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3070KogakuGassanJikoFutanGakuEntity}より{@link KogakuGassanJikoFutanGaku}を生成します。
     *
     * @param entity DBより取得した{@link DbT3070KogakuGassanJikoFutanGakuEntity}
     */
    public KogakuGassanJikoFutanGaku(DbT3070KogakuGassanJikoFutanGakuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算自己負担額"));
        this.id = new KogakuGassanJikoFutanGakuIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoNendo(),
                entity.getHokenshaNo(),
                entity.getShikyuShinseishoSeiriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3070KogakuGassanJikoFutanGakuEntity}
     * @param id {@link KogakuGassanJikoFutanGakuIdentifier}
     */
    KogakuGassanJikoFutanGaku(
            DbT3070KogakuGassanJikoFutanGakuEntity entity,
            KogakuGassanJikoFutanGakuIdentifier id
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
     * 保険者名を返します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return entity.getHokenshaMei();
    }

    /**
     * 国保被保険者証記号を返します。
     *
     * @return 国保被保険者証記号
     */
    public RString get国保被保険者証記号() {
        return entity.getKokuho_HihokenshaShoKigo();
    }

    /**
     * 被保険者氏名カナを返します。
     *
     * @return 被保険者氏名カナ
     */
    public AtenaKanaMeisho get被保険者氏名カナ() {
        return entity.getHihokenshaShimeiKana();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.getHihokenshaShimei();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getUmareYMD();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Code get性別() {
        return entity.getSeibetsuCode();
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
     * 自己負担額証明書整理番号を返します。
     *
     * @return 自己負担額証明書整理番号
     */
    public RString get自己負担額証明書整理番号() {
        return entity.getJikoFutanSeiriNo();
    }

    /**
     * 後期保険者番号を返します。
     *
     * @return 後期保険者番号
     */
    public RString get後期保険者番号() {
        return entity.getKoki_HokenshaNo();
    }

    /**
     * 後期被保険者番号を返します。
     *
     * @return 後期被保険者番号
     */
    public RString get後期被保険者番号() {
        return entity.getKoki_HihokenshaNo();
    }

    /**
     * 国保保険者番号を返します。
     *
     * @return 国保保険者番号
     */
    public RString get国保保険者番号() {
        return entity.getKokuho_HokenshaNo();
    }

    /**
     * 国保被保険者証番号を返します。
     *
     * @return 国保被保険者証番号
     */
    public RString get国保被保険者証番号() {
        return entity.getKokuho_HihokenshaShoNo();
    }

    /**
     * 国保個人番号を返します。
     *
     * @return 国保個人番号
     */
    public RString get国保個人番号() {
        return entity.getKokuho_KojinNo();
    }

    /**
     * 異動区分を返します。
     *
     * @return 異動区分
     */
    public RString get異動区分() {
        return entity.getIdoKubun();
    }

    /**
     * 補正済自己負担額送付区分を返します。
     *
     * @return 補正済自己負担額送付区分
     */
    public RString get補正済自己負担額送付区分() {
        return entity.getHoseiZumiSofuKubun();
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
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 合計_自己負担額を返します。
     *
     * @return 合計_自己負担額
     */
    public Decimal get合計_自己負担額() {
        return entity.getGokei_JikoFutanGaku();
    }

    /**
     * 合計_70_74自己負担額_内訳を返します。
     *
     * @return 合計_70_74自己負担額_内訳
     */
    public Decimal get合計_70_74自己負担額_内訳() {
        return entity.getGokei_70_74JikoFutanGaku();
    }

    /**
     * 合計_70未満高額支給額を返します。
     *
     * @return 合計_70未満高額支給額
     */
    public Decimal get合計_70未満高額支給額() {
        return entity.getGokei_Under70KogakuShikyuGaku();
    }

    /**
     * 合計_70_74高額支給額を返します。
     *
     * @return 合計_70_74高額支給額
     */
    public Decimal get合計_70_74高額支給額() {
        return entity.getGokei_70_74KogakuShikyuGaku();
    }

    /**
     * 補正済_合計_自己負担額を返します。
     *
     * @return 補正済_合計_自己負担額
     */
    public Decimal get補正済_合計_自己負担額() {
        return entity.getSumi_Gokei_JikoFutanGaku();
    }

    /**
     * 補正済_合計_70_74自己負担額_内訳を返します。
     *
     * @return 補正済_合計_70_74自己負担額_内訳
     */
    public Decimal get補正済_合計_70_74自己負担額_内訳() {
        return entity.getSumi_Gokei_70_74JikoFutanGaku();
    }

    /**
     * 補正済_合計_70未満高額支給額を返します。
     *
     * @return 補正済_合計_70未満高額支給額
     */
    public Decimal get補正済_合計_70未満高額支給額() {
        return entity.getSumi_Gokei_Under70KogakuShikyuGaku();
    }

    /**
     * 補正済_合計_70_74高額支給額を返します。
     *
     * @return 補正済_合計_70_74高額支給額
     */
    public Decimal get補正済_合計_70_74高額支給額() {
        return entity.getSumi_Gokei_70_74KogakuShikyuGaku();
    }

    /**
     * 宛先氏名を返します。
     *
     * @return 宛先氏名
     */
    public AtenaMeisho get宛先氏名() {
        return entity.getAtesakiShimei();
    }

    /**
     * 宛先郵便番号を返します。
     *
     * @return 宛先郵便番号
     */
    public YubinNo get宛先郵便番号() {
        return entity.getAtesakiYubinNo();
    }

    /**
     * 宛先住所を返します。
     *
     * @return 宛先住所
     */
    public RString get宛先住所() {
        return entity.getAtesakiJusho();
    }

    /**
     * 窓口払対象者判定コードを返します。
     *
     * @return 窓口払対象者判定コード
     */
    public RString get窓口払対象者判定コード() {
        return entity.getMadoguchi_TaishoshaHanteiCode();
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
        return entity.getShikaraiKaishiYMD();
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
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
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
     * 自己負担額確認情報受取年月を返します。
     *
     * @return 自己負担額確認情報受取年月
     */
    public FlexibleYearMonth get自己負担額確認情報受取年月() {
        return entity.getKakunin_UketoriYM();
    }

    /**
     * 補正済自己負担額情報送付年月を返します。
     *
     * @return 補正済自己負担額情報送付年月
     */
    public FlexibleYearMonth get補正済自己負担額情報送付年月() {
        return entity.getHoseiZumi_SofuYM();
    }

    /**
     * 自己負担額証明書情報受取年月を返します。
     *
     * @return 自己負担額証明書情報受取年月
     */
    public FlexibleYearMonth get自己負担額証明書情報受取年月() {
        return entity.getShomeisho_UketoriYM();
    }

    /**
     * 再送フラグを返します。
     *
     * @return 再送フラグ
     */
    public RString get再送フラグ() {
        return entity.getSaisoFlag();
    }

    /**
     * 送付対象外フラグを返します。
     *
     * @return 送付対象外フラグ
     */
    public RString get送付対象外フラグ() {
        return entity.getSofuTaishoGaiFlag();
    }

    /**
     * 自己負担額計算年月日を返します。
     *
     * @return 自己負担額計算年月日
     */
    public FlexibleDate get自己負担額計算年月日() {
        return entity.getJikoFutanKeisanYMD();
    }

    /**
     * 自己負担額証明書作成年月日を返します。
     *
     * @return 自己負担額証明書作成年月日
     */
    public FlexibleDate get自己負担額証明書作成年月日() {
        return entity.getShomeiShoSakuseiYMD();
    }

    /**
     * 後期_国保処理区分を返します。
     *
     * @return 後期_国保処理区分
     */
    public RString get後期_国保処理区分() {
        return entity.getKoki_KokuhoShoriKubun();
    }

    /**
     * リアル補正実施年月日を返します。
     *
     * @return リアル補正実施年月日
     */
    public FlexibleDate getリアル補正実施年月日() {
        return entity.getRealHoseiJissiYMD();
    }

    /**
     * {@link DbT3070KogakuGassanJikoFutanGakuEntity}のクローンを返します。
     *
     * @return {@link DbT3070KogakuGassanJikoFutanGakuEntity}のクローン
     */
    @Override
    public DbT3070KogakuGassanJikoFutanGakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 高額合算自己負担額の識別子{@link KogakuGassanJikoFutanGakuIdentifier}を返します。
     *
     * @return 高額合算自己負担額の識別子{@link KogakuGassanJikoFutanGakuIdentifier}
     */
    @Override
    public KogakuGassanJikoFutanGakuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する高額合算自己負担額を削除対象とします。<br/>
     * {@link DbT3070KogakuGassanJikoFutanGakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KogakuGassanJikoFutanGaku}
     */
    @Override
    public KogakuGassanJikoFutanGaku deleted() {
        DbT3070KogakuGassanJikoFutanGakuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KogakuGassanJikoFutanGaku(deletedEntity, id);
    }

    /**
     * {@link KogakuGassanJikoFutanGaku}のシリアライズ形式を提供します。
     *
     * @return {@link KogakuGassanJikoFutanGaku}のシリアライズ形式
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

        private final DbT3070KogakuGassanJikoFutanGakuEntity entity;
        private final KogakuGassanJikoFutanGakuIdentifier id;

        private _SerializationProxy(DbT3070KogakuGassanJikoFutanGakuEntity entity, KogakuGassanJikoFutanGakuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KogakuGassanJikoFutanGaku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KogakuGassanJikoFutanGakuBuilder createBuilderForEdit() {
        return new KogakuGassanJikoFutanGakuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

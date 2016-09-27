/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算支給額計算結果明細を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 huzongcheng
 */
public class KogakuGassanShikyugakuKeisanKekkaMeisai 
    extends ModelBase<KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier, 
            DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity, 
            KogakuGassanShikyugakuKeisanKekkaMeisai> 
    implements Serializable {

    private final DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity;
    private final KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 高額合算支給額計算結果明細の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 明細番号 明細番号
     * @param 履歴番号 履歴番号
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisai(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            RString 明細番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoNendo(対象年度);
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        this.entity.setMeisanNo(明細番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                明細番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity}より{@link KogakuGassanShikyugakuKeisanKekkaMeisai}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisai(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算支給額計算結果明細"));
        this.id = new KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoNendo(),
                entity.getShoKisaiHokenshaNo(),
                entity.getShikyuShinseishoSeiriNo(),
                entity.getMeisanNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity
     * {@link DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity}
     * @param id {@link KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier}
     */
    KogakuGassanShikyugakuKeisanKekkaMeisai(
            DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity,
            KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier id
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
     * 明細番号を返します。
     *
     * @return 明細番号
     */
    public RString get明細番号() {
        return entity.getMeisanNo();
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
     * 保険制度コードを返します。
     *
     * @return 保険制度コード
     */
    public RString get保険制度コード() {
        return entity.getHokenSeidoCode();
    }

    /**
     * 内訳保険者番号を返します。
     *
     * @return 内訳保険者番号
     */
    public RString get内訳保険者番号() {
        return entity.getUchiwakeHokenshaNo();
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
     * 被保険者_証番号を返します。
     *
     * @return 被保険者_証番号
     */
    public RString get被保険者_証番号() {
        return entity.getHiHokenshaShoNo();
    }

    /**
     * 内訳保険者名を返します。
     *
     * @return 内訳保険者名
     */
    public RString get内訳保険者名() {
        return entity.getUchiwakeHokenshaMei();
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
     * 対象者氏名_漢字を返します。
     *
     * @return 対象者氏名_漢字
     */
    public RString get対象者氏名_漢字() {
        return entity.getTaishoshaShimei();
    }

    /**
     * 70歳以上負担額を返します。
     *
     * @return 70歳以上負担額
     */
    public RString get70歳以上負担額() {
        return entity.getOver70_Futangaku();
    }

    /**
     * 70歳以上按分率を返します。
     *
     * @return 70歳以上按分率
     */
    public RString get70歳以上按分率() {
        return entity.getOver70_AmbunRitsu();
    }

    /**
     * 70歳以上支給額を返します。
     *
     * @return 70歳以上支給額
     */
    public RString get70歳以上支給額() {
        return entity.getOver70_Shikyugaku();
    }

    /**
     * 70歳未満負担額を返します。
     *
     * @return 70歳未満負担額
     */
    public RString get70歳未満負担額() {
        return entity.getUnder70_Futangaku();
    }

    /**
     * 負担額を返します。
     *
     * @return 負担額
     */
    public RString get負担額() {
        return entity.getFutangaku();
    }

    /**
     * 按分率を返します。
     *
     * @return 按分率
     */
    public RString get按分率() {
        return entity.getAmbunRitsu();
    }

    /**
     * 70歳未満支給額を返します。
     *
     * @return 70歳未満支給額
     */
    public RString get70歳未満支給額() {
        return entity.getUnder70_Shikyugaku();
    }

    /**
     * 支給額を返します。
     *
     * @return 支給額
     */
    public RString get支給額() {
        return entity.getShikyugaku();
    }

    /**
     * 備考欄記載70歳以上負担額を返します。
     *
     * @return 備考欄記載70歳以上負担額
     */
    public RString get備考欄記載70歳以上負担額() {
        return entity.getOver70_Biko();
    }

    /**
     * 備考欄記載70歳未満負担額を返します。
     *
     * @return 備考欄記載70歳未満負担額
     */
    public RString get備考欄記載70歳未満負担額() {
        return entity.getUnder70_Biko();
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
     * {@link DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity}のクローン
     */
    @Override
    public DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 高額合算支給額計算結果明細の識別子{@link KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier}を返します。
     *
     * @return
     * 高額合算支給額計算結果明細の識別子{@link KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier}
     */
    @Override
    public KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する高額合算支給額計算結果明細を削除対象とします。<br/>
     * {@link DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KogakuGassanShikyugakuKeisanKekkaMeisai}
     */
    @Override
    public KogakuGassanShikyugakuKeisanKekkaMeisai deleted() {
        DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KogakuGassanShikyugakuKeisanKekkaMeisai(deletedEntity, id);
    }

    /**
     * {@link KogakuGassanShikyugakuKeisanKekkaMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisai}のシリアライズ形式
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

        private final DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity;
        private final KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier id;

        private _SerializationProxy(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity,
                KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

//        private Object readResolve() {
//            return new KogakuGassanShikyugakuKeisanKekkaMeisai(this.entity, this.id);
//        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder createBuilderForEdit() {
        return new KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

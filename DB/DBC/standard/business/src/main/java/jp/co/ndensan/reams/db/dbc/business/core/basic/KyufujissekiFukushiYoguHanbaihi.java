/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績福祉用具販売費を管理するクラスです。
 */
public class KyufujissekiFukushiYoguHanbaihi 
extends ModelBase<KyufujissekiFukushiYoguHanbaihiIdentifier, 
        DbT3026KyufujissekiFukushiYoguHanbaihiEntity,
        KyufujissekiFukushiYoguHanbaihi> implements Serializable {

    private final DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity;
    private final KyufujissekiFukushiYoguHanbaihiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績福祉用具販売費の新規作成時に使用します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 通し番号 通し番号
     * @param 明細番号 明細番号
     */
    public KyufujissekiFukushiYoguHanbaihi(KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号,
            RString 明細番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        this.entity = new DbT3026KyufujissekiFukushiYoguHanbaihiEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setToshiNo(通し番号);
        this.entity.setMeisaiNo(明細番号);
        this.id = new KyufujissekiFukushiYoguHanbaihiIdentifier(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号,
                明細番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3026KyufujissekiFukushiYoguHanbaihiEntity}より{@link KyufujissekiFukushiYoguHanbaihi}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3026KyufujissekiFukushiYoguHanbaihiEntity}
     */
    public KyufujissekiFukushiYoguHanbaihi(DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績福祉用具販売費"));
        this.id = new KyufujissekiFukushiYoguHanbaihiIdentifier(
                entity.getKokanJohoShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getShokisaiHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshoNo(),
                entity.getToshiNo(),
                entity.getMeisaiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3026KyufujissekiFukushiYoguHanbaihiEntity}
     * @param id {@link KyufujissekiFukushiYoguHanbaihiIdentifier}
     */
    KyufujissekiFukushiYoguHanbaihi(
            DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity,
            KyufujissekiFukushiYoguHanbaihiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo get交換情報識別番号() {
        return entity.getKokanJohoShikibetsuNo();
    }

    /**
     * 入力識別番号を返します。
     *
     * @return 入力識別番号
     */
    public NyuryokuShikibetsuNo get入力識別番号() {
        return entity.getInputShikibetsuNo();
    }

    /**
     * レコード種別コードを返します。
     *
     * @return レコード種別コード
     */
    public RString getレコード種別コード() {
        return entity.getRecodeShubetsuCode();
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
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
    }

    /**
     * 通し番号を返します。
     *
     * @return 通し番号
     */
    public RString get通し番号() {
        return entity.getToshiNo();
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
     * サービスコードを返します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード() {
        return entity.getServiceCode();
    }

    /**
     * 福祉用具販売年月日を返します。
     *
     * @return 福祉用具販売年月日
     */
    public FlexibleDate get福祉用具販売年月日() {
        return entity.getFukushiyoguHanbaiYMD();
    }

    /**
     * 福祉用具商品名を返します。
     *
     * @return 福祉用具商品名
     */
    public RString get福祉用具商品名() {
        return entity.getFukushiyoguShohinName();
    }

    /**
     * 福祉用具種目コードを返します。
     *
     * @return 福祉用具種目コード
     */
    public RString get福祉用具種目コード() {
        return entity.getFukushiyoguSyumokuCode();
    }

    /**
     * 福祉用具製造事業者名を返します。
     *
     * @return 福祉用具製造事業者名
     */
    public RString get福祉用具製造事業者名() {
        return entity.getFukushiyoguSeizoJigyoshaName();
    }

    /**
     * 福祉用具販売事業者名を返します。
     *
     * @return 福祉用具販売事業者名
     */
    public RString get福祉用具販売事業者名() {
        return entity.getFukushiyoguHanbaiJigyoshaName();
    }

    /**
     * 販売金額を返します。
     *
     * @return 販売金額
     */
    public Decimal get販売金額() {
        return entity.getHanbaiKingaku();
    }

    /**
     * 摘要（品目コード）を返します。
     *
     * @return 摘要（品目コード）
     */
    public RString get摘要_品目コード() {
        return entity.getTekiyo();
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
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
    }

    /**
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.getTorikomiYM();
    }

    /**
     * {@link DbT3026KyufujissekiFukushiYoguHanbaihiEntity}のクローンを返します。
     *
     * @return {@link DbT3026KyufujissekiFukushiYoguHanbaihiEntity}のクローン
     */
    @Override
    public DbT3026KyufujissekiFukushiYoguHanbaihiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績福祉用具販売費の識別子{@link KyufujissekiFukushiYoguHanbaihiIdentifier}を返します。
     *
     * @return 給付実績福祉用具販売費の識別子{@link KyufujissekiFukushiYoguHanbaihiIdentifier}
     */
    @Override
    public KyufujissekiFukushiYoguHanbaihiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績福祉用具販売費を削除対象とします。<br/>
     * {@link DbT3026KyufujissekiFukushiYoguHanbaihiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufujissekiFukushiYoguHanbaihi}
     */
    @Override
    public KyufujissekiFukushiYoguHanbaihi deleted() {
        DbT3026KyufujissekiFukushiYoguHanbaihiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufujissekiFukushiYoguHanbaihi(deletedEntity, id);
    }

    /**
     * {@link KyufujissekiFukushiYoguHanbaihi}のシリアライズ形式を提供します。
     *
     * @return {@link KyufujissekiFukushiYoguHanbaihi}のシリアライズ形式
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

        private final DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity;
        private final KyufujissekiFukushiYoguHanbaihiIdentifier id;

        private _SerializationProxy(DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity, KyufujissekiFukushiYoguHanbaihiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufujissekiFukushiYoguHanbaihi(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufujissekiFukushiYoguHanbaihiBuilder createBuilderForEdit() {
        return new KyufujissekiFukushiYoguHanbaihiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

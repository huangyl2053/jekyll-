/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3027KyufujissekiJutakuKaishuhiEntity;
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
 * 給付実績住宅改修費を管理するクラスです。
 */
public class KyufujissekiJutakuKaishuhi 
extends ModelBase<KyufujissekiJutakuKaishuhiIdentifier, 
        DbT3027KyufujissekiJutakuKaishuhiEntity, 
        KyufujissekiJutakuKaishuhi> implements Serializable {

    private final DbT3027KyufujissekiJutakuKaishuhiEntity entity;
    private final KyufujissekiJutakuKaishuhiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績住宅改修費の新規作成時に使用します。
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
    public KyufujissekiJutakuKaishuhi(KokanShikibetsuNo 交換情報識別番号,
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
        this.entity = new DbT3027KyufujissekiJutakuKaishuhiEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setToshiNo(通し番号);
        this.entity.setMeisaiNo(明細番号);
        this.id = new KyufujissekiJutakuKaishuhiIdentifier(
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
     * DBより取得した{@link DbT3027KyufujissekiJutakuKaishuhiEntity}より{@link KyufujissekiJutakuKaishuhi}を生成します。
     *
     * @param entity DBより取得した{@link DbT3027KyufujissekiJutakuKaishuhiEntity}
     */
    public KyufujissekiJutakuKaishuhi(DbT3027KyufujissekiJutakuKaishuhiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績住宅改修費"));
        this.id = new KyufujissekiJutakuKaishuhiIdentifier(
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
     * @param entity {@link DbT3027KyufujissekiJutakuKaishuhiEntity}
     * @param id {@link KyufujissekiJutakuKaishuhiIdentifier}
     */
    KyufujissekiJutakuKaishuhi(
            DbT3027KyufujissekiJutakuKaishuhiEntity entity,
            KyufujissekiJutakuKaishuhiIdentifier id
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
     * 住宅改修着工年月日を返します。
     *
     * @return 住宅改修着工年月日
     */
    public FlexibleDate get住宅改修着工年月日() {
        return entity.getJutakuKaishuchakkoYMD();
    }

    /**
     * 住宅改修事業者名を返します。
     *
     * @return 住宅改修事業者名
     */
    public RString get住宅改修事業者名() {
        return entity.getJutakuKaishuJigyoshaName();
    }

    /**
     * 住宅改修住宅住所を返します。
     *
     * @return 住宅改修住宅住所
     */
    public RString get住宅改修住宅住所() {
        return entity.getJuutakukaishuJyutakuAdress();
    }

    /**
     * 改修金額を返します。
     *
     * @return 改修金額
     */
    public Decimal get改修金額() {
        return entity.getKaishuKingaku();
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
     * {@link DbT3027KyufujissekiJutakuKaishuhiEntity}のクローンを返します。
     *
     * @return {@link DbT3027KyufujissekiJutakuKaishuhiEntity}のクローン
     */
    @Override
    public DbT3027KyufujissekiJutakuKaishuhiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績住宅改修費の識別子{@link KyufujissekiJutakuKaishuhiIdentifier}を返します。
     *
     * @return 給付実績住宅改修費の識別子{@link KyufujissekiJutakuKaishuhiIdentifier}
     */
    @Override
    public KyufujissekiJutakuKaishuhiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績住宅改修費を削除対象とします。<br/>
     * {@link DbT3027KyufujissekiJutakuKaishuhiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufujissekiJutakuKaishuhi}
     */
    @Override
    public KyufujissekiJutakuKaishuhi deleted() {
        DbT3027KyufujissekiJutakuKaishuhiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufujissekiJutakuKaishuhi(deletedEntity, id);
    }

    /**
     * {@link KyufujissekiJutakuKaishuhi}のシリアライズ形式を提供します。
     *
     * @return {@link KyufujissekiJutakuKaishuhi}のシリアライズ形式
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

        private final DbT3027KyufujissekiJutakuKaishuhiEntity entity;
        private final KyufujissekiJutakuKaishuhiIdentifier id;

        private _SerializationProxy(DbT3027KyufujissekiJutakuKaishuhiEntity entity, KyufujissekiJutakuKaishuhiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufujissekiJutakuKaishuhi(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufujissekiJutakuKaishuhiBuilder createBuilderForEdit() {
        return new KyufujissekiJutakuKaishuhiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

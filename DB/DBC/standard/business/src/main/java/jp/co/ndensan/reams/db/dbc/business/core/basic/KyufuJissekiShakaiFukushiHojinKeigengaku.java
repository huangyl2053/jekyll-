/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績社会福祉法人軽減額を管理するクラスです。
 */
public class KyufuJissekiShakaiFukushiHojinKeigengaku 
extends ModelBase<KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier,
        DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity, 
        KyufuJissekiShakaiFukushiHojinKeigengaku> implements Serializable {

    private final DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity;
    private final KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績社会福祉法人軽減額の新規作成時に使用します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 通し番号 通し番号
     * @param サービス種類コード サービス種類コード
     */
    public KyufuJissekiShakaiFukushiHojinKeigengaku(KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号,
            ServiceShuruiCode サービス種類コード) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        this.entity = new DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setToshiNo(通し番号);
        this.entity.setServiceSyuruiCode(サービス種類コード);
        this.id = new KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号,
                サービス種類コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity}より{@link KyufuJissekiShakaiFukushiHojinKeigengaku}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengaku(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績社会福祉法人軽減額"));
        this.id = new KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier(
                entity.getKokanJohoShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getShokisaiHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshoNo(),
                entity.getToshiNo(),
                entity.getServiceSyuruiCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity
     * {@link DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity}
     * @param id {@link KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier}
     */
    KyufuJissekiShakaiFukushiHojinKeigengaku(
            DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity,
            KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier id
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
     * 軽減率を返します。
     *
     * @return 軽減率
     */
    public Decimal get軽減率() {
        return entity.getKeigenritsu();
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceSyuruiCode();
    }

    /**
     * 受領すべき利用者負担の総額を返します。
     *
     * @return 受領すべき利用者負担の総額
     */
    public Decimal get受領すべき利用者負担の総額() {
        return entity.getRiyoshaFutanTotal();
    }

    /**
     * 軽減額を返します。
     *
     * @return 軽減額
     */
    public Decimal get軽減額() {
        return entity.getKeigengaku();
    }

    /**
     * 軽減後利用者負担額を返します。
     *
     * @return 軽減後利用者負担額
     */
    public Decimal get軽減後利用者負担額() {
        return entity.getKeigengoRiyoshaFutangaku();
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
     * 後_受領すべき利用者負担の総額を返します。
     *
     * @return 後_受領すべき利用者負担の総額
     */
    public Decimal get後_受領すべき利用者負担の総額() {
        return entity.getAtoRiyoshaFutanTotal();
    }

    /**
     * 後_軽減額を返します。
     *
     * @return 後_軽減額
     */
    public Decimal get後_軽減額() {
        return entity.getAtoKeigengaku();
    }

    /**
     * 後_軽減後利用者負担額を返します。
     *
     * @return 後_軽減後利用者負担額
     */
    public Decimal get後_軽減後利用者負担額() {
        return entity.getAtoKeigengoRiyoshaFutangaku();
    }

    /**
     * 再審査回数を返します。
     *
     * @return 再審査回数
     */
    public Decimal get再審査回数() {
        return entity.getSaishinsaKaisu();
    }

    /**
     * 過誤回数を返します。
     *
     * @return 過誤回数
     */
    public Decimal get過誤回数() {
        return entity.getKagoKaisu();
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
     * {@link DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity}のクローンを返します。
     *
     * @return
     * {@link DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity}のクローン
     */
    @Override
    public DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績社会福祉法人軽減額の識別子{@link KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier}を返します。
     *
     * @return
     * 給付実績社会福祉法人軽減額の識別子{@link KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier}
     */
    @Override
    public KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績社会福祉法人軽減額を削除対象とします。<br/>
     * {@link DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufuJissekiShakaiFukushiHojinKeigengaku}
     */
    @Override
    public KyufuJissekiShakaiFukushiHojinKeigengaku deleted() {
        DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufuJissekiShakaiFukushiHojinKeigengaku(deletedEntity, id);
    }

    /**
     * {@link KyufuJissekiShakaiFukushiHojinKeigengaku}のシリアライズ形式を提供します。
     *
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengaku}のシリアライズ形式
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

        private final DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity;
        private final KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier id;

        private _SerializationProxy(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity, 
                KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufuJissekiShakaiFukushiHojinKeigengaku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder createBuilderForEdit() {
        return new KyufuJissekiShakaiFukushiHojinKeigengakuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

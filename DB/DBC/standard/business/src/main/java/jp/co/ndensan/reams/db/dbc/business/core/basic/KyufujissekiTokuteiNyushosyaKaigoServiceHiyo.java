/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績特定入所者介護サービス費用を管理するクラスです。
 */
public class KyufujissekiTokuteiNyushosyaKaigoServiceHiyo 
extends ModelBase<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier, 
        DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity, 
        KyufujissekiTokuteiNyushosyaKaigoServiceHiyo> implements Serializable {

    private final DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity;
    private final KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績特定入所者介護サービス費用の新規作成時に使用します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 通し番号 通し番号
     * @param 特定入所者介護サービス費用情報レコード順次番号 特定入所者介護サービス費用情報レコード順次番号
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号,
            RString 特定入所者介護サービス費用情報レコード順次番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(特定入所者介護サービス費用情報レコード順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス費用情報レコード順次番号"));
        this.entity = new DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setToshiNo(通し番号);
        this.entity.setRecodeJunjiNo(特定入所者介護サービス費用情報レコード順次番号);
        this.id = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号,
                特定入所者介護サービス費用情報レコード順次番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}より{@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyo}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績特定入所者介護サービス費用"));
        this.id = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier(
                entity.getKokanJohoShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getShokisaiHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshoNo(),
                entity.getToshiNo(),
                entity.getRecodeJunjiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity
     * {@link DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}
     * @param id {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier}
     */
    KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(
            DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity,
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier id
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
     * 特定入所者介護サービス費用情報レコード順次番号を返します。
     *
     * @return 特定入所者介護サービス費用情報レコード順次番号
     */
    public RString get特定入所者介護サービス費用情報レコード順次番号() {
        return entity.getRecodeJunjiNo();
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
    public Decimal get費用単価() {
        return entity.getHiyoTanka();
    }

    /**
     * 負担限度額を返します。
     *
     * @return 負担限度額
     */
    public Decimal get負担限度額() {
        return entity.getFutanGendogaku();
    }

    /**
     * 日数を返します。
     *
     * @return 日数
     */
    public Decimal get日数() {
        return entity.getNissu();
    }

    /**
     * 公費１日数を返します。
     *
     * @return 公費１日数
     */
    public Decimal get公費１日数() {
        return entity.getKohi1Nissu();
    }

    /**
     * 公費２日数を返します。
     *
     * @return 公費２日数
     */
    public Decimal get公費２日数() {
        return entity.getKohi2Nissu();
    }

    /**
     * 公費３日数を返します。
     *
     * @return 公費３日数
     */
    public Decimal get公費３日数() {
        return entity.getKohi3Nissu();
    }

    /**
     * 費用額を返します。
     *
     * @return 費用額
     */
    public Decimal get費用額() {
        return entity.getHiyogaku();
    }

    /**
     * 保険分請求額を返します。
     *
     * @return 保険分請求額
     */
    public Decimal get保険分請求額() {
        return entity.getHokenbunSeikyugaku();
    }

    /**
     * 公費１負担額_明細を返します。
     *
     * @return 公費１負担額_明細
     */
    public Decimal get公費１負担額_明細() {
        return entity.getKohi1Futangaku();
    }

    /**
     * 公費２負担額_明細を返します。
     *
     * @return 公費２負担額_明細
     */
    public Decimal get公費２負担額_明細() {
        return entity.getKohi2Futangaku();
    }

    /**
     * 公費３負担額_明細を返します。
     *
     * @return 公費３負担額_明細
     */
    public Decimal get公費３負担額_明細() {
        return entity.getKohi3Futangaku();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public Decimal get利用者負担額() {
        return entity.getRiyoshaFutangaku();
    }

    /**
     * 費用額合計を返します。
     *
     * @return 費用額合計
     */
    public Decimal get費用額合計() {
        return entity.getHiyogakuTotal();
    }

    /**
     * 保険分請求額合計を返します。
     *
     * @return 保険分請求額合計
     */
    public Decimal get保険分請求額合計() {
        return entity.getHokenbunSeikyugakuTotal();
    }

    /**
     * 利用者負担額合計を返します。
     *
     * @return 利用者負担額合計
     */
    public Decimal get利用者負担額合計() {
        return entity.getRiyoshaFutangakuTotal();
    }

    /**
     * 公費１_負担額合計を返します。
     *
     * @return 公費１_負担額合計
     */
    public Decimal get公費１_負担額合計() {
        return entity.getKohi1FutangakuTotal();
    }

    /**
     * 公費１_請求額を返します。
     *
     * @return 公費１_請求額
     */
    public Decimal get公費１_請求額() {
        return entity.getKohi1Seikyugaku();
    }

    /**
     * 公費１_本人負担月額を返します。
     *
     * @return 公費１_本人負担月額
     */
    public Decimal get公費１_本人負担月額() {
        return entity.getKohi1HonninFutanGetsugaku();
    }

    /**
     * 公費２_負担額合計を返します。
     *
     * @return 公費２_負担額合計
     */
    public Decimal get公費２_負担額合計() {
        return entity.getKohi2FutangakuTotal();
    }

    /**
     * 公費２_請求額を返します。
     *
     * @return 公費２_請求額
     */
    public Decimal get公費２_請求額() {
        return entity.getKohi2Seikyugaku();
    }

    /**
     * 公費２_本人負担月額を返します。
     *
     * @return 公費２_本人負担月額
     */
    public Decimal get公費２_本人負担月額() {
        return entity.getKohi2HonninFutanGetsugaku();
    }

    /**
     * 公費３_負担額合計を返します。
     *
     * @return 公費３_負担額合計
     */
    public Decimal get公費３_負担額合計() {
        return entity.getKohi3FutangakuTotal();
    }

    /**
     * 公費３_請求額を返します。
     *
     * @return 公費３_請求額
     */
    public Decimal get公費３_請求額() {
        return entity.getKohi3Seikyugaku();
    }

    /**
     * 公費３_本人負担月額を返します。
     *
     * @return 公費３_本人負担月額
     */
    public Decimal get公費３_本人負担月額() {
        return entity.getKohi3HonninFutanGetsugaku();
    }

    /**
     * 後_費用単価を返します。
     *
     * @return 後_費用単価
     */
    public Decimal get後_費用単価() {
        return entity.getAtoHiyoTanka();
    }

    /**
     * 後_日数を返します。
     *
     * @return 後_日数
     */
    public Decimal get後_日数() {
        return entity.getAtoNissu();
    }

    /**
     * 後_公費１日数を返します。
     *
     * @return 後_公費１日数
     */
    public Decimal get後_公費１日数() {
        return entity.getAtoKohi1Nissu();
    }

    /**
     * 後_公費２日数を返します。
     *
     * @return 後_公費２日数
     */
    public Decimal get後_公費２日数() {
        return entity.getAtoKohi2Nissu();
    }

    /**
     * 後_公費３日数を返します。
     *
     * @return 後_公費３日数
     */
    public Decimal get後_公費３日数() {
        return entity.getAtoKohi3Nissu();
    }

    /**
     * 後_費用額を返します。
     *
     * @return 後_費用額
     */
    public Decimal get後_費用額() {
        return entity.getAtoHiyogaku();
    }

    /**
     * 後_保険分請求額を返します。
     *
     * @return 後_保険分請求額
     */
    public Decimal get後_保険分請求額() {
        return entity.getAtoHokenbunSeikyugaku();
    }

    /**
     * 後_公費１負担額_明細を返します。
     *
     * @return 後_公費１負担額_明細
     */
    public Decimal get後_公費１負担額_明細() {
        return entity.getAtoKohi1Futangaku();
    }

    /**
     * 後_公費２負担額_明細を返します。
     *
     * @return 後_公費２負担額_明細
     */
    public Decimal get後_公費２負担額_明細() {
        return entity.getAtoKohi2Futangaku();
    }

    /**
     * 後_公費３負担額_明細を返します。
     *
     * @return 後_公費３負担額_明細
     */
    public Decimal get後_公費３負担額_明細() {
        return entity.getAtoKohi3Futangaku();
    }

    /**
     * 後_利用者負担額を返します。
     *
     * @return 後_利用者負担額
     */
    public Decimal get後_利用者負担額() {
        return entity.getAtoRiyoshaFutangaku();
    }

    /**
     * 後_費用額合計を返します。
     *
     * @return 後_費用額合計
     */
    public Decimal get後_費用額合計() {
        return entity.getAtoHiyogakuTotal();
    }

    /**
     * 後_保険分請求額合計を返します。
     *
     * @return 後_保険分請求額合計
     */
    public Decimal get後_保険分請求額合計() {
        return entity.getAtoHokenbunSeikyugakuTotal();
    }

    /**
     * 後_利用者負担額合計を返します。
     *
     * @return 後_利用者負担額合計
     */
    public Decimal get後_利用者負担額合計() {
        return entity.getAtoRiyoshaFutangakuTotal();
    }

    /**
     * 後_公費１_負担額合計を返します。
     *
     * @return 後_公費１_負担額合計
     */
    public Decimal get後_公費１_負担額合計() {
        return entity.getAtoKohi1FutangakuTotal();
    }

    /**
     * 後_公費１_請求額を返します。
     *
     * @return 後_公費１_請求額
     */
    public Decimal get後_公費１_請求額() {
        return entity.getAtoKohi1Seikyugaku();
    }

    /**
     * 後_公費１_本人負担月額を返します。
     *
     * @return 後_公費１_本人負担月額
     */
    public Decimal get後_公費１_本人負担月額() {
        return entity.getAtoKohi1HonninFutanGetsugaku();
    }

    /**
     * 後_公費２_負担額合計を返します。
     *
     * @return 後_公費２_負担額合計
     */
    public Decimal get後_公費２_負担額合計() {
        return entity.getAtoKohi2FutangakuTotal();
    }

    /**
     * 後_公費２_請求額を返します。
     *
     * @return 後_公費２_請求額
     */
    public Decimal get後_公費２_請求額() {
        return entity.getAtoKohi2Seikyugaku();
    }

    /**
     * 後_公費２_本人負担月額を返します。
     *
     * @return 後_公費２_本人負担月額
     */
    public Decimal get後_公費２_本人負担月額() {
        return entity.getAtoKohi2HonninFutanGetsugaku();
    }

    /**
     * 後_公費３_負担額合計を返します。
     *
     * @return 後_公費３_負担額合計
     */
    public Decimal get後_公費３_負担額合計() {
        return entity.getAtoKohi3FutangakuTotal();
    }

    /**
     * 後_公費３_請求額を返します。
     *
     * @return 後_公費３_請求額
     */
    public Decimal get後_公費３_請求額() {
        return entity.getAtoKohi3Seikyugaku();
    }

    /**
     * 後_公費３_本人負担月額を返します。
     *
     * @return 後_公費３_本人負担月額
     */
    public Decimal get後_公費３_本人負担月額() {
        return entity.getAtoKohi3HonninFutanGetsugaku();
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
     * {@link DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}のクローンを返します。
     *
     * @return
     * {@link DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}のクローン
     */
    @Override
    public DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績特定入所者介護サービス費用の識別子{@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier}を返します。
     *
     * @return
     * 給付実績特定入所者介護サービス費用の識別子{@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier}
     */
    @Override
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績特定入所者介護サービス費用を削除対象とします。<br/>
     * {@link DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyo}
     */
    @Override
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyo deleted() {
        DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(deletedEntity, id);
    }

    /**
     * {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyo}のシリアライズ形式を提供します。
     *
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyo}のシリアライズ形式
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

        private final DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity;
        private final KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier id;

        private _SerializationProxy(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity, 
                KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder createBuilderForEdit() {
        return new KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

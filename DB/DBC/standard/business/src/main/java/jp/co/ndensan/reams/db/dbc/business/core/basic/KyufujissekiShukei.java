/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績集計を管理するクラスです。
 */
public class KyufujissekiShukei extends
        ModelBase<KyufujissekiShukeiIdentifier, DbT3033KyufujissekiShukeiEntity, KyufujissekiShukei> implements Serializable {

    private final DbT3033KyufujissekiShukeiEntity entity;
    private final KyufujissekiShukeiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績集計の新規作成時に使用します。
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
    public KyufujissekiShukei(KokanShikibetsuNo 交換情報識別番号,
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
        this.entity = new DbT3033KyufujissekiShukeiEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setToshiNo(通し番号);
        this.entity.setServiceSyuruiCode(サービス種類コード);
        this.id = new KyufujissekiShukeiIdentifier(
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
     * DBより取得した{@link DbT3033KyufujissekiShukeiEntity}より{@link KyufujissekiShukei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3033KyufujissekiShukeiEntity}
     */
    public KyufujissekiShukei(DbT3033KyufujissekiShukeiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績集計"));
        this.id = new KyufujissekiShukeiIdentifier(
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
     * @param entity {@link DbT3033KyufujissekiShukeiEntity}
     * @param id {@link KyufujissekiShukeiIdentifier}
     */
    KyufujissekiShukei(
            DbT3033KyufujissekiShukeiEntity entity,
            KyufujissekiShukeiIdentifier id
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
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceSyuruiCode();
    }

    /**
     * サービス実日数を返します。
     *
     * @return サービス実日数
     */
    public Integer getサービス実日数() {
        return entity.getServiceJitsunissu();
    }

    /**
     * 計画単位数を返します。
     *
     * @return 計画単位数
     */
    public Decimal get計画単位数() {
        return entity.getPlanTanisu();
    }

    /**
     * 限度額管理対象単位数を返します。
     *
     * @return 限度額管理対象単位数
     */
    public Decimal get限度額管理対象単位数() {
        return entity.getGendogakuKanriTaishoTanisu();
    }

    /**
     * 限度額管理対象外単位数を返します。
     *
     * @return 限度額管理対象外単位数
     */
    public Decimal get限度額管理対象外単位数() {
        return entity.getGendogakuKanritaishogaiTanisu();
    }

    /**
     * 短期入所計画日数を返します。
     *
     * @return 短期入所計画日数
     */
    public Integer get短期入所計画日数() {

        return entity.getTankiNyushoPlanNissu();
    }

    /**
     * 短期入所実日数を返します。
     *
     * @return 短期入所実日数
     */
    public Integer get短期入所実日数() {
        return entity.getTankiNyushoJitsunissu();
    }

    /**
     * 保険_単位数合計を返します。
     *
     * @return 保険_単位数合計
     */
    public Decimal get保険_単位数合計() {
        return entity.getHokenTanisuTotal();
    }

    /**
     * 保険_単位数単価を返します。
     *
     * @return 保険_単位数単価
     */
    public Decimal get保険_単位数単価() {
        return entity.getHokenTanisuTani();
    }

    /**
     * 保険_請求額を返します。
     *
     * @return 保険_請求額
     */
    public Decimal get保険_請求額() {
        return entity.getHokenSeikyugaku();
    }

    /**
     * 保険_利用者負担額を返します。
     *
     * @return 保険_利用者負担額
     */
    public Decimal get保険_利用者負担額() {
        return entity.getHokenRiyoshaFutangaku();
    }

    /**
     * 公費１_単位数合計を返します。
     *
     * @return 公費１_単位数合計
     */
    public Decimal get公費１_単位数合計() {
        return entity.getKohi1TanisuTotal();
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
     * 公費１_本人負担額を返します。
     *
     * @return 公費１_本人負担額
     */
    public Decimal get公費１_本人負担額() {
        return entity.getKohi1HonninFutangaku();
    }

    /**
     * 公費２_単位数合計を返します。
     *
     * @return 公費２_単位数合計
     */
    public Decimal get公費２_単位数合計() {
        return entity.getKohi2TanisuTotal();
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
     * 公費２_本人負担額を返します。
     *
     * @return 公費２_本人負担額
     */
    public Decimal get公費２_本人負担額() {
        return entity.getKohi2HonninFutangaku();
    }

    /**
     * 公費３_単位数合計を返します。
     *
     * @return 公費３_単位数合計
     */
    public Decimal get公費３_単位数合計() {
        return entity.getKohi3TanisuTotal();
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
     * 公費３_本人負担額を返します。
     *
     * @return 公費３_本人負担額
     */
    public Decimal get公費３_本人負担額() {
        return entity.getKohi3HonninFutangaku();
    }

    /**
     * 保険_出来高単位数合計を返します。
     *
     * @return 保険_出来高単位数合計
     */
    public Decimal get保険_出来高単位数合計() {
        return entity.getHokenDekidakaTanisuTotal();
    }

    /**
     * 保険_出来高請求額を返します。
     *
     * @return 保険_出来高請求額
     */
    public Decimal get保険_出来高請求額() {
        return entity.getHokenDekidakaSeikyugaku();
    }

    /**
     * 保険_出来高医療費利用者負担額を返します。
     *
     * @return 保険_出来高医療費利用者負担額
     */
    public Decimal get保険_出来高医療費利用者負担額() {
        return entity.getHokenDekidakaIryohiRiyoshaFutangaku();
    }

    /**
     * 公費１_出来高単位数合計を返します。
     *
     * @return 公費１_出来高単位数合計
     */
    public Decimal get公費１_出来高単位数合計() {
        return entity.getKohi1DekidakaTanisuTotal();
    }

    /**
     * 公費１_出来高請求額を返します。
     *
     * @return 公費１_出来高請求額
     */
    public Decimal get公費１_出来高請求額() {
        return entity.getKohi1DekidakaSeikyugaku();
    }

    /**
     * 公費１_出来高医療費利用者負担額を返します。
     *
     * @return 公費１_出来高医療費利用者負担額
     */
    public Decimal get公費１_出来高医療費利用者負担額() {
        return entity.getKohi1DekidakaIryohiRiyoshaFutangaku();
    }

    /**
     * 公費２_出来高単位数合計を返します。
     *
     * @return 公費２_出来高単位数合計
     */
    public Decimal get公費２_出来高単位数合計() {
        return entity.getKohi2DekidakaTanisuTotal();
    }

    /**
     * 公費２_出来高請求額を返します。
     *
     * @return 公費２_出来高請求額
     */
    public Decimal get公費２_出来高請求額() {
        return entity.getKohi2DekidakaSeikyugaku();
    }

    /**
     * 公費２_出来高医療費本人負担額を返します。
     *
     * @return 公費２_出来高医療費本人負担額
     */
    public Decimal get公費２_出来高医療費本人負担額() {
        return entity.getKohi2DekidakaIryohiRiyoshaFutangaku();
    }

    /**
     * 公費３_出来高単位数合計を返します。
     *
     * @return 公費３_出来高単位数合計
     */
    public Decimal get公費３_出来高単位数合計() {
        return entity.getKohi3DekidakaTanisuTotal();
    }

    /**
     * 公費３_出来高請求額を返します。
     *
     * @return 公費３_出来高請求額
     */
    public Decimal get公費３_出来高請求額() {
        return entity.getKohi3DekidakaSeikyugaku();
    }

    /**
     * 公費３_出来高医療費本人負担額を返します。
     *
     * @return 公費３_出来高医療費本人負担額
     */
    public Decimal get公費３_出来高医療費本人負担額() {
        return entity.getKohi3DekidakaIryohiRiyoshaFutangaku();
    }

    /**
     * 後_短期入所実日数を返します。
     *
     * @return 後_短期入所実日数
     */
    public Integer get後_短期入所実日数() {
        return entity.getAtoTankiNyushoJitsunissu();
    }

    /**
     * 後_単位数合計を返します。
     *
     * @return 後_単位数合計
     */
    public Decimal get後_単位数合計() {
        return entity.getAtoHokenTanisuTotal();
    }

    /**
     * 後_保険請求分請求額を返します。
     *
     * @return 後_保険請求分請求額
     */
    public Decimal get後_保険請求分請求額() {
        return entity.getAtoHokenSeikyugaku();
    }

    /**
     * 後_公費１_単位数合計を返します。
     *
     * @return 後_公費１_単位数合計
     */
    public Decimal get後_公費１_単位数合計() {
        return entity.getAtoKohi1TanisuTotal();
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
     * 後_公費２_単位数合計を返します。
     *
     * @return 後_公費２_単位数合計
     */
    public Decimal get後_公費２_単位数合計() {
        return entity.getAtoKohi2TanisuTotal();
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
     * 後_公費３_単位数合計を返します。
     *
     * @return 後_公費３_単位数合計
     */
    public Decimal get後_公費３_単位数合計() {
        return entity.getAtoKohi3TanisuTotal();
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
     * 後_保険_出来高単位数合計を返します。
     *
     * @return 後_保険_出来高単位数合計
     */
    public Decimal get後_保険_出来高単位数合計() {
        return entity.getAtoHokenDekidakaTanisuTotal();
    }

    /**
     * 後_保険_出来高請求額を返します。
     *
     * @return 後_保険_出来高請求額
     */
    public Decimal get後_保険_出来高請求額() {
        return entity.getAtoHokenDekidakaSeikyugaku();
    }

    /**
     * 後_公費１_出来高単位数合計を返します。
     *
     * @return 後_公費１_出来高単位数合計
     */
    public Decimal get後_公費１_出来高単位数合計() {
        return entity.getAtoKohi1DekidakaTanisuTotal();
    }

    /**
     * 後_公費１_出来高請求額を返します。
     *
     * @return 後_公費１_出来高請求額
     */
    public Decimal get後_公費１_出来高請求額() {
        return entity.getAtoKohi1DekidakaSeikyugaku();
    }

    /**
     * 後_公費２_出来高単位数合計を返します。
     *
     * @return 後_公費２_出来高単位数合計
     */
    public Decimal get後_公費２_出来高単位数合計() {
        return entity.getAtoKohi2DekidakaTanisuTotal();
    }

    /**
     * 後_公費２_出来高請求額を返します。
     *
     * @return 後_公費２_出来高請求額
     */
    public Decimal get後_公費２_出来高請求額() {
        return entity.getAtoKohi2DekidakaSeikyugaku();
    }

    /**
     * 後_公費３_出来高単位数合計を返します。
     *
     * @return 後_公費３_出来高単位数合計
     */
    public Decimal get後_公費３_出来高単位数合計() {
        return entity.getAtoKohi3DekidakaTanisuTotal();
    }

    /**
     * 後_公費３_出来高請求額を返します。
     *
     * @return 後_公費３_出来高請求額
     */
    public Decimal get後_公費３_出来高請求額() {
        return entity.getAtoKohi3DekidakaSeikyugaku();
    }

    /**
     * 再審査回数を返します。
     *
     * @return 再審査回数
     */
    public Integer get再審査回数() {
        return entity.getSaishinsaKaisu();
    }

    /**
     * 過誤回数を返します。
     *
     * @return 過誤回数
     */
    public Integer get過誤回数() {
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
     * {@link DbT3033KyufujissekiShukeiEntity}のクローンを返します。
     *
     * @return {@link DbT3033KyufujissekiShukeiEntity}のクローン
     */
    @Override
    public DbT3033KyufujissekiShukeiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績集計の識別子{@link KyufujissekiShukeiIdentifier}を返します。
     *
     * @return 給付実績集計の識別子{@link KyufujissekiShukeiIdentifier}
     */
    @Override
    public KyufujissekiShukeiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績集計を削除対象とします。<br/>
     * {@link DbT3033KyufujissekiShukeiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufujissekiShukei}
     */
    @Override
    public KyufujissekiShukei deleted() {
        DbT3033KyufujissekiShukeiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufujissekiShukei(deletedEntity, id);
    }

    /**
     * {@link KyufujissekiShukei}のシリアライズ形式を提供します。
     *
     * @return {@link KyufujissekiShukei}のシリアライズ形式
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

        private final DbT3033KyufujissekiShukeiEntity entity;
        private final KyufujissekiShukeiIdentifier id;

        private _SerializationProxy(DbT3033KyufujissekiShukeiEntity entity, KyufujissekiShukeiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufujissekiShukei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufujissekiShukeiBuilder createBuilderForEdit() {
        return new KyufujissekiShukeiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

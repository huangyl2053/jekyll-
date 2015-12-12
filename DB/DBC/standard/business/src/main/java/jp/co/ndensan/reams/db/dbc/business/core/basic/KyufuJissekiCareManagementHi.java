/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3031KyufuJissekiCareManagementHiEntity;
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
 * 給付実績ケアマネジメント費を管理するクラスです。
 */
public class KyufuJissekiCareManagementHi 
extends ModelBase<KyufuJissekiCareManagementHiIdentifier, 
        DbT3031KyufuJissekiCareManagementHiEntity, 
        KyufuJissekiCareManagementHi> implements Serializable {

    private final DbT3031KyufuJissekiCareManagementHiEntity entity;
    private final KyufuJissekiCareManagementHiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績ケアマネジメント費の新規作成時に使用します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 指定_基準該当事業所区分コード 指定_基準該当事業所区分コード
     * @param 居宅サービス計画作成依頼届出年月日 居宅サービス計画作成依頼届出年月日
     * @param 通し番号 通し番号
     * @param サービス計画費明細行番号 サービス計画費明細行番号
     */
    public KyufuJissekiCareManagementHi(KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 指定_基準該当事業所区分コード,
            FlexibleDate 居宅サービス計画作成依頼届出年月日,
            RString 通し番号,
            RString サービス計画費明細行番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(指定_基準該当事業所区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("指定_基準該当事業所区分コード"));
        requireNonNull(居宅サービス計画作成依頼届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画作成依頼届出年月日"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(サービス計画費明細行番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス計画費明細行番号"));
        this.entity = new DbT3031KyufuJissekiCareManagementHiEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setShiteiKijungaitoJigyoshoKubunCode(指定_基準該当事業所区分コード);
        this.entity.setKyotakuServiceSakuseiIraiYMD(居宅サービス計画作成依頼届出年月日);
        this.entity.setToshiNo(通し番号);
        this.entity.setServicePlanhiMeisaiLineNo(サービス計画費明細行番号);
        this.id = new KyufuJissekiCareManagementHiIdentifier(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                指定_基準該当事業所区分コード,
                居宅サービス計画作成依頼届出年月日,
                通し番号,
                サービス計画費明細行番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3031KyufuJissekiCareManagementHiEntity}より{@link KyufuJissekiCareManagementHi}を生成します。
     *
     * @param entity DBより取得した{@link DbT3031KyufuJissekiCareManagementHiEntity}
     */
    public KyufuJissekiCareManagementHi(DbT3031KyufuJissekiCareManagementHiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績ケアマネジメント費"));
        this.id = new KyufuJissekiCareManagementHiIdentifier(
                entity.getKokanJohoShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getShokisaiHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshoNo(),
                entity.getShiteiKijungaitoJigyoshoKubunCode(),
                entity.getKyotakuServiceSakuseiIraiYMD(),
                entity.getToshiNo(),
                entity.getServicePlanhiMeisaiLineNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3031KyufuJissekiCareManagementHiEntity}
     * @param id {@link KyufuJissekiCareManagementHiIdentifier}
     */
    KyufuJissekiCareManagementHi(
            DbT3031KyufuJissekiCareManagementHiEntity entity,
            KyufuJissekiCareManagementHiIdentifier id
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
     * 指定_基準該当事業所区分コードを返します。
     *
     * @return 指定_基準該当事業所区分コード
     */
    public RString get指定_基準該当事業所区分コード() {
        return entity.getShiteiKijungaitoJigyoshoKubunCode();
    }

    /**
     * 居宅サービス計画作成依頼届出年月日を返します。
     *
     * @return 居宅サービス計画作成依頼届出年月日
     */
    public FlexibleDate get居宅サービス計画作成依頼届出年月日() {
        return entity.getKyotakuServiceSakuseiIraiYMD();
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
     * サービス計画費明細行番号を返します。
     *
     * @return サービス計画費明細行番号
     */
    public RString getサービス計画費明細行番号() {
        return entity.getServicePlanhiMeisaiLineNo();
    }

    /**
     * 単位数単価を返します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価() {
        return entity.getTanisuTanka();
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
     * 単位数を返します。
     *
     * @return 単位数
     */
    public Decimal get単位数() {
        return entity.getTanisu();
    }

    /**
     * 回数を返します。
     *
     * @return 回数
     */
    public Decimal get回数() {
        return entity.getKaisu();
    }

    /**
     * サービス単位数を返します。
     *
     * @return サービス単位数
     */
    public int getサービス単位数() {
        return entity.getServiceTanisu();
    }

    /**
     * サービス単位数合計を返します。
     *
     * @return サービス単位数合計
     */
    public int getサービス単位数合計() {
        return entity.getSerivceTanisuTotal();
    }

    /**
     * 請求金額を返します。
     *
     * @return 請求金額
     */
    public int get請求金額() {
        return entity.getSeikyuKingaku();
    }

    /**
     * 担当介護支援専門員番号を返します。
     *
     * @return 担当介護支援専門員番号
     */
    public RString get担当介護支援専門員番号() {
        return entity.getTantoKaigoShienSemmoninNo();
    }

    /**
     * 摘要を返します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return entity.getTekiyo();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public int get利用者負担額() {
        return entity.getRiyoushaFutangaku();
    }

    /**
     * 後_単位数を返します。
     *
     * @return 後_単位数
     */
    public Decimal get後_単位数() {
        return entity.getAtoTanisu();
    }

    /**
     * 後_回数を返します。
     *
     * @return 後_回数
     */
    public Decimal get後_回数() {
        return entity.getAtoKaisu();
    }

    /**
     * 後_サービス単位数を返します。
     *
     * @return 後_サービス単位数
     */
    public int get後_サービス単位数() {
        return entity.getAtoServiceTanisu();
    }

    /**
     * 後_サービス単位数合計を返します。
     *
     * @return 後_サービス単位数合計
     */
    public int get後_サービス単位数合計() {
        return entity.getAtoServiceTanisuTotal();
    }

    /**
     * 後_請求金額を返します。
     *
     * @return 後_請求金額
     */
    public int get後_請求金額() {
        return entity.getAtoSeikyuKingaku();
    }

    /**
     * 後_利用者負担額を返します。
     *
     * @return 後_利用者負担額
     */
    public int get後_利用者負担額() {
        return entity.getAtoRiyoshaFutangaku();
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
     * {@link DbT3031KyufuJissekiCareManagementHiEntity}のクローンを返します。
     *
     * @return {@link DbT3031KyufuJissekiCareManagementHiEntity}のクローン
     */
    @Override
    public DbT3031KyufuJissekiCareManagementHiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績ケアマネジメント費の識別子{@link KyufuJissekiCareManagementHiIdentifier}を返します。
     *
     * @return 給付実績ケアマネジメント費の識別子{@link KyufuJissekiCareManagementHiIdentifier}
     */
    @Override
    public KyufuJissekiCareManagementHiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績ケアマネジメント費を削除対象とします。<br/>
     * {@link DbT3031KyufuJissekiCareManagementHiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufuJissekiCareManagementHi}
     */
    @Override
    public KyufuJissekiCareManagementHi deleted() {
        DbT3031KyufuJissekiCareManagementHiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufuJissekiCareManagementHi(deletedEntity, id);
    }

    /**
     * {@link KyufuJissekiCareManagementHi}のシリアライズ形式を提供します。
     *
     * @return {@link KyufuJissekiCareManagementHi}のシリアライズ形式
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

        private final DbT3031KyufuJissekiCareManagementHiEntity entity;
        private final KyufuJissekiCareManagementHiIdentifier id;

        private _SerializationProxy(DbT3031KyufuJissekiCareManagementHiEntity entity, KyufuJissekiCareManagementHiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufuJissekiCareManagementHi(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufuJissekiCareManagementHiBuilder createBuilderForEdit() {
        return new KyufuJissekiCareManagementHiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}

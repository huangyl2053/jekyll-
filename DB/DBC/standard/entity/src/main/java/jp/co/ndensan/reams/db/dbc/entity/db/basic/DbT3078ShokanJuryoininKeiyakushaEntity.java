package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 償還受領委任契約者テーブルのエンティティクラスです。
 */
public class DbT3078ShokanJuryoininKeiyakushaEntity extends DbTableEntityBase<DbT3078ShokanJuryoininKeiyakushaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3078ShokanJuryoininKeiyakusha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate shinseiYMD;
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private RString keiyakuJigyoshaNo;
    @PrimaryKey
    private RString keiyakuServiceShurui;
    private FlexibleDate ketteiYMD;
    private RString shoninKekkaKubun;
    private RString keiyakuNo;
    private FlexibleDate juryoininKaishiYMD;
    private FlexibleDate juryoininShuryoYMD;
    private RString fuShoninRiyu;
    private Decimal hiyoGakuGokei;
    private Decimal hokenTaishoHiyoGaku;
    private Decimal riyoshaJikoFutanGaku;
    private Decimal hokenKyufuhiGaku;
    private FlexibleDate shoninKekkaTsuchiSakuseiYMD;
    private RString shoninKekkaTsuchiSaiHakkoKubun;
    private RString shikyushinseiUmuKubun;
    private FlexibleYearMonth shikyushinseiServiceYM;
    private RString shikyushinseiSeiriNo;
    private RString biko;

    /**
     * insertDantaiCdのgetメソッドです。
     * 
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     * 
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     * 
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     * 
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     * 
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * 
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 申請年月日のgetメソッドです。
     * 
     * @return 申請年月日
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     * 
     * @param shinseiYMD 申請年月日
     */
    public void setShinseiYMD(@Nonnull FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 受付年月日のgetメソッドです。
     * 
     * @return 受付年月日
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * 受付年月日のsetメソッドです。
     * 
     * @param uketsukeYMD 受付年月日
     */
    public void setUketsukeYMD(@Nonnull FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * 契約事業者番号のgetメソッドです。
     * <br/>
     * <br/>償還受領委任契約事業者の事業者契約番号
     * 
     * @return 契約事業者番号
     */
    public RString getKeiyakuJigyoshaNo() {
        return keiyakuJigyoshaNo;
    }

    /**
     * 契約事業者番号のsetメソッドです。
     * <br/>
     * <br/>償還受領委任契約事業者の事業者契約番号
     * 
     * @param keiyakuJigyoshaNo 契約事業者番号
     */
    public void setKeiyakuJigyoshaNo(@Nonnull RString keiyakuJigyoshaNo) {
        this.keiyakuJigyoshaNo = keiyakuJigyoshaNo;
    }

    /**
     * 契約サービス種類のgetメソッドです。
     * <br/>
     * <br/>01：福祉用具、02：住宅改修、03：予防福祉用具、04：予防住宅改修、05：償還払支給、06：高額給付支給
     * 
     * @return 契約サービス種類
     */
    public RString getKeiyakuServiceShurui() {
        return keiyakuServiceShurui;
    }

    /**
     * 契約サービス種類のsetメソッドです。
     * <br/>
     * <br/>01：福祉用具、02：住宅改修、03：予防福祉用具、04：予防住宅改修、05：償還払支給、06：高額給付支給
     * 
     * @param keiyakuServiceShurui 契約サービス種類
     */
    public void setKeiyakuServiceShurui(@Nonnull RString keiyakuServiceShurui) {
        this.keiyakuServiceShurui = keiyakuServiceShurui;
    }

    /**
     * 決定年月日のgetメソッドです。
     * 
     * @return 決定年月日
     */
    @CheckForNull
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * 決定年月日のsetメソッドです。
     * 
     * @param ketteiYMD 決定年月日
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * 承認結果区分のgetメソッドです。
     * <br/>
     * <br/>0:承認しない,1:承認する
     * 
     * @return 承認結果区分
     */
    @CheckForNull
    public RString getShoninKekkaKubun() {
        return shoninKekkaKubun;
    }

    /**
     * 承認結果区分のsetメソッドです。
     * <br/>
     * <br/>0:承認しない,1:承認する
     * 
     * @param shoninKekkaKubun 承認結果区分
     */
    public void setShoninKekkaKubun(RString shoninKekkaKubun) {
        this.shoninKekkaKubun = shoninKekkaKubun;
    }

    /**
     * 契約番号のgetメソッドです。
     * <br/>
     * <br/>開始年月日が属する西暦年度（4桁）＋契約事業者・年度単位に１からの連番（4桁）
     * 
     * @return 契約番号
     */
    @CheckForNull
    public RString getKeiyakuNo() {
        return keiyakuNo;
    }

    /**
     * 契約番号のsetメソッドです。
     * <br/>
     * <br/>開始年月日が属する西暦年度（4桁）＋契約事業者・年度単位に１からの連番（4桁）
     * 
     * @param keiyakuNo 契約番号
     */
    public void setKeiyakuNo(RString keiyakuNo) {
        this.keiyakuNo = keiyakuNo;
    }

    /**
     * 受領委任払適用開始年月日のgetメソッドです。
     * 
     * @return 受領委任払適用開始年月日
     */
    @CheckForNull
    public FlexibleDate getJuryoininKaishiYMD() {
        return juryoininKaishiYMD;
    }

    /**
     * 受領委任払適用開始年月日のsetメソッドです。
     * 
     * @param juryoininKaishiYMD 受領委任払適用開始年月日
     */
    public void setJuryoininKaishiYMD(FlexibleDate juryoininKaishiYMD) {
        this.juryoininKaishiYMD = juryoininKaishiYMD;
    }

    /**
     * 受領委任払適用終了年月日のgetメソッドです。
     * 
     * @return 受領委任払適用終了年月日
     */
    @CheckForNull
    public FlexibleDate getJuryoininShuryoYMD() {
        return juryoininShuryoYMD;
    }

    /**
     * 受領委任払適用終了年月日のsetメソッドです。
     * 
     * @param juryoininShuryoYMD 受領委任払適用終了年月日
     */
    public void setJuryoininShuryoYMD(FlexibleDate juryoininShuryoYMD) {
        this.juryoininShuryoYMD = juryoininShuryoYMD;
    }

    /**
     * 不承認理由のgetメソッドです。
     * 
     * @return 不承認理由
     */
    @CheckForNull
    public RString getFuShoninRiyu() {
        return fuShoninRiyu;
    }

    /**
     * 不承認理由のsetメソッドです。
     * 
     * @param fuShoninRiyu 不承認理由
     */
    public void setFuShoninRiyu(RString fuShoninRiyu) {
        this.fuShoninRiyu = fuShoninRiyu;
    }

    /**
     * 費用額合計のgetメソッドです。
     * <br/>
     * <br/>給付額等
     * 
     * @return 費用額合計
     */
    @CheckForNull
    public Decimal getHiyoGakuGokei() {
        return hiyoGakuGokei;
    }

    /**
     * 費用額合計のsetメソッドです。
     * <br/>
     * <br/>給付額等
     * 
     * @param hiyoGakuGokei 費用額合計
     */
    public void setHiyoGakuGokei(Decimal hiyoGakuGokei) {
        this.hiyoGakuGokei = hiyoGakuGokei;
    }

    /**
     * 保険対象費用額のgetメソッドです。
     * <br/>
     * <br/>給付額等
     * 
     * @return 保険対象費用額
     */
    @CheckForNull
    public Decimal getHokenTaishoHiyoGaku() {
        return hokenTaishoHiyoGaku;
    }

    /**
     * 保険対象費用額のsetメソッドです。
     * <br/>
     * <br/>給付額等
     * 
     * @param hokenTaishoHiyoGaku 保険対象費用額
     */
    public void setHokenTaishoHiyoGaku(Decimal hokenTaishoHiyoGaku) {
        this.hokenTaishoHiyoGaku = hokenTaishoHiyoGaku;
    }

    /**
     * 利用者自己負担額のgetメソッドです。
     * <br/>
     * <br/>給付額等
     * 
     * @return 利用者自己負担額
     */
    @CheckForNull
    public Decimal getRiyoshaJikoFutanGaku() {
        return riyoshaJikoFutanGaku;
    }

    /**
     * 利用者自己負担額のsetメソッドです。
     * <br/>
     * <br/>給付額等
     * 
     * @param riyoshaJikoFutanGaku 利用者自己負担額
     */
    public void setRiyoshaJikoFutanGaku(Decimal riyoshaJikoFutanGaku) {
        this.riyoshaJikoFutanGaku = riyoshaJikoFutanGaku;
    }

    /**
     * 保険給付費額のgetメソッドです。
     * <br/>
     * <br/>給付額等
     * 
     * @return 保険給付費額
     */
    @CheckForNull
    public Decimal getHokenKyufuhiGaku() {
        return hokenKyufuhiGaku;
    }

    /**
     * 保険給付費額のsetメソッドです。
     * <br/>
     * <br/>給付額等
     * 
     * @param hokenKyufuhiGaku 保険給付費額
     */
    public void setHokenKyufuhiGaku(Decimal hokenKyufuhiGaku) {
        this.hokenKyufuhiGaku = hokenKyufuhiGaku;
    }

    /**
     * 承認結果通知書作成日のgetメソッドです。
     * 
     * @return 承認結果通知書作成日
     */
    @CheckForNull
    public FlexibleDate getShoninKekkaTsuchiSakuseiYMD() {
        return shoninKekkaTsuchiSakuseiYMD;
    }

    /**
     * 承認結果通知書作成日のsetメソッドです。
     * 
     * @param shoninKekkaTsuchiSakuseiYMD 承認結果通知書作成日
     */
    public void setShoninKekkaTsuchiSakuseiYMD(FlexibleDate shoninKekkaTsuchiSakuseiYMD) {
        this.shoninKekkaTsuchiSakuseiYMD = shoninKekkaTsuchiSakuseiYMD;
    }

    /**
     * 承認結果通知書再発行区分のgetメソッドです。
     * 
     * @return 承認結果通知書再発行区分
     */
    @CheckForNull
    public RString getShoninKekkaTsuchiSaiHakkoKubun() {
        return shoninKekkaTsuchiSaiHakkoKubun;
    }

    /**
     * 承認結果通知書再発行区分のsetメソッドです。
     * 
     * @param shoninKekkaTsuchiSaiHakkoKubun 承認結果通知書再発行区分
     */
    public void setShoninKekkaTsuchiSaiHakkoKubun(RString shoninKekkaTsuchiSaiHakkoKubun) {
        this.shoninKekkaTsuchiSaiHakkoKubun = shoninKekkaTsuchiSaiHakkoKubun;
    }

    /**
     * 支給申請書有無区分のgetメソッドです。
     * 
     * @return 支給申請書有無区分
     */
    @CheckForNull
    public RString getShikyushinseiUmuKubun() {
        return shikyushinseiUmuKubun;
    }

    /**
     * 支給申請書有無区分のsetメソッドです。
     * 
     * @param shikyushinseiUmuKubun 支給申請書有無区分
     */
    public void setShikyushinseiUmuKubun(RString shikyushinseiUmuKubun) {
        this.shikyushinseiUmuKubun = shikyushinseiUmuKubun;
    }

    /**
     * 支給申請サービス提供年月のgetメソッドです。
     * 
     * @return 支給申請サービス提供年月
     */
    @CheckForNull
    public FlexibleYearMonth getShikyushinseiServiceYM() {
        return shikyushinseiServiceYM;
    }

    /**
     * 支給申請サービス提供年月のsetメソッドです。
     * 
     * @param shikyushinseiServiceYM 支給申請サービス提供年月
     */
    public void setShikyushinseiServiceYM(FlexibleYearMonth shikyushinseiServiceYM) {
        this.shikyushinseiServiceYM = shikyushinseiServiceYM;
    }

    /**
     * 支給申請償還整理番号のgetメソッドです。
     * 
     * @return 支給申請償還整理番号
     */
    @CheckForNull
    public RString getShikyushinseiSeiriNo() {
        return shikyushinseiSeiriNo;
    }

    /**
     * 支給申請償還整理番号のsetメソッドです。
     * 
     * @param shikyushinseiSeiriNo 支給申請償還整理番号
     */
    public void setShikyushinseiSeiriNo(RString shikyushinseiSeiriNo) {
        this.shikyushinseiSeiriNo = shikyushinseiSeiriNo;
    }

    /**
     * 備考のgetメソッドです。
     * 
     * @return 備考
     */
    @CheckForNull
    public RString getBiko() {
        return biko;
    }

    /**
     * 備考のsetメソッドです。
     * 
     * @param biko 備考
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3078ShokanJuryoininKeiyakushaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3078ShokanJuryoininKeiyakushaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3078ShokanJuryoininKeiyakushaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shinseiYMD, other.shinseiYMD)) {
            return false;
        }
        if (!Objects.equals(this.keiyakuJigyoshaNo, other.keiyakuJigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.keiyakuServiceShurui, other.keiyakuServiceShurui)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3078ShokanJuryoininKeiyakushaEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shinseiYMD = entity.shinseiYMD;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.keiyakuJigyoshaNo = entity.keiyakuJigyoshaNo;
        this.keiyakuServiceShurui = entity.keiyakuServiceShurui;
        this.ketteiYMD = entity.ketteiYMD;
        this.shoninKekkaKubun = entity.shoninKekkaKubun;
        this.keiyakuNo = entity.keiyakuNo;
        this.juryoininKaishiYMD = entity.juryoininKaishiYMD;
        this.juryoininShuryoYMD = entity.juryoininShuryoYMD;
        this.fuShoninRiyu = entity.fuShoninRiyu;
        this.hiyoGakuGokei = entity.hiyoGakuGokei;
        this.hokenTaishoHiyoGaku = entity.hokenTaishoHiyoGaku;
        this.riyoshaJikoFutanGaku = entity.riyoshaJikoFutanGaku;
        this.hokenKyufuhiGaku = entity.hokenKyufuhiGaku;
        this.shoninKekkaTsuchiSakuseiYMD = entity.shoninKekkaTsuchiSakuseiYMD;
        this.shoninKekkaTsuchiSaiHakkoKubun = entity.shoninKekkaTsuchiSaiHakkoKubun;
        this.shikyushinseiUmuKubun = entity.shikyushinseiUmuKubun;
        this.shikyushinseiServiceYM = entity.shikyushinseiServiceYM;
        this.shikyushinseiSeiriNo = entity.shikyushinseiSeiriNo;
        this.biko = entity.biko;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, shinseiYMD, uketsukeYMD, keiyakuJigyoshaNo, keiyakuServiceShurui, ketteiYMD, shoninKekkaKubun, keiyakuNo, juryoininKaishiYMD, juryoininShuryoYMD, fuShoninRiyu, hiyoGakuGokei, hokenTaishoHiyoGaku, riyoshaJikoFutanGaku, hokenKyufuhiGaku, shoninKekkaTsuchiSakuseiYMD, shoninKekkaTsuchiSaiHakkoKubun, shikyushinseiUmuKubun, shikyushinseiServiceYM, shikyushinseiSeiriNo, biko);
    }

// </editor-fold>

}

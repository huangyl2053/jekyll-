package jp.co.ndensan.reams.db.dbc.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private Decimal rirekiNo;
    private FlexibleDate shinseiYMD;
    private RString jigyoshaKeiyakuNo;
    private RString keiyakuServiceShurui;
    private FlexibleDate ketteiYMD;
    private RString shoninKekkaKubun;
    private FlexibleDate juryoininKaishiYMD;
    private FlexibleDate juryoininShuryoYMD;
    private RString keiyakuNo;
    private RString fuShoninRiyu;
    private Decimal hiyoGakuGokei;
    private Decimal hokenTaishoHiyoGaku;
    private Decimal riyoshaJikoFutanGaku;
    private Decimal hokenKyufuhiGaku;
    private FlexibleDate shoninKekkaTsuchiSakuseiYMD;
    private RString shoninKekkaTsuchiSaiHakkoKubun;

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
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
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
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
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
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 事業者契約番号のgetメソッドです。
     * <br/>
     * <br/>償還受領委任契約事業者の事業者契約番号
     *
     * @return 事業者契約番号
     */
    public RString getJigyoshaKeiyakuNo() {
        return jigyoshaKeiyakuNo;
    }

    /**
     * 事業者契約番号のsetメソッドです。
     * <br/>
     * <br/>償還受領委任契約事業者の事業者契約番号
     *
     * @param jigyoshaKeiyakuNo 事業者契約番号
     */
    public void setJigyoshaKeiyakuNo(RString jigyoshaKeiyakuNo) {
        this.jigyoshaKeiyakuNo = jigyoshaKeiyakuNo;
    }

    /**
     * 契約サービス種類のgetメソッドです。
     * <br/>
     * <br/>1:住宅改修費,2:福祉用具購入費,3:償還払給付,4：高額給付
     *
     * @return 契約サービス種類
     */
    public RString getKeiyakuServiceShurui() {
        return keiyakuServiceShurui;
    }

    /**
     * 契約サービス種類のsetメソッドです。
     * <br/>
     * <br/>1:住宅改修費,2:福祉用具購入費,3:償還払給付,4：高額給付
     *
     * @param keiyakuServiceShurui 契約サービス種類
     */
    public void setKeiyakuServiceShurui(RString keiyakuServiceShurui) {
        this.keiyakuServiceShurui = keiyakuServiceShurui;
    }

    /**
     * 決定年月日のgetメソッドです。
     *
     * @return 決定年月日
     */
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
     * 受領委任払適用開始年月日のgetメソッドです。
     *
     * @return 受領委任払適用開始年月日
     */
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
     * 契約番号のgetメソッドです。
     * <br/>
     * <br/>開始年月日が属する西暦年度（4桁）＋契約事業者・年度単位に１からの連番（4桁）
     *
     * @return 契約番号
     */
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
     * 不承認理由のgetメソッドです。
     *
     * @return 不承認理由
     */
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
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.uketsukeYMD, other.uketsukeYMD)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
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
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.rirekiNo = entity.rirekiNo;
        this.shinseiYMD = entity.shinseiYMD;
        this.jigyoshaKeiyakuNo = entity.jigyoshaKeiyakuNo;
        this.keiyakuServiceShurui = entity.keiyakuServiceShurui;
        this.ketteiYMD = entity.ketteiYMD;
        this.shoninKekkaKubun = entity.shoninKekkaKubun;
        this.juryoininKaishiYMD = entity.juryoininKaishiYMD;
        this.juryoininShuryoYMD = entity.juryoininShuryoYMD;
        this.keiyakuNo = entity.keiyakuNo;
        this.fuShoninRiyu = entity.fuShoninRiyu;
        this.hiyoGakuGokei = entity.hiyoGakuGokei;
        this.hokenTaishoHiyoGaku = entity.hokenTaishoHiyoGaku;
        this.riyoshaJikoFutanGaku = entity.riyoshaJikoFutanGaku;
        this.hokenKyufuhiGaku = entity.hokenKyufuhiGaku;
        this.shoninKekkaTsuchiSakuseiYMD = entity.shoninKekkaTsuchiSakuseiYMD;
        this.shoninKekkaTsuchiSaiHakkoKubun = entity.shoninKekkaTsuchiSaiHakkoKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, shoKisaiHokenshaNo, uketsukeYMD, rirekiNo, shinseiYMD, jigyoshaKeiyakuNo, keiyakuServiceShurui, ketteiYMD, shoninKekkaKubun, juryoininKaishiYMD, juryoininShuryoYMD, keiyakuNo, fuShoninRiyu, hiyoGakuGokei, hokenTaishoHiyoGaku, riyoshaJikoFutanGaku, hokenKyufuhiGaku, shoninKekkaTsuchiSakuseiYMD, shoninKekkaTsuchiSaiHakkoKubun);
    }

// </editor-fold>
}

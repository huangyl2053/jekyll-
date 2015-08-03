package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 高額受領委任契約事業者テーブルのエンティティクラスです。
 */
public class DbT3076KogakuJuryoininKeiyakuJigyoshaEntity extends DbTableEntityBase<DbT3076KogakuJuryoininKeiyakuJigyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3076KogakuJuryoininKeiyakuJigyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private DbUDD002HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleDate shinseiYMD;
    private DbUDD004JigyoshaNo jigyoshaNo;
    private FlexibleDate ketteiYMD;
    private RString shoninKekkaKubun;
    private FlexibleDate juryoininKaishiYMD;
    private FlexibleDate juryoininShuryoYMD;
    private RString keiyakuNo;
    private RString fuShoninRiyu;
    private Decimal riyoshaFutanJogenGaku;
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
    public DbUDD002HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(DbUDD002HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
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
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(int rirekiNo) {
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
     * 事業者番号のgetメソッドです。
     * <br/>
     * <br/>受領委任対象の事業者番号
     * 
     * @return 事業者番号
     */
    public DbUDD004JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     * <br/>
     * <br/>受領委任対象の事業者番号
     * 
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(DbUDD004JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
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
     * 利用者負担上限額のgetメソッドです。
     * 
     * @return 利用者負担上限額
     */
    public Decimal getRiyoshaFutanJogenGaku() {
        return riyoshaFutanJogenGaku;
    }

    /**
     * 利用者負担上限額のsetメソッドです。
     * 
     * @param riyoshaFutanJogenGaku 利用者負担上限額
     */
    public void setRiyoshaFutanJogenGaku(Decimal riyoshaFutanJogenGaku) {
        this.riyoshaFutanJogenGaku = riyoshaFutanJogenGaku;
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
     * このエンティティの主キーが他の{@literal DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.rirekiNo = entity.rirekiNo;
        this.shinseiYMD = entity.shinseiYMD;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.ketteiYMD = entity.ketteiYMD;
        this.shoninKekkaKubun = entity.shoninKekkaKubun;
        this.juryoininKaishiYMD = entity.juryoininKaishiYMD;
        this.juryoininShuryoYMD = entity.juryoininShuryoYMD;
        this.keiyakuNo = entity.keiyakuNo;
        this.fuShoninRiyu = entity.fuShoninRiyu;
        this.riyoshaFutanJogenGaku = entity.riyoshaFutanJogenGaku;
        this.shoninKekkaTsuchiSakuseiYMD = entity.shoninKekkaTsuchiSakuseiYMD;
        this.shoninKekkaTsuchiSaiHakkoKubun = entity.shoninKekkaTsuchiSaiHakkoKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, uketsukeYMD, rirekiNo, shinseiYMD, jigyoshaNo, ketteiYMD, shoninKekkaKubun, juryoininKaishiYMD, juryoininShuryoYMD, keiyakuNo, fuShoninRiyu, riyoshaFutanJogenGaku, shoninKekkaTsuchiSakuseiYMD, shoninKekkaTsuchiSaiHakkoKubun);
    }

// </editor-fold>
}

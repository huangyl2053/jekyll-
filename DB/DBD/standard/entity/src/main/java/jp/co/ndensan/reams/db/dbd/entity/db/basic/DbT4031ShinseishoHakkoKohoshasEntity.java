package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;

/**
 * 申請書発行候補者テーブルのエンティティクラスです。
 * <br/> 申請書把握処理で候補者として判断された情報を保持する。
 */
public class DbT4031ShinseishoHakkoKohoshasEntity extends DbTableEntityBase<DbT4031ShinseishoHakkoKohoshasEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4031ShinseishoHakkoKohoshas");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private UUID haakuShoriID;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    private boolean willBeRenewed;
    private ShikibetsuCode shikibetsuCode;
    private RString setaiKazeiKubun;
    private RString honninKazeiKubun;
    private boolean isRoreiFukushiNenkinJukyusha;
    private boolean isSeikatsuHogoJukyusha;
    private RString riyoshaFutanDankai;
    private Decimal gokeiShotokuKingaku;
    private Decimal nenkinShunyuGaku;
    private Decimal hikazeinenkinKananGaku;
    private JigyoshaNo jigyoshaNo;

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
     * 把握処理IDのgetメソッドです。
     * 
     * @return 把握処理ID
     */
    public UUID getHaakuShoriID() {
        return haakuShoriID;
    }

    /**
     * 把握処理IDのsetメソッドです。
     * 
     * @param haakuShoriID 把握処理ID
     */
    public void setHaakuShoriID(@Nonnull UUID haakuShoriID) {
        this.haakuShoriID = haakuShoriID;
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
     * 更新認定フラグのgetメソッドです。
     * 
     * @return 更新認定フラグ
     */
    public boolean getWillBeRenewed() {
        return willBeRenewed;
    }

    /**
     * 更新認定フラグのsetメソッドです。
     * 
     * @param willBeRenewed 更新認定フラグ
     */
    public void setWillBeRenewed(@Nonnull boolean willBeRenewed) {
        this.willBeRenewed = willBeRenewed;
    }

    /**
     * 識別コードのgetメソッドです。
     * 
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * 
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 世帯課税区分のgetメソッドです。
     * 
     * @return 世帯課税区分
     */
    public RString getSetaiKazeiKubun() {
        return setaiKazeiKubun;
    }

    /**
     * 世帯課税区分のsetメソッドです。
     * 
     * @param setaiKazeiKubun 世帯課税区分
     */
    public void setSetaiKazeiKubun(@Nonnull RString setaiKazeiKubun) {
        this.setaiKazeiKubun = setaiKazeiKubun;
    }

    /**
     * 本人課税区分のgetメソッドです。
     * 
     * @return 本人課税区分
     */
    public RString getHonninKazeiKubun() {
        return honninKazeiKubun;
    }

    /**
     * 本人課税区分のsetメソッドです。
     * 
     * @param honninKazeiKubun 本人課税区分
     */
    public void setHonninKazeiKubun(@Nonnull RString honninKazeiKubun) {
        this.honninKazeiKubun = honninKazeiKubun;
    }

    /**
     * 老齢受給者フラグのgetメソッドです。
     * 
     * @return 老齢受給者フラグ
     */
    public boolean getIsRoreiFukushiNenkinJukyusha() {
        return isRoreiFukushiNenkinJukyusha;
    }

    /**
     * 老齢受給者フラグのsetメソッドです。
     * 
     * @param isRoreiFukushiNenkinJukyusha 老齢受給者フラグ
     */
    public void setIsRoreiFukushiNenkinJukyusha(@Nonnull boolean isRoreiFukushiNenkinJukyusha) {
        this.isRoreiFukushiNenkinJukyusha = isRoreiFukushiNenkinJukyusha;
    }

    /**
     * 生保受給者フラグのgetメソッドです。
     * 
     * @return 生保受給者フラグ
     */
    public boolean getIsSeikatsuHogoJukyusha() {
        return isSeikatsuHogoJukyusha;
    }

    /**
     * 生保受給者フラグのsetメソッドです。
     * 
     * @param isSeikatsuHogoJukyusha 生保受給者フラグ
     */
    public void setIsSeikatsuHogoJukyusha(@Nonnull boolean isSeikatsuHogoJukyusha) {
        this.isSeikatsuHogoJukyusha = isSeikatsuHogoJukyusha;
    }

    /**
     * 利用者負担段階のgetメソッドです。
     * 
     * @return 利用者負担段階
     */
    public RString getRiyoshaFutanDankai() {
        return riyoshaFutanDankai;
    }

    /**
     * 利用者負担段階のsetメソッドです。
     * 
     * @param riyoshaFutanDankai 利用者負担段階
     */
    public void setRiyoshaFutanDankai(@Nonnull RString riyoshaFutanDankai) {
        this.riyoshaFutanDankai = riyoshaFutanDankai;
    }

    /**
     * 合計所得金額のgetメソッドです。
     * 
     * @return 合計所得金額
     */
    @CheckForNull
    public Decimal getGokeiShotokuKingaku() {
        return gokeiShotokuKingaku;
    }

    /**
     * 合計所得金額のsetメソッドです。
     * 
     * @param gokeiShotokuKingaku 合計所得金額
     */
    public void setGokeiShotokuKingaku(Decimal gokeiShotokuKingaku) {
        this.gokeiShotokuKingaku = gokeiShotokuKingaku;
    }

    /**
     * 年金収入額のgetメソッドです。
     * 
     * @return 年金収入額
     */
    @CheckForNull
    public Decimal getNenkinShunyuGaku() {
        return nenkinShunyuGaku;
    }

    /**
     * 年金収入額のsetメソッドです。
     * 
     * @param nenkinShunyuGaku 年金収入額
     */
    public void setNenkinShunyuGaku(Decimal nenkinShunyuGaku) {
        this.nenkinShunyuGaku = nenkinShunyuGaku;
    }

    /**
     * 非課税年金勘案額のgetメソッドです。
     * <br/>
     * <br/>減免減額申請書発行用対象者把握時に把握された、非課税年金対象者テーブルから引用する金額
     * 
     * @return 非課税年金勘案額
     */
    @CheckForNull
    public Decimal getHikazeinenkinKananGaku() {
        return hikazeinenkinKananGaku;
    }

    /**
     * 非課税年金勘案額のsetメソッドです。
     * <br/>
     * <br/>減免減額申請書発行用対象者把握時に把握された、非課税年金対象者テーブルから引用する金額
     * 
     * @param hikazeinenkinKananGaku 非課税年金勘案額
     */
    public void setHikazeinenkinKananGaku(Decimal hikazeinenkinKananGaku) {
        this.hikazeinenkinKananGaku = hikazeinenkinKananGaku;
    }

    /**
     * 事業者番号のgetメソッドです。
     * 
     * @return 事業者番号
     */
    @CheckForNull
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     * 
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4031ShinseishoHakkoKohoshasEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4031ShinseishoHakkoKohoshasEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4031ShinseishoHakkoKohoshasEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.haakuShoriID, other.haakuShoriID)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4031ShinseishoHakkoKohoshasEntity entity) {
        this.haakuShoriID = entity.haakuShoriID;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.willBeRenewed = entity.willBeRenewed;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.setaiKazeiKubun = entity.setaiKazeiKubun;
        this.honninKazeiKubun = entity.honninKazeiKubun;
        this.isRoreiFukushiNenkinJukyusha = entity.isRoreiFukushiNenkinJukyusha;
        this.isSeikatsuHogoJukyusha = entity.isSeikatsuHogoJukyusha;
        this.riyoshaFutanDankai = entity.riyoshaFutanDankai;
        this.gokeiShotokuKingaku = entity.gokeiShotokuKingaku;
        this.nenkinShunyuGaku = entity.nenkinShunyuGaku;
        this.hikazeinenkinKananGaku = entity.hikazeinenkinKananGaku;
        this.jigyoshaNo = entity.jigyoshaNo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(haakuShoriID, hihokenshaNo, willBeRenewed, shikibetsuCode, setaiKazeiKubun, honninKazeiKubun, isRoreiFukushiNenkinJukyusha, isSeikatsuHogoJukyusha, riyoshaFutanDankai, gokeiShotokuKingaku, nenkinShunyuGaku, hikazeinenkinKananGaku, jigyoshaNo);
    }

// </editor-fold>

}

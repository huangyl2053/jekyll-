package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 通知書発行後異動者テーブルのエンティティクラスです。
 * <br/> 通知書の一括発行時、発行対象とした賦課の情報を登録しておくテーブル。

     * <br/>その後、住基や資格情報に異動があったかどうかを検証する際に用いる。
 */
public class DbT2017TsuchishoHakkogoIdoshaEntity extends DbTableEntityBase<DbT2017TsuchishoHakkogoIdoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT2017TsuchishoHakkogoIdosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ReportId reportID;
    @PrimaryKey
    private YMDHMS chohyosakuseiTimestamp;
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    private FlexibleYear fukaNendo;
    private ShikibetsuCode shikibetsuCode;
    private HihokenshaNo hihokenshaNo;
    private YMDHMS keisanTimestamp;
    private int gaitoRemban;
    private FlexibleDate idoYMD;
    private RString idoNaiyo;
    private boolean idoAriFlag;

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
     * 帳票IDのgetメソッドです。
     * <br/>
     * <br/>一括発行対象となった帳票ID。
     * 
     * @return 帳票ID
     */
    public ReportId getReportID() {
        return reportID;
    }

    /**
     * 帳票IDのsetメソッドです。
     * <br/>
     * <br/>一括発行対象となった帳票ID。
     * 
     * @param reportID 帳票ID
     */
    public void setReportID(@Nonnull ReportId reportID) {
        this.reportID = reportID;
    }

    /**
     * 帳票作成日時のgetメソッドです。
     * <br/>
     * <br/>一括発行の日時（同じ一括発行であれば、同じ日時とする）。
     * 
     * @return 帳票作成日時
     */
    public YMDHMS getChohyosakuseiTimestamp() {
        return chohyosakuseiTimestamp;
    }

    /**
     * 帳票作成日時のsetメソッドです。
     * <br/>
     * <br/>一括発行の日時（同じ一括発行であれば、同じ日時とする）。
     * 
     * @param chohyosakuseiTimestamp 帳票作成日時
     */
    public void setChohyosakuseiTimestamp(@Nonnull YMDHMS chohyosakuseiTimestamp) {
        this.chohyosakuseiTimestamp = chohyosakuseiTimestamp;
    }

    /**
     * 通知書番号のgetメソッドです。
     * <br/>
     * <br/>通知書発行対象となった賦課の通知書番号。
     * 
     * @return 通知書番号
     */
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * 通知書番号のsetメソッドです。
     * <br/>
     * <br/>通知書発行対象となった賦課の通知書番号。
     * 
     * @param tsuchishoNo 通知書番号
     */
    public void setTsuchishoNo(@Nonnull TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * 賦課年度のgetメソッドです。
     * <br/>
     * <br/>通知書発行対象となった賦課の賦課年度。
     * 
     * @return 賦課年度
     */
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * 賦課年度のsetメソッドです。
     * <br/>
     * <br/>通知書発行対象となった賦課の賦課年度。
     * 
     * @param fukaNendo 賦課年度
     */
    public void setFukaNendo(@Nonnull FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * 識別コードのgetメソッドです。
     * <br/>
     * <br/>賦課・通知書発行の対象となった被保険者の識別コード。
     * 
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * <br/>
     * <br/>賦課・通知書発行の対象となった被保険者の識別コード。
     * 
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * <br/>
     * <br/>賦課、通知書発行の対象となった被保険者の被保険者番号。
     * 
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * <br/>
     * <br/>賦課、通知書発行の対象となった被保険者の被保険者番号。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 計算処理日時のgetメソッドです。
     * <br/>
     * <br/>賦課の計算が行われた日時（＝調定日時）。
     * 
     * @return 計算処理日時
     */
    public YMDHMS getKeisanTimestamp() {
        return keisanTimestamp;
    }

    /**
     * 計算処理日時のsetメソッドです。
     * <br/>
     * <br/>賦課の計算が行われた日時（＝調定日時）。
     * 
     * @param keisanTimestamp 計算処理日時
     */
    public void setKeisanTimestamp(@Nonnull YMDHMS keisanTimestamp) {
        this.keisanTimestamp = keisanTimestamp;
    }

    /**
     * 該当連番のgetメソッドです。
     * <br/>
     * <br/>バッチの一括発行時、発行順に振られた連番。
     * 
     * @return 該当連番
     */
    public int getGaitoRemban() {
        return gaitoRemban;
    }

    /**
     * 該当連番のsetメソッドです。
     * <br/>
     * <br/>バッチの一括発行時、発行順に振られた連番。
     * 
     * @param gaitoRemban 該当連番
     */
    public void setGaitoRemban(@Nonnull int gaitoRemban) {
        this.gaitoRemban = gaitoRemban;
    }

    /**
     * 異動年月日のgetメソッドです。
     * <br/>
     * <br/>通知書発行後に異動のあった年月日。
     * 
     * @return 異動年月日
     */
    @CheckForNull
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 異動年月日のsetメソッドです。
     * <br/>
     * <br/>通知書発行後に異動のあった年月日。
     * 
     * @param idoYMD 異動年月日
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * 異動内容のgetメソッドです。
     * <br/>
     * <br/>通知書発行後にあった異動の内容。

     * <br/>0：なし 1:資格異動 2:氏名変更 3:本人住所変更
     * 
     * @return 異動内容
     */
    @CheckForNull
    public RString getIdoNaiyo() {
        return idoNaiyo;
    }

    /**
     * 異動内容のsetメソッドです。
     * <br/>
     * <br/>通知書発行後にあった異動の内容。

     * <br/>0：なし 1:資格異動 2:氏名変更 3:本人住所変更
     * 
     * @param idoNaiyo 異動内容
     */
    public void setIdoNaiyo(RString idoNaiyo) {
        this.idoNaiyo = idoNaiyo;
    }

    /**
     * 異動ありフラグのgetメソッドです。
     * <br/>
     * <br/>異動チェック時、通知書発行後に異動があった場合、trueを設定する。チェック処理の前はすべてfalse。
     * 
     * @return 異動ありフラグ
     */
    public boolean getIdoAriFlag() {
        return idoAriFlag;
    }

    /**
     * 異動ありフラグのsetメソッドです。
     * <br/>
     * <br/>異動チェック時、通知書発行後に異動があった場合、trueを設定する。チェック処理の前はすべてfalse。
     * 
     * @param idoAriFlag 異動ありフラグ
     */
    public void setIdoAriFlag(@Nonnull boolean idoAriFlag) {
        this.idoAriFlag = idoAriFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2017TsuchishoHakkogoIdoshaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2017TsuchishoHakkogoIdoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2017TsuchishoHakkogoIdoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.reportID, other.reportID)) {
            return false;
        }
        if (!Objects.equals(this.chohyosakuseiTimestamp, other.chohyosakuseiTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.tsuchishoNo, other.tsuchishoNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT2017TsuchishoHakkogoIdoshaEntity entity) {
        this.reportID = entity.reportID;
        this.chohyosakuseiTimestamp = entity.chohyosakuseiTimestamp;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.fukaNendo = entity.fukaNendo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.keisanTimestamp = entity.keisanTimestamp;
        this.gaitoRemban = entity.gaitoRemban;
        this.idoYMD = entity.idoYMD;
        this.idoNaiyo = entity.idoNaiyo;
        this.idoAriFlag = entity.idoAriFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(reportID, chohyosakuseiTimestamp, tsuchishoNo, fukaNendo, shikibetsuCode, hihokenshaNo, keisanTimestamp, gaitoRemban, idoYMD, idoNaiyo, idoAriFlag);
    }

// </editor-fold>
}

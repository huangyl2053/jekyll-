package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 汎用リスト項目変換テーブルのエンティティクラスです。
 * <br/> 汎用リストの出力項目(列名)とExcelファイル上の項目位置の変換に使用
 */
public class DbT7401HanyoLisyInvertedEntity extends DbTableEntityBase<DbT7401HanyoLisyInvertedEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7401HanyoLisyInverted");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ReportId reportId;
    @PrimaryKey
    private RString komokuId;
    private int komokuIchi;
    private RString chohyoHyojiIchi;
    private RString kingakuHenshuHoho;
    private boolean logicalDeletedFlag;

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
     * <br/>出力項目管理テーブル（UrT0072ShutsuryokuKomokuKanri）、出力項目設定テーブル（UrT0073ShutsuryokuKomokuSettei）へのリンク情報
     * 
     * @return 帳票ID
     */
    public ReportId getReportId() {
        return reportId;
    }

    /**
     * 帳票IDのsetメソッドです。
     * <br/>
     * <br/>出力項目管理テーブル（UrT0072ShutsuryokuKomokuKanri）、出力項目設定テーブル（UrT0073ShutsuryokuKomokuSettei）へのリンク情報
     * 
     * @param reportId 帳票ID
     */
    public void setReportId(@Nonnull ReportId reportId) {
        this.reportId = reportId;
    }

    /**
     * 項目IDのgetメソッドです。
     * <br/>
     * <br/>帳票出力項目管理（UrT0171ChohyoShutsuryokuKomokuKanri）、出力項目設定テーブル（UrT0073ShutsuryokuKomokuSettei）へのリンク情報
     * 
     * @return 項目ID
     */
    public RString getKomokuId() {
        return komokuId;
    }

    /**
     * 項目IDのsetメソッドです。
     * <br/>
     * <br/>帳票出力項目管理（UrT0171ChohyoShutsuryokuKomokuKanri）、出力項目設定テーブル（UrT0073ShutsuryokuKomokuSettei）へのリンク情報
     * 
     * @param komokuId 項目ID
     */
    public void setKomokuId(@Nonnull RString komokuId) {
        this.komokuId = komokuId;
    }

    /**
     * 項目位置のgetメソッドです。
     * <br/>
     * <br/>中間(出力用に編集した)CSVのカラム位置（0オリジン）
     * 
     * @return 項目位置
     */
    public int getKomokuIchi() {
        return komokuIchi;
    }

    /**
     * 項目位置のsetメソッドです。
     * <br/>
     * <br/>中間(出力用に編集した)CSVのカラム位置（0オリジン）
     * 
     * @param komokuIchi 項目位置
     */
    public void setKomokuIchi(@Nonnull int komokuIchi) {
        this.komokuIchi = komokuIchi;
    }

    /**
     * 帳票表示位置のgetメソッドです。
     * <br/>
     * <br/>0:左詰め　1:右詰め
     * 
     * @return 帳票表示位置
     */
    public RString getChohyoHyojiIchi() {
        return chohyoHyojiIchi;
    }

    /**
     * 帳票表示位置のsetメソッドです。
     * <br/>
     * <br/>0:左詰め　1:右詰め
     * 
     * @param chohyoHyojiIchi 帳票表示位置
     */
    public void setChohyoHyojiIchi(@Nonnull RString chohyoHyojiIchi) {
        this.chohyoHyojiIchi = chohyoHyojiIchi;
    }

    /**
     * 金額編集のgetメソッドです。
     * <br/>
     * <br/>0:不要　1:必要（Z,ZZ9編集)
     * 
     * @return 金額編集
     */
    public RString getKingakuHenshuHoho() {
        return kingakuHenshuHoho;
    }

    /**
     * 金額編集のsetメソッドです。
     * <br/>
     * <br/>0:不要　1:必要（Z,ZZ9編集)
     * 
     * @param kingakuHenshuHoho 金額編集
     */
    public void setKingakuHenshuHoho(@Nonnull RString kingakuHenshuHoho) {
        this.kingakuHenshuHoho = kingakuHenshuHoho;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     * 
     * @return 論理削除フラグ
     */
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * 論理削除フラグのsetメソッドです。
     * 
     * @param logicalDeletedFlag 論理削除フラグ
     */
    public void setLogicalDeletedFlag(@Nonnull boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7401HanyoLisyInvertedEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7401HanyoLisyInvertedEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7401HanyoLisyInvertedEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.reportId, other.reportId)) {
            return false;
        }
        if (!Objects.equals(this.komokuId, other.komokuId)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7401HanyoLisyInvertedEntity entity) {
        this.reportId = entity.reportId;
        this.komokuId = entity.komokuId;
        this.komokuIchi = entity.komokuIchi;
        this.chohyoHyojiIchi = entity.chohyoHyojiIchi;
        this.kingakuHenshuHoho = entity.kingakuHenshuHoho;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(reportId, komokuId, komokuIchi, chohyoHyojiIchi, kingakuHenshuHoho, logicalDeletedFlag);
    }

// </editor-fold>
}

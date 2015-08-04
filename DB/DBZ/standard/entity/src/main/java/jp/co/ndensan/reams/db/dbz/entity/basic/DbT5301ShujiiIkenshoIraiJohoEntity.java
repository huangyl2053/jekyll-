package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * 主治医意見書作成依頼情報テーブルのエンティティクラスです。
 */
public class DbT5301ShujiiIkenshoIraiJohoEntity extends DbTableEntityBase<DbT5301ShujiiIkenshoIraiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5301ShujiiIkenshoIraiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private DbUDD013ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ikenshoIraiRirekiNo;
    private Code koroshoIfShikibetsuCode;
    private RString shujiiIryokikanCode;
    private RString shujiiCode;
    private RString ikenshoIraiKubun;
    private int ikenshoIraiKaisu;
    private Code ishiKubunCode;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private FlexibleDate ikenshoSakuseiKigenYMD;
    private FlexibleDate iraishoShutsuryokuYMD;
    private FlexibleDate ikenshoShutsuryokuYMD;
    private FlexibleDate seikyushoShutsuryokuYMD;
    private Code sakuseiryoSeikyuKubun;
    private FlexibleDate ikenshoSakuseiTokusokuYMD;
    private RString ikenshoSakuseiTokusokuHoho;
    private int ikenshoTokusokuKaisu;
    private RString ikenshoTokusokuMemo;
    private boolean ninteiJohoTeikyoKiboFlag;
    private FlexibleDate ninteiJohoTeikyoYMD;
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
     * 申請書管理番号のgetメソッドです。
     * 
     * @return 申請書管理番号
     */
    public DbUDD013ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(DbUDD013ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 主治医意見書作成依頼履歴番号のgetメソッドです。
     * 
     * @return 主治医意見書作成依頼履歴番号
     */
    public int getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    /**
     * 主治医意見書作成依頼履歴番号のsetメソッドです。
     * 
     * @param ikenshoIraiRirekiNo 主治医意見書作成依頼履歴番号
     */
    public void setIkenshoIraiRirekiNo(int ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    /**
     * 厚労省IF識別コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）パーティショニングのCheck項目
     * 
     * @return 厚労省IF識別コード
     */
    public Code getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * 厚労省IF識別コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）パーティショニングのCheck項目
     * 
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     */
    public void setKoroshoIfShikibetsuCode(Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 主治医医療機関コードのgetメソッドです。
     * <br/>
     * <br/>主治医医療機関情報
     * 
     * @return 主治医医療機関コード
     */
    public RString getShujiiIryokikanCode() {
        return shujiiIryokikanCode;
    }

    /**
     * 主治医医療機関コードのsetメソッドです。
     * <br/>
     * <br/>主治医医療機関情報
     * 
     * @param shujiiIryokikanCode 主治医医療機関コード
     */
    public void setShujiiIryokikanCode(RString shujiiIryokikanCode) {
        this.shujiiIryokikanCode = shujiiIryokikanCode;
    }

    /**
     * 主治医コードのgetメソッドです。
     * <br/>
     * <br/>主治医情報
     * 
     * @return 主治医コード
     */
    public RString getShujiiCode() {
        return shujiiCode;
    }

    /**
     * 主治医コードのsetメソッドです。
     * <br/>
     * <br/>主治医情報
     * 
     * @param shujiiCode 主治医コード
     */
    public void setShujiiCode(RString shujiiCode) {
        this.shujiiCode = shujiiCode;
    }

    /**
     * 主治医意見書依頼区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：主治医意見書依頼区分）初回・再依頼・再意見書
     * 
     * @return 主治医意見書依頼区分
     */
    public RString getIkenshoIraiKubun() {
        return ikenshoIraiKubun;
    }

    /**
     * 主治医意見書依頼区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：主治医意見書依頼区分）初回・再依頼・再意見書
     * 
     * @param ikenshoIraiKubun 主治医意見書依頼区分
     */
    public void setIkenshoIraiKubun(RString ikenshoIraiKubun) {
        this.ikenshoIraiKubun = ikenshoIraiKubun;
    }

    /**
     * 主治医意見書作成回数のgetメソッドです。
     * <br/>
     * <br/>主治医意見書を作成した回数（申請単位）
     * 
     * @return 主治医意見書作成回数
     */
    public int getIkenshoIraiKaisu() {
        return ikenshoIraiKaisu;
    }

    /**
     * 主治医意見書作成回数のsetメソッドです。
     * <br/>
     * <br/>主治医意見書を作成した回数（申請単位）
     * 
     * @param ikenshoIraiKaisu 主治医意見書作成回数
     */
    public void setIkenshoIraiKaisu(int ikenshoIraiKaisu) {
        this.ikenshoIraiKaisu = ikenshoIraiKaisu;
    }

    /**
     * 医師区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：医師区分コード）主治医・指定医
     * 
     * @return 医師区分コード
     */
    public Code getIshiKubunCode() {
        return ishiKubunCode;
    }

    /**
     * 医師区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：医師区分コード）主治医・指定医
     * 
     * @param ishiKubunCode 医師区分コード
     */
    public void setIshiKubunCode(Code ishiKubunCode) {
        this.ishiKubunCode = ishiKubunCode;
    }

    /**
     * 主治医意見書作成依頼年月日のgetメソッドです。
     * 
     * @return 主治医意見書作成依頼年月日
     */
    public FlexibleDate getIkenshoSakuseiIraiYMD() {
        return ikenshoSakuseiIraiYMD;
    }

    /**
     * 主治医意見書作成依頼年月日のsetメソッドです。
     * 
     * @param ikenshoSakuseiIraiYMD 主治医意見書作成依頼年月日
     */
    public void setIkenshoSakuseiIraiYMD(FlexibleDate ikenshoSakuseiIraiYMD) {
        this.ikenshoSakuseiIraiYMD = ikenshoSakuseiIraiYMD;
    }

    /**
     * 主治医意見書作成期限年月日のgetメソッドです。
     * 
     * @return 主治医意見書作成期限年月日
     */
    public FlexibleDate getIkenshoSakuseiKigenYMD() {
        return ikenshoSakuseiKigenYMD;
    }

    /**
     * 主治医意見書作成期限年月日のsetメソッドです。
     * 
     * @param ikenshoSakuseiKigenYMD 主治医意見書作成期限年月日
     */
    public void setIkenshoSakuseiKigenYMD(FlexibleDate ikenshoSakuseiKigenYMD) {
        this.ikenshoSakuseiKigenYMD = ikenshoSakuseiKigenYMD;
    }

    /**
     * 依頼書出力年月日のgetメソッドです。
     * 
     * @return 依頼書出力年月日
     */
    public FlexibleDate getIraishoShutsuryokuYMD() {
        return iraishoShutsuryokuYMD;
    }

    /**
     * 依頼書出力年月日のsetメソッドです。
     * 
     * @param iraishoShutsuryokuYMD 依頼書出力年月日
     */
    public void setIraishoShutsuryokuYMD(FlexibleDate iraishoShutsuryokuYMD) {
        this.iraishoShutsuryokuYMD = iraishoShutsuryokuYMD;
    }

    /**
     * 意見書出力年月日のgetメソッドです。
     * 
     * @return 意見書出力年月日
     */
    public FlexibleDate getIkenshoShutsuryokuYMD() {
        return ikenshoShutsuryokuYMD;
    }

    /**
     * 意見書出力年月日のsetメソッドです。
     * 
     * @param ikenshoShutsuryokuYMD 意見書出力年月日
     */
    public void setIkenshoShutsuryokuYMD(FlexibleDate ikenshoShutsuryokuYMD) {
        this.ikenshoShutsuryokuYMD = ikenshoShutsuryokuYMD;
    }

    /**
     * 請求書出力年月日のgetメソッドです。
     * 
     * @return 請求書出力年月日
     */
    public FlexibleDate getSeikyushoShutsuryokuYMD() {
        return seikyushoShutsuryokuYMD;
    }

    /**
     * 請求書出力年月日のsetメソッドです。
     * 
     * @param seikyushoShutsuryokuYMD 請求書出力年月日
     */
    public void setSeikyushoShutsuryokuYMD(FlexibleDate seikyushoShutsuryokuYMD) {
        this.seikyushoShutsuryokuYMD = seikyushoShutsuryokuYMD;
    }

    /**
     * 作成料請求区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：作成料請求区分）
     * 
     * @return 作成料請求区分
     */
    public Code getSakuseiryoSeikyuKubun() {
        return sakuseiryoSeikyuKubun;
    }

    /**
     * 作成料請求区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：作成料請求区分）
     * 
     * @param sakuseiryoSeikyuKubun 作成料請求区分
     */
    public void setSakuseiryoSeikyuKubun(Code sakuseiryoSeikyuKubun) {
        this.sakuseiryoSeikyuKubun = sakuseiryoSeikyuKubun;
    }

    /**
     * 主治医意見書作成督促年月日のgetメソッドです。
     * 
     * @return 主治医意見書作成督促年月日
     */
    public FlexibleDate getIkenshoSakuseiTokusokuYMD() {
        return ikenshoSakuseiTokusokuYMD;
    }

    /**
     * 主治医意見書作成督促年月日のsetメソッドです。
     * 
     * @param ikenshoSakuseiTokusokuYMD 主治医意見書作成督促年月日
     */
    public void setIkenshoSakuseiTokusokuYMD(FlexibleDate ikenshoSakuseiTokusokuYMD) {
        this.ikenshoSakuseiTokusokuYMD = ikenshoSakuseiTokusokuYMD;
    }

    /**
     * 主治医意見書作成督促方法のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：意見書作成督促方法）電話・ＦＡＸ・督促状
     * 
     * @return 主治医意見書作成督促方法
     */
    public RString getIkenshoSakuseiTokusokuHoho() {
        return ikenshoSakuseiTokusokuHoho;
    }

    /**
     * 主治医意見書作成督促方法のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：意見書作成督促方法）電話・ＦＡＸ・督促状
     * 
     * @param ikenshoSakuseiTokusokuHoho 主治医意見書作成督促方法
     */
    public void setIkenshoSakuseiTokusokuHoho(RString ikenshoSakuseiTokusokuHoho) {
        this.ikenshoSakuseiTokusokuHoho = ikenshoSakuseiTokusokuHoho;
    }

    /**
     * 主治医意見書作成督促回数のgetメソッドです。
     * 
     * @return 主治医意見書作成督促回数
     */
    public int getIkenshoTokusokuKaisu() {
        return ikenshoTokusokuKaisu;
    }

    /**
     * 主治医意見書作成督促回数のsetメソッドです。
     * 
     * @param ikenshoTokusokuKaisu 主治医意見書作成督促回数
     */
    public void setIkenshoTokusokuKaisu(int ikenshoTokusokuKaisu) {
        this.ikenshoTokusokuKaisu = ikenshoTokusokuKaisu;
    }

    /**
     * 主治医意見書作成督促メモのgetメソッドです。
     * 
     * @return 主治医意見書作成督促メモ
     */
    public RString getIkenshoTokusokuMemo() {
        return ikenshoTokusokuMemo;
    }

    /**
     * 主治医意見書作成督促メモのsetメソッドです。
     * 
     * @param ikenshoTokusokuMemo 主治医意見書作成督促メモ
     */
    public void setIkenshoTokusokuMemo(RString ikenshoTokusokuMemo) {
        this.ikenshoTokusokuMemo = ikenshoTokusokuMemo;
    }

    /**
     * 認定情報提供希望フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定情報提供希望フラグ）
     * 
     * @return 認定情報提供希望フラグ
     */
    public boolean getNinteiJohoTeikyoKiboFlag() {
        return ninteiJohoTeikyoKiboFlag;
    }

    /**
     * 認定情報提供希望フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定情報提供希望フラグ）
     * 
     * @param ninteiJohoTeikyoKiboFlag 認定情報提供希望フラグ
     */
    public void setNinteiJohoTeikyoKiboFlag(boolean ninteiJohoTeikyoKiboFlag) {
        this.ninteiJohoTeikyoKiboFlag = ninteiJohoTeikyoKiboFlag;
    }

    /**
     * 認定状況提供年月日のgetメソッドです。
     * 
     * @return 認定状況提供年月日
     */
    public FlexibleDate getNinteiJohoTeikyoYMD() {
        return ninteiJohoTeikyoYMD;
    }

    /**
     * 認定状況提供年月日のsetメソッドです。
     * 
     * @param ninteiJohoTeikyoYMD 認定状況提供年月日
     */
    public void setNinteiJohoTeikyoYMD(FlexibleDate ninteiJohoTeikyoYMD) {
        this.ninteiJohoTeikyoYMD = ninteiJohoTeikyoYMD;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     * <br/>
     * <br/>True：削除　False：通常
     * 
     * @return 論理削除フラグ
     */
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * 論理削除フラグのsetメソッドです。
     * <br/>
     * <br/>True：削除　False：通常
     * 
     * @param logicalDeletedFlag 論理削除フラグ
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5301ShujiiIkenshoIraiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5301ShujiiIkenshoIraiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5301ShujiiIkenshoIraiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ikenshoIraiRirekiNo != other.ikenshoIraiRirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5301ShujiiIkenshoIraiJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ikenshoIraiRirekiNo = entity.ikenshoIraiRirekiNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.shujiiIryokikanCode = entity.shujiiIryokikanCode;
        this.shujiiCode = entity.shujiiCode;
        this.ikenshoIraiKubun = entity.ikenshoIraiKubun;
        this.ikenshoIraiKaisu = entity.ikenshoIraiKaisu;
        this.ishiKubunCode = entity.ishiKubunCode;
        this.ikenshoSakuseiIraiYMD = entity.ikenshoSakuseiIraiYMD;
        this.ikenshoSakuseiKigenYMD = entity.ikenshoSakuseiKigenYMD;
        this.iraishoShutsuryokuYMD = entity.iraishoShutsuryokuYMD;
        this.ikenshoShutsuryokuYMD = entity.ikenshoShutsuryokuYMD;
        this.seikyushoShutsuryokuYMD = entity.seikyushoShutsuryokuYMD;
        this.sakuseiryoSeikyuKubun = entity.sakuseiryoSeikyuKubun;
        this.ikenshoSakuseiTokusokuYMD = entity.ikenshoSakuseiTokusokuYMD;
        this.ikenshoSakuseiTokusokuHoho = entity.ikenshoSakuseiTokusokuHoho;
        this.ikenshoTokusokuKaisu = entity.ikenshoTokusokuKaisu;
        this.ikenshoTokusokuMemo = entity.ikenshoTokusokuMemo;
        this.ninteiJohoTeikyoKiboFlag = entity.ninteiJohoTeikyoKiboFlag;
        this.ninteiJohoTeikyoYMD = entity.ninteiJohoTeikyoYMD;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ikenshoIraiRirekiNo, koroshoIfShikibetsuCode, shujiiIryokikanCode, shujiiCode, ikenshoIraiKubun, ikenshoIraiKaisu, ishiKubunCode, ikenshoSakuseiIraiYMD, ikenshoSakuseiKigenYMD, iraishoShutsuryokuYMD, ikenshoShutsuryokuYMD, seikyushoShutsuryokuYMD, sakuseiryoSeikyuKubun, ikenshoSakuseiTokusokuYMD, ikenshoSakuseiTokusokuHoho, ikenshoTokusokuKaisu, ikenshoTokusokuMemo, ninteiJohoTeikyoKiboFlag, ninteiJohoTeikyoYMD, logicalDeletedFlag);
    }

// </editor-fold>
}

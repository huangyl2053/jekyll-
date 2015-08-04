package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import java.util.Objects;

/**
 * 証交付回収テーブルのエンティティクラスです。
 * <br/> 被保険者証および資格者証の交付記録および回収記録を管理します。
 */
public class DbT7037ShoKofuKaishuEntity extends DbTableEntityBase<DbT7037ShoKofuKaishuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7037ShoKofuKaishu");

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
    private RString kofuShoShurui;
    @PrimaryKey
    private int rirekiNo;
    private LasdecCode shichosonCode;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate kofuYMD;
    private FlexibleDate yukoKigenYMD;
    private RString kofuJiyu;
    private RString kofuRiyu;
    private FlexibleDate kaishuYMD;
    private RString kaishuJiyu;
    private RString kaishuRiyu;
    private boolean tanpyoHakkoUmuFlag;
    private YMDHMS hakkoShoriTimestamp;
    private RString shinYoshikiSumiKubunCode;
    private RString shoYoshikiKubunCode;
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
     * 交付証種類のgetメソッドです。
     * <br/>
     * <br/>コード定義
     * 
     * @return 交付証種類
     */
    public RString getKofuShoShurui() {
        return kofuShoShurui;
    }

    /**
     * 交付証種類のsetメソッドです。
     * <br/>
     * <br/>コード定義
     * 
     * @param kofuShoShurui 交付証種類
     */
    public void setKofuShoShurui(RString kofuShoShurui) {
        this.kofuShoShurui = kofuShoShurui;
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
     * 市町村コードのgetメソッドです。
     * 
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     * 
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
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
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 交付年月日のgetメソッドです。
     * 
     * @return 交付年月日
     */
    public FlexibleDate getKofuYMD() {
        return kofuYMD;
    }

    /**
     * 交付年月日のsetメソッドです。
     * 
     * @param kofuYMD 交付年月日
     */
    public void setKofuYMD(FlexibleDate kofuYMD) {
        this.kofuYMD = kofuYMD;
    }

    /**
     * 有効期限のgetメソッドです。
     * 
     * @return 有効期限
     */
    public FlexibleDate getYukoKigenYMD() {
        return yukoKigenYMD;
    }

    /**
     * 有効期限のsetメソッドです。
     * 
     * @param yukoKigenYMD 有効期限
     */
    public void setYukoKigenYMD(FlexibleDate yukoKigenYMD) {
        this.yukoKigenYMD = yukoKigenYMD;
    }

    /**
     * 交付事由のgetメソッドです。
     * <br/>
     * <br/>コード定義
     * 
     * @return 交付事由
     */
    public RString getKofuJiyu() {
        return kofuJiyu;
    }

    /**
     * 交付事由のsetメソッドです。
     * <br/>
     * <br/>コード定義
     * 
     * @param kofuJiyu 交付事由
     */
    public void setKofuJiyu(RString kofuJiyu) {
        this.kofuJiyu = kofuJiyu;
    }

    /**
     * 交付理由のgetメソッドです。
     * 
     * @return 交付理由
     */
    public RString getKofuRiyu() {
        return kofuRiyu;
    }

    /**
     * 交付理由のsetメソッドです。
     * 
     * @param kofuRiyu 交付理由
     */
    public void setKofuRiyu(RString kofuRiyu) {
        this.kofuRiyu = kofuRiyu;
    }

    /**
     * 回収年月日のgetメソッドです。
     * 
     * @return 回収年月日
     */
    public FlexibleDate getKaishuYMD() {
        return kaishuYMD;
    }

    /**
     * 回収年月日のsetメソッドです。
     * 
     * @param kaishuYMD 回収年月日
     */
    public void setKaishuYMD(FlexibleDate kaishuYMD) {
        this.kaishuYMD = kaishuYMD;
    }

    /**
     * 回収事由のgetメソッドです。
     * <br/>
     * <br/>コード定義
     * 
     * @return 回収事由
     */
    public RString getKaishuJiyu() {
        return kaishuJiyu;
    }

    /**
     * 回収事由のsetメソッドです。
     * <br/>
     * <br/>コード定義
     * 
     * @param kaishuJiyu 回収事由
     */
    public void setKaishuJiyu(RString kaishuJiyu) {
        this.kaishuJiyu = kaishuJiyu;
    }

    /**
     * 回収理由のgetメソッドです。
     * 
     * @return 回収理由
     */
    public RString getKaishuRiyu() {
        return kaishuRiyu;
    }

    /**
     * 回収理由のsetメソッドです。
     * 
     * @param kaishuRiyu 回収理由
     */
    public void setKaishuRiyu(RString kaishuRiyu) {
        this.kaishuRiyu = kaishuRiyu;
    }

    /**
     * 単票発行有無フラグのgetメソッドです。
     * <br/>
     * <br/>True：単票発行した、False：単票発行していない
     * 
     * @return 単票発行有無フラグ
     */
    public boolean getTanpyoHakkoUmuFlag() {
        return tanpyoHakkoUmuFlag;
    }

    /**
     * 単票発行有無フラグのsetメソッドです。
     * <br/>
     * <br/>True：単票発行した、False：単票発行していない
     * 
     * @param tanpyoHakkoUmuFlag 単票発行有無フラグ
     */
    public void setTanpyoHakkoUmuFlag(boolean tanpyoHakkoUmuFlag) {
        this.tanpyoHakkoUmuFlag = tanpyoHakkoUmuFlag;
    }

    /**
     * 発行処理日時のgetメソッドです。
     * 
     * @return 発行処理日時
     */
    public YMDHMS getHakkoShoriTimestamp() {
        return hakkoShoriTimestamp;
    }

    /**
     * 発行処理日時のsetメソッドです。
     * 
     * @param hakkoShoriTimestamp 発行処理日時
     */
    public void setHakkoShoriTimestamp(YMDHMS hakkoShoriTimestamp) {
        this.hakkoShoriTimestamp = hakkoShoriTimestamp;
    }

    /**
     * 新様式印書済区分コードのgetメソッドです。
     * <br/>
     * <br/>00：初期値、01：新様式印書済
     * 
     * @return 新様式印書済区分コード
     */
    public RString getShinYoshikiSumiKubunCode() {
        return shinYoshikiSumiKubunCode;
    }

    /**
     * 新様式印書済区分コードのsetメソッドです。
     * <br/>
     * <br/>00：初期値、01：新様式印書済
     * 
     * @param shinYoshikiSumiKubunCode 新様式印書済区分コード
     */
    public void setShinYoshikiSumiKubunCode(RString shinYoshikiSumiKubunCode) {
        this.shinYoshikiSumiKubunCode = shinYoshikiSumiKubunCode;
    }

    /**
     * 証様式区分コードのgetメソッドです。
     * <br/>
     * <br/>00：旧様式、01：新様式、02：新様式２
     * 
     * @return 証様式区分コード
     */
    public RString getShoYoshikiKubunCode() {
        return shoYoshikiKubunCode;
    }

    /**
     * 証様式区分コードのsetメソッドです。
     * <br/>
     * <br/>00：旧様式、01：新様式、02：新様式２
     * 
     * @param shoYoshikiKubunCode 証様式区分コード
     */
    public void setShoYoshikiKubunCode(RString shoYoshikiKubunCode) {
        this.shoYoshikiKubunCode = shoYoshikiKubunCode;
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
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7037ShoKofuKaishuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7037ShoKofuKaishuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7037ShoKofuKaishuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kofuShoShurui, other.kofuShoShurui)) {
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
    public void shallowCopy(DbT7037ShoKofuKaishuEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kofuShoShurui = entity.kofuShoShurui;
        this.rirekiNo = entity.rirekiNo;
        this.shichosonCode = entity.shichosonCode;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.kofuYMD = entity.kofuYMD;
        this.yukoKigenYMD = entity.yukoKigenYMD;
        this.kofuJiyu = entity.kofuJiyu;
        this.kofuRiyu = entity.kofuRiyu;
        this.kaishuYMD = entity.kaishuYMD;
        this.kaishuJiyu = entity.kaishuJiyu;
        this.kaishuRiyu = entity.kaishuRiyu;
        this.tanpyoHakkoUmuFlag = entity.tanpyoHakkoUmuFlag;
        this.hakkoShoriTimestamp = entity.hakkoShoriTimestamp;
        this.shinYoshikiSumiKubunCode = entity.shinYoshikiSumiKubunCode;
        this.shoYoshikiKubunCode = entity.shoYoshikiKubunCode;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kofuShoShurui, rirekiNo, shichosonCode, shikibetsuCode, kofuYMD, yukoKigenYMD, kofuJiyu, kofuRiyu, kaishuYMD, kaishuJiyu, kaishuRiyu, tanpyoHakkoUmuFlag, hakkoShoriTimestamp, shinYoshikiSumiKubunCode, shoYoshikiKubunCode, logicalDeletedFlag);
    }

// </editor-fold>
}

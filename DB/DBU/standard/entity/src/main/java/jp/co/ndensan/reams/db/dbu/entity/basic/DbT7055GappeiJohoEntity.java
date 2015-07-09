package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import java.util.Objects;

/**
 * 合併情報テーブルのエンティティクラスです。
 */
public class DbT7055GappeiJohoEntity extends DbTableEntityBase<DbT7055GappeiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7055GappeiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleDate gappeiYMD;
    @PrimaryKey
    private RString chiikiNo;
    private LasdecCode shichosonCode;
    private RString gappeiShurui;
    private DbUDD003HokenshaNo hokenshaNo;
    private FlexibleDate kyuJohoFuyoToYMD;
    private FlexibleDate kokuhorenDataFromYMD;

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
     * 合併年月日のgetメソッドです。
     * 
     * @return 合併年月日
     */
    public FlexibleDate getGappeiYMD() {
        return gappeiYMD;
    }

    /**
     * 合併年月日のsetメソッドです。
     * 
     * @param gappeiYMD 合併年月日
     */
    public void setGappeiYMD(FlexibleDate gappeiYMD) {
        this.gappeiYMD = gappeiYMD;
    }

    /**
     * 地域番号のgetメソッドです。
     * 
     * @return 地域番号
     */
    public RString getChiikiNo() {
        return chiikiNo;
    }

    /**
     * 地域番号のsetメソッドです。
     * 
     * @param chiikiNo 地域番号
     */
    public void setChiikiNo(RString chiikiNo) {
        this.chiikiNo = chiikiNo;
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
     * 合併種類のgetメソッドです。
     * <br/>
     * <br/>1:対等合併 2:吸収合併
     * 
     * @return 合併種類
     */
    public RString getGappeiShurui() {
        return gappeiShurui;
    }

    /**
     * 合併種類のsetメソッドです。
     * <br/>
     * <br/>1:対等合併 2:吸収合併
     * 
     * @param gappeiShurui 合併種類
     */
    public void setGappeiShurui(RString gappeiShurui) {
        this.gappeiShurui = gappeiShurui;
    }

    /**
     * 保険者番号のgetメソッドです。
     * 
     * @return 保険者番号
     */
    public DbUDD003HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * 保険者番号のsetメソッドです。
     * 
     * @param hokenshaNo 保険者番号
     */
    public void setHokenshaNo(DbUDD003HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * 旧市町村情報付与終了年月日のgetメソッドです。
     * <br/>
     * <br/>旧市町村情報を合併日以降、いつまで管理するかを設定
     * 
     * @return 旧市町村情報付与終了年月日
     */
    public FlexibleDate getKyuJohoFuyoToYMD() {
        return kyuJohoFuyoToYMD;
    }

    /**
     * 旧市町村情報付与終了年月日のsetメソッドです。
     * <br/>
     * <br/>旧市町村情報を合併日以降、いつまで管理するかを設定
     * 
     * @param kyuJohoFuyoToYMD 旧市町村情報付与終了年月日
     */
    public void setKyuJohoFuyoToYMD(FlexibleDate kyuJohoFuyoToYMD) {
        this.kyuJohoFuyoToYMD = kyuJohoFuyoToYMD;
    }

    /**
     * 国保連データ連携開始年月日のgetメソッドです。
     * 
     * @return 国保連データ連携開始年月日
     */
    public FlexibleDate getKokuhorenDataFromYMD() {
        return kokuhorenDataFromYMD;
    }

    /**
     * 国保連データ連携開始年月日のsetメソッドです。
     * 
     * @param kokuhorenDataFromYMD 国保連データ連携開始年月日
     */
    public void setKokuhorenDataFromYMD(FlexibleDate kokuhorenDataFromYMD) {
        this.kokuhorenDataFromYMD = kokuhorenDataFromYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7055GappeiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7055GappeiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7055GappeiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.gappeiYMD, other.gappeiYMD)) {
            return false;
        }
        if (!Objects.equals(this.chiikiNo, other.chiikiNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7055GappeiJohoEntity entity) {
        this.gappeiYMD = entity.gappeiYMD;
        this.chiikiNo = entity.chiikiNo;
        this.shichosonCode = entity.shichosonCode;
        this.gappeiShurui = entity.gappeiShurui;
        this.hokenshaNo = entity.hokenshaNo;
        this.kyuJohoFuyoToYMD = entity.kyuJohoFuyoToYMD;
        this.kokuhorenDataFromYMD = entity.kokuhorenDataFromYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(gappeiYMD, chiikiNo, shichosonCode, gappeiShurui, hokenshaNo, kyuJohoFuyoToYMD, kokuhorenDataFromYMD);
    }

// </editor-fold>
}

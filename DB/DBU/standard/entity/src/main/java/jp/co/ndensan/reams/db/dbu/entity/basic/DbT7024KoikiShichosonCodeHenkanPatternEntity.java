package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import java.util.Objects;

/**
 * 広域市町村管理コード変換パターンテーブルのエンティティクラスです。
 */
public class DbT7024KoikiShichosonCodeHenkanPatternEntity extends DbTableEntityBase<DbT7024KoikiShichosonCodeHenkanPatternEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7024KoikiShichosonCodeHenkanPattern");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString koikiShichosonNo;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private RString codeKubun;
    private RString codeHenkanTableShiyoUmu;
    private RString jidoSaibanKubun;
    private int shichosonCodeKetasu;
    private int shichosonCodeKaishiIchi;
    private int shichosonCodeShiyoKetasu;
    private RString shichosonNinshoNoUmu;
    private int koikiCodeKetasu;
    private int koikiCodeKaishiIchi;
    private int koikiCodeShiyoKetasu;
    private RString koikiNinshoNoUmu;
    private RString shichosonNoFukaKubun;

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
     * 広域内市町村番号のgetメソッドです。
     * 
     * @return 広域内市町村番号
     */
    public RString getKoikiShichosonNo() {
        return koikiShichosonNo;
    }

    /**
     * 広域内市町村番号のsetメソッドです。
     * 
     * @param koikiShichosonNo 広域内市町村番号
     */
    public void setKoikiShichosonNo(RString koikiShichosonNo) {
        this.koikiShichosonNo = koikiShichosonNo;
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
     * コード区分のgetメソッドです。
     * <br/>
     * <br/>変換対象となるコードを表す
     * 
     * @return コード区分
     */
    public RString getCodeKubun() {
        return codeKubun;
    }

    /**
     * コード区分のsetメソッドです。
     * <br/>
     * <br/>変換対象となるコードを表す
     * 
     * @param codeKubun コード区分
     */
    public void setCodeKubun(RString codeKubun) {
        this.codeKubun = codeKubun;
    }

    /**
     * コード変換テーブル使用区分のgetメソッドです。
     * 
     * @return コード変換テーブル使用区分
     */
    public RString getCodeHenkanTableShiyoUmu() {
        return codeHenkanTableShiyoUmu;
    }

    /**
     * コード変換テーブル使用区分のsetメソッドです。
     * 
     * @param codeHenkanTableShiyoUmu コード変換テーブル使用区分
     */
    public void setCodeHenkanTableShiyoUmu(RString codeHenkanTableShiyoUmu) {
        this.codeHenkanTableShiyoUmu = codeHenkanTableShiyoUmu;
    }

    /**
     * 自動採番区分のgetメソッドです。
     * 
     * @return 自動採番区分
     */
    public RString getJidoSaibanKubun() {
        return jidoSaibanKubun;
    }

    /**
     * 自動採番区分のsetメソッドです。
     * 
     * @param jidoSaibanKubun 自動採番区分
     */
    public void setJidoSaibanKubun(RString jidoSaibanKubun) {
        this.jidoSaibanKubun = jidoSaibanKubun;
    }

    /**
     * 市町村用コード桁数のgetメソッドです。
     * 
     * @return 市町村用コード桁数
     */
    public int getShichosonCodeKetasu() {
        return shichosonCodeKetasu;
    }

    /**
     * 市町村用コード桁数のsetメソッドです。
     * 
     * @param shichosonCodeKetasu 市町村用コード桁数
     */
    public void setShichosonCodeKetasu(int shichosonCodeKetasu) {
        this.shichosonCodeKetasu = shichosonCodeKetasu;
    }

    /**
     * 市町村用コード開始位置のgetメソッドです。
     * 
     * @return 市町村用コード開始位置
     */
    public int getShichosonCodeKaishiIchi() {
        return shichosonCodeKaishiIchi;
    }

    /**
     * 市町村用コード開始位置のsetメソッドです。
     * 
     * @param shichosonCodeKaishiIchi 市町村用コード開始位置
     */
    public void setShichosonCodeKaishiIchi(int shichosonCodeKaishiIchi) {
        this.shichosonCodeKaishiIchi = shichosonCodeKaishiIchi;
    }

    /**
     * 市町村用コード使用桁数のgetメソッドです。
     * 
     * @return 市町村用コード使用桁数
     */
    public int getShichosonCodeShiyoKetasu() {
        return shichosonCodeShiyoKetasu;
    }

    /**
     * 市町村用コード使用桁数のsetメソッドです。
     * 
     * @param shichosonCodeShiyoKetasu 市町村用コード使用桁数
     */
    public void setShichosonCodeShiyoKetasu(int shichosonCodeShiyoKetasu) {
        this.shichosonCodeShiyoKetasu = shichosonCodeShiyoKetasu;
    }

    /**
     * 市町村用チェックディジット有無区分のgetメソッドです。
     * 
     * @return 市町村用チェックディジット有無区分
     */
    public RString getShichosonNinshoNoUmu() {
        return shichosonNinshoNoUmu;
    }

    /**
     * 市町村用チェックディジット有無区分のsetメソッドです。
     * 
     * @param shichosonNinshoNoUmu 市町村用チェックディジット有無区分
     */
    public void setShichosonNinshoNoUmu(RString shichosonNinshoNoUmu) {
        this.shichosonNinshoNoUmu = shichosonNinshoNoUmu;
    }

    /**
     * 広域用コード桁数のgetメソッドです。
     * 
     * @return 広域用コード桁数
     */
    public int getKoikiCodeKetasu() {
        return koikiCodeKetasu;
    }

    /**
     * 広域用コード桁数のsetメソッドです。
     * 
     * @param koikiCodeKetasu 広域用コード桁数
     */
    public void setKoikiCodeKetasu(int koikiCodeKetasu) {
        this.koikiCodeKetasu = koikiCodeKetasu;
    }

    /**
     * 広域用コード開始位置のgetメソッドです。
     * 
     * @return 広域用コード開始位置
     */
    public int getKoikiCodeKaishiIchi() {
        return koikiCodeKaishiIchi;
    }

    /**
     * 広域用コード開始位置のsetメソッドです。
     * 
     * @param koikiCodeKaishiIchi 広域用コード開始位置
     */
    public void setKoikiCodeKaishiIchi(int koikiCodeKaishiIchi) {
        this.koikiCodeKaishiIchi = koikiCodeKaishiIchi;
    }

    /**
     * 広域用コード使用桁数のgetメソッドです。
     * 
     * @return 広域用コード使用桁数
     */
    public int getKoikiCodeShiyoKetasu() {
        return koikiCodeShiyoKetasu;
    }

    /**
     * 広域用コード使用桁数のsetメソッドです。
     * 
     * @param koikiCodeShiyoKetasu 広域用コード使用桁数
     */
    public void setKoikiCodeShiyoKetasu(int koikiCodeShiyoKetasu) {
        this.koikiCodeShiyoKetasu = koikiCodeShiyoKetasu;
    }

    /**
     * 広域用チェックディジット有無区分のgetメソッドです。
     * 
     * @return 広域用チェックディジット有無区分
     */
    public RString getKoikiNinshoNoUmu() {
        return koikiNinshoNoUmu;
    }

    /**
     * 広域用チェックディジット有無区分のsetメソッドです。
     * 
     * @param koikiNinshoNoUmu 広域用チェックディジット有無区分
     */
    public void setKoikiNinshoNoUmu(RString koikiNinshoNoUmu) {
        this.koikiNinshoNoUmu = koikiNinshoNoUmu;
    }

    /**
     * 広域内市町村番号付加区分のgetメソッドです。
     * 
     * @return 広域内市町村番号付加区分
     */
    public RString getShichosonNoFukaKubun() {
        return shichosonNoFukaKubun;
    }

    /**
     * 広域内市町村番号付加区分のsetメソッドです。
     * 
     * @param shichosonNoFukaKubun 広域内市町村番号付加区分
     */
    public void setShichosonNoFukaKubun(RString shichosonNoFukaKubun) {
        this.shichosonNoFukaKubun = shichosonNoFukaKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7024KoikiShichosonCodeHenkanPatternEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7024KoikiShichosonCodeHenkanPatternEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7024KoikiShichosonCodeHenkanPatternEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.koikiShichosonNo, other.koikiShichosonNo)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.codeKubun, other.codeKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7024KoikiShichosonCodeHenkanPatternEntity entity) {
        this.koikiShichosonNo = entity.koikiShichosonNo;
        this.shichosonCode = entity.shichosonCode;
        this.codeKubun = entity.codeKubun;
        this.codeHenkanTableShiyoUmu = entity.codeHenkanTableShiyoUmu;
        this.jidoSaibanKubun = entity.jidoSaibanKubun;
        this.shichosonCodeKetasu = entity.shichosonCodeKetasu;
        this.shichosonCodeKaishiIchi = entity.shichosonCodeKaishiIchi;
        this.shichosonCodeShiyoKetasu = entity.shichosonCodeShiyoKetasu;
        this.shichosonNinshoNoUmu = entity.shichosonNinshoNoUmu;
        this.koikiCodeKetasu = entity.koikiCodeKetasu;
        this.koikiCodeKaishiIchi = entity.koikiCodeKaishiIchi;
        this.koikiCodeShiyoKetasu = entity.koikiCodeShiyoKetasu;
        this.koikiNinshoNoUmu = entity.koikiNinshoNoUmu;
        this.shichosonNoFukaKubun = entity.shichosonNoFukaKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(koikiShichosonNo, shichosonCode, codeKubun, codeHenkanTableShiyoUmu, jidoSaibanKubun, shichosonCodeKetasu, shichosonCodeKaishiIchi, shichosonCodeShiyoKetasu, shichosonNinshoNoUmu, koikiCodeKetasu, koikiCodeKaishiIchi, koikiCodeShiyoKetasu, koikiNinshoNoUmu, shichosonNoFukaKubun);
    }

// </editor-fold>
}

package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosainCode;

/**
 * 調査員情報テーブルのエンティティクラスです。
 */
public class DbT5913ChosainJohoEntity extends DbTableEntityBase<DbT5913ChosainJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5913ChosainJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private ChosaItakusakiCode ninteichosaItakusakiCode;
    @PrimaryKey
    private ChosainCode ninteiChosainNo;
    private RString chosainShimei;
    private RString chosainKanaShimei;
    private RString seibetsu;
    private RString chosainShikaku;
    private RString chikuCode;
    private int chosaKanoNinzuPerMonth;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private TelNo faxNo;
    private boolean jokyoFlag;

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
     * 認定調査委託先コードのgetメソッドです。
     *
     * @return 認定調査委託先コード
     */
    public ChosaItakusakiCode getNinteichosaItakusakiCode() {
        return ninteichosaItakusakiCode;
    }

    /**
     * 認定調査委託先コードのsetメソッドです。
     *
     * @param ninteichosaItakusakiCode 認定調査委託先コード
     */
    public void setNinteichosaItakusakiCode(ChosaItakusakiCode ninteichosaItakusakiCode) {
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
    }

    /**
     * 認定調査員コードのgetメソッドです。
     *
     * @return 認定調査員コード
     */
    public ChosainCode getNinteiChosainNo() {
        return ninteiChosainNo;
    }

    /**
     * 認定調査員コードのsetメソッドです。
     *
     * @param ninteiChosainNo 認定調査員コード
     */
    public void setNinteiChosainNo(ChosainCode ninteiChosainNo) {
        this.ninteiChosainNo = ninteiChosainNo;
    }

    /**
     * 調査員氏名のgetメソッドです。
     *
     * @return 調査員氏名
     */
    public RString getChosainShimei() {
        return chosainShimei;
    }

    /**
     * 調査員氏名のsetメソッドです。
     *
     * @param chosainShimei 調査員氏名
     */
    public void setChosainShimei(RString chosainShimei) {
        this.chosainShimei = chosainShimei;
    }

    /**
     * 調査員氏名カナのgetメソッドです。
     *
     * @return 調査員氏名カナ
     */
    public RString getChosainKanaShimei() {
        return chosainKanaShimei;
    }

    /**
     * 調査員氏名カナのsetメソッドです。
     *
     * @param chosainKanaShimei 調査員氏名カナ
     */
    public void setChosainKanaShimei(RString chosainKanaShimei) {
        this.chosainKanaShimei = chosainKanaShimei;
    }

    /**
     * 性別のgetメソッドです。
     *
     * @return 性別
     */
    public RString getSeibetsu() {
        return seibetsu;
    }

    /**
     * 性別のsetメソッドです。
     *
     * @param seibetsu 性別
     */
    public void setSeibetsu(RString seibetsu) {
        this.seibetsu = seibetsu;
    }

    /**
     * 調査員資格のgetメソッドです。
     *
     * @return 調査員資格
     */
    public RString getChosainShikaku() {
        return chosainShikaku;
    }

    /**
     * 調査員資格のsetメソッドです。
     *
     * @param chosainShikaku 調査員資格
     */
    public void setChosainShikaku(RString chosainShikaku) {
        this.chosainShikaku = chosainShikaku;
    }

    /**
     * 地区コードのgetメソッドです。
     *
     * @return 地区コード
     */
    public RString getChikuCode() {
        return chikuCode;
    }

    /**
     * 地区コードのsetメソッドです。
     *
     * @param chikuCode 地区コード
     */
    public void setChikuCode(RString chikuCode) {
        this.chikuCode = chikuCode;
    }

    /**
     * 調査可能人数／月のgetメソッドです。
     *
     * @return 調査可能人数／月
     */
    public int getChosaKanoNinzuPerMonth() {
        return chosaKanoNinzuPerMonth;
    }

    /**
     * 調査可能人数／月のsetメソッドです。
     *
     * @param chosaKanoNinzuPerMonth 調査可能人数／月
     */
    public void setChosaKanoNinzuPerMonth(int chosaKanoNinzuPerMonth) {
        this.chosaKanoNinzuPerMonth = chosaKanoNinzuPerMonth;
    }

    /**
     * 郵便番号のgetメソッドです。
     *
     * @return 郵便番号
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     *
     * @param yubinNo 郵便番号
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * 住所のgetメソッドです。
     *
     * @return 住所
     */
    public AtenaJusho getJusho() {
        return jusho;
    }

    /**
     * 住所のsetメソッドです。
     *
     * @param jusho 住所
     */
    public void setJusho(AtenaJusho jusho) {
        this.jusho = jusho;
    }

    /**
     * 電話番号のgetメソッドです。
     *
     * @return 電話番号
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * 電話番号のsetメソッドです。
     *
     * @param telNo 電話番号
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * FAX番号のgetメソッドです。
     *
     * @return FAX番号
     */
    public TelNo getFaxNo() {
        return faxNo;
    }

    /**
     * FAX番号のsetメソッドです。
     *
     * @param faxNo FAX番号
     */
    public void setFaxNo(TelNo faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * 状況フラグのgetメソッドです。
     *
     * @return 状況フラグ
     */
    public boolean getJokyoFlag() {
        return jokyoFlag;
    }

    /**
     * 状況フラグのsetメソッドです。
     *
     * @param jokyoFlag 状況フラグ
     */
    public void setJokyoFlag(boolean jokyoFlag) {
        this.jokyoFlag = jokyoFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5913ChosainJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT5913ChosainJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5913ChosainJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.ninteichosaItakusakiCode, other.ninteichosaItakusakiCode)) {
            return false;
        }
        if (!Objects.equals(this.ninteiChosainNo, other.ninteiChosainNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5913ChosainJohoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.ninteichosaItakusakiCode = entity.ninteichosaItakusakiCode;
        this.ninteiChosainNo = entity.ninteiChosainNo;
        this.chosainShimei = entity.chosainShimei;
        this.chosainKanaShimei = entity.chosainKanaShimei;
        this.seibetsu = entity.seibetsu;
        this.chosainShikaku = entity.chosainShikaku;
        this.chikuCode = entity.chikuCode;
        this.chosaKanoNinzuPerMonth = entity.chosaKanoNinzuPerMonth;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
        this.jokyoFlag = entity.jokyoFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, ninteichosaItakusakiCode, ninteiChosainNo, chosainShimei, chosainKanaShimei, seibetsu, chosainShikaku, chikuCode, chosaKanoNinzuPerMonth, yubinNo, jusho, telNo, faxNo, jokyoFlag);
    }

// </editor-fold>
}

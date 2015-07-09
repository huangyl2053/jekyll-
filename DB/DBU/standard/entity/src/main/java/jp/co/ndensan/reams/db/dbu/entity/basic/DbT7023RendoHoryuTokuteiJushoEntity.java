package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import java.util.Objects;

/**
 * 連動保留特定住所マスタテーブルのエンティティクラスです。
 */
public class DbT7023RendoHoryuTokuteiJushoEntity extends DbTableEntityBase<DbT7023RendoHoryuTokuteiJushoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7023RendoHoryuTokuteiJusho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString kanriNo;
    @PrimaryKey
    private LasdecCode shichosonCode;
    private ChoikiCode jushoCode;
    private AtenaJusho jusho;
    private BanchiCode banchiCode1;
    private BanchiCode banchiCode2;
    private BanchiCode banchiCode3;
    private AtenaBanchi banchi;
    private RString shisetsuShurui;
    private RString shisetsuCode;

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
     * 管理番号のgetメソッドです。
     * <br/>
     * <br/>連番
     * 
     * @return 管理番号
     */
    public RString getKanriNo() {
        return kanriNo;
    }

    /**
     * 管理番号のsetメソッドです。
     * <br/>
     * <br/>連番
     * 
     * @param kanriNo 管理番号
     */
    public void setKanriNo(RString kanriNo) {
        this.kanriNo = kanriNo;
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
     * 住所コードのgetメソッドです。
     * 
     * @return 住所コード
     */
    public ChoikiCode getJushoCode() {
        return jushoCode;
    }

    /**
     * 住所コードのsetメソッドです。
     * 
     * @param jushoCode 住所コード
     */
    public void setJushoCode(ChoikiCode jushoCode) {
        this.jushoCode = jushoCode;
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
     * 番地コード１のgetメソッドです。
     * 
     * @return 番地コード１
     */
    public BanchiCode getBanchiCode1() {
        return banchiCode1;
    }

    /**
     * 番地コード１のsetメソッドです。
     * 
     * @param banchiCode1 番地コード１
     */
    public void setBanchiCode1(BanchiCode banchiCode1) {
        this.banchiCode1 = banchiCode1;
    }

    /**
     * 番地コード２のgetメソッドです。
     * 
     * @return 番地コード２
     */
    public BanchiCode getBanchiCode2() {
        return banchiCode2;
    }

    /**
     * 番地コード２のsetメソッドです。
     * 
     * @param banchiCode2 番地コード２
     */
    public void setBanchiCode2(BanchiCode banchiCode2) {
        this.banchiCode2 = banchiCode2;
    }

    /**
     * 番地コード３のgetメソッドです。
     * 
     * @return 番地コード３
     */
    public BanchiCode getBanchiCode3() {
        return banchiCode3;
    }

    /**
     * 番地コード３のsetメソッドです。
     * 
     * @param banchiCode3 番地コード３
     */
    public void setBanchiCode3(BanchiCode banchiCode3) {
        this.banchiCode3 = banchiCode3;
    }

    /**
     * 番地のgetメソッドです。
     * 
     * @return 番地
     */
    public AtenaBanchi getBanchi() {
        return banchi;
    }

    /**
     * 番地のsetメソッドです。
     * 
     * @param banchi 番地
     */
    public void setBanchi(AtenaBanchi banchi) {
        this.banchi = banchi;
    }

    /**
     * 施設種類のgetメソッドです。
     * 
     * @return 施設種類
     */
    public RString getShisetsuShurui() {
        return shisetsuShurui;
    }

    /**
     * 施設種類のsetメソッドです。
     * 
     * @param shisetsuShurui 施設種類
     */
    public void setShisetsuShurui(RString shisetsuShurui) {
        this.shisetsuShurui = shisetsuShurui;
    }

    /**
     * 施設コードのgetメソッドです。
     * 
     * @return 施設コード
     */
    public RString getShisetsuCode() {
        return shisetsuCode;
    }

    /**
     * 施設コードのsetメソッドです。
     * 
     * @param shisetsuCode 施設コード
     */
    public void setShisetsuCode(RString shisetsuCode) {
        this.shisetsuCode = shisetsuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7023RendoHoryuTokuteiJushoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7023RendoHoryuTokuteiJushoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7023RendoHoryuTokuteiJushoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kanriNo, other.kanriNo)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7023RendoHoryuTokuteiJushoEntity entity) {
        this.kanriNo = entity.kanriNo;
        this.shichosonCode = entity.shichosonCode;
        this.jushoCode = entity.jushoCode;
        this.jusho = entity.jusho;
        this.banchiCode1 = entity.banchiCode1;
        this.banchiCode2 = entity.banchiCode2;
        this.banchiCode3 = entity.banchiCode3;
        this.banchi = entity.banchi;
        this.shisetsuShurui = entity.shisetsuShurui;
        this.shisetsuCode = entity.shisetsuCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kanriNo, shichosonCode, jushoCode, jusho, banchiCode1, banchiCode2, banchiCode3, banchi, shisetsuShurui, shisetsuCode);
    }

// </editor-fold>
}

package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;

/**
 * 調査員情報　継承テーブルのエンティティクラスです。
 */
public class DbT7013ChosainJohoEntity extends DbTableEntityBase<DbT7013ChosainJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7013ChosainJoho");

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
    private RString kaigoJigyoshaNo;
    @PrimaryKey
    private RString kaigoChosainNo;
    private RString jigyoshaNo;
    private RString kaigoChosainJokyo;
    private AtenaMeisho chosainShimei;
    private AtenaKanaMeisho chosainKanaShimei;
    private RString seibetsu;
    private Code chosainShikakuCode;
    private ChikuCode chikuCode;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;

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
     * 介護事業者番号のgetメソッドです。
     * 
     * @return 介護事業者番号
     */
    public RString getKaigoJigyoshaNo() {
        return kaigoJigyoshaNo;
    }

    /**
     * 介護事業者番号のsetメソッドです。
     * 
     * @param kaigoJigyoshaNo 介護事業者番号
     */
    public void setKaigoJigyoshaNo(RString kaigoJigyoshaNo) {
        this.kaigoJigyoshaNo = kaigoJigyoshaNo;
    }

    /**
     * 介護調査員番号のgetメソッドです。
     * 
     * @return 介護調査員番号
     */
    public RString getKaigoChosainNo() {
        return kaigoChosainNo;
    }

    /**
     * 介護調査員番号のsetメソッドです。
     * 
     * @param kaigoChosainNo 介護調査員番号
     */
    public void setKaigoChosainNo(RString kaigoChosainNo) {
        this.kaigoChosainNo = kaigoChosainNo;
    }

    /**
     * 事業者番号のgetメソッドです。
     * 
     * @return 事業者番号
     */
    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     * 
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(RString jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 介護調査員状況のgetメソッドです。
     * 
     * @return 介護調査員状況
     */
    public RString getKaigoChosainJokyo() {
        return kaigoChosainJokyo;
    }

    /**
     * 介護調査員状況のsetメソッドです。
     * 
     * @param kaigoChosainJokyo 介護調査員状況
     */
    public void setKaigoChosainJokyo(RString kaigoChosainJokyo) {
        this.kaigoChosainJokyo = kaigoChosainJokyo;
    }

    /**
     * 調査員氏名のgetメソッドです。
     * 
     * @return 調査員氏名
     */
    public AtenaMeisho getChosainShimei() {
        return chosainShimei;
    }

    /**
     * 調査員氏名のsetメソッドです。
     * 
     * @param chosainShimei 調査員氏名
     */
    public void setChosainShimei(AtenaMeisho chosainShimei) {
        this.chosainShimei = chosainShimei;
    }

    /**
     * 調査員氏名カナのgetメソッドです。
     * 
     * @return 調査員氏名カナ
     */
    public AtenaKanaMeisho getChosainKanaShimei() {
        return chosainKanaShimei;
    }

    /**
     * 調査員氏名カナのsetメソッドです。
     * 
     * @param chosainKanaShimei 調査員氏名カナ
     */
    public void setChosainKanaShimei(AtenaKanaMeisho chosainKanaShimei) {
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
     * 調査員資格コードのgetメソッドです。
     * 
     * @return 調査員資格コード
     */
    public Code getChosainShikakuCode() {
        return chosainShikakuCode;
    }

    /**
     * 調査員資格コードのsetメソッドです。
     * 
     * @param chosainShikakuCode 調査員資格コード
     */
    public void setChosainShikakuCode(Code chosainShikakuCode) {
        this.chosainShikakuCode = chosainShikakuCode;
    }

    /**
     * 地区コードのgetメソッドです。
     * 
     * @return 地区コード
     */
    public ChikuCode getChikuCode() {
        return chikuCode;
    }

    /**
     * 地区コードのsetメソッドです。
     * 
     * @param chikuCode 地区コード
     */
    public void setChikuCode(ChikuCode chikuCode) {
        this.chikuCode = chikuCode;
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
     * このエンティティの主キーが他の{@literal DbT7013ChosainJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7013ChosainJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7013ChosainJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.kaigoJigyoshaNo, other.kaigoJigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kaigoChosainNo, other.kaigoChosainNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7013ChosainJohoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.kaigoJigyoshaNo = entity.kaigoJigyoshaNo;
        this.kaigoChosainNo = entity.kaigoChosainNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.kaigoChosainJokyo = entity.kaigoChosainJokyo;
        this.chosainShimei = entity.chosainShimei;
        this.chosainKanaShimei = entity.chosainKanaShimei;
        this.seibetsu = entity.seibetsu;
        this.chosainShikakuCode = entity.chosainShikakuCode;
        this.chikuCode = entity.chikuCode;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.telNo = entity.telNo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, kaigoJigyoshaNo, kaigoChosainNo, jigyoshaNo, kaigoChosainJokyo, chosainShimei, chosainKanaShimei, seibetsu, chosainShikakuCode, chikuCode, yubinNo, jusho, telNo);
    }

// </editor-fold>
}

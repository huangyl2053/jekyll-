package jp.co.ndensan.reams.db.dbe.entity.basic;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;

/**
 * DbT7013ChosainJohoの項目定義クラスです
 *
 */
public class DbT7013ChosainJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

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
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private RString kaigoJigyoshaNo;
    @PrimaryKey
    private RString kaigoChosainNo;
    private RString jigyoshaNo;
    private boolean kaigoChosainJokyo;
    private AtenaMeisho chosainShimei;
    private AtenaKanaMeisho chosainKanaShimei;
    private RString seibetsu;
    private Code chosainShikakuCode;
    private ChikuCode chikuCode;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getKaigoJigyoshaNo
     *
     * @return kaigoJigyoshaNo
     */
    public RString getKaigoJigyoshaNo() {
        return kaigoJigyoshaNo;
    }

    /**
     * setKaigoJigyoshaNo
     *
     * @param kaigoJigyoshaNo kaigoJigyoshaNo
     */
    public void setKaigoJigyoshaNo(RString kaigoJigyoshaNo) {
        this.kaigoJigyoshaNo = kaigoJigyoshaNo;
    }

    /**
     * getKaigoChosainNo
     *
     * @return kaigoChosainNo
     */
    public RString getKaigoChosainNo() {
        return kaigoChosainNo;
    }

    /**
     * setKaigoChosainNo
     *
     * @param kaigoChosainNo kaigoChosainNo
     */
    public void setKaigoChosainNo(RString kaigoChosainNo) {
        this.kaigoChosainNo = kaigoChosainNo;
    }

    /**
     * getJigyoshaNo
     *
     * @return jigyoshaNo
     */
    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     *
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(RString jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getKaigoChosainJokyo
     *
     * @return kaigoChosainJokyo
     */
    public boolean getKaigoChosainJokyo() {
        return kaigoChosainJokyo;
    }

    /**
     * setKaigoChosainJokyo
     *
     * @param kaigoChosainJokyo kaigoChosainJokyo
     */
    public void setKaigoChosainJokyo(boolean kaigoChosainJokyo) {
        this.kaigoChosainJokyo = kaigoChosainJokyo;
    }

    /**
     * getChosainShimei
     *
     * @return chosainShimei
     */
    public AtenaMeisho getChosainShimei() {
        return chosainShimei;
    }

    /**
     * setChosainShimei
     *
     * @param chosainShimei chosainShimei
     */
    public void setChosainShimei(AtenaMeisho chosainShimei) {
        this.chosainShimei = chosainShimei;
    }

    /**
     * getChosainKanaShimei
     *
     * @return chosainKanaShimei
     */
    public AtenaKanaMeisho getChosainKanaShimei() {
        return chosainKanaShimei;
    }

    /**
     * setChosainKanaShimei
     *
     * @param chosainKanaShimei chosainKanaShimei
     */
    public void setChosainKanaShimei(AtenaKanaMeisho chosainKanaShimei) {
        this.chosainKanaShimei = chosainKanaShimei;
    }

    /**
     * getSeibetsu
     *
     * @return seibetsu
     */
    public RString getSeibetsu() {
        return seibetsu;
    }

    /**
     * setSeibetsu
     *
     * @param seibetsu seibetsu
     */
    public void setSeibetsu(RString seibetsu) {
        this.seibetsu = seibetsu;
    }

    /**
     * getChosainShikakuCode
     *
     * @return chosainShikakuCode
     */
    public Code getChosainShikakuCode() {
        return chosainShikakuCode;
    }

    /**
     * setChosainShikakuCode
     *
     * @param chosainShikakuCode chosainShikakuCode
     */
    public void setChosainShikakuCode(Code chosainShikakuCode) {
        this.chosainShikakuCode = chosainShikakuCode;
    }

    /**
     * getChikuCode
     *
     * @return chikuCode
     */
    public ChikuCode getChikuCode() {
        return chikuCode;
    }

    /**
     * setChikuCode
     *
     * @param chikuCode chikuCode
     */
    public void setChikuCode(ChikuCode chikuCode) {
        this.chikuCode = chikuCode;
    }

    /**
     * getYubinNo
     *
     * @return yubinNo
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * setYubinNo
     *
     * @param yubinNo yubinNo
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * getJusho
     *
     * @return jusho
     */
    public AtenaJusho getJusho() {
        return jusho;
    }

    /**
     * setJusho
     *
     * @param jusho jusho
     */
    public void setJusho(AtenaJusho jusho) {
        this.jusho = jusho;
    }

    /**
     * getTelNo
     *
     * @return telNo
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * setTelNo
     *
     * @param telNo telNo
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
    public boolean equalsPrimaryKeys(DbT7013ChosainJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
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
// </editor-fold>
}

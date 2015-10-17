package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * DbT7011ShujiiIryoKikanJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT7011ShujiiIryoKikanJohoEntity implements IDbAccessable {

    /**
     * TableName
     */
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7011ShujiiIryoKikanJoho");
    private RString insertDantaiCd = RString.EMPTY;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId = RString.EMPTY;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId = RString.EMPTY;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private KaigoIryoKikanCode kaigoIryokikanCode;
    private RString iryokikanCode;
    private boolean iryokikanJokyo;
    private RString kikanKubunCode;

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
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getKaigoIryokikanCode
     *
     * @return kaigoIryokikanCode
     */
    public KaigoIryoKikanCode getKaigoIryokikanCode() {
        return kaigoIryokikanCode;
    }

    /**
     * setKaigoIryokikanCode
     *
     * @param kaigoIryokikanCode kaigoIryokikanCode
     */
    public void setKaigoIryokikanCode(KaigoIryoKikanCode kaigoIryokikanCode) {
        this.kaigoIryokikanCode = kaigoIryokikanCode;
    }

    /**
     * getIryokikanCode
     *
     * @return iryokikanCode
     */
    public RString getIryokikanCode() {
        return iryokikanCode;
    }

    /**
     * setIryokikanCode
     *
     * @param iryokikanCode iryokikanCode
     */
    public void setIryokikanCode(RString iryokikanCode) {
        this.iryokikanCode = iryokikanCode;
    }

    /**
     * getIryokikanJokyo
     *
     * @return iryokikanJokyo
     */
    public boolean getIryokikanJokyo() {
        return iryokikanJokyo;
    }

    /**
     * setIryokikanJokyo
     *
     * @param iryokikanJokyo iryokikanJokyo
     */
    public void setIryokikanJokyo(boolean iryokikanJokyo) {
        this.iryokikanJokyo = iryokikanJokyo;
    }

    /**
     * getKikanKubunCode
     *
     * @return kikanKubunCode
     */
    public RString getKikanKubunCode() {
        return kikanKubunCode;
    }

    /**
     * setKikanKubunCode
     *
     * @param kikanKubunCode kikanKubunCode
     */
    public void setKikanKubunCode(RString kikanKubunCode) {
        this.kikanKubunCode = kikanKubunCode;
    }

    //TODO n1013 コードマスタの利用方法が明確になってから再テスト　2014/03/31
    /**
     * コードマスタから機関区分コードに対応した名称を取得します。
     *
     * @return 名称
     */
    public RString getKikanKubunCodeMeisho() {
//        return CodeMaster.getCodeMeisho(new RString("DBE"), new RString("35"), kikanKubunCode);
        return new RString("機関名称");
    }

    /**
     * コードマスタから機関区分コードに対応した略称を取得します。
     *
     * @return 略称
     */
    public RString getKikanKubunCodeRyakusho() {
//        return CodeMaster.getCodeRyakusho(new RString("DBE"), new RString("35"), kikanKubunCode);
        return new RString("機関略称");
    }
}

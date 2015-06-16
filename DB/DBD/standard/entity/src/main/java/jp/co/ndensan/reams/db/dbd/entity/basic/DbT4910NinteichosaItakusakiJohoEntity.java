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
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;

/**
 * 認定調査委託先情報（子）テーブルのエンティティクラスです。
 */
public class DbT4910NinteichosaItakusakiJohoEntity extends DbTableEntityBase<DbT4910NinteichosaItakusakiJohoEntity> implements IDbAccessable, INinteichosaItakusakiJohoEntity {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4910NinteichosaItakusakiJoho");

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
    private JigyoshaNo jigyoshaNo;
    private RString jigyoshaMeisho;
    private RString jigyoshaMeishoKana;
    private YubinNo yubinNo;
    private RString jusho;
    private TelNo telNo;
    private TelNo faxNo;
    private AtenaMeisho daihyoshaName;
    private RString chosaItakuKubun;
    private int waritsukeTeiin;
    private ChikuCode waritsukeChiku;
    private boolean autoWaritsukeFlag;
    private RString kikanKubun;
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
     * 事業者番号のgetメソッドです。
     * <br/>
     * <br/>URを参照する場合のみ設定
     *
     * @return 事業者番号
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     * <br/>
     * <br/>URを参照する場合のみ設定
     *
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 事業者名称のgetメソッドです。
     *
     * @return 事業者名称
     */
    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /**
     * 事業者名称のsetメソッドです。
     *
     * @param jigyoshaMeisho 事業者名称
     */
    public void setJigyoshaMeisho(RString jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    /**
     * 事業者名称カナのgetメソッドです。
     *
     * @return 事業者名称カナ
     */
    public RString getJigyoshaMeishoKana() {
        return jigyoshaMeishoKana;
    }

    /**
     * 事業者名称カナのsetメソッドです。
     *
     * @param jigyoshaMeishoKana 事業者名称カナ
     */
    public void setJigyoshaMeishoKana(RString jigyoshaMeishoKana) {
        this.jigyoshaMeishoKana = jigyoshaMeishoKana;
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
    public RString getJusho() {
        return jusho;
    }

    /**
     * 住所のsetメソッドです。
     *
     * @param jusho 住所
     */
    public void setJusho(RString jusho) {
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
     * 代表者名のgetメソッドです。
     *
     * @return 代表者名
     */
    public AtenaMeisho getDaihyoshaName() {
        return daihyoshaName;
    }

    /**
     * 代表者名のsetメソッドです。
     *
     * @param daihyoshaName 代表者名
     */
    public void setDaihyoshaName(AtenaMeisho daihyoshaName) {
        this.daihyoshaName = daihyoshaName;
    }

    /**
     * 調査委託区分のgetメソッドです。
     *
     * @return 調査委託区分
     */
    public RString getChosaItakuKubun() {
        return chosaItakuKubun;
    }

    /**
     * 調査委託区分のsetメソッドです。
     *
     * @param chosaItakuKubun 調査委託区分
     */
    public void setChosaItakuKubun(RString chosaItakuKubun) {
        this.chosaItakuKubun = chosaItakuKubun;
    }

    /**
     * 割付定員のgetメソッドです。
     *
     * @return 割付定員
     */
    public int getWaritsukeTeiin() {
        return waritsukeTeiin;
    }

    /**
     * 割付定員のsetメソッドです。
     *
     * @param waritsukeTeiin 割付定員
     */
    public void setWaritsukeTeiin(int waritsukeTeiin) {
        this.waritsukeTeiin = waritsukeTeiin;
    }

    /**
     * 割付地区のgetメソッドです。
     *
     * @return 割付地区
     */
    public ChikuCode getWaritsukeChiku() {
        return waritsukeChiku;
    }

    /**
     * 割付地区のsetメソッドです。
     *
     * @param waritsukeChiku 割付地区
     */
    public void setWaritsukeChiku(ChikuCode waritsukeChiku) {
        this.waritsukeChiku = waritsukeChiku;
    }

    /**
     * 自動割付フラグのgetメソッドです。
     *
     * @return 自動割付フラグ
     */
    public boolean getAutoWaritsukeFlag() {
        return autoWaritsukeFlag;
    }

    /**
     * 自動割付フラグのsetメソッドです。
     *
     * @param autoWaritsukeFlag 自動割付フラグ
     */
    public void setAutoWaritsukeFlag(boolean autoWaritsukeFlag) {
        this.autoWaritsukeFlag = autoWaritsukeFlag;
    }

    /**
     * 機関の区分のgetメソッドです。
     *
     * @return 機関の区分
     */
    public RString getKikanKubun() {
        return kikanKubun;
    }

    /**
     * 機関の区分のsetメソッドです。
     *
     * @param kikanKubun 機関の区分
     */
    public void setKikanKubun(RString kikanKubun) {
        this.kikanKubun = kikanKubun;
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
     * このエンティティの主キーが他の{@literal DbT4910NinteichosaItakusakiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4910NinteichosaItakusakiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4910NinteichosaItakusakiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.ninteichosaItakusakiCode, other.ninteichosaItakusakiCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4910NinteichosaItakusakiJohoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.ninteichosaItakusakiCode = entity.ninteichosaItakusakiCode;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.jigyoshaMeisho = entity.jigyoshaMeisho;
        this.jigyoshaMeishoKana = entity.jigyoshaMeishoKana;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
        this.daihyoshaName = entity.daihyoshaName;
        this.chosaItakuKubun = entity.chosaItakuKubun;
        this.waritsukeTeiin = entity.waritsukeTeiin;
        this.waritsukeChiku = entity.waritsukeChiku;
        this.autoWaritsukeFlag = entity.autoWaritsukeFlag;
        this.kikanKubun = entity.kikanKubun;
        this.jokyoFlag = entity.jokyoFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, ninteichosaItakusakiCode, jigyoshaNo, jigyoshaMeisho, jigyoshaMeishoKana, yubinNo, jusho, telNo, faxNo, daihyoshaName, chosaItakuKubun, waritsukeTeiin, waritsukeChiku, autoWaritsukeFlag, kikanKubun, jokyoFlag);
    }

// </editor-fold>
}

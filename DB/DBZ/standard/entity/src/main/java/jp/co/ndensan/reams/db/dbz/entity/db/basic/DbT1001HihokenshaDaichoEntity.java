package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 被保険者台帳管理テーブルのエンティティクラスです。
 * <br/> 介護保険被保険者の資格を管理する
 */
public class DbT1001HihokenshaDaichoEntity extends DbTableEntityBase<DbT1001HihokenshaDaichoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1001HihokenshaDaicho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate idoYMD;
    @PrimaryKey
    private RString edaNo;
    private RString idoJiyuCode;
    private LasdecCode shichosonCode;
    private ShikibetsuCode shikibetsuCode;
    private RString shikakuShutokuJiyuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuShutokuTodokedeYMD;
    private FlexibleDate ichigoShikakuShutokuYMD;
    private RString hihokennshaKubunCode;
    private RString shikakuSoshitsuJiyuCode;
    private FlexibleDate shikakuSoshitsuYMD;
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    private RString shikakuHenkoJiyuCode;
    private FlexibleDate shikakuHenkoYMD;
    private FlexibleDate shikakuHenkoTodokedeYMD;
    private RString jushochitokureiTekiyoJiyuCode;
    private FlexibleDate jushochitokureiTekiyoYMD;
    private FlexibleDate jushochitokureiTekiyoTodokedeYMD;
    private RString jushochitokureiKaijoJiyuCode;
    private FlexibleDate jushochitokureiKaijoYMD;
    private FlexibleDate jushochitokureiKaijoTodokedeYMD;
    private RString jushochiTokureiFlag;
    private RString koikinaiJushochiTokureiFlag;
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    private LasdecCode kyuShichosonCode;
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
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 異動日のgetメソッドです。
     *
     * @return 異動日
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 異動日のsetメソッドです。
     *
     * @param idoYMD 異動日
     */
    public void setIdoYMD(@Nonnull FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * 枝番のgetメソッドです。
     *
     * @return 枝番
     */
    public RString getEdaNo() {
        return edaNo;
    }

    /**
     * 枝番のsetメソッドです。
     *
     * @param edaNo 枝番
     */
    public void setEdaNo(@Nonnull RString edaNo) {
        this.edaNo = edaNo;
    }

    /**
     * 異動事由コードのgetメソッドです。
     *
     * @return 異動事由コード
     */
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * 異動事由コードのsetメソッドです。
     *
     * @param idoJiyuCode 異動事由コード
     */
    public void setIdoJiyuCode(@Nonnull RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
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
    public void setShichosonCode(@Nonnull LasdecCode shichosonCode) {
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
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 資格取得事由コードのgetメソッドです。
     *
     * @return 資格取得事由コード
     */
    @CheckForNull
    public RString getShikakuShutokuJiyuCode() {
        return shikakuShutokuJiyuCode;
    }

    /**
     * 資格取得事由コードのsetメソッドです。
     *
     * @param shikakuShutokuJiyuCode 資格取得事由コード
     */
    public void setShikakuShutokuJiyuCode(RString shikakuShutokuJiyuCode) {
        this.shikakuShutokuJiyuCode = shikakuShutokuJiyuCode;
    }

    /**
     * 資格取得年月日のgetメソッドです。
     *
     * @return 資格取得年月日
     */
    @CheckForNull
    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    /**
     * 資格取得年月日のsetメソッドです。
     *
     * @param shikakuShutokuYMD 資格取得年月日
     */
    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * 資格取得届出年月日のgetメソッドです。
     *
     * @return 資格取得届出年月日
     */
    @CheckForNull
    public FlexibleDate getShikakuShutokuTodokedeYMD() {
        return shikakuShutokuTodokedeYMD;
    }

    /**
     * 資格取得届出年月日のsetメソッドです。
     *
     * @param shikakuShutokuTodokedeYMD 資格取得届出年月日
     */
    public void setShikakuShutokuTodokedeYMD(FlexibleDate shikakuShutokuTodokedeYMD) {
        this.shikakuShutokuTodokedeYMD = shikakuShutokuTodokedeYMD;
    }

    /**
     * 第1号資格取得年月日のgetメソッドです。
     *
     * @return 第1号資格取得年月日
     */
    @CheckForNull
    public FlexibleDate getIchigoShikakuShutokuYMD() {
        return ichigoShikakuShutokuYMD;
    }

    /**
     * 第1号資格取得年月日のsetメソッドです。
     *
     * @param ichigoShikakuShutokuYMD 第1号資格取得年月日
     */
    public void setIchigoShikakuShutokuYMD(FlexibleDate ichigoShikakuShutokuYMD) {
        this.ichigoShikakuShutokuYMD = ichigoShikakuShutokuYMD;
    }

    /**
     * 被保険者区分コードのgetメソッドです。
     * <br/>
     * <br/>１号・２号
     *
     * @return 被保険者区分コード
     */
    public RString getHihokennshaKubunCode() {
        return hihokennshaKubunCode;
    }

    /**
     * 被保険者区分コードのsetメソッドです。
     * <br/>
     * <br/>１号・２号
     *
     * @param hihokennshaKubunCode 被保険者区分コード
     */
    public void setHihokennshaKubunCode(@Nonnull RString hihokennshaKubunCode) {
        this.hihokennshaKubunCode = hihokennshaKubunCode;
    }

    /**
     * 資格喪失事由コードのgetメソッドです。
     *
     * @return 資格喪失事由コード
     */
    @CheckForNull
    public RString getShikakuSoshitsuJiyuCode() {
        return shikakuSoshitsuJiyuCode;
    }

    /**
     * 資格喪失事由コードのsetメソッドです。
     *
     * @param shikakuSoshitsuJiyuCode 資格喪失事由コード
     */
    public void setShikakuSoshitsuJiyuCode(RString shikakuSoshitsuJiyuCode) {
        this.shikakuSoshitsuJiyuCode = shikakuSoshitsuJiyuCode;
    }

    /**
     * 資格喪失年月日のgetメソッドです。
     *
     * @return 資格喪失年月日
     */
    @CheckForNull
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失年月日のsetメソッドです。
     *
     * @param shikakuSoshitsuYMD 資格喪失年月日
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失届出年月日のgetメソッドです。
     *
     * @return 資格喪失届出年月日
     */
    @CheckForNull
    public FlexibleDate getShikakuSoshitsuTodokedeYMD() {
        return shikakuSoshitsuTodokedeYMD;
    }

    /**
     * 資格喪失届出年月日のsetメソッドです。
     *
     * @param shikakuSoshitsuTodokedeYMD 資格喪失届出年月日
     */
    public void setShikakuSoshitsuTodokedeYMD(FlexibleDate shikakuSoshitsuTodokedeYMD) {
        this.shikakuSoshitsuTodokedeYMD = shikakuSoshitsuTodokedeYMD;
    }

    /**
     * 資格変更事由コードのgetメソッドです。
     *
     * @return 資格変更事由コード
     */
    @CheckForNull
    public RString getShikakuHenkoJiyuCode() {
        return shikakuHenkoJiyuCode;
    }

    /**
     * 資格変更事由コードのsetメソッドです。
     *
     * @param shikakuHenkoJiyuCode 資格変更事由コード
     */
    public void setShikakuHenkoJiyuCode(RString shikakuHenkoJiyuCode) {
        this.shikakuHenkoJiyuCode = shikakuHenkoJiyuCode;
    }

    /**
     * 資格変更年月日のgetメソッドです。
     *
     * @return 資格変更年月日
     */
    @CheckForNull
    public FlexibleDate getShikakuHenkoYMD() {
        return shikakuHenkoYMD;
    }

    /**
     * 資格変更年月日のsetメソッドです。
     *
     * @param shikakuHenkoYMD 資格変更年月日
     */
    public void setShikakuHenkoYMD(FlexibleDate shikakuHenkoYMD) {
        this.shikakuHenkoYMD = shikakuHenkoYMD;
    }

    /**
     * 資格変更届出年月日のgetメソッドです。
     *
     * @return 資格変更届出年月日
     */
    @CheckForNull
    public FlexibleDate getShikakuHenkoTodokedeYMD() {
        return shikakuHenkoTodokedeYMD;
    }

    /**
     * 資格変更届出年月日のsetメソッドです。
     *
     * @param shikakuHenkoTodokedeYMD 資格変更届出年月日
     */
    public void setShikakuHenkoTodokedeYMD(FlexibleDate shikakuHenkoTodokedeYMD) {
        this.shikakuHenkoTodokedeYMD = shikakuHenkoTodokedeYMD;
    }

    /**
     * 住所地特例適用事由コードのgetメソッドです。
     *
     * @return 住所地特例適用事由コード
     */
    @CheckForNull
    public RString getJushochitokureiTekiyoJiyuCode() {
        return jushochitokureiTekiyoJiyuCode;
    }

    /**
     * 住所地特例適用事由コードのsetメソッドです。
     *
     * @param jushochitokureiTekiyoJiyuCode 住所地特例適用事由コード
     */
    public void setJushochitokureiTekiyoJiyuCode(RString jushochitokureiTekiyoJiyuCode) {
        this.jushochitokureiTekiyoJiyuCode = jushochitokureiTekiyoJiyuCode;
    }

    /**
     * 適用年月日のgetメソッドです。
     *
     * @return 適用年月日
     */
    @CheckForNull
    public FlexibleDate getJushochitokureiTekiyoYMD() {
        return jushochitokureiTekiyoYMD;
    }

    /**
     * 適用年月日のsetメソッドです。
     *
     * @param jushochitokureiTekiyoYMD 適用年月日
     */
    public void setJushochitokureiTekiyoYMD(FlexibleDate jushochitokureiTekiyoYMD) {
        this.jushochitokureiTekiyoYMD = jushochitokureiTekiyoYMD;
    }

    /**
     * 適用届出年月日のgetメソッドです。
     *
     * @return 適用届出年月日
     */
    @CheckForNull
    public FlexibleDate getJushochitokureiTekiyoTodokedeYMD() {
        return jushochitokureiTekiyoTodokedeYMD;
    }

    /**
     * 適用届出年月日のsetメソッドです。
     *
     * @param jushochitokureiTekiyoTodokedeYMD 適用届出年月日
     */
    public void setJushochitokureiTekiyoTodokedeYMD(FlexibleDate jushochitokureiTekiyoTodokedeYMD) {
        this.jushochitokureiTekiyoTodokedeYMD = jushochitokureiTekiyoTodokedeYMD;
    }

    /**
     * 住所地特例解除事由コードのgetメソッドです。
     *
     * @return 住所地特例解除事由コード
     */
    @CheckForNull
    public RString getJushochitokureiKaijoJiyuCode() {
        return jushochitokureiKaijoJiyuCode;
    }

    /**
     * 住所地特例解除事由コードのsetメソッドです。
     *
     * @param jushochitokureiKaijoJiyuCode 住所地特例解除事由コード
     */
    public void setJushochitokureiKaijoJiyuCode(RString jushochitokureiKaijoJiyuCode) {
        this.jushochitokureiKaijoJiyuCode = jushochitokureiKaijoJiyuCode;
    }

    /**
     * 解除年月日のgetメソッドです。
     *
     * @return 解除年月日
     */
    @CheckForNull
    public FlexibleDate getJushochitokureiKaijoYMD() {
        return jushochitokureiKaijoYMD;
    }

    /**
     * 解除年月日のsetメソッドです。
     *
     * @param jushochitokureiKaijoYMD 解除年月日
     */
    public void setJushochitokureiKaijoYMD(FlexibleDate jushochitokureiKaijoYMD) {
        this.jushochitokureiKaijoYMD = jushochitokureiKaijoYMD;
    }

    /**
     * 解除届出年月日のgetメソッドです。
     *
     * @return 解除届出年月日
     */
    @CheckForNull
    public FlexibleDate getJushochitokureiKaijoTodokedeYMD() {
        return jushochitokureiKaijoTodokedeYMD;
    }

    /**
     * 解除届出年月日のsetメソッドです。
     *
     * @param jushochitokureiKaijoTodokedeYMD 解除届出年月日
     */
    public void setJushochitokureiKaijoTodokedeYMD(FlexibleDate jushochitokureiKaijoTodokedeYMD) {
        this.jushochitokureiKaijoTodokedeYMD = jushochitokureiKaijoTodokedeYMD;
    }

    /**
     * 住所地特例フラグのgetメソッドです。
     *
     * @return 住所地特例フラグ
     */
    @CheckForNull
    public RString getJushochiTokureiFlag() {
        return jushochiTokureiFlag;
    }

    /**
     * 住所地特例フラグのsetメソッドです。
     *
     * @param jushochiTokureiFlag 住所地特例フラグ
     */
    public void setJushochiTokureiFlag(RString jushochiTokureiFlag) {
        this.jushochiTokureiFlag = jushochiTokureiFlag;
    }

    /**
     * 広域内住所地特例フラグのgetメソッドです。
     *
     * @return 広域内住所地特例フラグ
     */
    @CheckForNull
    public RString getKoikinaiJushochiTokureiFlag() {
        return koikinaiJushochiTokureiFlag;
    }

    /**
     * 広域内住所地特例フラグのsetメソッドです。
     *
     * @param koikinaiJushochiTokureiFlag 広域内住所地特例フラグ
     */
    public void setKoikinaiJushochiTokureiFlag(RString koikinaiJushochiTokureiFlag) {
        this.koikinaiJushochiTokureiFlag = koikinaiJushochiTokureiFlag;
    }

    /**
     * 広住特措置元市町村コードのgetメソッドです。
     *
     * @return 広住特措置元市町村コード
     */
    @CheckForNull
    public LasdecCode getKoikinaiTokureiSochimotoShichosonCode() {
        return koikinaiTokureiSochimotoShichosonCode;
    }

    /**
     * 広住特措置元市町村コードのsetメソッドです。
     *
     * @param koikinaiTokureiSochimotoShichosonCode 広住特措置元市町村コード
     */
    public void setKoikinaiTokureiSochimotoShichosonCode(LasdecCode koikinaiTokureiSochimotoShichosonCode) {
        this.koikinaiTokureiSochimotoShichosonCode = koikinaiTokureiSochimotoShichosonCode;
    }

    /**
     * 旧市町村コードのgetメソッドです。
     * <br/>
     * <br/>合併市町村の時は、旧市町村コードを設定
     *
     * @return 旧市町村コード
     */
    @CheckForNull
    public LasdecCode getKyuShichosonCode() {
        return kyuShichosonCode;
    }

    /**
     * 旧市町村コードのsetメソッドです。
     * <br/>
     * <br/>合併市町村の時は、旧市町村コードを設定
     *
     * @param kyuShichosonCode 旧市町村コード
     */
    public void setKyuShichosonCode(LasdecCode kyuShichosonCode) {
        this.kyuShichosonCode = kyuShichosonCode;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     *
     * @return 論理削除フラグ
     */
    @CheckForNull
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
     * このエンティティの主キーが他の{@literal DbT1001HihokenshaDaichoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1001HihokenshaDaichoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1001HihokenshaDaichoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.idoYMD, other.idoYMD)) {
            return false;
        }
        if (!Objects.equals(this.edaNo, other.edaNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1001HihokenshaDaichoEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.idoYMD = entity.idoYMD;
        this.edaNo = entity.edaNo;
        this.idoJiyuCode = entity.idoJiyuCode;
        this.shichosonCode = entity.shichosonCode;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shikakuShutokuJiyuCode = entity.shikakuShutokuJiyuCode;
        this.shikakuShutokuYMD = entity.shikakuShutokuYMD;
        this.shikakuShutokuTodokedeYMD = entity.shikakuShutokuTodokedeYMD;
        this.ichigoShikakuShutokuYMD = entity.ichigoShikakuShutokuYMD;
        this.hihokennshaKubunCode = entity.hihokennshaKubunCode;
        this.shikakuSoshitsuJiyuCode = entity.shikakuSoshitsuJiyuCode;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.shikakuSoshitsuTodokedeYMD = entity.shikakuSoshitsuTodokedeYMD;
        this.shikakuHenkoJiyuCode = entity.shikakuHenkoJiyuCode;
        this.shikakuHenkoYMD = entity.shikakuHenkoYMD;
        this.shikakuHenkoTodokedeYMD = entity.shikakuHenkoTodokedeYMD;
        this.jushochitokureiTekiyoJiyuCode = entity.jushochitokureiTekiyoJiyuCode;
        this.jushochitokureiTekiyoYMD = entity.jushochitokureiTekiyoYMD;
        this.jushochitokureiTekiyoTodokedeYMD = entity.jushochitokureiTekiyoTodokedeYMD;
        this.jushochitokureiKaijoJiyuCode = entity.jushochitokureiKaijoJiyuCode;
        this.jushochitokureiKaijoYMD = entity.jushochitokureiKaijoYMD;
        this.jushochitokureiKaijoTodokedeYMD = entity.jushochitokureiKaijoTodokedeYMD;
        this.jushochiTokureiFlag = entity.jushochiTokureiFlag;
        this.koikinaiJushochiTokureiFlag = entity.koikinaiJushochiTokureiFlag;
        this.koikinaiTokureiSochimotoShichosonCode = entity.koikinaiTokureiSochimotoShichosonCode;
        this.kyuShichosonCode = entity.kyuShichosonCode;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, idoYMD, edaNo, idoJiyuCode, shichosonCode, shikibetsuCode, shikakuShutokuJiyuCode, shikakuShutokuYMD, shikakuShutokuTodokedeYMD, ichigoShikakuShutokuYMD, hihokennshaKubunCode, shikakuSoshitsuJiyuCode, shikakuSoshitsuYMD, shikakuSoshitsuTodokedeYMD, shikakuHenkoJiyuCode, shikakuHenkoYMD, shikakuHenkoTodokedeYMD, jushochitokureiTekiyoJiyuCode, jushochitokureiTekiyoYMD, jushochitokureiTekiyoTodokedeYMD, jushochitokureiKaijoJiyuCode, jushochitokureiKaijoYMD, jushochitokureiKaijoTodokedeYMD, jushochiTokureiFlag, koikinaiJushochiTokureiFlag, koikinaiTokureiSochimotoShichosonCode, kyuShichosonCode, logicalDeletedFlag);
    }

// </editor-fold>
    /**
     * @return the lastUpdateTimestamp
     */
    public RDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    /**
     * @param lastUpdateTimestamp the lastUpdateTimestamp to set
     */
    public void setLastUpdateTimestamp(RDateTime lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    /**
     * @return the insertTimestamp
     */
    public RDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    /**
     * @param insertTimestamp the insertTimestamp to set
     */
    public void setInsertTimestamp(RDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }
}

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
 * 整合性チェック情報テーブルのエンティティクラスです。
 * <br/> 整合性チェックで不整合となった住登内情報と介護資格情報を管理する。
 */
public class DbT1014SeigoseiCheckEntity extends DbTableEntityBase<DbT1014SeigoseiCheckEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT1014SeigoseiCheck");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    private boolean taishogaiFlag;
    private RString fuseigoRiyuCode;
    private RDateTime torokuTimestamp;
    private int rierkiNo;
    private FlexibleDate idoYMD;
    private FlexibleDate todokedeYMD;
    private RString idoJiyuCode;
    private RString shoriJiyuCode;
    private FlexibleDate shoriYMD;
    private RString juminShubetsuCode;
    private RString juminJotaiCode;
    private FlexibleDate seinengappiYMD;
    private RString torokuJiyuCode;
    private FlexibleDate torokuIdoYMD;
    private FlexibleDate torokuTodokedeYMD;
    private RString shojoJiyuCode;
    private FlexibleDate shojoIdoYMD;
    private FlexibleDate shojoTodokedeYMD;
    private boolean shojoTsuchiFlag;
    private FlexibleDate tenshutsuYoteiIdoYMD;
    private FlexibleDate tenshutsuKakuteiIdoYMD;
    private FlexibleDate tenshutsuKakuteiTsuchiYMD;
    private RString daichoShubetsu;
    private FlexibleDate shikakuIdoYMD;
    private RString shikakuIdoEdaNo;
    private RString shikakuIdoJiyuCode;
    private HihokenshaNo hihokenshaNo;
    private LasdecCode shichosonCode;
    private RString shutokuTekiyoJiyuCode;
    private FlexibleDate shutokuTekiyoYMD;
    private FlexibleDate shutokuTekiyoTodokedeYMD;
    private RString soshitsuKaijoJiyuCode;
    private FlexibleDate soshitsuKaijoYMD;
    private FlexibleDate soshitsuKaijoTodokedeYMD;
    private FlexibleDate ichigoShutokuYMD;
    private RString hihokenshaKubunCode;
    private RString shikakuHenkoJiyuCode;
    private FlexibleDate shikakuHenkoYMD;
    private FlexibleDate shikakuHenkoTodokedeYMD;
    private RString jutokuTekiyoJiyuCode;
    private FlexibleDate jutokuTekiyoYMD;
    private FlexibleDate jutokuTekiyoTodokedeYMD;
    private RString jutokuKaijoJiyuCode;
    private FlexibleDate jutokuKaijoYMD;
    private FlexibleDate jutokuKaijoTodokedeYMD;

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
     * 対象外フラグのgetメソッドです。
     * <br/>
     * <br/>True：対象外である
     * 
     * @return 対象外フラグ
     */
    public boolean getTaishogaiFlag() {
        return taishogaiFlag;
    }

    /**
     * 対象外フラグのsetメソッドです。
     * <br/>
     * <br/>True：対象外である
     * 
     * @param taishogaiFlag 対象外フラグ
     */
    public void setTaishogaiFlag(@Nonnull boolean taishogaiFlag) {
        this.taishogaiFlag = taishogaiFlag;
    }

    /**
     * 不整合理由コードのgetメソッドです。
     * <br/>
     * <br/>DBZ.Enum不整合理由
     * 
     * @return 不整合理由コード
     */
    @CheckForNull
    public RString getFuseigoRiyuCode() {
        return fuseigoRiyuCode;
    }

    /**
     * 不整合理由コードのsetメソッドです。
     * <br/>
     * <br/>DBZ.Enum不整合理由
     * 
     * @param fuseigoRiyuCode 不整合理由コード
     */
    public void setFuseigoRiyuCode(RString fuseigoRiyuCode) {
        this.fuseigoRiyuCode = fuseigoRiyuCode;
    }

    /**
     * 登録日時のgetメソッドです。
     * 
     * @return 登録日時
     */
    @CheckForNull
    public RDateTime getTorokuTimestamp() {
        return torokuTimestamp;
    }

    /**
     * 登録日時のsetメソッドです。
     * 
     * @param torokuTimestamp 登録日時
     */
    public void setTorokuTimestamp(RDateTime torokuTimestamp) {
        this.torokuTimestamp = torokuTimestamp;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    @CheckForNull
    public int getRierkiNo() {
        return rierkiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rierkiNo 履歴番号
     */
    public void setRierkiNo(int rierkiNo) {
        this.rierkiNo = rierkiNo;
    }

    /**
     * 異動年月日のgetメソッドです。
     * 
     * @return 異動年月日
     */
    @CheckForNull
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 異動年月日のsetメソッドです。
     * 
     * @param idoYMD 異動年月日
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * 届出年月日のgetメソッドです。
     * 
     * @return 届出年月日
     */
    @CheckForNull
    public FlexibleDate getTodokedeYMD() {
        return todokedeYMD;
    }

    /**
     * 届出年月日のsetメソッドです。
     * 
     * @param todokedeYMD 届出年月日
     */
    public void setTodokedeYMD(FlexibleDate todokedeYMD) {
        this.todokedeYMD = todokedeYMD;
    }

    /**
     * 異動事由コードのgetメソッドです。
     * 
     * @return 異動事由コード
     */
    @CheckForNull
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * 異動事由コードのsetメソッドです。
     * 
     * @param idoJiyuCode 異動事由コード
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * 処理事由コードのgetメソッドです。
     * 
     * @return 処理事由コード
     */
    @CheckForNull
    public RString getShoriJiyuCode() {
        return shoriJiyuCode;
    }

    /**
     * 処理事由コードのsetメソッドです。
     * 
     * @param shoriJiyuCode 処理事由コード
     */
    public void setShoriJiyuCode(RString shoriJiyuCode) {
        this.shoriJiyuCode = shoriJiyuCode;
    }

    /**
     * 処理年月日のgetメソッドです。
     * 
     * @return 処理年月日
     */
    @CheckForNull
    public FlexibleDate getShoriYMD() {
        return shoriYMD;
    }

    /**
     * 処理年月日のsetメソッドです。
     * 
     * @param shoriYMD 処理年月日
     */
    public void setShoriYMD(FlexibleDate shoriYMD) {
        this.shoriYMD = shoriYMD;
    }

    /**
     * 住民種別コードのgetメソッドです。
     * 
     * @return 住民種別コード
     */
    @CheckForNull
    public RString getJuminShubetsuCode() {
        return juminShubetsuCode;
    }

    /**
     * 住民種別コードのsetメソッドです。
     * 
     * @param juminShubetsuCode 住民種別コード
     */
    public void setJuminShubetsuCode(RString juminShubetsuCode) {
        this.juminShubetsuCode = juminShubetsuCode;
    }

    /**
     * 住民状態コードのgetメソッドです。
     * 
     * @return 住民状態コード
     */
    @CheckForNull
    public RString getJuminJotaiCode() {
        return juminJotaiCode;
    }

    /**
     * 住民状態コードのsetメソッドです。
     * 
     * @param juminJotaiCode 住民状態コード
     */
    public void setJuminJotaiCode(RString juminJotaiCode) {
        this.juminJotaiCode = juminJotaiCode;
    }

    /**
     * 生年月日のgetメソッドです。
     * 
     * @return 生年月日
     */
    @CheckForNull
    public FlexibleDate getSeinengappiYMD() {
        return seinengappiYMD;
    }

    /**
     * 生年月日のsetメソッドです。
     * 
     * @param seinengappiYMD 生年月日
     */
    public void setSeinengappiYMD(FlexibleDate seinengappiYMD) {
        this.seinengappiYMD = seinengappiYMD;
    }

    /**
     * 登録事由コードのgetメソッドです。
     * 
     * @return 登録事由コード
     */
    @CheckForNull
    public RString getTorokuJiyuCode() {
        return torokuJiyuCode;
    }

    /**
     * 登録事由コードのsetメソッドです。
     * 
     * @param torokuJiyuCode 登録事由コード
     */
    public void setTorokuJiyuCode(RString torokuJiyuCode) {
        this.torokuJiyuCode = torokuJiyuCode;
    }

    /**
     * 登録異動年月日のgetメソッドです。
     * 
     * @return 登録異動年月日
     */
    @CheckForNull
    public FlexibleDate getTorokuIdoYMD() {
        return torokuIdoYMD;
    }

    /**
     * 登録異動年月日のsetメソッドです。
     * 
     * @param torokuIdoYMD 登録異動年月日
     */
    public void setTorokuIdoYMD(FlexibleDate torokuIdoYMD) {
        this.torokuIdoYMD = torokuIdoYMD;
    }

    /**
     * 登録届出年月日のgetメソッドです。
     * 
     * @return 登録届出年月日
     */
    @CheckForNull
    public FlexibleDate getTorokuTodokedeYMD() {
        return torokuTodokedeYMD;
    }

    /**
     * 登録届出年月日のsetメソッドです。
     * 
     * @param torokuTodokedeYMD 登録届出年月日
     */
    public void setTorokuTodokedeYMD(FlexibleDate torokuTodokedeYMD) {
        this.torokuTodokedeYMD = torokuTodokedeYMD;
    }

    /**
     * 消除事由コードのgetメソッドです。
     * 
     * @return 消除事由コード
     */
    @CheckForNull
    public RString getShojoJiyuCode() {
        return shojoJiyuCode;
    }

    /**
     * 消除事由コードのsetメソッドです。
     * 
     * @param shojoJiyuCode 消除事由コード
     */
    public void setShojoJiyuCode(RString shojoJiyuCode) {
        this.shojoJiyuCode = shojoJiyuCode;
    }

    /**
     * 消除異動年月日のgetメソッドです。
     * 
     * @return 消除異動年月日
     */
    @CheckForNull
    public FlexibleDate getShojoIdoYMD() {
        return shojoIdoYMD;
    }

    /**
     * 消除異動年月日のsetメソッドです。
     * 
     * @param shojoIdoYMD 消除異動年月日
     */
    public void setShojoIdoYMD(FlexibleDate shojoIdoYMD) {
        this.shojoIdoYMD = shojoIdoYMD;
    }

    /**
     * 消除届出年月日のgetメソッドです。
     * 
     * @return 消除届出年月日
     */
    @CheckForNull
    public FlexibleDate getShojoTodokedeYMD() {
        return shojoTodokedeYMD;
    }

    /**
     * 消除届出年月日のsetメソッドです。
     * 
     * @param shojoTodokedeYMD 消除届出年月日
     */
    public void setShojoTodokedeYMD(FlexibleDate shojoTodokedeYMD) {
        this.shojoTodokedeYMD = shojoTodokedeYMD;
    }

    /**
     * 消除通知フラグのgetメソッドです。
     * 
     * @return 消除通知フラグ
     */
    @CheckForNull
    public boolean getShojoTsuchiFlag() {
        return shojoTsuchiFlag;
    }

    /**
     * 消除通知フラグのsetメソッドです。
     * 
     * @param shojoTsuchiFlag 消除通知フラグ
     */
    public void setShojoTsuchiFlag(boolean shojoTsuchiFlag) {
        this.shojoTsuchiFlag = shojoTsuchiFlag;
    }

    /**
     * 転出予定異動年月日のgetメソッドです。
     * 
     * @return 転出予定異動年月日
     */
    @CheckForNull
    public FlexibleDate getTenshutsuYoteiIdoYMD() {
        return tenshutsuYoteiIdoYMD;
    }

    /**
     * 転出予定異動年月日のsetメソッドです。
     * 
     * @param tenshutsuYoteiIdoYMD 転出予定異動年月日
     */
    public void setTenshutsuYoteiIdoYMD(FlexibleDate tenshutsuYoteiIdoYMD) {
        this.tenshutsuYoteiIdoYMD = tenshutsuYoteiIdoYMD;
    }

    /**
     * 転出確定異動年月日のgetメソッドです。
     * 
     * @return 転出確定異動年月日
     */
    @CheckForNull
    public FlexibleDate getTenshutsuKakuteiIdoYMD() {
        return tenshutsuKakuteiIdoYMD;
    }

    /**
     * 転出確定異動年月日のsetメソッドです。
     * 
     * @param tenshutsuKakuteiIdoYMD 転出確定異動年月日
     */
    public void setTenshutsuKakuteiIdoYMD(FlexibleDate tenshutsuKakuteiIdoYMD) {
        this.tenshutsuKakuteiIdoYMD = tenshutsuKakuteiIdoYMD;
    }

    /**
     * 転出確定通知年月日のgetメソッドです。
     * 
     * @return 転出確定通知年月日
     */
    @CheckForNull
    public FlexibleDate getTenshutsuKakuteiTsuchiYMD() {
        return tenshutsuKakuteiTsuchiYMD;
    }

    /**
     * 転出確定通知年月日のsetメソッドです。
     * 
     * @param tenshutsuKakuteiTsuchiYMD 転出確定通知年月日
     */
    public void setTenshutsuKakuteiTsuchiYMD(FlexibleDate tenshutsuKakuteiTsuchiYMD) {
        this.tenshutsuKakuteiTsuchiYMD = tenshutsuKakuteiTsuchiYMD;
    }

    /**
     * 台帳種別のgetメソッドです。
     * 
     * @return 台帳種別
     */
    @CheckForNull
    public RString getDaichoShubetsu() {
        return daichoShubetsu;
    }

    /**
     * 台帳種別のsetメソッドです。
     * 
     * @param daichoShubetsu 台帳種別
     */
    public void setDaichoShubetsu(RString daichoShubetsu) {
        this.daichoShubetsu = daichoShubetsu;
    }

    /**
     * 資格異動日のgetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @return 資格異動日
     */
    @CheckForNull
    public FlexibleDate getShikakuIdoYMD() {
        return shikakuIdoYMD;
    }

    /**
     * 資格異動日のsetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @param shikakuIdoYMD 資格異動日
     */
    public void setShikakuIdoYMD(FlexibleDate shikakuIdoYMD) {
        this.shikakuIdoYMD = shikakuIdoYMD;
    }

    /**
     * 資格異動枝番のgetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @return 資格異動枝番
     */
    @CheckForNull
    public RString getShikakuIdoEdaNo() {
        return shikakuIdoEdaNo;
    }

    /**
     * 資格異動枝番のsetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @param shikakuIdoEdaNo 資格異動枝番
     */
    public void setShikakuIdoEdaNo(RString shikakuIdoEdaNo) {
        this.shikakuIdoEdaNo = shikakuIdoEdaNo;
    }

    /**
     * 資格異動事由コードのgetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @return 資格異動事由コード
     */
    @CheckForNull
    public RString getShikakuIdoJiyuCode() {
        return shikakuIdoJiyuCode;
    }

    /**
     * 資格異動事由コードのsetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @param shikakuIdoJiyuCode 資格異動事由コード
     */
    public void setShikakuIdoJiyuCode(RString shikakuIdoJiyuCode) {
        this.shikakuIdoJiyuCode = shikakuIdoJiyuCode;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * 
     * @return 被保険者番号
     */
    @CheckForNull
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 市町村コードのgetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @return 市町村コード
     */
    @CheckForNull
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 取得適用事由コードのgetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @return 取得適用事由コード
     */
    @CheckForNull
    public RString getShutokuTekiyoJiyuCode() {
        return shutokuTekiyoJiyuCode;
    }

    /**
     * 取得適用事由コードのsetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @param shutokuTekiyoJiyuCode 取得適用事由コード
     */
    public void setShutokuTekiyoJiyuCode(RString shutokuTekiyoJiyuCode) {
        this.shutokuTekiyoJiyuCode = shutokuTekiyoJiyuCode;
    }

    /**
     * 取得適用年月日のgetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @return 取得適用年月日
     */
    @CheckForNull
    public FlexibleDate getShutokuTekiyoYMD() {
        return shutokuTekiyoYMD;
    }

    /**
     * 取得適用年月日のsetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @param shutokuTekiyoYMD 取得適用年月日
     */
    public void setShutokuTekiyoYMD(FlexibleDate shutokuTekiyoYMD) {
        this.shutokuTekiyoYMD = shutokuTekiyoYMD;
    }

    /**
     * 取得適用届出年月日のgetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @return 取得適用届出年月日
     */
    @CheckForNull
    public FlexibleDate getShutokuTekiyoTodokedeYMD() {
        return shutokuTekiyoTodokedeYMD;
    }

    /**
     * 取得適用届出年月日のsetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @param shutokuTekiyoTodokedeYMD 取得適用届出年月日
     */
    public void setShutokuTekiyoTodokedeYMD(FlexibleDate shutokuTekiyoTodokedeYMD) {
        this.shutokuTekiyoTodokedeYMD = shutokuTekiyoTodokedeYMD;
    }

    /**
     * 喪失解除事由コードのgetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @return 喪失解除事由コード
     */
    @CheckForNull
    public RString getSoshitsuKaijoJiyuCode() {
        return soshitsuKaijoJiyuCode;
    }

    /**
     * 喪失解除事由コードのsetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @param soshitsuKaijoJiyuCode 喪失解除事由コード
     */
    public void setSoshitsuKaijoJiyuCode(RString soshitsuKaijoJiyuCode) {
        this.soshitsuKaijoJiyuCode = soshitsuKaijoJiyuCode;
    }

    /**
     * 喪失解除年月日のgetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @return 喪失解除年月日
     */
    @CheckForNull
    public FlexibleDate getSoshitsuKaijoYMD() {
        return soshitsuKaijoYMD;
    }

    /**
     * 喪失解除年月日のsetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @param soshitsuKaijoYMD 喪失解除年月日
     */
    public void setSoshitsuKaijoYMD(FlexibleDate soshitsuKaijoYMD) {
        this.soshitsuKaijoYMD = soshitsuKaijoYMD;
    }

    /**
     * 喪失解除届出年月日のgetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @return 喪失解除届出年月日
     */
    @CheckForNull
    public FlexibleDate getSoshitsuKaijoTodokedeYMD() {
        return soshitsuKaijoTodokedeYMD;
    }

    /**
     * 喪失解除届出年月日のsetメソッドです。
     * <br/>
     * <br/>被保台帳、他特例者台帳、除外者台帳　共通
     * 
     * @param soshitsuKaijoTodokedeYMD 喪失解除届出年月日
     */
    public void setSoshitsuKaijoTodokedeYMD(FlexibleDate soshitsuKaijoTodokedeYMD) {
        this.soshitsuKaijoTodokedeYMD = soshitsuKaijoTodokedeYMD;
    }

    /**
     * 第１号取得年月日のgetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @return 第１号取得年月日
     */
    @CheckForNull
    public FlexibleDate getIchigoShutokuYMD() {
        return ichigoShutokuYMD;
    }

    /**
     * 第１号取得年月日のsetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @param ichigoShutokuYMD 第１号取得年月日
     */
    public void setIchigoShutokuYMD(FlexibleDate ichigoShutokuYMD) {
        this.ichigoShutokuYMD = ichigoShutokuYMD;
    }

    /**
     * 被保険者区分コードのgetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @return 被保険者区分コード
     */
    @CheckForNull
    public RString getHihokenshaKubunCode() {
        return hihokenshaKubunCode;
    }

    /**
     * 被保険者区分コードのsetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @param hihokenshaKubunCode 被保険者区分コード
     */
    public void setHihokenshaKubunCode(RString hihokenshaKubunCode) {
        this.hihokenshaKubunCode = hihokenshaKubunCode;
    }

    /**
     * 資格変更事由コードのgetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @return 資格変更事由コード
     */
    @CheckForNull
    public RString getShikakuHenkoJiyuCode() {
        return shikakuHenkoJiyuCode;
    }

    /**
     * 資格変更事由コードのsetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @param shikakuHenkoJiyuCode 資格変更事由コード
     */
    public void setShikakuHenkoJiyuCode(RString shikakuHenkoJiyuCode) {
        this.shikakuHenkoJiyuCode = shikakuHenkoJiyuCode;
    }

    /**
     * 資格変更年月日のgetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @return 資格変更年月日
     */
    @CheckForNull
    public FlexibleDate getShikakuHenkoYMD() {
        return shikakuHenkoYMD;
    }

    /**
     * 資格変更年月日のsetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @param shikakuHenkoYMD 資格変更年月日
     */
    public void setShikakuHenkoYMD(FlexibleDate shikakuHenkoYMD) {
        this.shikakuHenkoYMD = shikakuHenkoYMD;
    }

    /**
     * 資格変更届出年月日のgetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @return 資格変更届出年月日
     */
    @CheckForNull
    public FlexibleDate getShikakuHenkoTodokedeYMD() {
        return shikakuHenkoTodokedeYMD;
    }

    /**
     * 資格変更届出年月日のsetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @param shikakuHenkoTodokedeYMD 資格変更届出年月日
     */
    public void setShikakuHenkoTodokedeYMD(FlexibleDate shikakuHenkoTodokedeYMD) {
        this.shikakuHenkoTodokedeYMD = shikakuHenkoTodokedeYMD;
    }

    /**
     * 住特適用事由コードのgetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @return 住特適用事由コード
     */
    @CheckForNull
    public RString getJutokuTekiyoJiyuCode() {
        return jutokuTekiyoJiyuCode;
    }

    /**
     * 住特適用事由コードのsetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @param jutokuTekiyoJiyuCode 住特適用事由コード
     */
    public void setJutokuTekiyoJiyuCode(RString jutokuTekiyoJiyuCode) {
        this.jutokuTekiyoJiyuCode = jutokuTekiyoJiyuCode;
    }

    /**
     * 住特適用年月日のgetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @return 住特適用年月日
     */
    @CheckForNull
    public FlexibleDate getJutokuTekiyoYMD() {
        return jutokuTekiyoYMD;
    }

    /**
     * 住特適用年月日のsetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @param jutokuTekiyoYMD 住特適用年月日
     */
    public void setJutokuTekiyoYMD(FlexibleDate jutokuTekiyoYMD) {
        this.jutokuTekiyoYMD = jutokuTekiyoYMD;
    }

    /**
     * 住特適用届出年月日のgetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @return 住特適用届出年月日
     */
    @CheckForNull
    public FlexibleDate getJutokuTekiyoTodokedeYMD() {
        return jutokuTekiyoTodokedeYMD;
    }

    /**
     * 住特適用届出年月日のsetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @param jutokuTekiyoTodokedeYMD 住特適用届出年月日
     */
    public void setJutokuTekiyoTodokedeYMD(FlexibleDate jutokuTekiyoTodokedeYMD) {
        this.jutokuTekiyoTodokedeYMD = jutokuTekiyoTodokedeYMD;
    }

    /**
     * 住特解除事由コードのgetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @return 住特解除事由コード
     */
    @CheckForNull
    public RString getJutokuKaijoJiyuCode() {
        return jutokuKaijoJiyuCode;
    }

    /**
     * 住特解除事由コードのsetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @param jutokuKaijoJiyuCode 住特解除事由コード
     */
    public void setJutokuKaijoJiyuCode(RString jutokuKaijoJiyuCode) {
        this.jutokuKaijoJiyuCode = jutokuKaijoJiyuCode;
    }

    /**
     * 住特解除年月日のgetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @return 住特解除年月日
     */
    @CheckForNull
    public FlexibleDate getJutokuKaijoYMD() {
        return jutokuKaijoYMD;
    }

    /**
     * 住特解除年月日のsetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @param jutokuKaijoYMD 住特解除年月日
     */
    public void setJutokuKaijoYMD(FlexibleDate jutokuKaijoYMD) {
        this.jutokuKaijoYMD = jutokuKaijoYMD;
    }

    /**
     * 住特解除届出年月日のgetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @return 住特解除届出年月日
     */
    @CheckForNull
    public FlexibleDate getJutokuKaijoTodokedeYMD() {
        return jutokuKaijoTodokedeYMD;
    }

    /**
     * 住特解除届出年月日のsetメソッドです。
     * <br/>
     * <br/>被保台帳のみ
     * 
     * @param jutokuKaijoTodokedeYMD 住特解除届出年月日
     */
    public void setJutokuKaijoTodokedeYMD(FlexibleDate jutokuKaijoTodokedeYMD) {
        this.jutokuKaijoTodokedeYMD = jutokuKaijoTodokedeYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1014SeigoseiCheckEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1014SeigoseiCheckEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1014SeigoseiCheckEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1014SeigoseiCheckEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.taishogaiFlag = entity.taishogaiFlag;
        this.fuseigoRiyuCode = entity.fuseigoRiyuCode;
        this.torokuTimestamp = entity.torokuTimestamp;
        this.rierkiNo = entity.rierkiNo;
        this.idoYMD = entity.idoYMD;
        this.todokedeYMD = entity.todokedeYMD;
        this.idoJiyuCode = entity.idoJiyuCode;
        this.shoriJiyuCode = entity.shoriJiyuCode;
        this.shoriYMD = entity.shoriYMD;
        this.juminShubetsuCode = entity.juminShubetsuCode;
        this.juminJotaiCode = entity.juminJotaiCode;
        this.seinengappiYMD = entity.seinengappiYMD;
        this.torokuJiyuCode = entity.torokuJiyuCode;
        this.torokuIdoYMD = entity.torokuIdoYMD;
        this.torokuTodokedeYMD = entity.torokuTodokedeYMD;
        this.shojoJiyuCode = entity.shojoJiyuCode;
        this.shojoIdoYMD = entity.shojoIdoYMD;
        this.shojoTodokedeYMD = entity.shojoTodokedeYMD;
        this.shojoTsuchiFlag = entity.shojoTsuchiFlag;
        this.tenshutsuYoteiIdoYMD = entity.tenshutsuYoteiIdoYMD;
        this.tenshutsuKakuteiIdoYMD = entity.tenshutsuKakuteiIdoYMD;
        this.tenshutsuKakuteiTsuchiYMD = entity.tenshutsuKakuteiTsuchiYMD;
        this.daichoShubetsu = entity.daichoShubetsu;
        this.shikakuIdoYMD = entity.shikakuIdoYMD;
        this.shikakuIdoEdaNo = entity.shikakuIdoEdaNo;
        this.shikakuIdoJiyuCode = entity.shikakuIdoJiyuCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shichosonCode = entity.shichosonCode;
        this.shutokuTekiyoJiyuCode = entity.shutokuTekiyoJiyuCode;
        this.shutokuTekiyoYMD = entity.shutokuTekiyoYMD;
        this.shutokuTekiyoTodokedeYMD = entity.shutokuTekiyoTodokedeYMD;
        this.soshitsuKaijoJiyuCode = entity.soshitsuKaijoJiyuCode;
        this.soshitsuKaijoYMD = entity.soshitsuKaijoYMD;
        this.soshitsuKaijoTodokedeYMD = entity.soshitsuKaijoTodokedeYMD;
        this.ichigoShutokuYMD = entity.ichigoShutokuYMD;
        this.hihokenshaKubunCode = entity.hihokenshaKubunCode;
        this.shikakuHenkoJiyuCode = entity.shikakuHenkoJiyuCode;
        this.shikakuHenkoYMD = entity.shikakuHenkoYMD;
        this.shikakuHenkoTodokedeYMD = entity.shikakuHenkoTodokedeYMD;
        this.jutokuTekiyoJiyuCode = entity.jutokuTekiyoJiyuCode;
        this.jutokuTekiyoYMD = entity.jutokuTekiyoYMD;
        this.jutokuTekiyoTodokedeYMD = entity.jutokuTekiyoTodokedeYMD;
        this.jutokuKaijoJiyuCode = entity.jutokuKaijoJiyuCode;
        this.jutokuKaijoYMD = entity.jutokuKaijoYMD;
        this.jutokuKaijoTodokedeYMD = entity.jutokuKaijoTodokedeYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, taishogaiFlag, fuseigoRiyuCode, torokuTimestamp, rierkiNo, idoYMD, todokedeYMD, idoJiyuCode, shoriJiyuCode, shoriYMD, juminShubetsuCode, juminJotaiCode, seinengappiYMD, torokuJiyuCode, torokuIdoYMD, torokuTodokedeYMD, shojoJiyuCode, shojoIdoYMD, shojoTodokedeYMD, shojoTsuchiFlag, tenshutsuYoteiIdoYMD, tenshutsuKakuteiIdoYMD, tenshutsuKakuteiTsuchiYMD, daichoShubetsu, shikakuIdoYMD, shikakuIdoEdaNo, shikakuIdoJiyuCode, hihokenshaNo, shichosonCode, shutokuTekiyoJiyuCode, shutokuTekiyoYMD, shutokuTekiyoTodokedeYMD, soshitsuKaijoJiyuCode, soshitsuKaijoYMD, soshitsuKaijoTodokedeYMD, ichigoShutokuYMD, hihokenshaKubunCode, shikakuHenkoJiyuCode, shikakuHenkoYMD, shikakuHenkoTodokedeYMD, jutokuTekiyoJiyuCode, jutokuTekiyoYMD, jutokuTekiyoTodokedeYMD, jutokuKaijoJiyuCode, jutokuKaijoYMD, jutokuKaijoTodokedeYMD);
    }

// </editor-fold>
}

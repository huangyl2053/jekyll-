package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DbT1010TennyushutsuHoryuTaishoshaの項目定義クラスです
 *
 */
public class DbT1010TennyushutsuHoryuTaishoshaEntity extends DbTableEntityBase<DbT1010TennyushutsuHoryuTaishoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1010TennyushutsuHoryuTaishosha");

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
    @PrimaryKey
    private Decimal rirekiNo;
    private LasdecCode shichosonCode;
    private RString sakuseiJiyuCode;
    private SetaiCode setaiCode;
    private RString juminShubetsuCode;
    private RString juminJotaiCode;
    private AtenaMeisho atenaShimei;
    private AtenaKanaMeisho atenaKanaShimei;
    private FlexibleDate seinengappiYMD;
    private RString seibetsuCode;
    private RString idoJiyuCode;
    private FlexibleDate torokuIdoYMD;
    private FlexibleDate torokuTodokedeYMD;
    private FlexibleDate shojoIdoYMD;
    private FlexibleDate shojoIdoTodokedeYMD;
    private FlexibleDate tenshutsuYoteiIdoYMD;
    private FlexibleDate tenshutsuKakuteiIdoYMD;
    private FlexibleDate tenshutsuKakuteiIdoTsuchiYMD;
    private RString zenkokuJushoCode;
    private AtenaJusho jusho;
    private AtenaBanchi banchi;
    private Katagaki katagaki;
    private ZenkokuJushoCode tenshutsuYoteiZenkokuJushoCode;
    private AtenaJusho tenshutsuYoteiJusho;
    private AtenaBanchi tenshutsuYoteiBanchi;
    private Katagaki tenshutsuYoteiKatagaki;
    private ZenkokuJushoCode tenshutsuKakuteiZenkokuJushoCode;
    private AtenaJusho tenshutsuKakuteiJusho;
    private AtenaBanchi tenshutsuKakuteiBanchi;
    private Katagaki tenshutsuKakuteiKatagaki;

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
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
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
     * 作成事由コードのgetメソッドです。
     *
     * @return 作成事由コード
     */
    public RString getSakuseiJiyuCode() {
        return sakuseiJiyuCode;
    }

    /**
     * 作成事由コードのsetメソッドです。
     *
     * @param sakuseiJiyuCode 作成事由コード
     */
    public void setSakuseiJiyuCode(RString sakuseiJiyuCode) {
        this.sakuseiJiyuCode = sakuseiJiyuCode;
    }

    /**
     * 世帯コードのgetメソッドです。
     *
     * @return 世帯コード
     */
    public SetaiCode getSetaiCode() {
        return setaiCode;
    }

    /**
     * 世帯コードのsetメソッドです。
     *
     * @param setaiCode 世帯コード
     */
    public void setSetaiCode(SetaiCode setaiCode) {
        this.setaiCode = setaiCode;
    }

    /**
     * 住民種別コードのgetメソッドです。
     *
     * @return 住民種別コード
     */
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
     * 宛名氏名のgetメソッドです。
     *
     * @return 宛名氏名
     */
    public AtenaMeisho getAtenaShimei() {
        return atenaShimei;
    }

    /**
     * 宛名氏名のsetメソッドです。
     *
     * @param atenaShimei 宛名氏名
     */
    public void setAtenaShimei(AtenaMeisho atenaShimei) {
        this.atenaShimei = atenaShimei;
    }

    /**
     * 宛名カナ氏名のgetメソッドです。
     *
     * @return 宛名カナ氏名
     */
    public AtenaKanaMeisho getAtenaKanaShimei() {
        return atenaKanaShimei;
    }

    /**
     * 宛名カナ氏名のsetメソッドです。
     *
     * @param atenaKanaShimei 宛名カナ氏名
     */
    public void setAtenaKanaShimei(AtenaKanaMeisho atenaKanaShimei) {
        this.atenaKanaShimei = atenaKanaShimei;
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
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
     * 性別コードのgetメソッドです。
     *
     * @return 性別コード
     */
    public RString getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * 性別コードのsetメソッドです。
     *
     * @param seibetsuCode 性別コード
     */
    public void setSeibetsuCode(RString seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
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
    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * 登録異動年月日のgetメソッドです。
     *
     * @return 登録異動年月日
     */
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
     * 消除異動年月日のgetメソッドです。
     *
     * @return 消除異動年月日
     */
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
    public FlexibleDate getShojoIdoTodokedeYMD() {
        return shojoIdoTodokedeYMD;
    }

    /**
     * 消除届出年月日のsetメソッドです。
     *
     * @param shojoIdoTodokedeYMD 消除届出年月日
     */
    public void setShojoIdoTodokedeYMD(FlexibleDate shojoIdoTodokedeYMD) {
        this.shojoIdoTodokedeYMD = shojoIdoTodokedeYMD;
    }

    /**
     * 転出予定異動年月日のgetメソッドです。
     *
     * @return 転出予定異動年月日
     */
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
     * 転出確定異動通知年月日のgetメソッドです。
     *
     * @return 転出確定異動通知年月日
     */
    public FlexibleDate getTenshutsuKakuteiIdoTsuchiYMD() {
        return tenshutsuKakuteiIdoTsuchiYMD;
    }

    /**
     * 転出確定異動通知年月日のsetメソッドです。
     *
     * @param tenshutsuKakuteiIdoTsuchiYMD 転出確定異動通知年月日
     */
    public void setTenshutsuKakuteiIdoTsuchiYMD(FlexibleDate tenshutsuKakuteiIdoTsuchiYMD) {
        this.tenshutsuKakuteiIdoTsuchiYMD = tenshutsuKakuteiIdoTsuchiYMD;
    }

    /**
     * 全国住所コードのgetメソッドです。
     *
     * @return 全国住所コード
     */
    public RString getZenkokuJushoCode() {
        return zenkokuJushoCode;
    }

    /**
     * 全国住所コードのsetメソッドです。
     *
     * @param zenkokuJushoCode 全国住所コード
     */
    public void setZenkokuJushoCode(RString zenkokuJushoCode) {
        this.zenkokuJushoCode = zenkokuJushoCode;
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
     * 方書のgetメソッドです。
     *
     * @return 方書
     */
    public Katagaki getKatagaki() {
        return katagaki;
    }

    /**
     * 方書のsetメソッドです。
     *
     * @param katagaki 方書
     */
    public void setKatagaki(Katagaki katagaki) {
        this.katagaki = katagaki;
    }

    /**
     * 転出予定全国住所コードのgetメソッドです。
     *
     * @return 転出予定全国住所コード
     */
    public ZenkokuJushoCode getTenshutsuYoteiZenkokuJushoCode() {
        return tenshutsuYoteiZenkokuJushoCode;
    }

    /**
     * 転出予定全国住所コードのsetメソッドです。
     *
     * @param tenshutsuYoteiZenkokuJushoCode 転出予定全国住所コード
     */
    public void setTenshutsuYoteiZenkokuJushoCode(ZenkokuJushoCode tenshutsuYoteiZenkokuJushoCode) {
        this.tenshutsuYoteiZenkokuJushoCode = tenshutsuYoteiZenkokuJushoCode;
    }

    /**
     * 転出予定住所のgetメソッドです。
     *
     * @return 転出予定住所
     */
    public AtenaJusho getTenshutsuYoteiJusho() {
        return tenshutsuYoteiJusho;
    }

    /**
     * 転出予定住所のsetメソッドです。
     *
     * @param tenshutsuYoteiJusho 転出予定住所
     */
    public void setTenshutsuYoteiJusho(AtenaJusho tenshutsuYoteiJusho) {
        this.tenshutsuYoteiJusho = tenshutsuYoteiJusho;
    }

    /**
     * 転出予定番地のgetメソッドです。
     *
     * @return 転出予定番地
     */
    public AtenaBanchi getTenshutsuYoteiBanchi() {
        return tenshutsuYoteiBanchi;
    }

    /**
     * 転出予定番地のsetメソッドです。
     *
     * @param tenshutsuYoteiBanchi 転出予定番地
     */
    public void setTenshutsuYoteiBanchi(AtenaBanchi tenshutsuYoteiBanchi) {
        this.tenshutsuYoteiBanchi = tenshutsuYoteiBanchi;
    }

    /**
     * 転出予定方書のgetメソッドです。
     *
     * @return 転出予定方書
     */
    public Katagaki getTenshutsuYoteiKatagaki() {
        return tenshutsuYoteiKatagaki;
    }

    /**
     * 転出予定方書のsetメソッドです。
     *
     * @param tenshutsuYoteiKatagaki 転出予定方書
     */
    public void setTenshutsuYoteiKatagaki(Katagaki tenshutsuYoteiKatagaki) {
        this.tenshutsuYoteiKatagaki = tenshutsuYoteiKatagaki;
    }

    /**
     * 転出確定全国住所コードのgetメソッドです。
     *
     * @return 転出確定全国住所コード
     */
    public ZenkokuJushoCode getTenshutsuKakuteiZenkokuJushoCode() {
        return tenshutsuKakuteiZenkokuJushoCode;
    }

    /**
     * 転出確定全国住所コードのsetメソッドです。
     *
     * @param tenshutsuKakuteiZenkokuJushoCode 転出確定全国住所コード
     */
    public void setTenshutsuKakuteiZenkokuJushoCode(ZenkokuJushoCode tenshutsuKakuteiZenkokuJushoCode) {
        this.tenshutsuKakuteiZenkokuJushoCode = tenshutsuKakuteiZenkokuJushoCode;
    }

    /**
     * 転出確定住所のgetメソッドです。
     *
     * @return 転出確定住所
     */
    public AtenaJusho getTenshutsuKakuteiJusho() {
        return tenshutsuKakuteiJusho;
    }

    /**
     * 転出確定住所のsetメソッドです。
     *
     * @param tenshutsuKakuteiJusho 転出確定住所
     */
    public void setTenshutsuKakuteiJusho(AtenaJusho tenshutsuKakuteiJusho) {
        this.tenshutsuKakuteiJusho = tenshutsuKakuteiJusho;
    }

    /**
     * 転出確定番地のgetメソッドです。
     *
     * @return 転出確定番地
     */
    public AtenaBanchi getTenshutsuKakuteiBanchi() {
        return tenshutsuKakuteiBanchi;
    }

    /**
     * 転出確定番地のsetメソッドです。
     *
     * @param tenshutsuKakuteiBanchi 転出確定番地
     */
    public void setTenshutsuKakuteiBanchi(AtenaBanchi tenshutsuKakuteiBanchi) {
        this.tenshutsuKakuteiBanchi = tenshutsuKakuteiBanchi;
    }

    /**
     * 転出確定方書のgetメソッドです。
     *
     * @return 転出確定方書
     */
    public Katagaki getTenshutsuKakuteiKatagaki() {
        return tenshutsuKakuteiKatagaki;
    }

    /**
     * 転出確定方書のsetメソッドです。
     *
     * @param tenshutsuKakuteiKatagaki 転出確定方書
     */
    public void setTenshutsuKakuteiKatagaki(Katagaki tenshutsuKakuteiKatagaki) {
        this.tenshutsuKakuteiKatagaki = tenshutsuKakuteiKatagaki;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1010TennyushutsuHoryuTaishoshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1010TennyushutsuHoryuTaishoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1010TennyushutsuHoryuTaishoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1010TennyushutsuHoryuTaishoshaEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.rirekiNo = entity.rirekiNo;
        this.shichosonCode = entity.shichosonCode;
        this.sakuseiJiyuCode = entity.sakuseiJiyuCode;
        this.setaiCode = entity.setaiCode;
        this.juminShubetsuCode = entity.juminShubetsuCode;
        this.juminJotaiCode = entity.juminJotaiCode;
        this.atenaShimei = entity.atenaShimei;
        this.atenaKanaShimei = entity.atenaKanaShimei;
        this.seinengappiYMD = entity.seinengappiYMD;
        this.seibetsuCode = entity.seibetsuCode;
        this.idoJiyuCode = entity.idoJiyuCode;
        this.torokuIdoYMD = entity.torokuIdoYMD;
        this.torokuTodokedeYMD = entity.torokuTodokedeYMD;
        this.shojoIdoYMD = entity.shojoIdoYMD;
        this.shojoIdoTodokedeYMD = entity.shojoIdoTodokedeYMD;
        this.tenshutsuYoteiIdoYMD = entity.tenshutsuYoteiIdoYMD;
        this.tenshutsuKakuteiIdoYMD = entity.tenshutsuKakuteiIdoYMD;
        this.tenshutsuKakuteiIdoTsuchiYMD = entity.tenshutsuKakuteiIdoTsuchiYMD;
        this.zenkokuJushoCode = entity.zenkokuJushoCode;
        this.jusho = entity.jusho;
        this.banchi = entity.banchi;
        this.katagaki = entity.katagaki;
        this.tenshutsuYoteiZenkokuJushoCode = entity.tenshutsuYoteiZenkokuJushoCode;
        this.tenshutsuYoteiJusho = entity.tenshutsuYoteiJusho;
        this.tenshutsuYoteiBanchi = entity.tenshutsuYoteiBanchi;
        this.tenshutsuYoteiKatagaki = entity.tenshutsuYoteiKatagaki;
        this.tenshutsuKakuteiZenkokuJushoCode = entity.tenshutsuKakuteiZenkokuJushoCode;
        this.tenshutsuKakuteiJusho = entity.tenshutsuKakuteiJusho;
        this.tenshutsuKakuteiBanchi = entity.tenshutsuKakuteiBanchi;
        this.tenshutsuKakuteiKatagaki = entity.tenshutsuKakuteiKatagaki;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, rirekiNo, shichosonCode, sakuseiJiyuCode, setaiCode, juminShubetsuCode, juminJotaiCode, atenaShimei, atenaKanaShimei, seinengappiYMD, seibetsuCode, idoJiyuCode, torokuIdoYMD, torokuTodokedeYMD, shojoIdoYMD, shojoIdoTodokedeYMD, tenshutsuYoteiIdoYMD, tenshutsuKakuteiIdoYMD, tenshutsuKakuteiIdoTsuchiYMD, zenkokuJushoCode, jusho, banchi, katagaki, tenshutsuYoteiZenkokuJushoCode, tenshutsuYoteiJusho, tenshutsuYoteiBanchi, tenshutsuYoteiKatagaki, tenshutsuKakuteiZenkokuJushoCode, tenshutsuKakuteiJusho, tenshutsuKakuteiBanchi, tenshutsuKakuteiKatagaki);
    }

// </editor-fold>
}

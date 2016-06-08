package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.NinshoshaCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7004KaigoShiharaiJohoの項目定義クラスです
 *
 */
public class DbT7004KaigoShiharaiJohoEntity extends DbTableEntityBase<DbT7004KaigoShiharaiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7004KaigoShiharaiJoho");

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
    private KamokuCode kamokuCode;
    @PrimaryKey
    private FlexibleDate ketteiYMD;
    private HihokenshaNo hihokenshaNo;
    private LasdecCode shichosonCode;
    private RString shiharaiHohoKubun;
    private Code madoguchiShiharaiBashoCode;
    private YMDHM madoguchiShiharaiKaishiYMDHM;
    private YMDHM madoguchiShiharaiShuryoYMDHM;
    private FlexibleDate furikomiYoteiYMD;
    private int shiharaiKingaku;
    private Code syubetsuCode;
    private Code yotoKubunCode;
    private FlexibleDate ninshoYMD1;
    private NinshoshaCode ninshoshaCode1;
    private FlexibleDate ninshoYMD2;
    private NinshoshaCode ninshoshaCode2;

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
     * <br/>
     * <br/>口座ＤＢ上の識別コード
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * <br/>
     * <br/>口座ＤＢ上の識別コード
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 科目コードのgetメソッドです。
     * <br/>
     * <br/>支払単位の科目：高額サ・福祉用具・住宅改修など
     *
     * @return 科目コード
     */
    public KamokuCode getKamokuCode() {
        return kamokuCode;
    }

    /**
     * 科目コードのsetメソッドです。
     * <br/>
     * <br/>支払単位の科目：高額サ・福祉用具・住宅改修など
     *
     * @param kamokuCode 科目コード
     */
    public void setKamokuCode(KamokuCode kamokuCode) {
        this.kamokuCode = kamokuCode;
    }

    /**
     * 決定年月日のgetメソッドです。
     *
     * @return 決定年月日
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * 決定年月日のsetメソッドです。
     *
     * @param ketteiYMD 決定年月日
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
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
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
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
     * 支払方法区分のgetメソッドです。
     * <br/>
     * <br/>窓口・口座
     *
     * @return 支払方法区分
     */
    public RString getShiharaiHohoKubun() {
        return shiharaiHohoKubun;
    }

    /**
     * 支払方法区分のsetメソッドです。
     * <br/>
     * <br/>窓口・口座
     *
     * @param shiharaiHohoKubun 支払方法区分
     */
    public void setShiharaiHohoKubun(RString shiharaiHohoKubun) {
        this.shiharaiHohoKubun = shiharaiHohoKubun;
    }

    /**
     * 窓口支払場所コードのgetメソッドです。
     * <br/>
     * <br/>各市町村の窓口
     *
     * @return 窓口支払場所コード
     */
    public Code getMadoguchiShiharaiBashoCode() {
        return madoguchiShiharaiBashoCode;
    }

    /**
     * 窓口支払場所コードのsetメソッドです。
     * <br/>
     * <br/>各市町村の窓口
     *
     * @param madoguchiShiharaiBashoCode 窓口支払場所コード
     */
    public void setMadoguchiShiharaiBashoCode(Code madoguchiShiharaiBashoCode) {
        this.madoguchiShiharaiBashoCode = madoguchiShiharaiBashoCode;
    }

    /**
     * 窓口支払開始年月日時分のgetメソッドです。
     *
     * @return 窓口支払開始年月日時分
     */
    public YMDHM getMadoguchiShiharaiKaishiYMDHM() {
        return madoguchiShiharaiKaishiYMDHM;
    }

    /**
     * 窓口支払開始年月日時分のsetメソッドです。
     *
     * @param madoguchiShiharaiKaishiYMDHM 窓口支払開始年月日時分
     */
    public void setMadoguchiShiharaiKaishiYMDHM(YMDHM madoguchiShiharaiKaishiYMDHM) {
        this.madoguchiShiharaiKaishiYMDHM = madoguchiShiharaiKaishiYMDHM;
    }

    /**
     * 窓口支払終了年月日時分のgetメソッドです。
     *
     * @return 窓口支払終了年月日時分
     */
    public YMDHM getMadoguchiShiharaiShuryoYMDHM() {
        return madoguchiShiharaiShuryoYMDHM;
    }

    /**
     * 窓口支払終了年月日時分のsetメソッドです。
     *
     * @param madoguchiShiharaiShuryoYMDHM 窓口支払終了年月日時分
     */
    public void setMadoguchiShiharaiShuryoYMDHM(YMDHM madoguchiShiharaiShuryoYMDHM) {
        this.madoguchiShiharaiShuryoYMDHM = madoguchiShiharaiShuryoYMDHM;
    }

    /**
     * 振込予定年月日のgetメソッドです。
     *
     * @return 振込予定年月日
     */
    public FlexibleDate getFurikomiYoteiYMD() {
        return furikomiYoteiYMD;
    }

    /**
     * 振込予定年月日のsetメソッドです。
     *
     * @param furikomiYoteiYMD 振込予定年月日
     */
    public void setFurikomiYoteiYMD(FlexibleDate furikomiYoteiYMD) {
        this.furikomiYoteiYMD = furikomiYoteiYMD;
    }

    /**
     * 支払金額のgetメソッドです。
     *
     * @return 支払金額
     */
    public int getShiharaiKingaku() {
        return shiharaiKingaku;
    }

    /**
     * 支払金額のsetメソッドです。
     *
     * @param shiharaiKingaku 支払金額
     */
    public void setShiharaiKingaku(int shiharaiKingaku) {
        this.shiharaiKingaku = shiharaiKingaku;
    }

    /**
     * 種別コードのgetメソッドです。
     *
     * @return 種別コード
     */
    public Code getSyubetsuCode() {
        return syubetsuCode;
    }

    /**
     * 種別コードのsetメソッドです。
     *
     * @param syubetsuCode 種別コード
     */
    public void setSyubetsuCode(Code syubetsuCode) {
        this.syubetsuCode = syubetsuCode;
    }

    /**
     * 用途区分コードのgetメソッドです。
     *
     * @return 用途区分コード
     */
    public Code getYotoKubunCode() {
        return yotoKubunCode;
    }

    /**
     * 用途区分コードのsetメソッドです。
     *
     * @param yotoKubunCode 用途区分コード
     */
    public void setYotoKubunCode(Code yotoKubunCode) {
        this.yotoKubunCode = yotoKubunCode;
    }

    /**
     * 認証日１のgetメソッドです。
     *
     * @return 認証日１
     */
    public FlexibleDate getNinshoYMD1() {
        return ninshoYMD1;
    }

    /**
     * 認証日１のsetメソッドです。
     *
     * @param ninshoYMD1 認証日１
     */
    public void setNinshoYMD1(FlexibleDate ninshoYMD1) {
        this.ninshoYMD1 = ninshoYMD1;
    }

    /**
     * 認証者コード１のgetメソッドです。
     *
     * @return 認証者コード１
     */
    public NinshoshaCode getNinshoshaCode1() {
        return ninshoshaCode1;
    }

    /**
     * 認証者コード１のsetメソッドです。
     *
     * @param ninshoshaCode1 認証者コード１
     */
    public void setNinshoshaCode1(NinshoshaCode ninshoshaCode1) {
        this.ninshoshaCode1 = ninshoshaCode1;
    }

    /**
     * 認証日２のgetメソッドです。
     *
     * @return 認証日２
     */
    public FlexibleDate getNinshoYMD2() {
        return ninshoYMD2;
    }

    /**
     * 認証日２のsetメソッドです。
     *
     * @param ninshoYMD2 認証日２
     */
    public void setNinshoYMD2(FlexibleDate ninshoYMD2) {
        this.ninshoYMD2 = ninshoYMD2;
    }

    /**
     * 認証者コード２のgetメソッドです。
     *
     * @return 認証者コード２
     */
    public NinshoshaCode getNinshoshaCode2() {
        return ninshoshaCode2;
    }

    /**
     * 認証者コード２のsetメソッドです。
     *
     * @param ninshoshaCode2 認証者コード２
     */
    public void setNinshoshaCode2(NinshoshaCode ninshoshaCode2) {
        this.ninshoshaCode2 = ninshoshaCode2;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7004KaigoShiharaiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7004KaigoShiharaiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7004KaigoShiharaiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.kamokuCode, other.kamokuCode)) {
            return false;
        }
        if (!Objects.equals(this.ketteiYMD, other.ketteiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7004KaigoShiharaiJohoEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.kamokuCode = entity.kamokuCode;
        this.ketteiYMD = entity.ketteiYMD;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shichosonCode = entity.shichosonCode;
        this.shiharaiHohoKubun = entity.shiharaiHohoKubun;
        this.madoguchiShiharaiBashoCode = entity.madoguchiShiharaiBashoCode;
        this.madoguchiShiharaiKaishiYMDHM = entity.madoguchiShiharaiKaishiYMDHM;
        this.madoguchiShiharaiShuryoYMDHM = entity.madoguchiShiharaiShuryoYMDHM;
        this.furikomiYoteiYMD = entity.furikomiYoteiYMD;
        this.shiharaiKingaku = entity.shiharaiKingaku;
        this.syubetsuCode = entity.syubetsuCode;
        this.yotoKubunCode = entity.yotoKubunCode;
        this.ninshoYMD1 = entity.ninshoYMD1;
        this.ninshoshaCode1 = entity.ninshoshaCode1;
        this.ninshoYMD2 = entity.ninshoYMD2;
        this.ninshoshaCode2 = entity.ninshoshaCode2;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, kamokuCode, ketteiYMD, hihokenshaNo, shichosonCode, shiharaiHohoKubun, madoguchiShiharaiBashoCode, madoguchiShiharaiKaishiYMDHM, madoguchiShiharaiShuryoYMDHM, furikomiYoteiYMD, shiharaiKingaku, syubetsuCode, yotoKubunCode, ninshoYMD1, ninshoshaCode1, ninshoYMD2, ninshoshaCode2);
    }

// </editor-fold>
}

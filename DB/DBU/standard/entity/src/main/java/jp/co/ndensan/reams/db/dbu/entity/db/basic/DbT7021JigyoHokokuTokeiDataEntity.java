package jp.co.ndensan.reams.db.dbu.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 事業報告統計データテーブルのエンティティクラスです。
 */
public class DbT7021JigyoHokokuTokeiDataEntity extends DbTableEntityBase<DbT7021JigyoHokokuTokeiDataEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7021JigyoHokokuTokeiData");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear hokokuYSeireki;
    @PrimaryKey
    private RString hokokuM;
    @PrimaryKey
    private FlexibleYear shukeiTaishoYSeireki;
    @PrimaryKey
    private RString shukeiTaishoM;
    @PrimaryKey
    private RString toukeiTaishoKubun;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private Code hyoNo;
    @PrimaryKey
    private Code shukeiNo;
    @PrimaryKey
    private Code shukeiTani;
    @PrimaryKey
    private Decimal tateNo;
    @PrimaryKey
    private Decimal yokoNo;
    private Decimal shukeiKekkaAtai;
    private RString shukeiKomokuMeisho;
    private Code tateKomokuCode;
    private Code yokoKomokuCode;

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
     * 報告年のgetメソッドです。
     * <br/>
     * <br/>年報時は、年度を設定
     * 
     * @return 報告年
     */
    public FlexibleYear getHokokuYSeireki() {
        return hokokuYSeireki;
    }

    /**
     * 報告年のsetメソッドです。
     * <br/>
     * <br/>年報時は、年度を設定
     * 
     * @param hokokuYSeireki 報告年
     */
    public void setHokokuYSeireki(FlexibleYear hokokuYSeireki) {
        this.hokokuYSeireki = hokokuYSeireki;
    }

    /**
     * 報告月のgetメソッドです。
     * <br/>
     * <br/>年報時は、「00」を設定
     * 
     * @return 報告月
     */
    public RString getHokokuM() {
        return hokokuM;
    }

    /**
     * 報告月のsetメソッドです。
     * <br/>
     * <br/>年報時は、「00」を設定
     * 
     * @param hokokuM 報告月
     */
    public void setHokokuM(RString hokokuM) {
        this.hokokuM = hokokuM;
    }

    /**
     * 集計対象年のgetメソッドです。
     * <br/>
     * <br/>年報時は、年度を設定
     * 
     * @return 集計対象年
     */
    public FlexibleYear getShukeiTaishoYSeireki() {
        return shukeiTaishoYSeireki;
    }

    /**
     * 集計対象年のsetメソッドです。
     * <br/>
     * <br/>年報時は、年度を設定
     * 
     * @param shukeiTaishoYSeireki 集計対象年
     */
    public void setShukeiTaishoYSeireki(FlexibleYear shukeiTaishoYSeireki) {
        this.shukeiTaishoYSeireki = shukeiTaishoYSeireki;
    }

    /**
     * 集計対象月のgetメソッドです。
     * <br/>
     * <br/>年報時は、「00」を設定
     * 
     * @return 集計対象月
     */
    public RString getShukeiTaishoM() {
        return shukeiTaishoM;
    }

    /**
     * 集計対象月のsetメソッドです。
     * <br/>
     * <br/>年報時は、「00」を設定
     * 
     * @param shukeiTaishoM 集計対象月
     */
    public void setShukeiTaishoM(RString shukeiTaishoM) {
        this.shukeiTaishoM = shukeiTaishoM;
    }

    /**
     * 統計対象区分のgetメソッドです。
     * <br/>
     * <br/>広域の場合、広域保険者か構成市町村か、 合併市町村の場合、新市町村か旧市町村か
     * 
     * @return 統計対象区分
     */
    public RString getToukeiTaishoKubun() {
        return toukeiTaishoKubun;
    }

    /**
     * 統計対象区分のsetメソッドです。
     * <br/>
     * <br/>広域の場合、広域保険者か構成市町村か、 合併市町村の場合、新市町村か旧市町村か
     * 
     * @param toukeiTaishoKubun 統計対象区分
     */
    public void setToukeiTaishoKubun(RString toukeiTaishoKubun) {
        this.toukeiTaishoKubun = toukeiTaishoKubun;
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
     * 表番号のgetメソッドです。
     * 
     * @return 表番号
     */
    public Code getHyoNo() {
        return hyoNo;
    }

    /**
     * 表番号のsetメソッドです。
     * 
     * @param hyoNo 表番号
     */
    public void setHyoNo(Code hyoNo) {
        this.hyoNo = hyoNo;
    }

    /**
     * 集計番号のgetメソッドです。
     * 
     * @return 集計番号
     */
    public Code getShukeiNo() {
        return shukeiNo;
    }

    /**
     * 集計番号のsetメソッドです。
     * 
     * @param shukeiNo 集計番号
     */
    public void setShukeiNo(Code shukeiNo) {
        this.shukeiNo = shukeiNo;
    }

    /**
     * 集計単位のgetメソッドです。
     * 
     * @return 集計単位
     */
    public Code getShukeiTani() {
        return shukeiTani;
    }

    /**
     * 集計単位のsetメソッドです。
     * 
     * @param shukeiTani 集計単位
     */
    public void setShukeiTani(Code shukeiTani) {
        this.shukeiTani = shukeiTani;
    }

    /**
     * 縦番号のgetメソッドです。
     * 
     * @return 縦番号
     */
    public Decimal getTateNo() {
        return tateNo;
    }

    /**
     * 縦番号のsetメソッドです。
     * 
     * @param tateNo 縦番号
     */
    public void setTateNo(Decimal tateNo) {
        this.tateNo = tateNo;
    }

    /**
     * 横番号のgetメソッドです。
     * 
     * @return 横番号
     */
    public Decimal getYokoNo() {
        return yokoNo;
    }

    /**
     * 横番号のsetメソッドです。
     * 
     * @param yokoNo 横番号
     */
    public void setYokoNo(Decimal yokoNo) {
        this.yokoNo = yokoNo;
    }

    /**
     * 集計結果値のgetメソッドです。
     * 
     * @return 集計結果値
     */
    public Decimal getShukeiKekkaAtai() {
        return shukeiKekkaAtai;
    }

    /**
     * 集計結果値のsetメソッドです。
     * 
     * @param shukeiKekkaAtai 集計結果値
     */
    public void setShukeiKekkaAtai(Decimal shukeiKekkaAtai) {
        this.shukeiKekkaAtai = shukeiKekkaAtai;
    }

    /**
     * 集計項目名称のgetメソッドです。
     * 
     * @return 集計項目名称
     */
    public RString getShukeiKomokuMeisho() {
        return shukeiKomokuMeisho;
    }

    /**
     * 集計項目名称のsetメソッドです。
     * 
     * @param shukeiKomokuMeisho 集計項目名称
     */
    public void setShukeiKomokuMeisho(RString shukeiKomokuMeisho) {
        this.shukeiKomokuMeisho = shukeiKomokuMeisho;
    }

    /**
     * 縦項目コードのgetメソッドです。
     * 
     * @return 縦項目コード
     */
    public Code getTateKomokuCode() {
        return tateKomokuCode;
    }

    /**
     * 縦項目コードのsetメソッドです。
     * 
     * @param tateKomokuCode 縦項目コード
     */
    public void setTateKomokuCode(Code tateKomokuCode) {
        this.tateKomokuCode = tateKomokuCode;
    }

    /**
     * 横項目コードのgetメソッドです。
     * 
     * @return 横項目コード
     */
    public Code getYokoKomokuCode() {
        return yokoKomokuCode;
    }

    /**
     * 横項目コードのsetメソッドです。
     * 
     * @param yokoKomokuCode 横項目コード
     */
    public void setYokoKomokuCode(Code yokoKomokuCode) {
        this.yokoKomokuCode = yokoKomokuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7021JigyoHokokuTokeiDataEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7021JigyoHokokuTokeiDataEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7021JigyoHokokuTokeiDataEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hokokuYSeireki, other.hokokuYSeireki)) {
            return false;
        }
        if (!Objects.equals(this.hokokuM, other.hokokuM)) {
            return false;
        }
        if (!Objects.equals(this.shukeiTaishoYSeireki, other.shukeiTaishoYSeireki)) {
            return false;
        }
        if (!Objects.equals(this.shukeiTaishoM, other.shukeiTaishoM)) {
            return false;
        }
        if (!Objects.equals(this.toukeiTaishoKubun, other.toukeiTaishoKubun)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.hyoNo, other.hyoNo)) {
            return false;
        }
        if (!Objects.equals(this.shukeiNo, other.shukeiNo)) {
            return false;
        }
        if (!Objects.equals(this.shukeiTani, other.shukeiTani)) {
            return false;
        }
        if (!Objects.equals(this.tateNo, other.tateNo)) {
            return false;
        }
        if (!Objects.equals(this.yokoNo, other.yokoNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7021JigyoHokokuTokeiDataEntity entity) {
        this.hokokuYSeireki = entity.hokokuYSeireki;
        this.hokokuM = entity.hokokuM;
        this.shukeiTaishoYSeireki = entity.shukeiTaishoYSeireki;
        this.shukeiTaishoM = entity.shukeiTaishoM;
        this.toukeiTaishoKubun = entity.toukeiTaishoKubun;
        this.shichosonCode = entity.shichosonCode;
        this.hyoNo = entity.hyoNo;
        this.shukeiNo = entity.shukeiNo;
        this.shukeiTani = entity.shukeiTani;
        this.tateNo = entity.tateNo;
        this.yokoNo = entity.yokoNo;
        this.shukeiKekkaAtai = entity.shukeiKekkaAtai;
        this.shukeiKomokuMeisho = entity.shukeiKomokuMeisho;
        this.tateKomokuCode = entity.tateKomokuCode;
        this.yokoKomokuCode = entity.yokoKomokuCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hokokuYSeireki, hokokuM, shukeiTaishoYSeireki, shukeiTaishoM, toukeiTaishoKubun, shichosonCode, hyoNo, shukeiNo, shukeiTani, tateNo, yokoNo, shukeiKekkaAtai, shukeiKomokuMeisho, tateKomokuCode, yokoKomokuCode);
    }

// </editor-fold>



}

package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT1006KyokaisoGaitoshaの項目定義クラスです
 *
 */
public class DbT1006KyokaisoGaitoshaEntity extends DbTableEntityBase<DbT1006KyokaisoGaitoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1006KyokaisoGaitosha");

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
    private Decimal rirekiNo;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private FlexibleDate kyokaisoSochiKetteiYMD;
    private RString kyuufugakuGengakuKisaiKiajoFlag;
    private RString hyojunFutanGengakuGaitoFlag;
    private Decimal hyojunFutanKeigengoFutangaku;
    private RString kyojuhinadoFutangakugengakuGaitoFlag;
    private RString kyojuhiKeigengoKyoshitsuShuruiCode;
    private Decimal kyojuhiKeigengoHutangaku;
    private RString shokuhiKeigengoHutangakuGaitoFlag;
    private Decimal shokuhiKeigengoHutangaku;
    private RString kogakuServicehiJogengakuGengakuGaitoFlag;
    private Decimal kogakuServicehiJogengakuGengakugoJogengaku;
    private RString hokenryoNofuGengakuFlag;

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
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
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
     * 適用開始年月日のgetメソッドです。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * 適用開始年月日のsetメソッドです。
     *
     * @param tekiyoKaishiYMD 適用開始年月日
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * 適用終了年月日のgetメソッドです。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * 適用終了年月日のsetメソッドです。
     *
     * @param tekiyoShuryoYMD 適用終了年月日
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * 境界層措置決定年月日のgetメソッドです。
     *
     * @return 境界層措置決定年月日
     */
    public FlexibleDate getKyokaisoSochiKetteiYMD() {
        return kyokaisoSochiKetteiYMD;
    }

    /**
     * 境界層措置決定年月日のsetメソッドです。
     *
     * @param kyokaisoSochiKetteiYMD 境界層措置決定年月日
     */
    public void setKyokaisoSochiKetteiYMD(FlexibleDate kyokaisoSochiKetteiYMD) {
        this.kyokaisoSochiKetteiYMD = kyokaisoSochiKetteiYMD;
    }

    /**
     * 給付額減額記載解除フラグのgetメソッドです。
     *
     * @return 給付額減額記載解除フラグ
     */
    public RString getKyuufugakuGengakuKisaiKiajoFlag() {
        return kyuufugakuGengakuKisaiKiajoFlag;
    }

    /**
     * 給付額減額記載解除フラグのsetメソッドです。
     *
     * @param kyuufugakuGengakuKisaiKiajoFlag 給付額減額記載解除フラグ
     */
    public void setKyuufugakuGengakuKisaiKiajoFlag(RString kyuufugakuGengakuKisaiKiajoFlag) {
        this.kyuufugakuGengakuKisaiKiajoFlag = kyuufugakuGengakuKisaiKiajoFlag;
    }

    /**
     * 標準負担額額該当フラグのgetメソッドです。
     *
     * @return 標準負担額額該当フラグ
     */
    public RString getHyojunFutanGengakuGaitoFlag() {
        return hyojunFutanGengakuGaitoFlag;
    }

    /**
     * 標準負担額額該当フラグのsetメソッドです。
     *
     * @param hyojunFutanGengakuGaitoFlag 標準負担額額該当フラグ
     */
    public void setHyojunFutanGengakuGaitoFlag(RString hyojunFutanGengakuGaitoFlag) {
        this.hyojunFutanGengakuGaitoFlag = hyojunFutanGengakuGaitoFlag;
    }

    /**
     * 標準負担軽減後負担額のgetメソッドです。
     *
     * @return 標準負担軽減後負担額
     */
    public Decimal getHyojunFutanKeigengoFutangaku() {
        return hyojunFutanKeigengoFutangaku;
    }

    /**
     * 標準負担軽減後負担額のsetメソッドです。
     *
     * @param hyojunFutanKeigengoFutangaku 標準負担軽減後負担額
     */
    public void setHyojunFutanKeigengoFutangaku(Decimal hyojunFutanKeigengoFutangaku) {
        this.hyojunFutanKeigengoFutangaku = hyojunFutanKeigengoFutangaku;
    }

    /**
     * 居住費等負担額減額該当フラグのgetメソッドです。
     *
     * @return 居住費等負担額減額該当フラグ
     */
    public RString getKyojuhinadoFutangakugengakuGaitoFlag() {
        return kyojuhinadoFutangakugengakuGaitoFlag;
    }

    /**
     * 居住費等負担額減額該当フラグのsetメソッドです。
     *
     * @param kyojuhinadoFutangakugengakuGaitoFlag 居住費等負担額減額該当フラグ
     */
    public void setKyojuhinadoFutangakugengakuGaitoFlag(RString kyojuhinadoFutangakugengakuGaitoFlag) {
        this.kyojuhinadoFutangakugengakuGaitoFlag = kyojuhinadoFutangakugengakuGaitoFlag;
    }

    /**
     * 居住費軽減後居室種類コードのgetメソッドです。
     *
     * @return 居住費軽減後居室種類コード
     */
    public RString getKyojuhiKeigengoKyoshitsuShuruiCode() {
        return kyojuhiKeigengoKyoshitsuShuruiCode;
    }

    /**
     * 居住費軽減後居室種類コードのsetメソッドです。
     *
     * @param kyojuhiKeigengoKyoshitsuShuruiCode 居住費軽減後居室種類コード
     */
    public void setKyojuhiKeigengoKyoshitsuShuruiCode(RString kyojuhiKeigengoKyoshitsuShuruiCode) {
        this.kyojuhiKeigengoKyoshitsuShuruiCode = kyojuhiKeigengoKyoshitsuShuruiCode;
    }

    /**
     * 居住費軽減後負担額のgetメソッドです。
     *
     * @return 居住費軽減後負担額
     */
    public Decimal getKyojuhiKeigengoHutangaku() {
        return kyojuhiKeigengoHutangaku;
    }

    /**
     * 居住費軽減後負担額のsetメソッドです。
     *
     * @param kyojuhiKeigengoHutangaku 居住費軽減後負担額
     */
    public void setKyojuhiKeigengoHutangaku(Decimal kyojuhiKeigengoHutangaku) {
        this.kyojuhiKeigengoHutangaku = kyojuhiKeigengoHutangaku;
    }

    /**
     * 食費負担額減額該当フラグのgetメソッドです。
     *
     * @return 食費負担額減額該当フラグ
     */
    public RString getShokuhiKeigengoHutangakuGaitoFlag() {
        return shokuhiKeigengoHutangakuGaitoFlag;
    }

    /**
     * 食費負担額減額該当フラグのsetメソッドです。
     *
     * @param shokuhiKeigengoHutangakuGaitoFlag 食費負担額減額該当フラグ
     */
    public void setShokuhiKeigengoHutangakuGaitoFlag(RString shokuhiKeigengoHutangakuGaitoFlag) {
        this.shokuhiKeigengoHutangakuGaitoFlag = shokuhiKeigengoHutangakuGaitoFlag;
    }

    /**
     * 食費軽減後負担額のgetメソッドです。
     *
     * @return 食費軽減後負担額
     */
    public Decimal getShokuhiKeigengoHutangaku() {
        return shokuhiKeigengoHutangaku;
    }

    /**
     * 食費軽減後負担額のsetメソッドです。
     *
     * @param shokuhiKeigengoHutangaku 食費軽減後負担額
     */
    public void setShokuhiKeigengoHutangaku(Decimal shokuhiKeigengoHutangaku) {
        this.shokuhiKeigengoHutangaku = shokuhiKeigengoHutangaku;
    }

    /**
     * 高額ｻｰﾋﾞｽ費上限額減額該当フラグのgetメソッドです。
     *
     * @return 高額ｻｰﾋﾞｽ費上限額減額該当フラグ
     */
    public RString getKogakuServicehiJogengakuGengakuGaitoFlag() {
        return kogakuServicehiJogengakuGengakuGaitoFlag;
    }

    /**
     * 高額ｻｰﾋﾞｽ費上限額減額該当フラグのsetメソッドです。
     *
     * @param kogakuServicehiJogengakuGengakuGaitoFlag 高額ｻｰﾋﾞｽ費上限額減額該当フラグ
     */
    public void setKogakuServicehiJogengakuGengakuGaitoFlag(RString kogakuServicehiJogengakuGengakuGaitoFlag) {
        this.kogakuServicehiJogengakuGengakuGaitoFlag = kogakuServicehiJogengakuGengakuGaitoFlag;
    }

    /**
     * 高額ｻｰﾋﾞｽ費減額後上限額のgetメソッドです。
     *
     * @return 高額ｻｰﾋﾞｽ費減額後上限額
     */
    public Decimal getKogakuServicehiJogengakuGengakugoJogengaku() {
        return kogakuServicehiJogengakuGengakugoJogengaku;
    }

    /**
     * 高額ｻｰﾋﾞｽ費減額後上限額のsetメソッドです。
     *
     * @param kogakuServicehiJogengakuGengakugoJogengaku 高額ｻｰﾋﾞｽ費減額後上限額
     */
    public void setKogakuServicehiJogengakuGengakugoJogengaku(Decimal kogakuServicehiJogengakuGengakugoJogengaku) {
        this.kogakuServicehiJogengakuGengakugoJogengaku = kogakuServicehiJogengakuGengakugoJogengaku;
    }

    /**
     * 保険料納付減額フラグのgetメソッドです。
     *
     * @return 保険料納付減額フラグ
     */
    public RString getHokenryoNofuGengakuFlag() {
        return hokenryoNofuGengakuFlag;
    }

    /**
     * 保険料納付減額フラグのsetメソッドです。
     *
     * @param hokenryoNofuGengakuFlag 保険料納付減額フラグ
     */
    public void setHokenryoNofuGengakuFlag(RString hokenryoNofuGengakuFlag) {
        this.hokenryoNofuGengakuFlag = hokenryoNofuGengakuFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1006KyokaisoGaitoshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1006KyokaisoGaitoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1006KyokaisoGaitoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT1006KyokaisoGaitoshaEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.kyokaisoSochiKetteiYMD = entity.kyokaisoSochiKetteiYMD;
        this.kyuufugakuGengakuKisaiKiajoFlag = entity.kyuufugakuGengakuKisaiKiajoFlag;
        this.hyojunFutanGengakuGaitoFlag = entity.hyojunFutanGengakuGaitoFlag;
        this.hyojunFutanKeigengoFutangaku = entity.hyojunFutanKeigengoFutangaku;
        this.kyojuhinadoFutangakugengakuGaitoFlag = entity.kyojuhinadoFutangakugengakuGaitoFlag;
        this.kyojuhiKeigengoKyoshitsuShuruiCode = entity.kyojuhiKeigengoKyoshitsuShuruiCode;
        this.kyojuhiKeigengoHutangaku = entity.kyojuhiKeigengoHutangaku;
        this.shokuhiKeigengoHutangakuGaitoFlag = entity.shokuhiKeigengoHutangakuGaitoFlag;
        this.shokuhiKeigengoHutangaku = entity.shokuhiKeigengoHutangaku;
        this.kogakuServicehiJogengakuGengakuGaitoFlag = entity.kogakuServicehiJogengakuGengakuGaitoFlag;
        this.kogakuServicehiJogengakuGengakugoJogengaku = entity.kogakuServicehiJogengakuGengakugoJogengaku;
        this.hokenryoNofuGengakuFlag = entity.hokenryoNofuGengakuFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, rirekiNo, tekiyoKaishiYMD, tekiyoShuryoYMD, kyokaisoSochiKetteiYMD, kyuufugakuGengakuKisaiKiajoFlag, hyojunFutanGengakuGaitoFlag, hyojunFutanKeigengoFutangaku, kyojuhinadoFutangakugengakuGaitoFlag, kyojuhiKeigengoKyoshitsuShuruiCode, kyojuhiKeigengoHutangaku, shokuhiKeigengoHutangakuGaitoFlag, shokuhiKeigengoHutangaku, kogakuServicehiJogengakuGengakuGaitoFlag, kogakuServicehiJogengakuGengakugoJogengaku, hokenryoNofuGengakuFlag);
    }

// </editor-fold>
}

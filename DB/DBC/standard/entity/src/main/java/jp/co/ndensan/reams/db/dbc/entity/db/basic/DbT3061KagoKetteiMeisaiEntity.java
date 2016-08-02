package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 過誤決定明細テーブルのエンティティクラスです。
 */
public class DbT3061KagoKetteiMeisaiEntity extends DbTableEntityBase<DbT3061KagoKetteiMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3061KagoKetteiMeisai");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private FlexibleYearMonth toriatsukaiYM;
    private RString hokenshaKubun;
    private int rirekiNo;
    private JigyoshaNo jigyoshoNo;
    private RString jigyoshoName;
    private HihokenshaNo hiHokenshaNo;
    private RString kohiJukyushaNo;
    private HokenshaNo shokisaiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private ServiceShuruiCode serviceShuruiCode;
    private RString serviceShuruiName;
    private Code kagomoushitateJiyuCode;
    private RString kagomoushitateJiyu;
    private Decimal tanisu;
    private Decimal hokenshaFutangaku;
    private FlexibleYearMonth torikomiYM;

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
     * 取扱年月のgetメソッドです。
     * <br/>
     * <br/>連合会が取扱った年月
     * 
     * @return 取扱年月
     */
    public FlexibleYearMonth getToriatsukaiYM() {
        return toriatsukaiYM;
    }

    /**
     * 取扱年月のsetメソッドです。
     * <br/>
     * <br/>連合会が取扱った年月
     * 
     * @param toriatsukaiYM 取扱年月
     */
    public void setToriatsukaiYM(@Nonnull FlexibleYearMonth toriatsukaiYM) {
        this.toriatsukaiYM = toriatsukaiYM;
    }

    /**
     * 保険者区分のgetメソッドです。
     * <br/>
     * <br/>1：保険者
     * <br/>2：公費負担者　
     * <br/>3：総合事業費(経過措置)保険者
     * <br/>4：総合事業費保険者
     * <br/>5：総合事業費公費負担者
     * 
     * @return 保険者区分
     */
    public RString getHokenshaKubun() {
        return hokenshaKubun;
    }

    /**
     * 保険者区分のsetメソッドです。
     * <br/>
     * <br/>1：保険者
     * <br/>2：公費負担者　
     * <br/>3：総合事業費(経過措置)保険者
     * <br/>4：総合事業費保険者
     * <br/>5：総合事業費公費負担者
     * 
     * @param hokenshaKubun 保険者区分
     */
    public void setHokenshaKubun(@Nonnull RString hokenshaKubun) {
        this.hokenshaKubun = hokenshaKubun;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 事業所番号のgetメソッドです。
     * 
     * @return 事業所番号
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * 事業所番号のsetメソッドです。
     * 
     * @param jigyoshoNo 事業所番号
     */
    public void setJigyoshoNo(@Nonnull JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * 事業所名のgetメソッドです。
     * 
     * @return 事業所名
     */
    @CheckForNull
    public RString getJigyoshoName() {
        return jigyoshoName;
    }

    /**
     * 事業所名のsetメソッドです。
     * 
     * @param jigyoshoName 事業所名
     */
    public void setJigyoshoName(RString jigyoshoName) {
        this.jigyoshoName = jigyoshoName;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * 
     * @return 被保険者番号
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hiHokenshaNo 被保険者番号
     */
    public void setHiHokenshaNo(@Nonnull HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * 公費受給者番号のgetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2、5）の場合
     * 
     * @return 公費受給者番号
     */
    @CheckForNull
    public RString getKohiJukyushaNo() {
        return kohiJukyushaNo;
    }

    /**
     * 公費受給者番号のsetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2、5）の場合
     * 
     * @param kohiJukyushaNo 公費受給者番号
     */
    public void setKohiJukyushaNo(RString kohiJukyushaNo) {
        this.kohiJukyushaNo = kohiJukyushaNo;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2、5）の場合
     * 
     * @return 証記載保険者番号
     */
    @CheckForNull
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * <br/>
     * <br/>公費（保険者区分=2、5）の場合
     * 
     * @param shokisaiHokenshaNo 証記載保険者番号
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * サービス提供年月のgetメソッドです。
     * 
     * @return サービス提供年月
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * サービス提供年月のsetメソッドです。
     * 
     * @param serviceTeikyoYM サービス提供年月
     */
    public void setServiceTeikyoYM(@Nonnull FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * サービス種類コードのgetメソッドです。
     * 
     * @return サービス種類コード
     */
    @CheckForNull
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     * 
     * @param serviceShuruiCode サービス種類コード
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * サービス種類名のgetメソッドです。
     * 
     * @return サービス種類名
     */
    @CheckForNull
    public RString getServiceShuruiName() {
        return serviceShuruiName;
    }

    /**
     * サービス種類名のsetメソッドです。
     * 
     * @param serviceShuruiName サービス種類名
     */
    public void setServiceShuruiName(RString serviceShuruiName) {
        this.serviceShuruiName = serviceShuruiName;
    }

    /**
     * 過誤申立事由コードのgetメソッドです。
     * 
     * @return 過誤申立事由コード
     */
    @CheckForNull
    public Code getKagomoushitateJiyuCode() {
        return kagomoushitateJiyuCode;
    }

    /**
     * 過誤申立事由コードのsetメソッドです。
     * 
     * @param kagomoushitateJiyuCode 過誤申立事由コード
     */
    public void setKagomoushitateJiyuCode(Code kagomoushitateJiyuCode) {
        this.kagomoushitateJiyuCode = kagomoushitateJiyuCode;
    }

    /**
     * 過誤申立事由のgetメソッドです。
     * 
     * @return 過誤申立事由
     */
    @CheckForNull
    public RString getKagomoushitateJiyu() {
        return kagomoushitateJiyu;
    }

    /**
     * 過誤申立事由のsetメソッドです。
     * 
     * @param kagomoushitateJiyu 過誤申立事由
     */
    public void setKagomoushitateJiyu(RString kagomoushitateJiyu) {
        this.kagomoushitateJiyu = kagomoushitateJiyu;
    }

    /**
     * 単位数（特定入所者介護費等）のgetメソッドです。
     * 
     * @return 単位数（特定入所者介護費等）
     */
    @CheckForNull
    public Decimal getTanisu() {
        return tanisu;
    }

    /**
     * 単位数（特定入所者介護費等）のsetメソッドです。
     * 
     * @param tanisu 単位数（特定入所者介護費等）
     */
    public void setTanisu(Decimal tanisu) {
        this.tanisu = tanisu;
    }

    /**
     * 保険者負担額のgetメソッドです。
     * 
     * @return 保険者負担額
     */
    @CheckForNull
    public Decimal getHokenshaFutangaku() {
        return hokenshaFutangaku;
    }

    /**
     * 保険者負担額のsetメソッドです。
     * 
     * @param hokenshaFutangaku 保険者負担額
     */
    public void setHokenshaFutangaku(Decimal hokenshaFutangaku) {
        this.hokenshaFutangaku = hokenshaFutangaku;
    }

    /**
     * 取込年月のgetメソッドです。
     * 
     * @return 取込年月
     */
    @CheckForNull
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * 取込年月のsetメソッドです。
     * 
     * @param torikomiYM 取込年月
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3061KagoKetteiMeisaiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3061KagoKetteiMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3061KagoKetteiMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3061KagoKetteiMeisaiEntity entity) {
        this.toriatsukaiYM = entity.toriatsukaiYM;
        this.hokenshaKubun = entity.hokenshaKubun;
        this.rirekiNo = entity.rirekiNo;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.jigyoshoName = entity.jigyoshoName;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.kohiJukyushaNo = entity.kohiJukyushaNo;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceShuruiName = entity.serviceShuruiName;
        this.kagomoushitateJiyuCode = entity.kagomoushitateJiyuCode;
        this.kagomoushitateJiyu = entity.kagomoushitateJiyu;
        this.tanisu = entity.tanisu;
        this.hokenshaFutangaku = entity.hokenshaFutangaku;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(toriatsukaiYM, hokenshaKubun, rirekiNo, jigyoshoNo, jigyoshoName, hiHokenshaNo, kohiJukyushaNo, shokisaiHokenshaNo, serviceTeikyoYM, serviceShuruiCode, serviceShuruiName, kagomoushitateJiyuCode, kagomoushitateJiyu, tanisu, hokenshaFutangaku, torikomiYM);
    }

// </editor-fold>


}

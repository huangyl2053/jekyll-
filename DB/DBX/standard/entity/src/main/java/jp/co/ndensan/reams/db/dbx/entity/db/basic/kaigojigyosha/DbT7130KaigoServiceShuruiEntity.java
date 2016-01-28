package jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * DbT7130KaigoServiceShuruiの項目定義クラスです
 *
 * @author 自動生成
 * @jpName 介護サービス種類エンティティ
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
@OnNextSchema("rgdb")
public class DbT7130KaigoServiceShuruiEntity extends DbTableEntityBase<DbT7130KaigoServiceShuruiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7130KaigoServiceShurui");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KaigoServiceShuruiCode serviceShuruiCd;
    @PrimaryKey
    private FlexibleYearMonth teikyoKaishiYM;
    private FlexibleYearMonth teikyoshuryoYM;
    private RString serviceShuruiMeisho;
    private RString serviceShuruiRyakusho;
    private KaigoServiceBunruiCode serviceBunrruicode;

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
     * サービス種類コードのgetメソッドです。
     *
     * @return サービス種類コード
     */
    public KaigoServiceShuruiCode getServiceShuruiCd() {
        return serviceShuruiCd;
    }

    /**
     * サービス種類コードのsetメソッドです。
     *
     * @param serviceShuruiCd サービス種類コード
     */
    public void setServiceShuruiCd(KaigoServiceShuruiCode serviceShuruiCd) {
        this.serviceShuruiCd = serviceShuruiCd;
    }

    /**
     * 提供開始年月のgetメソッドです。
     *
     * @return 提供開始年月
     */
    public FlexibleYearMonth getTeikyoKaishiYM() {
        return teikyoKaishiYM;
    }

    /**
     * 提供開始年月のsetメソッドです。
     *
     * @param teikyoKaishiYM 提供開始年月
     */
    public void setTeikyoKaishiYM(FlexibleYearMonth teikyoKaishiYM) {
        this.teikyoKaishiYM = teikyoKaishiYM;
    }

    /**
     * 提供終了年月のgetメソッドです。
     *
     * @return 提供終了年月
     */
    public FlexibleYearMonth getTeikyoshuryoYM() {
        return teikyoshuryoYM;
    }

    /**
     * 提供終了年月のsetメソッドです。
     *
     * @param teikyoshuryoYM 提供終了年月
     */
    public void setTeikyoshuryoYM(FlexibleYearMonth teikyoshuryoYM) {
        this.teikyoshuryoYM = teikyoshuryoYM;
    }

    /**
     * サービス種類名称のgetメソッドです。
     *
     * @return サービス種類名称
     */
    public RString getServiceShuruiMeisho() {
        return serviceShuruiMeisho;
    }

    /**
     * サービス種類名称のsetメソッドです。
     *
     * @param serviceShuruiMeisho サービス種類名称
     */
    public void setServiceShuruiMeisho(RString serviceShuruiMeisho) {
        this.serviceShuruiMeisho = serviceShuruiMeisho;
    }

    /**
     * サービス種類略称のgetメソッドです。
     *
     * @return サービス種類略称
     */
    public RString getServiceShuruiRyakusho() {
        return serviceShuruiRyakusho;
    }

    /**
     * サービス種類略称のsetメソッドです。
     *
     * @param serviceShuruiRyakusho サービス種類略称
     */
    public void setServiceShuruiRyakusho(RString serviceShuruiRyakusho) {
        this.serviceShuruiRyakusho = serviceShuruiRyakusho;
    }

    /**
     * サービス分類コードのgetメソッドです。
     * <br/>
     * <br/>01:居宅サービス
     * <br/>02:居宅介護支援
     * <br/>03:施設サービス
     * <br/>04:特定入所者介護サービス
     * <br/>05:介護予防サービス
     * <br/>06:介護予防支援
     * <br/>07:地域密着型サービス
     * <br/>08:地域密着型介護予防サービス
     * <br/>09:その他
     * <br/>10:総合事業
     * <br/>11:ケアマネジメント
     *
     * @return サービス分類コード
     */
    public KaigoServiceBunruiCode getServiceBunrruicode() {
        return serviceBunrruicode;
    }

    /**
     * サービス分類コードのsetメソッドです。
     * <br/>
     * <br/>01:居宅サービス
     * <br/>02:居宅介護支援
     * <br/>03:施設サービス
     * <br/>04:特定入所者介護サービス
     * <br/>05:介護予防サービス
     * <br/>06:介護予防支援
     * <br/>07:地域密着型サービス
     * <br/>08:地域密着型介護予防サービス
     * <br/>09:その他
     * <br/>10:総合事業
     * <br/>11:ケアマネジメント
     *
     * @param serviceBunrruicode サービス分類コード
     */
    public void setServiceBunrruicode(KaigoServiceBunruiCode serviceBunrruicode) {
        this.serviceBunrruicode = serviceBunrruicode;
    }

    /**
     * このエンティティの主キーが他の{@literal UrT0522KaigoServiceShuruiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal UrT0522KaigoServiceShuruiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7130KaigoServiceShuruiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.serviceShuruiCd, other.serviceShuruiCd)) {
            return false;
        }
        if (!Objects.equals(this.teikyoKaishiYM, other.teikyoKaishiYM)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7130KaigoServiceShuruiEntity entity) {
        this.serviceShuruiCd = entity.serviceShuruiCd;
        this.teikyoKaishiYM = entity.teikyoKaishiYM;
        this.teikyoshuryoYM = entity.teikyoshuryoYM;
        this.serviceShuruiMeisho = entity.serviceShuruiMeisho;
        this.serviceShuruiRyakusho = entity.serviceShuruiRyakusho;
        this.serviceBunrruicode = entity.serviceBunrruicode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(serviceShuruiCd, teikyoKaishiYM, teikyoshuryoYM, serviceShuruiMeisho, serviceShuruiRyakusho, serviceBunrruicode);
    }

}

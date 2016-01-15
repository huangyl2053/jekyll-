package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuShikibetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuSanteiTani;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoServiceIdoJiyu;

/**
 * DbT7131KaigoServiceNaiyouテーブルのエンティティクラスです。
 *
 * @author 自動生成
 * @jpName 介護サービス内容エンティティ
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public class DbT7131KaigoServiceNaiyouEntity extends DbTableEntityBase<DbT7131KaigoServiceNaiyouEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7131KaigoServiceNaiyou");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KaigoServiceShuruiCode serviceShuruiCode;
    @PrimaryKey
    private RString serviceKoumokuCode;
    @PrimaryKey
    private FlexibleYearMonth teikyoKaishiYM;
    @PrimaryKey
    private Decimal rirekiNo;
    private FlexibleYearMonth teikyoShuryoYM;
    private RString serviceName;
    private RString serviceNameRyaku;
    private int taniSu;
    private TanisuShikibetsu tanisuShikibetsuCode;
    private TanisuSanteiTani tanisuSanteiTani;
    private KaigoServiceIdoJiyu idouJiyuCode;

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
    public KaigoServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     *
     * @param serviceShuruiCode サービス種類コード
     */
    public void setServiceShuruiCode(KaigoServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * サービス項目コードのgetメソッドです。
     *
     * @return サービス項目コード
     */
    public RString getServiceKoumokuCode() {
        return serviceKoumokuCode;
    }

    /**
     * サービス項目コードのsetメソッドです。
     *
     * @param serviceKoumokuCode サービス項目コード
     */
    public void setServiceKoumokuCode(RString serviceKoumokuCode) {
        this.serviceKoumokuCode = serviceKoumokuCode;
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
     * 提供終了年月のgetメソッドです。
     *
     * @return 提供終了年月
     */
    public FlexibleYearMonth getTeikyoShuryoYM() {
        return teikyoShuryoYM;
    }

    /**
     * 提供終了年月のsetメソッドです。
     *
     * @param teikyoShuryoYM 提供終了年月
     */
    public void setTeikyoShuryoYM(FlexibleYearMonth teikyoShuryoYM) {
        this.teikyoShuryoYM = teikyoShuryoYM;
    }

    /**
     * サービス名称のgetメソッドです。
     *
     * @return サービス名称
     */
    public RString getServiceName() {
        return serviceName;
    }

    /**
     * サービス名称のsetメソッドです。
     *
     * @param serviceName サービス名称
     */
    public void setServiceName(RString serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * サービス略称のgetメソッドです。
     *
     * @return サービス略称
     */
    public RString getServiceNameRyaku() {
        return serviceNameRyaku;
    }

    /**
     * サービス略称のsetメソッドです。
     *
     * @param serviceNameRyaku サービス略称
     */
    public void setServiceNameRyaku(RString serviceNameRyaku) {
        this.serviceNameRyaku = serviceNameRyaku;
    }

    /**
     * 単位数のgetメソッドです。
     *
     * @return 単位数
     */
    public int getTaniSu() {
        return taniSu;
    }

    /**
     * 単位数のsetメソッドです。
     *
     * @param taniSu 単位数
     */
    public void setTaniSu(int taniSu) {
        this.taniSu = taniSu;
    }

    /**
     * 単位数識別のgetメソッドです。
     * <br/>
     * <br/>01：単位数
     * <br/>02：金額(円)
     * <br/>03：％値
     * <br/>04：きざみ基準単位
     * <br/>05：法定単位数なし
     * <br/>06：単位数(記載省略)
     * <br/>07：％値(記載省略)
     * <br/>08：1/1000値
     * <br/>09：1/1000値(記載省略)
     * <br/>13：％値：上限
     *
     * @return 単位数識別
     */
    public TanisuShikibetsu getTanisuShikibetsuCode() {
        return tanisuShikibetsuCode;
    }

    /**
     * 単位数識別のsetメソッドです。
     * <br/>
     * <br/>01：単位数
     * <br/>02：金額(円)
     * <br/>03：％値
     * <br/>04：きざみ基準単位
     * <br/>05：法定単位数なし
     * <br/>06：単位数(記載省略)
     * <br/>07：％値(記載省略)
     * <br/>08：1/1000値
     * <br/>09：1/1000値(記載省略)
     * <br/>13：％値：上限
     *
     * @param tanisuShikibetsuCode 単位数識別
     */
    public void setTanisuShikibetsuCode(TanisuShikibetsu tanisuShikibetsuCode) {
        this.tanisuShikibetsuCode = tanisuShikibetsuCode;
    }

    /**
     * 単位数算定単位のgetメソッドです。
     * <br/>
     * <br/>01:1回につき
     * <br/>02:1日につき
     * <br/>03:1月につき
     * <br/>04:算定単位無し
     * <br/>05:1週間につき
     *
     * @return 単位数算定単位
     */
    public TanisuSanteiTani getTanisuSanteiTani() {
        return tanisuSanteiTani;
    }

    /**
     * 単位数算定単位のsetメソッドです。
     * <br/>
     * <br/>01:1回につき
     * <br/>02:1日につき
     * <br/>03:1月につき
     * <br/>04:算定単位無し
     * <br/>05:1週間につき
     *
     * @param tanisuSanteiTani 単位数算定単位
     */
    public void setTanisuSanteiTani(TanisuSanteiTani tanisuSanteiTani) {
        this.tanisuSanteiTani = tanisuSanteiTani;
    }

    /**
     * 異動事由のgetメソッドです。
     * <br/>
     * <br/>010：厚生省改定による 等
     *
     * @return 異動事由
     */
    public KaigoServiceIdoJiyu getIdouJiyuCode() {
        return idouJiyuCode;
    }

    /**
     * 異動事由のsetメソッドです。
     * <br/>
     * <br/>010：厚生省改定による 等
     *
     * @param idouJiyuCode 異動事由
     */
    public void setIdouJiyuCode(KaigoServiceIdoJiyu idouJiyuCode) {
        this.idouJiyuCode = idouJiyuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal UrT0523KaigoServiceNaiyouEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal UrT0523KaigoServiceNaiyouEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7131KaigoServiceNaiyouEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.serviceShuruiCode, other.serviceShuruiCode)) {
            return false;
        }
        if (!Objects.equals(this.serviceKoumokuCode, other.serviceKoumokuCode)) {
            return false;
        }
        if (!Objects.equals(this.teikyoKaishiYM, other.teikyoKaishiYM)) {
            return false;
        }
        if (!Objects.equals(this.rirekiNo, other.rirekiNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7131KaigoServiceNaiyouEntity entity) {
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceKoumokuCode = entity.serviceKoumokuCode;
        this.teikyoKaishiYM = entity.teikyoKaishiYM;
        this.rirekiNo = entity.rirekiNo;
        this.teikyoShuryoYM = entity.teikyoShuryoYM;
        this.serviceName = entity.serviceName;
        this.serviceNameRyaku = entity.serviceNameRyaku;
        this.taniSu = entity.taniSu;
        this.tanisuShikibetsuCode = entity.tanisuShikibetsuCode;
        this.tanisuSanteiTani = entity.tanisuSanteiTani;
        this.idouJiyuCode = entity.idouJiyuCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(serviceShuruiCode, serviceKoumokuCode, teikyoKaishiYM, rirekiNo, teikyoShuryoYM, serviceName, serviceNameRyaku, taniSu, tanisuShikibetsuCode, tanisuSanteiTani, idouJiyuCode);
    }

// </editor-fold>
}

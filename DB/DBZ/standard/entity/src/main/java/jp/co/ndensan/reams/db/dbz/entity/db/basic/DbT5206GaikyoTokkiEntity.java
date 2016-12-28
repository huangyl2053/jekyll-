package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 認定調査票（概況特記）テーブルのエンティティクラスです。
 */
public class DbT5206GaikyoTokkiEntity extends DbTableEntityBase<DbT5206GaikyoTokkiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5206GaikyoTokki");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ninteichosaRirekiNo;
    @PrimaryKey
    private RString gaikyoTokkiTextImageKubun;
    private Code genponMaskKubun;
    private RString jutakuKaishu;
    private RString tokubetsuKyufuService;
    private RString zaitakuService;
    private RString shuso;
    private RString kazokuJokyo;
    private RString kyojuKankyo;
    private RString kikaiKiki;

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
     * 申請書管理番号のgetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(@Nonnull ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 認定調査依頼履歴番号のgetメソッドです。
     * <br/>
     * <br/>認定調査依頼情報
     * 
     * @return 認定調査依頼履歴番号
     */
    public int getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /**
     * 認定調査依頼履歴番号のsetメソッドです。
     * <br/>
     * <br/>認定調査依頼情報
     * 
     * @param ninteichosaRirekiNo 認定調査依頼履歴番号
     */
    public void setNinteichosaRirekiNo(@Nonnull int ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /**
     * 概況特記テキスト・イメージ区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：特記事項テキスト・イメージ区分）1:テキスト 2:イメージ
     * 
     * @return 概況特記テキスト・イメージ区分
     */
    public RString getGaikyoTokkiTextImageKubun() {
        return gaikyoTokkiTextImageKubun;
    }

    /**
     * 概況特記テキスト・イメージ区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：特記事項テキスト・イメージ区分）1:テキスト 2:イメージ
     * 
     * @param gaikyoTokkiTextImageKubun 概況特記テキスト・イメージ区分
     */
    public void setGaikyoTokkiTextImageKubun(@Nonnull RString gaikyoTokkiTextImageKubun) {
        this.gaikyoTokkiTextImageKubun = gaikyoTokkiTextImageKubun;
    }

    /**
     * 原本マスク区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：原本マスク区分）1:原本  2:マスク
     * 
     * @return 原本マスク区分
     */
    public Code getGenponMaskKubun() {
        return genponMaskKubun;
    }

    /**
     * 原本マスク区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：原本マスク区分）1:原本  2:マスク
     * 
     * @param genponMaskKubun 原本マスク区分
     */
    public void setGenponMaskKubun(@Nonnull Code genponMaskKubun) {
        this.genponMaskKubun = genponMaskKubun;
    }

    /**
     * 住宅改修（改修箇所）のgetメソッドです。
     * 
     * @return 住宅改修（改修箇所）
     */
    @CheckForNull
    public RString getJutakuKaishu() {
        return jutakuKaishu;
    }

    /**
     * 住宅改修（改修箇所）のsetメソッドです。
     * 
     * @param jutakuKaishu 住宅改修（改修箇所）
     */
    public void setJutakuKaishu(RString jutakuKaishu) {
        this.jutakuKaishu = jutakuKaishu;
    }

    /**
     * 市町村特別給付サービス種類名のgetメソッドです。
     * 
     * @return 市町村特別給付サービス種類名
     */
    @CheckForNull
    public RString getTokubetsuKyufuService() {
        return tokubetsuKyufuService;
    }

    /**
     * 市町村特別給付サービス種類名のsetメソッドです。
     * 
     * @param tokubetsuKyufuService 市町村特別給付サービス種類名
     */
    public void setTokubetsuKyufuService(RString tokubetsuKyufuService) {
        this.tokubetsuKyufuService = tokubetsuKyufuService;
    }

    /**
     * 介護保険給付以外の在宅サービス種類名のgetメソッドです。
     * 
     * @return 介護保険給付以外の在宅サービス種類名
     */
    @CheckForNull
    public RString getZaitakuService() {
        return zaitakuService;
    }

    /**
     * 介護保険給付以外の在宅サービス種類名のsetメソッドです。
     * 
     * @param zaitakuService 介護保険給付以外の在宅サービス種類名
     */
    public void setZaitakuService(RString zaitakuService) {
        this.zaitakuService = zaitakuService;
    }

    /**
     * 概況特記事項（主訴）のgetメソッドです。
     * 
     * @return 概況特記事項（主訴）
     */
    @CheckForNull
    public RString getShuso() {
        return shuso;
    }

    /**
     * 概況特記事項（主訴）のsetメソッドです。
     * 
     * @param shuso 概況特記事項（主訴）
     */
    public void setShuso(RString shuso) {
        this.shuso = shuso;
    }

    /**
     * 概況特記事項（家族状況）のgetメソッドです。
     * 
     * @return 概況特記事項（家族状況）
     */
    @CheckForNull
    public RString getKazokuJokyo() {
        return kazokuJokyo;
    }

    /**
     * 概況特記事項（家族状況）のsetメソッドです。
     * 
     * @param kazokuJokyo 概況特記事項（家族状況）
     */
    public void setKazokuJokyo(RString kazokuJokyo) {
        this.kazokuJokyo = kazokuJokyo;
    }

    /**
     * 概況特記事項（居住環境）のgetメソッドです。
     * 
     * @return 概況特記事項（居住環境）
     */
    @CheckForNull
    public RString getKyojuKankyo() {
        return kyojuKankyo;
    }

    /**
     * 概況特記事項（居住環境）のsetメソッドです。
     * 
     * @param kyojuKankyo 概況特記事項（居住環境）
     */
    public void setKyojuKankyo(RString kyojuKankyo) {
        this.kyojuKankyo = kyojuKankyo;
    }

    /**
     * 概況特記事項（機器・器械）のgetメソッドです。
     * 
     * @return 概況特記事項（機器・器械）
     */
    @CheckForNull
    public RString getKikaiKiki() {
        return kikaiKiki;
    }

    /**
     * 概況特記事項（機器・器械）のsetメソッドです。
     * 
     * @param kikaiKiki 概況特記事項（機器・器械）
     */
    public void setKikaiKiki(RString kikaiKiki) {
        this.kikaiKiki = kikaiKiki;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5206GaikyoTokkiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5206GaikyoTokkiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5206GaikyoTokkiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ninteichosaRirekiNo != other.ninteichosaRirekiNo) {
            return false;
        }
        if (!Objects.equals(this.gaikyoTokkiTextImageKubun, other.gaikyoTokkiTextImageKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5206GaikyoTokkiEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaRirekiNo = entity.ninteichosaRirekiNo;
        this.gaikyoTokkiTextImageKubun = entity.gaikyoTokkiTextImageKubun;
        this.genponMaskKubun = entity.genponMaskKubun;
        this.jutakuKaishu = entity.jutakuKaishu;
        this.tokubetsuKyufuService = entity.tokubetsuKyufuService;
        this.zaitakuService = entity.zaitakuService;
        this.shuso = entity.shuso;
        this.kazokuJokyo = entity.kazokuJokyo;
        this.kyojuKankyo = entity.kyojuKankyo;
        this.kikaiKiki = entity.kikaiKiki;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, gaikyoTokkiTextImageKubun, genponMaskKubun, jutakuKaishu, tokubetsuKyufuService, zaitakuService, shuso, kazokuJokyo, kyojuKankyo, kikaiKiki);
    }

// </editor-fold>

}

package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * DbT4206GaikyoTokkiテーブルのエンティティクラスです。
 */
public class DbT4206GaikyoTokkiEntity extends DbTableEntityBase<DbT4206GaikyoTokkiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4206GaikyoTokki");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private final int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ninteichosaRirekiNo;
    @PrimaryKey
    private RString gaikyoTokkiTextImageKubun;
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
     * shinseishoKanriNoのgetメソッドです。
     *
     * @return shinseishoKanriNo
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * shinseishoKanriNoのsetメソッドです。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(@Nonnull ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * ninteichosaRirekiNoのgetメソッドです。
     *
     * @return ninteichosaRirekiNo
     */
    public int getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /**
     * ninteichosaRirekiNoのsetメソッドです。
     *
     * @param ninteichosaRirekiNo ninteichosaRirekiNo
     */
    public void setNinteichosaRirekiNo(@Nonnull int ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /**
     * gaikyoTokkiTextImageKubunのgetメソッドです。
     *
     * @return gaikyoTokkiTextImageKubun
     */
    public RString getGaikyoTokkiTextImageKubun() {
        return gaikyoTokkiTextImageKubun;
    }

    /**
     * gaikyoTokkiTextImageKubunのsetメソッドです。
     *
     * @param gaikyoTokkiTextImageKubun gaikyoTokkiTextImageKubun
     */
    public void setGaikyoTokkiTextImageKubun(@Nonnull RString gaikyoTokkiTextImageKubun) {
        this.gaikyoTokkiTextImageKubun = gaikyoTokkiTextImageKubun;
    }

    /**
     * jutakuKaishuのgetメソッドです。
     *
     * @return jutakuKaishu
     */
    @CheckForNull
    public RString getJutakuKaishu() {
        return jutakuKaishu;
    }

    /**
     * jutakuKaishuのsetメソッドです。
     *
     * @param jutakuKaishu jutakuKaishu
     */
    public void setJutakuKaishu(RString jutakuKaishu) {
        this.jutakuKaishu = jutakuKaishu;
    }

    /**
     * tokubetsuKyufuServiceのgetメソッドです。
     *
     * @return tokubetsuKyufuService
     */
    @CheckForNull
    public RString getTokubetsuKyufuService() {
        return tokubetsuKyufuService;
    }

    /**
     * tokubetsuKyufuServiceのsetメソッドです。
     *
     * @param tokubetsuKyufuService tokubetsuKyufuService
     */
    public void setTokubetsuKyufuService(RString tokubetsuKyufuService) {
        this.tokubetsuKyufuService = tokubetsuKyufuService;
    }

    /**
     * zaitakuServiceのgetメソッドです。
     *
     * @return zaitakuService
     */
    @CheckForNull
    public RString getZaitakuService() {
        return zaitakuService;
    }

    /**
     * zaitakuServiceのsetメソッドです。
     *
     * @param zaitakuService zaitakuService
     */
    public void setZaitakuService(RString zaitakuService) {
        this.zaitakuService = zaitakuService;
    }

    /**
     * shusoのgetメソッドです。
     *
     * @return shuso
     */
    @CheckForNull
    public RString getShuso() {
        return shuso;
    }

    /**
     * shusoのsetメソッドです。
     *
     * @param shuso shuso
     */
    public void setShuso(RString shuso) {
        this.shuso = shuso;
    }

    /**
     * kazokuJokyoのgetメソッドです。
     *
     * @return kazokuJokyo
     */
    @CheckForNull
    public RString getKazokuJokyo() {
        return kazokuJokyo;
    }

    /**
     * kazokuJokyoのsetメソッドです。
     *
     * @param kazokuJokyo kazokuJokyo
     */
    public void setKazokuJokyo(RString kazokuJokyo) {
        this.kazokuJokyo = kazokuJokyo;
    }

    /**
     * kyojuKankyoのgetメソッドです。
     *
     * @return kyojuKankyo
     */
    @CheckForNull
    public RString getKyojuKankyo() {
        return kyojuKankyo;
    }

    /**
     * kyojuKankyoのsetメソッドです。
     *
     * @param kyojuKankyo kyojuKankyo
     */
    public void setKyojuKankyo(RString kyojuKankyo) {
        this.kyojuKankyo = kyojuKankyo;
    }

    /**
     * kikaiKikiのgetメソッドです。
     *
     * @return kikaiKiki
     */
    @CheckForNull
    public RString getKikaiKiki() {
        return kikaiKiki;
    }

    /**
     * kikaiKikiのsetメソッドです。
     *
     * @param kikaiKiki kikaiKiki
     */
    public void setKikaiKiki(RString kikaiKiki) {
        this.kikaiKiki = kikaiKiki;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4206GaikyoTokkiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4206GaikyoTokkiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4206GaikyoTokkiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ninteichosaRirekiNo != other.ninteichosaRirekiNo) {
            return false;
        }
        return Objects.equals(this.gaikyoTokkiTextImageKubun, other.gaikyoTokkiTextImageKubun);
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(DbT4206GaikyoTokkiEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaRirekiNo = entity.ninteichosaRirekiNo;
        this.gaikyoTokkiTextImageKubun = entity.gaikyoTokkiTextImageKubun;
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
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, gaikyoTokkiTextImageKubun, jutakuKaishu, tokubetsuKyufuService, zaitakuService, shuso, kazokuJokyo, kyojuKankyo, kikaiKiki);
    }

// </editor-fold>
}

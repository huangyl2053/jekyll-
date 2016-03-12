package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 世帯員把握テーブルのエンティティクラスです。
 */
public class DbT2005SetaiHaakuTempEntity extends DbTableEntityBase<DbT2005SetaiHaakuTempEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2005SetaiHaakuTemp");

    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate kijunYMD;
    private FlexibleYear shotokuNendo;
    private RString jushochiTokureiFlag;

    /**
     * hihokenshaNoのgetメソッドです。
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * hihokenshaNoのsetメソッドです。
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * shikibetsuCodeのgetメソッドです。
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * shikibetsuCodeのsetメソッドです。
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * kijunYMDのgetメソッドです。
     *
     * @return kijunYMD
     */
    @CheckForNull
    public FlexibleDate getKijunYMD() {
        return kijunYMD;
    }

    /**
     * kijunYMDのsetメソッドです。
     *
     * @param kijunYMD kijunYMD
     */
    public void setKijunYMD(FlexibleDate kijunYMD) {
        this.kijunYMD = kijunYMD;
    }

    /**
     * shotokuNendoのgetメソッドです。
     *
     * @return shotokuNendo
     */
    @CheckForNull
    public FlexibleYear getShotokuNendo() {
        return shotokuNendo;
    }

    /**
     * shotokuNendoのsetメソッドです。
     *
     * @param shotokuNendo shotokuNendo
     */
    public void setShotokuNendo(FlexibleYear shotokuNendo) {
        this.shotokuNendo = shotokuNendo;
    }

    /**
     * jushochiTokureiFlagのgetメソッドです。
     *
     * @return jushochiTokureiFlag
     */
    @CheckForNull
    public RString getJushochiTokureiFlag() {
        return jushochiTokureiFlag;
    }

    /**
     * jushochiTokureiFlagのsetメソッドです。
     *
     * @param jushochiTokureiFlag jushochiTokureiFlag
     */
    public void setJushochiTokureiFlag(RString jushochiTokureiFlag) {
        this.jushochiTokureiFlag = jushochiTokureiFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2005SetaiHaakuTempEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT2005SetaiHaakuTempEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2005SetaiHaakuTempEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT2005SetaiHaakuTempEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.kijunYMD = entity.kijunYMD;
        this.shotokuNendo = entity.shotokuNendo;
        this.jushochiTokureiFlag = entity.jushochiTokureiFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, shikibetsuCode, kijunYMD, shotokuNendo, jushochiTokureiFlag);
    }

// </editor-fold>
}

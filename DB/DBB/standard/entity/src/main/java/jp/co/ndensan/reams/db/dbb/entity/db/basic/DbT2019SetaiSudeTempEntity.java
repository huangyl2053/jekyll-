package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 世帯員所得情報一時テーブルのエンティティクラスです。
 */
public class DbT2019SetaiSudeTempEntity extends DbTableEntityBase<DbT2019SetaiSudeTempEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2019SetaiSudeTemp");

    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate kijunYMD;
    private FlexibleYear shotokuNendo;
    private RString jushochiTokureiFlag;
    private SetaiCode setaiCode;
    private RString honninKubun;
    private RString kazeiKubun;
    private RString kazeiKubunGemmenGo;
    private RString gekihenKanwaKubun;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkiniShunyuGaku;
    private Decimal nenkiniShotokuGaku;
    private Decimal kazeiShotokuGaku;
    private RString torokuGyomu;

    public DbT2019SetaiSudeTempEntity() {
    }

    public DbT2019SetaiSudeTempEntity(HihokenshaNo hihokenshaNo,
            ShikibetsuCode shikibetsuCode,
            FlexibleDate kijunYMD,
            FlexibleYear shotokuNendo,
            RString jushochiTokureiFlag,
            SetaiCode setaiCode,
            RString honninKubun) {
        this.hihokenshaNo = hihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
        this.kijunYMD = kijunYMD;
        this.shotokuNendo = shotokuNendo;
        this.jushochiTokureiFlag = jushochiTokureiFlag;
        this.setaiCode = setaiCode;
        this.honninKubun = honninKubun;

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
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
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
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 基準年月日のgetメソッドです。
     *
     * @return 基準年月日
     */
    @CheckForNull
    public FlexibleDate getKijunYMD() {
        return kijunYMD;
    }

    /**
     * 基準年月日のsetメソッドです。
     *
     * @param kijunYMD 基準年月日
     */
    public void setKijunYMD(FlexibleDate kijunYMD) {
        this.kijunYMD = kijunYMD;
    }

    /**
     * 所得年度のgetメソッドです。
     *
     * @return 所得年度
     */
    @CheckForNull
    public FlexibleYear getShotokuNendo() {
        return shotokuNendo;
    }

    /**
     * 所得年度のsetメソッドです。
     *
     * @param shotokuNendo 所得年度
     */
    public void setShotokuNendo(FlexibleYear shotokuNendo) {
        this.shotokuNendo = shotokuNendo;
    }

    /**
     * 住所地特例該当のgetメソッドです。
     *
     * @return 住所地特例該当
     */
    @CheckForNull
    public RString getJushochiTokureiFlag() {
        return jushochiTokureiFlag;
    }

    /**
     * 住所地特例該当のsetメソッドです。
     *
     * @param jushochiTokureiFlag 住所地特例該当
     */
    public void setJushochiTokureiFlag(RString jushochiTokureiFlag) {
        this.jushochiTokureiFlag = jushochiTokureiFlag;
    }

    /**
     * 世帯コードのgetメソッドです。
     *
     * @return 世帯コード
     */
    @CheckForNull
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
     * 本人区分のgetメソッドです。
     *
     * @return 本人区分
     */
    @CheckForNull
    public RString getHonninKubun() {
        return honninKubun;
    }

    /**
     * 本人区分のsetメソッドです。
     *
     * @param honninKubun 本人区分
     */
    public void setHonninKubun(RString honninKubun) {
        this.honninKubun = honninKubun;
    }

    /**
     * 課税区分（住民税減免前）のgetメソッドです。
     * <br/>
     * <br/>1：課税　2：非課税　3：未申告　4：調査中　5：課税取消
     * <br/>※保険料賦課の際に参照する
     *
     * @return 課税区分（住民税減免前）
     */
    @CheckForNull
    public RString getKazeiKubun() {
        return kazeiKubun;
    }

    /**
     * 課税区分（住民税減免前）のsetメソッドです。
     * <br/>
     * <br/>1：課税　2：非課税　3：未申告　4：調査中　5：課税取消
     * <br/>※保険料賦課の際に参照する
     *
     * @param kazeiKubun 課税区分（住民税減免前）
     */
    public void setKazeiKubun(RString kazeiKubun) {
        this.kazeiKubun = kazeiKubun;
    }

    /**
     * 課税区分（住民税減免後）のgetメソッドです。
     * <br/>
     * <br/>1：課税　2：非課税　3：未申告　4：調査中　5：課税取消
     * <br/>※給付（高額等）で参照する
     *
     * @return 課税区分（住民税減免後）
     */
    @CheckForNull
    public RString getKazeiKubunGemmenGo() {
        return kazeiKubunGemmenGo;
    }

    /**
     * 課税区分（住民税減免後）のsetメソッドです。
     * <br/>
     * <br/>1：課税　2：非課税　3：未申告　4：調査中　5：課税取消
     * <br/>※給付（高額等）で参照する
     *
     * @param kazeiKubunGemmenGo 課税区分（住民税減免後）
     */
    public void setKazeiKubunGemmenGo(RString kazeiKubunGemmenGo) {
        this.kazeiKubunGemmenGo = kazeiKubunGemmenGo;
    }

    /**
     * 激変緩和措置区分のgetメソッドです。
     *
     * @return 激変緩和措置区分
     */
    @CheckForNull
    public RString getGekihenKanwaKubun() {
        return gekihenKanwaKubun;
    }

    /**
     * 激変緩和措置区分のsetメソッドです。
     *
     * @param gekihenKanwaKubun 激変緩和措置区分
     */
    public void setGekihenKanwaKubun(RString gekihenKanwaKubun) {
        this.gekihenKanwaKubun = gekihenKanwaKubun;
    }

    /**
     * 合計所得金額のgetメソッドです。
     *
     * @return 合計所得金額
     */
    @CheckForNull
    public Decimal getGokeiShotokuGaku() {
        return gokeiShotokuGaku;
    }

    /**
     * 合計所得金額のsetメソッドです。
     *
     * @param gokeiShotokuGaku 合計所得金額
     */
    public void setGokeiShotokuGaku(Decimal gokeiShotokuGaku) {
        this.gokeiShotokuGaku = gokeiShotokuGaku;
    }

    /**
     * 年金収入額のgetメソッドです。
     *
     * @return 年金収入額
     */
    @CheckForNull
    public Decimal getNenkiniShunyuGaku() {
        return nenkiniShunyuGaku;
    }

    /**
     * 年金収入額のsetメソッドです。
     *
     * @param nenkiniShunyuGaku 年金収入額
     */
    public void setNenkiniShunyuGaku(Decimal nenkiniShunyuGaku) {
        this.nenkiniShunyuGaku = nenkiniShunyuGaku;
    }

    /**
     * 年金所得額のgetメソッドです。
     *
     * @return 年金所得額
     */
    @CheckForNull
    public Decimal getNenkiniShotokuGaku() {
        return nenkiniShotokuGaku;
    }

    /**
     * 年金所得額のsetメソッドです。
     *
     * @param nenkiniShotokuGaku 年金所得額
     */
    public void setNenkiniShotokuGaku(Decimal nenkiniShotokuGaku) {
        this.nenkiniShotokuGaku = nenkiniShotokuGaku;
    }

    /**
     * 課税所得額のgetメソッドです。
     *
     * @return 課税所得額
     */
    @CheckForNull
    public Decimal getKazeiShotokuGaku() {
        return kazeiShotokuGaku;
    }

    /**
     * 課税所得額のsetメソッドです。
     *
     * @param kazeiShotokuGaku 課税所得額
     */
    public void setKazeiShotokuGaku(Decimal kazeiShotokuGaku) {
        this.kazeiShotokuGaku = kazeiShotokuGaku;
    }

    /**
     * 登録業務のgetメソッドです。
     *
     * @return 登録業務
     */
    @CheckForNull
    public RString getTorokuGyomu() {
        return torokuGyomu;
    }

    /**
     * 登録業務のsetメソッドです。
     *
     * @param torokuGyomu 登録業務
     */
    public void setTorokuGyomu(RString torokuGyomu) {
        this.torokuGyomu = torokuGyomu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2019SetaiSudeTempEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT2019SetaiSudeTempEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2019SetaiSudeTempEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        return Objects.equals(this.shikibetsuCode, other.shikibetsuCode);
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(DbT2019SetaiSudeTempEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.kijunYMD = entity.kijunYMD;
        this.shotokuNendo = entity.shotokuNendo;
        this.jushochiTokureiFlag = entity.jushochiTokureiFlag;
        this.setaiCode = entity.setaiCode;
        this.honninKubun = entity.honninKubun;
        this.kazeiKubun = entity.kazeiKubun;
        this.kazeiKubunGemmenGo = entity.kazeiKubunGemmenGo;
        this.gekihenKanwaKubun = entity.gekihenKanwaKubun;
        this.gokeiShotokuGaku = entity.gokeiShotokuGaku;
        this.nenkiniShunyuGaku = entity.nenkiniShunyuGaku;
        this.nenkiniShotokuGaku = entity.nenkiniShotokuGaku;
        this.kazeiShotokuGaku = entity.kazeiShotokuGaku;
        this.torokuGyomu = entity.torokuGyomu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, shikibetsuCode, kijunYMD, shotokuNendo, jushochiTokureiFlag, setaiCode, honninKubun, kazeiKubun, kazeiKubunGemmenGo, gekihenKanwaKubun, gokeiShotokuGaku, nenkiniShunyuGaku, nenkiniShotokuGaku, kazeiShotokuGaku, torokuGyomu);
    }

// </editor-fold>
}

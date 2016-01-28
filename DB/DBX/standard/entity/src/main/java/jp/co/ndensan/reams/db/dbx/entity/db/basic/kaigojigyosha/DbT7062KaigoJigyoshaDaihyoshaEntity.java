package jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 介護事業者代表者テーブルのエンティティクラスです。
 * <br/> 介護サービス事業者の代表者を管理します。
 */
public class DbT7062KaigoJigyoshaDaihyoshaEntity extends DbTableEntityBase<DbT7062KaigoJigyoshaDaihyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7062KaigoJigyoshaDaihyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KaigoJigyoshaNo jigyoshaNo;
    @PrimaryKey
    private FlexibleDate yukoKaishiYMD;
    private AtenaMeisho daihyoshaShimei;
    private AtenaKanaMeisho daihyoshaKanaShimei;
    private YubinNo daihyoshaYubinNo;
    private AtenaJusho daihyoshaJusho;
    private RString daihyoshaKanaJusho;
    private RString daihyoshaYakushokuMei;
    private AtenaMeisho kaisetsushaShimei;
    private AtenaKanaMeisho kaisetsushaKanaShimei;
    private YubinNo kaisetsushaYubinNo;
    private AtenaJusho kaisetsushaJusho;
    private RString kaisetsushaKanaJusho;
    private TelNo kaisetsushaTelNo;
    private TelNo kaisetsushaFaxNo;

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
     * 事業者番号のgetメソッドです。
     *
     * @return 事業者番号
     */
    public KaigoJigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     *
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(@Nonnull KaigoJigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 有効開始日のgetメソッドです。
     *
     * @return 有効開始日
     */
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * 有効開始日のsetメソッドです。
     *
     * @param yukoKaishiYMD 有効開始日
     */
    public void setYukoKaishiYMD(@Nonnull FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * 代表者名のgetメソッドです。
     *
     * @return 代表者名
     */
    public AtenaMeisho getDaihyoshaShimei() {
        return daihyoshaShimei;
    }

    /**
     * 代表者名のsetメソッドです。
     *
     * @param daihyoshaShimei 代表者名
     */
    public void setDaihyoshaShimei(@Nonnull AtenaMeisho daihyoshaShimei) {
        this.daihyoshaShimei = daihyoshaShimei;
    }

    /**
     * 代表者名カナのgetメソッドです。
     *
     * @return 代表者名カナ
     */
    public AtenaKanaMeisho getDaihyoshaKanaShimei() {
        return daihyoshaKanaShimei;
    }

    /**
     * 代表者名カナのsetメソッドです。
     *
     * @param daihyoshaKanaShimei 代表者名カナ
     */
    public void setDaihyoshaKanaShimei(@Nonnull AtenaKanaMeisho daihyoshaKanaShimei) {
        this.daihyoshaKanaShimei = daihyoshaKanaShimei;
    }

    /**
     * 代表者郵便番号のgetメソッドです。
     *
     * @return 代表者郵便番号
     */
    @CheckForNull
    public YubinNo getDaihyoshaYubinNo() {
        return daihyoshaYubinNo;
    }

    /**
     * 代表者郵便番号のsetメソッドです。
     *
     * @param daihyoshaYubinNo 代表者郵便番号
     */
    public void setDaihyoshaYubinNo(YubinNo daihyoshaYubinNo) {
        this.daihyoshaYubinNo = daihyoshaYubinNo;
    }

    /**
     * 代表者住所のgetメソッドです。
     *
     * @return 代表者住所
     */
    @CheckForNull
    public AtenaJusho getDaihyoshaJusho() {
        return daihyoshaJusho;
    }

    /**
     * 代表者住所のsetメソッドです。
     *
     * @param daihyoshaJusho 代表者住所
     */
    public void setDaihyoshaJusho(AtenaJusho daihyoshaJusho) {
        this.daihyoshaJusho = daihyoshaJusho;
    }

    /**
     * 代表者住所カナのgetメソッドです。
     *
     * @return 代表者住所カナ
     */
    @CheckForNull
    public RString getDaihyoshaKanaJusho() {
        return daihyoshaKanaJusho;
    }

    /**
     * 代表者住所カナのsetメソッドです。
     *
     * @param daihyoshaKanaJusho 代表者住所カナ
     */
    public void setDaihyoshaKanaJusho(RString daihyoshaKanaJusho) {
        this.daihyoshaKanaJusho = daihyoshaKanaJusho;
    }

    /**
     * 代表者役職名のgetメソッドです。
     *
     * @return 代表者役職名
     */
    @CheckForNull
    public RString getDaihyoshaYakushokuMei() {
        return daihyoshaYakushokuMei;
    }

    /**
     * 代表者役職名のsetメソッドです。
     *
     * @param daihyoshaYakushokuMei 代表者役職名
     */
    public void setDaihyoshaYakushokuMei(RString daihyoshaYakushokuMei) {
        this.daihyoshaYakushokuMei = daihyoshaYakushokuMei;
    }

    /**
     * 開設者名称のgetメソッドです。
     *
     * @return 開設者名称
     */
    @CheckForNull
    public AtenaMeisho getKaisetsushaShimei() {
        return kaisetsushaShimei;
    }

    /**
     * 開設者名称のsetメソッドです。
     *
     * @param kaisetsushaShimei 開設者名称
     */
    public void setKaisetsushaShimei(AtenaMeisho kaisetsushaShimei) {
        this.kaisetsushaShimei = kaisetsushaShimei;
    }

    /**
     * 開設者名称カナのgetメソッドです。
     *
     * @return 開設者名称カナ
     */
    @CheckForNull
    public AtenaKanaMeisho getKaisetsushaKanaShimei() {
        return kaisetsushaKanaShimei;
    }

    /**
     * 開設者名称カナのsetメソッドです。
     *
     * @param kaisetsushaKanaShimei 開設者名称カナ
     */
    public void setKaisetsushaKanaShimei(AtenaKanaMeisho kaisetsushaKanaShimei) {
        this.kaisetsushaKanaShimei = kaisetsushaKanaShimei;
    }

    /**
     * 開設者郵便番号のgetメソッドです。
     *
     * @return 開設者郵便番号
     */
    @CheckForNull
    public YubinNo getKaisetsushaYubinNo() {
        return kaisetsushaYubinNo;
    }

    /**
     * 開設者郵便番号のsetメソッドです。
     *
     * @param kaisetsushaYubinNo 開設者郵便番号
     */
    public void setKaisetsushaYubinNo(YubinNo kaisetsushaYubinNo) {
        this.kaisetsushaYubinNo = kaisetsushaYubinNo;
    }

    /**
     * 開設者住所のgetメソッドです。
     *
     * @return 開設者住所
     */
    @CheckForNull
    public AtenaJusho getKaisetsushaJusho() {
        return kaisetsushaJusho;
    }

    /**
     * 開設者住所のsetメソッドです。
     *
     * @param kaisetsushaJusho 開設者住所
     */
    public void setKaisetsushaJusho(AtenaJusho kaisetsushaJusho) {
        this.kaisetsushaJusho = kaisetsushaJusho;
    }

    /**
     * 開設者住所カナのgetメソッドです。
     *
     * @return 開設者住所カナ
     */
    @CheckForNull
    public RString getKaisetsushaKanaJusho() {
        return kaisetsushaKanaJusho;
    }

    /**
     * 開設者住所カナのsetメソッドです。
     *
     * @param kaisetsushaKanaJusho 開設者住所カナ
     */
    public void setKaisetsushaKanaJusho(RString kaisetsushaKanaJusho) {
        this.kaisetsushaKanaJusho = kaisetsushaKanaJusho;
    }

    /**
     * 開設者電話番号のgetメソッドです。
     *
     * @return 開設者電話番号
     */
    @CheckForNull
    public TelNo getKaisetsushaTelNo() {
        return kaisetsushaTelNo;
    }

    /**
     * 開設者電話番号のsetメソッドです。
     *
     * @param kaisetsushaTelNo 開設者電話番号
     */
    public void setKaisetsushaTelNo(TelNo kaisetsushaTelNo) {
        this.kaisetsushaTelNo = kaisetsushaTelNo;
    }

    /**
     * 開設者ＦＡＸ番号のgetメソッドです。
     *
     * @return 開設者ＦＡＸ番号
     */
    @CheckForNull
    public TelNo getKaisetsushaFaxNo() {
        return kaisetsushaFaxNo;
    }

    /**
     * 開設者ＦＡＸ番号のsetメソッドです。
     *
     * @param kaisetsushaFaxNo 開設者ＦＡＸ番号
     */
    public void setKaisetsushaFaxNo(TelNo kaisetsushaFaxNo) {
        this.kaisetsushaFaxNo = kaisetsushaFaxNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7062KaigoJigyoshaDaihyoshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7062KaigoJigyoshaDaihyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7062KaigoJigyoshaDaihyoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yukoKaishiYMD, other.yukoKaishiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(DbT7062KaigoJigyoshaDaihyoshaEntity entity) {
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yukoKaishiYMD = entity.yukoKaishiYMD;
        this.daihyoshaShimei = entity.daihyoshaShimei;
        this.daihyoshaKanaShimei = entity.daihyoshaKanaShimei;
        this.daihyoshaYubinNo = entity.daihyoshaYubinNo;
        this.daihyoshaJusho = entity.daihyoshaJusho;
        this.daihyoshaKanaJusho = entity.daihyoshaKanaJusho;
        this.daihyoshaYakushokuMei = entity.daihyoshaYakushokuMei;
        this.kaisetsushaShimei = entity.kaisetsushaShimei;
        this.kaisetsushaKanaShimei = entity.kaisetsushaKanaShimei;
        this.kaisetsushaYubinNo = entity.kaisetsushaYubinNo;
        this.kaisetsushaJusho = entity.kaisetsushaJusho;
        this.kaisetsushaKanaJusho = entity.kaisetsushaKanaJusho;
        this.kaisetsushaTelNo = entity.kaisetsushaTelNo;
        this.kaisetsushaFaxNo = entity.kaisetsushaFaxNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaNo, yukoKaishiYMD, daihyoshaShimei, daihyoshaKanaShimei, daihyoshaYubinNo, daihyoshaJusho, daihyoshaKanaJusho, daihyoshaYakushokuMei, kaisetsushaShimei, kaisetsushaKanaShimei, kaisetsushaYubinNo, kaisetsushaJusho, kaisetsushaKanaJusho, kaisetsushaTelNo, kaisetsushaFaxNo);
    }

// </editor-fold>
}

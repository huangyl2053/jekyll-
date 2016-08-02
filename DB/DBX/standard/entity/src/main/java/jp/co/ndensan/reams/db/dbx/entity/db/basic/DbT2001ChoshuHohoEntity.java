package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 介護徴収方法テーブルのエンティティクラスです。
 */
public class DbT2001ChoshuHohoEntity extends DbTableEntityBase<DbT2001ChoshuHohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2001ChoshuHoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear fukaNendo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    private RString choshuHoho4gatsu;
    private RString choshuHoho5gatsu;
    private RString choshuHoho6gatsu;
    private RString choshuHoho7gatsu;
    private RString choshuHoho8gatsu;
    private RString choshuHoho9gatsu;
    private RString choshuHoho10gatsu;
    private RString choshuHoho11gatsu;
    private RString choshuHoho12gatsu;
    private RString choshuHoho1gatsu;
    private RString choshuHoho2gatsu;
    private RString choshuHoho3gatsu;
    private RString choshuHohoYoku4gatsu;
    private RString choshuHohoYoku5gatsu;
    private RString choshuHohoYoku6gatsu;
    private RString choshuHohoYoku7gatsu;
    private RString choshuHohoYoku8gatsu;
    private RString choshuHohoYoku9gatsu;
    private RString kariNenkinNo;
    private RString kariNenkinCode;
    private RString kariHosokuM;
    private RString honNenkinNo;
    private RString honNenkinCode;
    private RString honHosokuM;
    private RString yokunendoKariNenkinNo;
    private RString yokunendoKariNenkinCode;
    private RString yokunendoKariHosokuM;
    private boolean iraiSohuzumiFlag;
    private boolean tsuikaIraiSohuzumiFlag;
    private YMDHMS tokuchoTeishiNichiji;
    private RString tokuchoTeishiJiyuCode;

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
     * 賦課年度のgetメソッドです。
     *
     * @return 賦課年度
     */
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * 賦課年度のsetメソッドです。
     *
     * @param fukaNendo 賦課年度
     */
    public void setFukaNendo(@Nonnull FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
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
     * 徴収方法4月のgetメソッドです。
     *
     * @return 徴収方法4月
     */
    @CheckForNull
    public RString getChoshuHoho4gatsu() {
        return choshuHoho4gatsu;
    }

    /**
     * 徴収方法4月のsetメソッドです。
     *
     * @param choshuHoho4gatsu 徴収方法4月
     */
    public void setChoshuHoho4gatsu(RString choshuHoho4gatsu) {
        this.choshuHoho4gatsu = choshuHoho4gatsu;
    }

    /**
     * 徴収方法5月のgetメソッドです。
     *
     * @return 徴収方法5月
     */
    @CheckForNull
    public RString getChoshuHoho5gatsu() {
        return choshuHoho5gatsu;
    }

    /**
     * 徴収方法5月のsetメソッドです。
     *
     * @param choshuHoho5gatsu 徴収方法5月
     */
    public void setChoshuHoho5gatsu(RString choshuHoho5gatsu) {
        this.choshuHoho5gatsu = choshuHoho5gatsu;
    }

    /**
     * 徴収方法6月のgetメソッドです。
     *
     * @return 徴収方法6月
     */
    @CheckForNull
    public RString getChoshuHoho6gatsu() {
        return choshuHoho6gatsu;
    }

    /**
     * 徴収方法6月のsetメソッドです。
     *
     * @param choshuHoho6gatsu 徴収方法6月
     */
    public void setChoshuHoho6gatsu(RString choshuHoho6gatsu) {
        this.choshuHoho6gatsu = choshuHoho6gatsu;
    }

    /**
     * 徴収方法7月のgetメソッドです。
     *
     * @return 徴収方法7月
     */
    @CheckForNull
    public RString getChoshuHoho7gatsu() {
        return choshuHoho7gatsu;
    }

    /**
     * 徴収方法7月のsetメソッドです。
     *
     * @param choshuHoho7gatsu 徴収方法7月
     */
    public void setChoshuHoho7gatsu(RString choshuHoho7gatsu) {
        this.choshuHoho7gatsu = choshuHoho7gatsu;
    }

    /**
     * 徴収方法8月のgetメソッドです。
     *
     * @return 徴収方法8月
     */
    @CheckForNull
    public RString getChoshuHoho8gatsu() {
        return choshuHoho8gatsu;
    }

    /**
     * 徴収方法8月のsetメソッドです。
     *
     * @param choshuHoho8gatsu 徴収方法8月
     */
    public void setChoshuHoho8gatsu(RString choshuHoho8gatsu) {
        this.choshuHoho8gatsu = choshuHoho8gatsu;
    }

    /**
     * 徴収方法9月のgetメソッドです。
     *
     * @return 徴収方法9月
     */
    @CheckForNull
    public RString getChoshuHoho9gatsu() {
        return choshuHoho9gatsu;
    }

    /**
     * 徴収方法9月のsetメソッドです。
     *
     * @param choshuHoho9gatsu 徴収方法9月
     */
    public void setChoshuHoho9gatsu(RString choshuHoho9gatsu) {
        this.choshuHoho9gatsu = choshuHoho9gatsu;
    }

    /**
     * 徴収方法10月のgetメソッドです。
     *
     * @return 徴収方法10月
     */
    @CheckForNull
    public RString getChoshuHoho10gatsu() {
        return choshuHoho10gatsu;
    }

    /**
     * 徴収方法10月のsetメソッドです。
     *
     * @param choshuHoho10gatsu 徴収方法10月
     */
    public void setChoshuHoho10gatsu(RString choshuHoho10gatsu) {
        this.choshuHoho10gatsu = choshuHoho10gatsu;
    }

    /**
     * 徴収方法11月のgetメソッドです。
     *
     * @return 徴収方法11月
     */
    @CheckForNull
    public RString getChoshuHoho11gatsu() {
        return choshuHoho11gatsu;
    }

    /**
     * 徴収方法11月のsetメソッドです。
     *
     * @param choshuHoho11gatsu 徴収方法11月
     */
    public void setChoshuHoho11gatsu(RString choshuHoho11gatsu) {
        this.choshuHoho11gatsu = choshuHoho11gatsu;
    }

    /**
     * 徴収方法12月のgetメソッドです。
     *
     * @return 徴収方法12月
     */
    @CheckForNull
    public RString getChoshuHoho12gatsu() {
        return choshuHoho12gatsu;
    }

    /**
     * 徴収方法12月のsetメソッドです。
     *
     * @param choshuHoho12gatsu 徴収方法12月
     */
    public void setChoshuHoho12gatsu(RString choshuHoho12gatsu) {
        this.choshuHoho12gatsu = choshuHoho12gatsu;
    }

    /**
     * 徴収方法1月のgetメソッドです。
     *
     * @return 徴収方法1月
     */
    @CheckForNull
    public RString getChoshuHoho1gatsu() {
        return choshuHoho1gatsu;
    }

    /**
     * 徴収方法1月のsetメソッドです。
     *
     * @param choshuHoho1gatsu 徴収方法1月
     */
    public void setChoshuHoho1gatsu(RString choshuHoho1gatsu) {
        this.choshuHoho1gatsu = choshuHoho1gatsu;
    }

    /**
     * 徴収方法2月のgetメソッドです。
     *
     * @return 徴収方法2月
     */
    @CheckForNull
    public RString getChoshuHoho2gatsu() {
        return choshuHoho2gatsu;
    }

    /**
     * 徴収方法2月のsetメソッドです。
     *
     * @param choshuHoho2gatsu 徴収方法2月
     */
    public void setChoshuHoho2gatsu(RString choshuHoho2gatsu) {
        this.choshuHoho2gatsu = choshuHoho2gatsu;
    }

    /**
     * 徴収方法3月のgetメソッドです。
     *
     * @return 徴収方法3月
     */
    @CheckForNull
    public RString getChoshuHoho3gatsu() {
        return choshuHoho3gatsu;
    }

    /**
     * 徴収方法3月のsetメソッドです。
     *
     * @param choshuHoho3gatsu 徴収方法3月
     */
    public void setChoshuHoho3gatsu(RString choshuHoho3gatsu) {
        this.choshuHoho3gatsu = choshuHoho3gatsu;
    }

    /**
     * 徴収方法翌4月のgetメソッドです。
     *
     * @return 徴収方法翌4月
     */
    @CheckForNull
    public RString getChoshuHohoYoku4gatsu() {
        return choshuHohoYoku4gatsu;
    }

    /**
     * 徴収方法翌4月のsetメソッドです。
     *
     * @param choshuHohoYoku4gatsu 徴収方法翌4月
     */
    public void setChoshuHohoYoku4gatsu(RString choshuHohoYoku4gatsu) {
        this.choshuHohoYoku4gatsu = choshuHohoYoku4gatsu;
    }

    /**
     * 徴収方法翌5月のgetメソッドです。
     *
     * @return 徴収方法翌5月
     */
    @CheckForNull
    public RString getChoshuHohoYoku5gatsu() {
        return choshuHohoYoku5gatsu;
    }

    /**
     * 徴収方法翌5月のsetメソッドです。
     *
     * @param choshuHohoYoku5gatsu 徴収方法翌5月
     */
    public void setChoshuHohoYoku5gatsu(RString choshuHohoYoku5gatsu) {
        this.choshuHohoYoku5gatsu = choshuHohoYoku5gatsu;
    }

    /**
     * 徴収方法翌6月のgetメソッドです。
     *
     * @return 徴収方法翌6月
     */
    @CheckForNull
    public RString getChoshuHohoYoku6gatsu() {
        return choshuHohoYoku6gatsu;
    }

    /**
     * 徴収方法翌6月のsetメソッドです。
     *
     * @param choshuHohoYoku6gatsu 徴収方法翌6月
     */
    public void setChoshuHohoYoku6gatsu(RString choshuHohoYoku6gatsu) {
        this.choshuHohoYoku6gatsu = choshuHohoYoku6gatsu;
    }

    /**
     * 徴収方法翌7月のgetメソッドです。
     *
     * @return 徴収方法翌7月
     */
    @CheckForNull
    public RString getChoshuHohoYoku7gatsu() {
        return choshuHohoYoku7gatsu;
    }

    /**
     * 徴収方法翌7月のsetメソッドです。
     *
     * @param choshuHohoYoku7gatsu 徴収方法翌7月
     */
    public void setChoshuHohoYoku7gatsu(RString choshuHohoYoku7gatsu) {
        this.choshuHohoYoku7gatsu = choshuHohoYoku7gatsu;
    }

    /**
     * 徴収方法翌8月のgetメソッドです。
     *
     * @return 徴収方法翌8月
     */
    @CheckForNull
    public RString getChoshuHohoYoku8gatsu() {
        return choshuHohoYoku8gatsu;
    }

    /**
     * 徴収方法翌8月のsetメソッドです。
     *
     * @param choshuHohoYoku8gatsu 徴収方法翌8月
     */
    public void setChoshuHohoYoku8gatsu(RString choshuHohoYoku8gatsu) {
        this.choshuHohoYoku8gatsu = choshuHohoYoku8gatsu;
    }

    /**
     * 徴収方法翌9月のgetメソッドです。
     *
     * @return 徴収方法翌9月
     */
    @CheckForNull
    public RString getChoshuHohoYoku9gatsu() {
        return choshuHohoYoku9gatsu;
    }

    /**
     * 徴収方法翌9月のsetメソッドです。
     *
     * @param choshuHohoYoku9gatsu 徴収方法翌9月
     */
    public void setChoshuHohoYoku9gatsu(RString choshuHohoYoku9gatsu) {
        this.choshuHohoYoku9gatsu = choshuHohoYoku9gatsu;
    }

    /**
     * 仮徴収・基礎年金番号のgetメソッドです。
     *
     * @return 仮徴収・基礎年金番号
     */
    @CheckForNull
    public RString getKariNenkinNo() {
        return kariNenkinNo;
    }

    /**
     * 仮徴収・基礎年金番号のsetメソッドです。
     *
     * @param kariNenkinNo 仮徴収・基礎年金番号
     */
    public void setKariNenkinNo(RString kariNenkinNo) {
        this.kariNenkinNo = kariNenkinNo;
    }

    /**
     * 仮徴収・年金コードのgetメソッドです。
     *
     * @return 仮徴収・年金コード
     */
    @CheckForNull
    public RString getKariNenkinCode() {
        return kariNenkinCode;
    }

    /**
     * 仮徴収・年金コードのsetメソッドです。
     *
     * @param kariNenkinCode 仮徴収・年金コード
     */
    public void setKariNenkinCode(RString kariNenkinCode) {
        this.kariNenkinCode = kariNenkinCode;
    }

    /**
     * 仮徴収・捕捉月のgetメソッドです。
     *
     * @return 仮徴収・捕捉月
     */
    @CheckForNull
    public RString getKariHosokuM() {
        return kariHosokuM;
    }

    /**
     * 仮徴収・捕捉月のsetメソッドです。
     *
     * @param kariHosokuM 仮徴収・捕捉月
     */
    public void setKariHosokuM(RString kariHosokuM) {
        this.kariHosokuM = kariHosokuM;
    }

    /**
     * 本徴収・基礎年金番号のgetメソッドです。
     *
     * @return 本徴収・基礎年金番号
     */
    @CheckForNull
    public RString getHonNenkinNo() {
        return honNenkinNo;
    }

    /**
     * 本徴収・基礎年金番号のsetメソッドです。
     *
     * @param honNenkinNo 本徴収・基礎年金番号
     */
    public void setHonNenkinNo(RString honNenkinNo) {
        this.honNenkinNo = honNenkinNo;
    }

    /**
     * 本徴収・年金コードのgetメソッドです。
     *
     * @return 本徴収・年金コード
     */
    @CheckForNull
    public RString getHonNenkinCode() {
        return honNenkinCode;
    }

    /**
     * 本徴収・年金コードのsetメソッドです。
     *
     * @param honNenkinCode 本徴収・年金コード
     */
    public void setHonNenkinCode(RString honNenkinCode) {
        this.honNenkinCode = honNenkinCode;
    }

    /**
     * 本徴収・捕捉月のgetメソッドです。
     *
     * @return 本徴収・捕捉月
     */
    @CheckForNull
    public RString getHonHosokuM() {
        return honHosokuM;
    }

    /**
     * 本徴収・捕捉月のsetメソッドです。
     *
     * @param honHosokuM 本徴収・捕捉月
     */
    public void setHonHosokuM(RString honHosokuM) {
        this.honHosokuM = honHosokuM;
    }

    /**
     * 翌年度仮徴収・基礎年金番号のgetメソッドです。
     *
     * @return 翌年度仮徴収・基礎年金番号
     */
    @CheckForNull
    public RString getYokunendoKariNenkinNo() {
        return yokunendoKariNenkinNo;
    }

    /**
     * 翌年度仮徴収・基礎年金番号のsetメソッドです。
     *
     * @param yokunendoKariNenkinNo 翌年度仮徴収・基礎年金番号
     */
    public void setYokunendoKariNenkinNo(RString yokunendoKariNenkinNo) {
        this.yokunendoKariNenkinNo = yokunendoKariNenkinNo;
    }

    /**
     * 翌年度仮徴収・年金コードのgetメソッドです。
     *
     * @return 翌年度仮徴収・年金コード
     */
    @CheckForNull
    public RString getYokunendoKariNenkinCode() {
        return yokunendoKariNenkinCode;
    }

    /**
     * 翌年度仮徴収・年金コードのsetメソッドです。
     *
     * @param yokunendoKariNenkinCode 翌年度仮徴収・年金コード
     */
    public void setYokunendoKariNenkinCode(RString yokunendoKariNenkinCode) {
        this.yokunendoKariNenkinCode = yokunendoKariNenkinCode;
    }

    /**
     * 翌年度仮徴収・捕捉月のgetメソッドです。
     *
     * @return 翌年度仮徴収・捕捉月
     */
    @CheckForNull
    public RString getYokunendoKariHosokuM() {
        return yokunendoKariHosokuM;
    }

    /**
     * 翌年度仮徴収・捕捉月のsetメソッドです。
     *
     * @param yokunendoKariHosokuM 翌年度仮徴収・捕捉月
     */
    public void setYokunendoKariHosokuM(RString yokunendoKariHosokuM) {
        this.yokunendoKariHosokuM = yokunendoKariHosokuM;
    }

    /**
     * 依頼情報送付済みフラグのgetメソッドです。
     *
     * @return 依頼情報送付済みフラグ
     */
    @CheckForNull
    public boolean getIraiSohuzumiFlag() {
        return iraiSohuzumiFlag;
    }

    /**
     * 依頼情報送付済みフラグのsetメソッドです。
     *
     * @param iraiSohuzumiFlag 依頼情報送付済みフラグ
     */
    public void setIraiSohuzumiFlag(boolean iraiSohuzumiFlag) {
        this.iraiSohuzumiFlag = iraiSohuzumiFlag;
    }

    /**
     * 追加依頼情報送付済みフラグのgetメソッドです。
     *
     * @return 追加依頼情報送付済みフラグ
     */
    @CheckForNull
    public boolean getTsuikaIraiSohuzumiFlag() {
        return tsuikaIraiSohuzumiFlag;
    }

    /**
     * 追加依頼情報送付済みフラグのsetメソッドです。
     *
     * @param tsuikaIraiSohuzumiFlag 追加依頼情報送付済みフラグ
     */
    public void setTsuikaIraiSohuzumiFlag(boolean tsuikaIraiSohuzumiFlag) {
        this.tsuikaIraiSohuzumiFlag = tsuikaIraiSohuzumiFlag;
    }

    /**
     * 特別徴収停止日時のgetメソッドです。
     *
     * @return 特別徴収停止日時
     */
    @CheckForNull
    public YMDHMS getTokuchoTeishiNichiji() {
        return tokuchoTeishiNichiji;
    }

    /**
     * 特別徴収停止日時のsetメソッドです。
     *
     * @param tokuchoTeishiNichiji 特別徴収停止日時
     */
    public void setTokuchoTeishiNichiji(YMDHMS tokuchoTeishiNichiji) {
        this.tokuchoTeishiNichiji = tokuchoTeishiNichiji;
    }

    /**
     * 特別徴収停止事由コードのgetメソッドです。
     *
     * @return 特別徴収停止事由コード
     */
    @CheckForNull
    public RString getTokuchoTeishiJiyuCode() {
        return tokuchoTeishiJiyuCode;
    }

    /**
     * 特別徴収停止事由コードのsetメソッドです。
     *
     * @param tokuchoTeishiJiyuCode 特別徴収停止事由コード
     */
    public void setTokuchoTeishiJiyuCode(RString tokuchoTeishiJiyuCode) {
        this.tokuchoTeishiJiyuCode = tokuchoTeishiJiyuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2001ChoshuHohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2001ChoshuHohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2001ChoshuHohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.fukaNendo, other.fukaNendo)) {
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
    public void shallowCopy(DbT2001ChoshuHohoEntity entity) {
        this.fukaNendo = entity.fukaNendo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.choshuHoho4gatsu = entity.choshuHoho4gatsu;
        this.choshuHoho5gatsu = entity.choshuHoho5gatsu;
        this.choshuHoho6gatsu = entity.choshuHoho6gatsu;
        this.choshuHoho7gatsu = entity.choshuHoho7gatsu;
        this.choshuHoho8gatsu = entity.choshuHoho8gatsu;
        this.choshuHoho9gatsu = entity.choshuHoho9gatsu;
        this.choshuHoho10gatsu = entity.choshuHoho10gatsu;
        this.choshuHoho11gatsu = entity.choshuHoho11gatsu;
        this.choshuHoho12gatsu = entity.choshuHoho12gatsu;
        this.choshuHoho1gatsu = entity.choshuHoho1gatsu;
        this.choshuHoho2gatsu = entity.choshuHoho2gatsu;
        this.choshuHoho3gatsu = entity.choshuHoho3gatsu;
        this.choshuHohoYoku4gatsu = entity.choshuHohoYoku4gatsu;
        this.choshuHohoYoku5gatsu = entity.choshuHohoYoku5gatsu;
        this.choshuHohoYoku6gatsu = entity.choshuHohoYoku6gatsu;
        this.choshuHohoYoku7gatsu = entity.choshuHohoYoku7gatsu;
        this.choshuHohoYoku8gatsu = entity.choshuHohoYoku8gatsu;
        this.choshuHohoYoku9gatsu = entity.choshuHohoYoku9gatsu;
        this.kariNenkinNo = entity.kariNenkinNo;
        this.kariNenkinCode = entity.kariNenkinCode;
        this.kariHosokuM = entity.kariHosokuM;
        this.honNenkinNo = entity.honNenkinNo;
        this.honNenkinCode = entity.honNenkinCode;
        this.honHosokuM = entity.honHosokuM;
        this.yokunendoKariNenkinNo = entity.yokunendoKariNenkinNo;
        this.yokunendoKariNenkinCode = entity.yokunendoKariNenkinCode;
        this.yokunendoKariHosokuM = entity.yokunendoKariHosokuM;
        this.iraiSohuzumiFlag = entity.iraiSohuzumiFlag;
        this.tsuikaIraiSohuzumiFlag = entity.tsuikaIraiSohuzumiFlag;
        this.tokuchoTeishiNichiji = entity.tokuchoTeishiNichiji;
        this.tokuchoTeishiJiyuCode = entity.tokuchoTeishiJiyuCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(fukaNendo, hihokenshaNo, rirekiNo, choshuHoho4gatsu, choshuHoho5gatsu, choshuHoho6gatsu, choshuHoho7gatsu, choshuHoho8gatsu, choshuHoho9gatsu, choshuHoho10gatsu, choshuHoho11gatsu, choshuHoho12gatsu, choshuHoho1gatsu, choshuHoho2gatsu, choshuHoho3gatsu, choshuHohoYoku4gatsu, choshuHohoYoku5gatsu, choshuHohoYoku6gatsu, choshuHohoYoku7gatsu, choshuHohoYoku8gatsu, choshuHohoYoku9gatsu, kariNenkinNo, kariNenkinCode, kariHosokuM, honNenkinNo, honNenkinCode, honHosokuM, yokunendoKariNenkinNo, yokunendoKariNenkinCode, yokunendoKariHosokuM, iraiSohuzumiFlag, tsuikaIraiSohuzumiFlag, tokuchoTeishiNichiji, tokuchoTeishiJiyuCode);
    }

// </editor-fold>
}

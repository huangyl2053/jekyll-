package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;

/**
 * 介護第三者行為求償テーブルのエンティティクラスです。
 */
public class DbT3082DaisanshaKoiKyushoEntity extends DbTableEntityBase<DbT3082DaisanshaKoiKyushoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3082DaisanshaKoiKyusho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private DbUDD002HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString todokedeKanriNo;
    @PrimaryKey
    private RString kyushoSeikyuNo;
    @PrimaryKey
    private int rirekiNo;
    private Decimal kyufuGakuGokei;
    private Decimal kashitsuSosatsuGaku;
    private Decimal hokenKyufuSeikyuGaku;
    private FlexibleDate songaiBaishoKinNonyuYMD;
    private YubinNo seikyusakiYubinNo;
    private RString seikyusakiJusho;
    private AtenaMeisho seikyusakiMeisho;
    private RString seikyusakiBusho;
    private AtenaMeisho seikyusakiTantosha;
    private TelNo seikyusakiTelNo;

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
    public DbUDD002HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(DbUDD002HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 第三者行為届出管理番号のgetメソッドです。
     * 
     * @return 第三者行為届出管理番号
     */
    public RString getTodokedeKanriNo() {
        return todokedeKanriNo;
    }

    /**
     * 第三者行為届出管理番号のsetメソッドです。
     * 
     * @param todokedeKanriNo 第三者行為届出管理番号
     */
    public void setTodokedeKanriNo(RString todokedeKanriNo) {
        this.todokedeKanriNo = todokedeKanriNo;
    }

    /**
     * 第三者行為求償請求番号のgetメソッドです。
     * 
     * @return 第三者行為求償請求番号
     */
    public RString getKyushoSeikyuNo() {
        return kyushoSeikyuNo;
    }

    /**
     * 第三者行為求償請求番号のsetメソッドです。
     * 
     * @param kyushoSeikyuNo 第三者行為求償請求番号
     */
    public void setKyushoSeikyuNo(RString kyushoSeikyuNo) {
        this.kyushoSeikyuNo = kyushoSeikyuNo;
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
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 給付額合計のgetメソッドです。
     * 
     * @return 給付額合計
     */
    public Decimal getKyufuGakuGokei() {
        return kyufuGakuGokei;
    }

    /**
     * 給付額合計のsetメソッドです。
     * 
     * @param kyufuGakuGokei 給付額合計
     */
    public void setKyufuGakuGokei(Decimal kyufuGakuGokei) {
        this.kyufuGakuGokei = kyufuGakuGokei;
    }

    /**
     * 過失相殺額のgetメソッドです。
     * 
     * @return 過失相殺額
     */
    public Decimal getKashitsuSosatsuGaku() {
        return kashitsuSosatsuGaku;
    }

    /**
     * 過失相殺額のsetメソッドです。
     * 
     * @param kashitsuSosatsuGaku 過失相殺額
     */
    public void setKashitsuSosatsuGaku(Decimal kashitsuSosatsuGaku) {
        this.kashitsuSosatsuGaku = kashitsuSosatsuGaku;
    }

    /**
     * 保険給付請求額のgetメソッドです。
     * 
     * @return 保険給付請求額
     */
    public Decimal getHokenKyufuSeikyuGaku() {
        return hokenKyufuSeikyuGaku;
    }

    /**
     * 保険給付請求額のsetメソッドです。
     * 
     * @param hokenKyufuSeikyuGaku 保険給付請求額
     */
    public void setHokenKyufuSeikyuGaku(Decimal hokenKyufuSeikyuGaku) {
        this.hokenKyufuSeikyuGaku = hokenKyufuSeikyuGaku;
    }

    /**
     * 損害賠償金納入期限のgetメソッドです。
     * 
     * @return 損害賠償金納入期限
     */
    public FlexibleDate getSongaiBaishoKinNonyuYMD() {
        return songaiBaishoKinNonyuYMD;
    }

    /**
     * 損害賠償金納入期限のsetメソッドです。
     * 
     * @param songaiBaishoKinNonyuYMD 損害賠償金納入期限
     */
    public void setSongaiBaishoKinNonyuYMD(FlexibleDate songaiBaishoKinNonyuYMD) {
        this.songaiBaishoKinNonyuYMD = songaiBaishoKinNonyuYMD;
    }

    /**
     * 請求先郵便番号のgetメソッドです。
     * 
     * @return 請求先郵便番号
     */
    public YubinNo getSeikyusakiYubinNo() {
        return seikyusakiYubinNo;
    }

    /**
     * 請求先郵便番号のsetメソッドです。
     * 
     * @param seikyusakiYubinNo 請求先郵便番号
     */
    public void setSeikyusakiYubinNo(YubinNo seikyusakiYubinNo) {
        this.seikyusakiYubinNo = seikyusakiYubinNo;
    }

    /**
     * 請求先住所のgetメソッドです。
     * 
     * @return 請求先住所
     */
    public RString getSeikyusakiJusho() {
        return seikyusakiJusho;
    }

    /**
     * 請求先住所のsetメソッドです。
     * 
     * @param seikyusakiJusho 請求先住所
     */
    public void setSeikyusakiJusho(RString seikyusakiJusho) {
        this.seikyusakiJusho = seikyusakiJusho;
    }

    /**
     * 請求先名称のgetメソッドです。
     * 
     * @return 請求先名称
     */
    public AtenaMeisho getSeikyusakiMeisho() {
        return seikyusakiMeisho;
    }

    /**
     * 請求先名称のsetメソッドです。
     * 
     * @param seikyusakiMeisho 請求先名称
     */
    public void setSeikyusakiMeisho(AtenaMeisho seikyusakiMeisho) {
        this.seikyusakiMeisho = seikyusakiMeisho;
    }

    /**
     * 請求先部署のgetメソッドです。
     * 
     * @return 請求先部署
     */
    public RString getSeikyusakiBusho() {
        return seikyusakiBusho;
    }

    /**
     * 請求先部署のsetメソッドです。
     * 
     * @param seikyusakiBusho 請求先部署
     */
    public void setSeikyusakiBusho(RString seikyusakiBusho) {
        this.seikyusakiBusho = seikyusakiBusho;
    }

    /**
     * 請求先担当者のgetメソッドです。
     * 
     * @return 請求先担当者
     */
    public AtenaMeisho getSeikyusakiTantosha() {
        return seikyusakiTantosha;
    }

    /**
     * 請求先担当者のsetメソッドです。
     * 
     * @param seikyusakiTantosha 請求先担当者
     */
    public void setSeikyusakiTantosha(AtenaMeisho seikyusakiTantosha) {
        this.seikyusakiTantosha = seikyusakiTantosha;
    }

    /**
     * 請求先電話番号のgetメソッドです。
     * 
     * @return 請求先電話番号
     */
    public TelNo getSeikyusakiTelNo() {
        return seikyusakiTelNo;
    }

    /**
     * 請求先電話番号のsetメソッドです。
     * 
     * @param seikyusakiTelNo 請求先電話番号
     */
    public void setSeikyusakiTelNo(TelNo seikyusakiTelNo) {
        this.seikyusakiTelNo = seikyusakiTelNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3082DaisanshaKoiKyushoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3082DaisanshaKoiKyushoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3082DaisanshaKoiKyushoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.todokedeKanriNo, other.todokedeKanriNo)) {
            return false;
        }
        if (!Objects.equals(this.kyushoSeikyuNo, other.kyushoSeikyuNo)) {
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
    public void shallowCopy(DbT3082DaisanshaKoiKyushoEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.todokedeKanriNo = entity.todokedeKanriNo;
        this.kyushoSeikyuNo = entity.kyushoSeikyuNo;
        this.rirekiNo = entity.rirekiNo;
        this.kyufuGakuGokei = entity.kyufuGakuGokei;
        this.kashitsuSosatsuGaku = entity.kashitsuSosatsuGaku;
        this.hokenKyufuSeikyuGaku = entity.hokenKyufuSeikyuGaku;
        this.songaiBaishoKinNonyuYMD = entity.songaiBaishoKinNonyuYMD;
        this.seikyusakiYubinNo = entity.seikyusakiYubinNo;
        this.seikyusakiJusho = entity.seikyusakiJusho;
        this.seikyusakiMeisho = entity.seikyusakiMeisho;
        this.seikyusakiBusho = entity.seikyusakiBusho;
        this.seikyusakiTantosha = entity.seikyusakiTantosha;
        this.seikyusakiTelNo = entity.seikyusakiTelNo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, todokedeKanriNo, kyushoSeikyuNo, rirekiNo, kyufuGakuGokei, kashitsuSosatsuGaku, hokenKyufuSeikyuGaku, songaiBaishoKinNonyuYMD, seikyusakiYubinNo, seikyusakiJusho, seikyusakiMeisho, seikyusakiBusho, seikyusakiTantosha, seikyusakiTelNo);
    }

// </editor-fold>
}

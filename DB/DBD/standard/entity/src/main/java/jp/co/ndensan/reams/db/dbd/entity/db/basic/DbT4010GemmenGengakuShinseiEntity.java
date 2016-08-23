package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 減免減額申請テーブルのエンティティクラスです。
 * <br/> 減免・減額の申請届出に関する情報を一元管理する。
 */
public class DbT4010GemmenGengakuShinseiEntity extends DbTableEntityBase<DbT4010GemmenGengakuShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4010GemmenGengakuShinsei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString gemmenGengakuShurui;
    @PrimaryKey
    private int shinseiRirekiNo;
    private RString shinseiTodokedeDaikoKubun;
    private AtenaMeisho shinseiTodokedeshaShimei;
    private AtenaKanaMeisho shinseiTodokedeshaKanaShimei;
    private RString shinseiTodokedeshaTsuzukigara;
    private JigyoshaNo shinseiTodokedeDaikoJigyoshaNo;
    private RString jigyoshaKubun;
    private YubinNo shinseiTodokedeshaYubinNo;
    private AtenaJusho shinseiTodokedeshaJusho;
    private TelNo shinseiTodokedeshaTelNo;

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
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
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(@Nonnull ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
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
     * 減免減額種類のgetメソッドです。
     * <br/>
     * <br/>DBDEnum.減免減額種類
     *
     * <br/> 01：標準負担額減免
     *
     * <br/> 02：特定標準負担額減額
     *
     * <br/> 03：利用者負担額減額
     *
     * <br/> 04：社会福祉法人等利用者負担軽減
     *
     * <br/> 05：訪問介護利用者負担額減額
     *
     * <br/> 06：特別地域加算減免
     *
     * <br/> 07：負担限度額認定
     *
     * <br/> 08：特定負担限度額認定
     *
     * <br/> 09：市民課税特例減額
     *
     * @return 減免減額種類
     */
    public RString getGemmenGengakuShurui() {
        return gemmenGengakuShurui;
    }

    /**
     * 減免減額種類のsetメソッドです。
     * <br/>
     * <br/>DBDEnum.減免減額種類
     *
     * <br/> 01：標準負担額減免
     *
     * <br/> 02：特定標準負担額減額
     *
     * <br/> 03：利用者負担額減額
     *
     * <br/> 04：社会福祉法人等利用者負担軽減
     *
     * <br/> 05：訪問介護利用者負担額減額
     *
     * <br/> 06：特別地域加算減免
     *
     * <br/> 07：負担限度額認定
     *
     * <br/> 08：特定負担限度額認定
     *
     * <br/> 09：市民課税特例減額
     *
     * @param gemmenGengakuShurui 減免減額種類
     */
    public void setGemmenGengakuShurui(@Nonnull RString gemmenGengakuShurui) {
        this.gemmenGengakuShurui = gemmenGengakuShurui;
    }

    /**
     * 履歴番号のgetメソッドです。
     * <br/>
     * <br/>各申請の履歴とリンクする履歴番号
     *
     * @return 履歴番号
     */
    public int getShinseiRirekiNo() {
        return shinseiRirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * <br/>
     * <br/>各申請の履歴とリンクする履歴番号
     *
     * @param shinseiRirekiNo 履歴番号
     */
    public void setShinseiRirekiNo(@Nonnull int shinseiRirekiNo) {
        this.shinseiRirekiNo = shinseiRirekiNo;
    }

    /**
     * 申請届出代行区分のgetメソッドです。
     * <br/>
     * <br/>DBDEnum.申請届出代行区分
     *
     * <br/>1:本人
     *
     * <br/>2:家族
     *
     * <br/>3:委任者
     *
     * <br/>4:代行事業者等
     *
     * @return 申請届出代行区分
     */
    @CheckForNull
    public RString getShinseiTodokedeDaikoKubun() {
        return shinseiTodokedeDaikoKubun;
    }

    /**
     * 申請届出代行区分のsetメソッドです。
     * <br/>
     * <br/>DBDEnum.申請届出代行区分
     *
     * <br/>1:本人
     *
     * <br/>2:家族
     *
     * <br/>3:委任者
     *
     * <br/>4:代行事業者等
     *
     * @param shinseiTodokedeDaikoKubun 申請届出代行区分
     */
    public void setShinseiTodokedeDaikoKubun(RString shinseiTodokedeDaikoKubun) {
        this.shinseiTodokedeDaikoKubun = shinseiTodokedeDaikoKubun;
    }

    /**
     * 申請届出者氏名のgetメソッドです。
     *
     * @return 申請届出者氏名
     */
    @CheckForNull
    public AtenaMeisho getShinseiTodokedeshaShimei() {
        return shinseiTodokedeshaShimei;
    }

    /**
     * 申請届出者氏名のsetメソッドです。
     *
     * @param shinseiTodokedeshaShimei 申請届出者氏名
     */
    public void setShinseiTodokedeshaShimei(AtenaMeisho shinseiTodokedeshaShimei) {
        this.shinseiTodokedeshaShimei = shinseiTodokedeshaShimei;
    }

    /**
     * 申請届出者氏名カナのgetメソッドです。
     *
     * @return 申請届出者氏名カナ
     */
    @CheckForNull
    public AtenaKanaMeisho getShinseiTodokedeshaKanaShimei() {
        return shinseiTodokedeshaKanaShimei;
    }

    /**
     * 申請届出者氏名カナのsetメソッドです。
     *
     * @param shinseiTodokedeshaKanaShimei 申請届出者氏名カナ
     */
    public void setShinseiTodokedeshaKanaShimei(AtenaKanaMeisho shinseiTodokedeshaKanaShimei) {
        this.shinseiTodokedeshaKanaShimei = shinseiTodokedeshaKanaShimei;
    }

    /**
     * 申請届出者続柄のgetメソッドです。
     *
     * @return 申請届出者続柄
     */
    @CheckForNull
    public RString getShinseiTodokedeshaTsuzukigara() {
        return shinseiTodokedeshaTsuzukigara;
    }

    /**
     * 申請届出者続柄のsetメソッドです。
     *
     * @param shinseiTodokedeshaTsuzukigara 申請届出者続柄
     */
    public void setShinseiTodokedeshaTsuzukigara(RString shinseiTodokedeshaTsuzukigara) {
        this.shinseiTodokedeshaTsuzukigara = shinseiTodokedeshaTsuzukigara;
    }

    /**
     * 申請届出代行事業者番号のgetメソッドです。
     *
     * @return 申請届出代行事業者番号
     */
    @CheckForNull
    public JigyoshaNo getShinseiTodokedeDaikoJigyoshaNo() {
        return shinseiTodokedeDaikoJigyoshaNo;
    }

    /**
     * 申請届出代行事業者番号のsetメソッドです。
     *
     * @param shinseiTodokedeDaikoJigyoshaNo 申請届出代行事業者番号
     */
    public void setShinseiTodokedeDaikoJigyoshaNo(JigyoshaNo shinseiTodokedeDaikoJigyoshaNo) {
        this.shinseiTodokedeDaikoJigyoshaNo = shinseiTodokedeDaikoJigyoshaNo;
    }

    /**
     * 事業者区分のgetメソッドです。
     *
     * @return 事業者区分
     */
    @CheckForNull
    public RString getJigyoshaKubun() {
        return jigyoshaKubun;
    }

    /**
     * 事業者区分のsetメソッドです。
     *
     * @param jigyoshaKubun 事業者区分
     */
    public void setJigyoshaKubun(RString jigyoshaKubun) {
        this.jigyoshaKubun = jigyoshaKubun;
    }

    /**
     * 申請届出者郵便番号のgetメソッドです。
     *
     * @return 申請届出者郵便番号
     */
    @CheckForNull
    public YubinNo getShinseiTodokedeshaYubinNo() {
        return shinseiTodokedeshaYubinNo;
    }

    /**
     * 申請届出者郵便番号のsetメソッドです。
     *
     * @param shinseiTodokedeshaYubinNo 申請届出者郵便番号
     */
    public void setShinseiTodokedeshaYubinNo(YubinNo shinseiTodokedeshaYubinNo) {
        this.shinseiTodokedeshaYubinNo = shinseiTodokedeshaYubinNo;
    }

    /**
     * 申請届出者住所のgetメソッドです。
     *
     * @return 申請届出者住所
     */
    @CheckForNull
    public AtenaJusho getShinseiTodokedeshaJusho() {
        return shinseiTodokedeshaJusho;
    }

    /**
     * 申請届出者住所のsetメソッドです。
     *
     * @param shinseiTodokedeshaJusho 申請届出者住所
     */
    public void setShinseiTodokedeshaJusho(AtenaJusho shinseiTodokedeshaJusho) {
        this.shinseiTodokedeshaJusho = shinseiTodokedeshaJusho;
    }

    /**
     * 申請届出者電話番号のgetメソッドです。
     *
     * @return 申請届出者電話番号
     */
    @CheckForNull
    public TelNo getShinseiTodokedeshaTelNo() {
        return shinseiTodokedeshaTelNo;
    }

    /**
     * 申請届出者電話番号のsetメソッドです。
     *
     * @param shinseiTodokedeshaTelNo 申請届出者電話番号
     */
    public void setShinseiTodokedeshaTelNo(TelNo shinseiTodokedeshaTelNo) {
        this.shinseiTodokedeshaTelNo = shinseiTodokedeshaTelNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4010GemmenGengakuShinseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT4010GemmenGengakuShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4010GemmenGengakuShinseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.gemmenGengakuShurui, other.gemmenGengakuShurui)) {
            return false;
        }
        if (this.shinseiRirekiNo != other.shinseiRirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4010GemmenGengakuShinseiEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.gemmenGengakuShurui = entity.gemmenGengakuShurui;
        this.shinseiRirekiNo = entity.shinseiRirekiNo;
        this.shinseiTodokedeDaikoKubun = entity.shinseiTodokedeDaikoKubun;
        this.shinseiTodokedeshaShimei = entity.shinseiTodokedeshaShimei;
        this.shinseiTodokedeshaKanaShimei = entity.shinseiTodokedeshaKanaShimei;
        this.shinseiTodokedeshaTsuzukigara = entity.shinseiTodokedeshaTsuzukigara;
        this.shinseiTodokedeDaikoJigyoshaNo = entity.shinseiTodokedeDaikoJigyoshaNo;
        this.jigyoshaKubun = entity.jigyoshaKubun;
        this.shinseiTodokedeshaYubinNo = entity.shinseiTodokedeshaYubinNo;
        this.shinseiTodokedeshaJusho = entity.shinseiTodokedeshaJusho;
        this.shinseiTodokedeshaTelNo = entity.shinseiTodokedeshaTelNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, gemmenGengakuShurui, shinseiRirekiNo, shinseiTodokedeDaikoKubun, shinseiTodokedeshaShimei, shinseiTodokedeshaKanaShimei, shinseiTodokedeshaTsuzukigara, shinseiTodokedeDaikoJigyoshaNo, jigyoshaKubun, shinseiTodokedeshaYubinNo, shinseiTodokedeshaJusho, shinseiTodokedeshaTelNo);
    }

// </editor-fold>
}

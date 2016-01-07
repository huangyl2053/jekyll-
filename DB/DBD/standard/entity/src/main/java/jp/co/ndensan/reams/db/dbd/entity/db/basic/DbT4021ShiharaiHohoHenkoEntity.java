package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 支払方法変更テーブルのエンティティクラスです。
 */
public class DbT4021ShiharaiHohoHenkoEntity extends DbTableEntityBase<DbT4021ShiharaiHohoHenkoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4021ShiharaiHohoHenko");

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
    private RString kanriKubun;
    @PrimaryKey
    private int rirekiNo;
    private RString torokuKubun;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString shuryoKubun;
    private FlexibleDate yokoku_TorokuYMD;
    private FlexibleDate sashitome_IraiJuriYMD;
    private FlexibleDate yokoku_TsuchiHakkoYMD;
    private boolean yokoku_TsuchiSaiHakkoFlag;
    private FlexibleDate bemmei_TeishutsuYMD;
    private FlexibleDate bemmei_UketsukeYMD;
    private RString bemmei_RiyuCode;
    private FlexibleDate bemmei_ShinsaKetteiYMD;
    private RString bemmei_ShinsaKekkaKubun;
    private FlexibleDate shokan_KetteiYMD;
    private FlexibleDate shokan_TsuchiHakkoYMD;
    private boolean shokan_TsuchiSaiHakkoFlag;
    private FlexibleDate hihokenshaShoTeishutsuYMD;
    private boolean sashitome_Flag;
    private FlexibleDate sashitome_KetteiYMD;
    private FlexibleDate sashitome_KaijoYMD;
    private FlexibleDate gemmen_KetteiYMD;
    private FlexibleDate gemmen_TsuchiHakkoYMD;
    private boolean gemmen_TsuchiSaiHakkoFlag;
    private HokenKyufuRitsu kyufuRitsu;
    private FlexibleDate shuryoShinsei_UketsukeYMD;
    private FlexibleDate shuryoShinsei_YMD;
    private RString shuryoShinsei_RiyuCode;
    private FlexibleDate shuryoShinsei_ShinsaKetteiYMD;
    private RString shuryoShinsei_ShinsaKekkaKubun;
    private boolean mukoKubun;
    private boolean logicalDeletedFlag;

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
     * 管理区分のgetメソッドです。
     * <br/>
     * <br/>1：２号差止,2：１号償還払い化,3：１号給付額減額
     * 
     * @return 管理区分
     */
    public RString getKanriKubun() {
        return kanriKubun;
    }

    /**
     * 管理区分のsetメソッドです。
     * <br/>
     * <br/>1：２号差止,2：１号償還払い化,3：１号給付額減額
     * 
     * @param kanriKubun 管理区分
     */
    public void setKanriKubun(@Nonnull RString kanriKubun) {
        this.kanriKubun = kanriKubun;
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
     * 登録区分のgetメソッドです。
     * <br/>
     * <br/>01：２号予告登録者,02：２号差止登録,11：１号予告者登録,12：１号償還払い化登録,21：１号給付額減額登録
     * 
     * @return 登録区分
     */
    public RString getTorokuKubun() {
        return torokuKubun;
    }

    /**
     * 登録区分のsetメソッドです。
     * <br/>
     * <br/>01：２号予告登録者,02：２号差止登録,11：１号予告者登録,12：１号償還払い化登録,21：１号給付額減額登録
     * 
     * @param torokuKubun 登録区分
     */
    public void setTorokuKubun(@Nonnull RString torokuKubun) {
        this.torokuKubun = torokuKubun;
    }

    /**
     * 適用開始年月日のgetメソッドです。
     * 
     * @return 適用開始年月日
     */
    @CheckForNull
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * 適用開始年月日のsetメソッドです。
     * 
     * @param tekiyoKaishiYMD 適用開始年月日
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * 適用終了年月日のgetメソッドです。
     * 
     * @return 適用終了年月日
     */
    @CheckForNull
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * 適用終了年月日のsetメソッドです。
     * 
     * @param tekiyoShuryoYMD 適用終了年月日
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * 終了区分のgetメソッドです。
     * <br/>
     * <br/>01：差止措置終了依頼書受理,02：弁明書受理,03：終了申請書受理,04：減額免除申請書受理,98：職権,99：その他
     * 
     * @return 終了区分
     */
    @CheckForNull
    public RString getShuryoKubun() {
        return shuryoKubun;
    }

    /**
     * 終了区分のsetメソッドです。
     * <br/>
     * <br/>01：差止措置終了依頼書受理,02：弁明書受理,03：終了申請書受理,04：減額免除申請書受理,98：職権,99：その他
     * 
     * @param shuryoKubun 終了区分
     */
    public void setShuryoKubun(RString shuryoKubun) {
        this.shuryoKubun = shuryoKubun;
    }

    /**
     * 予告登録年月日のgetメソッドです。
     * 
     * @return 予告登録年月日
     */
    @CheckForNull
    public FlexibleDate getYokoku_TorokuYMD() {
        return yokoku_TorokuYMD;
    }

    /**
     * 予告登録年月日のsetメソッドです。
     * 
     * @param yokoku_TorokuYMD 予告登録年月日
     */
    public void setYokoku_TorokuYMD(FlexibleDate yokoku_TorokuYMD) {
        this.yokoku_TorokuYMD = yokoku_TorokuYMD;
    }

    /**
     * 差止依頼書受理年月日のgetメソッドです。
     * 
     * @return 差止依頼書受理年月日
     */
    @CheckForNull
    public FlexibleDate getSashitome_IraiJuriYMD() {
        return sashitome_IraiJuriYMD;
    }

    /**
     * 差止依頼書受理年月日のsetメソッドです。
     * 
     * @param sashitome_IraiJuriYMD 差止依頼書受理年月日
     */
    public void setSashitome_IraiJuriYMD(FlexibleDate sashitome_IraiJuriYMD) {
        this.sashitome_IraiJuriYMD = sashitome_IraiJuriYMD;
    }

    /**
     * 予告通知書発行年月日のgetメソッドです。
     * 
     * @return 予告通知書発行年月日
     */
    @CheckForNull
    public FlexibleDate getYokoku_TsuchiHakkoYMD() {
        return yokoku_TsuchiHakkoYMD;
    }

    /**
     * 予告通知書発行年月日のsetメソッドです。
     * 
     * @param yokoku_TsuchiHakkoYMD 予告通知書発行年月日
     */
    public void setYokoku_TsuchiHakkoYMD(FlexibleDate yokoku_TsuchiHakkoYMD) {
        this.yokoku_TsuchiHakkoYMD = yokoku_TsuchiHakkoYMD;
    }

    /**
     * 予告通知書再発行フラグのgetメソッドです。
     * <br/>
     * <br/>1：再発行対象,0：再発行対象外
     * 
     * @return 予告通知書再発行フラグ
     */
    @CheckForNull
    public boolean getYokoku_TsuchiSaiHakkoFlag() {
        return yokoku_TsuchiSaiHakkoFlag;
    }

    /**
     * 予告通知書再発行フラグのsetメソッドです。
     * <br/>
     * <br/>1：再発行対象,0：再発行対象外
     * 
     * @param yokoku_TsuchiSaiHakkoFlag 予告通知書再発行フラグ
     */
    public void setYokoku_TsuchiSaiHakkoFlag(boolean yokoku_TsuchiSaiHakkoFlag) {
        this.yokoku_TsuchiSaiHakkoFlag = yokoku_TsuchiSaiHakkoFlag;
    }

    /**
     * 弁明書提出期限のgetメソッドです。
     * 
     * @return 弁明書提出期限
     */
    @CheckForNull
    public FlexibleDate getBemmei_TeishutsuYMD() {
        return bemmei_TeishutsuYMD;
    }

    /**
     * 弁明書提出期限のsetメソッドです。
     * 
     * @param bemmei_TeishutsuYMD 弁明書提出期限
     */
    public void setBemmei_TeishutsuYMD(FlexibleDate bemmei_TeishutsuYMD) {
        this.bemmei_TeishutsuYMD = bemmei_TeishutsuYMD;
    }

    /**
     * 弁明書受付年月日のgetメソッドです。
     * 
     * @return 弁明書受付年月日
     */
    @CheckForNull
    public FlexibleDate getBemmei_UketsukeYMD() {
        return bemmei_UketsukeYMD;
    }

    /**
     * 弁明書受付年月日のsetメソッドです。
     * 
     * @param bemmei_UketsukeYMD 弁明書受付年月日
     */
    public void setBemmei_UketsukeYMD(FlexibleDate bemmei_UketsukeYMD) {
        this.bemmei_UketsukeYMD = bemmei_UketsukeYMD;
    }

    /**
     * 弁明理由コードのgetメソッドです。
     * <br/>
     * <br/>01：公費負担医療の受給,02：災害,03：重大な障害または長期入院,04：滞納保険料の減少,05：保険料完納,99：その他
     * 
     * @return 弁明理由コード
     */
    @CheckForNull
    public RString getBemmei_RiyuCode() {
        return bemmei_RiyuCode;
    }

    /**
     * 弁明理由コードのsetメソッドです。
     * <br/>
     * <br/>01：公費負担医療の受給,02：災害,03：重大な障害または長期入院,04：滞納保険料の減少,05：保険料完納,99：その他
     * 
     * @param bemmei_RiyuCode 弁明理由コード
     */
    public void setBemmei_RiyuCode(RString bemmei_RiyuCode) {
        this.bemmei_RiyuCode = bemmei_RiyuCode;
    }

    /**
     * 弁明審査決定年月日のgetメソッドです。
     * 
     * @return 弁明審査決定年月日
     */
    @CheckForNull
    public FlexibleDate getBemmei_ShinsaKetteiYMD() {
        return bemmei_ShinsaKetteiYMD;
    }

    /**
     * 弁明審査決定年月日のsetメソッドです。
     * 
     * @param bemmei_ShinsaKetteiYMD 弁明審査決定年月日
     */
    public void setBemmei_ShinsaKetteiYMD(FlexibleDate bemmei_ShinsaKetteiYMD) {
        this.bemmei_ShinsaKetteiYMD = bemmei_ShinsaKetteiYMD;
    }

    /**
     * 弁明審査結果区分のgetメソッドです。
     * <br/>
     * <br/>1：申請受理,2：申請却下
     * 
     * @return 弁明審査結果区分
     */
    @CheckForNull
    public RString getBemmei_ShinsaKekkaKubun() {
        return bemmei_ShinsaKekkaKubun;
    }

    /**
     * 弁明審査結果区分のsetメソッドです。
     * <br/>
     * <br/>1：申請受理,2：申請却下
     * 
     * @param bemmei_ShinsaKekkaKubun 弁明審査結果区分
     */
    public void setBemmei_ShinsaKekkaKubun(RString bemmei_ShinsaKekkaKubun) {
        this.bemmei_ShinsaKekkaKubun = bemmei_ShinsaKekkaKubun;
    }

    /**
     * 償還払化決定年月日のgetメソッドです。
     * 
     * @return 償還払化決定年月日
     */
    @CheckForNull
    public FlexibleDate getShokan_KetteiYMD() {
        return shokan_KetteiYMD;
    }

    /**
     * 償還払化決定年月日のsetメソッドです。
     * 
     * @param shokan_KetteiYMD 償還払化決定年月日
     */
    public void setShokan_KetteiYMD(FlexibleDate shokan_KetteiYMD) {
        this.shokan_KetteiYMD = shokan_KetteiYMD;
    }

    /**
     * 償還払化通知書発行年月日のgetメソッドです。
     * 
     * @return 償還払化通知書発行年月日
     */
    @CheckForNull
    public FlexibleDate getShokan_TsuchiHakkoYMD() {
        return shokan_TsuchiHakkoYMD;
    }

    /**
     * 償還払化通知書発行年月日のsetメソッドです。
     * 
     * @param shokan_TsuchiHakkoYMD 償還払化通知書発行年月日
     */
    public void setShokan_TsuchiHakkoYMD(FlexibleDate shokan_TsuchiHakkoYMD) {
        this.shokan_TsuchiHakkoYMD = shokan_TsuchiHakkoYMD;
    }

    /**
     * 償還払化通知書再発行フラグのgetメソッドです。
     * <br/>
     * <br/>1：再発行対象,0：再発行対象外
     * 
     * @return 償還払化通知書再発行フラグ
     */
    @CheckForNull
    public boolean getShokan_TsuchiSaiHakkoFlag() {
        return shokan_TsuchiSaiHakkoFlag;
    }

    /**
     * 償還払化通知書再発行フラグのsetメソッドです。
     * <br/>
     * <br/>1：再発行対象,0：再発行対象外
     * 
     * @param shokan_TsuchiSaiHakkoFlag 償還払化通知書再発行フラグ
     */
    public void setShokan_TsuchiSaiHakkoFlag(boolean shokan_TsuchiSaiHakkoFlag) {
        this.shokan_TsuchiSaiHakkoFlag = shokan_TsuchiSaiHakkoFlag;
    }

    /**
     * 被保険者証提出期限のgetメソッドです。
     * 
     * @return 被保険者証提出期限
     */
    @CheckForNull
    public FlexibleDate getHihokenshaShoTeishutsuYMD() {
        return hihokenshaShoTeishutsuYMD;
    }

    /**
     * 被保険者証提出期限のsetメソッドです。
     * 
     * @param hihokenshaShoTeishutsuYMD 被保険者証提出期限
     */
    public void setHihokenshaShoTeishutsuYMD(FlexibleDate hihokenshaShoTeishutsuYMD) {
        this.hihokenshaShoTeishutsuYMD = hihokenshaShoTeishutsuYMD;
    }

    /**
     * 差止対象フラグのgetメソッドです。
     * <br/>
     * <br/>1：差止対象,0：差止対象外
     * 
     * @return 差止対象フラグ
     */
    @CheckForNull
    public boolean getSashitome_Flag() {
        return sashitome_Flag;
    }

    /**
     * 差止対象フラグのsetメソッドです。
     * <br/>
     * <br/>1：差止対象,0：差止対象外
     * 
     * @param sashitome_Flag 差止対象フラグ
     */
    public void setSashitome_Flag(boolean sashitome_Flag) {
        this.sashitome_Flag = sashitome_Flag;
    }

    /**
     * 差止対象決定年月日のgetメソッドです。
     * 
     * @return 差止対象決定年月日
     */
    @CheckForNull
    public FlexibleDate getSashitome_KetteiYMD() {
        return sashitome_KetteiYMD;
    }

    /**
     * 差止対象決定年月日のsetメソッドです。
     * 
     * @param sashitome_KetteiYMD 差止対象決定年月日
     */
    public void setSashitome_KetteiYMD(FlexibleDate sashitome_KetteiYMD) {
        this.sashitome_KetteiYMD = sashitome_KetteiYMD;
    }

    /**
     * 差止対象解除年月日のgetメソッドです。
     * 
     * @return 差止対象解除年月日
     */
    @CheckForNull
    public FlexibleDate getSashitome_KaijoYMD() {
        return sashitome_KaijoYMD;
    }

    /**
     * 差止対象解除年月日のsetメソッドです。
     * 
     * @param sashitome_KaijoYMD 差止対象解除年月日
     */
    public void setSashitome_KaijoYMD(FlexibleDate sashitome_KaijoYMD) {
        this.sashitome_KaijoYMD = sashitome_KaijoYMD;
    }

    /**
     * 減額決定年月日のgetメソッドです。
     * 
     * @return 減額決定年月日
     */
    @CheckForNull
    public FlexibleDate getGemmen_KetteiYMD() {
        return gemmen_KetteiYMD;
    }

    /**
     * 減額決定年月日のsetメソッドです。
     * 
     * @param gemmen_KetteiYMD 減額決定年月日
     */
    public void setGemmen_KetteiYMD(FlexibleDate gemmen_KetteiYMD) {
        this.gemmen_KetteiYMD = gemmen_KetteiYMD;
    }

    /**
     * 減額通知書発行年月日のgetメソッドです。
     * 
     * @return 減額通知書発行年月日
     */
    @CheckForNull
    public FlexibleDate getGemmen_TsuchiHakkoYMD() {
        return gemmen_TsuchiHakkoYMD;
    }

    /**
     * 減額通知書発行年月日のsetメソッドです。
     * 
     * @param gemmen_TsuchiHakkoYMD 減額通知書発行年月日
     */
    public void setGemmen_TsuchiHakkoYMD(FlexibleDate gemmen_TsuchiHakkoYMD) {
        this.gemmen_TsuchiHakkoYMD = gemmen_TsuchiHakkoYMD;
    }

    /**
     * 減額通知書再発行フラグのgetメソッドです。
     * <br/>
     * <br/>1：再発行対象,0：再発行対象外
     * 
     * @return 減額通知書再発行フラグ
     */
    @CheckForNull
    public boolean getGemmen_TsuchiSaiHakkoFlag() {
        return gemmen_TsuchiSaiHakkoFlag;
    }

    /**
     * 減額通知書再発行フラグのsetメソッドです。
     * <br/>
     * <br/>1：再発行対象,0：再発行対象外
     * 
     * @param gemmen_TsuchiSaiHakkoFlag 減額通知書再発行フラグ
     */
    public void setGemmen_TsuchiSaiHakkoFlag(boolean gemmen_TsuchiSaiHakkoFlag) {
        this.gemmen_TsuchiSaiHakkoFlag = gemmen_TsuchiSaiHakkoFlag;
    }

    /**
     * 給付率のgetメソッドです。
     * <br/>
     * <br/>％で設定（70％の場合、070）
     * 
     * @return 給付率
     */
    @CheckForNull
    public HokenKyufuRitsu getKyufuRitsu() {
        return kyufuRitsu;
    }

    /**
     * 給付率のsetメソッドです。
     * <br/>
     * <br/>％で設定（70％の場合、070）
     * 
     * @param kyufuRitsu 給付率
     */
    public void setKyufuRitsu(HokenKyufuRitsu kyufuRitsu) {
        this.kyufuRitsu = kyufuRitsu;
    }

    /**
     * 終了申請書受付年月日のgetメソッドです。
     * 
     * @return 終了申請書受付年月日
     */
    @CheckForNull
    public FlexibleDate getShuryoShinsei_UketsukeYMD() {
        return shuryoShinsei_UketsukeYMD;
    }

    /**
     * 終了申請書受付年月日のsetメソッドです。
     * 
     * @param shuryoShinsei_UketsukeYMD 終了申請書受付年月日
     */
    public void setShuryoShinsei_UketsukeYMD(FlexibleDate shuryoShinsei_UketsukeYMD) {
        this.shuryoShinsei_UketsukeYMD = shuryoShinsei_UketsukeYMD;
    }

    /**
     * 終了申請年月日のgetメソッドです。
     * 
     * @return 終了申請年月日
     */
    @CheckForNull
    public FlexibleDate getShuryoShinsei_YMD() {
        return shuryoShinsei_YMD;
    }

    /**
     * 終了申請年月日のsetメソッドです。
     * 
     * @param shuryoShinsei_YMD 終了申請年月日
     */
    public void setShuryoShinsei_YMD(FlexibleDate shuryoShinsei_YMD) {
        this.shuryoShinsei_YMD = shuryoShinsei_YMD;
    }

    /**
     * 終了申請理由コードのgetメソッドです。
     * <br/>
     * <br/>01：公費負担医療の受給,02：災害,03：重大な障害または長期入院,04：滞納保険料の減少（支払方法変更管理種別：2）,05：保険料完納（支払方法変更管理種別：2）,06：特別な事情（支払方法変更管理種別：3）,98：職権（支払方法変更管理種別：3）,99：その他
     * 
     * @return 終了申請理由コード
     */
    @CheckForNull
    public RString getShuryoShinsei_RiyuCode() {
        return shuryoShinsei_RiyuCode;
    }

    /**
     * 終了申請理由コードのsetメソッドです。
     * <br/>
     * <br/>01：公費負担医療の受給,02：災害,03：重大な障害または長期入院,04：滞納保険料の減少（支払方法変更管理種別：2）,05：保険料完納（支払方法変更管理種別：2）,06：特別な事情（支払方法変更管理種別：3）,98：職権（支払方法変更管理種別：3）,99：その他
     * 
     * @param shuryoShinsei_RiyuCode 終了申請理由コード
     */
    public void setShuryoShinsei_RiyuCode(RString shuryoShinsei_RiyuCode) {
        this.shuryoShinsei_RiyuCode = shuryoShinsei_RiyuCode;
    }

    /**
     * 終了申請審査決定年月日のgetメソッドです。
     * 
     * @return 終了申請審査決定年月日
     */
    @CheckForNull
    public FlexibleDate getShuryoShinsei_ShinsaKetteiYMD() {
        return shuryoShinsei_ShinsaKetteiYMD;
    }

    /**
     * 終了申請審査決定年月日のsetメソッドです。
     * 
     * @param shuryoShinsei_ShinsaKetteiYMD 終了申請審査決定年月日
     */
    public void setShuryoShinsei_ShinsaKetteiYMD(FlexibleDate shuryoShinsei_ShinsaKetteiYMD) {
        this.shuryoShinsei_ShinsaKetteiYMD = shuryoShinsei_ShinsaKetteiYMD;
    }

    /**
     * 終了申請審査結果区分のgetメソッドです。
     * <br/>
     * <br/>1：申請受理,2：申請却下
     * 
     * @return 終了申請審査結果区分
     */
    @CheckForNull
    public RString getShuryoShinsei_ShinsaKekkaKubun() {
        return shuryoShinsei_ShinsaKekkaKubun;
    }

    /**
     * 終了申請審査結果区分のsetメソッドです。
     * <br/>
     * <br/>1：申請受理,2：申請却下
     * 
     * @param shuryoShinsei_ShinsaKekkaKubun 終了申請審査結果区分
     */
    public void setShuryoShinsei_ShinsaKekkaKubun(RString shuryoShinsei_ShinsaKekkaKubun) {
        this.shuryoShinsei_ShinsaKekkaKubun = shuryoShinsei_ShinsaKekkaKubun;
    }

    /**
     * 無効区分のgetメソッドです。
     * <br/>
     * <br/>1：無効,0：有効
     * 
     * @return 無効区分
     */
    @CheckForNull
    public boolean getMukoKubun() {
        return mukoKubun;
    }

    /**
     * 無効区分のsetメソッドです。
     * <br/>
     * <br/>1：無効,0：有効
     * 
     * @param mukoKubun 無効区分
     */
    public void setMukoKubun(boolean mukoKubun) {
        this.mukoKubun = mukoKubun;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     * 
     * @return 論理削除フラグ
     */
    @CheckForNull
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * 論理削除フラグのsetメソッドです。
     * 
     * @param logicalDeletedFlag 論理削除フラグ
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4021ShiharaiHohoHenkoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4021ShiharaiHohoHenkoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4021ShiharaiHohoHenkoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kanriKubun, other.kanriKubun)) {
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
    public void shallowCopy(DbT4021ShiharaiHohoHenkoEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kanriKubun = entity.kanriKubun;
        this.rirekiNo = entity.rirekiNo;
        this.torokuKubun = entity.torokuKubun;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.shuryoKubun = entity.shuryoKubun;
        this.yokoku_TorokuYMD = entity.yokoku_TorokuYMD;
        this.sashitome_IraiJuriYMD = entity.sashitome_IraiJuriYMD;
        this.yokoku_TsuchiHakkoYMD = entity.yokoku_TsuchiHakkoYMD;
        this.yokoku_TsuchiSaiHakkoFlag = entity.yokoku_TsuchiSaiHakkoFlag;
        this.bemmei_TeishutsuYMD = entity.bemmei_TeishutsuYMD;
        this.bemmei_UketsukeYMD = entity.bemmei_UketsukeYMD;
        this.bemmei_RiyuCode = entity.bemmei_RiyuCode;
        this.bemmei_ShinsaKetteiYMD = entity.bemmei_ShinsaKetteiYMD;
        this.bemmei_ShinsaKekkaKubun = entity.bemmei_ShinsaKekkaKubun;
        this.shokan_KetteiYMD = entity.shokan_KetteiYMD;
        this.shokan_TsuchiHakkoYMD = entity.shokan_TsuchiHakkoYMD;
        this.shokan_TsuchiSaiHakkoFlag = entity.shokan_TsuchiSaiHakkoFlag;
        this.hihokenshaShoTeishutsuYMD = entity.hihokenshaShoTeishutsuYMD;
        this.sashitome_Flag = entity.sashitome_Flag;
        this.sashitome_KetteiYMD = entity.sashitome_KetteiYMD;
        this.sashitome_KaijoYMD = entity.sashitome_KaijoYMD;
        this.gemmen_KetteiYMD = entity.gemmen_KetteiYMD;
        this.gemmen_TsuchiHakkoYMD = entity.gemmen_TsuchiHakkoYMD;
        this.gemmen_TsuchiSaiHakkoFlag = entity.gemmen_TsuchiSaiHakkoFlag;
        this.kyufuRitsu = entity.kyufuRitsu;
        this.shuryoShinsei_UketsukeYMD = entity.shuryoShinsei_UketsukeYMD;
        this.shuryoShinsei_YMD = entity.shuryoShinsei_YMD;
        this.shuryoShinsei_RiyuCode = entity.shuryoShinsei_RiyuCode;
        this.shuryoShinsei_ShinsaKetteiYMD = entity.shuryoShinsei_ShinsaKetteiYMD;
        this.shuryoShinsei_ShinsaKekkaKubun = entity.shuryoShinsei_ShinsaKekkaKubun;
        this.mukoKubun = entity.mukoKubun;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, kanriKubun, rirekiNo, torokuKubun, tekiyoKaishiYMD, tekiyoShuryoYMD, shuryoKubun, yokoku_TorokuYMD, sashitome_IraiJuriYMD, yokoku_TsuchiHakkoYMD, yokoku_TsuchiSaiHakkoFlag, bemmei_TeishutsuYMD, bemmei_UketsukeYMD, bemmei_RiyuCode, bemmei_ShinsaKetteiYMD, bemmei_ShinsaKekkaKubun, shokan_KetteiYMD, shokan_TsuchiHakkoYMD, shokan_TsuchiSaiHakkoFlag, hihokenshaShoTeishutsuYMD, sashitome_Flag, sashitome_KetteiYMD, sashitome_KaijoYMD, gemmen_KetteiYMD, gemmen_TsuchiHakkoYMD, gemmen_TsuchiSaiHakkoFlag, kyufuRitsu, shuryoShinsei_UketsukeYMD, shuryoShinsei_YMD, shuryoShinsei_RiyuCode, shuryoShinsei_ShinsaKetteiYMD, shuryoShinsei_ShinsaKekkaKubun, mukoKubun, logicalDeletedFlag);
    }

// </editor-fold>

}

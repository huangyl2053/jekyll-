package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 償還払支給申請テーブルのエンティティクラスです。
 */
public class DbT3034ShokanShinseiEntity extends DbTableEntityBase<DbT3034ShokanShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3034ShokanShinsei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString seiriNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private HokenshaNo shoKisaiHokenshaNo;
    private FlexibleDate uketsukeYMD;
    private FlexibleDate shinseiYMD;
    private RString shinseiRiyu;
    private RString shinseishaKubun;
    private RString shinseishaNameKanji;
    private RString shinseishaNameKana;
    private RString shinseishaAddress;
    private RString shinseishaTelNo;
    private RString shinseiJigyoshaCode;
    private Decimal shiharaiKingakuTotal;
    private int hokenKyufuritsu;
    private int riyoshaFutangaku;
    private RString shikyuShinseiShinsaKubun;
    private RString shinsaHohoKubun;
    private FlexibleYearMonth sofuYM;
    private RString shiharaiHohoKubunCode;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString heichoNaiyo;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private long kozaID;
    private RString juryoininKeiyakuNo;

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
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hiHokenshaNo 被保険者番号
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * サービス提供年月のgetメソッドです。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * サービス提供年月のsetメソッドです。
     *
     * @param serviceTeikyoYM サービス提供年月
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * 整理番号のgetメソッドです。
     *
     * @return 整理番号
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * 整理番号のsetメソッドです。
     *
     * @param seiriNo 整理番号
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
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
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 受付年月日のgetメソッドです。
     *
     * @return 受付年月日
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * 受付年月日のsetメソッドです。
     *
     * @param uketsukeYMD 受付年月日
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * 申請年月日のgetメソッドです。
     * <br/>
     * <br/>1:本人,2:代理人,3:受領委任事業者
     *
     * @return 申請年月日
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     * <br/>
     * <br/>1:本人,2:代理人,3:受領委任事業者
     *
     * @param shinseiYMD 申請年月日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 申請理由のgetメソッドです。
     *
     * @return 申請理由
     */
    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    /**
     * 申請理由のsetメソッドです。
     *
     * @param shinseiRiyu 申請理由
     */
    public void setShinseiRiyu(RString shinseiRiyu) {
        this.shinseiRiyu = shinseiRiyu;
    }

    /**
     * 申請者区分のgetメソッドです。
     *
     * @return 申請者区分
     */
    public RString getShinseishaKubun() {
        return shinseishaKubun;
    }

    /**
     * 申請者区分のsetメソッドです。
     *
     * @param shinseishaKubun 申請者区分
     */
    public void setShinseishaKubun(RString shinseishaKubun) {
        this.shinseishaKubun = shinseishaKubun;
    }

    /**
     * 申請者氏名のgetメソッドです。
     *
     * @return 申請者氏名
     */
    public RString getShinseishaNameKanji() {
        return shinseishaNameKanji;
    }

    /**
     * 申請者氏名のsetメソッドです。
     *
     * @param shinseishaNameKanji 申請者氏名
     */
    public void setShinseishaNameKanji(RString shinseishaNameKanji) {
        this.shinseishaNameKanji = shinseishaNameKanji;
    }

    /**
     * 申請者氏名カナのgetメソッドです。
     *
     * @return 申請者氏名カナ
     */
    public RString getShinseishaNameKana() {
        return shinseishaNameKana;
    }

    /**
     * 申請者氏名カナのsetメソッドです。
     *
     * @param shinseishaNameKana 申請者氏名カナ
     */
    public void setShinseishaNameKana(RString shinseishaNameKana) {
        this.shinseishaNameKana = shinseishaNameKana;
    }

    /**
     * 申請者住所のgetメソッドです。
     *
     * @return 申請者住所
     */
    public RString getShinseishaAddress() {
        return shinseishaAddress;
    }

    /**
     * 申請者住所のsetメソッドです。
     *
     * @param shinseishaAddress 申請者住所
     */
    public void setShinseishaAddress(RString shinseishaAddress) {
        this.shinseishaAddress = shinseishaAddress;
    }

    /**
     * 申請者電話番号のgetメソッドです。
     *
     * @return 申請者電話番号
     */
    public RString getShinseishaTelNo() {
        return shinseishaTelNo;
    }

    /**
     * 申請者電話番号のsetメソッドです。
     *
     * @param shinseishaTelNo 申請者電話番号
     */
    public void setShinseishaTelNo(RString shinseishaTelNo) {
        this.shinseishaTelNo = shinseishaTelNo;
    }

    /**
     * 申請事業者コードのgetメソッドです。
     *
     * @return 申請事業者コード
     */
    public RString getShinseiJigyoshaCode() {
        return shinseiJigyoshaCode;
    }

    /**
     * 申請事業者コードのsetメソッドです。
     *
     * @param shinseiJigyoshaCode 申請事業者コード
     */
    public void setShinseiJigyoshaCode(RString shinseiJigyoshaCode) {
        this.shinseiJigyoshaCode = shinseiJigyoshaCode;
    }

    /**
     * 支払金額合計のgetメソッドです。
     *
     * @return 支払金額合計
     */
    public Decimal getShiharaiKingakuTotal() {
        return shiharaiKingakuTotal;
    }

    /**
     * 支払金額合計のsetメソッドです。
     *
     * @param shiharaiKingakuTotal 支払金額合計
     */
    public void setShiharaiKingakuTotal(Decimal shiharaiKingakuTotal) {
        this.shiharaiKingakuTotal = shiharaiKingakuTotal;
    }

    /**
     * 保険給付額のgetメソッドです。
     *
     * @return 保険給付額
     */
    public int getHokenKyufuritsu() {
        return hokenKyufuritsu;
    }

    /**
     * 保険給付額のsetメソッドです。
     *
     * @param hokenKyufuritsu 保険給付額
     */
    public void setHokenKyufuritsu(int hokenKyufuritsu) {
        this.hokenKyufuritsu = hokenKyufuritsu;
    }

    /**
     * 利用者負担額のgetメソッドです。
     *
     * @return 利用者負担額
     */
    public int getRiyoshaFutangaku() {
        return riyoshaFutangaku;
    }

    /**
     * 利用者負担額のsetメソッドです。
     *
     * @param riyoshaFutangaku 利用者負担額
     */
    public void setRiyoshaFutangaku(int riyoshaFutangaku) {
        this.riyoshaFutangaku = riyoshaFutangaku;
    }

    /**
     * 支給申請審査区分のgetメソッドです。
     * <br/>
     * <br/>1:未審査、2:審査済み
     *
     * @return 支給申請審査区分
     */
    public RString getShikyuShinseiShinsaKubun() {
        return shikyuShinseiShinsaKubun;
    }

    /**
     * 支給申請審査区分のsetメソッドです。
     * <br/>
     * <br/>1:未審査、2:審査済み
     *
     * @param shikyuShinseiShinsaKubun 支給申請審査区分
     */
    public void setShikyuShinseiShinsaKubun(RString shikyuShinseiShinsaKubun) {
        this.shikyuShinseiShinsaKubun = shikyuShinseiShinsaKubun;
    }

    /**
     * 審査方法区分のgetメソッドです。
     * <br/>
     * <br/>1:審査依頼,2:審査済み
     *
     * @return 審査方法区分
     */
    public RString getShinsaHohoKubun() {
        return shinsaHohoKubun;
    }

    /**
     * 審査方法区分のsetメソッドです。
     * <br/>
     * <br/>1:審査依頼,2:審査済み
     *
     * @param shinsaHohoKubun 審査方法区分
     */
    public void setShinsaHohoKubun(RString shinsaHohoKubun) {
        this.shinsaHohoKubun = shinsaHohoKubun;
    }

    /**
     * 送付年月のgetメソッドです。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * 送付年月のsetメソッドです。
     *
     * @param sofuYM 送付年月
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * 支払方法区分コードのgetメソッドです。
     *
     * @return 支払方法区分コード
     */
    public RString getShiharaiHohoKubunCode() {
        return shiharaiHohoKubunCode;
    }

    /**
     * 支払方法区分コードのsetメソッドです。
     *
     * @param shiharaiHohoKubunCode 支払方法区分コード
     */
    public void setShiharaiHohoKubunCode(RString shiharaiHohoKubunCode) {
        this.shiharaiHohoKubunCode = shiharaiHohoKubunCode;
    }

    /**
     * 支払場所のgetメソッドです。
     *
     * @return 支払場所
     */
    public RString getShiharaiBasho() {
        return shiharaiBasho;
    }

    /**
     * 支払場所のsetメソッドです。
     *
     * @param shiharaiBasho 支払場所
     */
    public void setShiharaiBasho(RString shiharaiBasho) {
        this.shiharaiBasho = shiharaiBasho;
    }

    /**
     * 支払期間開始年月日のgetメソッドです。
     *
     * @return 支払期間開始年月日
     */
    public FlexibleDate getShiharaiKaishiYMD() {
        return shiharaiKaishiYMD;
    }

    /**
     * 支払期間開始年月日のsetメソッドです。
     *
     * @param shiharaiKaishiYMD 支払期間開始年月日
     */
    public void setShiharaiKaishiYMD(FlexibleDate shiharaiKaishiYMD) {
        this.shiharaiKaishiYMD = shiharaiKaishiYMD;
    }

    /**
     * 支払期間終了年月日のgetメソッドです。
     *
     * @return 支払期間終了年月日
     */
    public FlexibleDate getShiharaiShuryoYMD() {
        return shiharaiShuryoYMD;
    }

    /**
     * 支払期間終了年月日のsetメソッドです。
     *
     * @param shiharaiShuryoYMD 支払期間終了年月日
     */
    public void setShiharaiShuryoYMD(FlexibleDate shiharaiShuryoYMD) {
        this.shiharaiShuryoYMD = shiharaiShuryoYMD;
    }

    /**
     * 閉庁内容のgetメソッドです。
     *
     * @return 閉庁内容
     */
    public RString getHeichoNaiyo() {
        return heichoNaiyo;
    }

    /**
     * 閉庁内容のsetメソッドです。
     *
     * @param heichoNaiyo 閉庁内容
     */
    public void setHeichoNaiyo(RString heichoNaiyo) {
        this.heichoNaiyo = heichoNaiyo;
    }

    /**
     * 支払窓口開始時間のgetメソッドです。
     *
     * @return 支払窓口開始時間
     */
    public RString getShiharaiKaishiTime() {
        return shiharaiKaishiTime;
    }

    /**
     * 支払窓口開始時間のsetメソッドです。
     *
     * @param shiharaiKaishiTime 支払窓口開始時間
     */
    public void setShiharaiKaishiTime(RString shiharaiKaishiTime) {
        this.shiharaiKaishiTime = shiharaiKaishiTime;
    }

    /**
     * 支払窓口終了期間のgetメソッドです。
     *
     * @return 支払窓口終了期間
     */
    public RString getShiharaiShuryoTime() {
        return shiharaiShuryoTime;
    }

    /**
     * 支払窓口終了期間のsetメソッドです。
     *
     * @param shiharaiShuryoTime 支払窓口終了期間
     */
    public void setShiharaiShuryoTime(RString shiharaiShuryoTime) {
        this.shiharaiShuryoTime = shiharaiShuryoTime;
    }

    /**
     * 口座IDのgetメソッドです。
     *
     * @return 口座ID
     */
    public long getKozaID() {
        return kozaID;
    }

    /**
     * 口座IDのsetメソッドです。
     *
     * @param kozaID 口座ID
     */
    public void setKozaID(long kozaID) {
        this.kozaID = kozaID;
    }

    /**
     * 受領委任契約番号のgetメソッドです。
     *
     * @return 受領委任契約番号
     */
    public RString getJuryoininKeiyakuNo() {
        return juryoininKeiyakuNo;
    }

    /**
     * 受領委任契約番号のsetメソッドです。
     *
     * @param juryoininKeiyakuNo 受領委任契約番号
     */
    public void setJuryoininKeiyakuNo(RString juryoininKeiyakuNo) {
        this.juryoininKeiyakuNo = juryoininKeiyakuNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3034ShokanShinseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3034ShokanShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3034ShokanShinseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNo, other.seiriNo)) {
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
    public void shallowCopy(DbT3034ShokanShinseiEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.rirekiNo = entity.rirekiNo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.shinseiYMD = entity.shinseiYMD;
        this.shinseiRiyu = entity.shinseiRiyu;
        this.shinseishaKubun = entity.shinseishaKubun;
        this.shinseishaNameKanji = entity.shinseishaNameKanji;
        this.shinseishaNameKana = entity.shinseishaNameKana;
        this.shinseishaAddress = entity.shinseishaAddress;
        this.shinseishaTelNo = entity.shinseishaTelNo;
        this.shinseiJigyoshaCode = entity.shinseiJigyoshaCode;
        this.shiharaiKingakuTotal = entity.shiharaiKingakuTotal;
        this.hokenKyufuritsu = entity.hokenKyufuritsu;
        this.riyoshaFutangaku = entity.riyoshaFutangaku;
        this.shikyuShinseiShinsaKubun = entity.shikyuShinseiShinsaKubun;
        this.shinsaHohoKubun = entity.shinsaHohoKubun;
        this.sofuYM = entity.sofuYM;
        this.shiharaiHohoKubunCode = entity.shiharaiHohoKubunCode;
        this.shiharaiBasho = entity.shiharaiBasho;
        this.shiharaiKaishiYMD = entity.shiharaiKaishiYMD;
        this.shiharaiShuryoYMD = entity.shiharaiShuryoYMD;
        this.heichoNaiyo = entity.heichoNaiyo;
        this.shiharaiKaishiTime = entity.shiharaiKaishiTime;
        this.shiharaiShuryoTime = entity.shiharaiShuryoTime;
        this.kozaID = entity.kozaID;
        this.juryoininKeiyakuNo = entity.juryoininKeiyakuNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, rirekiNo, shoKisaiHokenshaNo, uketsukeYMD, shinseiYMD, shinseiRiyu, shinseishaKubun, shinseishaNameKanji, shinseishaNameKana, shinseishaAddress, shinseishaTelNo, shinseiJigyoshaCode, shiharaiKingakuTotal, hokenKyufuritsu, riyoshaFutangaku, shikyuShinseiShinsaKubun, shinsaHohoKubun, sofuYM, shiharaiHohoKubunCode, shiharaiBasho, shiharaiKaishiYMD, shiharaiShuryoYMD, heichoNaiyo, shiharaiKaishiTime, shiharaiShuryoTime, kozaID, juryoininKeiyakuNo);
    }

// </editor-fold>
}

package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給住宅改修事前申請テーブルのエンティティクラスです。
 */
public class DbT3035ShokanJutakuKaishuJizenShinseiEntity extends DbTableEntityBase<DbT3035ShokanJutakuKaishuJizenShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3035ShokanJutakuKaishuJizenShinsei");

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
    private JigyoshaNo jigyoshaNo;
    private RString jigyoshaNameKanji;
    private RString jigyoshaNameKana;
    private YubinNo jigyoshaYubunNo;
    private RString jigyoshaAddress;
    private RString jigyoshaTelNo;
    private RString jigyoshaFaxNo;
    private RString riyushoSakuseishaKanji;
    private RString riyushoSakuseishaKana;
    private ServiceShuruiCode serviceShuruiCode;
    private FlexibleDate keiyakuKetteiYMD;
    private RString shoninKubun;
    private RString fushoninRiyu;
    private int kyufugakuHiyogakuTotal;
    private int kyufugakuHokenTaishoHiyogaku;
    private int kyufugakuRiyoshaJikofutangaku;
    private int kyufugakuHokenkyufuhigaku;
    private FlexibleDate sekoKanryoYoteiYMD;
    private RString shinseiTorikeshiJiyuCode;
    private RString biko;

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
     * 事業者番号のgetメソッドです。
     *
     * @return 事業者番号
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     *
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 事業者名称のgetメソッドです。
     *
     * @return 事業者名称
     */
    public RString getJigyoshaNameKanji() {
        return jigyoshaNameKanji;
    }

    /**
     * 事業者名称のsetメソッドです。
     *
     * @param jigyoshaNameKanji 事業者名称
     */
    public void setJigyoshaNameKanji(RString jigyoshaNameKanji) {
        this.jigyoshaNameKanji = jigyoshaNameKanji;
    }

    /**
     * 事業者名称カナのgetメソッドです。
     *
     * @return 事業者名称カナ
     */
    public RString getJigyoshaNameKana() {
        return jigyoshaNameKana;
    }

    /**
     * 事業者名称カナのsetメソッドです。
     *
     * @param jigyoshaNameKana 事業者名称カナ
     */
    public void setJigyoshaNameKana(RString jigyoshaNameKana) {
        this.jigyoshaNameKana = jigyoshaNameKana;
    }

    /**
     * 事業者郵便番号のgetメソッドです。
     *
     * @return 事業者郵便番号
     */
    public YubinNo getJigyoshaYubunNo() {
        return jigyoshaYubunNo;
    }

    /**
     * 事業者郵便番号のsetメソッドです。
     *
     * @param jigyoshaYubunNo 事業者郵便番号
     */
    public void setJigyoshaYubunNo(YubinNo jigyoshaYubunNo) {
        this.jigyoshaYubunNo = jigyoshaYubunNo;
    }

    /**
     * 事業者住所のgetメソッドです。
     *
     * @return 事業者住所
     */
    public RString getJigyoshaAddress() {
        return jigyoshaAddress;
    }

    /**
     * 事業者住所のsetメソッドです。
     *
     * @param jigyoshaAddress 事業者住所
     */
    public void setJigyoshaAddress(RString jigyoshaAddress) {
        this.jigyoshaAddress = jigyoshaAddress;
    }

    /**
     * 事業者電話番号のgetメソッドです。
     *
     * @return 事業者電話番号
     */
    public RString getJigyoshaTelNo() {
        return jigyoshaTelNo;
    }

    /**
     * 事業者電話番号のsetメソッドです。
     *
     * @param jigyoshaTelNo 事業者電話番号
     */
    public void setJigyoshaTelNo(RString jigyoshaTelNo) {
        this.jigyoshaTelNo = jigyoshaTelNo;
    }

    /**
     * 事業者ＦＡＸ番号のgetメソッドです。
     *
     * @return 事業者ＦＡＸ番号
     */
    public RString getJigyoshaFaxNo() {
        return jigyoshaFaxNo;
    }

    /**
     * 事業者ＦＡＸ番号のsetメソッドです。
     *
     * @param jigyoshaFaxNo 事業者ＦＡＸ番号
     */
    public void setJigyoshaFaxNo(RString jigyoshaFaxNo) {
        this.jigyoshaFaxNo = jigyoshaFaxNo;
    }

    /**
     * 理由書作成者のgetメソッドです。
     *
     * @return 理由書作成者
     */
    public RString getRiyushoSakuseishaKanji() {
        return riyushoSakuseishaKanji;
    }

    /**
     * 理由書作成者のsetメソッドです。
     *
     * @param riyushoSakuseishaKanji 理由書作成者
     */
    public void setRiyushoSakuseishaKanji(RString riyushoSakuseishaKanji) {
        this.riyushoSakuseishaKanji = riyushoSakuseishaKanji;
    }

    /**
     * 理由書作成者カナのgetメソッドです。
     *
     * @return 理由書作成者カナ
     */
    public RString getRiyushoSakuseishaKana() {
        return riyushoSakuseishaKana;
    }

    /**
     * 理由書作成者カナのsetメソッドです。
     *
     * @param riyushoSakuseishaKana 理由書作成者カナ
     */
    public void setRiyushoSakuseishaKana(RString riyushoSakuseishaKana) {
        this.riyushoSakuseishaKana = riyushoSakuseishaKana;
    }

    /**
     * サービス種類コードのgetメソッドです。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     *
     * @param serviceShuruiCode サービス種類コード
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * 契約決定年月日のgetメソッドです。
     *
     * @return 契約決定年月日
     */
    public FlexibleDate getKeiyakuKetteiYMD() {
        return keiyakuKetteiYMD;
    }

    /**
     * 契約決定年月日のsetメソッドです。
     *
     * @param keiyakuKetteiYMD 契約決定年月日
     */
    public void setKeiyakuKetteiYMD(FlexibleDate keiyakuKetteiYMD) {
        this.keiyakuKetteiYMD = keiyakuKetteiYMD;
    }

    /**
     * 承認区分のgetメソッドです。
     *
     * @return 承認区分
     */
    public RString getShoninKubun() {
        return shoninKubun;
    }

    /**
     * 承認区分のsetメソッドです。
     *
     * @param shoninKubun 承認区分
     */
    public void setShoninKubun(RString shoninKubun) {
        this.shoninKubun = shoninKubun;
    }

    /**
     * 不承認の理由のgetメソッドです。
     *
     * @return 不承認の理由
     */
    public RString getFushoninRiyu() {
        return fushoninRiyu;
    }

    /**
     * 不承認の理由のsetメソッドです。
     *
     * @param fushoninRiyu 不承認の理由
     */
    public void setFushoninRiyu(RString fushoninRiyu) {
        this.fushoninRiyu = fushoninRiyu;
    }

    /**
     * 給付額等・費用額合計のgetメソッドです。
     *
     * @return 給付額等・費用額合計
     */
    public int getKyufugakuHiyogakuTotal() {
        return kyufugakuHiyogakuTotal;
    }

    /**
     * 給付額等・費用額合計のsetメソッドです。
     *
     * @param kyufugakuHiyogakuTotal 給付額等・費用額合計
     */
    public void setKyufugakuHiyogakuTotal(int kyufugakuHiyogakuTotal) {
        this.kyufugakuHiyogakuTotal = kyufugakuHiyogakuTotal;
    }

    /**
     * 給付額等・保険対象費用額のgetメソッドです。
     *
     * @return 給付額等・保険対象費用額
     */
    public int getKyufugakuHokenTaishoHiyogaku() {
        return kyufugakuHokenTaishoHiyogaku;
    }

    /**
     * 給付額等・保険対象費用額のsetメソッドです。
     *
     * @param kyufugakuHokenTaishoHiyogaku 給付額等・保険対象費用額
     */
    public void setKyufugakuHokenTaishoHiyogaku(int kyufugakuHokenTaishoHiyogaku) {
        this.kyufugakuHokenTaishoHiyogaku = kyufugakuHokenTaishoHiyogaku;
    }

    /**
     * 給付額等・利用者自己負担額のgetメソッドです。
     *
     * @return 給付額等・利用者自己負担額
     */
    public int getKyufugakuRiyoshaJikofutangaku() {
        return kyufugakuRiyoshaJikofutangaku;
    }

    /**
     * 給付額等・利用者自己負担額のsetメソッドです。
     *
     * @param kyufugakuRiyoshaJikofutangaku 給付額等・利用者自己負担額
     */
    public void setKyufugakuRiyoshaJikofutangaku(int kyufugakuRiyoshaJikofutangaku) {
        this.kyufugakuRiyoshaJikofutangaku = kyufugakuRiyoshaJikofutangaku;
    }

    /**
     * 給付額等・保険給付費額のgetメソッドです。
     *
     * @return 給付額等・保険給付費額
     */
    public int getKyufugakuHokenkyufuhigaku() {
        return kyufugakuHokenkyufuhigaku;
    }

    /**
     * 給付額等・保険給付費額のsetメソッドです。
     *
     * @param kyufugakuHokenkyufuhigaku 給付額等・保険給付費額
     */
    public void setKyufugakuHokenkyufuhigaku(int kyufugakuHokenkyufuhigaku) {
        this.kyufugakuHokenkyufuhigaku = kyufugakuHokenkyufuhigaku;
    }

    /**
     * 施工完了予定年月日のgetメソッドです。
     *
     * @return 施工完了予定年月日
     */
    public FlexibleDate getSekoKanryoYoteiYMD() {
        return sekoKanryoYoteiYMD;
    }

    /**
     * 施工完了予定年月日のsetメソッドです。
     *
     * @param sekoKanryoYoteiYMD 施工完了予定年月日
     */
    public void setSekoKanryoYoteiYMD(FlexibleDate sekoKanryoYoteiYMD) {
        this.sekoKanryoYoteiYMD = sekoKanryoYoteiYMD;
    }

    /**
     * 申請取消事由コードのgetメソッドです。
     *
     * @return 申請取消事由コード
     */
    public RString getShinseiTorikeshiJiyuCode() {
        return shinseiTorikeshiJiyuCode;
    }

    /**
     * 申請取消事由コードのsetメソッドです。
     *
     * @param shinseiTorikeshiJiyuCode 申請取消事由コード
     */
    public void setShinseiTorikeshiJiyuCode(RString shinseiTorikeshiJiyuCode) {
        this.shinseiTorikeshiJiyuCode = shinseiTorikeshiJiyuCode;
    }

    /**
     * 備考のgetメソッドです。
     *
     * @return 備考
     */
    public RString getBiko() {
        return biko;
    }

    /**
     * 備考のsetメソッドです。
     *
     * @param biko 備考
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3035ShokanJutakuKaishuJizenShinseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3035ShokanJutakuKaishuJizenShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3035ShokanJutakuKaishuJizenShinseiEntity other) {
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
    public void shallowCopy(DbT3035ShokanJutakuKaishuJizenShinseiEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.rirekiNo = entity.rirekiNo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.shinseiYMD = entity.shinseiYMD;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.jigyoshaNameKanji = entity.jigyoshaNameKanji;
        this.jigyoshaNameKana = entity.jigyoshaNameKana;
        this.jigyoshaYubunNo = entity.jigyoshaYubunNo;
        this.jigyoshaAddress = entity.jigyoshaAddress;
        this.jigyoshaTelNo = entity.jigyoshaTelNo;
        this.jigyoshaFaxNo = entity.jigyoshaFaxNo;
        this.riyushoSakuseishaKanji = entity.riyushoSakuseishaKanji;
        this.riyushoSakuseishaKana = entity.riyushoSakuseishaKana;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.keiyakuKetteiYMD = entity.keiyakuKetteiYMD;
        this.shoninKubun = entity.shoninKubun;
        this.fushoninRiyu = entity.fushoninRiyu;
        this.kyufugakuHiyogakuTotal = entity.kyufugakuHiyogakuTotal;
        this.kyufugakuHokenTaishoHiyogaku = entity.kyufugakuHokenTaishoHiyogaku;
        this.kyufugakuRiyoshaJikofutangaku = entity.kyufugakuRiyoshaJikofutangaku;
        this.kyufugakuHokenkyufuhigaku = entity.kyufugakuHokenkyufuhigaku;
        this.sekoKanryoYoteiYMD = entity.sekoKanryoYoteiYMD;
        this.shinseiTorikeshiJiyuCode = entity.shinseiTorikeshiJiyuCode;
        this.biko = entity.biko;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, rirekiNo, shoKisaiHokenshaNo, uketsukeYMD, shinseiYMD, jigyoshaNo, jigyoshaNameKanji, jigyoshaNameKana, jigyoshaYubunNo, jigyoshaAddress, jigyoshaTelNo, jigyoshaFaxNo, riyushoSakuseishaKanji, riyushoSakuseishaKana, serviceShuruiCode, keiyakuKetteiYMD, shoninKubun, fushoninRiyu, kyufugakuHiyogakuTotal, kyufugakuHokenTaishoHiyogaku, kyufugakuRiyoshaJikofutangaku, kyufugakuHokenkyufuhigaku, sekoKanryoYoteiYMD, shinseiTorikeshiJiyuCode, biko);
    }

// </editor-fold>
}

package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 償還払請求基本テーブルのエンティティクラスです。
 */
public class DbT3038ShokanKihonEntity extends DbTableEntityBase<DbT3038ShokanKihonEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3038ShokanKihon");

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
    private RString seiriNp;
    @PrimaryKey
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private RString yoshikiNo;
    @PrimaryKey
    private RString meisaiNo;
    private RString kyuSochiNyushoshaTokureiCode;
    private RString kyotakuServiceSakuseiKubunCode;
    private JigyoshaNo kyotakuserviceJigyoshaNo;
    private FlexibleDate kaishiYMD;
    private FlexibleDate chushiYMD;
    private RString chushiRiyuNyushomaeJyokyoCode;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoYMD;
    private Decimal nyushoJitsuNissu;
    private Decimal gaihakuNissu;
    private RString taishogoJotaiCode;
    private HokenKyufuRitsu hokenKyufuritsu;
    private int serviceTanisu;
    private Decimal hokenSeikyugaku;
    private int riyoshaFutangaku;
    private Decimal kinkyuShisetsuRyoyoSeikyugaku;
    private Decimal tokuteiShinryoSeikyugaku;
    private int tokuteiNyushoshaKaigoServiceSeikyugaku;

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
    public RString getSeiriNp() {
        return seiriNp;
    }

    /**
     * 整理番号のsetメソッドです。
     *
     * @param seiriNp 整理番号
     */
    public void setSeiriNp(RString seiriNp) {
        this.seiriNp = seiriNp;
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
     * 様式番号のgetメソッドです。
     *
     * @return 様式番号
     */
    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    /**
     * 様式番号のsetメソッドです。
     *
     * @param yoshikiNo 様式番号
     */
    public void setYoshikiNo(RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * 明細番号のgetメソッドです。
     *
     * @return 明細番号
     */
    public RString getMeisaiNo() {
        return meisaiNo;
    }

    /**
     * 明細番号のsetメソッドです。
     *
     * @param meisaiNo 明細番号
     */
    public void setMeisaiNo(RString meisaiNo) {
        this.meisaiNo = meisaiNo;
    }

    /**
     * 旧措置入所者特例コードのgetメソッドです。
     *
     * @return 旧措置入所者特例コード
     */
    public RString getKyuSochiNyushoshaTokureiCode() {
        return kyuSochiNyushoshaTokureiCode;
    }

    /**
     * 旧措置入所者特例コードのsetメソッドです。
     *
     * @param kyuSochiNyushoshaTokureiCode 旧措置入所者特例コード
     */
    public void setKyuSochiNyushoshaTokureiCode(RString kyuSochiNyushoshaTokureiCode) {
        this.kyuSochiNyushoshaTokureiCode = kyuSochiNyushoshaTokureiCode;
    }

    /**
     * 居宅サービス計画作成区分コードのgetメソッドです。
     *
     * @return 居宅サービス計画作成区分コード
     */
    public RString getKyotakuServiceSakuseiKubunCode() {
        return kyotakuServiceSakuseiKubunCode;
    }

    /**
     * 居宅サービス計画作成区分コードのsetメソッドです。
     *
     * @param kyotakuServiceSakuseiKubunCode 居宅サービス計画作成区分コード
     */
    public void setKyotakuServiceSakuseiKubunCode(RString kyotakuServiceSakuseiKubunCode) {
        this.kyotakuServiceSakuseiKubunCode = kyotakuServiceSakuseiKubunCode;
    }

    /**
     * 居宅サービス計画事業者番号のgetメソッドです。
     *
     * @return 居宅サービス計画事業者番号
     */
    public JigyoshaNo getKyotakuserviceJigyoshaNo() {
        return kyotakuserviceJigyoshaNo;
    }

    /**
     * 居宅サービス計画事業者番号のsetメソッドです。
     *
     * @param kyotakuserviceJigyoshaNo 居宅サービス計画事業者番号
     */
    public void setKyotakuserviceJigyoshaNo(JigyoshaNo kyotakuserviceJigyoshaNo) {
        this.kyotakuserviceJigyoshaNo = kyotakuserviceJigyoshaNo;
    }

    /**
     * 開始年月日のgetメソッドです。
     *
     * @return 開始年月日
     */
    public FlexibleDate getKaishiYMD() {
        return kaishiYMD;
    }

    /**
     * 開始年月日のsetメソッドです。
     *
     * @param kaishiYMD 開始年月日
     */
    public void setKaishiYMD(FlexibleDate kaishiYMD) {
        this.kaishiYMD = kaishiYMD;
    }

    /**
     * 中止年月日のgetメソッドです。
     *
     * @return 中止年月日
     */
    public FlexibleDate getChushiYMD() {
        return chushiYMD;
    }

    /**
     * 中止年月日のsetメソッドです。
     *
     * @param chushiYMD 中止年月日
     */
    public void setChushiYMD(FlexibleDate chushiYMD) {
        this.chushiYMD = chushiYMD;
    }

    /**
     * 中止理由・入所（院）前の状況コードのgetメソッドです。
     *
     * @return 中止理由・入所（院）前の状況コード
     */
    public RString getChushiRiyuNyushomaeJyokyoCode() {
        return chushiRiyuNyushomaeJyokyoCode;
    }

    /**
     * 中止理由・入所（院）前の状況コードのsetメソッドです。
     *
     * @param chushiRiyuNyushomaeJyokyoCode 中止理由・入所（院）前の状況コード
     */
    public void setChushiRiyuNyushomaeJyokyoCode(RString chushiRiyuNyushomaeJyokyoCode) {
        this.chushiRiyuNyushomaeJyokyoCode = chushiRiyuNyushomaeJyokyoCode;
    }

    /**
     * 入所（院）年月日のgetメソッドです。
     *
     * @return 入所（院）年月日
     */
    public FlexibleDate getNyushoYMD() {
        return nyushoYMD;
    }

    /**
     * 入所（院）年月日のsetメソッドです。
     *
     * @param nyushoYMD 入所（院）年月日
     */
    public void setNyushoYMD(FlexibleDate nyushoYMD) {
        this.nyushoYMD = nyushoYMD;
    }

    /**
     * 退所（院）年月日のgetメソッドです。
     *
     * @return 退所（院）年月日
     */
    public FlexibleDate getTaishoYMD() {
        return taishoYMD;
    }

    /**
     * 退所（院）年月日のsetメソッドです。
     *
     * @param taishoYMD 退所（院）年月日
     */
    public void setTaishoYMD(FlexibleDate taishoYMD) {
        this.taishoYMD = taishoYMD;
    }

    /**
     * 入所（院）実日数のgetメソッドです。
     *
     * @return 入所（院）実日数
     */
    public Decimal getNyushoJitsuNissu() {
        return nyushoJitsuNissu;
    }

    /**
     * 入所（院）実日数のsetメソッドです。
     *
     * @param nyushoJitsuNissu 入所（院）実日数
     */
    public void setNyushoJitsuNissu(Decimal nyushoJitsuNissu) {
        this.nyushoJitsuNissu = nyushoJitsuNissu;
    }

    /**
     * 外泊日数のgetメソッドです。
     *
     * @return 外泊日数
     */
    public Decimal getGaihakuNissu() {
        return gaihakuNissu;
    }

    /**
     * 外泊日数のsetメソッドです。
     *
     * @param gaihakuNissu 外泊日数
     */
    public void setGaihakuNissu(Decimal gaihakuNissu) {
        this.gaihakuNissu = gaihakuNissu;
    }

    /**
     * 退所（院）後の状態コードのgetメソッドです。
     *
     * @return 退所（院）後の状態コード
     */
    public RString getTaishogoJotaiCode() {
        return taishogoJotaiCode;
    }

    /**
     * 退所（院）後の状態コードのsetメソッドです。
     *
     * @param taishogoJotaiCode 退所（院）後の状態コード
     */
    public void setTaishogoJotaiCode(RString taishogoJotaiCode) {
        this.taishogoJotaiCode = taishogoJotaiCode;
    }

    /**
     * 保険給付率のgetメソッドです。
     *
     * @return 保険給付率
     */
    public HokenKyufuRitsu getHokenKyufuritsu() {
        return hokenKyufuritsu;
    }

    /**
     * 保険給付率のsetメソッドです。
     *
     * @param hokenKyufuritsu 保険給付率
     */
    public void setHokenKyufuritsu(HokenKyufuRitsu hokenKyufuritsu) {
        this.hokenKyufuritsu = hokenKyufuritsu;
    }

    /**
     * サービス単位数のgetメソッドです。
     *
     * @return サービス単位数
     */
    public int getServiceTanisu() {
        return serviceTanisu;
    }

    /**
     * サービス単位数のsetメソッドです。
     *
     * @param serviceTanisu サービス単位数
     */
    public void setServiceTanisu(int serviceTanisu) {
        this.serviceTanisu = serviceTanisu;
    }

    /**
     * 保険請求額のgetメソッドです。
     *
     * @return 保険請求額
     */
    public Decimal getHokenSeikyugaku() {
        return hokenSeikyugaku;
    }

    /**
     * 保険請求額のsetメソッドです。
     *
     * @param hokenSeikyugaku 保険請求額
     */
    public void setHokenSeikyugaku(Decimal hokenSeikyugaku) {
        this.hokenSeikyugaku = hokenSeikyugaku;
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
     * 緊急時施設療養費請求額のgetメソッドです。
     *
     * @return 緊急時施設療養費請求額
     */
    public Decimal getKinkyuShisetsuRyoyoSeikyugaku() {
        return kinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 緊急時施設療養費請求額のsetメソッドです。
     *
     * @param kinkyuShisetsuRyoyoSeikyugaku 緊急時施設療養費請求額
     */
    public void setKinkyuShisetsuRyoyoSeikyugaku(Decimal kinkyuShisetsuRyoyoSeikyugaku) {
        this.kinkyuShisetsuRyoyoSeikyugaku = kinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 特定診療費請求額のgetメソッドです。
     *
     * @return 特定診療費請求額
     */
    public Decimal getTokuteiShinryoSeikyugaku() {
        return tokuteiShinryoSeikyugaku;
    }

    /**
     * 特定診療費請求額のsetメソッドです。
     *
     * @param tokuteiShinryoSeikyugaku 特定診療費請求額
     */
    public void setTokuteiShinryoSeikyugaku(Decimal tokuteiShinryoSeikyugaku) {
        this.tokuteiShinryoSeikyugaku = tokuteiShinryoSeikyugaku;
    }

    /**
     * 特定入所者介護サービス費等請求額のgetメソッドです。
     *
     * @return 特定入所者介護サービス費等請求額
     */
    public int getTokuteiNyushoshaKaigoServiceSeikyugaku() {
        return tokuteiNyushoshaKaigoServiceSeikyugaku;
    }

    /**
     * 特定入所者介護サービス費等請求額のsetメソッドです。
     *
     * @param tokuteiNyushoshaKaigoServiceSeikyugaku 特定入所者介護サービス費等請求額
     */
    public void setTokuteiNyushoshaKaigoServiceSeikyugaku(int tokuteiNyushoshaKaigoServiceSeikyugaku) {
        this.tokuteiNyushoshaKaigoServiceSeikyugaku = tokuteiNyushoshaKaigoServiceSeikyugaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3038ShokanKihonEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT3038ShokanKihonEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3038ShokanKihonEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNp, other.seiriNp)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yoshikiNo, other.yoshikiNo)) {
            return false;
        }
        if (this.meisaiNo != other.meisaiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3038ShokanKihonEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNp = entity.seiriNp;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.meisaiNo = entity.meisaiNo;
        this.kyuSochiNyushoshaTokureiCode = entity.kyuSochiNyushoshaTokureiCode;
        this.kyotakuServiceSakuseiKubunCode = entity.kyotakuServiceSakuseiKubunCode;
        this.kyotakuserviceJigyoshaNo = entity.kyotakuserviceJigyoshaNo;
        this.kaishiYMD = entity.kaishiYMD;
        this.chushiYMD = entity.chushiYMD;
        this.chushiRiyuNyushomaeJyokyoCode = entity.chushiRiyuNyushomaeJyokyoCode;
        this.nyushoYMD = entity.nyushoYMD;
        this.taishoYMD = entity.taishoYMD;
        this.nyushoJitsuNissu = entity.nyushoJitsuNissu;
        this.gaihakuNissu = entity.gaihakuNissu;
        this.taishogoJotaiCode = entity.taishogoJotaiCode;
        this.hokenKyufuritsu = entity.hokenKyufuritsu;
        this.serviceTanisu = entity.serviceTanisu;
        this.hokenSeikyugaku = entity.hokenSeikyugaku;
        this.riyoshaFutangaku = entity.riyoshaFutangaku;
        this.kinkyuShisetsuRyoyoSeikyugaku = entity.kinkyuShisetsuRyoyoSeikyugaku;
        this.tokuteiShinryoSeikyugaku = entity.tokuteiShinryoSeikyugaku;
        this.tokuteiNyushoshaKaigoServiceSeikyugaku = entity.tokuteiNyushoshaKaigoServiceSeikyugaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNp, jigyoshaNo, yoshikiNo, meisaiNo, kyuSochiNyushoshaTokureiCode, kyotakuServiceSakuseiKubunCode, kyotakuserviceJigyoshaNo, kaishiYMD, chushiYMD, chushiRiyuNyushomaeJyokyoCode, nyushoYMD, taishoYMD, nyushoJitsuNissu, gaihakuNissu, taishogoJotaiCode, hokenKyufuritsu, serviceTanisu, hokenSeikyugaku, riyoshaFutangaku, kinkyuShisetsuRyoyoSeikyugaku, tokuteiShinryoSeikyugaku, tokuteiNyushoshaKaigoServiceSeikyugaku);
    }

// </editor-fold>
}

package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
 * DbT3038ShokanKihonの項目定義クラスです
 *
 */
public class DbT3038ShokanKihonEntity extends DbTableEntityBase<DbT3038ShokanKihonEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    private YMDHMS shoriTimestamp;
    private RString kyuSochiNyushoshaTokureiCode;
    private RString kyotakuServiceSakuseiKubunCode;
    private JigyoshaNo kyotakuserviceJigyoshaNo;
    private FlexibleDate kaishiYMD;
    private FlexibleDate chushiYMD;
    private RString chushiRiyuNyushomaeJyokyoCode;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoYMD;
    private int nyushoJitsuNissu;
    private int gaihakuNissu;
    private RString taishogoJotaiCode;
    private HokenKyufuRitsu hokenKyufuritsu;
    private int serviceTanisu;
    private Decimal hokenSeikyugaku;
    private int riyoshaFutangaku;
    private Decimal kinkyuShisetsuRyoyoSeikyugaku;
    private Decimal tokuteiShinryoSeikyugaku;
    private int tokuteiNyushoshaKaigoServiceSeikyugaku;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getServiceTeikyoYM
     *
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getSeiriNp
     *
     * @return seiriNp
     */
    public RString getSeiriNp() {
        return seiriNp;
    }

    /**
     * setSeiriNp
     *
     * @param seiriNp seiriNp
     */
    public void setSeiriNp(RString seiriNp) {
        this.seiriNp = seiriNp;
    }

    /**
     * getJigyoshaNo
     *
     * @return jigyoshaNo
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     *
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getYoshikiNo
     *
     * @return yoshikiNo
     */
    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    /**
     * setYoshikiNo
     *
     * @param yoshikiNo yoshikiNo
     */
    public void setYoshikiNo(RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getKyuSochiNyushoshaTokureiCode
     *
     * @return kyuSochiNyushoshaTokureiCode
     */
    public RString getKyuSochiNyushoshaTokureiCode() {
        return kyuSochiNyushoshaTokureiCode;
    }

    /**
     * setKyuSochiNyushoshaTokureiCode
     *
     * @param kyuSochiNyushoshaTokureiCode kyuSochiNyushoshaTokureiCode
     */
    public void setKyuSochiNyushoshaTokureiCode(RString kyuSochiNyushoshaTokureiCode) {
        this.kyuSochiNyushoshaTokureiCode = kyuSochiNyushoshaTokureiCode;
    }

    /**
     * getKyotakuServiceSakuseiKubunCode
     *
     * @return kyotakuServiceSakuseiKubunCode
     */
    public RString getKyotakuServiceSakuseiKubunCode() {
        return kyotakuServiceSakuseiKubunCode;
    }

    /**
     * setKyotakuServiceSakuseiKubunCode
     *
     * @param kyotakuServiceSakuseiKubunCode kyotakuServiceSakuseiKubunCode
     */
    public void setKyotakuServiceSakuseiKubunCode(RString kyotakuServiceSakuseiKubunCode) {
        this.kyotakuServiceSakuseiKubunCode = kyotakuServiceSakuseiKubunCode;
    }

    /**
     * getKyotakuserviceJigyoshaNo
     *
     * @return kyotakuserviceJigyoshaNo
     */
    public JigyoshaNo getKyotakuserviceJigyoshaNo() {
        return kyotakuserviceJigyoshaNo;
    }

    /**
     * setKyotakuserviceJigyoshaNo
     *
     * @param kyotakuserviceJigyoshaNo kyotakuserviceJigyoshaNo
     */
    public void setKyotakuserviceJigyoshaNo(JigyoshaNo kyotakuserviceJigyoshaNo) {
        this.kyotakuserviceJigyoshaNo = kyotakuserviceJigyoshaNo;
    }

    /**
     * getKaishiYMD
     *
     * @return kaishiYMD
     */
    public FlexibleDate getKaishiYMD() {
        return kaishiYMD;
    }

    /**
     * setKaishiYMD
     *
     * @param kaishiYMD kaishiYMD
     */
    public void setKaishiYMD(FlexibleDate kaishiYMD) {
        this.kaishiYMD = kaishiYMD;
    }

    /**
     * getChushiYMD
     *
     * @return chushiYMD
     */
    public FlexibleDate getChushiYMD() {
        return chushiYMD;
    }

    /**
     * setChushiYMD
     *
     * @param chushiYMD chushiYMD
     */
    public void setChushiYMD(FlexibleDate chushiYMD) {
        this.chushiYMD = chushiYMD;
    }

    /**
     * getChushiRiyuNyushomaeJyokyoCode
     *
     * @return chushiRiyuNyushomaeJyokyoCode
     */
    public RString getChushiRiyuNyushomaeJyokyoCode() {
        return chushiRiyuNyushomaeJyokyoCode;
    }

    /**
     * setChushiRiyuNyushomaeJyokyoCode
     *
     * @param chushiRiyuNyushomaeJyokyoCode chushiRiyuNyushomaeJyokyoCode
     */
    public void setChushiRiyuNyushomaeJyokyoCode(RString chushiRiyuNyushomaeJyokyoCode) {
        this.chushiRiyuNyushomaeJyokyoCode = chushiRiyuNyushomaeJyokyoCode;
    }

    /**
     * getNyushoYMD
     *
     * @return nyushoYMD
     */
    public FlexibleDate getNyushoYMD() {
        return nyushoYMD;
    }

    /**
     * setNyushoYMD
     *
     * @param nyushoYMD nyushoYMD
     */
    public void setNyushoYMD(FlexibleDate nyushoYMD) {
        this.nyushoYMD = nyushoYMD;
    }

    /**
     * getTaishoYMD
     *
     * @return taishoYMD
     */
    public FlexibleDate getTaishoYMD() {
        return taishoYMD;
    }

    /**
     * setTaishoYMD
     *
     * @param taishoYMD taishoYMD
     */
    public void setTaishoYMD(FlexibleDate taishoYMD) {
        this.taishoYMD = taishoYMD;
    }

    /**
     * getNyushoJitsuNissu
     *
     * @return nyushoJitsuNissu
     */
    public int getNyushoJitsuNissu() {
        return nyushoJitsuNissu;
    }

    /**
     * setNyushoJitsuNissu
     *
     * @param nyushoJitsuNissu nyushoJitsuNissu
     */
    public void setNyushoJitsuNissu(int nyushoJitsuNissu) {
        this.nyushoJitsuNissu = nyushoJitsuNissu;
    }

    /**
     * getGaihakuNissu
     *
     * @return gaihakuNissu
     */
    public int getGaihakuNissu() {
        return gaihakuNissu;
    }

    /**
     * setGaihakuNissu
     *
     * @param gaihakuNissu gaihakuNissu
     */
    public void setGaihakuNissu(int gaihakuNissu) {
        this.gaihakuNissu = gaihakuNissu;
    }

    /**
     * getTaishogoJotaiCode
     *
     * @return taishogoJotaiCode
     */
    public RString getTaishogoJotaiCode() {
        return taishogoJotaiCode;
    }

    /**
     * setTaishogoJotaiCode
     *
     * @param taishogoJotaiCode taishogoJotaiCode
     */
    public void setTaishogoJotaiCode(RString taishogoJotaiCode) {
        this.taishogoJotaiCode = taishogoJotaiCode;
    }

    /**
     * getHokenKyufuritsu
     *
     * @return hokenKyufuritsu
     */
    public HokenKyufuRitsu getHokenKyufuritsu() {
        return hokenKyufuritsu;
    }

    /**
     * setHokenKyufuritsu
     *
     * @param hokenKyufuritsu hokenKyufuritsu
     */
    public void setHokenKyufuritsu(HokenKyufuRitsu hokenKyufuritsu) {
        this.hokenKyufuritsu = hokenKyufuritsu;
    }

    /**
     * getServiceTanisu
     *
     * @return serviceTanisu
     */
    public int getServiceTanisu() {
        return serviceTanisu;
    }

    /**
     * setServiceTanisu
     *
     * @param serviceTanisu serviceTanisu
     */
    public void setServiceTanisu(int serviceTanisu) {
        this.serviceTanisu = serviceTanisu;
    }

    /**
     * getHokenSeikyugaku
     *
     * @return hokenSeikyugaku
     */
    public Decimal getHokenSeikyugaku() {
        return hokenSeikyugaku;
    }

    /**
     * setHokenSeikyugaku
     *
     * @param hokenSeikyugaku hokenSeikyugaku
     */
    public void setHokenSeikyugaku(Decimal hokenSeikyugaku) {
        this.hokenSeikyugaku = hokenSeikyugaku;
    }

    /**
     * getRiyoshaFutangaku
     *
     * @return riyoshaFutangaku
     */
    public int getRiyoshaFutangaku() {
        return riyoshaFutangaku;
    }

    /**
     * setRiyoshaFutangaku
     *
     * @param riyoshaFutangaku riyoshaFutangaku
     */
    public void setRiyoshaFutangaku(int riyoshaFutangaku) {
        this.riyoshaFutangaku = riyoshaFutangaku;
    }

    /**
     * getKinkyuShisetsuRyoyoSeikyugaku
     *
     * @return kinkyuShisetsuRyoyoSeikyugaku
     */
    public Decimal getKinkyuShisetsuRyoyoSeikyugaku() {
        return kinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * setKinkyuShisetsuRyoyoSeikyugaku
     *
     * @param kinkyuShisetsuRyoyoSeikyugaku kinkyuShisetsuRyoyoSeikyugaku
     */
    public void setKinkyuShisetsuRyoyoSeikyugaku(Decimal kinkyuShisetsuRyoyoSeikyugaku) {
        this.kinkyuShisetsuRyoyoSeikyugaku = kinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * getTokuteiShinryoSeikyugaku
     *
     * @return tokuteiShinryoSeikyugaku
     */
    public Decimal getTokuteiShinryoSeikyugaku() {
        return tokuteiShinryoSeikyugaku;
    }

    /**
     * setTokuteiShinryoSeikyugaku
     *
     * @param tokuteiShinryoSeikyugaku tokuteiShinryoSeikyugaku
     */
    public void setTokuteiShinryoSeikyugaku(Decimal tokuteiShinryoSeikyugaku) {
        this.tokuteiShinryoSeikyugaku = tokuteiShinryoSeikyugaku;
    }

    /**
     * getTokuteiNyushoshaKaigoServiceSeikyugaku
     *
     * @return tokuteiNyushoshaKaigoServiceSeikyugaku
     */
    public int getTokuteiNyushoshaKaigoServiceSeikyugaku() {
        return tokuteiNyushoshaKaigoServiceSeikyugaku;
    }

    /**
     * setTokuteiNyushoshaKaigoServiceSeikyugaku
     *
     * @param tokuteiNyushoshaKaigoServiceSeikyugaku tokuteiNyushoshaKaigoServiceSeikyugaku
     */
    public void setTokuteiNyushoshaKaigoServiceSeikyugaku(int tokuteiNyushoshaKaigoServiceSeikyugaku) {
        this.tokuteiNyushoshaKaigoServiceSeikyugaku = tokuteiNyushoshaKaigoServiceSeikyugaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3038ShokanKihonEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3038ShokanKihonEntity}の場合{@literal true}、それ以外の場合は{@literal false}
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
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
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
        this.shoriTimestamp = entity.shoriTimestamp;
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
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNp, jigyoshaNo, yoshikiNo, shoriTimestamp, kyuSochiNyushoshaTokureiCode, kyotakuServiceSakuseiKubunCode, kyotakuserviceJigyoshaNo, kaishiYMD, chushiYMD, chushiRiyuNyushomaeJyokyoCode, nyushoYMD, taishoYMD, nyushoJitsuNissu, gaihakuNissu, taishogoJotaiCode, hokenKyufuritsu, serviceTanisu, hokenSeikyugaku, riyoshaFutangaku, kinkyuShisetsuRyoyoSeikyugaku, tokuteiShinryoSeikyugaku, tokuteiNyushoshaKaigoServiceSeikyugaku);
    }

// </editor-fold>
}

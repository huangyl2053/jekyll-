package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績特定診療費・特別療養費テーブルのエンティティクラスです。
 * <br/> サービス提供年月が平成１５年４月以後の場合
 */
public class DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity extends DbTableEntityBase<DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    @PrimaryKey
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @PrimaryKey
    private RString recodeShubetsuCode;
    @PrimaryKey
    private HokenshaNo shokisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private JigyoshaNo jigyoshoNo;
    @PrimaryKey
    private RString toshiNo;
    @PrimaryKey
    private RString recodeJunjiNo;
    private RString shobyoName;
    private RString shikibetsuNo;
    private Decimal tanisu;
    private Decimal hokenKaisu;
    private int hokenServiceTanisu;
    private int hokenTotalTanisu;
    private Decimal kohi1Kaisu;
    private int kohi1ServiceTanisu;
    private int kohi1TotalTanisu;
    private Decimal kohi2Kaisu;
    private int kohi2ServiceTanisu;
    private int kohi2TotalTanisu;
    private Decimal kohi3Kaisu;
    private int kohi3ServiceTanisu;
    private int kohi3TotalTanisu;
    private RString tekiyo;
    private Decimal atoTanisu;
    private Decimal atoHokenKaisu;
    private int atoHokenServiceTanisu;
    private int atoHokenTotalTanisu;
    private Decimal atoKohi1Kaisu;
    private int atoKohi1ServiceTanisu;
    private int atoKohi1TotalTanisu;
    private Decimal atoKohi2Kaisu;
    private int atoKohi2ServiceTanisu;
    private int atoKohi2TotalTanisu;
    private Decimal atoKohi3Kaisu;
    private int atoKohi3ServiceTanisu;
    private int atoKohi3TotalTanisu;
    private Decimal saishinsaKaisu;
    private Decimal kagoKaisu;
    private FlexibleYearMonth shinsaYM;
    private RString seiriNo;
    private FlexibleYearMonth torikomiYM;

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
     * 交換情報識別番号のgetメソッドです。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo getKokanJohoShikibetsuNo() {
        return kokanJohoShikibetsuNo;
    }

    /**
     * 交換情報識別番号のsetメソッドです。
     *
     * @param kokanJohoShikibetsuNo 交換情報識別番号
     */
    public void setKokanJohoShikibetsuNo(KokanShikibetsuNo kokanJohoShikibetsuNo) {
        this.kokanJohoShikibetsuNo = kokanJohoShikibetsuNo;
    }

    /**
     * 入力識別番号のgetメソッドです。
     *
     * @return 入力識別番号
     */
    public NyuryokuShikibetsuNo getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * 入力識別番号のsetメソッドです。
     *
     * @param inputShikibetsuNo 入力識別番号
     */
    public void setInputShikibetsuNo(NyuryokuShikibetsuNo inputShikibetsuNo) {
        this.inputShikibetsuNo = inputShikibetsuNo;
    }

    /**
     * レコード種別コードのgetメソッドです。
     *
     * @return レコード種別コード
     */
    public RString getRecodeShubetsuCode() {
        return recodeShubetsuCode;
    }

    /**
     * レコード種別コードのsetメソッドです。
     *
     * @param recodeShubetsuCode レコード種別コード
     */
    public void setRecodeShubetsuCode(RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shokisaiHokenshaNo 証記載保険者番号
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
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
     * 事業所番号のgetメソッドです。
     *
     * @return 事業所番号
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * 事業所番号のsetメソッドです。
     *
     * @param jigyoshoNo 事業所番号
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * 通し番号のgetメソッドです。
     *
     * @return 通し番号
     */
    public RString getToshiNo() {
        return toshiNo;
    }

    /**
     * 通し番号のsetメソッドです。
     *
     * @param toshiNo 通し番号
     */
    public void setToshiNo(RString toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * 特定診療情報レコード順次番号のgetメソッドです。
     *
     * @return 特定診療情報レコード順次番号
     */
    public RString getRecodeJunjiNo() {
        return recodeJunjiNo;
    }

    /**
     * 特定診療情報レコード順次番号のsetメソッドです。
     *
     * @param recodeJunjiNo 特定診療情報レコード順次番号
     */
    public void setRecodeJunjiNo(RString recodeJunjiNo) {
        this.recodeJunjiNo = recodeJunjiNo;
    }

    /**
     * 傷病名のgetメソッドです。
     *
     * @return 傷病名
     */
    public RString getShobyoName() {
        return shobyoName;
    }

    /**
     * 傷病名のsetメソッドです。
     *
     * @param shobyoName 傷病名
     */
    public void setShobyoName(RString shobyoName) {
        this.shobyoName = shobyoName;
    }

    /**
     * 識別番号のgetメソッドです。
     * <br/>
     * <br/>介護給付費等の記載要領で示される特定診療費の識別
     * <br/>番号のうち、＠を除く２桁の数字
     *
     * @return 識別番号
     */
    public RString getShikibetsuNo() {
        return shikibetsuNo;
    }

    /**
     * 識別番号のsetメソッドです。
     * <br/>
     * <br/>介護給付費等の記載要領で示される特定診療費の識別
     * <br/>番号のうち、＠を除く２桁の数字
     *
     * @param shikibetsuNo 識別番号
     */
    public void setShikibetsuNo(RString shikibetsuNo) {
        this.shikibetsuNo = shikibetsuNo;
    }

    /**
     * 単位数のgetメソッドです。
     *
     * @return 単位数
     */
    public Decimal getTanisu() {
        return tanisu;
    }

    /**
     * 単位数のsetメソッドです。
     *
     * @param tanisu 単位数
     */
    public void setTanisu(Decimal tanisu) {
        this.tanisu = tanisu;
    }

    /**
     * 保険・回数のgetメソッドです。
     *
     * @return 保険・回数
     */
    public Decimal getHokenKaisu() {
        return hokenKaisu;
    }

    /**
     * 保険・回数のsetメソッドです。
     *
     * @param hokenKaisu 保険・回数
     */
    public void setHokenKaisu(Decimal hokenKaisu) {
        this.hokenKaisu = hokenKaisu;
    }

    /**
     * 保険・ｻｰﾋﾞｽ単位数のgetメソッドです。
     *
     * @return 保険・ｻｰﾋﾞｽ単位数
     */
    public int getHokenServiceTanisu() {
        return hokenServiceTanisu;
    }

    /**
     * 保険・ｻｰﾋﾞｽ単位数のsetメソッドです。
     *
     * @param hokenServiceTanisu 保険・ｻｰﾋﾞｽ単位数
     */
    public void setHokenServiceTanisu(int hokenServiceTanisu) {
        this.hokenServiceTanisu = hokenServiceTanisu;
    }

    /**
     * 保険・合計単位数のgetメソッドです。
     *
     * @return 保険・合計単位数
     */
    public int getHokenTotalTanisu() {
        return hokenTotalTanisu;
    }

    /**
     * 保険・合計単位数のsetメソッドです。
     *
     * @param hokenTotalTanisu 保険・合計単位数
     */
    public void setHokenTotalTanisu(int hokenTotalTanisu) {
        this.hokenTotalTanisu = hokenTotalTanisu;
    }

    /**
     * 公費１・回数のgetメソッドです。
     *
     * @return 公費１・回数
     */
    public Decimal getKohi1Kaisu() {
        return kohi1Kaisu;
    }

    /**
     * 公費１・回数のsetメソッドです。
     *
     * @param kohi1Kaisu 公費１・回数
     */
    public void setKohi1Kaisu(Decimal kohi1Kaisu) {
        this.kohi1Kaisu = kohi1Kaisu;
    }

    /**
     * 公費１・ｻｰﾋﾞｽ単位数のgetメソッドです。
     *
     * @return 公費１・ｻｰﾋﾞｽ単位数
     */
    public int getKohi1ServiceTanisu() {
        return kohi1ServiceTanisu;
    }

    /**
     * 公費１・ｻｰﾋﾞｽ単位数のsetメソッドです。
     *
     * @param kohi1ServiceTanisu 公費１・ｻｰﾋﾞｽ単位数
     */
    public void setKohi1ServiceTanisu(int kohi1ServiceTanisu) {
        this.kohi1ServiceTanisu = kohi1ServiceTanisu;
    }

    /**
     * 公費１・合計単位数のgetメソッドです。
     *
     * @return 公費１・合計単位数
     */
    public int getKohi1TotalTanisu() {
        return kohi1TotalTanisu;
    }

    /**
     * 公費１・合計単位数のsetメソッドです。
     *
     * @param kohi1TotalTanisu 公費１・合計単位数
     */
    public void setKohi1TotalTanisu(int kohi1TotalTanisu) {
        this.kohi1TotalTanisu = kohi1TotalTanisu;
    }

    /**
     * 公費２・回数のgetメソッドです。
     *
     * @return 公費２・回数
     */
    public Decimal getKohi2Kaisu() {
        return kohi2Kaisu;
    }

    /**
     * 公費２・回数のsetメソッドです。
     *
     * @param kohi2Kaisu 公費２・回数
     */
    public void setKohi2Kaisu(Decimal kohi2Kaisu) {
        this.kohi2Kaisu = kohi2Kaisu;
    }

    /**
     * 公費２・ｻｰﾋﾞｽ単位数のgetメソッドです。
     *
     * @return 公費２・ｻｰﾋﾞｽ単位数
     */
    public int getKohi2ServiceTanisu() {
        return kohi2ServiceTanisu;
    }

    /**
     * 公費２・ｻｰﾋﾞｽ単位数のsetメソッドです。
     *
     * @param kohi2ServiceTanisu 公費２・ｻｰﾋﾞｽ単位数
     */
    public void setKohi2ServiceTanisu(int kohi2ServiceTanisu) {
        this.kohi2ServiceTanisu = kohi2ServiceTanisu;
    }

    /**
     * 公費２・合計単位数のgetメソッドです。
     *
     * @return 公費２・合計単位数
     */
    public int getKohi2TotalTanisu() {
        return kohi2TotalTanisu;
    }

    /**
     * 公費２・合計単位数のsetメソッドです。
     *
     * @param kohi2TotalTanisu 公費２・合計単位数
     */
    public void setKohi2TotalTanisu(int kohi2TotalTanisu) {
        this.kohi2TotalTanisu = kohi2TotalTanisu;
    }

    /**
     * 公費３・回数のgetメソッドです。
     *
     * @return 公費３・回数
     */
    public Decimal getKohi3Kaisu() {
        return kohi3Kaisu;
    }

    /**
     * 公費３・回数のsetメソッドです。
     *
     * @param kohi3Kaisu 公費３・回数
     */
    public void setKohi3Kaisu(Decimal kohi3Kaisu) {
        this.kohi3Kaisu = kohi3Kaisu;
    }

    /**
     * 公費３・ｻｰﾋﾞｽ単位数のgetメソッドです。
     *
     * @return 公費３・ｻｰﾋﾞｽ単位数
     */
    public int getKohi3ServiceTanisu() {
        return kohi3ServiceTanisu;
    }

    /**
     * 公費３・ｻｰﾋﾞｽ単位数のsetメソッドです。
     *
     * @param kohi3ServiceTanisu 公費３・ｻｰﾋﾞｽ単位数
     */
    public void setKohi3ServiceTanisu(int kohi3ServiceTanisu) {
        this.kohi3ServiceTanisu = kohi3ServiceTanisu;
    }

    /**
     * 公費３・合計単位数のgetメソッドです。
     *
     * @return 公費３・合計単位数
     */
    public int getKohi3TotalTanisu() {
        return kohi3TotalTanisu;
    }

    /**
     * 公費３・合計単位数のsetメソッドです。
     *
     * @param kohi3TotalTanisu 公費３・合計単位数
     */
    public void setKohi3TotalTanisu(int kohi3TotalTanisu) {
        this.kohi3TotalTanisu = kohi3TotalTanisu;
    }

    /**
     * 摘要のgetメソッドです。
     *
     * @return 摘要
     */
    public RString getTekiyo() {
        return tekiyo;
    }

    /**
     * 摘要のsetメソッドです。
     *
     * @param tekiyo 摘要
     */
    public void setTekiyo(RString tekiyo) {
        this.tekiyo = tekiyo;
    }

    /**
     * 後・単位数のgetメソッドです。
     *
     * @return 後・単位数
     */
    public Decimal getAtoTanisu() {
        return atoTanisu;
    }

    /**
     * 後・単位数のsetメソッドです。
     *
     * @param atoTanisu 後・単位数
     */
    public void setAtoTanisu(Decimal atoTanisu) {
        this.atoTanisu = atoTanisu;
    }

    /**
     * 後・保険・回数のgetメソッドです。
     *
     * @return 後・保険・回数
     */
    public Decimal getAtoHokenKaisu() {
        return atoHokenKaisu;
    }

    /**
     * 後・保険・回数のsetメソッドです。
     *
     * @param atoHokenKaisu 後・保険・回数
     */
    public void setAtoHokenKaisu(Decimal atoHokenKaisu) {
        this.atoHokenKaisu = atoHokenKaisu;
    }

    /**
     * 後・保険・ｻｰﾋﾞｽ単位数のgetメソッドです。
     *
     * @return 後・保険・ｻｰﾋﾞｽ単位数
     */
    public int getAtoHokenServiceTanisu() {
        return atoHokenServiceTanisu;
    }

    /**
     * 後・保険・ｻｰﾋﾞｽ単位数のsetメソッドです。
     *
     * @param atoHokenServiceTanisu 後・保険・ｻｰﾋﾞｽ単位数
     */
    public void setAtoHokenServiceTanisu(int atoHokenServiceTanisu) {
        this.atoHokenServiceTanisu = atoHokenServiceTanisu;
    }

    /**
     * 後・保険・合計単位数のgetメソッドです。
     *
     * @return 後・保険・合計単位数
     */
    public int getAtoHokenTotalTanisu() {
        return atoHokenTotalTanisu;
    }

    /**
     * 後・保険・合計単位数のsetメソッドです。
     *
     * @param atoHokenTotalTanisu 後・保険・合計単位数
     */
    public void setAtoHokenTotalTanisu(int atoHokenTotalTanisu) {
        this.atoHokenTotalTanisu = atoHokenTotalTanisu;
    }

    /**
     * 後・公費１・回数のgetメソッドです。
     *
     * @return 後・公費１・回数
     */
    public Decimal getAtoKohi1Kaisu() {
        return atoKohi1Kaisu;
    }

    /**
     * 後・公費１・回数のsetメソッドです。
     *
     * @param atoKohi1Kaisu 後・公費１・回数
     */
    public void setAtoKohi1Kaisu(Decimal atoKohi1Kaisu) {
        this.atoKohi1Kaisu = atoKohi1Kaisu;
    }

    /**
     * 後・公費１・ｻｰﾋﾞｽ単位数のgetメソッドです。
     *
     * @return 後・公費１・ｻｰﾋﾞｽ単位数
     */
    public int getAtoKohi1ServiceTanisu() {
        return atoKohi1ServiceTanisu;
    }

    /**
     * 後・公費１・ｻｰﾋﾞｽ単位数のsetメソッドです。
     *
     * @param atoKohi1ServiceTanisu 後・公費１・ｻｰﾋﾞｽ単位数
     */
    public void setAtoKohi1ServiceTanisu(int atoKohi1ServiceTanisu) {
        this.atoKohi1ServiceTanisu = atoKohi1ServiceTanisu;
    }

    /**
     * 後・公費１・合計単位数のgetメソッドです。
     *
     * @return 後・公費１・合計単位数
     */
    public int getAtoKohi1TotalTanisu() {
        return atoKohi1TotalTanisu;
    }

    /**
     * 後・公費１・合計単位数のsetメソッドです。
     *
     * @param atoKohi1TotalTanisu 後・公費１・合計単位数
     */
    public void setAtoKohi1TotalTanisu(int atoKohi1TotalTanisu) {
        this.atoKohi1TotalTanisu = atoKohi1TotalTanisu;
    }

    /**
     * 後・公費２・回数のgetメソッドです。
     *
     * @return 後・公費２・回数
     */
    public Decimal getAtoKohi2Kaisu() {
        return atoKohi2Kaisu;
    }

    /**
     * 後・公費２・回数のsetメソッドです。
     *
     * @param atoKohi2Kaisu 後・公費２・回数
     */
    public void setAtoKohi2Kaisu(Decimal atoKohi2Kaisu) {
        this.atoKohi2Kaisu = atoKohi2Kaisu;
    }

    /**
     * 後・公費２・ｻｰﾋﾞｽ単位数のgetメソッドです。
     *
     * @return 後・公費２・ｻｰﾋﾞｽ単位数
     */
    public int getAtoKohi2ServiceTanisu() {
        return atoKohi2ServiceTanisu;
    }

    /**
     * 後・公費２・ｻｰﾋﾞｽ単位数のsetメソッドです。
     *
     * @param atoKohi2ServiceTanisu 後・公費２・ｻｰﾋﾞｽ単位数
     */
    public void setAtoKohi2ServiceTanisu(int atoKohi2ServiceTanisu) {
        this.atoKohi2ServiceTanisu = atoKohi2ServiceTanisu;
    }

    /**
     * 後・公費２・合計単位数のgetメソッドです。
     *
     * @return 後・公費２・合計単位数
     */
    public int getAtoKohi2TotalTanisu() {
        return atoKohi2TotalTanisu;
    }

    /**
     * 後・公費２・合計単位数のsetメソッドです。
     *
     * @param atoKohi2TotalTanisu 後・公費２・合計単位数
     */
    public void setAtoKohi2TotalTanisu(int atoKohi2TotalTanisu) {
        this.atoKohi2TotalTanisu = atoKohi2TotalTanisu;
    }

    /**
     * 後・公費３・回数のgetメソッドです。
     *
     * @return 後・公費３・回数
     */
    public Decimal getAtoKohi3Kaisu() {
        return atoKohi3Kaisu;
    }

    /**
     * 後・公費３・回数のsetメソッドです。
     *
     * @param atoKohi3Kaisu 後・公費３・回数
     */
    public void setAtoKohi3Kaisu(Decimal atoKohi3Kaisu) {
        this.atoKohi3Kaisu = atoKohi3Kaisu;
    }

    /**
     * 後・公費３・ｻｰﾋﾞｽ単位数のgetメソッドです。
     *
     * @return 後・公費３・ｻｰﾋﾞｽ単位数
     */
    public int getAtoKohi3ServiceTanisu() {
        return atoKohi3ServiceTanisu;
    }

    /**
     * 後・公費３・ｻｰﾋﾞｽ単位数のsetメソッドです。
     *
     * @param atoKohi3ServiceTanisu 後・公費３・ｻｰﾋﾞｽ単位数
     */
    public void setAtoKohi3ServiceTanisu(int atoKohi3ServiceTanisu) {
        this.atoKohi3ServiceTanisu = atoKohi3ServiceTanisu;
    }

    /**
     * 後・公費３・合計単位数のgetメソッドです。
     *
     * @return 後・公費３・合計単位数
     */
    public int getAtoKohi3TotalTanisu() {
        return atoKohi3TotalTanisu;
    }

    /**
     * 後・公費３・合計単位数のsetメソッドです。
     *
     * @param atoKohi3TotalTanisu 後・公費３・合計単位数
     */
    public void setAtoKohi3TotalTanisu(int atoKohi3TotalTanisu) {
        this.atoKohi3TotalTanisu = atoKohi3TotalTanisu;
    }

    /**
     * 再審査回数のgetメソッドです。
     *
     * @return 再審査回数
     */
    public Decimal getSaishinsaKaisu() {
        return saishinsaKaisu;
    }

    /**
     * 再審査回数のsetメソッドです。
     *
     * @param saishinsaKaisu 再審査回数
     */
    public void setSaishinsaKaisu(Decimal saishinsaKaisu) {
        this.saishinsaKaisu = saishinsaKaisu;
    }

    /**
     * 過誤回数のgetメソッドです。
     *
     * @return 過誤回数
     */
    public Decimal getKagoKaisu() {
        return kagoKaisu;
    }

    /**
     * 過誤回数のsetメソッドです。
     *
     * @param kagoKaisu 過誤回数
     */
    public void setKagoKaisu(Decimal kagoKaisu) {
        this.kagoKaisu = kagoKaisu;
    }

    /**
     * 審査年月のgetメソッドです。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth getShinsaYM() {
        return shinsaYM;
    }

    /**
     * 審査年月のsetメソッドです。
     *
     * @param shinsaYM 審査年月
     */
    public void setShinsaYM(FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
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
     * 取込年月のgetメソッドです。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * 取込年月のsetメソッドです。
     *
     * @param torikomiYM 取込年月
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kokanJohoShikibetsuNo, other.kokanJohoShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.inputShikibetsuNo, other.inputShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.recodeShubetsuCode, other.recodeShubetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shokisaiHokenshaNo, other.shokisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshoNo, other.jigyoshoNo)) {
            return false;
        }
        if (!Objects.equals(this.toshiNo, other.toshiNo)) {
            return false;
        }
        if (!Objects.equals(this.recodeJunjiNo, other.recodeJunjiNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.recodeJunjiNo = entity.recodeJunjiNo;
        this.shobyoName = entity.shobyoName;
        this.shikibetsuNo = entity.shikibetsuNo;
        this.tanisu = entity.tanisu;
        this.hokenKaisu = entity.hokenKaisu;
        this.hokenServiceTanisu = entity.hokenServiceTanisu;
        this.hokenTotalTanisu = entity.hokenTotalTanisu;
        this.kohi1Kaisu = entity.kohi1Kaisu;
        this.kohi1ServiceTanisu = entity.kohi1ServiceTanisu;
        this.kohi1TotalTanisu = entity.kohi1TotalTanisu;
        this.kohi2Kaisu = entity.kohi2Kaisu;
        this.kohi2ServiceTanisu = entity.kohi2ServiceTanisu;
        this.kohi2TotalTanisu = entity.kohi2TotalTanisu;
        this.kohi3Kaisu = entity.kohi3Kaisu;
        this.kohi3ServiceTanisu = entity.kohi3ServiceTanisu;
        this.kohi3TotalTanisu = entity.kohi3TotalTanisu;
        this.tekiyo = entity.tekiyo;
        this.atoTanisu = entity.atoTanisu;
        this.atoHokenKaisu = entity.atoHokenKaisu;
        this.atoHokenServiceTanisu = entity.atoHokenServiceTanisu;
        this.atoHokenTotalTanisu = entity.atoHokenTotalTanisu;
        this.atoKohi1Kaisu = entity.atoKohi1Kaisu;
        this.atoKohi1ServiceTanisu = entity.atoKohi1ServiceTanisu;
        this.atoKohi1TotalTanisu = entity.atoKohi1TotalTanisu;
        this.atoKohi2Kaisu = entity.atoKohi2Kaisu;
        this.atoKohi2ServiceTanisu = entity.atoKohi2ServiceTanisu;
        this.atoKohi2TotalTanisu = entity.atoKohi2TotalTanisu;
        this.atoKohi3Kaisu = entity.atoKohi3Kaisu;
        this.atoKohi3ServiceTanisu = entity.atoKohi3ServiceTanisu;
        this.atoKohi3TotalTanisu = entity.atoKohi3TotalTanisu;
        this.saishinsaKaisu = entity.saishinsaKaisu;
        this.kagoKaisu = entity.kagoKaisu;
        this.shinsaYM = entity.shinsaYM;
        this.seiriNo = entity.seiriNo;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, recodeJunjiNo, shobyoName, shikibetsuNo, tanisu, hokenKaisu, hokenServiceTanisu, hokenTotalTanisu, kohi1Kaisu, kohi1ServiceTanisu, kohi1TotalTanisu, kohi2Kaisu, kohi2ServiceTanisu, kohi2TotalTanisu, kohi3Kaisu, kohi3ServiceTanisu, kohi3TotalTanisu, tekiyo, atoTanisu, atoHokenKaisu, atoHokenServiceTanisu, atoHokenTotalTanisu, atoKohi1Kaisu, atoKohi1ServiceTanisu, atoKohi1TotalTanisu, atoKohi2Kaisu, atoKohi2ServiceTanisu, atoKohi2TotalTanisu, atoKohi3Kaisu, atoKohi3ServiceTanisu, atoKohi3TotalTanisu, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}

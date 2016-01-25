package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;

/**
 * DbT3017KyufujissekiKihonの項目定義クラスです
 *
 */
public class DbT3017KyufujissekiKihonEntity extends DbTableEntityBase<DbT3017KyufujissekiKihonEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3017KyufujissekiKihon");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KokanShikibetsuNo kokanShikibetsuNo;
    @PrimaryKey
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @PrimaryKey
    private RString recodeShubetsuCode;
    @PrimaryKey
    private RString kyufuSakuseiKubunCode;
    @PrimaryKey
    private HokenshaNo shokisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString kyufuJissekiKubunCode;
    @PrimaryKey
    private JigyoshaNo jigyoshoNo;
    @PrimaryKey
    private RString toshiNo;
    private RString kohi1FutanshaNo;
    private RString kohi1JukyushaNo;
    private RString kohi2FutanshaNo;
    private RString kohi2JukyushaNo;
    private RString kohi3FutanshaNo;
    private RString kohi3JukyushaNo;
    private FlexibleDate umareYMD;
    private RString seibetsuCode;
    private RString yoKaigoJotaiKubunCode;
    private RString kyuSochiNyushoshaTokureiCode;
    private FlexibleDate ninteiYukoKaishiYMD;
    private FlexibleDate ninteiYukoShuryoYMD;
    private RString rojinHokenShichosonNo;
    private RString rojinhokenJukyushaNo;
    private RString kokiHokenshaNo;
    private RString kokiHiHokenshaNo;
    private RString kokuhoHokenshaNo;
    private RString kokuhoHiHokenshashoNo;
    private RString kokuhoKojinNo;
    private RString kyotakuServiceSakuseiKubunCode;
    private JigyoshaNo kyotakuKaigoShienJigyoshoNo;
    private FlexibleDate kaishiYMD;
    private FlexibleDate chushiYMD;
    private RString chushiRiyuNyushomaeJyokyoCode;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoYMD;
    private int nyushoJitsunissu;
    private int gaihakuNissu;
    private RString taishogoJotaiCode;
    private HokenKyufuRitsu hokenKyufuritsu;
    private HokenKyufuRitsu kohi1Kyufuritsu;
    private HokenKyufuRitsu kohi2Kyufuritsu;
    private HokenKyufuRitsu kohi3Kyufuritsu;
    private int maeHokenServiceTanisu;
    private Decimal maeHokenSeikyugaku;
    private int maeHokenRiyoshaFutangaku;
    private Decimal maeHokenKinkyuShisetsuRyoyoSeikyugaku;
    private Decimal maeHokenTokuteiShinryohiSeikyugaku;
    private int maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int maeKohi1ServiceTanisu;
    private int maeKohi1Seikyugaku;
    private int maeKohi1RiyoshaFutangaku;
    private int maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
    private int maeKohi1TokuteiShinryohiSeikyugaku;
    private int maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int maeKohi2ServiceTanisu;
    private int maeKohi2Seikyugaku;
    private int maeKohi2RiyoshaFutangaku;
    private int maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
    private int maeKohi2TokuteiShinryohiSeikyugaku;
    private int maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int maeKohi3ServiceTanisu;
    private int maeKohi3Seikyugaku;
    private int maeKohi3RiyoshaFutangaku;
    private int maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
    private int maeKohi3TokuteiShinryohiSeikyugaku;
    private int maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int atoHokenServiceTanisu;
    private Decimal atoHokenSeikyugaku;
    private int atoHokenRiyoshaFutangaku;
    private Decimal atoHokenKinkyuShisetsuRyoyoSeikyugaku;
    private Decimal atoHokenTokuteiShinryohiSeikyugaku;
    private int atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int atoKohi1ServiceTanisu;
    private int atoKohi1Seikyugaku;
    private int atoKohi1RiyoshaFutangaku;
    private int atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
    private int atoKohi1TokuteiShinryohiSeikyugaku;
    private int atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int atoKohi2ServiceTanisu;
    private int atoKohi2Seikyugaku;
    private int atoKohi2RiyoshaFutangaku;
    private int atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
    private int atoKohi2TokuteiShinryohiSeikyugaku;
    private int atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private int atoKohi3ServiceTanisu;
    private int atoKohi3Seikyugaku;
    private int atoKohi3RiyoshaFutangaku;
    private int atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
    private int atoKohi3TokuteiShinryohiSeikyugaku;
    private int atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    private RString keikaiKubunCode;
    private FlexibleYearMonth shinsaYM;
    private RString seiriNo;
    private FlexibleYearMonth sofuYM;
    private FlexibleYearMonth torikomiYM;
    private RString dokujiSakuseiKubun;
    private boolean hokenshaHoyuKyufujissekiJohoSakujoFlag;

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
    public KokanShikibetsuNo getKokanShikibetsuNo() {
        return kokanShikibetsuNo;
    }

    /**
     * 交換情報識別番号のsetメソッドです。
     *
     * @param kokanShikibetsuNo 交換情報識別番号
     */
    public void setKokanShikibetsuNo(@Nonnull KokanShikibetsuNo kokanShikibetsuNo) {
        this.kokanShikibetsuNo = kokanShikibetsuNo;
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
    public void setInputShikibetsuNo(@Nonnull NyuryokuShikibetsuNo inputShikibetsuNo) {
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
    public void setRecodeShubetsuCode(@Nonnull RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    /**
     * 給付実績情報作成区分コードのgetメソッドです。
     * <br/>
     * <br/>1:新規2:修正3:取消
     *
     * @return 給付実績情報作成区分コード
     */
    public RString getKyufuSakuseiKubunCode() {
        return kyufuSakuseiKubunCode;
    }

    /**
     * 給付実績情報作成区分コードのsetメソッドです。
     * <br/>
     * <br/>1:新規2:修正3:取消
     *
     * @param kyufuSakuseiKubunCode 給付実績情報作成区分コード
     */
    public void setKyufuSakuseiKubunCode(@Nonnull RString kyufuSakuseiKubunCode) {
        this.kyufuSakuseiKubunCode = kyufuSakuseiKubunCode;
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
    public void setShokisaiHokenshaNo(@Nonnull HokenshaNo shokisaiHokenshaNo) {
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
    public void setHiHokenshaNo(@Nonnull HihokenshaNo hiHokenshaNo) {
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
    public void setServiceTeikyoYM(@Nonnull FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * 給付実績区分コードのgetメソッドです。
     * <br/>
     * <br/>1:現物2:償還
     *
     * @return 給付実績区分コード
     */
    public RString getKyufuJissekiKubunCode() {
        return kyufuJissekiKubunCode;
    }

    /**
     * 給付実績区分コードのsetメソッドです。
     * <br/>
     * <br/>1:現物2:償還
     *
     * @param kyufuJissekiKubunCode 給付実績区分コード
     */
    public void setKyufuJissekiKubunCode(@Nonnull RString kyufuJissekiKubunCode) {
        this.kyufuJissekiKubunCode = kyufuJissekiKubunCode;
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
    public void setJigyoshoNo(@Nonnull JigyoshaNo jigyoshoNo) {
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
    public void setToshiNo(@Nonnull RString toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * 公費１・負担者番号のgetメソッドです。
     *
     * @return 公費１・負担者番号
     */
    @CheckForNull
    public RString getKohi1FutanshaNo() {
        return kohi1FutanshaNo;
    }

    /**
     * 公費１・負担者番号のsetメソッドです。
     *
     * @param kohi1FutanshaNo 公費１・負担者番号
     */
    public void setKohi1FutanshaNo(RString kohi1FutanshaNo) {
        this.kohi1FutanshaNo = kohi1FutanshaNo;
    }

    /**
     * 公費１・受給者番号のgetメソッドです。
     *
     * @return 公費１・受給者番号
     */
    @CheckForNull
    public RString getKohi1JukyushaNo() {
        return kohi1JukyushaNo;
    }

    /**
     * 公費１・受給者番号のsetメソッドです。
     *
     * @param kohi1JukyushaNo 公費１・受給者番号
     */
    public void setKohi1JukyushaNo(RString kohi1JukyushaNo) {
        this.kohi1JukyushaNo = kohi1JukyushaNo;
    }

    /**
     * 公費２・負担者番号のgetメソッドです。
     *
     * @return 公費２・負担者番号
     */
    @CheckForNull
    public RString getKohi2FutanshaNo() {
        return kohi2FutanshaNo;
    }

    /**
     * 公費２・負担者番号のsetメソッドです。
     *
     * @param kohi2FutanshaNo 公費２・負担者番号
     */
    public void setKohi2FutanshaNo(RString kohi2FutanshaNo) {
        this.kohi2FutanshaNo = kohi2FutanshaNo;
    }

    /**
     * 公費２・受給者番号のgetメソッドです。
     *
     * @return 公費２・受給者番号
     */
    @CheckForNull
    public RString getKohi2JukyushaNo() {
        return kohi2JukyushaNo;
    }

    /**
     * 公費２・受給者番号のsetメソッドです。
     *
     * @param kohi2JukyushaNo 公費２・受給者番号
     */
    public void setKohi2JukyushaNo(RString kohi2JukyushaNo) {
        this.kohi2JukyushaNo = kohi2JukyushaNo;
    }

    /**
     * 公費３・負担者番号のgetメソッドです。
     *
     * @return 公費３・負担者番号
     */
    @CheckForNull
    public RString getKohi3FutanshaNo() {
        return kohi3FutanshaNo;
    }

    /**
     * 公費３・負担者番号のsetメソッドです。
     *
     * @param kohi3FutanshaNo 公費３・負担者番号
     */
    public void setKohi3FutanshaNo(RString kohi3FutanshaNo) {
        this.kohi3FutanshaNo = kohi3FutanshaNo;
    }

    /**
     * 公費３・受給者番号のgetメソッドです。
     *
     * @return 公費３・受給者番号
     */
    @CheckForNull
    public RString getKohi3JukyushaNo() {
        return kohi3JukyushaNo;
    }

    /**
     * 公費３・受給者番号のsetメソッドです。
     *
     * @param kohi3JukyushaNo 公費３・受給者番号
     */
    public void setKohi3JukyushaNo(RString kohi3JukyushaNo) {
        this.kohi3JukyushaNo = kohi3JukyushaNo;
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    @CheckForNull
    public FlexibleDate getUmareYMD() {
        return umareYMD;
    }

    /**
     * 生年月日のsetメソッドです。
     *
     * @param umareYMD 生年月日
     */
    public void setUmareYMD(FlexibleDate umareYMD) {
        this.umareYMD = umareYMD;
    }

    /**
     * 性別コードのgetメソッドです。
     *
     * @return 性別コード
     */
    @CheckForNull
    public RString getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * 性別コードのsetメソッドです。
     *
     * @param seibetsuCode 性別コード
     */
    public void setSeibetsuCode(RString seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
    }

    /**
     * 要介護状態区分コードのgetメソッドです。
     *
     * @return 要介護状態区分コード
     */
    @CheckForNull
    public RString getYoKaigoJotaiKubunCode() {
        return yoKaigoJotaiKubunCode;
    }

    /**
     * 要介護状態区分コードのsetメソッドです。
     *
     * @param yoKaigoJotaiKubunCode 要介護状態区分コード
     */
    public void setYoKaigoJotaiKubunCode(RString yoKaigoJotaiKubunCode) {
        this.yoKaigoJotaiKubunCode = yoKaigoJotaiKubunCode;
    }

    /**
     * 旧措置入所者特例コードのgetメソッドです。
     *
     * @return 旧措置入所者特例コード
     */
    @CheckForNull
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
     * 認定有効期間・開始年月日のgetメソッドです。
     *
     * @return 認定有効期間・開始年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiYukoKaishiYMD() {
        return ninteiYukoKaishiYMD;
    }

    /**
     * 認定有効期間・開始年月日のsetメソッドです。
     *
     * @param ninteiYukoKaishiYMD 認定有効期間・開始年月日
     */
    public void setNinteiYukoKaishiYMD(FlexibleDate ninteiYukoKaishiYMD) {
        this.ninteiYukoKaishiYMD = ninteiYukoKaishiYMD;
    }

    /**
     * 認定有功期間・終了年月日のgetメソッドです。
     *
     * @return 認定有功期間・終了年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiYukoShuryoYMD() {
        return ninteiYukoShuryoYMD;
    }

    /**
     * 認定有功期間・終了年月日のsetメソッドです。
     *
     * @param ninteiYukoShuryoYMD 認定有功期間・終了年月日
     */
    public void setNinteiYukoShuryoYMD(FlexibleDate ninteiYukoShuryoYMD) {
        this.ninteiYukoShuryoYMD = ninteiYukoShuryoYMD;
    }

    /**
     * 老人保健市町村番号のgetメソッドです。
     *
     * @return 老人保健市町村番号
     */
    @CheckForNull
    public RString getRojinHokenShichosonNo() {
        return rojinHokenShichosonNo;
    }

    /**
     * 老人保健市町村番号のsetメソッドです。
     *
     * @param rojinHokenShichosonNo 老人保健市町村番号
     */
    public void setRojinHokenShichosonNo(RString rojinHokenShichosonNo) {
        this.rojinHokenShichosonNo = rojinHokenShichosonNo;
    }

    /**
     * 老人保健受給者番号のgetメソッドです。
     *
     * @return 老人保健受給者番号
     */
    @CheckForNull
    public RString getRojinhokenJukyushaNo() {
        return rojinhokenJukyushaNo;
    }

    /**
     * 老人保健受給者番号のsetメソッドです。
     *
     * @param rojinhokenJukyushaNo 老人保健受給者番号
     */
    public void setRojinhokenJukyushaNo(RString rojinhokenJukyushaNo) {
        this.rojinhokenJukyushaNo = rojinhokenJukyushaNo;
    }

    /**
     * 保険者番号（後期）のgetメソッドです。
     * <br/>
     * <br/>サービス提供年月が平成２０年４月以降の場合
     *
     * @return 保険者番号（後期）
     */
    @CheckForNull
    public RString getKokiHokenshaNo() {
        return kokiHokenshaNo;
    }

    /**
     * 保険者番号（後期）のsetメソッドです。
     * <br/>
     * <br/>サービス提供年月が平成２０年４月以降の場合
     *
     * @param kokiHokenshaNo 保険者番号（後期）
     */
    public void setKokiHokenshaNo(RString kokiHokenshaNo) {
        this.kokiHokenshaNo = kokiHokenshaNo;
    }

    /**
     * 被保険者番号（後期）のgetメソッドです。
     * <br/>
     * <br/>サービス提供年月が平成２０年５月以降の場合
     *
     * @return 被保険者番号（後期）
     */
    @CheckForNull
    public RString getKokiHiHokenshaNo() {
        return kokiHiHokenshaNo;
    }

    /**
     * 被保険者番号（後期）のsetメソッドです。
     * <br/>
     * <br/>サービス提供年月が平成２０年５月以降の場合
     *
     * @param kokiHiHokenshaNo 被保険者番号（後期）
     */
    public void setKokiHiHokenshaNo(RString kokiHiHokenshaNo) {
        this.kokiHiHokenshaNo = kokiHiHokenshaNo;
    }

    /**
     * 保険者番号（国保）のgetメソッドです。
     * <br/>
     * <br/>サービス提供年月が平成２０年６月以降の場合
     *
     * @return 保険者番号（国保）
     */
    @CheckForNull
    public RString getKokuhoHokenshaNo() {
        return kokuhoHokenshaNo;
    }

    /**
     * 保険者番号（国保）のsetメソッドです。
     * <br/>
     * <br/>サービス提供年月が平成２０年６月以降の場合
     *
     * @param kokuhoHokenshaNo 保険者番号（国保）
     */
    public void setKokuhoHokenshaNo(RString kokuhoHokenshaNo) {
        this.kokuhoHokenshaNo = kokuhoHokenshaNo;
    }

    /**
     * 被保険者証番号（国保）のgetメソッドです。
     * <br/>
     * <br/>サービス提供年月が平成２０年７月以降の場合
     *
     * @return 被保険者証番号（国保）
     */
    @CheckForNull
    public RString getKokuhoHiHokenshashoNo() {
        return kokuhoHiHokenshashoNo;
    }

    /**
     * 被保険者証番号（国保）のsetメソッドです。
     * <br/>
     * <br/>サービス提供年月が平成２０年７月以降の場合
     *
     * @param kokuhoHiHokenshashoNo 被保険者証番号（国保）
     */
    public void setKokuhoHiHokenshashoNo(RString kokuhoHiHokenshashoNo) {
        this.kokuhoHiHokenshashoNo = kokuhoHiHokenshashoNo;
    }

    /**
     * 個人番号（国保）のgetメソッドです。
     * <br/>
     * <br/>サービス提供年月が平成２０年８月以降の場合
     *
     * @return 個人番号（国保）
     */
    @CheckForNull
    public RString getKokuhoKojinNo() {
        return kokuhoKojinNo;
    }

    /**
     * 個人番号（国保）のsetメソッドです。
     * <br/>
     * <br/>サービス提供年月が平成２０年８月以降の場合
     *
     * @param kokuhoKojinNo 個人番号（国保）
     */
    public void setKokuhoKojinNo(RString kokuhoKojinNo) {
        this.kokuhoKojinNo = kokuhoKojinNo;
    }

    /**
     * 居宅サービス計画作成区分コードのgetメソッドです。
     *
     * @return 居宅サービス計画作成区分コード
     */
    @CheckForNull
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
     * 事業所番号(居宅介護支援事業所等)のgetメソッドです。
     *
     * @return 事業所番号(居宅介護支援事業所等)
     */
    @CheckForNull
    public JigyoshaNo getKyotakuKaigoShienJigyoshoNo() {
        return kyotakuKaigoShienJigyoshoNo;
    }

    /**
     * 事業所番号(居宅介護支援事業所等)のsetメソッドです。
     *
     * @param kyotakuKaigoShienJigyoshoNo 事業所番号(居宅介護支援事業所等)
     */
    public void setKyotakuKaigoShienJigyoshoNo(JigyoshaNo kyotakuKaigoShienJigyoshoNo) {
        this.kyotakuKaigoShienJigyoshoNo = kyotakuKaigoShienJigyoshoNo;
    }

    /**
     * 開始年月日のgetメソッドです。
     *
     * @return 開始年月日
     */
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
    public int getNyushoJitsunissu() {
        return nyushoJitsunissu;
    }

    /**
     * 入所（院）実日数のsetメソッドです。
     *
     * @param nyushoJitsunissu 入所（院）実日数
     */
    public void setNyushoJitsunissu(int nyushoJitsunissu) {
        this.nyushoJitsunissu = nyushoJitsunissu;
    }

    /**
     * 外泊日数のgetメソッドです。
     *
     * @return 外泊日数
     */
    @CheckForNull
    public int getGaihakuNissu() {
        return gaihakuNissu;
    }

    /**
     * 外泊日数のsetメソッドです。
     *
     * @param gaihakuNissu 外泊日数
     */
    public void setGaihakuNissu(int gaihakuNissu) {
        this.gaihakuNissu = gaihakuNissu;
    }

    /**
     * 退所（院）後の状態コードのgetメソッドです。
     *
     * @return 退所（院）後の状態コード
     */
    @CheckForNull
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
    @CheckForNull
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
     * 公費１給付率のgetメソッドです。
     *
     * @return 公費１給付率
     */
    @CheckForNull
    public HokenKyufuRitsu getKohi1Kyufuritsu() {
        return kohi1Kyufuritsu;
    }

    /**
     * 公費１給付率のsetメソッドです。
     *
     * @param kohi1Kyufuritsu 公費１給付率
     */
    public void setKohi1Kyufuritsu(HokenKyufuRitsu kohi1Kyufuritsu) {
        this.kohi1Kyufuritsu = kohi1Kyufuritsu;
    }

    /**
     * 公費２給付率のgetメソッドです。
     *
     * @return 公費２給付率
     */
    @CheckForNull
    public HokenKyufuRitsu getKohi2Kyufuritsu() {
        return kohi2Kyufuritsu;
    }

    /**
     * 公費２給付率のsetメソッドです。
     *
     * @param kohi2Kyufuritsu 公費２給付率
     */
    public void setKohi2Kyufuritsu(HokenKyufuRitsu kohi2Kyufuritsu) {
        this.kohi2Kyufuritsu = kohi2Kyufuritsu;
    }

    /**
     * 公費３給付率のgetメソッドです。
     *
     * @return 公費３給付率
     */
    @CheckForNull
    public HokenKyufuRitsu getKohi3Kyufuritsu() {
        return kohi3Kyufuritsu;
    }

    /**
     * 公費３給付率のsetメソッドです。
     *
     * @param kohi3Kyufuritsu 公費３給付率
     */
    public void setKohi3Kyufuritsu(HokenKyufuRitsu kohi3Kyufuritsu) {
        this.kohi3Kyufuritsu = kohi3Kyufuritsu;
    }

    /**
     * 前・保険・サービス単位数のgetメソッドです。
     *
     * @return 前・保険・サービス単位数
     */
    @CheckForNull
    public int getMaeHokenServiceTanisu() {
        return maeHokenServiceTanisu;
    }

    /**
     * 前・保険・サービス単位数のsetメソッドです。
     *
     * @param maeHokenServiceTanisu 前・保険・サービス単位数
     */
    public void setMaeHokenServiceTanisu(int maeHokenServiceTanisu) {
        this.maeHokenServiceTanisu = maeHokenServiceTanisu;
    }

    /**
     * 前・保険・請求額のgetメソッドです。
     *
     * @return 前・保険・請求額
     */
    @CheckForNull
    public Decimal getMaeHokenSeikyugaku() {
        return maeHokenSeikyugaku;
    }

    /**
     * 前・保険・請求額のsetメソッドです。
     *
     * @param maeHokenSeikyugaku 前・保険・請求額
     */
    public void setMaeHokenSeikyugaku(Decimal maeHokenSeikyugaku) {
        this.maeHokenSeikyugaku = maeHokenSeikyugaku;
    }

    /**
     * 前・保険・利用者負担額のgetメソッドです。
     *
     * @return 前・保険・利用者負担額
     */
    @CheckForNull
    public int getMaeHokenRiyoshaFutangaku() {
        return maeHokenRiyoshaFutangaku;
    }

    /**
     * 前・保険・利用者負担額のsetメソッドです。
     *
     * @param maeHokenRiyoshaFutangaku 前・保険・利用者負担額
     */
    public void setMaeHokenRiyoshaFutangaku(int maeHokenRiyoshaFutangaku) {
        this.maeHokenRiyoshaFutangaku = maeHokenRiyoshaFutangaku;
    }

    /**
     * 前・保険・緊急時施設療養費請求額のgetメソッドです。
     *
     * @return 前・保険・緊急時施設療養費請求額
     */
    @CheckForNull
    public Decimal getMaeHokenKinkyuShisetsuRyoyoSeikyugaku() {
        return maeHokenKinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 前・保険・緊急時施設療養費請求額のsetメソッドです。
     *
     * @param maeHokenKinkyuShisetsuRyoyoSeikyugaku 前・保険・緊急時施設療養費請求額
     */
    public void setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(Decimal maeHokenKinkyuShisetsuRyoyoSeikyugaku) {
        this.maeHokenKinkyuShisetsuRyoyoSeikyugaku = maeHokenKinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 前・保険・特定診療費請求額のgetメソッドです。
     *
     * @return 前・保険・特定診療費請求額
     */
    @CheckForNull
    public Decimal getMaeHokenTokuteiShinryohiSeikyugaku() {
        return maeHokenTokuteiShinryohiSeikyugaku;
    }

    /**
     * 前・保険・特定診療費請求額のsetメソッドです。
     *
     * @param maeHokenTokuteiShinryohiSeikyugaku 前・保険・特定診療費請求額
     */
    public void setMaeHokenTokuteiShinryohiSeikyugaku(Decimal maeHokenTokuteiShinryohiSeikyugaku) {
        this.maeHokenTokuteiShinryohiSeikyugaku = maeHokenTokuteiShinryohiSeikyugaku;
    }

    /**
     * 前・保険・特定入所者介護サービス費等請求額のgetメソッドです。
     *
     * @return 前・保険・特定入所者介護サービス費等請求額
     */
    @CheckForNull
    public int getMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 前・保険・特定入所者介護サービス費等請求額のsetメソッドです。
     *
     * @param maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     * 前・保険・特定入所者介護サービス費等請求額
     */
    public void setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(int maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku = maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 前・公費１・サービス単位数のgetメソッドです。
     *
     * @return 前・公費１・サービス単位数
     */
    @CheckForNull
    public int getMaeKohi1ServiceTanisu() {
        return maeKohi1ServiceTanisu;
    }

    /**
     * 前・公費１・サービス単位数のsetメソッドです。
     *
     * @param maeKohi1ServiceTanisu 前・公費１・サービス単位数
     */
    public void setMaeKohi1ServiceTanisu(int maeKohi1ServiceTanisu) {
        this.maeKohi1ServiceTanisu = maeKohi1ServiceTanisu;
    }

    /**
     * 前・公費１・請求額のgetメソッドです。
     *
     * @return 前・公費１・請求額
     */
    @CheckForNull
    public int getMaeKohi1Seikyugaku() {
        return maeKohi1Seikyugaku;
    }

    /**
     * 前・公費１・請求額のsetメソッドです。
     *
     * @param maeKohi1Seikyugaku 前・公費１・請求額
     */
    public void setMaeKohi1Seikyugaku(int maeKohi1Seikyugaku) {
        this.maeKohi1Seikyugaku = maeKohi1Seikyugaku;
    }

    /**
     * 前・公費１・本人負担額のgetメソッドです。
     *
     * @return 前・公費１・本人負担額
     */
    @CheckForNull
    public int getMaeKohi1RiyoshaFutangaku() {
        return maeKohi1RiyoshaFutangaku;
    }

    /**
     * 前・公費１・本人負担額のsetメソッドです。
     *
     * @param maeKohi1RiyoshaFutangaku 前・公費１・本人負担額
     */
    public void setMaeKohi1RiyoshaFutangaku(int maeKohi1RiyoshaFutangaku) {
        this.maeKohi1RiyoshaFutangaku = maeKohi1RiyoshaFutangaku;
    }

    /**
     * 前・公費１・緊急時施設療養費請求額のgetメソッドです。
     *
     * @return 前・公費１・緊急時施設療養費請求額
     */
    @CheckForNull
    public int getMaeKohi1KinkyuShisetsuRyoyoSeikyugaku() {
        return maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 前・公費１・緊急時施設療養費請求額のsetメソッドです。
     *
     * @param maeKohi1KinkyuShisetsuRyoyoSeikyugaku 前・公費１・緊急時施設療養費請求額
     */
    public void setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku(int maeKohi1KinkyuShisetsuRyoyoSeikyugaku) {
        this.maeKohi1KinkyuShisetsuRyoyoSeikyugaku = maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 前・公費１・特定診療費請求額のgetメソッドです。
     *
     * @return 前・公費１・特定診療費請求額
     */
    @CheckForNull
    public int getMaeKohi1TokuteiShinryohiSeikyugaku() {
        return maeKohi1TokuteiShinryohiSeikyugaku;
    }

    /**
     * 前・公費１・特定診療費請求額のsetメソッドです。
     *
     * @param maeKohi1TokuteiShinryohiSeikyugaku 前・公費１・特定診療費請求額
     */
    public void setMaeKohi1TokuteiShinryohiSeikyugaku(int maeKohi1TokuteiShinryohiSeikyugaku) {
        this.maeKohi1TokuteiShinryohiSeikyugaku = maeKohi1TokuteiShinryohiSeikyugaku;
    }

    /**
     * 前・公費１・特定入所者介護サービス費等請求額のgetメソッドです。
     *
     * @return 前・公費１・特定入所者介護サービス費等請求額
     */
    @CheckForNull
    public int getMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 前・公費１・特定入所者介護サービス費等請求額のsetメソッドです。
     *
     * @param maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * 前・公費１・特定入所者介護サービス費等請求額
     */
    public void setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(int maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku = maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 前・公費２・サービス単位数のgetメソッドです。
     *
     * @return 前・公費２・サービス単位数
     */
    @CheckForNull
    public int getMaeKohi2ServiceTanisu() {
        return maeKohi2ServiceTanisu;
    }

    /**
     * 前・公費２・サービス単位数のsetメソッドです。
     *
     * @param maeKohi2ServiceTanisu 前・公費２・サービス単位数
     */
    public void setMaeKohi2ServiceTanisu(int maeKohi2ServiceTanisu) {
        this.maeKohi2ServiceTanisu = maeKohi2ServiceTanisu;
    }

    /**
     * 前・公費２・請求額のgetメソッドです。
     *
     * @return 前・公費２・請求額
     */
    @CheckForNull
    public int getMaeKohi2Seikyugaku() {
        return maeKohi2Seikyugaku;
    }

    /**
     * 前・公費２・請求額のsetメソッドです。
     *
     * @param maeKohi2Seikyugaku 前・公費２・請求額
     */
    public void setMaeKohi2Seikyugaku(int maeKohi2Seikyugaku) {
        this.maeKohi2Seikyugaku = maeKohi2Seikyugaku;
    }

    /**
     * 前・公費２・本人負担額のgetメソッドです。
     *
     * @return 前・公費２・本人負担額
     */
    @CheckForNull
    public int getMaeKohi2RiyoshaFutangaku() {
        return maeKohi2RiyoshaFutangaku;
    }

    /**
     * 前・公費２・本人負担額のsetメソッドです。
     *
     * @param maeKohi2RiyoshaFutangaku 前・公費２・本人負担額
     */
    public void setMaeKohi2RiyoshaFutangaku(int maeKohi2RiyoshaFutangaku) {
        this.maeKohi2RiyoshaFutangaku = maeKohi2RiyoshaFutangaku;
    }

    /**
     * 前・公費２・緊急時施設療養費請求額のgetメソッドです。
     *
     * @return 前・公費２・緊急時施設療養費請求額
     */
    @CheckForNull
    public int getMaeKohi2KinkyuShisetsuRyoyoSeikyugaku() {
        return maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 前・公費２・緊急時施設療養費請求額のsetメソッドです。
     *
     * @param maeKohi2KinkyuShisetsuRyoyoSeikyugaku 前・公費２・緊急時施設療養費請求額
     */
    public void setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku(int maeKohi2KinkyuShisetsuRyoyoSeikyugaku) {
        this.maeKohi2KinkyuShisetsuRyoyoSeikyugaku = maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 前・公費２・特定診療費請求額のgetメソッドです。
     *
     * @return 前・公費２・特定診療費請求額
     */
    @CheckForNull
    public int getMaeKohi2TokuteiShinryohiSeikyugaku() {
        return maeKohi2TokuteiShinryohiSeikyugaku;
    }

    /**
     * 前・公費２・特定診療費請求額のsetメソッドです。
     *
     * @param maeKohi2TokuteiShinryohiSeikyugaku 前・公費２・特定診療費請求額
     */
    public void setMaeKohi2TokuteiShinryohiSeikyugaku(int maeKohi2TokuteiShinryohiSeikyugaku) {
        this.maeKohi2TokuteiShinryohiSeikyugaku = maeKohi2TokuteiShinryohiSeikyugaku;
    }

    /**
     * 前・公費２・特定入所者介護サービス費等請求額のgetメソッドです。
     *
     * @return 前・公費２・特定入所者介護サービス費等請求額
     */
    @CheckForNull
    public int getMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 前・公費２・特定入所者介護サービス費等請求額のsetメソッドです。
     *
     * @param maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * 前・公費２・特定入所者介護サービス費等請求額
     */
    public void setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(int maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku = maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 前・公費３・サービス単位数のgetメソッドです。
     *
     * @return 前・公費３・サービス単位数
     */
    @CheckForNull
    public int getMaeKohi3ServiceTanisu() {
        return maeKohi3ServiceTanisu;
    }

    /**
     * 前・公費３・サービス単位数のsetメソッドです。
     *
     * @param maeKohi3ServiceTanisu 前・公費３・サービス単位数
     */
    public void setMaeKohi3ServiceTanisu(int maeKohi3ServiceTanisu) {
        this.maeKohi3ServiceTanisu = maeKohi3ServiceTanisu;
    }

    /**
     * 前・公費３・請求額のgetメソッドです。
     *
     * @return 前・公費３・請求額
     */
    @CheckForNull
    public int getMaeKohi3Seikyugaku() {
        return maeKohi3Seikyugaku;
    }

    /**
     * 前・公費３・請求額のsetメソッドです。
     *
     * @param maeKohi3Seikyugaku 前・公費３・請求額
     */
    public void setMaeKohi3Seikyugaku(int maeKohi3Seikyugaku) {
        this.maeKohi3Seikyugaku = maeKohi3Seikyugaku;
    }

    /**
     * 前・公費３・本人負担額のgetメソッドです。
     *
     * @return 前・公費３・本人負担額
     */
    @CheckForNull
    public int getMaeKohi3RiyoshaFutangaku() {
        return maeKohi3RiyoshaFutangaku;
    }

    /**
     * 前・公費３・本人負担額のsetメソッドです。
     *
     * @param maeKohi3RiyoshaFutangaku 前・公費３・本人負担額
     */
    public void setMaeKohi3RiyoshaFutangaku(int maeKohi3RiyoshaFutangaku) {
        this.maeKohi3RiyoshaFutangaku = maeKohi3RiyoshaFutangaku;
    }

    /**
     * 前・公費３・緊急時施設療養費請求額のgetメソッドです。
     *
     * @return 前・公費３・緊急時施設療養費請求額
     */
    @CheckForNull
    public int getMaeKohi3KinkyuShisetsuRyoyoSeikyugaku() {
        return maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 前・公費３・緊急時施設療養費請求額のsetメソッドです。
     *
     * @param maeKohi3KinkyuShisetsuRyoyoSeikyugaku 前・公費３・緊急時施設療養費請求額
     */
    public void setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku(int maeKohi3KinkyuShisetsuRyoyoSeikyugaku) {
        this.maeKohi3KinkyuShisetsuRyoyoSeikyugaku = maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 前・公費３・特定診療費請求額のgetメソッドです。
     *
     * @return 前・公費３・特定診療費請求額
     */
    @CheckForNull
    public int getMaeKohi3TokuteiShinryohiSeikyugaku() {
        return maeKohi3TokuteiShinryohiSeikyugaku;
    }

    /**
     * 前・公費３・特定診療費請求額のsetメソッドです。
     *
     * @param maeKohi3TokuteiShinryohiSeikyugaku 前・公費３・特定診療費請求額
     */
    public void setMaeKohi3TokuteiShinryohiSeikyugaku(int maeKohi3TokuteiShinryohiSeikyugaku) {
        this.maeKohi3TokuteiShinryohiSeikyugaku = maeKohi3TokuteiShinryohiSeikyugaku;
    }

    /**
     * 前・公費３・特定入所者介護サービス費等請求額のgetメソッドです。
     *
     * @return 前・公費３・特定入所者介護サービス費等請求額
     */
    @CheckForNull
    public int getMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 前・公費３・特定入所者介護サービス費等請求額のsetメソッドです。
     *
     * @param maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * 前・公費３・特定入所者介護サービス費等請求額
     */
    public void setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(int maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku = maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 後・保険・サービス単位数のgetメソッドです。
     *
     * @return 後・保険・サービス単位数
     */
    @CheckForNull
    public int getAtoHokenServiceTanisu() {
        return atoHokenServiceTanisu;
    }

    /**
     * 後・保険・サービス単位数のsetメソッドです。
     *
     * @param atoHokenServiceTanisu 後・保険・サービス単位数
     */
    public void setAtoHokenServiceTanisu(int atoHokenServiceTanisu) {
        this.atoHokenServiceTanisu = atoHokenServiceTanisu;
    }

    /**
     * 後・保険・請求額のgetメソッドです。
     *
     * @return 後・保険・請求額
     */
    @CheckForNull
    public Decimal getAtoHokenSeikyugaku() {
        return atoHokenSeikyugaku;
    }

    /**
     * 後・保険・請求額のsetメソッドです。
     *
     * @param atoHokenSeikyugaku 後・保険・請求額
     */
    public void setAtoHokenSeikyugaku(Decimal atoHokenSeikyugaku) {
        this.atoHokenSeikyugaku = atoHokenSeikyugaku;
    }

    /**
     * 後・保険・利用者負担額のgetメソッドです。
     *
     * @return 後・保険・利用者負担額
     */
    @CheckForNull
    public int getAtoHokenRiyoshaFutangaku() {
        return atoHokenRiyoshaFutangaku;
    }

    /**
     * 後・保険・利用者負担額のsetメソッドです。
     *
     * @param atoHokenRiyoshaFutangaku 後・保険・利用者負担額
     */
    public void setAtoHokenRiyoshaFutangaku(int atoHokenRiyoshaFutangaku) {
        this.atoHokenRiyoshaFutangaku = atoHokenRiyoshaFutangaku;
    }

    /**
     * 後・緊急時施設療養費請求額のgetメソッドです。
     *
     * @return 後・緊急時施設療養費請求額
     */
    @CheckForNull
    public Decimal getAtoHokenKinkyuShisetsuRyoyoSeikyugaku() {
        return atoHokenKinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 後・緊急時施設療養費請求額のsetメソッドです。
     *
     * @param atoHokenKinkyuShisetsuRyoyoSeikyugaku 後・緊急時施設療養費請求額
     */
    public void setAtoHokenKinkyuShisetsuRyoyoSeikyugaku(Decimal atoHokenKinkyuShisetsuRyoyoSeikyugaku) {
        this.atoHokenKinkyuShisetsuRyoyoSeikyugaku = atoHokenKinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 後・保険・特定診療費請求額のgetメソッドです。
     *
     * @return 後・保険・特定診療費請求額
     */
    @CheckForNull
    public Decimal getAtoHokenTokuteiShinryohiSeikyugaku() {
        return atoHokenTokuteiShinryohiSeikyugaku;
    }

    /**
     * 後・保険・特定診療費請求額のsetメソッドです。
     *
     * @param atoHokenTokuteiShinryohiSeikyugaku 後・保険・特定診療費請求額
     */
    public void setAtoHokenTokuteiShinryohiSeikyugaku(Decimal atoHokenTokuteiShinryohiSeikyugaku) {
        this.atoHokenTokuteiShinryohiSeikyugaku = atoHokenTokuteiShinryohiSeikyugaku;
    }

    /**
     * 後・保険・特定入所者介護サービス費等請求額のgetメソッドです。
     *
     * @return 後・保険・特定入所者介護サービス費等請求額
     */
    @CheckForNull
    public int getAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 後・保険・特定入所者介護サービス費等請求額のsetメソッドです。
     *
     * @param atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     * 後・保険・特定入所者介護サービス費等請求額
     */
    public void setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(int atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku = atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 後・公費１・サービス単位数のgetメソッドです。
     *
     * @return 後・公費１・サービス単位数
     */
    @CheckForNull
    public int getAtoKohi1ServiceTanisu() {
        return atoKohi1ServiceTanisu;
    }

    /**
     * 後・公費１・サービス単位数のsetメソッドです。
     *
     * @param atoKohi1ServiceTanisu 後・公費１・サービス単位数
     */
    public void setAtoKohi1ServiceTanisu(int atoKohi1ServiceTanisu) {
        this.atoKohi1ServiceTanisu = atoKohi1ServiceTanisu;
    }

    /**
     * 後・公費１・請求額のgetメソッドです。
     *
     * @return 後・公費１・請求額
     */
    @CheckForNull
    public int getAtoKohi1Seikyugaku() {
        return atoKohi1Seikyugaku;
    }

    /**
     * 後・公費１・請求額のsetメソッドです。
     *
     * @param atoKohi1Seikyugaku 後・公費１・請求額
     */
    public void setAtoKohi1Seikyugaku(int atoKohi1Seikyugaku) {
        this.atoKohi1Seikyugaku = atoKohi1Seikyugaku;
    }

    /**
     * 後・公費１・本人負担額のgetメソッドです。
     *
     * @return 後・公費１・本人負担額
     */
    @CheckForNull
    public int getAtoKohi1RiyoshaFutangaku() {
        return atoKohi1RiyoshaFutangaku;
    }

    /**
     * 後・公費１・本人負担額のsetメソッドです。
     *
     * @param atoKohi1RiyoshaFutangaku 後・公費１・本人負担額
     */
    public void setAtoKohi1RiyoshaFutangaku(int atoKohi1RiyoshaFutangaku) {
        this.atoKohi1RiyoshaFutangaku = atoKohi1RiyoshaFutangaku;
    }

    /**
     * 後・公費１・緊急時施設療養費請求額のgetメソッドです。
     *
     * @return 後・公費１・緊急時施設療養費請求額
     */
    @CheckForNull
    public int getAtoKohi1KinkyuShisetsuRyoyoSeikyugaku() {
        return atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 後・公費１・緊急時施設療養費請求額のsetメソッドです。
     *
     * @param atoKohi1KinkyuShisetsuRyoyoSeikyugaku 後・公費１・緊急時施設療養費請求額
     */
    public void setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku(int atoKohi1KinkyuShisetsuRyoyoSeikyugaku) {
        this.atoKohi1KinkyuShisetsuRyoyoSeikyugaku = atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 後・公費１・特定診療費請求額のgetメソッドです。
     *
     * @return 後・公費１・特定診療費請求額
     */
    @CheckForNull
    public int getAtoKohi1TokuteiShinryohiSeikyugaku() {
        return atoKohi1TokuteiShinryohiSeikyugaku;
    }

    /**
     * 後・公費１・特定診療費請求額のsetメソッドです。
     *
     * @param atoKohi1TokuteiShinryohiSeikyugaku 後・公費１・特定診療費請求額
     */
    public void setAtoKohi1TokuteiShinryohiSeikyugaku(int atoKohi1TokuteiShinryohiSeikyugaku) {
        this.atoKohi1TokuteiShinryohiSeikyugaku = atoKohi1TokuteiShinryohiSeikyugaku;
    }

    /**
     * 後・公費１・特定入所者介護サービス費等請求額のgetメソッドです。
     *
     * @return 後・公費１・特定入所者介護サービス費等請求額
     */
    @CheckForNull
    public int getAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 後・公費１・特定入所者介護サービス費等請求額のsetメソッドです。
     *
     * @param atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * 後・公費１・特定入所者介護サービス費等請求額
     */
    public void setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(int atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku = atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 後・公費２・サービス単位数のgetメソッドです。
     *
     * @return 後・公費２・サービス単位数
     */
    @CheckForNull
    public int getAtoKohi2ServiceTanisu() {
        return atoKohi2ServiceTanisu;
    }

    /**
     * 後・公費２・サービス単位数のsetメソッドです。
     *
     * @param atoKohi2ServiceTanisu 後・公費２・サービス単位数
     */
    public void setAtoKohi2ServiceTanisu(int atoKohi2ServiceTanisu) {
        this.atoKohi2ServiceTanisu = atoKohi2ServiceTanisu;
    }

    /**
     * 後・公費２・請求額のgetメソッドです。
     *
     * @return 後・公費２・請求額
     */
    @CheckForNull
    public int getAtoKohi2Seikyugaku() {
        return atoKohi2Seikyugaku;
    }

    /**
     * 後・公費２・請求額のsetメソッドです。
     *
     * @param atoKohi2Seikyugaku 後・公費２・請求額
     */
    public void setAtoKohi2Seikyugaku(int atoKohi2Seikyugaku) {
        this.atoKohi2Seikyugaku = atoKohi2Seikyugaku;
    }

    /**
     * 後・公費２・利用者負担額のgetメソッドです。
     *
     * @return 後・公費２・利用者負担額
     */
    @CheckForNull
    public int getAtoKohi2RiyoshaFutangaku() {
        return atoKohi2RiyoshaFutangaku;
    }

    /**
     * 後・公費２・利用者負担額のsetメソッドです。
     *
     * @param atoKohi2RiyoshaFutangaku 後・公費２・利用者負担額
     */
    public void setAtoKohi2RiyoshaFutangaku(int atoKohi2RiyoshaFutangaku) {
        this.atoKohi2RiyoshaFutangaku = atoKohi2RiyoshaFutangaku;
    }

    /**
     * 後・公費２・緊急時施設療養費請求額のgetメソッドです。
     *
     * @return 後・公費２・緊急時施設療養費請求額
     */
    @CheckForNull
    public int getAtoKohi2KinkyuShisetsuRyoyoSeikyugaku() {
        return atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 後・公費２・緊急時施設療養費請求額のsetメソッドです。
     *
     * @param atoKohi2KinkyuShisetsuRyoyoSeikyugaku 後・公費２・緊急時施設療養費請求額
     */
    public void setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku(int atoKohi2KinkyuShisetsuRyoyoSeikyugaku) {
        this.atoKohi2KinkyuShisetsuRyoyoSeikyugaku = atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 後・公費２・特定診療費請求額のgetメソッドです。
     *
     * @return 後・公費２・特定診療費請求額
     */
    @CheckForNull
    public int getAtoKohi2TokuteiShinryohiSeikyugaku() {
        return atoKohi2TokuteiShinryohiSeikyugaku;
    }

    /**
     * 後・公費２・特定診療費請求額のsetメソッドです。
     *
     * @param atoKohi2TokuteiShinryohiSeikyugaku 後・公費２・特定診療費請求額
     */
    public void setAtoKohi2TokuteiShinryohiSeikyugaku(int atoKohi2TokuteiShinryohiSeikyugaku) {
        this.atoKohi2TokuteiShinryohiSeikyugaku = atoKohi2TokuteiShinryohiSeikyugaku;
    }

    /**
     * 後・公費２・特定入所者介護サービス費等請求額のgetメソッドです。
     *
     * @return 後・公費２・特定入所者介護サービス費等請求額
     */
    @CheckForNull
    public int getAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 後・公費２・特定入所者介護サービス費等請求額のsetメソッドです。
     *
     * @param atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * 後・公費２・特定入所者介護サービス費等請求額
     */
    public void setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(int atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku = atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 後・公費３・サービス単位数のgetメソッドです。
     *
     * @return 後・公費３・サービス単位数
     */
    @CheckForNull
    public int getAtoKohi3ServiceTanisu() {
        return atoKohi3ServiceTanisu;
    }

    /**
     * 後・公費３・サービス単位数のsetメソッドです。
     *
     * @param atoKohi3ServiceTanisu 後・公費３・サービス単位数
     */
    public void setAtoKohi3ServiceTanisu(int atoKohi3ServiceTanisu) {
        this.atoKohi3ServiceTanisu = atoKohi3ServiceTanisu;
    }

    /**
     * 後・公費３・請求額のgetメソッドです。
     *
     * @return 後・公費３・請求額
     */
    @CheckForNull
    public int getAtoKohi3Seikyugaku() {
        return atoKohi3Seikyugaku;
    }

    /**
     * 後・公費３・請求額のsetメソッドです。
     *
     * @param atoKohi3Seikyugaku 後・公費３・請求額
     */
    public void setAtoKohi3Seikyugaku(int atoKohi3Seikyugaku) {
        this.atoKohi3Seikyugaku = atoKohi3Seikyugaku;
    }

    /**
     * 後・公費３・利用者負担額のgetメソッドです。
     *
     * @return 後・公費３・利用者負担額
     */
    @CheckForNull
    public int getAtoKohi3RiyoshaFutangaku() {
        return atoKohi3RiyoshaFutangaku;
    }

    /**
     * 後・公費３・利用者負担額のsetメソッドです。
     *
     * @param atoKohi3RiyoshaFutangaku 後・公費３・利用者負担額
     */
    public void setAtoKohi3RiyoshaFutangaku(int atoKohi3RiyoshaFutangaku) {
        this.atoKohi3RiyoshaFutangaku = atoKohi3RiyoshaFutangaku;
    }

    /**
     * 後・公費３・緊急時施設療養費請求額のgetメソッドです。
     *
     * @return 後・公費３・緊急時施設療養費請求額
     */
    @CheckForNull
    public int getAtoKohi3KinkyuShisetsuRyoyoSeikyugaku() {
        return atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 後・公費３・緊急時施設療養費請求額のsetメソッドです。
     *
     * @param atoKohi3KinkyuShisetsuRyoyoSeikyugaku 後・公費３・緊急時施設療養費請求額
     */
    public void setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku(int atoKohi3KinkyuShisetsuRyoyoSeikyugaku) {
        this.atoKohi3KinkyuShisetsuRyoyoSeikyugaku = atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
    }

    /**
     * 後・公費３・特定診療費請求額のgetメソッドです。
     *
     * @return 後・公費３・特定診療費請求額
     */
    @CheckForNull
    public int getAtoKohi3TokuteiShinryohiSeikyugaku() {
        return atoKohi3TokuteiShinryohiSeikyugaku;
    }

    /**
     * 後・公費３・特定診療費請求額のsetメソッドです。
     *
     * @param atoKohi3TokuteiShinryohiSeikyugaku 後・公費３・特定診療費請求額
     */
    public void setAtoKohi3TokuteiShinryohiSeikyugaku(int atoKohi3TokuteiShinryohiSeikyugaku) {
        this.atoKohi3TokuteiShinryohiSeikyugaku = atoKohi3TokuteiShinryohiSeikyugaku;
    }

    /**
     * 後・公費３・特定入所者介護サービス費等請求額のgetメソッドです。
     *
     * @return 後・公費３・特定入所者介護サービス費等請求額
     */
    @CheckForNull
    public int getAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku() {
        return atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 後・公費３・特定入所者介護サービス費等請求額のsetメソッドです。
     *
     * @param atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     * 後・公費３・特定入所者介護サービス費等請求額
     */
    public void setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(int atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku) {
        this.atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku = atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
    }

    /**
     * 警告区分コードのgetメソッドです。
     * <br/>
     * <br/>１：警告なし　２：警告あり
     *
     * @return 警告区分コード
     */
    @CheckForNull
    public RString getKeikaiKubunCode() {
        return keikaiKubunCode;
    }

    /**
     * 警告区分コードのsetメソッドです。
     * <br/>
     * <br/>１：警告なし　２：警告あり
     *
     * @param keikaiKubunCode 警告区分コード
     */
    public void setKeikaiKubunCode(RString keikaiKubunCode) {
        this.keikaiKubunCode = keikaiKubunCode;
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
    public void setShinsaYM(@Nonnull FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
    }

    /**
     * 整理番号のgetメソッドです。
     *
     * @return 整理番号
     */
    @CheckForNull
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
     * 送付年月のgetメソッドです。
     *
     * @return 送付年月
     */
    @CheckForNull
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
     * 取込年月のgetメソッドです。
     *
     * @return 取込年月
     */
    @CheckForNull
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
     * 独自作成区分のgetメソッドです。
     *
     * @return 独自作成区分
     */
    @CheckForNull
    public RString getDokujiSakuseiKubun() {
        return dokujiSakuseiKubun;
    }

    /**
     * 独自作成区分のsetメソッドです。
     *
     * @param dokujiSakuseiKubun 独自作成区分
     */
    public void setDokujiSakuseiKubun(RString dokujiSakuseiKubun) {
        this.dokujiSakuseiKubun = dokujiSakuseiKubun;
    }

    /**
     * 保険者保有給付実績情報削除済フラグのgetメソッドです。
     *
     * @return 保険者保有給付実績情報削除済フラグ
     */
    @CheckForNull
    public boolean getHokenshaHoyuKyufujissekiJohoSakujoFlag() {
        return hokenshaHoyuKyufujissekiJohoSakujoFlag;
    }

    /**
     * 保険者保有給付実績情報削除済フラグのsetメソッドです。
     *
     * @param hokenshaHoyuKyufujissekiJohoSakujoFlag 保険者保有給付実績情報削除済フラグ
     */
    public void setHokenshaHoyuKyufujissekiJohoSakujoFlag(boolean hokenshaHoyuKyufujissekiJohoSakujoFlag) {
        this.hokenshaHoyuKyufujissekiJohoSakujoFlag = hokenshaHoyuKyufujissekiJohoSakujoFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3017KyufujissekiKihonEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3017KyufujissekiKihonEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3017KyufujissekiKihonEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kokanShikibetsuNo, other.kokanShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.inputShikibetsuNo, other.inputShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.recodeShubetsuCode, other.recodeShubetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.kyufuSakuseiKubunCode, other.kyufuSakuseiKubunCode)) {
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
        if (!Objects.equals(this.kyufuJissekiKubunCode, other.kyufuJissekiKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshoNo, other.jigyoshoNo)) {
            return false;
        }
        if (!Objects.equals(this.toshiNo, other.toshiNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3017KyufujissekiKihonEntity entity) {
        this.kokanShikibetsuNo = entity.kokanShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.kyufuSakuseiKubunCode = entity.kyufuSakuseiKubunCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.kyufuJissekiKubunCode = entity.kyufuJissekiKubunCode;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.kohi1FutanshaNo = entity.kohi1FutanshaNo;
        this.kohi1JukyushaNo = entity.kohi1JukyushaNo;
        this.kohi2FutanshaNo = entity.kohi2FutanshaNo;
        this.kohi2JukyushaNo = entity.kohi2JukyushaNo;
        this.kohi3FutanshaNo = entity.kohi3FutanshaNo;
        this.kohi3JukyushaNo = entity.kohi3JukyushaNo;
        this.umareYMD = entity.umareYMD;
        this.seibetsuCode = entity.seibetsuCode;
        this.yoKaigoJotaiKubunCode = entity.yoKaigoJotaiKubunCode;
        this.kyuSochiNyushoshaTokureiCode = entity.kyuSochiNyushoshaTokureiCode;
        this.ninteiYukoKaishiYMD = entity.ninteiYukoKaishiYMD;
        this.ninteiYukoShuryoYMD = entity.ninteiYukoShuryoYMD;
        this.rojinHokenShichosonNo = entity.rojinHokenShichosonNo;
        this.rojinhokenJukyushaNo = entity.rojinhokenJukyushaNo;
        this.kokiHokenshaNo = entity.kokiHokenshaNo;
        this.kokiHiHokenshaNo = entity.kokiHiHokenshaNo;
        this.kokuhoHokenshaNo = entity.kokuhoHokenshaNo;
        this.kokuhoHiHokenshashoNo = entity.kokuhoHiHokenshashoNo;
        this.kokuhoKojinNo = entity.kokuhoKojinNo;
        this.kyotakuServiceSakuseiKubunCode = entity.kyotakuServiceSakuseiKubunCode;
        this.kyotakuKaigoShienJigyoshoNo = entity.kyotakuKaigoShienJigyoshoNo;
        this.kaishiYMD = entity.kaishiYMD;
        this.chushiYMD = entity.chushiYMD;
        this.chushiRiyuNyushomaeJyokyoCode = entity.chushiRiyuNyushomaeJyokyoCode;
        this.nyushoYMD = entity.nyushoYMD;
        this.taishoYMD = entity.taishoYMD;
        this.nyushoJitsunissu = entity.nyushoJitsunissu;
        this.gaihakuNissu = entity.gaihakuNissu;
        this.taishogoJotaiCode = entity.taishogoJotaiCode;
        this.hokenKyufuritsu = entity.hokenKyufuritsu;
        this.kohi1Kyufuritsu = entity.kohi1Kyufuritsu;
        this.kohi2Kyufuritsu = entity.kohi2Kyufuritsu;
        this.kohi3Kyufuritsu = entity.kohi3Kyufuritsu;
        this.maeHokenServiceTanisu = entity.maeHokenServiceTanisu;
        this.maeHokenSeikyugaku = entity.maeHokenSeikyugaku;
        this.maeHokenRiyoshaFutangaku = entity.maeHokenRiyoshaFutangaku;
        this.maeHokenKinkyuShisetsuRyoyoSeikyugaku = entity.maeHokenKinkyuShisetsuRyoyoSeikyugaku;
        this.maeHokenTokuteiShinryohiSeikyugaku = entity.maeHokenTokuteiShinryohiSeikyugaku;
        this.maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.maeKohi1ServiceTanisu = entity.maeKohi1ServiceTanisu;
        this.maeKohi1Seikyugaku = entity.maeKohi1Seikyugaku;
        this.maeKohi1RiyoshaFutangaku = entity.maeKohi1RiyoshaFutangaku;
        this.maeKohi1KinkyuShisetsuRyoyoSeikyugaku = entity.maeKohi1KinkyuShisetsuRyoyoSeikyugaku;
        this.maeKohi1TokuteiShinryohiSeikyugaku = entity.maeKohi1TokuteiShinryohiSeikyugaku;
        this.maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.maeKohi2ServiceTanisu = entity.maeKohi2ServiceTanisu;
        this.maeKohi2Seikyugaku = entity.maeKohi2Seikyugaku;
        this.maeKohi2RiyoshaFutangaku = entity.maeKohi2RiyoshaFutangaku;
        this.maeKohi2KinkyuShisetsuRyoyoSeikyugaku = entity.maeKohi2KinkyuShisetsuRyoyoSeikyugaku;
        this.maeKohi2TokuteiShinryohiSeikyugaku = entity.maeKohi2TokuteiShinryohiSeikyugaku;
        this.maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.maeKohi3ServiceTanisu = entity.maeKohi3ServiceTanisu;
        this.maeKohi3Seikyugaku = entity.maeKohi3Seikyugaku;
        this.maeKohi3RiyoshaFutangaku = entity.maeKohi3RiyoshaFutangaku;
        this.maeKohi3KinkyuShisetsuRyoyoSeikyugaku = entity.maeKohi3KinkyuShisetsuRyoyoSeikyugaku;
        this.maeKohi3TokuteiShinryohiSeikyugaku = entity.maeKohi3TokuteiShinryohiSeikyugaku;
        this.maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.atoHokenServiceTanisu = entity.atoHokenServiceTanisu;
        this.atoHokenSeikyugaku = entity.atoHokenSeikyugaku;
        this.atoHokenRiyoshaFutangaku = entity.atoHokenRiyoshaFutangaku;
        this.atoHokenKinkyuShisetsuRyoyoSeikyugaku = entity.atoHokenKinkyuShisetsuRyoyoSeikyugaku;
        this.atoHokenTokuteiShinryohiSeikyugaku = entity.atoHokenTokuteiShinryohiSeikyugaku;
        this.atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.atoKohi1ServiceTanisu = entity.atoKohi1ServiceTanisu;
        this.atoKohi1Seikyugaku = entity.atoKohi1Seikyugaku;
        this.atoKohi1RiyoshaFutangaku = entity.atoKohi1RiyoshaFutangaku;
        this.atoKohi1KinkyuShisetsuRyoyoSeikyugaku = entity.atoKohi1KinkyuShisetsuRyoyoSeikyugaku;
        this.atoKohi1TokuteiShinryohiSeikyugaku = entity.atoKohi1TokuteiShinryohiSeikyugaku;
        this.atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.atoKohi2ServiceTanisu = entity.atoKohi2ServiceTanisu;
        this.atoKohi2Seikyugaku = entity.atoKohi2Seikyugaku;
        this.atoKohi2RiyoshaFutangaku = entity.atoKohi2RiyoshaFutangaku;
        this.atoKohi2KinkyuShisetsuRyoyoSeikyugaku = entity.atoKohi2KinkyuShisetsuRyoyoSeikyugaku;
        this.atoKohi2TokuteiShinryohiSeikyugaku = entity.atoKohi2TokuteiShinryohiSeikyugaku;
        this.atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.atoKohi3ServiceTanisu = entity.atoKohi3ServiceTanisu;
        this.atoKohi3Seikyugaku = entity.atoKohi3Seikyugaku;
        this.atoKohi3RiyoshaFutangaku = entity.atoKohi3RiyoshaFutangaku;
        this.atoKohi3KinkyuShisetsuRyoyoSeikyugaku = entity.atoKohi3KinkyuShisetsuRyoyoSeikyugaku;
        this.atoKohi3TokuteiShinryohiSeikyugaku = entity.atoKohi3TokuteiShinryohiSeikyugaku;
        this.atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku = entity.atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku;
        this.keikaiKubunCode = entity.keikaiKubunCode;
        this.shinsaYM = entity.shinsaYM;
        this.seiriNo = entity.seiriNo;
        this.sofuYM = entity.sofuYM;
        this.torikomiYM = entity.torikomiYM;
        this.dokujiSakuseiKubun = entity.dokujiSakuseiKubun;
        this.hokenshaHoyuKyufujissekiJohoSakujoFlag = entity.hokenshaHoyuKyufujissekiJohoSakujoFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, kyufuSakuseiKubunCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, kyufuJissekiKubunCode, jigyoshoNo, toshiNo, kohi1FutanshaNo, kohi1JukyushaNo, kohi2FutanshaNo, kohi2JukyushaNo, kohi3FutanshaNo, kohi3JukyushaNo, umareYMD, seibetsuCode, yoKaigoJotaiKubunCode, kyuSochiNyushoshaTokureiCode, ninteiYukoKaishiYMD, ninteiYukoShuryoYMD, rojinHokenShichosonNo, rojinhokenJukyushaNo, kokiHokenshaNo, kokiHiHokenshaNo, kokuhoHokenshaNo, kokuhoHiHokenshashoNo, kokuhoKojinNo, kyotakuServiceSakuseiKubunCode, kyotakuKaigoShienJigyoshoNo, kaishiYMD, chushiYMD, chushiRiyuNyushomaeJyokyoCode, nyushoYMD, taishoYMD, nyushoJitsunissu, gaihakuNissu, taishogoJotaiCode, hokenKyufuritsu, kohi1Kyufuritsu, kohi2Kyufuritsu, kohi3Kyufuritsu, maeHokenServiceTanisu, maeHokenSeikyugaku, maeHokenRiyoshaFutangaku, maeHokenKinkyuShisetsuRyoyoSeikyugaku, maeHokenTokuteiShinryohiSeikyugaku, maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku, maeKohi1ServiceTanisu, maeKohi1Seikyugaku, maeKohi1RiyoshaFutangaku, maeKohi1KinkyuShisetsuRyoyoSeikyugaku, maeKohi1TokuteiShinryohiSeikyugaku, maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku, maeKohi2ServiceTanisu, maeKohi2Seikyugaku, maeKohi2RiyoshaFutangaku, maeKohi2KinkyuShisetsuRyoyoSeikyugaku, maeKohi2TokuteiShinryohiSeikyugaku, maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku, maeKohi3ServiceTanisu, maeKohi3Seikyugaku, maeKohi3RiyoshaFutangaku, maeKohi3KinkyuShisetsuRyoyoSeikyugaku, maeKohi3TokuteiShinryohiSeikyugaku, maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku, atoHokenServiceTanisu, atoHokenSeikyugaku, atoHokenRiyoshaFutangaku, atoHokenKinkyuShisetsuRyoyoSeikyugaku, atoHokenTokuteiShinryohiSeikyugaku, atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku, atoKohi1ServiceTanisu, atoKohi1Seikyugaku, atoKohi1RiyoshaFutangaku, atoKohi1KinkyuShisetsuRyoyoSeikyugaku, atoKohi1TokuteiShinryohiSeikyugaku, atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku, atoKohi2ServiceTanisu, atoKohi2Seikyugaku, atoKohi2RiyoshaFutangaku, atoKohi2KinkyuShisetsuRyoyoSeikyugaku, atoKohi2TokuteiShinryohiSeikyugaku, atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku, atoKohi3ServiceTanisu, atoKohi3Seikyugaku, atoKohi3RiyoshaFutangaku, atoKohi3KinkyuShisetsuRyoyoSeikyugaku, atoKohi3TokuteiShinryohiSeikyugaku, atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku, keikaiKubunCode, shinsaYM, seiriNo, sofuYM, torikomiYM, dokujiSakuseiKubun, hokenshaHoyuKyufujissekiJohoSakujoFlag);
    }

// </editor-fold>
}

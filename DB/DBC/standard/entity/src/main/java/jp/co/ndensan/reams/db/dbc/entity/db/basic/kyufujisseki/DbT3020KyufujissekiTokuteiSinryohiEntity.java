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
 * 給付実績特定診療費テーブルのエンティティクラスです。
 * <br/> サービス提供年月が平成１５年３月以前の場合
 */
public class DbT3020KyufujissekiTokuteiSinryohiEntity extends DbTableEntityBase<DbT3020KyufujissekiTokuteiSinryohiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3020KyufujissekiTokuteiSinryohi");

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
    private int hokenShidoKanriryo;
    private int hokenTanjunXsen;
    private int hokenRehabilitation;
    private int hokenSeishinkaSemmonRyoho;
    private int hokenTotalTanisu;
    private int kohi1ShidoKanriryo;
    private int kohi1TanjunXsen;
    private int kohi1Rehabilitation;
    private int kohi1SeishinkaSemmonRyoho;
    private int kohi1TotalTanisu;
    private int kohi2ShidoKanriryo;
    private int kohi2TanjunXsen;
    private int kohi2Rehabilitation;
    private int kohi2SeishinkaSemmonRyoho;
    private int kohi2TotalTanisu;
    private int kohi3ShidoKanriryo;
    private int kohi3TanjunXsen;
    private int kohi3Rehabilitation;
    private int kohi3SeishinkaSemmonRyoho;
    private int kohi3TotalTanisu;
    private RString tekiyo1;
    private RString tekiyo2;
    private RString tekiyo3;
    private RString tekiyo4;
    private RString tekiyo5;
    private RString tekiyo6;
    private RString tekiyo7;
    private RString tekiyo8;
    private RString tekiyo9;
    private RString tekiyo10;
    private RString tekiyo11;
    private RString tekiyo12;
    private RString tekiyo13;
    private RString tekiyo14;
    private RString tekiyo15;
    private RString tekiyo16;
    private RString tekiyo17;
    private RString tekiyo18;
    private RString tekiyo19;
    private RString tekiyo20;
    private int atoHokenShidoKanriryo;
    private int atoHokenTanjunXsen;
    private int atoHokenRehabilitation;
    private int atoHokenSeishinkaSemmonRyoho;
    private int atoKohi1ShidoKanriryo;
    private int atoKohi1TanjunXsen;
    private int atoKohi1Rehabilitation;
    private int atoKohi1SeishinkaSemmonRyoho;
    private int atoKohi2ShidoKanriryo;
    private int atoKohi2TanjunXsen;
    private int atoKohi2Rehabilitation;
    private int atoKohi2SeishinkaSemmonRyoho;
    private int atoKohi3ShidoKanriryo;
    private int atoKohi3TanjunXsen;
    private int atoKohi3Rehabilitation;
    private int atoKohi3SeishinkaSemmonRyoho;
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
     * 保険・指導管理料等のgetメソッドです。
     *
     * @return 保険・指導管理料等
     */
    public int getHokenShidoKanriryo() {
        return hokenShidoKanriryo;
    }

    /**
     * 保険・指導管理料等のsetメソッドです。
     *
     * @param hokenShidoKanriryo 保険・指導管理料等
     */
    public void setHokenShidoKanriryo(int hokenShidoKanriryo) {
        this.hokenShidoKanriryo = hokenShidoKanriryo;
    }

    /**
     * 保険・単純エックス線のgetメソッドです。
     *
     * @return 保険・単純エックス線
     */
    public int getHokenTanjunXsen() {
        return hokenTanjunXsen;
    }

    /**
     * 保険・単純エックス線のsetメソッドです。
     *
     * @param hokenTanjunXsen 保険・単純エックス線
     */
    public void setHokenTanjunXsen(int hokenTanjunXsen) {
        this.hokenTanjunXsen = hokenTanjunXsen;
    }

    /**
     * 保険・リハビリテーションのgetメソッドです。
     *
     * @return 保険・リハビリテーション
     */
    public int getHokenRehabilitation() {
        return hokenRehabilitation;
    }

    /**
     * 保険・リハビリテーションのsetメソッドです。
     *
     * @param hokenRehabilitation 保険・リハビリテーション
     */
    public void setHokenRehabilitation(int hokenRehabilitation) {
        this.hokenRehabilitation = hokenRehabilitation;
    }

    /**
     * 保険・精神科専門療法のgetメソッドです。
     *
     * @return 保険・精神科専門療法
     */
    public int getHokenSeishinkaSemmonRyoho() {
        return hokenSeishinkaSemmonRyoho;
    }

    /**
     * 保険・精神科専門療法のsetメソッドです。
     *
     * @param hokenSeishinkaSemmonRyoho 保険・精神科専門療法
     */
    public void setHokenSeishinkaSemmonRyoho(int hokenSeishinkaSemmonRyoho) {
        this.hokenSeishinkaSemmonRyoho = hokenSeishinkaSemmonRyoho;
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
     * 公費１・指導管理料等のgetメソッドです。
     *
     * @return 公費１・指導管理料等
     */
    public int getKohi1ShidoKanriryo() {
        return kohi1ShidoKanriryo;
    }

    /**
     * 公費１・指導管理料等のsetメソッドです。
     *
     * @param kohi1ShidoKanriryo 公費１・指導管理料等
     */
    public void setKohi1ShidoKanriryo(int kohi1ShidoKanriryo) {
        this.kohi1ShidoKanriryo = kohi1ShidoKanriryo;
    }

    /**
     * 公費１・単純エックス線のgetメソッドです。
     *
     * @return 公費１・単純エックス線
     */
    public int getKohi1TanjunXsen() {
        return kohi1TanjunXsen;
    }

    /**
     * 公費１・単純エックス線のsetメソッドです。
     *
     * @param kohi1TanjunXsen 公費１・単純エックス線
     */
    public void setKohi1TanjunXsen(int kohi1TanjunXsen) {
        this.kohi1TanjunXsen = kohi1TanjunXsen;
    }

    /**
     * 公費１・リハビリテーションのgetメソッドです。
     *
     * @return 公費１・リハビリテーション
     */
    public int getKohi1Rehabilitation() {
        return kohi1Rehabilitation;
    }

    /**
     * 公費１・リハビリテーションのsetメソッドです。
     *
     * @param kohi1Rehabilitation 公費１・リハビリテーション
     */
    public void setKohi1Rehabilitation(int kohi1Rehabilitation) {
        this.kohi1Rehabilitation = kohi1Rehabilitation;
    }

    /**
     * 公費１・精神科専門療法のgetメソッドです。
     *
     * @return 公費１・精神科専門療法
     */
    public int getKohi1SeishinkaSemmonRyoho() {
        return kohi1SeishinkaSemmonRyoho;
    }

    /**
     * 公費１・精神科専門療法のsetメソッドです。
     *
     * @param kohi1SeishinkaSemmonRyoho 公費１・精神科専門療法
     */
    public void setKohi1SeishinkaSemmonRyoho(int kohi1SeishinkaSemmonRyoho) {
        this.kohi1SeishinkaSemmonRyoho = kohi1SeishinkaSemmonRyoho;
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
     * 公費２・指導管理料等のgetメソッドです。
     *
     * @return 公費２・指導管理料等
     */
    public int getKohi2ShidoKanriryo() {
        return kohi2ShidoKanriryo;
    }

    /**
     * 公費２・指導管理料等のsetメソッドです。
     *
     * @param kohi2ShidoKanriryo 公費２・指導管理料等
     */
    public void setKohi2ShidoKanriryo(int kohi2ShidoKanriryo) {
        this.kohi2ShidoKanriryo = kohi2ShidoKanriryo;
    }

    /**
     * 公費２・単純エックス線のgetメソッドです。
     *
     * @return 公費２・単純エックス線
     */
    public int getKohi2TanjunXsen() {
        return kohi2TanjunXsen;
    }

    /**
     * 公費２・単純エックス線のsetメソッドです。
     *
     * @param kohi2TanjunXsen 公費２・単純エックス線
     */
    public void setKohi2TanjunXsen(int kohi2TanjunXsen) {
        this.kohi2TanjunXsen = kohi2TanjunXsen;
    }

    /**
     * 公費２・リハビリテーションのgetメソッドです。
     *
     * @return 公費２・リハビリテーション
     */
    public int getKohi2Rehabilitation() {
        return kohi2Rehabilitation;
    }

    /**
     * 公費２・リハビリテーションのsetメソッドです。
     *
     * @param kohi2Rehabilitation 公費２・リハビリテーション
     */
    public void setKohi2Rehabilitation(int kohi2Rehabilitation) {
        this.kohi2Rehabilitation = kohi2Rehabilitation;
    }

    /**
     * 公費２・精神科専門療法のgetメソッドです。
     *
     * @return 公費２・精神科専門療法
     */
    public int getKohi2SeishinkaSemmonRyoho() {
        return kohi2SeishinkaSemmonRyoho;
    }

    /**
     * 公費２・精神科専門療法のsetメソッドです。
     *
     * @param kohi2SeishinkaSemmonRyoho 公費２・精神科専門療法
     */
    public void setKohi2SeishinkaSemmonRyoho(int kohi2SeishinkaSemmonRyoho) {
        this.kohi2SeishinkaSemmonRyoho = kohi2SeishinkaSemmonRyoho;
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
     * 公費３・指導管理料等のgetメソッドです。
     *
     * @return 公費３・指導管理料等
     */
    public int getKohi3ShidoKanriryo() {
        return kohi3ShidoKanriryo;
    }

    /**
     * 公費３・指導管理料等のsetメソッドです。
     *
     * @param kohi3ShidoKanriryo 公費３・指導管理料等
     */
    public void setKohi3ShidoKanriryo(int kohi3ShidoKanriryo) {
        this.kohi3ShidoKanriryo = kohi3ShidoKanriryo;
    }

    /**
     * 公費３・単純エックス線のgetメソッドです。
     *
     * @return 公費３・単純エックス線
     */
    public int getKohi3TanjunXsen() {
        return kohi3TanjunXsen;
    }

    /**
     * 公費３・単純エックス線のsetメソッドです。
     *
     * @param kohi3TanjunXsen 公費３・単純エックス線
     */
    public void setKohi3TanjunXsen(int kohi3TanjunXsen) {
        this.kohi3TanjunXsen = kohi3TanjunXsen;
    }

    /**
     * 公費３・リハビリテーションのgetメソッドです。
     *
     * @return 公費３・リハビリテーション
     */
    public int getKohi3Rehabilitation() {
        return kohi3Rehabilitation;
    }

    /**
     * 公費３・リハビリテーションのsetメソッドです。
     *
     * @param kohi3Rehabilitation 公費３・リハビリテーション
     */
    public void setKohi3Rehabilitation(int kohi3Rehabilitation) {
        this.kohi3Rehabilitation = kohi3Rehabilitation;
    }

    /**
     * 公費３・精神科専門療法のgetメソッドです。
     *
     * @return 公費３・精神科専門療法
     */
    public int getKohi3SeishinkaSemmonRyoho() {
        return kohi3SeishinkaSemmonRyoho;
    }

    /**
     * 公費３・精神科専門療法のsetメソッドです。
     *
     * @param kohi3SeishinkaSemmonRyoho 公費３・精神科専門療法
     */
    public void setKohi3SeishinkaSemmonRyoho(int kohi3SeishinkaSemmonRyoho) {
        this.kohi3SeishinkaSemmonRyoho = kohi3SeishinkaSemmonRyoho;
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
     * 摘要１のgetメソッドです。
     *
     * @return 摘要１
     */
    public RString getTekiyo1() {
        return tekiyo1;
    }

    /**
     * 摘要１のsetメソッドです。
     *
     * @param tekiyo1 摘要１
     */
    public void setTekiyo1(RString tekiyo1) {
        this.tekiyo1 = tekiyo1;
    }

    /**
     * 摘要２のgetメソッドです。
     *
     * @return 摘要２
     */
    public RString getTekiyo2() {
        return tekiyo2;
    }

    /**
     * 摘要２のsetメソッドです。
     *
     * @param tekiyo2 摘要２
     */
    public void setTekiyo2(RString tekiyo2) {
        this.tekiyo2 = tekiyo2;
    }

    /**
     * 摘要３のgetメソッドです。
     *
     * @return 摘要３
     */
    public RString getTekiyo3() {
        return tekiyo3;
    }

    /**
     * 摘要３のsetメソッドです。
     *
     * @param tekiyo3 摘要３
     */
    public void setTekiyo3(RString tekiyo3) {
        this.tekiyo3 = tekiyo3;
    }

    /**
     * 摘要４のgetメソッドです。
     *
     * @return 摘要４
     */
    public RString getTekiyo4() {
        return tekiyo4;
    }

    /**
     * 摘要４のsetメソッドです。
     *
     * @param tekiyo4 摘要４
     */
    public void setTekiyo4(RString tekiyo4) {
        this.tekiyo4 = tekiyo4;
    }

    /**
     * 摘要５のgetメソッドです。
     *
     * @return 摘要５
     */
    public RString getTekiyo5() {
        return tekiyo5;
    }

    /**
     * 摘要５のsetメソッドです。
     *
     * @param tekiyo5 摘要５
     */
    public void setTekiyo5(RString tekiyo5) {
        this.tekiyo5 = tekiyo5;
    }

    /**
     * 摘要６のgetメソッドです。
     *
     * @return 摘要６
     */
    public RString getTekiyo6() {
        return tekiyo6;
    }

    /**
     * 摘要６のsetメソッドです。
     *
     * @param tekiyo6 摘要６
     */
    public void setTekiyo6(RString tekiyo6) {
        this.tekiyo6 = tekiyo6;
    }

    /**
     * 摘要７のgetメソッドです。
     *
     * @return 摘要７
     */
    public RString getTekiyo7() {
        return tekiyo7;
    }

    /**
     * 摘要７のsetメソッドです。
     *
     * @param tekiyo7 摘要７
     */
    public void setTekiyo7(RString tekiyo7) {
        this.tekiyo7 = tekiyo7;
    }

    /**
     * 摘要８のgetメソッドです。
     *
     * @return 摘要８
     */
    public RString getTekiyo8() {
        return tekiyo8;
    }

    /**
     * 摘要８のsetメソッドです。
     *
     * @param tekiyo8 摘要８
     */
    public void setTekiyo8(RString tekiyo8) {
        this.tekiyo8 = tekiyo8;
    }

    /**
     * 摘要９のgetメソッドです。
     *
     * @return 摘要９
     */
    public RString getTekiyo9() {
        return tekiyo9;
    }

    /**
     * 摘要９のsetメソッドです。
     *
     * @param tekiyo9 摘要９
     */
    public void setTekiyo9(RString tekiyo9) {
        this.tekiyo9 = tekiyo9;
    }

    /**
     * 摘要１０のgetメソッドです。
     *
     * @return 摘要１０
     */
    public RString getTekiyo10() {
        return tekiyo10;
    }

    /**
     * 摘要１０のsetメソッドです。
     *
     * @param tekiyo10 摘要１０
     */
    public void setTekiyo10(RString tekiyo10) {
        this.tekiyo10 = tekiyo10;
    }

    /**
     * 摘要１１のgetメソッドです。
     *
     * @return 摘要１１
     */
    public RString getTekiyo11() {
        return tekiyo11;
    }

    /**
     * 摘要１１のsetメソッドです。
     *
     * @param tekiyo11 摘要１１
     */
    public void setTekiyo11(RString tekiyo11) {
        this.tekiyo11 = tekiyo11;
    }

    /**
     * 摘要１２のgetメソッドです。
     *
     * @return 摘要１２
     */
    public RString getTekiyo12() {
        return tekiyo12;
    }

    /**
     * 摘要１２のsetメソッドです。
     *
     * @param tekiyo12 摘要１２
     */
    public void setTekiyo12(RString tekiyo12) {
        this.tekiyo12 = tekiyo12;
    }

    /**
     * 摘要１３のgetメソッドです。
     *
     * @return 摘要１３
     */
    public RString getTekiyo13() {
        return tekiyo13;
    }

    /**
     * 摘要１３のsetメソッドです。
     *
     * @param tekiyo13 摘要１３
     */
    public void setTekiyo13(RString tekiyo13) {
        this.tekiyo13 = tekiyo13;
    }

    /**
     * 摘要１４のgetメソッドです。
     *
     * @return 摘要１４
     */
    public RString getTekiyo14() {
        return tekiyo14;
    }

    /**
     * 摘要１４のsetメソッドです。
     *
     * @param tekiyo14 摘要１４
     */
    public void setTekiyo14(RString tekiyo14) {
        this.tekiyo14 = tekiyo14;
    }

    /**
     * 摘要１５のgetメソッドです。
     *
     * @return 摘要１５
     */
    public RString getTekiyo15() {
        return tekiyo15;
    }

    /**
     * 摘要１５のsetメソッドです。
     *
     * @param tekiyo15 摘要１５
     */
    public void setTekiyo15(RString tekiyo15) {
        this.tekiyo15 = tekiyo15;
    }

    /**
     * 摘要１６のgetメソッドです。
     *
     * @return 摘要１６
     */
    public RString getTekiyo16() {
        return tekiyo16;
    }

    /**
     * 摘要１６のsetメソッドです。
     *
     * @param tekiyo16 摘要１６
     */
    public void setTekiyo16(RString tekiyo16) {
        this.tekiyo16 = tekiyo16;
    }

    /**
     * 摘要１７のgetメソッドです。
     *
     * @return 摘要１７
     */
    public RString getTekiyo17() {
        return tekiyo17;
    }

    /**
     * 摘要１７のsetメソッドです。
     *
     * @param tekiyo17 摘要１７
     */
    public void setTekiyo17(RString tekiyo17) {
        this.tekiyo17 = tekiyo17;
    }

    /**
     * 摘要１８のgetメソッドです。
     *
     * @return 摘要１８
     */
    public RString getTekiyo18() {
        return tekiyo18;
    }

    /**
     * 摘要１８のsetメソッドです。
     *
     * @param tekiyo18 摘要１８
     */
    public void setTekiyo18(RString tekiyo18) {
        this.tekiyo18 = tekiyo18;
    }

    /**
     * 摘要１９のgetメソッドです。
     *
     * @return 摘要１９
     */
    public RString getTekiyo19() {
        return tekiyo19;
    }

    /**
     * 摘要１９のsetメソッドです。
     *
     * @param tekiyo19 摘要１９
     */
    public void setTekiyo19(RString tekiyo19) {
        this.tekiyo19 = tekiyo19;
    }

    /**
     * 摘要２０のgetメソッドです。
     *
     * @return 摘要２０
     */
    public RString getTekiyo20() {
        return tekiyo20;
    }

    /**
     * 摘要２０のsetメソッドです。
     *
     * @param tekiyo20 摘要２０
     */
    public void setTekiyo20(RString tekiyo20) {
        this.tekiyo20 = tekiyo20;
    }

    /**
     * 後・保険・指導管理料等のgetメソッドです。
     *
     * @return 後・保険・指導管理料等
     */
    public int getAtoHokenShidoKanriryo() {
        return atoHokenShidoKanriryo;
    }

    /**
     * 後・保険・指導管理料等のsetメソッドです。
     *
     * @param atoHokenShidoKanriryo 後・保険・指導管理料等
     */
    public void setAtoHokenShidoKanriryo(int atoHokenShidoKanriryo) {
        this.atoHokenShidoKanriryo = atoHokenShidoKanriryo;
    }

    /**
     * 後・保険・単純エックス線のgetメソッドです。
     *
     * @return 後・保険・単純エックス線
     */
    public int getAtoHokenTanjunXsen() {
        return atoHokenTanjunXsen;
    }

    /**
     * 後・保険・単純エックス線のsetメソッドです。
     *
     * @param atoHokenTanjunXsen 後・保険・単純エックス線
     */
    public void setAtoHokenTanjunXsen(int atoHokenTanjunXsen) {
        this.atoHokenTanjunXsen = atoHokenTanjunXsen;
    }

    /**
     * 後・保険・リハビリテーションのgetメソッドです。
     *
     * @return 後・保険・リハビリテーション
     */
    public int getAtoHokenRehabilitation() {
        return atoHokenRehabilitation;
    }

    /**
     * 後・保険・リハビリテーションのsetメソッドです。
     *
     * @param atoHokenRehabilitation 後・保険・リハビリテーション
     */
    public void setAtoHokenRehabilitation(int atoHokenRehabilitation) {
        this.atoHokenRehabilitation = atoHokenRehabilitation;
    }

    /**
     * 後・保険・精神科専門療法のgetメソッドです。
     *
     * @return 後・保険・精神科専門療法
     */
    public int getAtoHokenSeishinkaSemmonRyoho() {
        return atoHokenSeishinkaSemmonRyoho;
    }

    /**
     * 後・保険・精神科専門療法のsetメソッドです。
     *
     * @param atoHokenSeishinkaSemmonRyoho 後・保険・精神科専門療法
     */
    public void setAtoHokenSeishinkaSemmonRyoho(int atoHokenSeishinkaSemmonRyoho) {
        this.atoHokenSeishinkaSemmonRyoho = atoHokenSeishinkaSemmonRyoho;
    }

    /**
     * 後・公費１・指導管理料等のgetメソッドです。
     *
     * @return 後・公費１・指導管理料等
     */
    public int getAtoKohi1ShidoKanriryo() {
        return atoKohi1ShidoKanriryo;
    }

    /**
     * 後・公費１・指導管理料等のsetメソッドです。
     *
     * @param atoKohi1ShidoKanriryo 後・公費１・指導管理料等
     */
    public void setAtoKohi1ShidoKanriryo(int atoKohi1ShidoKanriryo) {
        this.atoKohi1ShidoKanriryo = atoKohi1ShidoKanriryo;
    }

    /**
     * 後・公費１・単純エックス線のgetメソッドです。
     *
     * @return 後・公費１・単純エックス線
     */
    public int getAtoKohi1TanjunXsen() {
        return atoKohi1TanjunXsen;
    }

    /**
     * 後・公費１・単純エックス線のsetメソッドです。
     *
     * @param atoKohi1TanjunXsen 後・公費１・単純エックス線
     */
    public void setAtoKohi1TanjunXsen(int atoKohi1TanjunXsen) {
        this.atoKohi1TanjunXsen = atoKohi1TanjunXsen;
    }

    /**
     * 後・公費１・リハビリテーションのgetメソッドです。
     *
     * @return 後・公費１・リハビリテーション
     */
    public int getAtoKohi1Rehabilitation() {
        return atoKohi1Rehabilitation;
    }

    /**
     * 後・公費１・リハビリテーションのsetメソッドです。
     *
     * @param atoKohi1Rehabilitation 後・公費１・リハビリテーション
     */
    public void setAtoKohi1Rehabilitation(int atoKohi1Rehabilitation) {
        this.atoKohi1Rehabilitation = atoKohi1Rehabilitation;
    }

    /**
     * 後・公費１・精神科専門療法のgetメソッドです。
     *
     * @return 後・公費１・精神科専門療法
     */
    public int getAtoKohi1SeishinkaSemmonRyoho() {
        return atoKohi1SeishinkaSemmonRyoho;
    }

    /**
     * 後・公費１・精神科専門療法のsetメソッドです。
     *
     * @param atoKohi1SeishinkaSemmonRyoho 後・公費１・精神科専門療法
     */
    public void setAtoKohi1SeishinkaSemmonRyoho(int atoKohi1SeishinkaSemmonRyoho) {
        this.atoKohi1SeishinkaSemmonRyoho = atoKohi1SeishinkaSemmonRyoho;
    }

    /**
     * 後・公費２・指導管理料等のgetメソッドです。
     *
     * @return 後・公費２・指導管理料等
     */
    public int getAtoKohi2ShidoKanriryo() {
        return atoKohi2ShidoKanriryo;
    }

    /**
     * 後・公費２・指導管理料等のsetメソッドです。
     *
     * @param atoKohi2ShidoKanriryo 後・公費２・指導管理料等
     */
    public void setAtoKohi2ShidoKanriryo(int atoKohi2ShidoKanriryo) {
        this.atoKohi2ShidoKanriryo = atoKohi2ShidoKanriryo;
    }

    /**
     * 後・公費２・単純エックス線のgetメソッドです。
     *
     * @return 後・公費２・単純エックス線
     */
    public int getAtoKohi2TanjunXsen() {
        return atoKohi2TanjunXsen;
    }

    /**
     * 後・公費２・単純エックス線のsetメソッドです。
     *
     * @param atoKohi2TanjunXsen 後・公費２・単純エックス線
     */
    public void setAtoKohi2TanjunXsen(int atoKohi2TanjunXsen) {
        this.atoKohi2TanjunXsen = atoKohi2TanjunXsen;
    }

    /**
     * 後・公費２・リハビリテーションのgetメソッドです。
     *
     * @return 後・公費２・リハビリテーション
     */
    public int getAtoKohi2Rehabilitation() {
        return atoKohi2Rehabilitation;
    }

    /**
     * 後・公費２・リハビリテーションのsetメソッドです。
     *
     * @param atoKohi2Rehabilitation 後・公費２・リハビリテーション
     */
    public void setAtoKohi2Rehabilitation(int atoKohi2Rehabilitation) {
        this.atoKohi2Rehabilitation = atoKohi2Rehabilitation;
    }

    /**
     * 後・公費２・精神科専門療法のgetメソッドです。
     *
     * @return 後・公費２・精神科専門療法
     */
    public int getAtoKohi2SeishinkaSemmonRyoho() {
        return atoKohi2SeishinkaSemmonRyoho;
    }

    /**
     * 後・公費２・精神科専門療法のsetメソッドです。
     *
     * @param atoKohi2SeishinkaSemmonRyoho 後・公費２・精神科専門療法
     */
    public void setAtoKohi2SeishinkaSemmonRyoho(int atoKohi2SeishinkaSemmonRyoho) {
        this.atoKohi2SeishinkaSemmonRyoho = atoKohi2SeishinkaSemmonRyoho;
    }

    /**
     * 後・公費３・指導管理料等のgetメソッドです。
     *
     * @return 後・公費３・指導管理料等
     */
    public int getAtoKohi3ShidoKanriryo() {
        return atoKohi3ShidoKanriryo;
    }

    /**
     * 後・公費３・指導管理料等のsetメソッドです。
     *
     * @param atoKohi3ShidoKanriryo 後・公費３・指導管理料等
     */
    public void setAtoKohi3ShidoKanriryo(int atoKohi3ShidoKanriryo) {
        this.atoKohi3ShidoKanriryo = atoKohi3ShidoKanriryo;
    }

    /**
     * 後・公費３・単純エックス線のgetメソッドです。
     *
     * @return 後・公費３・単純エックス線
     */
    public int getAtoKohi3TanjunXsen() {
        return atoKohi3TanjunXsen;
    }

    /**
     * 後・公費３・単純エックス線のsetメソッドです。
     *
     * @param atoKohi3TanjunXsen 後・公費３・単純エックス線
     */
    public void setAtoKohi3TanjunXsen(int atoKohi3TanjunXsen) {
        this.atoKohi3TanjunXsen = atoKohi3TanjunXsen;
    }

    /**
     * 後・公費３・リハビリテーションのgetメソッドです。
     *
     * @return 後・公費３・リハビリテーション
     */
    public int getAtoKohi3Rehabilitation() {
        return atoKohi3Rehabilitation;
    }

    /**
     * 後・公費３・リハビリテーションのsetメソッドです。
     *
     * @param atoKohi3Rehabilitation 後・公費３・リハビリテーション
     */
    public void setAtoKohi3Rehabilitation(int atoKohi3Rehabilitation) {
        this.atoKohi3Rehabilitation = atoKohi3Rehabilitation;
    }

    /**
     * 後・公費３・精神科専門療法のgetメソッドです。
     *
     * @return 後・公費３・精神科専門療法
     */
    public int getAtoKohi3SeishinkaSemmonRyoho() {
        return atoKohi3SeishinkaSemmonRyoho;
    }

    /**
     * 後・公費３・精神科専門療法のsetメソッドです。
     *
     * @param atoKohi3SeishinkaSemmonRyoho 後・公費３・精神科専門療法
     */
    public void setAtoKohi3SeishinkaSemmonRyoho(int atoKohi3SeishinkaSemmonRyoho) {
        this.atoKohi3SeishinkaSemmonRyoho = atoKohi3SeishinkaSemmonRyoho;
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
     * このエンティティの主キーが他の{@literal DbT3020KyufujissekiTokuteiSinryohiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3020KyufujissekiTokuteiSinryohiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3020KyufujissekiTokuteiSinryohiEntity other) {
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
    public void shallowCopy(DbT3020KyufujissekiTokuteiSinryohiEntity entity) {
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
        this.hokenShidoKanriryo = entity.hokenShidoKanriryo;
        this.hokenTanjunXsen = entity.hokenTanjunXsen;
        this.hokenRehabilitation = entity.hokenRehabilitation;
        this.hokenSeishinkaSemmonRyoho = entity.hokenSeishinkaSemmonRyoho;
        this.hokenTotalTanisu = entity.hokenTotalTanisu;
        this.kohi1ShidoKanriryo = entity.kohi1ShidoKanriryo;
        this.kohi1TanjunXsen = entity.kohi1TanjunXsen;
        this.kohi1Rehabilitation = entity.kohi1Rehabilitation;
        this.kohi1SeishinkaSemmonRyoho = entity.kohi1SeishinkaSemmonRyoho;
        this.kohi1TotalTanisu = entity.kohi1TotalTanisu;
        this.kohi2ShidoKanriryo = entity.kohi2ShidoKanriryo;
        this.kohi2TanjunXsen = entity.kohi2TanjunXsen;
        this.kohi2Rehabilitation = entity.kohi2Rehabilitation;
        this.kohi2SeishinkaSemmonRyoho = entity.kohi2SeishinkaSemmonRyoho;
        this.kohi2TotalTanisu = entity.kohi2TotalTanisu;
        this.kohi3ShidoKanriryo = entity.kohi3ShidoKanriryo;
        this.kohi3TanjunXsen = entity.kohi3TanjunXsen;
        this.kohi3Rehabilitation = entity.kohi3Rehabilitation;
        this.kohi3SeishinkaSemmonRyoho = entity.kohi3SeishinkaSemmonRyoho;
        this.kohi3TotalTanisu = entity.kohi3TotalTanisu;
        this.tekiyo1 = entity.tekiyo1;
        this.tekiyo2 = entity.tekiyo2;
        this.tekiyo3 = entity.tekiyo3;
        this.tekiyo4 = entity.tekiyo4;
        this.tekiyo5 = entity.tekiyo5;
        this.tekiyo6 = entity.tekiyo6;
        this.tekiyo7 = entity.tekiyo7;
        this.tekiyo8 = entity.tekiyo8;
        this.tekiyo9 = entity.tekiyo9;
        this.tekiyo10 = entity.tekiyo10;
        this.tekiyo11 = entity.tekiyo11;
        this.tekiyo12 = entity.tekiyo12;
        this.tekiyo13 = entity.tekiyo13;
        this.tekiyo14 = entity.tekiyo14;
        this.tekiyo15 = entity.tekiyo15;
        this.tekiyo16 = entity.tekiyo16;
        this.tekiyo17 = entity.tekiyo17;
        this.tekiyo18 = entity.tekiyo18;
        this.tekiyo19 = entity.tekiyo19;
        this.tekiyo20 = entity.tekiyo20;
        this.atoHokenShidoKanriryo = entity.atoHokenShidoKanriryo;
        this.atoHokenTanjunXsen = entity.atoHokenTanjunXsen;
        this.atoHokenRehabilitation = entity.atoHokenRehabilitation;
        this.atoHokenSeishinkaSemmonRyoho = entity.atoHokenSeishinkaSemmonRyoho;
        this.atoKohi1ShidoKanriryo = entity.atoKohi1ShidoKanriryo;
        this.atoKohi1TanjunXsen = entity.atoKohi1TanjunXsen;
        this.atoKohi1Rehabilitation = entity.atoKohi1Rehabilitation;
        this.atoKohi1SeishinkaSemmonRyoho = entity.atoKohi1SeishinkaSemmonRyoho;
        this.atoKohi2ShidoKanriryo = entity.atoKohi2ShidoKanriryo;
        this.atoKohi2TanjunXsen = entity.atoKohi2TanjunXsen;
        this.atoKohi2Rehabilitation = entity.atoKohi2Rehabilitation;
        this.atoKohi2SeishinkaSemmonRyoho = entity.atoKohi2SeishinkaSemmonRyoho;
        this.atoKohi3ShidoKanriryo = entity.atoKohi3ShidoKanriryo;
        this.atoKohi3TanjunXsen = entity.atoKohi3TanjunXsen;
        this.atoKohi3Rehabilitation = entity.atoKohi3Rehabilitation;
        this.atoKohi3SeishinkaSemmonRyoho = entity.atoKohi3SeishinkaSemmonRyoho;
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
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, recodeJunjiNo, shobyoName, hokenShidoKanriryo, hokenTanjunXsen, hokenRehabilitation, hokenSeishinkaSemmonRyoho, hokenTotalTanisu, kohi1ShidoKanriryo, kohi1TanjunXsen, kohi1Rehabilitation, kohi1SeishinkaSemmonRyoho, kohi1TotalTanisu, kohi2ShidoKanriryo, kohi2TanjunXsen, kohi2Rehabilitation, kohi2SeishinkaSemmonRyoho, kohi2TotalTanisu, kohi3ShidoKanriryo, kohi3TanjunXsen, kohi3Rehabilitation, kohi3SeishinkaSemmonRyoho, kohi3TotalTanisu, tekiyo1, tekiyo2, tekiyo3, tekiyo4, tekiyo5, tekiyo6, tekiyo7, tekiyo8, tekiyo9, tekiyo10, tekiyo11, tekiyo12, tekiyo13, tekiyo14, tekiyo15, tekiyo16, tekiyo17, tekiyo18, tekiyo19, tekiyo20, atoHokenShidoKanriryo, atoHokenTanjunXsen, atoHokenRehabilitation, atoHokenSeishinkaSemmonRyoho, atoKohi1ShidoKanriryo, atoKohi1TanjunXsen, atoKohi1Rehabilitation, atoKohi1SeishinkaSemmonRyoho, atoKohi2ShidoKanriryo, atoKohi2TanjunXsen, atoKohi2Rehabilitation, atoKohi2SeishinkaSemmonRyoho, atoKohi3ShidoKanriryo, atoKohi3TanjunXsen, atoKohi3Rehabilitation, atoKohi3SeishinkaSemmonRyoho, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}

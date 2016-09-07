package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 年金特徴回付情報テーブルのエンティティクラスです。
 *
 * @reamsid_L DBZ-9999-022 yangchenbing
 */
public class UeT0511NenkinTokuchoKaifuJohoEntity extends DbTableEntityBase<UeT0511NenkinTokuchoKaifuJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("UeT0511NenkinTokuchoKaifuJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private GyomuCode gyomuCode;
    @PrimaryKey
    private FlexibleYear shoriNendo;
    @PrimaryKey
    private RString tsuchiNaiyoCode;
    @PrimaryKey
    private FlexibleYearMonth shoriTaishoYM;
    @PrimaryKey
    private RString kisoNenkinNo;
    @PrimaryKey
    private RString nenkinCode;
    @PrimaryKey
    private RString koseiCityCode;
    @PrimaryKey
    private int renban;
    private RDateTime shoriTimestamp;
    private RString renkeiShubetsu;
    private RString hosokuTsuki;
    private RString tenbikiTsuki;
    private RString dtCityCode;
    private Code dtTokubetsuChoshuGimushaCode;
    private RString dtTsuchiNaiyoCode;
    private RString dtBaitaiCode;
    private RString dtTokubetsuChoshuSeidoCode;
    private RString dtSakuseiYMD;
    private RString dtKisoNenkinNo;
    private RString dtNenkinCode;
    private RString dtYobi1;
    private RString dtBirthDay;
    private RString dtSeibetsu;
    private RString dtKanaShimei;
    private RString dtShiftCode1;
    private RString dtKanjiShimei;
    private RString dtShiftCode2;
    private RString dtYubinNo;
    private RString dtKanaJusho;
    private RString dtShiftCode3;
    private RString dtKanjiJusho;
    private RString dtShiftCode4;
    private RString dtKakushuKubun;
    private RString dtShoriKekka;
    private RString dtKokiIkanCode;
    private RString dtKakushuYMD;
    private RString dtKakushuKingaku1;
    private RString dtKakushuKingaku2;
    private RString dtKakushuKingaku3;
    private RString dtYobi2;
    private RString dtKyosaiNenkinshoshoKigoNo;
    private ShikibetsuCode shikibetsuCode;
    private RString hihokenshaNo;
    private SetaiCode kokuhoSetaiCode;
    private RString dtKakushuKingaku4;
    private RString dtKakushuKingaku5;
    private RString dtKakushuKingaku6;
    private RString dtKakushuKingaku7;
    private RString dtKakushuKingaku8;
    private RString dtTeishiYM;
    private RString dtYobi4Juminzei;
    private RString dtKojinNo;
    private RString kokuhoYoteiSoshitsuKubun;

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
     * 業務コードのgetメソッドです。
     *
     * @return 業務コード
     */
    public GyomuCode getGyomuCode() {
        return gyomuCode;
    }

    /**
     * 業務コードのsetメソッドです。
     *
     * @param gyomuCode 業務コード
     */
    public void setGyomuCode(@Nonnull GyomuCode gyomuCode) {
        this.gyomuCode = gyomuCode;
    }

    /**
     * 処理年度のgetメソッドです。
     *
     * @return 処理年度
     */
    public FlexibleYear getShoriNendo() {
        return shoriNendo;
    }

    /**
     * 処理年度のsetメソッドです。
     *
     * @param shoriNendo 処理年度
     */
    public void setShoriNendo(@Nonnull FlexibleYear shoriNendo) {
        this.shoriNendo = shoriNendo;
    }

    /**
     * 通知内容コードのgetメソッドです。
     *
     * @return 通知内容コード
     */
    public RString getTsuchiNaiyoCode() {
        return tsuchiNaiyoCode;
    }

    /**
     * 通知内容コードのsetメソッドです。
     *
     * @param tsuchiNaiyoCode 通知内容コード
     */
    public void setTsuchiNaiyoCode(@Nonnull RString tsuchiNaiyoCode) {
        this.tsuchiNaiyoCode = tsuchiNaiyoCode;
    }

    /**
     * 処理対象年月のgetメソッドです。
     *
     * @return 処理対象年月
     */
    public FlexibleYearMonth getShoriTaishoYM() {
        return shoriTaishoYM;
    }

    /**
     * 処理対象年月のsetメソッドです。
     *
     * @param shoriTaishoYM 処理対象年月
     */
    public void setShoriTaishoYM(@Nonnull FlexibleYearMonth shoriTaishoYM) {
        this.shoriTaishoYM = shoriTaishoYM;
    }

    /**
     * 基礎年金番号のgetメソッドです。
     *
     * @return 基礎年金番号
     */
    public RString getKisoNenkinNo() {
        return kisoNenkinNo;
    }

    /**
     * 基礎年金番号のsetメソッドです。
     *
     * @param kisoNenkinNo 基礎年金番号
     */
    public void setKisoNenkinNo(@Nonnull RString kisoNenkinNo) {
        this.kisoNenkinNo = kisoNenkinNo;
    }

    /**
     * 年金コードのgetメソッドです。
     *
     * @return 年金コード
     */
    public RString getNenkinCode() {
        return nenkinCode;
    }

    /**
     * 年金コードのsetメソッドです。
     *
     * @param nenkinCode 年金コード
     */
    public void setNenkinCode(@Nonnull RString nenkinCode) {
        this.nenkinCode = nenkinCode;
    }

    /**
     * 構成市町村コードのgetメソッドです。
     *
     * @return 構成市町村コード
     */
    public RString getKoseiCityCode() {
        return koseiCityCode;
    }

    /**
     * 構成市町村コードのsetメソッドです。
     *
     * @param koseiCityCode 構成市町村コード
     */
    public void setKoseiCityCode(@Nonnull RString koseiCityCode) {
        this.koseiCityCode = koseiCityCode;
    }

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    public int getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     *
     * @param renban 連番
     */
    public void setRenban(@Nonnull int renban) {
        this.renban = renban;
    }

    /**
     * 処理日時のgetメソッドです。
     *
     * @return 処理日時
     */
    @CheckForNull
    public RDateTime getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * 処理日時のsetメソッドです。
     *
     * @param shoriTimestamp 処理日時
     */
    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * 連携種別のgetメソッドです。
     *
     * @return 連携種別
     */
    @CheckForNull
    public RString getRenkeiShubetsu() {
        return renkeiShubetsu;
    }

    /**
     * 連携種別のsetメソッドです。
     *
     * @param renkeiShubetsu 連携種別
     */
    public void setRenkeiShubetsu(RString renkeiShubetsu) {
        this.renkeiShubetsu = renkeiShubetsu;
    }

    /**
     * 捕捉月のgetメソッドです。
     *
     * @return 捕捉月
     */
    @CheckForNull
    public RString getHosokuTsuki() {
        return hosokuTsuki;
    }

    /**
     * 捕捉月のsetメソッドです。
     *
     * @param hosokuTsuki 捕捉月
     */
    public void setHosokuTsuki(RString hosokuTsuki) {
        this.hosokuTsuki = hosokuTsuki;
    }

    /**
     * 天引月のgetメソッドです。
     *
     * @return 天引月
     */
    @CheckForNull
    public RString getTenbikiTsuki() {
        return tenbikiTsuki;
    }

    /**
     * 天引月のsetメソッドです。
     *
     * @param tenbikiTsuki 天引月
     */
    public void setTenbikiTsuki(RString tenbikiTsuki) {
        this.tenbikiTsuki = tenbikiTsuki;
    }

    /**
     * DT市町村コードのgetメソッドです。
     *
     * @return DT市町村コード
     */
    @CheckForNull
    public RString getDtCityCode() {
        return dtCityCode;
    }

    /**
     * DT市町村コードのsetメソッドです。
     *
     * @param dtCityCode DT市町村コード
     */
    public void setDtCityCode(RString dtCityCode) {
        this.dtCityCode = dtCityCode;
    }

    /**
     * DT特別徴収義務者コードのgetメソッドです。
     *
     * @return DT特別徴収義務者コード
     */
    @CheckForNull
    public Code getDtTokubetsuChoshuGimushaCode() {
        return dtTokubetsuChoshuGimushaCode;
    }

    /**
     * DT特別徴収義務者コードのsetメソッドです。
     *
     * @param dtTokubetsuChoshuGimushaCode DT特別徴収義務者コード
     */
    public void setDtTokubetsuChoshuGimushaCode(Code dtTokubetsuChoshuGimushaCode) {
        this.dtTokubetsuChoshuGimushaCode = dtTokubetsuChoshuGimushaCode;
    }

    /**
     * DT通知内容コードのgetメソッドです。
     *
     * @return DT通知内容コード
     */
    @CheckForNull
    public RString getDtTsuchiNaiyoCode() {
        return dtTsuchiNaiyoCode;
    }

    /**
     * DT通知内容コードのsetメソッドです。
     *
     * @param dtTsuchiNaiyoCode DT通知内容コード
     */
    public void setDtTsuchiNaiyoCode(RString dtTsuchiNaiyoCode) {
        this.dtTsuchiNaiyoCode = dtTsuchiNaiyoCode;
    }

    /**
     * DT媒体コードのgetメソッドです。
     *
     * @return DT媒体コード
     */
    @CheckForNull
    public RString getDtBaitaiCode() {
        return dtBaitaiCode;
    }

    /**
     * DT媒体コードのsetメソッドです。
     *
     * @param dtBaitaiCode DT媒体コード
     */
    public void setDtBaitaiCode(RString dtBaitaiCode) {
        this.dtBaitaiCode = dtBaitaiCode;
    }

    /**
     * DT特別徴収制度コードのgetメソッドです。
     *
     * @return DT特別徴収制度コード
     */
    @CheckForNull
    public RString getDtTokubetsuChoshuSeidoCode() {
        return dtTokubetsuChoshuSeidoCode;
    }

    /**
     * DT特別徴収制度コードのsetメソッドです。
     *
     * @param dtTokubetsuChoshuSeidoCode DT特別徴収制度コード
     */
    public void setDtTokubetsuChoshuSeidoCode(RString dtTokubetsuChoshuSeidoCode) {
        this.dtTokubetsuChoshuSeidoCode = dtTokubetsuChoshuSeidoCode;
    }

    /**
     * DT作成年月日のgetメソッドです。
     *
     * @return DT作成年月日
     */
    @CheckForNull
    public RString getDtSakuseiYMD() {
        return dtSakuseiYMD;
    }

    /**
     * DT作成年月日のsetメソッドです。
     *
     * @param dtSakuseiYMD DT作成年月日
     */
    public void setDtSakuseiYMD(RString dtSakuseiYMD) {
        this.dtSakuseiYMD = dtSakuseiYMD;
    }

    /**
     * DT基礎年金番号のgetメソッドです。
     *
     * @return DT基礎年金番号
     */
    @CheckForNull
    public RString getDtKisoNenkinNo() {
        return dtKisoNenkinNo;
    }

    /**
     * DT基礎年金番号のsetメソッドです。
     *
     * @param dtKisoNenkinNo DT基礎年金番号
     */
    public void setDtKisoNenkinNo(RString dtKisoNenkinNo) {
        this.dtKisoNenkinNo = dtKisoNenkinNo;
    }

    /**
     * DT年金コードのgetメソッドです。
     *
     * @return DT年金コード
     */
    @CheckForNull
    public RString getDtNenkinCode() {
        return dtNenkinCode;
    }

    /**
     * DT年金コードのsetメソッドです。
     *
     * @param dtNenkinCode DT年金コード
     */
    public void setDtNenkinCode(RString dtNenkinCode) {
        this.dtNenkinCode = dtNenkinCode;
    }

    /**
     * DT予備１のgetメソッドです。
     *
     * @return DT予備１
     */
    @CheckForNull
    public RString getDtYobi1() {
        return dtYobi1;
    }

    /**
     * DT予備１のsetメソッドです。
     *
     * @param dtYobi1 DT予備１
     */
    public void setDtYobi1(RString dtYobi1) {
        this.dtYobi1 = dtYobi1;
    }

    /**
     * DT生年月日のgetメソッドです。
     *
     * @return DT生年月日
     */
    @CheckForNull
    public RString getDtBirthDay() {
        return dtBirthDay;
    }

    /**
     * DT生年月日のsetメソッドです。
     *
     * @param dtBirthDay DT生年月日
     */
    public void setDtBirthDay(RString dtBirthDay) {
        this.dtBirthDay = dtBirthDay;
    }

    /**
     * DT性別のgetメソッドです。
     *
     * @return DT性別
     */
    @CheckForNull
    public RString getDtSeibetsu() {
        return dtSeibetsu;
    }

    /**
     * DT性別のsetメソッドです。
     *
     * @param dtSeibetsu DT性別
     */
    public void setDtSeibetsu(RString dtSeibetsu) {
        this.dtSeibetsu = dtSeibetsu;
    }

    /**
     * DTカナ氏名のgetメソッドです。
     *
     * @return DTカナ氏名
     */
    @CheckForNull
    public RString getDtKanaShimei() {
        return dtKanaShimei;
    }

    /**
     * DTカナ氏名のsetメソッドです。
     *
     * @param dtKanaShimei DTカナ氏名
     */
    public void setDtKanaShimei(RString dtKanaShimei) {
        this.dtKanaShimei = dtKanaShimei;
    }

    /**
     * DTシフトコード１のgetメソッドです。
     *
     * @return DTシフトコード１
     */
    @CheckForNull
    public RString getDtShiftCode1() {
        return dtShiftCode1;
    }

    /**
     * DTシフトコード１のsetメソッドです。
     *
     * @param dtShiftCode1 DTシフトコード１
     */
    public void setDtShiftCode1(RString dtShiftCode1) {
        this.dtShiftCode1 = dtShiftCode1;
    }

    /**
     * DT漢字氏名のgetメソッドです。
     *
     * @return DT漢字氏名
     */
    @CheckForNull
    public RString getDtKanjiShimei() {
        return dtKanjiShimei;
    }

    /**
     * DT漢字氏名のsetメソッドです。
     *
     * @param dtKanjiShimei DT漢字氏名
     */
    public void setDtKanjiShimei(RString dtKanjiShimei) {
        this.dtKanjiShimei = dtKanjiShimei;
    }

    /**
     * DTシフトコード２のgetメソッドです。
     *
     * @return DTシフトコード２
     */
    @CheckForNull
    public RString getDtShiftCode2() {
        return dtShiftCode2;
    }

    /**
     * DTシフトコード２のsetメソッドです。
     *
     * @param dtShiftCode2 DTシフトコード２
     */
    public void setDtShiftCode2(RString dtShiftCode2) {
        this.dtShiftCode2 = dtShiftCode2;
    }

    /**
     * DT郵便番号のgetメソッドです。
     *
     * @return DT郵便番号
     */
    @CheckForNull
    public RString getDtYubinNo() {
        return dtYubinNo;
    }

    /**
     * DT郵便番号のsetメソッドです。
     *
     * @param dtYubinNo DT郵便番号
     */
    public void setDtYubinNo(RString dtYubinNo) {
        this.dtYubinNo = dtYubinNo;
    }

    /**
     * DTカナ住所のgetメソッドです。
     *
     * @return DTカナ住所
     */
    @CheckForNull
    public RString getDtKanaJusho() {
        return dtKanaJusho;
    }

    /**
     * DTカナ住所のsetメソッドです。
     *
     * @param dtKanaJusho DTカナ住所
     */
    public void setDtKanaJusho(RString dtKanaJusho) {
        this.dtKanaJusho = dtKanaJusho;
    }

    /**
     * DTシフトコード３のgetメソッドです。
     *
     * @return DTシフトコード３
     */
    @CheckForNull
    public RString getDtShiftCode3() {
        return dtShiftCode3;
    }

    /**
     * DTシフトコード３のsetメソッドです。
     *
     * @param dtShiftCode3 DTシフトコード３
     */
    public void setDtShiftCode3(RString dtShiftCode3) {
        this.dtShiftCode3 = dtShiftCode3;
    }

    /**
     * DT漢字住所のgetメソッドです。
     *
     * @return DT漢字住所
     */
    @CheckForNull
    public RString getDtKanjiJusho() {
        return dtKanjiJusho;
    }

    /**
     * DT漢字住所のsetメソッドです。
     *
     * @param dtKanjiJusho DT漢字住所
     */
    public void setDtKanjiJusho(RString dtKanjiJusho) {
        this.dtKanjiJusho = dtKanjiJusho;
    }

    /**
     * DTシフトコード４のgetメソッドです。
     *
     * @return DTシフトコード４
     */
    @CheckForNull
    public RString getDtShiftCode4() {
        return dtShiftCode4;
    }

    /**
     * DTシフトコード４のsetメソッドです。
     *
     * @param dtShiftCode4 DTシフトコード４
     */
    public void setDtShiftCode4(RString dtShiftCode4) {
        this.dtShiftCode4 = dtShiftCode4;
    }

    /**
     * DT各種区分のgetメソッドです。
     *
     * @return DT各種区分
     */
    @CheckForNull
    public RString getDtKakushuKubun() {
        return dtKakushuKubun;
    }

    /**
     * DT各種区分のsetメソッドです。
     *
     * @param dtKakushuKubun DT各種区分
     */
    public void setDtKakushuKubun(RString dtKakushuKubun) {
        this.dtKakushuKubun = dtKakushuKubun;
    }

    /**
     * DT処理結果のgetメソッドです。
     *
     * @return DT処理結果
     */
    @CheckForNull
    public RString getDtShoriKekka() {
        return dtShoriKekka;
    }

    /**
     * DT処理結果のsetメソッドです。
     *
     * @param dtShoriKekka DT処理結果
     */
    public void setDtShoriKekka(RString dtShoriKekka) {
        this.dtShoriKekka = dtShoriKekka;
    }

    /**
     * DT後期移管コードのgetメソッドです。
     *
     * @return DT後期移管コード
     */
    @CheckForNull
    public RString getDtKokiIkanCode() {
        return dtKokiIkanCode;
    }

    /**
     * DT後期移管コードのsetメソッドです。
     *
     * @param dtKokiIkanCode DT後期移管コード
     */
    public void setDtKokiIkanCode(RString dtKokiIkanCode) {
        this.dtKokiIkanCode = dtKokiIkanCode;
    }

    /**
     * DT各種年月日のgetメソッドです。
     *
     * @return DT各種年月日
     */
    @CheckForNull
    public RString getDtKakushuYMD() {
        return dtKakushuYMD;
    }

    /**
     * DT各種年月日のsetメソッドです。
     *
     * @param dtKakushuYMD DT各種年月日
     */
    public void setDtKakushuYMD(RString dtKakushuYMD) {
        this.dtKakushuYMD = dtKakushuYMD;
    }

    /**
     * DT各種金額欄１のgetメソッドです。
     *
     * @return DT各種金額欄１
     */
    @CheckForNull
    public RString getDtKakushuKingaku1() {
        return dtKakushuKingaku1;
    }

    /**
     * DT各種金額欄１のsetメソッドです。
     *
     * @param dtKakushuKingaku1 DT各種金額欄１
     */
    public void setDtKakushuKingaku1(RString dtKakushuKingaku1) {
        this.dtKakushuKingaku1 = dtKakushuKingaku1;
    }

    /**
     * DT各種金額欄２のgetメソッドです。
     *
     * @return DT各種金額欄２
     */
    @CheckForNull
    public RString getDtKakushuKingaku2() {
        return dtKakushuKingaku2;
    }

    /**
     * DT各種金額欄２のsetメソッドです。
     *
     * @param dtKakushuKingaku2 DT各種金額欄２
     */
    public void setDtKakushuKingaku2(RString dtKakushuKingaku2) {
        this.dtKakushuKingaku2 = dtKakushuKingaku2;
    }

    /**
     * DT各種金額欄３のgetメソッドです。
     *
     * @return DT各種金額欄３
     */
    @CheckForNull
    public RString getDtKakushuKingaku3() {
        return dtKakushuKingaku3;
    }

    /**
     * DT各種金額欄３のsetメソッドです。
     *
     * @param dtKakushuKingaku3 DT各種金額欄３
     */
    public void setDtKakushuKingaku3(RString dtKakushuKingaku3) {
        this.dtKakushuKingaku3 = dtKakushuKingaku3;
    }

    /**
     * DT予備２のgetメソッドです。
     *
     * @return DT予備２
     */
    @CheckForNull
    public RString getDtYobi2() {
        return dtYobi2;
    }

    /**
     * DT予備２のsetメソッドです。
     *
     * @param dtYobi2 DT予備２
     */
    public void setDtYobi2(RString dtYobi2) {
        this.dtYobi2 = dtYobi2;
    }

    /**
     * DT共済年金証書記号番号のgetメソッドです。
     *
     * @return DT共済年金証書記号番号
     */
    @CheckForNull
    public RString getDtKyosaiNenkinshoshoKigoNo() {
        return dtKyosaiNenkinshoshoKigoNo;
    }

    /**
     * DT共済年金証書記号番号のsetメソッドです。
     *
     * @param dtKyosaiNenkinshoshoKigoNo DT共済年金証書記号番号
     */
    public void setDtKyosaiNenkinshoshoKigoNo(RString dtKyosaiNenkinshoshoKigoNo) {
        this.dtKyosaiNenkinshoshoKigoNo = dtKyosaiNenkinshoshoKigoNo;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    @CheckForNull
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    @CheckForNull
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 国保世帯コードのgetメソッドです。
     *
     * @return 国保世帯コード
     */
    @CheckForNull
    public SetaiCode getKokuhoSetaiCode() {
        return kokuhoSetaiCode;
    }

    /**
     * 国保世帯コードのsetメソッドです。
     *
     * @param kokuhoSetaiCode 国保世帯コード
     */
    public void setKokuhoSetaiCode(SetaiCode kokuhoSetaiCode) {
        this.kokuhoSetaiCode = kokuhoSetaiCode;
    }

    /**
     * DT各種金額欄４のgetメソッドです。
     *
     * @return DT各種金額欄４
     */
    @CheckForNull
    public RString getDtKakushuKingaku4() {
        return dtKakushuKingaku4;
    }

    /**
     * DT各種金額欄４のsetメソッドです。
     *
     * @param dtKakushuKingaku4 DT各種金額欄４
     */
    public void setDtKakushuKingaku4(RString dtKakushuKingaku4) {
        this.dtKakushuKingaku4 = dtKakushuKingaku4;
    }

    /**
     * DT各種金額欄５のgetメソッドです。
     *
     * @return DT各種金額欄５
     */
    @CheckForNull
    public RString getDtKakushuKingaku5() {
        return dtKakushuKingaku5;
    }

    /**
     * DT各種金額欄５のsetメソッドです。
     *
     * @param dtKakushuKingaku5 DT各種金額欄５
     */
    public void setDtKakushuKingaku5(RString dtKakushuKingaku5) {
        this.dtKakushuKingaku5 = dtKakushuKingaku5;
    }

    /**
     * DT各種金額欄６のgetメソッドです。
     *
     * @return DT各種金額欄６
     */
    @CheckForNull
    public RString getDtKakushuKingaku6() {
        return dtKakushuKingaku6;
    }

    /**
     * DT各種金額欄６のsetメソッドです。
     *
     * @param dtKakushuKingaku6 DT各種金額欄６
     */
    public void setDtKakushuKingaku6(RString dtKakushuKingaku6) {
        this.dtKakushuKingaku6 = dtKakushuKingaku6;
    }

    /**
     * DT各種金額欄７のgetメソッドです。
     *
     * @return DT各種金額欄７
     */
    @CheckForNull
    public RString getDtKakushuKingaku7() {
        return dtKakushuKingaku7;
    }

    /**
     * DT各種金額欄７のsetメソッドです。
     *
     * @param dtKakushuKingaku7 DT各種金額欄７
     */
    public void setDtKakushuKingaku7(RString dtKakushuKingaku7) {
        this.dtKakushuKingaku7 = dtKakushuKingaku7;
    }

    /**
     * DT各種金額欄８のgetメソッドです。
     *
     * @return DT各種金額欄８
     */
    @CheckForNull
    public RString getDtKakushuKingaku8() {
        return dtKakushuKingaku8;
    }

    /**
     * DT各種金額欄８のsetメソッドです。
     *
     * @param dtKakushuKingaku8 DT各種金額欄８
     */
    public void setDtKakushuKingaku8(RString dtKakushuKingaku8) {
        this.dtKakushuKingaku8 = dtKakushuKingaku8;
    }

    /**
     * DT停止年月のgetメソッドです。
     *
     * @return DT停止年月
     */
    @CheckForNull
    public RString getDtTeishiYM() {
        return dtTeishiYM;
    }

    /**
     * DT停止年月のsetメソッドです。
     *
     * @param dtTeishiYM DT停止年月
     */
    public void setDtTeishiYM(RString dtTeishiYM) {
        this.dtTeishiYM = dtTeishiYM;
    }

    /**
     * DT予備４住民税のgetメソッドです。
     *
     * @return DT予備４住民税
     */
    @CheckForNull
    public RString getDtYobi4Juminzei() {
        return dtYobi4Juminzei;
    }

    /**
     * DT予備４住民税のsetメソッドです。
     *
     * @param dtYobi4Juminzei DT予備４住民税
     */
    public void setDtYobi4Juminzei(RString dtYobi4Juminzei) {
        this.dtYobi4Juminzei = dtYobi4Juminzei;
    }

    /**
     * DT個人番号のgetメソッドです。
     *
     * @return DT個人番号
     */
    @CheckForNull
    public RString getDtKojinNo() {
        return dtKojinNo;
    }

    /**
     * DT個人番号のsetメソッドです。
     *
     * @param dtKojinNo DT個人番号
     */
    public void setDtKojinNo(RString dtKojinNo) {
        this.dtKojinNo = dtKojinNo;
    }

    /**
     * 国保予定喪失区分のgetメソッドです。
     *
     * @return 国保予定喪失区分
     */
    @CheckForNull
    public RString getKokuhoYoteiSoshitsuKubun() {
        return kokuhoYoteiSoshitsuKubun;
    }

    /**
     * 国保予定喪失区分のsetメソッドです。
     *
     * @param kokuhoYoteiSoshitsuKubun 国保予定喪失区分
     */
    public void setKokuhoYoteiSoshitsuKubun(RString kokuhoYoteiSoshitsuKubun) {
        this.kokuhoYoteiSoshitsuKubun = kokuhoYoteiSoshitsuKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal UeT0511NenkinTokuchoKaifuJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal UeT0511NenkinTokuchoKaifuJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(UeT0511NenkinTokuchoKaifuJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.gyomuCode, other.gyomuCode)) {
            return false;
        }
        if (!Objects.equals(this.shoriNendo, other.shoriNendo)) {
            return false;
        }
        if (!Objects.equals(this.tsuchiNaiyoCode, other.tsuchiNaiyoCode)) {
            return false;
        }
        if (!Objects.equals(this.shoriTaishoYM, other.shoriTaishoYM)) {
            return false;
        }
        if (!Objects.equals(this.kisoNenkinNo, other.kisoNenkinNo)) {
            return false;
        }
        if (!Objects.equals(this.nenkinCode, other.nenkinCode)) {
            return false;
        }
        if (!Objects.equals(this.koseiCityCode, other.koseiCityCode)) {
            return false;
        }
        if (this.renban != other.renban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(UeT0511NenkinTokuchoKaifuJohoEntity entity) {
        this.gyomuCode = entity.gyomuCode;
        this.shoriNendo = entity.shoriNendo;
        this.tsuchiNaiyoCode = entity.tsuchiNaiyoCode;
        this.shoriTaishoYM = entity.shoriTaishoYM;
        this.kisoNenkinNo = entity.kisoNenkinNo;
        this.nenkinCode = entity.nenkinCode;
        this.koseiCityCode = entity.koseiCityCode;
        this.renban = entity.renban;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.renkeiShubetsu = entity.renkeiShubetsu;
        this.hosokuTsuki = entity.hosokuTsuki;
        this.tenbikiTsuki = entity.tenbikiTsuki;
        this.dtCityCode = entity.dtCityCode;
        this.dtTokubetsuChoshuGimushaCode = entity.dtTokubetsuChoshuGimushaCode;
        this.dtTsuchiNaiyoCode = entity.dtTsuchiNaiyoCode;
        this.dtBaitaiCode = entity.dtBaitaiCode;
        this.dtTokubetsuChoshuSeidoCode = entity.dtTokubetsuChoshuSeidoCode;
        this.dtSakuseiYMD = entity.dtSakuseiYMD;
        this.dtKisoNenkinNo = entity.dtKisoNenkinNo;
        this.dtNenkinCode = entity.dtNenkinCode;
        this.dtYobi1 = entity.dtYobi1;
        this.dtBirthDay = entity.dtBirthDay;
        this.dtSeibetsu = entity.dtSeibetsu;
        this.dtKanaShimei = entity.dtKanaShimei;
        this.dtShiftCode1 = entity.dtShiftCode1;
        this.dtKanjiShimei = entity.dtKanjiShimei;
        this.dtShiftCode2 = entity.dtShiftCode2;
        this.dtYubinNo = entity.dtYubinNo;
        this.dtKanaJusho = entity.dtKanaJusho;
        this.dtShiftCode3 = entity.dtShiftCode3;
        this.dtKanjiJusho = entity.dtKanjiJusho;
        this.dtShiftCode4 = entity.dtShiftCode4;
        this.dtKakushuKubun = entity.dtKakushuKubun;
        this.dtShoriKekka = entity.dtShoriKekka;
        this.dtKokiIkanCode = entity.dtKokiIkanCode;
        this.dtKakushuYMD = entity.dtKakushuYMD;
        this.dtKakushuKingaku1 = entity.dtKakushuKingaku1;
        this.dtKakushuKingaku2 = entity.dtKakushuKingaku2;
        this.dtKakushuKingaku3 = entity.dtKakushuKingaku3;
        this.dtYobi2 = entity.dtYobi2;
        this.dtKyosaiNenkinshoshoKigoNo = entity.dtKyosaiNenkinshoshoKigoNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kokuhoSetaiCode = entity.kokuhoSetaiCode;
        this.dtKakushuKingaku4 = entity.dtKakushuKingaku4;
        this.dtKakushuKingaku5 = entity.dtKakushuKingaku5;
        this.dtKakushuKingaku6 = entity.dtKakushuKingaku6;
        this.dtKakushuKingaku7 = entity.dtKakushuKingaku7;
        this.dtKakushuKingaku8 = entity.dtKakushuKingaku8;
        this.dtTeishiYM = entity.dtTeishiYM;
        this.dtYobi4Juminzei = entity.dtYobi4Juminzei;
        this.dtKojinNo = entity.dtKojinNo;
        this.kokuhoYoteiSoshitsuKubun = entity.kokuhoYoteiSoshitsuKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(gyomuCode, shoriNendo, tsuchiNaiyoCode, shoriTaishoYM, kisoNenkinNo, nenkinCode, koseiCityCode, renban, shoriTimestamp, renkeiShubetsu, hosokuTsuki, tenbikiTsuki, dtCityCode, dtTokubetsuChoshuGimushaCode, dtTsuchiNaiyoCode, dtBaitaiCode, dtTokubetsuChoshuSeidoCode, dtSakuseiYMD, dtKisoNenkinNo, dtNenkinCode, dtYobi1, dtBirthDay, dtSeibetsu, dtKanaShimei, dtShiftCode1, dtKanjiShimei, dtShiftCode2, dtYubinNo, dtKanaJusho, dtShiftCode3, dtKanjiJusho, dtShiftCode4, dtKakushuKubun, dtShoriKekka, dtKokiIkanCode, dtKakushuYMD, dtKakushuKingaku1, dtKakushuKingaku2, dtKakushuKingaku3, dtYobi2, dtKyosaiNenkinshoshoKigoNo, shikibetsuCode, hihokenshaNo, kokuhoSetaiCode, dtKakushuKingaku4, dtKakushuKingaku5, dtKakushuKingaku6, dtKakushuKingaku7, dtKakushuKingaku8, dtTeishiYM, dtYobi4Juminzei, dtKojinNo, kokuhoYoteiSoshitsuKubun);
    }

// </editor-fold>
}

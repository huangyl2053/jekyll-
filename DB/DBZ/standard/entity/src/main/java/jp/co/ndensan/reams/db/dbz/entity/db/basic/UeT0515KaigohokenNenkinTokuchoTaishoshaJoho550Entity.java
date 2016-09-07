package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgue")
public class UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity
        extends DbTableEntityBase<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity>
        implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME = new RString("UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private int renban;
    @PrimaryKey
    private RString kisoNenkinNo;
    @PrimaryKey
    private RString nenkinCode;
    @PrimaryKey
    private long seq;
    private RDateTime shoriTimestamp;
    private RString dtCityCode;
    private RString dtTokubetsuChoshuGimushaCode;
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
    private RString kaigohokenHihokenshaNo;
    private RString kojinCodeKubun;
    private RString kojinCode;
    private RString kaigohokenJushochitokureiKubun;
    private RString hosokuYMD;
    private RString taikiFlag;
    private RString yobi;

    public RString getInsertDantaiCd() {
        return this.insertDantaiCd;
    }

    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    public int getRenban() {
        return this.renban;
    }

    public void setRenban(@Nonnull int renban) {
        this.renban = renban;
    }

    public RString getKisoNenkinNo() {
        return this.kisoNenkinNo;
    }

    public void setKisoNenkinNo(@Nonnull RString kisoNenkinNo) {
        this.kisoNenkinNo = kisoNenkinNo;
    }

    public RString getNenkinCode() {
        return this.nenkinCode;
    }

    public void setNenkinCode(@Nonnull RString nenkinCode) {
        this.nenkinCode = nenkinCode;
    }

    public long getSeq() {
        return this.seq;
    }

    public void setSeq(@Nonnull long seq) {
        this.seq = seq;
    }

    @CheckForNull
    public RDateTime getShoriTimestamp() {
        return this.shoriTimestamp;
    }

    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    @CheckForNull
    public RString getDtCityCode() {
        return this.dtCityCode;
    }

    public void setDtCityCode(RString dtCityCode) {
        this.dtCityCode = dtCityCode;
    }

    @CheckForNull
    public RString getDtTokubetsuChoshuGimushaCode() {
        return this.dtTokubetsuChoshuGimushaCode;
    }

    public void setDtTokubetsuChoshuGimushaCode(RString dtTokubetsuChoshuGimushaCode) {
        this.dtTokubetsuChoshuGimushaCode = dtTokubetsuChoshuGimushaCode;
    }

    @CheckForNull
    public RString getDtTsuchiNaiyoCode() {
        return this.dtTsuchiNaiyoCode;
    }

    public void setDtTsuchiNaiyoCode(RString dtTsuchiNaiyoCode) {
        this.dtTsuchiNaiyoCode = dtTsuchiNaiyoCode;
    }

    @CheckForNull
    public RString getDtBaitaiCode() {
        return this.dtBaitaiCode;
    }

    public void setDtBaitaiCode(RString dtBaitaiCode) {
        this.dtBaitaiCode = dtBaitaiCode;
    }

    @CheckForNull
    public RString getDtTokubetsuChoshuSeidoCode() {
        return this.dtTokubetsuChoshuSeidoCode;
    }

    public void setDtTokubetsuChoshuSeidoCode(RString dtTokubetsuChoshuSeidoCode) {
        this.dtTokubetsuChoshuSeidoCode = dtTokubetsuChoshuSeidoCode;
    }

    @CheckForNull
    public RString getDtSakuseiYMD() {
        return this.dtSakuseiYMD;
    }

    public void setDtSakuseiYMD(RString dtSakuseiYMD) {
        this.dtSakuseiYMD = dtSakuseiYMD;
    }

    @CheckForNull
    public RString getDtKisoNenkinNo() {
        return this.dtKisoNenkinNo;
    }

    public void setDtKisoNenkinNo(RString dtKisoNenkinNo) {
        this.dtKisoNenkinNo = dtKisoNenkinNo;
    }

    @CheckForNull
    public RString getDtNenkinCode() {
        return this.dtNenkinCode;
    }

    public void setDtNenkinCode(RString dtNenkinCode) {
        this.dtNenkinCode = dtNenkinCode;
    }

    @CheckForNull
    public RString getDtYobi1() {
        return this.dtYobi1;
    }

    public void setDtYobi1(RString dtYobi1) {
        this.dtYobi1 = dtYobi1;
    }

    @CheckForNull
    public RString getDtBirthDay() {
        return this.dtBirthDay;
    }

    public void setDtBirthDay(RString dtBirthDay) {
        this.dtBirthDay = dtBirthDay;
    }

    @CheckForNull
    public RString getDtSeibetsu() {
        return this.dtSeibetsu;
    }

    public void setDtSeibetsu(RString dtSeibetsu) {
        this.dtSeibetsu = dtSeibetsu;
    }

    @CheckForNull
    public RString getDtKanaShimei() {
        return this.dtKanaShimei;
    }

    public void setDtKanaShimei(RString dtKanaShimei) {
        this.dtKanaShimei = dtKanaShimei;
    }

    @CheckForNull
    public RString getDtShiftCode1() {
        return this.dtShiftCode1;
    }

    public void setDtShiftCode1(RString dtShiftCode1) {
        this.dtShiftCode1 = dtShiftCode1;
    }

    @CheckForNull
    public RString getDtKanjiShimei() {
        return this.dtKanjiShimei;
    }

    public void setDtKanjiShimei(RString dtKanjiShimei) {
        this.dtKanjiShimei = dtKanjiShimei;
    }

    @CheckForNull
    public RString getDtShiftCode2() {
        return this.dtShiftCode2;
    }

    public void setDtShiftCode2(RString dtShiftCode2) {
        this.dtShiftCode2 = dtShiftCode2;
    }

    @CheckForNull
    public RString getDtYubinNo() {
        return this.dtYubinNo;
    }

    public void setDtYubinNo(RString dtYubinNo) {
        this.dtYubinNo = dtYubinNo;
    }

    @CheckForNull
    public RString getDtKanaJusho() {
        return this.dtKanaJusho;
    }

    public void setDtKanaJusho(RString dtKanaJusho) {
        this.dtKanaJusho = dtKanaJusho;
    }

    @CheckForNull
    public RString getDtShiftCode3() {
        return this.dtShiftCode3;
    }

    public void setDtShiftCode3(RString dtShiftCode3) {
        this.dtShiftCode3 = dtShiftCode3;
    }

    @CheckForNull
    public RString getDtKanjiJusho() {
        return this.dtKanjiJusho;
    }

    public void setDtKanjiJusho(RString dtKanjiJusho) {
        this.dtKanjiJusho = dtKanjiJusho;
    }

    @CheckForNull
    public RString getDtShiftCode4() {
        return this.dtShiftCode4;
    }

    public void setDtShiftCode4(RString dtShiftCode4) {
        this.dtShiftCode4 = dtShiftCode4;
    }

    @CheckForNull
    public RString getDtKakushuKubun() {
        return this.dtKakushuKubun;
    }

    public void setDtKakushuKubun(RString dtKakushuKubun) {
        this.dtKakushuKubun = dtKakushuKubun;
    }

    @CheckForNull
    public RString getDtShoriKekka() {
        return this.dtShoriKekka;
    }

    public void setDtShoriKekka(RString dtShoriKekka) {
        this.dtShoriKekka = dtShoriKekka;
    }

    @CheckForNull
    public RString getDtKokiIkanCode() {
        return this.dtKokiIkanCode;
    }

    public void setDtKokiIkanCode(RString dtKokiIkanCode) {
        this.dtKokiIkanCode = dtKokiIkanCode;
    }

    @CheckForNull
    public RString getDtKakushuYMD() {
        return this.dtKakushuYMD;
    }

    public void setDtKakushuYMD(RString dtKakushuYMD) {
        this.dtKakushuYMD = dtKakushuYMD;
    }

    @CheckForNull
    public RString getDtKakushuKingaku1() {
        return this.dtKakushuKingaku1;
    }

    public void setDtKakushuKingaku1(RString dtKakushuKingaku1) {
        this.dtKakushuKingaku1 = dtKakushuKingaku1;
    }

    @CheckForNull
    public RString getDtKakushuKingaku2() {
        return this.dtKakushuKingaku2;
    }

    public void setDtKakushuKingaku2(RString dtKakushuKingaku2) {
        this.dtKakushuKingaku2 = dtKakushuKingaku2;
    }

    @CheckForNull
    public RString getDtKakushuKingaku3() {
        return this.dtKakushuKingaku3;
    }

    public void setDtKakushuKingaku3(RString dtKakushuKingaku3) {
        this.dtKakushuKingaku3 = dtKakushuKingaku3;
    }

    @CheckForNull
    public RString getDtYobi2() {
        return this.dtYobi2;
    }

    public void setDtYobi2(RString dtYobi2) {
        this.dtYobi2 = dtYobi2;
    }

    @CheckForNull
    public RString getDtKyosaiNenkinshoshoKigoNo() {
        return this.dtKyosaiNenkinshoshoKigoNo;
    }

    public void setDtKyosaiNenkinshoshoKigoNo(RString dtKyosaiNenkinshoshoKigoNo) {
        this.dtKyosaiNenkinshoshoKigoNo = dtKyosaiNenkinshoshoKigoNo;
    }

    @CheckForNull
    public RString getKaigohokenHihokenshaNo() {
        return this.kaigohokenHihokenshaNo;
    }

    public void setKaigohokenHihokenshaNo(RString kaigohokenHihokenshaNo) {
        this.kaigohokenHihokenshaNo = kaigohokenHihokenshaNo;
    }

    @CheckForNull
    public RString getKojinCodeKubun() {
        return this.kojinCodeKubun;
    }

    public void setKojinCodeKubun(RString kojinCodeKubun) {
        this.kojinCodeKubun = kojinCodeKubun;
    }

    @CheckForNull
    public RString getKojinCode() {
        return this.kojinCode;
    }

    public void setKojinCode(RString kojinCode) {
        this.kojinCode = kojinCode;
    }

    @CheckForNull
    public RString getKaigohokenJushochitokureiKubun() {
        return this.kaigohokenJushochitokureiKubun;
    }

    public void setKaigohokenJushochitokureiKubun(RString kaigohokenJushochitokureiKubun) {
        this.kaigohokenJushochitokureiKubun = kaigohokenJushochitokureiKubun;
    }

    @CheckForNull
    public RString getHosokuYMD() {
        return this.hosokuYMD;
    }

    public void setHosokuYMD(RString hosokuYMD) {
        this.hosokuYMD = hosokuYMD;
    }

    @CheckForNull
    public RString getTaikiFlag() {
        return this.taikiFlag;
    }

    public void setTaikiFlag(RString taikiFlag) {
        this.taikiFlag = taikiFlag;
    }

    @CheckForNull
    public RString getYobi() {
        return this.yobi;
    }

    public void setYobi(RString yobi) {
        this.yobi = yobi;
    }

    @Override
    public boolean equalsPrimaryKeys(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity other) {
        if (other == null) {
            return false;
        }
        if (this.renban != other.renban) {
            return false;
        }
        if (!Objects.equals(this.kisoNenkinNo, other.kisoNenkinNo)) {
            return false;
        }
        if (!Objects.equals(this.nenkinCode, other.nenkinCode)) {
            return false;
        }
        return this.seq == other.seq;
    }

    public void shallowCopy(UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity entity) {
        this.renban = entity.renban;
        this.kisoNenkinNo = entity.kisoNenkinNo;
        this.nenkinCode = entity.nenkinCode;
        this.seq = entity.seq;
        this.shoriTimestamp = entity.shoriTimestamp;
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
        this.kaigohokenHihokenshaNo = entity.kaigohokenHihokenshaNo;
        this.kojinCodeKubun = entity.kojinCodeKubun;
        this.kojinCode = entity.kojinCode;
        this.kaigohokenJushochitokureiKubun = entity.kaigohokenJushochitokureiKubun;
        this.hosokuYMD = entity.hosokuYMD;
        this.taikiFlag = entity.taikiFlag;
        this.yobi = entity.yobi;
    }

    @Override
    public RString getMd5() {
        return super.toMd5(new Object[]{Integer.valueOf(this.renban), this.kisoNenkinNo, this.nenkinCode, Long.valueOf(this.seq), this.shoriTimestamp, this.dtCityCode, this.dtTokubetsuChoshuGimushaCode, this.dtTsuchiNaiyoCode, this.dtBaitaiCode, this.dtTokubetsuChoshuSeidoCode, this.dtSakuseiYMD, this.dtKisoNenkinNo, this.dtNenkinCode, this.dtYobi1, this.dtBirthDay, this.dtSeibetsu, this.dtKanaShimei, this.dtShiftCode1, this.dtKanjiShimei, this.dtShiftCode2, this.dtYubinNo, this.dtKanaJusho, this.dtShiftCode3, this.dtKanjiJusho, this.dtShiftCode4, this.dtKakushuKubun, this.dtShoriKekka, this.dtKokiIkanCode, this.dtKakushuYMD, this.dtKakushuKingaku1, this.dtKakushuKingaku2, this.dtKakushuKingaku3, this.dtYobi2, this.dtKyosaiNenkinshoshoKigoNo, this.kaigohokenHihokenshaNo, this.kojinCodeKubun, this.kojinCode, this.kaigohokenJushochitokureiKubun, this.hosokuYMD, this.taikiFlag, this.yobi});
    }
}

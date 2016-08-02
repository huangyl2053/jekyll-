package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 介護保険負担限度額認定テーブルのエンティティクラスです。
 */
public class DbT4018KaigoHokenFutanGendogakuNinteiEntity extends DbTableEntityBase<DbT4018KaigoHokenFutanGendogakuNinteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4018KaigoHokenFutanGendogakuNintei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString ketteiKubun;
    private RString hiShoninRiyu;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    private RString kyusochishaKubun;
    private RString shinseiRiyuKubun;
    private RString riyoshaFutanDankai;
    private boolean kyokaisoGaitoshaKubun;
    private boolean gekihenKanwaSochiTaishoshaKubun;
    private RString kyoshitsuShubetsu;
    private Decimal shokuhiFutanGendogaku;
    private Decimal unitTypeKoshitsu;
    private Decimal unitTypeJunKoshitsu;
    private Decimal juraiTypeKoshitsu_Tokuyo;
    private Decimal juraiTypeKoshitsu_Roken_Ryoyo;
    private Decimal tashoshitsu;
    private boolean haigushaUmuFlag;
    private AtenaMeisho haigushaShimei;
    private AtenaKanaMeisho haigushaShimeiKana;
    private FlexibleDate haigushaSeinenGappiYMD;
    private AtenaJusho haigushaJusho;
    private RString haigushaRenrakusaki;
    private AtenaJusho haigushaJusho2;
    private RString haigushaKazeiKubun;
    private ShikibetsuCode haigushaShikibetsuCd;
    private RString yochokinShinkokuKubun;
    private Decimal yochokinGaku;
    private Decimal yukashoukenGaisangaku;
    private Decimal sonotaKingaku;
    private YMDHMS ninteiBatchExecutedTimestamp;
    private boolean izokuNenkinJukyuFlag;
    private boolean shogaiNenkinJukyuFlag;

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
     * shinseiYMDのgetメソッドです。
     * 
     * @return shinseiYMD
     */
    @CheckForNull
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * shinseiYMDのsetメソッドです。
     * 
     * @param shinseiYMD shinseiYMD
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * ketteiYMDのgetメソッドです。
     * 
     * @return ketteiYMD
     */
    @CheckForNull
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * ketteiYMDのsetメソッドです。
     * 
     * @param ketteiYMD ketteiYMD
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * tekiyoKaishiYMDのgetメソッドです。
     * 
     * @return tekiyoKaishiYMD
     */
    @CheckForNull
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * tekiyoKaishiYMDのsetメソッドです。
     * 
     * @param tekiyoKaishiYMD tekiyoKaishiYMD
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * tekiyoShuryoYMDのgetメソッドです。
     * 
     * @return tekiyoShuryoYMD
     */
    @CheckForNull
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * tekiyoShuryoYMDのsetメソッドです。
     * 
     * @param tekiyoShuryoYMD tekiyoShuryoYMD
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * ketteiKubunのgetメソッドです。
     * 
     * @return ketteiKubun
     */
    @CheckForNull
    public RString getKetteiKubun() {
        return ketteiKubun;
    }

    /**
     * ketteiKubunのsetメソッドです。
     * 
     * @param ketteiKubun ketteiKubun
     */
    public void setKetteiKubun(RString ketteiKubun) {
        this.ketteiKubun = ketteiKubun;
    }

    /**
     * hiShoninRiyuのgetメソッドです。
     * 
     * @return hiShoninRiyu
     */
    @CheckForNull
    public RString getHiShoninRiyu() {
        return hiShoninRiyu;
    }

    /**
     * hiShoninRiyuのsetメソッドです。
     * 
     * @param hiShoninRiyu hiShoninRiyu
     */
    public void setHiShoninRiyu(RString hiShoninRiyu) {
        this.hiShoninRiyu = hiShoninRiyu;
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
     * 履歴番号のgetメソッドです。
     * <br/>
     * <br/>新規履歴：0, 以降の申請・決定：最大履歴番号+1
     * 
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * <br/>
     * <br/>新規履歴：0, 以降の申請・決定：最大履歴番号+1
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 旧措置者区分のgetメソッドです。
     * <br/>
     * <br/>DBDEnum.旧措置区分

     * <br/>"":空白

     * <br/> 1:旧措置者

     * <br/> 2:旧措置者実質的負担軽減者
     * 
     * @return 旧措置者区分
     */
    @CheckForNull
    public RString getKyusochishaKubun() {
        return kyusochishaKubun;
    }

    /**
     * 旧措置者区分のsetメソッドです。
     * <br/>
     * <br/>DBDEnum.旧措置区分

     * <br/>"":空白

     * <br/> 1:旧措置者

     * <br/> 2:旧措置者実質的負担軽減者
     * 
     * @param kyusochishaKubun 旧措置者区分
     */
    public void setKyusochishaKubun(RString kyusochishaKubun) {
        this.kyusochishaKubun = kyusochishaKubun;
    }

    /**
     * 申請理由区分のgetメソッドです。
     * <br/>
     * <br/>DBDEnum.申請理由区分 

     * <br/>01:世帯非課税８０万以下 

     * <br/>02:世帯非課税８０万超 　

     * <br/>03:生保 

     * <br/>04:世帯非課税 

     * <br/>05:老齢 

     * <br/>06:特例減額措置 

     * <br/>99:その他
     * 
     * @return 申請理由区分
     */
    @CheckForNull
    public RString getShinseiRiyuKubun() {
        return shinseiRiyuKubun;
    }

    /**
     * 申請理由区分のsetメソッドです。
     * <br/>
     * <br/>DBDEnum.申請理由区分 

     * <br/>01:世帯非課税８０万以下 

     * <br/>02:世帯非課税８０万超 　

     * <br/>03:生保 

     * <br/>04:世帯非課税 

     * <br/>05:老齢 

     * <br/>06:特例減額措置 

     * <br/>99:その他
     * 
     * @param shinseiRiyuKubun 申請理由区分
     */
    public void setShinseiRiyuKubun(RString shinseiRiyuKubun) {
        this.shinseiRiyuKubun = shinseiRiyuKubun;
    }

    /**
     * 利用者負担段階のgetメソッドです。
     * <br/>
     * <br/>DBDEnum.利用者負担段階

     * <br/>1:第一段階

     * <br/>2:第二段階

     * <br/>3:第三段階

     * <br/>4:課税層第三段階
     * 
     * @return 利用者負担段階
     */
    @CheckForNull
    public RString getRiyoshaFutanDankai() {
        return riyoshaFutanDankai;
    }

    /**
     * 利用者負担段階のsetメソッドです。
     * <br/>
     * <br/>DBDEnum.利用者負担段階

     * <br/>1:第一段階

     * <br/>2:第二段階

     * <br/>3:第三段階

     * <br/>4:課税層第三段階
     * 
     * @param riyoshaFutanDankai 利用者負担段階
     */
    public void setRiyoshaFutanDankai(RString riyoshaFutanDankai) {
        this.riyoshaFutanDankai = riyoshaFutanDankai;
    }

    /**
     * 境界層該当者区分のgetメソッドです。
     * <br/>
     * <br/>trueの場合、境界層該当者
     * 
     * @return 境界層該当者区分
     */
    @CheckForNull
    public boolean getKyokaisoGaitoshaKubun() {
        return kyokaisoGaitoshaKubun;
    }

    /**
     * 境界層該当者区分のsetメソッドです。
     * <br/>
     * <br/>trueの場合、境界層該当者
     * 
     * @param kyokaisoGaitoshaKubun 境界層該当者区分
     */
    public void setKyokaisoGaitoshaKubun(boolean kyokaisoGaitoshaKubun) {
        this.kyokaisoGaitoshaKubun = kyokaisoGaitoshaKubun;
    }

    /**
     * 激変緩和措置対象者区分のgetメソッドです。
     * <br/>
     * <br/>trueの場合、激変緩和対象者
     * 
     * @return 激変緩和措置対象者区分
     */
    @CheckForNull
    public boolean getGekihenKanwaSochiTaishoshaKubun() {
        return gekihenKanwaSochiTaishoshaKubun;
    }

    /**
     * 激変緩和措置対象者区分のsetメソッドです。
     * <br/>
     * <br/>trueの場合、激変緩和対象者
     * 
     * @param gekihenKanwaSochiTaishoshaKubun 激変緩和措置対象者区分
     */
    public void setGekihenKanwaSochiTaishoshaKubun(boolean gekihenKanwaSochiTaishoshaKubun) {
        this.gekihenKanwaSochiTaishoshaKubun = gekihenKanwaSochiTaishoshaKubun;
    }

    /**
     * 居室種別のgetメソッドです。
     * <br/>
     * <br/>DBDEnum.居室種別

     * <br/>1：ユニット型個室

     * <br/>2：ユニット型準個室

     * <br/>3：従来型個室

     * <br/>4：多床室

     * <br/>5：従来型個室（老健）
     * 
     * @return 居室種別
     */
    @CheckForNull
    public RString getKyoshitsuShubetsu() {
        return kyoshitsuShubetsu;
    }

    /**
     * 居室種別のsetメソッドです。
     * <br/>
     * <br/>DBDEnum.居室種別

     * <br/>1：ユニット型個室

     * <br/>2：ユニット型準個室

     * <br/>3：従来型個室

     * <br/>4：多床室

     * <br/>5：従来型個室（老健）
     * 
     * @param kyoshitsuShubetsu 居室種別
     */
    public void setKyoshitsuShubetsu(RString kyoshitsuShubetsu) {
        this.kyoshitsuShubetsu = kyoshitsuShubetsu;
    }

    /**
     * 食費負担限度額のgetメソッドです。
     * 
     * @return 食費負担限度額
     */
    @CheckForNull
    public Decimal getShokuhiFutanGendogaku() {
        return shokuhiFutanGendogaku;
    }

    /**
     * 食費負担限度額のsetメソッドです。
     * 
     * @param shokuhiFutanGendogaku 食費負担限度額
     */
    public void setShokuhiFutanGendogaku(Decimal shokuhiFutanGendogaku) {
        this.shokuhiFutanGendogaku = shokuhiFutanGendogaku;
    }

    /**
     * ユニット型個室のgetメソッドです。
     * 
     * @return ユニット型個室
     */
    @CheckForNull
    public Decimal getUnitTypeKoshitsu() {
        return unitTypeKoshitsu;
    }

    /**
     * ユニット型個室のsetメソッドです。
     * 
     * @param unitTypeKoshitsu ユニット型個室
     */
    public void setUnitTypeKoshitsu(Decimal unitTypeKoshitsu) {
        this.unitTypeKoshitsu = unitTypeKoshitsu;
    }

    /**
     * ユニット型準個室のgetメソッドです。
     * 
     * @return ユニット型準個室
     */
    @CheckForNull
    public Decimal getUnitTypeJunKoshitsu() {
        return unitTypeJunKoshitsu;
    }

    /**
     * ユニット型準個室のsetメソッドです。
     * 
     * @param unitTypeJunKoshitsu ユニット型準個室
     */
    public void setUnitTypeJunKoshitsu(Decimal unitTypeJunKoshitsu) {
        this.unitTypeJunKoshitsu = unitTypeJunKoshitsu;
    }

    /**
     * 従来型個室（特養等）のgetメソッドです。
     * 
     * @return 従来型個室（特養等）
     */
    @CheckForNull
    public Decimal getJuraiTypeKoshitsu_Tokuyo() {
        return juraiTypeKoshitsu_Tokuyo;
    }

    /**
     * 従来型個室（特養等）のsetメソッドです。
     * 
     * @param juraiTypeKoshitsu_Tokuyo 従来型個室（特養等）
     */
    public void setJuraiTypeKoshitsu_Tokuyo(Decimal juraiTypeKoshitsu_Tokuyo) {
        this.juraiTypeKoshitsu_Tokuyo = juraiTypeKoshitsu_Tokuyo;
    }

    /**
     * 従来型個室（老健・療養等）のgetメソッドです。
     * 
     * @return 従来型個室（老健・療養等）
     */
    @CheckForNull
    public Decimal getJuraiTypeKoshitsu_Roken_Ryoyo() {
        return juraiTypeKoshitsu_Roken_Ryoyo;
    }

    /**
     * 従来型個室（老健・療養等）のsetメソッドです。
     * 
     * @param juraiTypeKoshitsu_Roken_Ryoyo 従来型個室（老健・療養等）
     */
    public void setJuraiTypeKoshitsu_Roken_Ryoyo(Decimal juraiTypeKoshitsu_Roken_Ryoyo) {
        this.juraiTypeKoshitsu_Roken_Ryoyo = juraiTypeKoshitsu_Roken_Ryoyo;
    }

    /**
     * 多床室のgetメソッドです。
     * 
     * @return 多床室
     */
    @CheckForNull
    public Decimal getTashoshitsu() {
        return tashoshitsu;
    }

    /**
     * 多床室のsetメソッドです。
     * 
     * @param tashoshitsu 多床室
     */
    public void setTashoshitsu(Decimal tashoshitsu) {
        this.tashoshitsu = tashoshitsu;
    }

    /**
     * 配偶者の有無のgetメソッドです。
     * <br/>
     * <br/>trueの場合、配偶者あり。
     * 
     * @return 配偶者の有無
     */
    @CheckForNull
    public boolean getHaigushaUmuFlag() {
        return haigushaUmuFlag;
    }

    /**
     * 配偶者の有無のsetメソッドです。
     * <br/>
     * <br/>trueの場合、配偶者あり。
     * 
     * @param haigushaUmuFlag 配偶者の有無
     */
    public void setHaigushaUmuFlag(boolean haigushaUmuFlag) {
        this.haigushaUmuFlag = haigushaUmuFlag;
    }

    /**
     * 配偶者氏名のgetメソッドです。
     * 
     * @return 配偶者氏名
     */
    @CheckForNull
    public AtenaMeisho getHaigushaShimei() {
        return haigushaShimei;
    }

    /**
     * 配偶者氏名のsetメソッドです。
     * 
     * @param haigushaShimei 配偶者氏名
     */
    public void setHaigushaShimei(AtenaMeisho haigushaShimei) {
        this.haigushaShimei = haigushaShimei;
    }

    /**
     * 配偶者氏名カナのgetメソッドです。
     * 
     * @return 配偶者氏名カナ
     */
    @CheckForNull
    public AtenaKanaMeisho getHaigushaShimeiKana() {
        return haigushaShimeiKana;
    }

    /**
     * 配偶者氏名カナのsetメソッドです。
     * 
     * @param haigushaShimeiKana 配偶者氏名カナ
     */
    public void setHaigushaShimeiKana(AtenaKanaMeisho haigushaShimeiKana) {
        this.haigushaShimeiKana = haigushaShimeiKana;
    }

    /**
     * 配偶者生年月日のgetメソッドです。
     * 
     * @return 配偶者生年月日
     */
    @CheckForNull
    public FlexibleDate getHaigushaSeinenGappiYMD() {
        return haigushaSeinenGappiYMD;
    }

    /**
     * 配偶者生年月日のsetメソッドです。
     * 
     * @param haigushaSeinenGappiYMD 配偶者生年月日
     */
    public void setHaigushaSeinenGappiYMD(FlexibleDate haigushaSeinenGappiYMD) {
        this.haigushaSeinenGappiYMD = haigushaSeinenGappiYMD;
    }

    /**
     * 配偶者住所のgetメソッドです。
     * 
     * @return 配偶者住所
     */
    @CheckForNull
    public AtenaJusho getHaigushaJusho() {
        return haigushaJusho;
    }

    /**
     * 配偶者住所のsetメソッドです。
     * 
     * @param haigushaJusho 配偶者住所
     */
    public void setHaigushaJusho(AtenaJusho haigushaJusho) {
        this.haigushaJusho = haigushaJusho;
    }

    /**
     * 配偶者連絡先のgetメソッドです。
     * 
     * @return 配偶者連絡先
     */
    @CheckForNull
    public RString getHaigushaRenrakusaki() {
        return haigushaRenrakusaki;
    }

    /**
     * 配偶者連絡先のsetメソッドです。
     * 
     * @param haigushaRenrakusaki 配偶者連絡先
     */
    public void setHaigushaRenrakusaki(RString haigushaRenrakusaki) {
        this.haigushaRenrakusaki = haigushaRenrakusaki;
    }

    /**
     * 配偶者住所２のgetメソッドです。
     * <br/>
     * <br/>1月1日時点の住所
     * 
     * @return 配偶者住所２
     */
    @CheckForNull
    public AtenaJusho getHaigushaJusho2() {
        return haigushaJusho2;
    }

    /**
     * 配偶者住所２のsetメソッドです。
     * <br/>
     * <br/>1月1日時点の住所
     * 
     * @param haigushaJusho2 配偶者住所２
     */
    public void setHaigushaJusho2(AtenaJusho haigushaJusho2) {
        this.haigushaJusho2 = haigushaJusho2;
    }

    /**
     * 配偶者課税区分のgetメソッドです。
     * <br/>
     * <br/>1:課税、2:非課税
     * 
     * @return 配偶者課税区分
     */
    @CheckForNull
    public RString getHaigushaKazeiKubun() {
        return haigushaKazeiKubun;
    }

    /**
     * 配偶者課税区分のsetメソッドです。
     * <br/>
     * <br/>1:課税、2:非課税
     * 
     * @param haigushaKazeiKubun 配偶者課税区分
     */
    public void setHaigushaKazeiKubun(RString haigushaKazeiKubun) {
        this.haigushaKazeiKubun = haigushaKazeiKubun;
    }

    /**
     * 配偶者識別コードのgetメソッドです。
     * 
     * @return 配偶者識別コード
     */
    @CheckForNull
    public ShikibetsuCode getHaigushaShikibetsuCd() {
        return haigushaShikibetsuCd;
    }

    /**
     * 配偶者識別コードのsetメソッドです。
     * 
     * @param haigushaShikibetsuCd 配偶者識別コード
     */
    public void setHaigushaShikibetsuCd(ShikibetsuCode haigushaShikibetsuCd) {
        this.haigushaShikibetsuCd = haigushaShikibetsuCd;
    }

    /**
     * 預貯金申告区分のgetメソッドです。
     * <br/>
     * <br/>預貯金、有価証券等の金額の合計が1000万円（夫婦は2000万円）かどうかの区分。

     * <br/>DBDEnum.預貯金申告区分

     * <br/>0:超過

     * <br/>1:以下
     * 
     * @return 預貯金申告区分
     */
    @CheckForNull
    public RString getYochokinShinkokuKubun() {
        return yochokinShinkokuKubun;
    }

    /**
     * 預貯金申告区分のsetメソッドです。
     * <br/>
     * <br/>預貯金、有価証券等の金額の合計が1000万円（夫婦は2000万円）かどうかの区分。

     * <br/>DBDEnum.預貯金申告区分

     * <br/>0:超過

     * <br/>1:以下
     * 
     * @param yochokinShinkokuKubun 預貯金申告区分
     */
    public void setYochokinShinkokuKubun(RString yochokinShinkokuKubun) {
        this.yochokinShinkokuKubun = yochokinShinkokuKubun;
    }

    /**
     * 預貯金額のgetメソッドです。
     * 
     * @return 預貯金額
     */
    @CheckForNull
    public Decimal getYochokinGaku() {
        return yochokinGaku;
    }

    /**
     * 預貯金額のsetメソッドです。
     * 
     * @param yochokinGaku 預貯金額
     */
    public void setYochokinGaku(Decimal yochokinGaku) {
        this.yochokinGaku = yochokinGaku;
    }

    /**
     * 有価証券評価概算額のgetメソッドです。
     * 
     * @return 有価証券評価概算額
     */
    @CheckForNull
    public Decimal getYukashoukenGaisangaku() {
        return yukashoukenGaisangaku;
    }

    /**
     * 有価証券評価概算額のsetメソッドです。
     * 
     * @param yukashoukenGaisangaku 有価証券評価概算額
     */
    public void setYukashoukenGaisangaku(Decimal yukashoukenGaisangaku) {
        this.yukashoukenGaisangaku = yukashoukenGaisangaku;
    }

    /**
     * その他金額のgetメソッドです。
     * 
     * @return その他金額
     */
    @CheckForNull
    public Decimal getSonotaKingaku() {
        return sonotaKingaku;
    }

    /**
     * その他金額のsetメソッドです。
     * 
     * @param sonotaKingaku その他金額
     */
    public void setSonotaKingaku(Decimal sonotaKingaku) {
        this.sonotaKingaku = sonotaKingaku;
    }

    /**
     * 一括認定バッチ処理日時のgetメソッドです。
     * <br/>
     * <br/>バッチによる一括認定時に、バッチの処理日時を設定
     * 
     * @return 一括認定バッチ処理日時
     */
    @CheckForNull
    public YMDHMS getNinteiBatchExecutedTimestamp() {
        return ninteiBatchExecutedTimestamp;
    }

    /**
     * 一括認定バッチ処理日時のsetメソッドです。
     * <br/>
     * <br/>バッチによる一括認定時に、バッチの処理日時を設定
     * 
     * @param ninteiBatchExecutedTimestamp 一括認定バッチ処理日時
     */
    public void setNinteiBatchExecutedTimestamp(YMDHMS ninteiBatchExecutedTimestamp) {
        this.ninteiBatchExecutedTimestamp = ninteiBatchExecutedTimestamp;
    }

    /**
     * 遺族年金受給フラグのgetメソッドです。
     * <br/>
     * <br/>tureの場合、申告有り。
     * 
     * @return 遺族年金受給フラグ
     */
    @CheckForNull
    public boolean getIzokuNenkinJukyuFlag() {
        return izokuNenkinJukyuFlag;
    }

    /**
     * 遺族年金受給フラグのsetメソッドです。
     * <br/>
     * <br/>tureの場合、申告有り。
     * 
     * @param izokuNenkinJukyuFlag 遺族年金受給フラグ
     */
    public void setIzokuNenkinJukyuFlag(boolean izokuNenkinJukyuFlag) {
        this.izokuNenkinJukyuFlag = izokuNenkinJukyuFlag;
    }

    /**
     * 障害年金受給フラグのgetメソッドです。
     * <br/>
     * <br/>tureの場合、申告有り。
     * 
     * @return 障害年金受給フラグ
     */
    @CheckForNull
    public boolean getShogaiNenkinJukyuFlag() {
        return shogaiNenkinJukyuFlag;
    }

    /**
     * 障害年金受給フラグのsetメソッドです。
     * <br/>
     * <br/>tureの場合、申告有り。
     * 
     * @param shogaiNenkinJukyuFlag 障害年金受給フラグ
     */
    public void setShogaiNenkinJukyuFlag(boolean shogaiNenkinJukyuFlag) {
        this.shogaiNenkinJukyuFlag = shogaiNenkinJukyuFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4018KaigoHokenFutanGendogakuNinteiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4018KaigoHokenFutanGendogakuNinteiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4018KaigoHokenFutanGendogakuNinteiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT4018KaigoHokenFutanGendogakuNinteiEntity entity) {
        this.shinseiYMD = entity.shinseiYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.ketteiKubun = entity.ketteiKubun;
        this.hiShoninRiyu = entity.hiShoninRiyu;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.kyusochishaKubun = entity.kyusochishaKubun;
        this.shinseiRiyuKubun = entity.shinseiRiyuKubun;
        this.riyoshaFutanDankai = entity.riyoshaFutanDankai;
        this.kyokaisoGaitoshaKubun = entity.kyokaisoGaitoshaKubun;
        this.gekihenKanwaSochiTaishoshaKubun = entity.gekihenKanwaSochiTaishoshaKubun;
        this.kyoshitsuShubetsu = entity.kyoshitsuShubetsu;
        this.shokuhiFutanGendogaku = entity.shokuhiFutanGendogaku;
        this.unitTypeKoshitsu = entity.unitTypeKoshitsu;
        this.unitTypeJunKoshitsu = entity.unitTypeJunKoshitsu;
        this.juraiTypeKoshitsu_Tokuyo = entity.juraiTypeKoshitsu_Tokuyo;
        this.juraiTypeKoshitsu_Roken_Ryoyo = entity.juraiTypeKoshitsu_Roken_Ryoyo;
        this.tashoshitsu = entity.tashoshitsu;
        this.haigushaUmuFlag = entity.haigushaUmuFlag;
        this.haigushaShimei = entity.haigushaShimei;
        this.haigushaShimeiKana = entity.haigushaShimeiKana;
        this.haigushaSeinenGappiYMD = entity.haigushaSeinenGappiYMD;
        this.haigushaJusho = entity.haigushaJusho;
        this.haigushaRenrakusaki = entity.haigushaRenrakusaki;
        this.haigushaJusho2 = entity.haigushaJusho2;
        this.haigushaKazeiKubun = entity.haigushaKazeiKubun;
        this.haigushaShikibetsuCd = entity.haigushaShikibetsuCd;
        this.yochokinShinkokuKubun = entity.yochokinShinkokuKubun;
        this.yochokinGaku = entity.yochokinGaku;
        this.yukashoukenGaisangaku = entity.yukashoukenGaisangaku;
        this.sonotaKingaku = entity.sonotaKingaku;
        this.ninteiBatchExecutedTimestamp = entity.ninteiBatchExecutedTimestamp;
        this.izokuNenkinJukyuFlag = entity.izokuNenkinJukyuFlag;
        this.shogaiNenkinJukyuFlag = entity.shogaiNenkinJukyuFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseiYMD, ketteiYMD, tekiyoKaishiYMD, tekiyoShuryoYMD, ketteiKubun, hiShoninRiyu, shoKisaiHokenshaNo, hihokenshaNo, rirekiNo, kyusochishaKubun, shinseiRiyuKubun, riyoshaFutanDankai, kyokaisoGaitoshaKubun, gekihenKanwaSochiTaishoshaKubun, kyoshitsuShubetsu, shokuhiFutanGendogaku, unitTypeKoshitsu, unitTypeJunKoshitsu, juraiTypeKoshitsu_Tokuyo, juraiTypeKoshitsu_Roken_Ryoyo, tashoshitsu, haigushaUmuFlag, haigushaShimei, haigushaShimeiKana, haigushaSeinenGappiYMD, haigushaJusho, haigushaRenrakusaki, haigushaJusho2, haigushaKazeiKubun, haigushaShikibetsuCd, yochokinShinkokuKubun, yochokinGaku, yukashoukenGaisangaku, sonotaKingaku, ninteiBatchExecutedTimestamp, izokuNenkinJukyuFlag, shogaiNenkinJukyuFlag);
    }

// </editor-fold>



}

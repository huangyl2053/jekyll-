package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 特定標準負担額減額テーブルのエンティティクラスです。
 */
public class DbT4013TokuteiHyojunFutangakuGengakuEntity extends DbTableEntityBase<DbT4013TokuteiHyojunFutangakuGengakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4013TokuteiHyojunFutangakuGengaku");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    private RString shinseiJiyu;
    private RString riyoshaFutanDankai;
    private RString hyojunFutanKubun;
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
    private int yochokinGaku;
    private int yukashoukenGaisangaku;
    private int sonotaKingaku;

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
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
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
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 申請事由のgetメソッドです。
     *
     * @return 申請事由
     */
    public RString getShinseiJiyu() {
        return shinseiJiyu;
    }

    /**
     * 申請事由のsetメソッドです。
     *
     * @param shinseiJiyu 申請事由
     */
    public void setShinseiJiyu(RString shinseiJiyu) {
        this.shinseiJiyu = shinseiJiyu;
    }

    /**
     * 利用者負担段階のgetメソッドです。
     * <br/>
     * <br/>・第一段階
     *
     * <br/>・第二段階
     *
     * <br/>・第三段階
     *
     * <br/>・課税層第三段階
     *
     * @return 利用者負担段階
     */
    public RString getRiyoshaFutanDankai() {
        return riyoshaFutanDankai;
    }

    /**
     * 利用者負担段階のsetメソッドです。
     * <br/>
     * <br/>・第一段階
     *
     * <br/>・第二段階
     *
     * <br/>・第三段階
     *
     * <br/>・課税層第三段階
     *
     * @param riyoshaFutanDankai 利用者負担段階
     */
    public void setRiyoshaFutanDankai(RString riyoshaFutanDankai) {
        this.riyoshaFutanDankai = riyoshaFutanDankai;
    }

    /**
     * 標準負担区分のgetメソッドです。
     * <br/>
     * <br/>1:標準負担      *
     * <br/>2:特定標準負担
     *
     * @return 標準負担区分
     */
    public RString getHyojunFutanKubun() {
        return hyojunFutanKubun;
    }

    /**
     * 標準負担区分のsetメソッドです。
     * <br/>
     * <br/>1:標準負担      *
     * <br/>2:特定標準負担
     *
     * @param hyojunFutanKubun 標準負担区分
     */
    public void setHyojunFutanKubun(RString hyojunFutanKubun) {
        this.hyojunFutanKubun = hyojunFutanKubun;
    }

    /**
     * 居室種別のgetメソッドです。
     * <br/>
     * <br/>1：ユニット型個室
     *
     * <br/>2：ユニット型準個室
     *
     * <br/>3：従来型個室
     *
     * <br/>4：多床室
     *
     * <br/>5：従来型個室（老健）
     *
     * @return 居室種別
     */
    public RString getKyoshitsuShubetsu() {
        return kyoshitsuShubetsu;
    }

    /**
     * 居室種別のsetメソッドです。
     * <br/>
     * <br/>1：ユニット型個室
     *
     * <br/>2：ユニット型準個室
     *
     * <br/>3：従来型個室
     *
     * <br/>4：多床室
     *
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
     * 配偶者有無フラグのgetメソッドです。
     *
     * @return 配偶者有無フラグ
     */
    public boolean getHaigushaUmuFlag() {
        return haigushaUmuFlag;
    }

    /**
     * 配偶者有無フラグのsetメソッドです。
     *
     * @param haigushaUmuFlag 配偶者有無フラグ
     */
    public void setHaigushaUmuFlag(boolean haigushaUmuFlag) {
        this.haigushaUmuFlag = haigushaUmuFlag;
    }

    /**
     * 配偶者氏名のgetメソッドです。
     *
     * @return 配偶者氏名
     */
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
     * <br/>預貯金、有価証券等の金額の合計が1000万円（夫婦は2000万円）
     *
     * <br/>1:以下、0:より大きい
     *
     * @return 預貯金申告区分
     */
    public RString getYochokinShinkokuKubun() {
        return yochokinShinkokuKubun;
    }

    /**
     * 預貯金申告区分のsetメソッドです。
     * <br/>
     * <br/>預貯金、有価証券等の金額の合計が1000万円（夫婦は2000万円）
     *
     * <br/>1:以下、0:より大きい
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
    public int getYochokinGaku() {
        return yochokinGaku;
    }

    /**
     * 預貯金額のsetメソッドです。
     *
     * @param yochokinGaku 預貯金額
     */
    public void setYochokinGaku(int yochokinGaku) {
        this.yochokinGaku = yochokinGaku;
    }

    /**
     * 有価証券評価概算額のgetメソッドです。
     *
     * @return 有価証券評価概算額
     */
    public int getYukashoukenGaisangaku() {
        return yukashoukenGaisangaku;
    }

    /**
     * 有価証券評価概算額のsetメソッドです。
     *
     * @param yukashoukenGaisangaku 有価証券評価概算額
     */
    public void setYukashoukenGaisangaku(int yukashoukenGaisangaku) {
        this.yukashoukenGaisangaku = yukashoukenGaisangaku;
    }

    /**
     * その他金額のgetメソッドです。
     *
     * @return その他金額
     */
    public int getSonotaKingaku() {
        return sonotaKingaku;
    }

    /**
     * その他金額のsetメソッドです。
     *
     * @param sonotaKingaku その他金額
     */
    public void setSonotaKingaku(int sonotaKingaku) {
        this.sonotaKingaku = sonotaKingaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4013TokuteiHyojunFutangakuGengakuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4013TokuteiHyojunFutangakuGengakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4013TokuteiHyojunFutangakuGengakuEntity other) {
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
    public void shallowCopy(DbT4013TokuteiHyojunFutangakuGengakuEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.shinseiJiyu = entity.shinseiJiyu;
        this.riyoshaFutanDankai = entity.riyoshaFutanDankai;
        this.hyojunFutanKubun = entity.hyojunFutanKubun;
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
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, rirekiNo, shinseiJiyu, riyoshaFutanDankai, hyojunFutanKubun, kyoshitsuShubetsu, shokuhiFutanGendogaku, unitTypeKoshitsu, unitTypeJunKoshitsu, juraiTypeKoshitsu_Tokuyo, juraiTypeKoshitsu_Roken_Ryoyo, tashoshitsu, haigushaUmuFlag, haigushaShimei, haigushaShimeiKana, haigushaSeinenGappiYMD, haigushaJusho, haigushaRenrakusaki, haigushaJusho2, haigushaKazeiKubun, haigushaShikibetsuCd, yochokinShinkokuKubun, yochokinGaku, yukashoukenGaisangaku, sonotaKingaku);
    }

// </editor-fold>
}

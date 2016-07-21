package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 識別番号管理テーブルのエンティティクラスです。
 * <br/> 識別番号を管理するテーブルです。
 *
 * @reamsid_L DBC-9999-012 panhe
 */
public class DbT3118ShikibetsuNoKanriEntity extends DbTableEntityBase<DbT3118ShikibetsuNoKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3118ShikibetsuNoKanri");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shikibetsuNo;
    @PrimaryKey
    private FlexibleYearMonth tekiyoKaishiYM;
    private FlexibleYearMonth tekiyoShuryoYM;
    private RString meisho;
    private RString ryakusho;
    private RString meisho2;
    private RString shikibetsuNoKubon;
    private RString kyufujissekiKubun;
    private RString kyufuBunruiKubun;
    private RString sentakuKanoShuruiCode01;
    private RString sentakuKanoShuruiCode02;
    private RString sentakuKanoShuruiCode03;
    private RString sentakuKanoShuruiCode04;
    private RString sentakuKanoShuruiCode05;
    private RString sentakuKanoShuruiCode06;
    private RString sentakuKanoShuruiCode07;
    private RString sentakuKanoShuruiCode08;
    private RString sentakuKanoShuruiCode09;
    private RString sentakuKanoShuruiCode10;
    private RString sentakuKanoShuruiCode11;
    private RString sentakuKanoShuruiCode12;
    private RString sentakuKanoShuruiCode13;
    private RString sentakuKanoShuruiCode14;
    private RString sentakuKanoShuruiCode15;
    private RString sentakuKanoShuruiCode16;
    private RString sentakuKanoShuruiCode17;
    private RString sentakuKanoShuruiCode18;
    private RString sentakuKanoShuruiCode19;
    private RString sentakuKanoShuruiCode20;
    private RString shafukuSentakuKanoShuruiCode01;
    private RString shafukuSentakuKanoShuruiCode02;
    private RString shafukuSentakuKanoShuruiCode03;
    private RString shafukuSentakuKanoShuruiCode04;
    private RString shafukuSentakuKanoShuruiCode05;
    private RString shafukuSentakuKanoShuruiCode06;
    private RString shafukuSentakuKanoShuruiCode07;
    private RString shafukuSentakuKanoShuruiCode08;
    private RString shafukuSentakuKanoShuruiCode09;
    private RString shafukuSentakuKanoShuruiCode10;
    private RString kihonSetteiKubun;
    private RString meisaiSetteiKubun;
    private RString kinkyuShisetsuRyoyoSetteiKubun;
    private RString tokuteiShinryoSetteiKubun;
    private RString shokujiHiyosetteiKubun;
    private RString kyotakuKeikakuSetteiKubun;
    private RString fukushoyouguKonyuSetteiKubun;
    private RString jutakukaishuSetteiKubun;
    private RString kogakuKaigoSetteiKubun;
    private RString tokuteishinryoTokubetsuryoyoSetteiKubun;
    private RString tokuteinyushoshaSetteiKubun;
    private RString shakaifukushiKeigenSetteiKubun;
    private RString careManagementSetteiKubun;
    private RString tokuteiShikkanSetteiKubun;
    private RString meisaiJushochitokureiSetteiKubun;
    private RString shukeiSetteiKubun;
    private int hyoujiJun;
    private RString kagoMoshitateYoshikiNo;

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
     * 識別番号のgetメソッドです。
     *
     * @return 識別番号
     */
    public RString getShikibetsuNo() {
        return shikibetsuNo;
    }

    /**
     * 識別番号のsetメソッドです。
     *
     * @param shikibetsuNo 識別番号
     */
    public void setShikibetsuNo(@Nonnull RString shikibetsuNo) {
        this.shikibetsuNo = shikibetsuNo;
    }

    /**
     * 適用開始年月のgetメソッドです。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth getTekiyoKaishiYM() {
        return tekiyoKaishiYM;
    }

    /**
     * 適用開始年月のsetメソッドです。
     *
     * @param tekiyoKaishiYM 適用開始年月
     */
    public void setTekiyoKaishiYM(@Nonnull FlexibleYearMonth tekiyoKaishiYM) {
        this.tekiyoKaishiYM = tekiyoKaishiYM;
    }

    /**
     * 適用終了年月のgetメソッドです。
     *
     * @return 適用終了年月
     */
    @CheckForNull
    public FlexibleYearMonth getTekiyoShuryoYM() {
        return tekiyoShuryoYM;
    }

    /**
     * 適用終了年月のsetメソッドです。
     *
     * @param tekiyoShuryoYM 適用終了年月
     */
    public void setTekiyoShuryoYM(FlexibleYearMonth tekiyoShuryoYM) {
        this.tekiyoShuryoYM = tekiyoShuryoYM;
    }

    /**
     * 名称のgetメソッドです。
     *
     * @return 名称
     */
    @CheckForNull
    public RString getMeisho() {
        return meisho;
    }

    /**
     * 名称のsetメソッドです。
     *
     * @param meisho 名称
     */
    public void setMeisho(RString meisho) {
        this.meisho = meisho;
    }

    /**
     * 略称のgetメソッドです。
     *
     * @return 略称
     */
    @CheckForNull
    public RString getRyakusho() {
        return ryakusho;
    }

    /**
     * 略称のsetメソッドです。
     *
     * @param ryakusho 略称
     */
    public void setRyakusho(RString ryakusho) {
        this.ryakusho = ryakusho;
    }

    /**
     * 名称２のgetメソッドです。
     *
     * @return 名称２
     */
    @CheckForNull
    public RString getMeisho2() {
        return meisho2;
    }

    /**
     * 名称２のsetメソッドです。
     *
     * @param meisho2 名称２
     */
    public void setMeisho2(RString meisho2) {
        this.meisho2 = meisho2;
    }

    /**
     * 識別番号区分のgetメソッドです。
     * <br/>
     * <br/>1：交換情報識別番号、2：入力識別番号
     *
     * @return 識別番号区分
     */
    @CheckForNull
    public RString getShikibetsuNoKubon() {
        return shikibetsuNoKubon;
    }

    /**
     * 識別番号区分のsetメソッドです。
     * <br/>
     * <br/>1：交換情報識別番号、2：入力識別番号
     *
     * @param shikibetsuNoKubon 識別番号区分
     */
    public void setShikibetsuNoKubon(RString shikibetsuNoKubon) {
        this.shikibetsuNoKubon = shikibetsuNoKubon;
    }

    /**
     * 給付実績区分のgetメソッドです。
     * <br/>
     * <br/>1：現物、2：償還、0：区分なし
     *
     * @return 給付実績区分
     */
    @CheckForNull
    public RString getKyufujissekiKubun() {
        return kyufujissekiKubun;
    }

    /**
     * 給付実績区分のsetメソッドです。
     * <br/>
     * <br/>1：現物、2：償還、0：区分なし
     *
     * @param kyufujissekiKubun 給付実績区分
     */
    public void setKyufujissekiKubun(RString kyufujissekiKubun) {
        this.kyufujissekiKubun = kyufujissekiKubun;
    }

    /**
     * 給付分類区分のgetメソッドです。
     * <br/>
     * <br/>1：介護給付、2：予防給付、3：介護給付+予防給付、4：総合事業（経過措置）、5：総合事業、0：区分なし
     *
     * @return 給付分類区分
     */
    @CheckForNull
    public RString getKyufuBunruiKubun() {
        return kyufuBunruiKubun;
    }

    /**
     * 給付分類区分のsetメソッドです。
     * <br/>
     * <br/>1：介護給付、2：予防給付、3：介護給付+予防給付、4：総合事業（経過措置）、5：総合事業、0：区分なし
     *
     * @param kyufuBunruiKubun 給付分類区分
     */
    public void setKyufuBunruiKubun(RString kyufuBunruiKubun) {
        this.kyufuBunruiKubun = kyufuBunruiKubun;
    }

    /**
     * 選択可能サービス種類コード01のgetメソッドです。
     *
     * @return 選択可能サービス種類コード01
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode01() {
        return sentakuKanoShuruiCode01;
    }

    /**
     * 選択可能サービス種類コード01のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode01 選択可能サービス種類コード01
     */
    public void setSentakuKanoShuruiCode01(RString sentakuKanoShuruiCode01) {
        this.sentakuKanoShuruiCode01 = sentakuKanoShuruiCode01;
    }

    /**
     * 選択可能サービス種類コード02のgetメソッドです。
     *
     * @return 選択可能サービス種類コード02
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode02() {
        return sentakuKanoShuruiCode02;
    }

    /**
     * 選択可能サービス種類コード02のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode02 選択可能サービス種類コード02
     */
    public void setSentakuKanoShuruiCode02(RString sentakuKanoShuruiCode02) {
        this.sentakuKanoShuruiCode02 = sentakuKanoShuruiCode02;
    }

    /**
     * 選択可能サービス種類コード03のgetメソッドです。
     *
     * @return 選択可能サービス種類コード03
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode03() {
        return sentakuKanoShuruiCode03;
    }

    /**
     * 選択可能サービス種類コード03のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode03 選択可能サービス種類コード03
     */
    public void setSentakuKanoShuruiCode03(RString sentakuKanoShuruiCode03) {
        this.sentakuKanoShuruiCode03 = sentakuKanoShuruiCode03;
    }

    /**
     * 選択可能サービス種類コード04のgetメソッドです。
     *
     * @return 選択可能サービス種類コード04
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode04() {
        return sentakuKanoShuruiCode04;
    }

    /**
     * 選択可能サービス種類コード04のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode04 選択可能サービス種類コード04
     */
    public void setSentakuKanoShuruiCode04(RString sentakuKanoShuruiCode04) {
        this.sentakuKanoShuruiCode04 = sentakuKanoShuruiCode04;
    }

    /**
     * 選択可能サービス種類コード05のgetメソッドです。
     *
     * @return 選択可能サービス種類コード05
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode05() {
        return sentakuKanoShuruiCode05;
    }

    /**
     * 選択可能サービス種類コード05のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode05 選択可能サービス種類コード05
     */
    public void setSentakuKanoShuruiCode05(RString sentakuKanoShuruiCode05) {
        this.sentakuKanoShuruiCode05 = sentakuKanoShuruiCode05;
    }

    /**
     * 選択可能サービス種類コード06のgetメソッドです。
     *
     * @return 選択可能サービス種類コード06
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode06() {
        return sentakuKanoShuruiCode06;
    }

    /**
     * 選択可能サービス種類コード06のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode06 選択可能サービス種類コード06
     */
    public void setSentakuKanoShuruiCode06(RString sentakuKanoShuruiCode06) {
        this.sentakuKanoShuruiCode06 = sentakuKanoShuruiCode06;
    }

    /**
     * 選択可能サービス種類コード07のgetメソッドです。
     *
     * @return 選択可能サービス種類コード07
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode07() {
        return sentakuKanoShuruiCode07;
    }

    /**
     * 選択可能サービス種類コード07のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode07 選択可能サービス種類コード07
     */
    public void setSentakuKanoShuruiCode07(RString sentakuKanoShuruiCode07) {
        this.sentakuKanoShuruiCode07 = sentakuKanoShuruiCode07;
    }

    /**
     * 選択可能サービス種類コード08のgetメソッドです。
     *
     * @return 選択可能サービス種類コード08
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode08() {
        return sentakuKanoShuruiCode08;
    }

    /**
     * 選択可能サービス種類コード08のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode08 選択可能サービス種類コード08
     */
    public void setSentakuKanoShuruiCode08(RString sentakuKanoShuruiCode08) {
        this.sentakuKanoShuruiCode08 = sentakuKanoShuruiCode08;
    }

    /**
     * 選択可能サービス種類コード09のgetメソッドです。
     *
     * @return 選択可能サービス種類コード09
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode09() {
        return sentakuKanoShuruiCode09;
    }

    /**
     * 選択可能サービス種類コード09のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode09 選択可能サービス種類コード09
     */
    public void setSentakuKanoShuruiCode09(RString sentakuKanoShuruiCode09) {
        this.sentakuKanoShuruiCode09 = sentakuKanoShuruiCode09;
    }

    /**
     * 選択可能サービス種類コード10のgetメソッドです。
     *
     * @return 選択可能サービス種類コード10
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode10() {
        return sentakuKanoShuruiCode10;
    }

    /**
     * 選択可能サービス種類コード10のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode10 選択可能サービス種類コード10
     */
    public void setSentakuKanoShuruiCode10(RString sentakuKanoShuruiCode10) {
        this.sentakuKanoShuruiCode10 = sentakuKanoShuruiCode10;
    }

    /**
     * 選択可能サービス種類コード11のgetメソッドです。
     *
     * @return 選択可能サービス種類コード11
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode11() {
        return sentakuKanoShuruiCode11;
    }

    /**
     * 選択可能サービス種類コード11のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode11 選択可能サービス種類コード11
     */
    public void setSentakuKanoShuruiCode11(RString sentakuKanoShuruiCode11) {
        this.sentakuKanoShuruiCode11 = sentakuKanoShuruiCode11;
    }

    /**
     * 選択可能サービス種類コード12のgetメソッドです。
     *
     * @return 選択可能サービス種類コード12
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode12() {
        return sentakuKanoShuruiCode12;
    }

    /**
     * 選択可能サービス種類コード12のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode12 選択可能サービス種類コード12
     */
    public void setSentakuKanoShuruiCode12(RString sentakuKanoShuruiCode12) {
        this.sentakuKanoShuruiCode12 = sentakuKanoShuruiCode12;
    }

    /**
     * 選択可能サービス種類コード13のgetメソッドです。
     *
     * @return 選択可能サービス種類コード13
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode13() {
        return sentakuKanoShuruiCode13;
    }

    /**
     * 選択可能サービス種類コード13のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode13 選択可能サービス種類コード13
     */
    public void setSentakuKanoShuruiCode13(RString sentakuKanoShuruiCode13) {
        this.sentakuKanoShuruiCode13 = sentakuKanoShuruiCode13;
    }

    /**
     * 選択可能サービス種類コード14のgetメソッドです。
     *
     * @return 選択可能サービス種類コード14
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode14() {
        return sentakuKanoShuruiCode14;
    }

    /**
     * 選択可能サービス種類コード14のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode14 選択可能サービス種類コード14
     */
    public void setSentakuKanoShuruiCode14(RString sentakuKanoShuruiCode14) {
        this.sentakuKanoShuruiCode14 = sentakuKanoShuruiCode14;
    }

    /**
     * 選択可能サービス種類コード15のgetメソッドです。
     *
     * @return 選択可能サービス種類コード15
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode15() {
        return sentakuKanoShuruiCode15;
    }

    /**
     * 選択可能サービス種類コード15のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode15 選択可能サービス種類コード15
     */
    public void setSentakuKanoShuruiCode15(RString sentakuKanoShuruiCode15) {
        this.sentakuKanoShuruiCode15 = sentakuKanoShuruiCode15;
    }

    /**
     * 選択可能サービス種類コード16のgetメソッドです。
     *
     * @return 選択可能サービス種類コード16
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode16() {
        return sentakuKanoShuruiCode16;
    }

    /**
     * 選択可能サービス種類コード16のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode16 選択可能サービス種類コード16
     */
    public void setSentakuKanoShuruiCode16(RString sentakuKanoShuruiCode16) {
        this.sentakuKanoShuruiCode16 = sentakuKanoShuruiCode16;
    }

    /**
     * 選択可能サービス種類コード17のgetメソッドです。
     *
     * @return 選択可能サービス種類コード17
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode17() {
        return sentakuKanoShuruiCode17;
    }

    /**
     * 選択可能サービス種類コード17のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode17 選択可能サービス種類コード17
     */
    public void setSentakuKanoShuruiCode17(RString sentakuKanoShuruiCode17) {
        this.sentakuKanoShuruiCode17 = sentakuKanoShuruiCode17;
    }

    /**
     * 選択可能サービス種類コード18のgetメソッドです。
     *
     * @return 選択可能サービス種類コード18
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode18() {
        return sentakuKanoShuruiCode18;
    }

    /**
     * 選択可能サービス種類コード18のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode18 選択可能サービス種類コード18
     */
    public void setSentakuKanoShuruiCode18(RString sentakuKanoShuruiCode18) {
        this.sentakuKanoShuruiCode18 = sentakuKanoShuruiCode18;
    }

    /**
     * 選択可能サービス種類コード19のgetメソッドです。
     *
     * @return 選択可能サービス種類コード19
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode19() {
        return sentakuKanoShuruiCode19;
    }

    /**
     * 選択可能サービス種類コード19のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode19 選択可能サービス種類コード19
     */
    public void setSentakuKanoShuruiCode19(RString sentakuKanoShuruiCode19) {
        this.sentakuKanoShuruiCode19 = sentakuKanoShuruiCode19;
    }

    /**
     * 選択可能サービス種類コード20のgetメソッドです。
     *
     * @return 選択可能サービス種類コード20
     */
    @CheckForNull
    public RString getSentakuKanoShuruiCode20() {
        return sentakuKanoShuruiCode20;
    }

    /**
     * 選択可能サービス種類コード20のsetメソッドです。
     *
     * @param sentakuKanoShuruiCode20 選択可能サービス種類コード20
     */
    public void setSentakuKanoShuruiCode20(RString sentakuKanoShuruiCode20) {
        this.sentakuKanoShuruiCode20 = sentakuKanoShuruiCode20;
    }

    /**
     * 社福選択可能種類コード01のgetメソッドです。
     *
     * @return 社福選択可能種類コード01
     */
    @CheckForNull
    public RString getShafukuSentakuKanoShuruiCode01() {
        return shafukuSentakuKanoShuruiCode01;
    }

    /**
     * 社福選択可能種類コード01のsetメソッドです。
     *
     * @param shafukuSentakuKanoShuruiCode01 社福選択可能種類コード01
     */
    public void setShafukuSentakuKanoShuruiCode01(RString shafukuSentakuKanoShuruiCode01) {
        this.shafukuSentakuKanoShuruiCode01 = shafukuSentakuKanoShuruiCode01;
    }

    /**
     * 社福選択可能種類コード02のgetメソッドです。
     *
     * @return 社福選択可能種類コード02
     */
    @CheckForNull
    public RString getShafukuSentakuKanoShuruiCode02() {
        return shafukuSentakuKanoShuruiCode02;
    }

    /**
     * 社福選択可能種類コード02のsetメソッドです。
     *
     * @param shafukuSentakuKanoShuruiCode02 社福選択可能種類コード02
     */
    public void setShafukuSentakuKanoShuruiCode02(RString shafukuSentakuKanoShuruiCode02) {
        this.shafukuSentakuKanoShuruiCode02 = shafukuSentakuKanoShuruiCode02;
    }

    /**
     * 社福選択可能種類コード03のgetメソッドです。
     *
     * @return 社福選択可能種類コード03
     */
    @CheckForNull
    public RString getShafukuSentakuKanoShuruiCode03() {
        return shafukuSentakuKanoShuruiCode03;
    }

    /**
     * 社福選択可能種類コード03のsetメソッドです。
     *
     * @param shafukuSentakuKanoShuruiCode03 社福選択可能種類コード03
     */
    public void setShafukuSentakuKanoShuruiCode03(RString shafukuSentakuKanoShuruiCode03) {
        this.shafukuSentakuKanoShuruiCode03 = shafukuSentakuKanoShuruiCode03;
    }

    /**
     * 社福選択可能種類コード04のgetメソッドです。
     *
     * @return 社福選択可能種類コード04
     */
    @CheckForNull
    public RString getShafukuSentakuKanoShuruiCode04() {
        return shafukuSentakuKanoShuruiCode04;
    }

    /**
     * 社福選択可能種類コード04のsetメソッドです。
     *
     * @param shafukuSentakuKanoShuruiCode04 社福選択可能種類コード04
     */
    public void setShafukuSentakuKanoShuruiCode04(RString shafukuSentakuKanoShuruiCode04) {
        this.shafukuSentakuKanoShuruiCode04 = shafukuSentakuKanoShuruiCode04;
    }

    /**
     * 社福選択可能種類コード05のgetメソッドです。
     *
     * @return 社福選択可能種類コード05
     */
    @CheckForNull
    public RString getShafukuSentakuKanoShuruiCode05() {
        return shafukuSentakuKanoShuruiCode05;
    }

    /**
     * 社福選択可能種類コード05のsetメソッドです。
     *
     * @param shafukuSentakuKanoShuruiCode05 社福選択可能種類コード05
     */
    public void setShafukuSentakuKanoShuruiCode05(RString shafukuSentakuKanoShuruiCode05) {
        this.shafukuSentakuKanoShuruiCode05 = shafukuSentakuKanoShuruiCode05;
    }

    /**
     * 社福選択可能種類コード06のgetメソッドです。
     *
     * @return 社福選択可能種類コード06
     */
    @CheckForNull
    public RString getShafukuSentakuKanoShuruiCode06() {
        return shafukuSentakuKanoShuruiCode06;
    }

    /**
     * 社福選択可能種類コード06のsetメソッドです。
     *
     * @param shafukuSentakuKanoShuruiCode06 社福選択可能種類コード06
     */
    public void setShafukuSentakuKanoShuruiCode06(RString shafukuSentakuKanoShuruiCode06) {
        this.shafukuSentakuKanoShuruiCode06 = shafukuSentakuKanoShuruiCode06;
    }

    /**
     * 社福選択可能種類コード07のgetメソッドです。
     *
     * @return 社福選択可能種類コード07
     */
    @CheckForNull
    public RString getShafukuSentakuKanoShuruiCode07() {
        return shafukuSentakuKanoShuruiCode07;
    }

    /**
     * 社福選択可能種類コード07のsetメソッドです。
     *
     * @param shafukuSentakuKanoShuruiCode07 社福選択可能種類コード07
     */
    public void setShafukuSentakuKanoShuruiCode07(RString shafukuSentakuKanoShuruiCode07) {
        this.shafukuSentakuKanoShuruiCode07 = shafukuSentakuKanoShuruiCode07;
    }

    /**
     * 社福選択可能種類コード08のgetメソッドです。
     *
     * @return 社福選択可能種類コード08
     */
    @CheckForNull
    public RString getShafukuSentakuKanoShuruiCode08() {
        return shafukuSentakuKanoShuruiCode08;
    }

    /**
     * 社福選択可能種類コード08のsetメソッドです。
     *
     * @param shafukuSentakuKanoShuruiCode08 社福選択可能種類コード08
     */
    public void setShafukuSentakuKanoShuruiCode08(RString shafukuSentakuKanoShuruiCode08) {
        this.shafukuSentakuKanoShuruiCode08 = shafukuSentakuKanoShuruiCode08;
    }

    /**
     * 社福選択可能種類コード09のgetメソッドです。
     *
     * @return 社福選択可能種類コード09
     */
    @CheckForNull
    public RString getShafukuSentakuKanoShuruiCode09() {
        return shafukuSentakuKanoShuruiCode09;
    }

    /**
     * 社福選択可能種類コード09のsetメソッドです。
     *
     * @param shafukuSentakuKanoShuruiCode09 社福選択可能種類コード09
     */
    public void setShafukuSentakuKanoShuruiCode09(RString shafukuSentakuKanoShuruiCode09) {
        this.shafukuSentakuKanoShuruiCode09 = shafukuSentakuKanoShuruiCode09;
    }

    /**
     * 社福選択可能種類コード10のgetメソッドです。
     *
     * @return 社福選択可能種類コード10
     */
    @CheckForNull
    public RString getShafukuSentakuKanoShuruiCode10() {
        return shafukuSentakuKanoShuruiCode10;
    }

    /**
     * 社福選択可能種類コード10のsetメソッドです。
     *
     * @param shafukuSentakuKanoShuruiCode10 社福選択可能種類コード10
     */
    public void setShafukuSentakuKanoShuruiCode10(RString shafukuSentakuKanoShuruiCode10) {
        this.shafukuSentakuKanoShuruiCode10 = shafukuSentakuKanoShuruiCode10;
    }

    /**
     * 基本設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 基本設定区分
     */
    @CheckForNull
    public RString getKihonSetteiKubun() {
        return kihonSetteiKubun;
    }

    /**
     * 基本設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param kihonSetteiKubun 基本設定区分
     */
    public void setKihonSetteiKubun(RString kihonSetteiKubun) {
        this.kihonSetteiKubun = kihonSetteiKubun;
    }

    /**
     * 明細設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 明細設定区分
     */
    @CheckForNull
    public RString getMeisaiSetteiKubun() {
        return meisaiSetteiKubun;
    }

    /**
     * 明細設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param meisaiSetteiKubun 明細設定区分
     */
    public void setMeisaiSetteiKubun(RString meisaiSetteiKubun) {
        this.meisaiSetteiKubun = meisaiSetteiKubun;
    }

    /**
     * 緊急時施設療養設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 緊急時施設療養設定区分
     */
    @CheckForNull
    public RString getKinkyuShisetsuRyoyoSetteiKubun() {
        return kinkyuShisetsuRyoyoSetteiKubun;
    }

    /**
     * 緊急時施設療養設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param kinkyuShisetsuRyoyoSetteiKubun 緊急時施設療養設定区分
     */
    public void setKinkyuShisetsuRyoyoSetteiKubun(RString kinkyuShisetsuRyoyoSetteiKubun) {
        this.kinkyuShisetsuRyoyoSetteiKubun = kinkyuShisetsuRyoyoSetteiKubun;
    }

    /**
     * 特定診療費設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 特定診療費設定区分
     */
    @CheckForNull
    public RString getTokuteiShinryoSetteiKubun() {
        return tokuteiShinryoSetteiKubun;
    }

    /**
     * 特定診療費設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param tokuteiShinryoSetteiKubun 特定診療費設定区分
     */
    public void setTokuteiShinryoSetteiKubun(RString tokuteiShinryoSetteiKubun) {
        this.tokuteiShinryoSetteiKubun = tokuteiShinryoSetteiKubun;
    }

    /**
     * 食事費用設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 食事費用設定区分
     */
    @CheckForNull
    public RString getShokujiHiyosetteiKubun() {
        return shokujiHiyosetteiKubun;
    }

    /**
     * 食事費用設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param shokujiHiyosetteiKubun 食事費用設定区分
     */
    public void setShokujiHiyosetteiKubun(RString shokujiHiyosetteiKubun) {
        this.shokujiHiyosetteiKubun = shokujiHiyosetteiKubun;
    }

    /**
     * 居宅計画費設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 居宅計画費設定区分
     */
    @CheckForNull
    public RString getKyotakuKeikakuSetteiKubun() {
        return kyotakuKeikakuSetteiKubun;
    }

    /**
     * 居宅計画費設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param kyotakuKeikakuSetteiKubun 居宅計画費設定区分
     */
    public void setKyotakuKeikakuSetteiKubun(RString kyotakuKeikakuSetteiKubun) {
        this.kyotakuKeikakuSetteiKubun = kyotakuKeikakuSetteiKubun;
    }

    /**
     * 福祉用具購入費設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 福祉用具購入費設定区分
     */
    @CheckForNull
    public RString getFukushoyouguKonyuSetteiKubun() {
        return fukushoyouguKonyuSetteiKubun;
    }

    /**
     * 福祉用具購入費設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param fukushoyouguKonyuSetteiKubun 福祉用具購入費設定区分
     */
    public void setFukushoyouguKonyuSetteiKubun(RString fukushoyouguKonyuSetteiKubun) {
        this.fukushoyouguKonyuSetteiKubun = fukushoyouguKonyuSetteiKubun;
    }

    /**
     * 住宅改修費設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 住宅改修費設定区分
     */
    @CheckForNull
    public RString getJutakukaishuSetteiKubun() {
        return jutakukaishuSetteiKubun;
    }

    /**
     * 住宅改修費設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param jutakukaishuSetteiKubun 住宅改修費設定区分
     */
    public void setJutakukaishuSetteiKubun(RString jutakukaishuSetteiKubun) {
        this.jutakukaishuSetteiKubun = jutakukaishuSetteiKubun;
    }

    /**
     * 高額介護サービス費設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 高額介護サービス費設定区分
     */
    @CheckForNull
    public RString getKogakuKaigoSetteiKubun() {
        return kogakuKaigoSetteiKubun;
    }

    /**
     * 高額介護サービス費設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param kogakuKaigoSetteiKubun 高額介護サービス費設定区分
     */
    public void setKogakuKaigoSetteiKubun(RString kogakuKaigoSetteiKubun) {
        this.kogakuKaigoSetteiKubun = kogakuKaigoSetteiKubun;
    }

    /**
     * 特定診療特別療養設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 特定診療特別療養設定区分
     */
    @CheckForNull
    public RString getTokuteishinryoTokubetsuryoyoSetteiKubun() {
        return tokuteishinryoTokubetsuryoyoSetteiKubun;
    }

    /**
     * 特定診療特別療養設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param tokuteishinryoTokubetsuryoyoSetteiKubun 特定診療特別療養設定区分
     */
    public void setTokuteishinryoTokubetsuryoyoSetteiKubun(RString tokuteishinryoTokubetsuryoyoSetteiKubun) {
        this.tokuteishinryoTokubetsuryoyoSetteiKubun = tokuteishinryoTokubetsuryoyoSetteiKubun;
    }

    /**
     * 特定入所者設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 特定入所者設定区分
     */
    @CheckForNull
    public RString getTokuteinyushoshaSetteiKubun() {
        return tokuteinyushoshaSetteiKubun;
    }

    /**
     * 特定入所者設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param tokuteinyushoshaSetteiKubun 特定入所者設定区分
     */
    public void setTokuteinyushoshaSetteiKubun(RString tokuteinyushoshaSetteiKubun) {
        this.tokuteinyushoshaSetteiKubun = tokuteinyushoshaSetteiKubun;
    }

    /**
     * 社会福祉法人軽減設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 社会福祉法人軽減設定区分
     */
    @CheckForNull
    public RString getShakaifukushiKeigenSetteiKubun() {
        return shakaifukushiKeigenSetteiKubun;
    }

    /**
     * 社会福祉法人軽減設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param shakaifukushiKeigenSetteiKubun 社会福祉法人軽減設定区分
     */
    public void setShakaifukushiKeigenSetteiKubun(RString shakaifukushiKeigenSetteiKubun) {
        this.shakaifukushiKeigenSetteiKubun = shakaifukushiKeigenSetteiKubun;
    }

    /**
     * ケアマネジメント設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return ケアマネジメント設定区分
     */
    @CheckForNull
    public RString getCareManagementSetteiKubun() {
        return careManagementSetteiKubun;
    }

    /**
     * ケアマネジメント設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param careManagementSetteiKubun ケアマネジメント設定区分
     */
    public void setCareManagementSetteiKubun(RString careManagementSetteiKubun) {
        this.careManagementSetteiKubun = careManagementSetteiKubun;
    }

    /**
     * 特定疾患施設療養設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 特定疾患施設療養設定区分
     */
    @CheckForNull
    public RString getTokuteiShikkanSetteiKubun() {
        return tokuteiShikkanSetteiKubun;
    }

    /**
     * 特定疾患施設療養設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param tokuteiShikkanSetteiKubun 特定疾患施設療養設定区分
     */
    public void setTokuteiShikkanSetteiKubun(RString tokuteiShikkanSetteiKubun) {
        this.tokuteiShikkanSetteiKubun = tokuteiShikkanSetteiKubun;
    }

    /**
     * 明細住所地特例設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 明細住所地特例設定区分
     */
    @CheckForNull
    public RString getMeisaiJushochitokureiSetteiKubun() {
        return meisaiJushochitokureiSetteiKubun;
    }

    /**
     * 明細住所地特例設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param meisaiJushochitokureiSetteiKubun 明細住所地特例設定区分
     */
    public void setMeisaiJushochitokureiSetteiKubun(RString meisaiJushochitokureiSetteiKubun) {
        this.meisaiJushochitokureiSetteiKubun = meisaiJushochitokureiSetteiKubun;
    }

    /**
     * 集計設定区分のgetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @return 集計設定区分
     */
    @CheckForNull
    public RString getShukeiSetteiKubun() {
        return shukeiSetteiKubun;
    }

    /**
     * 集計設定区分のsetメソッドです。
     * <br/>
     * <br/>0：設定不可、1：設定可（必須）、2：設定可（任意）
     *
     * @param shukeiSetteiKubun 集計設定区分
     */
    public void setShukeiSetteiKubun(RString shukeiSetteiKubun) {
        this.shukeiSetteiKubun = shukeiSetteiKubun;
    }

    /**
     * 表示順のgetメソッドです。
     *
     * @return 表示順
     */
    @CheckForNull
    public int getHyoujiJun() {
        return hyoujiJun;
    }

    /**
     * 表示順のsetメソッドです。
     *
     * @param hyoujiJun 表示順
     */
    public void setHyoujiJun(int hyoujiJun) {
        this.hyoujiJun = hyoujiJun;
    }

    /**
     * 過誤申立様式番号のgetメソッドです。
     * <br/>
     * <br/>過誤申立事由（様式）コードを設定する
     *
     * @return 過誤申立様式番号
     */
    @CheckForNull
    public RString getKagoMoshitateYoshikiNo() {
        return kagoMoshitateYoshikiNo;
    }

    /**
     * 過誤申立様式番号のsetメソッドです。
     * <br/>
     * <br/>過誤申立事由（様式）コードを設定する
     *
     * @param kagoMoshitateYoshikiNo 過誤申立様式番号
     */
    public void setKagoMoshitateYoshikiNo(RString kagoMoshitateYoshikiNo) {
        this.kagoMoshitateYoshikiNo = kagoMoshitateYoshikiNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3118ShikibetsuNoKanriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3118ShikibetsuNoKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3118ShikibetsuNoKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuNo, other.shikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.tekiyoKaishiYM, other.tekiyoKaishiYM)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3118ShikibetsuNoKanriEntity entity) {
        this.shikibetsuNo = entity.shikibetsuNo;
        this.tekiyoKaishiYM = entity.tekiyoKaishiYM;
        this.tekiyoShuryoYM = entity.tekiyoShuryoYM;
        this.meisho = entity.meisho;
        this.ryakusho = entity.ryakusho;
        this.meisho2 = entity.meisho2;
        this.shikibetsuNoKubon = entity.shikibetsuNoKubon;
        this.kyufujissekiKubun = entity.kyufujissekiKubun;
        this.kyufuBunruiKubun = entity.kyufuBunruiKubun;
        this.sentakuKanoShuruiCode01 = entity.sentakuKanoShuruiCode01;
        this.sentakuKanoShuruiCode02 = entity.sentakuKanoShuruiCode02;
        this.sentakuKanoShuruiCode03 = entity.sentakuKanoShuruiCode03;
        this.sentakuKanoShuruiCode04 = entity.sentakuKanoShuruiCode04;
        this.sentakuKanoShuruiCode05 = entity.sentakuKanoShuruiCode05;
        this.sentakuKanoShuruiCode06 = entity.sentakuKanoShuruiCode06;
        this.sentakuKanoShuruiCode07 = entity.sentakuKanoShuruiCode07;
        this.sentakuKanoShuruiCode08 = entity.sentakuKanoShuruiCode08;
        this.sentakuKanoShuruiCode09 = entity.sentakuKanoShuruiCode09;
        this.sentakuKanoShuruiCode10 = entity.sentakuKanoShuruiCode10;
        this.sentakuKanoShuruiCode11 = entity.sentakuKanoShuruiCode11;
        this.sentakuKanoShuruiCode12 = entity.sentakuKanoShuruiCode12;
        this.sentakuKanoShuruiCode13 = entity.sentakuKanoShuruiCode13;
        this.sentakuKanoShuruiCode14 = entity.sentakuKanoShuruiCode14;
        this.sentakuKanoShuruiCode15 = entity.sentakuKanoShuruiCode15;
        this.sentakuKanoShuruiCode16 = entity.sentakuKanoShuruiCode16;
        this.sentakuKanoShuruiCode17 = entity.sentakuKanoShuruiCode17;
        this.sentakuKanoShuruiCode18 = entity.sentakuKanoShuruiCode18;
        this.sentakuKanoShuruiCode19 = entity.sentakuKanoShuruiCode19;
        this.sentakuKanoShuruiCode20 = entity.sentakuKanoShuruiCode20;
        this.shafukuSentakuKanoShuruiCode01 = entity.shafukuSentakuKanoShuruiCode01;
        this.shafukuSentakuKanoShuruiCode02 = entity.shafukuSentakuKanoShuruiCode02;
        this.shafukuSentakuKanoShuruiCode03 = entity.shafukuSentakuKanoShuruiCode03;
        this.shafukuSentakuKanoShuruiCode04 = entity.shafukuSentakuKanoShuruiCode04;
        this.shafukuSentakuKanoShuruiCode05 = entity.shafukuSentakuKanoShuruiCode05;
        this.shafukuSentakuKanoShuruiCode06 = entity.shafukuSentakuKanoShuruiCode06;
        this.shafukuSentakuKanoShuruiCode07 = entity.shafukuSentakuKanoShuruiCode07;
        this.shafukuSentakuKanoShuruiCode08 = entity.shafukuSentakuKanoShuruiCode08;
        this.shafukuSentakuKanoShuruiCode09 = entity.shafukuSentakuKanoShuruiCode09;
        this.shafukuSentakuKanoShuruiCode10 = entity.shafukuSentakuKanoShuruiCode10;
        this.kihonSetteiKubun = entity.kihonSetteiKubun;
        this.meisaiSetteiKubun = entity.meisaiSetteiKubun;
        this.kinkyuShisetsuRyoyoSetteiKubun = entity.kinkyuShisetsuRyoyoSetteiKubun;
        this.tokuteiShinryoSetteiKubun = entity.tokuteiShinryoSetteiKubun;
        this.shokujiHiyosetteiKubun = entity.shokujiHiyosetteiKubun;
        this.kyotakuKeikakuSetteiKubun = entity.kyotakuKeikakuSetteiKubun;
        this.fukushoyouguKonyuSetteiKubun = entity.fukushoyouguKonyuSetteiKubun;
        this.jutakukaishuSetteiKubun = entity.jutakukaishuSetteiKubun;
        this.kogakuKaigoSetteiKubun = entity.kogakuKaigoSetteiKubun;
        this.tokuteishinryoTokubetsuryoyoSetteiKubun = entity.tokuteishinryoTokubetsuryoyoSetteiKubun;
        this.tokuteinyushoshaSetteiKubun = entity.tokuteinyushoshaSetteiKubun;
        this.shakaifukushiKeigenSetteiKubun = entity.shakaifukushiKeigenSetteiKubun;
        this.careManagementSetteiKubun = entity.careManagementSetteiKubun;
        this.tokuteiShikkanSetteiKubun = entity.tokuteiShikkanSetteiKubun;
        this.meisaiJushochitokureiSetteiKubun = entity.meisaiJushochitokureiSetteiKubun;
        this.shukeiSetteiKubun = entity.shukeiSetteiKubun;
        this.hyoujiJun = entity.hyoujiJun;
        this.kagoMoshitateYoshikiNo = entity.kagoMoshitateYoshikiNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuNo, tekiyoKaishiYM, tekiyoShuryoYM, meisho, ryakusho, meisho2, shikibetsuNoKubon, kyufujissekiKubun, kyufuBunruiKubun, sentakuKanoShuruiCode01, sentakuKanoShuruiCode02, sentakuKanoShuruiCode03, sentakuKanoShuruiCode04, sentakuKanoShuruiCode05, sentakuKanoShuruiCode06, sentakuKanoShuruiCode07, sentakuKanoShuruiCode08, sentakuKanoShuruiCode09, sentakuKanoShuruiCode10, sentakuKanoShuruiCode11, sentakuKanoShuruiCode12, sentakuKanoShuruiCode13, sentakuKanoShuruiCode14, sentakuKanoShuruiCode15, sentakuKanoShuruiCode16, sentakuKanoShuruiCode17, sentakuKanoShuruiCode18, sentakuKanoShuruiCode19, sentakuKanoShuruiCode20, shafukuSentakuKanoShuruiCode01, shafukuSentakuKanoShuruiCode02, shafukuSentakuKanoShuruiCode03, shafukuSentakuKanoShuruiCode04, shafukuSentakuKanoShuruiCode05, shafukuSentakuKanoShuruiCode06, shafukuSentakuKanoShuruiCode07, shafukuSentakuKanoShuruiCode08, shafukuSentakuKanoShuruiCode09, shafukuSentakuKanoShuruiCode10, kihonSetteiKubun, meisaiSetteiKubun, kinkyuShisetsuRyoyoSetteiKubun, tokuteiShinryoSetteiKubun, shokujiHiyosetteiKubun, kyotakuKeikakuSetteiKubun, fukushoyouguKonyuSetteiKubun, jutakukaishuSetteiKubun, kogakuKaigoSetteiKubun, tokuteishinryoTokubetsuryoyoSetteiKubun, tokuteinyushoshaSetteiKubun, shakaifukushiKeigenSetteiKubun, careManagementSetteiKubun, tokuteiShikkanSetteiKubun, meisaiJushochitokureiSetteiKubun, shukeiSetteiKubun, hyoujiJun, kagoMoshitateYoshikiNo);
    }

// </editor-fold>
}

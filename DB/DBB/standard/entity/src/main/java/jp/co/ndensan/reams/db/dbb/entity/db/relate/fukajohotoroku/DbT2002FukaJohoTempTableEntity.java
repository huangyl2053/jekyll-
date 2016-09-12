package jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * DbT2002FukaJohoTempTableEntity項目定義クラスです。
 *
 * @reamsid_L DBB-9040-070 wangxiaodong
 */
@OnNextSchema("rgdb")
public class DbT2002FukaJohoTempTableEntity extends DbTableEntityBase<DbT2002FukaJohoTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    /**
     * 賦課情報一時テーブル
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("DbT2002FukaJohoTemp");
    }
    @TempTableColumnOrder(1)
    private FlexibleYear choteiNendo;
    @TempTableColumnOrder(2)
    private FlexibleYear fukaNendo;
    @TempTableColumnOrder(3)
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(4)
    private int rirekiNo;
    @TempTableColumnOrder(5)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(6)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(7)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(8)
    private int setaiInsu;
    @TempTableColumnOrder(9)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(10)
    private RString shikakuShutokuJiyu;
    @TempTableColumnOrder(11)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(12)
    private RString shikakuSoshitsuJiyu;
    @TempTableColumnOrder(13)
    private RString seihofujoShurui;
    @TempTableColumnOrder(14)
    private FlexibleDate seihoKaishiYMD;
    @TempTableColumnOrder(15)
    private FlexibleDate seihoHaishiYMD;
    @TempTableColumnOrder(16)
    private FlexibleDate ronenKaishiYMD;
    @TempTableColumnOrder(17)
    private FlexibleDate ronenHaishiYMD;
    @TempTableColumnOrder(18)
    private FlexibleDate fukaYMD;
    @TempTableColumnOrder(19)
    private RString kazeiKubun;
    @TempTableColumnOrder(20)
    private RString setaikazeiKubun;
    @TempTableColumnOrder(21)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(22)
    private Decimal nenkinShunyuGaku;
    @TempTableColumnOrder(23)
    private RString hokenryoDankai;
    @TempTableColumnOrder(24)
    private RString hokenryoDankai1;
    @TempTableColumnOrder(25)
    private Decimal nengakuHokenryo1;
    @TempTableColumnOrder(26)
    private FlexibleYearMonth tsukiwariStartYM1;
    @TempTableColumnOrder(27)
    private FlexibleYearMonth tsukiwariEndYM1;
    @TempTableColumnOrder(28)
    private RString hokenryoDankai2;
    @TempTableColumnOrder(29)
    private Decimal nengakuHokenryo2;
    @TempTableColumnOrder(30)
    private FlexibleYearMonth tsukiwariStartYM2;
    @TempTableColumnOrder(31)
    private FlexibleYearMonth tsukiwariEndYM2;
    @TempTableColumnOrder(32)
    private YMDHMS choteiNichiji;
    @TempTableColumnOrder(33)
    private RString choteiJiyu1;
    @TempTableColumnOrder(34)
    private RString choteiJiyu2;
    @TempTableColumnOrder(35)
    private RString choteiJiyu3;
    @TempTableColumnOrder(36)
    private RString choteiJiyu4;
    @TempTableColumnOrder(37)
    private RString koseiM;
    @TempTableColumnOrder(38)
    private Decimal gemmenMaeHokenryo;
    @TempTableColumnOrder(39)
    private Decimal gemmenGaku;
    @TempTableColumnOrder(10)
    private Decimal kakuteiHokenryo;
    @TempTableColumnOrder(41)
    private RString hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(42)
    private int choshuHohoRirekiNo;
    @TempTableColumnOrder(43)
    private YMDHMS idoKijunNichiji;
    @TempTableColumnOrder(44)
    private RString kozaKubun;
    @TempTableColumnOrder(45)
    private RString kyokaisoKubun;
    @TempTableColumnOrder(46)
    private RString shokkenKubun;
    @TempTableColumnOrder(47)
    private LasdecCode fukaShichosonCode;
    @TempTableColumnOrder(48)
    private Decimal tkSaishutsuKampuGaku;
    @TempTableColumnOrder(49)
    private Decimal fuSaishutsuKampuGaku;
    @TempTableColumnOrder(50)
    private Decimal tkKibetsuGaku01;
    @TempTableColumnOrder(51)
    private Decimal tkKibetsuGaku02;
    @TempTableColumnOrder(52)
    private Decimal tkKibetsuGaku03;
    @TempTableColumnOrder(53)
    private Decimal tkKibetsuGaku04;
    @TempTableColumnOrder(54)
    private Decimal tkKibetsuGaku05;
    @TempTableColumnOrder(55)
    private Decimal tkKibetsuGaku06;
    @TempTableColumnOrder(56)
    private Decimal fuKibetsuGaku01;
    @TempTableColumnOrder(57)
    private Decimal fuKibetsuGaku02;
    @TempTableColumnOrder(58)
    private Decimal fuKibetsuGaku03;
    @TempTableColumnOrder(59)
    private Decimal fuKibetsuGaku04;
    @TempTableColumnOrder(60)
    private Decimal fuKibetsuGaku05;
    @TempTableColumnOrder(61)
    private Decimal fuKibetsuGaku06;
    @TempTableColumnOrder(62)
    private Decimal fuKibetsuGaku07;
    @TempTableColumnOrder(63)
    private Decimal fuKibetsuGaku08;
    @TempTableColumnOrder(64)
    private Decimal fuKibetsuGaku09;
    @TempTableColumnOrder(65)
    private Decimal fuKibetsuGaku10;
    @TempTableColumnOrder(66)
    private Decimal fuKibetsuGaku11;
    @TempTableColumnOrder(67)
    private Decimal fuKibetsuGaku12;
    @TempTableColumnOrder(68)
    private Decimal fuKibetsuGaku13;
    @TempTableColumnOrder(69)
    private Decimal fuKibetsuGaku14;

    /**
     * 調定年度のgetメソッドです。
     *
     * @return 調定年度
     */
    public FlexibleYear getChoteiNendo() {
        return choteiNendo;
    }

    /**
     * 調定年度のsetメソッドです。
     *
     * @param choteiNendo 調定年度
     */
    public void setChoteiNendo(@Nonnull FlexibleYear choteiNendo) {
        this.choteiNendo = choteiNendo;
    }

    /**
     * 賦課年度のgetメソッドです。
     *
     * @return 賦課年度
     */
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * 賦課年度のsetメソッドです。
     *
     * @param fukaNendo 賦課年度
     */
    public void setFukaNendo(@Nonnull FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * 通知書番号のgetメソッドです。
     *
     * @return 通知書番号
     */
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * 通知書番号のsetメソッドです。
     *
     * @param tsuchishoNo 通知書番号
     */
    public void setTsuchishoNo(@Nonnull TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
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
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
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
     * 世帯コードのgetメソッドです。
     *
     * @return 世帯コード
     */
    @CheckForNull
    public SetaiCode getSetaiCode() {
        return setaiCode;
    }

    /**
     * 世帯コードのsetメソッドです。
     *
     * @param setaiCode 世帯コード
     */
    public void setSetaiCode(SetaiCode setaiCode) {
        this.setaiCode = setaiCode;
    }

    /**
     * 世帯員数のgetメソッドです。
     *
     * @return 世帯員数
     */
    @CheckForNull
    public int getSetaiInsu() {
        return setaiInsu;
    }

    /**
     * 世帯員数のsetメソッドです。
     *
     * @param setaiInsu 世帯員数
     */
    public void setSetaiInsu(int setaiInsu) {
        this.setaiInsu = setaiInsu;
    }

    /**
     * 資格取得日のgetメソッドです。
     *
     * @return 資格取得日
     */
    @CheckForNull
    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    /**
     * 資格取得日のsetメソッドです。
     *
     * @param shikakuShutokuYMD 資格取得日
     */
    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * 資格取得事由のgetメソッドです。
     *
     * @return 資格取得事由
     */
    @CheckForNull
    public RString getShikakuShutokuJiyu() {
        return shikakuShutokuJiyu;
    }

    /**
     * 資格取得事由のsetメソッドです。
     *
     * @param shikakuShutokuJiyu 資格取得事由
     */
    public void setShikakuShutokuJiyu(RString shikakuShutokuJiyu) {
        this.shikakuShutokuJiyu = shikakuShutokuJiyu;
    }

    /**
     * 資格喪失日のgetメソッドです。
     *
     * @return 資格喪失日
     */
    @CheckForNull
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失日のsetメソッドです。
     *
     * @param shikakuSoshitsuYMD 資格喪失日
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失事由のgetメソッドです。
     *
     * @return 資格喪失事由
     */
    @CheckForNull
    public RString getShikakuSoshitsuJiyu() {
        return shikakuSoshitsuJiyu;
    }

    /**
     * 資格喪失事由のsetメソッドです。
     *
     * @param shikakuSoshitsuJiyu 資格喪失事由
     */
    public void setShikakuSoshitsuJiyu(RString shikakuSoshitsuJiyu) {
        this.shikakuSoshitsuJiyu = shikakuSoshitsuJiyu;
    }

    /**
     * 生活保護扶助種類のgetメソッドです。
     *
     * @return 生活保護扶助種類
     */
    @CheckForNull
    public RString getSeihofujoShurui() {
        return seihofujoShurui;
    }

    /**
     * 生活保護扶助種類のsetメソッドです。
     *
     * @param seihofujoShurui 生活保護扶助種類
     */
    public void setSeihofujoShurui(RString seihofujoShurui) {
        this.seihofujoShurui = seihofujoShurui;
    }

    /**
     * 生保開始日のgetメソッドです。
     *
     * @return 生保開始日
     */
    @CheckForNull
    public FlexibleDate getSeihoKaishiYMD() {
        return seihoKaishiYMD;
    }

    /**
     * 生保開始日のsetメソッドです。
     *
     * @param seihoKaishiYMD 生保開始日
     */
    public void setSeihoKaishiYMD(FlexibleDate seihoKaishiYMD) {
        this.seihoKaishiYMD = seihoKaishiYMD;
    }

    /**
     * 生保廃止日のgetメソッドです。
     *
     * @return 生保廃止日
     */
    @CheckForNull
    public FlexibleDate getSeihoHaishiYMD() {
        return seihoHaishiYMD;
    }

    /**
     * 生保廃止日のsetメソッドです。
     *
     * @param seihoHaishiYMD 生保廃止日
     */
    public void setSeihoHaishiYMD(FlexibleDate seihoHaishiYMD) {
        this.seihoHaishiYMD = seihoHaishiYMD;
    }

    /**
     * 老年開始日のgetメソッドです。
     *
     * @return 老年開始日
     */
    @CheckForNull
    public FlexibleDate getRonenKaishiYMD() {
        return ronenKaishiYMD;
    }

    /**
     * 老年開始日のsetメソッドです。
     *
     * @param ronenKaishiYMD 老年開始日
     */
    public void setRonenKaishiYMD(FlexibleDate ronenKaishiYMD) {
        this.ronenKaishiYMD = ronenKaishiYMD;
    }

    /**
     * 老年廃止日のgetメソッドです。
     *
     * @return 老年廃止日
     */
    @CheckForNull
    public FlexibleDate getRonenHaishiYMD() {
        return ronenHaishiYMD;
    }

    /**
     * 老年廃止日のsetメソッドです。
     *
     * @param ronenHaishiYMD 老年廃止日
     */
    public void setRonenHaishiYMD(FlexibleDate ronenHaishiYMD) {
        this.ronenHaishiYMD = ronenHaishiYMD;
    }

    /**
     * 賦課期日のgetメソッドです。
     *
     * @return 賦課期日
     */
    @CheckForNull
    public FlexibleDate getFukaYMD() {
        return fukaYMD;
    }

    /**
     * 賦課期日のsetメソッドです。
     *
     * @param fukaYMD 賦課期日
     */
    public void setFukaYMD(FlexibleDate fukaYMD) {
        this.fukaYMD = fukaYMD;
    }

    /**
     * 課税区分のgetメソッドです。
     *
     * @return 課税区分
     */
    @CheckForNull
    public RString getKazeiKubun() {
        return kazeiKubun;
    }

    /**
     * 課税区分のsetメソッドです。
     *
     * @param kazeiKubun 課税区分
     */
    public void setKazeiKubun(RString kazeiKubun) {
        this.kazeiKubun = kazeiKubun;
    }

    /**
     * 世帯課税区分のgetメソッドです。
     *
     * @return 世帯課税区分
     */
    @CheckForNull
    public RString getSetaikazeiKubun() {
        return setaikazeiKubun;
    }

    /**
     * 世帯課税区分のsetメソッドです。
     *
     * @param setaikazeiKubun 世帯課税区分
     */
    public void setSetaikazeiKubun(RString setaikazeiKubun) {
        this.setaikazeiKubun = setaikazeiKubun;
    }

    /**
     * 合計所得金額のgetメソッドです。
     * <br/>
     * <br/>マイナスの場合はゼロで管理
     *
     * @return 合計所得金額
     */
    @CheckForNull
    public Decimal getGokeiShotokuGaku() {
        return gokeiShotokuGaku;
    }

    /**
     * 合計所得金額のsetメソッドです。
     * <br/>
     * <br/>マイナスの場合はゼロで管理
     *
     * @param gokeiShotokuGaku 合計所得金額
     */
    public void setGokeiShotokuGaku(Decimal gokeiShotokuGaku) {
        this.gokeiShotokuGaku = gokeiShotokuGaku;
    }

    /**
     * 公的年金収入額のgetメソッドです。
     *
     * @return 公的年金収入額
     */
    @CheckForNull
    public Decimal getNenkinShunyuGaku() {
        return nenkinShunyuGaku;
    }

    /**
     * 公的年金収入額のsetメソッドです。
     *
     * @param nenkinShunyuGaku 公的年金収入額
     */
    public void setNenkinShunyuGaku(Decimal nenkinShunyuGaku) {
        this.nenkinShunyuGaku = nenkinShunyuGaku;
    }

    /**
     * 保険料段階のgetメソッドです。
     * <br/>
     * <br/>システムで管理する保険料段階
     *
     * @return 保険料段階
     */
    @CheckForNull
    public RString getHokenryoDankai() {
        return hokenryoDankai;
    }

    /**
     * 保険料段階のsetメソッドです。
     * <br/>
     * <br/>システムで管理する保険料段階
     *
     * @param hokenryoDankai 保険料段階
     */
    public void setHokenryoDankai(RString hokenryoDankai) {
        this.hokenryoDankai = hokenryoDankai;
    }

    /**
     * 保険料算定段階1のgetメソッドです。
     * <br/>
     * <br/>内部コードで管理
     *
     * @return 保険料算定段階1
     */
    @CheckForNull
    public RString getHokenryoDankai1() {
        return hokenryoDankai1;
    }

    /**
     * 保険料算定段階1のsetメソッドです。
     * <br/>
     * <br/>内部コードで管理
     *
     * @param hokenryoDankai1 保険料算定段階1
     */
    public void setHokenryoDankai1(RString hokenryoDankai1) {
        this.hokenryoDankai1 = hokenryoDankai1;
    }

    /**
     * 算定年額保険料1のgetメソッドです。
     *
     * @return 算定年額保険料1
     */
    @CheckForNull
    public Decimal getNengakuHokenryo1() {
        return nengakuHokenryo1;
    }

    /**
     * 算定年額保険料1のsetメソッドです。
     *
     * @param nengakuHokenryo1 算定年額保険料1
     */
    public void setNengakuHokenryo1(Decimal nengakuHokenryo1) {
        this.nengakuHokenryo1 = nengakuHokenryo1;
    }

    /**
     * 月割開始年月1のgetメソッドです。
     *
     * @return 月割開始年月1
     */
    @CheckForNull
    public FlexibleYearMonth getTsukiwariStartYM1() {
        return tsukiwariStartYM1;
    }

    /**
     * 月割開始年月1のsetメソッドです。
     *
     * @param tsukiwariStartYM1 月割開始年月1
     */
    public void setTsukiwariStartYM1(FlexibleYearMonth tsukiwariStartYM1) {
        this.tsukiwariStartYM1 = tsukiwariStartYM1;
    }

    /**
     * 月割終了年月1のgetメソッドです。
     *
     * @return 月割終了年月1
     */
    @CheckForNull
    public FlexibleYearMonth getTsukiwariEndYM1() {
        return tsukiwariEndYM1;
    }

    /**
     * 月割終了年月1のsetメソッドです。
     *
     * @param tsukiwariEndYM1 月割終了年月1
     */
    public void setTsukiwariEndYM1(FlexibleYearMonth tsukiwariEndYM1) {
        this.tsukiwariEndYM1 = tsukiwariEndYM1;
    }

    /**
     * 保険料算定段階2のgetメソッドです。
     * <br/>
     * <br/>内部コードで管理
     *
     * @return 保険料算定段階2
     */
    @CheckForNull
    public RString getHokenryoDankai2() {
        return hokenryoDankai2;
    }

    /**
     * 保険料算定段階2のsetメソッドです。
     * <br/>
     * <br/>内部コードで管理
     *
     * @param hokenryoDankai2 保険料算定段階2
     */
    public void setHokenryoDankai2(RString hokenryoDankai2) {
        this.hokenryoDankai2 = hokenryoDankai2;
    }

    /**
     * 算定年額保険料2のgetメソッドです。
     *
     * @return 算定年額保険料2
     */
    @CheckForNull
    public Decimal getNengakuHokenryo2() {
        return nengakuHokenryo2;
    }

    /**
     * 算定年額保険料2のsetメソッドです。
     *
     * @param nengakuHokenryo2 算定年額保険料2
     */
    public void setNengakuHokenryo2(Decimal nengakuHokenryo2) {
        this.nengakuHokenryo2 = nengakuHokenryo2;
    }

    /**
     * 月割開始年月2のgetメソッドです。
     *
     * @return 月割開始年月2
     */
    @CheckForNull
    public FlexibleYearMonth getTsukiwariStartYM2() {
        return tsukiwariStartYM2;
    }

    /**
     * 月割開始年月2のsetメソッドです。
     *
     * @param tsukiwariStartYM2 月割開始年月2
     */
    public void setTsukiwariStartYM2(FlexibleYearMonth tsukiwariStartYM2) {
        this.tsukiwariStartYM2 = tsukiwariStartYM2;
    }

    /**
     * 月割終了年月2のgetメソッドです。
     *
     * @return 月割終了年月2
     */
    @CheckForNull
    public FlexibleYearMonth getTsukiwariEndYM2() {
        return tsukiwariEndYM2;
    }

    /**
     * 月割終了年月2のsetメソッドです。
     *
     * @param tsukiwariEndYM2 月割終了年月2
     */
    public void setTsukiwariEndYM2(FlexibleYearMonth tsukiwariEndYM2) {
        this.tsukiwariEndYM2 = tsukiwariEndYM2;
    }

    /**
     * 調定日時のgetメソッドです。
     *
     * @return 調定日時
     */
    @CheckForNull
    public YMDHMS getChoteiNichiji() {
        return choteiNichiji;
    }

    /**
     * 調定日時のsetメソッドです。
     *
     * @param choteiNichiji 調定日時
     */
    public void setChoteiNichiji(YMDHMS choteiNichiji) {
        this.choteiNichiji = choteiNichiji;
    }

    /**
     * 調定事由1のgetメソッドです。
     *
     * @return 調定事由1
     */
    @CheckForNull
    public RString getChoteiJiyu1() {
        return choteiJiyu1;
    }

    /**
     * 調定事由1のsetメソッドです。
     *
     * @param choteiJiyu1 調定事由1
     */
    public void setChoteiJiyu1(RString choteiJiyu1) {
        this.choteiJiyu1 = choteiJiyu1;
    }

    /**
     * 調定事由2のgetメソッドです。
     *
     * @return 調定事由2
     */
    @CheckForNull
    public RString getChoteiJiyu2() {
        return choteiJiyu2;
    }

    /**
     * 調定事由2のsetメソッドです。
     *
     * @param choteiJiyu2 調定事由2
     */
    public void setChoteiJiyu2(RString choteiJiyu2) {
        this.choteiJiyu2 = choteiJiyu2;
    }

    /**
     * 調定事由3のgetメソッドです。
     *
     * @return 調定事由3
     */
    @CheckForNull
    public RString getChoteiJiyu3() {
        return choteiJiyu3;
    }

    /**
     * 調定事由3のsetメソッドです。
     *
     * @param choteiJiyu3 調定事由3
     */
    public void setChoteiJiyu3(RString choteiJiyu3) {
        this.choteiJiyu3 = choteiJiyu3;
    }

    /**
     * 調定事由4のgetメソッドです。
     *
     * @return 調定事由4
     */
    @CheckForNull
    public RString getChoteiJiyu4() {
        return choteiJiyu4;
    }

    /**
     * 調定事由4のsetメソッドです。
     *
     * @param choteiJiyu4 調定事由4
     */
    public void setChoteiJiyu4(RString choteiJiyu4) {
        this.choteiJiyu4 = choteiJiyu4;
    }

    /**
     * 更正月のgetメソッドです。
     *
     * @return 更正月
     */
    @CheckForNull
    public RString getKoseiM() {
        return koseiM;
    }

    /**
     * 更正月のsetメソッドです。
     *
     * @param koseiM 更正月
     */
    public void setKoseiM(RString koseiM) {
        this.koseiM = koseiM;
    }

    /**
     * 減免前介護保険料（年額）のgetメソッドです。
     *
     * @return 減免前介護保険料（年額）
     */
    @CheckForNull
    public Decimal getGemmenMaeHokenryo() {
        return gemmenMaeHokenryo;
    }

    /**
     * 減免前介護保険料（年額）のsetメソッドです。
     *
     * @param gemmenMaeHokenryo 減免前介護保険料（年額）
     */
    public void setGemmenMaeHokenryo(Decimal gemmenMaeHokenryo) {
        this.gemmenMaeHokenryo = gemmenMaeHokenryo;
    }

    /**
     * 減免額のgetメソッドです。
     *
     * @return 減免額
     */
    @CheckForNull
    public Decimal getGemmenGaku() {
        return gemmenGaku;
    }

    /**
     * 減免額のsetメソッドです。
     *
     * @param gemmenGaku 減免額
     */
    public void setGemmenGaku(Decimal gemmenGaku) {
        this.gemmenGaku = gemmenGaku;
    }

    /**
     * 確定介護保険料（年額）のgetメソッドです。
     *
     * @return 確定介護保険料（年額）
     */
    @CheckForNull
    public Decimal getKakuteiHokenryo() {
        return kakuteiHokenryo;
    }

    /**
     * 確定介護保険料（年額）のsetメソッドです。
     *
     * @param kakuteiHokenryo 確定介護保険料（年額）
     */
    public void setKakuteiHokenryo(Decimal kakuteiHokenryo) {
        this.kakuteiHokenryo = kakuteiHokenryo;
    }

    /**
     * 保険料段階（仮算定時）のgetメソッドです。
     * <br/>
     * <br/>内部コードで管理
     *
     * @return 保険料段階（仮算定時）
     */
    @CheckForNull
    public RString getHokenryoDankaiKarisanntei() {
        return hokenryoDankaiKarisanntei;
    }

    /**
     * 保険料段階（仮算定時）のsetメソッドです。
     * <br/>
     * <br/>内部コードで管理
     *
     * @param hokenryoDankaiKarisanntei 保険料段階（仮算定時）
     */
    public void setHokenryoDankaiKarisanntei(RString hokenryoDankaiKarisanntei) {
        this.hokenryoDankaiKarisanntei = hokenryoDankaiKarisanntei;
    }

    /**
     * 徴収方法履歴番号のgetメソッドです。
     *
     * @return 徴収方法履歴番号
     */
    @CheckForNull
    public int getChoshuHohoRirekiNo() {
        return choshuHohoRirekiNo;
    }

    /**
     * 徴収方法履歴番号のsetメソッドです。
     *
     * @param choshuHohoRirekiNo 徴収方法履歴番号
     */
    public void setChoshuHohoRirekiNo(int choshuHohoRirekiNo) {
        this.choshuHohoRirekiNo = choshuHohoRirekiNo;
    }

    /**
     * 異動基準日時のgetメソッドです。
     *
     * @return 異動基準日時
     */
    public YMDHMS getIdoKijunNichiji() {
        return idoKijunNichiji;
    }

    /**
     * 異動基準日時のsetメソッドです。
     *
     * @param idoKijunNichiji 異動基準日時
     */
    public void setIdoKijunNichiji(@Nonnull YMDHMS idoKijunNichiji) {
        this.idoKijunNichiji = idoKijunNichiji;
    }

    /**
     * 口座区分のgetメソッドです。
     * <br/>
     * <br/>1：口座振替　0:現金納付
     *
     * @return 口座区分
     */
    @CheckForNull
    public RString getKozaKubun() {
        return kozaKubun;
    }

    /**
     * 口座区分のsetメソッドです。
     * <br/>
     * <br/>1：口座振替　0:現金納付
     *
     * @param kozaKubun 口座区分
     */
    public void setKozaKubun(RString kozaKubun) {
        this.kozaKubun = kozaKubun;
    }

    /**
     * 境界層区分のgetメソッドです。
     * <br/>
     * <br/>1：該当　0:非該当
     *
     * @return 境界層区分
     */
    @CheckForNull
    public RString getKyokaisoKubun() {
        return kyokaisoKubun;
    }

    /**
     * 境界層区分のsetメソッドです。
     * <br/>
     * <br/>1：該当　0:非該当
     *
     * @param kyokaisoKubun 境界層区分
     */
    public void setKyokaisoKubun(RString kyokaisoKubun) {
        this.kyokaisoKubun = kyokaisoKubun;
    }

    /**
     * 職権区分のgetメソッドです。
     * <br/>
     * <br/>1：該当　0:非該当
     *
     * @return 職権区分
     */
    @CheckForNull
    public RString getShokkenKubun() {
        return shokkenKubun;
    }

    /**
     * 職権区分のsetメソッドです。
     * <br/>
     * <br/>1：該当　0:非該当
     *
     * @param shokkenKubun 職権区分
     */
    public void setShokkenKubun(RString shokkenKubun) {
        this.shokkenKubun = shokkenKubun;
    }

    /**
     * 賦課市町村コードのgetメソッドです。
     *
     * @return 賦課市町村コード
     */
    @CheckForNull
    public LasdecCode getFukaShichosonCode() {
        return fukaShichosonCode;
    }

    /**
     * 賦課市町村コードのsetメソッドです。
     *
     * @param fukaShichosonCode 賦課市町村コード
     */
    public void setFukaShichosonCode(LasdecCode fukaShichosonCode) {
        this.fukaShichosonCode = fukaShichosonCode;
    }

    /**
     * 特徴歳出還付額のgetメソッドです。
     *
     * @return 特徴歳出還付額
     */
    @CheckForNull
    public Decimal getTkSaishutsuKampuGaku() {
        return tkSaishutsuKampuGaku;
    }

    /**
     * 特徴歳出還付額のsetメソッドです。
     *
     * @param tkSaishutsuKampuGaku 特徴歳出還付額
     */
    public void setTkSaishutsuKampuGaku(Decimal tkSaishutsuKampuGaku) {
        this.tkSaishutsuKampuGaku = tkSaishutsuKampuGaku;
    }

    /**
     * 普徴歳出還付額のgetメソッドです。
     *
     * @return 普徴歳出還付額
     */
    @CheckForNull
    public Decimal getFuSaishutsuKampuGaku() {
        return fuSaishutsuKampuGaku;
    }

    /**
     * 普徴歳出還付額のsetメソッドです。
     *
     * @param fuSaishutsuKampuGaku 普徴歳出還付額
     */
    public void setFuSaishutsuKampuGaku(Decimal fuSaishutsuKampuGaku) {
        this.fuSaishutsuKampuGaku = fuSaishutsuKampuGaku;
    }

    /**
     * 特徴期別金額01のgetメソッドです。
     *
     * @return 特徴期別金額01
     */
    @CheckForNull
    public Decimal getTkKibetsuGaku01() {
        return tkKibetsuGaku01;
    }

    /**
     * 特徴期別金額01のsetメソッドです。
     *
     * @param tkKibetsuGaku01 特徴期別金額01
     */
    public void setTkKibetsuGaku01(Decimal tkKibetsuGaku01) {
        this.tkKibetsuGaku01 = tkKibetsuGaku01;
    }

    /**
     * 特徴期別金額02のgetメソッドです。
     *
     * @return 特徴期別金額02
     */
    @CheckForNull
    public Decimal getTkKibetsuGaku02() {
        return tkKibetsuGaku02;
    }

    /**
     * 特徴期別金額02のsetメソッドです。
     *
     * @param tkKibetsuGaku02 特徴期別金額02
     */
    public void setTkKibetsuGaku02(Decimal tkKibetsuGaku02) {
        this.tkKibetsuGaku02 = tkKibetsuGaku02;
    }

    /**
     * 特徴期別金額03のgetメソッドです。
     *
     * @return 特徴期別金額03
     */
    @CheckForNull
    public Decimal getTkKibetsuGaku03() {
        return tkKibetsuGaku03;
    }

    /**
     * 特徴期別金額03のsetメソッドです。
     *
     * @param tkKibetsuGaku03 特徴期別金額03
     */
    public void setTkKibetsuGaku03(Decimal tkKibetsuGaku03) {
        this.tkKibetsuGaku03 = tkKibetsuGaku03;
    }

    /**
     * 特徴期別金額04のgetメソッドです。
     *
     * @return 特徴期別金額04
     */
    @CheckForNull
    public Decimal getTkKibetsuGaku04() {
        return tkKibetsuGaku04;
    }

    /**
     * 特徴期別金額04のsetメソッドです。
     *
     * @param tkKibetsuGaku04 特徴期別金額04
     */
    public void setTkKibetsuGaku04(Decimal tkKibetsuGaku04) {
        this.tkKibetsuGaku04 = tkKibetsuGaku04;
    }

    /**
     * 特徴期別金額05のgetメソッドです。
     *
     * @return 特徴期別金額05
     */
    @CheckForNull
    public Decimal getTkKibetsuGaku05() {
        return tkKibetsuGaku05;
    }

    /**
     * 特徴期別金額05のsetメソッドです。
     *
     * @param tkKibetsuGaku05 特徴期別金額05
     */
    public void setTkKibetsuGaku05(Decimal tkKibetsuGaku05) {
        this.tkKibetsuGaku05 = tkKibetsuGaku05;
    }

    /**
     * 特徴期別金額06のgetメソッドです。
     *
     * @return 特徴期別金額06
     */
    @CheckForNull
    public Decimal getTkKibetsuGaku06() {
        return tkKibetsuGaku06;
    }

    /**
     * 特徴期別金額06のsetメソッドです。
     *
     * @param tkKibetsuGaku06 特徴期別金額06
     */
    public void setTkKibetsuGaku06(Decimal tkKibetsuGaku06) {
        this.tkKibetsuGaku06 = tkKibetsuGaku06;
    }

    /**
     * 普徴期別金額01のgetメソッドです。
     *
     * @return 普徴期別金額01
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku01() {
        return fuKibetsuGaku01;
    }

    /**
     * 普徴期別金額01のsetメソッドです。
     *
     * @param fuKibetsuGaku01 普徴期別金額01
     */
    public void setFuKibetsuGaku01(Decimal fuKibetsuGaku01) {
        this.fuKibetsuGaku01 = fuKibetsuGaku01;
    }

    /**
     * 普徴期別金額02のgetメソッドです。
     *
     * @return 普徴期別金額02
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku02() {
        return fuKibetsuGaku02;
    }

    /**
     * 普徴期別金額02のsetメソッドです。
     *
     * @param fuKibetsuGaku02 普徴期別金額02
     */
    public void setFuKibetsuGaku02(Decimal fuKibetsuGaku02) {
        this.fuKibetsuGaku02 = fuKibetsuGaku02;
    }

    /**
     * 普徴期別金額03のgetメソッドです。
     *
     * @return 普徴期別金額03
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku03() {
        return fuKibetsuGaku03;
    }

    /**
     * 普徴期別金額03のsetメソッドです。
     *
     * @param fuKibetsuGaku03 普徴期別金額03
     */
    public void setFuKibetsuGaku03(Decimal fuKibetsuGaku03) {
        this.fuKibetsuGaku03 = fuKibetsuGaku03;
    }

    /**
     * 普徴期別金額04のgetメソッドです。
     *
     * @return 普徴期別金額04
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku04() {
        return fuKibetsuGaku04;
    }

    /**
     * 普徴期別金額04のsetメソッドです。
     *
     * @param fuKibetsuGaku04 普徴期別金額04
     */
    public void setFuKibetsuGaku04(Decimal fuKibetsuGaku04) {
        this.fuKibetsuGaku04 = fuKibetsuGaku04;
    }

    /**
     * 普徴期別金額05のgetメソッドです。
     *
     * @return 普徴期別金額05
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku05() {
        return fuKibetsuGaku05;
    }

    /**
     * 普徴期別金額05のsetメソッドです。
     *
     * @param fuKibetsuGaku05 普徴期別金額05
     */
    public void setFuKibetsuGaku05(Decimal fuKibetsuGaku05) {
        this.fuKibetsuGaku05 = fuKibetsuGaku05;
    }

    /**
     * 普徴期別金額06のgetメソッドです。
     *
     * @return 普徴期別金額06
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku06() {
        return fuKibetsuGaku06;
    }

    /**
     * 普徴期別金額06のsetメソッドです。
     *
     * @param fuKibetsuGaku06 普徴期別金額06
     */
    public void setFuKibetsuGaku06(Decimal fuKibetsuGaku06) {
        this.fuKibetsuGaku06 = fuKibetsuGaku06;
    }

    /**
     * 普徴期別金額07のgetメソッドです。
     *
     * @return 普徴期別金額07
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku07() {
        return fuKibetsuGaku07;
    }

    /**
     * 普徴期別金額07のsetメソッドです。
     *
     * @param fuKibetsuGaku07 普徴期別金額07
     */
    public void setFuKibetsuGaku07(Decimal fuKibetsuGaku07) {
        this.fuKibetsuGaku07 = fuKibetsuGaku07;
    }

    /**
     * 普徴期別金額08のgetメソッドです。
     *
     * @return 普徴期別金額08
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku08() {
        return fuKibetsuGaku08;
    }

    /**
     * 普徴期別金額08のsetメソッドです。
     *
     * @param fuKibetsuGaku08 普徴期別金額08
     */
    public void setFuKibetsuGaku08(Decimal fuKibetsuGaku08) {
        this.fuKibetsuGaku08 = fuKibetsuGaku08;
    }

    /**
     * 普徴期別金額09のgetメソッドです。
     *
     * @return 普徴期別金額09
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku09() {
        return fuKibetsuGaku09;
    }

    /**
     * 普徴期別金額09のsetメソッドです。
     *
     * @param fuKibetsuGaku09 普徴期別金額09
     */
    public void setFuKibetsuGaku09(Decimal fuKibetsuGaku09) {
        this.fuKibetsuGaku09 = fuKibetsuGaku09;
    }

    /**
     * 普徴期別金額10のgetメソッドです。
     *
     * @return 普徴期別金額10
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku10() {
        return fuKibetsuGaku10;
    }

    /**
     * 普徴期別金額10のsetメソッドです。
     *
     * @param fuKibetsuGaku10 普徴期別金額10
     */
    public void setFuKibetsuGaku10(Decimal fuKibetsuGaku10) {
        this.fuKibetsuGaku10 = fuKibetsuGaku10;
    }

    /**
     * 普徴期別金額11のgetメソッドです。
     *
     * @return 普徴期別金額11
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku11() {
        return fuKibetsuGaku11;
    }

    /**
     * 普徴期別金額11のsetメソッドです。
     *
     * @param fuKibetsuGaku11 普徴期別金額11
     */
    public void setFuKibetsuGaku11(Decimal fuKibetsuGaku11) {
        this.fuKibetsuGaku11 = fuKibetsuGaku11;
    }

    /**
     * 普徴期別金額12のgetメソッドです。
     *
     * @return 普徴期別金額12
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku12() {
        return fuKibetsuGaku12;
    }

    /**
     * 普徴期別金額12のsetメソッドです。
     *
     * @param fuKibetsuGaku12 普徴期別金額12
     */
    public void setFuKibetsuGaku12(Decimal fuKibetsuGaku12) {
        this.fuKibetsuGaku12 = fuKibetsuGaku12;
    }

    /**
     * 普徴期別金額13のgetメソッドです。
     *
     * @return 普徴期別金額13
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku13() {
        return fuKibetsuGaku13;
    }

    /**
     * 普徴期別金額13のsetメソッドです。
     *
     * @param fuKibetsuGaku13 普徴期別金額13
     */
    public void setFuKibetsuGaku13(Decimal fuKibetsuGaku13) {
        this.fuKibetsuGaku13 = fuKibetsuGaku13;
    }

    /**
     * 普徴期別金額14のgetメソッドです。
     *
     * @return 普徴期別金額14
     */
    @CheckForNull
    public Decimal getFuKibetsuGaku14() {
        return fuKibetsuGaku14;
    }

    /**
     * 普徴期別金額14のsetメソッドです。
     *
     * @param fuKibetsuGaku14 普徴期別金額14
     */
    public void setFuKibetsuGaku14(Decimal fuKibetsuGaku14) {
        this.fuKibetsuGaku14 = fuKibetsuGaku14;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(DbT2002FukaJohoTempTableEntity entity) {
        this.choteiNendo = entity.choteiNendo;
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.setaiCode = entity.setaiCode;
        this.setaiInsu = entity.setaiInsu;
        this.shikakuShutokuYMD = entity.shikakuShutokuYMD;
        this.shikakuShutokuJiyu = entity.shikakuShutokuJiyu;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.shikakuSoshitsuJiyu = entity.shikakuSoshitsuJiyu;
        this.seihofujoShurui = entity.seihofujoShurui;
        this.seihoKaishiYMD = entity.seihoKaishiYMD;
        this.seihoHaishiYMD = entity.seihoHaishiYMD;
        this.ronenKaishiYMD = entity.ronenKaishiYMD;
        this.ronenHaishiYMD = entity.ronenHaishiYMD;
        this.fukaYMD = entity.fukaYMD;
        this.kazeiKubun = entity.kazeiKubun;
        this.setaikazeiKubun = entity.setaikazeiKubun;
        this.gokeiShotokuGaku = entity.gokeiShotokuGaku;
        this.nenkinShunyuGaku = entity.nenkinShunyuGaku;
        this.hokenryoDankai = entity.hokenryoDankai;
        this.hokenryoDankai1 = entity.hokenryoDankai1;
        this.nengakuHokenryo1 = entity.nengakuHokenryo1;
        this.tsukiwariStartYM1 = entity.tsukiwariStartYM1;
        this.tsukiwariEndYM1 = entity.tsukiwariEndYM1;
        this.hokenryoDankai2 = entity.hokenryoDankai2;
        this.nengakuHokenryo2 = entity.nengakuHokenryo2;
        this.tsukiwariStartYM2 = entity.tsukiwariStartYM2;
        this.tsukiwariEndYM2 = entity.tsukiwariEndYM2;
        this.choteiNichiji = entity.choteiNichiji;
        this.choteiJiyu1 = entity.choteiJiyu1;
        this.choteiJiyu2 = entity.choteiJiyu2;
        this.choteiJiyu3 = entity.choteiJiyu3;
        this.choteiJiyu4 = entity.choteiJiyu4;
        this.koseiM = entity.koseiM;
        this.gemmenMaeHokenryo = entity.gemmenMaeHokenryo;
        this.gemmenGaku = entity.gemmenGaku;
        this.kakuteiHokenryo = entity.kakuteiHokenryo;
        this.hokenryoDankaiKarisanntei = entity.hokenryoDankaiKarisanntei;
        this.choshuHohoRirekiNo = entity.choshuHohoRirekiNo;
        this.idoKijunNichiji = entity.idoKijunNichiji;
        this.kozaKubun = entity.kozaKubun;
        this.kyokaisoKubun = entity.kyokaisoKubun;
        this.shokkenKubun = entity.shokkenKubun;
        this.fukaShichosonCode = entity.fukaShichosonCode;
        this.tkSaishutsuKampuGaku = entity.tkSaishutsuKampuGaku;
        this.fuSaishutsuKampuGaku = entity.fuSaishutsuKampuGaku;
        this.tkKibetsuGaku01 = entity.tkKibetsuGaku01;
        this.tkKibetsuGaku02 = entity.tkKibetsuGaku02;
        this.tkKibetsuGaku03 = entity.tkKibetsuGaku03;
        this.tkKibetsuGaku04 = entity.tkKibetsuGaku04;
        this.tkKibetsuGaku05 = entity.tkKibetsuGaku05;
        this.tkKibetsuGaku06 = entity.tkKibetsuGaku06;
        this.fuKibetsuGaku01 = entity.fuKibetsuGaku01;
        this.fuKibetsuGaku02 = entity.fuKibetsuGaku02;
        this.fuKibetsuGaku03 = entity.fuKibetsuGaku03;
        this.fuKibetsuGaku04 = entity.fuKibetsuGaku04;
        this.fuKibetsuGaku05 = entity.fuKibetsuGaku05;
        this.fuKibetsuGaku06 = entity.fuKibetsuGaku06;
        this.fuKibetsuGaku07 = entity.fuKibetsuGaku07;
        this.fuKibetsuGaku08 = entity.fuKibetsuGaku08;
        this.fuKibetsuGaku09 = entity.fuKibetsuGaku09;
        this.fuKibetsuGaku10 = entity.fuKibetsuGaku10;
        this.fuKibetsuGaku11 = entity.fuKibetsuGaku11;
        this.fuKibetsuGaku12 = entity.fuKibetsuGaku12;
        this.fuKibetsuGaku13 = entity.fuKibetsuGaku13;
        this.fuKibetsuGaku14 = entity.fuKibetsuGaku14;

    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiNendo, fukaNendo, tsuchishoNo, hihokenshaNo, shikibetsuCode, setaiCode,
                setaiInsu, shikakuShutokuYMD, shikakuShutokuJiyu, shikakuSoshitsuYMD, shikakuSoshitsuJiyu,
                seihofujoShurui, seihoKaishiYMD, seihoHaishiYMD, ronenKaishiYMD, ronenHaishiYMD, fukaYMD,
                kazeiKubun, setaikazeiKubun, gokeiShotokuGaku, nenkinShunyuGaku, hokenryoDankai, hokenryoDankai1,
                nengakuHokenryo1, tsukiwariStartYM1, tsukiwariEndYM1, hokenryoDankai2, nengakuHokenryo2, tsukiwariStartYM2,
                tsukiwariEndYM2, choteiNichiji, choteiJiyu1, choteiJiyu2, choteiJiyu3, choteiJiyu4, koseiM, gemmenMaeHokenryo,
                gemmenGaku, kakuteiHokenryo, hokenryoDankaiKarisanntei, choshuHohoRirekiNo, idoKijunNichiji, kozaKubun,
                kyokaisoKubun, shokkenKubun, fukaShichosonCode, tkSaishutsuKampuGaku, fuSaishutsuKampuGaku, tkKibetsuGaku01,
                tkKibetsuGaku02, tkKibetsuGaku03, tkKibetsuGaku04, tkKibetsuGaku05, tkKibetsuGaku06, fuKibetsuGaku01,
                fuKibetsuGaku02, fuKibetsuGaku03, fuKibetsuGaku04, fuKibetsuGaku05, fuKibetsuGaku06, fuKibetsuGaku07,
                fuKibetsuGaku08, fuKibetsuGaku09, fuKibetsuGaku10, fuKibetsuGaku11, fuKibetsuGaku12, fuKibetsuGaku13, fuKibetsuGaku14);
    }

// </editor-fold>
}

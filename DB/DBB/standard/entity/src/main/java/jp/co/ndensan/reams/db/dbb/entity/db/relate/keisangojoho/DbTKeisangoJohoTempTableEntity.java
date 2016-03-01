package jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho;

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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * DbTKeisangoJohoTempTableEntity項目定義クラスです。
 *
 */
@OnNextSchema("rgdb")
public class DbTKeisangoJohoTempTableEntity extends DbTableEntityBase<DbTKeisangoJohoTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2015KeisangoJohoTemp");

    @TempTableColumnOrder(1)
    private FlexibleYear choteiNendo;
    @TempTableColumnOrder(2)
    private FlexibleYear fukaNendo;
    @TempTableColumnOrder(3)
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(4)
    private RString koseiZengoKubun;
    @TempTableColumnOrder(5)
    private RString sakuseiShoriName;
    @TempTableColumnOrder(6)
    private int fukaRirekiNo;
    @TempTableColumnOrder(7)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(8)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(9)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(10)
    private int setaiInsu;
    @TempTableColumnOrder(11)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(12)
    private RString shikakuShutokuJiyu;
    @TempTableColumnOrder(13)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(14)
    private RString shikakuSoshitsuJiyu;
    @TempTableColumnOrder(15)
    private RString seihofujoShurui;
    @TempTableColumnOrder(16)
    private FlexibleDate seihoKaishiYMD;
    @TempTableColumnOrder(17)
    private FlexibleDate seihoHaishiYMD;
    @TempTableColumnOrder(18)
    private FlexibleDate ronenKaishiYMD;
    @TempTableColumnOrder(19)
    private FlexibleDate ronenHaishiYMD;
    @TempTableColumnOrder(20)
    private FlexibleDate fukaYMD;
    @TempTableColumnOrder(21)
    private RString kazeiKubun;
    @TempTableColumnOrder(22)
    private RString setaikazeiKubun;
    @TempTableColumnOrder(23)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(24)
    private Decimal nenkinShunyuGaku;
    @TempTableColumnOrder(25)
    private RString hokenryoDankai;
    @TempTableColumnOrder(26)
    private RString hokenryoDankai1;
    @TempTableColumnOrder(27)
    private Decimal nengakuHokenryo1;
    @TempTableColumnOrder(28)
    private FlexibleDate tsukiwariStartYM1;
    @TempTableColumnOrder(29)
    private FlexibleDate tsukiwariEndYM1;
    @TempTableColumnOrder(30)
    private RString hokenryoDankai2;
    @TempTableColumnOrder(31)
    private Decimal nengakuHokenryo2;
    @TempTableColumnOrder(32)
    private FlexibleDate tsukiwariStartYM2;
    @TempTableColumnOrder(33)
    private FlexibleDate tsukiwariEndYM2;
    @TempTableColumnOrder(34)
    private YMDHMS choteiNichiji;
    @TempTableColumnOrder(35)
    private RString choteiJiyu1;
    @TempTableColumnOrder(36)
    private RString choteiJiyu2;
    @TempTableColumnOrder(37)
    private RString choteiJiyu3;
    @TempTableColumnOrder(38)
    private RString choteiJiyu4;
    @TempTableColumnOrder(39)
    private RString koseiM;
    @TempTableColumnOrder(40)
    private Decimal gemmenMaeHokenryo;
    @TempTableColumnOrder(41)
    private Decimal gemmenGaku;
    @TempTableColumnOrder(42)
    private Decimal kakuteiHokenryo;
    @TempTableColumnOrder(43)
    private RString hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(44)
    private int choshuHohoRirekiNo;
    @TempTableColumnOrder(45)
    private YMDHMS idoKijunNichiji;
    @TempTableColumnOrder(46)
    private RString kozaKubun;
    @TempTableColumnOrder(47)
    private RString kyokaisoKubun;
    @TempTableColumnOrder(48)
    private RString shokkenKubun;
    @TempTableColumnOrder(49)
    private LasdecCode fukaShichosonCode;
    @TempTableColumnOrder(50)
    private Decimal tkSaishutsuKampuGaku;
    @TempTableColumnOrder(51)
    private Decimal fuSaishutsuKampuGaku;
    @TempTableColumnOrder(52)
    private Decimal tkKibetsuGaku01;
    @TempTableColumnOrder(53)
    private Decimal tkKibetsuGaku02;
    @TempTableColumnOrder(54)
    private Decimal tkKibetsuGaku03;
    @TempTableColumnOrder(55)
    private Decimal tkKibetsuGaku04;
    @TempTableColumnOrder(56)
    private Decimal tkKibetsuGaku05;
    @TempTableColumnOrder(57)
    private Decimal tkKibetsuGaku06;
    @TempTableColumnOrder(58)
    private Decimal fuKibetsuGaku01;
    @TempTableColumnOrder(59)
    private Decimal fuKibetsuGaku02;
    @TempTableColumnOrder(60)
    private Decimal fuKibetsuGaku03;
    @TempTableColumnOrder(61)
    private Decimal fuKibetsuGaku04;
    @TempTableColumnOrder(62)
    private Decimal fuKibetsuGaku05;
    @TempTableColumnOrder(63)
    private Decimal fuKibetsuGaku06;
    @TempTableColumnOrder(64)
    private Decimal fuKibetsuGaku07;
    @TempTableColumnOrder(65)
    private Decimal fuKibetsuGaku08;
    @TempTableColumnOrder(66)
    private Decimal fuKibetsuGaku09;
    @TempTableColumnOrder(67)
    private Decimal fuKibetsuGaku10;
    @TempTableColumnOrder(68)
    private Decimal fuKibetsuGaku11;
    @TempTableColumnOrder(69)
    private Decimal fuKibetsuGaku12;
    @TempTableColumnOrder(70)
    private Decimal fuKibetsuGaku13;
    @TempTableColumnOrder(71)
    private Decimal fuKibetsuGaku14;
    @TempTableColumnOrder(72)
    private RString choshuHoho4gatsu;
    @TempTableColumnOrder(73)
    private RString choshuHoho5gatsu;
    @TempTableColumnOrder(74)
    private RString choshuHoho6gatsu;
    @TempTableColumnOrder(75)
    private RString choshuHoho7gatsu;
    @TempTableColumnOrder(76)
    private RString choshuHoho8gatsu;
    @TempTableColumnOrder(77)
    private RString choshuHoho9gatsu;
    @TempTableColumnOrder(78)
    private RString choshuHoho10gatsu;
    @TempTableColumnOrder(79)
    private RString choshuHoho11gatsu;
    @TempTableColumnOrder(80)
    private RString choshuHoho12gatsu;
    @TempTableColumnOrder(81)
    private RString choshuHoho1gatsu;
    @TempTableColumnOrder(82)
    private RString choshuHoho2gatsu;
    @TempTableColumnOrder(83)
    private RString choshuHoho3gatsu;
    @TempTableColumnOrder(84)
    private RString choshuHohoYoku4gatsu;
    @TempTableColumnOrder(85)
    private RString choshuHohoYoku5gatsu;
    @TempTableColumnOrder(86)
    private RString choshuHohoYoku6gatsu;
    @TempTableColumnOrder(87)
    private RString choshuHohoYoku7gatsu;
    @TempTableColumnOrder(88)
    private RString choshuHohoYoku8gatsu;
    @TempTableColumnOrder(89)
    private RString choshuHohoYoku9gatsu;
    @TempTableColumnOrder(90)
    private RString kariNenkinNo;
    @TempTableColumnOrder(91)
    private RString kariNenkinCode;
    @TempTableColumnOrder(92)
    private RString kariHosokuM;
    @TempTableColumnOrder(93)
    private RString honNenkinNo;
    @TempTableColumnOrder(94)
    private RString honNenkinCode;
    @TempTableColumnOrder(95)
    private RString honHosokuM;
    @TempTableColumnOrder(96)
    private RString yokunendoKariNenkinNo;
    @TempTableColumnOrder(97)
    private RString yokunendoKariNenkinCode;
    @TempTableColumnOrder(98)
    private RString yokunendoKariHosokuM;
    @TempTableColumnOrder(99)
    private boolean iraiSohuzumiFlag;
    @TempTableColumnOrder(100)
    private boolean tsuikaIraiSohuzumiFlag;
    @TempTableColumnOrder(101)
    private YMDHMS tokuchoTeishiNichiji;
    @TempTableColumnOrder(102)
    private RString tokuchoTeishiJiyuCode;
    @TempTableColumnOrder(103)
    private Decimal tkShunyuGaku01;
    @TempTableColumnOrder(104)
    private Decimal tkShunyuGaku02;
    @TempTableColumnOrder(105)
    private Decimal tkShunyuGaku03;
    @TempTableColumnOrder(106)
    private Decimal tkShunyuGaku04;
    @TempTableColumnOrder(107)
    private Decimal tkShunyuGaku05;
    @TempTableColumnOrder(108)
    private Decimal tkShunyuGaku06;
    @TempTableColumnOrder(109)
    private Decimal fuShunyuGaku01;
    @TempTableColumnOrder(110)
    private Decimal fuShunyuGaku02;
    @TempTableColumnOrder(111)
    private Decimal fuShunyuGaku03;
    @TempTableColumnOrder(112)
    private Decimal fuShunyuGaku04;
    @TempTableColumnOrder(113)
    private Decimal fuShunyuGaku05;
    @TempTableColumnOrder(114)
    private Decimal fuShunyuGaku06;
    @TempTableColumnOrder(115)
    private Decimal fuShunyuGaku07;
    @TempTableColumnOrder(116)
    private Decimal fuShunyuGaku08;
    @TempTableColumnOrder(117)
    private Decimal fuShunyuGaku09;
    @TempTableColumnOrder(118)
    private Decimal fuShunyuGaku10;
    @TempTableColumnOrder(119)
    private Decimal fuShunyuGaku11;
    @TempTableColumnOrder(120)
    private Decimal fuShunyuGaku12;
    @TempTableColumnOrder(121)
    private Decimal fuShunyuGaku13;
    @TempTableColumnOrder(122)
    private Decimal fuShunyuGaku14;

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
     * 更正前後区分のgetメソッドです。
     * <br/>
     * <br/>1：更正前、2：更正後
     *
     * @return 更正前後区分
     */
    public RString getKoseiZengoKubun() {
        return koseiZengoKubun;
    }

    /**
     * 更正前後区分のsetメソッドです。
     * <br/>
     * <br/>1：更正前、2：更正後
     *
     * @param koseiZengoKubun 更正前後区分
     */
    public void setKoseiZengoKubun(@Nonnull RString koseiZengoKubun) {
        this.koseiZengoKubun = koseiZengoKubun;
    }

    /**
     * 作成処理名のgetメソッドです。
     *
     * @return 作成処理名
     */
    public RString getSakuseiShoriName() {
        return sakuseiShoriName;
    }

    /**
     * 作成処理名のsetメソッドです。
     *
     * @param sakuseiShoriName 作成処理名
     */
    public void setSakuseiShoriName(@Nonnull RString sakuseiShoriName) {
        this.sakuseiShoriName = sakuseiShoriName;
    }

    /**
     * 賦課履歴番号のgetメソッドです。
     *
     * @return 賦課履歴番号
     */
    public int getFukaRirekiNo() {
        return fukaRirekiNo;
    }

    /**
     * 賦課履歴番号のsetメソッドです。
     *
     * @param fukaRirekiNo 賦課履歴番号
     */
    public void setFukaRirekiNo(@Nonnull int fukaRirekiNo) {
        this.fukaRirekiNo = fukaRirekiNo;
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
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
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
     * 老齢開始日のgetメソッドです。
     *
     * @return 老齢開始日
     */
    @CheckForNull
    public FlexibleDate getRonenKaishiYMD() {
        return ronenKaishiYMD;
    }

    /**
     * 老齢開始日のsetメソッドです。
     *
     * @param ronenKaishiYMD 老齢開始日
     */
    public void setRonenKaishiYMD(FlexibleDate ronenKaishiYMD) {
        this.ronenKaishiYMD = ronenKaishiYMD;
    }

    /**
     * 老齢廃止日のgetメソッドです。
     *
     * @return 老齢廃止日
     */
    @CheckForNull
    public FlexibleDate getRonenHaishiYMD() {
        return ronenHaishiYMD;
    }

    /**
     * 老齢廃止日のsetメソッドです。
     *
     * @param ronenHaishiYMD 老齢廃止日
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
     *
     * @return 合計所得金額
     */
    @CheckForNull
    public Decimal getGokeiShotokuGaku() {
        return gokeiShotokuGaku;
    }

    /**
     * 合計所得金額のsetメソッドです。
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
     *
     * @return 保険料段階
     */
    @CheckForNull
    public RString getHokenryoDankai() {
        return hokenryoDankai;
    }

    /**
     * 保険料段階のsetメソッドです。
     *
     * @param hokenryoDankai 保険料段階
     */
    public void setHokenryoDankai(RString hokenryoDankai) {
        this.hokenryoDankai = hokenryoDankai;
    }

    /**
     * 保険料算定段階1のgetメソッドです。
     *
     * @return 保険料算定段階1
     */
    @CheckForNull
    public RString getHokenryoDankai1() {
        return hokenryoDankai1;
    }

    /**
     * 保険料算定段階1のsetメソッドです。
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
    public FlexibleDate getTsukiwariStartYM1() {
        return tsukiwariStartYM1;
    }

    /**
     * 月割開始年月1のsetメソッドです。
     *
     * @param tsukiwariStartYM1 月割開始年月1
     */
    public void setTsukiwariStartYM1(FlexibleDate tsukiwariStartYM1) {
        this.tsukiwariStartYM1 = tsukiwariStartYM1;
    }

    /**
     * 月割終了年月1のgetメソッドです。
     *
     * @return 月割終了年月1
     */
    @CheckForNull
    public FlexibleDate getTsukiwariEndYM1() {
        return tsukiwariEndYM1;
    }

    /**
     * 月割終了年月1のsetメソッドです。
     *
     * @param tsukiwariEndYM1 月割終了年月1
     */
    public void setTsukiwariEndYM1(FlexibleDate tsukiwariEndYM1) {
        this.tsukiwariEndYM1 = tsukiwariEndYM1;
    }

    /**
     * 保険料算定段階2のgetメソッドです。
     *
     * @return 保険料算定段階2
     */
    @CheckForNull
    public RString getHokenryoDankai2() {
        return hokenryoDankai2;
    }

    /**
     * 保険料算定段階2のsetメソッドです。
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
    public FlexibleDate getTsukiwariStartYM2() {
        return tsukiwariStartYM2;
    }

    /**
     * 月割開始年月2のsetメソッドです。
     *
     * @param tsukiwariStartYM2 月割開始年月2
     */
    public void setTsukiwariStartYM2(FlexibleDate tsukiwariStartYM2) {
        this.tsukiwariStartYM2 = tsukiwariStartYM2;
    }

    /**
     * 月割終了年月2のgetメソッドです。
     *
     * @return 月割終了年月2
     */
    @CheckForNull
    public FlexibleDate getTsukiwariEndYM2() {
        return tsukiwariEndYM2;
    }

    /**
     * 月割終了年月2のsetメソッドです。
     *
     * @param tsukiwariEndYM2 月割終了年月2
     */
    public void setTsukiwariEndYM2(FlexibleDate tsukiwariEndYM2) {
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
     *
     * @return 保険料段階（仮算定時）
     */
    @CheckForNull
    public RString getHokenryoDankaiKarisanntei() {
        return hokenryoDankaiKarisanntei;
    }

    /**
     * 保険料段階（仮算定時）のsetメソッドです。
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
     *
     * @return 口座区分
     */
    @CheckForNull
    public RString getKozaKubun() {
        return kozaKubun;
    }

    /**
     * 口座区分のsetメソッドです。
     *
     * @param kozaKubun 口座区分
     */
    public void setKozaKubun(RString kozaKubun) {
        this.kozaKubun = kozaKubun;
    }

    /**
     * 境界層区分のgetメソッドです。
     *
     * @return 境界層区分
     */
    @CheckForNull
    public RString getKyokaisoKubun() {
        return kyokaisoKubun;
    }

    /**
     * 境界層区分のsetメソッドです。
     *
     * @param kyokaisoKubun 境界層区分
     */
    public void setKyokaisoKubun(RString kyokaisoKubun) {
        this.kyokaisoKubun = kyokaisoKubun;
    }

    /**
     * 職権区分のgetメソッドです。
     *
     * @return 職権区分
     */
    @CheckForNull
    public RString getShokkenKubun() {
        return shokkenKubun;
    }

    /**
     * 職権区分のsetメソッドです。
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
     * 徴収方法4月のgetメソッドです。
     *
     * @return 徴収方法4月
     */
    @CheckForNull
    public RString getChoshuHoho4gatsu() {
        return choshuHoho4gatsu;
    }

    /**
     * 徴収方法4月のsetメソッドです。
     *
     * @param choshuHoho4gatsu 徴収方法4月
     */
    public void setChoshuHoho4gatsu(RString choshuHoho4gatsu) {
        this.choshuHoho4gatsu = choshuHoho4gatsu;
    }

    /**
     * 徴収方法5月のgetメソッドです。
     *
     * @return 徴収方法5月
     */
    @CheckForNull
    public RString getChoshuHoho5gatsu() {
        return choshuHoho5gatsu;
    }

    /**
     * 徴収方法5月のsetメソッドです。
     *
     * @param choshuHoho5gatsu 徴収方法5月
     */
    public void setChoshuHoho5gatsu(RString choshuHoho5gatsu) {
        this.choshuHoho5gatsu = choshuHoho5gatsu;
    }

    /**
     * 徴収方法6月のgetメソッドです。
     *
     * @return 徴収方法6月
     */
    @CheckForNull
    public RString getChoshuHoho6gatsu() {
        return choshuHoho6gatsu;
    }

    /**
     * 徴収方法6月のsetメソッドです。
     *
     * @param choshuHoho6gatsu 徴収方法6月
     */
    public void setChoshuHoho6gatsu(RString choshuHoho6gatsu) {
        this.choshuHoho6gatsu = choshuHoho6gatsu;
    }

    /**
     * 徴収方法7月のgetメソッドです。
     *
     * @return 徴収方法7月
     */
    @CheckForNull
    public RString getChoshuHoho7gatsu() {
        return choshuHoho7gatsu;
    }

    /**
     * 徴収方法7月のsetメソッドです。
     *
     * @param choshuHoho7gatsu 徴収方法7月
     */
    public void setChoshuHoho7gatsu(RString choshuHoho7gatsu) {
        this.choshuHoho7gatsu = choshuHoho7gatsu;
    }

    /**
     * 徴収方法8月のgetメソッドです。
     *
     * @return 徴収方法8月
     */
    @CheckForNull
    public RString getChoshuHoho8gatsu() {
        return choshuHoho8gatsu;
    }

    /**
     * 徴収方法8月のsetメソッドです。
     *
     * @param choshuHoho8gatsu 徴収方法8月
     */
    public void setChoshuHoho8gatsu(RString choshuHoho8gatsu) {
        this.choshuHoho8gatsu = choshuHoho8gatsu;
    }

    /**
     * 徴収方法9月のgetメソッドです。
     *
     * @return 徴収方法9月
     */
    @CheckForNull
    public RString getChoshuHoho9gatsu() {
        return choshuHoho9gatsu;
    }

    /**
     * 徴収方法9月のsetメソッドです。
     *
     * @param choshuHoho9gatsu 徴収方法9月
     */
    public void setChoshuHoho9gatsu(RString choshuHoho9gatsu) {
        this.choshuHoho9gatsu = choshuHoho9gatsu;
    }

    /**
     * 徴収方法10月のgetメソッドです。
     *
     * @return 徴収方法10月
     */
    @CheckForNull
    public RString getChoshuHoho10gatsu() {
        return choshuHoho10gatsu;
    }

    /**
     * 徴収方法10月のsetメソッドです。
     *
     * @param choshuHoho10gatsu 徴収方法10月
     */
    public void setChoshuHoho10gatsu(RString choshuHoho10gatsu) {
        this.choshuHoho10gatsu = choshuHoho10gatsu;
    }

    /**
     * 徴収方法11月のgetメソッドです。
     *
     * @return 徴収方法11月
     */
    @CheckForNull
    public RString getChoshuHoho11gatsu() {
        return choshuHoho11gatsu;
    }

    /**
     * 徴収方法11月のsetメソッドです。
     *
     * @param choshuHoho11gatsu 徴収方法11月
     */
    public void setChoshuHoho11gatsu(RString choshuHoho11gatsu) {
        this.choshuHoho11gatsu = choshuHoho11gatsu;
    }

    /**
     * 徴収方法12月のgetメソッドです。
     *
     * @return 徴収方法12月
     */
    @CheckForNull
    public RString getChoshuHoho12gatsu() {
        return choshuHoho12gatsu;
    }

    /**
     * 徴収方法12月のsetメソッドです。
     *
     * @param choshuHoho12gatsu 徴収方法12月
     */
    public void setChoshuHoho12gatsu(RString choshuHoho12gatsu) {
        this.choshuHoho12gatsu = choshuHoho12gatsu;
    }

    /**
     * 徴収方法1月のgetメソッドです。
     *
     * @return 徴収方法1月
     */
    @CheckForNull
    public RString getChoshuHoho1gatsu() {
        return choshuHoho1gatsu;
    }

    /**
     * 徴収方法1月のsetメソッドです。
     *
     * @param choshuHoho1gatsu 徴収方法1月
     */
    public void setChoshuHoho1gatsu(RString choshuHoho1gatsu) {
        this.choshuHoho1gatsu = choshuHoho1gatsu;
    }

    /**
     * 徴収方法2月のgetメソッドです。
     *
     * @return 徴収方法2月
     */
    @CheckForNull
    public RString getChoshuHoho2gatsu() {
        return choshuHoho2gatsu;
    }

    /**
     * 徴収方法2月のsetメソッドです。
     *
     * @param choshuHoho2gatsu 徴収方法2月
     */
    public void setChoshuHoho2gatsu(RString choshuHoho2gatsu) {
        this.choshuHoho2gatsu = choshuHoho2gatsu;
    }

    /**
     * 徴収方法3月のgetメソッドです。
     *
     * @return 徴収方法3月
     */
    @CheckForNull
    public RString getChoshuHoho3gatsu() {
        return choshuHoho3gatsu;
    }

    /**
     * 徴収方法3月のsetメソッドです。
     *
     * @param choshuHoho3gatsu 徴収方法3月
     */
    public void setChoshuHoho3gatsu(RString choshuHoho3gatsu) {
        this.choshuHoho3gatsu = choshuHoho3gatsu;
    }

    /**
     * 徴収方法翌4月のgetメソッドです。
     *
     * @return 徴収方法翌4月
     */
    @CheckForNull
    public RString getChoshuHohoYoku4gatsu() {
        return choshuHohoYoku4gatsu;
    }

    /**
     * 徴収方法翌4月のsetメソッドです。
     *
     * @param choshuHohoYoku4gatsu 徴収方法翌4月
     */
    public void setChoshuHohoYoku4gatsu(RString choshuHohoYoku4gatsu) {
        this.choshuHohoYoku4gatsu = choshuHohoYoku4gatsu;
    }

    /**
     * 徴収方法翌5月のgetメソッドです。
     *
     * @return 徴収方法翌5月
     */
    @CheckForNull
    public RString getChoshuHohoYoku5gatsu() {
        return choshuHohoYoku5gatsu;
    }

    /**
     * 徴収方法翌5月のsetメソッドです。
     *
     * @param choshuHohoYoku5gatsu 徴収方法翌5月
     */
    public void setChoshuHohoYoku5gatsu(RString choshuHohoYoku5gatsu) {
        this.choshuHohoYoku5gatsu = choshuHohoYoku5gatsu;
    }

    /**
     * 徴収方法翌6月のgetメソッドです。
     *
     * @return 徴収方法翌6月
     */
    @CheckForNull
    public RString getChoshuHohoYoku6gatsu() {
        return choshuHohoYoku6gatsu;
    }

    /**
     * 徴収方法翌6月のsetメソッドです。
     *
     * @param choshuHohoYoku6gatsu 徴収方法翌6月
     */
    public void setChoshuHohoYoku6gatsu(RString choshuHohoYoku6gatsu) {
        this.choshuHohoYoku6gatsu = choshuHohoYoku6gatsu;
    }

    /**
     * 徴収方法翌7月のgetメソッドです。
     *
     * @return 徴収方法翌7月
     */
    @CheckForNull
    public RString getChoshuHohoYoku7gatsu() {
        return choshuHohoYoku7gatsu;
    }

    /**
     * 徴収方法翌7月のsetメソッドです。
     *
     * @param choshuHohoYoku7gatsu 徴収方法翌7月
     */
    public void setChoshuHohoYoku7gatsu(RString choshuHohoYoku7gatsu) {
        this.choshuHohoYoku7gatsu = choshuHohoYoku7gatsu;
    }

    /**
     * 徴収方法翌8月のgetメソッドです。
     *
     * @return 徴収方法翌8月
     */
    @CheckForNull
    public RString getChoshuHohoYoku8gatsu() {
        return choshuHohoYoku8gatsu;
    }

    /**
     * 徴収方法翌8月のsetメソッドです。
     *
     * @param choshuHohoYoku8gatsu 徴収方法翌8月
     */
    public void setChoshuHohoYoku8gatsu(RString choshuHohoYoku8gatsu) {
        this.choshuHohoYoku8gatsu = choshuHohoYoku8gatsu;
    }

    /**
     * 徴収方法翌9月のgetメソッドです。
     *
     * @return 徴収方法翌9月
     */
    @CheckForNull
    public RString getChoshuHohoYoku9gatsu() {
        return choshuHohoYoku9gatsu;
    }

    /**
     * 徴収方法翌9月のsetメソッドです。
     *
     * @param choshuHohoYoku9gatsu 徴収方法翌9月
     */
    public void setChoshuHohoYoku9gatsu(RString choshuHohoYoku9gatsu) {
        this.choshuHohoYoku9gatsu = choshuHohoYoku9gatsu;
    }

    /**
     * 仮徴収・基礎年金番号のgetメソッドです。
     *
     * @return 仮徴収・基礎年金番号
     */
    @CheckForNull
    public RString getKariNenkinNo() {
        return kariNenkinNo;
    }

    /**
     * 仮徴収・基礎年金番号のsetメソッドです。
     *
     * @param kariNenkinNo 仮徴収・基礎年金番号
     */
    public void setKariNenkinNo(RString kariNenkinNo) {
        this.kariNenkinNo = kariNenkinNo;
    }

    /**
     * 仮徴収・年金コードのgetメソッドです。
     *
     * @return 仮徴収・年金コード
     */
    @CheckForNull
    public RString getKariNenkinCode() {
        return kariNenkinCode;
    }

    /**
     * 仮徴収・年金コードのsetメソッドです。
     *
     * @param kariNenkinCode 仮徴収・年金コード
     */
    public void setKariNenkinCode(RString kariNenkinCode) {
        this.kariNenkinCode = kariNenkinCode;
    }

    /**
     * 仮徴収・捕捉月のgetメソッドです。
     *
     * @return 仮徴収・捕捉月
     */
    @CheckForNull
    public RString getKariHosokuM() {
        return kariHosokuM;
    }

    /**
     * 仮徴収・捕捉月のsetメソッドです。
     *
     * @param kariHosokuM 仮徴収・捕捉月
     */
    public void setKariHosokuM(RString kariHosokuM) {
        this.kariHosokuM = kariHosokuM;
    }

    /**
     * 本徴収・基礎年金番号のgetメソッドです。
     *
     * @return 本徴収・基礎年金番号
     */
    @CheckForNull
    public RString getHonNenkinNo() {
        return honNenkinNo;
    }

    /**
     * 本徴収・基礎年金番号のsetメソッドです。
     *
     * @param honNenkinNo 本徴収・基礎年金番号
     */
    public void setHonNenkinNo(RString honNenkinNo) {
        this.honNenkinNo = honNenkinNo;
    }

    /**
     * 本徴収・年金コードのgetメソッドです。
     *
     * @return 本徴収・年金コード
     */
    @CheckForNull
    public RString getHonNenkinCode() {
        return honNenkinCode;
    }

    /**
     * 本徴収・年金コードのsetメソッドです。
     *
     * @param honNenkinCode 本徴収・年金コード
     */
    public void setHonNenkinCode(RString honNenkinCode) {
        this.honNenkinCode = honNenkinCode;
    }

    /**
     * 本徴収・捕捉月のgetメソッドです。
     *
     * @return 本徴収・捕捉月
     */
    @CheckForNull
    public RString getHonHosokuM() {
        return honHosokuM;
    }

    /**
     * 本徴収・捕捉月のsetメソッドです。
     *
     * @param honHosokuM 本徴収・捕捉月
     */
    public void setHonHosokuM(RString honHosokuM) {
        this.honHosokuM = honHosokuM;
    }

    /**
     * 翌年度仮徴収・基礎年金番号のgetメソッドです。
     *
     * @return 翌年度仮徴収・基礎年金番号
     */
    @CheckForNull
    public RString getYokunendoKariNenkinNo() {
        return yokunendoKariNenkinNo;
    }

    /**
     * 翌年度仮徴収・基礎年金番号のsetメソッドです。
     *
     * @param yokunendoKariNenkinNo 翌年度仮徴収・基礎年金番号
     */
    public void setYokunendoKariNenkinNo(RString yokunendoKariNenkinNo) {
        this.yokunendoKariNenkinNo = yokunendoKariNenkinNo;
    }

    /**
     * 翌年度仮徴収・年金コードのgetメソッドです。
     *
     * @return 翌年度仮徴収・年金コード
     */
    @CheckForNull
    public RString getYokunendoKariNenkinCode() {
        return yokunendoKariNenkinCode;
    }

    /**
     * 翌年度仮徴収・年金コードのsetメソッドです。
     *
     * @param yokunendoKariNenkinCode 翌年度仮徴収・年金コード
     */
    public void setYokunendoKariNenkinCode(RString yokunendoKariNenkinCode) {
        this.yokunendoKariNenkinCode = yokunendoKariNenkinCode;
    }

    /**
     * 翌年度仮徴収・捕捉月のgetメソッドです。
     *
     * @return 翌年度仮徴収・捕捉月
     */
    @CheckForNull
    public RString getYokunendoKariHosokuM() {
        return yokunendoKariHosokuM;
    }

    /**
     * 翌年度仮徴収・捕捉月のsetメソッドです。
     *
     * @param yokunendoKariHosokuM 翌年度仮徴収・捕捉月
     */
    public void setYokunendoKariHosokuM(RString yokunendoKariHosokuM) {
        this.yokunendoKariHosokuM = yokunendoKariHosokuM;
    }

    /**
     * 依頼情報送付済みフラグのgetメソッドです。
     *
     * @return 依頼情報送付済みフラグ
     */
    @CheckForNull
    public boolean getIraiSohuzumiFlag() {
        return iraiSohuzumiFlag;
    }

    /**
     * 依頼情報送付済みフラグのsetメソッドです。
     *
     * @param iraiSohuzumiFlag 依頼情報送付済みフラグ
     */
    public void setIraiSohuzumiFlag(boolean iraiSohuzumiFlag) {
        this.iraiSohuzumiFlag = iraiSohuzumiFlag;
    }

    /**
     * 追加依頼情報送付済みフラグのgetメソッドです。
     *
     * @return 追加依頼情報送付済みフラグ
     */
    @CheckForNull
    public boolean getTsuikaIraiSohuzumiFlag() {
        return tsuikaIraiSohuzumiFlag;
    }

    /**
     * 追加依頼情報送付済みフラグのsetメソッドです。
     *
     * @param tsuikaIraiSohuzumiFlag 追加依頼情報送付済みフラグ
     */
    public void setTsuikaIraiSohuzumiFlag(boolean tsuikaIraiSohuzumiFlag) {
        this.tsuikaIraiSohuzumiFlag = tsuikaIraiSohuzumiFlag;
    }

    /**
     * 特別徴収停止日時のgetメソッドです。
     *
     * @return 特別徴収停止日時
     */
    @CheckForNull
    public YMDHMS getTokuchoTeishiNichiji() {
        return tokuchoTeishiNichiji;
    }

    /**
     * 特別徴収停止日時のsetメソッドです。
     *
     * @param tokuchoTeishiNichiji 特別徴収停止日時
     */
    public void setTokuchoTeishiNichiji(YMDHMS tokuchoTeishiNichiji) {
        this.tokuchoTeishiNichiji = tokuchoTeishiNichiji;
    }

    /**
     * 特別徴収停止事由コードのgetメソッドです。
     *
     * @return 特別徴収停止事由コード
     */
    @CheckForNull
    public RString getTokuchoTeishiJiyuCode() {
        return tokuchoTeishiJiyuCode;
    }

    /**
     * 特別徴収停止事由コードのsetメソッドです。
     *
     * @param tokuchoTeishiJiyuCode 特別徴収停止事由コード
     */
    public void setTokuchoTeishiJiyuCode(RString tokuchoTeishiJiyuCode) {
        this.tokuchoTeishiJiyuCode = tokuchoTeishiJiyuCode;
    }

    /**
     * 特徴収入額01のgetメソッドです。
     *
     * @return 特徴収入額01
     */
    @CheckForNull
    public Decimal getTkShunyuGaku01() {
        return tkShunyuGaku01;
    }

    /**
     * 特徴収入額01のsetメソッドです。
     *
     * @param tkShunyuGaku01 特徴収入額01
     */
    public void setTkShunyuGaku01(Decimal tkShunyuGaku01) {
        this.tkShunyuGaku01 = tkShunyuGaku01;
    }

    /**
     * 特徴収入額02のgetメソッドです。
     *
     * @return 特徴収入額02
     */
    @CheckForNull
    public Decimal getTkShunyuGaku02() {
        return tkShunyuGaku02;
    }

    /**
     * 特徴収入額02のsetメソッドです。
     *
     * @param tkShunyuGaku02 特徴収入額02
     */
    public void setTkShunyuGaku02(Decimal tkShunyuGaku02) {
        this.tkShunyuGaku02 = tkShunyuGaku02;
    }

    /**
     * 特徴収入額03のgetメソッドです。
     *
     * @return 特徴収入額03
     */
    @CheckForNull
    public Decimal getTkShunyuGaku03() {
        return tkShunyuGaku03;
    }

    /**
     * 特徴収入額03のsetメソッドです。
     *
     * @param tkShunyuGaku03 特徴収入額03
     */
    public void setTkShunyuGaku03(Decimal tkShunyuGaku03) {
        this.tkShunyuGaku03 = tkShunyuGaku03;
    }

    /**
     * 特徴収入額04のgetメソッドです。
     *
     * @return 特徴収入額04
     */
    @CheckForNull
    public Decimal getTkShunyuGaku04() {
        return tkShunyuGaku04;
    }

    /**
     * 特徴収入額04のsetメソッドです。
     *
     * @param tkShunyuGaku04 特徴収入額04
     */
    public void setTkShunyuGaku04(Decimal tkShunyuGaku04) {
        this.tkShunyuGaku04 = tkShunyuGaku04;
    }

    /**
     * 特徴収入額05のgetメソッドです。
     *
     * @return 特徴収入額05
     */
    @CheckForNull
    public Decimal getTkShunyuGaku05() {
        return tkShunyuGaku05;
    }

    /**
     * 特徴収入額05のsetメソッドです。
     *
     * @param tkShunyuGaku05 特徴収入額05
     */
    public void setTkShunyuGaku05(Decimal tkShunyuGaku05) {
        this.tkShunyuGaku05 = tkShunyuGaku05;
    }

    /**
     * 特徴収入額06のgetメソッドです。
     *
     * @return 特徴収入額06
     */
    @CheckForNull
    public Decimal getTkShunyuGaku06() {
        return tkShunyuGaku06;
    }

    /**
     * 特徴収入額06のsetメソッドです。
     *
     * @param tkShunyuGaku06 特徴収入額06
     */
    public void setTkShunyuGaku06(Decimal tkShunyuGaku06) {
        this.tkShunyuGaku06 = tkShunyuGaku06;
    }

    /**
     * 普徴収入額01のgetメソッドです。
     *
     * @return 普徴収入額01
     */
    @CheckForNull
    public Decimal getFuShunyuGaku01() {
        return fuShunyuGaku01;
    }

    /**
     * 普徴収入額01のsetメソッドです。
     *
     * @param fuShunyuGaku01 普徴収入額01
     */
    public void setFuShunyuGaku01(Decimal fuShunyuGaku01) {
        this.fuShunyuGaku01 = fuShunyuGaku01;
    }

    /**
     * 普徴収入額02のgetメソッドです。
     *
     * @return 普徴収入額02
     */
    @CheckForNull
    public Decimal getFuShunyuGaku02() {
        return fuShunyuGaku02;
    }

    /**
     * 普徴収入額02のsetメソッドです。
     *
     * @param fuShunyuGaku02 普徴収入額02
     */
    public void setFuShunyuGaku02(Decimal fuShunyuGaku02) {
        this.fuShunyuGaku02 = fuShunyuGaku02;
    }

    /**
     * 普徴収入額03のgetメソッドです。
     *
     * @return 普徴収入額03
     */
    @CheckForNull
    public Decimal getFuShunyuGaku03() {
        return fuShunyuGaku03;
    }

    /**
     * 普徴収入額03のsetメソッドです。
     *
     * @param fuShunyuGaku03 普徴収入額03
     */
    public void setFuShunyuGaku03(Decimal fuShunyuGaku03) {
        this.fuShunyuGaku03 = fuShunyuGaku03;
    }

    /**
     * 普徴収入額04のgetメソッドです。
     *
     * @return 普徴収入額04
     */
    @CheckForNull
    public Decimal getFuShunyuGaku04() {
        return fuShunyuGaku04;
    }

    /**
     * 普徴収入額04のsetメソッドです。
     *
     * @param fuShunyuGaku04 普徴収入額04
     */
    public void setFuShunyuGaku04(Decimal fuShunyuGaku04) {
        this.fuShunyuGaku04 = fuShunyuGaku04;
    }

    /**
     * 普徴収入額05のgetメソッドです。
     *
     * @return 普徴収入額05
     */
    @CheckForNull
    public Decimal getFuShunyuGaku05() {
        return fuShunyuGaku05;
    }

    /**
     * 普徴収入額05のsetメソッドです。
     *
     * @param fuShunyuGaku05 普徴収入額05
     */
    public void setFuShunyuGaku05(Decimal fuShunyuGaku05) {
        this.fuShunyuGaku05 = fuShunyuGaku05;
    }

    /**
     * 普徴収入額06のgetメソッドです。
     *
     * @return 普徴収入額06
     */
    @CheckForNull
    public Decimal getFuShunyuGaku06() {
        return fuShunyuGaku06;
    }

    /**
     * 普徴収入額06のsetメソッドです。
     *
     * @param fuShunyuGaku06 普徴収入額06
     */
    public void setFuShunyuGaku06(Decimal fuShunyuGaku06) {
        this.fuShunyuGaku06 = fuShunyuGaku06;
    }

    /**
     * 普徴収入額07のgetメソッドです。
     *
     * @return 普徴収入額07
     */
    @CheckForNull
    public Decimal getFuShunyuGaku07() {
        return fuShunyuGaku07;
    }

    /**
     * 普徴収入額07のsetメソッドです。
     *
     * @param fuShunyuGaku07 普徴収入額07
     */
    public void setFuShunyuGaku07(Decimal fuShunyuGaku07) {
        this.fuShunyuGaku07 = fuShunyuGaku07;
    }

    /**
     * 普徴収入額08のgetメソッドです。
     *
     * @return 普徴収入額08
     */
    @CheckForNull
    public Decimal getFuShunyuGaku08() {
        return fuShunyuGaku08;
    }

    /**
     * 普徴収入額08のsetメソッドです。
     *
     * @param fuShunyuGaku08 普徴収入額08
     */
    public void setFuShunyuGaku08(Decimal fuShunyuGaku08) {
        this.fuShunyuGaku08 = fuShunyuGaku08;
    }

    /**
     * 普徴収入額09のgetメソッドです。
     *
     * @return 普徴収入額09
     */
    @CheckForNull
    public Decimal getFuShunyuGaku09() {
        return fuShunyuGaku09;
    }

    /**
     * 普徴収入額09のsetメソッドです。
     *
     * @param fuShunyuGaku09 普徴収入額09
     */
    public void setFuShunyuGaku09(Decimal fuShunyuGaku09) {
        this.fuShunyuGaku09 = fuShunyuGaku09;
    }

    /**
     * 普徴収入額10のgetメソッドです。
     *
     * @return 普徴収入額10
     */
    @CheckForNull
    public Decimal getFuShunyuGaku10() {
        return fuShunyuGaku10;
    }

    /**
     * 普徴収入額10のsetメソッドです。
     *
     * @param fuShunyuGaku10 普徴収入額10
     */
    public void setFuShunyuGaku10(Decimal fuShunyuGaku10) {
        this.fuShunyuGaku10 = fuShunyuGaku10;
    }

    /**
     * 普徴収入額11のgetメソッドです。
     *
     * @return 普徴収入額11
     */
    @CheckForNull
    public Decimal getFuShunyuGaku11() {
        return fuShunyuGaku11;
    }

    /**
     * 普徴収入額11のsetメソッドです。
     *
     * @param fuShunyuGaku11 普徴収入額11
     */
    public void setFuShunyuGaku11(Decimal fuShunyuGaku11) {
        this.fuShunyuGaku11 = fuShunyuGaku11;
    }

    /**
     * 普徴収入額12のgetメソッドです。
     *
     * @return 普徴収入額12
     */
    @CheckForNull
    public Decimal getFuShunyuGaku12() {
        return fuShunyuGaku12;
    }

    /**
     * 普徴収入額12のsetメソッドです。
     *
     * @param fuShunyuGaku12 普徴収入額12
     */
    public void setFuShunyuGaku12(Decimal fuShunyuGaku12) {
        this.fuShunyuGaku12 = fuShunyuGaku12;
    }

    /**
     * 普徴収入額13のgetメソッドです。
     *
     * @return 普徴収入額13
     */
    @CheckForNull
    public Decimal getFuShunyuGaku13() {
        return fuShunyuGaku13;
    }

    /**
     * 普徴収入額13のsetメソッドです。
     *
     * @param fuShunyuGaku13 普徴収入額13
     */
    public void setFuShunyuGaku13(Decimal fuShunyuGaku13) {
        this.fuShunyuGaku13 = fuShunyuGaku13;
    }

    /**
     * 普徴収入額14のgetメソッドです。
     *
     * @return 普徴収入額14
     */
    @CheckForNull
    public Decimal getFuShunyuGaku14() {
        return fuShunyuGaku14;
    }

    /**
     * 普徴収入額14のsetメソッドです。
     *
     * @param fuShunyuGaku14 普徴収入額14
     */
    public void setFuShunyuGaku14(Decimal fuShunyuGaku14) {
        this.fuShunyuGaku14 = fuShunyuGaku14;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbTKeisangoJohoTempTableEntity entity) {
        this.choteiNendo = entity.choteiNendo;
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.koseiZengoKubun = entity.koseiZengoKubun;
        this.sakuseiShoriName = entity.sakuseiShoriName;
        this.fukaRirekiNo = entity.fukaRirekiNo;
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
        this.choshuHoho4gatsu = entity.choshuHoho4gatsu;
        this.choshuHoho5gatsu = entity.choshuHoho5gatsu;
        this.choshuHoho6gatsu = entity.choshuHoho6gatsu;
        this.choshuHoho7gatsu = entity.choshuHoho7gatsu;
        this.choshuHoho8gatsu = entity.choshuHoho8gatsu;
        this.choshuHoho9gatsu = entity.choshuHoho9gatsu;
        this.choshuHoho10gatsu = entity.choshuHoho10gatsu;
        this.choshuHoho11gatsu = entity.choshuHoho11gatsu;
        this.choshuHoho12gatsu = entity.choshuHoho12gatsu;
        this.choshuHoho1gatsu = entity.choshuHoho1gatsu;
        this.choshuHoho2gatsu = entity.choshuHoho2gatsu;
        this.choshuHoho3gatsu = entity.choshuHoho3gatsu;
        this.choshuHohoYoku4gatsu = entity.choshuHohoYoku4gatsu;
        this.choshuHohoYoku5gatsu = entity.choshuHohoYoku5gatsu;
        this.choshuHohoYoku6gatsu = entity.choshuHohoYoku6gatsu;
        this.choshuHohoYoku7gatsu = entity.choshuHohoYoku7gatsu;
        this.choshuHohoYoku8gatsu = entity.choshuHohoYoku8gatsu;
        this.choshuHohoYoku9gatsu = entity.choshuHohoYoku9gatsu;
        this.kariNenkinNo = entity.kariNenkinNo;
        this.kariNenkinCode = entity.kariNenkinCode;
        this.kariHosokuM = entity.kariHosokuM;
        this.honNenkinNo = entity.honNenkinNo;
        this.honNenkinCode = entity.honNenkinCode;
        this.honHosokuM = entity.honHosokuM;
        this.yokunendoKariNenkinNo = entity.yokunendoKariNenkinNo;
        this.yokunendoKariNenkinCode = entity.yokunendoKariNenkinCode;
        this.yokunendoKariHosokuM = entity.yokunendoKariHosokuM;
        this.iraiSohuzumiFlag = entity.iraiSohuzumiFlag;
        this.tsuikaIraiSohuzumiFlag = entity.tsuikaIraiSohuzumiFlag;
        this.tokuchoTeishiNichiji = entity.tokuchoTeishiNichiji;
        this.tokuchoTeishiJiyuCode = entity.tokuchoTeishiJiyuCode;
        this.tkShunyuGaku01 = entity.tkShunyuGaku01;
        this.tkShunyuGaku02 = entity.tkShunyuGaku02;
        this.tkShunyuGaku03 = entity.tkShunyuGaku03;
        this.tkShunyuGaku04 = entity.tkShunyuGaku04;
        this.tkShunyuGaku05 = entity.tkShunyuGaku05;
        this.tkShunyuGaku06 = entity.tkShunyuGaku06;
        this.fuShunyuGaku01 = entity.fuShunyuGaku01;
        this.fuShunyuGaku02 = entity.fuShunyuGaku02;
        this.fuShunyuGaku03 = entity.fuShunyuGaku03;
        this.fuShunyuGaku04 = entity.fuShunyuGaku04;
        this.fuShunyuGaku05 = entity.fuShunyuGaku05;
        this.fuShunyuGaku06 = entity.fuShunyuGaku06;
        this.fuShunyuGaku07 = entity.fuShunyuGaku07;
        this.fuShunyuGaku08 = entity.fuShunyuGaku08;
        this.fuShunyuGaku09 = entity.fuShunyuGaku09;
        this.fuShunyuGaku10 = entity.fuShunyuGaku10;
        this.fuShunyuGaku11 = entity.fuShunyuGaku11;
        this.fuShunyuGaku12 = entity.fuShunyuGaku12;
        this.fuShunyuGaku13 = entity.fuShunyuGaku13;
        this.fuShunyuGaku14 = entity.fuShunyuGaku14;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiNendo, fukaNendo, tsuchishoNo, koseiZengoKubun, sakuseiShoriName, fukaRirekiNo, hihokenshaNo, shikibetsuCode, setaiCode, setaiInsu, shikakuShutokuYMD, shikakuShutokuJiyu, shikakuSoshitsuYMD, shikakuSoshitsuJiyu, seihofujoShurui, seihoKaishiYMD, seihoHaishiYMD, ronenKaishiYMD, ronenHaishiYMD, fukaYMD, kazeiKubun, setaikazeiKubun, gokeiShotokuGaku, nenkinShunyuGaku, hokenryoDankai, hokenryoDankai1, nengakuHokenryo1, tsukiwariStartYM1, tsukiwariEndYM1, hokenryoDankai2, nengakuHokenryo2, tsukiwariStartYM2, tsukiwariEndYM2, choteiNichiji, choteiJiyu1, choteiJiyu2, choteiJiyu3, choteiJiyu4, koseiM, gemmenMaeHokenryo, gemmenGaku, kakuteiHokenryo, hokenryoDankaiKarisanntei, choshuHohoRirekiNo, idoKijunNichiji, kozaKubun, kyokaisoKubun, shokkenKubun, fukaShichosonCode, tkSaishutsuKampuGaku, fuSaishutsuKampuGaku, tkKibetsuGaku01, tkKibetsuGaku02, tkKibetsuGaku03, tkKibetsuGaku04, tkKibetsuGaku05, tkKibetsuGaku06, fuKibetsuGaku01, fuKibetsuGaku02, fuKibetsuGaku03, fuKibetsuGaku04, fuKibetsuGaku05, fuKibetsuGaku06, fuKibetsuGaku07, fuKibetsuGaku08, fuKibetsuGaku09, fuKibetsuGaku10, fuKibetsuGaku11, fuKibetsuGaku12, fuKibetsuGaku13, fuKibetsuGaku14, choshuHoho4gatsu, choshuHoho5gatsu, choshuHoho6gatsu, choshuHoho7gatsu, choshuHoho8gatsu, choshuHoho9gatsu, choshuHoho10gatsu, choshuHoho11gatsu, choshuHoho12gatsu, choshuHoho1gatsu, choshuHoho2gatsu, choshuHoho3gatsu, choshuHohoYoku4gatsu, choshuHohoYoku5gatsu, choshuHohoYoku6gatsu, choshuHohoYoku7gatsu, choshuHohoYoku8gatsu, choshuHohoYoku9gatsu, kariNenkinNo, kariNenkinCode, kariHosokuM, honNenkinNo, honNenkinCode, honHosokuM, yokunendoKariNenkinNo, yokunendoKariNenkinCode, yokunendoKariHosokuM, iraiSohuzumiFlag, tsuikaIraiSohuzumiFlag, tokuchoTeishiNichiji, tokuchoTeishiJiyuCode, tkShunyuGaku01, tkShunyuGaku02, tkShunyuGaku03, tkShunyuGaku04, tkShunyuGaku05, tkShunyuGaku06, fuShunyuGaku01, fuShunyuGaku02, fuShunyuGaku03, fuShunyuGaku04, fuShunyuGaku05, fuShunyuGaku06, fuShunyuGaku07, fuShunyuGaku08, fuShunyuGaku09, fuShunyuGaku10, fuShunyuGaku11, fuShunyuGaku12, fuShunyuGaku13, fuShunyuGaku14);
    }

// </editor-fold>
}

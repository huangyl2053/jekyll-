package jp.co.ndensan.reams.db.dbb.entity.db.basic.fuka;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 介護賦課テーブルのエンティティクラスです。
 */
public class DbT2002FukaEntity extends DbTableEntityBase<DbT2002FukaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2002Fuka");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear choteiNendo;
    @PrimaryKey
    private FlexibleYear fukaNendo;
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private SetaiCode setaiCode;
    private Decimal setaiInsu;
    private FlexibleDate shikakuShutokuYMD;
    private RString shikakuShutokuJiyu;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString shikakuSoshitsuJiyu;
    private RString seihofujoShurui;
    private FlexibleDate seihoKaishiYMD;
    private FlexibleDate seihoHaishiYMD;
    private FlexibleDate ronenKaishiYMD;
    private FlexibleDate ronenHaishiYMD;
    private FlexibleDate fukaYMD;
    private RString kazeiKubun;
    private RString setaikazeiKubun;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkinShunyuGaku;
    private RString hokenryoDankai;
    private RString hokenryoDankai1;
    private Decimal nengakuHokenryo1;
    private FlexibleYearMonth tsukiwariStartYM1;
    private FlexibleYearMonth tsukiwariEndYM1;
    private RString hokenryoDankai2;
    private Decimal nengakuHokenryo2;
    private FlexibleYearMonth tsukiwariStartYM2;
    private FlexibleYearMonth tsukiwariEndYM2;
    private RDateTime choteiTimestamp;
    private RString choteiJiyu1;
    private RString choteiJiyu2;
    private RString choteiJiyu3;
    private RString choteiJiyu4;
    private RString koseiM;
    private Decimal gemmenMaeHokenryo;
    private Decimal gemmenGaku;
    private Decimal kakuteiHokenryo;
    private RString hokenryoDankaiKarisanntei;
    private Decimal choshuHohoRirekiNo;
    private RDateTime idoKijunTimestamp;
    private RString kozaKubun;
    private RString kyokaisoKubun;
    private RString shokkenKubun;
    private LasdecCode fukaShichosonCode;

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
    public void setChoteiNendo(FlexibleYear choteiNendo) {
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
    public void setFukaNendo(FlexibleYear fukaNendo) {
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
    public void setTsuchishoNo(TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
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
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
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
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 世帯コードのgetメソッドです。
     *
     * @return 世帯コード
     */
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
    public Decimal getSetaiInsu() {
        return setaiInsu;
    }

    /**
     * 世帯員数のsetメソッドです。
     *
     * @param setaiInsu 世帯員数
     */
    public void setSetaiInsu(Decimal setaiInsu) {
        this.setaiInsu = setaiInsu;
    }

    /**
     * 資格取得日のgetメソッドです。
     *
     * @return 資格取得日
     */
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
    public RDateTime getChoteiTimestamp() {
        return choteiTimestamp;
    }

    /**
     * 調定日時のsetメソッドです。
     *
     * @param choteiTimestamp 調定日時
     */
    public void setChoteiTimestamp(RDateTime choteiTimestamp) {
        this.choteiTimestamp = choteiTimestamp;
    }

    /**
     * 調定事由1のgetメソッドです。
     *
     * @return 調定事由1
     */
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
    public Decimal getChoshuHohoRirekiNo() {
        return choshuHohoRirekiNo;
    }

    /**
     * 徴収方法履歴番号のsetメソッドです。
     *
     * @param choshuHohoRirekiNo 徴収方法履歴番号
     */
    public void setChoshuHohoRirekiNo(Decimal choshuHohoRirekiNo) {
        this.choshuHohoRirekiNo = choshuHohoRirekiNo;
    }

    /**
     * 異動基準日時のgetメソッドです。
     *
     * @return 異動基準日時
     */
    public RDateTime getIdoKijunTimestamp() {
        return idoKijunTimestamp;
    }

    /**
     * 異動基準日時のsetメソッドです。
     *
     * @param idoKijunTimestamp 異動基準日時
     */
    public void setIdoKijunTimestamp(RDateTime idoKijunTimestamp) {
        this.idoKijunTimestamp = idoKijunTimestamp;
    }

    /**
     * 口座区分のgetメソッドです。
     * <br/>
     * <br/>1：該当　0:非該当
     *
     * @return 口座区分
     */
    public RString getKozaKubun() {
        return kozaKubun;
    }

    /**
     * 口座区分のsetメソッドです。
     * <br/>
     * <br/>1：該当　0:非該当
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
     * このエンティティの主キーが他の{@literal DbT2002FukaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2002FukaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2002FukaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.choteiNendo, other.choteiNendo)) {
            return false;
        }
        if (!Objects.equals(this.fukaNendo, other.fukaNendo)) {
            return false;
        }
        if (!Objects.equals(this.tsuchishoNo, other.tsuchishoNo)) {
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
    public void shallowCopy(DbT2002FukaEntity entity) {
        this.choteiNendo = entity.choteiNendo;
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.rirekiNo = entity.rirekiNo;
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
        this.choteiTimestamp = entity.choteiTimestamp;
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
        this.idoKijunTimestamp = entity.idoKijunTimestamp;
        this.kozaKubun = entity.kozaKubun;
        this.kyokaisoKubun = entity.kyokaisoKubun;
        this.shokkenKubun = entity.shokkenKubun;
        this.fukaShichosonCode = entity.fukaShichosonCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo, hihokenshaNo, shikibetsuCode, setaiCode, setaiInsu, shikakuShutokuYMD, shikakuShutokuJiyu, shikakuSoshitsuYMD, shikakuSoshitsuJiyu, seihofujoShurui, seihoKaishiYMD, seihoHaishiYMD, ronenKaishiYMD, ronenHaishiYMD, fukaYMD, kazeiKubun, setaikazeiKubun, gokeiShotokuGaku, nenkinShunyuGaku, hokenryoDankai, hokenryoDankai1, nengakuHokenryo1, tsukiwariStartYM1, tsukiwariEndYM1, hokenryoDankai2, nengakuHokenryo2, tsukiwariStartYM2, tsukiwariEndYM2, choteiTimestamp, choteiJiyu1, choteiJiyu2, choteiJiyu3, choteiJiyu4, koseiM, gemmenMaeHokenryo, gemmenGaku, kakuteiHokenryo, hokenryoDankaiKarisanntei, choshuHohoRirekiNo, idoKijunTimestamp, kozaKubun, kyokaisoKubun, shokkenKubun, fukaShichosonCode);
    }

// </editor-fold>
}

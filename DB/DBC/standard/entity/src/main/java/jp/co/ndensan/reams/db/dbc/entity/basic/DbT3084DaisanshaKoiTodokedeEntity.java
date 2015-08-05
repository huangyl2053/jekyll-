package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;

/**
 * 介護第三者行為届出テーブルのエンティティクラスです。
 */
public class DbT3084DaisanshaKoiTodokedeEntity extends DbTableEntityBase<DbT3084DaisanshaKoiTodokedeEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3084DaisanshaKoiTodokede");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString todokedeKanriNo;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleDate todokedeYMD;
    private YubinNo todokedenin_YubinNo;
    private RString todokedenin_Jusho;
    private AtenaKanaMeisho todokedenin_ShimeiKana;
    private AtenaMeisho todokedenin_Shimei;
    private TelNo todokedenin_TelNo;
    private RString todokedenin_Zokugara;
    private Code yokaigoJotaiKubun;
    private FlexibleDate ninteiYukoKaishiYMD;
    private FlexibleDate ninteiYukoShuryoYMD;
    private YubinNo kagaisha_YubinNo;
    private RString kagaisha_Jusho;
    private AtenaKanaMeisho kagaisha_ShimeiKana;
    private AtenaMeisho kagansha_Shimei;
    private FlexibleDate kagaisha_UmareYMD;
    private TelNo kagaisha_TelNo;
    private RString kagaisha_Shokugyo;
    private YubinNo shiyosha_YubinNo;
    private RString shiyosha_Jusho;
    private AtenaKanaMeisho shiyosha_ShimeiKana;
    private AtenaMeisho shiyosha_Shimei;
    private FlexibleDate shiyosha_UmareYMD;
    private TelNo shiyosha_TelNo;
    private RString shiyosha_Shokugyo;
    private FlexibleDate fushoYMD;
    private RString fushoTime;
    private RString fushoJi_Basho;
    private RString hasshoGeiin_FushoJiJokyo;
    private AtenaMeisho jibaisekiHoken_KeiyakuKaishaMei;
    private RString jibaisekiHoken_ShomeishoNo;
    private RString jibaisekiHoken_KeiyakushaJusho;
    private RString shoyushaJusho;
    private AtenaMeisho shoyushaShimei;
    private RString torokuNo;
    private RString shadaiNo;
    private RString niniHoken_TaijinHoshoUmu;
    private AtenaMeisho niniHoken_TaijinHoshoKaishaMei;
    private TelNo niniHoken_TaijinHoshoKaishaTelNo;
    private AtenaMeisho niniHoken_TaijinHoshoKaishaTantosha;
    private RString jidan_SeiritsuUmu;
    private FlexibleDate jidan_SeiritsuYMD;
    private RString songaiBaishoKoshoKeika;
    private RString jikoHasseiJokyoHokokushoUmu;
    private RString nensho_DoishoUmu;
    private RString seiyakushoUmu;
    private RString kotsuJikoShomeishoUmu;
    private RString jinshinJikoShomeisho_NyushuFunoRiyushoUmu;
    private RString jidanshoUtsushiUmu;

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
     * 第三者行為届出管理番号のgetメソッドです。
     *
     * @return 第三者行為届出管理番号
     */
    public RString getTodokedeKanriNo() {
        return todokedeKanriNo;
    }

    /**
     * 第三者行為届出管理番号のsetメソッドです。
     *
     * @param todokedeKanriNo 第三者行為届出管理番号
     */
    public void setTodokedeKanriNo(RString todokedeKanriNo) {
        this.todokedeKanriNo = todokedeKanriNo;
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
     * 届出年月日のgetメソッドです。
     *
     * @return 届出年月日
     */
    public FlexibleDate getTodokedeYMD() {
        return todokedeYMD;
    }

    /**
     * 届出年月日のsetメソッドです。
     *
     * @param todokedeYMD 届出年月日
     */
    public void setTodokedeYMD(FlexibleDate todokedeYMD) {
        this.todokedeYMD = todokedeYMD;
    }

    /**
     * 届出人郵便番号のgetメソッドです。
     *
     * @return 届出人郵便番号
     */
    public YubinNo getTodokedenin_YubinNo() {
        return todokedenin_YubinNo;
    }

    /**
     * 届出人郵便番号のsetメソッドです。
     *
     * @param todokedenin_YubinNo 届出人郵便番号
     */
    public void setTodokedenin_YubinNo(YubinNo todokedenin_YubinNo) {
        this.todokedenin_YubinNo = todokedenin_YubinNo;
    }

    /**
     * 届出人住所のgetメソッドです。
     *
     * @return 届出人住所
     */
    public RString getTodokedenin_Jusho() {
        return todokedenin_Jusho;
    }

    /**
     * 届出人住所のsetメソッドです。
     *
     * @param todokedenin_Jusho 届出人住所
     */
    public void setTodokedenin_Jusho(RString todokedenin_Jusho) {
        this.todokedenin_Jusho = todokedenin_Jusho;
    }

    /**
     * 届出人氏名カナのgetメソッドです。
     *
     * @return 届出人氏名カナ
     */
    public AtenaKanaMeisho getTodokedenin_ShimeiKana() {
        return todokedenin_ShimeiKana;
    }

    /**
     * 届出人氏名カナのsetメソッドです。
     *
     * @param todokedenin_ShimeiKana 届出人氏名カナ
     */
    public void setTodokedenin_ShimeiKana(AtenaKanaMeisho todokedenin_ShimeiKana) {
        this.todokedenin_ShimeiKana = todokedenin_ShimeiKana;
    }

    /**
     * 届出人氏名のgetメソッドです。
     *
     * @return 届出人氏名
     */
    public AtenaMeisho getTodokedenin_Shimei() {
        return todokedenin_Shimei;
    }

    /**
     * 届出人氏名のsetメソッドです。
     *
     * @param todokedenin_Shimei 届出人氏名
     */
    public void setTodokedenin_Shimei(AtenaMeisho todokedenin_Shimei) {
        this.todokedenin_Shimei = todokedenin_Shimei;
    }

    /**
     * 届出人電話番号のgetメソッドです。
     *
     * @return 届出人電話番号
     */
    public TelNo getTodokedenin_TelNo() {
        return todokedenin_TelNo;
    }

    /**
     * 届出人電話番号のsetメソッドです。
     *
     * @param todokedenin_TelNo 届出人電話番号
     */
    public void setTodokedenin_TelNo(TelNo todokedenin_TelNo) {
        this.todokedenin_TelNo = todokedenin_TelNo;
    }

    /**
     * 届出人との続柄のgetメソッドです。
     *
     * @return 届出人との続柄
     */
    public RString getTodokedenin_Zokugara() {
        return todokedenin_Zokugara;
    }

    /**
     * 届出人との続柄のsetメソッドです。
     *
     * @param todokedenin_Zokugara 届出人との続柄
     */
    public void setTodokedenin_Zokugara(RString todokedenin_Zokugara) {
        this.todokedenin_Zokugara = todokedenin_Zokugara;
    }

    /**
     * 要介護状態区分のgetメソッドです。
     *
     * @return 要介護状態区分
     */
    public Code getYokaigoJotaiKubun() {
        return yokaigoJotaiKubun;
    }

    /**
     * 要介護状態区分のsetメソッドです。
     *
     * @param yokaigoJotaiKubun 要介護状態区分
     */
    public void setYokaigoJotaiKubun(Code yokaigoJotaiKubun) {
        this.yokaigoJotaiKubun = yokaigoJotaiKubun;
    }

    /**
     * 認定有効期間開始年月日のgetメソッドです。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate getNinteiYukoKaishiYMD() {
        return ninteiYukoKaishiYMD;
    }

    /**
     * 認定有効期間開始年月日のsetメソッドです。
     *
     * @param ninteiYukoKaishiYMD 認定有効期間開始年月日
     */
    public void setNinteiYukoKaishiYMD(FlexibleDate ninteiYukoKaishiYMD) {
        this.ninteiYukoKaishiYMD = ninteiYukoKaishiYMD;
    }

    /**
     * 認定有効期間終了年月日のgetメソッドです。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate getNinteiYukoShuryoYMD() {
        return ninteiYukoShuryoYMD;
    }

    /**
     * 認定有効期間終了年月日のsetメソッドです。
     *
     * @param ninteiYukoShuryoYMD 認定有効期間終了年月日
     */
    public void setNinteiYukoShuryoYMD(FlexibleDate ninteiYukoShuryoYMD) {
        this.ninteiYukoShuryoYMD = ninteiYukoShuryoYMD;
    }

    /**
     * 加害者郵便番号のgetメソッドです。
     *
     * @return 加害者郵便番号
     */
    public YubinNo getKagaisha_YubinNo() {
        return kagaisha_YubinNo;
    }

    /**
     * 加害者郵便番号のsetメソッドです。
     *
     * @param kagaisha_YubinNo 加害者郵便番号
     */
    public void setKagaisha_YubinNo(YubinNo kagaisha_YubinNo) {
        this.kagaisha_YubinNo = kagaisha_YubinNo;
    }

    /**
     * 加害者住所のgetメソッドです。
     *
     * @return 加害者住所
     */
    public RString getKagaisha_Jusho() {
        return kagaisha_Jusho;
    }

    /**
     * 加害者住所のsetメソッドです。
     *
     * @param kagaisha_Jusho 加害者住所
     */
    public void setKagaisha_Jusho(RString kagaisha_Jusho) {
        this.kagaisha_Jusho = kagaisha_Jusho;
    }

    /**
     * 加害者氏名カナのgetメソッドです。
     *
     * @return 加害者氏名カナ
     */
    public AtenaKanaMeisho getKagaisha_ShimeiKana() {
        return kagaisha_ShimeiKana;
    }

    /**
     * 加害者氏名カナのsetメソッドです。
     *
     * @param kagaisha_ShimeiKana 加害者氏名カナ
     */
    public void setKagaisha_ShimeiKana(AtenaKanaMeisho kagaisha_ShimeiKana) {
        this.kagaisha_ShimeiKana = kagaisha_ShimeiKana;
    }

    /**
     * 加害者氏名のgetメソッドです。
     *
     * @return 加害者氏名
     */
    public AtenaMeisho getKagansha_Shimei() {
        return kagansha_Shimei;
    }

    /**
     * 加害者氏名のsetメソッドです。
     *
     * @param kagansha_Shimei 加害者氏名
     */
    public void setKagansha_Shimei(AtenaMeisho kagansha_Shimei) {
        this.kagansha_Shimei = kagansha_Shimei;
    }

    /**
     * 加害者生年月日のgetメソッドです。
     *
     * @return 加害者生年月日
     */
    public FlexibleDate getKagaisha_UmareYMD() {
        return kagaisha_UmareYMD;
    }

    /**
     * 加害者生年月日のsetメソッドです。
     *
     * @param kagaisha_UmareYMD 加害者生年月日
     */
    public void setKagaisha_UmareYMD(FlexibleDate kagaisha_UmareYMD) {
        this.kagaisha_UmareYMD = kagaisha_UmareYMD;
    }

    /**
     * 加害者電話番号のgetメソッドです。
     *
     * @return 加害者電話番号
     */
    public TelNo getKagaisha_TelNo() {
        return kagaisha_TelNo;
    }

    /**
     * 加害者電話番号のsetメソッドです。
     *
     * @param kagaisha_TelNo 加害者電話番号
     */
    public void setKagaisha_TelNo(TelNo kagaisha_TelNo) {
        this.kagaisha_TelNo = kagaisha_TelNo;
    }

    /**
     * 加害者職業のgetメソッドです。
     *
     * @return 加害者職業
     */
    public RString getKagaisha_Shokugyo() {
        return kagaisha_Shokugyo;
    }

    /**
     * 加害者職業のsetメソッドです。
     *
     * @param kagaisha_Shokugyo 加害者職業
     */
    public void setKagaisha_Shokugyo(RString kagaisha_Shokugyo) {
        this.kagaisha_Shokugyo = kagaisha_Shokugyo;
    }

    /**
     * 使用者郵便番号のgetメソッドです。
     * <br/>
     * <br/>加害者の使用者
     *
     * @return 使用者郵便番号
     */
    public YubinNo getShiyosha_YubinNo() {
        return shiyosha_YubinNo;
    }

    /**
     * 使用者郵便番号のsetメソッドです。
     * <br/>
     * <br/>加害者の使用者
     *
     * @param shiyosha_YubinNo 使用者郵便番号
     */
    public void setShiyosha_YubinNo(YubinNo shiyosha_YubinNo) {
        this.shiyosha_YubinNo = shiyosha_YubinNo;
    }

    /**
     * 使用者住所のgetメソッドです。
     *
     * @return 使用者住所
     */
    public RString getShiyosha_Jusho() {
        return shiyosha_Jusho;
    }

    /**
     * 使用者住所のsetメソッドです。
     *
     * @param shiyosha_Jusho 使用者住所
     */
    public void setShiyosha_Jusho(RString shiyosha_Jusho) {
        this.shiyosha_Jusho = shiyosha_Jusho;
    }

    /**
     * 使用者氏名カナのgetメソッドです。
     *
     * @return 使用者氏名カナ
     */
    public AtenaKanaMeisho getShiyosha_ShimeiKana() {
        return shiyosha_ShimeiKana;
    }

    /**
     * 使用者氏名カナのsetメソッドです。
     *
     * @param shiyosha_ShimeiKana 使用者氏名カナ
     */
    public void setShiyosha_ShimeiKana(AtenaKanaMeisho shiyosha_ShimeiKana) {
        this.shiyosha_ShimeiKana = shiyosha_ShimeiKana;
    }

    /**
     * 使用者氏名のgetメソッドです。
     *
     * @return 使用者氏名
     */
    public AtenaMeisho getShiyosha_Shimei() {
        return shiyosha_Shimei;
    }

    /**
     * 使用者氏名のsetメソッドです。
     *
     * @param shiyosha_Shimei 使用者氏名
     */
    public void setShiyosha_Shimei(AtenaMeisho shiyosha_Shimei) {
        this.shiyosha_Shimei = shiyosha_Shimei;
    }

    /**
     * 使用者生年月日のgetメソッドです。
     *
     * @return 使用者生年月日
     */
    public FlexibleDate getShiyosha_UmareYMD() {
        return shiyosha_UmareYMD;
    }

    /**
     * 使用者生年月日のsetメソッドです。
     *
     * @param shiyosha_UmareYMD 使用者生年月日
     */
    public void setShiyosha_UmareYMD(FlexibleDate shiyosha_UmareYMD) {
        this.shiyosha_UmareYMD = shiyosha_UmareYMD;
    }

    /**
     * 使用者電話番号のgetメソッドです。
     *
     * @return 使用者電話番号
     */
    public TelNo getShiyosha_TelNo() {
        return shiyosha_TelNo;
    }

    /**
     * 使用者電話番号のsetメソッドです。
     *
     * @param shiyosha_TelNo 使用者電話番号
     */
    public void setShiyosha_TelNo(TelNo shiyosha_TelNo) {
        this.shiyosha_TelNo = shiyosha_TelNo;
    }

    /**
     * 使用者職業のgetメソッドです。
     *
     * @return 使用者職業
     */
    public RString getShiyosha_Shokugyo() {
        return shiyosha_Shokugyo;
    }

    /**
     * 使用者職業のsetメソッドです。
     *
     * @param shiyosha_Shokugyo 使用者職業
     */
    public void setShiyosha_Shokugyo(RString shiyosha_Shokugyo) {
        this.shiyosha_Shokugyo = shiyosha_Shokugyo;
    }

    /**
     * 負傷年月日のgetメソッドです。
     *
     * @return 負傷年月日
     */
    public FlexibleDate getFushoYMD() {
        return fushoYMD;
    }

    /**
     * 負傷年月日のsetメソッドです。
     *
     * @param fushoYMD 負傷年月日
     */
    public void setFushoYMD(FlexibleDate fushoYMD) {
        this.fushoYMD = fushoYMD;
    }

    /**
     * 負傷時間のgetメソッドです。
     *
     * @return 負傷時間
     */
    public RString getFushoTime() {
        return fushoTime;
    }

    /**
     * 負傷時間のsetメソッドです。
     *
     * @param fushoTime 負傷時間
     */
    public void setFushoTime(RString fushoTime) {
        this.fushoTime = fushoTime;
    }

    /**
     * 負傷時の場所のgetメソッドです。
     *
     * @return 負傷時の場所
     */
    public RString getFushoJi_Basho() {
        return fushoJi_Basho;
    }

    /**
     * 負傷時の場所のsetメソッドです。
     *
     * @param fushoJi_Basho 負傷時の場所
     */
    public void setFushoJi_Basho(RString fushoJi_Basho) {
        this.fushoJi_Basho = fushoJi_Basho;
    }

    /**
     * 発病原因・負傷時状況のgetメソッドです。
     *
     * @return 発病原因・負傷時状況
     */
    public RString getHasshoGeiin_FushoJiJokyo() {
        return hasshoGeiin_FushoJiJokyo;
    }

    /**
     * 発病原因・負傷時状況のsetメソッドです。
     *
     * @param hasshoGeiin_FushoJiJokyo 発病原因・負傷時状況
     */
    public void setHasshoGeiin_FushoJiJokyo(RString hasshoGeiin_FushoJiJokyo) {
        this.hasshoGeiin_FushoJiJokyo = hasshoGeiin_FushoJiJokyo;
    }

    /**
     * 自賠責保険契約会社名のgetメソッドです。
     *
     * @return 自賠責保険契約会社名
     */
    public AtenaMeisho getJibaisekiHoken_KeiyakuKaishaMei() {
        return jibaisekiHoken_KeiyakuKaishaMei;
    }

    /**
     * 自賠責保険契約会社名のsetメソッドです。
     *
     * @param jibaisekiHoken_KeiyakuKaishaMei 自賠責保険契約会社名
     */
    public void setJibaisekiHoken_KeiyakuKaishaMei(AtenaMeisho jibaisekiHoken_KeiyakuKaishaMei) {
        this.jibaisekiHoken_KeiyakuKaishaMei = jibaisekiHoken_KeiyakuKaishaMei;
    }

    /**
     * 自賠責保険証明書番号のgetメソッドです。
     *
     * @return 自賠責保険証明書番号
     */
    public RString getJibaisekiHoken_ShomeishoNo() {
        return jibaisekiHoken_ShomeishoNo;
    }

    /**
     * 自賠責保険証明書番号のsetメソッドです。
     *
     * @param jibaisekiHoken_ShomeishoNo 自賠責保険証明書番号
     */
    public void setJibaisekiHoken_ShomeishoNo(RString jibaisekiHoken_ShomeishoNo) {
        this.jibaisekiHoken_ShomeishoNo = jibaisekiHoken_ShomeishoNo;
    }

    /**
     * 自賠責保険契約者住所のgetメソッドです。
     *
     * @return 自賠責保険契約者住所
     */
    public RString getJibaisekiHoken_KeiyakushaJusho() {
        return jibaisekiHoken_KeiyakushaJusho;
    }

    /**
     * 自賠責保険契約者住所のsetメソッドです。
     *
     * @param jibaisekiHoken_KeiyakushaJusho 自賠責保険契約者住所
     */
    public void setJibaisekiHoken_KeiyakushaJusho(RString jibaisekiHoken_KeiyakushaJusho) {
        this.jibaisekiHoken_KeiyakushaJusho = jibaisekiHoken_KeiyakushaJusho;
    }

    /**
     * 所有者住所のgetメソッドです。
     *
     * @return 所有者住所
     */
    public RString getShoyushaJusho() {
        return shoyushaJusho;
    }

    /**
     * 所有者住所のsetメソッドです。
     *
     * @param shoyushaJusho 所有者住所
     */
    public void setShoyushaJusho(RString shoyushaJusho) {
        this.shoyushaJusho = shoyushaJusho;
    }

    /**
     * 所有者氏名のgetメソッドです。
     *
     * @return 所有者氏名
     */
    public AtenaMeisho getShoyushaShimei() {
        return shoyushaShimei;
    }

    /**
     * 所有者氏名のsetメソッドです。
     *
     * @param shoyushaShimei 所有者氏名
     */
    public void setShoyushaShimei(AtenaMeisho shoyushaShimei) {
        this.shoyushaShimei = shoyushaShimei;
    }

    /**
     * 登録番号のgetメソッドです。
     * <br/>
     * <br/>（車両番号）
     *
     * @return 登録番号
     */
    public RString getTorokuNo() {
        return torokuNo;
    }

    /**
     * 登録番号のsetメソッドです。
     * <br/>
     * <br/>（車両番号）
     *
     * @param torokuNo 登録番号
     */
    public void setTorokuNo(RString torokuNo) {
        this.torokuNo = torokuNo;
    }

    /**
     * 車台番号のgetメソッドです。
     *
     * @return 車台番号
     */
    public RString getShadaiNo() {
        return shadaiNo;
    }

    /**
     * 車台番号のsetメソッドです。
     *
     * @param shadaiNo 車台番号
     */
    public void setShadaiNo(RString shadaiNo) {
        this.shadaiNo = shadaiNo;
    }

    /**
     * 任意保険対人保障有無のgetメソッドです。
     *
     * @return 任意保険対人保障有無
     */
    public RString getNiniHoken_TaijinHoshoUmu() {
        return niniHoken_TaijinHoshoUmu;
    }

    /**
     * 任意保険対人保障有無のsetメソッドです。
     *
     * @param niniHoken_TaijinHoshoUmu 任意保険対人保障有無
     */
    public void setNiniHoken_TaijinHoshoUmu(RString niniHoken_TaijinHoshoUmu) {
        this.niniHoken_TaijinHoshoUmu = niniHoken_TaijinHoshoUmu;
    }

    /**
     * 任意保険対人保障保険契約会社名のgetメソッドです。
     *
     * @return 任意保険対人保障保険契約会社名
     */
    public AtenaMeisho getNiniHoken_TaijinHoshoKaishaMei() {
        return niniHoken_TaijinHoshoKaishaMei;
    }

    /**
     * 任意保険対人保障保険契約会社名のsetメソッドです。
     *
     * @param niniHoken_TaijinHoshoKaishaMei 任意保険対人保障保険契約会社名
     */
    public void setNiniHoken_TaijinHoshoKaishaMei(AtenaMeisho niniHoken_TaijinHoshoKaishaMei) {
        this.niniHoken_TaijinHoshoKaishaMei = niniHoken_TaijinHoshoKaishaMei;
    }

    /**
     * 任意保険対人保障保険契約会社連絡先のgetメソッドです。
     *
     * @return 任意保険対人保障保険契約会社連絡先
     */
    public TelNo getNiniHoken_TaijinHoshoKaishaTelNo() {
        return niniHoken_TaijinHoshoKaishaTelNo;
    }

    /**
     * 任意保険対人保障保険契約会社連絡先のsetメソッドです。
     *
     * @param niniHoken_TaijinHoshoKaishaTelNo 任意保険対人保障保険契約会社連絡先
     */
    public void setNiniHoken_TaijinHoshoKaishaTelNo(TelNo niniHoken_TaijinHoshoKaishaTelNo) {
        this.niniHoken_TaijinHoshoKaishaTelNo = niniHoken_TaijinHoshoKaishaTelNo;
    }

    /**
     * 任意保険対人保障保険契約会社担当者のgetメソッドです。
     *
     * @return 任意保険対人保障保険契約会社担当者
     */
    public AtenaMeisho getNiniHoken_TaijinHoshoKaishaTantosha() {
        return niniHoken_TaijinHoshoKaishaTantosha;
    }

    /**
     * 任意保険対人保障保険契約会社担当者のsetメソッドです。
     *
     * @param niniHoken_TaijinHoshoKaishaTantosha 任意保険対人保障保険契約会社担当者
     */
    public void setNiniHoken_TaijinHoshoKaishaTantosha(AtenaMeisho niniHoken_TaijinHoshoKaishaTantosha) {
        this.niniHoken_TaijinHoshoKaishaTantosha = niniHoken_TaijinHoshoKaishaTantosha;
    }

    /**
     * 示談成立有無のgetメソッドです。
     *
     * @return 示談成立有無
     */
    public RString getJidan_SeiritsuUmu() {
        return jidan_SeiritsuUmu;
    }

    /**
     * 示談成立有無のsetメソッドです。
     *
     * @param jidan_SeiritsuUmu 示談成立有無
     */
    public void setJidan_SeiritsuUmu(RString jidan_SeiritsuUmu) {
        this.jidan_SeiritsuUmu = jidan_SeiritsuUmu;
    }

    /**
     * 示談成立年月日のgetメソッドです。
     *
     * @return 示談成立年月日
     */
    public FlexibleDate getJidan_SeiritsuYMD() {
        return jidan_SeiritsuYMD;
    }

    /**
     * 示談成立年月日のsetメソッドです。
     *
     * @param jidan_SeiritsuYMD 示談成立年月日
     */
    public void setJidan_SeiritsuYMD(FlexibleDate jidan_SeiritsuYMD) {
        this.jidan_SeiritsuYMD = jidan_SeiritsuYMD;
    }

    /**
     * 損害賠償交渉経過のgetメソッドです。
     *
     * @return 損害賠償交渉経過
     */
    public RString getSongaiBaishoKoshoKeika() {
        return songaiBaishoKoshoKeika;
    }

    /**
     * 損害賠償交渉経過のsetメソッドです。
     *
     * @param songaiBaishoKoshoKeika 損害賠償交渉経過
     */
    public void setSongaiBaishoKoshoKeika(RString songaiBaishoKoshoKeika) {
        this.songaiBaishoKoshoKeika = songaiBaishoKoshoKeika;
    }

    /**
     * 事故発生状況報告書有無のgetメソッドです。
     *
     * @return 事故発生状況報告書有無
     */
    public RString getJikoHasseiJokyoHokokushoUmu() {
        return jikoHasseiJokyoHokokushoUmu;
    }

    /**
     * 事故発生状況報告書有無のsetメソッドです。
     *
     * @param jikoHasseiJokyoHokokushoUmu 事故発生状況報告書有無
     */
    public void setJikoHasseiJokyoHokokushoUmu(RString jikoHasseiJokyoHokokushoUmu) {
        this.jikoHasseiJokyoHokokushoUmu = jikoHasseiJokyoHokokushoUmu;
    }

    /**
     * 念書兼同意書有無のgetメソッドです。
     *
     * @return 念書兼同意書有無
     */
    public RString getNensho_DoishoUmu() {
        return nensho_DoishoUmu;
    }

    /**
     * 念書兼同意書有無のsetメソッドです。
     *
     * @param nensho_DoishoUmu 念書兼同意書有無
     */
    public void setNensho_DoishoUmu(RString nensho_DoishoUmu) {
        this.nensho_DoishoUmu = nensho_DoishoUmu;
    }

    /**
     * 誓約書有無のgetメソッドです。
     *
     * @return 誓約書有無
     */
    public RString getSeiyakushoUmu() {
        return seiyakushoUmu;
    }

    /**
     * 誓約書有無のsetメソッドです。
     *
     * @param seiyakushoUmu 誓約書有無
     */
    public void setSeiyakushoUmu(RString seiyakushoUmu) {
        this.seiyakushoUmu = seiyakushoUmu;
    }

    /**
     * 交通事故証明書有無のgetメソッドです。
     *
     * @return 交通事故証明書有無
     */
    public RString getKotsuJikoShomeishoUmu() {
        return kotsuJikoShomeishoUmu;
    }

    /**
     * 交通事故証明書有無のsetメソッドです。
     *
     * @param kotsuJikoShomeishoUmu 交通事故証明書有無
     */
    public void setKotsuJikoShomeishoUmu(RString kotsuJikoShomeishoUmu) {
        this.kotsuJikoShomeishoUmu = kotsuJikoShomeishoUmu;
    }

    /**
     * 人身事故証明書入手不能理由書有無のgetメソッドです。
     *
     * @return 人身事故証明書入手不能理由書有無
     */
    public RString getJinshinJikoShomeisho_NyushuFunoRiyushoUmu() {
        return jinshinJikoShomeisho_NyushuFunoRiyushoUmu;
    }

    /**
     * 人身事故証明書入手不能理由書有無のsetメソッドです。
     *
     * @param jinshinJikoShomeisho_NyushuFunoRiyushoUmu 人身事故証明書入手不能理由書有無
     */
    public void setJinshinJikoShomeisho_NyushuFunoRiyushoUmu(RString jinshinJikoShomeisho_NyushuFunoRiyushoUmu) {
        this.jinshinJikoShomeisho_NyushuFunoRiyushoUmu = jinshinJikoShomeisho_NyushuFunoRiyushoUmu;
    }

    /**
     * 示談書写し有無のgetメソッドです。
     *
     * @return 示談書写し有無
     */
    public RString getJidanshoUtsushiUmu() {
        return jidanshoUtsushiUmu;
    }

    /**
     * 示談書写し有無のsetメソッドです。
     *
     * @param jidanshoUtsushiUmu 示談書写し有無
     */
    public void setJidanshoUtsushiUmu(RString jidanshoUtsushiUmu) {
        this.jidanshoUtsushiUmu = jidanshoUtsushiUmu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3084DaisanshaKoiTodokedeEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3084DaisanshaKoiTodokedeEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3084DaisanshaKoiTodokedeEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.todokedeKanriNo, other.todokedeKanriNo)) {
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
    public void shallowCopy(DbT3084DaisanshaKoiTodokedeEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.todokedeKanriNo = entity.todokedeKanriNo;
        this.rirekiNo = entity.rirekiNo;
        this.todokedeYMD = entity.todokedeYMD;
        this.todokedenin_YubinNo = entity.todokedenin_YubinNo;
        this.todokedenin_Jusho = entity.todokedenin_Jusho;
        this.todokedenin_ShimeiKana = entity.todokedenin_ShimeiKana;
        this.todokedenin_Shimei = entity.todokedenin_Shimei;
        this.todokedenin_TelNo = entity.todokedenin_TelNo;
        this.todokedenin_Zokugara = entity.todokedenin_Zokugara;
        this.yokaigoJotaiKubun = entity.yokaigoJotaiKubun;
        this.ninteiYukoKaishiYMD = entity.ninteiYukoKaishiYMD;
        this.ninteiYukoShuryoYMD = entity.ninteiYukoShuryoYMD;
        this.kagaisha_YubinNo = entity.kagaisha_YubinNo;
        this.kagaisha_Jusho = entity.kagaisha_Jusho;
        this.kagaisha_ShimeiKana = entity.kagaisha_ShimeiKana;
        this.kagansha_Shimei = entity.kagansha_Shimei;
        this.kagaisha_UmareYMD = entity.kagaisha_UmareYMD;
        this.kagaisha_TelNo = entity.kagaisha_TelNo;
        this.kagaisha_Shokugyo = entity.kagaisha_Shokugyo;
        this.shiyosha_YubinNo = entity.shiyosha_YubinNo;
        this.shiyosha_Jusho = entity.shiyosha_Jusho;
        this.shiyosha_ShimeiKana = entity.shiyosha_ShimeiKana;
        this.shiyosha_Shimei = entity.shiyosha_Shimei;
        this.shiyosha_UmareYMD = entity.shiyosha_UmareYMD;
        this.shiyosha_TelNo = entity.shiyosha_TelNo;
        this.shiyosha_Shokugyo = entity.shiyosha_Shokugyo;
        this.fushoYMD = entity.fushoYMD;
        this.fushoTime = entity.fushoTime;
        this.fushoJi_Basho = entity.fushoJi_Basho;
        this.hasshoGeiin_FushoJiJokyo = entity.hasshoGeiin_FushoJiJokyo;
        this.jibaisekiHoken_KeiyakuKaishaMei = entity.jibaisekiHoken_KeiyakuKaishaMei;
        this.jibaisekiHoken_ShomeishoNo = entity.jibaisekiHoken_ShomeishoNo;
        this.jibaisekiHoken_KeiyakushaJusho = entity.jibaisekiHoken_KeiyakushaJusho;
        this.shoyushaJusho = entity.shoyushaJusho;
        this.shoyushaShimei = entity.shoyushaShimei;
        this.torokuNo = entity.torokuNo;
        this.shadaiNo = entity.shadaiNo;
        this.niniHoken_TaijinHoshoUmu = entity.niniHoken_TaijinHoshoUmu;
        this.niniHoken_TaijinHoshoKaishaMei = entity.niniHoken_TaijinHoshoKaishaMei;
        this.niniHoken_TaijinHoshoKaishaTelNo = entity.niniHoken_TaijinHoshoKaishaTelNo;
        this.niniHoken_TaijinHoshoKaishaTantosha = entity.niniHoken_TaijinHoshoKaishaTantosha;
        this.jidan_SeiritsuUmu = entity.jidan_SeiritsuUmu;
        this.jidan_SeiritsuYMD = entity.jidan_SeiritsuYMD;
        this.songaiBaishoKoshoKeika = entity.songaiBaishoKoshoKeika;
        this.jikoHasseiJokyoHokokushoUmu = entity.jikoHasseiJokyoHokokushoUmu;
        this.nensho_DoishoUmu = entity.nensho_DoishoUmu;
        this.seiyakushoUmu = entity.seiyakushoUmu;
        this.kotsuJikoShomeishoUmu = entity.kotsuJikoShomeishoUmu;
        this.jinshinJikoShomeisho_NyushuFunoRiyushoUmu = entity.jinshinJikoShomeisho_NyushuFunoRiyushoUmu;
        this.jidanshoUtsushiUmu = entity.jidanshoUtsushiUmu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, todokedeKanriNo, rirekiNo, todokedeYMD, todokedenin_YubinNo, todokedenin_Jusho, todokedenin_ShimeiKana, todokedenin_Shimei, todokedenin_TelNo, todokedenin_Zokugara, yokaigoJotaiKubun, ninteiYukoKaishiYMD, ninteiYukoShuryoYMD, kagaisha_YubinNo, kagaisha_Jusho, kagaisha_ShimeiKana, kagansha_Shimei, kagaisha_UmareYMD, kagaisha_TelNo, kagaisha_Shokugyo, shiyosha_YubinNo, shiyosha_Jusho, shiyosha_ShimeiKana, shiyosha_Shimei, shiyosha_UmareYMD, shiyosha_TelNo, shiyosha_Shokugyo, fushoYMD, fushoTime, fushoJi_Basho, hasshoGeiin_FushoJiJokyo, jibaisekiHoken_KeiyakuKaishaMei, jibaisekiHoken_ShomeishoNo, jibaisekiHoken_KeiyakushaJusho, shoyushaJusho, shoyushaShimei, torokuNo, shadaiNo, niniHoken_TaijinHoshoUmu, niniHoken_TaijinHoshoKaishaMei, niniHoken_TaijinHoshoKaishaTelNo, niniHoken_TaijinHoshoKaishaTantosha, jidan_SeiritsuUmu, jidan_SeiritsuYMD, songaiBaishoKoshoKeika, jikoHasseiJokyoHokokushoUmu, nensho_DoishoUmu, seiyakushoUmu, kotsuJikoShomeishoUmu, jinshinJikoShomeisho_NyushuFunoRiyushoUmu, jidanshoUtsushiUmu);
    }

// </editor-fold>
}

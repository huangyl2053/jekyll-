package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3084DaisanshaKoiTodokedeの項目定義クラスです
 *
 */
public class DbT3084DaisanshaKoiTodokedeEntity extends DbTableEntityBase<DbT3084DaisanshaKoiTodokedeEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    private YMDHMS shoriTimestamp;
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
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getTodokedeKanriNo
     *
     * @return todokedeKanriNo
     */
    public RString getTodokedeKanriNo() {
        return todokedeKanriNo;
    }

    /**
     * setTodokedeKanriNo
     *
     * @param todokedeKanriNo todokedeKanriNo
     */
    public void setTodokedeKanriNo(RString todokedeKanriNo) {
        this.todokedeKanriNo = todokedeKanriNo;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getTodokedeYMD
     *
     * @return todokedeYMD
     */
    public FlexibleDate getTodokedeYMD() {
        return todokedeYMD;
    }

    /**
     * setTodokedeYMD
     *
     * @param todokedeYMD todokedeYMD
     */
    public void setTodokedeYMD(FlexibleDate todokedeYMD) {
        this.todokedeYMD = todokedeYMD;
    }

    /**
     * getTodokedenin_YubinNo
     *
     * @return todokedenin_YubinNo
     */
    public YubinNo getTodokedenin_YubinNo() {
        return todokedenin_YubinNo;
    }

    /**
     * setTodokedenin_YubinNo
     *
     * @param todokedenin_YubinNo todokedenin_YubinNo
     */
    public void setTodokedenin_YubinNo(YubinNo todokedenin_YubinNo) {
        this.todokedenin_YubinNo = todokedenin_YubinNo;
    }

    /**
     * getTodokedenin_Jusho
     *
     * @return todokedenin_Jusho
     */
    public RString getTodokedenin_Jusho() {
        return todokedenin_Jusho;
    }

    /**
     * setTodokedenin_Jusho
     *
     * @param todokedenin_Jusho todokedenin_Jusho
     */
    public void setTodokedenin_Jusho(RString todokedenin_Jusho) {
        this.todokedenin_Jusho = todokedenin_Jusho;
    }

    /**
     * getTodokedenin_ShimeiKana
     *
     * @return todokedenin_ShimeiKana
     */
    public AtenaKanaMeisho getTodokedenin_ShimeiKana() {
        return todokedenin_ShimeiKana;
    }

    /**
     * setTodokedenin_ShimeiKana
     *
     * @param todokedenin_ShimeiKana todokedenin_ShimeiKana
     */
    public void setTodokedenin_ShimeiKana(AtenaKanaMeisho todokedenin_ShimeiKana) {
        this.todokedenin_ShimeiKana = todokedenin_ShimeiKana;
    }

    /**
     * getTodokedenin_Shimei
     *
     * @return todokedenin_Shimei
     */
    public AtenaMeisho getTodokedenin_Shimei() {
        return todokedenin_Shimei;
    }

    /**
     * setTodokedenin_Shimei
     *
     * @param todokedenin_Shimei todokedenin_Shimei
     */
    public void setTodokedenin_Shimei(AtenaMeisho todokedenin_Shimei) {
        this.todokedenin_Shimei = todokedenin_Shimei;
    }

    /**
     * getTodokedenin_TelNo
     *
     * @return todokedenin_TelNo
     */
    public TelNo getTodokedenin_TelNo() {
        return todokedenin_TelNo;
    }

    /**
     * setTodokedenin_TelNo
     *
     * @param todokedenin_TelNo todokedenin_TelNo
     */
    public void setTodokedenin_TelNo(TelNo todokedenin_TelNo) {
        this.todokedenin_TelNo = todokedenin_TelNo;
    }

    /**
     * getTodokedenin_Zokugara
     *
     * @return todokedenin_Zokugara
     */
    public RString getTodokedenin_Zokugara() {
        return todokedenin_Zokugara;
    }

    /**
     * setTodokedenin_Zokugara
     *
     * @param todokedenin_Zokugara todokedenin_Zokugara
     */
    public void setTodokedenin_Zokugara(RString todokedenin_Zokugara) {
        this.todokedenin_Zokugara = todokedenin_Zokugara;
    }

    /**
     * getYokaigoJotaiKubun
     *
     * @return yokaigoJotaiKubun
     */
    public Code getYokaigoJotaiKubun() {
        return yokaigoJotaiKubun;
    }

    /**
     * setYokaigoJotaiKubun
     *
     * @param yokaigoJotaiKubun yokaigoJotaiKubun
     */
    public void setYokaigoJotaiKubun(Code yokaigoJotaiKubun) {
        this.yokaigoJotaiKubun = yokaigoJotaiKubun;
    }

    /**
     * getNinteiYukoKaishiYMD
     *
     * @return ninteiYukoKaishiYMD
     */
    public FlexibleDate getNinteiYukoKaishiYMD() {
        return ninteiYukoKaishiYMD;
    }

    /**
     * setNinteiYukoKaishiYMD
     *
     * @param ninteiYukoKaishiYMD ninteiYukoKaishiYMD
     */
    public void setNinteiYukoKaishiYMD(FlexibleDate ninteiYukoKaishiYMD) {
        this.ninteiYukoKaishiYMD = ninteiYukoKaishiYMD;
    }

    /**
     * getNinteiYukoShuryoYMD
     *
     * @return ninteiYukoShuryoYMD
     */
    public FlexibleDate getNinteiYukoShuryoYMD() {
        return ninteiYukoShuryoYMD;
    }

    /**
     * setNinteiYukoShuryoYMD
     *
     * @param ninteiYukoShuryoYMD ninteiYukoShuryoYMD
     */
    public void setNinteiYukoShuryoYMD(FlexibleDate ninteiYukoShuryoYMD) {
        this.ninteiYukoShuryoYMD = ninteiYukoShuryoYMD;
    }

    /**
     * getKagaisha_YubinNo
     *
     * @return kagaisha_YubinNo
     */
    public YubinNo getKagaisha_YubinNo() {
        return kagaisha_YubinNo;
    }

    /**
     * setKagaisha_YubinNo
     *
     * @param kagaisha_YubinNo kagaisha_YubinNo
     */
    public void setKagaisha_YubinNo(YubinNo kagaisha_YubinNo) {
        this.kagaisha_YubinNo = kagaisha_YubinNo;
    }

    /**
     * getKagaisha_Jusho
     *
     * @return kagaisha_Jusho
     */
    public RString getKagaisha_Jusho() {
        return kagaisha_Jusho;
    }

    /**
     * setKagaisha_Jusho
     *
     * @param kagaisha_Jusho kagaisha_Jusho
     */
    public void setKagaisha_Jusho(RString kagaisha_Jusho) {
        this.kagaisha_Jusho = kagaisha_Jusho;
    }

    /**
     * getKagaisha_ShimeiKana
     *
     * @return kagaisha_ShimeiKana
     */
    public AtenaKanaMeisho getKagaisha_ShimeiKana() {
        return kagaisha_ShimeiKana;
    }

    /**
     * setKagaisha_ShimeiKana
     *
     * @param kagaisha_ShimeiKana kagaisha_ShimeiKana
     */
    public void setKagaisha_ShimeiKana(AtenaKanaMeisho kagaisha_ShimeiKana) {
        this.kagaisha_ShimeiKana = kagaisha_ShimeiKana;
    }

    /**
     * getKagansha_Shimei
     *
     * @return kagansha_Shimei
     */
    public AtenaMeisho getKagansha_Shimei() {
        return kagansha_Shimei;
    }

    /**
     * setKagansha_Shimei
     *
     * @param kagansha_Shimei kagansha_Shimei
     */
    public void setKagansha_Shimei(AtenaMeisho kagansha_Shimei) {
        this.kagansha_Shimei = kagansha_Shimei;
    }

    /**
     * getKagaisha_UmareYMD
     *
     * @return kagaisha_UmareYMD
     */
    public FlexibleDate getKagaisha_UmareYMD() {
        return kagaisha_UmareYMD;
    }

    /**
     * setKagaisha_UmareYMD
     *
     * @param kagaisha_UmareYMD kagaisha_UmareYMD
     */
    public void setKagaisha_UmareYMD(FlexibleDate kagaisha_UmareYMD) {
        this.kagaisha_UmareYMD = kagaisha_UmareYMD;
    }

    /**
     * getKagaisha_TelNo
     *
     * @return kagaisha_TelNo
     */
    public TelNo getKagaisha_TelNo() {
        return kagaisha_TelNo;
    }

    /**
     * setKagaisha_TelNo
     *
     * @param kagaisha_TelNo kagaisha_TelNo
     */
    public void setKagaisha_TelNo(TelNo kagaisha_TelNo) {
        this.kagaisha_TelNo = kagaisha_TelNo;
    }

    /**
     * getKagaisha_Shokugyo
     *
     * @return kagaisha_Shokugyo
     */
    public RString getKagaisha_Shokugyo() {
        return kagaisha_Shokugyo;
    }

    /**
     * setKagaisha_Shokugyo
     *
     * @param kagaisha_Shokugyo kagaisha_Shokugyo
     */
    public void setKagaisha_Shokugyo(RString kagaisha_Shokugyo) {
        this.kagaisha_Shokugyo = kagaisha_Shokugyo;
    }

    /**
     * getShiyosha_YubinNo
     *
     * @return shiyosha_YubinNo
     */
    public YubinNo getShiyosha_YubinNo() {
        return shiyosha_YubinNo;
    }

    /**
     * setShiyosha_YubinNo
     *
     * @param shiyosha_YubinNo shiyosha_YubinNo
     */
    public void setShiyosha_YubinNo(YubinNo shiyosha_YubinNo) {
        this.shiyosha_YubinNo = shiyosha_YubinNo;
    }

    /**
     * getShiyosha_Jusho
     *
     * @return shiyosha_Jusho
     */
    public RString getShiyosha_Jusho() {
        return shiyosha_Jusho;
    }

    /**
     * setShiyosha_Jusho
     *
     * @param shiyosha_Jusho shiyosha_Jusho
     */
    public void setShiyosha_Jusho(RString shiyosha_Jusho) {
        this.shiyosha_Jusho = shiyosha_Jusho;
    }

    /**
     * getShiyosha_ShimeiKana
     *
     * @return shiyosha_ShimeiKana
     */
    public AtenaKanaMeisho getShiyosha_ShimeiKana() {
        return shiyosha_ShimeiKana;
    }

    /**
     * setShiyosha_ShimeiKana
     *
     * @param shiyosha_ShimeiKana shiyosha_ShimeiKana
     */
    public void setShiyosha_ShimeiKana(AtenaKanaMeisho shiyosha_ShimeiKana) {
        this.shiyosha_ShimeiKana = shiyosha_ShimeiKana;
    }

    /**
     * getShiyosha_Shimei
     *
     * @return shiyosha_Shimei
     */
    public AtenaMeisho getShiyosha_Shimei() {
        return shiyosha_Shimei;
    }

    /**
     * setShiyosha_Shimei
     *
     * @param shiyosha_Shimei shiyosha_Shimei
     */
    public void setShiyosha_Shimei(AtenaMeisho shiyosha_Shimei) {
        this.shiyosha_Shimei = shiyosha_Shimei;
    }

    /**
     * getShiyosha_UmareYMD
     *
     * @return shiyosha_UmareYMD
     */
    public FlexibleDate getShiyosha_UmareYMD() {
        return shiyosha_UmareYMD;
    }

    /**
     * setShiyosha_UmareYMD
     *
     * @param shiyosha_UmareYMD shiyosha_UmareYMD
     */
    public void setShiyosha_UmareYMD(FlexibleDate shiyosha_UmareYMD) {
        this.shiyosha_UmareYMD = shiyosha_UmareYMD;
    }

    /**
     * getShiyosha_TelNo
     *
     * @return shiyosha_TelNo
     */
    public TelNo getShiyosha_TelNo() {
        return shiyosha_TelNo;
    }

    /**
     * setShiyosha_TelNo
     *
     * @param shiyosha_TelNo shiyosha_TelNo
     */
    public void setShiyosha_TelNo(TelNo shiyosha_TelNo) {
        this.shiyosha_TelNo = shiyosha_TelNo;
    }

    /**
     * getShiyosha_Shokugyo
     *
     * @return shiyosha_Shokugyo
     */
    public RString getShiyosha_Shokugyo() {
        return shiyosha_Shokugyo;
    }

    /**
     * setShiyosha_Shokugyo
     *
     * @param shiyosha_Shokugyo shiyosha_Shokugyo
     */
    public void setShiyosha_Shokugyo(RString shiyosha_Shokugyo) {
        this.shiyosha_Shokugyo = shiyosha_Shokugyo;
    }

    /**
     * getFushoYMD
     *
     * @return fushoYMD
     */
    public FlexibleDate getFushoYMD() {
        return fushoYMD;
    }

    /**
     * setFushoYMD
     *
     * @param fushoYMD fushoYMD
     */
    public void setFushoYMD(FlexibleDate fushoYMD) {
        this.fushoYMD = fushoYMD;
    }

    /**
     * getFushoTime
     *
     * @return fushoTime
     */
    public RString getFushoTime() {
        return fushoTime;
    }

    /**
     * setFushoTime
     *
     * @param fushoTime fushoTime
     */
    public void setFushoTime(RString fushoTime) {
        this.fushoTime = fushoTime;
    }

    /**
     * getFushoJi_Basho
     *
     * @return fushoJi_Basho
     */
    public RString getFushoJi_Basho() {
        return fushoJi_Basho;
    }

    /**
     * setFushoJi_Basho
     *
     * @param fushoJi_Basho fushoJi_Basho
     */
    public void setFushoJi_Basho(RString fushoJi_Basho) {
        this.fushoJi_Basho = fushoJi_Basho;
    }

    /**
     * getHasshoGeiin_FushoJiJokyo
     *
     * @return hasshoGeiin_FushoJiJokyo
     */
    public RString getHasshoGeiin_FushoJiJokyo() {
        return hasshoGeiin_FushoJiJokyo;
    }

    /**
     * setHasshoGeiin_FushoJiJokyo
     *
     * @param hasshoGeiin_FushoJiJokyo hasshoGeiin_FushoJiJokyo
     */
    public void setHasshoGeiin_FushoJiJokyo(RString hasshoGeiin_FushoJiJokyo) {
        this.hasshoGeiin_FushoJiJokyo = hasshoGeiin_FushoJiJokyo;
    }

    /**
     * getJibaisekiHoken_KeiyakuKaishaMei
     *
     * @return jibaisekiHoken_KeiyakuKaishaMei
     */
    public AtenaMeisho getJibaisekiHoken_KeiyakuKaishaMei() {
        return jibaisekiHoken_KeiyakuKaishaMei;
    }

    /**
     * setJibaisekiHoken_KeiyakuKaishaMei
     *
     * @param jibaisekiHoken_KeiyakuKaishaMei jibaisekiHoken_KeiyakuKaishaMei
     */
    public void setJibaisekiHoken_KeiyakuKaishaMei(AtenaMeisho jibaisekiHoken_KeiyakuKaishaMei) {
        this.jibaisekiHoken_KeiyakuKaishaMei = jibaisekiHoken_KeiyakuKaishaMei;
    }

    /**
     * getJibaisekiHoken_ShomeishoNo
     *
     * @return jibaisekiHoken_ShomeishoNo
     */
    public RString getJibaisekiHoken_ShomeishoNo() {
        return jibaisekiHoken_ShomeishoNo;
    }

    /**
     * setJibaisekiHoken_ShomeishoNo
     *
     * @param jibaisekiHoken_ShomeishoNo jibaisekiHoken_ShomeishoNo
     */
    public void setJibaisekiHoken_ShomeishoNo(RString jibaisekiHoken_ShomeishoNo) {
        this.jibaisekiHoken_ShomeishoNo = jibaisekiHoken_ShomeishoNo;
    }

    /**
     * getJibaisekiHoken_KeiyakushaJusho
     *
     * @return jibaisekiHoken_KeiyakushaJusho
     */
    public RString getJibaisekiHoken_KeiyakushaJusho() {
        return jibaisekiHoken_KeiyakushaJusho;
    }

    /**
     * setJibaisekiHoken_KeiyakushaJusho
     *
     * @param jibaisekiHoken_KeiyakushaJusho jibaisekiHoken_KeiyakushaJusho
     */
    public void setJibaisekiHoken_KeiyakushaJusho(RString jibaisekiHoken_KeiyakushaJusho) {
        this.jibaisekiHoken_KeiyakushaJusho = jibaisekiHoken_KeiyakushaJusho;
    }

    /**
     * getShoyushaJusho
     *
     * @return shoyushaJusho
     */
    public RString getShoyushaJusho() {
        return shoyushaJusho;
    }

    /**
     * setShoyushaJusho
     *
     * @param shoyushaJusho shoyushaJusho
     */
    public void setShoyushaJusho(RString shoyushaJusho) {
        this.shoyushaJusho = shoyushaJusho;
    }

    /**
     * getShoyushaShimei
     *
     * @return shoyushaShimei
     */
    public AtenaMeisho getShoyushaShimei() {
        return shoyushaShimei;
    }

    /**
     * setShoyushaShimei
     *
     * @param shoyushaShimei shoyushaShimei
     */
    public void setShoyushaShimei(AtenaMeisho shoyushaShimei) {
        this.shoyushaShimei = shoyushaShimei;
    }

    /**
     * getTorokuNo
     *
     * @return torokuNo
     */
    public RString getTorokuNo() {
        return torokuNo;
    }

    /**
     * setTorokuNo
     *
     * @param torokuNo torokuNo
     */
    public void setTorokuNo(RString torokuNo) {
        this.torokuNo = torokuNo;
    }

    /**
     * getShadaiNo
     *
     * @return shadaiNo
     */
    public RString getShadaiNo() {
        return shadaiNo;
    }

    /**
     * setShadaiNo
     *
     * @param shadaiNo shadaiNo
     */
    public void setShadaiNo(RString shadaiNo) {
        this.shadaiNo = shadaiNo;
    }

    /**
     * getNiniHoken_TaijinHoshoUmu
     *
     * @return niniHoken_TaijinHoshoUmu
     */
    public RString getNiniHoken_TaijinHoshoUmu() {
        return niniHoken_TaijinHoshoUmu;
    }

    /**
     * setNiniHoken_TaijinHoshoUmu
     *
     * @param niniHoken_TaijinHoshoUmu niniHoken_TaijinHoshoUmu
     */
    public void setNiniHoken_TaijinHoshoUmu(RString niniHoken_TaijinHoshoUmu) {
        this.niniHoken_TaijinHoshoUmu = niniHoken_TaijinHoshoUmu;
    }

    /**
     * getNiniHoken_TaijinHoshoKaishaMei
     *
     * @return niniHoken_TaijinHoshoKaishaMei
     */
    public AtenaMeisho getNiniHoken_TaijinHoshoKaishaMei() {
        return niniHoken_TaijinHoshoKaishaMei;
    }

    /**
     * setNiniHoken_TaijinHoshoKaishaMei
     *
     * @param niniHoken_TaijinHoshoKaishaMei niniHoken_TaijinHoshoKaishaMei
     */
    public void setNiniHoken_TaijinHoshoKaishaMei(AtenaMeisho niniHoken_TaijinHoshoKaishaMei) {
        this.niniHoken_TaijinHoshoKaishaMei = niniHoken_TaijinHoshoKaishaMei;
    }

    /**
     * getNiniHoken_TaijinHoshoKaishaTelNo
     *
     * @return niniHoken_TaijinHoshoKaishaTelNo
     */
    public TelNo getNiniHoken_TaijinHoshoKaishaTelNo() {
        return niniHoken_TaijinHoshoKaishaTelNo;
    }

    /**
     * setNiniHoken_TaijinHoshoKaishaTelNo
     *
     * @param niniHoken_TaijinHoshoKaishaTelNo niniHoken_TaijinHoshoKaishaTelNo
     */
    public void setNiniHoken_TaijinHoshoKaishaTelNo(TelNo niniHoken_TaijinHoshoKaishaTelNo) {
        this.niniHoken_TaijinHoshoKaishaTelNo = niniHoken_TaijinHoshoKaishaTelNo;
    }

    /**
     * getNiniHoken_TaijinHoshoKaishaTantosha
     *
     * @return niniHoken_TaijinHoshoKaishaTantosha
     */
    public AtenaMeisho getNiniHoken_TaijinHoshoKaishaTantosha() {
        return niniHoken_TaijinHoshoKaishaTantosha;
    }

    /**
     * setNiniHoken_TaijinHoshoKaishaTantosha
     *
     * @param niniHoken_TaijinHoshoKaishaTantosha niniHoken_TaijinHoshoKaishaTantosha
     */
    public void setNiniHoken_TaijinHoshoKaishaTantosha(AtenaMeisho niniHoken_TaijinHoshoKaishaTantosha) {
        this.niniHoken_TaijinHoshoKaishaTantosha = niniHoken_TaijinHoshoKaishaTantosha;
    }

    /**
     * getJidan_SeiritsuUmu
     *
     * @return jidan_SeiritsuUmu
     */
    public RString getJidan_SeiritsuUmu() {
        return jidan_SeiritsuUmu;
    }

    /**
     * setJidan_SeiritsuUmu
     *
     * @param jidan_SeiritsuUmu jidan_SeiritsuUmu
     */
    public void setJidan_SeiritsuUmu(RString jidan_SeiritsuUmu) {
        this.jidan_SeiritsuUmu = jidan_SeiritsuUmu;
    }

    /**
     * getJidan_SeiritsuYMD
     *
     * @return jidan_SeiritsuYMD
     */
    public FlexibleDate getJidan_SeiritsuYMD() {
        return jidan_SeiritsuYMD;
    }

    /**
     * setJidan_SeiritsuYMD
     *
     * @param jidan_SeiritsuYMD jidan_SeiritsuYMD
     */
    public void setJidan_SeiritsuYMD(FlexibleDate jidan_SeiritsuYMD) {
        this.jidan_SeiritsuYMD = jidan_SeiritsuYMD;
    }

    /**
     * getSongaiBaishoKoshoKeika
     *
     * @return songaiBaishoKoshoKeika
     */
    public RString getSongaiBaishoKoshoKeika() {
        return songaiBaishoKoshoKeika;
    }

    /**
     * setSongaiBaishoKoshoKeika
     *
     * @param songaiBaishoKoshoKeika songaiBaishoKoshoKeika
     */
    public void setSongaiBaishoKoshoKeika(RString songaiBaishoKoshoKeika) {
        this.songaiBaishoKoshoKeika = songaiBaishoKoshoKeika;
    }

    /**
     * getJikoHasseiJokyoHokokushoUmu
     *
     * @return jikoHasseiJokyoHokokushoUmu
     */
    public RString getJikoHasseiJokyoHokokushoUmu() {
        return jikoHasseiJokyoHokokushoUmu;
    }

    /**
     * setJikoHasseiJokyoHokokushoUmu
     *
     * @param jikoHasseiJokyoHokokushoUmu jikoHasseiJokyoHokokushoUmu
     */
    public void setJikoHasseiJokyoHokokushoUmu(RString jikoHasseiJokyoHokokushoUmu) {
        this.jikoHasseiJokyoHokokushoUmu = jikoHasseiJokyoHokokushoUmu;
    }

    /**
     * getNensho_DoishoUmu
     *
     * @return nensho_DoishoUmu
     */
    public RString getNensho_DoishoUmu() {
        return nensho_DoishoUmu;
    }

    /**
     * setNensho_DoishoUmu
     *
     * @param nensho_DoishoUmu nensho_DoishoUmu
     */
    public void setNensho_DoishoUmu(RString nensho_DoishoUmu) {
        this.nensho_DoishoUmu = nensho_DoishoUmu;
    }

    /**
     * getSeiyakushoUmu
     *
     * @return seiyakushoUmu
     */
    public RString getSeiyakushoUmu() {
        return seiyakushoUmu;
    }

    /**
     * setSeiyakushoUmu
     *
     * @param seiyakushoUmu seiyakushoUmu
     */
    public void setSeiyakushoUmu(RString seiyakushoUmu) {
        this.seiyakushoUmu = seiyakushoUmu;
    }

    /**
     * getKotsuJikoShomeishoUmu
     *
     * @return kotsuJikoShomeishoUmu
     */
    public RString getKotsuJikoShomeishoUmu() {
        return kotsuJikoShomeishoUmu;
    }

    /**
     * setKotsuJikoShomeishoUmu
     *
     * @param kotsuJikoShomeishoUmu kotsuJikoShomeishoUmu
     */
    public void setKotsuJikoShomeishoUmu(RString kotsuJikoShomeishoUmu) {
        this.kotsuJikoShomeishoUmu = kotsuJikoShomeishoUmu;
    }

    /**
     * getJinshinJikoShomeisho_NyushuFunoRiyushoUmu
     *
     * @return jinshinJikoShomeisho_NyushuFunoRiyushoUmu
     */
    public RString getJinshinJikoShomeisho_NyushuFunoRiyushoUmu() {
        return jinshinJikoShomeisho_NyushuFunoRiyushoUmu;
    }

    /**
     * setJinshinJikoShomeisho_NyushuFunoRiyushoUmu
     *
     * @param jinshinJikoShomeisho_NyushuFunoRiyushoUmu jinshinJikoShomeisho_NyushuFunoRiyushoUmu
     */
    public void setJinshinJikoShomeisho_NyushuFunoRiyushoUmu(RString jinshinJikoShomeisho_NyushuFunoRiyushoUmu) {
        this.jinshinJikoShomeisho_NyushuFunoRiyushoUmu = jinshinJikoShomeisho_NyushuFunoRiyushoUmu;
    }

    /**
     * getJidanshoUtsushiUmu
     *
     * @return jidanshoUtsushiUmu
     */
    public RString getJidanshoUtsushiUmu() {
        return jidanshoUtsushiUmu;
    }

    /**
     * setJidanshoUtsushiUmu
     *
     * @param jidanshoUtsushiUmu jidanshoUtsushiUmu
     */
    public void setJidanshoUtsushiUmu(RString jidanshoUtsushiUmu) {
        this.jidanshoUtsushiUmu = jidanshoUtsushiUmu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3084DaisanshaKoiTodokedeEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
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
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
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
        this.shoriTimestamp = entity.shoriTimestamp;
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
        return super.toMd5(hihokenshaNo, todokedeKanriNo, shoriTimestamp, todokedeYMD, todokedenin_YubinNo, todokedenin_Jusho, todokedenin_ShimeiKana, todokedenin_Shimei, todokedenin_TelNo, todokedenin_Zokugara, yokaigoJotaiKubun, ninteiYukoKaishiYMD, ninteiYukoShuryoYMD, kagaisha_YubinNo, kagaisha_Jusho, kagaisha_ShimeiKana, kagansha_Shimei, kagaisha_UmareYMD, kagaisha_TelNo, kagaisha_Shokugyo, shiyosha_YubinNo, shiyosha_Jusho, shiyosha_ShimeiKana, shiyosha_Shimei, shiyosha_UmareYMD, shiyosha_TelNo, shiyosha_Shokugyo, fushoYMD, fushoTime, fushoJi_Basho, hasshoGeiin_FushoJiJokyo, jibaisekiHoken_KeiyakuKaishaMei, jibaisekiHoken_ShomeishoNo, jibaisekiHoken_KeiyakushaJusho, shoyushaJusho, shoyushaShimei, torokuNo, shadaiNo, niniHoken_TaijinHoshoUmu, niniHoken_TaijinHoshoKaishaMei, niniHoken_TaijinHoshoKaishaTelNo, niniHoken_TaijinHoshoKaishaTantosha, jidan_SeiritsuUmu, jidan_SeiritsuYMD, songaiBaishoKoshoKeika, jikoHasseiJokyoHokokushoUmu, nensho_DoishoUmu, seiyakushoUmu, kotsuJikoShomeishoUmu, jinshinJikoShomeisho_NyushuFunoRiyushoUmu, jidanshoUtsushiUmu);
    }

// </editor-fold>
}

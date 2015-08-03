package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;

/**
 * DbT3077JuryoininKeiyakuJigyoshaの項目定義クラスです
 *
 */
public class DbT3077JuryoininKeiyakuJigyoshaEntity extends DbTableEntityBase<DbT3077JuryoininKeiyakuJigyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3077JuryoininKeiyakuJigyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString jigyoshaKeiyakuNo;
    @PrimaryKey
    private FlexibleDate kaishiYMD;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleDate shuryoYMD;
    private FlexibleDate todokedeYMD;
    private RString todokedeAddress;
    private RString todokedeJigyoshaName;
    private RString todokedeDaihyoshaName;
    private KinyuKikanCode kinyuKikanCode;
    private KinyuKikanShitenCode shitenCode;
    private RString kozaShubetsu;
    private RString kozaNo;
    private RString tsuchoKigo;
    private RString tsuchoNo;
    private AtenaKanaMeisho kozaMeiginin;
    private AtenaMeisho kozaMeigininKanji;
    private TelNo jigyoshaFaxNo;
    private FlexibleDate keiyakuTorokuYMD;
    private RString sofusakiBusho;
    private RString eigyoKeitai;
    private boolean jutakuKaishuKeiyakuUmu;
    private boolean tokuteiFukushiYoguHanbaiKeiyakuUmu;
    private boolean shokanbaraiKyufuKeiyakuUmu;
    private boolean kogakuKyufuKeiyakuUmu;
    private JigyoshaNo keiyakuJigyoshaNo;
    private boolean toriatsukaiKakuyakushoUmu;

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
     * 事業者契約番号のgetメソッドです。
     * <br/>
     * <br/>1からの連番付番
     * 
     * @return 事業者契約番号
     */
    public RString getJigyoshaKeiyakuNo() {
        return jigyoshaKeiyakuNo;
    }

    /**
     * 事業者契約番号のsetメソッドです。
     * <br/>
     * <br/>1からの連番付番
     * 
     * @param jigyoshaKeiyakuNo 事業者契約番号
     */
    public void setJigyoshaKeiyakuNo(RString jigyoshaKeiyakuNo) {
        this.jigyoshaKeiyakuNo = jigyoshaKeiyakuNo;
    }

    /**
     * 開始年月日のgetメソッドです。
     * 
     * @return 開始年月日
     */
    public FlexibleDate getKaishiYMD() {
        return kaishiYMD;
    }

    /**
     * 開始年月日のsetメソッドです。
     * 
     * @param kaishiYMD 開始年月日
     */
    public void setKaishiYMD(FlexibleDate kaishiYMD) {
        this.kaishiYMD = kaishiYMD;
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
     * 終了年月日のgetメソッドです。
     * 
     * @return 終了年月日
     */
    public FlexibleDate getShuryoYMD() {
        return shuryoYMD;
    }

    /**
     * 終了年月日のsetメソッドです。
     * 
     * @param shuryoYMD 終了年月日
     */
    public void setShuryoYMD(FlexibleDate shuryoYMD) {
        this.shuryoYMD = shuryoYMD;
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
     * 届出者住所のgetメソッドです。
     * 
     * @return 届出者住所
     */
    public RString getTodokedeAddress() {
        return todokedeAddress;
    }

    /**
     * 届出者住所のsetメソッドです。
     * 
     * @param todokedeAddress 届出者住所
     */
    public void setTodokedeAddress(RString todokedeAddress) {
        this.todokedeAddress = todokedeAddress;
    }

    /**
     * 届出者事業者名称のgetメソッドです。
     * 
     * @return 届出者事業者名称
     */
    public RString getTodokedeJigyoshaName() {
        return todokedeJigyoshaName;
    }

    /**
     * 届出者事業者名称のsetメソッドです。
     * 
     * @param todokedeJigyoshaName 届出者事業者名称
     */
    public void setTodokedeJigyoshaName(RString todokedeJigyoshaName) {
        this.todokedeJigyoshaName = todokedeJigyoshaName;
    }

    /**
     * 届出者代表者氏名のgetメソッドです。
     * 
     * @return 届出者代表者氏名
     */
    public RString getTodokedeDaihyoshaName() {
        return todokedeDaihyoshaName;
    }

    /**
     * 届出者代表者氏名のsetメソッドです。
     * 
     * @param todokedeDaihyoshaName 届出者代表者氏名
     */
    public void setTodokedeDaihyoshaName(RString todokedeDaihyoshaName) {
        this.todokedeDaihyoshaName = todokedeDaihyoshaName;
    }

    /**
     * 金融機関コードのgetメソッドです。
     * 
     * @return 金融機関コード
     */
    public KinyuKikanCode getKinyuKikanCode() {
        return kinyuKikanCode;
    }

    /**
     * 金融機関コードのsetメソッドです。
     * 
     * @param kinyuKikanCode 金融機関コード
     */
    public void setKinyuKikanCode(KinyuKikanCode kinyuKikanCode) {
        this.kinyuKikanCode = kinyuKikanCode;
    }

    /**
     * 支店コードのgetメソッドです。
     * 
     * @return 支店コード
     */
    public KinyuKikanShitenCode getShitenCode() {
        return shitenCode;
    }

    /**
     * 支店コードのsetメソッドです。
     * 
     * @param shitenCode 支店コード
     */
    public void setShitenCode(KinyuKikanShitenCode shitenCode) {
        this.shitenCode = shitenCode;
    }

    /**
     * 口座種別のgetメソッドです。
     * 
     * @return 口座種別
     */
    public RString getKozaShubetsu() {
        return kozaShubetsu;
    }

    /**
     * 口座種別のsetメソッドです。
     * 
     * @param kozaShubetsu 口座種別
     */
    public void setKozaShubetsu(RString kozaShubetsu) {
        this.kozaShubetsu = kozaShubetsu;
    }

    /**
     * 口座番号のgetメソッドです。
     * 
     * @return 口座番号
     */
    public RString getKozaNo() {
        return kozaNo;
    }

    /**
     * 口座番号のsetメソッドです。
     * 
     * @param kozaNo 口座番号
     */
    public void setKozaNo(RString kozaNo) {
        this.kozaNo = kozaNo;
    }

    /**
     * 通帳記号のgetメソッドです。
     * 
     * @return 通帳記号
     */
    public RString getTsuchoKigo() {
        return tsuchoKigo;
    }

    /**
     * 通帳記号のsetメソッドです。
     * 
     * @param tsuchoKigo 通帳記号
     */
    public void setTsuchoKigo(RString tsuchoKigo) {
        this.tsuchoKigo = tsuchoKigo;
    }

    /**
     * 通帳番号のgetメソッドです。
     * 
     * @return 通帳番号
     */
    public RString getTsuchoNo() {
        return tsuchoNo;
    }

    /**
     * 通帳番号のsetメソッドです。
     * 
     * @param tsuchoNo 通帳番号
     */
    public void setTsuchoNo(RString tsuchoNo) {
        this.tsuchoNo = tsuchoNo;
    }

    /**
     * 口座名義人のgetメソッドです。
     * 
     * @return 口座名義人
     */
    public AtenaKanaMeisho getKozaMeiginin() {
        return kozaMeiginin;
    }

    /**
     * 口座名義人のsetメソッドです。
     * 
     * @param kozaMeiginin 口座名義人
     */
    public void setKozaMeiginin(AtenaKanaMeisho kozaMeiginin) {
        this.kozaMeiginin = kozaMeiginin;
    }

    /**
     * 口座名義人漢字のgetメソッドです。
     * 
     * @return 口座名義人漢字
     */
    public AtenaMeisho getKozaMeigininKanji() {
        return kozaMeigininKanji;
    }

    /**
     * 口座名義人漢字のsetメソッドです。
     * 
     * @param kozaMeigininKanji 口座名義人漢字
     */
    public void setKozaMeigininKanji(AtenaMeisho kozaMeigininKanji) {
        this.kozaMeigininKanji = kozaMeigininKanji;
    }

    /**
     * 事業者FAX番号のgetメソッドです。
     * 
     * @return 事業者FAX番号
     */
    public TelNo getJigyoshaFaxNo() {
        return jigyoshaFaxNo;
    }

    /**
     * 事業者FAX番号のsetメソッドです。
     * 
     * @param jigyoshaFaxNo 事業者FAX番号
     */
    public void setJigyoshaFaxNo(TelNo jigyoshaFaxNo) {
        this.jigyoshaFaxNo = jigyoshaFaxNo;
    }

    /**
     * 契約登録年月日のgetメソッドです。
     * 
     * @return 契約登録年月日
     */
    public FlexibleDate getKeiyakuTorokuYMD() {
        return keiyakuTorokuYMD;
    }

    /**
     * 契約登録年月日のsetメソッドです。
     * 
     * @param keiyakuTorokuYMD 契約登録年月日
     */
    public void setKeiyakuTorokuYMD(FlexibleDate keiyakuTorokuYMD) {
        this.keiyakuTorokuYMD = keiyakuTorokuYMD;
    }

    /**
     * 送付先部署のgetメソッドです。
     * 
     * @return 送付先部署
     */
    public RString getSofusakiBusho() {
        return sofusakiBusho;
    }

    /**
     * 送付先部署のsetメソッドです。
     * 
     * @param sofusakiBusho 送付先部署
     */
    public void setSofusakiBusho(RString sofusakiBusho) {
        this.sofusakiBusho = sofusakiBusho;
    }

    /**
     * 営業形態のgetメソッドです。
     * <br/>
     * <br/>個人、法人の分け
     * 
     * @return 営業形態
     */
    public RString getEigyoKeitai() {
        return eigyoKeitai;
    }

    /**
     * 営業形態のsetメソッドです。
     * <br/>
     * <br/>個人、法人の分け
     * 
     * @param eigyoKeitai 営業形態
     */
    public void setEigyoKeitai(RString eigyoKeitai) {
        this.eigyoKeitai = eigyoKeitai;
    }

    /**
     * 住宅改修契約有無のgetメソッドです。
     * <br/>
     * <br/>0:契約無し,1:契約有り（償還払給付契約有無が「0」である場合に限る）
     * 
     * @return 住宅改修契約有無
     */
    public boolean getJutakuKaishuKeiyakuUmu() {
        return jutakuKaishuKeiyakuUmu;
    }

    /**
     * 住宅改修契約有無のsetメソッドです。
     * <br/>
     * <br/>0:契約無し,1:契約有り（償還払給付契約有無が「0」である場合に限る）
     * 
     * @param jutakuKaishuKeiyakuUmu 住宅改修契約有無
     */
    public void setJutakuKaishuKeiyakuUmu(boolean jutakuKaishuKeiyakuUmu) {
        this.jutakuKaishuKeiyakuUmu = jutakuKaishuKeiyakuUmu;
    }

    /**
     * 特定福祉用具販売契約有無のgetメソッドです。
     * <br/>
     * <br/>0:契約無し,1:契約有り（償還払給付契約有無が「0」である場合に限る）
     * 
     * @return 特定福祉用具販売契約有無
     */
    public boolean getTokuteiFukushiYoguHanbaiKeiyakuUmu() {
        return tokuteiFukushiYoguHanbaiKeiyakuUmu;
    }

    /**
     * 特定福祉用具販売契約有無のsetメソッドです。
     * <br/>
     * <br/>0:契約無し,1:契約有り（償還払給付契約有無が「0」である場合に限る）
     * 
     * @param tokuteiFukushiYoguHanbaiKeiyakuUmu 特定福祉用具販売契約有無
     */
    public void setTokuteiFukushiYoguHanbaiKeiyakuUmu(boolean tokuteiFukushiYoguHanbaiKeiyakuUmu) {
        this.tokuteiFukushiYoguHanbaiKeiyakuUmu = tokuteiFukushiYoguHanbaiKeiyakuUmu;
    }

    /**
     * 償還払給付契約有無のgetメソッドです。
     * <br/>
     * <br/>0:契約無し,1:契約有り（住宅改修契約有無および特定福祉用具販売契約有無が「0」である場合に限る）
     * 
     * @return 償還払給付契約有無
     */
    public boolean getShokanbaraiKyufuKeiyakuUmu() {
        return shokanbaraiKyufuKeiyakuUmu;
    }

    /**
     * 償還払給付契約有無のsetメソッドです。
     * <br/>
     * <br/>0:契約無し,1:契約有り（住宅改修契約有無および特定福祉用具販売契約有無が「0」である場合に限る）
     * 
     * @param shokanbaraiKyufuKeiyakuUmu 償還払給付契約有無
     */
    public void setShokanbaraiKyufuKeiyakuUmu(boolean shokanbaraiKyufuKeiyakuUmu) {
        this.shokanbaraiKyufuKeiyakuUmu = shokanbaraiKyufuKeiyakuUmu;
    }

    /**
     * 高額給付契約有無のgetメソッドです。
     * <br/>
     * <br/>0:契約無し,1:契約有り
     * 
     * @return 高額給付契約有無
     */
    public boolean getKogakuKyufuKeiyakuUmu() {
        return kogakuKyufuKeiyakuUmu;
    }

    /**
     * 高額給付契約有無のsetメソッドです。
     * <br/>
     * <br/>0:契約無し,1:契約有り
     * 
     * @param kogakuKyufuKeiyakuUmu 高額給付契約有無
     */
    public void setKogakuKyufuKeiyakuUmu(boolean kogakuKyufuKeiyakuUmu) {
        this.kogakuKyufuKeiyakuUmu = kogakuKyufuKeiyakuUmu;
    }

    /**
     * 契約事業者番号のgetメソッドです。
     * 
     * @return 契約事業者番号
     */
    public JigyoshaNo getKeiyakuJigyoshaNo() {
        return keiyakuJigyoshaNo;
    }

    /**
     * 契約事業者番号のsetメソッドです。
     * 
     * @param keiyakuJigyoshaNo 契約事業者番号
     */
    public void setKeiyakuJigyoshaNo(JigyoshaNo keiyakuJigyoshaNo) {
        this.keiyakuJigyoshaNo = keiyakuJigyoshaNo;
    }

    /**
     * 取扱確約書有無のgetメソッドです。
     * 
     * @return 取扱確約書有無
     */
    public boolean getToriatsukaiKakuyakushoUmu() {
        return toriatsukaiKakuyakushoUmu;
    }

    /**
     * 取扱確約書有無のsetメソッドです。
     * 
     * @param toriatsukaiKakuyakushoUmu 取扱確約書有無
     */
    public void setToriatsukaiKakuyakushoUmu(boolean toriatsukaiKakuyakushoUmu) {
        this.toriatsukaiKakuyakushoUmu = toriatsukaiKakuyakushoUmu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3077JuryoininKeiyakuJigyoshaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3077JuryoininKeiyakuJigyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3077JuryoininKeiyakuJigyoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaKeiyakuNo, other.jigyoshaKeiyakuNo)) {
            return false;
        }
        if (!Objects.equals(this.kaishiYMD, other.kaishiYMD)) {
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
    public void shallowCopy(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        this.jigyoshaKeiyakuNo = entity.jigyoshaKeiyakuNo;
        this.kaishiYMD = entity.kaishiYMD;
        this.rirekiNo = entity.rirekiNo;
        this.shuryoYMD = entity.shuryoYMD;
        this.todokedeYMD = entity.todokedeYMD;
        this.todokedeAddress = entity.todokedeAddress;
        this.todokedeJigyoshaName = entity.todokedeJigyoshaName;
        this.todokedeDaihyoshaName = entity.todokedeDaihyoshaName;
        this.kinyuKikanCode = entity.kinyuKikanCode;
        this.shitenCode = entity.shitenCode;
        this.kozaShubetsu = entity.kozaShubetsu;
        this.kozaNo = entity.kozaNo;
        this.tsuchoKigo = entity.tsuchoKigo;
        this.tsuchoNo = entity.tsuchoNo;
        this.kozaMeiginin = entity.kozaMeiginin;
        this.kozaMeigininKanji = entity.kozaMeigininKanji;
        this.jigyoshaFaxNo = entity.jigyoshaFaxNo;
        this.keiyakuTorokuYMD = entity.keiyakuTorokuYMD;
        this.sofusakiBusho = entity.sofusakiBusho;
        this.eigyoKeitai = entity.eigyoKeitai;
        this.jutakuKaishuKeiyakuUmu = entity.jutakuKaishuKeiyakuUmu;
        this.tokuteiFukushiYoguHanbaiKeiyakuUmu = entity.tokuteiFukushiYoguHanbaiKeiyakuUmu;
        this.shokanbaraiKyufuKeiyakuUmu = entity.shokanbaraiKyufuKeiyakuUmu;
        this.kogakuKyufuKeiyakuUmu = entity.kogakuKyufuKeiyakuUmu;
        this.keiyakuJigyoshaNo = entity.keiyakuJigyoshaNo;
        this.toriatsukaiKakuyakushoUmu = entity.toriatsukaiKakuyakushoUmu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaKeiyakuNo, kaishiYMD, rirekiNo, shuryoYMD, todokedeYMD, todokedeAddress, todokedeJigyoshaName, todokedeDaihyoshaName, kinyuKikanCode, shitenCode, kozaShubetsu, kozaNo, tsuchoKigo, tsuchoNo, kozaMeiginin, kozaMeigininKanji, jigyoshaFaxNo, keiyakuTorokuYMD, sofusakiBusho, eigyoKeitai, jutakuKaishuKeiyakuUmu, tokuteiFukushiYoguHanbaiKeiyakuUmu, shokanbaraiKyufuKeiyakuUmu, kogakuKyufuKeiyakuUmu, keiyakuJigyoshaNo, toriatsukaiKakuyakushoUmu);
    }

// </editor-fold>





}

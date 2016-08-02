package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 要介護認定申請情報テーブルのエンティティクラスです。
 */
public class DbT5101NinteiShinseiJohoEntity extends DbTableEntityBase<DbT5101NinteiShinseiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5101NinteiShinseiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    private Code koroshoIfShikibetsuCode;
    private RString shoKisaiHokenshaNo;
    private FlexibleYear shinseiNendo;
    private RString hihokenshaNo;
    private FlexibleDate ninteiShinseiYMD;
    private EdabanCode ninteiShinseiEdabanCode;
    private Code ninteiShinseiHoreiKubunCode;
    private Code ninteiShinseiShinseijiKubunCode;
    private Code torisageKubunCode;
    private RString hihokenshaKubunCode;
    private FlexibleDate seinengappiYMD;
    private int age;
    private Code seibetsu;
    private AtenaKanaMeisho hihokenshaKana;
    private AtenaMeisho hihokenshaName;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private RString shishoCode;
    private ShikibetsuCode shikibetsuCode;
    private ChikuCode chikuCode;
    private boolean minashiNigoEtcTaishoFlag;
    private Code koikinaiTenkyoKubun;
    private Code ninteiShinseiYukoKubunCode;
    private RString shienShinseiKubun;
    private RString ninteiShinseiRiyu;
    private RString shinseiServiceDeleteRiyu;
    private Code zenYokaigoKubunCode;
    private FlexibleDate zenkaiNinteiYMD;
    private FlexibleDate zenkaiYukoKikanStart;
    private FlexibleDate zenkaiYukoKikanEnd;
    private RString nigoIryoHokenshaName;
    private RString nigoIryoHokenKigoBango;
    private Code nigoTokuteiShippeiCode;
    private RString jidoWariateJogaishaKubun;
    private boolean johoteikyoDoiFlag;
    private FlexibleDate johoteikyoSiryoOutputYMD;
    private Code chosaKubun;
    private ChosaItakusakiCode ninteiChosaItakusakiCode;
    private ChosainCode ninteiChosainCode;
    private RString renrakuJikoToChosain;
    private ShujiiIryokikanCode shujiiIryokikanCode;
    private ShujiiCode shujiiCode;
    private boolean shiteiiFlag;
    private Code ikenshoDataShubetsu;
    private RString renrakuJikoToShujii;
    private boolean enkitsuchiNashiDoiFlag;
    private boolean shisetsuNyushoFlag;
    private JigyoshaNo nyushoShisetsuCode;
    private boolean kateiHomonFlag;
    private YubinNo homonChosasakiYubinNo;
    private AtenaJusho homonChosasakiJusho;
    private AtenaMeisho homonChosasakiName;
    private TelNo homonChosasakiTelNo;
    private RString shichosonRenrakuJiko;
    private Code shoriJotaiKubun;
    private FlexibleDate torisageYMD;
    private RString torisageRiyu;
    private FlexibleDate kyakkaYMD;
    private RString kyakkaRiyu;
    private FlexibleDate enkiKetteiYMD;
    private RString enkiRiyu;
    private FlexibleDate enkiTsuchiHakkoYMD;
    private int enkiTsuchiHakkoKaisu;
    private FlexibleDate enkiMikomiKaishiYMD;
    private FlexibleDate enkiMikomiShuryoYMD;
    private boolean shinsaKeizokuFlag;
    private Code shinsakaiYusenWaritsukeKubunCode;
    private FlexibleDate koshinTsuchiHakkoYMD;
    private FlexibleDate koshinTsuchiHakkoKanryoYMD;
    private FlexibleDate ninteiShinseiJohoTorokuYMD;
    private int saiChosaIraiKaisu;
    private int saiSakuseiIraiKaisu;
    private FlexibleDate ifSofuYMD;
    private boolean logicalDeletedFlag;

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
     * 申請書管理番号のgetメソッドです。
     * 
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(@Nonnull ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 厚労省IF識別コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）年によって異なる認定調査項目を特定するためのコード。
     * 
     * @return 厚労省IF識別コード
     */
    public Code getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * 厚労省IF識別コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）年によって異なる認定調査項目を特定するためのコード。
     * 
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     */
    public void setKoroshoIfShikibetsuCode(@Nonnull Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     * 
     * @return 証記載保険者番号
     */
    public RString getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * 
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(@Nonnull RString shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 申請年度のgetメソッドです。
     * 
     * @return 申請年度
     */
    public FlexibleYear getShinseiNendo() {
        return shinseiNendo;
    }

    /**
     * 申請年度のsetメソッドです。
     * 
     * @param shinseiNendo 申請年度
     */
    public void setShinseiNendo(@Nonnull FlexibleYear shinseiNendo) {
        this.shinseiNendo = shinseiNendo;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * 
     * @return 被保険者番号
     */
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(@Nonnull RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 認定申請年月日のgetメソッドです。
     * <br/>
     * <br/>更新対象
     * 
     * @return 認定申請年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiShinseiYMD() {
        return ninteiShinseiYMD;
    }

    /**
     * 認定申請年月日のsetメソッドです。
     * <br/>
     * <br/>更新対象
     * 
     * @param ninteiShinseiYMD 認定申請年月日
     */
    public void setNinteiShinseiYMD(FlexibleDate ninteiShinseiYMD) {
        this.ninteiShinseiYMD = ninteiShinseiYMD;
    }

    /**
     * 認定申請枝番コードのgetメソッドです。
     * 
     * @return 認定申請枝番コード
     */
    public EdabanCode getNinteiShinseiEdabanCode() {
        return ninteiShinseiEdabanCode;
    }

    /**
     * 認定申請枝番コードのsetメソッドです。
     * 
     * @param ninteiShinseiEdabanCode 認定申請枝番コード
     */
    public void setNinteiShinseiEdabanCode(@Nonnull EdabanCode ninteiShinseiEdabanCode) {
        this.ninteiShinseiEdabanCode = ninteiShinseiEdabanCode;
    }

    /**
     * 認定申請区分（法令）コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：申請区分（法令）コード）新規申請・更新申請・区分変更申請・職権
     * 
     * @return 認定申請区分（法令）コード
     */
    @CheckForNull
    public Code getNinteiShinseiHoreiKubunCode() {
        return ninteiShinseiHoreiKubunCode;
    }

    /**
     * 認定申請区分（法令）コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：申請区分（法令）コード）新規申請・更新申請・区分変更申請・職権
     * 
     * @param ninteiShinseiHoreiKubunCode 認定申請区分（法令）コード
     */
    public void setNinteiShinseiHoreiKubunCode(Code ninteiShinseiHoreiKubunCode) {
        this.ninteiShinseiHoreiKubunCode = ninteiShinseiHoreiKubunCode;
    }

    /**
     * 認定申請区分（申請時）コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：申請区分（申請時）コード）新規・更新・区分変更・転入申請・資格喪失（死亡）・新規（事前）・更新（事前）
     * 
     * @return 認定申請区分（申請時）コード
     */
    public Code getNinteiShinseiShinseijiKubunCode() {
        return ninteiShinseiShinseijiKubunCode;
    }

    /**
     * 認定申請区分（申請時）コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：申請区分（申請時）コード）新規・更新・区分変更・転入申請・資格喪失（死亡）・新規（事前）・更新（事前）
     * 
     * @param ninteiShinseiShinseijiKubunCode 認定申請区分（申請時）コード
     */
    public void setNinteiShinseiShinseijiKubunCode(@Nonnull Code ninteiShinseiShinseijiKubunCode) {
        this.ninteiShinseiShinseijiKubunCode = ninteiShinseiShinseijiKubunCode;
    }

    /**
     * 取下区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：取下区分コード）NCI 1:認定申請有効、2:却下、3:取り下げ、4:区分変更却下
     * 
     * @return 取下区分コード
     */
    @CheckForNull
    public Code getTorisageKubunCode() {
        return torisageKubunCode;
    }

    /**
     * 取下区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：取下区分コード）NCI 1:認定申請有効、2:却下、3:取り下げ、4:区分変更却下
     * 
     * @param torisageKubunCode 取下区分コード
     */
    public void setTorisageKubunCode(Code torisageKubunCode) {
        this.torisageKubunCode = torisageKubunCode;
    }

    /**
     * 被保険者区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：被保険者区分コード）1:第1号被保険者、2:第2号被保険者、その他8生活保護)
     * 
     * @return 被保険者区分コード
     */
    public RString getHihokenshaKubunCode() {
        return hihokenshaKubunCode;
    }

    /**
     * 被保険者区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：被保険者区分コード）1:第1号被保険者、2:第2号被保険者、その他8生活保護)
     * 
     * @param hihokenshaKubunCode 被保険者区分コード
     */
    public void setHihokenshaKubunCode(@Nonnull RString hihokenshaKubunCode) {
        this.hihokenshaKubunCode = hihokenshaKubunCode;
    }

    /**
     * 生年月日のgetメソッドです。
     * 
     * @return 生年月日
     */
    public FlexibleDate getSeinengappiYMD() {
        return seinengappiYMD;
    }

    /**
     * 生年月日のsetメソッドです。
     * 
     * @param seinengappiYMD 生年月日
     */
    public void setSeinengappiYMD(@Nonnull FlexibleDate seinengappiYMD) {
        this.seinengappiYMD = seinengappiYMD;
    }

    /**
     * 年齢のgetメソッドです。
     * <br/>
     * <br/>申請日時点の年齢
     * 
     * @return 年齢
     */
    @CheckForNull
    public int getAge() {
        return age;
    }

    /**
     * 年齢のsetメソッドです。
     * <br/>
     * <br/>申請日時点の年齢
     * 
     * @param age 年齢
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 性別のgetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：性別コード）
     * 
     * @return 性別
     */
    public Code getSeibetsu() {
        return seibetsu;
    }

    /**
     * 性別のsetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：性別コード）
     * 
     * @param seibetsu 性別
     */
    public void setSeibetsu(@Nonnull Code seibetsu) {
        this.seibetsu = seibetsu;
    }

    /**
     * 被保険者氏名カナのgetメソッドです。
     * 
     * @return 被保険者氏名カナ
     */
    public AtenaKanaMeisho getHihokenshaKana() {
        return hihokenshaKana;
    }

    /**
     * 被保険者氏名カナのsetメソッドです。
     * 
     * @param hihokenshaKana 被保険者氏名カナ
     */
    public void setHihokenshaKana(@Nonnull AtenaKanaMeisho hihokenshaKana) {
        this.hihokenshaKana = hihokenshaKana;
    }

    /**
     * 被保険者氏名のgetメソッドです。
     * 
     * @return 被保険者氏名
     */
    public AtenaMeisho getHihokenshaName() {
        return hihokenshaName;
    }

    /**
     * 被保険者氏名のsetメソッドです。
     * 
     * @param hihokenshaName 被保険者氏名
     */
    public void setHihokenshaName(@Nonnull AtenaMeisho hihokenshaName) {
        this.hihokenshaName = hihokenshaName;
    }

    /**
     * 郵便番号のgetメソッドです。
     * 
     * @return 郵便番号
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     * 
     * @param yubinNo 郵便番号
     */
    public void setYubinNo(@Nonnull YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * 住所のgetメソッドです。
     * 
     * @return 住所
     */
    public AtenaJusho getJusho() {
        return jusho;
    }

    /**
     * 住所のsetメソッドです。
     * 
     * @param jusho 住所
     */
    public void setJusho(@Nonnull AtenaJusho jusho) {
        this.jusho = jusho;
    }

    /**
     * 電話番号のgetメソッドです。
     * 
     * @return 電話番号
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * 電話番号のsetメソッドです。
     * 
     * @param telNo 電話番号
     */
    public void setTelNo(@Nonnull TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * 支所コードのgetメソッドです。
     * 
     * @return 支所コード
     */
    @CheckForNull
    public RString getShishoCode() {
        return shishoCode;
    }

    /**
     * 支所コードのsetメソッドです。
     * 
     * @param shishoCode 支所コード
     */
    public void setShishoCode(RString shishoCode) {
        this.shishoCode = shishoCode;
    }

    /**
     * 識別コードのgetメソッドです。
     * <br/>
     * <br/>住基
     * 
     * @return 識別コード
     */
    @CheckForNull
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * <br/>
     * <br/>住基
     * 
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 地区コードのgetメソッドです。
     * 
     * @return 地区コード
     */
    @CheckForNull
    public ChikuCode getChikuCode() {
        return chikuCode;
    }

    /**
     * 地区コードのsetメソッドです。
     * 
     * @param chikuCode 地区コード
     */
    public void setChikuCode(ChikuCode chikuCode) {
        this.chikuCode = chikuCode;
    }

    /**
     * みなし２号等対象フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：みなし2号等対象フラグ）
     * 
     * @return みなし２号等対象フラグ
     */
    @CheckForNull
    public boolean getMinashiNigoEtcTaishoFlag() {
        return minashiNigoEtcTaishoFlag;
    }

    /**
     * みなし２号等対象フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：みなし2号等対象フラグ）
     * 
     * @param minashiNigoEtcTaishoFlag みなし２号等対象フラグ
     */
    public void setMinashiNigoEtcTaishoFlag(boolean minashiNigoEtcTaishoFlag) {
        this.minashiNigoEtcTaishoFlag = minashiNigoEtcTaishoFlag;
    }

    /**
     * 広域内転居区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：広域内転居区分）0：対象外、1:申請中の転居、2:申請終了
     * 
     * @return 広域内転居区分
     */
    @CheckForNull
    public Code getKoikinaiTenkyoKubun() {
        return koikinaiTenkyoKubun;
    }

    /**
     * 広域内転居区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：広域内転居区分）0：対象外、1:申請中の転居、2:申請終了
     * 
     * @param koikinaiTenkyoKubun 広域内転居区分
     */
    public void setKoikinaiTenkyoKubun(Code koikinaiTenkyoKubun) {
        this.koikinaiTenkyoKubun = koikinaiTenkyoKubun;
    }

    /**
     * 認定申請有効区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：認定申請有効区分）
     * 
     * @return 認定申請有効区分
     */
    public Code getNinteiShinseiYukoKubunCode() {
        return ninteiShinseiYukoKubunCode;
    }

    /**
     * 認定申請有効区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：認定申請有効区分）
     * 
     * @param ninteiShinseiYukoKubunCode 認定申請有効区分
     */
    public void setNinteiShinseiYukoKubunCode(@Nonnull Code ninteiShinseiYukoKubunCode) {
        this.ninteiShinseiYukoKubunCode = ninteiShinseiYukoKubunCode;
    }

    /**
     * 要介護申請・要支援申請の区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護申請・要支援申請の区分）
     * 
     * @return 要介護申請・要支援申請の区分
     */
    @CheckForNull
    public RString getShienShinseiKubun() {
        return shienShinseiKubun;
    }

    /**
     * 要介護申請・要支援申請の区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護申請・要支援申請の区分）
     * 
     * @param shienShinseiKubun 要介護申請・要支援申請の区分
     */
    public void setShienShinseiKubun(RString shienShinseiKubun) {
        this.shienShinseiKubun = shienShinseiKubun;
    }

    /**
     * 認定申請理由のgetメソッドです。
     * 
     * @return 認定申請理由
     */
    @CheckForNull
    public RString getNinteiShinseiRiyu() {
        return ninteiShinseiRiyu;
    }

    /**
     * 認定申請理由のsetメソッドです。
     * 
     * @param ninteiShinseiRiyu 認定申請理由
     */
    public void setNinteiShinseiRiyu(RString ninteiShinseiRiyu) {
        this.ninteiShinseiRiyu = ninteiShinseiRiyu;
    }

    /**
     * 申請サービス削除の理由のgetメソッドです。
     * 
     * @return 申請サービス削除の理由
     */
    @CheckForNull
    public RString getShinseiServiceDeleteRiyu() {
        return shinseiServiceDeleteRiyu;
    }

    /**
     * 申請サービス削除の理由のsetメソッドです。
     * 
     * @param shinseiServiceDeleteRiyu 申請サービス削除の理由
     */
    public void setShinseiServiceDeleteRiyu(RString shinseiServiceDeleteRiyu) {
        this.shinseiServiceDeleteRiyu = shinseiServiceDeleteRiyu;
    }

    /**
     * 前回要介護状態区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：要介護状態区分コード09など）
     * 
     * @return 前回要介護状態区分コード
     */
    @CheckForNull
    public Code getZenYokaigoKubunCode() {
        return zenYokaigoKubunCode;
    }

    /**
     * 前回要介護状態区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：要介護状態区分コード09など）
     * 
     * @param zenYokaigoKubunCode 前回要介護状態区分コード
     */
    public void setZenYokaigoKubunCode(Code zenYokaigoKubunCode) {
        this.zenYokaigoKubunCode = zenYokaigoKubunCode;
    }

    /**
     * 前回認定年月日のgetメソッドです。
     * 
     * @return 前回認定年月日
     */
    @CheckForNull
    public FlexibleDate getZenkaiNinteiYMD() {
        return zenkaiNinteiYMD;
    }

    /**
     * 前回認定年月日のsetメソッドです。
     * 
     * @param zenkaiNinteiYMD 前回認定年月日
     */
    public void setZenkaiNinteiYMD(FlexibleDate zenkaiNinteiYMD) {
        this.zenkaiNinteiYMD = zenkaiNinteiYMD;
    }

    /**
     * 前回認定有効期間（開始）のgetメソッドです。
     * 
     * @return 前回認定有効期間（開始）
     */
    @CheckForNull
    public FlexibleDate getZenkaiYukoKikanStart() {
        return zenkaiYukoKikanStart;
    }

    /**
     * 前回認定有効期間（開始）のsetメソッドです。
     * 
     * @param zenkaiYukoKikanStart 前回認定有効期間（開始）
     */
    public void setZenkaiYukoKikanStart(FlexibleDate zenkaiYukoKikanStart) {
        this.zenkaiYukoKikanStart = zenkaiYukoKikanStart;
    }

    /**
     * 前回認定有効期間（終了）のgetメソッドです。
     * 
     * @return 前回認定有効期間（終了）
     */
    @CheckForNull
    public FlexibleDate getZenkaiYukoKikanEnd() {
        return zenkaiYukoKikanEnd;
    }

    /**
     * 前回認定有効期間（終了）のsetメソッドです。
     * 
     * @param zenkaiYukoKikanEnd 前回認定有効期間（終了）
     */
    public void setZenkaiYukoKikanEnd(FlexibleDate zenkaiYukoKikanEnd) {
        this.zenkaiYukoKikanEnd = zenkaiYukoKikanEnd;
    }

    /**
     * ２号医療保険者名のgetメソッドです。
     * <br/>
     * <br/>受給者台帳にぶら下がっている医療保険加入状況の主たるものが入る
     * 
     * @return ２号医療保険者名
     */
    @CheckForNull
    public RString getNigoIryoHokenshaName() {
        return nigoIryoHokenshaName;
    }

    /**
     * ２号医療保険者名のsetメソッドです。
     * <br/>
     * <br/>受給者台帳にぶら下がっている医療保険加入状況の主たるものが入る
     * 
     * @param nigoIryoHokenshaName ２号医療保険者名
     */
    public void setNigoIryoHokenshaName(RString nigoIryoHokenshaName) {
        this.nigoIryoHokenshaName = nigoIryoHokenshaName;
    }

    /**
     * ２号医療保険記号番号のgetメソッドです。
     * <br/>
     * <br/>受給者台帳にぶら下がっている医療保険加入状況の主たるものが入る
     * 
     * @return ２号医療保険記号番号
     */
    @CheckForNull
    public RString getNigoIryoHokenKigoBango() {
        return nigoIryoHokenKigoBango;
    }

    /**
     * ２号医療保険記号番号のsetメソッドです。
     * <br/>
     * <br/>受給者台帳にぶら下がっている医療保険加入状況の主たるものが入る
     * 
     * @param nigoIryoHokenKigoBango ２号医療保険記号番号
     */
    public void setNigoIryoHokenKigoBango(RString nigoIryoHokenKigoBango) {
        this.nigoIryoHokenKigoBango = nigoIryoHokenKigoBango;
    }

    /**
     * ２号特定疾病コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：特定疾病コード）
     * 
     * @return ２号特定疾病コード
     */
    @CheckForNull
    public Code getNigoTokuteiShippeiCode() {
        return nigoTokuteiShippeiCode;
    }

    /**
     * ２号特定疾病コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：特定疾病コード）
     * 
     * @param nigoTokuteiShippeiCode ２号特定疾病コード
     */
    public void setNigoTokuteiShippeiCode(Code nigoTokuteiShippeiCode) {
        this.nigoTokuteiShippeiCode = nigoTokuteiShippeiCode;
    }

    /**
     * 自動割当除外者区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：自動割当除外者区分）
     * 
     * @return 自動割当除外者区分
     */
    @CheckForNull
    public RString getJidoWariateJogaishaKubun() {
        return jidoWariateJogaishaKubun;
    }

    /**
     * 自動割当除外者区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：自動割当除外者区分）
     * 
     * @param jidoWariateJogaishaKubun 自動割当除外者区分
     */
    public void setJidoWariateJogaishaKubun(RString jidoWariateJogaishaKubun) {
        this.jidoWariateJogaishaKubun = jidoWariateJogaishaKubun;
    }

    /**
     * 情報提供への同意有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：情報提供への同意有無）
     * 
     * @return 情報提供への同意有無
     */
    @CheckForNull
    public boolean getJohoteikyoDoiFlag() {
        return johoteikyoDoiFlag;
    }

    /**
     * 情報提供への同意有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：情報提供への同意有無）
     * 
     * @param johoteikyoDoiFlag 情報提供への同意有無
     */
    public void setJohoteikyoDoiFlag(boolean johoteikyoDoiFlag) {
        this.johoteikyoDoiFlag = johoteikyoDoiFlag;
    }

    /**
     * 情報提供資料出力年月日のgetメソッドです。
     * 
     * @return 情報提供資料出力年月日
     */
    @CheckForNull
    public FlexibleDate getJohoteikyoSiryoOutputYMD() {
        return johoteikyoSiryoOutputYMD;
    }

    /**
     * 情報提供資料出力年月日のsetメソッドです。
     * 
     * @param johoteikyoSiryoOutputYMD 情報提供資料出力年月日
     */
    public void setJohoteikyoSiryoOutputYMD(FlexibleDate johoteikyoSiryoOutputYMD) {
        this.johoteikyoSiryoOutputYMD = johoteikyoSiryoOutputYMD;
    }

    /**
     * 調査区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査区分）
     * 
     * @return 調査区分
     */
    @CheckForNull
    public Code getChosaKubun() {
        return chosaKubun;
    }

    /**
     * 調査区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査区分）
     * 
     * @param chosaKubun 調査区分
     */
    public void setChosaKubun(Code chosaKubun) {
        this.chosaKubun = chosaKubun;
    }

    /**
     * 認定調査委託先コードのgetメソッドです。
     * <br/>
     * <br/>依頼情報の生成によってupdateされていく。認定調査委託先情報
     * 
     * @return 認定調査委託先コード
     */
    @CheckForNull
    public ChosaItakusakiCode getNinteiChosaItakusakiCode() {
        return ninteiChosaItakusakiCode;
    }

    /**
     * 認定調査委託先コードのsetメソッドです。
     * <br/>
     * <br/>依頼情報の生成によってupdateされていく。認定調査委託先情報
     * 
     * @param ninteiChosaItakusakiCode 認定調査委託先コード
     */
    public void setNinteiChosaItakusakiCode(ChosaItakusakiCode ninteiChosaItakusakiCode) {
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
    }

    /**
     * 認定調査員コードのgetメソッドです。
     * <br/>
     * <br/>依頼情報の生成によってupdateされていく。認定調査員情報
     * 
     * @return 認定調査員コード
     */
    @CheckForNull
    public ChosainCode getNinteiChosainCode() {
        return ninteiChosainCode;
    }

    /**
     * 認定調査員コードのsetメソッドです。
     * <br/>
     * <br/>依頼情報の生成によってupdateされていく。認定調査員情報
     * 
     * @param ninteiChosainCode 認定調査員コード
     */
    public void setNinteiChosainCode(ChosainCode ninteiChosainCode) {
        this.ninteiChosainCode = ninteiChosainCode;
    }

    /**
     * 調査員への連絡事項のgetメソッドです。
     * 
     * @return 調査員への連絡事項
     */
    @CheckForNull
    public RString getRenrakuJikoToChosain() {
        return renrakuJikoToChosain;
    }

    /**
     * 調査員への連絡事項のsetメソッドです。
     * 
     * @param renrakuJikoToChosain 調査員への連絡事項
     */
    public void setRenrakuJikoToChosain(RString renrakuJikoToChosain) {
        this.renrakuJikoToChosain = renrakuJikoToChosain;
    }

    /**
     * 主治医医療機関コードのgetメソッドです。
     * <br/>
     * <br/>申請書の主治医の医療機関に相当する介護独自の医療機関コード。依頼情報の生成によってupdateされていく。主治医医療機関情報
     * 
     * @return 主治医医療機関コード
     */
    @CheckForNull
    public ShujiiIryokikanCode getShujiiIryokikanCode() {
        return shujiiIryokikanCode;
    }

    /**
     * 主治医医療機関コードのsetメソッドです。
     * <br/>
     * <br/>申請書の主治医の医療機関に相当する介護独自の医療機関コード。依頼情報の生成によってupdateされていく。主治医医療機関情報
     * 
     * @param shujiiIryokikanCode 主治医医療機関コード
     */
    public void setShujiiIryokikanCode(ShujiiIryokikanCode shujiiIryokikanCode) {
        this.shujiiIryokikanCode = shujiiIryokikanCode;
    }

    /**
     * 主治医コードのgetメソッドです。
     * <br/>
     * <br/>申請書の主治医に相当する介護独自の医師コード。依頼情報の生成によってupdateされていく。主治医情報
     * 
     * @return 主治医コード
     */
    @CheckForNull
    public ShujiiCode getShujiiCode() {
        return shujiiCode;
    }

    /**
     * 主治医コードのsetメソッドです。
     * <br/>
     * <br/>申請書の主治医に相当する介護独自の医師コード。依頼情報の生成によってupdateされていく。主治医情報
     * 
     * @param shujiiCode 主治医コード
     */
    public void setShujiiCode(ShujiiCode shujiiCode) {
        this.shujiiCode = shujiiCode;
    }

    /**
     * 指定医フラグのgetメソッドです。
     * 
     * @return 指定医フラグ
     */
    @CheckForNull
    public boolean getShiteiiFlag() {
        return shiteiiFlag;
    }

    /**
     * 指定医フラグのsetメソッドです。
     * 
     * @param shiteiiFlag 指定医フラグ
     */
    public void setShiteiiFlag(boolean shiteiiFlag) {
        this.shiteiiFlag = shiteiiFlag;
    }

    /**
     * 意見書データ種別のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：意見書データ種別）
     * 
     * @return 意見書データ種別
     */
    @CheckForNull
    public Code getIkenshoDataShubetsu() {
        return ikenshoDataShubetsu;
    }

    /**
     * 意見書データ種別のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：意見書データ種別）
     * 
     * @param ikenshoDataShubetsu 意見書データ種別
     */
    public void setIkenshoDataShubetsu(Code ikenshoDataShubetsu) {
        this.ikenshoDataShubetsu = ikenshoDataShubetsu;
    }

    /**
     * 主治医への連絡事項のgetメソッドです。
     * 
     * @return 主治医への連絡事項
     */
    @CheckForNull
    public RString getRenrakuJikoToShujii() {
        return renrakuJikoToShujii;
    }

    /**
     * 主治医への連絡事項のsetメソッドです。
     * 
     * @param renrakuJikoToShujii 主治医への連絡事項
     */
    public void setRenrakuJikoToShujii(RString renrakuJikoToShujii) {
        this.renrakuJikoToShujii = renrakuJikoToShujii;
    }

    /**
     * 認定延期通知発行しないことに対する同意有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定延期通知発行しないことに対する同意有無）
     * 
     * @return 認定延期通知発行しないことに対する同意有無
     */
    @CheckForNull
    public boolean getEnkitsuchiNashiDoiFlag() {
        return enkitsuchiNashiDoiFlag;
    }

    /**
     * 認定延期通知発行しないことに対する同意有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定延期通知発行しないことに対する同意有無）
     * 
     * @param enkitsuchiNashiDoiFlag 認定延期通知発行しないことに対する同意有無
     */
    public void setEnkitsuchiNashiDoiFlag(boolean enkitsuchiNashiDoiFlag) {
        this.enkitsuchiNashiDoiFlag = enkitsuchiNashiDoiFlag;
    }

    /**
     * 施設入所の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：施設入所の有無）
     * 
     * @return 施設入所の有無
     */
    @CheckForNull
    public boolean getShisetsuNyushoFlag() {
        return shisetsuNyushoFlag;
    }

    /**
     * 施設入所の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：施設入所の有無）
     * 
     * @param shisetsuNyushoFlag 施設入所の有無
     */
    public void setShisetsuNyushoFlag(boolean shisetsuNyushoFlag) {
        this.shisetsuNyushoFlag = shisetsuNyushoFlag;
    }

    /**
     * 入所施設コードのgetメソッドです。
     * <br/>
     * <br/>介護事業者の事業者番号または、医療機関コード
     * 
     * @return 入所施設コード
     */
    @CheckForNull
    public JigyoshaNo getNyushoShisetsuCode() {
        return nyushoShisetsuCode;
    }

    /**
     * 入所施設コードのsetメソッドです。
     * <br/>
     * <br/>介護事業者の事業者番号または、医療機関コード
     * 
     * @param nyushoShisetsuCode 入所施設コード
     */
    public void setNyushoShisetsuCode(JigyoshaNo nyushoShisetsuCode) {
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    /**
     * 家庭訪問の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：家庭訪問の有無）
     * 
     * @return 家庭訪問の有無
     */
    @CheckForNull
    public boolean getKateiHomonFlag() {
        return kateiHomonFlag;
    }

    /**
     * 家庭訪問の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：家庭訪問の有無）
     * 
     * @param kateiHomonFlag 家庭訪問の有無
     */
    public void setKateiHomonFlag(boolean kateiHomonFlag) {
        this.kateiHomonFlag = kateiHomonFlag;
    }

    /**
     * 訪問調査先郵便番号のgetメソッドです。
     * 
     * @return 訪問調査先郵便番号
     */
    @CheckForNull
    public YubinNo getHomonChosasakiYubinNo() {
        return homonChosasakiYubinNo;
    }

    /**
     * 訪問調査先郵便番号のsetメソッドです。
     * 
     * @param homonChosasakiYubinNo 訪問調査先郵便番号
     */
    public void setHomonChosasakiYubinNo(YubinNo homonChosasakiYubinNo) {
        this.homonChosasakiYubinNo = homonChosasakiYubinNo;
    }

    /**
     * 訪問調査先住所のgetメソッドです。
     * 
     * @return 訪問調査先住所
     */
    @CheckForNull
    public AtenaJusho getHomonChosasakiJusho() {
        return homonChosasakiJusho;
    }

    /**
     * 訪問調査先住所のsetメソッドです。
     * 
     * @param homonChosasakiJusho 訪問調査先住所
     */
    public void setHomonChosasakiJusho(AtenaJusho homonChosasakiJusho) {
        this.homonChosasakiJusho = homonChosasakiJusho;
    }

    /**
     * 訪問調査先名称のgetメソッドです。
     * 
     * @return 訪問調査先名称
     */
    @CheckForNull
    public AtenaMeisho getHomonChosasakiName() {
        return homonChosasakiName;
    }

    /**
     * 訪問調査先名称のsetメソッドです。
     * 
     * @param homonChosasakiName 訪問調査先名称
     */
    public void setHomonChosasakiName(AtenaMeisho homonChosasakiName) {
        this.homonChosasakiName = homonChosasakiName;
    }

    /**
     * 訪問調査先電話番号のgetメソッドです。
     * 
     * @return 訪問調査先電話番号
     */
    @CheckForNull
    public TelNo getHomonChosasakiTelNo() {
        return homonChosasakiTelNo;
    }

    /**
     * 訪問調査先電話番号のsetメソッドです。
     * 
     * @param homonChosasakiTelNo 訪問調査先電話番号
     */
    public void setHomonChosasakiTelNo(TelNo homonChosasakiTelNo) {
        this.homonChosasakiTelNo = homonChosasakiTelNo;
    }

    /**
     * 市町村連絡事項のgetメソッドです。
     * <br/>
     * <br/>広域運用時、市町村から広域連合に伝えたい事務連絡事項を登録する
     * 
     * @return 市町村連絡事項
     */
    @CheckForNull
    public RString getShichosonRenrakuJiko() {
        return shichosonRenrakuJiko;
    }

    /**
     * 市町村連絡事項のsetメソッドです。
     * <br/>
     * <br/>広域運用時、市町村から広域連合に伝えたい事務連絡事項を登録する
     * 
     * @param shichosonRenrakuJiko 市町村連絡事項
     */
    public void setShichosonRenrakuJiko(RString shichosonRenrakuJiko) {
        this.shichosonRenrakuJiko = shichosonRenrakuJiko;
    }

    /**
     * 処理状態区分のgetメソッドです。
     * <br/>
     * <br/>旧「処理区分」
     * 
     * @return 処理状態区分
     */
    @CheckForNull
    public Code getShoriJotaiKubun() {
        return shoriJotaiKubun;
    }

    /**
     * 処理状態区分のsetメソッドです。
     * <br/>
     * <br/>旧「処理区分」
     * 
     * @param shoriJotaiKubun 処理状態区分
     */
    public void setShoriJotaiKubun(Code shoriJotaiKubun) {
        this.shoriJotaiKubun = shoriJotaiKubun;
    }

    /**
     * 取下年月日のgetメソッドです。
     * 
     * @return 取下年月日
     */
    @CheckForNull
    public FlexibleDate getTorisageYMD() {
        return torisageYMD;
    }

    /**
     * 取下年月日のsetメソッドです。
     * 
     * @param torisageYMD 取下年月日
     */
    public void setTorisageYMD(FlexibleDate torisageYMD) {
        this.torisageYMD = torisageYMD;
    }

    /**
     * 取下理由のgetメソッドです。
     * 
     * @return 取下理由
     */
    @CheckForNull
    public RString getTorisageRiyu() {
        return torisageRiyu;
    }

    /**
     * 取下理由のsetメソッドです。
     * 
     * @param torisageRiyu 取下理由
     */
    public void setTorisageRiyu(RString torisageRiyu) {
        this.torisageRiyu = torisageRiyu;
    }

    /**
     * 却下年月日のgetメソッドです。
     * 
     * @return 却下年月日
     */
    @CheckForNull
    public FlexibleDate getKyakkaYMD() {
        return kyakkaYMD;
    }

    /**
     * 却下年月日のsetメソッドです。
     * 
     * @param kyakkaYMD 却下年月日
     */
    public void setKyakkaYMD(FlexibleDate kyakkaYMD) {
        this.kyakkaYMD = kyakkaYMD;
    }

    /**
     * 却下理由のgetメソッドです。
     * 
     * @return 却下理由
     */
    @CheckForNull
    public RString getKyakkaRiyu() {
        return kyakkaRiyu;
    }

    /**
     * 却下理由のsetメソッドです。
     * 
     * @param kyakkaRiyu 却下理由
     */
    public void setKyakkaRiyu(RString kyakkaRiyu) {
        this.kyakkaRiyu = kyakkaRiyu;
    }

    /**
     * 延期決定年月日のgetメソッドです。
     * 
     * @return 延期決定年月日
     */
    @CheckForNull
    public FlexibleDate getEnkiKetteiYMD() {
        return enkiKetteiYMD;
    }

    /**
     * 延期決定年月日のsetメソッドです。
     * 
     * @param enkiKetteiYMD 延期決定年月日
     */
    public void setEnkiKetteiYMD(FlexibleDate enkiKetteiYMD) {
        this.enkiKetteiYMD = enkiKetteiYMD;
    }

    /**
     * 延期理由のgetメソッドです。
     * 
     * @return 延期理由
     */
    @CheckForNull
    public RString getEnkiRiyu() {
        return enkiRiyu;
    }

    /**
     * 延期理由のsetメソッドです。
     * 
     * @param enkiRiyu 延期理由
     */
    public void setEnkiRiyu(RString enkiRiyu) {
        this.enkiRiyu = enkiRiyu;
    }

    /**
     * 延期通知発行年月日のgetメソッドです。
     * 
     * @return 延期通知発行年月日
     */
    @CheckForNull
    public FlexibleDate getEnkiTsuchiHakkoYMD() {
        return enkiTsuchiHakkoYMD;
    }

    /**
     * 延期通知発行年月日のsetメソッドです。
     * 
     * @param enkiTsuchiHakkoYMD 延期通知発行年月日
     */
    public void setEnkiTsuchiHakkoYMD(FlexibleDate enkiTsuchiHakkoYMD) {
        this.enkiTsuchiHakkoYMD = enkiTsuchiHakkoYMD;
    }

    /**
     * 延期通知発行回数のgetメソッドです。
     * 
     * @return 延期通知発行回数
     */
    @CheckForNull
    public int getEnkiTsuchiHakkoKaisu() {
        return enkiTsuchiHakkoKaisu;
    }

    /**
     * 延期通知発行回数のsetメソッドです。
     * 
     * @param enkiTsuchiHakkoKaisu 延期通知発行回数
     */
    public void setEnkiTsuchiHakkoKaisu(int enkiTsuchiHakkoKaisu) {
        this.enkiTsuchiHakkoKaisu = enkiTsuchiHakkoKaisu;
    }

    /**
     * 延期見込期間開始年月日のgetメソッドです。
     * 
     * @return 延期見込期間開始年月日
     */
    @CheckForNull
    public FlexibleDate getEnkiMikomiKaishiYMD() {
        return enkiMikomiKaishiYMD;
    }

    /**
     * 延期見込期間開始年月日のsetメソッドです。
     * 
     * @param enkiMikomiKaishiYMD 延期見込期間開始年月日
     */
    public void setEnkiMikomiKaishiYMD(FlexibleDate enkiMikomiKaishiYMD) {
        this.enkiMikomiKaishiYMD = enkiMikomiKaishiYMD;
    }

    /**
     * 延期見込期間終了年月日のgetメソッドです。
     * 
     * @return 延期見込期間終了年月日
     */
    @CheckForNull
    public FlexibleDate getEnkiMikomiShuryoYMD() {
        return enkiMikomiShuryoYMD;
    }

    /**
     * 延期見込期間終了年月日のsetメソッドです。
     * 
     * @param enkiMikomiShuryoYMD 延期見込期間終了年月日
     */
    public void setEnkiMikomiShuryoYMD(FlexibleDate enkiMikomiShuryoYMD) {
        this.enkiMikomiShuryoYMD = enkiMikomiShuryoYMD;
    }

    /**
     * 審査継続区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：審査継続区分）
     * 
     * @return 審査継続区分
     */
    @CheckForNull
    public boolean getShinsaKeizokuFlag() {
        return shinsaKeizokuFlag;
    }

    /**
     * 審査継続区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：審査継続区分）
     * 
     * @param shinsaKeizokuFlag 審査継続区分
     */
    public void setShinsaKeizokuFlag(boolean shinsaKeizokuFlag) {
        this.shinsaKeizokuFlag = shinsaKeizokuFlag;
    }

    /**
     * 介護認定審査会優先振分区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：介護認定審査会優先振分区分コード）
     * 
     * @return 介護認定審査会優先振分区分コード
     */
    @CheckForNull
    public Code getShinsakaiYusenWaritsukeKubunCode() {
        return shinsakaiYusenWaritsukeKubunCode;
    }

    /**
     * 介護認定審査会優先振分区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：介護認定審査会優先振分区分コード）
     * 
     * @param shinsakaiYusenWaritsukeKubunCode 介護認定審査会優先振分区分コード
     */
    public void setShinsakaiYusenWaritsukeKubunCode(Code shinsakaiYusenWaritsukeKubunCode) {
        this.shinsakaiYusenWaritsukeKubunCode = shinsakaiYusenWaritsukeKubunCode;
    }

    /**
     * 更新通知発行年月日のgetメソッドです。
     * 
     * @return 更新通知発行年月日
     */
    @CheckForNull
    public FlexibleDate getKoshinTsuchiHakkoYMD() {
        return koshinTsuchiHakkoYMD;
    }

    /**
     * 更新通知発行年月日のsetメソッドです。
     * 
     * @param koshinTsuchiHakkoYMD 更新通知発行年月日
     */
    public void setKoshinTsuchiHakkoYMD(FlexibleDate koshinTsuchiHakkoYMD) {
        this.koshinTsuchiHakkoYMD = koshinTsuchiHakkoYMD;
    }

    /**
     * 更新通知発行完了年月日のgetメソッドです。
     * 
     * @return 更新通知発行完了年月日
     */
    @CheckForNull
    public FlexibleDate getKoshinTsuchiHakkoKanryoYMD() {
        return koshinTsuchiHakkoKanryoYMD;
    }

    /**
     * 更新通知発行完了年月日のsetメソッドです。
     * 
     * @param koshinTsuchiHakkoKanryoYMD 更新通知発行完了年月日
     */
    public void setKoshinTsuchiHakkoKanryoYMD(FlexibleDate koshinTsuchiHakkoKanryoYMD) {
        this.koshinTsuchiHakkoKanryoYMD = koshinTsuchiHakkoKanryoYMD;
    }

    /**
     * 認定申請情報登録年月日のgetメソッドです。
     * 
     * @return 認定申請情報登録年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiShinseiJohoTorokuYMD() {
        return ninteiShinseiJohoTorokuYMD;
    }

    /**
     * 認定申請情報登録年月日のsetメソッドです。
     * 
     * @param ninteiShinseiJohoTorokuYMD 認定申請情報登録年月日
     */
    public void setNinteiShinseiJohoTorokuYMD(FlexibleDate ninteiShinseiJohoTorokuYMD) {
        this.ninteiShinseiJohoTorokuYMD = ninteiShinseiJohoTorokuYMD;
    }

    /**
     * 再調査依頼回数のgetメソッドです。
     * 
     * @return 再調査依頼回数
     */
    @CheckForNull
    public int getSaiChosaIraiKaisu() {
        return saiChosaIraiKaisu;
    }

    /**
     * 再調査依頼回数のsetメソッドです。
     * 
     * @param saiChosaIraiKaisu 再調査依頼回数
     */
    public void setSaiChosaIraiKaisu(int saiChosaIraiKaisu) {
        this.saiChosaIraiKaisu = saiChosaIraiKaisu;
    }

    /**
     * 再作成依頼回数のgetメソッドです。
     * 
     * @return 再作成依頼回数
     */
    @CheckForNull
    public int getSaiSakuseiIraiKaisu() {
        return saiSakuseiIraiKaisu;
    }

    /**
     * 再作成依頼回数のsetメソッドです。
     * 
     * @param saiSakuseiIraiKaisu 再作成依頼回数
     */
    public void setSaiSakuseiIraiKaisu(int saiSakuseiIraiKaisu) {
        this.saiSakuseiIraiKaisu = saiSakuseiIraiKaisu;
    }

    /**
     * ＩＦ送付年月日のgetメソッドです。
     * 
     * @return ＩＦ送付年月日
     */
    @CheckForNull
    public FlexibleDate getIfSofuYMD() {
        return ifSofuYMD;
    }

    /**
     * ＩＦ送付年月日のsetメソッドです。
     * 
     * @param ifSofuYMD ＩＦ送付年月日
     */
    public void setIfSofuYMD(FlexibleDate ifSofuYMD) {
        this.ifSofuYMD = ifSofuYMD;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     * <br/>
     * <br/>True：論理削除　False：論理未削除
     * 
     * @return 論理削除フラグ
     */
    @CheckForNull
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * 論理削除フラグのsetメソッドです。
     * <br/>
     * <br/>True：論理削除　False：論理未削除
     * 
     * @param logicalDeletedFlag 論理削除フラグ
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5101NinteiShinseiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5101NinteiShinseiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5101NinteiShinseiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5101NinteiShinseiJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shinseiNendo = entity.shinseiNendo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.ninteiShinseiYMD = entity.ninteiShinseiYMD;
        this.ninteiShinseiEdabanCode = entity.ninteiShinseiEdabanCode;
        this.ninteiShinseiHoreiKubunCode = entity.ninteiShinseiHoreiKubunCode;
        this.ninteiShinseiShinseijiKubunCode = entity.ninteiShinseiShinseijiKubunCode;
        this.torisageKubunCode = entity.torisageKubunCode;
        this.hihokenshaKubunCode = entity.hihokenshaKubunCode;
        this.seinengappiYMD = entity.seinengappiYMD;
        this.age = entity.age;
        this.seibetsu = entity.seibetsu;
        this.hihokenshaKana = entity.hihokenshaKana;
        this.hihokenshaName = entity.hihokenshaName;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.telNo = entity.telNo;
        this.shishoCode = entity.shishoCode;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.chikuCode = entity.chikuCode;
        this.minashiNigoEtcTaishoFlag = entity.minashiNigoEtcTaishoFlag;
        this.koikinaiTenkyoKubun = entity.koikinaiTenkyoKubun;
        this.ninteiShinseiYukoKubunCode = entity.ninteiShinseiYukoKubunCode;
        this.shienShinseiKubun = entity.shienShinseiKubun;
        this.ninteiShinseiRiyu = entity.ninteiShinseiRiyu;
        this.shinseiServiceDeleteRiyu = entity.shinseiServiceDeleteRiyu;
        this.zenYokaigoKubunCode = entity.zenYokaigoKubunCode;
        this.zenkaiNinteiYMD = entity.zenkaiNinteiYMD;
        this.zenkaiYukoKikanStart = entity.zenkaiYukoKikanStart;
        this.zenkaiYukoKikanEnd = entity.zenkaiYukoKikanEnd;
        this.nigoIryoHokenshaName = entity.nigoIryoHokenshaName;
        this.nigoIryoHokenKigoBango = entity.nigoIryoHokenKigoBango;
        this.nigoTokuteiShippeiCode = entity.nigoTokuteiShippeiCode;
        this.jidoWariateJogaishaKubun = entity.jidoWariateJogaishaKubun;
        this.johoteikyoDoiFlag = entity.johoteikyoDoiFlag;
        this.johoteikyoSiryoOutputYMD = entity.johoteikyoSiryoOutputYMD;
        this.chosaKubun = entity.chosaKubun;
        this.ninteiChosaItakusakiCode = entity.ninteiChosaItakusakiCode;
        this.ninteiChosainCode = entity.ninteiChosainCode;
        this.renrakuJikoToChosain = entity.renrakuJikoToChosain;
        this.shujiiIryokikanCode = entity.shujiiIryokikanCode;
        this.shujiiCode = entity.shujiiCode;
        this.shiteiiFlag = entity.shiteiiFlag;
        this.ikenshoDataShubetsu = entity.ikenshoDataShubetsu;
        this.renrakuJikoToShujii = entity.renrakuJikoToShujii;
        this.enkitsuchiNashiDoiFlag = entity.enkitsuchiNashiDoiFlag;
        this.shisetsuNyushoFlag = entity.shisetsuNyushoFlag;
        this.nyushoShisetsuCode = entity.nyushoShisetsuCode;
        this.kateiHomonFlag = entity.kateiHomonFlag;
        this.homonChosasakiYubinNo = entity.homonChosasakiYubinNo;
        this.homonChosasakiJusho = entity.homonChosasakiJusho;
        this.homonChosasakiName = entity.homonChosasakiName;
        this.homonChosasakiTelNo = entity.homonChosasakiTelNo;
        this.shichosonRenrakuJiko = entity.shichosonRenrakuJiko;
        this.shoriJotaiKubun = entity.shoriJotaiKubun;
        this.torisageYMD = entity.torisageYMD;
        this.torisageRiyu = entity.torisageRiyu;
        this.kyakkaYMD = entity.kyakkaYMD;
        this.kyakkaRiyu = entity.kyakkaRiyu;
        this.enkiKetteiYMD = entity.enkiKetteiYMD;
        this.enkiRiyu = entity.enkiRiyu;
        this.enkiTsuchiHakkoYMD = entity.enkiTsuchiHakkoYMD;
        this.enkiTsuchiHakkoKaisu = entity.enkiTsuchiHakkoKaisu;
        this.enkiMikomiKaishiYMD = entity.enkiMikomiKaishiYMD;
        this.enkiMikomiShuryoYMD = entity.enkiMikomiShuryoYMD;
        this.shinsaKeizokuFlag = entity.shinsaKeizokuFlag;
        this.shinsakaiYusenWaritsukeKubunCode = entity.shinsakaiYusenWaritsukeKubunCode;
        this.koshinTsuchiHakkoYMD = entity.koshinTsuchiHakkoYMD;
        this.koshinTsuchiHakkoKanryoYMD = entity.koshinTsuchiHakkoKanryoYMD;
        this.ninteiShinseiJohoTorokuYMD = entity.ninteiShinseiJohoTorokuYMD;
        this.saiChosaIraiKaisu = entity.saiChosaIraiKaisu;
        this.saiSakuseiIraiKaisu = entity.saiSakuseiIraiKaisu;
        this.ifSofuYMD = entity.ifSofuYMD;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, koroshoIfShikibetsuCode, shoKisaiHokenshaNo, shinseiNendo, hihokenshaNo, ninteiShinseiYMD, ninteiShinseiEdabanCode, ninteiShinseiHoreiKubunCode, ninteiShinseiShinseijiKubunCode, torisageKubunCode, hihokenshaKubunCode, seinengappiYMD, age, seibetsu, hihokenshaKana, hihokenshaName, yubinNo, jusho, telNo, shishoCode, shikibetsuCode, chikuCode, minashiNigoEtcTaishoFlag, koikinaiTenkyoKubun, ninteiShinseiYukoKubunCode, shienShinseiKubun, ninteiShinseiRiyu, shinseiServiceDeleteRiyu, zenYokaigoKubunCode, zenkaiNinteiYMD, zenkaiYukoKikanStart, zenkaiYukoKikanEnd, nigoIryoHokenshaName, nigoIryoHokenKigoBango, nigoTokuteiShippeiCode, jidoWariateJogaishaKubun, johoteikyoDoiFlag, johoteikyoSiryoOutputYMD, chosaKubun, ninteiChosaItakusakiCode, ninteiChosainCode, renrakuJikoToChosain, shujiiIryokikanCode, shujiiCode, shiteiiFlag, ikenshoDataShubetsu, renrakuJikoToShujii, enkitsuchiNashiDoiFlag, shisetsuNyushoFlag, nyushoShisetsuCode, kateiHomonFlag, homonChosasakiYubinNo, homonChosasakiJusho, homonChosasakiName, homonChosasakiTelNo, shichosonRenrakuJiko, shoriJotaiKubun, torisageYMD, torisageRiyu, kyakkaYMD, kyakkaRiyu, enkiKetteiYMD, enkiRiyu, enkiTsuchiHakkoYMD, enkiTsuchiHakkoKaisu, enkiMikomiKaishiYMD, enkiMikomiShuryoYMD, shinsaKeizokuFlag, shinsakaiYusenWaritsukeKubunCode, koshinTsuchiHakkoYMD, koshinTsuchiHakkoKanryoYMD, ninteiShinseiJohoTorokuYMD, saiChosaIraiKaisu, saiSakuseiIraiKaisu, ifSofuYMD, logicalDeletedFlag);
    }

// </editor-fold>



}

package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 要介護認定主治医意見書情報（子）テーブルのエンティティクラスです。
 */
public class DbT4302ShujiiIkenshoJohoChildEntity extends DbTableEntityBase<DbT4302ShujiiIkenshoJohoChildEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4302ShujiiIkenshoJohoChild");

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
    @PrimaryKey
    private int ikenshoIraiRirekiNo;
    private RString koroshoIfShikibetsuCode;
    private RString ikenshoIraiKubun;
    private RString shujiiIryoKikanCode;
    private RString shujiiCode;
    private FlexibleDate ikenshoJuryoYMD;
    private FlexibleDate ikenshoKinyuYMD;
    private Code ikenshoSakuseiKaisuKubun;
    private Code zaitakuShisetsuKubun;
    private boolean ikenshoDoiFlag;
    private FlexibleDate saishuShinryoYMD;
    private boolean existTakaJushinFlag;
    private boolean existNaikaJushinFlag;
    private boolean existSeishinkaJushinFlag;
    private boolean existGekaJushinFlag;
    private boolean existSeikeigekaJushinFlag;
    private boolean existNoshinkeigekaJushinFlag;
    private boolean existHifukaJushinFlag;
    private boolean existHinyokikaJushinFlag;
    private boolean existFujinkaJushinFlag;
    private boolean existJibiinkokaJushinFlag;
    private boolean existRehabilitationkaJushinFlag;
    private boolean existShikaJushinFlag;
    private boolean existGankaJushinFlag;
    private boolean existSonotaJushinkaFlag;
    private RString sonotaJushinKaMei;
    private RString shindamMei1;
    private RString hasshoYMD1;
    private RString shindamMei2;
    private RString hasshoYMD2;
    private RString shindamMei3;
    private RString hasshoYMD3;
    private RString anteisei;
    private RString fuanteiJokyo;
    private RString chiryoNaiyo;
    private RString tokkiJiko;
    private boolean nijiHanteiKekkaRenrakuFlag;
    private RString ikenshoMemo;

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
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(@Nonnull ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 主治医意見書作成依頼履歴番号のgetメソッドです。
     * <br/>
     * <br/>主治医意見書作成依頼情報
     * 
     * @return 主治医意見書作成依頼履歴番号
     */
    public int getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    /**
     * 主治医意見書作成依頼履歴番号のsetメソッドです。
     * <br/>
     * <br/>主治医意見書作成依頼情報
     * 
     * @param ikenshoIraiRirekiNo 主治医意見書作成依頼履歴番号
     */
    public void setIkenshoIraiRirekiNo(@Nonnull int ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    /**
     * 厚労省IF識別コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）
     * 
     * @return 厚労省IF識別コード
     */
    public RString getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * 厚労省IF識別コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）
     * 
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     */
    public void setKoroshoIfShikibetsuCode(@Nonnull RString koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 主治医意見書依頼区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：主治医意見書依頼区分）
     * 
     * @return 主治医意見書依頼区分
     */
    public RString getIkenshoIraiKubun() {
        return ikenshoIraiKubun;
    }

    /**
     * 主治医意見書依頼区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：主治医意見書依頼区分）
     * 
     * @param ikenshoIraiKubun 主治医意見書依頼区分
     */
    public void setIkenshoIraiKubun(@Nonnull RString ikenshoIraiKubun) {
        this.ikenshoIraiKubun = ikenshoIraiKubun;
    }

    /**
     * 主治医医療機関コードのgetメソッドです。
     * <br/>
     * <br/>主治医医療機関情報
     * 
     * @return 主治医医療機関コード
     */
    public RString getShujiiIryoKikanCode() {
        return shujiiIryoKikanCode;
    }

    /**
     * 主治医医療機関コードのsetメソッドです。
     * <br/>
     * <br/>主治医医療機関情報
     * 
     * @param shujiiIryoKikanCode 主治医医療機関コード
     */
    public void setShujiiIryoKikanCode(@Nonnull RString shujiiIryoKikanCode) {
        this.shujiiIryoKikanCode = shujiiIryoKikanCode;
    }

    /**
     * 主治医コードのgetメソッドです。
     * <br/>
     * <br/>主治医情報
     * 
     * @return 主治医コード
     */
    public RString getShujiiCode() {
        return shujiiCode;
    }

    /**
     * 主治医コードのsetメソッドです。
     * <br/>
     * <br/>主治医情報
     * 
     * @param shujiiCode 主治医コード
     */
    public void setShujiiCode(@Nonnull RString shujiiCode) {
        this.shujiiCode = shujiiCode;
    }

    /**
     * 主治医意見書受領年月日のgetメソッドです。
     * 
     * @return 主治医意見書受領年月日
     */
    public FlexibleDate getIkenshoJuryoYMD() {
        return ikenshoJuryoYMD;
    }

    /**
     * 主治医意見書受領年月日のsetメソッドです。
     * 
     * @param ikenshoJuryoYMD 主治医意見書受領年月日
     */
    public void setIkenshoJuryoYMD(@Nonnull FlexibleDate ikenshoJuryoYMD) {
        this.ikenshoJuryoYMD = ikenshoJuryoYMD;
    }

    /**
     * 主治医意見書記入年月日のgetメソッドです。
     * 
     * @return 主治医意見書記入年月日
     */
    public FlexibleDate getIkenshoKinyuYMD() {
        return ikenshoKinyuYMD;
    }

    /**
     * 主治医意見書記入年月日のsetメソッドです。
     * 
     * @param ikenshoKinyuYMD 主治医意見書記入年月日
     */
    public void setIkenshoKinyuYMD(@Nonnull FlexibleDate ikenshoKinyuYMD) {
        this.ikenshoKinyuYMD = ikenshoKinyuYMD;
    }

    /**
     * 意見書作成回数区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：意見書作成回数区分）初回/2回目以上
     * 
     * @return 意見書作成回数区分
     */
    @CheckForNull
    public Code getIkenshoSakuseiKaisuKubun() {
        return ikenshoSakuseiKaisuKubun;
    }

    /**
     * 意見書作成回数区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：意見書作成回数区分）初回/2回目以上
     * 
     * @param ikenshoSakuseiKaisuKubun 意見書作成回数区分
     */
    public void setIkenshoSakuseiKaisuKubun(Code ikenshoSakuseiKaisuKubun) {
        this.ikenshoSakuseiKaisuKubun = ikenshoSakuseiKaisuKubun;
    }

    /**
     * 在宅／施設区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：在宅/施設区分）在宅/施設
     * 
     * @return 在宅／施設区分
     */
    @CheckForNull
    public Code getZaitakuShisetsuKubun() {
        return zaitakuShisetsuKubun;
    }

    /**
     * 在宅／施設区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：在宅/施設区分）在宅/施設
     * 
     * @param zaitakuShisetsuKubun 在宅／施設区分
     */
    public void setZaitakuShisetsuKubun(Code zaitakuShisetsuKubun) {
        this.zaitakuShisetsuKubun = zaitakuShisetsuKubun;
    }

    /**
     * 意見書同意フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：意見書同意フラグ）
     * 
     * @return 意見書同意フラグ
     */
    @CheckForNull
    public boolean getIkenshoDoiFlag() {
        return ikenshoDoiFlag;
    }

    /**
     * 意見書同意フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：意見書同意フラグ）
     * 
     * @param ikenshoDoiFlag 意見書同意フラグ
     */
    public void setIkenshoDoiFlag(boolean ikenshoDoiFlag) {
        this.ikenshoDoiFlag = ikenshoDoiFlag;
    }

    /**
     * 最終診療日のgetメソッドです。
     * 
     * @return 最終診療日
     */
    @CheckForNull
    public FlexibleDate getSaishuShinryoYMD() {
        return saishuShinryoYMD;
    }

    /**
     * 最終診療日のsetメソッドです。
     * 
     * @param saishuShinryoYMD 最終診療日
     */
    public void setSaishuShinryoYMD(FlexibleDate saishuShinryoYMD) {
        this.saishuShinryoYMD = saishuShinryoYMD;
    }

    /**
     * 他科受診の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：他科受診の有無）
     * 
     * @return 他科受診の有無
     */
    @CheckForNull
    public boolean getExistTakaJushinFlag() {
        return existTakaJushinFlag;
    }

    /**
     * 他科受診の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：他科受診の有無）
     * 
     * @param existTakaJushinFlag 他科受診の有無
     */
    public void setExistTakaJushinFlag(boolean existTakaJushinFlag) {
        this.existTakaJushinFlag = existTakaJushinFlag;
    }

    /**
     * 内科受診の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：内科受診の有無）
     * 
     * @return 内科受診の有無
     */
    @CheckForNull
    public boolean getExistNaikaJushinFlag() {
        return existNaikaJushinFlag;
    }

    /**
     * 内科受診の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：内科受診の有無）
     * 
     * @param existNaikaJushinFlag 内科受診の有無
     */
    public void setExistNaikaJushinFlag(boolean existNaikaJushinFlag) {
        this.existNaikaJushinFlag = existNaikaJushinFlag;
    }

    /**
     * 精神科受診の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：精神科受診の有無）
     * 
     * @return 精神科受診の有無
     */
    @CheckForNull
    public boolean getExistSeishinkaJushinFlag() {
        return existSeishinkaJushinFlag;
    }

    /**
     * 精神科受診の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：精神科受診の有無）
     * 
     * @param existSeishinkaJushinFlag 精神科受診の有無
     */
    public void setExistSeishinkaJushinFlag(boolean existSeishinkaJushinFlag) {
        this.existSeishinkaJushinFlag = existSeishinkaJushinFlag;
    }

    /**
     * 外科受診の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：外科受診の有無）
     * 
     * @return 外科受診の有無
     */
    @CheckForNull
    public boolean getExistGekaJushinFlag() {
        return existGekaJushinFlag;
    }

    /**
     * 外科受診の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：外科受診の有無）
     * 
     * @param existGekaJushinFlag 外科受診の有無
     */
    public void setExistGekaJushinFlag(boolean existGekaJushinFlag) {
        this.existGekaJushinFlag = existGekaJushinFlag;
    }

    /**
     * 整形外科受診の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：整形外科受診の有無）
     * 
     * @return 整形外科受診の有無
     */
    @CheckForNull
    public boolean getExistSeikeigekaJushinFlag() {
        return existSeikeigekaJushinFlag;
    }

    /**
     * 整形外科受診の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：整形外科受診の有無）
     * 
     * @param existSeikeigekaJushinFlag 整形外科受診の有無
     */
    public void setExistSeikeigekaJushinFlag(boolean existSeikeigekaJushinFlag) {
        this.existSeikeigekaJushinFlag = existSeikeigekaJushinFlag;
    }

    /**
     * 脳神経外科の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：脳神経外科受診の有無）
     * 
     * @return 脳神経外科の有無
     */
    @CheckForNull
    public boolean getExistNoshinkeigekaJushinFlag() {
        return existNoshinkeigekaJushinFlag;
    }

    /**
     * 脳神経外科の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：脳神経外科受診の有無）
     * 
     * @param existNoshinkeigekaJushinFlag 脳神経外科の有無
     */
    public void setExistNoshinkeigekaJushinFlag(boolean existNoshinkeigekaJushinFlag) {
        this.existNoshinkeigekaJushinFlag = existNoshinkeigekaJushinFlag;
    }

    /**
     * 皮膚科受診の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：皮膚科受診の有無）
     * 
     * @return 皮膚科受診の有無
     */
    @CheckForNull
    public boolean getExistHifukaJushinFlag() {
        return existHifukaJushinFlag;
    }

    /**
     * 皮膚科受診の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：皮膚科受診の有無）
     * 
     * @param existHifukaJushinFlag 皮膚科受診の有無
     */
    public void setExistHifukaJushinFlag(boolean existHifukaJushinFlag) {
        this.existHifukaJushinFlag = existHifukaJushinFlag;
    }

    /**
     * 泌尿器科受診の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：泌尿器科受診の有無）
     * 
     * @return 泌尿器科受診の有無
     */
    @CheckForNull
    public boolean getExistHinyokikaJushinFlag() {
        return existHinyokikaJushinFlag;
    }

    /**
     * 泌尿器科受診の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：泌尿器科受診の有無）
     * 
     * @param existHinyokikaJushinFlag 泌尿器科受診の有無
     */
    public void setExistHinyokikaJushinFlag(boolean existHinyokikaJushinFlag) {
        this.existHinyokikaJushinFlag = existHinyokikaJushinFlag;
    }

    /**
     * 婦人科受診の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：婦人科受診の有無）
     * 
     * @return 婦人科受診の有無
     */
    @CheckForNull
    public boolean getExistFujinkaJushinFlag() {
        return existFujinkaJushinFlag;
    }

    /**
     * 婦人科受診の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：婦人科受診の有無）
     * 
     * @param existFujinkaJushinFlag 婦人科受診の有無
     */
    public void setExistFujinkaJushinFlag(boolean existFujinkaJushinFlag) {
        this.existFujinkaJushinFlag = existFujinkaJushinFlag;
    }

    /**
     * 耳鼻咽喉科受診の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：耳鼻咽喉科受診の有無）
     * 
     * @return 耳鼻咽喉科受診の有無
     */
    @CheckForNull
    public boolean getExistJibiinkokaJushinFlag() {
        return existJibiinkokaJushinFlag;
    }

    /**
     * 耳鼻咽喉科受診の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：耳鼻咽喉科受診の有無）
     * 
     * @param existJibiinkokaJushinFlag 耳鼻咽喉科受診の有無
     */
    public void setExistJibiinkokaJushinFlag(boolean existJibiinkokaJushinFlag) {
        this.existJibiinkokaJushinFlag = existJibiinkokaJushinFlag;
    }

    /**
     * リハビリテーション科受診の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：リハビリテーション科受診の有無）
     * 
     * @return リハビリテーション科受診の有無
     */
    @CheckForNull
    public boolean getExistRehabilitationkaJushinFlag() {
        return existRehabilitationkaJushinFlag;
    }

    /**
     * リハビリテーション科受診の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：リハビリテーション科受診の有無）
     * 
     * @param existRehabilitationkaJushinFlag リハビリテーション科受診の有無
     */
    public void setExistRehabilitationkaJushinFlag(boolean existRehabilitationkaJushinFlag) {
        this.existRehabilitationkaJushinFlag = existRehabilitationkaJushinFlag;
    }

    /**
     * 歯科受診の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：歯科受診の有無）
     * 
     * @return 歯科受診の有無
     */
    @CheckForNull
    public boolean getExistShikaJushinFlag() {
        return existShikaJushinFlag;
    }

    /**
     * 歯科受診の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：歯科受診の有無）
     * 
     * @param existShikaJushinFlag 歯科受診の有無
     */
    public void setExistShikaJushinFlag(boolean existShikaJushinFlag) {
        this.existShikaJushinFlag = existShikaJushinFlag;
    }

    /**
     * 眼科の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：眼科受診の有無）
     * 
     * @return 眼科の有無
     */
    @CheckForNull
    public boolean getExistGankaJushinFlag() {
        return existGankaJushinFlag;
    }

    /**
     * 眼科の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：眼科受診の有無）
     * 
     * @param existGankaJushinFlag 眼科の有無
     */
    public void setExistGankaJushinFlag(boolean existGankaJushinFlag) {
        this.existGankaJushinFlag = existGankaJushinFlag;
    }

    /**
     * その他受診科の有無のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：その他受診科の有無）
     * 
     * @return その他受診科の有無
     */
    @CheckForNull
    public boolean getExistSonotaJushinkaFlag() {
        return existSonotaJushinkaFlag;
    }

    /**
     * その他受診科の有無のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：その他受診科の有無）
     * 
     * @param existSonotaJushinkaFlag その他受診科の有無
     */
    public void setExistSonotaJushinkaFlag(boolean existSonotaJushinkaFlag) {
        this.existSonotaJushinkaFlag = existSonotaJushinkaFlag;
    }

    /**
     * その他受診科名のgetメソッドです。
     * 
     * @return その他受診科名
     */
    @CheckForNull
    public RString getSonotaJushinKaMei() {
        return sonotaJushinKaMei;
    }

    /**
     * その他受診科名のsetメソッドです。
     * 
     * @param sonotaJushinKaMei その他受診科名
     */
    public void setSonotaJushinKaMei(RString sonotaJushinKaMei) {
        this.sonotaJushinKaMei = sonotaJushinKaMei;
    }

    /**
     * 意見書・診断名1のgetメソッドです。
     * 
     * @return 意見書・診断名1
     */
    @CheckForNull
    public RString getShindamMei1() {
        return shindamMei1;
    }

    /**
     * 意見書・診断名1のsetメソッドです。
     * 
     * @param shindamMei1 意見書・診断名1
     */
    public void setShindamMei1(RString shindamMei1) {
        this.shindamMei1 = shindamMei1;
    }

    /**
     * 意見書・発症年月日1のgetメソッドです。
     * 
     * @return 意見書・発症年月日1
     */
    @CheckForNull
    public RString getHasshoYMD1() {
        return hasshoYMD1;
    }

    /**
     * 意見書・発症年月日1のsetメソッドです。
     * 
     * @param hasshoYMD1 意見書・発症年月日1
     */
    public void setHasshoYMD1(RString hasshoYMD1) {
        this.hasshoYMD1 = hasshoYMD1;
    }

    /**
     * 意見書・診断名2のgetメソッドです。
     * 
     * @return 意見書・診断名2
     */
    @CheckForNull
    public RString getShindamMei2() {
        return shindamMei2;
    }

    /**
     * 意見書・診断名2のsetメソッドです。
     * 
     * @param shindamMei2 意見書・診断名2
     */
    public void setShindamMei2(RString shindamMei2) {
        this.shindamMei2 = shindamMei2;
    }

    /**
     * 意見書・発症年月日2のgetメソッドです。
     * 
     * @return 意見書・発症年月日2
     */
    @CheckForNull
    public RString getHasshoYMD2() {
        return hasshoYMD2;
    }

    /**
     * 意見書・発症年月日2のsetメソッドです。
     * 
     * @param hasshoYMD2 意見書・発症年月日2
     */
    public void setHasshoYMD2(RString hasshoYMD2) {
        this.hasshoYMD2 = hasshoYMD2;
    }

    /**
     * 意見書・診断名3のgetメソッドです。
     * 
     * @return 意見書・診断名3
     */
    @CheckForNull
    public RString getShindamMei3() {
        return shindamMei3;
    }

    /**
     * 意見書・診断名3のsetメソッドです。
     * 
     * @param shindamMei3 意見書・診断名3
     */
    public void setShindamMei3(RString shindamMei3) {
        this.shindamMei3 = shindamMei3;
    }

    /**
     * 意見書・発症年月日3のgetメソッドです。
     * 
     * @return 意見書・発症年月日3
     */
    @CheckForNull
    public RString getHasshoYMD3() {
        return hasshoYMD3;
    }

    /**
     * 意見書・発症年月日3のsetメソッドです。
     * 
     * @param hasshoYMD3 意見書・発症年月日3
     */
    public void setHasshoYMD3(RString hasshoYMD3) {
        this.hasshoYMD3 = hasshoYMD3;
    }

    /**
     * 意見書・症状としての安定性のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：意見書・症状としての安定性）
     * 
     * @return 意見書・症状としての安定性
     */
    @CheckForNull
    public RString getAnteisei() {
        return anteisei;
    }

    /**
     * 意見書・症状としての安定性のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：意見書・症状としての安定性）
     * 
     * @param anteisei 意見書・症状としての安定性
     */
    public void setAnteisei(RString anteisei) {
        this.anteisei = anteisei;
    }

    /**
     * 意見書・症状としての安定性　不安定状況のgetメソッドです。
     * 
     * @return 意見書・症状としての安定性　不安定状況
     */
    @CheckForNull
    public RString getFuanteiJokyo() {
        return fuanteiJokyo;
    }

    /**
     * 意見書・症状としての安定性　不安定状況のsetメソッドです。
     * 
     * @param fuanteiJokyo 意見書・症状としての安定性　不安定状況
     */
    public void setFuanteiJokyo(RString fuanteiJokyo) {
        this.fuanteiJokyo = fuanteiJokyo;
    }

    /**
     * 治療内容のgetメソッドです。
     * 
     * @return 治療内容
     */
    @CheckForNull
    public RString getChiryoNaiyo() {
        return chiryoNaiyo;
    }

    /**
     * 治療内容のsetメソッドです。
     * 
     * @param chiryoNaiyo 治療内容
     */
    public void setChiryoNaiyo(RString chiryoNaiyo) {
        this.chiryoNaiyo = chiryoNaiyo;
    }

    /**
     * 特記事項のgetメソッドです。
     * 
     * @return 特記事項
     */
    @CheckForNull
    public RString getTokkiJiko() {
        return tokkiJiko;
    }

    /**
     * 特記事項のsetメソッドです。
     * 
     * @param tokkiJiko 特記事項
     */
    public void setTokkiJiko(RString tokkiJiko) {
        this.tokkiJiko = tokkiJiko;
    }

    /**
     * 認定審査会後の二次判定結果の連絡確認フラグのgetメソッドです。
     * 
     * @return 認定審査会後の二次判定結果の連絡確認フラグ
     */
    @CheckForNull
    public boolean getNijiHanteiKekkaRenrakuFlag() {
        return nijiHanteiKekkaRenrakuFlag;
    }

    /**
     * 認定審査会後の二次判定結果の連絡確認フラグのsetメソッドです。
     * 
     * @param nijiHanteiKekkaRenrakuFlag 認定審査会後の二次判定結果の連絡確認フラグ
     */
    public void setNijiHanteiKekkaRenrakuFlag(boolean nijiHanteiKekkaRenrakuFlag) {
        this.nijiHanteiKekkaRenrakuFlag = nijiHanteiKekkaRenrakuFlag;
    }

    /**
     * 意見書メモのgetメソッドです。
     * <br/>
     * <br/>広域対応
     * 
     * @return 意見書メモ
     */
    @CheckForNull
    public RString getIkenshoMemo() {
        return ikenshoMemo;
    }

    /**
     * 意見書メモのsetメソッドです。
     * <br/>
     * <br/>広域対応
     * 
     * @param ikenshoMemo 意見書メモ
     */
    public void setIkenshoMemo(RString ikenshoMemo) {
        this.ikenshoMemo = ikenshoMemo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4302ShujiiIkenshoJohoChildEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4302ShujiiIkenshoJohoChildEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4302ShujiiIkenshoJohoChildEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ikenshoIraiRirekiNo != other.ikenshoIraiRirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4302ShujiiIkenshoJohoChildEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ikenshoIraiRirekiNo = entity.ikenshoIraiRirekiNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.ikenshoIraiKubun = entity.ikenshoIraiKubun;
        this.shujiiIryoKikanCode = entity.shujiiIryoKikanCode;
        this.shujiiCode = entity.shujiiCode;
        this.ikenshoJuryoYMD = entity.ikenshoJuryoYMD;
        this.ikenshoKinyuYMD = entity.ikenshoKinyuYMD;
        this.ikenshoSakuseiKaisuKubun = entity.ikenshoSakuseiKaisuKubun;
        this.zaitakuShisetsuKubun = entity.zaitakuShisetsuKubun;
        this.ikenshoDoiFlag = entity.ikenshoDoiFlag;
        this.saishuShinryoYMD = entity.saishuShinryoYMD;
        this.existTakaJushinFlag = entity.existTakaJushinFlag;
        this.existNaikaJushinFlag = entity.existNaikaJushinFlag;
        this.existSeishinkaJushinFlag = entity.existSeishinkaJushinFlag;
        this.existGekaJushinFlag = entity.existGekaJushinFlag;
        this.existSeikeigekaJushinFlag = entity.existSeikeigekaJushinFlag;
        this.existNoshinkeigekaJushinFlag = entity.existNoshinkeigekaJushinFlag;
        this.existHifukaJushinFlag = entity.existHifukaJushinFlag;
        this.existHinyokikaJushinFlag = entity.existHinyokikaJushinFlag;
        this.existFujinkaJushinFlag = entity.existFujinkaJushinFlag;
        this.existJibiinkokaJushinFlag = entity.existJibiinkokaJushinFlag;
        this.existRehabilitationkaJushinFlag = entity.existRehabilitationkaJushinFlag;
        this.existShikaJushinFlag = entity.existShikaJushinFlag;
        this.existGankaJushinFlag = entity.existGankaJushinFlag;
        this.existSonotaJushinkaFlag = entity.existSonotaJushinkaFlag;
        this.sonotaJushinKaMei = entity.sonotaJushinKaMei;
        this.shindamMei1 = entity.shindamMei1;
        this.hasshoYMD1 = entity.hasshoYMD1;
        this.shindamMei2 = entity.shindamMei2;
        this.hasshoYMD2 = entity.hasshoYMD2;
        this.shindamMei3 = entity.shindamMei3;
        this.hasshoYMD3 = entity.hasshoYMD3;
        this.anteisei = entity.anteisei;
        this.fuanteiJokyo = entity.fuanteiJokyo;
        this.chiryoNaiyo = entity.chiryoNaiyo;
        this.tokkiJiko = entity.tokkiJiko;
        this.nijiHanteiKekkaRenrakuFlag = entity.nijiHanteiKekkaRenrakuFlag;
        this.ikenshoMemo = entity.ikenshoMemo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ikenshoIraiRirekiNo, koroshoIfShikibetsuCode, ikenshoIraiKubun, shujiiIryoKikanCode, shujiiCode, ikenshoJuryoYMD, ikenshoKinyuYMD, ikenshoSakuseiKaisuKubun, zaitakuShisetsuKubun, ikenshoDoiFlag, saishuShinryoYMD, existTakaJushinFlag, existNaikaJushinFlag, existSeishinkaJushinFlag, existGekaJushinFlag, existSeikeigekaJushinFlag, existNoshinkeigekaJushinFlag, existHifukaJushinFlag, existHinyokikaJushinFlag, existFujinkaJushinFlag, existJibiinkokaJushinFlag, existRehabilitationkaJushinFlag, existShikaJushinFlag, existGankaJushinFlag, existSonotaJushinkaFlag, sonotaJushinKaMei, shindamMei1, hasshoYMD1, shindamMei2, hasshoYMD2, shindamMei3, hasshoYMD3, anteisei, fuanteiJokyo, chiryoNaiyo, tokkiJiko, nijiHanteiKekkaRenrakuFlag, ikenshoMemo);
    }

// </editor-fold>

}

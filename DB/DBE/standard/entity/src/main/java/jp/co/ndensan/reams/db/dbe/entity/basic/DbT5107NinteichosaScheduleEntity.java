package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;

/**
 * 要介護認定調査スケジュールテーブルのエンティティクラスです。
 */
public class DbT5107NinteichosaScheduleEntity extends DbTableEntityBase<DbT5107NinteichosaScheduleEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5107NinteichosaSchedule");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private DbUDD013ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int remban;
    private DbUDD003HokenshaNo shoKisaiHokenshaNo;
    private DbUDD004JigyoshaNo chosaItakusakiCode;
    private RString chosainCode;
    private FlexibleDate ninteichosaYoteiYMD;
    private RString ninteichosaYoteiKaishiTime;
    private RString ninteichosaYoteiShuryoTime;
    private int ichinichiMaxKensu;
    private RString ninteichosaKaishiTime;
    private RString ninteichosaShuryoTime;
    private ChikuCode chosaBashoChikuCode;
    private Code visitShurui;
    private DbUDD002HihokenshaNo hihokenshaNo;
    private RString memo;

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
    public DbUDD013ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(DbUDD013ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 連番のgetメソッドです。
     * 
     * @return 連番
     */
    public int getRemban() {
        return remban;
    }

    /**
     * 連番のsetメソッドです。
     * 
     * @param remban 連番
     */
    public void setRemban(int remban) {
        this.remban = remban;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     * 
     * @return 証記載保険者番号
     */
    public DbUDD003HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * 
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(DbUDD003HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 認定調査委託先コードのgetメソッドです。
     * 
     * @return 認定調査委託先コード
     */
    public DbUDD004JigyoshaNo getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    /**
     * 認定調査委託先コードのsetメソッドです。
     * 
     * @param chosaItakusakiCode 認定調査委託先コード
     */
    public void setChosaItakusakiCode(DbUDD004JigyoshaNo chosaItakusakiCode) {
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    /**
     * 認定調査員コードのgetメソッドです。
     * 
     * @return 認定調査員コード
     */
    public RString getChosainCode() {
        return chosainCode;
    }

    /**
     * 認定調査員コードのsetメソッドです。
     * 
     * @param chosainCode 認定調査員コード
     */
    public void setChosainCode(RString chosainCode) {
        this.chosainCode = chosainCode;
    }

    /**
     * 認定調査予定年月日のgetメソッドです。
     * 
     * @return 認定調査予定年月日
     */
    public FlexibleDate getNinteichosaYoteiYMD() {
        return ninteichosaYoteiYMD;
    }

    /**
     * 認定調査予定年月日のsetメソッドです。
     * 
     * @param ninteichosaYoteiYMD 認定調査予定年月日
     */
    public void setNinteichosaYoteiYMD(FlexibleDate ninteichosaYoteiYMD) {
        this.ninteichosaYoteiYMD = ninteichosaYoteiYMD;
    }

    /**
     * 認定調査予定開始時間のgetメソッドです。
     * 
     * @return 認定調査予定開始時間
     */
    public RString getNinteichosaYoteiKaishiTime() {
        return ninteichosaYoteiKaishiTime;
    }

    /**
     * 認定調査予定開始時間のsetメソッドです。
     * 
     * @param ninteichosaYoteiKaishiTime 認定調査予定開始時間
     */
    public void setNinteichosaYoteiKaishiTime(RString ninteichosaYoteiKaishiTime) {
        this.ninteichosaYoteiKaishiTime = ninteichosaYoteiKaishiTime;
    }

    /**
     * 認定調査予定終了時間のgetメソッドです。
     * 
     * @return 認定調査予定終了時間
     */
    public RString getNinteichosaYoteiShuryoTime() {
        return ninteichosaYoteiShuryoTime;
    }

    /**
     * 認定調査予定終了時間のsetメソッドです。
     * 
     * @param ninteichosaYoteiShuryoTime 認定調査予定終了時間
     */
    public void setNinteichosaYoteiShuryoTime(RString ninteichosaYoteiShuryoTime) {
        this.ninteichosaYoteiShuryoTime = ninteichosaYoteiShuryoTime;
    }

    /**
     * 一日最大調査件数のgetメソッドです。
     * 
     * @return 一日最大調査件数
     */
    public int getIchinichiMaxKensu() {
        return ichinichiMaxKensu;
    }

    /**
     * 一日最大調査件数のsetメソッドです。
     * 
     * @param ichinichiMaxKensu 一日最大調査件数
     */
    public void setIchinichiMaxKensu(int ichinichiMaxKensu) {
        this.ichinichiMaxKensu = ichinichiMaxKensu;
    }

    /**
     * 認定調査開始時間のgetメソッドです。
     * 
     * @return 認定調査開始時間
     */
    public RString getNinteichosaKaishiTime() {
        return ninteichosaKaishiTime;
    }

    /**
     * 認定調査開始時間のsetメソッドです。
     * 
     * @param ninteichosaKaishiTime 認定調査開始時間
     */
    public void setNinteichosaKaishiTime(RString ninteichosaKaishiTime) {
        this.ninteichosaKaishiTime = ninteichosaKaishiTime;
    }

    /**
     * 認定調査終了時間のgetメソッドです。
     * 
     * @return 認定調査終了時間
     */
    public RString getNinteichosaShuryoTime() {
        return ninteichosaShuryoTime;
    }

    /**
     * 認定調査終了時間のsetメソッドです。
     * 
     * @param ninteichosaShuryoTime 認定調査終了時間
     */
    public void setNinteichosaShuryoTime(RString ninteichosaShuryoTime) {
        this.ninteichosaShuryoTime = ninteichosaShuryoTime;
    }

    /**
     * 調査場所コードのgetメソッドです。
     * 
     * @return 調査場所コード
     */
    public ChikuCode getChosaBashoChikuCode() {
        return chosaBashoChikuCode;
    }

    /**
     * 調査場所コードのsetメソッドです。
     * 
     * @param chosaBashoChikuCode 調査場所コード
     */
    public void setChosaBashoChikuCode(ChikuCode chosaBashoChikuCode) {
        this.chosaBashoChikuCode = chosaBashoChikuCode;
    }

    /**
     * 訪問種類のgetメソッドです。
     * 
     * @return 訪問種類
     */
    public Code getVisitShurui() {
        return visitShurui;
    }

    /**
     * 訪問種類のsetメソッドです。
     * 
     * @param visitShurui 訪問種類
     */
    public void setVisitShurui(Code visitShurui) {
        this.visitShurui = visitShurui;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * 
     * @return 被保険者番号
     */
    public DbUDD002HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(DbUDD002HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * メモのgetメソッドです。
     * 
     * @return メモ
     */
    public RString getMemo() {
        return memo;
    }

    /**
     * メモのsetメソッドです。
     * 
     * @param memo メモ
     */
    public void setMemo(RString memo) {
        this.memo = memo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5107NinteichosaScheduleEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5107NinteichosaScheduleEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5107NinteichosaScheduleEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.remban != other.remban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5107NinteichosaScheduleEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.remban = entity.remban;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.chosaItakusakiCode = entity.chosaItakusakiCode;
        this.chosainCode = entity.chosainCode;
        this.ninteichosaYoteiYMD = entity.ninteichosaYoteiYMD;
        this.ninteichosaYoteiKaishiTime = entity.ninteichosaYoteiKaishiTime;
        this.ninteichosaYoteiShuryoTime = entity.ninteichosaYoteiShuryoTime;
        this.ichinichiMaxKensu = entity.ichinichiMaxKensu;
        this.ninteichosaKaishiTime = entity.ninteichosaKaishiTime;
        this.ninteichosaShuryoTime = entity.ninteichosaShuryoTime;
        this.chosaBashoChikuCode = entity.chosaBashoChikuCode;
        this.visitShurui = entity.visitShurui;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.memo = entity.memo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, remban, shoKisaiHokenshaNo, chosaItakusakiCode, chosainCode, ninteichosaYoteiYMD, ninteichosaYoteiKaishiTime, ninteichosaYoteiShuryoTime, ichinichiMaxKensu, ninteichosaKaishiTime, ninteichosaShuryoTime, chosaBashoChikuCode, visitShurui, hihokenshaNo, memo);
    }

// </editor-fold>
}

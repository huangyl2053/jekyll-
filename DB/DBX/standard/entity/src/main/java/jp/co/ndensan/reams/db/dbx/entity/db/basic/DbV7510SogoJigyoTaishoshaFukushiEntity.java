package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業対象者・福祉Viewテーブルのエンティティクラスです。
 */
public class DbV7510SogoJigyoTaishoshaFukushiEntity extends DbTableEntityBase<DbV7510SogoJigyoTaishoshaFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7510SogoJigyoTaishoshaFukushi");

    private HihokenshaNo hihokenshaNo;
    private int rirekiNo;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private FlexibleDate uketsukeYMD;
    private FlexibleDate ketteiYMD;
    private FlexibleDate checklistJisshiYMD;

    /**
     * hihokenshaNoのgetメソッドです。
     * 
     * @return hihokenshaNo
     */
    @CheckForNull
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * hihokenshaNoのsetメソッドです。
     * 
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * rirekiNoのgetメソッドです。
     * 
     * @return rirekiNo
     */
    @CheckForNull
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * rirekiNoのsetメソッドです。
     * 
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * tekiyoKaishiYMDのgetメソッドです。
     * 
     * @return tekiyoKaishiYMD
     */
    @CheckForNull
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * tekiyoKaishiYMDのsetメソッドです。
     * 
     * @param tekiyoKaishiYMD tekiyoKaishiYMD
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * tekiyoShuryoYMDのgetメソッドです。
     * 
     * @return tekiyoShuryoYMD
     */
    @CheckForNull
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * tekiyoShuryoYMDのsetメソッドです。
     * 
     * @param tekiyoShuryoYMD tekiyoShuryoYMD
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * uketsukeYMDのgetメソッドです。
     * 
     * @return uketsukeYMD
     */
    @CheckForNull
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * uketsukeYMDのsetメソッドです。
     * 
     * @param uketsukeYMD uketsukeYMD
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * ketteiYMDのgetメソッドです。
     * 
     * @return ketteiYMD
     */
    @CheckForNull
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * ketteiYMDのsetメソッドです。
     * 
     * @param ketteiYMD ketteiYMD
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * checklistJisshiYMDのgetメソッドです。
     * 
     * @return checklistJisshiYMD
     */
    @CheckForNull
    public FlexibleDate getChecklistJisshiYMD() {
        return checklistJisshiYMD;
    }

    /**
     * checklistJisshiYMDのsetメソッドです。
     * 
     * @param checklistJisshiYMD checklistJisshiYMD
     */
    public void setChecklistJisshiYMD(FlexibleDate checklistJisshiYMD) {
        this.checklistJisshiYMD = checklistJisshiYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV7510SogoJigyoTaishoshaFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7510SogoJigyoTaishoshaFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7510SogoJigyoTaishoshaFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7510SogoJigyoTaishoshaFukushiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.checklistJisshiYMD = entity.checklistJisshiYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, rirekiNo, tekiyoKaishiYMD, tekiyoShuryoYMD, uketsukeYMD, ketteiYMD, checklistJisshiYMD);
    }

// </editor-fold>

}

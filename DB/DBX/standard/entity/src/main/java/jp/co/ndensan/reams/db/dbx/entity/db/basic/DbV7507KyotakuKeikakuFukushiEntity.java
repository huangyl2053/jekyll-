package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 居宅給付計画・福祉Viewテーブルのエンティティクラスです。
 */
public class DbV7507KyotakuKeikakuFukushiEntity extends DbTableEntityBase<DbV7507KyotakuKeikakuFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7507KyotakuKeikakuFukushi");

    private HihokenshaNo hihokenshaNo;
    private FlexibleYearMonth taishoYM;
    private int rirekiNo;
    private RString kyotaku_SogoJigyoKubun;
    private RString todokedeKubun;
    private RString sakuseiKubunCode;
    private RString keikakuJigyoshaNo;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString sakuseiYMD;
    private FlexibleDate todokedeYMD;
    private FlexibleDate henkoYMD;
    private RString henkoJiyu;
    private RString zanteiKubun;
    private RString itakusakiJigyoshaNo;

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
     * taishoYMのgetメソッドです。
     * 
     * @return taishoYM
     */
    @CheckForNull
    public FlexibleYearMonth getTaishoYM() {
        return taishoYM;
    }

    /**
     * taishoYMのsetメソッドです。
     * 
     * @param taishoYM taishoYM
     */
    public void setTaishoYM(FlexibleYearMonth taishoYM) {
        this.taishoYM = taishoYM;
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
     * kyotaku_SogoJigyoKubunのgetメソッドです。
     * 
     * @return kyotaku_SogoJigyoKubun
     */
    @CheckForNull
    public RString getKyotaku_SogoJigyoKubun() {
        return kyotaku_SogoJigyoKubun;
    }

    /**
     * kyotaku_SogoJigyoKubunのsetメソッドです。
     * 
     * @param kyotaku_SogoJigyoKubun kyotaku_SogoJigyoKubun
     */
    public void setKyotaku_SogoJigyoKubun(RString kyotaku_SogoJigyoKubun) {
        this.kyotaku_SogoJigyoKubun = kyotaku_SogoJigyoKubun;
    }

    /**
     * todokedeKubunのgetメソッドです。
     * 
     * @return todokedeKubun
     */
    @CheckForNull
    public RString getTodokedeKubun() {
        return todokedeKubun;
    }

    /**
     * todokedeKubunのsetメソッドです。
     * 
     * @param todokedeKubun todokedeKubun
     */
    public void setTodokedeKubun(RString todokedeKubun) {
        this.todokedeKubun = todokedeKubun;
    }

    /**
     * sakuseiKubunCodeのgetメソッドです。
     * 
     * @return sakuseiKubunCode
     */
    @CheckForNull
    public RString getSakuseiKubunCode() {
        return sakuseiKubunCode;
    }

    /**
     * sakuseiKubunCodeのsetメソッドです。
     * 
     * @param sakuseiKubunCode sakuseiKubunCode
     */
    public void setSakuseiKubunCode(RString sakuseiKubunCode) {
        this.sakuseiKubunCode = sakuseiKubunCode;
    }

    /**
     * keikakuJigyoshaNoのgetメソッドです。
     * 
     * @return keikakuJigyoshaNo
     */
    @CheckForNull
    public RString getKeikakuJigyoshaNo() {
        return keikakuJigyoshaNo;
    }

    /**
     * keikakuJigyoshaNoのsetメソッドです。
     * 
     * @param keikakuJigyoshaNo keikakuJigyoshaNo
     */
    public void setKeikakuJigyoshaNo(RString keikakuJigyoshaNo) {
        this.keikakuJigyoshaNo = keikakuJigyoshaNo;
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
     * sakuseiYMDのgetメソッドです。
     * 
     * @return sakuseiYMD
     */
    @CheckForNull
    public RString getSakuseiYMD() {
        return sakuseiYMD;
    }

    /**
     * sakuseiYMDのsetメソッドです。
     * 
     * @param sakuseiYMD sakuseiYMD
     */
    public void setSakuseiYMD(RString sakuseiYMD) {
        this.sakuseiYMD = sakuseiYMD;
    }

    /**
     * todokedeYMDのgetメソッドです。
     * 
     * @return todokedeYMD
     */
    @CheckForNull
    public FlexibleDate getTodokedeYMD() {
        return todokedeYMD;
    }

    /**
     * todokedeYMDのsetメソッドです。
     * 
     * @param todokedeYMD todokedeYMD
     */
    public void setTodokedeYMD(FlexibleDate todokedeYMD) {
        this.todokedeYMD = todokedeYMD;
    }

    /**
     * henkoYMDのgetメソッドです。
     * 
     * @return henkoYMD
     */
    @CheckForNull
    public FlexibleDate getHenkoYMD() {
        return henkoYMD;
    }

    /**
     * henkoYMDのsetメソッドです。
     * 
     * @param henkoYMD henkoYMD
     */
    public void setHenkoYMD(FlexibleDate henkoYMD) {
        this.henkoYMD = henkoYMD;
    }

    /**
     * henkoJiyuのgetメソッドです。
     * 
     * @return henkoJiyu
     */
    @CheckForNull
    public RString getHenkoJiyu() {
        return henkoJiyu;
    }

    /**
     * henkoJiyuのsetメソッドです。
     * 
     * @param henkoJiyu henkoJiyu
     */
    public void setHenkoJiyu(RString henkoJiyu) {
        this.henkoJiyu = henkoJiyu;
    }

    /**
     * zanteiKubunのgetメソッドです。
     * 
     * @return zanteiKubun
     */
    @CheckForNull
    public RString getZanteiKubun() {
        return zanteiKubun;
    }

    /**
     * zanteiKubunのsetメソッドです。
     * 
     * @param zanteiKubun zanteiKubun
     */
    public void setZanteiKubun(RString zanteiKubun) {
        this.zanteiKubun = zanteiKubun;
    }

    /**
     * itakusakiJigyoshaNoのgetメソッドです。
     * 
     * @return itakusakiJigyoshaNo
     */
    @CheckForNull
    public RString getItakusakiJigyoshaNo() {
        return itakusakiJigyoshaNo;
    }

    /**
     * itakusakiJigyoshaNoのsetメソッドです。
     * 
     * @param itakusakiJigyoshaNo itakusakiJigyoshaNo
     */
    public void setItakusakiJigyoshaNo(RString itakusakiJigyoshaNo) {
        this.itakusakiJigyoshaNo = itakusakiJigyoshaNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV7507KyotakuKeikakuFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7507KyotakuKeikakuFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7507KyotakuKeikakuFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7507KyotakuKeikakuFukushiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoYM = entity.taishoYM;
        this.rirekiNo = entity.rirekiNo;
        this.kyotaku_SogoJigyoKubun = entity.kyotaku_SogoJigyoKubun;
        this.todokedeKubun = entity.todokedeKubun;
        this.sakuseiKubunCode = entity.sakuseiKubunCode;
        this.keikakuJigyoshaNo = entity.keikakuJigyoshaNo;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.sakuseiYMD = entity.sakuseiYMD;
        this.todokedeYMD = entity.todokedeYMD;
        this.henkoYMD = entity.henkoYMD;
        this.henkoJiyu = entity.henkoJiyu;
        this.zanteiKubun = entity.zanteiKubun;
        this.itakusakiJigyoshaNo = entity.itakusakiJigyoshaNo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoYM, rirekiNo, kyotaku_SogoJigyoKubun, todokedeKubun, sakuseiKubunCode, keikakuJigyoshaNo, tekiyoKaishiYMD, tekiyoShuryoYMD, sakuseiYMD, todokedeYMD, henkoYMD, henkoJiyu, zanteiKubun, itakusakiJigyoshaNo);
    }

// </editor-fold>
}

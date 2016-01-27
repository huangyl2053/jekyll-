package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 申請届出情報テーブルのエンティティクラスです。
 * <br/> 申請届出情報を一元管理する
 */
public class DbT5120ShinseitodokedeJohoEntity extends DbTableEntityBase<DbT5120ShinseitodokedeJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5120ShinseitodokedeJoho");

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
    private Code shinseiTodokedeDaikoKubunCode;
    private RString shinseiTodokedeshaShimei;
    private RString shinseiTodokedeshaKanaShimei;
    private RString shinseiTodokedeshaTsuzukigara;
    private JigyoshaNo shinseiTodokedeDaikoJigyoshaNo;
    private RString jigyoshaKubun;
    private YubinNo shinseiTodokedeshaYubinNo;
    private RString shinseiTodokedeshaJusho;
    private TelNo shinseiTodokedeshaTelNo;

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
     * 申請届出代行区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：申請届出代行区分コード）本人・家族・委任者・代行事業者等
     *
     * @return 申請届出代行区分コード
     */
    public Code getShinseiTodokedeDaikoKubunCode() {
        return shinseiTodokedeDaikoKubunCode;
    }

    /**
     * 申請届出代行区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：申請届出代行区分コード）本人・家族・委任者・代行事業者等
     *
     * @param shinseiTodokedeDaikoKubunCode 申請届出代行区分コード
     */
    public void setShinseiTodokedeDaikoKubunCode(@Nonnull Code shinseiTodokedeDaikoKubunCode) {
        this.shinseiTodokedeDaikoKubunCode = shinseiTodokedeDaikoKubunCode;
    }

    /**
     * 申請届出者氏名のgetメソッドです。
     *
     * @return 申請届出者氏名
     */
    @CheckForNull
    public RString getShinseiTodokedeshaShimei() {
        return shinseiTodokedeshaShimei;
    }

    /**
     * 申請届出者氏名のsetメソッドです。
     *
     * @param shinseiTodokedeshaShimei 申請届出者氏名
     */
    public void setShinseiTodokedeshaShimei(RString shinseiTodokedeshaShimei) {
        this.shinseiTodokedeshaShimei = shinseiTodokedeshaShimei;
    }

    /**
     * 申請届出者氏名カナのgetメソッドです。
     *
     * @return 申請届出者氏名カナ
     */
    @CheckForNull
    public RString getShinseiTodokedeshaKanaShimei() {
        return shinseiTodokedeshaKanaShimei;
    }

    /**
     * 申請届出者氏名カナのsetメソッドです。
     *
     * @param shinseiTodokedeshaKanaShimei 申請届出者氏名カナ
     */
    public void setShinseiTodokedeshaKanaShimei(RString shinseiTodokedeshaKanaShimei) {
        this.shinseiTodokedeshaKanaShimei = shinseiTodokedeshaKanaShimei;
    }

    /**
     * 申請届出者続柄のgetメソッドです。
     *
     * @return 申請届出者続柄
     */
    @CheckForNull
    public RString getShinseiTodokedeshaTsuzukigara() {
        return shinseiTodokedeshaTsuzukigara;
    }

    /**
     * 申請届出者続柄のsetメソッドです。
     *
     * @param shinseiTodokedeshaTsuzukigara 申請届出者続柄
     */
    public void setShinseiTodokedeshaTsuzukigara(RString shinseiTodokedeshaTsuzukigara) {
        this.shinseiTodokedeshaTsuzukigara = shinseiTodokedeshaTsuzukigara;
    }

    /**
     * 申請届出代行事業者番号のgetメソッドです。
     *
     * @return 申請届出代行事業者番号
     */
    @CheckForNull
    public JigyoshaNo getShinseiTodokedeDaikoJigyoshaNo() {
        return shinseiTodokedeDaikoJigyoshaNo;
    }

    /**
     * 申請届出代行事業者番号のsetメソッドです。
     *
     * @param shinseiTodokedeDaikoJigyoshaNo 申請届出代行事業者番号
     */
    public void setShinseiTodokedeDaikoJigyoshaNo(JigyoshaNo shinseiTodokedeDaikoJigyoshaNo) {
        this.shinseiTodokedeDaikoJigyoshaNo = shinseiTodokedeDaikoJigyoshaNo;
    }

    /**
     * 事業者区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：事業者区分）
     *
     * @return 事業者区分
     */
    @CheckForNull
    public RString getJigyoshaKubun() {
        return jigyoshaKubun;
    }

    /**
     * 事業者区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：事業者区分）
     *
     * @param jigyoshaKubun 事業者区分
     */
    public void setJigyoshaKubun(RString jigyoshaKubun) {
        this.jigyoshaKubun = jigyoshaKubun;
    }

    /**
     * 申請届出者郵便番号のgetメソッドです。
     *
     * @return 申請届出者郵便番号
     */
    @CheckForNull
    public YubinNo getShinseiTodokedeshaYubinNo() {
        return shinseiTodokedeshaYubinNo;
    }

    /**
     * 申請届出者郵便番号のsetメソッドです。
     *
     * @param shinseiTodokedeshaYubinNo 申請届出者郵便番号
     */
    public void setShinseiTodokedeshaYubinNo(YubinNo shinseiTodokedeshaYubinNo) {
        this.shinseiTodokedeshaYubinNo = shinseiTodokedeshaYubinNo;
    }

    /**
     * 申請届出者住所のgetメソッドです。
     *
     * @return 申請届出者住所
     */
    @CheckForNull
    public RString getShinseiTodokedeshaJusho() {
        return shinseiTodokedeshaJusho;
    }

    /**
     * 申請届出者住所のsetメソッドです。
     *
     * @param shinseiTodokedeshaJusho 申請届出者住所
     */
    public void setShinseiTodokedeshaJusho(RString shinseiTodokedeshaJusho) {
        this.shinseiTodokedeshaJusho = shinseiTodokedeshaJusho;
    }

    /**
     * 申請届出者電話番号のgetメソッドです。
     *
     * @return 申請届出者電話番号
     */
    @CheckForNull
    public TelNo getShinseiTodokedeshaTelNo() {
        return shinseiTodokedeshaTelNo;
    }

    /**
     * 申請届出者電話番号のsetメソッドです。
     *
     * @param shinseiTodokedeshaTelNo 申請届出者電話番号
     */
    public void setShinseiTodokedeshaTelNo(TelNo shinseiTodokedeshaTelNo) {
        this.shinseiTodokedeshaTelNo = shinseiTodokedeshaTelNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5120ShinseitodokedeJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5120ShinseitodokedeJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5120ShinseitodokedeJohoEntity other) {
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
    public void shallowCopy(DbT5120ShinseitodokedeJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.shinseiTodokedeDaikoKubunCode = entity.shinseiTodokedeDaikoKubunCode;
        this.shinseiTodokedeshaShimei = entity.shinseiTodokedeshaShimei;
        this.shinseiTodokedeshaKanaShimei = entity.shinseiTodokedeshaKanaShimei;
        this.shinseiTodokedeshaTsuzukigara = entity.shinseiTodokedeshaTsuzukigara;
        this.shinseiTodokedeDaikoJigyoshaNo = entity.shinseiTodokedeDaikoJigyoshaNo;
        this.jigyoshaKubun = entity.jigyoshaKubun;
        this.shinseiTodokedeshaYubinNo = entity.shinseiTodokedeshaYubinNo;
        this.shinseiTodokedeshaJusho = entity.shinseiTodokedeshaJusho;
        this.shinseiTodokedeshaTelNo = entity.shinseiTodokedeshaTelNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, shinseiTodokedeDaikoKubunCode, shinseiTodokedeshaShimei, shinseiTodokedeshaKanaShimei, shinseiTodokedeshaTsuzukigara, shinseiTodokedeDaikoJigyoshaNo, jigyoshaKubun, shinseiTodokedeshaYubinNo, shinseiTodokedeshaJusho, shinseiTodokedeshaTelNo);
    }

// </editor-fold>
}

package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 後期高齢者情報テーブルのエンティティクラスです。
 */
public class DbT7124KokiKoreishaInfoEntity extends DbTableEntityBase<DbT7124KokiKoreishaInfoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7124KokiKoreishaInfo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCd;
    @PrimaryKey
    private RString rirekiNo;
    private RString kokiHokenshaNoCity;
    private RString kokiHokenshaNoKoiki;
    private RString kokikoreiHihokenshaNo;
    private RString shikakuShutokuJiyuCode;
    private RString shikakuShutokuYMD;
    private RString shikakuSoshitsuJiyuCode;
    private RString shikakuSoshitsuYMD;
    private RString hokenshaKaishiYMD;
    private RString hokenshaShuryoYMD;
    private RString kojinKubunCode;
    private RString torokuKubun;

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
     * 識別コードのgetメソッドです。
     * 
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCd() {
        return shikibetsuCd;
    }

    /**
     * 識別コードのsetメソッドです。
     * 
     * @param shikibetsuCd 識別コード
     */
    public void setShikibetsuCd(@Nonnull ShikibetsuCode shikibetsuCd) {
        this.shikibetsuCd = shikibetsuCd;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 後期高齢保険者番号(市町村)のgetメソッドです。
     * 
     * @return 後期高齢保険者番号(市町村)
     */
    @CheckForNull
    public RString getKokiHokenshaNoCity() {
        return kokiHokenshaNoCity;
    }

    /**
     * 後期高齢保険者番号(市町村)のsetメソッドです。
     * 
     * @param kokiHokenshaNoCity 後期高齢保険者番号(市町村)
     */
    public void setKokiHokenshaNoCity(RString kokiHokenshaNoCity) {
        this.kokiHokenshaNoCity = kokiHokenshaNoCity;
    }

    /**
     * 後期高齢保険者番号(広域)のgetメソッドです。
     * 
     * @return 後期高齢保険者番号(広域)
     */
    @CheckForNull
    public RString getKokiHokenshaNoKoiki() {
        return kokiHokenshaNoKoiki;
    }

    /**
     * 後期高齢保険者番号(広域)のsetメソッドです。
     * 
     * @param kokiHokenshaNoKoiki 後期高齢保険者番号(広域)
     */
    public void setKokiHokenshaNoKoiki(RString kokiHokenshaNoKoiki) {
        this.kokiHokenshaNoKoiki = kokiHokenshaNoKoiki;
    }

    /**
     * 後期高齢被保険者番号のgetメソッドです。
     * 
     * @return 後期高齢被保険者番号
     */
    @CheckForNull
    public RString getKokikoreiHihokenshaNo() {
        return kokikoreiHihokenshaNo;
    }

    /**
     * 後期高齢被保険者番号のsetメソッドです。
     * 
     * @param kokikoreiHihokenshaNo 後期高齢被保険者番号
     */
    public void setKokikoreiHihokenshaNo(RString kokikoreiHihokenshaNo) {
        this.kokikoreiHihokenshaNo = kokikoreiHihokenshaNo;
    }

    /**
     * 資格取得事由コードのgetメソッドです。
     * 
     * @return 資格取得事由コード
     */
    @CheckForNull
    public RString getShikakuShutokuJiyuCode() {
        return shikakuShutokuJiyuCode;
    }

    /**
     * 資格取得事由コードのsetメソッドです。
     * 
     * @param shikakuShutokuJiyuCode 資格取得事由コード
     */
    public void setShikakuShutokuJiyuCode(RString shikakuShutokuJiyuCode) {
        this.shikakuShutokuJiyuCode = shikakuShutokuJiyuCode;
    }

    /**
     * 資格取得日のgetメソッドです。
     * 
     * @return 資格取得日
     */
    @CheckForNull
    public RString getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    /**
     * 資格取得日のsetメソッドです。
     * 
     * @param shikakuShutokuYMD 資格取得日
     */
    public void setShikakuShutokuYMD(RString shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * 資格喪失事由コードのgetメソッドです。
     * 
     * @return 資格喪失事由コード
     */
    @CheckForNull
    public RString getShikakuSoshitsuJiyuCode() {
        return shikakuSoshitsuJiyuCode;
    }

    /**
     * 資格喪失事由コードのsetメソッドです。
     * 
     * @param shikakuSoshitsuJiyuCode 資格喪失事由コード
     */
    public void setShikakuSoshitsuJiyuCode(RString shikakuSoshitsuJiyuCode) {
        this.shikakuSoshitsuJiyuCode = shikakuSoshitsuJiyuCode;
    }

    /**
     * 資格喪失日のgetメソッドです。
     * 
     * @return 資格喪失日
     */
    @CheckForNull
    public RString getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失日のsetメソッドです。
     * 
     * @param shikakuSoshitsuYMD 資格喪失日
     */
    public void setShikakuSoshitsuYMD(RString shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * 保険者適用開始日のgetメソッドです。
     * 
     * @return 保険者適用開始日
     */
    @CheckForNull
    public RString getHokenshaKaishiYMD() {
        return hokenshaKaishiYMD;
    }

    /**
     * 保険者適用開始日のsetメソッドです。
     * 
     * @param hokenshaKaishiYMD 保険者適用開始日
     */
    public void setHokenshaKaishiYMD(RString hokenshaKaishiYMD) {
        this.hokenshaKaishiYMD = hokenshaKaishiYMD;
    }

    /**
     * 保険者適用終了日のgetメソッドです。
     * 
     * @return 保険者適用終了日
     */
    @CheckForNull
    public RString getHokenshaShuryoYMD() {
        return hokenshaShuryoYMD;
    }

    /**
     * 保険者適用終了日のsetメソッドです。
     * 
     * @param hokenshaShuryoYMD 保険者適用終了日
     */
    public void setHokenshaShuryoYMD(RString hokenshaShuryoYMD) {
        this.hokenshaShuryoYMD = hokenshaShuryoYMD;
    }

    /**
     * 個人区分コードのgetメソッドです。
     * <br/>
     * <br/>1:住基、2:外国人、3:住登外
     * 
     * @return 個人区分コード
     */
    @CheckForNull
    public RString getKojinKubunCode() {
        return kojinKubunCode;
    }

    /**
     * 個人区分コードのsetメソッドです。
     * <br/>
     * <br/>1:住基、2:外国人、3:住登外
     * 
     * @param kojinKubunCode 個人区分コード
     */
    public void setKojinKubunCode(RString kojinKubunCode) {
        this.kojinKubunCode = kojinKubunCode;
    }

    /**
     * 登録区分のgetメソッドです。
     * <br/>
     * <br/>1:画面登録、0:データ連携
     * 
     * @return 登録区分
     */
    @CheckForNull
    public RString getTorokuKubun() {
        return torokuKubun;
    }

    /**
     * 登録区分のsetメソッドです。
     * <br/>
     * <br/>1:画面登録、0:データ連携
     * 
     * @param torokuKubun 登録区分
     */
    public void setTorokuKubun(RString torokuKubun) {
        this.torokuKubun = torokuKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7124KokiKoreishaInfoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7124KokiKoreishaInfoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7124KokiKoreishaInfoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCd, other.shikibetsuCd)) {
            return false;
        }
        if (!Objects.equals(this.rirekiNo, other.rirekiNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7124KokiKoreishaInfoEntity entity) {
        this.shikibetsuCd = entity.shikibetsuCd;
        this.rirekiNo = entity.rirekiNo;
        this.kokiHokenshaNoCity = entity.kokiHokenshaNoCity;
        this.kokiHokenshaNoKoiki = entity.kokiHokenshaNoKoiki;
        this.kokikoreiHihokenshaNo = entity.kokikoreiHihokenshaNo;
        this.shikakuShutokuJiyuCode = entity.shikakuShutokuJiyuCode;
        this.shikakuShutokuYMD = entity.shikakuShutokuYMD;
        this.shikakuSoshitsuJiyuCode = entity.shikakuSoshitsuJiyuCode;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.hokenshaKaishiYMD = entity.hokenshaKaishiYMD;
        this.hokenshaShuryoYMD = entity.hokenshaShuryoYMD;
        this.kojinKubunCode = entity.kojinKubunCode;
        this.torokuKubun = entity.torokuKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCd, rirekiNo, kokiHokenshaNoCity, kokiHokenshaNoKoiki, kokikoreiHihokenshaNo, shikakuShutokuJiyuCode, shikakuShutokuYMD, shikakuSoshitsuJiyuCode, shikakuSoshitsuYMD, hokenshaKaishiYMD, hokenshaShuryoYMD, kojinKubunCode, torokuKubun);
    }

// </editor-fold>
}

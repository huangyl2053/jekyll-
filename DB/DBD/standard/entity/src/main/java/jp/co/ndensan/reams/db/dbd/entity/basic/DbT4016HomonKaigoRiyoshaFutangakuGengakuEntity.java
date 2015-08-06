package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 訪問介護利用者負担額減額テーブルのエンティティクラスです。
 */
public class DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity extends DbTableEntityBase<DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4016HomonKaigoRiyoshaFutangakuGengaku");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    private RString hobetsuKubun;
    private boolean shogaishaTechoUmu;
    private RString shogaishaTechoTokyu;
    private RString shogaishaTechoNo;
    private FlexibleDate shogaishaTechoKofuYMD;
    private RString shinseiJiyu;
    private HokenKyufuRitsu kyufuritsu;
    private RString kohiFutanshaNo;
    private RString kohiJukyushaNo;

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
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
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
     * 法別区分のgetメソッドです。
     * <br/>
     * <br/>施行時ホームヘルプ(56)
     *
     * <br/>障害時ホームヘルプ(57)
     *
     * <br/>障害ヘルプ全額免除(58)
     *
     * @return 法別区分
     */
    public RString getHobetsuKubun() {
        return hobetsuKubun;
    }

    /**
     * 法別区分のsetメソッドです。
     * <br/>
     * <br/>施行時ホームヘルプ(56)
     *
     * <br/>障害時ホームヘルプ(57)
     *
     * <br/>障害ヘルプ全額免除(58)
     *
     * @param hobetsuKubun 法別区分
     */
    public void setHobetsuKubun(RString hobetsuKubun) {
        this.hobetsuKubun = hobetsuKubun;
    }

    /**
     * 障害者手帳有無のgetメソッドです。
     * <br/>
     * <br/>1：有
     *
     * <br/>0：無
     *
     * @return 障害者手帳有無
     */
    public boolean getShogaishaTechoUmu() {
        return shogaishaTechoUmu;
    }

    /**
     * 障害者手帳有無のsetメソッドです。
     * <br/>
     * <br/>1：有
     *
     * <br/>0：無
     *
     * @param shogaishaTechoUmu 障害者手帳有無
     */
    public void setShogaishaTechoUmu(boolean shogaishaTechoUmu) {
        this.shogaishaTechoUmu = shogaishaTechoUmu;
    }

    /**
     * 障害者手帳等級のgetメソッドです。
     *
     * @return 障害者手帳等級
     */
    public RString getShogaishaTechoTokyu() {
        return shogaishaTechoTokyu;
    }

    /**
     * 障害者手帳等級のsetメソッドです。
     *
     * @param shogaishaTechoTokyu 障害者手帳等級
     */
    public void setShogaishaTechoTokyu(RString shogaishaTechoTokyu) {
        this.shogaishaTechoTokyu = shogaishaTechoTokyu;
    }

    /**
     * 障害者手帳番号のgetメソッドです。
     *
     * @return 障害者手帳番号
     */
    public RString getShogaishaTechoNo() {
        return shogaishaTechoNo;
    }

    /**
     * 障害者手帳番号のsetメソッドです。
     *
     * @param shogaishaTechoNo 障害者手帳番号
     */
    public void setShogaishaTechoNo(RString shogaishaTechoNo) {
        this.shogaishaTechoNo = shogaishaTechoNo;
    }

    /**
     * 障害者手帳交付年月日のgetメソッドです。
     *
     * @return 障害者手帳交付年月日
     */
    public FlexibleDate getShogaishaTechoKofuYMD() {
        return shogaishaTechoKofuYMD;
    }

    /**
     * 障害者手帳交付年月日のsetメソッドです。
     *
     * @param shogaishaTechoKofuYMD 障害者手帳交付年月日
     */
    public void setShogaishaTechoKofuYMD(FlexibleDate shogaishaTechoKofuYMD) {
        this.shogaishaTechoKofuYMD = shogaishaTechoKofuYMD;
    }

    /**
     * 申請事由のgetメソッドです。
     *
     * @return 申請事由
     */
    public RString getShinseiJiyu() {
        return shinseiJiyu;
    }

    /**
     * 申請事由のsetメソッドです。
     *
     * @param shinseiJiyu 申請事由
     */
    public void setShinseiJiyu(RString shinseiJiyu) {
        this.shinseiJiyu = shinseiJiyu;
    }

    /**
     * 給付率のgetメソッドです。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu getKyufuritsu() {
        return kyufuritsu;
    }

    /**
     * 給付率のsetメソッドです。
     *
     * @param kyufuritsu 給付率
     */
    public void setKyufuritsu(HokenKyufuRitsu kyufuritsu) {
        this.kyufuritsu = kyufuritsu;
    }

    /**
     * 公費負担者番号のgetメソッドです。
     *
     * @return 公費負担者番号
     */
    public RString getKohiFutanshaNo() {
        return kohiFutanshaNo;
    }

    /**
     * 公費負担者番号のsetメソッドです。
     *
     * @param kohiFutanshaNo 公費負担者番号
     */
    public void setKohiFutanshaNo(RString kohiFutanshaNo) {
        this.kohiFutanshaNo = kohiFutanshaNo;
    }

    /**
     * 公費受給者番号のgetメソッドです。
     *
     * @return 公費受給者番号
     */
    public RString getKohiJukyushaNo() {
        return kohiJukyushaNo;
    }

    /**
     * 公費受給者番号のsetメソッドです。
     *
     * @param kohiJukyushaNo 公費受給者番号
     */
    public void setKohiJukyushaNo(RString kohiJukyushaNo) {
        this.kohiJukyushaNo = kohiJukyushaNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.hobetsuKubun = entity.hobetsuKubun;
        this.shogaishaTechoUmu = entity.shogaishaTechoUmu;
        this.shogaishaTechoTokyu = entity.shogaishaTechoTokyu;
        this.shogaishaTechoNo = entity.shogaishaTechoNo;
        this.shogaishaTechoKofuYMD = entity.shogaishaTechoKofuYMD;
        this.shinseiJiyu = entity.shinseiJiyu;
        this.kyufuritsu = entity.kyufuritsu;
        this.kohiFutanshaNo = entity.kohiFutanshaNo;
        this.kohiJukyushaNo = entity.kohiJukyushaNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, rirekiNo, hobetsuKubun, shogaishaTechoUmu, shogaishaTechoTokyu, shogaishaTechoNo, shogaishaTechoKofuYMD, shinseiJiyu, kyufuritsu, kohiFutanshaNo, kohiJukyushaNo);
    }

// </editor-fold>
}

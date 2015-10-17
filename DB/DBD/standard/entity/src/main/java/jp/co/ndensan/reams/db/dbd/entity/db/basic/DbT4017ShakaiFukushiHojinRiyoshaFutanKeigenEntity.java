package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 社会福祉法人等利用者負担軽減テーブルのエンティティクラスです。
 */
public class DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity extends DbTableEntityBase<DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4017ShakaiFukushiHojinRiyoshaFutanKeigen");

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
    private RString shinseiJiyu;
    private boolean seihoJukyuUmu;
    private boolean roreiFukushiNenkinJukyuUmu;
    private boolean seihoFujoMinaoshiTokureiUmu;
    private Decimal keigenritsu_Bunshi;
    private Decimal keigenritsu_Bumbo;
    private boolean kyotakuServiceGentei;
    private boolean kyojuhiShokuhiNomi;
    private boolean kyusochishaUnitTypeKoshitsuNomi;
    private RString kakuninNo;
    private RString gemmenKubun;

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
     * 生活保護受給有無のgetメソッドです。
     * <br/>
     * <br/>1：適用対象者
     *
     * <br/>0：適用外
     *
     * @return 生活保護受給有無
     */
    public boolean getSeihoJukyuUmu() {
        return seihoJukyuUmu;
    }

    /**
     * 生活保護受給有無のsetメソッドです。
     * <br/>
     * <br/>1：適用対象者
     *
     * <br/>0：適用外
     *
     * @param seihoJukyuUmu 生活保護受給有無
     */
    public void setSeihoJukyuUmu(boolean seihoJukyuUmu) {
        this.seihoJukyuUmu = seihoJukyuUmu;
    }

    /**
     * 老齢福祉年金受給有無のgetメソッドです。
     * <br/>
     * <br/>1：適用対象者
     *
     * <br/>0：適用外
     *
     * @return 老齢福祉年金受給有無
     */
    public boolean getRoreiFukushiNenkinJukyuUmu() {
        return roreiFukushiNenkinJukyuUmu;
    }

    /**
     * 老齢福祉年金受給有無のsetメソッドです。
     * <br/>
     * <br/>1：適用対象者
     *
     * <br/>0：適用外
     *
     * @param roreiFukushiNenkinJukyuUmu 老齢福祉年金受給有無
     */
    public void setRoreiFukushiNenkinJukyuUmu(boolean roreiFukushiNenkinJukyuUmu) {
        this.roreiFukushiNenkinJukyuUmu = roreiFukushiNenkinJukyuUmu;
    }

    /**
     * 生保扶助見直し特例有無のgetメソッドです。
     * <br/>
     * <br/>1：適用対象者
     *
     * <br/>0：適用外
     *
     * @return 生保扶助見直し特例有無
     */
    public boolean getSeihoFujoMinaoshiTokureiUmu() {
        return seihoFujoMinaoshiTokureiUmu;
    }

    /**
     * 生保扶助見直し特例有無のsetメソッドです。
     * <br/>
     * <br/>1：適用対象者
     *
     * <br/>0：適用外
     *
     * @param seihoFujoMinaoshiTokureiUmu 生保扶助見直し特例有無
     */
    public void setSeihoFujoMinaoshiTokureiUmu(boolean seihoFujoMinaoshiTokureiUmu) {
        this.seihoFujoMinaoshiTokureiUmu = seihoFujoMinaoshiTokureiUmu;
    }

    /**
     * 軽減率（分子）のgetメソッドです。
     *
     * @return 軽減率（分子）
     */
    public Decimal getKeigenritsu_Bunshi() {
        return keigenritsu_Bunshi;
    }

    /**
     * 軽減率（分子）のsetメソッドです。
     *
     * @param keigenritsu_Bunshi 軽減率（分子）
     */
    public void setKeigenritsu_Bunshi(Decimal keigenritsu_Bunshi) {
        this.keigenritsu_Bunshi = keigenritsu_Bunshi;
    }

    /**
     * 軽減率（分母）のgetメソッドです。
     *
     * @return 軽減率（分母）
     */
    public Decimal getKeigenritsu_Bumbo() {
        return keigenritsu_Bumbo;
    }

    /**
     * 軽減率（分母）のsetメソッドです。
     *
     * @param keigenritsu_Bumbo 軽減率（分母）
     */
    public void setKeigenritsu_Bumbo(Decimal keigenritsu_Bumbo) {
        this.keigenritsu_Bumbo = keigenritsu_Bumbo;
    }

    /**
     * 居宅サービス限定のgetメソッドです。
     * <br/>
     * <br/>1：該当
     *
     * <br/>0：非該当
     *
     * @return 居宅サービス限定
     */
    public boolean getKyotakuServiceGentei() {
        return kyotakuServiceGentei;
    }

    /**
     * 居宅サービス限定のsetメソッドです。
     * <br/>
     * <br/>1：該当
     *
     * <br/>0：非該当
     *
     * @param kyotakuServiceGentei 居宅サービス限定
     */
    public void setKyotakuServiceGentei(boolean kyotakuServiceGentei) {
        this.kyotakuServiceGentei = kyotakuServiceGentei;
    }

    /**
     * 居住費・食費のみのgetメソッドです。
     * <br/>
     * <br/>1：該当
     *
     * <br/>0：非該当
     *
     * @return 居住費・食費のみ
     */
    public boolean getKyojuhiShokuhiNomi() {
        return kyojuhiShokuhiNomi;
    }

    /**
     * 居住費・食費のみのsetメソッドです。
     * <br/>
     * <br/>1：該当
     *
     * <br/>0：非該当
     *
     * @param kyojuhiShokuhiNomi 居住費・食費のみ
     */
    public void setKyojuhiShokuhiNomi(boolean kyojuhiShokuhiNomi) {
        this.kyojuhiShokuhiNomi = kyojuhiShokuhiNomi;
    }

    /**
     * 旧措置者ユニット型個室のみのgetメソッドです。
     * <br/>
     * <br/>1：該当
     *
     * <br/>0：非該当
     *
     * @return 旧措置者ユニット型個室のみ
     */
    public boolean getKyusochishaUnitTypeKoshitsuNomi() {
        return kyusochishaUnitTypeKoshitsuNomi;
    }

    /**
     * 旧措置者ユニット型個室のみのsetメソッドです。
     * <br/>
     * <br/>1：該当
     *
     * <br/>0：非該当
     *
     * @param kyusochishaUnitTypeKoshitsuNomi 旧措置者ユニット型個室のみ
     */
    public void setKyusochishaUnitTypeKoshitsuNomi(boolean kyusochishaUnitTypeKoshitsuNomi) {
        this.kyusochishaUnitTypeKoshitsuNomi = kyusochishaUnitTypeKoshitsuNomi;
    }

    /**
     * 確認番号のgetメソッドです。
     *
     * @return 確認番号
     */
    public RString getKakuninNo() {
        return kakuninNo;
    }

    /**
     * 確認番号のsetメソッドです。
     *
     * @param kakuninNo 確認番号
     */
    public void setKakuninNo(RString kakuninNo) {
        this.kakuninNo = kakuninNo;
    }

    /**
     * 減免区分のgetメソッドです。
     * <br/>
     * <br/>非課税・老年受給
     *
     * <br/>生保に準ずる
     *
     * <br/>その他
     *
     * <br/>生計困難
     *
     * <br/>激変緩和
     *
     * @return 減免区分
     */
    public RString getGemmenKubun() {
        return gemmenKubun;
    }

    /**
     * 減免区分のsetメソッドです。
     * <br/>
     * <br/>非課税・老年受給
     *
     * <br/>生保に準ずる
     *
     * <br/>その他
     *
     * <br/>生計困難
     *
     * <br/>激変緩和
     *
     * @param gemmenKubun 減免区分
     */
    public void setGemmenKubun(RString gemmenKubun) {
        this.gemmenKubun = gemmenKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity other) {
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
    public void shallowCopy(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.shinseiJiyu = entity.shinseiJiyu;
        this.seihoJukyuUmu = entity.seihoJukyuUmu;
        this.roreiFukushiNenkinJukyuUmu = entity.roreiFukushiNenkinJukyuUmu;
        this.seihoFujoMinaoshiTokureiUmu = entity.seihoFujoMinaoshiTokureiUmu;
        this.keigenritsu_Bunshi = entity.keigenritsu_Bunshi;
        this.keigenritsu_Bumbo = entity.keigenritsu_Bumbo;
        this.kyotakuServiceGentei = entity.kyotakuServiceGentei;
        this.kyojuhiShokuhiNomi = entity.kyojuhiShokuhiNomi;
        this.kyusochishaUnitTypeKoshitsuNomi = entity.kyusochishaUnitTypeKoshitsuNomi;
        this.kakuninNo = entity.kakuninNo;
        this.gemmenKubun = entity.gemmenKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, rirekiNo, shinseiJiyu, seihoJukyuUmu, roreiFukushiNenkinJukyuUmu, seihoFujoMinaoshiTokureiUmu, keigenritsu_Bunshi, keigenritsu_Bumbo, kyotakuServiceGentei, kyojuhiShokuhiNomi, kyusochishaUnitTypeKoshitsuNomi, kakuninNo, gemmenKubun);
    }

// </editor-fold>
}

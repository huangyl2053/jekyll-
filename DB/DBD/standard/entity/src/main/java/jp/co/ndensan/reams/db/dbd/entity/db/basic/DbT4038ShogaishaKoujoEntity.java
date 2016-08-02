package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 障がい書控除テーブルのエンティティクラスです。
 */
public class DbT4038ShogaishaKoujoEntity extends DbTableEntityBase<DbT4038ShogaishaKoujoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4038ShogaishaKoujo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString ketteiKubun;
    private RString hiShoninRiyu;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleYear taishoNendo;
    private FlexibleDate kijunYMD;
    private FlexibleDate haakuYMD;
    private RString shinseiJiyu;
    private RString ninteiKubun;
    private RString ninteiNaiyo;
    private HokenKyufuRitsu kyufuritsu;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private Code shogaiNichijoSeikatsuJiritsudoCode;
    private boolean shogaishaTechoUmu;
    private RString shikakuSoshitsuJiyuCode;
    private FlexibleDate shikakuSoshitsuYMD;
    private boolean ninteishoHakkoTaishogai;

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
     * 申請年月日のgetメソッドです。
     * 
     * @return 申請年月日
     */
    @CheckForNull
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     * 
     * @param shinseiYMD 申請年月日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 決定年月日のgetメソッドです。
     * 
     * @return 決定年月日
     */
    @CheckForNull
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * 決定年月日のsetメソッドです。
     * 
     * @param ketteiYMD 決定年月日
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * 適用開始年月日のgetメソッドです。
     * 
     * @return 適用開始年月日
     */
    @CheckForNull
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * 適用開始年月日のsetメソッドです。
     * 
     * @param tekiyoKaishiYMD 適用開始年月日
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * 適用終了年月日のgetメソッドです。
     * 
     * @return 適用終了年月日
     */
    @CheckForNull
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * 適用終了年月日のsetメソッドです。
     * 
     * @param tekiyoShuryoYMD 適用終了年月日
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * 決定区分のgetメソッドです。
     * 
     * @return 決定区分
     */
    @CheckForNull
    public RString getKetteiKubun() {
        return ketteiKubun;
    }

    /**
     * 決定区分のsetメソッドです。
     * 
     * @param ketteiKubun 決定区分
     */
    public void setKetteiKubun(RString ketteiKubun) {
        this.ketteiKubun = ketteiKubun;
    }

    /**
     * 非承認理由のgetメソッドです。
     * 
     * @return 非承認理由
     */
    @CheckForNull
    public RString getHiShoninRiyu() {
        return hiShoninRiyu;
    }

    /**
     * 非承認理由のsetメソッドです。
     * 
     * @param hiShoninRiyu 非承認理由
     */
    public void setHiShoninRiyu(RString hiShoninRiyu) {
        this.hiShoninRiyu = hiShoninRiyu;
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
    public void setShoKisaiHokenshaNo(@Nonnull ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
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
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     * <br/>
     * <br/>新規履歴：0, 以降の申請・決定：最大履歴番号+1
     * 
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * <br/>
     * <br/>新規履歴：0, 以降の申請・決定：最大履歴番号+1
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 対象年度のgetメソッドです。
     * 
     * @return 対象年度
     */
    @CheckForNull
    public FlexibleYear getTaishoNendo() {
        return taishoNendo;
    }

    /**
     * 対象年度のsetメソッドです。
     * 
     * @param taishoNendo 対象年度
     */
    public void setTaishoNendo(FlexibleYear taishoNendo) {
        this.taishoNendo = taishoNendo;
    }

    /**
     * 基準日のgetメソッドです。
     * 
     * @return 基準日
     */
    @CheckForNull
    public FlexibleDate getKijunYMD() {
        return kijunYMD;
    }

    /**
     * 基準日のsetメソッドです。
     * 
     * @param kijunYMD 基準日
     */
    public void setKijunYMD(FlexibleDate kijunYMD) {
        this.kijunYMD = kijunYMD;
    }

    /**
     * 把握日のgetメソッドです。
     * 
     * @return 把握日
     */
    @CheckForNull
    public FlexibleDate getHaakuYMD() {
        return haakuYMD;
    }

    /**
     * 把握日のsetメソッドです。
     * 
     * @param haakuYMD 把握日
     */
    public void setHaakuYMD(FlexibleDate haakuYMD) {
        this.haakuYMD = haakuYMD;
    }

    /**
     * 申請事由のgetメソッドです。
     * 
     * @return 申請事由
     */
    @CheckForNull
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
     * 認定区分のgetメソッドです。
     * <br/>
     * <br/>DBDEnum.障がい者控除認定区分
     * 
     * @return 認定区分
     */
    @CheckForNull
    public RString getNinteiKubun() {
        return ninteiKubun;
    }

    /**
     * 認定区分のsetメソッドです。
     * <br/>
     * <br/>DBDEnum.障がい者控除認定区分
     * 
     * @param ninteiKubun 認定区分
     */
    public void setNinteiKubun(RString ninteiKubun) {
        this.ninteiKubun = ninteiKubun;
    }

    /**
     * 認定内容のgetメソッドです。
     * <br/>
     * <br/>'DBDEnum.障がい者控除認定内容
     * 
     * @return 認定内容
     */
    @CheckForNull
    public RString getNinteiNaiyo() {
        return ninteiNaiyo;
    }

    /**
     * 認定内容のsetメソッドです。
     * <br/>
     * <br/>'DBDEnum.障がい者控除認定内容
     * 
     * @param ninteiNaiyo 認定内容
     */
    public void setNinteiNaiyo(RString ninteiNaiyo) {
        this.ninteiNaiyo = ninteiNaiyo;
    }

    /**
     * 給付率のgetメソッドです。
     * 
     * @return 給付率
     */
    @CheckForNull
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
     * 認知症高齢者の日常生活自立度コードのgetメソッドです。
     * <br/>
     * <br/>DBZEnum.認知症高齢者自立度コード
     * 
     * @return 認知症高齢者の日常生活自立度コード
     */
    @CheckForNull
    public Code getNinchishoNichijoSeikatsuJiritsudoCode() {
        return ninchishoNichijoSeikatsuJiritsudoCode;
    }

    /**
     * 認知症高齢者の日常生活自立度コードのsetメソッドです。
     * <br/>
     * <br/>DBZEnum.認知症高齢者自立度コード
     * 
     * @param ninchishoNichijoSeikatsuJiritsudoCode 認知症高齢者の日常生活自立度コード
     */
    public void setNinchishoNichijoSeikatsuJiritsudoCode(Code ninchishoNichijoSeikatsuJiritsudoCode) {
        this.ninchishoNichijoSeikatsuJiritsudoCode = ninchishoNichijoSeikatsuJiritsudoCode;
    }

    /**
     * 障がい高齢者の日常生活自立度コードのgetメソッドです。
     * <br/>
     * <br/>DBZEnum.障害高齢者自立度コード
     * 
     * @return 障がい高齢者の日常生活自立度コード
     */
    @CheckForNull
    public Code getShogaiNichijoSeikatsuJiritsudoCode() {
        return shogaiNichijoSeikatsuJiritsudoCode;
    }

    /**
     * 障がい高齢者の日常生活自立度コードのsetメソッドです。
     * <br/>
     * <br/>DBZEnum.障害高齢者自立度コード
     * 
     * @param shogaiNichijoSeikatsuJiritsudoCode 障がい高齢者の日常生活自立度コード
     */
    public void setShogaiNichijoSeikatsuJiritsudoCode(Code shogaiNichijoSeikatsuJiritsudoCode) {
        this.shogaiNichijoSeikatsuJiritsudoCode = shogaiNichijoSeikatsuJiritsudoCode;
    }

    /**
     * 障がい者手帳有無のgetメソッドです。
     * <br/>
     * <br/>false：障がい者手帳なし、true：障がい者手帳あり
     * 
     * @return 障がい者手帳有無
     */
    @CheckForNull
    public boolean getShogaishaTechoUmu() {
        return shogaishaTechoUmu;
    }

    /**
     * 障がい者手帳有無のsetメソッドです。
     * <br/>
     * <br/>false：障がい者手帳なし、true：障がい者手帳あり
     * 
     * @param shogaishaTechoUmu 障がい者手帳有無
     */
    public void setShogaishaTechoUmu(boolean shogaishaTechoUmu) {
        this.shogaishaTechoUmu = shogaishaTechoUmu;
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
     * 資格喪失年月日のgetメソッドです。
     * 
     * @return 資格喪失年月日
     */
    @CheckForNull
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失年月日のsetメソッドです。
     * 
     * @param shikakuSoshitsuYMD 資格喪失年月日
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * 認定証発行対象外フラグのgetメソッドです。
     * <br/>
     * <br/>true：認定証一括発行対象外
     * 
     * @return 認定証発行対象外フラグ
     */
    @CheckForNull
    public boolean getNinteishoHakkoTaishogai() {
        return ninteishoHakkoTaishogai;
    }

    /**
     * 認定証発行対象外フラグのsetメソッドです。
     * <br/>
     * <br/>true：認定証一括発行対象外
     * 
     * @param ninteishoHakkoTaishogai 認定証発行対象外フラグ
     */
    public void setNinteishoHakkoTaishogai(boolean ninteishoHakkoTaishogai) {
        this.ninteishoHakkoTaishogai = ninteishoHakkoTaishogai;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4038ShogaishaKoujoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4038ShogaishaKoujoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4038ShogaishaKoujoEntity other) {
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
    public void shallowCopy(DbT4038ShogaishaKoujoEntity entity) {
        this.shinseiYMD = entity.shinseiYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.ketteiKubun = entity.ketteiKubun;
        this.hiShoninRiyu = entity.hiShoninRiyu;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.taishoNendo = entity.taishoNendo;
        this.kijunYMD = entity.kijunYMD;
        this.haakuYMD = entity.haakuYMD;
        this.shinseiJiyu = entity.shinseiJiyu;
        this.ninteiKubun = entity.ninteiKubun;
        this.ninteiNaiyo = entity.ninteiNaiyo;
        this.kyufuritsu = entity.kyufuritsu;
        this.ninchishoNichijoSeikatsuJiritsudoCode = entity.ninchishoNichijoSeikatsuJiritsudoCode;
        this.shogaiNichijoSeikatsuJiritsudoCode = entity.shogaiNichijoSeikatsuJiritsudoCode;
        this.shogaishaTechoUmu = entity.shogaishaTechoUmu;
        this.shikakuSoshitsuJiyuCode = entity.shikakuSoshitsuJiyuCode;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.ninteishoHakkoTaishogai = entity.ninteishoHakkoTaishogai;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseiYMD, ketteiYMD, tekiyoKaishiYMD, tekiyoShuryoYMD, ketteiKubun, hiShoninRiyu, shoKisaiHokenshaNo, hihokenshaNo, rirekiNo, taishoNendo, kijunYMD, haakuYMD, shinseiJiyu, ninteiKubun, ninteiNaiyo, kyufuritsu, ninchishoNichijoSeikatsuJiritsudoCode, shogaiNichijoSeikatsuJiritsudoCode, shogaishaTechoUmu, shikakuSoshitsuJiyuCode, shikakuSoshitsuYMD, ninteishoHakkoTaishogai);
    }

// </editor-fold>
}

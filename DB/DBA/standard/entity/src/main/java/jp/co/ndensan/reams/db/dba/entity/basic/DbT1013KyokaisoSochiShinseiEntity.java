package jp.co.ndensan.reams.db.dba.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 境界層措置申請テーブルのエンティティクラスです。
 */
public class DbT1013KyokaisoSochiShinseiEntity extends DbTableEntityBase<DbT1013KyokaisoSochiShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT1013KyokaisoSochiShinsei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private DbUDD002HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleDate shinseiYMD;
    private FlexibleDate uketsukeYMD;
    private RString shinsei_HaishiKubun;
    private FlexibleDate shinsei_HaishiYMD;
    private Decimal hogoHuyoKonkyoGengakuKingaku;
    private FlexibleDate kyokaisoShomeishoKofuYMD;
    private Decimal kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku;
    private Decimal kyojuhiKeigen_GengakuJikofutanGetsugaku;
    private RString kyojuhiKeigen_FutangendogakuDankaiCode;
    private Decimal shokuhiKeigen_GengakuJikofutanGetsugaku;
    private RString shokuhiKeigen_FutangendogakuDankaiCode;
    private Decimal riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku;
    private Decimal hokenryoGengaku_GengakuJikofutanGetsugaku;
    private Decimal gengakuJikofutanGetsugakuGokeigaku;
    private FlexibleDate kyukaisoSochiKetteiYMD;
    private RString sochiGaito_HigaitoKubun;

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
     * 申請年月日のgetメソッドです。
     * 
     * @return 申請年月日
     */
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
     * 受付年月日のgetメソッドです。
     * 
     * @return 受付年月日
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * 受付年月日のsetメソッドです。
     * 
     * @param uketsukeYMD 受付年月日
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * 申請・廃止区分のgetメソッドです。
     * <br/>
     * <br/>1:申請、2:廃止
     * 
     * @return 申請・廃止区分
     */
    public RString getShinsei_HaishiKubun() {
        return shinsei_HaishiKubun;
    }

    /**
     * 申請・廃止区分のsetメソッドです。
     * <br/>
     * <br/>1:申請、2:廃止
     * 
     * @param shinsei_HaishiKubun 申請・廃止区分
     */
    public void setShinsei_HaishiKubun(RString shinsei_HaishiKubun) {
        this.shinsei_HaishiKubun = shinsei_HaishiKubun;
    }

    /**
     * 申請・廃止年月日のgetメソッドです。
     * 
     * @return 申請・廃止年月日
     */
    public FlexibleDate getShinsei_HaishiYMD() {
        return shinsei_HaishiYMD;
    }

    /**
     * 申請・廃止年月日のsetメソッドです。
     * 
     * @param shinsei_HaishiYMD 申請・廃止年月日
     */
    public void setShinsei_HaishiYMD(FlexibleDate shinsei_HaishiYMD) {
        this.shinsei_HaishiYMD = shinsei_HaishiYMD;
    }

    /**
     * 保護不要根拠減額金額のgetメソッドです。
     * 
     * @return 保護不要根拠減額金額
     */
    public Decimal getHogoHuyoKonkyoGengakuKingaku() {
        return hogoHuyoKonkyoGengakuKingaku;
    }

    /**
     * 保護不要根拠減額金額のsetメソッドです。
     * 
     * @param hogoHuyoKonkyoGengakuKingaku 保護不要根拠減額金額
     */
    public void setHogoHuyoKonkyoGengakuKingaku(Decimal hogoHuyoKonkyoGengakuKingaku) {
        this.hogoHuyoKonkyoGengakuKingaku = hogoHuyoKonkyoGengakuKingaku;
    }

    /**
     * 境界層証明書交付年月日のgetメソッドです。
     * 
     * @return 境界層証明書交付年月日
     */
    public FlexibleDate getKyokaisoShomeishoKofuYMD() {
        return kyokaisoShomeishoKofuYMD;
    }

    /**
     * 境界層証明書交付年月日のsetメソッドです。
     * 
     * @param kyokaisoShomeishoKofuYMD 境界層証明書交付年月日
     */
    public void setKyokaisoShomeishoKofuYMD(FlexibleDate kyokaisoShomeishoKofuYMD) {
        this.kyokaisoShomeishoKofuYMD = kyokaisoShomeishoKofuYMD;
    }

    /**
     * 給付額減額取消・減額自己負担月額のgetメソッドです。
     * 
     * @return 給付額減額取消・減額自己負担月額
     */
    public Decimal getKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku() {
        return kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku;
    }

    /**
     * 給付額減額取消・減額自己負担月額のsetメソッドです。
     * 
     * @param kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku 給付額減額取消・減額自己負担月額
     */
    public void setKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku(Decimal kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku) {
        this.kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku = kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku;
    }

    /**
     * 居住費軽減・減額自己負担月額のgetメソッドです。
     * 
     * @return 居住費軽減・減額自己負担月額
     */
    public Decimal getKyojuhiKeigen_GengakuJikofutanGetsugaku() {
        return kyojuhiKeigen_GengakuJikofutanGetsugaku;
    }

    /**
     * 居住費軽減・減額自己負担月額のsetメソッドです。
     * 
     * @param kyojuhiKeigen_GengakuJikofutanGetsugaku 居住費軽減・減額自己負担月額
     */
    public void setKyojuhiKeigen_GengakuJikofutanGetsugaku(Decimal kyojuhiKeigen_GengakuJikofutanGetsugaku) {
        this.kyojuhiKeigen_GengakuJikofutanGetsugaku = kyojuhiKeigen_GengakuJikofutanGetsugaku;
    }

    /**
     * 居住費軽減・負担限度額段階コードのgetメソッドです。
     * 
     * @return 居住費軽減・負担限度額段階コード
     */
    public RString getKyojuhiKeigen_FutangendogakuDankaiCode() {
        return kyojuhiKeigen_FutangendogakuDankaiCode;
    }

    /**
     * 居住費軽減・負担限度額段階コードのsetメソッドです。
     * 
     * @param kyojuhiKeigen_FutangendogakuDankaiCode 居住費軽減・負担限度額段階コード
     */
    public void setKyojuhiKeigen_FutangendogakuDankaiCode(RString kyojuhiKeigen_FutangendogakuDankaiCode) {
        this.kyojuhiKeigen_FutangendogakuDankaiCode = kyojuhiKeigen_FutangendogakuDankaiCode;
    }

    /**
     * 食費軽減・減額自己負担月額のgetメソッドです。
     * 
     * @return 食費軽減・減額自己負担月額
     */
    public Decimal getShokuhiKeigen_GengakuJikofutanGetsugaku() {
        return shokuhiKeigen_GengakuJikofutanGetsugaku;
    }

    /**
     * 食費軽減・減額自己負担月額のsetメソッドです。
     * 
     * @param shokuhiKeigen_GengakuJikofutanGetsugaku 食費軽減・減額自己負担月額
     */
    public void setShokuhiKeigen_GengakuJikofutanGetsugaku(Decimal shokuhiKeigen_GengakuJikofutanGetsugaku) {
        this.shokuhiKeigen_GengakuJikofutanGetsugaku = shokuhiKeigen_GengakuJikofutanGetsugaku;
    }

    /**
     * 食費軽減・負担限度額段階コードのgetメソッドです。
     * 
     * @return 食費軽減・負担限度額段階コード
     */
    public RString getShokuhiKeigen_FutangendogakuDankaiCode() {
        return shokuhiKeigen_FutangendogakuDankaiCode;
    }

    /**
     * 食費軽減・負担限度額段階コードのsetメソッドです。
     * 
     * @param shokuhiKeigen_FutangendogakuDankaiCode 食費軽減・負担限度額段階コード
     */
    public void setShokuhiKeigen_FutangendogakuDankaiCode(RString shokuhiKeigen_FutangendogakuDankaiCode) {
        this.shokuhiKeigen_FutangendogakuDankaiCode = shokuhiKeigen_FutangendogakuDankaiCode;
    }

    /**
     * 利用者負担世帯合算額・減額自己負担月額のgetメソッドです。
     * 
     * @return 利用者負担世帯合算額・減額自己負担月額
     */
    public Decimal getRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku() {
        return riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku;
    }

    /**
     * 利用者負担世帯合算額・減額自己負担月額のsetメソッドです。
     * 
     * @param riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku 利用者負担世帯合算額・減額自己負担月額
     */
    public void setRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku(Decimal riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku) {
        this.riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku = riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku;
    }

    /**
     * 保険料減額・減額自己負担月額のgetメソッドです。
     * 
     * @return 保険料減額・減額自己負担月額
     */
    public Decimal getHokenryoGengaku_GengakuJikofutanGetsugaku() {
        return hokenryoGengaku_GengakuJikofutanGetsugaku;
    }

    /**
     * 保険料減額・減額自己負担月額のsetメソッドです。
     * 
     * @param hokenryoGengaku_GengakuJikofutanGetsugaku 保険料減額・減額自己負担月額
     */
    public void setHokenryoGengaku_GengakuJikofutanGetsugaku(Decimal hokenryoGengaku_GengakuJikofutanGetsugaku) {
        this.hokenryoGengaku_GengakuJikofutanGetsugaku = hokenryoGengaku_GengakuJikofutanGetsugaku;
    }

    /**
     * 減額自己負担月額合計額のgetメソッドです。
     * 
     * @return 減額自己負担月額合計額
     */
    public Decimal getGengakuJikofutanGetsugakuGokeigaku() {
        return gengakuJikofutanGetsugakuGokeigaku;
    }

    /**
     * 減額自己負担月額合計額のsetメソッドです。
     * 
     * @param gengakuJikofutanGetsugakuGokeigaku 減額自己負担月額合計額
     */
    public void setGengakuJikofutanGetsugakuGokeigaku(Decimal gengakuJikofutanGetsugakuGokeigaku) {
        this.gengakuJikofutanGetsugakuGokeigaku = gengakuJikofutanGetsugakuGokeigaku;
    }

    /**
     * 境界層措置決定年月日のgetメソッドです。
     * 
     * @return 境界層措置決定年月日
     */
    public FlexibleDate getKyukaisoSochiKetteiYMD() {
        return kyukaisoSochiKetteiYMD;
    }

    /**
     * 境界層措置決定年月日のsetメソッドです。
     * 
     * @param kyukaisoSochiKetteiYMD 境界層措置決定年月日
     */
    public void setKyukaisoSochiKetteiYMD(FlexibleDate kyukaisoSochiKetteiYMD) {
        this.kyukaisoSochiKetteiYMD = kyukaisoSochiKetteiYMD;
    }

    /**
     * 措置該当・非該当区分のgetメソッドです。
     * <br/>
     * <br/>1:該当、2:非該当
     * 
     * @return 措置該当・非該当区分
     */
    public RString getSochiGaito_HigaitoKubun() {
        return sochiGaito_HigaitoKubun;
    }

    /**
     * 措置該当・非該当区分のsetメソッドです。
     * <br/>
     * <br/>1:該当、2:非該当
     * 
     * @param sochiGaito_HigaitoKubun 措置該当・非該当区分
     */
    public void setSochiGaito_HigaitoKubun(RString sochiGaito_HigaitoKubun) {
        this.sochiGaito_HigaitoKubun = sochiGaito_HigaitoKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1013KyokaisoSochiShinseiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1013KyokaisoSochiShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1013KyokaisoSochiShinseiEntity other) {
        if (other == null) {
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
    public void shallowCopy(DbT1013KyokaisoSochiShinseiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.shinseiYMD = entity.shinseiYMD;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.shinsei_HaishiKubun = entity.shinsei_HaishiKubun;
        this.shinsei_HaishiYMD = entity.shinsei_HaishiYMD;
        this.hogoHuyoKonkyoGengakuKingaku = entity.hogoHuyoKonkyoGengakuKingaku;
        this.kyokaisoShomeishoKofuYMD = entity.kyokaisoShomeishoKofuYMD;
        this.kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku = entity.kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku;
        this.kyojuhiKeigen_GengakuJikofutanGetsugaku = entity.kyojuhiKeigen_GengakuJikofutanGetsugaku;
        this.kyojuhiKeigen_FutangendogakuDankaiCode = entity.kyojuhiKeigen_FutangendogakuDankaiCode;
        this.shokuhiKeigen_GengakuJikofutanGetsugaku = entity.shokuhiKeigen_GengakuJikofutanGetsugaku;
        this.shokuhiKeigen_FutangendogakuDankaiCode = entity.shokuhiKeigen_FutangendogakuDankaiCode;
        this.riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku = entity.riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku;
        this.hokenryoGengaku_GengakuJikofutanGetsugaku = entity.hokenryoGengaku_GengakuJikofutanGetsugaku;
        this.gengakuJikofutanGetsugakuGokeigaku = entity.gengakuJikofutanGetsugakuGokeigaku;
        this.kyukaisoSochiKetteiYMD = entity.kyukaisoSochiKetteiYMD;
        this.sochiGaito_HigaitoKubun = entity.sochiGaito_HigaitoKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, rirekiNo, shinseiYMD, uketsukeYMD, shinsei_HaishiKubun, shinsei_HaishiYMD, hogoHuyoKonkyoGengakuKingaku, kyokaisoShomeishoKofuYMD, kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku, kyojuhiKeigen_GengakuJikofutanGetsugaku, kyojuhiKeigen_FutangendogakuDankaiCode, shokuhiKeigen_GengakuJikofutanGetsugaku, shokuhiKeigen_FutangendogakuDankaiCode, riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku, hokenryoGengaku_GengakuJikofutanGetsugaku, gengakuJikofutanGetsugakuGokeigaku, kyukaisoSochiKetteiYMD, sochiGaito_HigaitoKubun);
    }

// </editor-fold>
}

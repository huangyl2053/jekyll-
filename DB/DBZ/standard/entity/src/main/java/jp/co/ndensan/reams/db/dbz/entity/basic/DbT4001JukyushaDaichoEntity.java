package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * DbT4001JukyushaDaichoの項目定義クラスです
 *
 */
public class DbT4001JukyushaDaichoEntity extends DbTableEntityBase<DbT4001JukyushaDaichoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4001JukyushaDaicho");

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
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private YMDHMS shoriTimeStamp;
    private ShishoCode shishoCode;
    private ShikibetsuCode ShikibetsuCode;
    private ChikuCode chikuCode;
    private FlexibleDate soshitsuYMD;
    private Code nigouTokuteiShippeiCode;
    private FlexibleDate chokkinIdoYMD;
    private Code chokkinIdoJiyuCode;
    private Decimal shikyuGendoTanisu;
    private FlexibleDate shikyuGendoKaishiYMD;
    private FlexibleDate shikyuGendoShuryoYMD;
    private int tankiSikyuGendoNissu;
    private FlexibleDate tankiShikyuGendoKaishiYMD;
    private FlexibleDate tankiShikyuGendoShuryoYMD;
    private RString jidoWariateJogaishaKubun;

    /**
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShoKisaiHokenshaNo
     * @return shoKisaiHokenshaNo
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getHihokenshaNo
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getShinseishoKanriNo
     * @return shinseishoKanriNo
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * setShinseishoKanriNo
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * getShoriTimeStamp
     * @return shoriTimeStamp
     */
    public YMDHMS getShoriTimeStamp() {
        return shoriTimeStamp;
    }

    /**
     * setShoriTimeStamp
     * @param shoriTimeStamp shoriTimeStamp
     */
    public void setShoriTimeStamp(YMDHMS shoriTimeStamp) {
        this.shoriTimeStamp = shoriTimeStamp;
    }

    /**
     * getShishoCode
     * @return shishoCode
     */
    public ShishoCode getShishoCode() {
        return shishoCode;
    }

    /**
     * setShishoCode
     * @param shishoCode shishoCode
     */
    public void setShishoCode(ShishoCode shishoCode) {
        this.shishoCode = shishoCode;
    }

    /**
     * getShikibetsuCode
     * @return ShikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return ShikibetsuCode;
    }

    /**
     * setShikibetsuCode
     * @param ShikibetsuCode ShikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode ShikibetsuCode) {
        this.ShikibetsuCode = ShikibetsuCode;
    }

    /**
     * getChikuCode
     * @return chikuCode
     */
    public ChikuCode getChikuCode() {
        return chikuCode;
    }

    /**
     * setChikuCode
     * @param chikuCode chikuCode
     */
    public void setChikuCode(ChikuCode chikuCode) {
        this.chikuCode = chikuCode;
    }

    /**
     * getSoshitsuYMD
     * @return soshitsuYMD
     */
    public FlexibleDate getSoshitsuYMD() {
        return soshitsuYMD;
    }

    /**
     * setSoshitsuYMD
     * @param soshitsuYMD soshitsuYMD
     */
    public void setSoshitsuYMD(FlexibleDate soshitsuYMD) {
        this.soshitsuYMD = soshitsuYMD;
    }

    /**
     * getNigouTokuteiShippeiCode
     * @return nigouTokuteiShippeiCode
     */
    public Code getNigouTokuteiShippeiCode() {
        return nigouTokuteiShippeiCode;
    }

    /**
     * setNigouTokuteiShippeiCode
     * @param nigouTokuteiShippeiCode nigouTokuteiShippeiCode
     */
    public void setNigouTokuteiShippeiCode(Code nigouTokuteiShippeiCode) {
        this.nigouTokuteiShippeiCode = nigouTokuteiShippeiCode;
    }

    /**
     * getChokkinIdoYMD
     * @return chokkinIdoYMD
     */
    public FlexibleDate getChokkinIdoYMD() {
        return chokkinIdoYMD;
    }

    /**
     * setChokkinIdoYMD
     * @param chokkinIdoYMD chokkinIdoYMD
     */
    public void setChokkinIdoYMD(FlexibleDate chokkinIdoYMD) {
        this.chokkinIdoYMD = chokkinIdoYMD;
    }

    /**
     * getChokkinIdoJiyuCode
     * @return chokkinIdoJiyuCode
     */
    public Code getChokkinIdoJiyuCode() {
        return chokkinIdoJiyuCode;
    }

    /**
     * setChokkinIdoJiyuCode
     * @param chokkinIdoJiyuCode chokkinIdoJiyuCode
     */
    public void setChokkinIdoJiyuCode(Code chokkinIdoJiyuCode) {
        this.chokkinIdoJiyuCode = chokkinIdoJiyuCode;
    }

    /**
     * getShikyuGendoTanisu
     * @return shikyuGendoTanisu
     */
    public Decimal getShikyuGendoTanisu() {
        return shikyuGendoTanisu;
    }

    /**
     * setShikyuGendoTanisu
     * @param shikyuGendoTanisu shikyuGendoTanisu
     */
    public void setShikyuGendoTanisu(Decimal shikyuGendoTanisu) {
        this.shikyuGendoTanisu = shikyuGendoTanisu;
    }

    /**
     * getShikyuGendoKaishiYMD
     * @return shikyuGendoKaishiYMD
     */
    public FlexibleDate getShikyuGendoKaishiYMD() {
        return shikyuGendoKaishiYMD;
    }

    /**
     * setShikyuGendoKaishiYMD
     * @param shikyuGendoKaishiYMD shikyuGendoKaishiYMD
     */
    public void setShikyuGendoKaishiYMD(FlexibleDate shikyuGendoKaishiYMD) {
        this.shikyuGendoKaishiYMD = shikyuGendoKaishiYMD;
    }

    /**
     * getShikyuGendoShuryoYMD
     * @return shikyuGendoShuryoYMD
     */
    public FlexibleDate getShikyuGendoShuryoYMD() {
        return shikyuGendoShuryoYMD;
    }

    /**
     * setShikyuGendoShuryoYMD
     * @param shikyuGendoShuryoYMD shikyuGendoShuryoYMD
     */
    public void setShikyuGendoShuryoYMD(FlexibleDate shikyuGendoShuryoYMD) {
        this.shikyuGendoShuryoYMD = shikyuGendoShuryoYMD;
    }

    /**
     * getTankiSikyuGendoNissu
     * @return tankiSikyuGendoNissu
     */
    public int getTankiSikyuGendoNissu() {
        return tankiSikyuGendoNissu;
    }

    /**
     * setTankiSikyuGendoNissu
     * @param tankiSikyuGendoNissu tankiSikyuGendoNissu
     */
    public void setTankiSikyuGendoNissu(int tankiSikyuGendoNissu) {
        this.tankiSikyuGendoNissu = tankiSikyuGendoNissu;
    }

    /**
     * getTankiShikyuGendoKaishiYMD
     * @return tankiShikyuGendoKaishiYMD
     */
    public FlexibleDate getTankiShikyuGendoKaishiYMD() {
        return tankiShikyuGendoKaishiYMD;
    }

    /**
     * setTankiShikyuGendoKaishiYMD
     * @param tankiShikyuGendoKaishiYMD tankiShikyuGendoKaishiYMD
     */
    public void setTankiShikyuGendoKaishiYMD(FlexibleDate tankiShikyuGendoKaishiYMD) {
        this.tankiShikyuGendoKaishiYMD = tankiShikyuGendoKaishiYMD;
    }

    /**
     * getTankiShikyuGendoShuryoYMD
     * @return tankiShikyuGendoShuryoYMD
     */
    public FlexibleDate getTankiShikyuGendoShuryoYMD() {
        return tankiShikyuGendoShuryoYMD;
    }

    /**
     * setTankiShikyuGendoShuryoYMD
     * @param tankiShikyuGendoShuryoYMD tankiShikyuGendoShuryoYMD
     */
    public void setTankiShikyuGendoShuryoYMD(FlexibleDate tankiShikyuGendoShuryoYMD) {
        this.tankiShikyuGendoShuryoYMD = tankiShikyuGendoShuryoYMD;
    }

    /**
     * getJidoWariateJogaishaKubun
     * @return jidoWariateJogaishaKubun
     */
    public RString getJidoWariateJogaishaKubun() {
        return jidoWariateJogaishaKubun;
    }

    /**
     * setJidoWariateJogaishaKubun
     * @param jidoWariateJogaishaKubun jidoWariateJogaishaKubun
     */
    public void setJidoWariateJogaishaKubun(RString jidoWariateJogaishaKubun) {
        this.jidoWariateJogaishaKubun = jidoWariateJogaishaKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4001JukyushaDaichoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4001JukyushaDaichoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4001JukyushaDaichoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimeStamp, other.shoriTimeStamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4001JukyushaDaichoEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.shoriTimeStamp = entity.shoriTimeStamp;
        this.shishoCode = entity.shishoCode;
        this.ShikibetsuCode = entity.ShikibetsuCode;
        this.chikuCode = entity.chikuCode;
        this.soshitsuYMD = entity.soshitsuYMD;
        this.nigouTokuteiShippeiCode = entity.nigouTokuteiShippeiCode;
        this.chokkinIdoYMD = entity.chokkinIdoYMD;
        this.chokkinIdoJiyuCode = entity.chokkinIdoJiyuCode;
        this.shikyuGendoTanisu = entity.shikyuGendoTanisu;
        this.shikyuGendoKaishiYMD = entity.shikyuGendoKaishiYMD;
        this.shikyuGendoShuryoYMD = entity.shikyuGendoShuryoYMD;
        this.tankiSikyuGendoNissu = entity.tankiSikyuGendoNissu;
        this.tankiShikyuGendoKaishiYMD = entity.tankiShikyuGendoKaishiYMD;
        this.tankiShikyuGendoShuryoYMD = entity.tankiShikyuGendoShuryoYMD;
        this.jidoWariateJogaishaKubun = entity.jidoWariateJogaishaKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, shinseishoKanriNo, shoriTimeStamp, shishoCode, ShikibetsuCode, chikuCode, soshitsuYMD, nigouTokuteiShippeiCode, chokkinIdoYMD, chokkinIdoJiyuCode, shikyuGendoTanisu, shikyuGendoKaishiYMD, shikyuGendoShuryoYMD, tankiSikyuGendoNissu, tankiShikyuGendoKaishiYMD, tankiShikyuGendoShuryoYMD, jidoWariateJogaishaKubun);
    }

// </editor-fold>


}

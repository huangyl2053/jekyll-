package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;

/**
 * DbT3077JuryoininKeiyakuJigyoshaの項目定義クラスです
 *
 */
public class DbT3077JuryoininKeiyakuJigyoshaEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3077JuryoininKeiyakuJigyosha");

    private RString insertDantaiCd;
    @PrimaryKey
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString jigyoshaKeiyakuNo;
    @PrimaryKey
    private FlexibleDate kaishiYMD;
    @PrimaryKey
    private RDateTime shoriTimestamp;
    private FlexibleDate shuryoYMD;
    private FlexibleDate todokedeYMD;
    private RString todokedeAddress;
    private RString todokedeJigyoshaName;
    private RString todokedeDaihyoshaName;
    private ShikibetsuCode shikibetsuCode;
    private TelNo jigyoshaFaxNo;
    private FlexibleDate keiyakuTorokuYMD;
    private RString sofusakiBusho;
    private RString eigyoKeitai;
    private boolean jutakuKaishuKeiyakuUmu;
    private boolean tokuteiFukushiYoguHanbaiKeiyakuUmu;
    private boolean shokanbaraiKyufuKeiyakuUmu;
    private boolean kogakuKyufuKeiyakuUmu;
    private JigyoshaNo keiyakuJigyoshaNo;
    private boolean toriatsukaiKakuyakushoUmu;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getJigyoshaKeiyakuNo
     *
     * @return jigyoshaKeiyakuNo
     */
    public RString getJigyoshaKeiyakuNo() {
        return jigyoshaKeiyakuNo;
    }

    /**
     * setJigyoshaKeiyakuNo
     *
     * @param jigyoshaKeiyakuNo jigyoshaKeiyakuNo
     */
    public void setJigyoshaKeiyakuNo(RString jigyoshaKeiyakuNo) {
        this.jigyoshaKeiyakuNo = jigyoshaKeiyakuNo;
    }

    /**
     * getKaishiYMD
     *
     * @return kaishiYMD
     */
    public FlexibleDate getKaishiYMD() {
        return kaishiYMD;
    }

    /**
     * setKaishiYMD
     *
     * @param kaishiYMD kaishiYMD
     */
    public void setKaishiYMD(FlexibleDate kaishiYMD) {
        this.kaishiYMD = kaishiYMD;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public RDateTime getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getShuryoYMD
     *
     * @return shuryoYMD
     */
    public FlexibleDate getShuryoYMD() {
        return shuryoYMD;
    }

    /**
     * setShuryoYMD
     *
     * @param shuryoYMD shuryoYMD
     */
    public void setShuryoYMD(FlexibleDate shuryoYMD) {
        this.shuryoYMD = shuryoYMD;
    }

    /**
     * getTodokedeYMD
     *
     * @return todokedeYMD
     */
    public FlexibleDate getTodokedeYMD() {
        return todokedeYMD;
    }

    /**
     * setTodokedeYMD
     *
     * @param todokedeYMD todokedeYMD
     */
    public void setTodokedeYMD(FlexibleDate todokedeYMD) {
        this.todokedeYMD = todokedeYMD;
    }

    /**
     * getTodokedeAddress
     *
     * @return todokedeAddress
     */
    public RString getTodokedeAddress() {
        return todokedeAddress;
    }

    /**
     * setTodokedeAddress
     *
     * @param todokedeAddress todokedeAddress
     */
    public void setTodokedeAddress(RString todokedeAddress) {
        this.todokedeAddress = todokedeAddress;
    }

    /**
     * getTodokedeJigyoshaName
     *
     * @return todokedeJigyoshaName
     */
    public RString getTodokedeJigyoshaName() {
        return todokedeJigyoshaName;
    }

    /**
     * setTodokedeJigyoshaName
     *
     * @param todokedeJigyoshaName todokedeJigyoshaName
     */
    public void setTodokedeJigyoshaName(RString todokedeJigyoshaName) {
        this.todokedeJigyoshaName = todokedeJigyoshaName;
    }

    /**
     * getTodokedeDaihyoshaName
     *
     * @return todokedeDaihyoshaName
     */
    public RString getTodokedeDaihyoshaName() {
        return todokedeDaihyoshaName;
    }

    /**
     * setTodokedeDaihyoshaName
     *
     * @param todokedeDaihyoshaName todokedeDaihyoshaName
     */
    public void setTodokedeDaihyoshaName(RString todokedeDaihyoshaName) {
        this.todokedeDaihyoshaName = todokedeDaihyoshaName;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getJigyoshaFaxNo
     *
     * @return jigyoshaFaxNo
     */
    public TelNo getJigyoshaFaxNo() {
        return jigyoshaFaxNo;
    }

    /**
     * setJigyoshaFaxNo
     *
     * @param jigyoshaFaxNo jigyoshaFaxNo
     */
    public void setJigyoshaFaxNo(TelNo jigyoshaFaxNo) {
        this.jigyoshaFaxNo = jigyoshaFaxNo;
    }

    /**
     * getKeiyakuTorokuYMD
     *
     * @return keiyakuTorokuYMD
     */
    public FlexibleDate getKeiyakuTorokuYMD() {
        return keiyakuTorokuYMD;
    }

    /**
     * setKeiyakuTorokuYMD
     *
     * @param keiyakuTorokuYMD keiyakuTorokuYMD
     */
    public void setKeiyakuTorokuYMD(FlexibleDate keiyakuTorokuYMD) {
        this.keiyakuTorokuYMD = keiyakuTorokuYMD;
    }

    /**
     * getSofusakiBusho
     *
     * @return sofusakiBusho
     */
    public RString getSofusakiBusho() {
        return sofusakiBusho;
    }

    /**
     * setSofusakiBusho
     *
     * @param sofusakiBusho sofusakiBusho
     */
    public void setSofusakiBusho(RString sofusakiBusho) {
        this.sofusakiBusho = sofusakiBusho;
    }

    /**
     * getEigyoKeitai
     *
     * @return eigyoKeitai
     */
    public RString getEigyoKeitai() {
        return eigyoKeitai;
    }

    /**
     * setEigyoKeitai
     *
     * @param eigyoKeitai eigyoKeitai
     */
    public void setEigyoKeitai(RString eigyoKeitai) {
        this.eigyoKeitai = eigyoKeitai;
    }

    /**
     * getJutakuKaishuKeiyakuUmu
     *
     * @return jutakuKaishuKeiyakuUmu
     */
    public boolean getJutakuKaishuKeiyakuUmu() {
        return jutakuKaishuKeiyakuUmu;
    }

    /**
     * setJutakuKaishuKeiyakuUmu
     *
     * @param jutakuKaishuKeiyakuUmu jutakuKaishuKeiyakuUmu
     */
    public void setJutakuKaishuKeiyakuUmu(boolean jutakuKaishuKeiyakuUmu) {
        this.jutakuKaishuKeiyakuUmu = jutakuKaishuKeiyakuUmu;
    }

    /**
     * getTokuteiFukushiYoguHanbaiKeiyakuUmu
     *
     * @return tokuteiFukushiYoguHanbaiKeiyakuUmu
     */
    public boolean getTokuteiFukushiYoguHanbaiKeiyakuUmu() {
        return tokuteiFukushiYoguHanbaiKeiyakuUmu;
    }

    /**
     * setTokuteiFukushiYoguHanbaiKeiyakuUmu
     *
     * @param tokuteiFukushiYoguHanbaiKeiyakuUmu
     * tokuteiFukushiYoguHanbaiKeiyakuUmu
     */
    public void setTokuteiFukushiYoguHanbaiKeiyakuUmu(boolean tokuteiFukushiYoguHanbaiKeiyakuUmu) {
        this.tokuteiFukushiYoguHanbaiKeiyakuUmu = tokuteiFukushiYoguHanbaiKeiyakuUmu;
    }

    /**
     * getShokanbaraiKyufuKeiyakuUmu
     *
     * @return shokanbaraiKyufuKeiyakuUmu
     */
    public boolean getShokanbaraiKyufuKeiyakuUmu() {
        return shokanbaraiKyufuKeiyakuUmu;
    }

    /**
     * setShokanbaraiKyufuKeiyakuUmu
     *
     * @param shokanbaraiKyufuKeiyakuUmu shokanbaraiKyufuKeiyakuUmu
     */
    public void setShokanbaraiKyufuKeiyakuUmu(boolean shokanbaraiKyufuKeiyakuUmu) {
        this.shokanbaraiKyufuKeiyakuUmu = shokanbaraiKyufuKeiyakuUmu;
    }

    /**
     * getKogakuKyufuKeiyakuUmu
     *
     * @return kogakuKyufuKeiyakuUmu
     */
    public boolean getKogakuKyufuKeiyakuUmu() {
        return kogakuKyufuKeiyakuUmu;
    }

    /**
     * setKogakuKyufuKeiyakuUmu
     *
     * @param kogakuKyufuKeiyakuUmu kogakuKyufuKeiyakuUmu
     */
    public void setKogakuKyufuKeiyakuUmu(boolean kogakuKyufuKeiyakuUmu) {
        this.kogakuKyufuKeiyakuUmu = kogakuKyufuKeiyakuUmu;
    }

    /**
     * getKeiyakuJigyoshaNo
     *
     * @return keiyakuJigyoshaNo
     */
    public JigyoshaNo getKeiyakuJigyoshaNo() {
        return keiyakuJigyoshaNo;
    }

    /**
     * setKeiyakuJigyoshaNo
     *
     * @param keiyakuJigyoshaNo keiyakuJigyoshaNo
     */
    public void setKeiyakuJigyoshaNo(JigyoshaNo keiyakuJigyoshaNo) {
        this.keiyakuJigyoshaNo = keiyakuJigyoshaNo;
    }

    /**
     * getToriatsukaiKakuyakushoUmu
     *
     * @return toriatsukaiKakuyakushoUmu
     */
    public boolean getToriatsukaiKakuyakushoUmu() {
        return toriatsukaiKakuyakushoUmu;
    }

    /**
     * setToriatsukaiKakuyakushoUmu
     *
     * @param toriatsukaiKakuyakushoUmu toriatsukaiKakuyakushoUmu
     */
    public void setToriatsukaiKakuyakushoUmu(boolean toriatsukaiKakuyakushoUmu) {
        this.toriatsukaiKakuyakushoUmu = toriatsukaiKakuyakushoUmu;
    }

// </editor-fold>
}

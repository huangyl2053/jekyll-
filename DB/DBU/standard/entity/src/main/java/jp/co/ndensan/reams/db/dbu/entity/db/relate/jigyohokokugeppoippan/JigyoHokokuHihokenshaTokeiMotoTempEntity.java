package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * temp事業報告世帯数集計データ一時テーブルです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@OnNextSchema("rgdb")
public class JigyoHokokuHihokenshaTokeiMotoTempEntity extends DbTableEntityBase<JigyoHokokuHihokenshaTokeiMotoTempEntity> implements IDbAccessable {

    /**
     * temp事業報告世帯数集計データ一時テーブル
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempJigyoHokokuHihokenshaTokeiMotoData"));
    }
    @TempTableColumnOrder(1)
    private RString dataShuruiKubun;
    @TempTableColumnOrder(2)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(4)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(5)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(6)
    private LasdecCode kyuShichosonCode;
    @TempTableColumnOrder(7)
    private FlexibleDate kijunYMD;
    @TempTableColumnOrder(8)
    private FlexibleDate idoYMD;
    @TempTableColumnOrder(9)
    private RString edaNo;
    @TempTableColumnOrder(10)
    private RString idoJiyuCode;
    @TempTableColumnOrder(11)
    private RString shikakuShutokuJiyuCode;
    @TempTableColumnOrder(12)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(13)
    private FlexibleDate shikakuShutokuTodokedeYMD;
    @TempTableColumnOrder(14)
    private FlexibleDate ichigoShikakuShutokuYMD;
    @TempTableColumnOrder(15)
    private RString hihokennshaKubunCode;
    @TempTableColumnOrder(16)
    private RString shikakuSoshitsuJiyuCode;
    @TempTableColumnOrder(17)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(18)
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    @TempTableColumnOrder(19)
    private RString shikakuHenkoJiyuCode;
    @TempTableColumnOrder(20)
    private FlexibleDate shikakuHenkoYMD;
    @TempTableColumnOrder(21)
    private FlexibleDate shikakuHenkoTodokedeYMD;
    @TempTableColumnOrder(22)
    private RString jushochitokureiTekiyoJiyuCode;
    @TempTableColumnOrder(23)
    private FlexibleDate jushochitokureiTekiyoYMD;
    @TempTableColumnOrder(24)
    private FlexibleDate jushochitokureiTekiyoTodokedeYMD;
    @TempTableColumnOrder(25)
    private RString jushochitokureiKaijoJiyuCode;
    @TempTableColumnOrder(26)
    private FlexibleDate jushochitokureiKaijoYMD;
    @TempTableColumnOrder(27)
    private FlexibleDate jushochitokureiKaijoTodokedeYMD;
    @TempTableColumnOrder(28)
    private RString jushochiTokureiFlag;
    @TempTableColumnOrder(29)
    private RString koikinaiJushochiTokureiFlag;
    @TempTableColumnOrder(30)
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    @TempTableColumnOrder(31)
    private YMDHMS shoriTimestamp;
    @TempTableColumnOrder(32)
    private FlexibleDate seinengappiYMD;

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(JigyoHokokuHihokenshaTokeiMotoTempEntity entity) {
        this.setDataShuruiKubun(entity.getDataShuruiKubun());
        this.setHihokenshaNo(entity.getHihokenshaNo());
        this.setShikibetsuCode(entity.getShikibetsuCode());
        this.setSetaiCode(entity.getSetaiCode());
        this.setShichosonCode(entity.getShichosonCode());
        this.setKyuShichosonCode(entity.getKyuShichosonCode());
        this.setKijunYMD(entity.getKijunYMD());
        this.setIdoYMD(entity.getIdoYMD());
        this.setEdaNo(entity.getEdaNo());
        this.setIdoJiyuCode(entity.getIdoJiyuCode());
        this.setShikakuShutokuJiyuCode(entity.getShikakuShutokuJiyuCode());
        this.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        this.setShikakuShutokuTodokedeYMD(entity.getShikakuShutokuTodokedeYMD());
        this.setIchigoShikakuShutokuYMD(entity.getIchigoShikakuShutokuYMD());
        this.setHihokennshaKubunCode(entity.getHihokennshaKubunCode());
        this.setShikakuSoshitsuJiyuCode(entity.getShikakuSoshitsuJiyuCode());
        this.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        this.setShikakuSoshitsuTodokedeYMD(entity.getShikakuSoshitsuTodokedeYMD());
        this.setShikakuHenkoJiyuCode(entity.getShikakuHenkoJiyuCode());
        this.setShikakuHenkoYMD(entity.getShikakuHenkoYMD());
        this.setShikakuHenkoTodokedeYMD(entity.getShikakuHenkoTodokedeYMD());
        this.setJushochitokureiTekiyoJiyuCode(entity.getJushochitokureiTekiyoJiyuCode());
        this.setJushochitokureiTekiyoYMD(entity.getJushochitokureiTekiyoYMD());
        this.setJushochitokureiTekiyoTodokedeYMD(entity.getJushochitokureiTekiyoTodokedeYMD());
        this.setJushochitokureiKaijoJiyuCode(entity.getJushochitokureiKaijoJiyuCode());
        this.setJushochitokureiKaijoYMD(entity.getJushochitokureiKaijoYMD());
        this.setJushochitokureiKaijoTodokedeYMD(entity.getJushochitokureiKaijoTodokedeYMD());
        this.setJushochiTokureiFlag(entity.getJushochiTokureiFlag());
        this.setKoikinaiJushochiTokureiFlag(entity.getKoikinaiJushochiTokureiFlag());
        this.setKoikinaiTokureiSochimotoShichosonCode(entity.getKoikinaiTokureiSochimotoShichosonCode());
        this.setShoriTimestamp(entity.getShoriTimestamp());
        this.setSeinengappiYMD(entity.getSeinengappiYMD());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(dataShuruiKubun, hihokenshaNo, shikibetsuCode, setaiCode, shichosonCode, kyuShichosonCode,
                kijunYMD, idoYMD, edaNo, idoJiyuCode, shikakuShutokuJiyuCode, shikakuShutokuYMD, shikakuShutokuTodokedeYMD,
                ichigoShikakuShutokuYMD, hihokennshaKubunCode, shikakuSoshitsuJiyuCode, shikakuSoshitsuYMD, shikakuSoshitsuTodokedeYMD,
                shikakuHenkoJiyuCode, shikakuHenkoYMD, shikakuHenkoTodokedeYMD, jushochitokureiTekiyoJiyuCode, jushochitokureiTekiyoYMD,
                jushochitokureiTekiyoTodokedeYMD, jushochitokureiKaijoJiyuCode, jushochitokureiKaijoYMD, jushochitokureiKaijoTodokedeYMD,
                jushochiTokureiFlag, koikinaiJushochiTokureiFlag, koikinaiTokureiSochimotoShichosonCode, shoriTimestamp, seinengappiYMD);
    }

    /**
     * @return the dataShuruiKubun
     */
    public RString getDataShuruiKubun() {
        return dataShuruiKubun;
    }

    /**
     * @param dataShuruiKubun the dataShuruiKubun to set
     */
    public void setDataShuruiKubun(RString dataShuruiKubun) {
        this.dataShuruiKubun = dataShuruiKubun;
    }

    /**
     * @return the hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * @param hihokenshaNo the hihokenshaNo to set
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * @return the shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * @param shikibetsuCode the shikibetsuCode to set
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * @return the setaiCode
     */
    public SetaiCode getSetaiCode() {
        return setaiCode;
    }

    /**
     * @param setaiCode the setaiCode to set
     */
    public void setSetaiCode(SetaiCode setaiCode) {
        this.setaiCode = setaiCode;
    }

    /**
     * @return the shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * @param shichosonCode the shichosonCode to set
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * @return the kyuShichosonCode
     */
    public LasdecCode getKyuShichosonCode() {
        return kyuShichosonCode;
    }

    /**
     * @param kyuShichosonCode the kyuShichosonCode to set
     */
    public void setKyuShichosonCode(LasdecCode kyuShichosonCode) {
        this.kyuShichosonCode = kyuShichosonCode;
    }

    /**
     * @return the kijunYMD
     */
    public FlexibleDate getKijunYMD() {
        return kijunYMD;
    }

    /**
     * @param kijunYMD the kijunYMD to set
     */
    public void setKijunYMD(FlexibleDate kijunYMD) {
        this.kijunYMD = kijunYMD;
    }

    /**
     * @return the idoYMD
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * @param idoYMD the idoYMD to set
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * @return the edaNo
     */
    public RString getEdaNo() {
        return edaNo;
    }

    /**
     * @param edaNo the edaNo to set
     */
    public void setEdaNo(RString edaNo) {
        this.edaNo = edaNo;
    }

    /**
     * @return the idoJiyuCode
     */
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * @param idoJiyuCode the idoJiyuCode to set
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * @return the shikakuShutokuJiyuCode
     */
    public RString getShikakuShutokuJiyuCode() {
        return shikakuShutokuJiyuCode;
    }

    /**
     * @param shikakuShutokuJiyuCode the shikakuShutokuJiyuCode to set
     */
    public void setShikakuShutokuJiyuCode(RString shikakuShutokuJiyuCode) {
        this.shikakuShutokuJiyuCode = shikakuShutokuJiyuCode;
    }

    /**
     * @return the shikakuShutokuYMD
     */
    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    /**
     * @param shikakuShutokuYMD the shikakuShutokuYMD to set
     */
    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * @return the shikakuShutokuTodokedeYMD
     */
    public FlexibleDate getShikakuShutokuTodokedeYMD() {
        return shikakuShutokuTodokedeYMD;
    }

    /**
     * @param shikakuShutokuTodokedeYMD the shikakuShutokuTodokedeYMD to set
     */
    public void setShikakuShutokuTodokedeYMD(FlexibleDate shikakuShutokuTodokedeYMD) {
        this.shikakuShutokuTodokedeYMD = shikakuShutokuTodokedeYMD;
    }

    /**
     * @return the ichigoShikakuShutokuYMD
     */
    public FlexibleDate getIchigoShikakuShutokuYMD() {
        return ichigoShikakuShutokuYMD;
    }

    /**
     * @param ichigoShikakuShutokuYMD the ichigoShikakuShutokuYMD to set
     */
    public void setIchigoShikakuShutokuYMD(FlexibleDate ichigoShikakuShutokuYMD) {
        this.ichigoShikakuShutokuYMD = ichigoShikakuShutokuYMD;
    }

    /**
     * @return the hihokennshaKubunCode
     */
    public RString getHihokennshaKubunCode() {
        return hihokennshaKubunCode;
    }

    /**
     * @param hihokennshaKubunCode the hihokennshaKubunCode to set
     */
    public void setHihokennshaKubunCode(RString hihokennshaKubunCode) {
        this.hihokennshaKubunCode = hihokennshaKubunCode;
    }

    /**
     * @return the shikakuSoshitsuJiyuCode
     */
    public RString getShikakuSoshitsuJiyuCode() {
        return shikakuSoshitsuJiyuCode;
    }

    /**
     * @param shikakuSoshitsuJiyuCode the shikakuSoshitsuJiyuCode to set
     */
    public void setShikakuSoshitsuJiyuCode(RString shikakuSoshitsuJiyuCode) {
        this.shikakuSoshitsuJiyuCode = shikakuSoshitsuJiyuCode;
    }

    /**
     * @return the shikakuSoshitsuYMD
     */
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * @param shikakuSoshitsuYMD the shikakuSoshitsuYMD to set
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * @return the shikakuSoshitsuTodokedeYMD
     */
    public FlexibleDate getShikakuSoshitsuTodokedeYMD() {
        return shikakuSoshitsuTodokedeYMD;
    }

    /**
     * @param shikakuSoshitsuTodokedeYMD the shikakuSoshitsuTodokedeYMD to set
     */
    public void setShikakuSoshitsuTodokedeYMD(FlexibleDate shikakuSoshitsuTodokedeYMD) {
        this.shikakuSoshitsuTodokedeYMD = shikakuSoshitsuTodokedeYMD;
    }

    /**
     * @return the shikakuHenkoJiyuCode
     */
    public RString getShikakuHenkoJiyuCode() {
        return shikakuHenkoJiyuCode;
    }

    /**
     * @param shikakuHenkoJiyuCode the shikakuHenkoJiyuCode to set
     */
    public void setShikakuHenkoJiyuCode(RString shikakuHenkoJiyuCode) {
        this.shikakuHenkoJiyuCode = shikakuHenkoJiyuCode;
    }

    /**
     * @return the shikakuHenkoYMD
     */
    public FlexibleDate getShikakuHenkoYMD() {
        return shikakuHenkoYMD;
    }

    /**
     * @param shikakuHenkoYMD the shikakuHenkoYMD to set
     */
    public void setShikakuHenkoYMD(FlexibleDate shikakuHenkoYMD) {
        this.shikakuHenkoYMD = shikakuHenkoYMD;
    }

    /**
     * @return the shikakuHenkoTodokedeYMD
     */
    public FlexibleDate getShikakuHenkoTodokedeYMD() {
        return shikakuHenkoTodokedeYMD;
    }

    /**
     * @param shikakuHenkoTodokedeYMD the shikakuHenkoTodokedeYMD to set
     */
    public void setShikakuHenkoTodokedeYMD(FlexibleDate shikakuHenkoTodokedeYMD) {
        this.shikakuHenkoTodokedeYMD = shikakuHenkoTodokedeYMD;
    }

    /**
     * @return the jushochitokureiTekiyoJiyuCode
     */
    public RString getJushochitokureiTekiyoJiyuCode() {
        return jushochitokureiTekiyoJiyuCode;
    }

    /**
     * @param jushochitokureiTekiyoJiyuCode the jushochitokureiTekiyoJiyuCode to set
     */
    public void setJushochitokureiTekiyoJiyuCode(RString jushochitokureiTekiyoJiyuCode) {
        this.jushochitokureiTekiyoJiyuCode = jushochitokureiTekiyoJiyuCode;
    }

    /**
     * @return the jushochitokureiTekiyoYMD
     */
    public FlexibleDate getJushochitokureiTekiyoYMD() {
        return jushochitokureiTekiyoYMD;
    }

    /**
     * @param jushochitokureiTekiyoYMD the jushochitokureiTekiyoYMD to set
     */
    public void setJushochitokureiTekiyoYMD(FlexibleDate jushochitokureiTekiyoYMD) {
        this.jushochitokureiTekiyoYMD = jushochitokureiTekiyoYMD;
    }

    /**
     * @return the jushochitokureiTekiyoTodokedeYMD
     */
    public FlexibleDate getJushochitokureiTekiyoTodokedeYMD() {
        return jushochitokureiTekiyoTodokedeYMD;
    }

    /**
     * @param jushochitokureiTekiyoTodokedeYMD the jushochitokureiTekiyoTodokedeYMD to set
     */
    public void setJushochitokureiTekiyoTodokedeYMD(FlexibleDate jushochitokureiTekiyoTodokedeYMD) {
        this.jushochitokureiTekiyoTodokedeYMD = jushochitokureiTekiyoTodokedeYMD;
    }

    /**
     * @return the jushochitokureiKaijoJiyuCode
     */
    public RString getJushochitokureiKaijoJiyuCode() {
        return jushochitokureiKaijoJiyuCode;
    }

    /**
     * @param jushochitokureiKaijoJiyuCode the jushochitokureiKaijoJiyuCode to set
     */
    public void setJushochitokureiKaijoJiyuCode(RString jushochitokureiKaijoJiyuCode) {
        this.jushochitokureiKaijoJiyuCode = jushochitokureiKaijoJiyuCode;
    }

    /**
     * @return the jushochitokureiKaijoYMD
     */
    public FlexibleDate getJushochitokureiKaijoYMD() {
        return jushochitokureiKaijoYMD;
    }

    /**
     * @param jushochitokureiKaijoYMD the jushochitokureiKaijoYMD to set
     */
    public void setJushochitokureiKaijoYMD(FlexibleDate jushochitokureiKaijoYMD) {
        this.jushochitokureiKaijoYMD = jushochitokureiKaijoYMD;
    }

    /**
     * @return the jushochitokureiKaijoTodokedeYMD
     */
    public FlexibleDate getJushochitokureiKaijoTodokedeYMD() {
        return jushochitokureiKaijoTodokedeYMD;
    }

    /**
     * @param jushochitokureiKaijoTodokedeYMD the jushochitokureiKaijoTodokedeYMD to set
     */
    public void setJushochitokureiKaijoTodokedeYMD(FlexibleDate jushochitokureiKaijoTodokedeYMD) {
        this.jushochitokureiKaijoTodokedeYMD = jushochitokureiKaijoTodokedeYMD;
    }

    /**
     * @return the jushochiTokureiFlag
     */
    public RString getJushochiTokureiFlag() {
        return jushochiTokureiFlag;
    }

    /**
     * @param jushochiTokureiFlag the jushochiTokureiFlag to set
     */
    public void setJushochiTokureiFlag(RString jushochiTokureiFlag) {
        this.jushochiTokureiFlag = jushochiTokureiFlag;
    }

    /**
     * @return the koikinaiJushochiTokureiFlag
     */
    public RString getKoikinaiJushochiTokureiFlag() {
        return koikinaiJushochiTokureiFlag;
    }

    /**
     * @param koikinaiJushochiTokureiFlag the koikinaiJushochiTokureiFlag to set
     */
    public void setKoikinaiJushochiTokureiFlag(RString koikinaiJushochiTokureiFlag) {
        this.koikinaiJushochiTokureiFlag = koikinaiJushochiTokureiFlag;
    }

    /**
     * @return the koikinaiTokureiSochimotoShichosonCode
     */
    public LasdecCode getKoikinaiTokureiSochimotoShichosonCode() {
        return koikinaiTokureiSochimotoShichosonCode;
    }

    /**
     * @param koikinaiTokureiSochimotoShichosonCode the koikinaiTokureiSochimotoShichosonCode to set
     */
    public void setKoikinaiTokureiSochimotoShichosonCode(LasdecCode koikinaiTokureiSochimotoShichosonCode) {
        this.koikinaiTokureiSochimotoShichosonCode = koikinaiTokureiSochimotoShichosonCode;
    }

    /**
     * @return the shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * @param shoriTimestamp the shoriTimestamp to set
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * @return the seinengappiYMD
     */
    public FlexibleDate getSeinengappiYMD() {
        return seinengappiYMD;
    }

    /**
     * @param seinengappiYMD the seinengappiYMD to set
     */
    public void setSeinengappiYMD(FlexibleDate seinengappiYMD) {
        this.seinengappiYMD = seinengappiYMD;
    }

}

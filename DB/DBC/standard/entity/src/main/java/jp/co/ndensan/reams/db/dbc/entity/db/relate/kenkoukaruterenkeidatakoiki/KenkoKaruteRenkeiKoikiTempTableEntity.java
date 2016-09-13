/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidatakoiki;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 広域介護被保険者配信用一時テーブルです。
 *
 * @reamsid_L DBC-5020-011 wangxiaodong
 */
@OnNextSchema("rgdb")
public class KenkoKaruteRenkeiKoikiTempTableEntity extends DbTableEntityBase<KenkoKaruteRenkeiKoikiTempTableEntity> implements IDbAccessable {

    /**
     * 広域介護被保険者配信用一時テーブル
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("KenkoKaruteRenkeiKoikiTempTable"));
    }
    @TempTableColumnOrder(1)
    private RString hihokenshaNo;
    @TempTableColumnOrder(2)
    private FlexibleDate idoYMD;
    @TempTableColumnOrder(3)
    private RString shichosonCode;
    @TempTableColumnOrder(4)
    private RString shikibetsuCode;
    @TempTableColumnOrder(5)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(6)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(7)
    private boolean logicalDeletedFlag;
    @TempTableColumnOrder(8)
    private RString gyomuCode;
    @TempTableColumnOrder(9)
    private RString juminShubetsuCode;
    @TempTableColumnOrder(10)
    private RString juminJotaiCode;
    @TempTableColumnOrder(11)
    private RString meisho;
    @TempTableColumnOrder(12)
    private RString kanaMeisho;
    @TempTableColumnOrder(13)
    private RString kojinNo;
    @TempTableColumnOrder(14)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(15)
    private RString seibetsuCode;
    @TempTableColumnOrder(16)
    private RString rirekiNo;
    @TempTableColumnOrder(17)
    private RString edaban;
    @TempTableColumnOrder(18)
    private RString yokaigoJotaiKubunCode;
    @TempTableColumnOrder(19)
    private FlexibleDate ninteiYMD;
    @TempTableColumnOrder(20)
    private FlexibleDate soshitsuYMD;
    @TempTableColumnOrder(21)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(22)
    private FlexibleDate ninteiYukoKikanShuryoYMD;

    /**
     * @return the hihokenshaNo
     */
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * @param hihokenshaNo the hihokenshaNo to set
     */
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
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
     * @return the shichosonCode
     */
    public RString getShichosonCode() {
        return shichosonCode;
    }

    /**
     * @param shichosonCode the shichosonCode to set
     */
    public void setShichosonCode(RString shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * @return the shikibetsuCode
     */
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * @param shikibetsuCode the shikibetsuCode to set
     */
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
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
     * @return the logicalDeletedFlag
     */
    public boolean isLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * @param logicalDeletedFlag the logicalDeletedFlag to set
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * @return the gyomuCode
     */
    public RString getGyomuCode() {
        return gyomuCode;
    }

    /**
     * @param gyomuCode the gyomuCode to set
     */
    public void setGyomuCode(RString gyomuCode) {
        this.gyomuCode = gyomuCode;
    }

    /**
     * @return the juminShubetsuCode
     */
    public RString getJuminShubetsuCode() {
        return juminShubetsuCode;
    }

    /**
     * @param juminShubetsuCode the juminShubetsuCode to set
     */
    public void setJuminShubetsuCode(RString juminShubetsuCode) {
        this.juminShubetsuCode = juminShubetsuCode;
    }

    /**
     * @return the juminJotaiCode
     */
    public RString getJuminJotaiCode() {
        return juminJotaiCode;
    }

    /**
     * @param juminJotaiCode the juminJotaiCode to set
     */
    public void setJuminJotaiCode(RString juminJotaiCode) {
        this.juminJotaiCode = juminJotaiCode;
    }

    /**
     * @return the meisho
     */
    public RString getMeisho() {
        return meisho;
    }

    /**
     * @param meisho the meisho to set
     */
    public void setMeisho(RString meisho) {
        this.meisho = meisho;
    }

    /**
     * @return the kanaMeisho
     */
    public RString getKanaMeisho() {
        return kanaMeisho;
    }

    /**
     * @param kanaMeisho the kanaMeisho to set
     */
    public void setKanaMeisho(RString kanaMeisho) {
        this.kanaMeisho = kanaMeisho;
    }

    /**
     * @return the kojinNo
     */
    public RString getKojinNo() {
        return kojinNo;
    }

    /**
     * @param kojinNo the kojinNo to set
     */
    public void setKojinNo(RString kojinNo) {
        this.kojinNo = kojinNo;
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

    /**
     * @return the seibetsuCode
     */
    public RString getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * @param seibetsuCode the seibetsuCode to set
     */
    public void setSeibetsuCode(RString seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
    }

    /**
     * @return the rirekiNo
     */
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /**
     * @param rirekiNo the rirekiNo to set
     */
    public void setRirekiNo(RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * @return the edaban
     */
    public RString getEdaban() {
        return edaban;
    }

    /**
     * @param edaban the edaban to set
     */
    public void setEdaban(RString edaban) {
        this.edaban = edaban;
    }

    /**
     * @return the yokaigoJotaiKubunCode
     */
    public RString getYokaigoJotaiKubunCode() {
        return yokaigoJotaiKubunCode;
    }

    /**
     * @param yokaigoJotaiKubunCode the yokaigoJotaiKubunCode to set
     */
    public void setYokaigoJotaiKubunCode(RString yokaigoJotaiKubunCode) {
        this.yokaigoJotaiKubunCode = yokaigoJotaiKubunCode;
    }

    /**
     * @return the ninteiYMD
     */
    public FlexibleDate getNinteiYMD() {
        return ninteiYMD;
    }

    /**
     * @param ninteiYMD the ninteiYMD to set
     */
    public void setNinteiYMD(FlexibleDate ninteiYMD) {
        this.ninteiYMD = ninteiYMD;
    }

    /**
     * @return the soshitsuYMD
     */
    public FlexibleDate getSoshitsuYMD() {
        return soshitsuYMD;
    }

    /**
     * @param soshitsuYMD the soshitsuYMD to set
     */
    public void setSoshitsuYMD(FlexibleDate soshitsuYMD) {
        this.soshitsuYMD = soshitsuYMD;
    }

    /**
     * @return the ninteiYukoKikanKaishiYMD
     */
    public FlexibleDate getNinteiYukoKikanKaishiYMD() {
        return ninteiYukoKikanKaishiYMD;
    }

    /**
     * @param ninteiYukoKikanKaishiYMD the ninteiYukoKikanKaishiYMD to set
     */
    public void setNinteiYukoKikanKaishiYMD(FlexibleDate ninteiYukoKikanKaishiYMD) {
        this.ninteiYukoKikanKaishiYMD = ninteiYukoKikanKaishiYMD;
    }

    /**
     * @return the ninteiYukoKikanShuryoYMD
     */
    public FlexibleDate getNinteiYukoKikanShuryoYMD() {
        return ninteiYukoKikanShuryoYMD;
    }

    /**
     * @param ninteiYukoKikanShuryoYMD the ninteiYukoKikanShuryoYMD to set
     */
    public void setNinteiYukoKikanShuryoYMD(FlexibleDate ninteiYukoKikanShuryoYMD) {
        this.ninteiYukoKikanShuryoYMD = ninteiYukoKikanShuryoYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(KenkoKaruteRenkeiKoikiTempTableEntity entity) {
        this.setEdaban(entity.getEdaban());
        this.setGyomuCode(entity.getGyomuCode());
        this.setHihokenshaNo(entity.getHihokenshaNo());
        this.setIdoYMD(entity.getIdoYMD());
        this.setJuminJotaiCode(entity.getJuminJotaiCode());
        this.setJuminShubetsuCode(entity.getJuminShubetsuCode());
        this.setKanaMeisho(entity.getKanaMeisho());
        this.setKojinNo(entity.getKojinNo());
        this.setLogicalDeletedFlag(entity.isLogicalDeletedFlag());
        this.setMeisho(entity.getMeisho());
        this.setNinteiYMD(entity.getNinteiYMD());
        this.setNinteiYukoKikanKaishiYMD(entity.getNinteiYukoKikanKaishiYMD());
        this.setNinteiYukoKikanShuryoYMD(entity.getNinteiYukoKikanShuryoYMD());
        this.setRirekiNo(entity.getRirekiNo());
        this.setSeibetsuCode(entity.getSeibetsuCode());
        this.setSeinengappiYMD(entity.getSeinengappiYMD());
        this.setShichosonCode(entity.getShichosonCode());
        this.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        this.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        this.setShikibetsuCode(entity.getShikibetsuCode());
        this.setSoshitsuYMD(entity.getSoshitsuYMD());
        this.setYokaigoJotaiKubunCode(entity.getYokaigoJotaiKubunCode());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, idoYMD, shichosonCode, shikibetsuCode, shikakuShutokuYMD, shikakuSoshitsuYMD,
                logicalDeletedFlag, gyomuCode, juminShubetsuCode, juminJotaiCode, meisho, kanaMeisho, kojinNo, seinengappiYMD,
                seibetsuCode, rirekiNo, edaban, yokaigoJotaiKubunCode, ninteiYMD, soshitsuYMD, ninteiYukoKikanKaishiYMD, ninteiYukoKikanShuryoYMD);
    }
// </editor-fold>
}

package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 受給者台帳Aliveテーブルの項目定義クラスです。
 */
public enum DbV4001JukyushaDaicho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    /**
     * shichosonCode
     */
    shichosonCode(2147483647, 0),
    /**
     * hihokenshaNo
     */
    hihokenshaNo(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(4, 0),
    /**
     * edaban
     */
    edaban(2, 0),
    /**
     * shinseishoKanriNo
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * shinseiJokyoKubun
     */
    shinseiJokyoKubun(1, 0),
    /**
     * shishoCode
     */
    shishoCode(9, 0),
    /**
     * chokkinFlag
     */
    chokkinFlag(1, 0),
    /**
     * shikibetsuCode
     */
    shikibetsuCode(2147483647, 0),
    /**
     * jukyuShinseiJiyu
     */
    jukyuShinseiJiyu(2147483647, 0),
    /**
     * shinseiRiyu
     */
    shinseiRiyu(2147483647, 0),
    /**
     * shinseishaKankeiCode
     */
    shinseishaKankeiCode(2147483647, 0),
    /**
     * homninKankei
     */
    homninKankei(10, 0),
    /**
     * jukyuShinseiYMD
     */
    jukyuShinseiYMD(2147483647, 0),
    /**
     * nigoTokuteiShippeiCode
     */
    nigoTokuteiShippeiCode(2147483647, 0),
    /**
     * shinsakaiIraiYMD
     */
    shinsakaiIraiYMD(2147483647, 0),
    /**
     * yokaigoJotaiKubunCode
     */
    yokaigoJotaiKubunCode(2147483647, 0),
    /**
     * ninteiYukoKikanKaishiYMD
     */
    ninteiYukoKikanKaishiYMD(2147483647, 0),
    /**
     * ninteiYukoKikanShuryoYMD
     */
    ninteiYukoKikanShuryoYMD(2147483647, 0),
    /**
     * ninteiYMD
     */
    ninteiYMD(2147483647, 0),
    /**
     * shiteiServiceShurui01
     */
    shiteiServiceShurui01(2147483647, 0),
    /**
     * shiteiServiceShurui02
     */
    shiteiServiceShurui02(2147483647, 0),
    /**
     * shiteiServiceShurui03
     */
    shiteiServiceShurui03(2147483647, 0),
    /**
     * shiteiServiceShurui04
     */
    shiteiServiceShurui04(2147483647, 0),
    /**
     * shiteiServiceShurui05
     */
    shiteiServiceShurui05(2147483647, 0),
    /**
     * shiteiServiceShurui06
     */
    shiteiServiceShurui06(2147483647, 0),
    /**
     * shiteiServiceShurui07
     */
    shiteiServiceShurui07(2147483647, 0),
    /**
     * shiteiServiceShurui08
     */
    shiteiServiceShurui08(2147483647, 0),
    /**
     * shiteiServiceShurui09
     */
    shiteiServiceShurui09(2147483647, 0),
    /**
     * shiteiServiceShurui10
     */
    shiteiServiceShurui10(2147483647, 0),
    /**
     * shiteiServiceShurui11
     */
    shiteiServiceShurui11(2147483647, 0),
    /**
     * shiteiServiceShurui12
     */
    shiteiServiceShurui12(2147483647, 0),
    /**
     * shiteiServiceShurui13
     */
    shiteiServiceShurui13(2147483647, 0),
    /**
     * shiteiServiceShurui14
     */
    shiteiServiceShurui14(2147483647, 0),
    /**
     * shiteiServiceShurui15
     */
    shiteiServiceShurui15(2147483647, 0),
    /**
     * shiteiServiceShurui16
     */
    shiteiServiceShurui16(2147483647, 0),
    /**
     * shiteiServiceShurui17
     */
    shiteiServiceShurui17(2147483647, 0),
    /**
     * shiteiServiceShurui18
     */
    shiteiServiceShurui18(2147483647, 0),
    /**
     * shiteiServiceShurui19
     */
    shiteiServiceShurui19(2147483647, 0),
    /**
     * shiteiServiceShurui20
     */
    shiteiServiceShurui20(2147483647, 0),
    /**
     * shiteiServiceShurui21
     */
    shiteiServiceShurui21(2147483647, 0),
    /**
     * shiteiServiceShurui22
     */
    shiteiServiceShurui22(2147483647, 0),
    /**
     * shiteiServiceShurui23
     */
    shiteiServiceShurui23(2147483647, 0),
    /**
     * shiteiServiceShurui24
     */
    shiteiServiceShurui24(2147483647, 0),
    /**
     * shiteiServiceShurui25
     */
    shiteiServiceShurui25(2147483647, 0),
    /**
     * shiteiServiceShurui26
     */
    shiteiServiceShurui26(2147483647, 0),
    /**
     * shiteiServiceShurui27
     */
    shiteiServiceShurui27(2147483647, 0),
    /**
     * shiteiServiceShurui28
     */
    shiteiServiceShurui28(2147483647, 0),
    /**
     * shiteiServiceShurui29
     */
    shiteiServiceShurui29(2147483647, 0),
    /**
     * shiteiServiceShurui30
     */
    shiteiServiceShurui30(2147483647, 0),
    /**
     * soshitsuYMD
     */
    soshitsuYMD(2147483647, 0),
    /**
     * chokkinIdoYMD
     */
    chokkinIdoYMD(2147483647, 0),
    /**
     * chokkinIdoJiyuCode
     */
    chokkinIdoJiyuCode(2147483647, 0),
    /**
     * yukoMukoKubun
     */
    yukoMukoKubun(2147483647, 0),
    /**
     * dataKubun
     */
    dataKubun(2147483647, 0),
    /**
     * remban
     */
    remban(4, 0),
    /**
     * idoRiyu
     */
    idoRiyu(2147483647, 0),
    /**
     * shinseishoKubun
     */
    shinseishoKubun(2147483647, 0),
    /**
     * sakujoJiyuCode
     */
    sakujoJiyuCode(2147483647, 0),
    /**
     * yoshienshaNinteiShinseiFlag
     */
    yoshienshaNinteiShinseiFlag(1, 0),
    /**
     * shikyuGendoTanisu
     */
    shikyuGendoTanisu(131089, 0),
    /**
     * shikyuGendoKaishiYMD
     */
    shikyuGendoKaishiYMD(2147483647, 0),
    /**
     * shikyuGendoShuryoYMD
     */
    shikyuGendoShuryoYMD(2147483647, 0),
    /**
     * tankiSikyuGendoNissu
     */
    tankiSikyuGendoNissu(10, 0),
    /**
     * tankiShikyuGendoKaishiYMD
     */
    tankiShikyuGendoKaishiYMD(2147483647, 0),
    /**
     * tankiShikyuGendoShuryoYMD
     */
    tankiShikyuGendoShuryoYMD(2147483647, 0),
    /**
     * toshoNinteiYukoKaishiYMD
     */
    toshoNinteiYukoKaishiYMD(2147483647, 0),
    /**
     * toshoNinteiYukoShuryoYMD
     */
    toshoNinteiYukoShuryoYMD(2147483647, 0),
    /**
     * jukyuShikakuShomeishoHakkoYMD1
     */
    jukyuShikakuShomeishoHakkoYMD1(2147483647, 0),
    /**
     * jukyuShikakuShomeishoHakkoYMD2
     */
    jukyuShikakuShomeishoHakkoYMD2(2147483647, 0),
    /**
     * shindanMeireishoHakkoYMD
     */
    shindanMeireishoHakkoYMD(2147483647, 0),
    /**
     * nigoShinseiJuriTsuchishoHakkoYMD
     */
    nigoShinseiJuriTsuchishoHakkoYMD(2147483647, 0),
    /**
     * ninteiKekkaTsuchishoHakkoYMD
     */
    ninteiKekkaTsuchishoHakkoYMD(2147483647, 0),
    /**
     * kubunHenkoTsuchishoHakkoYMD
     */
    kubunHenkoTsuchishoHakkoYMD(2147483647, 0),
    /**
     * serviceHenkoTsuchishoHakkoYMD
     */
    serviceHenkoTsuchishoHakkoYMD(2147483647, 0),
    /**
     * ninteiKyakkaTsuchishoHakkoYMD
     */
    ninteiKyakkaTsuchishoHakkoYMD(2147483647, 0),
    /**
     * ninteiTorikeshiTsuchishoHakkoYMD
     */
    ninteiTorikeshiTsuchishoHakkoYMD(2147483647, 0),
    /**
     * shikakuShutokuMaeShinseiFlag
     */
    shikakuShutokuMaeShinseiFlag(1, 0),
    /**
     * kyuSochishaFlag
     */
    kyuSochishaFlag(1, 0),
    /**
     * logicalDeletedFlag
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbV4001JukyushaDaicho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     * 
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     * 
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}

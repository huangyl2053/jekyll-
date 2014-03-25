package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定調査結果情報を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum DbT5008NinteichosaKekkaJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinseishoKanriNo(2147483647, 0),
    ninteichosaRirekiNo(5, 0),
    koroshoIfShikibetsuCode(3, 0),
    ninteichousaIraiKubunCode(2147483647, 0),
    ninteichosaIraiKaisu(5, 0),
    ninteichosaJisshiYMD(2147483647, 0),
    ninteichosaJuryoYMD(2147483647, 0),
    chosaItakuKubunCode(2147483647, 0),
    ninteiChosaKubunCode(2147483647, 0),
    chosaItakusakiCode(2147483647, 0),
    chosainCode(8, 0),
    chosaJisshiBashoCode(2147483647, 0),
    chosaJisshiBashoMeisho(32, 0),
    genzainoJokyoCode(2147483647, 0),
    serviceKubunCode(2147483647, 0),
    homonKaigo(5, 0),
    homonNyuyokuKaigo(5, 0),
    homonKango(5, 0),
    homonRehabilitation(5, 0),
    kyotakuRyoyoKanriShido(5, 0),
    tushoKaigo(5, 0),
    tushoRehabilitation(5, 0),
    tankiNyushoSeikatsuKaigo(5, 0),
    tankiNyushoRyoyoKaigo(5, 0),
    tokuteiShisetsuNyushoshaSeikatsuKaigo(5, 0),
    hukushiYoguTaiyo(5, 0),
    tokuteiHukushiYoguHanbai(5, 0),
    jutakuKaishu(5, 0),
    yakanTaiogataHomonKaigo(5, 0),
    ninchishoTaiogataTushoKaigo(5, 0),
    shokiboTakinogataKyotakuKaigo(5, 0),
    ninchishoTaiogataKyodoSeikatsuKaigo(5, 0),
    chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo(5, 0),
    chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo(5, 0),
    teikijunkaiZuijiTaiogataHomonKaigoKango(5, 0),
    hukugogataService(5, 0),
    kaigoyoboHomonKaigo(5, 0),
    kaigoyoboNyuyokuKaigo(5, 0),
    kaigoyoboHomonKango(5, 0),
    kaigoyoboHomonRehabilitation(5, 0),
    kaigoyoboKyotakuRyoyoKanriShido(5, 0),
    kaigoyoboTushoKaigo(5, 0),
    kaigoyoboTushoRehabilitation(5, 0),
    kaigoyoboTankiNyushoSeikatsuKaigo(5, 0),
    kaigooyoboTankiNyushoRyoyoKaigo(5, 0),
    kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo(5, 0),
    kaigoyoboHukushiYoguTaiyo(5, 0),
    kaigoyoboHukushiYoguHanbai(5, 0),
    kaigoyoboJutakuKaishuYobokyufu(5, 0),
    kaigoyoboNinchishoTaiogataTushoKaigo(5, 0),
    kaigoyoboShokiboTakinogataKyotakuKaigo(5, 0),
    kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo(5, 0),
    shichosonTokubetsuKyufu(60, 0),
    kaigohokenKyufuIgaiNoZaitakuService(60, 0),
    riyoShisetsuCode(2147483647, 0),
    riyoShisetsuShimei(80, 0),
    riyoShisetsuJusho(2147483647, 0),
    riyoShisetsuTelNo(2147483647, 0),
    riyoShisetsuYubinNo(2147483647, 0),
    gaikyochosaTokkijiko(2147483647, 0),
    tokkijikoUketsukeYMD(2147483647, 0),
    tokkijikoJuryoYMD(2147483647, 0);
    private final int maxLength;
    private final int scale;

    private DbT5008NinteichosaKekkaJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }
// </editor-fold>
}

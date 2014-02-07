package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定調査結果情報を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum DbT5008NinteichosaKekkaJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    shinseishoKanriNo(10, 0),
    ninteichousaIraiKubunCode(8, 0),
    ninteichosaIraiKaisu(5, 0),
    ninteichosaRirekiNo(5, 0),
    ninteichosaJisshiYMD(8, 0),
    ninteichosaJuryoYMD(8, 0),
    chosaItakuKubunCode(8, 0),
    ninteiChosaKubunCode(8, 0),
    chosaItakusakiCode(10, 0),
    chosainCode(8, 0),
    chosaJisshiBashoCode(8, 0),
    chosaJisshiBashoMeisho(32, 0),
    genzainoJokyoCode(8, 0),
    serviceKubunCode(8, 0),
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
    riyoShisetsuCode(10, 0),
    riyoShisetsuShimei(80, 0),
    riyoShisetsuJusho(50, 0),
    riyoShisetsuTelNo(14, 0),
    riyoShisetsuYubinNo(7, 0),
    gaikyochosaTokkijiko(512, 0),
    ninchishoNichijoSeikatsuJiritsudoCode(8, 0),
    shogaiNichijoSeikatsuJiritsudoCode(8, 0),
    shinsakaiYusenWaritsukeKubunCode(8, 0),
    tokkijikoUketsukeYMD(8, 0),
    tokkijikoJuryoYMD(8, 0);
    private final int maxLength;
    private final int scale;

    private DbT5008NinteichosaKekkaJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getScale() {
        return scale;
    }
// </editor-fold>
}

package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3001JukyushaIdoRenrakuhyoの項目定義クラスです
 *
 */
public enum DbT3001JukyushaIdoRenrakuhyo implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    idoYMD(2147483647, 0),
    idoKubunCode(1, 0),
    jukyushaIdoJiyu(2, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    hiHokenshaNameKana(25, 0),
    umareYMD(2147483647, 0),
    seibetsuCode(1, 0),
    shikakuShutokuYMD(2147483647, 0),
    shikakuSoshitsuYMD(2147483647, 0),
    rojinHokenShichosonNo(8, 0),
    rojinHokenJukyushaNo(7, 0),
    kohiFutanshaNo(8, 0),
    koikiRengoHokenshaNo(2147483647, 0),
    shinseiShubetsuCode(1, 0),
    henkoShinseichuKubunCode(1, 0),
    shinseiYMD(2147483647, 0),
    minashiYokaigoJotaiKubunCode(1, 0),
    yokaigoJotaiKubunCode(2, 0),
    ninteiYukoKikankaishiYMD(2147483647, 0),
    ninteiYukoKikanShuryoYMD(2147483647, 0),
    kyotakuServiceSakuseiKubunCode(1, 0),
    kyotakuKaigoShienJigyoshoNo(2147483647, 0),
    kyotakuServiceTekiyoKaishiYMD(2147483647, 0),
    kyotakuServiceTekiyoShuryoYMD(2147483647, 0),
    homonTsushoServiceShikyuGendoKijungaku(10, 0),
    homonTsushoServiceJogenKanriTekiyoKaishiYMD(2147483647, 0),
    homonTsushoServiceJogenKanriTekiyoShuryoYMD(2147483647, 0),
    tankiNyushoServiceShikyuGendoKijungaku(5, 0),
    tankinyushoServiceJogenKanriTekiyoKaishiYMD(2147483647, 0),
    tankinyushoServiceJogenKanriTekiyoShuryoYMD(2147483647, 0),
    kohiFutanJogenGengakuAriFlag(1, 0),
    shokanbaraikaKaishiYMD(2147483647, 0),
    shokanbaraikaShuryoYMD(2147483647, 0),
    kyufuritsuHikisageKaishiYMD(2147483647, 0),
    kyufuritsuHikisageShuryoYMD(2147483647, 0),
    gemmenShinseichuKubunCode(1, 0),
    riyoshaFutanKubunCode(1, 0),
    kyufuritsu(2147483647, 0),
    tekiyoKaishiYMD(2147483647, 0),
    tekiyoShuryoYMD(2147483647, 0),
    hyojunFutanKubunCode(1, 0),
    futangaku(10, 0),
    futangakuTekiyoKaishiYMD(2147483647, 0),
    futangakuTekiyoShuryoYMD(2147483647, 0),
    tokuteiNyushoshaNinteiShinseichuKubunCode(1, 0),
    tokuteiNyushoshaKaigoServiceKubunCode(1, 0),
    kaizeisoTokureiGengakuSochiTaishoFlag(1, 0),
    shokuhiFutanGendogaku(5, 0),
    kyojuhiUnitGataKoshitsuFutanGendogaku(5, 0),
    kyojuhiUnitGataJunKoshitsuFutanGendogaku(5, 0),
    kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku(5, 0),
    kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku(5, 0),
    kyujuhiTashoshitsuFutanGendogaku(5, 0),
    futanGendogakuTekiyoKaishiYMD(2147483647, 0),
    futanGendogakuTekiyoShuryoYMD(2147483647, 0),
    keigenritsu(5, 0),
    keigenritsuTekiyoKaishiYMD(2147483647, 0),
    keigenritsuTekiyoShuryoYMD(2147483647, 0),
    shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag(1, 0),
    kokiKoureiIryoHokenshaNo(8, 0),
    kokikoureiIryoHiHokenshaNo(8, 0),
    kokuhoHokenshaNo(8, 0),
    kokuhoHiHokenshaNo(20, 0),
    kokuhoKojinNo(10, 0),
    nijiyoboJigyoKubunCode(1, 0),
    nijiyoboJigyoYukoKikanKaishiYMD(2147483647, 0),
    nijiyoboJigyoYukoKikanShuryoYMD(2147483647, 0),
    teiseiRenrakuhyoFlag(1, 0),
    sofuYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3001JukyushaIdoRenrakuhyo(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}

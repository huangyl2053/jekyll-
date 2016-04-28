/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.hanyourisutosyuturyoku;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyourisutosyuturyoku.HanyoListKogakuKaigoMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額介護サービス費状況)のProcessパラメータです。
 *
 * @reamsid_L DBC-3092-020 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuKaigoProcessParameter implements IBatchProcessParameter {

    private LasdecCode kouseiShichosonCode;
    private FlexibleYearMonth serviceYmFrom;
    private FlexibleYearMonth serviceYmTo;
    private RString shoriJokyo;
    private RString shinsaHoho;
    private RString santeiKijun;
    private RString kokuhorenFuicchi;
    private RString taishosha;
    private RString shinseiKubun;
    private RString shiharaiSaki;
    private RString kiyuKikanCode;
    private FlexibleDate shisehiFrom;
    private FlexibleDate shisehiTo;
    private FlexibleDate hokemonoKeteihiFrom;
    private FlexibleDate hokemonoKeteihiTo;
    private FlexibleYearMonth kokuhoreKeteiymFrom;
    private FlexibleYearMonth kokuhoreKeteiymTo;
    private FlexibleYearMonth taishoshaUketoriymFrom;
    private FlexibleYearMonth taishoshaUketoriymTo;
    private FlexibleYearMonth kokuhoreSofuYMFrom;
    private FlexibleYearMonth kokuhoreSofuYMTo;
    private FlexibleYearMonth keteijohoUketoriymFrom;
    private FlexibleYearMonth keteijohoUketoriymTo;
    private Long shutsuryokuju;
    private RString shutsuryokuTomoku;
    private boolean tomokumeFuka;
    private boolean rebanFuka;
    private boolean hizukeHeshu;
    private IShikibetsuTaishoPSMSearchKey 宛名検索条件;

    /**
     * コンストラクタです。
     *
     * @param kouseiShichosonCode kouseiShichosonCode
     * @param serviceYmFrom serviceYmFrom
     * @param serviceYmTo serviceYmTo
     * @param shoriJokyo shoriJokyo
     * @param shinsaHoho shinsaHoho
     * @param santeiKijun santeiKijun
     * @param kokuhorenFuicchi kokuhorenFuicchi
     * @param taishosha taishosha
     * @param shinseiKubun shinseiKubun
     * @param shiharaiSaki shiharaiSaki
     * @param kiyuKikanCode kiyuKikanCode
     * @param shisehiFrom shisehiFrom
     * @param shisehiTo shisehiTo
     * @param hokemonoKeteihiFrom hokemonoKeteihiFrom
     * @param hokemonoKeteihiTo hokemonoKeteihiTo
     * @param kokuhoreKeteiymFrom kokuhoreKeteiymFrom
     * @param kokuhoreKeteiymTo kokuhoreKeteiymTo
     * @param taishoshaUketoriymFrom taishoshaUketoriymFrom
     * @param taishoshaUketoriymTo taishoshaUketoriymTo
     * @param kokuhoreSofuYMFrom kokuhoreSofuYMFrom
     * @param kokuhoreSofuYMTo kokuhoreSofuYMTo
     * @param keteijohoUketoriymFrom keteijohoUketoriymFrom
     * @param keteijohoUketoriymTo keteijohoUketoriymTo
     * @param shutsuryokuju shutsuryokuju
     * @param shutsuryokuTomoku shutsuryokuTomoku
     * @param tomokumeFuka tomokumeFuka
     * @param rebanFuka rebanFuka
     * @param hizukeHeshu hizukeHeshu
     * @param 宛名検索条件 宛名検索条件
     */
    public HanyoListKogakuKaigoProcessParameter(
            LasdecCode kouseiShichosonCode,
            FlexibleYearMonth serviceYmFrom,
            FlexibleYearMonth serviceYmTo,
            RString shoriJokyo,
            RString shinsaHoho,
            RString santeiKijun,
            RString kokuhorenFuicchi,
            RString taishosha,
            RString shinseiKubun,
            RString shiharaiSaki,
            RString kiyuKikanCode,
            FlexibleDate shisehiFrom,
            FlexibleDate shisehiTo,
            FlexibleDate hokemonoKeteihiFrom,
            FlexibleDate hokemonoKeteihiTo,
            FlexibleYearMonth kokuhoreKeteiymFrom,
            FlexibleYearMonth kokuhoreKeteiymTo,
            FlexibleYearMonth taishoshaUketoriymFrom,
            FlexibleYearMonth taishoshaUketoriymTo,
            FlexibleYearMonth kokuhoreSofuYMFrom,
            FlexibleYearMonth kokuhoreSofuYMTo,
            FlexibleYearMonth keteijohoUketoriymFrom,
            FlexibleYearMonth keteijohoUketoriymTo,
            Long shutsuryokuju,
            RString shutsuryokuTomoku,
            boolean tomokumeFuka,
            boolean rebanFuka,
            boolean hizukeHeshu,
            IShikibetsuTaishoPSMSearchKey 宛名検索条件) {
        this.kouseiShichosonCode = kouseiShichosonCode;
        this.serviceYmFrom = serviceYmFrom;
        this.serviceYmTo = serviceYmTo;
        this.shoriJokyo = shoriJokyo;
        this.shinsaHoho = shinsaHoho;
        this.santeiKijun = santeiKijun;
        this.kokuhorenFuicchi = kokuhorenFuicchi;
        this.taishosha = taishosha;
        this.shinseiKubun = shinseiKubun;
        this.shiharaiSaki = shiharaiSaki;
        this.kiyuKikanCode = kiyuKikanCode;
        this.shisehiFrom = shisehiFrom;
        this.shisehiTo = shisehiTo;
        this.hokemonoKeteihiFrom = hokemonoKeteihiFrom;
        this.hokemonoKeteihiTo = hokemonoKeteihiTo;
        this.kokuhoreKeteiymFrom = kokuhoreKeteiymFrom;
        this.kokuhoreKeteiymTo = kokuhoreKeteiymTo;
        this.taishoshaUketoriymFrom = taishoshaUketoriymFrom;
        this.taishoshaUketoriymTo = taishoshaUketoriymTo;
        this.kokuhoreSofuYMFrom = kokuhoreSofuYMFrom;
        this.kokuhoreSofuYMTo = kokuhoreSofuYMTo;
        this.keteijohoUketoriymFrom = keteijohoUketoriymFrom;
        this.keteijohoUketoriymTo = keteijohoUketoriymTo;
        this.shutsuryokuju = shutsuryokuju;
        this.shutsuryokuTomoku = shutsuryokuTomoku;
        this.tomokumeFuka = tomokumeFuka;
        this.rebanFuka = rebanFuka;
        this.hizukeHeshu = hizukeHeshu;
        this.宛名検索条件 = 宛名検索条件;
    }

    /**
     * 域内住所地特例者一覧表のMyBatisパラメータ作成です。
     *
     * @return 域内住所地特例者一覧表のMyBatisパラメータ
     */
    public HanyoListKogakuKaigoMybatisParameter toMybatisParamter() {
        return new HanyoListKogakuKaigoMybatisParameter(
                宛名検索条件,
                kouseiShichosonCode,
                serviceYmFrom,
                serviceYmTo,
                shoriJokyo,
                shinsaHoho,
                santeiKijun,
                kokuhorenFuicchi,
                taishosha,
                shinseiKubun,
                shiharaiSaki,
                kiyuKikanCode,
                shisehiFrom,
                shisehiTo,
                hokemonoKeteihiFrom,
                hokemonoKeteihiTo,
                kokuhoreKeteiymFrom,
                kokuhoreKeteiymTo,
                taishoshaUketoriymFrom,
                taishoshaUketoriymTo,
                kokuhoreSofuYMFrom,
                kokuhoreSofuYMTo,
                keteijohoUketoriymFrom,
                keteijohoUketoriymTo,
                shutsuryokuju,
                shutsuryokuTomoku,
                tomokumeFuka,
                rebanFuka,
                hizukeHeshu);
    }
}

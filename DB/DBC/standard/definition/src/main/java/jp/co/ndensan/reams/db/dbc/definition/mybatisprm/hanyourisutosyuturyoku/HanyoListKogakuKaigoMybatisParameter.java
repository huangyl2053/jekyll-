/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyourisutosyuturyoku;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額介護サービス費状況)のMybatisパラメータです。
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuKaigoMybatisParameter extends UaFt200FindShikibetsuTaishoParam
        implements IMyBatisParameter {

    private final LasdecCode kouseiShichosonCode;
    private final FlexibleYearMonth serviceYmFrom;
    private final FlexibleYearMonth serviceYmTo;
    private final RString shoriJokyo;
    private final RString shinsaHoho;
    private final RString santeiKijun;
    private final RString kokuhorenFuicchi;
    private final RString taishosha;
    private final RString shinseiKubun;
    private final RString shiharaiSaki;
    private final RString kiyuKikanCode;
    private final FlexibleDate shisehiFrom;
    private final FlexibleDate shisehiTo;
    private final FlexibleDate hokemonoKeteihiFrom;
    private final FlexibleDate hokemonoKeteihiTo;
    private final FlexibleYearMonth kokuhoreKeteiymFrom;
    private final FlexibleYearMonth kokuhoreKeteiymTo;
    private final FlexibleYearMonth taishoshaUketoriymFrom;
    private final FlexibleYearMonth taishoshaUketoriymTo;
    private final FlexibleYearMonth kokuhoreSofuYMFrom;
    private final FlexibleYearMonth kokuhoreSofuYMTo;
    private final FlexibleYearMonth keteijohoUketoriymFrom;
    private final FlexibleYearMonth keteijohoUketoriymTo;
    private final RString shutsuryokuju;
    private final RString shutsuryokuTomoku;
    private final boolean tomokumeFuka;
    private final boolean rebanFuka;
    private final boolean hizukeHeshu;

    /**
     * コンストラクタです。
     *
     * @param 宛名検索条件 宛名検索条件
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
     */
    public HanyoListKogakuKaigoMybatisParameter(
            IShikibetsuTaishoPSMSearchKey 宛名検索条件,
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
            RString shutsuryokuju,
            RString shutsuryokuTomoku,
            boolean tomokumeFuka,
            boolean rebanFuka,
            boolean hizukeHeshu) {
        super(宛名検索条件);
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
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.hanyourisutosyuturyoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku.SanteiKijun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyourisutosyuturyoku.HanyoListKogakuKaigoMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト出力(高額介護サービス費状況)のProcessパラメータです。
 *
 * @reamsid_L DBC-3092-020 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuKaigoProcessParameter implements IBatchProcessParameter {

    private int modo;
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
    private RString kiyuKikanName;
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
    private FlexibleYearMonth shinsaYM;
    private Long shutsuryokuju;
    private RString shutsuryokuTomoku;
    private boolean tomokumeFuka;
    private boolean rebanFuka;
    private boolean hizukeHeshu;
    private RString 国保連IFなし区分;
    private RString 事業高額分;
    private IKozaSearchKey searchkey;
    private List<KamokuCode> list;
    private List<KamokuCode> kamokuCodelist;
    private RString reamsLoginId;
    private RString 出力順;

    private static final int 基準額_ONE = 15000;
    private static final int 基準額_TWO = 26400;
    private static final int 基準額_THREE = 37200;
    private static final int 基準額_FOUR = 44400;

    /**
     * コンストラクタです。
     *
     * @param modo modo
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
     * @param kiyuKikanName kiyuKikanName
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
     * @param shinsaYM shinsaYM
     * @param shutsuryokuju shutsuryokuju
     * @param shutsuryokuTomoku shutsuryokuTomoku
     * @param tomokumeFuka tomokumeFuka
     * @param rebanFuka rebanFuka
     * @param hizukeHeshu hizukeHeshu
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param kamokuCodelist List<KamokuCode>
     * @param reamsLoginId RString
     */
    public HanyoListKogakuKaigoProcessParameter(
            int modo,
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
            RString kiyuKikanName,
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
            FlexibleYearMonth shinsaYM,
            Long shutsuryokuju,
            RString shutsuryokuTomoku,
            boolean tomokumeFuka,
            boolean rebanFuka,
            boolean hizukeHeshu,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            List<KamokuCode> kamokuCodelist,
            RString reamsLoginId) {
        this.modo = modo;
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
        this.kiyuKikanName = kiyuKikanName;
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
        this.shinsaYM = shinsaYM;
        this.shutsuryokuju = shutsuryokuju;
        this.shutsuryokuTomoku = shutsuryokuTomoku;
        this.tomokumeFuka = tomokumeFuka;
        this.rebanFuka = rebanFuka;
        this.hizukeHeshu = hizukeHeshu;
        this.searchkey = searchkey;
        this.list = list;
        this.kamokuCodelist = kamokuCodelist;
        this.reamsLoginId = reamsLoginId;
    }

    /**
     * 域内住所地特例者一覧表のMyBatisパラメータ作成です。
     *
     * @return 域内住所地特例者一覧表のMyBatisパラメータ
     */
    public HanyoListKogakuKaigoMybatisParameter toMybatisParamter() {

        Decimal santeiKijunParamter = Decimal.ZERO;
        if (null != santeiKijun) {
            SanteiKijun 算定基準 = SanteiKijun.toValue(santeiKijun);
            if (SanteiKijun.すべて.get名称().equals(算定基準.get名称())) {
                santeiKijunParamter = Decimal.ZERO;
            } else if (SanteiKijun._１５０００円.get名称().equals(算定基準.get名称())) {
                santeiKijunParamter = new Decimal(基準額_ONE);
            } else if (SanteiKijun._２６４００円.get名称().equals(算定基準.get名称())) {
                santeiKijunParamter = new Decimal(基準額_TWO);
            } else if (SanteiKijun._３７２００円.get名称().equals(算定基準.get名称())) {
                santeiKijunParamter = new Decimal(基準額_THREE);
            } else {
                santeiKijunParamter = new Decimal(基準額_FOUR);
            }
        }

        return new HanyoListKogakuKaigoMybatisParameter(
                kouseiShichosonCode,
                serviceYmFrom,
                serviceYmTo,
                shoriJokyo,
                shinsaHoho,
                santeiKijun,
                santeiKijunParamter,
                kokuhorenFuicchi,
                taishosha,
                shinseiKubun,
                shiharaiSaki,
                kiyuKikanCode,
                kiyuKikanName,
                shisehiFrom,
                shisehiTo,
                hokemonoKeteihiFrom,
                hokemonoKeteihiTo,
                kokuhoreKeteiymFrom,
                kokuhoreKeteiymTo,
                (taishoshaUketoriymFrom == null || taishoshaUketoriymFrom.isEmpty()) ? null : taishoshaUketoriymFrom,
                (taishoshaUketoriymTo == null || taishoshaUketoriymTo.isEmpty()) ? null : taishoshaUketoriymTo,
                kokuhoreSofuYMFrom,
                kokuhoreSofuYMTo,
                keteijohoUketoriymFrom,
                keteijohoUketoriymTo,
                shinsaYM,
                shutsuryokuju,
                shutsuryokuTomoku,
                tomokumeFuka,
                rebanFuka,
                hizukeHeshu,
                国保連IFなし区分,
                事業高額分,
                出力順,
                searchkey,
                list,
                kamokuCodelist);
    }
}

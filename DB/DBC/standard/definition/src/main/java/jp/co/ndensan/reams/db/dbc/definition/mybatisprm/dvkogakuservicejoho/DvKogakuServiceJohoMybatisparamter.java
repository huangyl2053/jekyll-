/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dvkogakuservicejoho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 汎用リスト_高額介護サービス費状況のMyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-3092-010 zhuliangwei
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class DvKogakuServiceJohoMybatisparamter implements IMyBatisParameter {

    private final RString kouseiShichosonCode;
    private final RString serviceYmFrom;
    private final RString serviceYmTo;
    private final RString shoriJokyo;
    private final RString shinsaHoho;
    private final RString santeiKijun;
    private final RString kokuhorenFuicchi;
    private final RString taishosha;
    private final RString shinseiKubun;
    private final RString shiharaiSaki;
    private final RString kiyuKikanCode;
    private final RString shisehiFrom;
    private final RString shisehiTo;
    private final RString hokemonoKeteihiFrom;
    private final RString hokemonoKeteihiTo;
    private final RString kokuhoreKeteiymFrom;
    private final RString kokuhoreKeteiymTo;
    private final RString taishoshaUketoriymFrom;
    private final RString taishoshaUketoriymTo;
    private final RString kokuhoreSofuYMFrom;
    private final RString kokuhoreSofuYMTo;
    private final RString keteijohoUketoriymFrom;
    private final RString keteijohoUketoriymTo;
    private final RString shutsuryokuju;
    private final RString shutsuryokuTomoku;
    private final RString tomokumeFuka;
    private final RString rebanFuka;
    private final RString hizukeHeshu;
    private final RString psmShikibetsuTaisho;
    private final boolean isEmptyShichosonCode;

    private DvKogakuServiceJohoMybatisparamter(RString kouseiShichosonCode,
            RString serviceYmFrom,
            RString serviceYmTo,
            RString shoriJokyo,
            RString shinsaHoho,
            RString santeiKijun,
            RString kokuhorenFuicchi,
            RString taishosha,
            RString shinseiKubun,
            RString shiharaiSaki,
            RString kiyuKikanCode,
            RString shisehiFrom,
            RString shisehiTo,
            RString hokemonoKeteihiFrom,
            RString hokemonoKeteihiTo,
            RString kokuhoreKeteiymFrom,
            RString kokuhoreKeteiymTo,
            RString taishoshaUketoriymFrom,
            RString taishoshaUketoriymTo,
            RString kokuhoreSofuYMFrom,
            RString kokuhoreSofuYMTo,
            RString keteijohoUketoriymFrom,
            RString keteijohoUketoriymTo,
            RString shutsuryokuju,
            RString shutsuryokuTomoku,
            RString tomokumeFuka,
            RString rebanFuka,
            RString hizukeHeshu,
            RString psmShikibetsuTaisho,
            boolean isEmptyShichosonCode) {
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
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.isEmptyShichosonCode = isEmptyShichosonCode;
    }

    /**
     * 汎用リスト_高額介護サービス費状況のMyBatisパラメータのcreateします。
     *
     * @param kouseiShichosonCode
     * @param serviceYmFrom
     * @param serviceYmTo
     * @param shoriJokyo
     * @param shinsaHoho
     * @param santeiKijun
     * @param kokuhorenFuicchi
     * @param taishosha
     * @param shinseiKubun
     * @param shiharaiSaki
     * @param kiyuKikanCode
     * @param shisehiFrom
     * @param shisehiTo
     * @param hokemonoKeteihiFrom
     * @param hokemonoKeteihiTo
     * @param kokuhoreKeteiymFrom
     * @param kokuhoreKeteiymTo
     * @param taishoshaUketoriymFrom
     * @param taishoshaUketoriymTo
     * @param kokuhoreSofuYMFrom
     * @param kokuhoreSofuYMTo
     * @param keteijohoUketoriymFrom
     * @param keteijohoUketoriymTo
     * @param shutsuryokuju
     * @param shutsuryokuTomoku
     * @param tomokumeFuka
     * @param rebanFuka
     * @param hizukeHeshu
     * @param psmShikibetsuTaisho
     * @return 汎用リスト_高額介護サービス費状況のMyBatisパラメータ
     */
    public static DvKogakuServiceJohoMybatisparamter createParamter(RString kouseiShichosonCode,
            RString serviceYmFrom,
            RString serviceYmTo,
            RString shoriJokyo,
            RString shinsaHoho,
            RString santeiKijun,
            RString kokuhorenFuicchi,
            RString taishosha,
            RString shinseiKubun,
            RString shiharaiSaki,
            RString kiyuKikanCode,
            RString shisehiFrom,
            RString shisehiTo,
            RString hokemonoKeteihiFrom,
            RString hokemonoKeteihiTo,
            RString kokuhoreKeteiymFrom,
            RString kokuhoreKeteiymTo,
            RString taishoshaUketoriymFrom,
            RString taishoshaUketoriymTo,
            RString kokuhoreSofuYMFrom,
            RString kokuhoreSofuYMTo,
            RString keteijohoUketoriymFrom,
            RString keteijohoUketoriymTo,
            RString shutsuryokuju,
            RString shutsuryokuTomoku,
            RString tomokumeFuka,
            RString rebanFuka,
            RString hizukeHeshu,
            RString psmShikibetsuTaisho) {
        boolean isEmptyShichosonCodeFlag = false;
        return new DvKogakuServiceJohoMybatisparamter(kouseiShichosonCode,
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
                hizukeHeshu,
                psmShikibetsuTaisho,
                isEmptyShichosonCodeFlag);

    }
}

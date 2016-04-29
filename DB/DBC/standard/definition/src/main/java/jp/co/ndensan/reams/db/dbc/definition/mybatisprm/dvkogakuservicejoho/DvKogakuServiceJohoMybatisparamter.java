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
 * @reamsid_L DBC-3092-010 sunhui
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
     * @param kouseiShichosonCode 構成市町村コード
     * @param serviceYmFrom サービス提供年月From
     * @param serviceYmTo サービス提供年月To
     * @param shoriJokyo 処理状況
     * @param shinsaHoho 審査方法
     * @param santeiKijun 算定基準
     * @param kokuhorenFuicchi 国保連不一致
     * @param taishosha 対象者
     * @param shinseiKubun 申請区分
     * @param shiharaiSaki 支払先
     * @param kiyuKikanCode 金融機関コード
     * @param shisehiFrom 申請日From
     * @param shisehiTo 申請日To
     * @param hokemonoKeteihiFrom 保険者決定日From
     * @param hokemonoKeteihiTo 保険者決定日To
     * @param kokuhoreKeteiymFrom 国保連決定年月From
     * @param kokuhoreKeteiymTo 国保連決定年月To
     * @param taishoshaUketoriymFrom 対象者受取年月From
     * @param taishoshaUketoriymTo 対象者受取年月To
     * @param kokuhoreSofuYMFrom 国保連送付年月From
     * @param kokuhoreSofuYMTo 国保連送付年月To
     * @param keteijohoUketoriymFrom 決定情報受取年月From
     * @param keteijohoUketoriymTo 決定情報受取年月To
     * @param shutsuryokuju 出力順
     * @param shutsuryokuTomoku 出力項目
     * @param tomokumeFuka 項目名付加
     * @param rebanFuka 連番付加
     * @param hizukeHeshu 日付'/'編集
     * @param psmShikibetsuTaisho 宛名識別対象
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.dvkogakuservicejoho;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dvkogakuservicejoho.DvKogakuServiceJohoProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_高額介護サービス費状況のバッチパラメータクラスです。
 *
 * @reamsid_L DBC-3092-010 sunhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DvKogakuServiceJohoBatchParamter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KOUSEI_SHICHOSON_CODE = "kouseiShichosonCode";
    private static final String SERVICE_YM_FROM = "serviceYmFrom";
    private static final String SERVICE_YM_TO = "serviceYmTo";
    private static final String SHORI_JOKYO = "shoriJokyo";
    private static final String SHINSA_HOHO = "shinsaHoho";
    private static final String SANTEI_KIJUN = "santeiKijun";
    private static final String KOKUHOREN_FUICCHI = "kokuhorenFuicchi";
    private static final String TAISHOSHA = "taishosha";
    private static final String SHINSEI_KUBUN = "shinseiKubun";
    private static final String SHIHARAI_SAKI = "shiharaiSaki";
    private static final String KIYU_KIKAN_CODE = "kiyuKikanCode";
    private static final String SHISEHI_FROM = "shisehiFrom";
    private static final String SHISEHI_TO = "shisehiTo";
    private static final String HOKEMONO_KETEIHI_FROM = "hokemonoKeteihiFrom";
    private static final String HOKEMONO_KETEIHI_TO = "hokemonoKeteihiTo";
    private static final String KOKUHORE_KETEIYM_FROM = "kokuhoreKeteiymFrom";
    private static final String KOKUHORE_KETEIYM_TO = "kokuhoreKeteiymTo";
    private static final String TAISHOSHA_UKETORIYM_FROM = "taishoshaUketoriymFrom";
    private static final String TAISHOSHA_UKETORIYM_TO = "taishoshaUketoriymTo";
    private static final String KOKUHORE_SOFUYM_FROM = "kokuhoreSofuYMFrom";
    private static final String KOKUHORE_SOFUYM_TO = "kokuhoreSofuYMTo";
    private static final String KETEIJOHO_UKETORIYM_FROM = "keteijohoUketoriymFrom";
    private static final String KETEIJOHO_UKETORIYM_TO = "keteijohoUketoriymTo";
    private static final String SHUTSURYOKUJU = "shutsuryokuju";
    private static final String SHUTSURYOKU_TOMOKU = "shutsuryokuTomoku";
    private static final String TOMOKUME_FUKA = "tomokumeFuka";
    private static final String REBAN_FUKA = "rebanFuka";
    private static final String HIZUKE_HESHU = "hizukeHeshu";

    @BatchParameter(key = KOUSEI_SHICHOSON_CODE, name = "構成市町村コード")
    private RString kouseiShichosonCode;
    @BatchParameter(key = SERVICE_YM_FROM, name = "サービス提供年月From")
    private RString serviceYmFrom;
    @BatchParameter(key = SERVICE_YM_TO, name = "サービス提供年月To")
    private RString serviceYmTo;
    @BatchParameter(key = SHORI_JOKYO, name = "処理状況")
    private RString shoriJokyo;
    @BatchParameter(key = SHINSA_HOHO, name = "審査方法")
    private RString shinsaHoho;
    @BatchParameter(key = SANTEI_KIJUN, name = "算定基準")
    private RString santeiKijun;
    @BatchParameter(key = KOKUHOREN_FUICCHI, name = "国保連不一致")
    private RString kokuhorenFuicchi;
    @BatchParameter(key = TAISHOSHA, name = "対象者")
    private RString taishosha;
    @BatchParameter(key = SHINSEI_KUBUN, name = "申請区分")
    private RString shinseiKubun;
    @BatchParameter(key = SHIHARAI_SAKI, name = "支払先")
    private RString shiharaiSaki;
    @BatchParameter(key = KIYU_KIKAN_CODE, name = "金融機関コード")
    private RString kiyuKikanCode;
    @BatchParameter(key = SHISEHI_FROM, name = "申請日From")
    private RString shisehiFrom;
    @BatchParameter(key = SHISEHI_TO, name = "申請日To")
    private RString shisehiTo;
    @BatchParameter(key = HOKEMONO_KETEIHI_FROM, name = "保険者決定日From")
    private RString hokemonoKeteihiFrom;
    @BatchParameter(key = HOKEMONO_KETEIHI_TO, name = "保険者決定日To")
    private RString hokemonoKeteihiTo;
    @BatchParameter(key = KOKUHORE_KETEIYM_FROM, name = "国保連決定年月From")
    private RString kokuhoreKeteiymFrom;
    @BatchParameter(key = KOKUHORE_KETEIYM_TO, name = "国保連決定年月To")
    private RString kokuhoreKeteiymTo;
    @BatchParameter(key = TAISHOSHA_UKETORIYM_FROM, name = "対象者受取年月From")
    private RString taishoshaUketoriymFrom;
    @BatchParameter(key = TAISHOSHA_UKETORIYM_TO, name = "対象者受取年月To")
    private RString taishoshaUketoriymTo;
    @BatchParameter(key = KOKUHORE_SOFUYM_FROM, name = "国保連送付年月From")
    private RString kokuhoreSofuYMFrom;
    @BatchParameter(key = KOKUHORE_SOFUYM_TO, name = "国保連送付年月To")
    private RString kokuhoreSofuYMTo;
    @BatchParameter(key = KETEIJOHO_UKETORIYM_FROM, name = "決定情報受取年月From")
    private RString keteijohoUketoriymFrom;
    @BatchParameter(key = KETEIJOHO_UKETORIYM_TO, name = "決定情報受取年月To")
    private RString keteijohoUketoriymTo;
    @BatchParameter(key = SHUTSURYOKUJU, name = "出力順")
    private RString shutsuryokuju;
    @BatchParameter(key = SHUTSURYOKU_TOMOKU, name = "出力項目")
    private RString shutsuryokuTomoku;
    @BatchParameter(key = TOMOKUME_FUKA, name = "項目名付加")
    private RString tomokumeFuka;
    @BatchParameter(key = REBAN_FUKA, name = "連番付加")
    private RString rebanFuka;
    @BatchParameter(key = HIZUKE_HESHU, name = "日付’／’編集")
    private RString hizukeHeshu;

    /**
     * 汎用リスト_高額介護サービス費状況のProcessParamterパラメータ作成です。
     *
     * @return 汎用リスト_高額介護サービス費状況のProcessParamterパラメータ
     */
    public DvKogakuServiceJohoProcessParamter toProcessParamter() {
        return new DvKogakuServiceJohoProcessParamter(kouseiShichosonCode,
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

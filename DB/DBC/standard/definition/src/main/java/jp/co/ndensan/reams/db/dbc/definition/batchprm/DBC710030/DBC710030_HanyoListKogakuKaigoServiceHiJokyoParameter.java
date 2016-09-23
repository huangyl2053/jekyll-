/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyourisutosyuturyoku.HanyoListKogakuKaigoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額介護サービス費状況)のバッチパラメータです。
 *
 * @reamsid_L DBC-3092-020 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710030_HanyoListKogakuKaigoServiceHiJokyoParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_MODO = "modo";
    private static final String KEY_KOUSEI_SHICHOSON_CODE = "kouseiShichosonCode";
    private static final String KEY_SERVICE_YM_FROM = "serviceYmFrom";
    private static final String KEY_SERVICE_YM_TO = "serviceYmTo";
    private static final String KEY_SHORI_JOKYO = "shoriJokyo";
    private static final String KEY_SHINSA_HOHO = "shinsaHoho";
    private static final String KEY_SANTEI_KIJUN = "santeiKijun";
    private static final String KEY_KOKUHOREN_FUICCHI = "kokuhorenFuicchi";
    private static final String KEY_TAISHOSHA = "taishosha";
    private static final String KEY_SHINSEI_KUBUN = "shinseiKubun";
    private static final String KEY_SHIHARAI_SAKI = "shiharaiSaki";
    private static final String KEY_KIYU_KIKAN_CODE = "kiyuKikanCode";
    private static final String KEY_KIYU_KIKAN_NAME = "kiyuKikanName";
    private static final String KEY_SHISEHI_FROM = "shisehiFrom";
    private static final String KEY_SHISEHI_TO = "shisehiTo";
    private static final String KEY_HOKEMONO_KETEIHI_FROM = "hokemonoKeteihiFrom";
    private static final String KEY_HOKEMONO_KETEIHI_TO = "hokemonoKeteihiTo";
    private static final String KEY_KOKUHORE_KETEIYM_FROM = "kokuhoreKeteiymFrom";
    private static final String KEY_KOKUHORE_KETEIYM_TO = "kokuhoreKeteiymTo";
    private static final String KEY_TAISHOSHA_UKETORIYM_FROM = "taishoshaUketoriymFrom";
    private static final String KEY_TAISHOSHA_UKETORIYM_TO = "taishoshaUketoriymTo";
    private static final String KEY_KOKUHORE_SOFUYM_FROM = "kokuhoreSofuYMFrom";
    private static final String KEY_KOKUHORE_SOFUYM_TO = "kokuhoreSofuYMTo";
    private static final String KEY_KETEIJOHO_UKETORIYM_FROM = "keteijohoUketoriymFrom";
    private static final String KEY_KETEIJOHO_UKETORIYM_TO = "keteijohoUketoriymTo";
    private static final String KEY_SHUTSURYOKUJU = "shutsuryokuju";
    private static final String KEY_SHINSAYM = "shinsaYM";
    private static final String KEY_SHUTSURYOKU_TOMOKU = "shutsuryokuTomoku";
    private static final String KEY_TOMOKUME_FUKA = "tomokumeFuka";
    private static final String KEY_REBAN_FUKA = "rebanFuka";
    private static final String KEY_HIZUKE_HESHU = "hizukeHeshu";
    private static final String KEY_REAMS_LOGIN_ID = "reamsLoginId";

    @BatchParameter(key = KEY_MODO, name = "モード")
    private int modo;
    @BatchParameter(key = KEY_KOUSEI_SHICHOSON_CODE, name = "構成市町村コード")
    private LasdecCode kouseiShichosonCode;
    @BatchParameter(key = KEY_SERVICE_YM_FROM, name = "サービス提供年月From")
    private FlexibleYearMonth serviceYmFrom;
    @BatchParameter(key = KEY_SERVICE_YM_TO, name = "サービス提供年月To")
    private FlexibleYearMonth serviceYmTo;
    @BatchParameter(key = KEY_SHORI_JOKYO, name = "処理状況")
    private RString shoriJokyo;
    @BatchParameter(key = KEY_SHINSA_HOHO, name = "審査方法")
    private RString shinsaHoho;
    @BatchParameter(key = KEY_SANTEI_KIJUN, name = "算定基準")
    private RString santeiKijun;
    @BatchParameter(key = KEY_KOKUHOREN_FUICCHI, name = "国保連不一致")
    private RString kokuhorenFuicchi;
    @BatchParameter(key = KEY_TAISHOSHA, name = "対象者")
    private RString taishosha;
    @BatchParameter(key = KEY_SHINSEI_KUBUN, name = "申請区分")
    private RString shinseiKubun;
    @BatchParameter(key = KEY_SHIHARAI_SAKI, name = "支払先")
    private RString shiharaiSaki;
    @BatchParameter(key = KEY_KIYU_KIKAN_CODE, name = "金融機関コード")
    private RString kiyuKikanCode;
    @BatchParameter(key = KEY_KIYU_KIKAN_NAME, name = "金融機関名称")
    private RString kiyuKikanName;
    @BatchParameter(key = KEY_SHISEHI_FROM, name = "申請日From")
    private FlexibleDate shisehiFrom;
    @BatchParameter(key = KEY_SHISEHI_TO, name = "申請日To")
    private FlexibleDate shisehiTo;
    @BatchParameter(key = KEY_HOKEMONO_KETEIHI_FROM, name = "保険者決定日From")
    private FlexibleDate hokemonoKeteihiFrom;
    @BatchParameter(key = KEY_HOKEMONO_KETEIHI_TO, name = "保険者決定日To")
    private FlexibleDate hokemonoKeteihiTo;
    @BatchParameter(key = KEY_KOKUHORE_KETEIYM_FROM, name = "国保連決定年月From")
    private FlexibleYearMonth kokuhoreKeteiymFrom;
    @BatchParameter(key = KEY_KOKUHORE_KETEIYM_TO, name = "国保連決定年月To")
    private FlexibleYearMonth kokuhoreKeteiymTo;
    @BatchParameter(key = KEY_TAISHOSHA_UKETORIYM_FROM, name = "対象者受取年月From")
    private FlexibleYearMonth taishoshaUketoriymFrom;
    @BatchParameter(key = KEY_TAISHOSHA_UKETORIYM_TO, name = "対象者受取年月To")
    private FlexibleYearMonth taishoshaUketoriymTo;
    @BatchParameter(key = KEY_KOKUHORE_SOFUYM_FROM, name = "国保連送付年月From")
    private FlexibleYearMonth kokuhoreSofuYMFrom;
    @BatchParameter(key = KEY_KOKUHORE_SOFUYM_TO, name = "国保連送付年月To")
    private FlexibleYearMonth kokuhoreSofuYMTo;
    @BatchParameter(key = KEY_KETEIJOHO_UKETORIYM_FROM, name = "決定情報受取年月From")
    private FlexibleYearMonth keteijohoUketoriymFrom;
    @BatchParameter(key = KEY_KETEIJOHO_UKETORIYM_TO, name = "決定情報受取年月To")
    private FlexibleYearMonth keteijohoUketoriymTo;
    @BatchParameter(key = KEY_SHINSAYM, name = "審査年月")
    private FlexibleYearMonth shinsaYM;
    @BatchParameter(key = KEY_SHUTSURYOKUJU, name = "出力順")
    private Long shutsuryokuju;
    @BatchParameter(key = KEY_SHUTSURYOKU_TOMOKU, name = "出力項目")
    private RString shutsuryokuTomoku;
    @BatchParameter(key = KEY_TOMOKUME_FUKA, name = "項目名付加")
    private boolean tomokumeFuka;
    @BatchParameter(key = KEY_REBAN_FUKA, name = "連番付加")
    private boolean rebanFuka;
    @BatchParameter(key = KEY_HIZUKE_HESHU, name = "日付’／’編集")
    private boolean hizukeHeshu;
    @BatchParameter(key = KEY_REAMS_LOGIN_ID, name = "reamsLoginId")
    private RString reamsLoginId;

    /**
     * 汎用リスト_高額介護サービス費状況のProcessParamterパラメータ作成です。
     *
     * @return 汎用リスト_高額介護サービス費状況のProcessParamterパラメータ
     */
    public HanyoListKogakuKaigoProcessParameter toProcessParamter() {
        return new HanyoListKogakuKaigoProcessParameter(
                modo,
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
                kiyuKikanName,
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
                shinsaYM,
                shutsuryokuju,
                shutsuryokuTomoku,
                tomokumeFuka,
                rebanFuka,
                hizukeHeshu,
                null,
                null,
                null,
                reamsLoginId);
    }
}

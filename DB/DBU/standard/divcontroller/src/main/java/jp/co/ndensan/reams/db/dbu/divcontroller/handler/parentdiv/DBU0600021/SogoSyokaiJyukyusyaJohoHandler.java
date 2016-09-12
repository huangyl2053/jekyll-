/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0600021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboJigyoTaishosha;
import jp.co.ndensan.reams.db.dbd.business.core.basic.KaigoHokenFutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShakaiFukushiHojinRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.hyojunfutangakugemmen.HyojunFutangakuGemmen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.homonkaigogemmen.HobetsuKubun;
import jp.co.ndensan.reams.db.dbu.business.core.jyukyusyajoho.JukyuNinteiJohoBusiness;
import jp.co.ndensan.reams.db.dbu.business.core.jyukyusyajoho.JukyuShinseiJohoBusiness;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600021.SogoSyokaiJyukyusyaJohoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyusochisha.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 総合照会_受給者情報のhandlerクラスです。
 *
 * @reamsid_L DBU-4100-030 xuyannan
 */
public class SogoSyokaiJyukyusyaJohoHandler {

    private static final int INDEX = 1;
    private static final RString 認定先頭1桁CODE = new RString("0");
    private static final RString 職権取消先頭1桁CODE = new RString("1");
    private static final RString 取得先頭1桁CODE = new RString("2");
    private static final RString 却下先頭1桁CODE = new RString("3");
    private static final RString 申請取消先頭1桁CODE = new RString("4");
    private static final RString 特殊無効先頭1桁CODE = new RString("9");
    private static final RString 認定内容 = new RString("認定");
    private static final RString 職権取消内容 = new RString("職権取消");
    private static final RString 取得内容 = new RString("取得");
    private static final RString 却下内容 = new RString("却下");
    private static final RString 申請取消内容 = new RString("申請取消");
    private static final RString 特殊無効内容 = new RString("特殊無効");
    private static final RString パーセント記号 = new RString("%");
    private static final RString EMPTY = new RString("0");
    private static final RString 旧措置者 = new RString("1");
    private static final RString 通常者 = new RString("2");
    private final SogoSyokaiJyukyusyaJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 受給者情報div
     */
    public SogoSyokaiJyukyusyaJohoHandler(SogoSyokaiJyukyusyaJohoDiv div) {
        this.div = div;
    }

    /**
     * 要介護認定情報を表示します。
     *
     * @param business 要介護認定情報
     */
    public void set要介護認定情報エリア(JukyuNinteiJohoBusiness business) {
        if (business == null) {
            return;
        }
        YokaigoJotaiKubunSupport.toValue(new FlexibleDate(business.get認定年月日()), business.get要介護認定状態区分コード());
        div.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoDo().setValue(
                YokaigoJotaiKubunSupport.toValue(
                        new FlexibleDate(business.get認定年月日()), business.get要介護認定状態区分コード()).getName());
        if (business.get認定有効期間開始年月日() != null) {
            div.getJyukyusyaJoho().getYokaigoNinteJoho().getNinteiYukoFromYYMMDD().setValue(
                    new RDate(business.get認定有効期間開始年月日().toString()));
        }
        if (business.get受給申請年月日() != null) {
            div.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoNinteJohoSinseiYYMMDD().setValue(
                    new RDate(business.get受給申請年月日().toString()));
        }
        div.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoNinteJohoSinseiSyubetu().setValue(
                JukyuShinseiJiyu.toValue(business.get受給申請事由()).get名称());
        div.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoNinteJohoSinseiKubunT().setValue(
                NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分_申請時コード()).get名称());
        if (business.is旧措置者フラグ()) {
            List<RString> list = new ArrayList<>();
            list.add(new RString("key0"));
            div.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoNinteJohoKyuSoti().setSelectedItemsByKey(list);
        }
        if (business.get認定有効期間終了年月日() != null) {
            div.getJyukyusyaJoho().getYokaigoNinteJoho().getNinteiYukoEndYYMMDD().setValue(
                    new RDate(business.get認定有効期間終了年月日().toString()));
        }
        if (business.get認定年月日() != null) {
            div.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoNinteJohoNinteiYYMMDD().setValue(
                    new RDate(business.get認定年月日().toString()));
        }
        RString 状態;
        if (RString.isNullOrEmpty(business.getデータ区分())) {
            状態 = RString.EMPTY;
        } else {
            if (認定先頭1桁CODE.equals(business.getデータ区分().substring(0, INDEX))) {
                状態 = 認定内容;
            } else if (職権取消先頭1桁CODE.equals(business.getデータ区分().substring(0, INDEX))) {
                状態 = 職権取消内容;
            } else if (取得先頭1桁CODE.equals(business.getデータ区分().substring(0, INDEX))) {
                状態 = 取得内容;
            } else if (却下先頭1桁CODE.equals(business.getデータ区分().substring(0, INDEX))) {
                状態 = 却下内容;
            } else if (申請取消先頭1桁CODE.equals(business.getデータ区分().substring(0, INDEX))) {
                状態 = 申請取消内容;
            } else if (特殊無効先頭1桁CODE.equals(business.getデータ区分().substring(0, INDEX))) {
                状態 = 特殊無効内容;
            } else {
                状態 = RString.EMPTY;
            }
        }
        div.getJyukyusyaJoho().getYokaigoNinteJoho().getJyotai().setValue(状態);
        div.getJyukyusyaJoho().getYokaigoNinteJoho().getYokaigoNinteJohoSinseiKubunHourei().setValue(
                NinteiShinseiHoreiCode.toValue(business.get認定申請区分_法令コード()).get名称());
    }

    /**
     * 申請情報を表示します。
     *
     * @param business 申請情報
     */
    public void set申請情報エリア(JukyuShinseiJohoBusiness business) {
        if (business == null) {
            return;
        }
        if (business.get受給申請年月日() != null) {
            div.getJyukyusyaJoho().getNinteSinseJoho().getNinteSinseJohoSinseiYYMMDD().setValue(
                    new RDate(business.get受給申請年月日().toString()));
        }
        if (business.get受給申請事由() != null) {
            div.getJyukyusyaJoho().getNinteSinseJoho().getNinteSinseJohoSinseiSyubetu().setValue(
                    JukyuShinseiJiyu.toValue(business.get受給申請事由()).get名称());
        }
        if (business.get認定申請区分_申請時コード() != null) {
            div.getJyukyusyaJoho().getNinteSinseJoho().getNinteSinseJohoSinseiKubunT().setValue(
                    NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分_申請時コード()).get名称());
        }
    }

    /**
     * 各種減免情報を表示します。
     *
     * @param 負担限度額認定 負担限度額認定
     * @param 利用者負担額減額 利用者負担額減額
     * @param 訪問介護利用者負担額減額 訪問介護利用者負担額減額
     * @param 社会福祉法人等利用者負担軽減 社会福祉法人等利用者負担軽減
     * @param 特別地域加算減免 特別地域加算減免
     * @param 標準負担額減免 標準負担額減免
     */
    public void set各種減免情報(
            KaigoHokenFutanGendogakuNintei 負担限度額認定,
            RiyoshaFutangakuGengaku 利用者負担額減額,
            HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額,
            ShakaiFukushiHojinRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減,
            TokubetsuchiikiKasanGemmen 特別地域加算減免,
            HyojunFutangakuGemmen 標準負担額減免) {
        if (負担限度額認定 != null) {
            div.getJyukyusyaJoho().getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubun().setValue(
                    codeToName(負担限度額認定.get決定区分()));
            if (旧措置者.equals(負担限度額認定.get旧措置者区分())) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunKyusoti().setValue(
                        KyusochishaKubun.toValue(true).get名称());
            } else if (通常者.equals(負担限度額認定.get旧措置者区分())) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunKyusoti().setValue(
                        KyusochishaKubun.toValue(false).get名称());
            }
            if (負担限度額認定.get利用者負担段階() != null && !EMPTY.equals(負担限度額認定.get決定区分())) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunHutanDankai().setValue(
                        RiyoshaFutanDankai.toValue(負担限度額認定.get利用者負担段階()).get名称());
            }
            if (負担限度額認定.get適用開始年月日() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunTekiyoYYMMDD().setValue(
                        new RDate(負担限度額認定.get適用開始年月日().toString()));
            }
            if (負担限度額認定.get適用終了年月日() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getHutanGendoGakuNinteiKeteKubunYukouKigen().setValue(
                        new RDate(負担限度額認定.get適用終了年月日().toString()));
            }
        }
        if (利用者負担額減額 != null) {
            div.getJyukyusyaJoho().getKakushuGenmenJoho().getRiyosyaHutanDankaiKeteKubun().setValue(
                    codeToName(利用者負担額減額.get決定区分()));
            div.getJyukyusyaJoho().getKakushuGenmenJoho().getRiyosyaHutanDankaiKyuhuRitu().setValue(
                    パーセント記号を付ける(利用者負担額減額.get給付率().value(), 利用者負担額減額.get決定区分()));
            if (利用者負担額減額.get適用開始年月日() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getRiyosyaHutanDankaiTekiyoYYMMDD().setValue(
                        new RDate(利用者負担額減額.get適用開始年月日().toString()));
            }
            if (利用者負担額減額.get適用終了年月日() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getRiyosyaHutanDankaiYukouKigen().setValue(
                        new RDate(利用者負担額減額.get適用終了年月日().toString()));
            }
        }
        if (訪問介護利用者負担額減額 != null) {
            div.getJyukyusyaJoho().getKakushuGenmenJoho().getHomonKaigRiyosyaHutanKeteKubun().setValue(
                    codeToName(訪問介護利用者負担額減額.get決定区分()));
            if (訪問介護利用者負担額減額.get法別区分() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getHomonKaigRiyosyaHutanSyurui().setValue(
                        HobetsuKubun.toValue(訪問介護利用者負担額減額.get法別区分()).get名称());
            }
            div.getJyukyusyaJoho().getKakushuGenmenJoho().getHomonKaigRiyosyaHutanKyuhuRitu().setValue(
                    パーセント記号を付ける(訪問介護利用者負担額減額.get給付率().value(), 訪問介護利用者負担額減額.get決定区分()));
            if (訪問介護利用者負担額減額.get適用開始年月日() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getHomonKaigRiyosyaHutanTekiyoYYMMDD().setValue(
                        new RDate(訪問介護利用者負担額減額.get適用開始年月日().toString()));
            }
            if (訪問介護利用者負担額減額.get適用終了年月日() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getHomonKaigRiyosyaHutanYukouKigen().setValue(
                        new RDate(訪問介護利用者負担額減額.get適用終了年月日().toString()));
            }
        }
        setOther減免情報(社会福祉法人等利用者負担軽減, 特別地域加算減免, 標準負担額減免);
    }

    /**
     * 給付制限情報を表示します。
     *
     * @param 支払方法変更 支払方法変更
     * @param 給付額減額 給付額減額
     */
    public void set給付制限情報エリア(ShiharaiHohoHenko 支払方法変更, ShiharaiHohoHenko 給付額減額) {
        if (支払方法変更 != null) {
            div.getJyukyusyaJoho().getKyuhuSeigenJoho().getShiharaiHohoTorokuKubun().setValue(
                    ShiharaiHenkoTorokuKubun.toValue(支払方法変更.get登録区分()).get名称());
            if (支払方法変更.get適用開始年月日() != null) {
                div.getJyukyusyaJoho().getKyuhuSeigenJoho().getShiharaiHohoFromYYMMDD().setValue(
                        new RDate(支払方法変更.get適用開始年月日().toString()));
            }
            if (支払方法変更.get適用終了年月日() != null) {
                div.getJyukyusyaJoho().getKyuhuSeigenJoho().getShiharaiHohoEndYYMMDD().setValue(
                        new RDate(支払方法変更.get適用終了年月日().toString()));
            }
        }
        if (給付額減額 != null) {
            div.getJyukyusyaJoho().getKyuhuSeigenJoho().getKyuhugakuGengakuTorokuKubun().setValue(
                    ShiharaiHenkoTorokuKubun.toValue(給付額減額.get登録区分()).get名称());
            if (給付額減額.get適用開始年月日() != null) {
                div.getJyukyusyaJoho().getKyuhuSeigenJoho().getKyuhugakuGengakuFromYYMMDD().setValue(
                        new RDate(給付額減額.get適用開始年月日().toString()));
            }
            if (給付額減額.get適用終了年月日() != null) {
                div.getJyukyusyaJoho().getKyuhuSeigenJoho().getKyuhugakuGengakuEndYYMMDD().setValue(
                        new RDate(給付額減額.get適用終了年月日().toString()));
            }
        }
    }

    /**
     * 総合事業対象者情報を表示します。
     *
     * @param 経過措置 経過措置
     * @param 総合事業 総合事業
     */
    public void set総合事業対象者情報エリア(NijiYoboJigyoTaishosha 経過措置, SogoJigyoTaishosha 総合事業) {
        if (経過措置 != null) {
            if (経過措置.get適用開始年月日() != null) {
                div.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().getKeikaSotiTekiyoFromYYMMDD().setValue(
                        new RDate(経過措置.get適用開始年月日().toString()));
            }
            if (経過措置.get適用終了年月日() != null) {
                div.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().getKeikaSotiTekiyoEndYYMMDD().setValue(
                        new RDate(経過措置.get適用終了年月日().toString()));
            }
        }
        if (総合事業 != null) {
            if (総合事業.get適用開始年月日() != null) {
                div.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().getSogoJigyoTekiyoFromYYMMDD().setValue(
                        new RDate(総合事業.get適用開始年月日().toString()));
            }
            if (総合事業.get適用終了年月日() != null) {
                div.getJyukyusyaJoho().getSogoJigyoTaisyosyaJoho().getSogoJigyoTekiyoEndYYMMDD().setValue(
                        new RDate(総合事業.get適用終了年月日().toString()));
            }
        }
    }

    private void setOther減免情報(
            ShakaiFukushiHojinRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減,
            TokubetsuchiikiKasanGemmen 特別地域加算減免,
            HyojunFutangakuGemmen 標準負担額減免) {
        if (社会福祉法人等利用者負担軽減 != null) {
            div.getJyukyusyaJoho().getKakushuGenmenJoho().getSyakaiHukushiHozinKeigenKeteKubun().setValue(
                    codeToName(社会福祉法人等利用者負担軽減.get決定区分()));
            if ((社会福祉法人等利用者負担軽減.get軽減率分子() != null && 社会福祉法人等利用者負担軽減.get軽減率分母() != null)
                    || !EMPTY.equals(社会福祉法人等利用者負担軽減.get決定区分())) {
                RStringBuilder builder = new RStringBuilder();
                builder.append(社会福祉法人等利用者負担軽減.get軽減率分子());
                builder.append("/");
                builder.append(社会福祉法人等利用者負担軽減.get軽減率分母());
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getSyakaiHukushiHozinKeigenKeigenRitu().setValue(builder.toRString());
            }
            if (社会福祉法人等利用者負担軽減.get適用開始年月日() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getSyakaiHukushiHozinKeigenTekiyoYYMMDD().setValue(
                        new RDate(社会福祉法人等利用者負担軽減.get適用開始年月日().toString()));
            }
            if (社会福祉法人等利用者負担軽減.get適用終了年月日() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getSyakaiHukushiHozinKeigenYukouKigen().setValue(
                        new RDate(社会福祉法人等利用者負担軽減.get適用終了年月日().toString()));
            }
        }
        if (特別地域加算減免 != null) {
            div.getJyukyusyaJoho().getKakushuGenmenJoho().getTokubetuTikiKasanGenmenKeteKubun().setValue(
                    codeToName(特別地域加算減免.get決定区分()));
            div.getJyukyusyaJoho().getKakushuGenmenJoho().getTokubetuTikiKasanGenmenKeigenRitu().setValue(
                    パーセント記号を付ける(特別地域加算減免.get減額率().value(), 特別地域加算減免.get決定区分()));
            if (特別地域加算減免.get適用開始年月日() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getTokubetuTikiKasanGenmenTekiyoYYMMDD().setValue(
                        new RDate(特別地域加算減免.get適用開始年月日().toString()));
            }
            if (特別地域加算減免.get適用終了年月日() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getTokubetuTikiKasanGenmenYukouKigen().setValue(
                        new RDate(特別地域加算減免.get適用終了年月日().toString()));
            }
        }
        if (標準負担額減免 != null) {
            div.getJyukyusyaJoho().getKakushuGenmenJoho().getHyojunHutanGenmenKeteKubun().setValue(
                    codeToName(標準負担額減免.get決定区分()));
            if (標準負担額減免.get減額後金額() != null && !EMPTY.equals(標準負担額減免.get決定区分())) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getHyojunHutanGenmenHutanGaku().setValue(
                        new RString(標準負担額減免.get減額後金額().toString()));
            }
            if (標準負担額減免.get適用開始年月日() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getHyojunHutanGenmenTekiyoYYMMDD().setValue(
                        new RDate(標準負担額減免.get適用開始年月日().toString()));
            }
            if (標準負担額減免.get適用終了年月日() != null) {
                div.getJyukyusyaJoho().getKakushuGenmenJoho().getHyojunHutanGenmenYukouKigen().setValue(
                        new RDate(標準負担額減免.get適用終了年月日().toString()));
            }
        }
    }

    private RString codeToName(RString code) {
        if (RString.isNullOrEmpty(code)) {
            return RString.EMPTY;
        }
        return KetteiKubun.toValue(code).get名称();
    }

    private RString パーセント記号を付ける(Decimal data, RString 決定区分) {
        if (data == null || EMPTY.equals(決定区分)) {
            return RString.EMPTY;
        }
        RStringBuilder builder = new RStringBuilder();
        builder.append(data);
        builder.append(パーセント記号);
        return builder.toRString();
    }
}

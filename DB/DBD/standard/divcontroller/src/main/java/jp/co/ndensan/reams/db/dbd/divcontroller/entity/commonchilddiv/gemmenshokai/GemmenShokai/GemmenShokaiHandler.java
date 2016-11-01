/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmenshokai.GemmenShokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbd.business.core.common.NursingCareInformationBusiness;
import jp.co.ndensan.reams.db.dbd.business.core.common.VariousReductionInformation;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenkoSummary;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.homonkaigogemmen.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.service.core.common.GemmenJokyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.ur.urd.business.core.seikatsuhogo.Seikatsuhogo;
import jp.co.ndensan.reams.ur.urd.service.core.seikatsuhogo.SeikatsuhogoManagerFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 【共有子Div】 減免照会ハンドラクラスです。
 *
 * @reamsid_L DBD-4342-010 wangjie2
 */
public class GemmenShokaiHandler {

    private final GemmenShokaiDiv div;
    private final RString 旧措置者 = new RString("旧措置者");
    private final RString 負担割合区分_１ = new RString("1");
    private final RString 負担割合区分_２ = new RString("2");
    private final RString 負担割合区分_１割 = new RString("10");
    private final RString 負担割合区分_２割 = new RString("20");
    private final RString 申請状況_申請中 = new RString("申請中");
    private final RString 申請状況_申請完了 = new RString("申請完了");

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】 減免照会Div
     */
    public GemmenShokaiHandler(GemmenShokaiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void onLoad(HihokenshaNo 被保険者番号) {
        onLoad要介護認定情報(被保険者番号);
        onLoad申請中情報(被保険者番号);
        onLoad各種減免情報(被保険者番号);
        onLoad老齢_生保情報(被保険者番号);
        onLoad給付制限情報(被保険者番号);
        onLoad利用者負担割合情報(被保険者番号);
    }

    private void onLoad利用者負担割合情報(HihokenshaNo 被保険者番号) {
        GemmenJokyoFinder finder = GemmenJokyoFinder.createIntance();
        List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細List = finder.find利用者負担割合明細(被保険者番号);
        if (!利用者負担割合明細List.isEmpty()) {
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = 利用者負担割合明細List.get(0);
            if (負担割合区分_１割.equals(利用者負担割合明細.get負担割合区分())) {
                div.getTxtFutanWariai().setValue(負担割合区分_１);
            } else if (負担割合区分_２割.equals(利用者負担割合明細.get負担割合区分())) {
                div.getTxtFutanWariai().setValue(負担割合区分_２);
            } else {
                div.getTxtFutanWariai().setValue(RString.EMPTY);
            }
            div.getTxtFutanWariaiKaishiYMD().setValue(利用者負担割合明細.get有効開始日());
            div.getTxtFutanWariaiShuryoYMD().setValue(利用者負担割合明細.get有効終了日());
        } else {
            div.getTxtFutanWariai().setValue(RString.EMPTY);
        }
    }

    private void onLoad給付制限情報(HihokenshaNo 被保険者番号) {
        GemmenJokyoFinder finder = GemmenJokyoFinder.createIntance();
        ShiharaiHohoHenkoSummary 支払方法変更情報 = finder.find支払方法変更情報(被保険者番号);
        div.getTxtShiharaiHohoHenkoTorokuKubun().setValue(支払方法変更情報.get支払方法変更_登録区分().get名称());
        div.getTxtShiharaiHohoHenkoKaishiYMD().setValue(支払方法変更情報.get支払方法変更_開始日());
        div.getTxtShiharaiHohoHenkoShuryoYMD().setValue(支払方法変更情報.get支払方法変更_終了日());
        div.getTxtKyufuGakuGengakuTorokuKubun().setValue(支払方法変更情報.get給付額減額_登録区分().get名称());
        div.getTxtKyufuGakuGengakuKaishiYMD().setValue(支払方法変更情報.get給付額減額_開始日());
        div.getTxtKyufuGakuGengakuShuryoYMD().setValue(支払方法変更情報.get給付額減額_終了日());
    }

    private void onLoad老齢_生保情報(HihokenshaNo 被保険者番号) {
        GemmenJokyoFinder finder = GemmenJokyoFinder.createIntance();
        ShikibetsuCode 識別コード = finder.get識別コード(被保険者番号);
        List<RoreiFukushiNenkinJukyusha> 老齢年金情報List = finder.find老齢年金情報(識別コード);
        if (!老齢年金情報List.isEmpty()) {
            RoreiFukushiNenkinJukyusha 老齢年金情報 = 老齢年金情報List.get(0);
            div.getTxtRoreiJukyuKaishiYMD().setValue(老齢年金情報.get受給開始年月日());
            div.getTxtRoreiJukyuShuryoYMD().setValue(老齢年金情報.get受給終了年月日());
        }
        Seikatsuhogo seikatsuhogo = SeikatsuhogoManagerFactory.createInstance().get生活保護(
                識別コード, GyomuCode.DB介護保険, new FlexibleDate(RDate.getNowDate().toDateString()));
        if (seikatsuhogo != null) {
            div.getTxtSeihoJukyuKaishiYMD().setValue(seikatsuhogo.get受給開始日());
            div.getTxtSeihoJukyuHaishiYMD().setValue(seikatsuhogo.get受給廃止日());
            if (!seikatsuhogo.create扶助種類リスト().isEmpty()) {
                div.getTxtSeihoShubetsu().setValue(seikatsuhogo.create扶助種類リスト().get(0).get扶助種類().getRyakusho());
            }
        }
    }

    private void onLoad各種減免情報(HihokenshaNo 被保険者番号) {
        GemmenJokyoFinder finder = GemmenJokyoFinder.createIntance();
        VariousReductionInformation 各種減免情報 = finder.find減免情報(被保険者番号);
        List<FutanGendogakuNintei> 介護保険負担限度額認定の情報List = 各種減免情報.get介護保険負担限度額認定の情報List();
        List<RiyoshaFutangakuGengaku> 利用者負担額減額の情報List = 各種減免情報.get利用者負担額減額の情報List();
        List<HomonKaigoRiyoshaFutangakuGengaku> 訪問介護利用者負担額減額の情報List = 各種減免情報.get訪問介護利用者負担額減額の情報List();
        List<ShakaifukuRiyoshaFutanKeigen> 社会福祉法人等利用者負担軽減の情報List = 各種減免情報.get社会福祉法人等利用者負担軽減の情報List();
        List<TokubetsuchiikiKasanGemmen> 特別地域加算減免の情報List = 各種減免情報.get特別地域加算減免の情報List();
        onLoad特定入所者(介護保険負担限度額認定の情報List);
        onLoad利用者負担(利用者負担額減額の情報List);
        onLoad特別対策(訪問介護利用者負担額減額の情報List);
        onLoad社会福祉法人(社会福祉法人等利用者負担軽減の情報List);
        onLoad特別地域加算(特別地域加算減免の情報List);
    }

    private void onLoad特別対策(List<HomonKaigoRiyoshaFutangakuGengaku> 訪問介護利用者負担額減額の情報List) {
        if (!訪問介護利用者負担額減額の情報List.isEmpty()) {
            HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額の情報 = 訪問介護利用者負担額減額の情報List.get(0);
            RString 決定区分 = 訪問介護利用者負担額減額の情報.get決定区分();
            if (決定区分 != null && !決定区分.isEmpty()) {
                div.getTxtHomonKaigoKetteiKubun().setValue(KetteiKubun.toValue(決定区分).get名称());
            }
            div.getTxtHomonKaigoKaishiYMD().setValue(訪問介護利用者負担額減額の情報.get適用開始年月日());
            div.getTxtHomonKaigoShuryoYMD().setValue(訪問介護利用者負担額減額の情報.get適用終了年月日());
            HokenKyufuRitsu 給付率 = 訪問介護利用者負担額減額の情報.get給付率();
            if (給付率 != null) {
                div.getTxtHomonKaigoKyufuRitsu().setValue(new RString(給付率.getColumnValue().toString()));
            }
            div.getTxtHomonKaigoBango().setValue(訪問介護利用者負担額減額の情報.get公費受給者番号());
            RString 法別区分 = 訪問介護利用者負担額減額の情報.get法別区分();
            if (法別区分 != null && !法別区分.isEmpty()) {
                div.getTxtHomonKaigoHobetsuKubun().setValue(HobetsuKubun.toValue(法別区分).get名称());
            }
        }
    }

    private void onLoad特別地域加算(List<TokubetsuchiikiKasanGemmen> 特別地域加算減免の情報List) {
        if (!特別地域加算減免の情報List.isEmpty()) {
            TokubetsuchiikiKasanGemmen 特別地域加算減免の情報 = 特別地域加算減免の情報List.get(0);
            RString 決定区分 = 特別地域加算減免の情報.get決定区分();
            if (決定区分 != null && !決定区分.isEmpty()) {
                div.getTxtTokubetsuChiikiKasanKetteiKubun().setValue(KetteiKubun.toValue(決定区分).get名称());
            }
            div.getTxtTokubetsuChiikiKasanKaishiYMD().setValue(特別地域加算減免の情報.get適用開始年月日());
            div.getTxtTokubetsuChiikiKasanShuryoYMD().setValue(特別地域加算減免の情報.get適用終了年月日());
            HokenKyufuRitsu 減額率 = 特別地域加算減免の情報.get減額率();
            if (減額率 != null) {
                div.getTxtTokubetsuChiikiKasanKyufuRitsu().setValue(new RString(特別地域加算減免の情報.get減額率().getColumnValue().toString()));
            }
            div.getTxtTokubetsuChiikiKasanKetteiKubunBango().setValue(特別地域加算減免の情報.get確認番号());
            div.getTxtTokubetsuChiikiKasanShinseiJokyo().setValue(get申請状況(特別地域加算減免の情報.get決定年月日()));
            div.getTxtTokubetsuChiikiKasanShinseiYMD().setValue(特別地域加算減免の情報.get申請年月日());
        }
    }

    private void onLoad社会福祉法人(List<ShakaifukuRiyoshaFutanKeigen> 社会福祉法人等利用者負担軽減の情報List) {
        if (!社会福祉法人等利用者負担軽減の情報List.isEmpty()) {
            ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減の情報 = 社会福祉法人等利用者負担軽減の情報List.get(0);
            RString 決定区分 = 社会福祉法人等利用者負担軽減の情報.get決定区分();
            if (決定区分 != null && !決定区分.isEmpty()) {
                div.getTxtShaFukuKetteiKubun().setValue(KetteiKubun.toValue(決定区分).get名称());
            }
            div.getTxtShaFukuKaishiYMD().setValue(社会福祉法人等利用者負担軽減の情報.get適用開始年月日());
            div.getTxtShaFukuShuryoYMD().setValue(社会福祉法人等利用者負担軽減の情報.get適用終了年月日());
            if (社会福祉法人等利用者負担軽減の情報.get軽減率_分子() != null
                    && 社会福祉法人等利用者負担軽減の情報.get軽減率_分母() != null) {
                div.getTxtShaFukuKyufuRitsu().setValue(new RString(社会福祉法人等利用者負担軽減の情報.get軽減率_分子()
                        .toString()).concat("/").concat(社会福祉法人等利用者負担軽減の情報.get軽減率_分母().toString()));
            }
            div.getTxtShaFukuBango().setValue(社会福祉法人等利用者負担軽減の情報.get確認番号());
            div.getTxtShaFukuShinseiJokyo().setValue(get申請状況(社会福祉法人等利用者負担軽減の情報.get決定年月日()));
            div.getTxtShaFukuShinseiYMD().setValue(社会福祉法人等利用者負担軽減の情報.get申請年月日());
        }
    }

    private void onLoad利用者負担(List<RiyoshaFutangakuGengaku> 利用者負担額減額の情報List) {
        if (!利用者負担額減額の情報List.isEmpty()) {
            RiyoshaFutangakuGengaku 利用者負担額減額の情報 = 利用者負担額減額の情報List.get(0);
            RString 決定区分 = 利用者負担額減額の情報.get決定区分();
            if (決定区分 != null && !決定区分.isEmpty()) {
                div.getTxtRiyoshaFutanKetteiKubun().setValue(KetteiKubun.toValue(利用者負担額減額の情報.get決定区分()).get名称());
            }
            div.getTxtRiyoshaFutanKaishiYMD().setValue(利用者負担額減額の情報.get適用開始年月日());
            div.getTxtRiyoshaFutanShuryoYMD().setValue(利用者負担額減額の情報.get適用終了年月日());
            if (利用者負担額減額の情報.get給付率() != null) {
                div.getTxtRiyoshaFutanKyufuRitsu().setValue(new RString(利用者負担額減額の情報.get給付率().getColumnValue().toString()));
            }
            div.getTxtRiyoshaFutanShinseiJokyo().setValue(get申請状況(利用者負担額減額の情報.get決定年月日()));
            div.getTxtRiyoshaFutanShinseiYMD().setValue(利用者負担額減額の情報.get申請年月日());
        }
    }

    private void onLoad特定入所者(List<FutanGendogakuNintei> 介護保険負担限度額認定の情報List) {
        if (!介護保険負担限度額認定の情報List.isEmpty()) {
            FutanGendogakuNintei 介護保険負担限度額認定の情報 = 介護保険負担限度額認定の情報List.get(0);
            RString 決定区分 = 介護保険負担限度額認定の情報.get決定区分();
            if (決定区分 != null && !決定区分.isEmpty()) {
                div.getTxtFutanGendoGakuKetteiKubun().setValue(KetteiKubun.toValue(介護保険負担限度額認定の情報.get決定区分()).get名称());
            }
            div.getTxtFutanGendoGakuKaishiYMD().setValue(介護保険負担限度額認定の情報.get適用開始年月日());
            div.getTxtFutanGendoGakuShuryoYMD().setValue(介護保険負担限度額認定の情報.get適用終了年月日());
            div.getTxtRiyoshaFutanDankai().setValue(介護保険負担限度額認定の情報.get利用者負担段階());
            RString 旧措置者区分 = 介護保険負担限度額認定の情報.get旧措置者区分();
            if (旧措置者区分 != null && !旧措置者区分.isEmpty()) {
                div.getTxtFutanGendoGakuKyuSochi().setValue(KyuSochishaKubun.toValue(旧措置者区分).get略称());
            }
            div.getTxtFutanGendoGakuShinseiJokyo().setValue(get申請状況(介護保険負担限度額認定の情報.get決定年月日()));
            div.getTxtFutanGendoGakuShinseiYMD().setValue(介護保険負担限度額認定の情報.get申請年月日());
        }
    }

    private RString get申請状況(FlexibleDate 決定年月日) {
        if (null == 決定年月日 || 決定年月日.isEmpty()) {
            return 申請状況_申請中;
        } else {
            return 申請状況_申請完了;
        }
    }

    private void onLoad申請中情報(HihokenshaNo 被保険者番号) {
        GemmenJokyoFinder finder = GemmenJokyoFinder.createIntance();
        List<JukyushaDaicho> 申請中情報List = finder.find申請中情報(被保険者番号);
        if (!申請中情報List.isEmpty()) {
            JukyushaDaicho 申請中情報 = 申請中情報List.get(0);
            div.getTxtShinseiChuShinseiYmd().setValue(申請中情報.get受給申請年月日());
            div.getTxtShinseiChuShinseiShurui().setValue(JukyuShinseiJiyu.toValue(申請中情報.get申請状況区分()).get名称());
        }
    }

    private void onLoad要介護認定情報(HihokenshaNo 被保険者番号) {
        GemmenJokyoFinder finder = GemmenJokyoFinder.createIntance();
        List<NursingCareInformationBusiness> 要介護認定情報List = finder.find要介護認定情報(被保険者番号);
        if (!要介護認定情報List.isEmpty()) {
            NursingCareInformationBusiness 要介護認定情報 = 要介護認定情報List.get(0);
            div.getTxtYokaigoNinteiJokyo().setValue(要介護認定情報.get申請状況区分().get名称());
            div.getTxtYokaigoNinteiShinseiYmd().setValue(要介護認定情報.get受給申請年月日());
            div.getTxtYokaigoNinteiShinseiShurui().setValue(要介護認定情報.get受給申請事由().get名称());
            div.getTxtYokaigoNinteiKyuSochiKubun().setValue(要介護認定情報.is旧措置者フラグ() ? 旧措置者 : RString.EMPTY);
            div.getTxtYokaigodo().setValue(要介護認定情報.get要介護度().getName());
            div.getTxtYokaigoNinteiKaishiYmd().setValue(要介護認定情報.get認定有効期間開始年月日());
            div.getTxtYokaigoNinteiShuryoYmd().setValue(要介護認定情報.get認定有効期間終了年月日());
            div.getTxtYokaigoNinteiNinteiYmd().setValue(要介護認定情報.get認定年月日());
        }
    }

}

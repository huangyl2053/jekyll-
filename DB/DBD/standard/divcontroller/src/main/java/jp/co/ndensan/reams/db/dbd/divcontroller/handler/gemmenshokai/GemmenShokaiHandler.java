/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.gemmenshokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.business.common.NursingCareInformationBusiness;
import jp.co.ndensan.reams.db.dbd.business.common.ShiharaiHohoHenkoSummaryBusiness;
import jp.co.ndensan.reams.db.dbd.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmenshokai.GemmenShokai.GemmenShokaiDiv;
import jp.co.ndensan.reams.db.dbd.service.common.GemmenJokyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.ur.urd.business.core.seikatsuhogo.Seikatsuhogo;
import jp.co.ndensan.reams.ur.urd.service.core.seikatsuhogo.SeikatsuhogoManagerFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 【共有子Div】 減免照会ハンドラクラスです。
 */
public class GemmenShokaiHandler {

    private final GemmenShokaiDiv div;
    private final GemmenJokyoFinder finder;
    private final RString 旧措置者 = new RString("旧措置者");
    private final RString 負担割合区分_１ = new RString("1");
    private final RString 負担割合区分_２ = new RString("2");
    private final RString 負担割合区分_１割 = new RString("10");
    private final RString 負担割合区分_２割 = new RString("20");

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】 減免照会Div
     */
    public GemmenShokaiHandler(GemmenShokaiDiv div) {
        this.div = div;
        this.finder = GemmenJokyoFinder.createIntance();
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
        List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細List = finder.find利用者負担割合明細(被保険者番号);
        if (!利用者負担割合明細List.isEmpty()) {
            RiyoshaFutanWariaiMeisai 利用者負担割合明細 = 利用者負担割合明細List.get(0);
            if (負担割合区分_１割.equals(利用者負担割合明細.get負担割合区分())) {
                div.getTxtFutanWariai().setValue(負担割合区分_１);
            } else if (負担割合区分_２割.equals(利用者負担割合明細.get負担割合区分())) {
                div.getTxtFutanWariai().setValue(負担割合区分_２);
            }
            div.getTxtFutanWariaiKaishiYMD().setValue(利用者負担割合明細.get有効開始日());
            div.getTxtFutanWariaiShuryoYMD().setValue(利用者負担割合明細.get有効終了日());
        }
    }

    private void onLoad給付制限情報(HihokenshaNo 被保険者番号) {
        ShiharaiHohoHenkoSummaryBusiness 支払方法変更情報 = finder.find支払方法変更情報(被保険者番号);
        div.getTxtShiharaiHohoHenkoTorokuKubun().setValue(支払方法変更情報.get支払方法変更_登録区分().get名称());
        div.getTxtShiharaiHohoHenkoKaishiYMD().setValue(支払方法変更情報.get支払方法変更_開始日());
        div.getTxtShiharaiHohoHenkoShuryoYMD().setValue(支払方法変更情報.get支払方法変更_終了日());
        div.getTxtKyufuGakuGengakuTorokuKubun().setValue(支払方法変更情報.get給付額減額_登録区分().get名称());
        div.getTxtKyufuGakuGengakuKaishiYMD().setValue(支払方法変更情報.get給付額減額_開始日());
        div.getTxtKyufuGakuGengakuShuryoYMD().setValue(支払方法変更情報.get給付額減額_終了日());
    }

    private void onLoad老齢_生保情報(HihokenshaNo 被保険者番号) {
        ShikibetsuCode 識別コード = finder.get識別コード(被保険者番号);
        List<RoreiFukushiNenkinJukyusha> 老齢年金情報List = finder.find老齢年金情報(識別コード);
        if (!老齢年金情報List.isEmpty()) {
            RoreiFukushiNenkinJukyusha 老齢年金情報 = 老齢年金情報List.get(0);
            div.getTxtRoreiJukyuKaishiYMD().setValue(老齢年金情報.get受給開始年月日());
            div.getTxtRoreiJukyuShuryoYMD().setValue(老齢年金情報.get受給終了年月日());
        }
        Seikatsuhogo seikatsuhogo
                = SeikatsuhogoManagerFactory.createInstance().get生活保護(識別コード, GyomuCode.DB介護保険, FlexibleDate.EMPTY);
        if (seikatsuhogo != null) {
            div.getTxtSeihoJukyuKaishiYMD().setValue(seikatsuhogo.get受給開始日());
            div.getTxtSeihoJukyuHaishiYMD().setValue(seikatsuhogo.get受給廃止日());
            if (!seikatsuhogo.create扶助種類リスト().isEmpty()) {
                div.getTxtSeihoShubetsu().setValue(seikatsuhogo.create扶助種類リスト().get(0).get扶助種類().getRyakusho());
            }
        }
    }

    private void onLoad各種減免情報(HihokenshaNo 被保険者番号) {
        //TODO QA #79662
        finder.find減免情報(被保険者番号);
    }

    private void onLoad申請中情報(HihokenshaNo 被保険者番号) {
        List<JukyushaDaicho> 申請中情報List = finder.find申請中情報(被保険者番号);
        if (!申請中情報List.isEmpty()) {
            JukyushaDaicho 申請中情報 = 申請中情報List.get(0);
            div.getTxtShinseiChuShinseiYmd().setValue(申請中情報.get受給申請年月日());
            div.getTxtShinseiChuShinseiShurui().setValue(JukyuShinseiJiyu.toValue(申請中情報.get申請状況区分()).get名称());
        }
    }

    private void onLoad要介護認定情報(HihokenshaNo 被保険者番号) {
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

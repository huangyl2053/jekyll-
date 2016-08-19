/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0610011;

import jp.co.ndensan.reams.db.dbu.business.core.tokeijoho.FukaSummary;
import jp.co.ndensan.reams.db.dbu.business.core.tokeijoho.JukyuSummary;
import jp.co.ndensan.reams.db.dbu.business.core.tokeijoho.ShikakuSummary;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0610011.KijunYMDDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 統計情報照会のHandlerクラスです。
 *
 * @reamsid_L DBU-4120-010 sunhaidi
 */
public class KijunYMDHandler {

    private final KijunYMDDiv div;

    /**
     * コンストラクタ。
     *
     * @param div KijunYMDDiv
     */
    public KijunYMDHandler(KijunYMDDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 市町村情報 ShichosonSecurityJoho
     */
    public void onLoad(ShichosonSecurityJoho 市町村情報) {
        div.getTxtKijunYMD().setValue(RDate.getNowDate());
        if (DonyuKeitaiCode.事務広域.getCode().equals(市町村情報.get導入形態コード().value())) {
            div.getCcdCitySelect().loadHokenshaList(GyomuBunrui.介護事務);
        } else {
            div.getCcdCitySelect().setDisplayNone(true);
            div.getCcdCitySelect().setVisible(true);
        }
    }

    /**
     *
     * @param shikakuSummary 資格人数サマリー
     * @param fukaSummary 賦課人数サマリー
     * @param jukyuSummary 受給人数サマリー
     */
    public void setData(ShikakuSummary shikakuSummary,
            FukaSummary fukaSummary,
            JukyuSummary jukyuSummary) {

        div.getTxtShikaku1().setValue(new Decimal(shikakuSummary.get資格人数()));
        div.getTxtJutoku1().setValue(new Decimal(shikakuSummary.get資格人数_内住所地特例者()));
        div.getTxtShikaku2().setValue(new Decimal(shikakuSummary.get一号被保険者人数()));
        div.getTxtJutoku2().setValue(new Decimal(shikakuSummary.get一号被保険者人数_内住所地特例者()));
        div.getTxtShikaku3().setValue(new Decimal(shikakuSummary.get二号被保険者人数()));
        div.getTxtJutoku3().setValue(new Decimal(shikakuSummary.get二号被保険者人数_内住所地特例者()));
        div.getTxtJogai().setValue(new Decimal(shikakuSummary.get適用除外者()));
        div.getTxtTatoku().setValue(new Decimal(shikakuSummary.get他住所地特例者()));

        div.getTxtJukyu1().setValue(new Decimal(jukyuSummary.get受給人数()));
        div.getTxtJukyu2().setValue(new Decimal(jukyuSummary.get要介護１人数()));
        div.getTxtJukyu3().setValue(new Decimal(jukyuSummary.get要介護２人数()));
        div.getTxtJukyu4().setValue(new Decimal(jukyuSummary.get要介護３人数()));
        div.getTxtJukyu5().setValue(new Decimal(jukyuSummary.get要介護４人数()));
        div.getTxtJukyu6().setValue(new Decimal(jukyuSummary.get要介護５人数()));
        div.getTxtJukyu7().setValue(new Decimal(jukyuSummary.get要支援１人数()));
        div.getTxtJukyu8().setValue(new Decimal(jukyuSummary.get要支援２人数()));
        div.getTxtJukyu9().setValue(new Decimal(jukyuSummary.get経過的要介護人数()));
        div.getTxtJukyu10().setValue(new Decimal(jukyuSummary.get自立人数()));

        div.getTxtFuka1().setValue(new Decimal(fukaSummary.get賦課人数()));
        div.getTxtFuka2().setValue(new Decimal(fukaSummary.get特別徴収人数_社保庁()));
        div.getTxtFuka3().setValue(new Decimal(fukaSummary.get特別徴収人数_地共済()));
        div.getTxtFuka4().setValue(new Decimal(fukaSummary.get普通徴収人数()));
    }
}

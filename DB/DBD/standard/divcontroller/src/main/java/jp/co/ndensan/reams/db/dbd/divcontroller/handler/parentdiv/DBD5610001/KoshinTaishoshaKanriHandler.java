/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5610001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5610001.KoshinTaishoshaKanriParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5610001.KoshinTaishoshaKanriDiv;
import jp.co.ndensan.reams.db.dbd.service.core.basic.shoridatekanri.ShoriDateKanriService;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更新申請対象者管理リスト作成画面のHandlerクラスです。
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
public class KoshinTaishoshaKanriHandler {

    private final KoshinTaishoshaKanriDiv div;

    /**
     *
     * @param div KoshinTaishoshaKanriDiv
     */
    public KoshinTaishoshaKanriHandler(KoshinTaishoshaKanriDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonSecurityJoho != null) {
            LasdecCode 市町村コード = shichosonSecurityJoho.get市町村情報().get市町村コード();
            ShoriDateKanriService shoriDateKanriService = ShoriDateKanriService.createInstance();
            ShoriDateKanri shoriDateKanri = shoriDateKanriService.getDbT7022ShoriDateKanriEntity(市町村コード);
            if (shoriDateKanri != null) {
                div.getZenkaiJoho().getTxtZenkaiShoriDate().setValue(shoriDateKanri.get基準日時().getDate());
                div.getZenkaiJoho().getTxtZenkaiShoriYukokikan().setValue(shoriDateKanri.get対象終了日時().getDate());

            } else {

                div.getZenkaiJoho().getTxtZenkaiShoriDate().clearValue();
                div.getZenkaiJoho().getTxtZenkaiShoriYukokikan().clearValue();

            }
        } else {
            div.getZenkaiJoho().getTxtZenkaiShoriDate().clearValue();
            div.getZenkaiJoho().getTxtZenkaiShoriYukokikan().clearValue();

        }
    }

    /**
     * 画面側からバッチパラメータを取得します。
     *
     * @return KoshinTaishoshaKanriParameter KoshinTaishoshaKanriParameter
     */
    public KoshinTaishoshaKanriParameter getParameter() {
        KoshinTaishoshaKanriParameter parameter = new KoshinTaishoshaKanriParameter();
        if (div.getZenkaiJoho().getTxtTaishoTsuki().getValue() != null) {
            parameter.set対象月(new FlexibleDate(div.getZenkaiJoho().getTxtTaishoTsuki().getValue().toDateString()).getYearMonth());

        } else {
            parameter.set対象月(FlexibleYearMonth.EMPTY);
        }
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        LasdecCode 市町村コード = shichosonSecurityJoho.get市町村情報().get市町村コード();
        ShoriDateKanriService shoriDateKanriService = ShoriDateKanriService.createInstance();
        ShoriDateKanri shoriDateKanri = shoriDateKanriService.getDbT7022ShoriDateKanriEntity(市町村コード);
        parameter.set市町村コード(市町村コード);
        if (shoriDateKanri != null) {
            parameter.set年度(shoriDateKanri.get年度());
            parameter.set年度内連番(shoriDateKanri.get年度内連番());
        } else {
            parameter.set年度(FlexibleYear.EMPTY);
            parameter.set年度内連番(RString.EMPTY);
        }
        parameter.set条件指定(div.getSelectJoken().getRadDataSelect().getSelectedValue());
        if (div.getYukoKikanSelect().getTxtYukokikanSelect().getFromValue() != null) {
            parameter.set有効期間終了日From(new FlexibleDate(div.getYukoKikanSelect().getTxtYukokikanSelect().getFromValue().toString()));
        } else {
            parameter.set有効期間終了日From(FlexibleDate.EMPTY);
        }
        if (div.getYukoKikanSelect().getTxtYukokikanSelect().getToValue() != null) {
            parameter.set有効期間終了日To(new FlexibleDate(div.getYukoKikanSelect().getTxtYukokikanSelect().getToValue().toString()));
        } else {
            parameter.set有効期間終了日To(FlexibleDate.EMPTY);
        }
        return parameter;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ninteishinseitodokedesha;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.dbt4101ninteishinseijoho.DbT4101NinteiShinseiJohoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.dbt4120shinseitodokedejoho.DbT4120ShinseitodokedeJohoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.dbt4121shinseirirekijoho.DbT4121ShinseiRirekiJohoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.shisetujyoho.KaigoJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteishinseitodokedesha.NinteiShinseiTodokedeshaMybatisParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.service.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定申請届出者のDivControllerです。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
public class NinteiShinseiTodokedesha {

    private static final RString 管内 = new RString("key0");
    private static final RString 管外 = new RString("key1");

    /**
     * 認定区分radがonChangeです。
     *
     * @param div NinteiShinseiTodokedeshaDiv
     * @return NinteiShinseiTodokedeshaDivのResponseData
     */
    public ResponseData<NinteiShinseiTodokedeshaDiv> onChangeDdlTodokedeDaikoKubun(NinteiShinseiTodokedeshaDiv div) {
        if (div.getMode_ShoriType() != null && new RString("InputMode").equals(new RString(div.getMode_ShoriType().toString()))) {
            setInput(div);
        }
        if (ShinseiTodokedeDaikoKubunCode.本人.getCode().equals(div.getDdlTodokledeDaikoKubun().getSelectedKey())) {
            div.getTxtShimei().setValue(div.getHdnShimei());
            div.getTxtKanaShimei().setValue(div.getHdnKanaShimei());
            div.getTxtHonninKankeisei().setValue(div.getHdnTsudukigara());
            if (管内.equals(div.getRadKannaiKangai().getSelectedKey())) {
                div.getTxtYubinNo().setValue(new YubinNo(div.getHdnYubinNo()));
                div.getCcdChoikiInput().load(ChoikiCode.EMPTY, div.getHdnJusho());
            } else if (管外.equals(div.getRadKannaiKangai().getSelectedKey())) {
                div.getCcdZenkokuJushoInput().load(ZenkokuJushoCode.EMPTY, div.getHdnJusho(), new YubinNo(div.getHdnYubinNo()));
            }
            div.getTxtTelNo().setDomain(new TelNo(div.getHdnTelNo()));
        } else if (ShinseiTodokedeDaikoKubunCode.家族.getCode().equals(div.getDdlTodokledeDaikoKubun().getSelectedKey())) {
            div.getBtnSetaiIchiran().setDisabled(false);
        } else if (ShinseiTodokedeDaikoKubunCode.委任.getCode().equals(div.getDdlTodokledeDaikoKubun().getSelectedKey())) {
            div.getBtnAtenaKensaku().setDisabled(false);
        } else if (ShinseiTodokedeDaikoKubunCode.代行.getCode().equals(div.getDdlTodokledeDaikoKubun().getSelectedKey())) {
            div.getTxtJigyoshaCode().setReadOnly(false);
            div.getBtnJigyoshaGuide().setDisabled(false);
            div.getDdlShinseiKankeisha().setReadOnly(false);
        } else {
            setその他(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 前回を複写するです。
     *
     * @param div NinteiShinseiTodokedeshaDiv
     * @return NinteiShinseiTodokedeshaDivのResponseData
     */
    public ResponseData<NinteiShinseiTodokedeshaDiv> onClickBtnZenkaiFukusha(NinteiShinseiTodokedeshaDiv div) {
        NinteiShinseiTodokedeshaFinder finder = NinteiShinseiTodokedeshaFinder.createInstance();
        DbT4121ShinseiRirekiJohoBusiness dbt4121 = finder.get申請履歴情報(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        if (dbt4121 != null) {
            DbT4101NinteiShinseiJohoBusiness dbt4101 = finder.get要介護認定申請情報受給(dbt4121.get前回申請管理番号());
            if (dbt4101 != null) {
                DbT4120ShinseitodokedeJohoBusiness dbt4120 = finder.get申請届出情報(dbt4101.get申請書管理番号());
                set前回内容(dbt4120, div);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 世帯一覧btnを押下しです。
     *
     * @param div NinteiShinseiTodokedeshaDiv
     * @return NinteiShinseiTodokedeshaDivのResponseData
     */
    public ResponseData<NinteiShinseiTodokedeshaDiv> onOkClose_seitai(NinteiShinseiTodokedeshaDiv div) {
        div.getTxtShimei().setValue(div.getHdnShimei());
        div.getTxtKanaShimei().setValue(div.getHdnKanaShimei());
        div.getTxtHonninKankeisei().setValue(div.getHdnTsudukigara());
        return ResponseData.of(div).respond();
    }

    /**
     * 宛名を検索btnを押下しです。
     *
     * @param div NinteiShinseiTodokedeshaDiv
     * @return NinteiShinseiTodokedeshaDivのResponseData
     */
    public ResponseData<NinteiShinseiTodokedeshaDiv> onOkClose_atenKensaku(NinteiShinseiTodokedeshaDiv div) {
        NinteiShinseiTodokedeshaFinder finder = NinteiShinseiTodokedeshaFinder.createInstance();
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        builder.set識別コード(new ShikibetsuCode(div.getHdnShikibetsuCode()));
        NinteiShinseiTodokedeshaBusiness shikibetsutaisyo
                = finder.select宛名データOnly_宛名条件And業務条件(new NinteiShinseiTodokedeshaMybatisParameter(builder.build()));
        if (shikibetsutaisyo != null) {
            AtenaMeisho mesho = shikibetsutaisyo.getPsmEntity().getMeisho();
            div.getTxtShimei().setValue(mesho == null ? RString.EMPTY : mesho.value());
            AtenaKanaMeisho kanameisho = shikibetsutaisyo.getPsmEntity().getKanaMeisho();
            div.getTxtKanaShimei().setValue(kanameisho == null ? RString.EMPTY : kanameisho.value());
            div.getTxtHonninKankeisei().setValue(shikibetsutaisyo.getPsmEntity().getTsuzukigara());
            div.getTxtYubinNo().setValue(shikibetsutaisyo.getPsmEntity().getYubinNo());
            div.getCcdChoikiInput().load(shikibetsutaisyo.getPsmEntity().getChoikiCode());
            div.getCcdZenkokuJushoInput().load(shikibetsutaisyo.getPsmEntity().getZenkokuJushoCode(), shikibetsutaisyo.getPsmEntity().getYubinNo());
            div.getTxtTelNo().setDomain(shikibetsutaisyo.getTelNo());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 管内・管外の変更です。
     *
     * @param div NinteiShinseiTodokedeshaDiv
     * @return NinteiShinseiTodokedeshaDivのResponseData
     */
    public ResponseData<NinteiShinseiTodokedeshaDiv> onChangeChkKannaiKangai(NinteiShinseiTodokedeshaDiv div) {
        if (new RString("key0").equals(div.getRadKannaiKangai().getSelectedKey())) {
            div.setMode_DisplayType(NinteiShinseiTodokedeshaDiv.DisplayType.管内);
        } else {
            div.setMode_DisplayType(NinteiShinseiTodokedeshaDiv.DisplayType.管外);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * LostFocusの処理。
     *
     * @param div NinteiShinseiTodokedeshaDiv
     * @return NinteiShinseiTodokedeshaDivのResponseData
     */
    public ResponseData<NinteiShinseiTodokedeshaDiv> lostFocus(NinteiShinseiTodokedeshaDiv div) {
        if (!RString.isNullOrEmpty(div.getTxtJigyoshaCode().getValue())) {
            NinteiShinseiTodokedeshaFinder finder = NinteiShinseiTodokedeshaFinder.createInstance();
            List<KaigoJigyoshaInputGuide> kaigoList = finder.getKaigoJigyoshaInputGuide(new JigyoshaNo(div.getTxtJigyoshaCode().getValue()),
                    FlexibleDate.getNowDate()).records();
            if (!kaigoList.isEmpty()) {
                div.getTxtJigyoshaName().setValue(kaigoList.get(0).get事業者名称().value());
                return ResponseData.of(div).respond();
            }
        }
        div.getTxtJigyoshaName().setValue(RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 町域入力ccdです。
     *
     * @param div NinteiShinseiTodokedeshaDiv
     * @return NinteiShinseiTodokedeshaDivのResponseData
     */
    public ResponseData<NinteiShinseiTodokedeshaDiv> onOkClose(NinteiShinseiTodokedeshaDiv div) {
        div.getTxtYubinNo().setValue(new YubinNo(div.getCcdChoikiInput().getHidden郵便番号()));
        return ResponseData.of(div).respond();
    }

    private void set前回内容(DbT4120ShinseitodokedeJohoBusiness dbt4120, NinteiShinseiTodokedeshaDiv div) {
        if (dbt4120 != null) {
            div.getTxtJigyoshaCode().setValue(dbt4120.get申請届出代行事業者番号().value());
            div.getTxtHonninKankeisei().setValue(dbt4120.get申請届出者続柄());
            div.getTxtShimei().setValue(dbt4120.get申請届出者氏名());
            div.getTxtKanaShimei().setValue(dbt4120.get申請届出者氏名カナ());
            div.getTxtTelNo().setDomain(dbt4120.get申請届出者電話番号());
            div.getTxtYubinNo().setValue(dbt4120.get申請届出者郵便番号());
            div.getDdlTodokledeDaikoKubun().setSelectedKey(dbt4120.get申請届出代行区分コード().value());
            div.getDdlShinseiKankeisha().setSelectedKey(dbt4120.get事業者区分());
        }
    }

    private void setInput(NinteiShinseiTodokedeshaDiv div) {
        div.getDdlTodokledeDaikoKubun().setReadOnly(false);
        div.getDdlShinseiKankeisha().setReadOnly(true);
        div.getBtnSetaiIchiran().setDisabled(true);
        div.getBtnAtenaKensaku().setDisabled(true);
        div.getBtnZenkaiFukusha().setDisabled(false);
        div.getBtnJigyoshaGuide().setDisabled(true);
        div.getTxtJigyoshaCode().setReadOnly(true);
    }

    private void setその他(NinteiShinseiTodokedeshaDiv div) {
        div.getDdlShinseiKankeisha().setSelectedIndex(0);
        div.getDdlTodokledeDaikoKubun().setSelectedIndex(0);
        div.getTxtHonninKankeisei().clearValue();
        div.getTxtJigyoshaCode().clearValue();
        div.getTxtJigyoshaName().clearValue();
        div.getTxtKanaShimei().clearValue();
        div.getTxtShimei().clearValue();
        div.getTxtTelNo().clearDomain();
        div.getTxtYubinNo().clearValue();
        div.getCcdChoikiInput().clear();
        div.getCcdZenkokuJushoInput().clear();
        div.getBtnAtenaKensaku().setDisabled(true);
        div.getBtnJigyoshaGuide().setDisabled(true);
        div.getBtnSetaiIchiran().setDisabled(true);
        div.getTxtJigyoshaCode().setReadOnly(true);
        div.getDdlShinseiKankeisha().setReadOnly(true);
    }
}

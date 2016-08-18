/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteishinseitodokedesha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaNaiyo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 介護認定申請届出者のHandlerクラスです。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
public class NinteiShinseiTodokedeshaHandler {

    private static final RString 管内 = new RString("key0");
    private static final RString 管外 = new RString("key1");
    private final NinteiShinseiTodokedeshaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定申請届出者
     */
    public NinteiShinseiTodokedeshaHandler(NinteiShinseiTodokedeshaDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param model NinteiShinseiTodokedeshaDataPassModel
     */
    public void initialize(NinteiShinseiTodokedeshaDataPassModel model) {
        div.getTxtHonninKankeisei().clearValue();
        div.getTxtJigyoshaCode().clearValue();
        div.getTxtJigyoshaName().clearValue();
        div.getTxtKanaShimei().clearValue();
        div.getTxtShimei().clearValue();
        div.getTxtTelNo().clearDomain();
        div.getTxtYubinNo().clearValue();
        div.getCcdChoikiInput().clear();
        div.getCcdZenkokuJushoInput().clear();
        List<RString> codeList = new ArrayList<>();
        for (ShinseiTodokedeDaikoKubunCode code : ShinseiTodokedeDaikoKubunCode.values()) {
            codeList.add(code.getCode());
        }
        div.getDdlTodokledeDaikoKubun().setDataSource(setDataSource(codeList, true));
        List<RString> shinseiKankeishaCodeList = new ArrayList<>();
        for (JigyoshaKubun code : JigyoshaKubun.values()) {
            shinseiKankeishaCodeList.add(code.getCode());
        }
        div.getDdlShinseiKankeisha().setDataSource(setDataSource(shinseiKankeishaCodeList, false));
        if ((NinteiShinseiTodokedeshaDiv.ShoriType.ShokaiMode).equals(div.getMode_ShoriType())) {
            div.getTxtJigyoshaCode().setValue(model.get申請届出代行事業者番号());
            div.getTxtHonninKankeisei().setValue(model.get続柄());
            div.getTxtShimei().setValue(model.get氏名());
            div.getTxtKanaShimei().setValue(model.getカナ氏名());
            div.getTxtTelNo().setDomain(new TelNo(model.get電話番号()));
            div.getTxtYubinNo().setValue(new YubinNo(model.get郵便番号()));
            div.getCcdChoikiInput().load(ChoikiCode.EMPTY, model.get住所());
            div.getDdlTodokledeDaikoKubun().setSelectedKey(model.get申請届出代行区分コード());
            div.getDdlShinseiKankeisha().setSelectedKey(model.get事業者区分());
            div.getDdlTodokledeDaikoKubun().setSelectedKey(管内);
        }
        setHidden(model);
        div.setMode_DisplayType(NinteiShinseiTodokedeshaDiv.DisplayType.管内);
    }

    /**
     * 画面一覧内容を取得。
     *
     * @return NinteiShinseiTodokedeshaNaiyo NinteiShinseiTodokedeshaNaiyo
     */
    public NinteiShinseiTodokedeshaNaiyo get一覧内容() {
        NinteiShinseiTodokedeshaNaiyo naiyo = new NinteiShinseiTodokedeshaNaiyo();
        naiyo.set届出代行区分(div.getDdlTodokledeDaikoKubun().getSelectedKey());
        naiyo.set管内管外区分(div.getRadKannaiKangai().getSelectedKey());
        naiyo.set事業者コード(div.getTxtJigyoshaCode().getValue());
        naiyo.set事業者名称(div.getTxtJigyoshaName().getValue());
        naiyo.set申請関係者(div.getDdlShinseiKankeisha().getSelectedKey());
        naiyo.setカナ氏名(div.getTxtKanaShimei().getValue());
        naiyo.set氏名(div.getTxtShimei().getValue());
        naiyo.set本人との関係性(div.getTxtHonninKankeisei().getValue());
        naiyo.set電話番号(div.getTxtTelNo().getDomain().getColumnValue());
        if (管内.equals(div.getRadKannaiKangai().getSelectedKey())) {
            naiyo.set郵便番号(div.getTxtYubinNo().getValue());
            naiyo.set町域入力住所コード(div.getCcdChoikiInput().get町域コード().getColumnValue());
            naiyo.set町域入力住所名称(div.getCcdChoikiInput().get町域名称());
        } else if (管外.equals(div.getRadKannaiKangai().getSelectedKey())) {
            naiyo.set全国郵便番号(div.getCcdZenkokuJushoInput().get郵便番号().value());
            naiyo.set全国住所コード(div.getCcdZenkokuJushoInput().get全国住所コード().getColumnValue());
            naiyo.set全国住所名称(div.getCcdZenkokuJushoInput().get全国住所名称());
        }
        return naiyo;
    }

    private List<KeyValueDataSource> setDataSource(List<RString> codeList, boolean kubun) {
        Collections.sort(codeList);
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KeyValueDataSource data = new KeyValueDataSource();
        data.setKey(RString.EMPTY);
        data.setValue(RString.EMPTY);
        dataSourceList.add(data);
        for (RString code : codeList) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(code);
            if (kubun) {
                keyValue.setValue(new RString(ShinseiTodokedeDaikoKubunCode.toValue(code).name()));
            } else {
                keyValue.setValue(new RString(JigyoshaKubun.toValue(code).name()));
            }
            dataSourceList.add(keyValue);
        }
        return dataSourceList;
    }

    private void setHidden(NinteiShinseiTodokedeshaDataPassModel model) {
        div.setHdnKeyAgeArrivalDay(AgeArrivalDay.当日.code());
        div.setHdnSerchYusenKubun(KensakuYusenKubun.住登内優先.code());
        div.setHdnGyomuCode(GyomuCode.DB介護保険.getColumnValue());
        div.setHdnKeyDialog(new RString("1"));
        div.setHdnShinseishoKanriNo(model.get申請書管理番号());
        div.setHdnShikibetsuCode(model.get識別コード());
        div.setHdnShimei(model.get氏名());
        div.setHdnKanaShimei(model.getカナ氏名());
        div.setHdnTsudukigara(model.get続柄());
        div.setHdnYubinNo(model.get郵便番号());
        div.setHdnJusho(model.get住所());
        div.setHdnTelNo(model.get電話番号());
    }
}

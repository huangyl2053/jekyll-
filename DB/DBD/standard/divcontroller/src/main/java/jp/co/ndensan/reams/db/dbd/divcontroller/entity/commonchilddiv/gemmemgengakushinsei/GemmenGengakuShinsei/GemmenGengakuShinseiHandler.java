/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.ShinseiJoho;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyosha.KaigoJigyoshaManager;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.session.PanelSessionAccessor;

/**
 * 共有子Div「減免減額申請」のHandlerクラスです。
 *
 * @reamsid_L DBD-4341-010 xuyue
 */
public class GemmenGengakuShinseiHandler {

    private final GemmenGengakuShinseiDiv div;
    private static final RString 本人識別コードのキー = new RString("本人識別コード");
    private static final RString 空白KEY = new RString("-1");
    private static final RString 介護保険施設 = new RString("介護保険施設");

    /**
     * コンストラクタです。
     *
     * @param div GemmenGengakuShinseiDiv
     */
    public GemmenGengakuShinseiHandler(GemmenGengakuShinseiDiv div) {
        this.div = div;
    }

    /**
     * 共有子Divを初期化します。
     *
     * @param 本人識別コード 本人識別コード
     */
    public void onLoad(ShikibetsuCode 本人識別コード) {
        PanelSessionAccessor.put(div, 本人識別コードのキー, 本人識別コード);

        div.getDdlShinseiDaikoKubun().setDataSource(getDdlShinseiDaikoKubun());
        div.getDdlShinseiDaikoKubun().setSelectedKey(空白KEY);
        div.getDdlJigyoshaKubun().setDataSource(getDdlJigyoshaKubun());
        div.getDdlJigyoshaKubun().setSelectedKey(空白KEY);
        データクリア();
    }

    /**
     * この共有子Divの対象となる被保険者の識別コードを返却します。
     *
     * @return 被保険者の識別コード
     */
    public ShikibetsuCode get本人識別コード() {
        boolean exists本人識別コード = PanelSessionAccessor.containsKey(div, 本人識別コードのキー);
        if (exists本人識別コード) {
            return PanelSessionAccessor.get(div, 本人識別コードのキー, ShikibetsuCode.class);
        }
        return ShikibetsuCode.EMPTY;
    }

    /**
     * 指定の値を、共有子Divに設定します。<br>
     * 申請日は、事業者情報の検索に用いられます。
     *
     * @param 減免減額申請情報 減免減額申請情報
     * @param 申請日 申請日
     */
    public void set減免減額申請情報(ShinseiJoho 減免減額申請情報, FlexibleDate 申請日) {

        KaigoJigyoshaManager manager = KaigoJigyoshaManager.createInstance();

        KaigoJigyosha kaigoJigyosha = null;
        if (減免減額申請情報.get申請届出代行事業者番号() != null && 申請日 != null) {
            kaigoJigyosha = manager.select介護事業者By申請日(減免減額申請情報.get申請届出代行事業者番号(), 申請日);
        }
        if (kaigoJigyosha != null) {
            div.getCcdShisetsuJoho().setNyuryokuShisetsuKodo(減免減額申請情報.get申請届出代行事業者番号().getColumnValue());
            div.getCcdShisetsuJoho().setShisetsuMeisho(kaigoJigyosha.get事業者名称().getColumnValue());
        } else {
            div.getCcdShisetsuJoho().setNyuryokuShisetsuKodo(RString.EMPTY);
            div.getCcdShisetsuJoho().setShisetsuMeisho(RString.EMPTY);
        }
        div.getDdlJigyoshaKubun().setDataSource(getDdlJigyoshaKubun());
        if (減免減額申請情報.get事業者区分() != null) {
            div.getDdlJigyoshaKubun().setSelectedKey(減免減額申請情報.get事業者区分().getCode());
        } else {
            div.getDdlJigyoshaKubun().setSelectedKey(空白KEY);
        }
        if (減免減額申請情報.get申請届出代行事業者番号() != null && !減免減額申請情報.get申請届出代行事業者番号().isEmpty()) {
            div.getCcdShisetsuJoho().setNyuryokuShisetsuKodo(減免減額申請情報.get申請届出代行事業者番号().getColumnValue());
        } else {
            div.getCcdShisetsuJoho().setNyuryokuShisetsuKodo(RString.EMPTY);
        }
        if (減免減額申請情報.get申請届出代行区分() != null) {
            div.getDdlShinseiDaikoKubun().setSelectedKey(減免減額申請情報.get申請届出代行区分().getCode());
        } else {
            div.getDdlShinseiDaikoKubun().setSelectedKey(空白KEY);
        }
        if (減免減額申請情報.get申請届出者氏名カナ() != null) {
            div.getTxtShinseishaShimeiKana().setValue(減免減額申請情報.get申請届出者氏名カナ().getColumnValue());
        }
        if (減免減額申請情報.get申請届出者氏名() != null) {
            div.getTxtShinseishaShimei().setDomain(減免減額申請情報.get申請届出者氏名());
        }
        if (減免減額申請情報.get申請届出者続柄() != null) {
            div.getTxtShinseishaTsuzukigara().setValue(減免減額申請情報.get申請届出者続柄());
        }
        if (減免減額申請情報.get申請届出者郵便番号() != null) {
            div.getTxtShinseishaYubinNo().setValue(減免減額申請情報.get申請届出者郵便番号());
        }
        if (減免減額申請情報.get申請届出者電話番号() != null) {
            div.getTxtShinseishaTelNo().setDomain(減免減額申請情報.get申請届出者電話番号());
        }
        if (減免減額申請情報.get申請届出者住所() != null) {
            div.getTxtShinseishaJusho().setDomain(減免減額申請情報.get申請届出者住所());
        }
    }

    /**
     * 画面に設定されている値を減免減額情報に設定して返却します。
     *
     * @return 減免減額申請情報
     */
    public ShinseiJoho get減免減額申請情報() {
        ShinseiTodokedeDaikoKubunCode 申請届出代行区分 = null;
        if (!div.getDdlShinseiDaikoKubun().getSelectedKey().isEmpty() && !空白KEY.equals(div.getDdlShinseiDaikoKubun().getSelectedKey())) {
            申請届出代行区分 = ShinseiTodokedeDaikoKubunCode.toValue(div.getDdlShinseiDaikoKubun().getSelectedKey());
        }
        AtenaMeisho 申請届出者氏名 = div.getTxtShinseishaShimei().getDomain();
        AtenaKanaMeisho 申請届出者氏名カナ = new AtenaKanaMeisho(div.getTxtShinseishaShimeiKana().getValue());
        RString 申請届出者続柄 = div.getTxtShinseishaTsuzukigara().getValue();
        JigyoshaNo 申請届出代行事業者番号 = new JigyoshaNo(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
        JigyoshaKubun 事業者区分 = null;
        if (!div.getDdlJigyoshaKubun().getSelectedKey().isEmpty() && !空白KEY.equals(div.getDdlJigyoshaKubun().getSelectedKey())) {
            事業者区分 = JigyoshaKubun.toValue(div.getDdlJigyoshaKubun().getSelectedKey());
        }
        YubinNo 申請届出者郵便番号 = div.getTxtShinseishaYubinNo().getValue();
        AtenaJusho 申請届出者住所 = div.getTxtShinseishaJusho().getDomain();
        TelNo 申請届出者電話番号 = div.getTxtShinseishaTelNo().getDomain();

        return new ShinseiJoho(申請届出代行区分, 申請届出者氏名, 申請届出者氏名カナ, 申請届出者続柄, 申請届出代行事業者番号,
                事業者区分, 申請届出者郵便番号, 申請届出者住所, 申請届出者電話番号);

    }

    private void データクリア() {

        div.getTxtShinseishaShimeiKana().clearValue();
        div.getTxtShinseishaShimei().clearDomain();
        div.getTxtShinseishaTsuzukigara().clearValue();
        div.getTxtShinseishaYubinNo().clearValue();
        div.getTxtShinseishaTelNo().clearDomain();
        div.getTxtShinseishaJusho().clearDomain();
        div.getCcdShisetsuJoho().setNyuryokuShisetsuKodo(RString.EMPTY);
        div.getCcdShisetsuJoho().getTxtNyuryokuShisetsuKodo().setDisabled(true);
        div.getCcdShisetsuJoho().getTxtNyuryokuShisetsuMeisho().setDisabled(true);
        div.getCcdShisetsuJoho().setShisetsuMeisho(RString.EMPTY);
        div.getCcdShisetsuJoho().getRadKaigoHokenShisetsu().setSelectedValue(介護保険施設);
    }

    private List<KeyValueDataSource> getDdlShinseiDaikoKubun() {
        List<KeyValueDataSource> shinseiDaikoKubun = new ArrayList<>();
        shinseiDaikoKubun.add(new KeyValueDataSource(空白KEY, RString.EMPTY));
        for (ShinseiTodokedeDaikoKubunCode code : ShinseiTodokedeDaikoKubunCode.values()) {
            KeyValueDataSource data = new KeyValueDataSource(code.getCode(), code.get名称());
            shinseiDaikoKubun.add(data);
        }
        return shinseiDaikoKubun;
    }

    private List<KeyValueDataSource> getDdlJigyoshaKubun() {
        List<KeyValueDataSource> jigyoshaKubun = new ArrayList<>();
        jigyoshaKubun.add(new KeyValueDataSource(空白KEY, RString.EMPTY));
        for (JigyoshaKubun code : JigyoshaKubun.values()) {
            KeyValueDataSource data = new KeyValueDataSource(code.getCode(), code.get名称());
            jigyoshaKubun.add(data);
        }
        return jigyoshaKubun;
    }

}

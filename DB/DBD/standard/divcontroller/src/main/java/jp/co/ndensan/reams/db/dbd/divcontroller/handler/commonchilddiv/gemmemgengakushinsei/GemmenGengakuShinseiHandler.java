/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.commonchilddiv.gemmemgengakushinsei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.gemmengengaku.ShinseiJoho;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.GemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyosha.KaigoJigyoshaManager;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShinseiTodokedeDaikoKubunCode;
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
 */
public class GemmenGengakuShinseiHandler {

    private final GemmenGengakuShinseiDiv div;
    private static final RString 本人識別コードのキー = new RString("本人識別コード");

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
        div.getDdlJigyoshaKubun().setDataSource(getDdlJigyoshaKubun());
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

        KaigoJigyosha kaigoJigyosha = manager.select介護事業者By申請日(減免減額申請情報.get申請届出代行事業者番号(), 申請日);
        if (kaigoJigyosha != null) {
            div.getTxtJigyoshaCode().setValue(減免減額申請情報.get申請届出代行事業者番号().getColumnValue());
            div.getTxtJigyoshaName().setValue(kaigoJigyosha.get事業者名称().getColumnValue());
        } else {
            div.getTxtJigyoshaCode().clearValue();
            div.getTxtJigyoshaName().clearValue();
        }
        div.getDdlJigyoshaKubun().setDataSource(getDdlJigyoshaKubun());
        if (減免減額申請情報.get申請届出代行区分() != null) {
            div.getDdlShinseiDaikoKubun().setSelectedKey(減免減額申請情報.get申請届出代行区分().getCode());
        }
        if (減免減額申請情報.get申請届出者氏名カナ() != null) {
            div.getTxtShinseishaShimeiKana().setValue(減免減額申請情報.get申請届出者氏名カナ().getColumnValue());
        }
        div.getTxtShinseishaShimei().setDomain(減免減額申請情報.get申請届出者氏名());
        div.getTxtShinseishaTsuzukigara().setValue(減免減額申請情報.get申請届出者続柄());
        div.getTxtShinseishaYubinNo().setValue(減免減額申請情報.get申請届出者郵便番号());
        div.getTxtShinseishaTelNo().setDomain(減免減額申請情報.get申請届出者電話番号());
        div.getTxtShinseishaJusho().setDomain(減免減額申請情報.get申請届出者住所());
    }

    /**
     * 画面に設定されている値を減免減額情報に設定して返却します。
     *
     * @return 減免減額申請情報
     */
    public ShinseiJoho get減免減額申請情報() {
        ShinseiTodokedeDaikoKubunCode 申請届出代行区分 = null;
        if (!div.getDdlShinseiDaikoKubun().getSelectedKey().isEmpty()) {
            申請届出代行区分 = ShinseiTodokedeDaikoKubunCode.toValue(div.getDdlShinseiDaikoKubun().getSelectedKey());
        }
        AtenaMeisho 申請届出者氏名 = div.getTxtShinseishaShimei().getDomain();
        AtenaKanaMeisho 申請届出者氏名カナ = new AtenaKanaMeisho(div.getTxtShinseishaShimeiKana().getValue());
        RString 申請届出者続柄 = div.getTxtShinseishaTsuzukigara().getValue();
        JigyoshaNo 申請届出代行事業者番号 = new JigyoshaNo(div.getTxtJigyoshaCode().getValue());
        JigyoshaKubun 事業者区分 = null;
        if (!div.getDdlJigyoshaKubun().getSelectedKey().isEmpty()) {
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
        div.getTxtJigyoshaCode().clearValue();
        div.getTxtJigyoshaName().clearValue();
    }

    private List<KeyValueDataSource> getDdlShinseiDaikoKubun() {
        List<KeyValueDataSource> shinseiDaikoKubun = new ArrayList<>();
        for (ShinseiTodokedeDaikoKubunCode code : ShinseiTodokedeDaikoKubunCode.values()) {
            KeyValueDataSource data = new KeyValueDataSource(code.getCode(), code.get名称());
            shinseiDaikoKubun.add(data);
        }
        return shinseiDaikoKubun;
    }

    private List<KeyValueDataSource> getDdlJigyoshaKubun() {
        List<KeyValueDataSource> jigyoshaKubun = new ArrayList<>();
        for (JigyoshaKubun code : JigyoshaKubun.values()) {
            KeyValueDataSource data = new KeyValueDataSource(code.getCode(), code.get名称());
            jigyoshaKubun.add(data);
        }
        return jigyoshaKubun;
    }

}

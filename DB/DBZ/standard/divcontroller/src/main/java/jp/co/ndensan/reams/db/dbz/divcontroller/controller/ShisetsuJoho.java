/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * 施設情報を入力する共有子Divのコントローラです。
 *
 * @author n8178 城間篤人
 */
public class ShisetsuJoho {

    private static final RString JIGYOSHA_DATA_SOURCE = new RString("shisetsuJoho/shisetsuData.yml");
    private static final RString OTHER_SHISETSU_DATA_SOURCE = new RString("shisetsuJoho/otherShisetsuData.yml");
    private static final RString TEKIYO_JOGAI_SHISETSU = new RString("shisetsuJoho/tekiyoJogaiShisetsuData.yml");

    /**
     * 引数から渡された施設情報Divの表示を変更します。<br/>
     * ここでは、住所地特例登録処理などの処理からの使用を想定しており、入力ガイド起動ボタンとラジオボタンに表示される情報を
     * 介護保険施設とその他特例施設に限定します。
     *
     * @param div 施設情報Div
     */
    public static void setJutokuMode(ShisetsuJohoDiv div) {
        div.getRadShisetsuShurui().setDataSource(div.getRadShisetsuShurui().getDataSource().subList(0, 2));
        div.getRadShisetsuShurui().setSelectedItem(new RString("kaigoHokenShisetsu"));
        div.getBtnJigyoshaInputGuide().setDisplayNone(false);
        div.getBtnOtherTokureiShisetsuInputGuide().setDisplayNone(true);
        div.getBtnJogaiShisetsuInputGuide().setDisplayNone(true);
    }

    /**
     * 引数から渡された施設情報Divの表示を変更します。<br/>
     * ここでは、その他特例施設入居による適用などの処理からの使用を想定しており、入力ガイド起動ボタンとラジオボタンに表示される情報を
     * 適用除外施設に限定します。
     *
     * @param div 施設情報Div
     */
    public static void setTekiyoJogaiMode(ShisetsuJohoDiv div) {
        div.getRadShisetsuShurui().setDataSource(div.getRadShisetsuShurui().getDataSource().subList(2, 3));
        div.getRadShisetsuShurui().setSelectedItem(new RString("tekiyoJogaiShisetsu"));
        div.getBtnJigyoshaInputGuide().setDisplayNone(true);
        div.getBtnOtherTokureiShisetsuInputGuide().setDisplayNone(true);
        div.getBtnJogaiShisetsuInputGuide().setDisplayNone(false);

    }

    /**
     * 施設種類ラジオボタンの選択項目が変更された際に実行します。<br/>
     * 選択された項目に合わせて、必要な入力補助ダイアログを表示します。
     *
     * @param div 施設情報Div
     * @return レスポンス
     */
    public ResponseData onChange_radShisetsuShurui(ShisetsuJohoDiv div) {
        ResponseData<ShisetsuJohoDiv> response = new ResponseData<>();
        setShowShisetsuInputGuide(div);
        response.data = div;
        return response;
    }

    private void setShowShisetsuInputGuide(ShisetsuJohoDiv div) {
        RadioButton rad = div.getRadShisetsuShurui();
        div.getBtnJigyoshaInputGuide().setDisplayNone(true);
        div.getBtnOtherTokureiShisetsuInputGuide().setDisplayNone(true);
        div.getBtnJogaiShisetsuInputGuide().setDisplayNone(true);

        switch (rad.getSelectedItem().toString()) {
            case "kaigoHokenShisetsu":
                div.getBtnJigyoshaInputGuide().setDisplayNone(false);
                break;
            case "other":
                div.getBtnOtherTokureiShisetsuInputGuide().setDisplayNone(false);
                break;
            default:
                div.getBtnJogaiShisetsuInputGuide().setDisplayNone(false);
                break;
        }
    }

    /**
     * 施設コードを入力するテキストボックスからフォーカスが離れた際に実行します<br/>
     * 選択している施設種類と入力した施設コードの情報に合致する施設名称を自動で入力します。
     *
     * @param div 施設情報Div
     * @return レスポンス
     */
    public ResponseData onBlur_txtShisetsuCode(ShisetsuJohoDiv div) {
        ResponseData<ShisetsuJohoDiv> response = new ResponseData<>();

        RadioButton rad = div.getRadShisetsuShurui();
        switch (rad.getSelectedItem().toString()) {
            case "kaigoHokenShisetsu":
                setJigyoshaMeisho(div);
                break;
            case "other":
                setMatchOtherShisetsu(div);
                break;
            default:
                setTekiyoJogaiShisetsuMeisho(div);
                break;
        }

        response.data = div;
        return response;
    }

    private void setJigyoshaMeisho(ShisetsuJohoDiv div) {
        List<HashMap> jigyoshaList = YamlLoader.DBZ.loadAsList(JIGYOSHA_DATA_SOURCE);
        RString 施設コード = div.getTxtShisetsuCode().getValue();
        div.getTxtShisetsuMeisho().setValue(RString.EMPTY);
        for (HashMap jigyosha : jigyoshaList) {
            if (jigyosha.get("事業者コード").toString().equals(施設コード.toString())) {
                div.getTxtShisetsuMeisho().setValue(new RString(jigyosha.get("事業者名称").toString()));
            }
        }
    }

    private void setMatchOtherShisetsu(ShisetsuJohoDiv div) {
        Map<String, List<HashMap>> 全特例施設 = YamlLoader.DBZ.loadAsMap(OTHER_SHISETSU_DATA_SOURCE);
        List<HashMap> 施設List = new ArrayList<>();
        RString 施設コード = div.getTxtShisetsuCode().getValue();

        for (List<HashMap> 管内管外分け特例施設 : 全特例施設.values()) {
            施設List.addAll(管内管外分け特例施設);
        }

        div.getTxtShisetsuMeisho().setValue(getMatchShisetsuMeisho(施設List, 施設コード));
    }

    private RString getMatchShisetsuMeisho(List<HashMap> 施設名称List, RString 施設コード) {
        RString 施設名称 = RString.EMPTY;
        for (HashMap 比較対象 : 施設名称List) {
            RString 比較対象施設コード = new RString(比較対象.get("事業者コード").toString());
            if (比較対象施設コード.equals(施設コード)) {
                施設名称 = new RString(比較対象.get("事業者名称").toString());
            }
        }
        return 施設名称;
    }

    private void setTekiyoJogaiShisetsuMeisho(ShisetsuJohoDiv div) {
        List<HashMap> shisetsuList = YamlLoader.DBZ.loadAsList(TEKIYO_JOGAI_SHISETSU);
        RString jigyoshaCode = div.getTxtShisetsuCode().getValue();
        div.getTxtShisetsuMeisho().setValue(RString.EMPTY);
        for (HashMap shisetsuJoho : shisetsuList) {
            if (jigyoshaCode.toString().equals(shisetsuJoho.get("事業者コード").toString())) {
                div.getTxtShisetsuMeisho().setValue(new RString(shisetsuJoho.get("事業者名称").toString()));
            }
        }
    }

}

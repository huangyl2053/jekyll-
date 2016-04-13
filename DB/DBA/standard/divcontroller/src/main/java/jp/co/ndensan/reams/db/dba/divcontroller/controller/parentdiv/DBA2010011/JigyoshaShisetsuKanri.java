/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2010011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010011.DBA2010011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010011.JigyoshaShisetsuKanriDiv;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu.JigyosyaType;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護事業者・施設管理作成クラスです。
 *
 * @reamsid_L DBA-0340-030 wanghui
 */
public class JigyoshaShisetsuKanri {

    private static final RString サービス事業者モード = new RString("11");
    private static final RString その他特例施設モード = new RString("12");
    private static final RString 適用除外施設モード = new RString("21");
    private static final RString 修正 = new RString("修正");
    private static final RString 介護_修正 = new RString("修正");
    private static final RString 介護_削除 = new RString("削除");
    private static final RString 介護_照会 = new RString("照会");
    private static final RString サービス事業者 = new RString("サービス事業者");
    private static final RString その他特例施設 = new RString("その他特例施設");
    private static final RString 適用除外施設 = new RString("適用除外施設");

    /**
     * 介護事業者・施設管理Divを初期化します。
     *
     * @param div 施設管理Div
     * @return ResponseData<JigyoshaNyuryokuGuideDiv> 施設管理Div
     */
    public ResponseData<JigyoshaShisetsuKanriDiv> onLoad(JigyoshaShisetsuKanriDiv div) {
        ViewStateHolder.put(ViewStateKeys.事業者施設選択入力ガイド_モード, 修正);
        JigyoshaMode mode = new JigyoshaMode();
        div.getJigyoshaShurui().getRadJigyoshaShurui().setSelectedKey(サービス事業者モード);
        mode.setJigyoshaShubetsu(div.getJigyoshaShurui().getRadJigyoshaShurui().getSelectedKey());
        div.setJigyoshaMode(DataPassingConverter.serialize(mode));
        div.getJigyoshaNyuryokuGuide().getCommonChildDiv1().initialize(mode);
        div.getJigyoshaNyuryokuGuide().getCommonChildDiv1().getJigyoshaNyuryokuGudieCommonChildDiv()
                .setJigyoshaMode(DataPassingConverter.serialize(mode));
        return ResponseData.of(div).respond();
    }

    /**
     * 施設管理Divを初期化します。
     *
     * @param div 施設管理Div
     * @return ResponseData<JigyoshaShisetsuKanriDiv> 施設管理Div
     */
    public ResponseData<JigyoshaShisetsuKanriDiv> onChange_BtnRadJigyoshaShurui(JigyoshaShisetsuKanriDiv div) {

        JigyoshaMode mode = new JigyoshaMode();
        mode.setJigyoshaShubetsu(div.getJigyoshaShurui().getRadJigyoshaShurui().getSelectedKey());
        div.setJigyoshaMode(DataPassingConverter.serialize(mode));
        div.getJigyoshaNyuryokuGuide().getCommonChildDiv1().initialize(mode);
        div.getJigyoshaNyuryokuGuide().getCommonChildDiv1().getJigyoshaNyuryokuGudieCommonChildDiv()
                .setJigyoshaMode(DataPassingConverter.serialize(mode));
        return ResponseData.of(div).respond();
    }

    /**
     * 施設管理の選択ボタンを押下処理します。
     *
     * @param div 施設管理Div
     * @return ResponseData<JigyoshaNyuryokuGuideDiv> 施設管理Div
     */
    public ResponseData<JigyoshaShisetsuKanriDiv> onClick_Senyi(JigyoshaShisetsuKanriDiv div) {
        RString サービスモード = div.getJigyoshaShurui().getRadJigyoshaShurui().getSelectedKey();
        ViewStateHolder.put(ViewStateKeys.サービス登録_サービス種類コード, サービスモード);
        ViewStateHolder.put(ViewStateKeys.介護事業者_状態, 介護_照会);
        JigyoshaMode mode = DataPassingConverter.deserialize(div.getJigyoshaNyuryokuGuide()
                .getCommonChildDiv1().getJigyoshaNyuryokuGudieCommonChildDiv().getJigyoshaMode(), JigyoshaMode.class);
        ViewStateHolder.put(ViewStateKeys.介護事業者_介護事業者情報, mode);
        if (サービス事業者モード.equals(サービスモード)) {
            return ResponseData.of(div).forwardWithEventName(DBA2010011TransitionEventName.選択)
                    .parameter(サービス事業者);
        }
        if (その他特例施設モード.equals(サービスモード)) {
            mode.setJigyoshaShubetsu(JigyosyaType.住所地特例対象施設.getコード());
            return ResponseData.of(div).forwardWithEventName(DBA2010011TransitionEventName.選択)
                    .parameter(その他特例施設);
        }
        if (適用除外施設モード.equals(サービスモード)) {
            mode.setJigyoshaShubetsu(JigyosyaType.適用除外施設.getコード());
            return ResponseData.of(div).forwardWithEventName(DBA2010011TransitionEventName.選択)
                    .parameter(適用除外施設);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 施設管理の削除ボタンを押下処理します。
     *
     * @param div 施設管理Div
     * @return ResponseData<JigyoshaNyuryokuGuideDiv> 施設管理Div
     */
    public ResponseData<JigyoshaShisetsuKanriDiv> onClick_Skujou(JigyoshaShisetsuKanriDiv div) {
        RString 削除モード = div.getJigyoshaShurui().getRadJigyoshaShurui().getSelectedKey();
        ViewStateHolder.put(ViewStateKeys.サービス登録_サービス種類コード, 削除モード);
        ViewStateHolder.put(ViewStateKeys.介護事業者_状態, 介護_削除);
        JigyoshaMode mode = DataPassingConverter.deserialize(div.getJigyoshaNyuryokuGuide()
                .getCommonChildDiv1().getJigyoshaNyuryokuGudieCommonChildDiv().getJigyoshaMode(), JigyoshaMode.class);
        ViewStateHolder.put(ViewStateKeys.介護事業者_介護事業者情報, mode);
        if (サービス事業者モード.equals(削除モード)) {
            return ResponseData.of(div).forwardWithEventName(DBA2010011TransitionEventName.削除)
                    .parameter(サービス事業者);
        }
        if (その他特例施設モード.equals(削除モード)) {
            mode.setJigyoshaShubetsu(JigyosyaType.住所地特例対象施設.getコード());
            return ResponseData.of(div).forwardWithEventName(DBA2010011TransitionEventName.削除)
                    .parameter(その他特例施設);
        }
        if (適用除外施設モード.equals(削除モード)) {
            mode.setJigyoshaShubetsu(JigyosyaType.適用除外施設.getコード());
            return ResponseData.of(div).forwardWithEventName(DBA2010011TransitionEventName.削除)
                    .parameter(適用除外施設);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 施設管理の修正ボタンを押下処理します。
     *
     * @param div 施設管理Div
     * @return ResponseData<JigyoshaNyuryokuGuideDiv> 施設管理Div
     */
    public ResponseData<JigyoshaShisetsuKanriDiv> onClick_Siyuseyi(JigyoshaShisetsuKanriDiv div) {
        RString 修正モード = div.getJigyoshaShurui().getRadJigyoshaShurui().getSelectedKey();
        ViewStateHolder.put(ViewStateKeys.サービス登録_サービス種類コード, 修正モード);
        ViewStateHolder.put(ViewStateKeys.介護事業者_状態, 介護_修正);
        JigyoshaMode mode = DataPassingConverter.deserialize(div.getJigyoshaNyuryokuGuide()
                .getCommonChildDiv1().getJigyoshaNyuryokuGudieCommonChildDiv().getJigyoshaMode(), JigyoshaMode.class);
        ViewStateHolder.put(ViewStateKeys.介護事業者_介護事業者情報, mode);
        if (サービス事業者モード.equals(修正モード)) {
            return ResponseData.of(div).forwardWithEventName(DBA2010011TransitionEventName.修正)
                    .parameter(サービス事業者);
        }
        if (その他特例施設モード.equals(修正モード)) {
            ViewStateHolder.put(ViewStateKeys.介護事業者_事業者種別, JigyosyaType.住所地特例対象施設.getコード());
            return ResponseData.of(div).forwardWithEventName(DBA2010011TransitionEventName.修正)
                    .parameter(その他特例施設);
        }
        if (適用除外施設モード.equals(修正モード)) {
            ViewStateHolder.put(ViewStateKeys.介護事業者_事業者種別, JigyosyaType.適用除外施設.getコード());
            return ResponseData.of(div).forwardWithEventName(DBA2010011TransitionEventName.修正)
                    .parameter(適用除外施設);
        }
        return ResponseData.of(div).respond();
    }
}

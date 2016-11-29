/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC8120012;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanShikyuGakuKeisanKekka;
import jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanResultEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuPanelListParameter;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120012.DBC8120012TransitionEventName.完了;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120012.DBC8120012TransitionEventName.対象者検索に戻る;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120012.DBC8120012TransitionEventName.検索結果一覧に戻る;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120012.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8120012.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelHandler;
import jp.co.ndensan.reams.db.dbc.service.report.gassanjigyobunkeisankekkarenrakuhyo.GassanJigyobunKeisanKekkaRenrakuhyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 事業高額合算・事業分支給額計算結果連絡票（単）のDivControllerです。
 *
 * @reamsid_L DBC-4840-010 lihang
 */
public class JigyobunShikyugakuKeisanKekkaRenrakuhyoPanel {

    private static final RString この連絡票は既に印刷されていますが = new RString("この連絡票は既に印刷されていますが");

    /**
     * 画面を初期化します
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onLoad(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        TaishoshaKey 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        ShikibetsuCode 識別コード = 引き継ぎ情報.get識別コード();
        JigyobunShikyugakuPanelListParameter parameter
                = createHandler(div).setJigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter(被保険者番号, null, null, null);
        createHandler(div).initialize(被保険者番号, 識別コード, parameter);
        return ResponseData.of(div).respond();
    }

    /**
     * 対象年度DDLをチェンジします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onChange_ddlTaishoNendo(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        TaishoshaKey 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        createHandler(div).onChange対象年度DDL(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡票整理番号DDLをチェンジします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onChange_ddlShikyuShinseishoSeiriNo(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        TaishoshaKey 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        createHandler(div).onChange連絡票整理番号DDL(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 証記載保険者番号DDLをチェンジします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onChange_ddlShoKisaiHokenshaNo(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        TaishoshaKey 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        createHandler(div).onChange証記載保険者番号DDL(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * バリデーションをチェックします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onClick_check(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        if (!ResponseHolder.isReRequest()
                && !div.getSakuseiPanel().getTxtZenkaiSakuseiYMD().getValue().toString().equals(RString.EMPTY.toString())) {
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.確認_汎用.getMessage().getCode(),
                    UrQuestionMessages.確認_汎用.getMessage().replace(この連絡票は既に印刷されていますが.toString()).evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンのメソッドです。
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_reportPublish(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        TaishoshaKey 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        JigyobunShikyugakuPanelListParameter parameter
                = createHandler(div).setJigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter(被保険者番号,
                        new FlexibleYear(div.getDdlTaishoNendo().getSelectedKey()),
                        div.getDdlShikyuShinseishoSeiriNo().getSelectedValue(),
                        new HokenshaNo(div.getDdlShoKisaiHokenshaNo().getSelectedValue()));
        List<JigyobunShikyugakuKeisanResultEntity> panelResultList = createHandler(div).処理対象データ取得(parameter);
        List<JigyoKogakuGassanShikyuGakuKeisanKekka> list = new ArrayList();
        for (JigyobunShikyugakuKeisanResultEntity entity : panelResultList) {
            int i = 0;
            for (JigyoKogakuGassanShikyuGakuKeisanKekka kekka : list) {
                if (kekka.toEntity().equalsPrimaryKeys(entity.getDbt3172Entity())) {
                    i++;
                }
            }
            if (i == 0) {
                list.add(new JigyoKogakuGassanShikyuGakuKeisanKekka(entity.getDbt3172Entity()));
            }
        }
        ViewStateHolder.put(ViewStateKeys.事業高額合算支給額計算結果データ, (Serializable) list);
        IShikibetsuTaishoFinder findler = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
        IShikibetsuTaisho 宛名識別対象情報 = findler.get識別対象(GyomuCode.DB介護保険, new ShikibetsuCode(
                div.getCclKaigoAtenaInfo().getAtenaInfoDiv().getHdnTxtShikibetsuCode()), KensakuYusenKubun.住登外優先);
        FlexibleDate 作成日 = div.getSakuseiPanel().getTxtSakuseiYMD().getValue();
        GassanJigyobunKeisanKekkaRenrakuhyoPrintService printService = new GassanJigyobunKeisanKekkaRenrakuhyoPrintService();
        return ResponseData.of(printService.print(panelResultList, 宛名識別対象情報, 作成日)).respond();
    }

    /**
     * 「発行する」ボタンのメソッドです。
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onClick_afterprint(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {

        List<JigyoKogakuGassanShikyuGakuKeisanKekka> list = ViewStateHolder.get(
                ViewStateKeys.事業高額合算支給額計算結果データ, List.class);
        if (list != null) {
            for (JigyoKogakuGassanShikyuGakuKeisanKekka panelResult : list) {
                createHandler(div).afterprint(new JigyoKogakuGassanShikyuGakuKeisanKekka(panelResult.toEntity()));
            }
        }
        return ResponseData.of(div).forwardWithEventName(完了).respond();
    }

    /**
     * 「再検索」ボタンをClickします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onClick_btnReSearch(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        if (!createHandler(div).get前排他(被保険者番号.getColumnValue())) {
            createHandler(div).前排他キーの解除(被保険者番号.getColumnValue());
        }
        return ResponseData.of(div).forwardWithEventName(対象者検索に戻る).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンをClickします
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     * @return ResponseData
     */
    public ResponseData<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv> onClick_btnSerchResult(
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        if (!createHandler(div).get前排他(被保険者番号.getColumnValue())) {
            createHandler(div).前排他キーの解除(被保険者番号.getColumnValue());
        }
        return ResponseData.of(div).forwardWithEventName(検索結果一覧に戻る).respond();
    }

    private JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelHandler createHandler(JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        return new JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelHandler(div);
    }
}

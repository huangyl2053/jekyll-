/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1320011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC060020.DBC060020_KyufuhiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011.KyufuTsuchiSakuseiIkatuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1320011.KyufuTsuchiSakuseiIkatuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1320011.KyufuTsuchiSakuseiIkatuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufutsuchisakuseiikatu.HihokenshaDaichoAliveManager;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費通知書作成(一括)のdivControllerです。
 *
 * @reamsid_L DBC-2280-010 chenxiangyu
 */
public class KyufuTsuchiSakuseiIkatu {

    /**
     * 給付費通知書作成(一括)初期化を処理します。
     *
     * @param div KyufuTsuchiSakuseiIkatuDiv
     * @return ResponseData<KyufuTsuchiSakuseiIkatuDiv>
     */
    public ResponseData<KyufuTsuchiSakuseiIkatuDiv> onLoad(KyufuTsuchiSakuseiIkatuDiv div) {
        getHandler(div).onLoad(ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務));
        return ResponseData.of(div).respond();
    }

    /**
     * 給付費通知書作成(一括)バッチを実行します。
     *
     * @param div KyufuTsuchiSakuseiIkatuDiv
     * @return ResponseData<KyufuTsuchiSakuseiIkatuDiv>
     */
    public ResponseData<DBC060020_KyufuhiTsuchishoParameter> onClick_btnPrint(KyufuTsuchiSakuseiIkatuDiv div) {
        DBC060020_KyufuhiTsuchishoParameter parameter = getHandler(div).create給付費通知書作成パラメータ();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 「被保険者検索」ボタンを押します。
     *
     * @param div KyufuTsuchiSakuseiIkatuDiv
     * @return ResponseData<KyufuTsuchiSakuseiIkatuDiv>
     */
    public ResponseData<KyufuTsuchiSakuseiIkatuDiv> onClick_btnHihokenshaSearch(KyufuTsuchiSakuseiIkatuDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「給付費通知情報を取り込む」ボタンを押します。
     *
     * @param div KyufuTsuchiSakuseiIkatuDiv
     * @return ResponseData<KyufuTsuchiSakuseiIkatuDiv>
     */
    public ResponseData<KyufuTsuchiSakuseiIkatuDiv> onClick_btnKyufuTsuchiJyoho(KyufuTsuchiSakuseiIkatuDiv div) {
        getHandler(div).setRowFileData();
        return ResponseData.of(div).respond();
    }

    /**
     * 「被保険者番号」をブラーします。
     *
     * @param div 画面情報
     * @return ResponseData<SaishinsaMoshitateTourokuPanelDiv>
     */
    public ResponseData<KyufuTsuchiSakuseiIkatuDiv> onBlur_txtHihoNo(KyufuTsuchiSakuseiIkatuDiv div) {
        if (RString.isNullOrEmpty(div.getTxtHihokenshaNo().getValue())) {
            div.getTxtHihokenshaName().clearValue();
        } else {
            HihokenshaDaichoAliveManager manager = new HihokenshaDaichoAliveManager();
            HihokenshaDaichoAlive date = manager.get最新の被保険者台帳情報(
                    div.getTxtHihokenshaNo().getValue());
            if (date == null) {
                div.getTxtHihokenshaName().clearValue();
                return ResponseData.of(div).addValidationMessages(getValidationHandler()
                        .get存在しないエラーメッセージ()).respond();
            }
            div.getTxtHihokenshaName().setValue(get被保名称(date.get識別コード()));
        }
        return ResponseData.of(div).respond();
    }

    private RString get被保名称(ShikibetsuCode 識別コード) {
        RString 被保名称 = RString.EMPTY;
        if (識別コード != null && !識別コード.isEmpty()) {
            IShikibetsuTaishoFinder 識別対象Finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
            IShikibetsuTaisho 宛名情報 = 識別対象Finder.get識別対象(GyomuCode.DB介護保険, 識別コード, KensakuYusenKubun.住登外優先);
            被保名称 = 宛名情報.get名称().getName().value();
        }
        return 被保名称;
    }

    private KyufuTsuchiSakuseiIkatuHandler getHandler(KyufuTsuchiSakuseiIkatuDiv div) {
        return new KyufuTsuchiSakuseiIkatuHandler(div);
    }

    private KyufuTsuchiSakuseiIkatuValidationHandler getValidationHandler() {
        return new KyufuTsuchiSakuseiIkatuValidationHandler();
    }
}

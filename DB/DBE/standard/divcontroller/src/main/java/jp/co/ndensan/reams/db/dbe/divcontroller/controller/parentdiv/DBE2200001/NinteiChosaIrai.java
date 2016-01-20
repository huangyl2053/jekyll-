/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2200001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinnteiChousairaiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinteichosaIraiJohoRelateBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninnteichousairai.NinnteiChousairaiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.NinteiChosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgChosaItakusakiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgchosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2200001.NinteiChosaIraiHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairai.NinnteiChousairaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 認定調査依頼のコントローラです。
 */
public class NinteiChosaIrai {

    /**
     * 画面初期化処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onLoad(NinteiChosaIraiDiv div) {
        getHandler(div).load();

        ShoKisaiHokenshaNo Temp_保険者番号 = ShoKisaiHokenshaNo.EMPTY;
        RString Temp_保険者名称 = RString.EMPTY;
        RString Temp_支所コード = RString.EMPTY;
        LasdecCode 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
        if (getHandler(div).is単一保険者() && 市町村コード != null) {

            Temp_保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
            Temp_保険者名称 = div.getCcdHokenshaList().getSelectedItem().get市町村名称();

            // QA88 TODO 支所情報取得につきましては、現在設計を追加で行っています。実装におかれましては、TODOとして進めてください。
            Temp_支所コード = RString.EMPTY;
        }

        // TODO
        Temp_保険者番号 = new ShoKisaiHokenshaNo("209007");

        ViewStateHolder.put(ViewStateKeys.支所コード, Temp_支所コード);
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, Temp_保険者番号);
        List<NinnteiChousairaiBusiness> 認定調査委託先List = NinnteiChousairaiFinder.createInstance().getNinnteiChousaItaku(
                NinnteiChousairaiParameter.createParam調査委託先Or未割付申請者(Temp_保険者番号, Temp_支所コード)).records();
        getHandler(div).set認定調査委託先一覧(認定調査委託先List);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先一覧の選択処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onSelect_dgChosaItakusakiIchiran(NinteiChosaIraiDiv div) {
        dgChosaItakusakiIchiran_Row row = div.getDgChosaItakusakiIchiran().getActiveRow();
        getHandler(div).set委託先基本情報(row);
        getHandler(div).setDisabledToChosaItakusakiAndChosainKihonJoho(true);
        ChosaItakusakiCode chosaItakusakiCode = new ChosaItakusakiCode(row.getChosaItakusakiCode().getValue());
        ViewStateHolder.put(ViewStateKeys.認定調査委託先コード, chosaItakusakiCode);
        RString Temp_支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);
        ShoKisaiHokenshaNo Temp_保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        NinnteiChousairaiParameter parameter = NinnteiChousairaiParameter.createParamfor調査員情報(
                Temp_保険者番号, Temp_支所コード, chosaItakusakiCode);
        List<NinnteiChousairaiBusiness> 調査員情報一覧 = NinnteiChousairaiFinder.createInstance().getChousaIn(parameter).records();
        getHandler(div).set調査員情報一覧(調査員情報一覧, row);

        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査員一覧の選択処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onSelect_dgchosainIchiran(NinteiChosaIraiDiv div) {
        dgchosainIchiran_Row row = div.getChosainIchiran().getDgchosainIchiran().getActiveRow();
        getHandler(div).set委託先基本情報(row);
        ChosainCode chosainCode = new ChosainCode(row.getChosainCode().getValue());
        ChosaItakusakiCode chosaItakusakiCode = ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, ChosaItakusakiCode.class);
        RString Temp_支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);
        ShoKisaiHokenshaNo Temp_保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);

        NinnteiChousairaiParameter parameter = NinnteiChousairaiParameter.createParamfor割付済み申請者一覧(
                Temp_保険者番号, Temp_支所コード, chosaItakusakiCode, chosainCode);
        List<WaritsukeBusiness> 割付済み申請者一覧 = NinnteiChousairaiFinder.createInstance().getWaritsuke(parameter).records();
        getHandler(div).set割付済み申請者一覧(割付済み申請者一覧, row.getHokenshaName());
        parameter = NinnteiChousairaiParameter.createParam調査委託先Or未割付申請者(Temp_保険者番号, Temp_支所コード);
        List<WaritsukeBusiness> 未割付申請者一覧 = NinnteiChousairaiFinder.createInstance().getShiteWaritsuke(parameter).records();
        getHandler(div).set未割付申請者一覧(未割付申請者一覧, row.getHokenshaName());

        parameter = NinnteiChousairaiParameter.createParam調査委託先Or未割付申請者(Temp_保険者番号, Temp_支所コード);
        List<WaritsukeBusiness> 未割付再依頼一覧 = NinnteiChousairaiFinder.createInstance().getShiteWaritsukeSai(parameter).records();
        getHandler(div).set未割付申請者一覧(未割付再依頼一覧, row.getHokenshaName());

        List<NinteichosaIraiJohoRelateBusiness> 割付済み一覧 = NinnteiChousairaiFinder.createInstance().getNinteichosaIraiJohoList(parameter).records();
        List<NinteiKanryoJoho> ninteiKanryoJohoList = new ArrayList<>();
        List<NinteichosaIraiJoho> ninteichosaIraiJohoList = new ArrayList<>();
        if (!割付済み一覧.isEmpty()) {
            ninteiKanryoJohoList = 割付済み一覧.get(0).getNinteiKanryoJohoList();
            ninteichosaIraiJohoList = 割付済み一覧.get(0).getNinteichosaIraiJohoList();
        }
        ViewStateHolder.put(ViewStateKeys.検索結果_認定調査依頼情報, Models.create(ninteichosaIraiJohoList));
        ViewStateHolder.put(ViewStateKeys.検索結果_要介護認定完了情報, Models.create(ninteiKanryoJohoList));
        return ResponseData.of(div).respond();
    }

    /**
     * 「↑申請者を割付ける」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnWaritsuke(NinteiChosaIraiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「↓割付けを解除する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnKaijo(NinteiChosaIraiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「↓割付けを解除する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnBackToChosaItakusakiSentaku(NinteiChosaIraiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「認定調査員選択へ戻る」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnBackToChosainSentaku(NinteiChosaIraiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「割付内容を保存する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnHozon(NinteiChosaIraiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択した帳票を発行する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_BtnPrint(NinteiChosaIraiDiv div) {
        return ResponseData.of(div).respond();
    }

    private NinteiChosaIraiHandler getHandler(NinteiChosaIraiDiv div) {
        return new NinteiChosaIraiHandler(div);
    }
}

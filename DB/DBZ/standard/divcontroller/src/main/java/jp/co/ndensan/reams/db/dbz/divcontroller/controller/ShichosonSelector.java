package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.shichosonsentaku.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dbz.business.core.shichosonsentaku.ShichosonSelectorResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shichosonSelector.shichosonSelector.ShichosonSelectorDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shichosonSelector.shichosonSelector.ShichosonSelectorHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shichosonSelector.shichosonSelector.dgShichoson_Row;
import jp.co.ndensan.reams.db.dbz.service.core.shichosonsentaku.ShichosonSentakuFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 市町村選択には、旧市町村選択情報を取得する、構成市町村選択情報を取得する機能を提供します。
 *
 * @reamsid_L DBA-0100-010 xuyannan
 */
public class ShichosonSelector {

    private final ShichosonSentakuFinder service;
    private static final RString KOUSEI_MODO_KOUSEI = new RString("1");
    private static final RString KOUSEI_MODO_KYU = new RString("0");

    /**
     * コンストラクタです。
     *
     */
    public ShichosonSelector() {
        service = ShichosonSentakuFinder.createInstance();
    }

    /**
     * 共通子DIVを初期化します。
     *
     * @param div ShichosonSelectorDiv
     * @return ResponseData<ShichosonSelectorDiv>
     */
    public ResponseData<ShichosonSelectorDiv> onLoad(ShichosonSelectorDiv div) {
        ShichosonSelectorModel model = DataPassingConverter.deserialize(div.getKyuShichoson(), ShichosonSelectorModel.class);
        RString 構成市町村モード = model.getShichosonModel();
        ResponseData<ShichosonSelectorDiv> response = new ResponseData<>();
        SearchResult<ShichosonSelectorResult> resultList = SearchResult.of(Collections.<ShichosonSelectorResult>emptyList(), 0, false);
        if (RString.isNullOrEmpty(div.getKijun())) {
        if (KOUSEI_MODO_KYU.equals(構成市町村モード)) {
            resultList = service.getGapeiShichosonSentaku(FlexibleDate.getNowDate());
        }
        if (KOUSEI_MODO_KOUSEI.equals(構成市町村モード)) {
            resultList = service.getKouseiShichosonSentaku(FlexibleDate.getNowDate());
        }
        } else {
            resultList = service.getGapeiShichosonSentaku();
        }
        getHandler(div).set一覧表示グリッド(resultList.records());
        response.data = div;
        return response;
    }

    /**
     * 構成市町村モードで呼び出された場合、構成市町村選択情報の取得を処理する。
     *
     * @param div ShichosonSelectorDiv
     * @return ResponseData<ShichosonSelectorDiv>
     */
    public ResponseData<ShichosonSelectorDiv> onChange_radShichosonKubun(ShichosonSelectorDiv div) {
        ResponseData<ShichosonSelectorDiv> response = new ResponseData<>();
        ShichosonSelectorModel model = DataPassingConverter.deserialize(div.getKyuShichoson(), ShichosonSelectorModel.class);
        getHandler(div).set構成市町村情報By市町村モード(model.getList());
        response.data = div;
        return response;
    }

    /**
     * 市町村選択を確定するボタンを処理する。
     *
     * @param div ShichosonSelectorDiv
     * @return ResponseData<ShichosonSelectorDiv>
     */
    public ResponseData<ShichosonSelectorDiv> onClick_btnSentaku(ShichosonSelectorDiv div) {
        ResponseData<ShichosonSelectorDiv> response = new ResponseData<>();
        ShichosonSelectorModel model = new ShichosonSelectorModel();
        List<ShichosonSelectorResult> resultList = new ArrayList<>();
        for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
            ShichosonSelectorResult result = new ShichosonSelectorResult();
            result.set市町村コード(new LasdecCode(row.getTxtShichosonCode()));
            result.set市町村名(row.getTxtShichosonName());
            resultList.add(result);
        }
        model.setList(resultList);
        div.setKyuShichoson(DataPassingConverter.serialize(model));
        response.data = div;
        return response;
    }

    /**
     * 「戻る」ボタンを処理する。
     *
     * @param div ShichosonSelectorDiv
     * @return ResponseData<ShichosonSelectorDiv>
     */
    public ResponseData<ShichosonSelectorDiv> onClick_btnModoru(ShichosonSelectorDiv div) {
        ResponseData<ShichosonSelectorDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private ShichosonSelectorHandler getHandler(ShichosonSelectorDiv div) {
        return new ShichosonSelectorHandler(div);
    }
}

package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.shichosonselector.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shichosonSelector.shichosonSelector.ShichosonSelectorDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shichosonSelector.shichosonSelector.ShichosonSelectorHandler;
import jp.co.ndensan.reams.db.dba.service.ShichosonSentakuFinder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 市町村選択には、旧市町村選択情報を取得する、構成市町村選択情報を取得する機能を提供します。
 *
 */
public class ShichosonSelector {

    private final ShichosonSentakuFinder service;
    private static final RString 市町村モード1 = new RString("1");
    private static final RString 市町村モード2 = new RString("0");

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
        if (市町村モード1.equals(構成市町村モード)) {
            div.getRadShichosonKubun().setDisplayNone(false);
        } else {
            div.getRadShichosonKubun().setDisplayNone(true);
        }
        if (市町村モード2.equals(構成市町村モード)) {
            List<DbT7056GappeiShichosonEntity> list = service.getGapeiShichosonSentaku(FlexibleDate.getNowDate());
            getHandler(div).set旧市町村選択情報一覧表示グリッド(list);

        }
        if (市町村モード1.equals(構成市町村モード)) {
            List<DbT7051KoseiShichosonMasterEntity> list = service.getKouseiShichosonSentaku(FlexibleDate.getNowDate());
            getHandler(div).set構成市町村情報一覧表示グリッド(list);
            ShichosonSelectorModel shichosonSelector = new ShichosonSelectorModel();
            shichosonSelector.setList(list);
            div.setKyuShichoson(DataPassingConverter.serialize(shichosonSelector));
        }
        response.data = div;
        return response;
    }

    /**
     * 構成市町村モードで呼び出された場合、構成市町村選択情報の取得を処理する。
     *
     * @param div　ShichosonSelectorDiv
     * @return ResponseData<ShichosonSelectorDiv>
     */
    public ResponseData<ShichosonSelectorDiv> onChange_radShichosonKubun(ShichosonSelectorDiv div) {
        ResponseData<ShichosonSelectorDiv> response = new ResponseData<>();
        ShichosonSelectorModel model = DataPassingConverter.deserialize(div.getKyuShichoson(), ShichosonSelectorModel.class);
        getHandler(div).onClick_旧市町村ラジオボタン(model.getList());
        response.data = div;
        return response;
    }

    /**
     * 市町村選択を確定するボタンを処理する。
     *
     * @param div　ShichosonSelectorDiv
     * @return ResponseData<ShichosonSelectorDiv>
     */
    public ResponseData<ShichosonSelectorDiv> onClick_市町村選択を確定するボタン(ShichosonSelectorDiv div) {
        ResponseData<ShichosonSelectorDiv> response = new ResponseData<>();

        ShichosonSelectorModel model = new ShichosonSelectorModel();
        if (!div.getDgShichoson().getSelectedItems().isEmpty()) {
            model.setShichosonCode(div.getDgShichoson().getSelectedItems().get(0).getTxtShichosonCode());
            model.setShichosonName(div.getDgShichoson().getSelectedItems().get(0).getTxtShichosonName());
            div.setKyuShichoson(DataPassingConverter.serialize(model));
        }
        response.data = div;
        return response;
    }

    /**
     * 「戻る」ボタンを処理する。
     *
     * @param div　ShichosonSelectorDiv
     * @return ResponseData<ShichosonSelectorDiv>
     */
    public ResponseData<ShichosonSelectorDiv> onClick_戻る(ShichosonSelectorDiv div) {
        ResponseData<ShichosonSelectorDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private ShichosonSelectorHandler getHandler(ShichosonSelectorDiv div) {
        return new ShichosonSelectorHandler(div);
    }

}

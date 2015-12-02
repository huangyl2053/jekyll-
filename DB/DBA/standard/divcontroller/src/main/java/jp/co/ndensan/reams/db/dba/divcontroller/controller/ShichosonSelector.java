package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.shichosonselector.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shichosonselector.ShichosonSelector.ShichosonSelectorDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shichosonselector.ShichosonSelector.ShichosonSelectorHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shichosonselector.ShichosonSelector.dgShichoson_Row;
import jp.co.ndensan.reams.db.dba.service.ShichosonSentakuFinder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
    //TODO QA57
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
        List<DbT7056GappeiShichosonEntity> DbT7056List = new ArrayList();
        List<DbT7051KoseiShichosonMasterEntity> DbT7051List = new ArrayList();
        if (KOUSEI_MODO_KYU.equals(構成市町村モード)) {
            DbT7056List = service.getGapeiShichosonSentaku(FlexibleDate.getNowDate());
        }
        if (KOUSEI_MODO_KOUSEI.equals(構成市町村モード)) {
            DbT7051List = service.getKouseiShichosonSentaku(FlexibleDate.getNowDate());
        }
        getHandler(div).set一覧表示グリッド(DbT7056List, DbT7051List);
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
        getHandler(div).set構成市町村情報By市町村モード(model.getList());
        response.data = div;
        return response;
    }

    /**
     * 市町村選択を確定するボタンを処理する。
     *
     * @param div　ShichosonSelectorDiv
     * @return ResponseData<ShichosonSelectorDiv>
     */
    public ResponseData<ShichosonSelectorDiv> onClick_btnSentaku(ShichosonSelectorDiv div) {
        ResponseData<ShichosonSelectorDiv> response = new ResponseData<>();
        ShichosonSelectorModel model = new ShichosonSelectorModel();
        List<DbT7051KoseiShichosonMasterEntity> list = new ArrayList();
        for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
            DbT7051KoseiShichosonMasterEntity entity = new DbT7051KoseiShichosonMasterEntity();
            entity.setShichosonCode(new LasdecCode(row.getTxtShichosonCode()));
            entity.setShichosonMeisho(row.getTxtShichosonName());
            list.add(entity);
        }
        model.setList(list);
        div.setKyuShichoson(DataPassingConverter.serialize(model));
        response.data = div;
        return response;
    }

    /**
     * 「戻る」ボタンを処理する。
     *
     * @param div　ShichosonSelectorDiv
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

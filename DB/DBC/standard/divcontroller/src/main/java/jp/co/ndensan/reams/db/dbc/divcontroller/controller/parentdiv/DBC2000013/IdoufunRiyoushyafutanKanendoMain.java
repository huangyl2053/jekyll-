/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000013;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180030.DBC180030_KanendoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.idoufunriyoushyafutankanendo.IdoufunRiyoushyafutanKanendoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000013.DBC2000013TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000013.IdoufunRiyoushyafutanKanendoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000013.IdoufunRiyoushyafutanKanendoMainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000013.IdoufunRiyoushyafutanKanendoMainValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.idoufunriyoushyafutankanendo.IdoufunRiyoushyafutanKanendoManager;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 異動分利用者負担割合判定（過年度）のクラスです。
 *
 * @reamsid_L DBC-4940-010 wangrenze
 */
public class IdoufunRiyoushyafutanKanendoMain {

    /**
     * 画面の初期化です。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<IdoufunRiyoushyafutanKanendoDiv> onLoad(IdoufunRiyoushyafutanKanendoDiv div) {
        ShoriDateKanri データ = get直近の年次負担割合判定処理();
        getHandler(div).initControl(データ);
        ShoriDateKanri business = get異動分利用者負担割合判定_過年度のデータ();
        if (business != null) {
            getHandler(div).set取得できたの抽出期間(business);
        }
        if (business == null && データ != null) {
            RString 年次判定年度 = データ.get年度().toDateString();
            IdoufunRiyoushyafutanKanendoMybatisParameter parameter = new IdoufunRiyoushyafutanKanendoMybatisParameter(
                    ShoriName.異動分利用者負担割合判定.get名称(), 年次判定年度);
            getHandler(div).set取得できないの抽出期間(get異動分利用者負担割合判定のデータ(parameter));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行」ボタンのClickです。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<IdoufunRiyoushyafutanKanendoDiv> onClick_btnJikkouCheck(IdoufunRiyoushyafutanKanendoDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).実行するボタンを押下の存在チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンの押下処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<DBC180030_KanendoRiyoshaFutanwariaiHanteiParameter> onClick_btnJikkou(IdoufunRiyoushyafutanKanendoDiv div) {
        return ResponseData.of(getHandler(div).setParameter()).forwardWithEventName(DBC2000013TransitionEventName.終了).respond();
    }

    private ShoriDateKanri get直近の年次負担割合判定処理() {
        return IdoufunRiyoushyafutanKanendoManager.createInstance().get直近の年次負担割合判定処理(
                ShoriName.年次利用者負担割合判定.get名称());
    }

    private ShoriDateKanri get異動分利用者負担割合判定_過年度のデータ() {
        return IdoufunRiyoushyafutanKanendoManager.createInstance().get異動分利用者負担割合判定_過年度のデータ(
                ShoriName.異動分利用者負担割合判定_過年度.get名称());
    }

    private ShoriDateKanri get異動分利用者負担割合判定のデータ(IdoufunRiyoushyafutanKanendoMybatisParameter parameter) {
        return IdoufunRiyoushyafutanKanendoManager.createInstance().get異動分利用者負担割合判定のデータ(parameter);
    }

    private IdoufunRiyoushyafutanKanendoMainHandler getHandler(IdoufunRiyoushyafutanKanendoDiv div) {
        return new IdoufunRiyoushyafutanKanendoMainHandler(div);
    }

    private IdoufunRiyoushyafutanKanendoMainValidationHandler getValidationHandler(IdoufunRiyoushyafutanKanendoDiv div) {
        return new IdoufunRiyoushyafutanKanendoMainValidationHandler(div);
    }
}

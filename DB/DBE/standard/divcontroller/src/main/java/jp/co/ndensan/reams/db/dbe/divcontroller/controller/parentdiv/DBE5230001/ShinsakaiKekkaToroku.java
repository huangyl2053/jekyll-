/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5230001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteishinseijoho.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.ShinsakaiKekkaTorokuHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuManager;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 介護認定審査会審査結果登録クラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaToroku {

    private final ShinsakaiKekkaTorokuManager manager;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKekkaToroku() {
        this.manager = ShinsakaiKekkaTorokuManager.createInstance();
    }

    /**
     * 介護認定審査会審査結果登録Divを初期化します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<ShinsakaiKekkaTorokuDiv> 介護認定審査会審査結果登録Div
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onLoad(ShinsakaiKekkaTorokuDiv div) {
        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.介護認定審査会開催結果登録_開催番号, RString.class);
        List<ShinsakaiKekkaTorokuBusiness> headList = manager.getヘッドエリア内容検索(開催番号).records();
        List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList = manager.get審査会委員一覧検索(開催番号).records();
        getHandler(div).onLoad(headList, iChiRanList);
        List<ShinsakaiKaisaiYoteiJoho> yoteiJohoList = manager.get審査会委員一覧検索_業務概念_1(開催番号).records();
        Models<ShinsakaiKaisaiYoteiJohoIdentifier, ShinsakaiKaisaiYoteiJoho> shinsakaiKaisaiYoteiJoho = Models.create(yoteiJohoList);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会開催結果登録_介護認定審査会開催予定情報, shinsakaiKaisaiYoteiJoho);

        List<NinteiShinseiJoho> shinseiJohoList = manager.get審査会委員一覧検索_業務概念_2(開催番号).records();
        Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho = Models.create(shinseiJohoList);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会開催結果登録_要介護認定申請情報, ninteiShinseiJoho);

        return ResponseData.of(div).respond();
    }

    /**
     * 審査会データ空チェックを実施します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData<NenreiTotatsuTorokushaListDiv>
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onClick_Check(ShinsakaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        return ResponseData.of(div).respond();
    }

    private ShinsakaiKekkaTorokuHandler getHandler(ShinsakaiKekkaTorokuDiv div) {
        return new ShinsakaiKekkaTorokuHandler(div);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiWariateIinJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;

/**
 * 介護認定審査会審査結果登録クラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaTorokuHandler {

    private final ShinsakaiKekkaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催結果登録Div
     */
    public ShinsakaiKekkaTorokuHandler(ShinsakaiKekkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアです。
     *
     * @param headList headList
     * @param iChiRanList iChiRanList
     */
    public void onLoad(List<ShinsakaiKekkaTorokuBusiness> headList, List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList) {
        for (ShinsakaiKekkaTorokuBusiness head : headList) {
        }
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアです。
     *
     * @param list 審査会委員一覧設定
     *
     */
    public void initialize(List<ShinsakaiWariateIinJohoBusiness> list) {

    }
}

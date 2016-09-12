/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinJoho.RoreiFukushiNenkinJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.service.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoFinder;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 【共有子Div】 老齢福祉年金ハンドラクラスです。
 *
 * @reamsid_L DBD-3560-090 wangjie2
 */
public class RoreiFukushiNenkinJohoHandler {

    private final RoreiFukushiNenkinJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】老齢福祉年金Div
     */
    public RoreiFukushiNenkinJohoHandler(RoreiFukushiNenkinJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void initializa(HihokenshaNo 被保険者番号) {
        RoreiFukushiNenkinJohoFinder finder = RoreiFukushiNenkinJohoFinder.createIntance();
        List<RoreiFukushiNenkinJukyusha> 老齢福祉年金情報List = finder.get老齢福祉年金情報(被保険者番号);
        List<dgRoreiFukushiNenkinJoho_Row> dataSourceList = getDataSource(老齢福祉年金情報List);
        div.getDgRoreiFukushiNenkinJoho().setDataSource(dataSourceList);
    }

    private List<dgRoreiFukushiNenkinJoho_Row> getDataSource(List<RoreiFukushiNenkinJukyusha> 老齢福祉年金情報List) {
        List<dgRoreiFukushiNenkinJoho_Row> dataSourceList = new ArrayList<>();
        for (RoreiFukushiNenkinJukyusha 老齢福祉年金情報 : 老齢福祉年金情報List) {
            dgRoreiFukushiNenkinJoho_Row dataSource = new dgRoreiFukushiNenkinJoho_Row();
            if (老齢福祉年金情報.get受給開始年月日() != null) {
                TextBoxFlexibleDate 開始日 = new TextBoxFlexibleDate();
                開始日.setValue(老齢福祉年金情報.get受給開始年月日());
                dataSource.setStartDate(開始日);
            }
            if (老齢福祉年金情報.get受給終了年月日() != null) {
                TextBoxFlexibleDate 終了日 = new TextBoxFlexibleDate();
                終了日.setValue(老齢福祉年金情報.get受給終了年月日());
                dataSource.setEndDate(終了日);
            }
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

}

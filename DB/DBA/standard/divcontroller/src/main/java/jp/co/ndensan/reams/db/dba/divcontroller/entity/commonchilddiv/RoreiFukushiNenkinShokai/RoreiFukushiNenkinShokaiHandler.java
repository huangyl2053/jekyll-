/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.roreifukushinenkinjoho.BRoreiFukushiNenkinJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 *
 * 老齢福祉年金情報です.
 */
public class RoreiFukushiNenkinShokaiHandler {

    private final RoreiFukushiNenkinShokaiDiv div;
    public static final ShikibetsuCode shikibetsuCode = new ShikibetsuCode("000001234567890");
    public static final FlexibleDate jukyuKaishiYMD = new FlexibleDate("20140401");
    public static final FlexibleDate jukyuShuryoYMD = new FlexibleDate("20140401");
    public static final HihokenshaNo hihokenshaNo = new HihokenshaNo("20140401");

    public RoreiFukushiNenkinShokaiHandler(RoreiFukushiNenkinShokaiDiv div) {
        this.div = div;
    }

    /**
     * 共通子DIVを初期化します。
     *
     * @param 老齢福祉年金情報 List<BRoreiFukushiNenkinJoho>
     */
    public void set老齢福祉年金情報一覧表示グリッド(List<BRoreiFukushiNenkinJoho> 老齢福祉年金情報) {

        List<datagridRireki_Row> rowList = new ArrayList();
        for (BRoreiFukushiNenkinJoho entity : 老齢福祉年金情報) {
            datagridRireki_Row row = new datagridRireki_Row();
            row.setStartDate(entity.getJukyuKaishiYMD().wareki().toDateString());
            row.setEndDate(entity.getJukyuShuryoYMD().wareki().toDateString());
            rowList.add(row);
        }
        div.getDatagridRireki().setDataSource(rowList);
        div.getPanelInput().setDisplayNone(true);
        div.getPanelRireki().setDisplayNone(false);

    }

    /**
     * 共通子DIVを初期化します。
     *
     * @param 老齢福祉年金情報 List<BRoreiFukushiNenkinJoho>
     */
    public void set老齢福祉年金情報画面表示() {

        div.getPanelRireki().setDisplayNone(true);
        div.getPanelInput().setDisplayNone(false);

    }

}

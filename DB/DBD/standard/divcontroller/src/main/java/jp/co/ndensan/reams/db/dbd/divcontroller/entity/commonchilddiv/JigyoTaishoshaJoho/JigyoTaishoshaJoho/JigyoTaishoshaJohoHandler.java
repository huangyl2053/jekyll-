/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.JigyoTaishoshaJoho.JigyoTaishoshaJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbd.service.core.jigyotaishoshajoho.JigyoTaishoshaJohoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 【共有子Div】 事業対象者ハンドラクラスです。
 *
 * @reamsid_L DBD-3560-130 wangjie2
 */
public class JigyoTaishoshaJohoHandler {

    private final JigyoTaishoshaJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】事業対象者Div
     */
    public JigyoTaishoshaJohoHandler(JigyoTaishoshaJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void initializa(HihokenshaNo 被保険者番号) {
        JigyoTaishoshaJohoFinder finder = JigyoTaishoshaJohoFinder.createIntance();
        List<SogoJigyoTaishosha> 事業対象者情報List = finder.get事業対象者情報(被保険者番号);
        div.getDgJigyoTaishoshaJoho().setDataSource(getDataSource(事業対象者情報List));
    }

    private List<dgJigyoTaishoshaJoho_Row> getDataSource(List<SogoJigyoTaishosha> 事業対象者情報List) {
        List<dgJigyoTaishoshaJoho_Row> dataSourceList = new ArrayList<>();
        for (SogoJigyoTaishosha 事業対象者情報 : 事業対象者情報List) {
            dgJigyoTaishoshaJoho_Row dataSource = new dgJigyoTaishoshaJoho_Row();
            if (事業対象者情報.get適用開始年月日() != null) {
                TextBoxFlexibleDate 適用開始日 = new TextBoxFlexibleDate();
                適用開始日.setValue(事業対象者情報.get適用開始年月日());
                dataSource.setTekiyoStartDate(適用開始日);
            }
            if (事業対象者情報.get適用終了年月日() != null) {
                TextBoxFlexibleDate 適用終了日 = new TextBoxFlexibleDate();
                適用終了日.setValue(事業対象者情報.get適用終了年月日());
                dataSource.setTekiyoEndDate(適用終了日);
            }
            if (事業対象者情報.getチェックリスト実施日() != null) {
                TextBoxFlexibleDate チェックリスト実施日 = new TextBoxFlexibleDate();
                チェックリスト実施日.setValue(事業対象者情報.getチェックリスト実施日());
                dataSource.setCheckListJisshiDate(チェックリスト実施日);
            }
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

}

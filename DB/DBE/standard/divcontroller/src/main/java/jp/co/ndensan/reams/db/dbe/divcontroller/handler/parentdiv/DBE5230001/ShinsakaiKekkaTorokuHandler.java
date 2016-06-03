/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 介護認定審査会審査結果登録クラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaTorokuHandler {

    private final ShinsakaiKekkaTorokuDiv div;
    private final RString key0 = new RString("key0");

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
            div.getKyotsuHyojiArea().getTxtShinsakaiName().setValue(head.get審査会名称());
            div.getKyotsuHyojiArea().getTxtGogitaiNo().setValue(head.get合議体名称());
            div.getKyotsuHyojiArea().getTxtShinsaTaishosha().setValue(new RString(head.get割付人数()));
            div.getKyotsuHyojiArea().getTxtShinsakaiKaijo().setValue(head.get審査会会場());
            div.getKyotsuHyojiArea().getTxtChiku().setValue(head.get審査会地区コード());
            div.getKyotsuHyojiArea().getTxtTaishoNinzu().setValue(new RString(head.get対象人数()));
            div.getKyotsuHyojiArea().getTxtKaisaiNichiji().setValue(head.get開催日());
            div.getKyotsuHyojiArea().getTxtKaisaiTimeRange().setFromValue(new RTime(head.get開催開始時間()));
            div.getKyotsuHyojiArea().getTxtKaisaiTimeRange().setToValue(new RTime(head.get開催終了時間()));
            div.getKyotsuHyojiArea().getTxtStutas().setValue(head.getステータス());

            List<KeyValueDataSource> selectedItem = new ArrayList<>();
            if (head.is審査会種類()) {
                selectedItem.add(new KeyValueDataSource(key0, key0));
            }
            div.getKyotsuHyojiArea().getChkShinsakaiShurui().setSelectedItems(selectedItem);
        }
        setTaishoshaIchiran(iChiRanList);

    }

    private void setTaishoshaIchiran(List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList) {
        List<dgTaishoshaIchiran_Row> dataSource = new ArrayList<>();
        TextBoxFlexibleDate 認定申請日 = new TextBoxFlexibleDate();
        TextBoxFlexibleDate 前回有効期間終了日 = new TextBoxFlexibleDate();
        for (ShinsakaiKekkaTorokuIChiRanBusiness business : iChiRanList) {
            認定申請日.setValue(business.get認定申請日());
            前回有効期間終了日.setValue(business.get前回有効期間終了日());
            dgTaishoshaIchiran_Row row = new dgTaishoshaIchiran_Row(
                    new RString(business.get審査会順序()),
                    business.get保険者番号(),
                    business.get保険者(),
                    business.get被保番号(),
                    business.get氏名(),
                    business.get被保区分(),
                    business.get申請区分_申請時(),
                    business.get申請区分_法令(),
                    認定申請日,
                    前回有効期間終了日,
                    business.get前回一次判定(),
                    business.get今回一次判定(),
                    // 前回二次判定
                    business.get前回一次判定(),
                    business.get今回二次判定(),
                    key0,
                    null,
                    key0,
                    key0,
                    null,
                    null,
                    key0,
                    Boolean.TRUE,
                    Boolean.TRUE,
                    key0,
                    key0,
                    key0,
                    key0,
                    key0,
                    key0,
                    key0);
            dataSource.add(row);
        }
        div.getShinseishaIchiran().getDgTaishoshaIchiran().setDataSource(dataSource);
    }

}

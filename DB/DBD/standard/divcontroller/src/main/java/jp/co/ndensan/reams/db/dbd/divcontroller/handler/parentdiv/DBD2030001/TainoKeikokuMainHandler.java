/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2030001;

import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResult;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2030001.TainoKeikokuMainDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 支払方法変更管理リストハンドラクラスです。
 *
 * @reamsid_L DBD-4340-010 liangbc
 */
public class TainoKeikokuMainHandler {

    private final TainoKeikokuMainDiv div;

    private static final int 小数点以下の有効桁数 = 3;

    /**
     * コンストラクタです。
     *
     * @param div 社会福祉法人等利用者負担軽減申請画面Div
     */
    public TainoKeikokuMainHandler(TainoKeikokuMainDiv div) {
        this.div = div;
    }

    /**
     * 滞納警告情報の表示
     *
     * @param 滞納判定結果 滞納判定結果
     */
    public void 滞納警告情報の表示(TainoHanteiResult 滞納判定結果) {
        div.getTainoKeikoku().getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoTainohanteiKijunbi().setText(
                滞納判定結果.get滞納判定基準日() == null ? RString.EMPTY : 滞納判定結果.get滞納判定基準日().wareki().toDateString());
        div.getTainoKeikoku().getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoSaikonoTainoNokigen().setText(
                滞納判定結果.get最古滞納納期限() == null ? RString.EMPTY : 滞納判定結果.get最古滞納納期限().wareki().toDateString());
        div.getTainoKeikoku().getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoTainohanteiKikan().setText(
                滞納判定結果.get滞納判定期間() == null ? RString.EMPTY : new RStringBuilder().append(滞納判定結果.get滞納判定期間().get年数())
                .append("年-").append(滞納判定結果.get滞納判定期間().get月数Without年数()).append("ヶ月以上").toRString());
        div.getTainoKeikoku().getTblTainoKeikoku().getTblShiharaiHoho().getLblShiharaiHohoTainoKikan().setText(
                滞納判定結果.get滞納期間() == null ? RString.EMPTY : new RStringBuilder().append(滞納判定結果.get滞納期間().getYear())
                .append("年").append(滞納判定結果.get滞納期間().getMonth()).append("ヶ月").toRString());
        div.getTainoKeikoku().getTblKyufugakuGengaku().getLblGengakuTainohanteiKijunbi().setText(
                滞納判定結果.get滞納判定基準日() == null ? RString.EMPTY : 滞納判定結果.get滞納判定基準日().wareki().toDateString());
        div.getTainoKeikoku().getTblKyufugakuGengaku2().getLblGengakuChosukenShometsu().setText(
                (滞納判定結果.get給付額減額() == null || 滞納判定結果.get給付額減額().get徴収権消滅期間() == null) ? RString.EMPTY
                : new RString(滞納判定結果.get給付額減額().get徴収権消滅期間().roundDownTo(小数点以下の有効桁数).toString()));
        div.getTainoKeikoku().getTblKyufugakuGengaku2().getLblGengakuNofuzumi().setText(
                (滞納判定結果.get給付額減額() == null || 滞納判定結果.get給付額減額().get納付済期間() == null) ? RString.EMPTY
                : new RString(滞納判定結果.get給付額減額().get納付済期間().roundDownTo(小数点以下の有効桁数).toString()));
        div.getTainoKeikoku().getTblKyufugakuGengaku2().getLblGengakuNofukgakuGengaku().setText(
                滞納判定結果.get給付額減額() == null ? RString.EMPTY
                : new RStringBuilder().append(滞納判定結果.get給付額減額().get給付額減額期間()).append("ヶ月").toRString());
    }
}

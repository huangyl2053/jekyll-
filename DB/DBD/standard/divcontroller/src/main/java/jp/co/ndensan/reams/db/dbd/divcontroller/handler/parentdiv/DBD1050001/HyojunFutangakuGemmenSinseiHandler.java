/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1050001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.hyojunfutangakugemmen.HyojunFutangakuGemmen;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050001.dgShinseiIchiran_Row;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.hyojunfutangakugemmen.HyojunFutangakuGemmenService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 標準負担額減免申請ハンドラクラスです。
 *
 * @reamsid_L DBD-3700-010 liuwei2
 */
public class HyojunFutangakuGemmenSinseiHandler {

    /**
     * get標準負担額減免申請データ取得処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @return 申請一覧情報
     */
    public List<HyojunFutangakuGemmen> get標準負担額減免申請情報(HihokenshaNo 被保険者番号) {
        return new HyojunFutangakuGemmenService().select標準負担額減免申請情報(被保険者番号);
    }

    /**
     * 申請一覧情報データ処理です。
     *
     * @param 標準負担額減免情報データ 標準負担額減免情報データ
     * @return 最初申請一覧情報
     */
    public ArrayList<dgShinseiIchiran_Row> setDgShinseiIchiran_Row(List<HyojunFutangakuGemmen> 標準負担額減免情報データ) {
        ArrayList<dgShinseiIchiran_Row> 最初申請一覧情報 = new ArrayList<>();
        for (HyojunFutangakuGemmen dbT4012HyojunFutangakuGemmen : 標準負担額減免情報データ) {
            dgShinseiIchiran_Row hyojunFutangakuGemmen = new dgShinseiIchiran_Row();
            hyojunFutangakuGemmen.setTxtShinseiYMD(new RString(dbT4012HyojunFutangakuGemmen.get申請年月日().toString()));
            hyojunFutangakuGemmen.setTxtShinseiRiyu(dbT4012HyojunFutangakuGemmen.get申請事由());
            TextBoxFlexibleDate 決定年月日 = new TextBoxFlexibleDate();
            決定年月日.setValue(new FlexibleDate(dbT4012HyojunFutangakuGemmen.get決定年月日().toString()));
            hyojunFutangakuGemmen.setTxtKetteiYMD(決定年月日);
            hyojunFutangakuGemmen.setTxtKetteiKubun(dbT4012HyojunFutangakuGemmen.get決定区分());
            hyojunFutangakuGemmen.setTxtHyojunFutangaku(new RString(dbT4012HyojunFutangakuGemmen.get減額後金額().toString()));
            hyojunFutangakuGemmen.setTxtGengakuKubun(dbT4012HyojunFutangakuGemmen.get減額区分());
            TextBoxFlexibleDate 適用終了年月日 = new TextBoxFlexibleDate();
            適用終了年月日.setValue(new FlexibleDate(dbT4012HyojunFutangakuGemmen.get適用終了年月日().toString()));
            hyojunFutangakuGemmen.setTxtTekiyoYMD(適用終了年月日);
            hyojunFutangakuGemmen.setTxtShoninShinaiRiyu(dbT4012HyojunFutangakuGemmen.get非承認理由());

            最初申請一覧情報.add(hyojunFutangakuGemmen);
        }
        return 最初申請一覧情報;
    }
}

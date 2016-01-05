/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.DBA1110011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashohakkokanribo.KayiSyuuJiyuu;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashohakkokanribo.KouFuJiyuu;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1110011.BatchPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1110011.dgKaishuJiyu_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1110011.dgKoufuJiyu_Row;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv.DisplayNone;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者証発行管理簿ハンドラクラスです。
 */
public class BatchPanelHandler {

    private final BatchPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 被保険者証発行管理簿Div
     */
    public BatchPanelHandler(BatchPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param kouFuJiyuuList 交付事由リスト
     * @param kayiSyuuJiyuuList　回収事由リスト
     */
    public void initialize(List<KouFuJiyuu> kouFuJiyuuList, List<KayiSyuuJiyuu> kayiSyuuJiyuuList) {
        List<dgKaishuJiyu_Row> dgKaishuJiyuRowList = new ArrayList<>();
        List<dgKoufuJiyu_Row> dgKoufuJiyuRowList = new ArrayList<>();
        for (KouFuJiyuu KouFuJiyuu : kouFuJiyuuList) {
            dgKoufuJiyu_Row dgKoufuJiyuRow = new dgKoufuJiyu_Row();
            dgKoufuJiyuRow.setTxtKofuJiyuCode(new RString(KouFuJiyuu.getコード().toString()));
            dgKoufuJiyuRow.setTxtKofuJiyu(KouFuJiyuu.getコード名称());
            dgKoufuJiyuRowList.add(dgKoufuJiyuRow);

        }
        for (KayiSyuuJiyuu kayiSyuuJiyuu : kayiSyuuJiyuuList) {
            dgKaishuJiyu_Row dgKaishuJiyuRow = new dgKaishuJiyu_Row();
            dgKaishuJiyuRow.setTxtKaishuJiyuCode(new RString(kayiSyuuJiyuu.getコード().toString()));
            dgKaishuJiyuRow.setTxtKaishuJiyu(kayiSyuuJiyuu.getコード名称());
            dgKaishuJiyuRowList.add(dgKaishuJiyuRow);
        }
        div.getDgKaishuJiyu().setDataSource(dgKaishuJiyuRowList);
        div.getDgKoufuJiyu().setDataSource(dgKoufuJiyuRowList);
        div.getCcdChohyoShutsuryokujun().setVisible(true);
        SubGyomuCode subGyomuCode = div.getCcdChohyoShutsuryokujun().getサブ業務コード();
        ReportId reportId = div.getCcdChohyoShutsuryokujun().get帳票ID();
        DisplayNone displayNone = DisplayNone.SORT_ONLY;

    }
}

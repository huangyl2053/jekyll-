/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.ShujiiIkenTokusokujoHakkoReportProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書督促対象者一覧表の出力条件表編集クラスです。
 */
public class ShujiiIkenshoTokusokuTaishoshaIchiranhyoOutputJokenhyoEditor {

    private final ShujiiIkenTokusokujoHakkoReportProcessParameter param;

    /**
     * コンストラクタです。
     *
     * @param param {@link ShujiiIkenTokusokujoHakkoReportProcessParameter}
     */
    public ShujiiIkenshoTokusokuTaishoshaIchiranhyoOutputJokenhyoEditor(
            ShujiiIkenTokusokujoHakkoReportProcessParameter param) {
        this.param = param;
    }

    /**
     * 出力条件を編集して返します。
     *
     * @return 条件リスト
     */
    public List<RString> edit() {
        List<RString> 出力条件List = new ArrayList<>();
        出力条件List.add(new RString("【保険者コード】").concat(edit保険者コード(param.getTemp_保険者コード())));
        出力条件List.add(new RString("【期間】").concat(edit期間(param.getTemp_印刷期間開始日(), param.getTemp_印刷期間終了日())));
        return 出力条件List;
    }

    private RString edit保険者コード(RString 保険者コード) {
        return 保険者コード == null || 保険者コード.isEmpty()
                ? new RString("全市町村")
                : 保険者コード;
    }

    private RString edit期間(RDate from, RDate to) {
        return from.wareki().toDateString().concat("～").concat(to.wareki().toDateString());
    }
}

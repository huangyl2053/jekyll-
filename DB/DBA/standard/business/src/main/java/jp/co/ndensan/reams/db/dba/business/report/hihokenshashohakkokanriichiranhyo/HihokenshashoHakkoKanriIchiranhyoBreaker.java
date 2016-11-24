/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 被保険者証発行管理リストに対して、業務独自のページ切替を行うクラスです。
 *
 * @author n8178
 */
public class HihokenshashoHakkoKanriIchiranhyoBreaker extends PageBreaker<HihokenshashoHakkoKanriIchiranhyoReportSource> {

    private final List<RString> 改頁項目;

    /**
     * コンストラクタです。帳票出力順から出力順項目を受け取り、それを元に改頁項目のリストを作成します。
     * また、抽出条件を帳票に出力するために、隠し改頁項目を設定します。
     *
     * @param 出力順項目 出力順項目
     */
    public HihokenshashoHakkoKanriIchiranhyoBreaker(List<ISetSortItem> 出力順項目) {
        this.改頁項目 = new ArrayList<>();
        for (ISetSortItem item : 出力順項目) {
            if (!item.is改頁項目()) {
                continue;
            }
            for (HihokenshashoHakkoKanriIchiranhyoItems reportItem : HihokenshashoHakkoKanriIchiranhyoItems.values()) {
                if (item.get項目ID().equals(reportItem.get項目ID())) {
                    this.改頁項目.add(reportItem.getフォームフィールド名());
                }
            }
        }
        this.改頁項目.add(HihokenshashoHakkoKanriIchiranhyoItems.隠し改行項目.getフォームフィールド名());
    }

    @Override
    public List<RString> breakKeys() {
        return 改頁項目;
    }

}

package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigogekihenkanwasettei.KaigoGekihenKanwaSettei;

import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBB-1770-020 wangkanglei
 */
public interface IKaigoGekihenKanwaSetteiDiv extends ICommonChildDivBaseProperties {

    /**
     * 激変緩和Gridの初期設定。
     *
     * @param hdnGekihenIndex04 保険料率04
     * @param hdnGekihenIndex05 保険料率05
     * @param hdnGekihenIndex06 保険料率06
     * @param hdnGekihenIndex08 保険料率08
     * @param hdnGekihenIndex09 保険料率09
     * @param hdnGekihenIndex10 保険料率10
     * @param hdnGekihenIndex11 保険料率11
     */
    public void initialize(Decimal hdnGekihenIndex04,
            Decimal hdnGekihenIndex05,
            Decimal hdnGekihenIndex06,
            Decimal hdnGekihenIndex08,
            Decimal hdnGekihenIndex09,
            Decimal hdnGekihenIndex10,
            Decimal hdnGekihenIndex11);
}

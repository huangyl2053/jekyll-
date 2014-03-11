/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IAnsweringItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査票定義を扱うBuilderクラスです。
 *
 * @author N8156 宮本 康
 */
class NinteichosahyoRegulationBuilder {

    private Map<NinteichosaItemKubun, INinteichosaItem> 調査票定義;
    private INinteichosaItemGroup 調査項目グループ = NinteichosaItemGroup.OfCommon.なし;
    private INinteichosaItemSubGroup 調査項目サブグループ = NinteichosaItemSubGroup.OfCommon.なし;
    private int 調査項目グループ内番号 = 1;

    /**
     * インスタンスを生成します。
     *
     * @param 調査票定義 調査票定義
     */
    NinteichosahyoRegulationBuilder(Map<NinteichosaItemKubun, INinteichosaItem> 調査票定義) {
        this.調査票定義 = requireNonNull(調査票定義, Messages.E00001.replace("調査票定義").getMessage());
    }

    /**
     * 調査項目グループ、調査項目サブグループを設定します。
     *
     * @param 調査項目グループ 調査項目グループ
     * @param 調査項目サブグループ 調査項目サブグループ
     */
    void set調査項目グループ(INinteichosaItemGroup 調査項目グループ, INinteichosaItemSubGroup 調査項目サブグループ) {
        this.調査項目グループ = 調査項目グループ;
        this.調査項目サブグループ = 調査項目サブグループ;
        this.調査項目グループ内番号 = 1;
    }

    /**
     * 調査票定義に調査項目を設定します。
     *
     * @param 調査項目番号 調査項目番号
     * @param 調査項目区分 調査項目区分
     * @param 表示名称 表示名称
     * @param 選択肢 選択肢
     */
    void set調査項目(String 調査項目番号, NinteichosaItemKubun 調査項目区分, String 表示名称, IAnsweringItem[] 選択肢) {
        調査票定義.put(調査項目区分,
                new NinteichosaItem(調査項目グループ, 調査項目サブグループ, 調査項目グループ内番号++,
                new NinteichosaItemNo(new RString(調査項目番号)), 調査項目区分, new RString(表示名称), new Choices(選択肢)));
    }
}

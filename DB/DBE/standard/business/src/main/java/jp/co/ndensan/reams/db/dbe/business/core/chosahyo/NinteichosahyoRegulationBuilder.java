/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahyo;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.IAnswerItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.INinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.INinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.NinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.NinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査票定義を扱うBuilderクラスです。
 *
 * @author N8156 宮本 康
 * @param <E> INinteichosaItemKubun
 */
class NinteichosahyoRegulationBuilder<E extends INinteichosaItemKubun> {

    private final Map<E, INinteichosaItem> 調査票定義;
    private INinteichosaItemGroup 調査項目グループ = NinteichosaItemGroup.なし;
    private INinteichosaItemSubGroup 調査項目サブグループ = NinteichosaItemSubGroup.なし;
    private int 調査項目グループ内番号 = 1;
    private int 調査項目サブグループ内番号 = 1;

    /**
     * インスタンスを生成します。
     *
     * @param 調査票定義 調査票定義
     */
    NinteichosahyoRegulationBuilder(Map<E, INinteichosaItem> 調査票定義) {
        this.調査票定義 = requireNonNull(調査票定義, Messages.E00001.replace("調査票定義").getMessage());
    }

    /**
     * 調査項目グループ、調査項目サブグループを設定します。<br />
     * 以前設定した調査項目グループを変更した場合、調査項目グループ内番号を1で初期化します。<br />
     * 以前設定した調査項目グループ、または調査項目サブグループを変更した場合、意見書項目サブグループ内番号を1で初期化します。<br />
     *
     * @param 調査項目グループ 調査項目グループ
     * @param 調査項目サブグループ 調査項目サブグループ
     */
    void set調査項目グループ(INinteichosaItemGroup 調査項目グループ, INinteichosaItemSubGroup 調査項目サブグループ) {
        if (this.調査項目グループ != 調査項目グループ) {
            this.調査項目グループ内番号 = 1;
        }
        if (this.調査項目グループ != 調査項目グループ || this.調査項目サブグループ != 調査項目サブグループ) {
            this.調査項目サブグループ内番号 = 1;
        }
        this.調査項目グループ = 調査項目グループ;
        this.調査項目サブグループ = 調査項目サブグループ;
    }

    /**
     * 調査票定義に調査項目を設定します。
     *
     * @param 調査項目番号 調査項目番号
     * @param 調査項目区分 調査項目区分
     * @param 表示名称 表示名称
     * @param 回答項目 回答項目
     */
    void set調査項目(String 調査項目番号, E 調査項目区分, String 表示名称, IAnswerItem 回答項目) {
        調査票定義.put(調査項目区分,
                new NinteichosaItem(調査項目グループ, 調査項目サブグループ,
                        this.調査項目サブグループ == NinteichosaItemSubGroup.なし ? 調査項目グループ内番号++ : 調査項目グループ内番号,
                        this.調査項目サブグループ != NinteichosaItemSubGroup.なし ? 調査項目サブグループ内番号++ : 調査項目サブグループ内番号,
                        new NinteichosaItemNo(new RString(調査項目番号)), 調査項目区分, new RString(表示名称), 回答項目));
    }
}

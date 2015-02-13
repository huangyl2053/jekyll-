/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.IAnswerItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.IShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.IShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.ShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.ShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIkenshoItemNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 主治医意見書の定義を扱うBuilderクラスです。
 *
 * @author N8156 宮本 康
 * @param <E> IShujiiIkenshoItemKubun
 */
class ShujiiIkenshoRegulationBuilder<E extends IShujiiIkenshoItemKubun> {

    private final Map<E, IShujiiIkenshoItem> 意見書定義;
    private IShujiiIkenshoItemGroup 意見書項目グループ = ShujiiIkenshoItemGroup.なし;
    private IShujiiIkenshoItemSubGroup 意見書項目サブグループ = ShujiiIkenshoItemSubGroup.なし;
    private int 意見書項目グループ内番号 = 1;
    private int 意見書項目サブグループ内番号 = 1;

    /**
     * インスタンスを生成します。
     *
     * @param 意見書定義 意見書定義
     */
    ShujiiIkenshoRegulationBuilder(Map<E, IShujiiIkenshoItem> 意見書定義) {
        this.意見書定義 = requireNonNull(意見書定義, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書定義"));
    }

    /**
     * 意見書項目グループ、意見書項目サブグループを設定します。<br />
     * 以前設定した意見書項目グループを変更した場合、意見書項目グループ内番号を1で初期化します。<br />
     * 以前設定した意見書項目グループ、または意見書項目サブグループを変更した場合、意見書項目サブグループ内番号を1で初期化します。<br />
     *
     * @param 意見書項目グループ 意見書項目グループ
     * @param 意見書項目サブグループ 意見書項目サブグループ
     */
    void set意見書項目グループ(IShujiiIkenshoItemGroup 意見書項目グループ, IShujiiIkenshoItemSubGroup 意見書項目サブグループ) {
        if (this.意見書項目グループ != 意見書項目グループ) {
            this.意見書項目グループ内番号 = 1;
        }
        if (this.意見書項目グループ != 意見書項目グループ || this.意見書項目サブグループ != 意見書項目サブグループ) {
            this.意見書項目サブグループ内番号 = 1;
        }
        this.意見書項目グループ = 意見書項目グループ;
        this.意見書項目サブグループ = 意見書項目サブグループ;
    }

    /**
     * 意見書定義に意見書項目を設定します。
     *
     * @param 意見書項目番号 意見書項目番号
     * @param 意見書項目区分 意見書項目区分
     * @param 表示名称 表示名称
     * @param 回答項目 回答項目
     */
    void set意見書項目(String 意見書項目番号, E 意見書項目区分, String 表示名称, IAnswerItem 回答項目) {
        set意見書項目(意見書項目番号, 意見書項目区分, 表示名称, 回答項目, false);
    }

    /**
     * 意見書定義に主要意見書項目を設定します。
     *
     * @param 意見書項目番号 意見書項目番号
     * @param 意見書項目区分 意見書項目区分
     * @param 表示名称 表示名称
     * @param 回答項目 回答項目
     */
    void set主要意見書項目(String 意見書項目番号, E 意見書項目区分, String 表示名称, IAnswerItem 回答項目) {
        set意見書項目(意見書項目番号, 意見書項目区分, 表示名称, 回答項目, true);
    }

    private void set意見書項目(String 意見書項目番号, E 意見書項目区分, String 表示名称, IAnswerItem 回答項目, boolean 主要項目) {
        意見書定義.put(意見書項目区分,
                new ShujiiIkenshoItem(意見書項目グループ, 意見書項目サブグループ,
                        this.意見書項目サブグループ == ShujiiIkenshoItemSubGroup.なし ? 意見書項目グループ内番号++ : 意見書項目グループ内番号,
                        this.意見書項目サブグループ != ShujiiIkenshoItemSubGroup.なし ? 意見書項目サブグループ内番号++ : 意見書項目サブグループ内番号,
                        new ShujiiIkenshoItemNo(new RString(意見書項目番号)), 意見書項目区分, new RString(表示名称), 回答項目, 主要項目));
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IAnsweringItem;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIkenshoItemNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 主治医意見書の定義を扱うBuilderクラスです。
 *
 * @author N8156 宮本 康
 * @param <E> IShujiiIkenshoItemKubun
 */
class ShujiiIkenshoRegulationBuilder<E extends IShujiiIkenshoItemKubun> {

    private Map<E, IShujiiIkenshoItem> 意見書定義;
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
        this.意見書定義 = requireNonNull(意見書定義, Messages.E00001.replace("意見書定義").getMessage());
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
     * @param 選択肢 選択肢
     */
    void set意見書項目(String 意見書項目番号, E 意見書項目区分, String 表示名称, IAnsweringItem[] 選択肢) {
        set意見書項目(意見書項目番号, 意見書項目区分, 表示名称, 選択肢, false);
    }

    /**
     * 意見書定義に主要意見書項目を設定します。
     *
     * @param 意見書項目番号 意見書項目番号
     * @param 意見書項目区分 意見書項目区分
     * @param 表示名称 表示名称
     * @param 選択肢 選択肢
     */
    void set主要意見書項目(String 意見書項目番号, E 意見書項目区分, String 表示名称, IAnsweringItem[] 選択肢) {
        set意見書項目(意見書項目番号, 意見書項目区分, 表示名称, 選択肢, true);
    }

    private void set意見書項目(String 意見書項目番号, E 意見書項目区分, String 表示名称, IAnsweringItem[] 選択肢, boolean 主要項目) {
        意見書定義.put(意見書項目区分,
                new ShujiiIkenshoItem(意見書項目グループ, 意見書項目サブグループ,
                this.意見書項目サブグループ == ShujiiIkenshoItemSubGroup.なし ? 意見書項目グループ内番号++ : 意見書項目グループ内番号,
                this.意見書項目サブグループ != ShujiiIkenshoItemSubGroup.なし ? 意見書項目サブグループ内番号++ : 意見書項目サブグループ内番号,
                new ShujiiIkenshoItemNo(new RString(意見書項目番号)), 意見書項目区分, new RString(表示名称), new Choices(選択肢), 主要項目));
    }
}

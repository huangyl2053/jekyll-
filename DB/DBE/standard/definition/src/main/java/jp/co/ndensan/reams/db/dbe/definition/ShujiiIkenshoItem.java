/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIkenshoItemNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 主治医意見書の項目を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoItem implements IShujiiIkenshoItem {

    private final IShujiiIkenshoItemGroup 意見書項目グループ;
    private final IShujiiIkenshoItemSubGroup 意見書項目サブグループ;
    private final int 意見書項目グループ内番号;
    private final int 意見書項目サブグループ内番号;
    private final ShujiiIkenshoItemNo 意見書項目番号;
    private final IShujiiIkenshoItemKubun 意見書項目区分;
    private final RString 表示名称;
    private final IAnswerItem 回答項目;
    private final boolean 主要意見書項目;

    /**
     * インスタンスを生成します。
     *
     * @param 意見書項目グループ 意見書項目グループ
     * @param 意見書項目サブグループ 意見書項目サブグループ
     * @param 意見書項目グループ内番号 意見書項目グループ内番号
     * @param 意見書項目サブグループ内番号 意見書項目サブグループ内番号
     * @param 意見書項目番号 意見書項目番号
     * @param 意見書項目区分 意見書項目区分
     * @param 表示名称 表示名称
     * @param 回答項目 回答項目
     * @param 主要意見書項目 主要意見書項目
     */
    public ShujiiIkenshoItem(IShujiiIkenshoItemGroup 意見書項目グループ, IShujiiIkenshoItemSubGroup 意見書項目サブグループ,
            int 意見書項目グループ内番号, int 意見書項目サブグループ内番号, ShujiiIkenshoItemNo 意見書項目番号,
            IShujiiIkenshoItemKubun 意見書項目区分, RString 表示名称, IAnswerItem 回答項目, boolean 主要意見書項目) {
        this.意見書項目グループ = requireNonNull(意見書項目グループ, Messages.E00001.replace("意見書項目グループ").getMessage());
        this.意見書項目サブグループ = requireNonNull(意見書項目サブグループ, Messages.E00001.replace("意見書項目サブグループ").getMessage());
        this.意見書項目グループ内番号 = 意見書項目グループ内番号;
        this.意見書項目サブグループ内番号 = 意見書項目サブグループ内番号;
        this.意見書項目番号 = requireNonNull(意見書項目番号, Messages.E00001.replace("意見書項目番号").getMessage());
        this.意見書項目区分 = requireNonNull(意見書項目区分, Messages.E00001.replace("意見書項目区分").getMessage());
        this.表示名称 = requireNonNull(表示名称, Messages.E00001.replace("表示名称").getMessage());
        this.回答項目 = requireNonNull(回答項目, Messages.E00001.replace("回答項目").getMessage());
        this.主要意見書項目 = 主要意見書項目;
    }

    @Override
    public boolean is意見書結果項目() {
        return false;
    }

    @Override
    public IShujiiIkenshoItemGroup get意見書項目グループ() {
        return 意見書項目グループ;
    }

    @Override
    public IShujiiIkenshoItemSubGroup get意見書項目サブグループ() {
        return 意見書項目サブグループ;
    }

    @Override
    public int get意見書項目グループ内番号() {
        return 意見書項目グループ内番号;
    }

    @Override
    public int get意見書項目サブグループ内番号() {
        return 意見書項目サブグループ内番号;
    }

    @Override
    public ShujiiIkenshoItemNo get意見書項目番号() {
        return 意見書項目番号;
    }

    @Override
    public IShujiiIkenshoItemKubun get意見書項目区分() {
        return 意見書項目区分;
    }

    @Override
    public RString get表示名称() {
        return 表示名称;
    }

    @Override
    public IAnswerItem get回答項目() {
        return 回答項目;
    }

    @Override
    public boolean is主要意見書項目() {
        return 主要意見書項目;
    }
}

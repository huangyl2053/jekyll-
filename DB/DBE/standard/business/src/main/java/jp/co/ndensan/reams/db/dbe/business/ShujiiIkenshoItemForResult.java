/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.Choices;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Choice;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IAnsweringItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.FreeInputItem;
import jp.co.ndensan.reams.db.dbe.definition.IShujiiIkenshoItem;
import jp.co.ndensan.reams.db.dbe.definition.ShujiiIkenshoItem;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIkenshoItemNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 主治医意見書の結果（意見書項目単位）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoItemForResult implements IShujiiIkenshoItem {

    private final ShujiiIkenshoItem 意見書項目;
    private final RString 意見書結果;

    /**
     * インスタンスを生成します。
     *
     * @param 意見書項目 意見書項目
     * @param 意見書結果 意見書結果
     */
    public ShujiiIkenshoItemForResult(ShujiiIkenshoItem 意見書項目, RString 意見書結果) {
        this.意見書項目 = requireNonNull(意見書項目, Messages.E00001.replace("意見書項目").getMessage());
        this.意見書結果 = requireNonNull(意見書結果, Messages.E00001.replace("意見書結果").getMessage());
    }

    @Override
    public boolean is意見書結果項目() {
        return true;
    }

    @Override
    public IShujiiIkenshoItemGroup get意見書項目グループ() {
        return 意見書項目.get意見書項目グループ();
    }

    @Override
    public IShujiiIkenshoItemSubGroup get意見書項目サブグループ() {
        return 意見書項目.get意見書項目サブグループ();
    }

    @Override
    public int get意見書項目グループ内番号() {
        return 意見書項目.get意見書項目グループ内番号();
    }

    @Override
    public int get意見書項目サブグループ内番号() {
        return 意見書項目.get意見書項目サブグループ内番号();
    }

    @Override
    public ShujiiIkenshoItemNo get意見書項目番号() {
        return 意見書項目.get意見書項目番号();
    }

    @Override
    public IShujiiIkenshoItemKubun get意見書項目区分() {
        return 意見書項目.get意見書項目区分();
    }

    @Override
    public RString get表示名称() {
        return 意見書項目.get表示名称();
    }

    @Override
    public Choices get選択肢() {
        return 意見書項目.get選択肢();
    }

    @Override
    public boolean is主要意見書項目() {
        return 意見書項目.is主要意見書項目();
    }

    /**
     * 意見書項目を返します。
     *
     * @return 意見書項目
     */
    public ShujiiIkenshoItem get意見書項目() {
        return 意見書項目;
    }

    /**
     * 意見書結果（生値）を返します。
     *
     * @return 意見書結果（生値）
     */
    public RString get意見書結果() {
        return 意見書結果;
    }

    /**
     * 回答結果を返します。
     *
     * @return 回答結果
     */
    public IAnsweringItem get回答結果() {
        for (IAnsweringItem data : 意見書項目.get選択肢().asList()) {
            if (data.getValue().equals(Choice.FreeInput.自由入力.getValue())) {
                return new FreeInputItem(意見書結果);
            }
        }
        return 意見書項目.get選択肢().toValue(意見書結果);
    }
}

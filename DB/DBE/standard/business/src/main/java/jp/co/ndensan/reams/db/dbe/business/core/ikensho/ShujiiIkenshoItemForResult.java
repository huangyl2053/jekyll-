/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho;

import jp.co.ndensan.reams.db.dbe.business.core.IAnswerItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.IShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.IShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.IAnswerResultItem;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIkenshoItemNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
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
        this.意見書項目 = requireNonNull(意見書項目, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書項目"));
        this.意見書結果 = requireNonNull(意見書結果, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書結果"));
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
    public IAnswerItem get回答項目() {
        return 意見書項目.get回答項目();
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
    public IAnswerResultItem get回答結果() {
        return 意見書項目.get回答項目().toValue(意見書結果);
    }
}

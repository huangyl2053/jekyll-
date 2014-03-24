/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IAnsweringItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.FreeInputItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.IAnsweringItems;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.INinteichosaItem;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果（調査項目単位）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaItemForResult implements INinteichosaItem {

    private final INinteichosaItem 調査項目;
    private final RString 調査結果;

    /**
     * インスタンスを生成します。
     *
     * @param 調査項目 調査項目
     * @param 調査結果 調査結果
     */
    public NinteichosaItemForResult(INinteichosaItem 調査項目, RString 調査結果) {
        this.調査項目 = requireNonNull(調査項目, Messages.E00001.replace("調査項目").getMessage());
        this.調査結果 = requireNonNull(調査結果, Messages.E00001.replace("調査結果").getMessage());
    }

    @Override
    public INinteichosaItemGroup get調査項目グループ() {
        return 調査項目.get調査項目グループ();
    }

    @Override
    public INinteichosaItemSubGroup get調査項目サブグループ() {
        return 調査項目.get調査項目サブグループ();
    }

    @Override
    public int get調査項目グループ内番号() {
        return 調査項目.get調査項目グループ内番号();
    }

    @Override
    public int get調査項目サブグループ内番号() {
        return 調査項目.get調査項目サブグループ内番号();
    }

    @Override
    public NinteichosaItemNo get調査項目番号() {
        return 調査項目.get調査項目番号();
    }

    @Override
    public INinteichosaItemKubun get調査項目区分() {
        return 調査項目.get調査項目区分();
    }

    @Override
    public RString get表示名称() {
        return 調査項目.get表示名称();
    }

    @Override
    public IAnsweringItems get選択肢() {
        return 調査項目.get選択肢();
    }

    /**
     * 調査結果（生値）を返します。
     *
     * @return 調査結果（生値）
     */
    public RString get調査結果() {
        return 調査結果;
    }

    /**
     * 回答結果を返します。
     *
     * @return 回答結果
     */
    public IAnsweringItem get回答結果() {
        for (IAnsweringItem data : 調査項目.get選択肢().asList()) {
            if (data.getName().equals(Choice.FreeInput.自由入力.getName())) {
                return new FreeInputItem(調査結果);
            }
        }
        return 調査項目.get選択肢().toValue(調査結果);
    }
}

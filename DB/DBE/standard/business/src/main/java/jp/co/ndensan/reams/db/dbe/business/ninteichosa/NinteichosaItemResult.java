/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IAnsweringItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.IAnsweringItems;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.INinteichosaItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaItem;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果情報を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaItemResult implements INinteichosaItem {

    private final NinteichosaItem 調査項目;
    private final RString 調査結果コード;

    /**
     * インスタンスを生成します。
     *
     * @param 調査項目 調査項目
     * @param 調査結果コード 調査結果コード
     */
    public NinteichosaItemResult(NinteichosaItem 調査項目, RString 調査結果コード) {
        this.調査項目 = requireNonNull(調査項目, Messages.E00001.replace("調査項目").getMessage());
        this.調査結果コード = requireNonNull(調査結果コード, Messages.E00001.replace("調査結果コード").getMessage());
    }

    @Override
    public IChosahyoItemGroup get調査票項目グループ() {
        return 調査項目.get調査票項目グループ();
    }

    @Override
    public IChosahyoItemSubGroup get調査票項目サブグループ() {
        return 調査項目.get調査票項目サブグループ();
    }

    @Override
    public int get調査票項目サブグループ内番号() {
        return 調査項目.get調査票項目サブグループ内番号();
    }

    @Override
    public NinteichosaItemNo get調査項目番号() {
        return 調査項目.get調査項目番号();
    }

    @Override
    public ChosahyoItems get調査票項目() {
        return 調査項目.get調査票項目();
    }

    @Override
    public RString get表示名称() {
        return 調査項目.get表示名称();
    }

    @Override
    public IAnsweringItems get選択肢グループ() {
        return 調査項目.get選択肢グループ();
    }

    /**
     * 調査結果コードを返します。
     *
     * @return 調査結果コード
     */
    public RString get調査結果コード() {
        return 調査結果コード;
    }

    /**
     * 調査結果を返します。
     *
     * @return 調査結果
     */
    public IAnsweringItem get調査結果() {
        return 調査項目.get選択肢グループ().toValue(調査結果コード);
    }
}

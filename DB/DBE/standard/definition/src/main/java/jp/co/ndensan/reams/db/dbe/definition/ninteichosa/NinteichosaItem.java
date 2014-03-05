/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査項目情報を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaItem implements INinteichosaItem {

    private final IChosahyoItemGroup 調査票項目グループ;
    private final IChosahyoItemSubGroup 調査票項目サブグループ;
    private final int 調査票項目サブグループ内番号;
    private final NinteichosaItemNo 調査項目番号;
    private final ChosahyoItems 調査票項目;
    private final RString 表示名称;
    private final IAnsweringItems 選択肢グループ;

    /**
     * インスタンスを生成します。
     *
     * @param 調査票項目グループ 調査票項目グループ
     * @param 調査票項目サブグループ 調査票項目サブグループ
     * @param 調査票項目サブグループ内番号 調査票項目サブグループ内番号
     * @param 調査項目番号 調査項目番号
     * @param 調査票項目 調査票項目
     * @param 表示名称 表示名称
     * @param 選択肢グループ 選択肢グループ
     */
    public NinteichosaItem(IChosahyoItemGroup 調査票項目グループ, IChosahyoItemSubGroup 調査票項目サブグループ, int 調査票項目サブグループ内番号,
            NinteichosaItemNo 調査項目番号, ChosahyoItems 調査票項目, RString 表示名称, IAnsweringItems 選択肢グループ) {
        this.調査票項目グループ = requireNonNull(調査票項目グループ, Messages.E00001.replace("調査票項目グループ").getMessage());
        this.調査票項目サブグループ = requireNonNull(調査票項目サブグループ, Messages.E00001.replace("調査票項目サブグループ").getMessage());
        this.調査票項目サブグループ内番号 = 調査票項目サブグループ内番号;
        this.調査項目番号 = requireNonNull(調査項目番号, Messages.E00001.replace("調査項目番号").getMessage());
        this.調査票項目 = requireNonNull(調査票項目, Messages.E00001.replace("調査票項目").getMessage());
        this.表示名称 = requireNonNull(表示名称, Messages.E00001.replace("表示名称").getMessage());
        this.選択肢グループ = requireNonNull(選択肢グループ, Messages.E00001.replace("選択肢グループ").getMessage());
    }

    @Override
    public IChosahyoItemGroup get調査票項目グループ() {
        return 調査票項目グループ;
    }

    @Override
    public IChosahyoItemSubGroup get調査票項目サブグループ() {
        return 調査票項目サブグループ;
    }

    @Override
    public int get調査票項目サブグループ内番号() {
        return 調査票項目サブグループ内番号;
    }

    @Override
    public NinteichosaItemNo get調査項目番号() {
        return 調査項目番号;
    }

    @Override
    public ChosahyoItems get調査票項目() {
        return 調査票項目;
    }

    @Override
    public RString get表示名称() {
        return 表示名称;
    }

    @Override
    public IAnsweringItems get選択肢グループ() {
        return 選択肢グループ;
    }
}

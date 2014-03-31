/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.Choices;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査項目を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaItem implements INinteichosaItem {

    private final INinteichosaItemGroup 調査項目グループ;
    private final INinteichosaItemSubGroup 調査項目サブグループ;
    private final int 調査項目グループ内番号;
    private final int 調査項目サブグループ内番号;
    private final NinteichosaItemNo 調査項目番号;
    private final INinteichosaItemKubun 調査項目区分;
    private final RString 表示名称;
    private final Choices 選択肢;

    /**
     * インスタンスを生成します。
     *
     * @param 調査項目グループ 調査項目グループ
     * @param 調査項目サブグループ 調査項目サブグループ
     * @param 調査項目グループ内番号 調査項目グループ内番号
     * @param 調査項目サブグループ内番号 調査項目サブグループ内番号
     * @param 調査項目番号 調査項目番号
     * @param 調査項目区分 調査項目区分
     * @param 表示名称 表示名称
     * @param 選択肢 選択肢
     */
    public NinteichosaItem(INinteichosaItemGroup 調査項目グループ, INinteichosaItemSubGroup 調査項目サブグループ,
            int 調査項目グループ内番号, int 調査項目サブグループ内番号, NinteichosaItemNo 調査項目番号,
            INinteichosaItemKubun 調査項目区分, RString 表示名称, Choices 選択肢) {
        this.調査項目グループ = requireNonNull(調査項目グループ, Messages.E00001.replace("調査項目グループ").getMessage());
        this.調査項目サブグループ = requireNonNull(調査項目サブグループ, Messages.E00001.replace("調査項目サブグループ").getMessage());
        this.調査項目グループ内番号 = 調査項目グループ内番号;
        this.調査項目サブグループ内番号 = 調査項目サブグループ内番号;
        this.調査項目番号 = requireNonNull(調査項目番号, Messages.E00001.replace("調査項目番号").getMessage());
        this.調査項目区分 = requireNonNull(調査項目区分, Messages.E00001.replace("調査項目区分").getMessage());
        this.表示名称 = requireNonNull(表示名称, Messages.E00001.replace("表示名称").getMessage());
        this.選択肢 = requireNonNull(選択肢, Messages.E00001.replace("選択肢").getMessage());
    }

    @Override
    public boolean is調査結果項目() {
        return false;
    }

    @Override
    public INinteichosaItemGroup get調査項目グループ() {
        return 調査項目グループ;
    }

    @Override
    public INinteichosaItemSubGroup get調査項目サブグループ() {
        return 調査項目サブグループ;
    }

    @Override
    public int get調査項目グループ内番号() {
        return 調査項目グループ内番号;
    }

    @Override
    public int get調査項目サブグループ内番号() {
        return 調査項目サブグループ内番号;
    }

    @Override
    public NinteichosaItemNo get調査項目番号() {
        return 調査項目番号;
    }

    @Override
    public INinteichosaItemKubun get調査項目区分() {
        return 調査項目区分;
    }

    @Override
    public RString get表示名称() {
        return 表示名称;
    }

    @Override
    public Choices get選択肢() {
        return 選択肢;
    }
}

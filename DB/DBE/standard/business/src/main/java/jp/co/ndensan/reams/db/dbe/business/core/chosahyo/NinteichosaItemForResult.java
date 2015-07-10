/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahyo;

import jp.co.ndensan.reams.db.dbe.business.core.IAnswerItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.IAnswerResultItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.INinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.INinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果（調査項目単位）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaItemForResult implements INinteichosaItem {

    private final NinteichosaItem 調査項目;
    private final RString 調査結果;

    /**
     * インスタンスを生成します。
     *
     * @param 調査項目 調査項目
     * @param 調査結果 調査結果
     */
    public NinteichosaItemForResult(NinteichosaItem 調査項目, RString 調査結果) {
        this.調査項目 = requireNonNull(調査項目, UrSystemErrorMessages.値がnull.getReplacedMessage("調査項目"));
        this.調査結果 = requireNonNull(調査結果, UrSystemErrorMessages.値がnull.getReplacedMessage("調査結果"));
    }

    @Override
    public boolean is調査結果項目() {
        return true;
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
    public IAnswerItem get回答項目() {
        return 調査項目.get回答項目();
    }

    /**
     * 調査項目を返します。
     *
     * @return 調査項目
     */
    public NinteichosaItem get調査項目() {
        return 調査項目;
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
    public IAnswerResultItem get回答結果() {
        return 調査項目.get回答項目().toValue(調査結果);
    }
}

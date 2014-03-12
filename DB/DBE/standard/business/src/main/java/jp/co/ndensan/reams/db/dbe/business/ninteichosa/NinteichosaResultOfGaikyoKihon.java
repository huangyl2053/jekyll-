/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果（概況調査基本）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResultOfGaikyoKihon {

    private final NinteichosaIraiKubunCode 認定調査依頼区分;
    private final int 認定調査回数;
    private final FlexibleDate 認定調査実施年月日;
    private final FlexibleDate 認定調査受領年月日;
    private final NinteichosaKubun 認定調査区分;
    private final INinteiChosain 認定調査員;
    private final NinteichosaJisshibashoKubun 認定調査実施場所区分;
    private final ShinsakaiFuriwakeKubun 審査会優先振分区分;

    /**
     * インスタンスを生成します。
     *
     * @param 認定調査依頼区分 認定調査依頼区分
     * @param 認定調査回数 認定調査回数
     * @param 認定調査実施年月日 認定調査実施年月日
     * @param 認定調査受領年月日 認定調査受領年月日
     * @param 認定調査区分 認定調査区分
     * @param 認定調査員 認定調査員
     * @param 認定調査実施場所区分 認定調査実施場所区分
     * @param 審査会優先振分区分 審査会優先振分区分
     */
    public NinteichosaResultOfGaikyoKihon(
            NinteichosaIraiKubunCode 認定調査依頼区分,
            int 認定調査回数,
            FlexibleDate 認定調査実施年月日,
            FlexibleDate 認定調査受領年月日,
            NinteichosaKubun 認定調査区分,
            INinteiChosain 認定調査員,
            NinteichosaJisshibashoKubun 認定調査実施場所区分,
            ShinsakaiFuriwakeKubun 審査会優先振分区分) {
        this.認定調査依頼区分 = requireNonNull(認定調査依頼区分, Messages.E00001.replace("認定調査依頼区分").getMessage());
        this.認定調査回数 = requireNonNull(認定調査回数, Messages.E00001.replace("認定調査回数").getMessage());
        this.認定調査実施年月日 = requireNonNull(認定調査実施年月日, Messages.E00001.replace("認定調査実施年月日").getMessage());
        this.認定調査受領年月日 = requireNonNull(認定調査受領年月日, Messages.E00001.replace("認定調査受領年月日").getMessage());
        this.認定調査区分 = requireNonNull(認定調査区分, Messages.E00001.replace("認定調査区分").getMessage());
        this.認定調査員 = requireNonNull(認定調査員, Messages.E00001.replace("認定調査員").getMessage());
        this.認定調査実施場所区分 = requireNonNull(認定調査実施場所区分, Messages.E00001.replace("認定調査実施場所区分").getMessage());
        this.審査会優先振分区分 = requireNonNull(審査会優先振分区分, Messages.E00001.replace("審査会優先振分区分").getMessage());
    }

    /**
     * 認定調査依頼区分を返します。
     *
     * @return 認定調査依頼区分
     */
    public NinteichosaIraiKubunCode get認定調査依頼区分() {
        return 認定調査依頼区分;
    }

    /**
     * 認定調査回数を返します。
     *
     * @return 認定調査回数
     */
    public int get認定調査回数() {
        return 認定調査回数;
    }

    /**
     * 認定調査実施年月日を返します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return 認定調査実施年月日;
    }

    /**
     * 認定調査受領年月日を返します。
     *
     * @return 認定調査受領年月日
     */
    public FlexibleDate get認定調査受領年月日() {
        return 認定調査受領年月日;
    }

    /**
     * 認定調査区分を返します。
     *
     * @return 認定調査区分
     */
    public NinteichosaKubun get認定調査区分() {
        return 認定調査区分;
    }

    /**
     * 認定調査員を返します。
     *
     * @return 認定調査員
     */
    public INinteiChosain get認定調査員() {
        return 認定調査員;
    }

    /**
     * 認定調査実施場所区分を返します。
     *
     * @return 認定調査実施場所区分
     */
    public NinteichosaJisshibashoKubun get認定調査実施場所区分() {
        return 認定調査実施場所区分;
    }

    /**
     * 審査会優先振分区分を返します。
     *
     * @return 審査会優先振分区分
     */
    public ShinsakaiFuriwakeKubun get審査会優先振分区分() {
        return 審査会優先振分区分;
    }
}

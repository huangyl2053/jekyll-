/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果（概況調査基本）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResultOfGaikyoKihon {

    private final FlexibleDate 認定調査実施年月日;
    private final NinteichosaIraiKubunCode 認定調査依頼区分;
    private final NinteichosaJisshibashoKubun 認定調査実施場所区分;
// TODO N8156 宮本 康 認定調査依頼担当者のチケット完了後に対応
//    private final NinteichosaIraiTaishosha 認定調査依頼対象者情報;
    private final NinteichosaKubun 認定調査区分;
    private final ShinsakaiFuriwakeKubun 審査会優先振分区分;

    /**
     * インスタンスを生成します。
     *
     * @param 認定調査実施年月日 認定調査実施年月日
     * @param 認定調査依頼区分 認定調査依頼区分
     * @param 認定調査実施場所区分 認定調査実施場所区分
     * @param 認定調査区分 認定調査区分
     * @param 審査会優先振分区分 審査会優先振分区分
     */
    public NinteichosaResultOfGaikyoKihon(
            FlexibleDate 認定調査実施年月日,
            NinteichosaIraiKubunCode 認定調査依頼区分,
            NinteichosaJisshibashoKubun 認定調査実施場所区分,
            NinteichosaKubun 認定調査区分,
            ShinsakaiFuriwakeKubun 審査会優先振分区分) {
        this.認定調査実施年月日 = requireNonNull(認定調査実施年月日, Messages.E00001.replace("認定調査実施年月日").getMessage());
        this.認定調査依頼区分 = requireNonNull(認定調査依頼区分, Messages.E00001.replace("認定調査依頼区分").getMessage());
        this.認定調査実施場所区分 = requireNonNull(認定調査実施場所区分, Messages.E00001.replace("認定調査実施場所区分").getMessage());
        this.認定調査区分 = requireNonNull(認定調査区分, Messages.E00001.replace("認定調査区分").getMessage());
        this.審査会優先振分区分 = requireNonNull(審査会優先振分区分, Messages.E00001.replace("審査会優先振分区分").getMessage());
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
     * 認定調査依頼区分を返します。
     *
     * @return 認定調査依頼区分
     */
    public NinteichosaIraiKubunCode get認定調査依頼区分() {
        return 認定調査依頼区分;
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
     * 認定調査区分を返します。
     *
     * @return 認定調査区分
     */
    public NinteichosaKubun get認定調査区分() {
        return 認定調査区分;
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

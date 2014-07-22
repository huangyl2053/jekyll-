/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgress;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
// TODO N8187 久保田英男 URのNinteiChosainのキャメルケースをNinteichosainに修正する。URを修正するタイミングで対応する。
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 認定調査依頼対象者の対応付けを行うクラスです。
 *
 * @author N8187 久保田 英男
 */
public final class NinteichosaIraiTaishoshaMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteichosaIraiTaishoshaMapper() {
    }

    /**
     * 引数で渡されたパラメータから認定調査依頼対象者への対応付けを行います。
     *
     * @param 認定進捗情報 認定進捗情報
     * @param 要介護認定申請情報 要介護認定申請情報
     * @param 個人 個人
     * @param 認定調査委託先情報 認定調査委託先情報
     * @param 事業者情報 事業者情報
     * @param 認定調査員情報 認定調査員情報
     * @return 認定調査依頼対象者
     * @throws NullPointerException
     * {@code 認定進捗情報}がnullの場合、{@code 要介護認定申請情報}がnullの場合、または{@code 個人}がnullの場合
     */
    public static NinteichosaIraiTaishosha toNinteichosaIraiTaishosha(
            YokaigoNinteiProgress 認定進捗情報,
            YokaigoNinteiShinsei 要介護認定申請情報,
            IKojin 個人,
            NinteichosaItakusaki 認定調査委託先情報,
            IKaigoJigyosha 事業者情報,
            INinteiChosain 認定調査員情報) throws NullPointerException {

        requireNonNull(認定進捗情報, Messages.E00003.replace("認定進捗情報", " 認定調査依頼対象者").getMessage());
        requireNonNull(要介護認定申請情報, Messages.E00003.replace("要介護認定申請情報", " 認定調査依頼対象者").getMessage());
        requireNonNull(個人, Messages.E00003.replace("個人", " 認定調査依頼対象者").getMessage());

        return new NinteichosaIraiTaishosha(
                認定進捗情報,
                要介護認定申請情報.get申請書管理番号(),
                要介護認定申請情報.get証記載保険者番号(),
                要介護認定申請情報.get被保番号(),
                要介護認定申請情報.get認定申請年月日(),
                要介護認定申請情報.get認定申請区分_申請時(),
                個人,
                個人.get氏名().getName().value(),
                個人.get住所().getValue(),
                認定調査委託先情報,
                事業者情報,
                認定調査員情報);
    }

}

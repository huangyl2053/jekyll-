/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgress;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼対象者のビジネスクラスとエンティティの変換を行うクラスです。
 *
 * @author N8187 久保田 英男
 */
public final class ShujiiIkenshoIraiTaishoshaMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ShujiiIkenshoIraiTaishoshaMapper() {
    }

    /**
     * 渡されたパラメータから、主治医意見書作成依頼対象者への対応付けを行います。
     *
     * @param 認定進捗情報 認定進捗情報
     * @param 認定申請情報 認定申請情報
     * @param 個人 個人
     * @param 氏名 氏名
     * @param 住所 住所
     * @param 主治医医療機関 主治医医療機関
     * @param 主治医 主治医
     * @return 主治医意見書作成依頼対象者
     * @throws NullPointerException
     * {@code 認定進捗情報}がnullの場合、または{@code 認定申請情報}がnullの場合
     */
    public static ShujiiIkenshoIraiTaishosha toShujiiIkenshoIraiTaishosha(
            YokaigoNinteiProgress 認定進捗情報,
            YokaigoNinteiShinsei 認定申請情報,
            IKojin 個人,
            RString 氏名,
            RString 住所,
            KaigoIryoKikan 主治医医療機関,
            KaigoDoctor 主治医) throws NullPointerException {

        requireNonNull(認定進捗情報, Messages.E00003.replace("認定進捗情報", " 主治医意見書作成依頼対象者").getMessage());
        requireNonNull(認定申請情報, Messages.E00003.replace("認定申請情報", "主治医意見書作成依頼対象者").getMessage());

        return new ShujiiIkenshoIraiTaishosha(
                認定進捗情報,
                認定申請情報.get申請書管理番号(),
                認定申請情報.get証記載保険者番号(),
                認定申請情報.get被保番号(),
                認定申請情報.get認定申請年月日(),
                認定申請情報.get認定申請区分_申請時(),
                個人,
                氏名,
                住所,
                主治医医療機関,
                主治医);
    }

}

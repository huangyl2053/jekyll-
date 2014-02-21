/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IDoctor;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
     * @param 認定申請情報Entity 認定申請情報Entity
     * @param 個人 個人
     * @param 氏名 氏名
     * @param 住所 住所
     * @param 主治医医療機関 主治医医療機関
     * @param 主治医 主治医
     * @return 主治医意見書作成依頼対象者
     * @throws NullPointerException {@code 認定申請情報Entity}がnullの場合
     */
    public static ShujiiIkenshoIraiTaishosha toShujiiIkenshoIraiTaishosha(
            DbT5001NinteiShinseiJohoEntity 認定申請情報Entity,
            IKojin 個人,
            RString 氏名,
            RString 住所,
            KaigoIryoKikan 主治医医療機関,
            IDoctor 主治医) throws NullPointerException {

        requireNonNull(認定申請情報Entity, Messages.E00003.replace("認定申請情報Entity", "主治医意見書作成依頼対象者").getMessage());

        ShinseishoKanriNo 申請書管理番号 = 認定申請情報Entity.getShinseishoKanriNo();
        ShichosonCode 市町村コード = 認定申請情報Entity.getShichosonCode();
        KaigoHihokenshaNo 被保険者番号 = 認定申請情報Entity.getHihokenshaNo();
        FlexibleDate 認定申請年月日 = 認定申請情報Entity.getNinteiShinseiYMD();
        RString 認定申請区分 = 認定申請情報Entity.getNinteiShinseiShinseijiKubunCode();

        return new ShujiiIkenshoIraiTaishosha(
                申請書管理番号,
                市町村コード,
                被保険者番号,
                認定申請年月日,
                認定申請区分,
                個人,
                氏名,
                住所,
                主治医医療機関,
                主治医);
    }
}

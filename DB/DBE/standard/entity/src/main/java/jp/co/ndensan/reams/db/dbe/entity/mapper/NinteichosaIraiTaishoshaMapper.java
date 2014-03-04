/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urf.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urf.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urf.entity.mapper.KaigoJigyoshaMapper;
import jp.co.ndensan.reams.ur.urf.entity.mapper.NinteiChosainMapper;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.entity.basic.KojinEntity;
import jp.co.ndensan.reams.ur.urz.entity.mapper.helper.IKojinFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.ur.urz.business.JushoEditor;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushoEditPattern;

/**
 * 認定調査対象者のビジネスクラスとエンティティの変換を行うクラスです。
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
     * 各エンティティから認定調査依頼対象者への対応付けを行います。
     *
     * @param 要介護認定申請情報Entity 要介護認定申請情報Entity
     * @param 個人 個人情報
     * @param 認定調査委託先Entity 認定調査委託先Entity
     * @param 介護事業者Entity 介護事業者Entity
     * @param 調査員情報Entity 調査員情報Entity
     * @return 認定調査依頼対象者
     * @throws NullPointerException
     * {@code 要介護認定申請情報Entity}がnullの場合、または{@code 個人Entity}がnullの場合
     */
    public static NinteichosaIraiTaishosha toNinteichosaIraiTaishosha(
            DbT5001NinteiShinseiJohoEntity 要介護認定申請情報Entity,
            IKojin 個人,
            DbT7010NinteichosaItakusakiJohoEntity 認定調査委託先Entity,
            KaigoJigyoshaEntity 介護事業者Entity,
            ChosainJohoEntity 調査員情報Entity) throws NullPointerException {

        requireNonNull(要介護認定申請情報Entity, Messages.E00003.replace("要介護認定申請情報Entity", "認定調査対象者").getMessage());
        requireNonNull(個人, Messages.E00003.replace("個人", "認定調査対象者").getMessage());

        ShinseishoKanriNo 申請書管理番号 = 要介護認定申請情報Entity.getShinseishoKanriNo();
        ShichosonCode 市町村コード = 要介護認定申請情報Entity.getShichosonCode();
        KaigoHihokenshaNo 被保険者 = 要介護認定申請情報Entity.getHihokenshaNo();
        FlexibleDate 認定申請年月日 = 要介護認定申請情報Entity.getNinteiShinseiYMD();
        RString 認定申請区分 = 要介護認定申請情報Entity.getNinteiShinseiShinseijiKubunCode().getColumnValue();
        IKojin 個人情報 = 個人;
//        IShikibetsuTaisho 識別対象 = ShikibetsuTaishoFactory.create(個人Entity);
        RString 氏名 = 個人.get氏名().getName();
        RString 住所 = 個人.get住所().getValue();
        NinteichosaItakusaki 認定調査委託先 = create認定調査委託先(認定調査委託先Entity);
        IKaigoJigyosha 事業者情報 = create介護事業者(介護事業者Entity);
        INinteiChosain 認定調査員情報 = create認定調査員(調査員情報Entity, 事業者情報);

        return new NinteichosaIraiTaishosha(
                申請書管理番号, 市町村コード, 被保険者,
                認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所,
                認定調査委託先, 事業者情報, 認定調査員情報);
    }

    private static NinteichosaItakusaki create認定調査委託先(DbT7010NinteichosaItakusakiJohoEntity entity) {
        return isNull(entity) ? null : NinteichosaItakusakiMapper.toNinteichosaItakusaki(entity);
    }

    private static IKaigoJigyosha create介護事業者(KaigoJigyoshaEntity entity) {
        return isNull(entity) ? null : KaigoJigyoshaMapper.toKaigoJigyosha(entity);
    }

    private static INinteiChosain create認定調査員(ChosainJohoEntity entity, IKaigoJigyosha 介護事業者) {
        boolean isUncreatable = isNull(entity) || isNull(介護事業者);
        return isUncreatable ? null : NinteiChosainMapper.toNinteiChosain(entity, 介護事業者);
    }

    private static <T> boolean isNull(T object) {
        return object == null;
    }
}

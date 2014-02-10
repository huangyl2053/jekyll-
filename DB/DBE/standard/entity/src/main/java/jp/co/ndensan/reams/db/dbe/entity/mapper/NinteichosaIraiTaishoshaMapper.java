/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urf.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urf.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urf.entity.mapper.KaigoJigyoshaMapper;
import jp.co.ndensan.reams.ur.urf.entity.mapper.NinteiChosainMapper;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.entity.basic.KojinEntity;
import jp.co.ndensan.reams.ur.urz.entity.mapper.helper.IKojinFactory;
import jp.co.ndensan.reams.ur.urz.entity.mapper.helper.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.ur.urz.business.JushoEditor;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushoEditPattern;

/**
 * 認定調査対象者のビジネスクラスとエンティティの変換を行うクラスです
 *
 * @author N8187 久保田 英男
 */
public final class NinteichosaIraiTaishoshaMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです
     */
    private NinteichosaIraiTaishoshaMapper() {
    }

    /**
     * 各エンティティから認定調査対象者への対応付けを行います
     *
     * @param 要介護認定申請情報Entity 要介護認定申請情報Entity
     * @param 要介護認定進捗情報Entity 要介護認定進捗情報Entity
     * @param 個人Enity 個人Enity
     * @param 認定調査委託先Entity 認定調査委託先Entity
     * @param 介護事業者Entity 介護事業者Entity
     * @param 調査員情報Entity 調査員情報Entity
     * @return 認定調査対象者
     * @throws NullPointerException
     * {@code 要介護認定申請情報Entity}がnullの場合、{@code 要介護認定進捗情報Entity}がnullの場合、または{@code 個人Enity}がnullの場合
     */
    public static NinteichosaIraiTaishosha toNinteichosaIraiTaishosha(
            DbT5001NinteiShinseiJohoEntity 要介護認定申請情報Entity,
            DbT5005NinteiShinchokuJohoEntity 要介護認定進捗情報Entity,
            KojinEntity 個人Enity,
            DbT7010NinteichosaItakusakiJohoEntity 認定調査委託先Entity,
            KaigoJigyoshaEntity 介護事業者Entity,
            ChosainJohoEntity 調査員情報Entity) throws NullPointerException {

        requireNonNull(要介護認定申請情報Entity, Messages.E00003.replace("要介護認定申請情報Entity", "認定調査対象者").getMessage());
        requireNonNull(要介護認定進捗情報Entity, Messages.E00003.replace("要介護認定進捗情報Entity", "認定調査対象者").getMessage());
        requireNonNull(個人Enity, Messages.E00003.replace("個人エンティティ", "認定調査対象者").getMessage());

        ShinseishoKanriNo 申請書管理番号 = 要介護認定申請情報Entity.getShinseishoKanriNo();
        RString 市町村コード = 要介護認定申請情報Entity.getShichosonCode().getValue();
        KaigoHihokenshaNumber 被保険者 = 要介護認定申請情報Entity.getHihokenshaNo();
        FlexibleDate 認定申請年月日 = 要介護認定申請情報Entity.getNinteiShinseiYMD();
        RString 認定申請区分 = 要介護認定申請情報Entity.getNinteiShinseiShinseijiKubunCode();
        IKojin 個人情報 = IKojinFactory.create(個人Enity);
        IShikibetsuTaisho 識別対象 = ShikibetsuTaishoFactory.create(個人Enity);
        RString 氏名 = 識別対象.get氏名().getName();
        RString 住所 = JushoEditor.editJusho(識別対象.get住所(), JushoEditPattern.町域番地);

        NinteichosaItakusaki 認定調査委託先;
        IKaigoJigyosha 事業者情報;
        INinteiChosain 認定調査員情報;

        if (認定調査委託先Entity == null) {
            認定調査委託先 = null;
        } else {
            認定調査委託先 = NinteichosaItakusakiMapper.toNinteichosaItakusaki(認定調査委託先Entity);
        }
        if (介護事業者Entity == null) {
            事業者情報 = null;
        } else {
            事業者情報 = KaigoJigyoshaMapper.toKaigoJigyosha(介護事業者Entity);
        }
        if (調査員情報Entity == null || 事業者情報 == null) {
            認定調査員情報 = null;
        } else {
            認定調査員情報 = NinteiChosainMapper.toNinteiChosain(調査員情報Entity, 事業者情報);
        }

        return new NinteichosaIraiTaishosha(
                申請書管理番号, 市町村コード, 被保険者,
                認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所,
                認定調査委託先, 事業者情報, 認定調査員情報);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.INinteiChosain;
import jp.co.ndensan.reams.db.dbx.business._NinteiChosain;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho._Name;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;

/**
 * 調査員情報エンティティ変換クラスです。
 *
 * @author N2204 三井 沙織
 * @jpName 認定調査員マッパー
 * @bizDomain 介護
 * @category 認定調査員
 * @subCategory
 * @mainClass
 * @reference
 */
public final class NinteiChosainMapper {

    private NinteiChosainMapper() {
    }

    /**
     * 調査員情報エンティティから認定調査員を作成します。
     *
     * @param entity 調査員情報エンティティ
     * @param 所属事業者 所属事業者
     * @return {@link INinteiChosain}を実装したクラスのインスタンス
     */
    public static INinteiChosain toNinteiChosain(ChosainJohoEntity entity, IKaigoJigyosha 所属事業者) {
        IName 氏名 = new _Name(new AtenaMeisho(entity.get調査員氏名()), new AtenaKanaMeisho(entity.get調査員氏名カナ()));
        return new _NinteiChosain(entity.get介護調査員番号(), 氏名, 所属事業者);
    }

    /**
     * 調査員情報エンティティリストから認定調査員のリストを作成します。
     *
     * @param entityList 調査員情報エンティティリスト
     * @param 所属事業者 所属事業者
     * @return {@link INinteiChosain}のリスト
     */
    public static List<INinteiChosain> toNinteiChosain(List<ChosainJohoEntity> entityList, IKaigoJigyosha 所属事業者) {
        List<INinteiChosain> ninteiChosain = new ArrayList();
        for (ChosainJohoEntity entity : entityList) {
            ninteiChosain.add(toNinteiChosain(entity, 所属事業者));
        }
        return ninteiChosain;
    }
}

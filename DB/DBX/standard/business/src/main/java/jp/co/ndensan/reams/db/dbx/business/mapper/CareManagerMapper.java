/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.ICareManager;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core._CareManager;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho._Name;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * ケアマネージャエンティティ変換クラスです。
 *
 * @author n9944 趙 春暉
 * @jpName ケアマネージャマッパー
 * @bizDomain 介護
 * @category ケアマネージャ
 * @subCategory
 * @mainClass
 * @reference
 */
public final class CareManagerMapper {

    private CareManagerMapper() {
    }

    /**
     * ケアマネージャエンティティからケアマネージャを作成します。
     *
     * @param entity ケアマネージャエンティティ
     * @param 所属事業者 所属事業者
     * @return {@link ICareManager}を実装したクラスのインスタンス
     */
    public static ICareManager toCareManager(DbT7064CareManegerEntity entity, IKaigoJigyosha 所属事業者) {
        IName 氏名 = new _Name(entity.getKaigoShienSenmoninMei(), entity.getKaigoShienSenmoninMeiKana());
        return new _CareManager(entity.getKaigoShienSenmoninNo(), 氏名, 所属事業者, new Range(entity.getYukoKaishiDate(), entity.getYukoShuryoDate()));
    }

    /**
     * ケアマネージャエンティティリストからケアマネージャのリストを作成します。
     *
     * @param entityList ケアマネージャエンティティリスト
     * @param 所属事業者 所属事業者
     * @return {@link ICareManager}のリスト
     */
    public static List<ICareManager> toCareManager(List<DbT7064CareManegerEntity> entityList, IKaigoJigyosha 所属事業者) {
        List<ICareManager> result = new ArrayList();
        for (DbT7064CareManegerEntity entity : entityList) {
            result.add(toCareManager(entity, 所属事業者));
        }
        return result;
    }
}

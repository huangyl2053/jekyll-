/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoService;
import jp.co.ndensan.reams.db.dbx.business.core._KaigoService;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;

/**
 * 介護サービスのコンバーターです。
 *
 * @author n8104 小玉　洋一
 * @jpName 介護サービスマッパー
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public final class KaigoServiceMapper {

    private KaigoServiceMapper() {
    }

    /**
     * IKaigoServiceの型にして返します。
     *
     * @param shuruiEntities 介護サービス種類
     * @param kaigoServiceNaiyoList 介護サービス内容
     * @return 介護サービス
     */
    public static IKaigoService to介護サービス(
            List<DbT7130KaigoServiceShuruiEntity> shuruiEntities, List<DbT7131KaigoServiceNaiyouEntity> kaigoServiceNaiyoList) {
        if (shuruiEntities.isEmpty()) {
            return absentOf介護サービス種類(kaigoServiceNaiyoList);
        }
        return make介護サービス種類(shuruiEntities, kaigoServiceNaiyoList);
    }

    private static IKaigoService absentOf介護サービス種類(List<DbT7131KaigoServiceNaiyouEntity> kaigoServiceNaiyoList) throws IllegalArgumentException {

        if (kaigoServiceNaiyoList.isEmpty()) {
            return null;
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する介護サービス種類").evaluate());
    }

    private static IKaigoService make介護サービス種類(
            List<DbT7130KaigoServiceShuruiEntity> shuruiEntities, List<DbT7131KaigoServiceNaiyouEntity> kaigoServiceNaiyoList) {
        if (kaigoServiceNaiyoList.isEmpty()) {
            return convertI介護サービス(shuruiEntities.get(0), Collections.EMPTY_LIST);
        }
        return convertI介護サービス(shuruiEntities.get(0), kaigoServiceNaiyoList);
    }

    private static IKaigoService convertI介護サービス(
            DbT7130KaigoServiceShuruiEntity shuruiEntity, List<DbT7131KaigoServiceNaiyouEntity> kaigoServiceNaiyoList) {
        return new _KaigoService(KaigoServiceShuruiMapper.to介護サービス種類(shuruiEntity),
                KaigoServiceNaiyoMapper.to介護サービス内容リスト(kaigoServiceNaiyoList));
    }
}

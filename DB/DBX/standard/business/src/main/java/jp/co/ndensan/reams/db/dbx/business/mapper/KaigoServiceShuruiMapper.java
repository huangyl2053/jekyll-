/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.business.core._KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 介護サービス種類のコンバーターです。
 *
 * @author n8104 小玉　洋一
 * @jpName 介護サービス種類マッパー
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public final class KaigoServiceShuruiMapper {

    private KaigoServiceShuruiMapper() {
    }

    /**
     * IKaigoServiceShuruiの型にして返します。
     *
     * @param kaigoServiceShuruiEntity 介護サービス種類
     * @return 介護サービス種類
     */
    public static IKaigoServiceShurui to介護サービス種類(DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity) {
        requireNonNull(kaigoServiceShuruiEntity, UrSystemErrorMessages.引数がnullのため生成不可.
                getReplacedMessage("kaigoServiceShuruiEntity", "IKaigoServiceShurui"));
        IKaigoServiceShurui kaigoServiceShurui = new _KaigoServiceShurui(kaigoServiceShuruiEntity.getServiceShuruiCd(),
                new Range<>(kaigoServiceShuruiEntity.getTeikyoKaishiYM(),
                        kaigoServiceShuruiEntity.getTeikyoshuryoYM()),
                kaigoServiceShuruiEntity.getServiceShuruiMeisho(),
                kaigoServiceShuruiEntity.getServiceShuruiRyakusho(),
                kaigoServiceShuruiEntity.getServiceBunrruicode());
        return kaigoServiceShurui;
    }

    /**
     * KaigoServiceShuruiEntityの型にして返します。
     *
     * @param kaigoServiceShurui 介護サービス種類
     * @return 介護サービス内容Entity
     */
    public static DbT7130KaigoServiceShuruiEntity to介護サービス種類Entity(IKaigoServiceShurui kaigoServiceShurui) {

        requireNonNull(kaigoServiceShurui, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("kaigoServiceShurui", "KaigoServiceShuruiEntity"));
        DbT7130KaigoServiceShuruiEntity entity = new DbT7130KaigoServiceShuruiEntity();
        entity.setServiceShuruiCd(kaigoServiceShurui.getサービス種類コード());
        entity.setTeikyoKaishiYM(kaigoServiceShurui.get提供年月().getFrom());
        entity.setTeikyoshuryoYM(kaigoServiceShurui.get提供年月().getTo());
        entity.setServiceShuruiMeisho(kaigoServiceShurui.getサービス種類名称());
        entity.setServiceShuruiRyakusho(kaigoServiceShurui.getサービス種類名称略称());
        entity.setServiceBunrruicode(kaigoServiceShurui.getサービス分類());

        return entity;
    }

    /**
     * IKaigoServiceShurui型のリストにして返します。
     *
     * @param entities 介護サービス種類リスト
     * @return 介護サービス種類リスト
     */
    public static List<IKaigoServiceShurui> to介護サービス種類リスト(List<DbT7130KaigoServiceShuruiEntity> entities) {
        List<IKaigoServiceShurui> kaigoServiceShuruiList = new ArrayList<>();
        if (entities.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        for (DbT7130KaigoServiceShuruiEntity entity : entities) {
            kaigoServiceShuruiList.add(to介護サービス種類(entity));
        }
        return kaigoServiceShuruiList;
    }
}

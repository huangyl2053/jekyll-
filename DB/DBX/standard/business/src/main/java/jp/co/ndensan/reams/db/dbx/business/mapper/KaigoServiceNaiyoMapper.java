/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoServiceCode;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoServiceNaiyo;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoServiceTani;
import jp.co.ndensan.reams.db.dbx.business.core._KaigoServiceCode;
import jp.co.ndensan.reams.db.dbx.business.core._KaigoServiceNaiyo;
import jp.co.ndensan.reams.db.dbx.business.core._KaigoServiceTani;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護サービス内容のコンバーターです。
 *
 * @author n8104　小玉　洋一
 * @jpName 介護サービス内容マッパー
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public final class KaigoServiceNaiyoMapper {

    private KaigoServiceNaiyoMapper() {
    }

    /**
     * IKaigoServiceNaiyoの型にして返します。
     *
     * @param kaigoServiceNaiyoEntity 介護サービス内容
     * @return 介護サービス内容
     */
    public static IKaigoServiceNaiyo to介護サービス内容(DbT7131KaigoServiceNaiyouEntity kaigoServiceNaiyoEntity) {
        Objects.requireNonNull(kaigoServiceNaiyoEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("kaigoServiceNaiyoEntity"));
        IKaigoServiceCode 介護サービスコード = new _KaigoServiceCode(
                kaigoServiceNaiyoEntity.getServiceShuruiCode(), kaigoServiceNaiyoEntity.getServiceKoumokuCode());
        IKaigoServiceTani サービス単位 = new _KaigoServiceTani(
                kaigoServiceNaiyoEntity.getTaniSu(),
                kaigoServiceNaiyoEntity.getTanisuShikibetsuCode(),
                kaigoServiceNaiyoEntity.getTanisuSanteiTani());
        IKaigoServiceNaiyo kaigoServicenaiyo = new _KaigoServiceNaiyo(介護サービスコード,
                new Range<>(kaigoServiceNaiyoEntity.getTeikyoKaishiYM(),
                        kaigoServiceNaiyoEntity.getTeikyoShuryoYM()),
                kaigoServiceNaiyoEntity.getRirekiNo().intValue(),
                kaigoServiceNaiyoEntity.getServiceName(),
                kaigoServiceNaiyoEntity.getServiceNameRyaku(),
                サービス単位);

        return kaigoServicenaiyo;
    }

    /**
     * KaigoServiceNaiyoEntityの型にして返します。
     *
     * @param kaigoServiceNaiyo 介護サービス内容
     * @return 介護サービス内容Entity
     */
    public static DbT7131KaigoServiceNaiyouEntity to介護サービス内容Entity(IKaigoServiceNaiyo kaigoServiceNaiyo) {
        requireNonNull(kaigoServiceNaiyo, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("kaigoServiceNaiyo", "KaigoServiceNaiyoEntity"));

        DbT7131KaigoServiceNaiyouEntity entity = new DbT7131KaigoServiceNaiyouEntity();
        entity.setServiceShuruiCode(kaigoServiceNaiyo.getサービスコード().getサービス種類コード());
        entity.setServiceKoumokuCode(kaigoServiceNaiyo.getサービスコード().getサービス項目コード());
        entity.setTeikyoKaishiYM(kaigoServiceNaiyo.get適用年月().getFrom());
        entity.setTeikyoShuryoYM(kaigoServiceNaiyo.get適用年月().getTo());
        entity.setRirekiNo(new Decimal(kaigoServiceNaiyo.get履歴番号()));
        entity.setServiceName(kaigoServiceNaiyo.getサービス名称());
        entity.setServiceNameRyaku(kaigoServiceNaiyo.getサービス略称());
        entity.setTaniSu(kaigoServiceNaiyo.get介護サービス単位().get単位数());
        entity.setTanisuShikibetsuCode(kaigoServiceNaiyo.get介護サービス単位().get単位数識別());
        entity.setTanisuSanteiTani(kaigoServiceNaiyo.get介護サービス単位().get単位数算定単位());
        return entity;
    }

    /**
     * IKaigoServiceNaiyo型のリストにして返します。
     *
     * @param naiyoEntities 介護サービス内容リスト
     * @return 介護サービス内容リスト
     */
    public static List<IKaigoServiceNaiyo> to介護サービス内容リスト(List<DbT7131KaigoServiceNaiyouEntity> naiyoEntities) {
        List<IKaigoServiceNaiyo> kaigoServiceNaiyoList = new ArrayList<>();
        if (naiyoEntities.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        for (DbT7131KaigoServiceNaiyouEntity naiyoEntity : naiyoEntities) {
            kaigoServiceNaiyoList.add(to介護サービス内容(naiyoEntity));
        }

        return kaigoServiceNaiyoList;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.RenkeiyoDataSofuKiroku;
import jp.co.ndensan.reams.db.dbe.definition.HikiwatashiKubun;
import jp.co.ndensan.reams.db.dbe.definition.NinteiShinseijiKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiChousaSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiIkenshoSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiSoufuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5022RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 連携用データ送付記録のビジネスクラスとエンティティの変換を行うクラスです。
 *
 * @author N8107 千秋雄
 */
public final class RenkeiyoDataSofuKirokuMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private RenkeiyoDataSofuKirokuMapper() {
    }

    /**
     * 連携用データ送付記録エンティティから連携用データ送付記録への対応付けを行います。
     *
     * @param entity 連携用データ送付記録Entity
     * @return 連携用データ送付記録
     * @throws NullPointerException {@code 連携用データ送付記録Entity}がnullの場合
     */
    public static RenkeiyoDataSofuKiroku toRenkeiyoDataSofuKiroku(DbT5022RenkeiyoDataSofuKirokuEntity entity) throws NullPointerException {
        requireNonNull(entity, Messages.E00003.replace("連携用データ送付記録Entity", "連携用データ送付記録").getMessage());
        ShinseishoKanriNo 申請書管理番号 = entity.getShinseishoKanriNo();
        YMDHMS 処理日時 = entity.getShoriTimestamp();
        KaigoHihokenshaNo 被保険者番号 = entity.getHihokenshaNo();
        NinteiShinseijiKubun 認定申請時区分 = NinteiShinseijiKubun.toValue(entity.getNinteiShinseiShinseijiKubun());
        HikiwatashiKubun 引渡し区分 = HikiwatashiKubun.toValue(entity.getHikiwatashiKubun());
        SaiSoufuKubun 再送付区分 = SaiSoufuKubun.toValue(entity.getSaiSoufuKubun());
        SaiChousaSoufuKubun 再調査送付区分 = SaiChousaSoufuKubun.toValue(entity.getSaiChousaSoufuKubun());
        SaiIkenshoSoufuKubun 再意見書送付区分 = SaiIkenshoSoufuKubun.toValue(entity.getSaiIkenshoSoufuKubun());

        return new RenkeiyoDataSofuKiroku(申請書管理番号, 処理日時, 被保険者番号, 認定申請時区分, 引渡し区分,
                entity.getHikiwatashiNichiji(), 再送付区分, 再調査送付区分, 再意見書送付区分);

    }
}

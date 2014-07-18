/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisageTaishosha;
import jp.co.ndensan.reams.db.dbe.business.TorisageRiyu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;

/**
 * 認定申請情報Entityを認定申請取下げ対象者クラスに変換するためのMapperです。
 *
 * @author n8178 城間篤人
 */
public final class NinteishinseiTorisageTaishoshaMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private NinteishinseiTorisageTaishoshaMapper() {
    }

    /**
     * 認定申請情報Entityを認定申請取下げ対象者クラスに変換します。
     *
     * @param entity 認定申請情報Entity
     * @return 認定申請取下げ対象者クラス
     */
    public static NinteiShinseiTorisageTaishosha to認定申請取下げ対象者(DbT5001NinteiShinseiJohoEntity entity) {
        return new NinteiShinseiTorisageTaishosha(entity.getShinseishoKanriNo(), entity.getShoKisaiHokenshaNo(), entity.getHihokenshaNo(),
                entity.getNinteiShinseiYMD(), entity.getNinteiShinseiShinseijiKubunCode(), create認定申請取下げ(entity));
    }

    private static NinteiShinseiTorisage create認定申請取下げ(DbT5001NinteiShinseiJohoEntity entity) {
        return new NinteiShinseiTorisage(
                TorisageKubun.toValue(entity.getTorisageKubunCode()),
                new TorisageRiyu(entity.getTorisageRiyu()),
                entity.getTorisageYMD(),
                ShinsaKeizokuKubun.toValue(entity.getShinsaKeizokuKubun()));
    }

    /**
     * 認定申請情報Entityと認定申請取下げの情報を受け取り、申請の取下げに関しての情報を更新した認定申請情報Entityを返します。
     *
     * @param entity 認定申請情報Entity
     * @param 認定申請取下げ情報 認定申請取下げ情報
     * @return 申請の取下げに関しての情報を更新した認定申請情報Entity
     */
    public static DbT5001NinteiShinseiJohoEntity to認定申請情報Entity(DbT5001NinteiShinseiJohoEntity entity,
            NinteiShinseiTorisage 認定申請取下げ情報) {
        DbT5001NinteiShinseiJohoEntity 更新済みEntity = cloneEntity(entity);
        更新済みEntity.setTorisageKubunCode(認定申請取下げ情報.get取下げ区分().get取下げ区分コード());
        更新済みEntity.setTorisageRiyu(認定申請取下げ情報.get取下げ理由().asRString());
        更新済みEntity.setTorisageYMD(認定申請取下げ情報.get取下げ年月日());
        更新済みEntity.setShinsaKeizokuKubun(認定申請取下げ情報.get申請継続区分().is継続());
        return 更新済みEntity;
    }

    private static DbT5001NinteiShinseiJohoEntity cloneEntity(DbT5001NinteiShinseiJohoEntity entity) {
        DbT5001NinteiShinseiJohoEntity 更新済みEntity = new DbT5001NinteiShinseiJohoEntity();
        更新済みEntity.setInsertDantaiCd(entity.getInsertDantaiCd());
        更新済みEntity.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        更新済みEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        更新済みEntity.setShishoCode(entity.getShishoCode());
        更新済みEntity.setHihokenshaNo(entity.getHihokenshaNo());
        更新済みEntity.setShikibetsuCode(entity.getShikibetsuCode());
        更新済みEntity.setNinteiShinseiYMD(entity.getNinteiShinseiYMD());
        更新済みEntity.setNinteiShinseiEdabanCode(entity.getNinteiShinseiEdabanCode());
        更新済みEntity.setNinteiShinseiShinseijiKubunCode(entity.getNinteiShinseiShinseijiKubunCode());
        更新済みEntity.setNinteiShinseiHoreiKubunCode(entity.getNinteiShinseiHoreiKubunCode());
        更新済みEntity.setNinteiShinseiYukoKubunCode(entity.getNinteiShinseiYukoKubunCode());
        更新済みEntity.setShienShinseiKubun(entity.getShienShinseiKubun());
        更新済みEntity.setShinseiRiyu(entity.getShinseiRiyu());
        更新済みEntity.setZenYokaigoKubunCode(entity.getZenYokaigoKubunCode());
        更新済みEntity.setZenYukoKikan(entity.getZenYukoKikan());
        更新済みEntity.setJohoteikyoDouiUmuKubun(entity.getJohoteikyoDouiUmuKubun());
        更新済みEntity.setNinteichosaIraiRirekiNo(entity.getNinteichosaIraiRirekiNo());
        更新済みEntity.setIkenshoIraiRirekiNo(entity.getIkenshoIraiRirekiNo());
        更新済みEntity.setMinashiCode(entity.getMinashiCode());
        更新済みEntity.setEnkitsuchiDoiUmuKubun(entity.getEnkitsuchiDoiUmuKubun());
        更新済みEntity.setShisetsuNyushoUmuKubun(entity.getShisetsuNyushoUmuKubun());
        更新済みEntity.setSichosonRenrakuJiko(entity.getSichosonRenrakuJiko());
        更新済みEntity.setTorisageKubunCode(entity.getTorisageKubunCode());
        更新済みEntity.setTorisageRiyu(entity.getTorisageRiyu());
        更新済みEntity.setTorisageYMD(entity.getTorisageYMD());
        更新済みEntity.setShinsaKeizokuKubun(entity.getShinsaKeizokuKubun());
        return 更新済みEntity;
    }
}

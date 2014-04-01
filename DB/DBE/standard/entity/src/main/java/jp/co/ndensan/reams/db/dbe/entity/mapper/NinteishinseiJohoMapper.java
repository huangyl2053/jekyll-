/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 認定申請情報のMapperです。
 *
 * @author n8178 城間篤人
 */
//TODO n8178 城間篤人 認定申請情報の実装にあわせて再修正予定 2014年2月末
public final class NinteishinseiJohoMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private NinteishinseiJohoMapper() {
    }

    /**
     * 認定申請情報Entityを認定申請情報クラスに変換します。
     *
     * @param entity 認定申請情報Entity
     * @return 認定申請情報クラス
     */
    public static NinteiShinseiJoho to認定申請情報(DbT5001NinteiShinseiJohoEntity entity) {
        return new NinteiShinseiJoho(
                entity.getShinseishoKanriNo(),
                entity.getShoKisaiHokenshaNo(),
                entity.getShishoCode(),
                entity.getHihokenshaNo(),
                entity.getShikibetsuCode(),
                entity.getNinteiShinseiYMD().toRDate(),
                entity.getNinteiShinseiEdabanCode(),
                entity.getNinteiShinseiShinseijiKubunCode(),
                entity.getNinteiShinseiHoreiKubunCode(),
                entity.getNinteiShinseiYukoKubunCode(),
                new Code(entity.getShienShinseiKubun()),
                entity.getShinseiRiyu(),
                entity.getZenYokaigoKubunCode(),
                entity.getZenYukoKikan(),
                entity.getJohoteikyoDouiUmuKubun(),
                entity.getNinteichosaIraiRirekiNo(),
                entity.getIkenshoIraiRirekiNo(),
                new Code(entity.getMinashiCode()),
                entity.getEnkitsuchiDoiUmuKubun(),
                entity.getShisetsuNyushoUmuKubun(),
                entity.getSichosonRenrakuJiko(),
                new NinteiShinseiTorisage(TorisageKubun.toValue(entity.getTorisageKubunCode()),
                entity.getTorisageRiyu(), entity.getTorisageYMD(),
                ShinsaKeizokuKubun.toValue(entity.getShinsaKeizokuKubun())));
    }

    /**
     * 認定申請情報を、認定申請情報EntityにMappingします。
     *
     * @param 認定申請情報 認定申請情報
     * @return 申請の取下げに関しての情報を更新した認定申請情報Entity
     */
    public static DbT5001NinteiShinseiJohoEntity to認定申請情報Entity(NinteiShinseiJoho 認定申請情報) {
        DbT5001NinteiShinseiJohoEntity 更新済みEntity = new DbT5001NinteiShinseiJohoEntity();
        更新済みEntity.setShinseishoKanriNo(認定申請情報.get申請書管理番号());
        更新済みEntity.setNinteichosaIraiRirekiNo(認定申請情報.get認定調査依頼履歴番号());
        更新済みEntity.setShoKisaiHokenshaNo(認定申請情報.get証記載保険者番号());
        更新済みEntity.setShishoCode(認定申請情報.get支所コード());
        更新済みEntity.setHihokenshaNo(認定申請情報.get介護被保険者番号());
        更新済みEntity.setShikibetsuCode(認定申請情報.get識別コード());
        更新済みEntity.setNinteiShinseiYMD(認定申請情報.get認定申請年月日().toFlexibleDate());
        更新済みEntity.setNinteiShinseiEdabanCode(認定申請情報.get枝番コード());
        更新済みEntity.setNinteiShinseiShinseijiKubunCode(認定申請情報.get認定申請区分_申請時());
        更新済みEntity.setNinteiShinseiHoreiKubunCode(認定申請情報.get認定申請区分_法令());
        更新済みEntity.setNinteiShinseiYukoKubunCode(認定申請情報.get認定申請有効区分());
        //TODO n8178 城間篤人 後日、要支援申請区分を作成予定 2014年2月末
        更新済みEntity.setShienShinseiKubun(認定申請情報.get要支援申請区分().getColumnValue());
        更新済みEntity.setShinseiRiyu(認定申請情報.get認定申請理由());
        更新済みEntity.setZenYokaigoKubunCode(認定申請情報.get前回要介護状態区分コード());
        更新済みEntity.setZenYukoKikan(認定申請情報.get前回申請有効期間());
        更新済みEntity.setJohoteikyoDouiUmuKubun(認定申請情報.is情報提供への同意有無());
        更新済みEntity.setIkenshoIraiRirekiNo(認定申請情報.get意見書依頼履歴番号());
        更新済みEntity.setMinashiCode(認定申請情報.getみなし要介護区分コード().getColumnValue());
        更新済みEntity.setEnkitsuchiDoiUmuKubun(認定申請情報.is延期通知有無同意());
        更新済みEntity.setShisetsuNyushoUmuKubun(認定申請情報.is施設入所());
        更新済みEntity.setSichosonRenrakuJiko(認定申請情報.get市町村連絡事項());
        更新済みEntity.setTorisageKubunCode(認定申請情報.get認定申請取下げ().get取下げ区分().get取下げ区分コード());
        更新済みEntity.setTorisageRiyu(認定申請情報.get認定申請取下げ().get取下げ理由());
        更新済みEntity.setTorisageYMD(認定申請情報.get認定申請取下げ().get取下げ年月日());
        更新済みEntity.setShinsaKeizokuKubun(認定申請情報.get認定申請取下げ().get申請継続区分().is継続());
        return 更新済みEntity;
    }
}

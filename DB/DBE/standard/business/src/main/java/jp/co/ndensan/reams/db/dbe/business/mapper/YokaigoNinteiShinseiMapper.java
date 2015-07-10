/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteiResultSimple;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiRiyu;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbe.business.TorisageRiyu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiYusenWaritsukeKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請情報のMapperです。
 *
 * @author n8178 城間篤人
 */
//TODO n8178 城間篤人 認定申請情報の実装にあわせて再修正予定 2014年2月末
public final class YokaigoNinteiShinseiMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private YokaigoNinteiShinseiMapper() {
    }

    /**
     * 認定申請情報Entityを認定申請情報クラスに変換します。
     *
     * @param entity 認定申請情報Entity
     * @return 認定申請情報クラス
     */
    public static YokaigoNinteiShinsei toYokaigoNinteiShinsei(DbT5001NinteiShinseiJohoEntity entity) {
        return new YokaigoNinteiShinsei(
                new ShinseishoKanriNo(entity.getShinseishoKanriNo()),
                entity.getShoriTimestamp(),
                new ShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo()),
                new ShishoCode(entity.getShishoCode()),
                new HihokenshaNo(entity.getHihokenshaNo()),
                entity.getShikibetsuCode(),
                entity.getNinteiShinseiYMD(),
                entity.getNinteiShinseiEdabanCode(),
                entity.getNinteiShinseiShinseijiKubunCode(),
                entity.getNinteiShinseiHoreiKubunCode(),
                entity.getNinteiShinseiYukoKubunCode(),
                new Code(entity.getShienShinseiKubun()),
                new NinteiShinseiRiyu(entity.getShinseiRiyu()),
                //TODO n3327 三浦凌 とりあえずは、すべて前回結果は「無し」とし、結果が参照可能となった時点で修正する。
                NinteiResultSimple.NONE,
                entity.getJohoteikyoDouiUmuKubun(),
                new NinteichosaIraiRirekiNo(entity.getNinteichosaIraiRirekiNo()),
                entity.getIkenshoIraiRirekiNo(),
                new Code(entity.getMinashiCode()),
                entity.getEnkitsuchiDoiUmuKubun(),
                entity.getShisetsuNyushoUmuKubun(),
                entity.getSichosonRenrakuJiko(),
                new NinteiShinseiTorisage(
                        TorisageKubun.toValue(entity.getTorisageKubunCode()),
                        new TorisageRiyu(entity.getTorisageRiyu()),
                        entity.getTorisageYMD(),
                        ShinsaKeizokuKubun.toValue(entity.getShinsaKeizokuKubun())
                ),
                //TODO n3327 三浦凌 ShinsakaiYusenWaritukeKubunがentityに存在しない。自動生成のために、DBのテーブルを修正する必要がある。
                ShinsakaiYusenWaritsukeKubun.defaultValue(),
                entity.getIfSofuYMD()
        );
    }

    /**
     * 認定申請情報を、認定申請情報EntityにMappingします。
     *
     * @param yokaigoNinteiShinsei 認定申請情報
     * @return 申請の取下げに関しての情報を更新した認定申請情報Entity
     */
    public static DbT5001NinteiShinseiJohoEntity toDbT5001NinteiShinseiJohoEntity(YokaigoNinteiShinsei yokaigoNinteiShinsei) {
        DbT5001NinteiShinseiJohoEntity entity = new DbT5001NinteiShinseiJohoEntity();
        entity.setShinseishoKanriNo(yokaigoNinteiShinsei.get申請書管理番号().value());
        entity.setShoriTimestamp(yokaigoNinteiShinsei.get処理日時());
        entity.setNinteichosaIraiRirekiNo(yokaigoNinteiShinsei.get認定調査依頼履歴番号().value());
        entity.setShoKisaiHokenshaNo(yokaigoNinteiShinsei.get証記載保険者番号().value());
        entity.setShishoCode(yokaigoNinteiShinsei.get支所コード().value());
        entity.setHihokenshaNo(yokaigoNinteiShinsei.get被保番号().value());
        entity.setShikibetsuCode(yokaigoNinteiShinsei.get識別コード());
        entity.setNinteiShinseiYMD(yokaigoNinteiShinsei.get認定申請年月日());
        entity.setNinteiShinseiEdabanCode(yokaigoNinteiShinsei.get枝番コード());
        entity.setNinteiShinseiShinseijiKubunCode(yokaigoNinteiShinsei.get認定申請区分_申請時());
        entity.setNinteiShinseiHoreiKubunCode(yokaigoNinteiShinsei.get認定申請区分_法令());
        entity.setNinteiShinseiYukoKubunCode(yokaigoNinteiShinsei.get認定申請有効区分());
        //TODO n8178 城間篤人 後日、要支援申請区分を作成予定 2014年2月末
        entity.setShienShinseiKubun(yokaigoNinteiShinsei.get要支援申請区分().getColumnValue());
        entity.setShinseiRiyu(yokaigoNinteiShinsei.get認定申請理由().asRString());
        entity.setZenYokaigoKubunCode(yokaigoNinteiShinsei.get前回認定結果().get要介護度().getCode());
        entity.setZenYukoKikan(yokaigoNinteiShinsei.get前回認定結果().get認定有効期間().get有効期間月数().value());
        entity.setJohoteikyoDouiUmuKubun(yokaigoNinteiShinsei.is情報提供への同意有無());
        entity.setNinteichosaShikibetsuCode(new Code(RString.EMPTY));
        entity.setIkenshoIraiRirekiNo(yokaigoNinteiShinsei.get意見書依頼履歴番号());
        entity.setMinashiCode(yokaigoNinteiShinsei.getみなし要介護区分コード().getColumnValue());
        entity.setEnkitsuchiDoiUmuKubun(yokaigoNinteiShinsei.is延期通知有無同意());
        entity.setShisetsuNyushoUmuKubun(yokaigoNinteiShinsei.is施設入所());
        entity.setSichosonRenrakuJiko(yokaigoNinteiShinsei.get市町村連絡事項());
        entity.setTorisageKubunCode(yokaigoNinteiShinsei.get認定申請取下げ().get取下げ区分().get取下げ区分コード());
        entity.setTorisageRiyu(yokaigoNinteiShinsei.get認定申請取下げ().get取下げ理由().asRString());
        entity.setTorisageYMD(yokaigoNinteiShinsei.get認定申請取下げ().get取下げ年月日());
        entity.setShinsaKeizokuKubun(yokaigoNinteiShinsei.get認定申請取下げ().get申請継続区分().is継続());
        entity.setIfSofuYMD(yokaigoNinteiShinsei.getIF送付年月日());
        return entity;
    }
}

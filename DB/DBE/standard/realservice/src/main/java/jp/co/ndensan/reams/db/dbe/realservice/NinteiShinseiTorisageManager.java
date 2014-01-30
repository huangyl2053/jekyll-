/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisageTaishosha;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisageTaishoshaList;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteishinseiTorisageTaishoshaMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;

/**
 * 介護認定申請を取り下げる際の情報を管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteiShinseiTorisageManager {

    private final INinteiShinseiJohoDac shinseiDac;

    /**
     * デフォルトコンストラクタです。
     */
    public NinteiShinseiTorisageManager() {
        shinseiDac = InstanceCreator.create(INinteiShinseiJohoDac.class);
    }

    /**
     * テスト用パッケージプライベートコンストラクタです。
     *
     * @param shinseiDac テスト用MockDac
     */
    NinteiShinseiTorisageManager(INinteiShinseiJohoDac shinseiDac) {
        this.shinseiDac = shinseiDac;
    }

    /**
     * 申請書管理番号で指定された認定申請情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定申請情報
     */
    public NinteiShinseiTorisageTaishosha get認定申請取下げ対象者(ShinseishoKanriNo 申請書管理番号) {
        DbT5001NinteiShinseiJohoEntity entity = shinseiDac.select(申請書管理番号);
        return NinteishinseiTorisageTaishoshaMapper.to認定申請取下げ対象者(entity);
    }

    /**
     * 指定した市町村分で、指定された認定申請日の範囲で取下げされていない認定申請情報を全件取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定申請年月日範囲 認定申請年月日範囲
     * @return 指定した条件に合致する、取り下げされていない認定申請情報のリスト
     */
    public NinteiShinseiTorisageTaishoshaList get認定申請取下げ対象者全件(ShichosonCode 市町村コード, Range<FlexibleDate> 認定申請年月日範囲) {
        List<DbT5001NinteiShinseiJohoEntity> entities = shinseiDac.selectAllBy認定申請年月日(市町村コード, 認定申請年月日範囲);
        return create認定申請取下げList(entities);
    }

    /**
     * 指定した市町村分で、指定された取下げ年月日の範囲で取下げされている認定申請情報を全件取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 取下げ年月日範囲 取下げ年月日範囲
     * @return 指定した条件に合致する、取り下げされている認定申請情報のリスト
     */
    public NinteiShinseiTorisageTaishoshaList get認定申請取下げ者(ShichosonCode 市町村コード, Range<FlexibleDate> 取下げ年月日範囲) {
        List<DbT5001NinteiShinseiJohoEntity> entities = shinseiDac.selectAllBy取下げ年月日(市町村コード, 取下げ年月日範囲);
        return create認定申請取下げList(entities);
    }

    private NinteiShinseiTorisageTaishoshaList create認定申請取下げList(List<DbT5001NinteiShinseiJohoEntity> entities) {
        List<NinteiShinseiTorisageTaishosha> 認定申請取下げList = new ArrayList<>();
        for (DbT5001NinteiShinseiJohoEntity entity : entities) {
            認定申請取下げList.add(NinteishinseiTorisageTaishoshaMapper.to認定申請取下げ対象者(entity));
        }
        return new NinteiShinseiTorisageTaishoshaList(認定申請取下げList);
    }

    /**
     * 引数から渡された認定申請取下げ対象者の情報を元に、認定申請情報を更新します。
     *
     * @param 認定申請取下げ対象者 認定申請取下げ対象者
     * @return 更新件数。
     */
    public boolean save(ShinseishoKanriNo 申請書管理No, NinteiShinseiTorisage 認定申請取下げ情報) {
        DbT5001NinteiShinseiJohoEntity 更新前entity = shinseiDac.select(申請書管理No);
        DbT5001NinteiShinseiJohoEntity 更新後entity = NinteishinseiTorisageTaishoshaMapper
                .to認定申請情報Entity(更新前entity, 認定申請取下げ情報);
        return shinseiDac.update(更新後entity) == 1 ? true : false;
    }
}

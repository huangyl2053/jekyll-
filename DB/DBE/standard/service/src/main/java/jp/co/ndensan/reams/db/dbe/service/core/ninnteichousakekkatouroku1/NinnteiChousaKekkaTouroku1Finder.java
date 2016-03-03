/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninnteichousakekkatouroku1;

import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.TempData;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe2210001.NinteiChosaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.ninnteichousakekkatouroku1.TempDataEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe2210001.IDbe2210001RelateMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5203NinteichosahyoKihonChosaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5211NinteichosahyoChosaItemDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査結果登録1検索用クラスです。
 */
public class NinnteiChousaKekkaTouroku1Finder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public NinnteiChousaKekkaTouroku1Finder() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @return TaishouWaritsukeFinder
     */
    public static NinnteiChousaKekkaTouroku1Finder createInstance() {
        return InstanceProvider.create(NinnteiChousaKekkaTouroku1Finder.class);

    }

    /**
     * get認定調査情報
     *
     * @param temp_認定調査履歴番号 認定調査履歴番号
     * @param temp_認定調査委託先コード 認定調査委託先コード
     * @param temp_申請書管理番号 申請書管理番号
     * @return TempData
     */
    public TempData get認定調査情報(int temp_認定調査履歴番号,
            RString temp_認定調査委託先コード,
            ShinseishoKanriNo temp_申請書管理番号) {
        IDbe2210001RelateMapper mapper = mapperProvider.create(IDbe2210001RelateMapper.class);
        TempDataEntity entity = mapper.get認定調査情報(new NinteiChosaJohoMybatisParameter(temp_認定調査履歴番号, temp_認定調査委託先コード, temp_申請書管理番号));

        TempData data = new TempData();
        if (entity != null) {
            data.setTemp_厚労省IF識別コード(entity.getTemp_厚労省IF識別コード());
            data.setTemp_認定調査依頼区分コード(entity.getTemp_認定調査依頼区分コード());
            data.setTemp_認定調査回数(entity.getTemp_認定調査回数());
            data.setTemp_認定調査委託区分コード(entity.getTemp_認定調査依頼区分コード());
        }
        return data;
    }

    /**
     * get認定調査情報
     *
     * @param 申請書管理番号 申請書管理番号
     * @return ShinseishoKanriNo
     */
    public ShinseishoKanriNo get前回申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        DbT5121ShinseiRirekiJohoDac dbt5121Dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
        DbT5121ShinseiRirekiJohoEntity rirekiJohoEntity = dbt5121Dac.selectByKey(申請書管理番号);
        if (rirekiJohoEntity != null) {
            return rirekiJohoEntity.getZenkaiShinseishoKanriNo();
        }
        return null;
    }

    /**
     * getMax認定調査依頼履歴番号
     *
     * @param 申請書管理番号 申請書管理番号
     * @return Max認定調査依頼履歴番号
     */
    public int getMax認定調査依頼履歴番号(ShinseishoKanriNo 申請書管理番号) {
        DbT5203NinteichosahyoKihonChosaDac dbt5203Dac = InstanceProvider.create(DbT5203NinteichosahyoKihonChosaDac.class);
        DbT5203NinteichosahyoKihonChosaEntity entity = dbt5203Dac.selectMax認定調査依頼履歴番号ByKey(申請書管理番号);
        if (entity != null) {
            return entity.getNinteichosaRirekiNo();
        }
        return 0;
    }

    /**
     * get調査項目
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @param 連番 連番
     * @return 調査項目
     */
    public RString get調査項目(ShinseishoKanriNo 申請書管理番号, int 要介護認定調査履歴番号, int 連番) {
        DbT5211NinteichosahyoChosaItemDac dac = InstanceProvider.create(DbT5211NinteichosahyoChosaItemDac.class);
        DbT5211NinteichosahyoChosaItemEntity entity = dac.selectByKey(ShinseishoKanriNo.EMPTY, 要介護認定調査履歴番号, 連番);
        return entity.getResearchItem();
    }
}

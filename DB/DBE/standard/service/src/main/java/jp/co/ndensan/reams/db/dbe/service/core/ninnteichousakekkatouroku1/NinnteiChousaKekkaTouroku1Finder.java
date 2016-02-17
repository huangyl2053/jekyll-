/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninnteichousakekkatouroku1;

import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.TempData;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe2210001.NinteiChosaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.ninnteichousakekkatouroku1.TempDataEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe2210001.IDbe2210001RelateMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査結果登録1検索用クラスです。
 */
public class NinnteiChousaKekkaTouroku1Finder {

    private final MapperProvider mapperProvider;

    public NinnteiChousaKekkaTouroku1Finder() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    public static NinnteiChousaKekkaTouroku1Finder createInstance() {
        return InstanceProvider.create(NinnteiChousaKekkaTouroku1Finder.class);

    }

    public TempData get認定調査情報(int temp_認定調査履歴番号,
            RString temp_認定調査委託先コード,
            ShinseishoKanriNo temp_申請書管理番号) {
        IDbe2210001RelateMapper mapper = mapperProvider.create(IDbe2210001RelateMapper.class);
        TempDataEntity entity = mapper.get認定調査情報(new NinteiChosaJohoMybatisParameter(temp_認定調査履歴番号, temp_認定調査委託先コード, temp_申請書管理番号));
        
        TempData data = new TempData();
        data.setTemp_厚労省IF識別コード(entity.getTemp_厚労省IF識別コード());
        data.setTemp_認定調査依頼区分コード(entity.getTemp_認定調査依頼区分コード());   
        data.setTemp_認定調査回数(entity.getTemp_認定調査回数());
        data.setTemp_認定調査委託区分コード(entity.getTemp_認定調査依頼区分コード());
        return data;
    }
}

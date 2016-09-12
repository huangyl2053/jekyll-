/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninnteichousakekkatouroku1;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.TempData;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousakekkatouroku1.NinteiChosaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousakekkatouroku1.TempDataEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninnteichousakekkatouroku1.INinnteiChousaKekkaTouroku1RelateMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5203NinteichosahyoKihonChosaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5211NinteichosahyoChosaItemDac;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査結果登録1検索用クラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
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
     * 認定調査情報を取得します。
     *
     * @param temp_認定調査履歴番号 認定調査履歴番号
     * @param temp_認定調査委託先コード 認定調査委託先コード
     * @param temp_申請書管理番号 申請書管理番号
     * @return TempData
     */
    public TempData get認定調査情報(int temp_認定調査履歴番号,
            RString temp_認定調査委託先コード,
            ShinseishoKanriNo temp_申請書管理番号) {
        INinnteiChousaKekkaTouroku1RelateMapper mapper = mapperProvider.create(INinnteiChousaKekkaTouroku1RelateMapper.class);
        List<TempDataEntity> entityList = mapper.get認定調査情報(new NinteiChosaJohoMybatisParameter(temp_認定調査履歴番号, temp_認定調査委託先コード,
                temp_申請書管理番号, RString.EMPTY));

        TempData data = new TempData();
        if (entityList != null && !entityList.isEmpty()) {
            TempDataEntity entity = entityList.get(0);
            data.setTemp_厚労省IF識別コード(entity.getTemp_厚労省IF識別コード());
            data.setTemp_認定調査依頼区分コード(entity.getTemp_認定調査依頼区分コード());
            data.setTemp_認定調査回数(entity.getTemp_認定調査回数());
        }
        return data;
    }

    /**
     * 既存概況調査情報を取得します。
     *
     * @param temp_認定調査履歴番号 認定調査履歴番号
     * @param temp_申請書管理番号 申請書管理番号
     * @return TempData
     */
    public TempData get既存概況調査情報(int temp_認定調査履歴番号,
            ShinseishoKanriNo temp_申請書管理番号) {

        INinnteiChousaKekkaTouroku1RelateMapper mapper = mapperProvider.create(INinnteiChousaKekkaTouroku1RelateMapper.class);
        RString 概況調査テキストイメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        TempDataEntity entity = mapper.get既存概況調査情報(new NinteiChosaJohoMybatisParameter(temp_認定調査履歴番号, RString.EMPTY,
                temp_申請書管理番号, 概況調査テキストイメージ区分));

        if (entity == null) {
            return null;
        }

        TempData data = new TempData();
        data.setTemp_現在の状況コード(entity.getTemp_現在の状況コード());
        data.setTemp_現在のサービス区分コード(entity.getTemp_現在のサービス区分コード());
        data.setTemp_利用施設名(entity.getTemp_利用施設名());
        data.setTemp_利用施設住所(entity.getTemp_利用施設住所());
        data.setTemp_利用施設電話番号(entity.getTemp_利用施設電話番号());
        data.setTemp_利用施設郵便番号(entity.getTemp_利用施設郵便番号());
        data.setTemp_特記(entity.getTemp_特記());
        data.setTemp_調査実施場所コード(entity.getTemp_調査実施場所コード());
        data.setTemp_調査実施場所名称(entity.getTemp_調査実施場所名称());
        data.setTemp_調査委託先コード(entity.getTemp_調査委託先コード());
        data.setTemp_調査員コード(entity.getTemp_調査員コード());
        data.setTemp_調査実施年月日(entity.getTemp_調査実施年月日());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.service.core.zenkaininteikekkajoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.HokenshaNinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.zenkaininteikekkajoho.ZenkaiNinteiKekkaJohoRelate;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.zenkaininteikekkajoho.ZenkaiNinteiKekkaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.zenkaininteikekkajoho.IZenkaiNinteiKekkaJohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 前回結果情報のサービスクラスです。
 */
public class ZenkaiNinteiKekkaJohoFinder {
    
    private final MapperProvider mapperProvider;
    
    /**
     * コンストラクタです。
     */
    public ZenkaiNinteiKekkaJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }
    
    ZenkaiNinteiKekkaJohoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }
    
    /**
     * {@link InstanceProvider#create}にて生成した{@link ZenkaiNinteiKekkaJohoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ZenkaiNinteiKekkaJohoFinder}のインスタンス
     */
    public static ZenkaiNinteiKekkaJohoFinder createInstance() {
        return InstanceProvider.create(ZenkaiNinteiKekkaJohoFinder.class);
    }
    
    /**
     * 要介護度_前回受給を取得します。
     * @param 申請書管理番号 申請書管理番号
     * @return SearchResult<HokenshaNinteiShinseiJoho>
     */
    public SearchResult<HokenshaNinteiShinseiJoho> get要介護度_前回受給(ShinseishoKanriNo 申請書管理番号) {
        List<HokenshaNinteiShinseiJoho> hokenshaNinteiShinseiJohoList = new ArrayList<>();
        IZenkaiNinteiKekkaJohoMapper mapper = mapperProvider.create(IZenkaiNinteiKekkaJohoMapper.class);
        DbT4101NinteiShinseiJohoEntity entity = mapper.get要介護度_前回受給(申請書管理番号);
        if (entity != null) {
            hokenshaNinteiShinseiJohoList.add(new HokenshaNinteiShinseiJoho(entity));
        }
        return SearchResult.of(hokenshaNinteiShinseiJohoList, 0, false);
    }
    
    /**
     * 要介護度_前回認定を取得します。
     * @param 申請書管理番号 申請書管理番号
     * @return SearchResult<NinteiShinseiJoho>
     */
    public SearchResult<NinteiShinseiJoho> get要介護度_前回認定(ShinseishoKanriNo 申請書管理番号) {
        List<NinteiShinseiJoho> ninteiShinseiJohoList = new ArrayList<>();
        IZenkaiNinteiKekkaJohoMapper mapper = mapperProvider.create(IZenkaiNinteiKekkaJohoMapper.class);
        DbT5101NinteiShinseiJohoEntity entity = mapper.get要介護度_前回認定(申請書管理番号);
        if (entity != null) {
            ninteiShinseiJohoList.add(new NinteiShinseiJoho(entity));
        }
        return SearchResult.of(ninteiShinseiJohoList, 0, false);
    }
    
    /**
     * 要介護度_今回受給を取得します。
     * @param 申請書管理番号 申請書管理番号
     * @return SearchResult<ZenkaiNinteiKekkaJohoRelate>
     */
    public SearchResult<ZenkaiNinteiKekkaJohoRelate> get要介護度_今回受給(ShinseishoKanriNo 申請書管理番号) {
        List<ZenkaiNinteiKekkaJohoRelate> zenkaiNinteiKekkaJohoRelateList = new ArrayList<>();
        IZenkaiNinteiKekkaJohoMapper mapper = mapperProvider.create(IZenkaiNinteiKekkaJohoMapper.class);
        ZenkaiNinteiKekkaJohoRelateEntity entity = mapper.get要介護度_今回受給(申請書管理番号);
        if (entity != null) {
            zenkaiNinteiKekkaJohoRelateList.add(new ZenkaiNinteiKekkaJohoRelate(entity));
        }
        return SearchResult.of(zenkaiNinteiKekkaJohoRelateList, 0, false);
    }
    
    /**
     * 要介護度_今回認定を取得します。
     * @param 申請書管理番号 申請書管理番号
     * @return SearchResult<ZenkaiNinteiKekkaJohoRelate>
     */
    public SearchResult<ZenkaiNinteiKekkaJohoRelate> get要介護度_今回認定(ShinseishoKanriNo 申請書管理番号) {
        List<ZenkaiNinteiKekkaJohoRelate> zenkaiNinteiKekkaJohoRelateList = new ArrayList<>();
        IZenkaiNinteiKekkaJohoMapper mapper = mapperProvider.create(IZenkaiNinteiKekkaJohoMapper.class);
        ZenkaiNinteiKekkaJohoRelateEntity entity = mapper.get要介護度_今回認定(申請書管理番号);
        zenkaiNinteiKekkaJohoRelateList.add(new ZenkaiNinteiKekkaJohoRelate(entity));
        return SearchResult.of(zenkaiNinteiKekkaJohoRelateList, 0, false);
    }
    
    /**
     * 受給の前回申請管理番号を取得します。
     * @param 申請書管理番号
     * @return 前回申請管理番号
     */
    public RString get前回申請管理番号_受給(ShinseishoKanriNo 申請書管理番号) {
        IZenkaiNinteiKekkaJohoMapper mapper = mapperProvider.create(IZenkaiNinteiKekkaJohoMapper.class);
        return mapper.get前回申請管理番号_受給(申請書管理番号);
    }
    
    /**
     * 認定の前回申請管理番号を取得します。
     * @param 申請書管理番号
     * @return 前回申請管理番号
     */
    public RString get前回申請管理番号_認定(ShinseishoKanriNo 申請書管理番号) {
        IZenkaiNinteiKekkaJohoMapper mapper = mapperProvider.create(IZenkaiNinteiKekkaJohoMapper.class);
        return mapper.get前回申請管理番号_認定(申請書管理番号);
    }
}

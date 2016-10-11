/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.seikyushinsashuseitoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoShukei;
import jp.co.ndensan.reams.db.dbc.business.core.seikyushinsashuseitoroku.SeikyuShinsaShuseiTorokuBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.seikyushinsashuseitoroku.SeikyuShinsaShuseiTorokuMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyushinsashuseitoroku.SeikyuShinsaShuseiTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.seikyushinsashuseitoroku.ISeikyuShinsaShuseiTorokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住宅改修理由書作成手数料請求情報修正登録(審査結果登録)のクラスです。
 *
 * @reamsid_L DBC-2870-010 zhangruitao
 */
public class SeikyuShinsaShuseiTorokuFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    SeikyuShinsaShuseiTorokuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    SeikyuShinsaShuseiTorokuFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoikinaiTenkyoRirekiHenkanFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KoikinaiTenkyoRirekiHenkanFinder}のインスタンス
     */
    public static SeikyuShinsaShuseiTorokuFinder createInstance() {
        return InstanceProvider.create(SeikyuShinsaShuseiTorokuFinder.class);
    }

    /**
     * 検索条件より、適当な条件を連結して、申請者一覧情報を検索する
     *
     * @param 検索条件
     * @return ResponseData<SeikyuShinsaShuseiTorokuDiv>
     */
    public SearchResult<SeikyuShinsaShuseiTorokuBusiness> getKoikinaiTenkyoList(SeikyuShinsaShuseiTorokuMapperParameter 検索条件) {
        requireNonNull(検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("検索条件"));
        ISeikyuShinsaShuseiTorokuMapper mapper = mapperProvider.create(ISeikyuShinsaShuseiTorokuMapper.class);
        List<SeikyuShinsaShuseiTorokuRelateEntity> entityList = mapper.selectSeikyuShinsaShuseiTorokuList(検索条件);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<SeikyuShinsaShuseiTorokuBusiness>emptyList(), 0, false);
        }
        List<SeikyuShinsaShuseiTorokuBusiness> resultList = new ArrayList<>();

        for (SeikyuShinsaShuseiTorokuRelateEntity entity : entityList) {
            SeikyuShinsaShuseiTorokuBusiness bussiness = new SeikyuShinsaShuseiTorokuBusiness();
            entity.getDbT3094().initializeMd5();
            entity.getDbT3095().initializeMd5();
            entity.getDbT3096().initializeMd5();
            JutakuKaishuRiyushoTesuryoKettei dbT3094 = new JutakuKaishuRiyushoTesuryoKettei(entity.getDbT3094());
            JutakuKaishuRiyushoTesuryoMeisai dbT3095 = new JutakuKaishuRiyushoTesuryoMeisai(entity.getDbT3095());
            JutakuKaishuRiyushoTesuryoShukei dbT3096 = new JutakuKaishuRiyushoTesuryoShukei(entity.getDbT3096());
            bussiness.setDbT3094(dbT3094);
            bussiness.setDbT3095(dbT3095);
            bussiness.setDbT3096(dbT3096);
            resultList.add(bussiness);
        }
        return SearchResult.of(resultList, 0, false);
    }
}

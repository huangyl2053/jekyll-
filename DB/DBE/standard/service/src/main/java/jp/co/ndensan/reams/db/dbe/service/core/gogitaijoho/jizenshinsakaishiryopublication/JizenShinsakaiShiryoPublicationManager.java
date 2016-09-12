/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.jizenshinsakaishiryopublication;

import jp.co.ndensan.reams.db.dbe.business.core.jizenshinsakaishiryopublication.JizenShinsakaiShiryoPublicationBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.jizenshinsakaishiryopublication.JizenShinsakaiShiryoPublicationMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.jizenshinsakekka.JizenShinsaKekkaSelectEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.jizenshinsakaishiryopublication.IJizenShinsakaiShiryoPublicationMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会委員事前審査 のコントローラです。
 *
 * @reamsid_L DBE-1630-010 dangjingjing
 */
public class JizenShinsakaiShiryoPublicationManager {

    private final MapperProvider provider;

    /**
     * コンストラクタです。
     */
    JizenShinsakaiShiryoPublicationManager() {
        this.provider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param provider {@link MapperProvider}}
     */
    public JizenShinsakaiShiryoPublicationManager(MapperProvider provider) {
        this.provider = provider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JizenShinsakaiShiryoPublicationManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JizenShinsakaiShiryoPublicationManager}のインスタンス
     */
    public static JizenShinsakaiShiryoPublicationManager creatInstance() {
        return InstanceProvider.create(JizenShinsakaiShiryoPublicationManager.class);
    }

    /**
     * 審査会自動割付を検索します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @return JizenShinsakaiShiryoPublicationBusiness
     */
    @Transaction
    public JizenShinsakaiShiryoPublicationBusiness get審査会開催番号(RString 審査会開催番号) {
        JizenShinsakaiShiryoPublicationMybitisParamter mybitisParamter = new JizenShinsakaiShiryoPublicationMybitisParamter(審査会開催番号);
        IJizenShinsakaiShiryoPublicationMapper manager = provider.create(IJizenShinsakaiShiryoPublicationMapper.class);
        JizenShinsaKekkaSelectEntity entity = manager.select介護認定審査会開催番号(mybitisParamter);
        if (entity == null) {
            return null;
        }
        return new JizenShinsakaiShiryoPublicationBusiness(entity);
    }
}

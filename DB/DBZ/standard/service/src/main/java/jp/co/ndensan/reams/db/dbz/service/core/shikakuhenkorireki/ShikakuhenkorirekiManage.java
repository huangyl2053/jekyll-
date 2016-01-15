/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shikakuhenkorireki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.sikakuidocheck.SikakuIdoCheckManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.mapper.IUaFt200FindShikibetsuTaishoFunctionMapper;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 対象者個人情報取得
 */
public class ShikakuhenkorirekiManage {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShikakuhenkorirekiManage() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SikakuIdoCheckManager}のインスタンスを返します。
     *
     * @return SikakuIdoCheckManager
     *
     */
    public static ShikakuhenkorirekiManage createInstance() {
        return InstanceProvider.create(ShikakuhenkorirekiManage.class);

    }

    /**
     * 対象者個人情報取得(識別コード経由)
     *
     * @param 識別コード 識別コード
     * @return 個人情報
     */
    public List<IKojin> getKojinInfoByShikibetuCd(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoPSMSearchKeyBuilder keyBuilder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        keyBuilder.set識別コード(識別コード);

        List<JuminShubetsu> 住民種別list = new ArrayList<>();
        住民種別list.add(JuminShubetsu.日本人);
        住民種別list.add(JuminShubetsu.外国人);
        住民種別list.add(JuminShubetsu.住登外個人_日本人);
        住民種別list.add(JuminShubetsu.住登外個人_外国人);
        keyBuilder.set住民種別(住民種別list);

        List<JuminJotai> 住民状態list = new ArrayList<>();
        住民状態list.add(JuminJotai.住民);
        住民状態list.add(JuminJotai.住登外);
        住民状態list.add(JuminJotai.消除者);
        住民状態list.add(JuminJotai.転出者);
        住民状態list.add(JuminJotai.死亡者);
        keyBuilder.set住民状態(住民状態list);

        UaFt200FindShikibetsuTaishoParam parm = new UaFt200FindShikibetsuTaishoParam(keyBuilder.build());
        IUaFt200FindShikibetsuTaishoFunctionMapper mapper = this.mapperProvider.create(IUaFt200FindShikibetsuTaishoFunctionMapper.class);
        List<UaFt200FindShikibetsuTaishoEntity> 対象者個人情報 = mapper.selectByParameterClass(parm);
        if (対象者個人情報.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<IKojin> kojins = new ArrayList<>();
            for (UaFt200FindShikibetsuTaishoEntity entity : 対象者個人情報) {
                kojins.add(ShikibetsuTaishoFactory.createKojin(entity));
            }
            return kojins;
        }
    }
}

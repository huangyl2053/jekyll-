/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosatokusokujohakko;

import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoTempData;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosatokusokujohakko.CountGaitouDataKenSu13Parameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosatokusokujohakko.CountGaitouDataKenSu2Parameter;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteitiyousaiirai.INinteiShinseiJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査督促状発行を管理するクラスです。
 *
 * @reamsid_L DBE-0030-010 liangbc
 */
public class NinteiChosaTokusokujoHakkoManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinteiChosaTokusokujoHakkoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    NinteiChosaTokusokujoHakkoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiShinseiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiShinseiJohoManager}のインスタンス
     */
    public static NinteiChosaTokusokujoHakkoManager createInstance() {
        return InstanceProvider.create(NinteiChosaTokusokujoHakkoManager.class);
    }

    /**
     * countGaitouDataKenSu13
     *
     * @param tempData NinteiChosaTokusokujoHakkoTempData
     * @return count
     */
    public int countGaitouDataKenSu13(NinteiChosaTokusokujoHakkoTempData tempData) {
        INinteiShinseiJohoMapper mapper = mapperProvider.create(INinteiShinseiJohoMapper.class);
        return mapper.countGaitouDataKenSu13(CountGaitouDataKenSu13Parameter.createParam(tempData));
    }

    /**
     * countGaitouDataKenSu2
     *
     * @param tempData NinteiChosaTokusokujoHakkoTempData
     * @return count
     */
    public int countGaitouDataKenSu2(NinteiChosaTokusokujoHakkoTempData tempData) {
        INinteiShinseiJohoMapper mapper = mapperProvider.create(INinteiShinseiJohoMapper.class);
        return mapper.countGaitouDataKenSu2(CountGaitouDataKenSu2Parameter.createParam(tempData));
    }

}

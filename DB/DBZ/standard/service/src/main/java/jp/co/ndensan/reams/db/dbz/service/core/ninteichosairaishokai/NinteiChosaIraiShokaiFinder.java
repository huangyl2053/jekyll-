/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteichosairaishokai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosairaishokai.NinteiChosaIraiShokaiMaster;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteichosairaishokai.NinteiChosaIraiShokaiParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteichosairaishokai.NinteiChosaIraiShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteichosairaishokai.INinteiChosaIraiShokaiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 認定調査情報を取得するのクラスです。
 *
 * @reamsid_L DBE-0200-020 zhangguopeng
 */
public class NinteiChosaIraiShokaiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinteiChosaIraiShokaiFinder() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     */
    NinteiChosaIraiShokaiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosaIraiShokaiManager}のインスタンスを返します。
     *
     * @return NinteiChosaIraiShokaiManager
     *
     */
    public static NinteiChosaIraiShokaiFinder createInstance() {
        return InstanceProvider.create(NinteiChosaIraiShokaiFinder.class);
    }

    /**
     * 認定調査情報を取得の処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return SearchResult<NinteiChosaIraiShokaiMaster> 認定調査情報
     */
    public SearchResult<NinteiChosaIraiShokaiMaster> getNinteiChousaJouhou(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        NinteiChosaIraiShokaiParameter parameter = NinteiChosaIraiShokaiParameter.createParam(申請書管理番号);
        INinteiChosaIraiShokaiMapper mapper = mapperProvider.create(INinteiChosaIraiShokaiMapper.class);
        List<NinteiChosaIraiShokaiRelateEntity> entityList = mapper.get認定調査情報(parameter);
        List<NinteiChosaIraiShokaiMaster> shokaiMaster = new ArrayList<>();
        for (NinteiChosaIraiShokaiRelateEntity entity : entityList) {
            shokaiMaster.add(new NinteiChosaIraiShokaiMaster(entity));
        }
        return SearchResult.of(shokaiMaster, 0, false);
    }
    
    /**
     * 定調査情報件数を取得の処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return int 定調査情報件数
     */
    public int get認定調査情報件数(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        NinteiChosaIraiShokaiParameter parameter = NinteiChosaIraiShokaiParameter.createParam(申請書管理番号);
        INinteiChosaIraiShokaiMapper mapper = mapperProvider.create(INinteiChosaIraiShokaiMapper.class);
        return mapper.get認定調査情報件数(parameter);

    }
}

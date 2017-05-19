/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteichosa;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteichosa.NinteichosaContextMapperParameter;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteichosa.INinteichosaContextMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査関連の処理を扱います。
 */
public class NinteichosaContextService {

    private final MapperProvider mapperProvider;

    public NinteichosaContextService() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * @return {@link NinteichosaContextService}のインスタンス
     */
    public static NinteichosaContextService createInstance() {
        return InstanceProvider.create(NinteichosaContextService.class);
    }

    /**
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return 指定の申請、調査履歴以前に認定調査が行われている場合、{@code true}.
     */
    public ChosaKubun findChosaKubun(RString 申請書管理番号, int 認定調査依頼履歴番号) {
        return this.mapperProvider.create(INinteichosaContextMapper.class)
                .hasBeenExaminedBefore(
                        NinteichosaContextMapperParameter.hasBeenExaminedBefore(
                                申請書管理番号,
                                認定調査依頼履歴番号
                        )
                ) ? ChosaKubun.再調査 : ChosaKubun.新規調査;
    }
}

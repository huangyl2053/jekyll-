/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.roreifukushinenkinjukyushajohn;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.definition.core.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaMapperParameter;
import jp.co.ndensan.reams.db.dbu.persistence.mapper.basic.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老齢福祉年金受給者台帳管理です。
 *
 */
public class RorenFukushiNenkinJohoKanrishi {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    RorenFukushiNenkinJohoKanrishi() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RorenFukushiNenkinJohoKanrishi} のインスタンスを返します。
     *
     * @return RorenFukushiNenkinJohoKanrishi
     */

    public static RorenFukushiNenkinJohoKanrishi createInstance() {
        return InstanceProvider.create(RorenFukushiNenkinJohoKanrishi.class);

    }

    /**
     * 老齢福祉年金受給者台帳管理を返します。
     *
     * @param param 老齢福祉年金受給者台帳管理パラメータ
     * @return boolean 受給期間重複フラグ(true: 重複する、false: 重複しない)
     */
    @Transaction
    public boolean jukyuKikanJufukuCheck(RoreiFukushiNenkinJukyushaMapperParameter param) {
        requireNonNull(param, UrSystemErrorMessages.値がnull.getReplacedMessage("param"));
        RoreiFukushiNenkinJukyushaMapper mapper = mapperProvider.create(RoreiFukushiNenkinJukyushaMapper.class);
        int count = mapper.jukyuKikanJufukuCheck(param);
        return count != 0;
    }
}

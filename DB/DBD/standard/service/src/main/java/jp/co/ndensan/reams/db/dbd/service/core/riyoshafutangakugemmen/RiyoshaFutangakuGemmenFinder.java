/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.riyoshafutangakugemmen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuServiceMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.riyoshafutangengaku.IRiyoshaFutangakuGengakuMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 【共有子Div】利用者負担額減免Finderです。
 *
 * @reamsid_L DBD-3560-060 wangjie2
 */
public class RiyoshaFutangakuGemmenFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    RiyoshaFutangakuGemmenFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 【共有子Div】利用者負担額減免FinderのIntanceを作成します。
     *
     * @return RiyoshaFutangakuGemmenFinder
     */
    public static RiyoshaFutangakuGemmenFinder createIntance() {
        return InstanceProvider.create(RiyoshaFutangakuGemmenFinder.class);
    }

    /**
     * 被保険者番号を使用して減免減額申請テーブルと利用者負担額減額テーブルより利用者負担額減額の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<利用者負担額減額の情報>
     */
    @Transaction
    public List<RiyoshaFutangakuGengaku> get申請一覧_利用者負担額減額情報(HihokenshaNo 被保険者番号) {
        IRiyoshaFutangakuGengakuMapper riyoshaFutangakuGengakuMapper = mapperProvider.create(IRiyoshaFutangakuGengakuMapper.class);
        List<RiyoshaFutangakuGengakuEntity> 利用者負担額減額の情報 = riyoshaFutangakuGengakuMapper.
                selectBy被保険者番号And減免減額種類(
                        RiyoshaFutangakuGengakuServiceMapperParameter.createParameter(GemmenGengakuShurui.利用者負担額減額.getコード(),
                                被保険者番号, RString.EMPTY));

        List<RiyoshaFutangakuGengaku> list = new ArrayList<>();
        for (RiyoshaFutangakuGengakuEntity entity : 利用者負担額減額の情報) {
            list.add(new RiyoshaFutangakuGengaku(entity));
        }
        return list;
    }

}

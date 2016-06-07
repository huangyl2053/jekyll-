/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.nyutaishoshakanri;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.nyutaishoshakanri.NyutaishoshaKanriMapperParameter;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nyutaishoshakanri.INyutaishoshaKanriMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険施設入退所者管理の履歴期間重複チェックです。
 *
 * @reamsid_L DBA-0360-010 duanzhanli
 *
 */
public class NyutaishoshaKanriFinder {

    private static final RString 被保険者 = new RString("1");
    private static final RString 他町村住所地特例者 = new RString("2");
    private static final RString 適用除外者 = new RString("3");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public NyutaishoshaKanriFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NyutaishoshaKanriFinder}のインスタンスを返します。
     *
     * @return NyutaishoshaKanriFinder
     */
    public static NyutaishoshaKanriFinder createInstance() {
        return InstanceProvider.create(NyutaishoshaKanriFinder.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    NyutaishoshaKanriFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * 介護保険施設情報件数を取得する
     *
     * @param 入所年月日 入所年月日
     * @param 退所年月日 退所年月日
     * @param 台帳種別 台帳種別
     * @return rirekiKikanJufukuFlag
     */
    @Transaction
    public boolean isRirekiKikanJufukuFlag(FlexibleDate 入所年月日, FlexibleDate 退所年月日, RString 台帳種別) {
        int count = 0;
        INyutaishoshaKanriMapper mapper = mapperProvider.create(INyutaishoshaKanriMapper.class);
        NyutaishoshaKanriMapperParameter parameter = NyutaishoshaKanriMapperParameter.createSelectByKeyParam(入所年月日, 退所年月日);
        if (被保険者.equals(台帳種別)) {
            count = mapper.getHihokenshaDaichoCount(parameter);
        }
        if (他町村住所地特例者.equals(台帳種別)) {
            count = mapper.getTashichosonJushochiTokureiCount(parameter);
        }
        if (適用除外者.equals(台帳種別)) {
            count = mapper.getTekiyoJogaishaCount(parameter);
        }
        return 2 <= count;
    }
}

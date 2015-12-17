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
 */
public class NyutaishoshaKanriFinder {

    private static final RString KAIGOHOHENSHISETSU_VALUE = new RString("11");
    private static final RString JUSHOCHITOKUREITAISHOSHISETSU_VALUE = new RString("12");
    private static final RString TEKIYOJOGAISHISETSU_VALUE = new RString("21");
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
     * @param 入所施設種類 入所施設種類
     * @return rirekiKikanJufukuFlag
     */
    @Transaction
    public Boolean isRirekiKikanJufukuFlag(FlexibleDate 入所年月日, FlexibleDate 退所年月日, RString 入所施設種類) {
        int count = 0;
        INyutaishoshaKanriMapper mapper = mapperProvider.create(INyutaishoshaKanriMapper.class);
        NyutaishoshaKanriMapperParameter parameter;
        switch (入所施設種類.toString()) {
            case "11":
                parameter = NyutaishoshaKanriMapperParameter.createSelectByKeyParam(入所年月日, 退所年月日, KAIGOHOHENSHISETSU_VALUE);
                count = mapper.getHihokenshaDaichoCount(parameter);
                break;
            case "12":
                parameter = NyutaishoshaKanriMapperParameter.createSelectByKeyParam(入所年月日, 退所年月日, JUSHOCHITOKUREITAISHOSHISETSU_VALUE);
                count = mapper.getTekiyoJogaishaCount(parameter);
                break;
            case "21":
                parameter = NyutaishoshaKanriMapperParameter.createSelectByKeyParam(入所年月日, 退所年月日, TEKIYOJOGAISHISETSU_VALUE);
                count = mapper.getTashichosonJushochiTokureiCount(parameter);
                break;
            default:
                break;
        }
        return 2 <= count;
    }
}

package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceTypeCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.basic.KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.business.mapper.KaigoJigyoshaMapper;
import jp.co.ndensan.reams.db.dbx.persistence.basic.IDbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.persistence.basic.IDbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 介護事業者に関連した情報を扱うクラスです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者取得
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 * @deprecated {@link _KaigoJigyoshaRelateManager}を使用してください。
 */
public class _KaigoJigyoshaFinder implements IKaigoJigyoshaFinder {

    private final IDbT7060KaigoJigyoshaDac 事業者Dac;
    private final IDbT7063KaigoJigyoshaShiteiServiceDac 事業者指定サービスDac;

    /**
     * コンストラクタです。
     */
    public _KaigoJigyoshaFinder() {
        事業者Dac = InstanceProvider.createWithCustomize(IDbT7060KaigoJigyoshaDac.class);
        事業者指定サービスDac = InstanceProvider.createWithCustomize(IDbT7063KaigoJigyoshaShiteiServiceDac.class);
    }

    /**
     * テスト用コンストラクタです。 mockで置き換えたDacを引数として渡しています。
     *
     * @param 事業者Dac
     * @param 事業者指定サービスDac
     */
    _KaigoJigyoshaFinder(IDbT7060KaigoJigyoshaDac 事業者Dac, IDbT7063KaigoJigyoshaShiteiServiceDac 事業者指定サービスDac) {
        this.事業者Dac = 事業者Dac;
        this.事業者指定サービスDac = 事業者指定サービスDac;
    }

    @Override
    public List<IKaigoJigyosha> get特定の指定サービスを含む事業者一覧(IKaigoServiceTypeCode serviceTypeCd) {
        List<KaigoJigyoshaShiteiServiceEntity> 指定サービスs = 事業者指定サービスDac.select特定のサービス種類コードのサービス種類一覧(serviceTypeCd.getValue());

        if (指定サービスs == null) {
            return Collections.EMPTY_LIST;
        }

        List<RString> 事業者番号s = new ArrayList<>();
        for (KaigoJigyoshaShiteiServiceEntity 指定サービス : 指定サービスs) {
            事業者番号s.add(指定サービス.get事業者番号());
        }

        List<KaigoJigyoshaEntity> 事業者s = new ArrayList<>();
        事業者s.addAll(事業者Dac.select特定の事業者番号の事業者List(事業者番号s));

        List<IKaigoJigyosha> 特定サービスを含む事業者s = KaigoJigyoshaMapper.toKaigoJigyoshas(事業者s);

        if (特定サービスを含む事業者s.isEmpty()) {
            return Collections.EMPTY_LIST;
        } else {
            return 特定サービスを含む事業者s;
        }
    }

    @Override
    public IKaigoJigyosha get特定の事業者番号の介護事業者(RString jigyoshaBango, FlexibleDate 有効開始年月日) {
        KaigoJigyoshaEntity 特定の事業者種別かつ事業者番号の事業者 = 事業者Dac.select特定の事業者番号の事業者(jigyoshaBango, 有効開始年月日);

        if (特定の事業者種別かつ事業者番号の事業者 == null) {
            return null;
        } else {
            return KaigoJigyoshaMapper.toKaigoJigyosha(特定の事業者種別かつ事業者番号の事業者);
        }
    }

    @Override
    public IKaigoJigyosha get特定の事業者番号の介護事業者(RString jigyoshaBango) {
        KaigoJigyoshaEntity 特定の事業者種別かつ事業者番号の事業者 = 事業者Dac.select特定の事業者番号の事業者(jigyoshaBango);

        if (特定の事業者種別かつ事業者番号の事業者 == null) {
            return null;
        } else {
            return KaigoJigyoshaMapper.toKaigoJigyosha(特定の事業者種別かつ事業者番号の事業者);
        }
    }
}

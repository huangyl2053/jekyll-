/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.kaigokougakujuryoininshouninkakuninsho;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigokougakujuryoininshouninkakuninsho.KaigoKougakuJuryoininShouninkakuninshoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigokougakujuryoininshouninkakuninsho.ShouninkakuninshoEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigokougakujuryoininshouninkakuninsho.IKaigoKougakuJuryoininShouninkakuninshoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * [総合窓口用被保険者、受給者等判断]のクラスです。
 *
 * @reamsid_L DBU-4220-010 jinjue
 */
public class KaigoKougakuJuryoininShouninkakuninshoFinder {

    private final MapperProvider mapperProvider;
    private static final int 判断 = 0;
    private static final RString 転入 = new RString("10（転入）");
    private static final RString 転出 = new RString("20（転出）");
    private boolean 住民情報判断フラグ;

    /**
     * コンストラクタです。
     */
    KaigoKougakuJuryoininShouninkakuninshoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    KaigoKougakuJuryoininShouninkakuninshoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoKougakuJuryoininShouninkakuninshoFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KaigoKougakuJuryoininShouninkakuninshoFinder}のインスタンス
     */
    public static KaigoKougakuJuryoininShouninkakuninshoFinder createInstance() {
        return InstanceProvider.create(KaigoKougakuJuryoininShouninkakuninshoFinder.class);
    }

    /**
     * 総合窓口用被保険者、受給者等判断の処理です。
     *
     * @param 住民情報 住民情報
     * @return 判断結果 true: 連動保留特定住所情報を取得します false:連動保留特定住所情報を取得しません
     */
    public boolean get被保険者判断結果(ShouninkakuninshoEntity 住民情報) {

        for (RString list : 住民情報.get住民情報()) {
            ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                    ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
            UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
            if (list.startsWith(転入)) {
                KaigoKougakuJuryoininShouninkakuninshoParameter meter = KaigoKougakuJuryoininShouninkakuninshoParameter.
                        creatParameter(住民情報.get識別コード(), new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
                住民情報判断フラグ = this.select被保険者(meter);
            }
        }
        return 住民情報判断フラグ;
    }

    /**
     * 総合窓口用被保険者、受給者等判断の処理です。
     *
     * @param 住民情報 住民情報
     * @return 判断結果 true: 連動保留特定住所情報を取得します false:連動保留特定住所情報を取得しません
     */
    public boolean get受給者(ShouninkakuninshoEntity 住民情報) {

        for (RString list : 住民情報.get住民情報()) {
            if (list.startsWith(転出)) {
                KaigoKougakuJuryoininShouninkakuninshoParameter meter = KaigoKougakuJuryoininShouninkakuninshoParameter.
                        creatParameter(住民情報.get識別コード(), RString.EMPTY);
                住民情報判断フラグ = this.select受給者(meter);
            }
        }
        return 住民情報判断フラグ;
    }

    private boolean select被保険者(KaigoKougakuJuryoininShouninkakuninshoParameter meter) {
        boolean 判断フラグ = true;
        IKaigoKougakuJuryoininShouninkakuninshoMapper mapper = mapperProvider.create(IKaigoKougakuJuryoininShouninkakuninshoMapper.class);
        int 被保険者 = mapper.select被保険者(meter);
        if (判断 == 被保険者) {
            判断フラグ = false;
        }
        return 判断フラグ;
    }

    private boolean select受給者(KaigoKougakuJuryoininShouninkakuninshoParameter meter) {
        boolean 判断フラグ = true;
        IKaigoKougakuJuryoininShouninkakuninshoMapper mapper = mapperProvider.create(IKaigoKougakuJuryoininShouninkakuninshoMapper.class);
        int 受給者 = mapper.select受給者(meter);
        if (判断 == 受給者) {
            判断フラグ = false;
        }
        return 判断フラグ;
    }
}

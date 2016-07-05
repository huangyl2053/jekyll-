/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.taino;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResult;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoKiSummary;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TokuchoFuchoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.jikokisanbikanri.JikoKisanbiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.JikoGoShunyuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TainoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TaishoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.taino.SearchShiharaiHohoHenkoTainoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.taino.ITainoJokyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 滞納情報（画面）のビジネスクラスです。
 *
 * @reamsid_L DBD-3620-050 liangbc
 */
public class TainoJokyoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public TainoJokyoFinder() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TainoJokyoResearcher}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TainoJokyoResearcher}のインスタンス
     */
    public static TainoJokyoFinder createInstance() {
        return InstanceProvider.create(TainoJokyoFinder.class);
    }

    /**
     * 指定の被保険者について、指定の基準日時点の滞納の状況を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準日 基準日
     * @return 滞納判定結果
     */
    public TainoHanteiResult research滞納情報(HihokenshaNo 被保険者番号, FlexibleDate 基準日) {
        return TainoJokyoResearcher.createInstance().research滞納状況(被保険者番号, 基準日);
    }

    /**
     * 支払方法変更で管理している滞納情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     * @param 滞納判定区分 滞納判定区分
     * @return 滞納判定結果
     */
    public TainoHanteiResult find支払方法変更滞納(
            HihokenshaNo 被保険者番号, ShiharaiHenkoKanriKubun 管理区分, int 履歴番号, TainoHanteiKubun 滞納判定区分) {
        ITainoJokyoMapper mapper = mapperProvider.create(ITainoJokyoMapper.class);
        List<DbT4022ShiharaiHohoHenkoTainoEntity> entitys = mapper.searchShiharaiHohoHenkoTaino(
                SearchShiharaiHohoHenkoTainoParameter.createParameter(被保険者番号, 管理区分, 履歴番号, 滞納判定区分));
        List<TainoKiSummary> summarys = create滞納情報entitys(entitys);
        return TainoJokyoResearcher.createInstance().create給付額減額情報(summarys, entitys.get(0).getTainoHanteiYMD());
    }

    private List<TainoKiSummary> create滞納情報entitys(List<DbT4022ShiharaiHohoHenkoTainoEntity> entitys) {
        List<TainoKiSummary> 滞納情報entitys = new ArrayList<>();
        TainoKiSummary summary;
        FlexibleDate nokigen;
        for (DbT4022ShiharaiHohoHenkoTainoEntity entity : entitys) {
            nokigen = entity.getNokigen();
            Decimal 調定額 = entity.getChoteigaku();
            summary = new TainoKiSummary(
                    entity.getFukaNendo(),
                    entity.getChoteiNendo(),
                    !entity.getFukaNendo().equals(entity.getChoteiNendo()),
                    entity.getShuno_Ki_Tsuki(),
                    調定額,
                    調定額 == null ? Decimal.ZERO : 調定額.subtract(entity.getTainoGaku()),
                    entity.getTainoGaku(),
                    nokigen == null ? null : new RDate(nokigen.toString()),
                    entity.getJikoKisanYMD(),
                    JikoKisanbiKubun.toValue(entity.getJikoKisanKubun()),
                    MinoKannoKubun.toValue(entity.getKanno_MinoKubun()),
                    JikoKubun.toValue(entity.getJikoKubun()),
                    entity.getTsuchishoNo(),
                    TokuchoFuchoKubun.toValue(entity.getTokucho_fuchoKubun()),
                    JikoGoShunyuKubun.toValue(entity.getJikoAtoShunyuKubun()),
                    TaishoHanteiKubun.toValue(entity.getTaishoKanriKubun()),
                    entity.getKojoGaku());
            滞納情報entitys.add(summary);
        }
        return 滞納情報entitys;
    }
}

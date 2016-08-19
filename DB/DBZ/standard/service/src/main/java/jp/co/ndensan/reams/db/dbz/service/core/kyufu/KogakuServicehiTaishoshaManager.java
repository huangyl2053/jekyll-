/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kyufu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3055KogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額対象者情報有無の処理するクラスです。
 */
public class KogakuServicehiTaishoshaManager {

    //private IKogakuServicehiTaishosha manager;
    private MapperProvider mapperProvider;
    private static final RString 受託あり = new RString("2");
    private static final RString 受託なし = new RString("1");
    private static final RString 平成17年10月 = new RString("200510");
    private DbT3055KogakuKyufuTaishoshaGokeiDac dac3055;
    private DbT3054KogakuKyufuTaishoshaMeisaiDac dac3054;
    private DbT3055KogakuKyufuTaishoshaGokeiEntity dbt3055Entity;
    private DbT3054KogakuKyufuTaishoshaMeisaiEntity dbt3054Entity;
    private FlexibleYearMonth 対象者受取年月;
    private boolean 同月サービス有無;
    private RString 高額給付根拠;

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link KogakuServicehiTaishoshaEntity}
     */
    KogakuServicehiTaishoshaManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KogakuServicehiTaishoshaManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KogakuServicehiTaishoshaManager}のインスタンス
     */
    public static KogakuServicehiTaishoshaManager createInstance() {
        return InstanceProvider.create(KogakuServicehiTaishoshaManager.class);
    }

    /**
     * サービス提供年月時点の（最新）高額介護サービス費給付対象者合計情報を取得する。
     *
     * @param 被保険者台帳
     * @param サービス提供年月
     * @return 同月サービス有無
     */
    public boolean is高額対象者有無(HihokenshaNo 被保険者台帳, FlexibleDate サービス提供年月) {
        requireNonNull(被保険者台帳, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));

        dbt3055Entity = dac3055.get最大履歴番号(被保険者台帳, サービス提供年月);

        dbt3055Entity = dac3055.selectByKeyNew(被保険者台帳, サービス提供年月, dbt3055Entity.getRirekiNo());

        対象者受取年月 = dbt3055Entity.getTashoshaUketoriYM();

        RString config高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);

        if (dbt3055Entity != null) {

            dbt3054Entity = dac3054.selectByKogakuKyufuKonkyo(被保険者台帳, サービス提供年月, dbt3055Entity.getRirekiNo());
            高額給付根拠 = dbt3054Entity.getKogakuKyufuKonkyo();

        } else if (!高額給付根拠.isNullOrEmpty() && 受託あり.equals(config高額)) {

            if (対象者受取年月.compareTo(new FlexibleYearMonth(平成17年10月)) <= 0) {
                switch (高額給付根拠.substring(0, 3).toString()) {
                    case "合":
                        同月サービス有無 = true;
                        break;
                    case "単":
                        同月サービス有無 = false;
                        break;
                }
            } else if (対象者受取年月.compareTo(new FlexibleYearMonth(平成17年10月)) > 0) {
                switch (高額給付根拠.substring(0, 2).toString()) {
                    case "合":
                        同月サービス有無 = true;
                        break;
                    case "単":
                        同月サービス有無 = false;
                        break;
                }
            }

        } else if (受託なし.equals(config高額)) {
            if (対象者受取年月.compareTo(new FlexibleYearMonth(平成17年10月)) <= 0) {
                switch (高額給付根拠.substring(0, 3).toString()) {
                    case "合":
                        同月サービス有無 = true;
                        break;
                    case "単":
                        同月サービス有無 = false;
                        break;
                }
            } else if (対象者受取年月.compareTo(new FlexibleYearMonth(平成17年10月)) > 0) {
                switch (高額給付根拠.substring(0, 2).toString()) {
                    case "合":
                        同月サービス有無 = true;
                        break;
                    case "単":
                        同月サービス有無 = false;
                        break;
                }
            }
        } else {
            同月サービス有無 = false;
        }
        return 同月サービス有無;
    }
}

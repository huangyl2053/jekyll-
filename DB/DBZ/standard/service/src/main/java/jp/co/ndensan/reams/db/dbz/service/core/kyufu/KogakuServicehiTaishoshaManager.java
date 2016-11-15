/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kyufu;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3055KogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static java.util.Objects.requireNonNull;

/**
 * 高額対象者情報有無の処理するクラスです。
 */
public class KogakuServicehiTaishoshaManager {

    private static final int 合算判定INDEX_平成17年09月以前 = 3;
    private static final int 合算判定INDEX_平成17年10月以降 = 2;
    private static final RString 受託あり = new RString("2");
    private static final RString 受託なし = new RString("1");
    private static final FlexibleYearMonth 平成17年10月 = new FlexibleYearMonth("200510");
    private static final RString 全角カンマ = new RString("，");
    private final DbT3055KogakuKyufuTaishoshaGokeiDac dac3055;
    private final DbT3054KogakuKyufuTaishoshaMeisaiDac dac3054;

    /**
     * インスタンスを生成します。
     */
    public KogakuServicehiTaishoshaManager() {
        this.dac3055 = InstanceProvider.create(DbT3055KogakuKyufuTaishoshaGokeiDac.class);
        this.dac3054 = InstanceProvider.create(DbT3054KogakuKyufuTaishoshaMeisaiDac.class);
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
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return 同月サービス有無
     */
    public boolean is高額対象者有無(HihokenshaNo 被保険者番号, FlexibleDate サービス提供年月) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));

        FlexibleYearMonth 提供年月 = サービス提供年月.getYearMonth();
        DbT3055KogakuKyufuTaishoshaGokeiEntity maxRirekiNo = dac3055.get最大履歴番号(被保険者番号, 提供年月);
        if (maxRirekiNo == null || maxRirekiNo.getRirekiNo() == null) {
            return false;
        }

        DbT3054KogakuKyufuTaishoshaMeisaiEntity dbt3054Entity
                = dac3054.selectByKogakuKyufuKonkyo(被保険者番号, 提供年月, maxRirekiNo.getRirekiNo());
        RString 高額給付根拠 = (dbt3054Entity == null)
                ? RString.EMPTY
                : dbt3054Entity.getKogakuKyufuKonkyo();

        DbT3055KogakuKyufuTaishoshaGokeiEntity dbt3055Entity
                = dac3055.selectByKeyNew(被保険者番号, 提供年月, maxRirekiNo.getRirekiNo());
        if (dbt3055Entity == null) {
            return false;
        }
        FlexibleYearMonth 対象者受取年月 = dbt3055Entity.getTashoshaUketoriYM() == null || dbt3055Entity.getTashoshaUketoriYM().isEmpty()
                ? new FlexibleYearMonth("000000")
                : dbt3055Entity.getTashoshaUketoriYM();
        
        RString 受託区分_高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        return has同月サービス(受託区分_高額, 対象者受取年月, 高額給付根拠);
    }

    static boolean has同月サービス(RString 受託区分_高額, FlexibleYearMonth 対象者受取年月, RString 高額給付根拠) {
        if (RString.isNullOrEmpty(高額給付根拠)) {
            return false;
        }
        List<RString> 高額給付根拠s = 高額給付根拠.split(全角カンマ.toString());

        boolean 同月サービス有無 = false;

        if (受託あり.equals(受託区分_高額)) {
            if (平成17年10月.compareTo(対象者受取年月) <= 0) {
                switch (getOrEMPTY(高額給付根拠s, 合算判定INDEX_平成17年10月以降).toString()) {
                    case "合":
                        同月サービス有無 = true;
                        break;
                    case "単":
                        同月サービス有無 = false;
                        break;
                    default:
                        同月サービス有無 = false;
                        break;
                }
            } else if (平成17年10月.compareTo(対象者受取年月) > 0) {
                switch (getOrEMPTY(高額給付根拠s, 合算判定INDEX_平成17年09月以前).toString()) {
                    case "合":
                        同月サービス有無 = true;
                        break;
                    case "単":
                        同月サービス有無 = false;
                        break;
                    default:
                        同月サービス有無 = false;
                        break;
                }
            }

        } else if (受託なし.equals(受託区分_高額)) {
            if (平成17年10月.compareTo(対象者受取年月) <= 0) {
                switch (getOrEMPTY(高額給付根拠s, 合算判定INDEX_平成17年10月以降).toString()) {
                    case "合":
                        同月サービス有無 = true;
                        break;
                    case "単":
                        同月サービス有無 = false;
                        break;
                    default:
                        同月サービス有無 = false;
                        break;
                }
            } else if (平成17年10月.compareTo(対象者受取年月) > 0) {
                switch (getOrEMPTY(高額給付根拠s, 合算判定INDEX_平成17年09月以前).toString()) {
                    case "合":
                        同月サービス有無 = true;
                        break;
                    case "単":
                        同月サービス有無 = false;
                        break;
                    default:
                        同月サービス有無 = false;
                        break;
                }
            }
        }
        return 同月サービス有無;
    }

    private static RString getOrEMPTY(List<? extends RString> list, int index) {
        if (index < list.size()) {
            return list.get(index);
        }
        return RString.EMPTY;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.hihokenshasho;

import jp.co.ndensan.reams.db.dba.definition.core.enumeratedtype.config.ConfigKeysHihokenshashoIndicationMethod;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.hihokenshasho.IkkatsuHakkoBatchParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 介護保険被保険者証一括作成クラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class KaigoHokenHihokenshashoIkkatsuSakusei {

    private final RString 出力条件コード;
    private final FlexibleDate 今回の開始日;
    private final RTime 今回の時分秒_以上;
    private final FlexibleDate 今回の終了日;
    private final RTime 今回の時分秒_未満;
    private final FlexibleDate 今回の基準日;
    private final RTime 今回の時分秒;
    private final FlexibleDate 交付日;
    private final RString テスト出力するフラグ;
    private final RString 再発行するフラグ;
    private final FlexibleDate 発行日時の発行日;
    private final RTime 発行日時の時分秒;
    private final RString 出力順ID;

    /**
     * コンストラクタです。<br/>
     *
     * @param 出力条件コード 出力条件コード
     * @param 今回の開始日 今回の開始日
     * @param 今回の時分秒_以上 今回の時分秒_以上
     * @param 今回の終了日 今回の終了日
     * @param 今回の時分秒_未満 今回の時分秒_未満
     * @param 今回の基準日 今回の基準日
     * @param 今回の時分秒 今回の時分秒
     * @param 交付日 交付日
     * @param テスト出力するフラグ テスト出力するフラグ
     * @param 再発行するフラグ 再発行するフラグ
     * @param 発行日時の発行日 発行日時の発行日
     * @param 発行日時の時分秒 発行日時の時分秒
     * @param 出力順ID 出力順ID
     *
     */
    private KaigoHokenHihokenshashoIkkatsuSakusei(RString 出力条件コード,
            FlexibleDate 今回の開始日,
            RTime 今回の時分秒_以上,
            FlexibleDate 今回の終了日,
            RTime 今回の時分秒_未満,
            FlexibleDate 今回の基準日,
            RTime 今回の時分秒,
            FlexibleDate 交付日,
            RString テスト出力するフラグ,
            RString 再発行するフラグ,
            FlexibleDate 発行日時の発行日,
            RTime 発行日時の時分秒,
            RString 出力順ID) {

        this.出力条件コード = 出力条件コード;
        this.今回の開始日 = 今回の開始日;
        this.今回の時分秒_以上 = 今回の時分秒_以上;
        this.今回の終了日 = 今回の終了日;
        this.今回の時分秒_未満 = 今回の時分秒_未満;
        this.今回の基準日 = 今回の基準日;
        this.今回の時分秒 = 今回の時分秒;
        this.交付日 = 交付日;
        this.テスト出力するフラグ = テスト出力するフラグ;
        this.再発行するフラグ = 再発行するフラグ;
        this.発行日時の発行日 = 発行日時の発行日;
        this.発行日時の時分秒 = 発行日時の時分秒;
        this.出力順ID = 出力順ID;

    }

    /**
     * バッチパラメータの作成です。
     *
     * @param 出力条件コード 出力条件コード
     * @param 今回の開始日 今回の開始日
     * @param 今回の時分秒_以上 今回の時分秒_以上
     * @param 今回の終了日 今回の終了日
     * @param 今回の時分秒_未満 今回の時分秒_未満
     * @param 今回の基準日 今回の基準日
     * @param 今回の時分秒 今回の時分秒
     * @param 交付日 交付日
     * @param テスト出力するフラグ テスト出力するフラグ
     * @param 再発行するフラグ 再発行するフラグ
     * @param 発行日時の発行日 発行日時の発行日
     * @param 発行日時の時分秒 発行日時の時分秒
     * @param 出力順ID 出力順ID
     * @return IkkatsuHakkoBatchParameter
     */
    public static IkkatsuHakkoBatchParameter createKaigoHokenHihokenshashoBatchParameter(RString 出力条件コード,
            FlexibleDate 今回の開始日,
            RTime 今回の時分秒_以上,
            FlexibleDate 今回の終了日,
            RTime 今回の時分秒_未満,
            FlexibleDate 今回の基準日,
            RTime 今回の時分秒,
            FlexibleDate 交付日,
            RString テスト出力するフラグ,
            RString 再発行するフラグ,
            FlexibleDate 発行日時の発行日,
            RTime 発行日時の時分秒,
            RString 出力順ID) {
        return new IkkatsuHakkoBatchParameter(出力条件コード,
                今回の開始日,
                今回の時分秒_以上,
                今回の終了日,
                今回の時分秒_未満,
                今回の基準日,
                今回の時分秒,
                交付日,
                テスト出力するフラグ,
                再発行するフラグ,
                発行日時の発行日,
                発行日時の時分秒,
                出力順ID,
                BusinessConfig.get(ConfigKeysHihokenshashoIndicationMethod.被保険者証表示方法_証表示タイプ, SubGyomuCode.DBU介護統計報告));

    }
}

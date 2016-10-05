/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd571001;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;

/**
 * 受給者台帳のSQLのパラメータクラス
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class IdoChushutsuDaichoMybatisParameter implements IMyBatisParameter {

    private final RString 抽出条件設定区分;
    private final HihokenshaNo 被保険者番号From;
    private final HihokenshaNo 被保険者番号To;
    private final RDate 今回抽出開始年月日;
    private final RTime 今回抽出開始時分秒;
    private final RDate 今回抽出終了年月日;
    private final RTime 今回抽出終了時分秒;
    private final List<RString> 異動抽出対象リスト;
    private final RString 出力オプション区分;
    private final RString 出力順設定リスト;
    private final RString 市町村コード;

    private RDateTime 今回抽出開始日付;
    private RDateTime 今回抽出終了日付;
    private boolean is要介護認定;
    private boolean is利用者負担額減免;
    private boolean is施設入退所;
    private boolean is資格;
    private boolean is訪問介護;
    private boolean is居宅サービス計画;
    private boolean is老齢福祉年金;
    private boolean is負担限度額;
    private boolean is社会福祉法人軽減;
    private boolean is給付制限;
    private boolean is生活保護;

    /**
     * コンストラクタ
     *
     * @param 抽出条件設定区分 抽出条件設定区分
     * @param 被保険者番号From 被保険者番号From
     * @param 被保険者番号To 被保険者番号To
     * @param 今回抽出開始年月日 今回抽出開始年月日
     * @param 今回抽出開始時分秒 今回抽出開始時分秒
     * @param 今回抽出終了年月日 今回抽出終了年月日
     * @param 今回抽出終了時分秒 今回抽出終了時分秒
     * @param 異動抽出対象リスト 異動抽出対象リスト
     * @param 出力オプション区分 出力オプション区分
     * @param 出力順設定リスト 出力順設定リスト
     * @param 市町村コード 市町村コード
     */
    public IdoChushutsuDaichoMybatisParameter(RString 抽出条件設定区分, HihokenshaNo 被保険者番号From,
            HihokenshaNo 被保険者番号To, RDate 今回抽出開始年月日, RTime 今回抽出開始時分秒,
            RDate 今回抽出終了年月日, RTime 今回抽出終了時分秒, List<RString> 異動抽出対象リスト,
            RString 出力オプション区分, RString 出力順設定リスト, RString 市町村コード) {
        this.抽出条件設定区分 = 抽出条件設定区分;
        this.被保険者番号From = 被保険者番号From;
        this.被保険者番号To = 被保険者番号To;
        this.今回抽出開始年月日 = 今回抽出開始年月日;
        this.今回抽出開始時分秒 = 今回抽出開始時分秒;
        this.今回抽出終了年月日 = 今回抽出終了年月日;
        this.今回抽出終了時分秒 = 今回抽出終了時分秒;
        this.異動抽出対象リスト = 異動抽出対象リスト;
        this.出力オプション区分 = 出力オプション区分;
        this.出力順設定リスト = 出力順設定リスト;
        this.市町村コード = 市町村コード;
        set異動抽出対象リスト();
        get今回抽出日付();

    }

    private void set異動抽出対象リスト() {
        for (RString 異動抽出対象 : 異動抽出対象リスト) {
            if (異動抽出対象.equals(new RString("要介護認定"))) {
                is要介護認定 = true;
            } else if (異動抽出対象.equals(new RString("利用者負担額減免"))) {
                is利用者負担額減免 = true;
            } else if (異動抽出対象.equals(new RString("施設入退所"))) {
                is施設入退所 = true;
            } else if (異動抽出対象.equals(new RString("資格"))) {
                is資格 = true;
            } else if (異動抽出対象.equals(new RString("訪問介護(特別対策減免)"))) {
                is訪問介護 = true;
            } else if (異動抽出対象.equals(new RString("居宅サービス計画"))) {
                is居宅サービス計画 = true;
            } else if (異動抽出対象.equals(new RString("老齢福祉年金"))) {
                is老齢福祉年金 = true;
            } else if (異動抽出対象.equals(new RString("負担限度額(特定入所者)"))) {
                is負担限度額 = true;
            } else if (異動抽出対象.equals(new RString("社会福祉法人軽減"))) {
                is社会福祉法人軽減 = true;
            } else if (異動抽出対象.equals(new RString("給付制限"))) {
                is給付制限 = true;
            } else if (異動抽出対象.equals(new RString("生活保護"))) {
                is生活保護 = true;
            }
        }
    }

    private void get今回抽出日付() {
        今回抽出開始日付 = RDateTime.convertFrom(今回抽出開始年月日, 今回抽出開始時分秒);
        今回抽出終了日付 = RDateTime.convertFrom(今回抽出終了年月日, 今回抽出終了時分秒);
    }
}

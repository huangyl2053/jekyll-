/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd206010;

import jp.co.ndensan.reams.db.dbd.definition.core.shafugemmentaisyousyalist.JigyoshaSentaku;
import jp.co.ndensan.reams.db.dbd.definition.core.shafugemmentaisyousyalist.ShikakuSoshitsushaSentaku;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行のMybatisパラメータクラスです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD206010MybatisParameter implements IMyBatisParameter {

    private boolean is出力しない;
    private boolean 事業者番号isNotEmpty;
    private FlexibleDate last基準日;
    private boolean is事業者選択3;

    private FlexibleDate 基準日;
    private RString 資格喪失者選択;
    private RString 事業者選択;
    private RString 事業者番号;
    private RString 事業者名;
    private YMDHMS 処理日時;
    private static final RString CODE_出力しない = ShikakuSoshitsushaSentaku.出力しない.getコード();
    private static final RString CODE_事業者選択3 = JigyoshaSentaku.計画事業者とサービス事業者.getコード();

    /**
     *
     * @param 基準日 FlexibleDate
     * @param 資格喪失者選択 RString
     * @param 事業者選択 RString
     * @param 事業者番号 RString
     * @param 事業者名 RString
     * @param 処理日時 YMDHMS
     */
    public DBD206010MybatisParameter(FlexibleDate 基準日, RString 資格喪失者選択, RString 事業者選択, RString 事業者番号, RString 事業者名,
            YMDHMS 処理日時) {
        this.基準日 = 基準日;
        this.資格喪失者選択 = 資格喪失者選択;
        this.事業者選択 = 事業者選択;
        this.事業者番号 = 事業者番号;
        this.事業者名 = 事業者名;
        set事業者番号isNotEmpty(事業者番号);
        set資格喪失者出力(資格喪失者選択);
        setlast基準日(基準日);
        set事業者番号3(事業者選択);
        this.処理日時 = 処理日時;
    }

    private void set資格喪失者出力(RString 資格喪失者選択) {
        is出力しない = false;
        if (CODE_出力しない.equals(資格喪失者選択)) {
            is出力しない = true;
        }
    }

    private void set事業者番号isNotEmpty(RString 事業者番号) {
        事業者番号isNotEmpty = true;
        if (事業者番号 == null || 事業者番号.isEmpty()) {
            事業者番号isNotEmpty = false;
        }
    }

    private void setlast基準日(FlexibleDate 基準日) {
        last基準日 = 基準日.minusMonth(1);
    }

    private void set事業者番号3(RString 事業者選択) {
        is事業者選択3 = false;
        if (CODE_事業者選択3.equals(事業者選択)) {
            is事業者選択3 = true;
        }
    }
}

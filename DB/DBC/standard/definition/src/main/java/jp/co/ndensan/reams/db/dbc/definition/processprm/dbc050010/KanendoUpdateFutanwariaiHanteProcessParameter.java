/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_MeisaiIchiranChushutsuTaisho;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriTaisho;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.KanendoUpdateFutanwariaiHanteMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタ更新のプロセス用パラメータクラスです。
 *
 * @reamsid_L DBC-5010-030 x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KanendoUpdateFutanwariaiHanteProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 開始年月日;
    private FlexibleDate 終了年月日;
    private ShoriName 処理名;
    private Furikomi_ShoriKubun 処理区分;
    private Furikomi_ShoriTaisho 処理対象;
    private RDate 振込指定年月日;
    private boolean 再処理フラグ;
    private RDate 正振込指定年月日;
    private RDate 誤振込指定年月日;
    private Furikomi_ShihraiHohoShitei 支払方法;
    private FlexibleYearMonth 開始受取年月;
    private FlexibleYearMonth 終了受取年月;
    private Furikomi_MeisaiIchiranChushutsuTaisho 抽出対象;
    private FlexibleDate 対象作成年月日;

    /**
     * コンストラクタです。
     *
     * @param 開始年月日 開始年月日
     * @param 終了年月日 終了年月日
     * @param 処理名 処理名
     * @param 処理区分 処理区分
     * @param 処理対象 処理対象
     * @param 振込指定年月日 振込指定年月日
     * @param 再処理フラグ 再処理フラグ
     * @param 正振込指定年月日 正振込指定年月日
     * @param 誤振込指定年月日 誤振込指定年月日
     * @param 支払方法 支払方法
     * @param 開始受取年月 開始受取年月
     * @param 終了受取年月 終了受取年月
     * @param 抽出対象 抽出対象
     * @param 対象作成年月日 対象作成年月日
     */
    public KanendoUpdateFutanwariaiHanteProcessParameter(FlexibleDate 開始年月日,
            FlexibleDate 終了年月日, ShoriName 処理名,
            Furikomi_ShoriKubun 処理区分,
            Furikomi_ShoriTaisho 処理対象,
            RDate 振込指定年月日,
            boolean 再処理フラグ,
            RDate 正振込指定年月日,
            RDate 誤振込指定年月日,
            Furikomi_ShihraiHohoShitei 支払方法,
            FlexibleYearMonth 開始受取年月,
            FlexibleYearMonth 終了受取年月,
            Furikomi_MeisaiIchiranChushutsuTaisho 抽出対象,
            FlexibleDate 対象作成年月日) {
        this.開始年月日 = 開始年月日;
        this.終了年月日 = 終了年月日;
        this.処理名 = 処理名;
        this.処理区分 = 処理区分;
        this.処理対象 = 処理対象;
        this.振込指定年月日 = 振込指定年月日;
        this.再処理フラグ = 再処理フラグ;
        this.正振込指定年月日 = 正振込指定年月日;
        this.誤振込指定年月日 = 誤振込指定年月日;
        this.支払方法 = 支払方法;
        this.開始受取年月 = 開始受取年月;
        this.終了受取年月 = 終了受取年月;
        this.抽出対象 = 抽出対象;
        this.対象作成年月日 = 対象作成年月日;

    }

    /**
     * MYBATISパラメータを取得します。
     *
     * @return KanendoUpdateFutanwariaiHanteMybatisParameter
     */
    public KanendoUpdateFutanwariaiHanteMybatisParameter toKanendoUpdateFutanwariaiHanteMybatisParameter() {
        if (処理名 != null) {
            return new KanendoUpdateFutanwariaiHanteMybatisParameter(処理名.get名称());
        }
        return new KanendoUpdateFutanwariaiHanteMybatisParameter(RString.EMPTY);

    }
}

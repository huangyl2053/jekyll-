/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd207010.ShiharaiHohoHenkoHaakuFiveMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDMN32001_2_支払方法変更管理リスト作成_バッチプロセス5パラメタークラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoKanrFiveProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;
    private RString 登録者選択;
    private RString 差止予告登録者２号の選択;
    private RString 差止登録者２号の選択;
    private RString 償還予告登録者１号の選択;
    private RString 償還決定登録者１号の選択;
    private RString 差止中あり者のみの選択;
    private RString 保険料控除あり者のみの選択;
    private Long 改頁出力順ID;
    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private RDateTime 帳票作成日時;

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoKanrFiveProcessParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     * @param 登録者選択 登録者選択
     * @param 差止予告登録者２号の選択 差止予告登録者２号の選択
     * @param 差止登録者２号の選択 差止登録者２号の選択
     * @param 償還予告登録者１号の選択 償還予告登録者１号の選択
     * @param 償還決定登録者１号の選択 償還決定登録者１号の選択
     * @param 償還決定登録者１号_差止中あり者のみの選択 償還決定登録者１号_差止中あり者のみの選択
     * @param 償還決定登録者１号_保険料控除あり者のみの選択 償還決定登録者１号_保険料控除あり者のみの選択
     * @param 改頁出力順ID 改頁出力順ID
     * @param 帳票分類ID 帳票分類ID
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     */
    public ShiharaiHohoHenkoKanrFiveProcessParameter(FlexibleDate 基準日,
            RString 登録者選択,
            RString 差止予告登録者２号の選択,
            RString 差止登録者２号の選択,
            RString 償還予告登録者１号の選択,
            RString 償還決定登録者１号の選択,
            RString 償還決定登録者１号_差止中あり者のみの選択,
            RString 償還決定登録者１号_保険料控除あり者のみの選択,
            Long 改頁出力順ID,
            ReportId 帳票分類ID,
            ReportId 帳票ID,
            RDateTime 帳票作成日時) {
        this.基準日 = 基準日;
        this.登録者選択 = 登録者選択;
        this.差止予告登録者２号の選択 = 差止予告登録者２号の選択;
        this.差止登録者２号の選択 = 差止登録者２号の選択;
        this.償還予告登録者１号の選択 = 償還予告登録者１号の選択;
        this.償還決定登録者１号の選択 = 償還決定登録者１号の選択;
        this.差止中あり者のみの選択 = 償還決定登録者１号_差止中あり者のみの選択;
        this.保険料控除あり者のみの選択 = 償還決定登録者１号_保険料控除あり者のみの選択;
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票分類ID = 帳票分類ID;
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
    }

    /**
     * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5SQL用パラメターを取得します．
     *
     * @return DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5
     */
    public ShiharaiHohoHenkoHaakuFiveMybatisParameter toShiharaiHohoHenkoHaakuFiveMybatisParameter() {
        return new ShiharaiHohoHenkoHaakuFiveMybatisParameter(基準日);
    }
}

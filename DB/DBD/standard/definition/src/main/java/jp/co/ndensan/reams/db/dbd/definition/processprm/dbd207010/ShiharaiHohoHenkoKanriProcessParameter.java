/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd207010.ShiharaiHohoHenkoKanriMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更滞納者把握リスト作成_管理対象者情報_Processパラメタークラスです.
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoKanriProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;
    private RString 登録者選択;
    private RString 差止予告登録者２号の選択;
    private RString 差止登録者２号の選択;
    private RString 償還予告登録者１号の選択;
    private RString 償還決定登録者１号の選択;
    private RString 償還決定登録者_差止中あり者のみ１号の選択;
    private RString 償還決定登録者_保険料控除あり者のみ１号の選択;
    private Long 改頁出力順ID;
    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private RDateTime 帳票作成日時;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     * @param 登録者選択 登録者選択
     * @param 差止予告登録者２号の選択 差止予告登録者２号の選択
     * @param 差止登録者２号の選択 差止登録者２号の選択
     * @param 償還予告登録者１号の選択 償還予告登録者１号の選択
     * @param 償還決定登録者１号の選択 償還決定登録者１号の選択
     * @param 償還決定登録者_差止中あり者のみ１号の選択 償還決定登録者_差止中あり者のみ１号の選択
     * @param 償還決定登録者_保険料控除あり者のみ１号の選択 償還決定登録者_保険料控除あり者のみ１号の選択
     * @param 改頁出力順ID 改頁出力順ID
     * @param 帳票分類ID 帳票分類ID
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     */
    public ShiharaiHohoHenkoKanriProcessParameter(FlexibleDate 基準日,
            RString 登録者選択,
            RString 差止予告登録者２号の選択,
            RString 差止登録者２号の選択,
            RString 償還予告登録者１号の選択,
            RString 償還決定登録者１号の選択,
            RString 償還決定登録者_差止中あり者のみ１号の選択,
            RString 償還決定登録者_保険料控除あり者のみ１号の選択,
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
        this.償還決定登録者_差止中あり者のみ１号の選択 = 償還決定登録者_差止中あり者のみ１号の選択;
        this.償還決定登録者_保険料控除あり者のみ１号の選択 = 償還決定登録者_保険料控除あり者のみ１号の選択;
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票分類ID = 帳票分類ID;
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
    }

    /**
     * 管理対象者情報SQL用パラメターを取得します．
     *
     * @param 出力順 出力順
     * @return 管理対象者情報SQL用パラメター
     */
    public ShiharaiHohoHenkoKanriMybatisParameter toShiharaiHohoHenkoKanriMybatisParameter(RString 出力順) {
        return new ShiharaiHohoHenkoKanriMybatisParameter(基準日,
                登録者選択,
                差止予告登録者２号の選択,
                差止登録者２号の選択,
                償還予告登録者１号の選択,
                償還決定登録者１号の選択,
                償還決定登録者_差止中あり者のみ１号の選択,
                償還決定登録者_保険料控除あり者のみ１号の選択,
                出力順);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.shiharaihohokanrilist;

import jp.co.ndensan.reams.db.dbd.definition.processprm.shiharaihohohenkolist.CreateTaishoshaJohoTempTableProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更管理リスト作成用のMapper用パラメータクラスです。
 *
 * @reamsid_L DBD-3630-010 liangbc
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public final class ShiharaiHohoKanriListMapperParameter implements IMyBatisParameter {

    private final FlexibleDate 基準日;
    private final FlexibleDate 基準日減変更期限;
    private final int 登録者選択;
    private final int 差止予告登録者の選択;
    private final int 差止登録者の選択;
    private final int 償還予告登録者の選択;
    private final int 償還決定登録者の選択;
    private final int 償還決定登録者_差止中あり者のみの選択;
    private final int 償還決定登録者_保険料控除あり者のみの選択;
    private final RString 出力順;

    private ShiharaiHohoKanriListMapperParameter(FlexibleDate 基準日, FlexibleDate 基準日減変更期限, int 登録者選択, int 差止予告登録者の選択,
            int 差止登録者の選択, int 償還予告登録者の選択, int 償還決定登録者の選択, int 償還決定登録者_差止中あり者のみの選択,
            int 償還決定登録者_保険料控除あり者のみの選択, RString 出力順) {
        this.基準日 = 基準日;
        this.基準日減変更期限 = 基準日減変更期限;
        this.登録者選択 = 登録者選択;
        this.差止予告登録者の選択 = 差止予告登録者の選択;
        this.差止登録者の選択 = 差止登録者の選択;
        this.償還予告登録者の選択 = 償還予告登録者の選択;
        this.償還決定登録者の選択 = 償還決定登録者の選択;
        this.償還決定登録者_差止中あり者のみの選択 = 償還決定登録者_差止中あり者のみの選択;
        this.償還決定登録者_保険料控除あり者のみの選択 = 償還決定登録者_保険料控除あり者のみの選択;
        this.出力順 = 出力順;
    }

    /**
     * 支払方法変更管理リスト作成用MyBatisパラメータを作成します。
     *
     * @param processParameter CreateTaishoshaJohoTempTableProcessParameter
     * @param 出力順 RString
     * @return パラメータクラス
     */
    public static ShiharaiHohoKanriListMapperParameter createParameter(CreateTaishoshaJohoTempTableProcessParameter processParameter, RString 出力順) {
        int 変更期限 = Integer.parseInt(
                DbBusinessConfig.get(ConfigNameDBD.支払方法変更_支払方法変更期限, RDate.getNowDate(), SubGyomuCode.DBD介護受給).toString());
        return new ShiharaiHohoKanriListMapperParameter(
                processParameter.get基準日(),
                processParameter.get基準日().minusMonth(変更期限),
                Integer.parseInt(processParameter.get登録者選択().toString()),
                Integer.parseInt(processParameter.get差止予告登録者の選択().toString()),
                Integer.parseInt(processParameter.get差止登録者の選択().toString()),
                Integer.parseInt(processParameter.get償還予告登録者の選択().toString()),
                Integer.parseInt(processParameter.get償還決定登録者の選択().toString()),
                Integer.parseInt(processParameter.get償還決定登録者_差止中あり者のみの選択().toString()),
                Integer.parseInt(processParameter.get償還決定登録者_保険料控除あり者のみの選択().toString()),
                出力順);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 算定通知書一時テーブルに更新する用パラメータクラスです。
 *
 * @reamsid_L DBB-0780-060 xicongwang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class DecideKetteiHenkoTsuchishoParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final TsuchishoNo 通知書番号;
    private final RString 更正前後区分;
    private final RString 作成処理名;
    private final RString 決定変更区分;
    private final RString 出力順グループ指定;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     * @param 更正前後区分 RString
     * @param 作成処理名 RString
     * @param 決定変更区分 RString
     * @param 出力順グループ指定 RString
     */
    private DecideKetteiHenkoTsuchishoParameter(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            RString 更正前後区分,
            RString 作成処理名,
            RString 決定変更区分,
            RString 出力順グループ指定) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
        this.更正前後区分 = 更正前後区分;
        this.作成処理名 = 作成処理名;
        this.決定変更区分 = 決定変更区分;
        this.出力順グループ指定 = 出力順グループ指定;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     * @param 更正前後区分 RString
     * @param 作成処理名 RString
     * @param 決定変更区分 RString
     * @param 出力順グループ指定 RString
     * @return パラメータ
     */
    public static DecideKetteiHenkoTsuchishoParameter createSelectByKeyParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            RString 更正前後区分,
            RString 作成処理名,
            RString 決定変更区分,
            RString 出力順グループ指定) {
        return new DecideKetteiHenkoTsuchishoParameter(調定年度, 賦課年度, 通知書番号, 更正前後区分,
                作成処理名, 決定変更区分, 出力順グループ指定);
    }
}

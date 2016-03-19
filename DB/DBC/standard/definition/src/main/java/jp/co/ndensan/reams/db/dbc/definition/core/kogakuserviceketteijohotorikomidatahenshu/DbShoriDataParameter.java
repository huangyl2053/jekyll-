/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceketteijohotorikomidatahenshu;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額サービス費決定情報取込データ編集
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbShoriDataParameter {

    private final FlexibleYearMonth 処理年月;
    private final List<RString> ファイル名リスト;

    /**
     * コンストラクタです。
     *
     * @param 処理年月 FlexibleYearMonth
     * @param ファイル名リスト List<RString>
     */
    protected DbShoriDataParameter(FlexibleYearMonth 処理年月, List<RString> ファイル名リスト) {
        this.処理年月 = 処理年月;
        this.ファイル名リスト = ファイル名リスト;
    }

    /**
     * コンストラクタです。
     *
     * @param 処理年月 FlexibleYearMonth
     * @param ファイル名リスト List<RString>
     * @return DbShoriDataParameter
     */
    public static DbShoriDataParameter createSelectByKeyParam(FlexibleYearMonth 処理年月,
            List<RString> ファイル名リスト) {
        return new DbShoriDataParameter(処理年月, ファイル名リスト);
    }

}

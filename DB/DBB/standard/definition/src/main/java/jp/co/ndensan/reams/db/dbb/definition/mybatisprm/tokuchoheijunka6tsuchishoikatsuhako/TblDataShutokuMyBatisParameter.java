/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化（特徴6月分）通知書一括発行(バッチ)の仮算定額変更情報一時テーブルデータを取得ためのSQLパラメータクラスです。
 *
 * @reamsid_L DBB-0820-040 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TblDataShutokuMyBatisParameter extends KozaSearchParameter implements IMyBatisParameter {

    private SubGyomuCode サブ業務コード;
    private GyomuCode 業務コード;
    private FlexibleYear 調定年度;
    private FlexibleYear 調定年度minus1;
    private List<RString> 通知内容コード;
    private RString 更正前後区分;
    private RString 作成処理名;
    private RString 科目コード;
    private RString 処理日;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 通知内容コード 通知内容コード
     * @param 更正前後区分 更正前後区分
     * @param 作成処理名 作成処理名
     * @param 科目コード 科目コード
     * @param 処理日 処理日
     * @param key 口座検索用の検索キークラス
     * @param list 科目コードリスト
     */
    public TblDataShutokuMyBatisParameter(FlexibleYear 調定年度,
            List<RString> 通知内容コード, RString 更正前後区分,
            RString 作成処理名, RString 科目コード, RString 処理日, IKozaSearchKey key, List<KamokuCode> list) {

        super(key, list);
        this.サブ業務コード = SubGyomuCode.DBB介護賦課;
        this.業務コード = GyomuCode.DB介護保険;
        this.調定年度 = 調定年度;
        if (調定年度 != null) {
            this.調定年度minus1 = 調定年度.minusYear(1);
        }
        this.通知内容コード = 通知内容コード;
        this.更正前後区分 = 更正前後区分;
        this.作成処理名 = 作成処理名;
        this.科目コード = 科目コード;
        this.処理日 = 処理日;
    }

}

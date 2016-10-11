/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb014001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 普徴仮算定賦課のMyBatisパラメータクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class FuchoKarisanteiFukaMybatisParameter implements IMyBatisParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private FlexibleYear 調定前年度;
    private FlexibleYear 賦課前年度;
    private FlexibleDate 調定前年度終了日;
    private RString 処理日付区分;
    private RString 出力順;

    private RString 作成処理名;
    private RString 特別徴収対象者情報;
    private RString 特別徴収追加候補者情報;
}

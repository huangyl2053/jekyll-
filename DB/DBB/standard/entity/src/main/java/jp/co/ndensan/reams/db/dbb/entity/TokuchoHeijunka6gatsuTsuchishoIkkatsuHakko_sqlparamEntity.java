/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity;

import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko sqlparameter
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko_sqlparamEntity {

    private SubGyomuCode subgyomucode;
    private RString 年度;
    private ShoriName shoriName;
    //TODO UE特徴分配.Enum.通知内容コード.特別徴収対象者情報, UE特徴分配.Enum.通知内容コード.特別徴収追加候補者情報
    //TODO DBB介護賦課．Enum．徴収方法期別．特別徴収
    //TODO DBB介護賦課.Enum

    private RString 帳票作成日時;
    private RString 出力順ID;
    private RString 出力対象区分;
    private RString 帳票ID;

}

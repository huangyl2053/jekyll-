/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBBZ36001_1_仮算定異動賦課（バッチ）
 *
 * @reamsid_L DBB-0850-020 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiIdoKekkaIchiranCSVEntity {

    @CsvField(order = 10, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 20, name = "作成時刻")
    private RString 作成時刻;
    @CsvField(order = 30, name = "賦課年度")
    private RString 賦課年度;
    @CsvField(order = 40, name = "通知書番号")
    private RString 通知書番号;
    @CsvField(order = 50, name = "氏名")
    private RString 氏名;
    @CsvField(order = 60, name = "住所")
    private RString 住所;
    @CsvField(order = 70, name = "町域管内管外住所")
    private RString 町域管内管外住所;
    @CsvField(order = 80, name = "番地")
    private RString 番地;
    @CsvField(order = 90, name = "口座情報")
    private RString 口座情報;
    @CsvField(order = 100, name = "調定年月日")
    private RString 更正前調定年月日;
    @CsvField(order = 110, name = "特徴納付額計")
    private RString 更正前特徴納付額計;
    @CsvField(order = 120, name = "普徴納付額計")
    private RString 更正前普徴納付額計;
    @CsvField(order = 130, name = "減免額")
    private RString 更正前減免額;
    @CsvField(order = 140, name = "特徴額_１期")
    private RString 更正前特徴額_１期;
    @CsvField(order = 150, name = "特徴額_２期")
    private RString 更正前特徴額_２期;
    @CsvField(order = 160, name = "特徴額_３期")
    private RString 更正前特徴額_３期;
    @CsvField(order = 170, name = "普徴額_１期")
    private RString 更正前普徴額_１期;
    @CsvField(order = 180, name = "普徴額_２期")
    private RString 更正前普徴額_２期;
    @CsvField(order = 190, name = "普徴額_３期")
    private RString 更正前普徴額_３期;
    @CsvField(order = 200, name = "普徴額_４期")
    private RString 更正前普徴額_４期;
    @CsvField(order = 210, name = "普徴額_５期")
    private RString 更正前普徴額_５期;
    @CsvField(order = 220, name = "普徴額_６期")
    private RString 更正前普徴額_６期;
    @CsvField(order = 230, name = "普徴額_７期")
    private RString 更正前普徴額_７期;
    @CsvField(order = 240, name = "口座異動")
    private RString 更正前口座異動;
    @CsvField(order = 250, name = "徴収方法")
    private RString 更正前徴収方法;
    @CsvField(order = 260, name = "調定年月日")
    private RString 更正後調定年月日;
    @CsvField(order = 270, name = "特徴納付額計")
    private RString 更正後特徴納付額計;
    @CsvField(order = 280, name = "普徴納付額計")
    private RString 更正後普徴納付額計;
    @CsvField(order = 290, name = "減免額")
    private RString 更正後減免額;
    @CsvField(order = 300, name = "特徴額_１期")
    private RString 更正後特徴額_１期;
    @CsvField(order = 310, name = "特徴額_２期")
    private RString 更正後特徴額_２期;
    @CsvField(order = 320, name = "特徴額_３期")
    private RString 更正後特徴額_３期;
    @CsvField(order = 330, name = "普徴額_１期")
    private RString 更正後普徴額_１期;
    @CsvField(order = 340, name = "普徴額_２期")
    private RString 更正後普徴額_２期;
    @CsvField(order = 350, name = "普徴額_３期")
    private RString 更正後普徴額_３期;
    @CsvField(order = 360, name = "普徴額_４期")
    private RString 更正後普徴額_４期;
    @CsvField(order = 370, name = "普徴額_５期")
    private RString 更正後普徴額_５期;
    @CsvField(order = 380, name = "普徴額_６期")
    private RString 更正後普徴額_６期;
    @CsvField(order = 390, name = "普徴額_７期")
    private RString 更正後普徴額_７期;
    @CsvField(order = 400, name = "口座異動")
    private RString 更正後口座異動;
    @CsvField(order = 410, name = "徴収方法")
    private RString 更正後徴収方法;
    @CsvField(order = 420, name = "調定事由1")
    private RString 調定事由1;
    @CsvField(order = 430, name = "調定事由2")
    private RString 調定事由2;
    @CsvField(order = 440, name = "調定事由3")
    private RString 調定事由3;
    @CsvField(order = 450, name = "調定事由4")
    private RString 調定事由4;

}

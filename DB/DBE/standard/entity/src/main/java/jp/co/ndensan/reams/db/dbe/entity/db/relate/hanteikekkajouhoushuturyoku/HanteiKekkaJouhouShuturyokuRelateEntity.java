/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkajouhoushuturyoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 判定結果情報出力（保険者）RelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanteiKekkaJouhouShuturyokuRelateEntity {

    private RString shinseishoKanriNo;
    private RString hihokenshaNo;
    private RString hihokenshaName;
    private RString hihokenshaKana;
    private RString seibetsu;
    private RString seinengappiYMD;
    private RString ninteiShinseiYMD;
    private RString ninteiShinseiShinseijiKubunCode;
    private RString nijiHanteiYokaigoJotaiKubunCode;
    private RString shinsakaiKaisaiNo;
    private RString shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaisaiYMD;
    private RString shinsakaiKekkaJohoChushutsuYMD;

}

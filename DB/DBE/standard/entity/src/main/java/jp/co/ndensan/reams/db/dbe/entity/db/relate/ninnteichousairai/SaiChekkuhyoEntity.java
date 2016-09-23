/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査票差異チェック票のEntityクラスです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaiChekkuhyoEntity {

    private RString ichijiHanteiKekkaCode;
    private FlexibleDate nijiHanteiYMD;
    private RString nijiHanteiYokaigoJotaiKubun;
    private RString remban;
    private RString researchItem;
    private RString ninchishoSeikatsuJiritsudo;
    private RString shogaiSeikatsuJiritsudo;

}

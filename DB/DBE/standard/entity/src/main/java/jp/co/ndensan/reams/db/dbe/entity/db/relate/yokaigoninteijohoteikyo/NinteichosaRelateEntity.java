/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定申請者RelateEntityクラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaRelateEntity {

    private RString 特記事項番号;
    private RString 特記事項連番;
    private RString 特記事項区分;
    private RString 特記事項;
    private RDateTime イメージID;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfokihon;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査結果情報照会_基本調査RelateEntityクラスです。
 *
 * @reamsid_L DBE-3000-270 lizhuoxuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ChosaKekkaInfoKihonRelateEntity {

    private FlexibleDate ninteichosaJisshiYMD;
    private RString chosaJisshiBashoMeisho;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private Code shogaiNichijoSeikatsuJiritsudoCode;
    private Code koroshoIfShikibetsuCode;
}

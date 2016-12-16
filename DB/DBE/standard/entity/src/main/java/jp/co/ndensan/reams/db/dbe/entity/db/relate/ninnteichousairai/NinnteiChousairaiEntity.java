/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai;

import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査情報の取得のEntityクラスです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NinnteiChousairaiEntity {

    private RString ninteichosaItakusakiCode;
    private RString jigyoshaMeisho;
    private ChikuCode waritsukeChiku;
    private int waritsukeTeiin;
    private RString jusho;
    private TelNo telNo;
    private LasdecCode shichosonCode;
    private RString kikanKubun;
    private int waritsukesumiKensu;
    private RString ninteiChosainNo;
    private RString chosainShimei;
    private RString chosainKanaShimei;
    private RString seibetsu;
    private RString chikuCode;
    private RString chosainShikaku;
    private int chosaKanoNinzuPerMonth;
    private RString shichosonMeisho;
}

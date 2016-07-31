/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfogaikyo;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査結果情報照会_概況調査RelateEntityクラスです。
 *
 * @reamsid_L DBE-3000-260 lizhuoxuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ChosaKekkaInfoGaikyoRelateEntity {

    private FlexibleDate ninteichosaJisshiYMD;
    private RString chosaJisshiBashoMeisho;
    private RString tokki;
    private Code serviceKubunCode;
    private RString riyoShisetsuShimei;
    private RString riyoShisetsuJusho;
    private RString riyoShisetsuTelNo;
    private Code koroshoIfShikibetsuCode;
    private int remban;
    private RString serviceJokyoKinyu;
    private RString jutakuKaishu;
    private RString tokubetsuKyufuService;
    private RString zaitakuService;
    private RString shuso;
    private RString kazokuJokyo;
    private RString kyojuKankyo;
    private RString kikaiKiki;

}

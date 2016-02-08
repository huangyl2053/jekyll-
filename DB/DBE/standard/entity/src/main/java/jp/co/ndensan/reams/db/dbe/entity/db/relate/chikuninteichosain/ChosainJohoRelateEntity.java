/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.chikuninteichosain;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール詳細情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ChosainJohoRelateEntity {

    private Code chosaChikuCode;
    private RString ninteiChosaItakusakiCode;
    private RString ninteiChosainCode;
    private LasdecCode shichosonCode;
    private FlexibleDate ninteiChosaYoteiYMD;
    private RString ninteiChosaYoteiKaishiTime;
    private RString ninteiChosaYoteiShuryoTime;
    private Code ninteiChosaJikanWaku;
    private RString ninteichosaItakusakiCode;
    private RString ninteiChosainNo;
    private RString chosainShimei;

}

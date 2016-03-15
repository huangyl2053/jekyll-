/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosascheduleinput;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 調査員情報のRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaScheduleRelateEntity {

    private Code chosaChikuCode;
    private LasdecCode shichosonCode;
    private RString ninteiChosaItakusakiCode;
    private RString ninteiChosainCode;
    private FlexibleDate ninteiChosaYoteiYMD;
    private RString ninteiChosaYoteiKaishiTime;
    private RString ninteiChosaYoteiShuryoTime;
    private RString ninteiChosaJikanWaku;
    private Code yoyakuJokyo;
    private boolean yoyakuKaoFlag;
    private RString biko;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
}

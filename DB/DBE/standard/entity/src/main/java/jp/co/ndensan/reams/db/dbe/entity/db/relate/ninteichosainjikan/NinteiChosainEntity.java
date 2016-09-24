/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosainjikan;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査スケジュール情報の取得のEntityクラスです。
 *
 * @reamsid_L DBE-0022-010 linghuhang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosainEntity {

    private FlexibleDate ninteiChosaYoteiYMD;
    private RString ninteiChosaYoteiKaishiTime;
    private RString ninteiChosaYoteiShuryoTime;
    private Code ninteiChosaJikanWaku;
    private RString biko;
    private boolean yoyakuKaoFlag;
    private Code yoyakuJokyo;
}

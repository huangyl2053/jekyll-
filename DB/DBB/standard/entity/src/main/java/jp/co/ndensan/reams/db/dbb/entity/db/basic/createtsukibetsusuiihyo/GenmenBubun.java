/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 減免部分のEntityクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GenmenBubun {

    private RString choteiNendo;
    private RString fukaNendo;
    private RString tsuchishoNo;
    private RString rirekiNo;
    private RString hihokenshaNo;
    private RString hokenryoDankai;
    private RString gemmenGaku;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事務局用介護認定審査対象者一覧表のEntityクラスです。
 *
 * @reamsid_L DBE-0150-020 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaishiryoA4Entity {

    private RString shinseishoKanriNo;
    private RString shinsakaiOrder;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private RString hihokenshaName;
    private RString age;
    private RString seibetsu;
    private RString ichijiHanteiKekkaCode;
    private RString ichijiHnateiKeikokuCode;
    private RString kijunJikan;
}

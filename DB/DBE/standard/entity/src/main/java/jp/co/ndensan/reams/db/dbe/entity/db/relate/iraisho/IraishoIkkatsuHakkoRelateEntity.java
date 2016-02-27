/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.iraisho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 依頼書一括発行RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IraishoIkkatsuHakkoRelateEntity implements Serializable {

    private JigyoshaNo ninteichosaItakusakiCode;
    private RString jigyoshaMeisho;
    private RString ninteiChosainCode;
    private RString chosainShimei;

    private RString shujiiIryokikanCode;
    private RString iryoKikanMeisho;
    private RString shujiiCode;
    private AtenaMeisho shujiiName;

    private int shinseishaCount;
}

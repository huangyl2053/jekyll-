/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.shujiiiryokikanandshujiiguide;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医医療機関＆主治医RelateEntityクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIryokikanAndShujiiRelateEntity {

    private RString shichosonCode;
    private RString shujiiIryokikanCode;
    private RString iryokikanCode;
    private RString iryoKikanMeisho;
    private RString iryoKikanMeishoKana;
    private RString shujiiIryoKikanyubinNo;
    private RString shujiiIryoKikanjusho;
    private RString shujiiIryoKikantelNo;
    private RString shujiiIryoKikanfaxNo;
    private RString daihyoshaName;
    private boolean shujiiIryoKikanjokyoFlag;
    private RString shujiiCode;
    private RString shujiiName;
    private RString shujiiKana;
    private RString shujiiJohoyubinNo;
    private RString shujiiJohojusho;
    private RString shujiiJohotelNo;
    private RString shujiiJohofaxNo;
    private RString shinryokaName;
    private boolean shiteiiFlag;
    private boolean shujiiJohojokyoFlag;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体情報作成RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GogitaiJohoSakuseiRelateEntity implements Serializable {

    private int gogitaiNo;
    private RString gogitaiMei;
    private FlexibleDate gogitaiYukoKikanKaishiYMD;
    private FlexibleDate gogitaiYukoKikanShuryoYMD;
    private RString gogitaiKaishiYoteiTime;
    private RString gogitaiShuryoYoteiTime;
    private RString shinsakaiKaisaiBashoCode;
    private int shinsakaiYoteiTeiin;
    private int shinsakaiJidoWariateTeiin;
    private int shinsakaiIinTeiin;
    private boolean gogitaiSeishinkaSonzaiFlag;
    private boolean gogitaiDummyFlag;
    private RString shinsakaiKaisaiBashoName;
    private RString shinsakaiIinCode;
    private Code gogitaichoKubunCode;
    private boolean substituteFlag;
    private AtenaMeisho shinsakaiIinShimei;
}

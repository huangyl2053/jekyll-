/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput;

import java.io.Serializable;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関&主治医入力のビジネスクラスです
 *
 * @reamsid_L DBZ-1300-140 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIryokikanandshujiiDataPassModel implements Serializable {

    private RString 主治医医療機関名称;
    private RString 主治医氏名;
    private RString 主治医医療機関コード;
    private RString 主治医コード;
    private RString 市町村コード;
    private RString 医療機関市町村コード;
    private RString サブ業務コード;
    private RString 対象モード;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;
    private RString FAX番号;
    private RString 医療機関郵便番号;
    private RString 医療機関住所;
    private RString 医療機関電話番号;
    private RString 医療機関FAX番号;

    @Nonnull
    public AtenaJusho get住所AsAtenaJusho() {
        return this.住所 == null ? AtenaJusho.EMPTY : new AtenaJusho(this.住所);
    }

    @Nonnull
    public AtenaJusho get医療機関住所AsAtenaJusho() {
        return this.医療機関住所 == null ? AtenaJusho.EMPTY : new AtenaJusho(this.医療機関住所);
    }

    public TelNo get電話番号AsTelNo() {
        return this.電話番号 == null ? TelNo.EMPTY : new TelNo(this.電話番号);
    }

    public TelNo get医療機関電話番号AsTelNo() {
        return this.医療機関電話番号 == null ? TelNo.EMPTY : new TelNo(this.医療機関電話番号);
    }

    public TelNo getFAX番号AsTelNo() {
        return this.FAX番号 == null ? TelNo.EMPTY : new TelNo(this.FAX番号);
    }

    public TelNo get医療機関FAX番号AsTelNo() {
        return this.医療機関FAX番号 == null ? TelNo.EMPTY : new TelNo(this.医療機関FAX番号);
    }

}

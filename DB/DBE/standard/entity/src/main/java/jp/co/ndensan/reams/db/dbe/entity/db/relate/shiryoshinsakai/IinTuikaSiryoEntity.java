/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 追加資料鑑の情報です。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinTuikaSiryoEntity {

    private FlexibleDate shinsakaiKaisaiYMD;
    private int gogitaiNo;
    private int shinsakaiOrder;
    private RString shichosonMeisho;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private Code seibetsu;
    private int age;
    private FlexibleDate ninteiShinseiYMD;
    private Code shinseijiKubunCode;
    private Code zenIchijiHanteiKekkaCode;
    private Code jotaiKubunCode;
    private int yukoKikan;
    private Code shogaiCode;
    private Code ninchishoCode;
    private int kijunJikan;
    private Code ichijiHanteiKekkaCode;
    private RString ichijiHnateiKeikokuCode;
    private RString shinsakaiKaishiTime;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定通知書一括発行Entityのクラスです。
 *
 * @reamsid_L DBD-1430-010 lit
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiTsutishoIkkatsuHakkoEntity implements Cloneable, Serializable {

    private FlexibleDate 対象開始年月日;
    private FlexibleDate 対象終了年月日;
    private YMDHMS 対象開始日時;
    private YMDHMS 対象終了日時;
    private FlexibleYear 年度;
    private RString 年度内連番;
}

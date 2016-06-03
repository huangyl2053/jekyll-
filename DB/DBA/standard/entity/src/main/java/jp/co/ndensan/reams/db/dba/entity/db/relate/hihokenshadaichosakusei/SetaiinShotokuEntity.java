/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 世帯員情報を管理するクラスです。
 *
 * @reamsid_L DBA-0500-010 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaiinShotokuEntity {

    private ShikibetsuCode 識別コード;
    private HihokenshaNo 被保険者番号;
    private RString 氏名;
    private RString カナ氏名;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private RString 性別;
    private RString 続柄コード;
    private RString 続柄;
    private RString 種別コード;
    private RString 種別;
    private RString 課税区分_住民税減免前;
    private RString 課税区分_住民税減免後;
    private RString 激変緩和措置;
    private Decimal 合計所得金額;
    private Decimal 年金収入額;
    private Decimal 年金所得額;
    private Decimal 課税所得額;
    private RString 登録業務;
    private FlexibleDate 更正日;
    private boolean 同月サービス有無;
    private FlexibleDate 住民情報_異動日;
    private FlexibleDate 住民情報_住定日;
    private RString 住民情報_異動事由コード;
    private RString 住民情報_異動事由;
    private int 住民票表示順;
    private RString 本人区分;
    private RString 世帯コード;
}

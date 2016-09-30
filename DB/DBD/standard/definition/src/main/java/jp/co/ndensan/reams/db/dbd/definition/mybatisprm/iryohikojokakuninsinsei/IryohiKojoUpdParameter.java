/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.iryohikojokakuninsinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医療費控除データ更新用のパラメータです。
 *
 * @reamsid_L DBD-5780-010 tz_chengpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IryohiKojoUpdParameter {

    private FlexibleDate 発行年月日;
    private HihokenshaNo 被保険者番号;
    private RString 控除対象年;
    private RString データ区分;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 総合事業対象者情報クラスです．
 *
 * @reamsid_L DBD-3970-050 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SougouJigyouTaisyoSyaEntity {

    private HihokenshaNo 総合事業対象者情報_被保険者番号;
    private FlexibleDate 総合事業対象者情報_チェックリスト実施日;
    private FlexibleDate 総合事業対象者情報_適用開始年月日;
    private FlexibleDate 総合事業対象者情報_適用終了年月日;
}

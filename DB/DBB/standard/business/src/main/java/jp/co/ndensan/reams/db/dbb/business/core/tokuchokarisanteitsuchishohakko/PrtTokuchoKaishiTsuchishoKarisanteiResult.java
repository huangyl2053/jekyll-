/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteitsuchishohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴開始通知書(仮算定）の発行用引数クラスです。
 *
 * @reamsid_L DBB-0790-040 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PrtTokuchoKaishiTsuchishoKarisanteiResult {

    private List<TsuchishoDataTempResult> 特徴開始通知書ResultList;
    private FlexibleYear 調定年度;
    private YMDHMS 帳票作成日時;
    private Long 出力順ID;
    private FlexibleDate 発行日;
    private List<RString> 出力条件リスト;
    private ReportId 帳票ID;
    private RString 帳票名;
    private RString 宛名連番;
    private RString 出力対象区分;
    private RString 通知書定型文1;
    private RString 通知書定型文2;
    private Association 地方公共団体;
    private ChohyoSeigyoKyotsu 帳票制御共通;
}

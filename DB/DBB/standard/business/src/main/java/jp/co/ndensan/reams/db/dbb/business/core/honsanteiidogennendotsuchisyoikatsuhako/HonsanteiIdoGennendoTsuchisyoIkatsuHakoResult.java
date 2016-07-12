/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.honsanteiidogennendotsuchisyoikatsuhako;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidogennendotsuchisyoikatsuhako.TmpIdoGennendoKarisanteiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴開始通知書(仮算定）の発行情報クラスです。
 *
 * @reamsid_L DBB-0880-040 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiIdoGennendoTsuchisyoIkatsuHakoResult {

    private List<TmpIdoGennendoKarisanteiEntity> 特徴開始通知書ResultList;
    private FlexibleYear 調定年度;
    private YMDHMS 帳票作成日時;
    private RString 出力順ID;
    private List<RString> 出力条件リスト;
    private ReportId 帳票ID;
    private RString 帳票名;
    private RString 宛名連番;
    private RString 通知文1;
    private RString 通知文2;
    private ChohyoSeigyoKyotsu 帳票制御共通;
}

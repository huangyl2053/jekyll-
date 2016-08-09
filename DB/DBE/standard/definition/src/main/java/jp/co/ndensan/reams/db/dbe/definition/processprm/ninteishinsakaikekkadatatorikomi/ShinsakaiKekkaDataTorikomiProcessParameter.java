/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ninteishinsakaikekkadatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会審査結果データ取込み（モバイル）Process用パラメータクラスです。
 *
 * @reamsid_L DBE-1841-020 xuyongchao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiKekkaDataTorikomiProcessParameter implements IBatchProcessParameter {

    private final List<RString> filename;
    private final RString torikomidatakubun;
    private final RString torikominaiyoukubun;
    private final RString shinsakaiiintorikomikubun;
    private final RString mediapath;

    /**
     * コンストラクタ作成です。
     *
     * @param filename filename
     * @param torikomidatakubun torikomidatakubun
     * @param torikominaiyoukubun torikominaiyoukubun
     * @param shinsakaiiintorikomikubun shinsakaiiintorikomikubun
     * @param mediapath mediapath
     */
    public ShinsakaiKekkaDataTorikomiProcessParameter(List<RString> filename,
            RString torikomidatakubun,
            RString torikominaiyoukubun,
            RString shinsakaiiintorikomikubun,
            RString mediapath) {
        this.filename = filename;
        this.torikomidatakubun = torikomidatakubun;
        this.torikominaiyoukubun = torikominaiyoukubun;
        this.shinsakaiiintorikomikubun = shinsakaiiintorikomikubun;
        this.mediapath = mediapath;
    }
}

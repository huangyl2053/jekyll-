/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteishinsakaikekkadatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteishinsakaikekkadatatorikomi.ShinsakaiKekkaDataTorikomiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会審査結果データ取込み（モバイル）バッチパラメータクラスです。
 *
 * @reamsid_L DBE-1841-020 xuyongchao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiKekkaDataTorikomiBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1983264275818454152L;
    private static final String FILENAME = "filename";
    private static final String TORIKOMIDATAKUBUN = "torikomidatakubun";
    private static final String TORIKOMINAIYOUKUBUN = "torikominaiyoukubun";
    private static final String SHINSAKAIIINTORIKOMIKUBUN = "shinsakaiiintorikomikubun";
    private static final String MEDIAPATH = "mediapath";

    @BatchParameter(key = FILENAME, name = "ファイル名称")
    private List<RString> filename;
    @BatchParameter(key = TORIKOMIDATAKUBUN, name = "取込み対象データ区分")
    private RString torikomidatakubun;
    @BatchParameter(key = TORIKOMINAIYOUKUBUN, name = "取込み内容区分")
    private RString torikominaiyoukubun;
    @BatchParameter(key = SHINSAKAIIINTORIKOMIKUBUN, name = "審査会委員取込区分")
    private RString shinsakaiiintorikomikubun;
    @BatchParameter(key = MEDIAPATH, name = "外部媒体格納パス")
    private RString mediapath;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKekkaDataTorikomiBatchParameter() {

    }

    /**
     * コンストラクタです。
     *
     *
     * @param filename filename
     * @param torikomidatakubun torikomidatakubun
     * @param shinsakaiiintorikomikubun shinsakaiiintorikomikubun
     * @param torikominaiyoukubun torikominaiyoukubun
     * @param mediapath mediapath
     */
    public ShinsakaiKekkaDataTorikomiBatchParameter(
            List<RString> filename,
            RString torikomidatakubun,
            RString shinsakaiiintorikomikubun,
            RString torikominaiyoukubun,
            RString mediapath) {
        this.filename = filename;
        this.torikomidatakubun = torikomidatakubun;
        this.torikominaiyoukubun = torikominaiyoukubun;
        this.shinsakaiiintorikomikubun = shinsakaiiintorikomikubun;
        this.mediapath = mediapath;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return TaisyosyaJidoWaritsukeProcessParameter
     */
    public ShinsakaiKekkaDataTorikomiProcessParameter toShinsakaiKekkaDataTorikomiProcessParameter() {
        return new ShinsakaiKekkaDataTorikomiProcessParameter(filename,
                torikomidatakubun,
                torikominaiyoukubun,
                shinsakaiiintorikomikubun,
                mediapath);
    }

}

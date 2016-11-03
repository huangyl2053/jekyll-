/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.DBA150010;

import jp.co.ndensan.reams.db.dba.definition.processprm.dba150010.NenreiTotatsuTorokushaListProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 年齢到達登録者リストバッチのパラメータ。
 *
 * @reamsid_L DBA-0570-010 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBA150010_NenreitotatsuTorokuListParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_ZENKAIKAISHI_YMDHMS = "zenkaikaishiYMDHMS";
    private static final String KEY_ZENKAISHURYO_YMDHMS = "zenkaishuryoYMDHMS";
    private static final String KEY_KONKAIKAISHI_YMDHMS = "konkaikaishiYMDHMS";
    private static final String KEY_KONKAISHURYO_YMDHMS = "konkaishuryoYMDHMS";
    private static final String KEY_SHUTSURYOKUJUN_ID = "shutsuryokujunID";

    @BatchParameter(key = KEY_ZENKAIKAISHI_YMDHMS, name = "前回開始日時")
    private RString zenkaikaishiYMDHMS;
    @BatchParameter(key = KEY_ZENKAISHURYO_YMDHMS, name = "前回終了日時")
    private RString zenkaishuryoYMDHMS;
    @BatchParameter(key = KEY_KONKAIKAISHI_YMDHMS, name = "今回開始日時")
    private RString konkaikaishiYMDHMS;
    @BatchParameter(key = KEY_KONKAISHURYO_YMDHMS, name = "今回終了日時")
    private RString konkaishuryoYMDHMS;
    @BatchParameter(key = KEY_SHUTSURYOKUJUN_ID, name = "出力順ID")
    private Long shutsuryokujunID;

    /**
     * バーチのパラメータを作成します。
     *
     * @return NenreiTotatsuTorokushaListProcessParameter
     */
    public NenreiTotatsuTorokushaListProcessParameter toNenreiTotatsushaTorokuListProcessParameter() {
        return new NenreiTotatsuTorokushaListProcessParameter(
                zenkaikaishiYMDHMS,
                zenkaishuryoYMDHMS,
                konkaikaishiYMDHMS,
                konkaishuryoYMDHMS,
                shutsuryokujunID);
    }
}

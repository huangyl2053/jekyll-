/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.shotokujohoichiranhyosakusei;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護所得一時テーブルから対象データを抽出しのParameter
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenShotokuItijiParameter {

    private LasdecCode 市町村コード;
    private RString 開始時刻;
    private RString 終了時刻;
    private RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード LasdecCode
     * @param 開始時刻 YMDHMS
     * @param 終了時刻 YMDHMS
     * @param 出力順 RString
     */
    public KaigoHokenShotokuItijiParameter(LasdecCode 市町村コード,
            RString 開始時刻,
            RString 終了時刻,
            RString 出力順) {
        this.市町村コード = 市町村コード;
        this.開始時刻 = 開始時刻;
        this.終了時刻 = 終了時刻;
        this.出力順 = 出力順;
    }

    /**
     * toKaigoHokenShotokuItijiParameter
     *
     * @param 市町村コード LasdecCode
     * @param 開始時刻 YMDHMS
     * @param 終了時刻 YMDHMS
     * @param 出力順 RString
     * @return KaigoHokenShotokuItijiParameter
     */
    public KaigoHokenShotokuItijiParameter toKaigoHokenShotokuItijiParameter(LasdecCode 市町村コード,
            RString 開始時刻,
            RString 終了時刻,
            RString 出力順) {
        return new KaigoHokenShotokuItijiParameter(市町村コード, 開始時刻, 終了時刻, 出力順);

    }
}

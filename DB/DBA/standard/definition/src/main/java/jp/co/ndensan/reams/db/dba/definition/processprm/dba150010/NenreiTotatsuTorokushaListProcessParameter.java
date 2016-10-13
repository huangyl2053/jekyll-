/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.dba150010;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitotatsutorokushalistbatch.NenreiTotatsuTorokushaListMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 年齢到達登録者リストのバッチ処理クラスのパラメータ。
 *
 * @reamsid_L DBA-0570-020 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NenreiTotatsuTorokushaListProcessParameter implements IBatchProcessParameter {

    private RString zenkaikaishiYMDHMS;
    private RString zenkaishuryoYMDHMS;
    private RString konkaikaishiYMDHMS;
    private RString konkaishuryoYMDHMS;
    private Long shutsuryokujunID;
    private RString psmShikibetsuTaisho;
    private Code shutokuJiyu_Hihokensha;
    private List<Code> soshitsuJiyu_Hihokensha;
    private Code henkoJiyu_Hihokensha;
    private List<Code> jutokuTekiyo;
    private List<Code> jutokuKaijo;

    /**
     * コンストラクタ。
     *
     * @param zenkaikaishiYMDHMS 前回開始日時
     * @param zenkaishuryoYMDHMS 前回終了日時
     * @param konkaikaishiYMDHMS 今回開始日時
     * @param konkaishuryoYMDHMS 今回終了日時
     * @param shutsuryokujunID 出力順ID
     */
    public NenreiTotatsuTorokushaListProcessParameter(
            RString zenkaikaishiYMDHMS,
            RString zenkaishuryoYMDHMS,
            RString konkaikaishiYMDHMS,
            RString konkaishuryoYMDHMS,
            Long shutsuryokujunID) {
        this.zenkaikaishiYMDHMS = zenkaikaishiYMDHMS;
        this.zenkaishuryoYMDHMS = zenkaishuryoYMDHMS;
        this.konkaikaishiYMDHMS = konkaikaishiYMDHMS;
        this.konkaishuryoYMDHMS = konkaishuryoYMDHMS;
        this.shutsuryokujunID = shutsuryokujunID;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param shutsuryokujun 出力順
     * @param key 宛名キー
     * @return NenreiTotatsuTorokushaListMybatisParameter
     */
    public NenreiTotatsuTorokushaListMybatisParameter toNenreiTotatsushaTorokuListMybatisParameter(
            RString shutsuryokujun,
            IShikibetsuTaishoPSMSearchKey key) {
        Boolean shutsuryokujunFlg = true;
        if (shutsuryokujun == null || shutsuryokujun.isEmpty()) {

            shutsuryokujunFlg = false;
        }
        return new NenreiTotatsuTorokushaListMybatisParameter(
                konkaikaishiYMDHMS,
                konkaishuryoYMDHMS,
                psmShikibetsuTaisho,
                shutokuJiyu_Hihokensha,
                soshitsuJiyu_Hihokensha,
                henkoJiyu_Hihokensha,
                jutokuTekiyo,
                jutokuKaijo,
                shutsuryokujun,
                shutsuryokujunFlg,
                key);
    }
}

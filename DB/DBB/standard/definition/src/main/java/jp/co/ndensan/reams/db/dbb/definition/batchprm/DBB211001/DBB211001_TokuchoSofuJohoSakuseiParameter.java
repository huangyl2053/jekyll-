/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB211001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.DelTokuchoKaifuJohoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsChoshuHoho2ProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsFukaTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsJushochiTokureiTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsJushochiTokureiTsuikaTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsKaigohokenNenkinTaishosha1ProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsKaigohokenNenkinTokuchoTaishosha2ProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsKariHenkoTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsKariHenkoTsuikaTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsNenkinTokuchoKaifuJoho1ProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsNenkinTokuchoKaifuJoho2ProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsShikakuSoshitsuTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsTokuchoIraiTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsTokuchoTeishiTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsTokuchoTsuikaIraiTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsTokuchoTsuikaIraiTsuikaTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsTorikomiRirekiProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.PrtTokuchoIdojohoIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.PrtTokuchoIdojohoKensuhyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.PrtTokuchoIraijohoIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.PrtTokuchoIraijohoKensuhyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.UpdShoriDateKanriProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 *
 * 特徴送付情報作成のバッチ起動時に設定されるパラメータ
 *
 * @reamsid_L DBB-1840-040 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB211001_TokuchoSofuJohoSakuseiParameter extends BatchParameterBase {

    private static final String KEY_1 = "賦課年度";
    private static final String KEY_2 = "処理対象月";
    private static final String KEY_3 = "帳票ID";
    private static final String KEY_4 = "件数表帳票ID";
    private static final String KEY_5 = "出力順ID";

    @BatchParameter(key = KEY_1, name = "賦課年度")
    private RYear 賦課年度;
    @BatchParameter(key = KEY_2, name = "処理対象月")
    private RString 処理対象月;
    @BatchParameter(key = KEY_3, name = "帳票ID")
    private RString 帳票ID;
    @BatchParameter(key = KEY_4, name = "件数表帳票ID")
    private RString 件数表帳票ID;
    @BatchParameter(key = KEY_5, name = "出力順ID")
    private RString 出力順ID;

    /**
     * InsTokuchoIraiTempProcessParameterの取得です。
     *
     * @return InsTokuchoIraiTempProcessParameter
     */
    public InsTokuchoIraiTempProcessParameter toInsTokuchoIraiTempProcessParameter() {
        return new InsTokuchoIraiTempProcessParameter(賦課年度);
    }

    /**
     * InsNenkinTokuchoKaifuJoho1ProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @return InsNenkinTokuchoKaifuJoho1ProcessParameter
     */
    public InsNenkinTokuchoKaifuJoho1ProcessParameter toInsNenkinTokuchoKaifuJoho1ProcessParameter(
            YMDHMS システム日時) {
        return new InsNenkinTokuchoKaifuJoho1ProcessParameter(賦課年度, 処理対象月, システム日時);
    }

    /**
     * InsTorikomiRirekiProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @return InsTorikomiRirekiProcessParameter
     */
    public InsTorikomiRirekiProcessParameter toInsTorikomiRirekiProcessParameter(YMDHMS システム日時) {
        return new InsTorikomiRirekiProcessParameter(処理対象月, システム日時);
    }

    /**
     * InsKaigohokenNenkinTaishosha1ProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @return InsKaigohokenNenkinTaishosha1ProcessParameter
     */
    public InsKaigohokenNenkinTaishosha1ProcessParameter toInsKaigohokenNenkinTaishosha1ProcessParameter(YMDHMS システム日時) {
        return new InsKaigohokenNenkinTaishosha1ProcessParameter(システム日時);
    }

    /**
     * PrtTokuchoIraijohoIchiranhyoProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @param 出力条件リスト List<RString>
     * @return PrtTokuchoIraijohoIchiranhyoProcessParameter
     */
    public PrtTokuchoIraijohoIchiranhyoProcessParameter toPrtTokuchoIraijohoIchiranhyoProcessParameter(
            YMDHMS システム日時, List<RString> 出力条件リスト) {
        return new PrtTokuchoIraijohoIchiranhyoProcessParameter(賦課年度,
                帳票ID, システム日時, 出力順ID, 出力条件リスト);
    }

    /**
     * PrtTokuchoIraijohoKensuhyoProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @param 出力条件リスト List<RString>
     * @return PrtTokuchoIraijohoKensuhyoProcessParameter
     */
    public PrtTokuchoIraijohoKensuhyoProcessParameter toPrtTokuchoIraijohoKensuhyoProcessParameter(
            YMDHMS システム日時, List<RString> 出力条件リスト) {
        return new PrtTokuchoIraijohoKensuhyoProcessParameter(賦課年度,
                件数表帳票ID, システム日時, 出力条件リスト);
    }

    /**
     * InsTokuchoTeishiTempProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @return InsTokuchoTeishiTempProcessParameter
     */
    public InsTokuchoTeishiTempProcessParameter toInsTokuchoTeishiTempProcessParameter(
            YMDHMS システム日時) {
        return new InsTokuchoTeishiTempProcessParameter(賦課年度,
                処理対象月, システム日時);
    }

    /**
     * InsShikakuSoshitsuTempProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @return InsShikakuSoshitsuTempProcessParameter
     */
    public InsShikakuSoshitsuTempProcessParameter toInsShikakuSoshitsuTempProcessParameter(
            YMDHMS システム日時) {
        return new InsShikakuSoshitsuTempProcessParameter(賦課年度,
                処理対象月, システム日時);
    }

    /**
     * InsJushochiTokureiTempProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @return InsJushochiTokureiTempProcessParameter
     */
    public InsJushochiTokureiTempProcessParameter toInsJushochiTokureiTempProcessParameter(
            YMDHMS システム日時) {
        return new InsJushochiTokureiTempProcessParameter(賦課年度,
                システム日時, 処理対象月);
    }

    /**
     * InsJushochiTokureiTsuikaTempProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @return InsJushochiTokureiTsuikaTempProcessParameter
     */
    public InsJushochiTokureiTsuikaTempProcessParameter toInsJushochiTokureiTsuikaTempProcessParameter(
            YMDHMS システム日時) {
        return new InsJushochiTokureiTsuikaTempProcessParameter(賦課年度,
                処理対象月, システム日時);
    }

    /**
     * InsFukaTempProcessParameterの取得です。
     *
     * @return InsFukaTempProcessParameter
     */
    public InsFukaTempProcessParameter toInsFukaTempProcessParameter() {
        return new InsFukaTempProcessParameter(賦課年度);
    }

    /**
     * InsKariHenkoTempProcessParameterの取得です。
     *
     * @return InsKariHenkoTempProcessParameter
     */
    public InsKariHenkoTempProcessParameter toInsKariHenkoTempProcessParameter() {
        return new InsKariHenkoTempProcessParameter(処理対象月);
    }

    /**
     * InsKariHenkoTsuikaTempProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @return InsKariHenkoTsuikaTempProcessParameter
     */
    public InsKariHenkoTsuikaTempProcessParameter toInsKariHenkoTsuikaTempProcessParameter(
            YMDHMS システム日時) {
        return new InsKariHenkoTsuikaTempProcessParameter(賦課年度,
                処理対象月, システム日時);
    }

    /**
     * InsTokuchoTsuikaIraiTempProcessParameterの取得です。
     *
     * @return InsTokuchoTsuikaIraiTempProcessParameter
     */
    public InsTokuchoTsuikaIraiTempProcessParameter toInsTokuchoTsuikaIraiTempProcessParameter() {
        return new InsTokuchoTsuikaIraiTempProcessParameter(賦課年度, 処理対象月);
    }

    /**
     * InsTokuchoTsuikaIraiTsuikaTempProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @return InsTokuchoTsuikaIraiTsuikaTempProcessParameter
     */
    public InsTokuchoTsuikaIraiTsuikaTempProcessParameter toInsTokuchoTsuikaIraiTsuikaTempProcessParameter(
            YMDHMS システム日時) {
        return new InsTokuchoTsuikaIraiTsuikaTempProcessParameter(賦課年度, 処理対象月, システム日時);
    }

    /**
     * InsNenkinTokuchoKaifuJoho2ProcessParameterの取得です。
     *
     * @param is処理対象月が4月_6月 boolean
     * @param 処理対象月が5月 boolean
     * @param 処理対象月が10月_12月_2月 boolean
     * @return InsNenkinTokuchoKaifuJoho2ProcessParameter
     */
    public InsNenkinTokuchoKaifuJoho2ProcessParameter toInsNenkinTokuchoKaifuJoho2ProcessParameter(
            boolean is処理対象月が4月_6月, boolean 処理対象月が5月, boolean 処理対象月が10月_12月_2月) {
        return new InsNenkinTokuchoKaifuJoho2ProcessParameter(is処理対象月が4月_6月,
                処理対象月が5月, 処理対象月が10月_12月_2月);
    }

    /**
     * InsChoshuHoho2ProcessParameterの取得です。
     *
     * @param is処理対象月が4月_6月 boolean
     * @param is処理対象月が2月 boolean
     * @return InsChoshuHoho2ProcessParameter
     */
    public InsChoshuHoho2ProcessParameter toInsChoshuHoho2ProcessParameter(
            boolean is処理対象月が4月_6月, boolean is処理対象月が2月) {
        return new InsChoshuHoho2ProcessParameter(is処理対象月が4月_6月,
                is処理対象月が2月);
    }

    /**
     * InsKaigohokenNenkinTokuchoTaishosha2ProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @return InsKaigohokenNenkinTokuchoTaishosha2ProcessParameter
     */
    public InsKaigohokenNenkinTokuchoTaishosha2ProcessParameter toInsKaigohokenNenkinTokuchoTaishosha2ProcessParameter(
            YMDHMS システム日時) {
        return new InsKaigohokenNenkinTokuchoTaishosha2ProcessParameter(システム日時);
    }

    /**
     * PrtTokuchoIdojohoIchiranhyoProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @param 出力条件リスト List<RString>
     * @return PrtTokuchoIdojohoIchiranhyoProcessParameter
     */
    public PrtTokuchoIdojohoIchiranhyoProcessParameter toPrtTokuchoIdojohoIchiranhyoProcessParameter(
            YMDHMS システム日時, List<RString> 出力条件リスト) {
        return new PrtTokuchoIdojohoIchiranhyoProcessParameter(賦課年度,
                帳票ID, システム日時, 出力順ID, 出力条件リスト);
    }

    /**
     * PrtTokuchoIdojohoKensuhyoProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @param 出力条件リスト List<RString>
     * @return PrtTokuchoIdojohoKensuhyoProcessParameter
     */
    public PrtTokuchoIdojohoKensuhyoProcessParameter toPrtTokuchoIdojohoKensuhyoProcessParameter(
            YMDHMS システム日時, List<RString> 出力条件リスト) {
        return new PrtTokuchoIdojohoKensuhyoProcessParameter(賦課年度, 処理対象月,
                件数表帳票ID, システム日時, 出力条件リスト);
    }

    /**
     * UpdShoriDateKanriProcessParameterの取得です。
     *
     * @param システム日時 YMDHMS
     * @param 処理対象月が1月 boolean
     * @param 処理対象月が2月 boolean
     * @param 処理対象月が3月 boolean
     * @param 処理対象月が4月 boolean
     * @param 処理対象月が5月 boolean
     * @param 処理対象月が6月 boolean
     * @param 処理対象月が7月 boolean
     * @param 処理対象月が8月 boolean
     * @param 処理対象月が9月 boolean
     * @param 処理対象月が10月 boolean
     * @param 処理対象月が11月 boolean
     * @param 処理対象月が12月 boolean
     * @return UpdShoriDateKanriProcessParameter
     */
    public UpdShoriDateKanriProcessParameter toUpdShoriDateKanriProcessParameter(
            YMDHMS システム日時, boolean 処理対象月が1月, boolean 処理対象月が2月,
            boolean 処理対象月が3月, boolean 処理対象月が4月,
            boolean 処理対象月が5月, boolean 処理対象月が6月,
            boolean 処理対象月が7月, boolean 処理対象月が8月,
            boolean 処理対象月が9月, boolean 処理対象月が10月,
            boolean 処理対象月が11月, boolean 処理対象月が12月) {
        return new UpdShoriDateKanriProcessParameter(賦課年度, システム日時,
                処理対象月が1月, 処理対象月が2月, 処理対象月が3月, 処理対象月が4月,
                処理対象月が5月, 処理対象月が6月, 処理対象月が7月, 処理対象月が8月,
                処理対象月が9月, 処理対象月が10月, 処理対象月が11月, 処理対象月が12月);
    }

    /**
     * DelTokuchoKaifuJohoProcessParameterの取得です。
     *
     * @return DelTokuchoKaifuJohoProcessParameter
     */
    public DelTokuchoKaifuJohoProcessParameter toDelTokuchoKaifuJohoProcessParameter() {
        return new DelTokuchoKaifuJohoProcessParameter(賦課年度, 処理対象月);
    }
}

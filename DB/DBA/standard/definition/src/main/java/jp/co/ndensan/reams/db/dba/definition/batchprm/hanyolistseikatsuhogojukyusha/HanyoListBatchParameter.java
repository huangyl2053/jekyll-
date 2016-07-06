/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolistseikatsuhogojukyusha;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リストバッチのパラメータ。
 *
 * @reamsid_L DBA-1580-030 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListBatchParameter extends BatchParameterBase {

    private static final String KEY_CHOHYOID = "chohyoId";
    private static final String KEY_ATENACHUSHUTSUJYOKEN = "atenaChushutsuJyoken";
    private static final String KEY_SHUTSURYOKUJUNID = "shutsuryokujunId";
    private static final String KEY_SHUTSURYOKUKOMOKUID = "shutsuryokuKomokuId";
    private static final String KEY_KOMOKUMEIFUKA = "komokumeiFuka";
    private static final String KEY_RENBANFUKA = "renbanFuka";
    private static final String KEY_HITSUKEHENSHU = "hitsukeHenshu";
    private static final String KEY_HITSUKECHUSHUTSUKUBUN = "hitsukeChushutsuKubun";
    private static final String KEY_KIJUNYMD = "kijunYMD";
    private static final String KEY_CHUSHUTSUNICHIKUBUN = "chushutsunichiKubun";
    private static final String KEY_CHUSHUTSUNICHIFROM = "chushutsunichiFrom";
    private static final String KEY_CHUSHUTSUNICHITO = "chushutsunichiTo";
    private static final String KEY_JUKYUSHAJOHO_NIHONJIN = "jukyushaJoho_Nihonjin";
    private static final String KEY_JUKYUSHAJOHO_GAIKOKUJIN = "jukyushaJoho_Gaikokujin";
    private static final String KEY_FUJOSHURUI = "fujoShurui";

    @BatchParameter(key = KEY_CHOHYOID, name = "帳票ID")
    private RString chohyoId;
    @BatchParameter(key = KEY_ATENACHUSHUTSUJYOKEN, name = "宛名抽出条件")
    private RString atenaChushutsuJyoken;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = "出力順ID")
    private RString shutsuryokujunId;
    @BatchParameter(key = KEY_SHUTSURYOKUKOMOKUID, name = "出力項目ID")
    private RString shutsuryokuKomokuId;
    @BatchParameter(key = KEY_KOMOKUMEIFUKA, name = "項目名付加")
    private RString komokumeiFuka;
    @BatchParameter(key = KEY_RENBANFUKA, name = "連番付加 ")
    private RString renbanFuka;
    @BatchParameter(key = KEY_HITSUKEHENSHU, name = "日付編集")
    private RString hitsukeHenshu;
    @BatchParameter(key = KEY_HITSUKECHUSHUTSUKUBUN, name = "日付抽出区分")
    private RString hitsukeChushutsuKubun;
    @BatchParameter(key = KEY_KIJUNYMD, name = "基準日")
    private RString kijunYMD;
    @BatchParameter(key = KEY_CHUSHUTSUNICHIKUBUN, name = "範囲抽出日区分")
    private RString chushutsunichiKubun;
    @BatchParameter(key = KEY_CHUSHUTSUNICHIFROM, name = "範囲抽出日From")
    private RString chushutsunichiFrom;
    @BatchParameter(key = KEY_CHUSHUTSUNICHITO, name = "範囲抽出日To")
    private RString chushutsunichiTo;
    @BatchParameter(key = KEY_JUKYUSHAJOHO_NIHONJIN, name = "生保受給者情報・日本人")
    private boolean jukyushaJoho_Nihonjin;
    @BatchParameter(key = KEY_JUKYUSHAJOHO_GAIKOKUJIN, name = "生保受給者情報・外国人")
    private boolean jukyushaJoho_Gaikokujin;
    @BatchParameter(key = KEY_FUJOSHURUI, name = "扶助種類")
    private List<RString> fujoShurui;

//    /**
//     * バーチのパラメータを作成します。
//     *
//     * @return SeikatsuhogoJukyushaProcessParameter
//     */
//    public SeikatsuhogoJukyushaProcessParameter toSeikatsuhogoJukyushaProcessParameter() {
//        return new SeikatsuhogoJukyushaProcessParameter(
//                hakkouTyouhyou,
//                kaisaiBangou);
//    }
}

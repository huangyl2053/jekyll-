/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiGyomunaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_MeisaiIchiranChushutsuTaisho;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriTaisho;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.FurikomiDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.FurikomiDataTourokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.GdaekomimeisaiFurikomiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.HihokenshaAtenaProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.KanendoUpdateFutanwariaiHanteProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.KozaJohoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.ShikyugakuJohoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.ShoukanFurikomiProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込明細・振込みデータ作成バッチフローパラメタークラスです．
 *
 * @reamsid_L DBC-2180-030 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC050010_FurikomimeisaiFurikomiDataParameter extends BatchParameterBase {

    private static final String KEY_委託者コード = "委託者コード";
    private static final String KEY_代表金融機関コード = "代表金融機関コード";
    private static final String KEY_振込グループコード = "振込グループコード";
    private static final String KEY_処理対象 = "処理対象";
    private static final String KEY_処理区分 = "処理区分";
    private static final String KEY_振込指定年月日 = "振込指定年月日";
    private static final String KEY_再処理フラグ = "再処理フラグ";
    private static final String KEY_誤振込指定年月日 = "誤振込指定年月日";
    private static final String KEY_正振込指定年月日 = "正振込指定年月日";
    private static final String KEY_支払方法 = "支払方法";
    private static final String KEY_開始年月日 = "開始年月日";
    private static final String KEY_終了年月日 = "終了年月日";
    private static final String KEY_開始受取年月 = "開始受取年月";
    private static final String KEY_終了受取年月 = "終了受取年月";
    private static final String KEY_抽出対象 = "抽出対象";
    private static final String KEY_対象作成年月日 = "対象作成年月日";
    private static final String KEY_出力順ID = "出力順ID";

    @BatchParameter(key = KEY_委託者コード, name = "委託者コード")
    private RString 委託者コード;
    @BatchParameter(key = KEY_代表金融機関コード, name = "代表金融機関コード")
    private KinyuKikanCode 代表金融機関コード;
    @BatchParameter(key = KEY_振込グループコード, name = "振込グループコード")
    private RString 振込グループコード;
    @BatchParameter(key = KEY_処理対象, name = "処理対象")
    private Furikomi_ShoriTaisho 処理対象;
    @BatchParameter(key = KEY_処理区分, name = "処理区分")
    private Furikomi_ShoriKubun 処理区分;
    @BatchParameter(key = KEY_振込指定年月日, name = "振込指定年月日")
    private RDate 振込指定年月日;
    @BatchParameter(key = KEY_再処理フラグ, name = "再処理フラグ")
    private boolean 再処理フラグ;
    @BatchParameter(key = KEY_誤振込指定年月日, name = "誤振込指定年月日")
    private RDate 誤振込指定年月日;
    @BatchParameter(key = KEY_正振込指定年月日, name = "正振込指定年月日")
    private RDate 正振込指定年月日;
    @BatchParameter(key = KEY_支払方法, name = "支払方法")
    private Furikomi_ShihraiHohoShitei 支払方法;
    @BatchParameter(key = KEY_開始年月日, name = "開始年月日")
    private FlexibleDate 開始年月日;
    @BatchParameter(key = KEY_終了年月日, name = "終了年月日")
    private FlexibleDate 終了年月日;
    @BatchParameter(key = KEY_開始受取年月, name = "開始受取年月")
    private FlexibleYearMonth 開始受取年月;
    @BatchParameter(key = KEY_終了受取年月, name = "終了受取年月")
    private FlexibleYearMonth 終了受取年月;
    @BatchParameter(key = KEY_抽出対象, name = "抽出対象")
    private Furikomi_MeisaiIchiranChushutsuTaisho 抽出対象;
    @BatchParameter(key = KEY_対象作成年月日, name = "対象作成年月日")
    private FlexibleDate 対象作成年月日;
    @BatchParameter(key = KEY_出力順ID, name = "出力順ID")
    private Long 出力順ID;

    /**
     * 償還使用されたProcessパラメターを取得
     *
     * @return 償還使用されたProcessパラメター
     */
    public ShoukanFurikomiProcessParameter toFurikomimeisaiFurikomiProcessParameter() {
        return new ShoukanFurikomiProcessParameter(支払方法, 抽出対象,
                再処理フラグ, 開始年月日, 終了年月日, 対象作成年月日);
    }

    /**
     * 高額使用されたProcessパラメターを取得
     *
     * @return 高額使用されたProcessパラメター
     */
    public GdaekomimeisaiFurikomiProcessParameter toGdaekomimeisaiFurikomiProcessParameter() {
        return new GdaekomimeisaiFurikomiProcessParameter(支払方法, 抽出対象,
                再処理フラグ, 開始年月日, 終了年月日, 対象作成年月日,
                開始受取年月, 終了受取年月);
    }

    /**
     * 振込データ登録処理_Processパラメターを取得
     *
     * @return 振込データ登録処理_Processパラメター
     */
    public FurikomiDataTourokuProcessParameter toFurikomiDataTourokuProcessParameter() {
        return new FurikomiDataTourokuProcessParameter(委託者コード, 代表金融機関コード,
                振込グループコード,
                振込指定年月日,
                再処理フラグ,
                処理区分,
                誤振込指定年月日);
    }

    /**
     * 処理日付管理マスタ更新とバッチ出力条件パラメターを取得します．
     *
     * @param 処理名 処理名
     * @param 帳票ページCount 帳票ページCount
     * @return 処理日付管理マスタ更新とバッチ出力条件パラメター
     */
    public KanendoUpdateFutanwariaiHanteProcessParameter toKanendoUpdateFutanwariaiHanteProcessParameter(ShoriName 処理名,
            RString 帳票ページCount) {
        return new KanendoUpdateFutanwariaiHanteProcessParameter(開始年月日,
                終了年月日, 処理名,
                処理区分,
                処理対象,
                振込指定年月日,
                再処理フラグ,
                正振込指定年月日,
                誤振込指定年月日,
                支払方法,
                開始受取年月,
                終了受取年月,
                抽出対象,
                対象作成年月日,
                帳票ページCount);
    }

    /**
     * 被保険者台帳・宛名情報パラメターを取得します．
     *
     * @return 被保険者台帳・宛名情報パラメター
     */
    public HihokenshaAtenaProcessParameter toHihokenshaAtenaProcessParameter() {
        return new HihokenshaAtenaProcessParameter();
    }

    /**
     * 口座情報取得パラメターを取得します．
     *
     * @return 口座情報取得パラメター
     */
    public KozaJohoProcessParameter toKozaJohoProcessParameter() {
        return new KozaJohoProcessParameter(振込指定年月日);
    }

    /**
     * 振込データ作成パラメターを取得します．
     *
     * @param 振込業務内区分 振込業務内区分
     * @return 振込データ作成パラメター
     */
    public FurikomiDataProcessParameter toFurikomiDataProcessParameter(FurikomiGyomunaiKubun 振込業務内区分) {
        return new FurikomiDataProcessParameter(振込指定年月日, 振込業務内区分, 委託者コード);
    }

    /**
     * 振込明細一覧表作成パラメターを取得します．
     *
     * @return 振込明細一覧表作成パラメター
     */
    public ShikyugakuJohoProcessParameter toShikyugakuJohoProcessParameter() {
        return new ShikyugakuJohoProcessParameter(出力順ID, 処理区分, 支払方法);
    }
}

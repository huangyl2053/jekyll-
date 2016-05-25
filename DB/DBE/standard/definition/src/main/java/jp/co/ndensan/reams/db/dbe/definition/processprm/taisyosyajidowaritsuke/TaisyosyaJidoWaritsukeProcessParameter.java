package jp.co.ndensan.reams.db.dbe.definition.processprm.taisyosyajidowaritsuke;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者自動割付_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBE-1350-040 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaisyosyaJidoWaritsukeProcessParameter implements IBatchProcessParameter {

    private List<RString> shinsakaiKaisaiNo;
    private List<FlexibleDate> kaisaiYMD;
    private List<Integer> shinsakaiWaritsukeNinsu;
    private List<Integer> shinsakaiJidoWariateTeiin;

    /**
     * コンストラクタ作成です。
     *
     * @param shinsakaiKaisaiNo 審査会開催番号リスト
     * @param kaisaiYMD 開催日
     * @param shinsakaiWaritsukeNinsu 割付人数
     * @param shinsakaiJidoWariateTeiin 自動割当定員
     */
    public TaisyosyaJidoWaritsukeProcessParameter(List<RString> shinsakaiKaisaiNo,
            List<FlexibleDate> kaisaiYMD,
            List<Integer> shinsakaiWaritsukeNinsu,
            List<Integer> shinsakaiJidoWariateTeiin) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.kaisaiYMD = kaisaiYMD;
        this.shinsakaiWaritsukeNinsu = shinsakaiWaritsukeNinsu;
        this.shinsakaiJidoWariateTeiin = shinsakaiJidoWariateTeiin;
    }
}

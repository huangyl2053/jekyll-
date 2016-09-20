package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE510001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者自動割付のバチパラメータクラスです。
 *
 * @reamsid_L DBE-1350-040 wangxiaodong
 */
public class DBE510001_ShinsakaiAutoWaritsukeParameter extends BatchParameterBase {

    private static final String SHINSAKAI_KAISAINO = "shinsakaiKaisaiNo";
    private static final String SHINSAKAI_KAISAIYMD = "shinsakaiKaisaiKikanTo";
    private static final String SHINSAKAI_WARITSUKENINSU = "shinsakaiIinCodeList";
    private static final String SHINSAKAI_JIDOWARIATETEIIN = "shinsakaiIinCodeList";

    @BatchParameter(key = SHINSAKAI_KAISAINO, name = "審査会開催番号")
    private List<RString> shinsakaiKaisaiNo;
    @BatchParameter(key = SHINSAKAI_KAISAIYMD, name = "審査会開催日")
    private List<FlexibleDate> shinsakaiKaisaiYMD;
    @BatchParameter(key = SHINSAKAI_WARITSUKENINSU, name = "審査会割付人数")
    private List<Integer> shinsakaiWaritsukeNinsu;
    @BatchParameter(key = SHINSAKAI_JIDOWARIATETEIIN, name = "審査会自動割当定員")
    private List<Integer> shinsakaiJidoWariateTeiin;

    /**
     * コンストラクタです。
     */
    public DBE510001_ShinsakaiAutoWaritsukeParameter() {

    }

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 審査会開催番号
     * @param shinsakaiKaisaiYMD 審査会開催日
     * @param shinsakaiWaritsukeNinsu 審査会割付人数
     * @param shinsakaiJidoWariateTeiin 審査会自動割当定員
     */
    public DBE510001_ShinsakaiAutoWaritsukeParameter(
            List<RString> shinsakaiKaisaiNo,
            List<FlexibleDate> shinsakaiKaisaiYMD,
            List<Integer> shinsakaiWaritsukeNinsu,
            List<Integer> shinsakaiJidoWariateTeiin) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
        this.shinsakaiWaritsukeNinsu = shinsakaiWaritsukeNinsu;
        this.shinsakaiJidoWariateTeiin = shinsakaiJidoWariateTeiin;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return TaisyosyaJidoWaritsukeProcessParameter
     */
    public TaisyosyaJidoWaritsukeProcessParameter toTaisyosyaJidoWaritsukeProcessParameter() {
        return new TaisyosyaJidoWaritsukeProcessParameter(shinsakaiKaisaiNo,
                shinsakaiKaisaiYMD,
                shinsakaiWaritsukeNinsu,
                shinsakaiJidoWariateTeiin);
    }

}

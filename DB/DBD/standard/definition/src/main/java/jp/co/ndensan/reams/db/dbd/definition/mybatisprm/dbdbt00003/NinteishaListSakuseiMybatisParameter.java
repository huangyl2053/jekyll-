/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00003;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.homon.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 訪問介護利用者負担額減額認定者リス発行MyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3970-050 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteishaListSakuseiMybatisParameter implements IMyBatisParameter {

    private static final RString 法別区分_全て_コード = new RString("0");
    private static final RString 法別区分_施行時_いち = new RString("1");
    private static final RString 法別区分_障害時_に = new RString("2");
    private static final RString 法別区分_障害時_さん = new RString("3");
    private static final RString 対象期間指定_対象年度_いち = new RString("1");
    private static final RString 対象期間指定_基準日_に = new RString("2");
    private static final RString 対象リスト_認定者リスト_いち = new RString("1");
    private static final RString 対象リスト_該当者リスト_に = new RString("2");
    private static final RString 世帯非課税等_市町村民税非課税世帯_いち = new RString("1");
    private static final RString 世帯非課税等_所得税非課税世帯_に = new RString("2");
    private static final RString 世帯非課税等_市町村民税本人非課税者_さん = new RString("3");
    private static final RString 世帯非課税等_老齢福祉年金受給者_よん = new RString("4");
    private static final RString 世帯非課税等_生活保護受給者_ご = new RString("5");

    private boolean is対象期間指定_基準日;
    private boolean is対象期間指定_対象年度;
    private boolean is対象リスト_該当者リスト;
    private boolean is対象リスト_認定者リスト;
    private boolean is法別区分_全て;
    private boolean is法別区分_施行時;
    private boolean is法別区分_障害時;
    private boolean is法別区分_障害ヘルプ全額免除;
    private boolean is世帯非課税等_市町村民税非課税世帯;
    private boolean is世帯非課税等_所得税非課税世帯;
    private boolean is世帯非課税等_市町村民税本人非課税者;
    private boolean is世帯非課税等_老齢福祉年金受給者;
    private boolean is世帯非課税等_生活保護受給者;
    private RString 世帯表示_表示しない;
    private RString 減免減額種類_訪問介護利用者負担額減額;
    private RString 有効無効区分_有効;
    private RString 決定区分_承認する;
    private RString 法別区分施行時;
    private RString 法別区分障害時;
    private RString 法別区分障害全額免除;
    private RString 世帯課税区分_非課税;
    private TaishoKikan 対象期間指定;
    private FlexibleYear 対象年度;
    private FlexibleDate 対象年度の開始年月日;
    private FlexibleDate 対象年度の終了年月日;
    private FlexibleDate 基準日;
    private FlexibleYear 所得年度;
    private FlexibleDate 課税判定等基準日;
    private KyusochishaJukyushaKubun 旧措置者区分;
    private JukyushaKubun2 受給者区分;
    private SetaiHyoji 世帯表示;
    private List<HihokenshaKeizaiJokyo> 世帯非課税等;
    private List<CSVSettings> 出力設定;
    private Long 改頁出力順ID;
    private ReportId 帳票ID;
    private RDateTime 帳票作成日時;

    private RString psmShikibetsuTaisho;
    private RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 対象リスト 対象リスト
     * @param 対象期間指定 対象期間指定
     * @param 対象年度 対象年度
     * @param 対象年度の開始年月日 対象年度の開始年月日
     * @param 対象年度の終了年月日 対象年度の終了年月日
     * @param 基準日 基準日
     * @param 所得年度 所得年度
     * @param 課税判定等基準日 課税判定等基準日
     * @param 旧措置者区分 旧措置者区分
     * @param 法別区分 法別区分
     * @param 世帯表示 世帯表示
     * @param 受給者区分 受給者区分
     * @param 世帯非課税等 世帯非課税等
     * @param 出力設定 出力設定
     * @param 改頁出力順ID 改頁出力順ID
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     * @param psmShikibetsuTaisho 宛名
     * @param 出力順 出力順
     */
    public NinteishaListSakuseiMybatisParameter(TargetList 対象リスト,
            TaishoKikan 対象期間指定,
            FlexibleYear 対象年度,
            FlexibleDate 対象年度の開始年月日,
            FlexibleDate 対象年度の終了年月日,
            FlexibleDate 基準日,
            FlexibleYear 所得年度,
            FlexibleDate 課税判定等基準日,
            KyusochishaJukyushaKubun 旧措置者区分,
            HobetsuKubun 法別区分,
            SetaiHyoji 世帯表示,
            JukyushaKubun2 受給者区分,
            List<HihokenshaKeizaiJokyo> 世帯非課税等,
            List<CSVSettings> 出力設定,
            Long 改頁出力順ID,
            ReportId 帳票ID,
            RDateTime 帳票作成日時,
            RString psmShikibetsuTaisho,
            RString 出力順) {
        法別区分障害時 = RString.EMPTY;
        法別区分施行時 = RString.EMPTY;
        法別区分障害全額免除 = RString.EMPTY;
        this.対象年度 = 対象年度;
        this.対象年度の開始年月日 = 対象年度の開始年月日;
        this.対象年度の終了年月日 = 対象年度の終了年月日;
        this.基準日 = 基準日;
        this.所得年度 = 所得年度;
        this.課税判定等基準日 = 課税判定等基準日;
        this.旧措置者区分 = 旧措置者区分;
        this.世帯表示 = 世帯表示;
        this.受給者区分 = 受給者区分;
        this.世帯非課税等 = 世帯非課税等;
        this.出力設定 = 出力設定;
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
        edit対象期間指定(対象期間指定);
        edit対象リスト(対象リスト);
        edit法別区分(法別区分);
        edit世帯非課税等(世帯非課税等);
        this.世帯課税区分_非課税 = SetaiKazeiKubun.非課税.getコード();
        this.決定区分_承認する = KetteiKubun.承認する.getコード();
        this.減免減額種類_訪問介護利用者負担額減額 = GemmenGengakuShurui.訪問介護利用者負担額減額.getコード();
        this.有効無効区分_有効 = YukoMukoKubun.有効.getコード();
        this.世帯表示_表示しない = SetaiHyoji.表示しない.getコード();
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.出力順 = 出力順;

    }

    private void edit対象期間指定(TaishoKikan 対象期間指定) {
        if (対象期間指定_対象年度_いち.equals(対象期間指定.getコード())) {
            is対象期間指定_対象年度 = true;
        }
        if (対象期間指定_基準日_に.equals(対象期間指定.getコード())) {
            is対象期間指定_基準日 = true;
        }
    }

    private void edit対象リスト(TargetList 対象リスト) {
        if (対象リスト_認定者リスト_いち.equals(対象リスト.getコード())) {
            is対象リスト_認定者リスト = true;
        }
        if (対象リスト_該当者リスト_に.equals(対象リスト.getコード())) {
            is対象リスト_該当者リスト = true;
        }
    }

    private void edit法別区分(HobetsuKubun 法別区分) {
        if (法別区分 != null) {
            if (法別区分_全て_コード.equals(法別区分.getコード())) {
                is法別区分_全て = true;
            }
            if (法別区分_施行時_いち.equals(法別区分.getコード())) {
                法別区分施行時 = 法別区分_施行時_いち;
                is法別区分_施行時 = true;
            }
            if (法別区分_障害時_に.equals(法別区分.getコード())) {
                法別区分障害時 = 法別区分_障害時_に;
                is法別区分_障害時 = true;
            }
            if (法別区分_障害時_さん.equals(法別区分.getコード())) {
                法別区分障害全額免除 = 法別区分_障害時_さん;
                is法別区分_障害ヘルプ全額免除 = true;
            }

        }

    }

    private void edit世帯非課税等(List<HihokenshaKeizaiJokyo> 世帯非課税等) {
        for (HihokenshaKeizaiJokyo 世帯非課税情報 : 世帯非課税等) {
            if (世帯非課税等_市町村民税非課税世帯_いち.equals(世帯非課税情報.getコード())) {
                is世帯非課税等_市町村民税非課税世帯 = true;
            }
            if (世帯非課税等_所得税非課税世帯_に.equals(世帯非課税情報.getコード())) {
                is世帯非課税等_所得税非課税世帯 = true;
            }
            if (世帯非課税等_市町村民税本人非課税者_さん.equals(世帯非課税情報.getコード())) {
                is世帯非課税等_市町村民税本人非課税者 = true;
            }
            if (世帯非課税等_老齢福祉年金受給者_よん.equals(世帯非課税情報.getコード())) {
                is世帯非課税等_老齢福祉年金受給者 = true;
            }
            if (世帯非課税等_生活保護受給者_ご.equals(世帯非課税情報.getコード())) {
                is世帯非課税等_生活保護受給者 = true;
            }
        }
    }
}

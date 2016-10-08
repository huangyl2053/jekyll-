/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbz00001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.RiyoshaFutanDankaiHanni;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定者リスト作成MyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3960-050 x_liuwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteishaListSakuseiMybatisParameter implements IMyBatisParameter {

    private static final RString 対象期間指定_対象年度_いち = new RString("1");
    private static final RString 対象期間指定_基準日_に = new RString("2");

    private boolean is対象期間指定_基準日;
    private boolean is対象期間指定_対象年度;
    private boolean is対象リスト_該当者リスト;
    private boolean is対象リスト_認定者リスト;
    private boolean is世帯表示_表示する;
    private boolean is世帯表示_表示しない;
    private boolean 利用者負担1から3段階is;
    private boolean 利用者負担1段階is;
    private boolean 利用者負担2段階is;
    private boolean 利用者負担3段階is;
    private boolean 利用者負担4段階_高齢者複数世帯is;
    private RString 利用者負担1から3段階;
    private RString 利用者負担1段階;
    private RString 利用者負担2段階;
    private RString 利用者負担3段階;
    private RString 利用者負担4段階_高齢者複数世帯;
    private RString 減免減額種類_介護保険負担限度額認定;
    private RString 有効無効区分_有効;
    private RString 決定区分_承認する;
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
    private RiyoshaFutanDankaiHanni 利用者負担段階;
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
     * @param 世帯表示 世帯表示
     * @param 受給者区分 受給者区分
     * @param 利用者負担段階 利用者負担段階
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
            SetaiHyoji 世帯表示,
            JukyushaKubun2 受給者区分,
            RiyoshaFutanDankaiHanni 利用者負担段階,
            List<CSVSettings> 出力設定,
            Long 改頁出力順ID,
            ReportId 帳票ID,
            RDateTime 帳票作成日時,
            RString psmShikibetsuTaisho,
            RString 出力順) {
        this.対象年度 = 対象年度;
        this.対象年度の開始年月日 = 対象年度の開始年月日;
        this.対象年度の終了年月日 = 対象年度の終了年月日;
        this.基準日 = 基準日;
        this.所得年度 = 所得年度;
        this.課税判定等基準日 = 課税判定等基準日;
        this.旧措置者区分 = 旧措置者区分;
        this.受給者区分 = 受給者区分;
        this.利用者負担段階 = 利用者負担段階;
        this.出力設定 = 出力設定;
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
        this.有効無効区分_有効 = YukoMukoKubun.有効.getコード();
        this.減免減額種類_介護保険負担限度額認定 = GemmenGengakuShurui.負担限度額認定.getコード();
        this.決定区分_承認する = KetteiKubun.承認する.getコード();
        this.利用者負担1から3段階 = RiyoshaFutanDankaiHanni.利用者負担1から3段階.getコード();
        this.利用者負担1段階 = RiyoshaFutanDankaiHanni.利用者負担1段階.getコード();
        this.利用者負担2段階 = RiyoshaFutanDankaiHanni.利用者負担2段階.getコード();
        this.利用者負担3段階 = RiyoshaFutanDankaiHanni.利用者負担3段階.getコード();
        this.利用者負担4段階_高齢者複数世帯 = RiyoshaFutanDankaiHanni.利用者負担4段階_高齢者複数世帯.getコード();
        edit対象期間指定(対象期間指定);
        edit対象リスト(対象リスト);
        edit利用者負担段階(利用者負担段階);
        edit世帯表示(世帯表示);
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
        if (TargetList.認定者リスト.getコード().equals(対象リスト.getコード())) {
            is対象リスト_認定者リスト = true;
        }
        if (TargetList.該当者リスト.getコード().equals(対象リスト.getコード())) {
            is対象リスト_該当者リスト = true;
        }
    }

    private void edit利用者負担段階(RiyoshaFutanDankaiHanni 利用者負担段階) {
        if (RiyoshaFutanDankaiHanni.利用者負担1から3段階.getコード() == 利用者負担段階.getコード()) {
            利用者負担1から3段階is = true;
        }
        if (RiyoshaFutanDankaiHanni.利用者負担1段階.getコード() == 利用者負担段階.getコード()) {
            利用者負担1段階is = true;
        }
        if (RiyoshaFutanDankaiHanni.利用者負担2段階.getコード() == 利用者負担段階.getコード()) {
            利用者負担2段階is = true;
        }
        if (RiyoshaFutanDankaiHanni.利用者負担3段階.getコード() == 利用者負担段階.getコード()) {
            利用者負担3段階is = true;
        }
        if (RiyoshaFutanDankaiHanni.利用者負担4段階_高齢者複数世帯.getコード() == 利用者負担段階.getコード()) {
            利用者負担4段階_高齢者複数世帯is = true;
        }
    }

    private void edit世帯表示(SetaiHyoji 世帯表示) {
        if (SetaiHyoji.表示する.getコード() == 世帯表示.getコード()) {
            is世帯表示_表示する = true;
        }
        if (SetaiHyoji.表示しない.getコード() == 世帯表示.getコード()) {
            is世帯表示_表示しない = true;
        }
    }
}

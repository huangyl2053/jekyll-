/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00003;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.homon.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00003.NinteishaListSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 訪問介護利用者負担額減額認定者リス発行_process処理のパラメタークラスです。
 *
 * @reamsid_L DBD-3970-050 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteishaListSakuseiProcessParameter implements IBatchProcessParameter {

    private TargetList 対象リスト;
    private TaishoKikan 対象期間指定;
    private FlexibleYear 対象年度;
    private FlexibleDate 対象年度の開始年月日;
    private FlexibleDate 対象年度の終了年月日;
    private FlexibleDate 基準日;
    private FlexibleYear 所得年度;
    private FlexibleDate 課税判定等基準日;
    private HobetsuKubun 法別区分;
    private KyusochishaJukyushaKubun 旧措置者区分;
    private JukyushaKubun2 受給者区分;
    private SetaiHyoji 世帯表示;
    private List<HihokenshaKeizaiJokyo> 世帯非課税等;
    private List<CSVSettings> 出力設定;
    private Long 改頁出力順ID;
    private ReportId 帳票ID;
    private RDateTime 帳票作成日時;

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
     * @param 法別区分 法別区分
     * @param 旧措置者区分 旧措置者区分
     * @param 受給者区分 受給者区分
     * @param 世帯表示 世帯表示
     * @param 世帯非課税等 世帯非課税等
     * @param 出力設定 出力設定
     * @param 改頁出力順ID 改頁出力順ID
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     */
    public NinteishaListSakuseiProcessParameter(TargetList 対象リスト,
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
            RDateTime 帳票作成日時) {
        this.対象リスト = 対象リスト;
        this.対象期間指定 = 対象期間指定;
        this.対象年度 = 対象年度;
        this.対象年度の開始年月日 = 対象年度の開始年月日;
        this.対象年度の終了年月日 = 対象年度の終了年月日;
        this.基準日 = 基準日;
        this.所得年度 = 所得年度;
        this.課税判定等基準日 = 課税判定等基準日;
        this.法別区分 = 法別区分;
        this.旧措置者区分 = 旧措置者区分;
        this.受給者区分 = 受給者区分;
        this.世帯表示 = 世帯表示;
        this.世帯非課税等 = 世帯非課税等;
        this.出力設定 = 出力設定;
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
    }

    /**
     * ＳＱＬ使用された情報を作成します．
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 出力順 出力順
     * @return ＳＱＬ使用された情報を作成します．
     */
    public NinteishaListSakuseiMybatisParameter toNinteishaListSakuseiMybatisParameter(RString psmShikibetsuTaisho,
            RString 出力順) {
        return new NinteishaListSakuseiMybatisParameter(対象リスト,
                対象期間指定,
                対象年度,
                対象年度の開始年月日,
                対象年度の終了年月日,
                基準日,
                所得年度,
                課税判定等基準日,
                旧措置者区分,
                法別区分,
                世帯表示,
                受給者区分,
                世帯非課税等,
                出力設定,
                改頁出力順ID,
                帳票ID,
                帳票作成日時,
                psmShikibetsuTaisho,
                出力順);
    }
}

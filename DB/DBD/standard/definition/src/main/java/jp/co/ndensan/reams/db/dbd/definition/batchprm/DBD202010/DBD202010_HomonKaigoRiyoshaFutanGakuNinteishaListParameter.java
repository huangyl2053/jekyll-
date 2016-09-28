/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD202010;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.homon.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00003.NinteishaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00003.TaishoshaIchijiTokuteiProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 訪問介護利用者負担額減額認定者リスト画面バッチ用パラメータクラスを作成する
 *
 * @reamsid_L DBD-3970-010 xuejm
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaListParameter extends BatchParameterBase {

    private static final String TAISHOLIST = "taishoList";
    private static final String TAISHOKIKANSHITEI = "taishokikanshitei";
    private static final String TAISHONENDO = "taishonendo";
    private static final String TAISHONENDOKAISHIYMD = "taishonendokaishiYMD";
    private static final String TAISHONENDOSHURYOYMD = "taishonendoshuryoYMD";
    private static final String KIJUNYMD = "kijunYMD";
    private static final String SHOTOKUNENDO = "shotokunendo";
    private static final String KAZEIHANTEITOKIJUNDATE = "kazeihanteitokijundate";
    private static final String KYUSOCHISHAKUBUN = "kyusochishakubun";
    private static final String HOBETSUKUBUN = "hobetsukubun";
    private static final String SETAIHYOJI = "setaihyoji";
    private static final String JUKYUSHAKUBUN = "jukyushakubun";
    private static final String SETAIHIKAZEINADO = "setaihikazeinado";
    private static final String CSVSHUTSURYOKUSETEI = "csvshutsuryokusetei";
    private static final String CHANGEPAGEID = "changePageID";
    private static final String REPORTID = "reportId";

    @BatchParameter(key = TAISHOLIST, name = "対象リスト")
    private TargetList 対象リスト;
    @BatchParameter(key = TAISHOKIKANSHITEI, name = "対象期間指定")
    private TaishoKikan 対象期間指定;
    @BatchParameter(key = TAISHONENDO, name = "対象年度")
    private FlexibleYear 対象年度;
    @BatchParameter(key = TAISHONENDOKAISHIYMD, name = "対象年度の開始年月日")
    private FlexibleDate 対象年度の開始年月日;
    @BatchParameter(key = TAISHONENDOSHURYOYMD, name = "対象年度の終了年月日")
    private FlexibleDate 対象年度の終了年月日;
    @BatchParameter(key = KIJUNYMD, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = SHOTOKUNENDO, name = "所得年度")
    private FlexibleYear 所得年度;
    @BatchParameter(key = KAZEIHANTEITOKIJUNDATE, name = "課税判定等基準日")
    private FlexibleDate 課税判定等基準日;
    @BatchParameter(key = KYUSOCHISHAKUBUN, name = "旧措置区分")
    private KyusochishaJukyushaKubun 旧措置区分;
    @BatchParameter(key = HOBETSUKUBUN, name = "法別区分")
    private HobetsuKubun 法別区分;
    @BatchParameter(key = SETAIHYOJI, name = "世帯表示")
    private SetaiHyoji 世帯表示;
    @BatchParameter(key = JUKYUSHAKUBUN, name = "受給者区分")
    private JukyushaKubun2 受給者区分;
    @BatchParameter(key = SETAIHIKAZEINADO, name = "世帯非課税等")
    private List<HihokenshaKeizaiJokyo> 世帯非課税等;
    @BatchParameter(key = CSVSHUTSURYOKUSETEI, name = "CSV出力設定")
    private List<CSVSettings> csv出力設定;
    @BatchParameter(key = CHANGEPAGEID, name = "改頁出力順ID")
    private Long 改頁出力順ID;
    @BatchParameter(key = REPORTID, name = "帳票ID")
    private ReportId 帳票ID;

    /**
     * 対象者一次特定一時テーブル登録_process処理のパラメターを取得します。
     *
     * @return TaishoshaIchijiTokuteiProcessParameter
     */
    public TaishoshaIchijiTokuteiProcessParameter toTaishoshaIchijiTokuteiProcessParameter() {
        return new TaishoshaIchijiTokuteiProcessParameter(対象リスト,
                対象期間指定,
                対象年度の開始年月日,
                対象年度の終了年月日,
                基準日,
                課税判定等基準日,
                受給者区分,
                旧措置区分);
    }

    /**
     * 訪問介護利用者負担額減額認定者リス発行_process処理のパラメターを取得します。
     *
     * @param 帳票作成日時 帳票作成日時
     * @return NinteishaListSakuseiProcessParameter
     */
    public NinteishaListSakuseiProcessParameter toNinteishaListSakuseiProcessParameter(RDateTime 帳票作成日時) {
        return new NinteishaListSakuseiProcessParameter(対象リスト,
                対象期間指定,
                対象年度,
                対象年度の開始年月日,
                対象年度の終了年月日,
                基準日,
                所得年度,
                課税判定等基準日,
                旧措置区分,
                法別区分,
                世帯表示,
                受給者区分,
                世帯非課税等,
                csv出力設定,
                改頁出力順ID,
                帳票ID,
                帳票作成日時);
    }
}

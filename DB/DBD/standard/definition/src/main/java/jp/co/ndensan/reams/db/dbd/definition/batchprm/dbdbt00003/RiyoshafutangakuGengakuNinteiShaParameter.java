/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdbt00003;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun;
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
 * 訪問介護利用者負担額減額認定者リスト作成バッチパラメタークラスです
 *
 * @reamsid_L DBD-3970-030 x_xuliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshafutangakuGengakuNinteiShaParameter extends BatchParameterBase {

    private static final String TAISHORISUTO = "TaishoRisuto";
    private static final String TAISHOKIKANSHITEI = "taishokikanshitei";
    private static final String TAISHONENDO = "taishonendo";
    private static final String KAISHINENGAPPI = "kaishinengappi";
    private static final String SHYRYONENGAPPI = "shyryonengappi";
    private static final String KIJUNBI = "kijunbi";
    private static final String SHOTOKUNENDO = "shotokunendo";
    private static final String KAZEIHANTEITOKIJUNBI = "kazeihanteitokijunbi";
    private static final String KYUSOCHISHAKUBUN = "kyusochishakubun";
    private static final String NORIWAKUBUN = "noriwakubun";
    private static final String SETAIHYOJI = "setaihyoji";
    private static final String JUKYUSHAKUBUN = "jukyushakubun";
    private static final String SETAIHIKAZEITO = "setaihikazeito";
    private static final String CSVSHUTSURYOKUSETTEI = "csvshutsuryokusettei";
    private static final String ARATAMEPEJISHUTSURYOKUJUNID = "aratamepejishutsuryokujunid";
    private static final String CHOHYOID = "chohyoid";

    @BatchParameter(key = TAISHORISUTO, name = "対象リスト")
    private TargetList 対象リスト;
    @BatchParameter(key = TAISHOKIKANSHITEI, name = "対象期間指定")
    private TaishoKikan 対象期間指定;
    @BatchParameter(key = TAISHONENDO, name = "対象年度")
    private FlexibleYear 対象年度;
    @BatchParameter(key = KAISHINENGAPPI, name = "対象年度の開始年月日")
    private FlexibleDate 対象年度の開始年月日;
    @BatchParameter(key = SHYRYONENGAPPI, name = "対象年度の終了年月日")
    private FlexibleDate 対象年度の終了年月日;
    @BatchParameter(key = KIJUNBI, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = SHOTOKUNENDO, name = "所得年度")
    private FlexibleYear 所得年度;
    @BatchParameter(key = KAZEIHANTEITOKIJUNBI, name = "課税判定等基準日")
    private FlexibleDate 課税判定等基準日;
    @BatchParameter(key = KYUSOCHISHAKUBUN, name = "旧措置者区分")
    private KyusochishaKubun 旧措置者区分;
    @BatchParameter(key = NORIWAKUBUN, name = "法別区分")
    private HobetsuKubun 法別区分;
    @BatchParameter(key = SETAIHYOJI, name = "世帯表示")
    private SetaiHyoji 世帯表示;
    @BatchParameter(key = JUKYUSHAKUBUN, name = "受給者区分")
    private JukyushaKubun 受給者区分;
    @BatchParameter(key = SETAIHIKAZEITO, name = "世帯非課税等")
    private HihokenshaKeizaiJokyo 世帯非課税等;
    @BatchParameter(key = CSVSHUTSURYOKUSETTEI, name = "CSV出力設定")
    private CSVSettings 出力設定;
    @BatchParameter(key = ARATAMEPEJISHUTSURYOKUJUNID, name = "改頁出力順ID")
    private Long 改頁出力順ID;
    @BatchParameter(key = CHOHYOID, name = "帳票ID")
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
                旧措置者区分);
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
                旧措置者区分,
                法別区分,
                世帯表示,
                受給者区分,
                世帯非課税等,
                出力設定,
                改頁出力順ID,
                帳票ID,
                帳票作成日時);
    }
}

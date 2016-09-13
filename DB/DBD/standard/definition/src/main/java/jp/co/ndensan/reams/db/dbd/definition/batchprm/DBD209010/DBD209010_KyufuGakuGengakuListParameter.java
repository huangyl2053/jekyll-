/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD209010;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.shiharaihohohenko.kyufugengakukanrilist.TaishoKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32004.KyufuGakuGengakuTainoShaProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32004.TaishoShaKanriJohoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付額減額管理リスト作成バッチパラメータ
 *
 * @reamsid_L DBD-3800-030 x_xuliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD209010_KyufuGakuGengakuListParameter extends BatchParameterBase {

    private static final String KIJUNBI = "kijunbi";
    private static final String TAISHOKUBUN = "taishokubun";
    private static final String TSUCHISHOMIHAKKOSHACHUSHUTSU = "tsuchishomihakkoshachushutsu";
    private static final String GENGAKUTEKIYOCHUSHACHUSHUTSU = "gengakutekiyochushachushutsu";
    private static final String GENGAKUTEKIYOCHUSHACHUSHUTSUKIJUNBI = "gengakutekiyochushachushutsukijunbi";
    private static final String GENGAKUSHURYOBICHUSHUTSU = "gengakushuryobichushutsu";
    private static final String GENGAKUSHURYOBIHANIFROM = "gengakushuryobihanifrom";
    private static final String GENGAKUSHURYOBIHANITO = "gengakushuryobihanito";
    private static final String HOKENRYOTAINOSHASHUTSURYOKU = "hokenryotainoshashutsuryoku";
    private static final String ARATAMEPEJISHUTSURYOKUJUNID = "aratamepejishutsuryokujunid";
    private static final String CHOHYOID = "chohyoid";

    @BatchParameter(key = KIJUNBI, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = TAISHOKUBUN, name = "対象区分")
    private TaishoKubun 対象区分;
    @BatchParameter(key = TSUCHISHOMIHAKKOSHACHUSHUTSU, name = "通知書未発行者抽出")
    private boolean 通知書未発行者抽出;
    @BatchParameter(key = GENGAKUTEKIYOCHUSHACHUSHUTSU, name = "減額適用中者抽出")
    private boolean 減額適用中者抽出;
    @BatchParameter(key = GENGAKUTEKIYOCHUSHACHUSHUTSUKIJUNBI, name = "減額適用中者抽出基準日")
    private FlexibleDate 減額適用中者抽出基準日;
    @BatchParameter(key = GENGAKUSHURYOBICHUSHUTSU, name = "減額終了日抽出")
    private boolean 減額終了日抽出;
    @BatchParameter(key = GENGAKUSHURYOBIHANIFROM, name = "減額終了日範囲From")
    private FlexibleDate 減額終了日範囲From;
    @BatchParameter(key = GENGAKUSHURYOBIHANITO, name = "減額終了日範囲To")
    private FlexibleDate 減額終了日範囲To;
    @BatchParameter(key = HOKENRYOTAINOSHASHUTSURYOKU, name = "保険料完納者出力")
    private boolean 保険料完納者出力;
    @BatchParameter(key = ARATAMEPEJISHUTSURYOKUJUNID, name = "改頁出力順ID")
    private Long 改頁出力順ID;
    @BatchParameter(key = CHOHYOID, name = "帳票ID")
    private ReportId 帳票ID;

    /**
     * 対象者管理情報登録_process処理のパラメターを取得します。
     *
     * @return TaishoShaKanriJohoProcessParameter
     */
    public TaishoShaKanriJohoProcessParameter toTaishoshaIchijiTokuteiProcessParameter() {
        return new TaishoShaKanriJohoProcessParameter(基準日,
                対象区分,
                通知書未発行者抽出,
                減額適用中者抽出,
                減額適用中者抽出基準日,
                減額終了日抽出,
                減額終了日範囲From,
                減額終了日範囲To,
                保険料完納者出力
        );
    }

    /**
     * 給付額減額滞納者把握情報_process処理のパラメターを取得します。
     *
     * @param 帳票作成日時 帳票作成日時
     * @return KyufuGakuGengakuTainoShaProcessParameter
     */
    public KyufuGakuGengakuTainoShaProcessParameter toKyufuGakuGengakuTainoShaProcessParameter(RDateTime 帳票作成日時) {
        return new KyufuGakuGengakuTainoShaProcessParameter(基準日,
                対象区分,
                通知書未発行者抽出,
                減額適用中者抽出,
                減額適用中者抽出基準日,
                減額終了日抽出,
                減額終了日範囲From,
                減額終了日範囲To,
                保険料完納者出力,
                改頁出力順ID,
                帳票ID,
                帳票作成日時
        );
    }
}

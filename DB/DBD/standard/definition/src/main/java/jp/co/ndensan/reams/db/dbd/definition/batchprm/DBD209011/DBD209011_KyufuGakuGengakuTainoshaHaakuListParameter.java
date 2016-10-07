/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD209011;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd209011.KyufuGengakuHaakuListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd209011.KyufuGengakuHaakuListTaishoTokuteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd209011.ShunoJokyoHaakuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd209011.ShunoTainoJokyoHaakuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付額減額滞納者把握リストバッチパラメタークラスです．
 *
 * @reamsid_L DBD-3610-030 x_miaocl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter extends BatchParameterBase {

    private static final String KIJUNYMD = "kijunYMD";
    private static final String JIKOUKISANNDATETOUROKUSYA = "jikouKisannDateTourokuSya";
    private static final String HIHOKENSHAZENNINN = "hihokenshaZenninn";
    private static final String ZYUKYUUSYAZENNINN = "zyukyuuSyaZenninn";
    private static final String ZYUKYUUSYAZENNINNREQ = "zyukyuuSyaZenninnReq";
    private static final String ZYUKYUUNINNTEI = "zyukyuuniNntei";
    private static final String ZYUKYUUNINNTEIDATEFROM = "zyukyuuniNnteiFrom";
    private static final String ZYUKYUUNINNTEIDATETO = "zyukyuuniNnteiTo";
    private static final String NINNTEIYUUKOUSHUURYOU = "ninnteiYuukouShuuryou";
    private static final String NINNTEIYUUKOUSHUURYOUFEOM = "ninnteiYuukouShuuryouFrom";
    private static final String NINNTEIYUUKOUSHUURYOUTO = "ninnteiYuukouShuuryouTo";
    private static final String HOKENNRYOUOUTPUT = "hokennryouOutput";
    private static final String CHANGEPAGEID = "changePageId";
    private static final String REPORTID = "reportId";

    @BatchParameter(key = KIJUNYMD, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = JIKOUKISANNDATETOUROKUSYA, name = "時効起算日登録者の選択")
    private RString 時効起算日登録者の選択;
    @BatchParameter(key = HIHOKENSHAZENNINN, name = "被保険者全員の選択")
    private RString 被保険者全員の選択;
    @BatchParameter(key = ZYUKYUUSYAZENNINN, name = "受給者全員の選択")
    private RString 受給者全員の選択;
    @BatchParameter(key = ZYUKYUUSYAZENNINNREQ, name = "受給認定申請中者の選択")
    private RString 受給認定申請中者の選択;
    @BatchParameter(key = ZYUKYUUNINNTEI, name = "受給認定日抽出")
    private RString 受給認定日抽出;
    @BatchParameter(key = ZYUKYUUNINNTEIDATEFROM, name = "受給認定日抽出の開始")
    private FlexibleDate 受給認定日抽出の開始;
    @BatchParameter(key = ZYUKYUUNINNTEIDATETO, name = "受給認定日抽出の終了")
    private FlexibleDate 受給認定日抽出の終了;
    @BatchParameter(key = NINNTEIYUUKOUSHUURYOU, name = "認定有効終了日抽出")
    private RString 認定有効終了日抽出;
    @BatchParameter(key = NINNTEIYUUKOUSHUURYOUFEOM, name = "認定有効終了日抽出の開始")
    private FlexibleDate 認定有効終了日抽出の開始;
    @BatchParameter(key = NINNTEIYUUKOUSHUURYOUTO, name = "認定有効終了日抽出の終了")
    private FlexibleDate 認定有効終了日抽出の終了;
    @BatchParameter(key = HOKENNRYOUOUTPUT, name = "保険料完納者も出力")
    private RString 保険料完納者も出力;
    @BatchParameter(key = CHANGEPAGEID, name = "改頁出力順ID")
    private Long 改頁出力順ID;
    @BatchParameter(key = REPORTID, name = "帳票ID")
    private ReportId 帳票ID;

    /**
     * 給付額減額滞納者把握情報の取得_Process処理パラメターを取得します．
     *
     * @param バッチ起動時処理日時 バッチ起動時処理日時
     * @return 給付額減額滞納者把握情報の取得_Process処理パラメター
     */
    public KyufuGengakuHaakuListSakuseiProcessParameter toKyufuGengakuHaakuListSakuseiProcessParameter(RString バッチ起動時処理日時) {
        return new KyufuGengakuHaakuListSakuseiProcessParameter(基準日,
                時効起算日登録者の選択,
                被保険者全員の選択,
                受給者全員の選択,
                受給認定申請中者の選択,
                受給認定日抽出,
                受給認定日抽出の開始,
                受給認定日抽出の終了,
                認定有効終了日抽出,
                認定有効終了日抽出の開始,
                認定有効終了日抽出の終了,
                保険料完納者も出力,
                改頁出力順ID,
                帳票ID,
                バッチ起動時処理日時);
    }

    /**
     * 対象者把握情報の取得_Process処理パラメターを取得します．
     *
     * @return 対象者把握情報の取得_Process処理パラメター
     */
    public KyufuGengakuHaakuListTaishoTokuteiProcessParameter toKyufuGengakuHaakuListTaishoTokuteiProcessParameter() {
        return new KyufuGengakuHaakuListTaishoTokuteiProcessParameter(基準日,
                時効起算日登録者の選択,
                被保険者全員の選択,
                受給者全員の選択,
                受給認定申請中者の選択,
                受給認定日抽出,
                受給認定日抽出の開始,
                受給認定日抽出の終了,
                認定有効終了日抽出,
                認定有効終了日抽出の開始,
                認定有効終了日抽出の終了,
                保険料完納者も出力);
    }

    /**
     * 収納状況把握情報の取得_Process処理パラメターを取得します．
     *
     * @return 収納状況把握情報の取得_Process処理パラメター
     */
    public ShunoJokyoHaakuProcessParameter toShunoJokyoHaakuProcessParameter() {
        return new ShunoJokyoHaakuProcessParameter(基準日);
    }

    /**
     * 収納滞納状況把握情報の取得_Process処理パラメターを取得します．
     *
     * @return 収納滞納状況把握情報の取得_Process処理パラメター
     */
    public ShunoTainoJokyoHaakuProcessParameter toShunoTainoJokyoHaakuProcessParameter() {
        return new ShunoTainoJokyoHaakuProcessParameter(基準日);
    }
}

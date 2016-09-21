/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710020;

import jp.co.ndensan.reams.db.dbd.definition.processprm.hanyorisutojyukyusyadaicho.HanyoRisutoJyukyusyaDaichoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 汎用リスト受給者台帳２_バッチ用のパラメータです。
 *
 * @reamsid_L DBD-1810-020 yaodongsheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD710020_HanyoListJukyushaDaicho2Parameter extends BatchParameterBase {

    private static final String CYUSYUTSUDATAKUBUN = "cyusyutsudatakubun";
    private static final String SHINSEITORIKESHIDETACYUSYUTSU = "shinseitorikeshidetacyusyutsu";
    private static final String SAKUJYODATACYUSYUTSU = "sakujyodatacyusyutsu";
    private static final String SOSHITSUKUBUN = "soshitsukubun";
    private static final String CYUSYUTSUTAISYO = "cyusyutsutaisyo";
    private static final String CYUSYUTSUNICHISYURAI = "cyusyutsunichisyurai";
    private static final String CYUSYUTSUNICHIFROM = "cyusyutsunichifrom";
    private static final String CYUSYUTSUNICHITO = "cyusyutsunichito";
    private static final String IRYOKIKANCODEFROM = "iryokikancodefrom";
    private static final String IRYOKIKANCODEFTO = "iryokikancodefto";
    private static final String CYOSAITAKUSAKICODEFROM = "cyosaitakusakicodefrom";
    private static final String CYOSAITAKUSAKICODEFTO = "cyosaitakusakicodefto";
    private static final String ATENACYUSYUTSUJYOKEN = "atenacyusyutsujyoken";
    private static final String KAIPEJISYUTSURYOKUJUNID = "kaipejisyutsuryokujunid";
    private static final String SYUTSURYOKUKOMOKUID = "syutsuryokukomokuid";
    private static final String CYOHYOID = "cyohyoid";
    private static final String CSVKOMOKUMEIFUKA = "csvkomokumeifuka";
    private static final String CSVRENBANFUKA = "csvrenbanfuka";
    private static final String CSVHITSUKESURASYUHENSYU = "csvhitsukesurasyuhensyu";

    @BatchParameter(key = CYUSYUTSUDATAKUBUN, name = "抽出データ区分")
    private RString cyusyutsudatakubun;
    @BatchParameter(key = SHINSEITORIKESHIDETACYUSYUTSU, name = "申請取消データ抽出")
    private boolean isShinseikeshidetacyusyutsu;
    @BatchParameter(key = SAKUJYODATACYUSYUTSU, name = "削除データ抽出")
    private boolean isSakujyodatacyusyutsu;
    @BatchParameter(key = SOSHITSUKUBUN, name = "喪失区分")
    private RString soshitsukubun;
    @BatchParameter(key = CYUSYUTSUTAISYO, name = "抽出対象")
    private RString cyusyutsutaisyo;
    @BatchParameter(key = CYUSYUTSUNICHISYURAI, name = "抽出日種類")
    private RString cyusyutsunichisyurai;
    @BatchParameter(key = CYUSYUTSUNICHIFROM, name = "抽出日From")
    private FlexibleDate cyusyutsunichifrom;
    @BatchParameter(key = CYUSYUTSUNICHITO, name = "抽出日To")
    private FlexibleDate cyusyutsunichito;
    @BatchParameter(key = IRYOKIKANCODEFROM, name = "医療機関コードFrom")
    private RString iryokikancodefrom;
    @BatchParameter(key = IRYOKIKANCODEFTO, name = "医療機関コードTo")
    private RString iryokikancodefto;
    @BatchParameter(key = CYOSAITAKUSAKICODEFROM, name = "調査委託先コードFrom")
    private RString cyosaitakusakicodefrom;
    @BatchParameter(key = CYOSAITAKUSAKICODEFTO, name = "調査委託先コードTo")
    private RString cyosaitakusakicodefto;
    @BatchParameter(key = ATENACYUSYUTSUJYOKEN, name = "宛名抽出条件")
    private RString atenacyusyutsujyoken;
    @BatchParameter(key = KAIPEJISYUTSURYOKUJUNID, name = "改頁出力順ID")
    private Long kaipejisyutsuryokujunid;
    @BatchParameter(key = SYUTSURYOKUKOMOKUID, name = "出力項目ID")
    private Long syutsuryokukomokuid;
    @BatchParameter(key = CYOHYOID, name = "帳票ID")
    private RString cyohyoid;
    @BatchParameter(key = CSVKOMOKUMEIFUKA, name = "CSV項目名付加")
    private boolean isCsvkomokumeifuka;
    @BatchParameter(key = CSVRENBANFUKA, name = "CSV連番付加")
    private boolean isCsvrenbanfuka;
    @BatchParameter(key = CSVHITSUKESURASYUHENSYU, name = "CSV日付スラッシュ編集")
    private boolean isCsvhitsukesurasyuhensyu;

    /**
     * バーチのパラメータを作成します。
     *
     * @return HanyoRisutoJyukyusyaDaichoProcessParameter
     */
    public HanyoRisutoJyukyusyaDaichoProcessParameter toHanyoRisutoJyukyusyaDaichoProcessParameter() {
        return new HanyoRisutoJyukyusyaDaichoProcessParameter(cyusyutsudatakubun,
                isShinseikeshidetacyusyutsu,
                isSakujyodatacyusyutsu,
                soshitsukubun,
                cyusyutsutaisyo,
                cyusyutsunichisyurai,
                cyusyutsunichifrom,
                cyusyutsunichito,
                iryokikancodefrom,
                iryokikancodefto,
                cyosaitakusakicodefrom,
                cyosaitakusakicodefto,
                atenacyusyutsujyoken,
                kaipejisyutsuryokujunid,
                syutsuryokukomokuid,
                cyohyoid,
                isCsvkomokumeifuka,
                isCsvrenbanfuka,
                isCsvhitsukesurasyuhensyu);
    }
}

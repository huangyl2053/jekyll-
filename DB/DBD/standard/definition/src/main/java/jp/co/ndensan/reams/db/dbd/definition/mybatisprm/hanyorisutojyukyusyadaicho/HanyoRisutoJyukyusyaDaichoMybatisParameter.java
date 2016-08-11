/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutojyukyusyadaicho;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.ChushutsuDataKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.ChushutsuDateShurui;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.ChushutsuTaisho;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.SoshitsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 汎用リスト受給者台帳２のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-1810-020 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class HanyoRisutoJyukyusyaDaichoMybatisParameter implements IMyBatisParameter {

    private final boolean isShinseikeshidetacyusyutsu;
    private final boolean isSakujyodatacyusyutsu;
    private final FlexibleDate cyusyutsunichifrom;
    private final FlexibleDate cyusyutsunichito;
    private final RString iryokikancodefrom;
    private final RString iryokikancodefto;
    private final RString cyosaitakusakicodefrom;
    private final RString cyosaitakusakicodefto;
    private boolean is直近認定;
    private boolean is申請;
    private boolean is両方;
    private boolean is全履歴;
    private boolean is資格取得者のみ;
    private boolean is資格喪失者のみ;
    private boolean is指定日範囲;
    private boolean is医療機関コード範囲;
    private boolean is調査委託先コード範囲;
    private boolean is認定日;
    private boolean is申請日;
    private boolean is調査依頼日;
    private boolean is調査実施予定日;
    private boolean is調査実施日;
    private boolean is意見書依頼日;
    private boolean is意見書入手予定日;
    private boolean is意見書入手日;
    private boolean is審査会資料作成日;
    private boolean is審査会回答予定日;
    private boolean is審査会回答日;
    private boolean is認定有効開始日;
    private boolean is認定有効終了日;
    private boolean is抽出日from;
    private boolean is抽出日to;
    private boolean is医療機関コードfrom;
    private boolean is医療機関コードto;
    private boolean is調査委託先コードfrom;
    private boolean is調査委託先コードto;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;

    /**
     * コンストラクタです。
     *
     * @param cyusyutsudatakubun 抽出データ区分
     * @param isShinseikeshidetacyusyutsu 申請取消データ抽出
     * @param isSakujyodatacyusyutsu 削除データ抽出
     * @param soshitsukubun 喪失区分
     * @param cyusyutsutaisyo 抽出対象
     * @param cyusyutsunichisyurai 抽出日種類
     * @param cyusyutsunichifrom 抽出日From
     * @param cyusyutsunichito 抽出日To
     * @param iryokikancodefrom 医療機関コードFrom
     * @param iryokikancodefto 医療機関コードTo
     * @param cyosaitakusakicodefrom 調査委託先コードFrom
     * @param cyosaitakusakicodefto 調査委託先コードTo
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param psmAtesaki 宛名識別対象PSM
     */
    public HanyoRisutoJyukyusyaDaichoMybatisParameter(RString cyusyutsudatakubun,
            boolean isShinseikeshidetacyusyutsu,
            boolean isSakujyodatacyusyutsu,
            RString soshitsukubun,
            RString cyusyutsutaisyo,
            RString cyusyutsunichisyurai,
            FlexibleDate cyusyutsunichifrom,
            FlexibleDate cyusyutsunichito,
            RString iryokikancodefrom,
            RString iryokikancodefto,
            RString cyosaitakusakicodefrom,
            RString cyosaitakusakicodefto,
            RString psmShikibetsuTaisho,
            RString psmAtesaki) {
        set抽出データ区分(cyusyutsudatakubun);
        set抽出日種類(cyusyutsunichisyurai);
        this.isShinseikeshidetacyusyutsu = isShinseikeshidetacyusyutsu;
        this.isSakujyodatacyusyutsu = isSakujyodatacyusyutsu;
        if (SoshitsuKubun.資格取得者のみ.getコード().equals(soshitsukubun)) {
            is資格取得者のみ = true;
        } else if (SoshitsuKubun.資格喪失者のみ.getコード().equals(soshitsukubun)) {
            is資格喪失者のみ = true;
        }
        set抽出対象(cyusyutsutaisyo);
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
        this.cyusyutsunichifrom = cyusyutsunichifrom;
        this.cyusyutsunichito = cyusyutsunichito;
        this.iryokikancodefrom = iryokikancodefrom;
        this.iryokikancodefto = iryokikancodefto;
        this.cyosaitakusakicodefrom = cyosaitakusakicodefrom;
        this.cyosaitakusakicodefto = cyosaitakusakicodefto;
        setFromTo(cyusyutsunichifrom,
                cyusyutsunichito,
                iryokikancodefrom,
                iryokikancodefto,
                cyosaitakusakicodefrom,
                cyosaitakusakicodefto);
    }

    private void setFromTo(FlexibleDate cyusyutsunichifrom,
            FlexibleDate cyusyutsunichito,
            RString iryokikancodefrom,
            RString iryokikancodefto,
            RString cyosaitakusakicodefrom,
            RString cyosaitakusakicodefto) {
        if (cyusyutsunichifrom == null || cyusyutsunichifrom.isEmpty()) {
            is抽出日from = true;
        }
        if (cyusyutsunichito == null || cyusyutsunichito.isEmpty()) {
            is抽出日to = true;
        }
        if (RString.isNullOrEmpty(iryokikancodefrom)) {
            is医療機関コードfrom = true;
        }
        if (RString.isNullOrEmpty(iryokikancodefto)) {
            is医療機関コードto = true;
        }
        if (RString.isNullOrEmpty(cyosaitakusakicodefrom)) {
            this.is調査委託先コードfrom = true;
        }
        if (RString.isNullOrEmpty(cyosaitakusakicodefto)) {
            this.is調査委託先コードto = true;
        }
    }

    private void set抽出データ区分(RString cyusyutsudatakubun) {
        if (ChushutsuDataKubun.直近の認定データから抽出.getコード().equals(cyusyutsudatakubun)) {
            is直近認定 = true;
        } else if (ChushutsuDataKubun.申請データから抽出.getコード().equals(cyusyutsudatakubun)) {
            is申請 = true;
        } else if (ChushutsuDataKubun.両方のデータから抽出.getコード().equals(cyusyutsudatakubun)) {
            is両方 = true;
        } else if (ChushutsuDataKubun.全履歴.getコード().equals(cyusyutsudatakubun)) {
            is全履歴 = true;
        }
    }

    private void set抽出対象(RString cyusyutsutaisyo) {
        if (ChushutsuTaisho.医療機関.getコード().equals(cyusyutsutaisyo)) {
            is医療機関コード範囲 = true;
        } else if (ChushutsuTaisho.抽出年月日.getコード().equals(cyusyutsutaisyo)) {
            is指定日範囲 = true;
        } else if (ChushutsuTaisho.調査委託先.getコード().equals(cyusyutsutaisyo)) {
            is調査委託先コード範囲 = true;
        }
    }

    private void set抽出日種類(RString cyusyutsunichisyurai) {
        if (ChushutsuDateShurui.認定日.getコード().equals(cyusyutsunichisyurai)) {
            is認定日 = true;
        } else if (ChushutsuDateShurui.申請日.getコード().equals(cyusyutsunichisyurai)) {
            is申請日 = true;
        } else if (ChushutsuDateShurui.調査依頼日.getコード().equals(cyusyutsunichisyurai)) {
            is調査依頼日 = true;
        } else if (ChushutsuDateShurui.調査実施予定日.getコード().equals(cyusyutsunichisyurai)) {
            is調査実施予定日 = true;
        } else if (ChushutsuDateShurui.調査実施日.getコード().equals(cyusyutsunichisyurai)) {
            is調査実施日 = true;
        } else if (ChushutsuDateShurui.意見書依頼日.getコード().equals(cyusyutsunichisyurai)) {
            is意見書依頼日 = true;
        } else if (ChushutsuDateShurui.意見書入手予定日.getコード().equals(cyusyutsunichisyurai)) {
            is意見書入手予定日 = true;
        } else if (ChushutsuDateShurui.意見書入手日.getコード().equals(cyusyutsunichisyurai)) {
            is意見書入手日 = true;
        } else if (ChushutsuDateShurui.審査会資料作成日.getコード().equals(cyusyutsunichisyurai)) {
            is審査会資料作成日 = true;
        } else if (ChushutsuDateShurui.審査会回答予定日.getコード().equals(cyusyutsunichisyurai)) {
            is審査会回答予定日 = true;
        } else if (ChushutsuDateShurui.審査会回答日.getコード().equals(cyusyutsunichisyurai)) {
            is審査会回答日 = true;
        } else if (ChushutsuDateShurui.認定有効開始日.getコード().equals(cyusyutsunichisyurai)) {
            is認定有効開始日 = true;
        } else if (ChushutsuDateShurui.認定有効終了日.getコード().equals(cyusyutsunichisyurai)) {
            is認定有効終了日 = true;
        }
    }
}

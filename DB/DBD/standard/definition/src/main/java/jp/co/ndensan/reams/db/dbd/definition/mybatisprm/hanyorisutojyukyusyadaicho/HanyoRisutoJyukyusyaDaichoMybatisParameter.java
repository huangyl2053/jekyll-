/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutojyukyusyadaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト受給者台帳２のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1810-020 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoRisutoJyukyusyaDaichoMybatisParameter {

    private final RString cyusyutsudatakubun;
    private final boolean shinseitorikeshidetacyusyutsu;
    private final boolean sakujyodatacyusyutsu;
    private final RString soshitsukubun;
    private final RString cyusyutsutaisyo;
    private final RString cyusyutsunichisyurai;
    private final FlexibleDate cyusyutsunichifrom;
    private final FlexibleDate cyusyutsunichito;
    private final RString iryokikancodefrom;
    private final RString iryokikancodefto;
    private final RString cyosaitakusakicodefrom;
    private final RString cyosaitakusakicodefto;

    /**
     * コンストラクタです。
     *
     * @param cyusyutsudatakubun 抽出データ区分
     * @param shinseitorikeshidetacyusyutsu 申請取消データ抽出
     * @param sakujyodatacyusyutsu 削除データ抽出
     * @param soshitsukubun 喪失区分
     * @param cyusyutsutaisyo 抽出対象
     * @param cyusyutsunichisyurai 抽出日種類
     * @param cyusyutsunichifrom 抽出日From
     * @param cyusyutsunichito 抽出日To
     * @param iryokikancodefrom 医療機関コードFrom
     * @param iryokikancodefto 医療機関コードTo
     * @param cyosaitakusakicodefrom 調査委託先コードFrom
     * @param cyosaitakusakicodefto 調査委託先コードTo
     */
    public HanyoRisutoJyukyusyaDaichoMybatisParameter(RString cyusyutsudatakubun,
            boolean shinseitorikeshidetacyusyutsu,
            boolean sakujyodatacyusyutsu,
            RString soshitsukubun,
            RString cyusyutsutaisyo,
            RString cyusyutsunichisyurai,
            FlexibleDate cyusyutsunichifrom,
            FlexibleDate cyusyutsunichito,
            RString iryokikancodefrom,
            RString iryokikancodefto,
            RString cyosaitakusakicodefrom,
            RString cyosaitakusakicodefto) {
        this.cyusyutsudatakubun = cyusyutsudatakubun;
        this.shinseitorikeshidetacyusyutsu = shinseitorikeshidetacyusyutsu;
        this.sakujyodatacyusyutsu = sakujyodatacyusyutsu;
        this.soshitsukubun = soshitsukubun;
        this.cyusyutsutaisyo = cyusyutsutaisyo;
        this.cyusyutsunichisyurai = cyusyutsunichisyurai;
        this.cyusyutsunichifrom = cyusyutsunichifrom;
        this.cyusyutsunichito = cyusyutsunichito;
        this.iryokikancodefrom = iryokikancodefrom;
        this.iryokikancodefto = iryokikancodefto;
        this.cyosaitakusakicodefrom = cyosaitakusakicodefrom;
        this.cyosaitakusakicodefto = cyosaitakusakicodefto;

    }
}

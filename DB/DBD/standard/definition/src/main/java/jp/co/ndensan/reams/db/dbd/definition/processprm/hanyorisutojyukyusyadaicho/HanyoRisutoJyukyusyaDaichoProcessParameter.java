/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.hanyorisutojyukyusyadaicho;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutojyukyusyadaicho.HanyoRisutoJyukyusyaDaichoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト受給者台帳２のProcess用パラメータクラスです。
 *
 * @reamsid_L DBD-1810-020 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoRisutoJyukyusyaDaichoProcessParameter implements IBatchProcessParameter {

    private RString cyusyutsudatakubun;
    private boolean isShinseikeshidetacyusyutsu;
    private boolean isSakujyodatacyusyutsu;
    private RString soshitsukubun;
    private RString cyusyutsutaisyo;
    private RString cyusyutsunichisyurai;
    private FlexibleDate cyusyutsunichifrom;
    private FlexibleDate cyusyutsunichito;
    private RString iryokikancodefrom;
    private RString iryokikancodefto;
    private RString cyosaitakusakicodefrom;
    private RString cyosaitakusakicodefto;
    private RString atenacyusyutsujyoken;
    private Long kaipejisyutsuryokujunid;
    private Long syutsuryokukomokuid;
    private RString cyohyoid;
    private boolean isCsvkomokumeifuka;
    private boolean isCsvrenbanfuka;
    private boolean isCsvhitsukesurasyuhensyu;

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
     * @param atenacyusyutsujyoken 宛名抽出条件
     * @param kaipejisyutsuryokujunid 改頁出力順ID
     * @param syutsuryokukomokuid 出力項目ID
     * @param cyohyoid 帳票ID
     * @param isCsvkomokumeifuka CSV項目名付加
     * @param isCsvrenbanfuka CSV連番付加
     * @param isCsvhitsukesurasyuhensyu CSV日付スラッシュ編集
     */
    public HanyoRisutoJyukyusyaDaichoProcessParameter(RString cyusyutsudatakubun,
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
            RString atenacyusyutsujyoken,
            Long kaipejisyutsuryokujunid,
            Long syutsuryokukomokuid,
            RString cyohyoid,
            boolean isCsvkomokumeifuka,
            boolean isCsvrenbanfuka,
            boolean isCsvhitsukesurasyuhensyu) {
        this.cyusyutsudatakubun = cyusyutsudatakubun;
        this.isShinseikeshidetacyusyutsu = isShinseikeshidetacyusyutsu;
        this.isSakujyodatacyusyutsu = isSakujyodatacyusyutsu;
        this.soshitsukubun = soshitsukubun;
        this.cyusyutsutaisyo = cyusyutsutaisyo;
        this.cyusyutsunichisyurai = cyusyutsunichisyurai;
        this.cyusyutsunichifrom = cyusyutsunichifrom;
        this.cyusyutsunichito = cyusyutsunichito;
        this.iryokikancodefrom = iryokikancodefrom;
        this.iryokikancodefto = iryokikancodefto;
        this.cyosaitakusakicodefrom = cyosaitakusakicodefrom;
        this.cyosaitakusakicodefto = cyosaitakusakicodefto;
        this.atenacyusyutsujyoken = atenacyusyutsujyoken;
        this.kaipejisyutsuryokujunid = kaipejisyutsuryokujunid;
        this.syutsuryokukomokuid = syutsuryokukomokuid;
        this.cyohyoid = cyohyoid;
        this.isCsvkomokumeifuka = isCsvkomokumeifuka;
        this.isCsvrenbanfuka = isCsvrenbanfuka;
        this.isCsvhitsukesurasyuhensyu = isCsvhitsukesurasyuhensyu;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param psmAtesaki 宛先PSM
     * @return HanyoRisutoJyukyusyaDaichoMybatisParameter
     */
    public HanyoRisutoJyukyusyaDaichoMybatisParameter toHanyoRisutoJyukyusyaDaichoMybatisParameter(RString psmShikibetsuTaisho, RString psmAtesaki) {
        return new HanyoRisutoJyukyusyaDaichoMybatisParameter(cyusyutsudatakubun,
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
                psmShikibetsuTaisho,
                psmAtesaki);
    }
}

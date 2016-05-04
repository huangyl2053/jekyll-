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
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト受給者台帳２のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-1810-020 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoRisutoJyukyusyaDaichoMybatisParameter implements IMyBatisParameter {

    private final boolean isShinseitorikeshidetacyusyutsu;
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
    private RString psmShikibetsuTaisho;
    private RString psmAtesaki;

    /**
     * コンストラクタです。
     *
     * @param cyusyutsudatakubun 抽出データ区分
     * @param isShinseitorikeshidetacyusyutsu 申請取消データ抽出
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
     */
    public HanyoRisutoJyukyusyaDaichoMybatisParameter(RString cyusyutsudatakubun,
            boolean isShinseitorikeshidetacyusyutsu,
            boolean isSakujyodatacyusyutsu,
            RString soshitsukubun,
            RString cyusyutsutaisyo,
            RString cyusyutsunichisyurai,
            FlexibleDate cyusyutsunichifrom,
            FlexibleDate cyusyutsunichito,
            RString iryokikancodefrom,
            RString iryokikancodefto,
            RString cyosaitakusakicodefrom,
            RString cyosaitakusakicodefto) {
        set抽出データ区分(cyusyutsudatakubun);
        set抽出日種類(cyusyutsunichisyurai);
        this.isShinseitorikeshidetacyusyutsu = isShinseitorikeshidetacyusyutsu;
        this.isSakujyodatacyusyutsu = isSakujyodatacyusyutsu;
        if (SoshitsuKubun.資格取得者のみ.getコード().equals(soshitsukubun)) {
            is資格取得者のみ = true;
        } else if (SoshitsuKubun.資格喪失者のみ.getコード().equals(soshitsukubun)) {
            is資格喪失者のみ = true;
        }
        set抽出対象(cyusyutsutaisyo);
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        this.psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.未定義, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBA介護資格));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        psmAtesaki = new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString());
        this.cyusyutsunichifrom = cyusyutsunichifrom;
        this.cyusyutsunichito = cyusyutsunichito;
        this.iryokikancodefrom = iryokikancodefrom;
        this.iryokikancodefto = iryokikancodefto;
        this.cyosaitakusakicodefrom = cyosaitakusakicodefrom;
        this.cyosaitakusakicodefto = cyosaitakusakicodefto;
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

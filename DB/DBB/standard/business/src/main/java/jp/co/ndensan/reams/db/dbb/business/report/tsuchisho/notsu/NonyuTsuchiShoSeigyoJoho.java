/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.GinfuriTsuchishoType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KanendoMongon;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KigotoShutsuryoku;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KigotoTsuchishoType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuSanshutsuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuranHyojiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NokigenShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.OCRShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshuHizukeRan;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshuinranHyojiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshushoHizukeranKiHyoji;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SagakuReishoHakkoShijiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.ShutsuryokuHoshiki;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SokuhoTorikomiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SonotaTsuchishoType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.ToshoShutsuryokuHoho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 納入通知書制御情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NonyuTsuchiShoSeigyoJoho {

    private int 出力部数;
    private SagakuReishoHakkoShijiKubun 差額令書発行指示;
    private NofugakuranHyojiKubun 領収証書納付額欄;
    private NofugakuranHyojiKubun 納付書納付額欄;
    private RyoshuinranHyojiKubun 領収証書領収印欄;
    private RyoshuinranHyojiKubun 納付書領収印欄;
    private OCRShutsuryokuHoho 口座振替のOCR出力方法;
    private RyoshuHizukeRan 領収書領収日付印欄;
    private RyoshuHizukeRan 納付書領収日付欄;
    private Boolean exists中期開始期;
    private int 当初出力_中期開始期;
    private Boolean exists後期開始期;
    private int 当初出力_後期開始期;
    private ToshoShutsuryokuHoho 当初出力_出力方法;
    private NokigenShutsuryokuHoho 納期限出力方法;
    private KigotoTsuchishoType 期毎納入通知書タイプ;
    private GinfuriTsuchishoType 銀振納入通知書タイプ;
    private SonotaTsuchishoType その他納入通知書タイプ;
    private RyoshushoHizukeranKiHyoji 領収書日付印欄の期;
    private HyojiUmu 納付書市町村名表示;
    private RString 納付書市町村名;
    private SokuhoTorikomiKubun 速報取込区分;
    private HyojiUmu コンビニ明細書表示;
    private HyojiUmu ブック口座振替依頼表示;
    private HyojiUmu コンビニバーコード表示;
    private HyojiUmu コンビニ_ブック口座用納付書表示;
    private NofugakuSanshutsuHoho 納付額算出方法;
    private HyojiUmu コンビニ納付書発行日表示;
    private HyojiUmu コンビニ納付書取扱期限表示;
    private ShutsuryokuHoshiki 単票発行_出力方式;
    private ShutsuryokuHoshiki 単票発行_出力形式;
    private KigotoShutsuryoku コンビニ期毎出力;
    private KanendoMongon 過年度文言1;
    private KanendoMongon 過年度文言2;

}
